package problem01;

import problem01.part.*;
import problem01.part.commChannel.CommChannelFactory;
import problem01.part.commModule.CommModuleFactory;
import problem01.part.controller.ControllerFactory;
import problem01.part.display.DisplayFactory;

public class Poor implements IBuilder {
    private final Product product = new Product();
    private final ControllerFactory controllerFactory = new ControllerFactory();
    private final DisplayFactory displayFactory = new DisplayFactory();
    private final CommChannelFactory commChannelFactory = new CommChannelFactory();
    private final CommModuleFactory commModuleFactory = new CommModuleFactory();

    @Override
    public IBuilder specifyName(int noOfDisplayUnits) throws Exception {
        product.addPart(controllerFactory.getController("atmega"));

        for (int i = 0; i < noOfDisplayUnits; i++) {
            product.addPart(displayFactory.getDisplay("led"));
        }
        return this;
    }

    @Override
    public IBuilder setCommChannel(String commChannel) throws Exception {
        // add both module and channel here
        product.addPart(commModuleFactory.getCommModule(commChannel));
        product.addPart(commChannelFactory.getCommChannel(commChannel));
        return this;
    }

    @Override
    public IBuilder addApplication() {
        product.addPart(new Application());
        return this;
    }

    @Override
    public Product getQMS() {
        return this.product;
    }
}
