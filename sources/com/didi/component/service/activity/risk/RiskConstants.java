package com.didi.component.service.activity.risk;

public class RiskConstants {
    public static final int VERIFY_MODE_CARD = 3;
    public static final int VERIFY_MODE_CARD_FB = 1;
    public static final int VERIFY_MODE_CARD_FB_CURP = 5;
    public static final int VERIFY_MODE_FB = 2;
    public static final int VERIFY_MODE_FB_CURP = 6;

    public static class RiskVerifyFusionCallBack {
        public static final String CALLBACK_ACTION = "action";
        public static final int CALLBACK_RETURN_2_ESTIMATE = 2;
        public static final int CALLBACK_RETURN_2_VERITY_LIST = 1;
        public static final String CALLBACK_STATUS = "status";
    }
}
