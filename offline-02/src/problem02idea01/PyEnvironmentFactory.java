package problem02idea01;

public class PyEnvironmentFactory implements EnvironmentFactory{
    @Override
    public Parser getParser() {
        return new PyParser();
    }

    @Override
    public Font getFont() {
        return new Consolas();
    }
}
