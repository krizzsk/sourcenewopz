package com.didi.nova.assembly;

import com.didi.nova.assembly.ALog;

public class Assembly {
    public static void setLog(ALog.ILog iLog) {
        ALog.f29089a = iLog != null;
        ALog.f29090b = iLog;
    }
}
