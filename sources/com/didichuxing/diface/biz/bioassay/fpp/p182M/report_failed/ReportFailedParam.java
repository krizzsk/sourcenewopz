package com.didichuxing.diface.biz.bioassay.fpp.p182M.report_failed;

import com.didichuxing.diface.core.BaseParam;
import java.io.Serializable;

/* renamed from: com.didichuxing.diface.biz.bioassay.fpp.M.report_failed.ReportFailedParam */
public class ReportFailedParam extends BaseParam implements Serializable {
    public String aliveErrorCode;
    public String aliveErrorMsg;
    public int facePlan;
    public String sessionId;

    public int getFacePlan() {
        return this.facePlan;
    }

    public String getAliveErrorCode() {
        return this.aliveErrorCode;
    }

    public String getAliveErrorMsg() {
        return this.aliveErrorMsg;
    }

    public String getSessionId() {
        return this.sessionId;
    }
}
