package com.didi.sdk.payment;

import com.didi.payment.creditcard.open.feature.DidiAddCardData;
import java.io.Serializable;

@Deprecated
public class DidiCreditCardData implements Serializable {
    public static final String CREDIT_CARD_PARAM = "credit_card_param";
    public static final String CREDIT_CARD_PARAM_BIND_TYPE = "credit_card_param_bind_type";
    public static final String CREDIT_CARD_PARAM_DEVICE_ID = "credit_card_param_device_id";
    public static final String CREDIT_CARD_PARAM_IS_SIGN_AFTER_ORDER = "credit_card_param_is_sign_after_order";
    public static final String CREDIT_CARD_PARAM_ORDER_ID = "credit_card_param_order_id";
    public static final String CREDIT_CARD_PARAM_ORIGIN_ID = "credit_card_param_origin_id";
    public static final String CREDIT_CARD_PARAM_PRODUCT_LINE = "credit_card_param_product_line";
    public static final String CREDIT_CARD_PARAM_SUUID = "credit_card_param_suuid";
    public static final String CREDIT_CARD_PARAM_TOKEN = "credit_card_param_token";
    public static final String PAY_RESULT = "payResult";

    public static class Result implements Serializable {
        public static final int FAIL = 2;
        public static final int SUCCESS = 1;
        public int code = 2;
        public String message;
    }

    public static class Param implements Serializable {
        public static final int BIND_TYPE_USER_GUIDE = 5;
        public static final String ORIGIN_ID_BRAZIL = "5";
        public static final String ORIGIN_ID_GLOBAL = "1";
        public int bindType;
        public String deviceId;
        public boolean isNeedQueryResult;
        public boolean isSignAfterOrder = false;
        public String orderId = "";
        public String originId;
        public String productLine = "";
        public String suuid;
        public String token;

        public DidiAddCardData.Param transform() {
            DidiAddCardData.Param param = new DidiAddCardData.Param();
            param.isNeedQueryResult = this.isNeedQueryResult;
            param.bindType = this.bindType;
            param.orderId = this.orderId;
            param.productLine = this.productLine;
            param.isSignAfterOrder = this.isSignAfterOrder;
            return param;
        }
    }
}
