package problem01;

public class Director {
    private IBuilder builder;

    public void construct(IBuilder builder, String commChannel, int noOfDisplayUnits) {
        this.builder = builder.specifyName(noOfDisplayUnits).setCommChannel(commChannel);
    }
}
