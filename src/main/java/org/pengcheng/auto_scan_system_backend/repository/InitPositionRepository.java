package org.pengcheng.auto_scan_system_backend.repository;

import org.pengcheng.auto_scan_system_backend.domain.InitPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InitPositionRepository extends JpaRepository<InitPosition, Integer> {

    @Query(value = "SELECT * from init_position where USER_ID = ?1", nativeQuery = true)
    InitPosition findInitPositionByUserId(int userId);

    @Modifying
    @Query(value = "INSERT INTO init_position (USER_ID) VALUES (?1) ON DUPLICATE KEY UPDATE ANGLE_POSITION =?2, X_POSITION=?3, Y_POSITION =?4" +
            ", Z_POSITION=?5, U_POSITION = ?6, V_POSITION=?7, W_POSITION=?8, CREATED_TIME=NOW(), CREATED_BY=?1", nativeQuery = true)
    void upsertInitPositionByUserId(int userId, double anglePosition, double xPosition, double yPosition,
                                            double zPosition, double uPosition, double vPosition, double wPosition);
}
