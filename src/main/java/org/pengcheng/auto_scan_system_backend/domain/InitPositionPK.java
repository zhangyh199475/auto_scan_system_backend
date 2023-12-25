package org.pengcheng.auto_scan_system_backend.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class InitPositionPK implements Serializable {

    private int positionId;
    private int userId;

    @Column(name = "POSITION_ID")
    @Id
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
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
        InitPositionPK that = (InitPositionPK) o;
        return positionId == that.positionId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionId, userId);
    }
}
