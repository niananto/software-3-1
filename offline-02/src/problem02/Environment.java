package problem02;

public class Environment {
    private Parser parser;
    private Font font;

    public Environment(Parser parser, Font font) {
        this.parser = parser;
        this.font = font;
    }

    void describeEnv() {
        System.out.println("It's a " + parser + " with " + font + " font.");
    }
}
