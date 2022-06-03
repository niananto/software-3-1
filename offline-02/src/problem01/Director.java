package problem01;

public class Director {

    public void construct(IBuilder builder, String commChannel, int noOfDisplayUnits) {
        try {
            builder.specifyName(noOfDisplayUnits).addApplication().setCommChannel(commChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
