package problem01.part.display;

public class DisplayFactory {
    public Display getDisplay(String dName) throws Exception {
        if(dName.toLowerCase().contains("led")) {
            return new LEDMatrix();
        } else if(dName.toLowerCase().contains("lcd")) {
            return new LCDPanel();
        } else {
            throw new Exception("No such display found");
        }
    }
}
