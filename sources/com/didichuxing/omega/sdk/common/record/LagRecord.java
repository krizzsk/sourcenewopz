package com.didichuxing.omega.sdk.common.record;

public class LagRecord extends ChanceRecord {
    public LagRecord() {
        put("lag", 2);
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
