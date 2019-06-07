package netty_HelloWorld;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import sun.applet.resources.MsgAppletViewer;

import java.util.Date;

/**
 * Created by${YangChao}on 2019/6/7
 */


public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    protected void messageReceived(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(channelHandlerContext.channel().remoteAddress()  +" news client to server" +s);//
        channelHandlerContext.writeAndFlush(" server to client" + new  Date());
    }

    /**
     *字符串s是client发给server的信息
     *channelHandlerContext.writeAndFlush（）获取通道然后发消息给client
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
