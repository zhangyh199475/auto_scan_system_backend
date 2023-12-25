package org.pengcheng.auto_scan_system_backend.service.impl;

import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.LongByReference;
import org.pengcheng.auto_scan_system_backend.service.VISA32;
import org.springframework.beans.factory.annotation.Value;

public class Instrument {

    LongByReference defaultSession;
    LongByReference vipSession;
    VISA32 visa32 = VISA32.INSTANCE;

    @Value("${vna.ip}")
    private String ip = "169.254.114.102";

    public boolean open() {

        defaultSession = new LongByReference(0);
        int result = visa32.viOpenDefaultRM(defaultSession);
        if (result != VISA32.VI_SUCCESS) {
            return false;
        }

        vipSession = new LongByReference(0);
        String cmd = "TCPIP0::<ip>::hislip0::INSTR".replace("<ip>", ip);

        NativeLong a = new NativeLong(defaultSession.getValue());
        NativeLong b = new NativeLong(0);
        result = visa32.viOpen(a, cmd, b, b, vipSession);
        if (result != VISA32.VI_SUCCESS) {
            System.out.println(result);
            return false;
        }
        return true;
    }

    /**
     * 关闭设备.
     *
     * @return 成功返回true，失败返回false
     */
    public boolean close() {
        NativeLong a = new NativeLong(vipSession.getValue());
        int result = VISA32.INSTANCE.viClose(a);
        if (result != VISA32.VI_SUCCESS) {
            System.out.println(result);
            return false;
        }

        NativeLong b = new NativeLong(defaultSession.getValue());
        result = VISA32.INSTANCE.viClose(b);
        if (result != VISA32.VI_SUCCESS) {
            System.out.println(result);
            return false;
        }

        return true;
    }

    public boolean writeCmd(String cmdStr) {
        NativeLong a = new NativeLong(vipSession.getValue());
        int result = VISA32.INSTANCE.viPrintf(a, "%s\n", cmdStr);
        if (result != VISA32.VI_SUCCESS) {
            System.out.println(result);
            return false;
        }
        return true;
    }

    public String readResult() {
        NativeLong a = new NativeLong(vipSession.getValue());
        Memory mem = new Memory(200);
        int result = VISA32.INSTANCE.viScanf(a, "%t", mem);
        if (result != VISA32.VI_SUCCESS) {
            System.out.println(result);
            return null;
        }
        return mem.getString(0);
    }

    public int scanfInstrment() {
        NativeLong a = new NativeLong(defaultSession.getValue());
        NativeLong b = new NativeLong(0);
        return visa32.viScanf(a, "");

    }
}
