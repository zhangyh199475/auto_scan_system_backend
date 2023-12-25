package org.pengcheng.auto_scan_system_backend.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

import static org.pengcheng.auto_scan_system_backend.constant.BRTRobotConstant.*;

@Service
@ClientEndpoint
public class SocketHandler {

    private static final Logger logger = Logger.getLogger(BRTROBOT_LOGGER_HANDLER);

    @Value("${robot.ip}")
    private String robotAddress;

    @Value("${robot.port}")
    private int robotPort;

    private SocketChannel socketChannel;

//    private String queryRes;
//
//    private String queryStr;

    public String sendMsg(String queryStr) {

        logger.info(BRTROBOT_HANDLER_SEND_MSG + queryStr);
        String queryRes = "";

        try {
//            this.queryStr = "";
//            this.queryRes = "";
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(true);
            socketChannel.connect(new InetSocketAddress(robotAddress, robotPort));
//            Thread thread = new Thread(new TransThread(socketChannel, this.queryRes));
//            thread.start();
//            String query = thread.getName();

            ByteBuffer sendByteBuffer = ByteBuffer.wrap(queryStr.getBytes());
            socketChannel.write(sendByteBuffer);
            ByteBuffer recByteBuffer = ByteBuffer.allocate(1024);
            int len = socketChannel.read(recByteBuffer);
            queryRes = new String(recByteBuffer.array(), 0, len);
            logger.info(BRTROBOT_HANDLER_SEND_MSG_RESPONSE + queryRes);
//            Thread.sleep(100);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (socketChannel.isConnected()) {
                    socketChannel.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return queryRes;
    }
//
//    private class TransThread implements Runnable {
//
//        private SocketChannel socketChannel;
//
//        private String queryRes;
//
//        public TransThread(SocketChannel socketChannel, String queryRes) {
//            this.socketChannel = socketChannel;
//            this.queryRes = queryRes;
//        }
//
//        @Override
//        public void run() {
//            try {
//
//                ByteBuffer sendByteBuffer = ByteBuffer.wrap(queryStr.getBytes());
//                socketChannel.write(sendByteBuffer);
//                ByteBuffer recByteBuffer = ByteBuffer.allocate(1024);
//                int len = socketChannel.read(recByteBuffer);
//                this.queryRes = new String(recByteBuffer.array(), 0, len);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    socketChannel.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
