package org.pengcheng.auto_scan_system_backend.config;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.pengcheng.auto_scan_system_backend.handler.JsonHandler;

public class RobotInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(
                new StringEncoder(CharsetUtil.US_ASCII),
                new StringDecoder(CharsetUtil.US_ASCII),
                new JsonHandler());
    }
}
