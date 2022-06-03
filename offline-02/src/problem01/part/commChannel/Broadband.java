package problem01.part.commChannel;

public class Broadband extends CommChannel {
    // yearly cost
    @Override
    public double getPrice() {
        return 49510;
    }

    @Override
    public String getDescription() {
        return "Broadband Connection for one year";
    }
}
