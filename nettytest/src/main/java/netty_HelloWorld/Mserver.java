package netty_HelloWorld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by${YangChao}on 2019/6/7
 */


public class Mserver {
    public  static  void  main(String[] args) throws Exception{
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        /**
         * 服务器端定义两个线程组 boss接收来自客服端信息然后转给worker处理
         */

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();//辅助类建立通道
            serverBootstrap.group(boss,worker).channel(NioServerSocketChannel.class)
                    .childHandler(new MyserverInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(9999).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }


    }
}
