package org.pengcheng.auto_scan_system_backend.controller;

import org.pengcheng.auto_scan_system_backend.config.JwtConfig;
import org.pengcheng.auto_scan_system_backend.domain.Users;
import org.pengcheng.auto_scan_system_backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Resource
    private JwtConfig jwtConfig;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Users users){
        Users usersRes = this.usersService.login(users.getUserName(), users.getPassword());
        String token = "";
        if (!StringUtils.isEmpty(usersRes.getUserId())) {
            token = jwtConfig.createToken(String.valueOf(usersRes.getUserId()));
        }
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("token", token);
        userMap.put("user", usersRes);
        return new ResponseEntity(userMap, HttpStatus.OK);
    }

    @GetMapping("/getUserByUserId/{userId}")
    public ResponseEntity<Users> getUserByUserId(@PathVariable int userId){
        Users users = this.usersService.getUserByUserId(userId);
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping("/getUserList")
    public ResponseEntity<Users> getUsersList(){
        List<Users> usersList = this.usersService.getUsersList();
        return new ResponseEntity(usersList, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<Users> addUser(@RequestBody Users users){
        Users usersNew = this.usersService.addUser(users);
        return new ResponseEntity(usersNew, HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<Users> updateUser(@RequestBody Users users){
        Users usersNew = this.usersService.updateUser(users);
        return new ResponseEntity(usersNew, HttpStatus.OK);
    }

    @PutMapping("/deleteUser/{userId}")
    public ResponseEntity<Users> deleteUser(@PathVariable int userId){
        Users users = this.usersService.deleteUser(userId);
        return new ResponseEntity(users, HttpStatus.OK);
    }

}
