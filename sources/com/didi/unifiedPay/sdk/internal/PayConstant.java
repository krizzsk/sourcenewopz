package com.didi.unifiedPay.sdk.internal;

public class PayConstant {

    public enum PayBillType {
        Trip,
        NoneTrip,
        Merchant
    }

    public static boolean isGlobalOfflineChannel(int i) {
        return i == 178 || i == 204 || i == 203 || i == 214 || i == 213 || i == 205 || i == 215 || i == 175 || i == 200 || i == 201 || i == 202;
    }

    public static boolean isGlobalThirdChannel(int i) {
        return i == 152 || i == 204 || i == 203 || i == 205 || i == 214 || i == 213 || i == 215 || i == 212 || i == 183 || i == 150 || i == 182 || i == 190 || i == 178 || i == 175 || i == 200 || i == 201 || i == 202 || i == 2005;
    }

    public class PayChannelType {
        public static final int CHANNEL_TYPE_ALI = 128;
        public static final int CHANNEL_TYPE_ALI_GLOBAL = 170;
        public static final int CHANNEL_TYPE_ALI_HK = 172;
        public static final int CHANNEL_TYPE_ALI_NO_PWD = 134;
        public static final int CHANNEL_TYPE_BALANCE = 126;
        public static final int CHANNEL_TYPE_BALOTO = 201;
        public static final int CHANNEL_TYPE_BANK = 135;
        public static final int CHANNEL_TYPE_BANKTRANSACTION = 205;
        public static final int CHANNEL_TYPE_BANK_NO_PWD = 136;
        public static final int CHANNEL_TYPE_BOLETO = 178;
        public static final int CHANNEL_TYPE_CHANGE = 180;
        public static final int CHANNEL_TYPE_DIDIPAY = 166;
        public static final int CHANNEL_TYPE_DIDI_CREDIT = 161;
        public static final int CHANNEL_TYPE_DISCOUNT_CHARGE = 115;
        public static final int CHANNEL_TYPE_EFECTY = 202;
        public static final int CHANNEL_TYPE_ENTERPRISE = 121;
        public static final int CHANNEL_TYPE_EXPERIENCE = 108;
        public static final int CHANNEL_TYPE_FAMILY_PAY = 9100;
        public static final int CHANNEL_TYPE_FAST_BALOTO = 214;
        public static final int CHANNEL_TYPE_FAWRY = 213;
        public static final int CHANNEL_TYPE_GLOBAL_BALANCE = 120;
        public static final int CHANNEL_TYPE_NEW_PAYPAL = 183;
        public static final int CHANNEL_TYPE_NEXT_TRIP = 2005;
        public static final int CHANNEL_TYPE_NINENINEPAY = 190;
        public static final int CHANNEL_TYPE_OXXO = 175;
        public static final int CHANNEL_TYPE_PAGOFACIL = 204;
        public static final int CHANNEL_TYPE_PAYPAL = 152;
        public static final int CHANNEL_TYPE_PAYPAY = 182;
        public static final int CHANNEL_TYPE_PIX = 212;
        public static final int CHANNEL_TYPE_PREPAY = 118;
        public static final int CHANNEL_TYPE_QQ = 132;
        public static final int CHANNEL_TYPE_QQ_NO_PWD = 144;
        public static final int CHANNEL_TYPE_RAPIPAGO = 203;
        public static final int CHANNEL_TYPE_SERVIPAG = 200;
        public static final int CHANNEL_TYPE_SPEI = 215;
        public static final int CHANNEL_TYPE_TRAVEL_CARD = 123;
        public static final int CHANNEL_TYPE_UNKNOWN = 0;
        public static final int CHANNEL_TYPE_VISA = 150;
        public static final int CHANNEL_TYPE_WX = 127;
        public static final int CHANNEL_TYPE_WX_GLOBAL = 171;
        public static final int CHANNEL_TYPE_WX_HK = 173;
        public static final int CHANNEL_TYPE_WX_NO_PWD = 133;
        public static final int CHANNEL_TYPE_ZHIFUTONG = 162;

        public PayChannelType() {
        }
    }
}
