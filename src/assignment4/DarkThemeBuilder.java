package assignment4;

class DarkThemeBuilder implements ThemeBuilder {
    private Button button;
    private Checkbox checkbox;

    @Override
    public void buildButton() {
        button = new Button("black", "Dark");
    }

    @Override
    public void buildCheckbox() {
        checkbox = new Checkbox("black", "Dark");
    }

    @Override
    public Button getButton() {
        return button;
    }

    @Override
    public Checkbox getCheckbox() {
        return checkbox;
    }
}
