package org.pengcheng.auto_scan_system_backend.controller;

import org.pengcheng.auto_scan_system_backend.domain.BRTRobot;
import org.pengcheng.auto_scan_system_backend.service.BRTRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robot")
public class BRTRobotController {

    @Autowired
    private BRTRobotService brtRobotService;

    @GetMapping("/getWorldCoordinate")
    public ResponseEntity<BRTRobot> getWorldCoordinate(){
        BRTRobot brtRobot = brtRobotService.getWorldCoordinate();
        return new ResponseEntity(brtRobot, HttpStatus.OK);
    }
}
