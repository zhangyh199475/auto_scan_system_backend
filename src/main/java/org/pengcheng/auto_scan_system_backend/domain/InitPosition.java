package org.pengcheng.auto_scan_system_backend.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "init_position", schema = "sba", catalog = "")
@IdClass(InitPositionPK.class)
public class InitPosition {

    private int positionId;
    private int userId;
    private double anglePosition;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double uPosition;
    private double vPosition;
    private double wPosition;
    private LocalDateTime createdTime;
    private String createdBy;

    @Id
    @Column(name = "POSITION_ID")
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "ANGLE_POSITION")
    public double getAnglePosition() {
        return anglePosition;
    }

    public void setAnglePosition(double anglePosition) {
        this.anglePosition = anglePosition;
    }

    @Basic
    @Column(name = "X_POSITION")
    public double getxPosition() {
        return xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    @Basic
    @Column(name = "Y_POSITION")
    public double getyPosition() {
        return yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    @Basic
    @Column(name = "Z_POSITION")
    public double getzPosition() {
        return zPosition;
    }

    public void setzPosition(double zPosition) {
        this.zPosition = zPosition;
    }

    @Basic
    @Column(name = "U_POSITION")
    public double getuPosition() {
        return uPosition;
    }

    public void setuPosition(double uPosition) {
        this.uPosition = uPosition;
    }

    @Basic
    @Column(name = "V_POSITION")
    public double getvPosition() {
        return vPosition;
    }

    public void setvPosition(double vPosition) {
        this.vPosition = vPosition;
    }

    @Basic
    @Column(name = "W_POSITION")
    public double getwPosition() {
        return wPosition;
    }

    public void setwPosition(double wPosition) {
        this.wPosition = wPosition;
    }

    @Basic
    @Column(name = "CREATED_TIME")
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
