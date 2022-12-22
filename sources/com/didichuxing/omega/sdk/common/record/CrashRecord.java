package com.didichuxing.omega.sdk.common.record;

import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.collector.LogcatCollector;
import java.util.Map;

public class CrashRecord extends ChanceRecord {
    public String getErrorType() {
        return (String) get("et");
    }

    public String getErrorLine() {
        return (String) get("el");
    }

    public String getErrorTrace() {
        return (String) get("etc");
    }

    public String getErrorMsg() {
        return (String) get("em");
    }

    public String getAllThreadStack() {
        return (String) get("at");
    }

    public void setErrorType(String str) {
        put("et", str);
    }

    public void setErrorLine(String str) {
        put("el", str);
    }

    public void setErrorTrace(String str) {
        put("etc", str);
    }

    public void setErrorMsg(String str) {
        put("em", str);
    }

    public void setAllThreadStack(String str) {
        put("at", str);
    }

    public void setCurrentThreadCount(int i) {
        put("ctc", Integer.valueOf(i));
    }

    public void setSysThreadCount(int i) {
        put("stc", Integer.valueOf(i));
    }

    public void setCurrentFdCount(int i) {
        put("cfd", Integer.valueOf(i));
    }

    public void setSysFdCount(int i) {
        put("sfd", Integer.valueOf(i));
    }

    public void setFdList(Map<String, Object> map) {
        put("fdl", map);
    }

    public void takeLogcatWithCrashCheck(String str) {
        if (str == null) {
            takeLogcat();
            return;
        }
        LogcatCollector.LogcatBuffer logcat = LogcatCollector.getLogcat(OmegaConfig.LOGCAT_TAIL_COUNT, str);
        putLogcat(logcat.getBuffer().getBytes());
        if (!logcat.isContainErrMessage()) {
            int i = 0;
            while (i < 3) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                LogcatCollector.LogcatBuffer logcat2 = LogcatCollector.getLogcat(OmegaConfig.LOGCAT_TAIL_MAX_COUNT, str);
                putLogcat(logcat2.getBuffer().getBytes());
                if (logcat2.isContainErrMessage()) {
                    return;
                }
            }
        }
    }
}
