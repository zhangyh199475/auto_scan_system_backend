package org.pengcheng.auto_scan_system_backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags="Health Api")
public class HealthController {

    @GetMapping("/test")
    @ApiOperation(value="test")
    public ResponseEntity<String> test(String str){
        if (str.equals("123")){
            str = "456";
        } else {
            str = "789";
        }
        return new ResponseEntity(str, HttpStatus.OK);
    }

}