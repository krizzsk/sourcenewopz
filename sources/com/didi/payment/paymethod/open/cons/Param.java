package com.didi.payment.paymethod.open.cons;

public class Param {

    public static class BindType {
        public static final int DEFAULT = 8;
        public static final int JIE_TU = 13;
        public static final int SLIDE_WALLET = 1;
        public static final int SODA = 14;
        public static final int SUBMIT_TRIP = 8;
        public static final int UNIFIED_PAY = 4;
        public static final int USER_GUIDE = 5;
    }

    public static class CancelSignType {
        public static final int CANCEL_CARD = 2;
        public static final int CANCEL_SIGN = 1;
    }

    public static class SignType {
        public static final int BIND_AND_SIGN = 1;
        public static final int ONLY_SIGN = 2;
    }
}
