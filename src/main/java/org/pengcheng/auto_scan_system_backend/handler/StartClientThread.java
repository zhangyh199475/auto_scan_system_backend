package org.pengcheng.auto_scan_system_backend.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.pengcheng.auto_scan_system_backend.domain.BRTRobot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StartClientThread implements Runnable {

    @Value("robot.ip")
    private String robotAddress;

    @Value("robot.port")
    private int robotPort;

    private BRTRobotHandler brtRobotHandler;

    private ChannelHandlerContext channelHandlerContext;

    Logger log = LoggerFactory.getLogger(StartClientThread.class);

    @Override
    public void run() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(
                                new StringEncoder(CharsetUtil.US_ASCII),
                                new StringDecoder(CharsetUtil.US_ASCII),
                                new BRTRobotHandler());
                    }
                });

        ChannelFuture channelFuture;
        try {
            channelFuture = bootstrap.connect(robotAddress, robotPort).sync();
            channelFuture.addListener((ChannelFutureListener) channelFuture1 -> {
                if (channelFuture1.isSuccess()) {
                    log.info("Successfully connect to remote server, remote peer = " + robotAddress + ":" + robotPort);
                } else {
                    log.error("Can not connect to remote server, remote peer = " + robotAddress + ":" + robotPort);
                }
            });
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public BRTRobot connectBRTRobot(BRTRobot brtRobot) throws JsonProcessingException {
        this.run();
        brtRobotHandler.sendCommand(channelHandlerContext, brtRobot);
        return null;
    }
}
