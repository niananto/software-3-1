package problem01;

public class Deluxe implements IBuilder{
    private final Product product = new Product();

    @Override
    public IBuilder specifyName(int noOfDisplayUnits) {
        for (int i = 0; i < noOfDisplayUnits; i++) {
            product.addPart("LCD panel with Raspberry Pi");
        }
        return this;
    }

    @Override
    public IBuilder setCommChannel(String commChannel) {
        product.addPart(commChannel);
        return this;
    }

    @Override
    public Product getQMS() {
        return this.product;
    }
}
