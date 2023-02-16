package org.pengcheng.auto_scan_system_backend.domain;

import java.util.List;

public class BRTRobot {
    private String dsID; // 唯一标识
    private String reqType; // 命令类型
    private String camID; // 相机唯一ID
    private String ret;
    private String packID; // 数据包地址
    private List<String> queryAddr;
    private List<String> cmdData;
    private List<String> cmdReply;
    private String emptyList;
    private List<Instructions> instructions;
    private List<DsData> dsData;

    public String getDsID() {
        return dsID;
    }

    public void setDsID(String dsID) {
        this.dsID = dsID;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getCamID() {
        return camID;
    }

    public void setCamID(String camID) {
        this.camID = camID;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getPackID() {
        return packID;
    }

    public void setPackID(String packID) {
        this.packID = packID;
    }

    public List<String> getQueryAddr() {
        return queryAddr;
    }

    public void setQueryAddr(List<String> queryAddr) {
        this.queryAddr = queryAddr;
    }

    public List<String> getCmdData() {
        return cmdData;
    }

    public void setCmdData(List<String> cmdData) {
        this.cmdData = cmdData;
    }

    public List<String> getCmdReply() {
        return cmdReply;
    }

    public void setCmdReply(List<String> cmdReply) {
        this.cmdReply = cmdReply;
    }

    public String getEmptyList() {
        return emptyList;
    }

    public void setEmptyList(String emptyList) {
        this.emptyList = emptyList;
    }

    public List<Instructions> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instructions> instructions) {
        this.instructions = instructions;
    }

    public List<DsData> getDsData() {
        return dsData;
    }

    public void setDsData(List<DsData> dsData) {
        this.dsData = dsData;
    }
}

class Instructions {
    private String oneshot;
    private String action;
    private String cnt_id;
    private String m0;
    private String m1;
    private String m2;
    private String m3;
    private String m4;
    private String m5;
    private String m6;
    private String m7;
    private String ckStatus;
    private String speed;
    private String delay;
    private String smooth;
    private String type;
    private String io_status;
    private String point;
    private String limit;
    private String isUnlimit;
    private String isUse;
    private String ioNumber;

    public String getOneshot() {
        return oneshot;
    }

    public void setOneshot(String oneshot) {
        this.oneshot = oneshot;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCnt_id() {
        return cnt_id;
    }

    public void setCnt_id(String cnt_id) {
        this.cnt_id = cnt_id;
    }

    public String getM0() {
        return m0;
    }

    public void setM0(String m0) {
        this.m0 = m0;
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getM3() {
        return m3;
    }

    public void setM3(String m3) {
        this.m3 = m3;
    }

    public String getM4() {
        return m4;
    }

    public void setM4(String m4) {
        this.m4 = m4;
    }

    public String getM5() {
        return m5;
    }

    public void setM5(String m5) {
        this.m5 = m5;
    }

    public String getM6() {
        return m6;
    }

    public void setM6(String m6) {
        this.m6 = m6;
    }

    public String getM7() {
        return m7;
    }

    public void setM7(String m7) {
        this.m7 = m7;
    }

    public String getCkStatus() {
        return ckStatus;
    }

    public void setCkStatus(String ckStatus) {
        this.ckStatus = ckStatus;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getSmooth() {
        return smooth;
    }

    public void setSmooth(String smooth) {
        this.smooth = smooth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIo_status() {
        return io_status;
    }

    public void setIo_status(String io_status) {
        this.io_status = io_status;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getIsUnlimit() {
        return isUnlimit;
    }

    public void setIsUnlimit(String isUnlimit) {
        this.isUnlimit = isUnlimit;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }

    public String getIoNumber() {
        return ioNumber;
    }

    public void setIoNumber(String ioNumber) {
        this.ioNumber = ioNumber;
    }
}

class DsData {
    private String camID; // 相机唯一ID
    private List<Data> data; // 点位数据集，每个点位包括位置，颜色，相识度等信息

    public String getCamID() {
        return camID;
    }

    public void setCamID(String camID) {
        this.camID = camID;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}

class Data {
    private String ModelID; // 模板ID，用于区分点位是用于哪个视觉模板
    private String X; // 机器人与相机标定后的世界坐标X
    private String Y; // 机器人与相机标定后的世界坐标Y
    private String Z; // 机器人与相机标定后的世界坐标Z
    private String U; // 机器人与相机标定后的世界坐标Z, 四关节机器人没有
    private String V; // 机器人与相机标定后的世界坐标V, 四关节机器人没有
    private String Angel; // 机器人与相机标定后的世界坐标W，对于四关节机器人是U
    private String Similarity; // 相似度，范围待定
    private String Color; // 颜色，范围待定
    private String Rel; // 是否为相对移动，1为相对

    public String getModelID() {
        return ModelID;
    }

    public void setModelID(String modelID) {
        ModelID = modelID;
    }

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }

    public String getZ() {
        return Z;
    }

    public void setZ(String z) {
        Z = z;
    }

    public String getU() {
        return U;
    }

    public void setU(String u) {
        U = u;
    }

    public String getV() {
        return V;
    }

    public void setV(String v) {
        V = v;
    }

    public String getAngel() {
        return Angel;
    }

    public void setAngel(String angel) {
        Angel = angel;
    }

    public String getSimilarity() {
        return Similarity;
    }

    public void setSimilarity(String similarity) {
        Similarity = similarity;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getRel() {
        return Rel;
    }

    public void setRel(String rel) {
        Rel = rel;
    }
}