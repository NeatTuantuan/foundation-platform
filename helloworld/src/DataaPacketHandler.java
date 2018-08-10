import edu.xd.ridelab.receiver.IDataPacketHandler;
import edu.xd.ridelab.receiver.protocol.MacProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DataaPacketHandler extends SimpleChannelInboundHandler<MacProtocol> implements IDataPacketHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MacProtocol macProtocol) throws Exception {
        System.out.println("服务端接收消息 ："+macProtocol.toString());
    }

}
