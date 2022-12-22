package com.didi.payment.kycservice.utils;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/payment/kycservice/utils/PixConst;", "", "()V", "CUSTOMER_SERVICE_URL", "", "KEY_STATUS_NEW", "", "KEY_STATUS_NORMAL", "KEY_STATUS_PENDING", "KEY_STATUS_UNABLE", "MAX_POLL_COUNT", "NET_ERR_CODE_KYC_BLOCK", "NET_ERR_CODE_NEED_MIGRATE", "NET_ERR_CODE_OK", "NET_ERR_CODE_POLL", "NET_ERR_CODE_VERIFY", "PHONE_NUM_MAX_LENGTH", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixConst.kt */
public final class PixConst {
    public static final String CUSTOMER_SERVICE_URL = "https://help.didiglobal.com/passenger-index-new.html?source=99pay&kfPageSource=99pay";
    public static final PixConst INSTANCE = new PixConst();
    public static final int KEY_STATUS_NEW = 99;
    public static final int KEY_STATUS_NORMAL = 0;
    public static final int KEY_STATUS_PENDING = 1;
    public static final int KEY_STATUS_UNABLE = 2;
    public static final int MAX_POLL_COUNT = 5;
    public static final int NET_ERR_CODE_KYC_BLOCK = 60222;
    public static final int NET_ERR_CODE_NEED_MIGRATE = 60200;
    public static final int NET_ERR_CODE_OK = 0;
    public static final int NET_ERR_CODE_POLL = 60201;
    public static final int NET_ERR_CODE_VERIFY = 60204;
    public static final int PHONE_NUM_MAX_LENGTH = 11;

    private PixConst() {
    }
}
