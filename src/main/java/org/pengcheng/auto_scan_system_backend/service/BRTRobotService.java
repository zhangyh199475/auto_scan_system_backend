package org.pengcheng.auto_scan_system_backend.service;

import org.pengcheng.auto_scan_system_backend.domain.InitPosition;

import java.util.List;

public interface BRTRobotService {

    String getWorldCoordinate();

    String getJointCoordinate();

    String getMoveState();

    String setWorldCoordinate(double[] worldCoordinateArr);

    String setJointCoordinate(double[] jointCoordinateArr);

    void waitMoving();

    public double[] getAllRange(double[] worldCoordinateArr);

    boolean judgeWorldCoordinate(double[] worldCoordinateArr);

    double[] transCoordinateFromJsonToArray(String queryRes);

    double[] handleCoordinate(double[] coordinateArr, double[] movePosition);

    InitPosition getInitPosition(int userId);

    String setInitPosition(int userId);
    
    void finishInit(int userId, double anglePosition);
}
