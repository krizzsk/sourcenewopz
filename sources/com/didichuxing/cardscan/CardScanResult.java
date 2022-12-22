package com.didichuxing.cardscan;

import com.didichuxing.cardscan.model.C15185a;

public class CardScanResult {
    public static final int RESULT_ACTIVITY_NULL = 3;
    public static final int RESULT_CANCEL = 5;
    public static final int RESULT_FAIL = 6;
    public static final int RESULT_MANUAL = 7;
    public static final int RESULT_NOT_SUPPORT_SCAN = 2;
    public static final int RESULT_NO_CAMERA_PERMISSION = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_OPEN_CAMERA_ERROR = 4;
    public String cardNumber;
    public long duration;
    public int expiryMonth = 0;
    public int expiryYear = 0;
    public int requestCode;
    public int resultCode;

    public boolean isExpiryValid() {
        return C15185a.m33175a(this.expiryMonth, this.expiryYear);
    }
}
