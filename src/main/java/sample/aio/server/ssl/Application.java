package sample.aio.server.ssl;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

import com.github.ydydwang.aio.channel.AioServerBuilder;

import sample.aio.server.channel.DefaultChannelInboundHandler;

// keytool -genkey -keystore keystore.jks -keyalg RSA -storepass password -keypass password
public class Application {
	private static final int DEFAULT_THREAD_COUNT = 10;
	private static final int DEFAULT_PORT = 9999;

	public static void main(String[] args) throws Exception {
		char[] password = "password".toCharArray();
		KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(new FileInputStream(new File(Application.class.getClassLoader().getResource("keystore.jks").getFile())), password);
		SSLContext sslContext = SSLContext.getInstance("TLS");
		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
		keyManagerFactory.init(keystore, password);
		sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
		new AioServerBuilder().threadCount(DEFAULT_THREAD_COUNT)
				.withSSLContext(sslContext)
				.port(DEFAULT_PORT)
				.addHandler(new DefaultChannelInboundHandler())
				.start();
	}
}

