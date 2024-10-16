package assignment2.assignment4;

class Button {
    private String color;
    private String text;

    public Button(String color, String text) {
        this.color = color;
        this.text = text;
    }

    public void display() {
        System.out.println(text + " Button with color: " + color);
    }
}
