package problem02idea01;

public class CEnvironmentFactory implements EnvironmentFactory{
    @Override
    public Parser getParser() {
        return new CParser();
    }

    @Override
    public Font getFont() {
        return new CourierNew();
    }
}