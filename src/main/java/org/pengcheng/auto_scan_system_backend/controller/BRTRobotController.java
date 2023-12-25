/*
 * @Author: Alex Zhang zhangyh_upc@qq.com
 * @Date: 2023-02-23 11:34:41
 * @LastEditors: Alex Zhang zhangyh_upc@qq.com
 * @LastEditTime: 2023-12-22 17:07:02
 * @FilePath: \auto_scan_system_backend\src\main\java\org\pengcheng\auto_scan_system_backend\controller\BRTRobotController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package org.pengcheng.auto_scan_system_backend.controller;

import org.pengcheng.auto_scan_system_backend.domain.InitPosition;
import org.pengcheng.auto_scan_system_backend.handler.SocketHandler;
import org.pengcheng.auto_scan_system_backend.service.BRTRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static org.pengcheng.auto_scan_system_backend.constant.BRTRobotConstant.*;

@RestController
@RequestMapping("/robot")
public class BRTRobotController {

    private static final Logger logger = Logger.getLogger(BRTROBOT_LOGGER_CONTROLLER);

    @Autowired
    private BRTRobotService brtRobotService;

    @Autowired
    private SocketHandler socketHandler;

    @GetMapping("/getWorldCoordinate")
    public ResponseEntity<String> getWorldCoordinate() {

        logger.info(BRTROBOT_CONTROLLER_GET_WORLD_COORDINATE);
        String queryStr = brtRobotService.getWorldCoordinate();
        return new ResponseEntity<>(queryStr, HttpStatus.OK);
    }

    @PostMapping("/setWorldCoordinate")
    public ResponseEntity<String> setWorldCoordinate(@RequestBody double[] movePosition) {

        logger.info(BRTROBOT_CONTROLLER_SET_WORLD_COORDINATE);
        String queryStr = brtRobotService.getWorldCoordinate();
        double[] worldCoordinateArr = brtRobotService.transCoordinateFromJsonToArray(queryStr);
        double[] newWorldCoordinateArr = brtRobotService.handleCoordinate(worldCoordinateArr, movePosition);
        String postStr = brtRobotService.setWorldCoordinate(newWorldCoordinateArr);
        String postRes = socketHandler.sendMsg(postStr);
        return new ResponseEntity<>(postRes, HttpStatus.OK);
    }


    @GetMapping("/getInitPosition/{userId}")
    public ResponseEntity<InitPosition> getInitPosition(@PathVariable int userId) {

        logger.info(BRTROBOT_CONTROLLER_GET_INIT_POSITION);
        InitPosition initPosition = brtRobotService.getInitPosition(userId);
        return new ResponseEntity<>(initPosition, HttpStatus.OK);
    }

    @GetMapping("/reset")
    public ResponseEntity<String> resetRobot() {

        logger.info(BRTROBOT_CONTROLLER_RESET_WORLD_COORDINATE);
        double[] resetJointArr = new double[6];
        resetJointArr[0] = -90.0;
        resetJointArr[1] = -30.0;
        resetJointArr[2] = -30.0;
        resetJointArr[3] = 90.0;
        resetJointArr[4] = 0.0;
        resetJointArr[5] = 0.0;
        String postStr = brtRobotService.setJointCoordinate(resetJointArr);
        String postRes = socketHandler.sendMsg(postStr);
        return new ResponseEntity<>(postRes, HttpStatus.OK);
    }

    @GetMapping("/resetAngle")
    public ResponseEntity<String> resetAngle() {

        logger.info(BRTROBOT_CONTROLLER_RESET_ANGLE);
        String queryStr = brtRobotService.getWorldCoordinate();
        double[] worldCoordinateArr = brtRobotService.transCoordinateFromJsonToArray(queryStr);
        double[] resetWorldArr = new double[6];
        resetWorldArr[0] = worldCoordinateArr[0];
        resetWorldArr[1] = worldCoordinateArr[1];
        resetWorldArr[2] = worldCoordinateArr[2];
        resetWorldArr[3] = 90.0;
        resetWorldArr[4] = 0.0;
        resetWorldArr[5] = 0.0;
        String postStr = brtRobotService.setWorldCoordinate(resetWorldArr);
        String postRes = socketHandler.sendMsg(postStr);
        return new ResponseEntity<>(postRes, HttpStatus.OK);
    }

    @GetMapping("/resetCenter/{userId}")
    public ResponseEntity<InitPosition> resetCenter(@PathVariable int userId) {

        logger.info(BRTROBOT_CONTROLLER_RESET_CENTER);

        InitPosition initPosition = brtRobotService.getInitPosition(userId);
        double[] worldCoordinateArr = new double[6];
        worldCoordinateArr[0] = initPosition.getxPosition();
        worldCoordinateArr[1] = initPosition.getyPosition();
        worldCoordinateArr[2] = initPosition.getzPosition();
        worldCoordinateArr[3] = initPosition.getuPosition();
        worldCoordinateArr[4] = initPosition.getvPosition();
        worldCoordinateArr[5] = initPosition.getwPosition();
        String postStr = brtRobotService.setWorldCoordinate(worldCoordinateArr);
        socketHandler.sendMsg(postStr);

        return new ResponseEntity<>(initPosition, HttpStatus.OK);
    }

    @GetMapping("/finishInit/{userId}/{angle}")
    public ResponseEntity<String> finishInit(@PathVariable int userId, @PathVariable double angle) {

        logger.info(BRTROBOT_CONTROLLER_FINISH_INIT);
        brtRobotService.finishInit(userId, angle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllRange/{worldCoordinateArr}")
    public ResponseEntity<double[]> getAllRange(@PathVariable double[] worldCoordinateArr) {
        logger.info(BRTROBOT_CONTROLLER_GET_ALL_RANGE);
        double[] rangeArr = brtRobotService.getAllRange(worldCoordinateArr);
        return new ResponseEntity<>(rangeArr, HttpStatus.OK);
    }

    @GetMapping("/getMoveState")
    public ResponseEntity<String> getMoveState() {
        logger.info(BRTROBOT_CONTROLLER_GET_MOVE_STATE);
        return new ResponseEntity<>(brtRobotService.getMoveState(), HttpStatus.OK);
    }
}
