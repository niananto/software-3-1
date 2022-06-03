package problem01;

public class FactoryForBuilders {
    Director director = new Director();
    Product product;

    public Product getBuild(String buildType, String commChannel, int noOfDisplayUnits) throws Exception {

        if (buildType.toLowerCase().contains("deluxe")) {
            IBuilder deluxeBuilder = new Deluxe();
            director.construct(deluxeBuilder, commChannel, noOfDisplayUnits);
            product = deluxeBuilder.getQMS();
        } else if (buildType.toLowerCase().contains("optimal")) {
            IBuilder optimalBuilder = new Optimal();
            director.construct(optimalBuilder, commChannel, noOfDisplayUnits);
            product = optimalBuilder.getQMS();
        } else if (buildType.toLowerCase().contains("poor")) {
            IBuilder poorBuilder = new Poor();
            director.construct(poorBuilder, commChannel, noOfDisplayUnits);
            product = poorBuilder.getQMS();
        } else {
            throw new Exception("Doesn't match any build type");
        }

        return this.product;
    }
}
