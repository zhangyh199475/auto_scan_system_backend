package org.pengcheng.auto_scan_system_backend.repository;

import org.pengcheng.auto_scan_system_backend.domain.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Integer> {
    @Query(value = "SELECT * from task_history where USER_ID = ?1", nativeQuery = true)
    List<TaskHistory> findTaskHistoryByUserId(int userId);
}
