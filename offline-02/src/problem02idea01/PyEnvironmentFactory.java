package problem02idea01;

public class PyEnvironmentFactory implements EnvironmentFactory{
    @Override
    public Environment getEnvironment() {
        return new Environment(new PyParser(), new Consolas());
    }
}
