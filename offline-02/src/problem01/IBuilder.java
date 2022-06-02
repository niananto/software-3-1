package problem01;

public interface IBuilder {
    IBuilder specifyName(int noOfDisplayUnits);
    IBuilder setCommChannel(String commChannel);
    Product getQMS();
}
