package org.pengcheng.auto_scan_system_backend.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "task_history", schema = "sba", catalog = "")
@IdClass(TaskHistoryPK.class)
public class TaskHistory {
    private int taskId;
    private int userId;
    private String type;
    private String state;
    private String saveFile;
    private String sendEmail;
    private double anglePosition;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private double uPosition;
    private double vPosition;
    private double wPosition;
    private String scanSurface;
    private String sPara;
    private double aMin;
    private double aMax;
    private double aStep;
    private double bMin;
    private double bMax;
    private double bStep;
    private double freqMin;
    private double freqMax;
    private double freqStep;
    private LocalDateTime createdTime;
    private String createdBy;
    private LocalDateTime finishTime;

    @Id
    @Column(name = "TASK_ID")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "SAVE_FILE")
    public String getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(String saveFile) {
        this.saveFile = saveFile;
    }

    @Basic
    @Column(name = "SEND_EMAIL")
    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
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
    @Column(name = "SCAN_SURFACE")
    public String getScanSurface() {
        return scanSurface;
    }

    public void setScanSurface(String scanSurface) {
        this.scanSurface = scanSurface;
    }

    @Basic
    @Column(name = "S_PARA")
    public String getsPara() {
        return sPara;
    }

    public void setsPara(String sPara) {
        this.sPara = sPara;
    }

    @Basic
    @Column(name = "A_MIN")
    public double getaMin() {
        return aMin;
    }

    public void setaMin(double aMin) {
        this.aMin = aMin;
    }

    @Basic
    @Column(name = "A_MAX")
    public double getaMax() {
        return aMax;
    }

    public void setaMax(double aMax) {
        this.aMax = aMax;
    }

    @Basic
    @Column(name = "A_STEP")
    public double getaStep() {
        return aStep;
    }

    public void setaStep(double aStep) {
        this.aStep = aStep;
    }

    @Basic
    @Column(name = "B_MIN")
    public double getbMin() {
        return bMin;
    }

    public void setbMin(double bMin) {
        this.bMin = bMin;
    }

    @Basic
    @Column(name = "B_MAX")
    public double getbMax() {
        return bMax;
    }

    public void setbMax(double bMax) {
        this.bMax = bMax;
    }

    @Basic
    @Column(name = "B_STEP")
    public double getbStep() {
        return bStep;
    }

    public void setbStep(double bStep) {
        this.bStep = bStep;
    }

    @Basic
    @Column(name = "FREQ_MIN")
    public double getFreqMin() {
        return freqMin;
    }

    public void setFreqMin(double freqMin) {
        this.freqMin = freqMin;
    }

    @Basic
    @Column(name = "FREQ_MAX")
    public double getFreqMax() {
        return freqMax;
    }

    public void setFreqMax(double freqMax) {
        this.freqMax = freqMax;
    }

    @Basic
    @Column(name = "FREQ_STEP")
    public double getFreqStep() {
        return freqStep;
    }

    public void setFreqStep(double freqStep) {
        this.freqStep = freqStep;
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

    @Basic
    @Column(name = "FINISH_DATE")
    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskHistory that = (TaskHistory) o;
        return taskId == that.taskId && userId == that.userId && anglePosition == that.anglePosition && xPosition == that.xPosition && yPosition == that.yPosition && zPosition == that.zPosition && uPosition == that.uPosition && vPosition == that.vPosition && wPosition == that.wPosition && aMin == that.aMin && aMax == that.aMax && aStep == that.aStep && bMin == that.bMin && bMax == that.bMax && bStep == that.bStep && freqMin == that.freqMin && freqMax == that.freqMax && freqStep == that.freqStep && Objects.equals(type, that.type) && Objects.equals(state, that.state) && Objects.equals(saveFile, that.saveFile) && Objects.equals(sendEmail, that.sendEmail) && Objects.equals(scanSurface, that.scanSurface) && Objects.equals(sPara, that.sPara) && Objects.equals(createdTime, that.createdTime) && Objects.equals(createdBy, that.createdBy) && Objects.equals(finishTime, that.finishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, userId, type, state, saveFile, sendEmail, anglePosition, xPosition, yPosition, zPosition, uPosition, vPosition, wPosition, scanSurface, sPara, aMin, aMax, aStep, bMin, bMax, bStep, freqMin, freqMax, freqStep, createdTime, createdBy, finishTime);
    }
}
