package com.didi.payment.wallet.global.model.resp;

import java.io.Serializable;

public class LimitRiskDetailVo implements Serializable {
    public String description;
    public String link;
    public String payButtonText;
    public long riskLimitQuota;
}
