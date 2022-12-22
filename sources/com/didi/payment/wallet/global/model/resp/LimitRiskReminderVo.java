package com.didi.payment.wallet.global.model.resp;

import java.io.Serializable;

public class LimitRiskReminderVo implements Serializable {
    public static final int LIMIT_RISK_LEFT_STATUS_CONTINUE = 1;
    public static final int LIMIT_RISK_LEFT_STATUS_RETURN = 2;
    public int leftStatus;
    public String leftText;
    public String rightLink;
    public String rightText;
    public String subTitle;
    public String title;
}
