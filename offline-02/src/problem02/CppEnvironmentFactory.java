package problem02;

public class CppEnvironmentFactory implements EnvironmentFactory{
    @Override
    public Environment getEnvironment() {
        return new Environment(new CppParser(), new Monaco());
    }
}
