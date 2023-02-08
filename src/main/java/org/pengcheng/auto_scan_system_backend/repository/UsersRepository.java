package org.pengcheng.auto_scan_system_backend.repository;

import org.pengcheng.auto_scan_system_backend.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query(value = "SELECT * from USERS where USER_NAME = ?1", nativeQuery = true)
    Users findUsersByUserName(String userName);
}
