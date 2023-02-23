package org.pengcheng.auto_scan_system_backend.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import org.pengcheng.auto_scan_system_backend.domain.BRTRobot;
import org.springframework.stereotype.Service;

@Service
public class BRTRobotHandler extends SimpleChannelInboundHandler<byte[]> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) throws Exception {
        // Deserialize the incoming JSON message
        BRTRobot brtRobot = objectMapper.readValue(msg, BRTRobot.class);
        System.out.println("服务器收到消息: " + brtRobot.getCmdReply());
        ReferenceCountUtil.retain(brtRobot);
        ctx.fireChannelRead(brtRobot);
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
        System.out.println("服务器发送消息: " + brtRobot.getDsID());
        // Write the message to the channel
        ctx.writeAndFlush(msg);
    }
}
