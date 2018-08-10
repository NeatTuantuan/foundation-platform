import edu.xd.ridelab.receiver.IDataPacketDecoder;
import edu.xd.ridelab.receiver.protocol.MacProtocol;
import edu.xd.ridelab.receiver.util.SocketAddressUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class DataPacketDecoder extends ByteToMessageDecoder implements IDataPacketDecoder {

    @Override
    protected void decode(ChannelHandlerContext context, ByteBuf in, List<Object> out) throws Exception {
        if (isFullReceioved(in)){
            final byte[] bytes = new byte[in.readableBytes()];

            in.readBytes(bytes);

            final String ip = SocketAddressUtils.parseIp(context.channel().remoteAddress());

            final MacProtocol protocol = new MacProtocol(bytes,ip);

            out.add(protocol);
        }
    }

    private boolean isFullReceioved(ByteBuf in){
        return(in.readableBytes() >= 8 && in.readableBytes() >= in.getInt(4)+8);

    }
}
