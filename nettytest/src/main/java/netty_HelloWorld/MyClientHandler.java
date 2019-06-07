package netty_HelloWorld;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

/**
 * Created by${YangChao}on 2019/6/7
 */


public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(channelHandlerContext.channel().remoteAddress()  +" news server to client" +s);//
        channelHandlerContext.writeAndFlush(" client to server " + UUID.randomUUID());

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("来自客户端开启消息大门");
    }//只有重写这个类客户端才会开始想服务器端发送消息

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }//抛出异常 必须重载
}
