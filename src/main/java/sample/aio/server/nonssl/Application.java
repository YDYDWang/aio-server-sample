package sample.aio.server.nonssl;

import com.github.ydydwang.aio.channel.AioServerBuilder;

import sample.aio.server.channel.DefaultChannelInboundHandler;

public class Application {
	private static final int DEFAULT_THREAD_COUNT = 10;
	private static final int DEFAULT_PORT = 9999;

	public static void main(String[] args) throws Exception {
		new AioServerBuilder().threadCount(DEFAULT_THREAD_COUNT)
				.port(DEFAULT_PORT)
				.addHandler(new DefaultChannelInboundHandler())
				.start();
	}
}

