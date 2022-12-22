package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import java.io.Serializable;

public class QueryNightlyLimitSettingResp extends WBaseResp {
    public QueryNightlyLimitSettingVo data;

    public static class QueryNightlyLimitSettingVo implements Serializable {
        public String effectiveTime;
        public boolean isHit;
        public long limitInEffective;
        public long limitUnderAnalysis;
    }
}
