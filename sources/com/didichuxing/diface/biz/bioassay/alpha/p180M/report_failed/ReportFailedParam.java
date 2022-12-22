package com.didichuxing.diface.biz.bioassay.alpha.p180M.report_failed;

import com.didichuxing.diface.core.BaseParam;
import java.io.Serializable;

/* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.report_failed.ReportFailedParam */
public class ReportFailedParam extends BaseParam implements Serializable {
    public String aliveErrorCode;
    public String aliveErrorMsg;
    public String sessionId;

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
