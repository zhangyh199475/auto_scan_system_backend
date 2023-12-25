package org.pengcheng.auto_scan_system_backend.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TaskHistoryPK implements Serializable {
    private int taskId;
    private int userId;

    @Column(name = "TASK_ID")
    @Id
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Column(name = "USER_ID")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskHistoryPK that = (TaskHistoryPK) o;
        return taskId == that.taskId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, userId);
    }
}
