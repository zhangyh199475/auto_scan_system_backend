package org.pengcheng.auto_scan_system_backend.handler;

public class StartClientThread implements Runnable{
    @Override
    public void run() {
        try {
            BRTRobotHandler brtRobotHandler = new BRTRobotHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
