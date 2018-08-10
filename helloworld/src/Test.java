import edu.xd.ridelab.receiver.TcpServerBootstrap;
import edu.xd.ridelab.receiver.util.PropertiesUtils;

public class Test {
    public static final String VERSION = "2018-7-26";
    private static int port = Integer.parseInt(PropertiesUtils.getProperty("TCPport"));

    public static void main(String[] args){
        try {
            new TcpServerBootstrap().start(port,new DataPacketDecoder(),new DataaPacketHandler());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
