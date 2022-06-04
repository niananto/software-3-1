package problem01.part.commChannel;

class MobileData extends CommChannel {
    // yearly cost
    @Override
    public double getPrice() {
        return 56000;
    }

    @Override
    public String getDescription() {
        return "Mobile Data connection for one year";
    }
}
