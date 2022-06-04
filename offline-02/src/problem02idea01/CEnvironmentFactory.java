package problem02idea01;

public class CEnvironmentFactory implements EnvironmentFactory{
    @Override
    public Environment getEnvironment() {
        return new Environment(new CParser(), new CourierNew());
    }
}
