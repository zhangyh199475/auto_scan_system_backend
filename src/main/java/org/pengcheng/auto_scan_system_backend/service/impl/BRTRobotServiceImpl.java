package org.pengcheng.auto_scan_system_backend.service.impl;

import org.pengcheng.auto_scan_system_backend.domain.EulerAngles;
import org.pengcheng.auto_scan_system_backend.domain.InitPosition;
import org.pengcheng.auto_scan_system_backend.domain.Quaternion;
import org.pengcheng.auto_scan_system_backend.handler.SocketHandler;
import org.pengcheng.auto_scan_system_backend.repository.InitPositionRepository;
import org.pengcheng.auto_scan_system_backend.service.BRTRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

import static org.pengcheng.auto_scan_system_backend.constant.BRTRobotConstant.*;

@Service
@Transactional
public class BRTRobotServiceImpl implements BRTRobotService {

    @Value("${robot.dh.d.j6}")
    private double dhDJ6;

    @Autowired
    private SocketHandler socketHandler;

    @Autowired
    private InitPositionRepository initPositionRepository;

    private static final Logger logger = Logger.getLogger(BRTROBOT_LOGGER_SERVICE);

    @Override
    public String getWorldCoordinate() {

        logger.info(BRTROBOT_SERVICE_GET_WORLD_COORDINATE);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(DSID, DSID_REMOTE_MONITOR);
            jsonObject.put(REQ_TYPE, REQ_TYPE_QUERY);
            jsonObject.put(PACK_ID, PACK_ID_ZERO);
            JSONArray queryAddrArr = new JSONArray();
            queryAddrArr.put(QUERY_ADDR_WORLD_ZERO);
            queryAddrArr.put(QUERY_ADDR_WORLD_ONE);
            queryAddrArr.put(QUERY_ADDR_WORLD_TWO);
            queryAddrArr.put(QUERY_ADDR_WORLD_THREE);
            queryAddrArr.put(QUERY_ADDR_WORLD_FOUR);
            queryAddrArr.put(QUERY_ADDR_WORLD_FIVE);
            jsonObject.put(QUERY_ADDR, queryAddrArr);
            return socketHandler.sendMsg(jsonObject.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getJointCoordinate() {

        logger.info(BRTROBOT_SERVICE_GET_JOINT_COORDINATE);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(DSID, DSID_REMOTE_MONITOR);
            jsonObject.put(REQ_TYPE, REQ_TYPE_QUERY);
            jsonObject.put(PACK_ID, PACK_ID_ZERO);
            JSONArray queryAddrArr = new JSONArray();
            queryAddrArr.put(QUERY_ADDR_AXIS_ZERO);
            queryAddrArr.put(QUERY_ADDR_AXIS_ONE);
            queryAddrArr.put(QUERY_ADDR_AXIS_TWO);
            queryAddrArr.put(QUERY_ADDR_AXIS_THREE);
            queryAddrArr.put(QUERY_ADDR_AXIS_FOUR);
            queryAddrArr.put(QUERY_ADDR_AXIS_FIVE);
            jsonObject.put(QUERY_ADDR, queryAddrArr);
            return jsonObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMoveState() {

        logger.info(BRTROBOT_SERVICE_GET_MOVING_STATE);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(DSID, DSID_REMOTE_MONITOR);
            jsonObject.put(REQ_TYPE, REQ_TYPE_QUERY);
            jsonObject.put(PACK_ID, PACK_ID_ZERO);
            JSONArray queryAddrArr = new JSONArray();
            queryAddrArr.put(QUERY_ADDR_IS_MOVING);
            jsonObject.put(QUERY_ADDR, queryAddrArr);
            String js = jsonObject.toString();
            return socketHandler.sendMsg(js);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String setWorldCoordinate(double[] worldCoordinateArr) {

        logger.info(BRTROBOT_SERVICE_SET_WORLD_COORDINATE);
        JSONObject jsonObject = new JSONObject();
        String postStr;
        try {
            jsonObject.put(DSID, DSID_HC_REMOTE_COMMAND);
            jsonObject.put(REQ_TYPE, REQ_TYPE_ADD_RCC);
            jsonObject.put(EMPTY_LIST, EMPTY_LIST_ONE);
            JSONObject instruction = new JSONObject();
            instruction.put(INSTRUCTION_ONE_SHOT, INSTRUCTION_ONE_SHOT_ONE);
            instruction.put(INSTRUCTION_ACTION, INSTRUCTION_ACTION_TEN);
            instruction.put(INSTRUCTION_M_ZERO, String.valueOf(worldCoordinateArr[0]));
            instruction.put(INSTRUCTION_M_ONE, String.valueOf(worldCoordinateArr[1]));
            instruction.put(INSTRUCTION_M_TWO, String.valueOf(worldCoordinateArr[2]));
            instruction.put(INSTRUCTION_M_THREE, String.valueOf(worldCoordinateArr[3]));
            instruction.put(INSTRUCTION_M_FOUR, String.valueOf(worldCoordinateArr[4]));
            instruction.put(INSTRUCTION_M_FIVE, String.valueOf(worldCoordinateArr[5]));
            instruction.put(INSTRUCTION_CK_STATUS, INSTRUCTION_CK_STATUS_VALUE);
            instruction.put(INSTRUCTION_SPEED, INSTRUCTION_SPEED_SIXTY);
            instruction.put(INSTRUCTION_DELAY, INSTRUCTION_DELAY_ZERO);
            instruction.put(INSTRUCTION_SMOOTH, INSTRUCTION_SMOOTH_ZERO);
            JSONArray instructions = new JSONArray();
            instructions.put(instruction);
            jsonObject.put(INSTRUCTIONS, instructions);
            postStr = jsonObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return postStr;
    }

    @Override
    public String setJointCoordinate(double[] jointCoordinateArr) {

        logger.info(BRTROBOT_SERVICE_SET_JOINT_COORDINATE);
        JSONObject jsonObject = new JSONObject();
        String postStr;
        try {
            jsonObject.put(DSID, DSID_HC_REMOTE_COMMAND);
            jsonObject.put(REQ_TYPE, REQ_TYPE_ADD_RCC);
            jsonObject.put(EMPTY_LIST, EMPTY_LIST_ONE);
            JSONObject instruction = new JSONObject();
            instruction.put(INSTRUCTION_ONE_SHOT, INSTRUCTION_ONE_SHOT_ONE);
            instruction.put(INSTRUCTION_ACTION, INSTRUCTION_ACTION_FOUR);
            instruction.put(INSTRUCTION_M_ZERO, String.valueOf(jointCoordinateArr[0]));
            instruction.put(INSTRUCTION_M_ONE, String.valueOf(jointCoordinateArr[1]));
            instruction.put(INSTRUCTION_M_TWO, String.valueOf(jointCoordinateArr[2]));
            instruction.put(INSTRUCTION_M_THREE, String.valueOf(jointCoordinateArr[3]));
            instruction.put(INSTRUCTION_M_FOUR, String.valueOf(jointCoordinateArr[4]));
            instruction.put(INSTRUCTION_M_FIVE, String.valueOf(jointCoordinateArr[5]));
            instruction.put(INSTRUCTION_CK_STATUS, INSTRUCTION_CK_STATUS_VALUE);
            instruction.put(INSTRUCTION_SPEED, INSTRUCTION_SPEED_SIXTY);
            instruction.put(INSTRUCTION_DELAY, INSTRUCTION_DELAY_ZERO);
            instruction.put(INSTRUCTION_SMOOTH, INSTRUCTION_SMOOTH_ZERO);
            JSONArray instructions = new JSONArray();
            instructions.put(instruction);
            jsonObject.put(INSTRUCTIONS, instructions);
            postStr = jsonObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return postStr;
    }

    @Override
    public void waitMoving() {

    }

    @Override
    public double[] getAllRange(double[] worldCoordinateArr) {
        logger.info(BRTROBOT_SERVICE_GET_ALL_RANGE);
        // String worldCoordinate = getWorldCoordinate();
        // JSONObject jsonObject = new JSONObject(worldCoordinate);
        // JSONArray queryData = jsonObject.getJSONArray("queryData");
        // double[] worldCoordinateArr = new double[6];
        // worldCoordinateArr[0] = queryData.getDouble(0);
        // worldCoordinateArr[1] = queryData.getDouble(1);
        // worldCoordinateArr[2] = queryData.getDouble(2);
        // worldCoordinateArr[3] = queryData.getDouble(3);
        // worldCoordinateArr[4] = queryData.getDouble(4);
        // worldCoordinateArr[5] = queryData.getDouble(5);
        // 边界值数列，存储顺序为xMin, xMax, yMin, yMax, zMin, zMax
        double[] rangeArr = new double[6];
        for (int i = 0; i < 6; i += 2) {
            while (rangeArr[i] > -2000) {
                double[] point = worldCoordinateArr.clone();
                point[i / 2] += rangeArr[i];
                if (judgeWorldCoordinate(point)) {
                    rangeArr[i] -= 5.0;
                } else {
                    rangeArr[i] += 5.0;
                    break;
                }
            }
            while (rangeArr[i + 1] < 2000) {
                double[] point = worldCoordinateArr.clone();
                point[i / 2] += rangeArr[i + 1];
                if (judgeWorldCoordinate(point)) {
                    rangeArr[i + 1] += 5.0;
                } else {
                    rangeArr[i + 1] -= 5.0;
                    break;
                }
            }
            if (rangeArr[i] > 0)
                rangeArr[i] = 0;
            if (rangeArr[i + 1] < 0)
                rangeArr[i + 1] = 0;
        }
        return rangeArr;
    }

    @Override
    public boolean judgeWorldCoordinate(double[] worldCoordinateArr) {
        double x = worldCoordinateArr[0];
        double y = worldCoordinateArr[1];
        double z = worldCoordinateArr[2];
        double u = worldCoordinateArr[3];
        double v = worldCoordinateArr[4];
        double w = worldCoordinateArr[5];
        // 获取腕部XYZ坐标
        double[] wristCoordinate = this.getWristCoordinate(x, y, z, u, v, w);
        // 判断Z轴是否合法
        double wristX = wristCoordinate[0], wristY = wristCoordinate[1], wristZ = wristCoordinate[2];
        double lengthXY = Math.sqrt(wristX * wristX + wristY * wristY);
        if (lengthXY > 870) {
            return false;
        } else if (lengthXY >= 260) {
            if (wristZ <= 50 || wristZ <= (415.5 - Math.sqrt(410 * 410 - (390 + 70 - lengthXY) * (390 + 70 - lengthXY)))) {
                return false;
            }
        } else if (lengthXY < 260) {
            if (wristZ < (415.5 + 200)) {
                return false;
            }
        }
        if (wristZ > (415.5 + Math.sqrt(800 * 800 - (lengthXY - 70) * (lengthXY - 70)))) {
            return false;
        }
        return true;
    }

    @Override
    public double[] transCoordinateFromJsonToArray(String queryRes) {
        try {
            logger.info(BRTROBOT_SERVICE_TANS_COORDINATE_TO_LIST);
            JSONObject queryResJson = new JSONObject(queryRes);
            JSONArray worldCoordinateArray = queryResJson.getJSONArray(QUERY_DATA);
            double[] worldCoordinateArr = new double[6];
            for (int i = 0; i < worldCoordinateArray.length(); i++) {
                worldCoordinateArr[i] = worldCoordinateArray.getDouble(i);
            }
            return worldCoordinateArr;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double[] handleCoordinate(double[] coordinateArr, double[] movePosition) {
        for (int i = 0; i < 6; i++) {
            coordinateArr[i] += movePosition[i];
        }
        return coordinateArr;
    }

    @Override
    public InitPosition getInitPosition(int userId) {

        return initPositionRepository.findInitPositionByUserId(userId);
    }

    @Override
    public String setInitPosition(int userId) {

        InitPosition initPosition = initPositionRepository.findInitPositionByUserId(userId);
        double[] worldCoordinateArr = new double[6];
        worldCoordinateArr[0] = initPosition.getxPosition();
        worldCoordinateArr[1] = initPosition.getyPosition();
        worldCoordinateArr[2] = initPosition.getzPosition();
        worldCoordinateArr[3] = initPosition.getuPosition();
        worldCoordinateArr[4] = initPosition.getvPosition();
        worldCoordinateArr[5] = initPosition.getwPosition();
        return setWorldCoordinate(worldCoordinateArr);
    }

    @Override
    public void finishInit(int userId, double anglePosition) {

        String queryStr = getWorldCoordinate();
        double[] worldCoordinateArr = transCoordinateFromJsonToArray(queryStr);
        initPositionRepository.upsertInitPositionByUserId(userId, anglePosition, worldCoordinateArr[0], worldCoordinateArr[1], worldCoordinateArr[2], worldCoordinateArr[3], worldCoordinateArr[4], worldCoordinateArr[5]);
    }

    private double[] getWristCoordinate(double x, double y, double z, double u, double v, double w) {
        // u,v,w分别为x,y,z轴旋转角度，转换欧拉角需对应pitch,yaw,roll
        EulerAngles eulerAngles = new EulerAngles(Math.toRadians(v), Math.toRadians(w), Math.toRadians(u));
        Quaternion quaternion = eulerAngles.ToQuaternion();
        double[][] rotationMatrixArr = quaternionToRotationMatrix(quaternion);
        EulerAngles transEulerAngles = rotationMatrixToEulerAngles(rotationMatrixArr);
        double[] wristCoordinate = new double[3];

        wristCoordinate[0] = (x - Math.sin(Math.toRadians(transEulerAngles.yaw)) * dhDJ6);
        wristCoordinate[1] = (y - Math.sin(Math.toRadians(-transEulerAngles.roll)) * Math.cos(Math.toRadians(transEulerAngles.yaw)) * dhDJ6);
        wristCoordinate[2] = (z - Math.cos(Math.toRadians(-transEulerAngles.roll)) * Math.cos(Math.toRadians(transEulerAngles.yaw)) * dhDJ6);
        return wristCoordinate;
    }

    // 四元数转旋转矩阵
    private double[][] quaternionToRotationMatrix(Quaternion quaternion) {
        double[][] rotationMatrixArr = new double[3][3];

        rotationMatrixArr[0][0] = 1 - 2 * quaternion.y * quaternion.y - 2 * quaternion.z * quaternion.z;
        rotationMatrixArr[0][1] = 2 * quaternion.x * quaternion.y - 2 * quaternion.z * quaternion.w;
        rotationMatrixArr[0][2] = 2 * quaternion.x * quaternion.z + 2 * quaternion.y * quaternion.w;
        rotationMatrixArr[1][0] = 2 * quaternion.x * quaternion.y + 2 * quaternion.z * quaternion.w;
        rotationMatrixArr[1][1] = 1 - 2 * quaternion.x * quaternion.x - 2 * quaternion.z * quaternion.z;
        rotationMatrixArr[1][2] = 2 * quaternion.y * quaternion.z - 2 * quaternion.x * quaternion.w;
        rotationMatrixArr[2][0] = 2 * quaternion.x * quaternion.z - 2 * quaternion.y * quaternion.w;
        rotationMatrixArr[2][1] = 2 * quaternion.y * quaternion.z + 2 * quaternion.x * quaternion.w;
        rotationMatrixArr[2][2] = 1 - 2 * quaternion.x * quaternion.x - 2 * quaternion.y * quaternion.y;

        return rotationMatrixArr;
    }

    // 旋转矩阵转xyz欧拉角
    private EulerAngles rotationMatrixToEulerAngles(double[][] rotationMatrix) {

        double y = Math.asin(Math.max(-1, Math.min(rotationMatrix[0][2], 1)));
        double x = 0, z = 0;
        if (0.99999 > Math.abs(rotationMatrix[0][2])) {
            x = Math.atan2(-rotationMatrix[1][2], rotationMatrix[2][2]);
            z = Math.atan2(-rotationMatrix[0][1], -rotationMatrix[0][0]);
        } else {
            x = Math.atan2(rotationMatrix[2][1], -rotationMatrix[1][1]);
        }

        // 由zyx转换为xyz,返回对应值x-roll, y-yaw, z-pitch
        return new EulerAngles(Math.toDegrees(z), Math.toDegrees(y), Math.toDegrees(x));
    }
}
