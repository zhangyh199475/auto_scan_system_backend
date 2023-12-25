package org.pengcheng.auto_scan_system_backend.domain;


public class EulerAngles {
    // 根据机器人系统设置，该六轴机器人旋转顺序对应关系为zyx，即z-yaw, y-pitch, x-roll
    public double pitch;
    public double yaw;
    public double roll;

    public EulerAngles(double pitch, double yaw, double roll) {
        this.pitch = pitch; // y
        this.yaw = yaw; // z
        this.roll = roll; // x
    }

    public EulerAngles(double w, double x, double y, double z) {
        // roll (x-axis rotation)
        double sinrCosp = 2 * (w * x + y * z);
        double cosrCosp = 1 - 2 * (x * x + y * y);
        this.roll = Math.atan2(sinrCosp, cosrCosp);

        // pitch (y-axis rotation)
        double sinp = 2 * (w * y - z * x);
        if (Math.abs(sinp) >= 1) {
            this.pitch = Math.copySign(1.57075f, sinp); // use 90 degrees if out of range
        } else {
            this.pitch = Math.asin(sinp);
        }

        // yaw (z-axis rotation)
        double sinyCosp = 2 * (w * z + x * y);
        double cosyCosp = 1 - 2 * (y * y + z * z);
        this.yaw = Math.atan2(sinyCosp, cosyCosp);
    }

    public Quaternion ToQuaternion() {
        //欧拉角转四元数，角度减半是因为四元数旋转计算时需要旋转两次，具体原理请查看四元数原理
        double cy = Math.cos(yaw * 0.5f);
        double sy = Math.sin(yaw * 0.5f);
        double cp = Math.cos(pitch * 0.5f);
        double sp = Math.sin(pitch * 0.5f);
        double cr = Math.cos(roll * 0.5f);
        double sr = Math.sin(roll * 0.5f);
        Quaternion q = new Quaternion();
        q.w = cy * cp * cr + sy * sp * sr;
        q.x = cy * cp * sr - sy * sp * cr;
        q.y = sy * cp * sr + cy * sp * cr;
        q.z = sy * cp * cr - cy * sp * sr;
        return q;
    }
}
