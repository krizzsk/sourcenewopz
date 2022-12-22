package com.didichuxing.mas.sdk.quality.init;

import java.util.Map;

public abstract class NetEventParamBean {
    public String getAppState() {
        return "";
    }

    public String getCarrier() {
        return "";
    }

    public int getConState() {
        return 0;
    }

    public abstract long getDownBytes();

    public Exception getErrTrace() {
        return null;
    }

    public String getErrorClass() {
        return "";
    }

    public abstract int getErrorCode();

    public String getErrorInfo() {
        return "";
    }

    public Map<String, Object> getExtraParams() {
        return null;
    }

    public abstract int getHttpStateCode();

    public abstract int getHttpdns();

    public String getIP() {
        return "";
    }

    public String getLocaError() {
        return "";
    }

    public abstract String getMethod();

    public int getNtAppState() {
        return 0;
    }

    public String getProtocolName() {
        return "";
    }

    public String getReuseCon() {
        return "";
    }

    public String getScheme() {
        return "";
    }

    public abstract long getTime();

    public String getTraceid() {
        return "";
    }

    public abstract String getURL();

    public abstract long getUpBytes();

    public String getWanType() {
        return "";
    }
}
