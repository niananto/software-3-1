package problem01.part.commChannel;

public class CommChannelFactory {
    public CommChannel getCommChannel(String commType) throws Exception {
        if(commType.toLowerCase().contains("wifi") || commType.toLowerCase().contains("broad")) {
            return new Broadband();
        } else if(commType.toLowerCase().contains("mobile") || commType.toLowerCase().contains("data")) {
            return new MobileData();
        } else {
            throw new Exception("No such Communication Channel");
        }
    }
}
