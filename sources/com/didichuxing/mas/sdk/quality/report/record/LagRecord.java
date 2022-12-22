package com.didichuxing.mas.sdk.quality.report.record;

import com.didichuxing.mas.sdk.quality.report.utils.FileType;

public class LagRecord extends ChanceRecord {
    public LagRecord() {
        put("lag", 2);
        setFileType(FileType.CARTOON);
    }

    public void setErrorTrace(String str) {
        put("etc", str);
    }

    public void setAllThreadStack(String str) {
        put("at", str);
    }

    public void setCpuRate(String str) {
        put("cpurate", str);
    }

    public void setCpuBusy(Boolean bool) {
        put("cpubusy", Integer.valueOf(bool.booleanValue() ? 1 : 0));
    }

    public void setBlockTime(String str) {
        put("blocktime", str);
    }

    public void setLatestFPS(String str) {
        put("latestfps", str);
    }

    public void setSystemRefreshRate(float f) {
        put("systemRefreshRate", Float.valueOf(f));
    }
}
