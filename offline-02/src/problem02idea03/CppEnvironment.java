package problem02idea03;

public class CppEnvironment extends Environment{
    public CppEnvironment(Font font) {
        parser = new CppParser();
        this.font = font;
    }

    @Override
    public void describeEnvironment() {
        String[] fontNameTokens = this.font.getNameOfFont().split("\\.");
        String fontName = fontNameTokens[fontNameTokens.length-1];
        System.out.println("It's a CPP environment with " + fontName + " font");
    }
}
