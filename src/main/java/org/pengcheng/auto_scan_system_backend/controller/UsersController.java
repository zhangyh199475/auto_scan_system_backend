package org.pengcheng.auto_scan_system_backend.controller;

import org.pengcheng.auto_scan_system_backend.domain.Users;
import org.pengcheng.auto_scan_system_backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/login/{userName}")
    public ResponseEntity<Users> login(@PathVariable String userName){
        Users users = this.usersService.login(userName);
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping("/getUserByUserId/{userId}")
    public ResponseEntity<Users> getUserByUserId(@PathVariable int userId){
        Users users = this.usersService.getUserByUserId(userId);
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping("/getUsersList")
    public ResponseEntity<Users> getUsersList(Users users){
        List<Users> usersList = this.usersService.getUsersList(users);
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

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Users> deleteUser(@PathVariable int userId){
        Users users = this.usersService.deleteUser(userId);
        return new ResponseEntity(users, HttpStatus.OK);
    }

}
