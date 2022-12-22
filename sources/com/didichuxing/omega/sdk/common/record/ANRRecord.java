package com.didichuxing.omega.sdk.common.record;

import com.didichuxing.omega.sdk.common.collector.LogcatCollector;

public class ANRRecord extends ChanceRecord {
    public ANRRecord() {
        put("lag", 1);
    }

    public void setTraceFilename(String str) {
        addFile(str);
    }

    public void setAllThreadStack(String str) {
        put("at", str);
    }

    public void takeLogCatWithAnrReason() {
        putLogcat(LogcatCollector.getLogcatWithAnrReason(2500).getBytes());
    }
}
