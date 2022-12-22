package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;

public class GetNightlyLimitResp extends WBaseResp {
    public NightlyLimitVo data;

    public static class NightlyLimitVo {
        public String effectiveTime;
        public boolean isHit;
        public LimitRiskDetailVo limitRiskDetail;
        public long remainingLimit;
    }
}
