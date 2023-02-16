package org.pengcheng.auto_scan_system_backend.service;

import org.pengcheng.auto_scan_system_backend.domain.BRTRobot;

public interface BRTRobotService {

    BRTRobot getWorldCoordinate();
    BRTRobot getJointCoordinate();
    BRTRobot getMoveState();
    BRTRobot setWorldCoordinate(BRTRobot brtRobot);
    BRTRobot setJointCoordinate(BRTRobot brtRobot);
    void waitMoving();
    boolean judgeWorldCoordinate(BRTRobot brtRobot);
}
