package assignment2.assignment4;

class LightThemeBuilder implements ThemeBuilder {
    private Button button;
    private Checkbox checkbox;

    @Override
    public void buildButton() {
        button = new Button("white", "Light");
    }

    @Override
    public void buildCheckbox() {
        checkbox = new Checkbox("white", "Light");
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
