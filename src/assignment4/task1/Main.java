package assignment4.task1;

import java.util.*;

// Expression Interface
interface Expression {
    int interpret();
}

//Expression to handle numbers
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}


// Operation Expression to handle (+, -, *, /) kinda expressions
class OperationExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;
    private String operator;

    public OperationExpression(Expression leftExpression, Expression rightExpression, String operator) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public int interpret() {
        switch (operator) {
            case "+":
                return leftExpression.interpret() + rightExpression.interpret();
            case "-":
                return leftExpression.interpret() - rightExpression.interpret();
            case "*":
                return leftExpression.interpret() * rightExpression.interpret();
            case "/":
                if (rightExpression.interpret() == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return leftExpression.interpret() / rightExpression.interpret();
            default:
                throw new UnsupportedOperationException("Unsupported operation: " + operator);
        }
    }

}

// Interpreter to parse and evaluate expressions
class Interpreter {
    public static Expression parseExpression(String input) {
        String[] tokens = input.split(" ");

        // First pass: Handle multiplication and division
        List<String> firstPassTokens = new ArrayList<>();
        Expression currentExpression = new NumberExpression(Integer.parseInt(tokens[0]));

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            Expression right = new NumberExpression(Integer.parseInt(tokens[i + 1]));

            if (operator.equals("*") || operator.equals("/")) {
                currentExpression = new OperationExpression(currentExpression, right, operator);
            } else {
                firstPassTokens.add(Integer.toString(currentExpression.interpret()));
                firstPassTokens.add(operator);
                currentExpression = right;
            }
        }
        firstPassTokens.add(Integer.toString(currentExpression.interpret()));

        // Second pass: Handle addition and subtraction
        currentExpression = new NumberExpression(Integer.parseInt(firstPassTokens.get(0)));
        for (int i = 1; i < firstPassTokens.size(); i += 2) {
            String operator = firstPassTokens.get(i);
            Expression right = new NumberExpression(Integer.parseInt(firstPassTokens.get(i + 1)));
            currentExpression = new OperationExpression(currentExpression, right, operator);
        }

        return currentExpression;
    }

    public static void main(String[] args) {
        System.out.println("Enter expression in format (number expression number...)");
        System.out.println("Example: 6 + 3 * 2 - 4 / 2");
        System.out.println("Enter 'exit' to exit the program");
        while(true){
            Scanner scan = new Scanner(System.in);

            System.out.print("Input: ");
            String input = scan.nextLine();

            if (Objects.equals(input, "exit")){
                break;
            }

            Expression expression = parseExpression(input);
            System.out.println("Result: " + expression.interpret());  // Output: 10
        }
        System.out.println("Program ended");
    }
}
