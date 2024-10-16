package assignment2.assignment4;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        // Light theme
        ThemeBuilder lightBuilder = new LightThemeBuilder();
        director.setBuilder(lightBuilder);
        director.constructTheme();
        Button lightButton = lightBuilder.getButton();
        Checkbox lightCheckbox = lightBuilder.getCheckbox();
        lightButton.display();
        lightCheckbox.display();

        // Dark theme
        ThemeBuilder darkBuilder = new DarkThemeBuilder();
        director.setBuilder(darkBuilder);
        director.constructTheme();
        Button darkButton = darkBuilder.getButton();
        Checkbox darkCheckbox = darkBuilder.getCheckbox();
        darkButton.display();
        darkCheckbox.display();
    }
}
