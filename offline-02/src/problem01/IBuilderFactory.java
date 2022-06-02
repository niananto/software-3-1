package problem01;

public interface IBuilderFactory {
    Product getBuild(String buildType, String commChannel, int noOfDisplayUnits) throws Exception;
}
