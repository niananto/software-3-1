package problem01.part.commModule;

class WifiModule extends CommModule{
    @Override
    public double getPrice() {
        return 3700;
    }

    @Override
    public String getDescription() {
        return "Wifi Module for Broadband Connection";
    }
}
