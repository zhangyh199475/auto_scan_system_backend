package org.pengcheng.auto_scan_system_backend.service;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.LongByReference;

public interface VISA32 extends Library {
    // VISA32 INSTANCE = (VISA32) Native.loadLibrary("VISA32",
    // VISA32.class);
    VISA32 INSTANCE = (VISA32) Native.loadLibrary(
            "C:\\Program Files (x86)\\IVI Foundation\\VISA\\WinNT\\agvisa\\agbin\\visa32.dll", VISA32.class);

    public static final long VI_NULL = 0;
    public static final long VI_SUCCESS = 0;

    public int viOpenDefaultRM(LongByReference session);

    public int viOpen(NativeLong viSession, String rsrcName,
                      NativeLong accessMode, NativeLong timeout,
                      LongByReference session);

    public int viClose(NativeLong vi);

    public int viScanf(NativeLong vi, String readFmt, Object... args);

    public int viPrintf(NativeLong vi, String writeFmt, Object... args);
}
