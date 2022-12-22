package com.didi.sdk.global;

import java.io.Serializable;

public class DidiGlobalCardExpireInterceptData {

    public interface CardExpireInterceptCallback {
        public static final int CODE_CHANGE_PAYMENT_METHOD = 1;
        public static final int CODE_UPDATE_CARD = 0;

        void onClick(int i);
    }

    public static class CardExpireInterceptParam implements Serializable {
        public static final int TYPE_BILL = 0;
        public static final int TYPE_CHECKSTAND = 1;
        public String cardNo;
        public String icon;
        public int type;
    }
}
