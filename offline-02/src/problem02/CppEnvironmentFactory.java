package problem02;

public class CppEnvironmentFactory implements EnvironmentFactory{
    @Override
    public Parser getParser() {
        return new CppParser();
    }

    @Override
    public Font getFont() {
        return new Monaco();
    }
}
