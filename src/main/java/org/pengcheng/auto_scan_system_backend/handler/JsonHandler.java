package org.pengcheng.auto_scan_system_backend.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.pengcheng.auto_scan_system_backend.domain.BRTRobot;

public class JsonHandler extends SimpleChannelInboundHandler<byte[]> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) throws Exception {
        // Deserialize the incoming JSON message
        BRTRobot brtRobot = objectMapper.readValue(msg, BRTRobot.class);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Log any exceptions that occur during communication
        cause.printStackTrace();
        ctx.close();
    }

    public void sendCommand(ChannelHandlerContext ctx, BRTRobot brtRobot) throws JsonProcessingException {
        // Serialize the outgoing JSON message
        byte[] msg = objectMapper.writeValueAsBytes(brtRobot);

        // Write the message to the channel
        ctx.writeAndFlush(msg);
    }
}
