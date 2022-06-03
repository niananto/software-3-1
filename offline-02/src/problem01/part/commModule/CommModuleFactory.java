package problem01.part.commModule;

public class CommModuleFactory {
    public CommModule getCommModule(String cName) throws Exception {
        if(cName.toLowerCase().contains("sim") || cName.toLowerCase().contains("mobile")) {
            return new SIMCard();
        } else if(cName.toLowerCase().contains("wifi") || cName.toLowerCase().contains("broad")) {
            return new WifiModule();
        } else {
            throw new Exception("No such Communication Module found");
        }
    }
}
