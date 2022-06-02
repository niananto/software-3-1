package problem01;

public class ConcreteBuilderFactory implements IBuilderFactory {
    Director director = new Director();
    Product product;

    @Override
    public Product getBuild(String buildType, String commChannel, int noOfDisplayUnits) throws Exception {

        if (buildType.equalsIgnoreCase("deluxe")) {
            IBuilder deluxeBuilder = new Deluxe();
            director.construct(deluxeBuilder, commChannel, noOfDisplayUnits);
            product = deluxeBuilder.getQMS();
        } else if (buildType.equalsIgnoreCase("optimal")) {
            IBuilder optimalBuilder = new Optimal();
            director.construct(optimalBuilder, commChannel, noOfDisplayUnits);
            product = optimalBuilder.getQMS();
        } else if (buildType.equalsIgnoreCase("poor")) {
            IBuilder poorBuilder = new Poor();
            director.construct(poorBuilder, commChannel, noOfDisplayUnits);
            product = poorBuilder.getQMS();
        } else {
            throw new Exception("don't match any build type");
        }

        return this.product;
    }
}
