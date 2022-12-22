package com.didichuxing.diface.biz.bioassay.alpha.p180M.report_failed;

import com.didichuxing.diface.data.BaseResult;
import java.io.Serializable;

/* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.report_failed.ReportFailedResult */
public class ReportFailedResult extends BaseResult {
    public Data data;

    /* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.report_failed.ReportFailedResult$Data */
    public static class Data implements Serializable {
        public int code;
        public String message;
        public Result result;

        /* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.report_failed.ReportFailedResult$Data$Result */
        public static class Result implements Serializable {
            public String session_id;
        }
    }
}
