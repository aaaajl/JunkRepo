/**
 * 
 */
package netty.comet;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.DynamicChannelBuffer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelStateEvent;
import io.netty.channel.ExceptionEvent;
import io.netty.channel.MessageEvent;
import io.netty.channel.SimpleChannelHandler;
import io.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;

/**
 * @author fanghui.jl
 *
 */
public class ChatServer {

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			args = new String[] { "9876", "true" };
		}
		ChannelFactory factory = new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

		ServerBootstrap bootstrap = new ServerBootstrap(factory);

		ChatServerHandler handler = new ChatServerHandler();
		ChannelPipeline pipeline = bootstrap.getPipeline();
		pipeline.addLast("chat", handler);

		bootstrap.setOption("child.tcpNoDelay", true);
		bootstrap.setOption("child.keepAlive", true);
		int port = Integer.valueOf(args[0]);
		bootstrap.bind(new InetSocketAddress(port));

		boolean fillChat = "true".equals(args[1]);
		if (fillChat) {
			ChannelManagerThread cmt = new ChannelManagerThread();
			cmt.start();
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String command = br.readLine();
			if ("dump".equals(command)) {
				System.out.println("当前活着的数量:" + channel.size());
			} else if ("help".equals(command)) {
				System.out.println("命令列表:");
				System.out.println("dump:打印当前情况");
				System.out.println("help:帮助文档");
			}
		}
 
	}

	final static Random random = new Random();
	static int max = 0;

	static class ChannelManagerThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					if (max < channel.size()) {
						max = channel.size();
						System.out.println("live:" + channel.size());
					}

					for (Channel s : channel.values()) {
						if (random.nextInt(100) > 70) {
							ChannelBuffer cb = new DynamicChannelBuffer(256);
							cb.writeBytes("Hey!有人来找你了!".getBytes());
							s.write(cb);
						}
					}
					sleep(500);
				} catch (InterruptedException e) {

				}
			}
		}
	}

	final static Map<Integer, Channel> channel = new HashMap<Integer, Channel>();

	static void log(String message) {
		System.out.println(message);
	}

	//@Sharable
	static class ChatServerHandler extends SimpleChannelHandler {
		@Override
		public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
			Channel ch = e.getChannel();
			ChannelBuffer cb = new DynamicChannelBuffer(256);
			cb.writeBytes("Hell!你来了啊!".getBytes());
			ch.write(cb);
			channel.put(e.getChannel().getId(), e.getChannel());
		}

		@Override
		public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
		}

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
			e.getCause().printStackTrace();
			channel.remove(e.getChannel().getId());
			log("remove channel by exception! id:" + e.getChannel().getId());

			e.getChannel().close();
		}

		@Override
		public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
			channel.remove(e.getChannel().getId());
			log("remove channel by exception! id:" + e.getChannel().getId());

		}
	}
}
