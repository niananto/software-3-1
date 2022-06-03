package problem01;

public interface IBuilder {
    IBuilder specifyName(int noOfDisplayUnits) throws Exception;
    IBuilder setCommChannel(String commChannel) throws Exception;
    IBuilder addApplication();
    Product getQMS();
}
