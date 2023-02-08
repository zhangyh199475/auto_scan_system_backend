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
}

class DsData {
    private String camID; // 相机唯一ID
    private List<Data> data; // 点位数据集，每个点位包括位置，颜色，相识度等信息
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
}