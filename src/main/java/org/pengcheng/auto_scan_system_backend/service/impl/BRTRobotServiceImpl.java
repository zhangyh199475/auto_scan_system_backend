package org.pengcheng.auto_scan_system_backend.service.impl;

import org.pengcheng.auto_scan_system_backend.constant.BRTRobotConstant;
import org.pengcheng.auto_scan_system_backend.domain.BRTRobot;
import org.pengcheng.auto_scan_system_backend.service.BRTRobotService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BRTRobotServiceImpl implements BRTRobotService {
    @Override
    public BRTRobot getWorldCoordinate() {
        BRTRobot brtRobot = new BRTRobot();
        brtRobot.setDsID(BRTRobotConstant.DSID_REMOTE_MONITOR);
        brtRobot.setReqType(BRTRobotConstant.REQ_TYPE_QUERY);
        brtRobot.setPackID("0");
        List<String> queryAddrList = new ArrayList<>();
        queryAddrList.add(BRTRobotConstant.QUERY_ADDR_WORLD0);
        queryAddrList.add(BRTRobotConstant.QUERY_ADDR_WORLD1);
        queryAddrList.add(BRTRobotConstant.QUERY_ADDR_WORLD2);
        queryAddrList.add(BRTRobotConstant.QUERY_ADDR_WORLD3);
        queryAddrList.add(BRTRobotConstant.QUERY_ADDR_WORLD4);
        queryAddrList.add(BRTRobotConstant.QUERY_ADDR_WORLD5);
        brtRobot.setQueryAddr(queryAddrList);
        return brtRobot;
    }

    @Override
    public BRTRobot getJointCoordinate() {
        return null;
    }

    @Override
    public BRTRobot getMoveState() {
        return null;
    }

    @Override
    public BRTRobot setWorldCoordinate(BRTRobot brtRobot) {
        return null;
    }

    @Override
    public BRTRobot setJointCoordinate(BRTRobot brtRobot) {
        return null;
    }

    @Override
    public void waitMoving() {

    }

    @Override
    public boolean judgeWorldCoordinate(BRTRobot brtRobot) {
        return false;
    }
}
