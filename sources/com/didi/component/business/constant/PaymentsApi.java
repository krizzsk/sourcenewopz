package com.didi.component.business.constant;

public class PaymentsApi {
    public static final int CASH = 1024;
    public static final int CREDIT_CARD_TAG = 4096;
    public static final int DEBIT_TAG = 2048;
    public static final int ENTERPRISE_TAG = 512;
    public static final int ONLINE_CARD = 256;
    public static final int[] PAYMENTS_WHITE_LIST = {128, 256, 1024, 2048, 4096, 512, 4194304, 8388608};
    public static final int PAY_PAL_TAG = 128;
    public static final int Pix = 8388608;
    public static final int START_SIGN_CARD = 111;
    public static final int WALLET_99 = 4194304;

    public static boolean containsPayment(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = PAYMENTS_WHITE_LIST;
            if (i2 >= iArr.length) {
                return false;
            }
            if (iArr[i2] == i) {
                return true;
            }
            i2++;
        }
    }
}
