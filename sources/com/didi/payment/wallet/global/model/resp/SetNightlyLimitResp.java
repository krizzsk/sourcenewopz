package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;

public class SetNightlyLimitResp extends WBaseResp {
    public SetNightlyLimitVo data;

    public static class SetNightlyLimitVo {
        public String effectiveTime;
        public boolean isHit;
        public long limitInEffect;
        public long limitUnderAnalysis;
    }
}
