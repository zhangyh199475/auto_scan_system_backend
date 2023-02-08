package org.pengcheng.auto_scan_system_backend.service.impl;

import org.pengcheng.auto_scan_system_backend.domain.Users;
import org.pengcheng.auto_scan_system_backend.repository.UsersRepository;
import org.pengcheng.auto_scan_system_backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users getUserByUserId(int userId) {
        Users users = this.usersRepository.findById(userId).orElse(null);
        return users;
    }

    @Override
    public List<Users> getUsersList(Users users) {
        return this.usersRepository.findAll();
    }

    @Override
    public Users addUser(Users users) {
        this.usersRepository.save(users);
        return users;
    }

    @Override
    public Users updateUser(Users users) {
        Users newUsers = this.usersRepository.findById(users.getUserId()).orElse(null);
        newUsers.setUserName(users.getUserName());
        newUsers.setPassword(users.getPassword());
        newUsers.setEmail(users.getEmail());
        this.usersRepository.save(newUsers);
        return newUsers;
    }

    @Override
    public Users deleteUser(int userId) {
        Users users = this.usersRepository.findById(userId).orElse(null);
        users.setActive(0);
        this.usersRepository.save(users);
        return users;
    }

    @Override
    public Users login(String userName) {
        Users users = this.usersRepository.findUsersByUserName(userName);
        return users;
    }
}
