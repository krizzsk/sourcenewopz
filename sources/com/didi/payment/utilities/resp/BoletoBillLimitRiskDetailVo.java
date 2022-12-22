package com.didi.payment.utilities.resp;

import java.io.Serializable;

public class BoletoBillLimitRiskDetailVo implements Serializable {
    public String description;
    public String link;
    public String payButtonText;
    public long riskLimitQuota;
}
