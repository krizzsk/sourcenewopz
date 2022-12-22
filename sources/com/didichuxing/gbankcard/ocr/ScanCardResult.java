package com.didichuxing.gbankcard.ocr;

import android.text.TextUtils;
import com.didi.safetoolkit.api.SfConstant;

public class ScanCardResult {
    public static final int CODE_CANCEL_BACK_BOTTOM = 105;
    public static final int CODE_CANCEL_BACK_ICON = 103;
    public static final int CODE_CANCEL_BACK_KEY = 104;
    public static final int CODE_CANCEL_DIALOG_QUIT_BTN = 106;
    public static final int CODE_FAIL_DEVICE_NOT_SUPPORT = 107;
    public static final int CODE_NO_CAMERA_PERMISSION = 102;
    public static final int CODE_OK = 0;
    public static final int CODE_WRONG_CONTEXT = 100;
    public static final int CODE_WRONG_PARAM = 101;
    public String cardNum;
    public float[] cardNumRect;
    public int cardNumState;
    public float[] cardRect;
    public final int code;
    public String msg;
    public float prob;
    public final int type;

    public ScanCardResult(int i) {
        this(i, 0);
    }

    public ScanCardResult(int i, int i2) {
        this.code = i;
        this.type = i2;
    }

    public boolean isForceType() {
        return this.type == 1;
    }

    public String getDisplayCardNum() {
        if (TextUtils.isEmpty(this.cardNum)) {
            return "";
        }
        int min = Math.min(30, this.cardNum.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            sb.append(this.cardNum.charAt(i));
            if (i < min - 1 && (i + 1) % 4 == 0) {
                sb.append("  ");
            }
        }
        return sb.toString();
    }

    public String getMaskedCardNum() {
        if (TextUtils.isEmpty(this.cardNum)) {
            return "";
        }
        int length = this.cardNum.length();
        StringBuilder sb = new StringBuilder();
        if (length >= 10) {
            sb.append(this.cardNum, 0, 6);
            sb.append("*");
            sb.append(this.cardNum.substring(length - 4));
        } else if (length >= 6) {
            sb.append(this.cardNum, 0, 6);
            sb.append("*");
        } else {
            sb.append(this.cardNum);
            sb.append("*");
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScanCardResult{code=");
        sb.append(this.code);
        sb.append(", type=");
        sb.append(isForceType() ? "Force" : SfConstant.SfDangerLevel.LEVEL_NORMAL);
        sb.append(", cardNum=");
        sb.append(getDisplayCardNum());
        sb.append(", msg=");
        sb.append(this.msg);
        sb.append("}");
        return sb.toString();
    }
}
