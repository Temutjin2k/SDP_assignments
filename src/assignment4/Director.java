package assignment4;

// Created a Director class to construct products
class Director {
    private ThemeBuilder builder;

    public void setBuilder(ThemeBuilder builder) {
        this.builder = builder;
    }

    public void constructTheme() {
        builder.buildButton();
        builder.buildCheckbox();
    }
}
