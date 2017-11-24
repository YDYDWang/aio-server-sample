package sample.aio.server.channel;

import java.nio.ByteBuffer;

import com.github.ydydwang.aio.channel.ChannelContext;
import com.github.ydydwang.aio.channel.ChannelInboundHandler;
import com.github.ydydwang.aio.util.ByteBufferUtils;

public class DefaultChannelInboundHandler implements ChannelInboundHandler<ByteBuffer, ByteBuffer> {

	@Override
	public void channelActive(ChannelContext channelContext) throws Exception {
		System.out.println("channelActive" + channelContext.getRemoteAddress());
	}

	@Override
	public void channelInactive(ChannelContext channelContext) throws Exception {
		System.out.println("channelInactive" + channelContext.getRemoteAddress());
	}

	@Override
	public ByteBuffer channelRead(ChannelContext channelContext, ByteBuffer buffer) throws Exception {
		System.out.println("channelRead" + ByteBufferUtils.toString(buffer));
		System.out.println("channelRead" + channelContext.getRemoteAddress());
		return buffer;
	}

	@Override
	public void readFailed(ChannelContext channelContext, Throwable cause) throws Exception {
		System.out.println("readFailed");
	}

	@Override
	public void acceptFailed(Throwable cause) throws Exception {
		System.out.println("acceptFailed");
	}

}
