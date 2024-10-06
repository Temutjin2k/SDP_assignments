package assignment4;

class Checkbox {
    private String color;
    private String text;

    public Checkbox(String color, String text) {
        this.color = color;
        this.text = text;
    }

    public void display() {
        System.out.println(text + " Checkbox with color: " + color);
    }
}
