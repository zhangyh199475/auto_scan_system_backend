package org.pengcheng.auto_scan_system_backend.utils;

public class ModBusUtils {

    public static char byteToASCLL(byte b) {
        return (char) b;
    }


    /*
     * 字节数组转16进制字符串
     */
    public static String bytes2HexString(byte[] b) {
        String r = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            r += hex.toUpperCase() + " ";
        }
        return r;
    }
}
