package com.didi.payment.paymethod.open.cons;

public class Channel {
    public static final int ALIPAY = 134;
    public static final int CASH = 153;
    public static final int CMB = 136;
    public static final int DIDI_CREDIT_PAY = 161;
    public static final int DIDI_PAY = 169;
    public static final int GLOBAL_ALIPAY = 171;
    public static final int GLOBAL_WEIXIN = 170;
    public static final int INTERNATIONAL_CREDIT_CARD = 150;
    public static final int INTERNATIONAL_CREDIT_CARD_MASTER = 192;
    public static final int NEW_PAYPAL = 183;
    public static final int PAYPAL = 152;
    public static final int PAYPAY = 182;

    /* renamed from: QQ */
    public static final int f30961QQ = 144;
    public static final int WEIXIN = 133;
    public static final int ZFT = 162;

    public static boolean isChinaSupportChannel(int i) {
        return i == 134 || i == 133 || i == 171 || i == 170 || i == 136 || i == 144 || i == 150 || i == 192 || i == 161 || i == 162 || i == 169 || i == 153;
    }

    public static boolean isCreditCardChannel(int i) {
        return i == 150 || i == 192;
    }
}
