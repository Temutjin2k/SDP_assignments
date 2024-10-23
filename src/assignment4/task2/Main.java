package assignment4.task2;

import java.util.Scanner;
import java.util.Stack;

// Memento class to store text state
class Memento {
    private String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// TextEditor class that allows typing, saving, and undoing
class TextEditor {
    private StringBuilder currentText = new StringBuilder();

    public void type(String text) {
        currentText.append(text);
    }

    public String getText() {
        return currentText.toString();
    }

    public Memento save() {
        return new Memento(currentText.toString());
    }

    public void restore(Memento memento) {
        currentText = new StringBuilder(memento.getText());
        System.out.println("restor: " + currentText);
    }
}

// CareTaker class to manage Memento objects and undo operation
class CareTaker {
    private Stack<Memento> history = new Stack<>();

    public void save(TextEditor editor) {
        if (history.isEmpty() || !history.peek().getText().equals(editor.getText())) {
            history.push(editor.save());
            System.out.println("Text saved.");
        } else {
            System.out.println("No changes detected, not saving the same state.");
        }
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            history.pop();

            Memento prevMemento = new Memento("");
            if (!history.isEmpty()){
                prevMemento = history.peek();
            }
            editor.restore(prevMemento);

            System.out.println("Undo performed.");
        } else {
            System.out.println("No states to undo.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        CareTaker careTaker = new CareTaker();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\nCurrent text: " + editor.getText());
            System.out.println("Options: [1] Type, [2] Save, [3] Undo, [4] Exit");
            System.out.print("Choose an option: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Type your text: ");
                    String text = scanner.nextLine();
                    editor.type(text);
                    break;

                case "2":
                    careTaker.save(editor);
                    break;

                case "3":
                    careTaker.undo(editor);
                    break;

                case "4":
                    System.out.println("Exiting the text editor.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
