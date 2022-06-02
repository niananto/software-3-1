package problem02idea03;

public class CEnvironment extends Environment{
    public CEnvironment(Font font) {
        parser = new CParser();
        this.font = font;
    }

    @Override
    public void describeEnvironment() {
        String[] fontNameTokens = this.font.getNameOfFont().split("\\.");
        String fontName = fontNameTokens[fontNameTokens.length-1];
        System.out.println("It's a C environment with " + fontName + " font");
    }
}
