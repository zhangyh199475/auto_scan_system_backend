package org.pengcheng.auto_scan_system_backend.service;

import org.pengcheng.auto_scan_system_backend.domain.Users;

import java.util.List;

public interface UsersService {
    Users getUserByUserId(int userId);
    List<Users> getUsersList(Users users);
    Users addUser(Users users);
    Users updateUser(Users users);
    Users deleteUser(int userId);
    Users login(String userName);
}
