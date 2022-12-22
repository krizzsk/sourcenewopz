package com.didi.trackupload.sdk.datachannel;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class SendResult {
    public static final int DETAIL_ERR_CODE_HTTP_BUILD_WHOLE_MSG = -1101;
    public static final int DETAIL_ERR_CODE_HTTP_RESPONSE_OTHER_EXCEPTION = -1000;
    public static final int DETAIL_ERR_CODE_HTTP_TRHEAD_INTERRUPT = -1001;
    public static final int DETAIL_ERR_CODE_LOCAL_OTHER = -9999;
    public static final int DETAIL_ERR_CODE_PARSE_HTTP_RESPONSE = -1002;
    public static final int DETAIL_ERR_CODE_PB_2_BYTES = -1100;
    public static final int RESULT_FAIL = -1;
    public static final int RESULT_SUCC = 0;
    public static final int RESULT_TIMEOUT = -2;
    public static final int SEND_TYPE_HTTP = 1;
    public static final int SEND_TYPE_PUSH = 0;

    /* renamed from: a */
    private int f43978a;

    /* renamed from: b */
    private int f43979b;

    /* renamed from: c */
    private int f43980c;

    /* renamed from: d */
    private int f43981d;

    public int getBytesLength() {
        return this.f43981d;
    }

    public void setBytesLength(int i) {
        this.f43981d = i;
    }

    public int getResultCode() {
        return this.f43978a;
    }

    public int getSendType() {
        return this.f43979b;
    }

    public int getDetailCode() {
        return this.f43980c;
    }

    public void setDetailCode(int i) {
        this.f43980c = i;
    }

    public SendResult(int i, int i2) {
        this.f43978a = i;
        this.f43979b = i2;
        this.f43980c = -9999;
    }

    public SendResult(int i, int i2, int i3) {
        this.f43978a = i;
        this.f43980c = i2;
        this.f43979b = i3;
    }

    public String toString() {
        return Const.joLeft + this.f43979b + "," + this.f43981d + "," + this.f43978a + "," + this.f43980c + "}";
    }
}
