package problem02idea03;

public class PyEnvironment extends Environment{
    public PyEnvironment(Font font) {
        parser = new PyParser();
        this.font = font;
    }

    @Override
    public void describeEnvironment() {
        String[] fontNameTokens = this.font.getNameOfFont().split("\\.");
        String fontName = fontNameTokens[fontNameTokens.length-1];
        System.out.println("It's a Python environment with " + fontName + " font");
    }
}
