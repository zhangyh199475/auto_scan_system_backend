package org.pengcheng.auto_scan_system_backend.handler;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.pengcheng.auto_scan_system_backend.config.RobotInitializer;
import org.springframework.beans.factory.annotation.Value;

public class BRTRobotHandler {

    private Channel channel;

    @Value("robot.ip")
    private String robotAddress;

    @Value("robot.port")
    private int robotPort;

    public BRTRobotHandler() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new RobotInitializer());
            channel = bootstrap.connect(robotAddress, robotPort).sync().channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
