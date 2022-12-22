package com.didi.payment.commonsdk.utils;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NWConst;", "", "()V", "Net", "NetErrCode", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NWConst.kt */
public final class NWConst {
    public static final NWConst INSTANCE = new NWConst();

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NWConst$Net;", "", "()V", "BASE_SERVER_URL", "", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NWConst.kt */
    public static final class Net {
        public static final String BASE_SERVER_URL = "https://wallet.didiglobal.com";
        public static final Net INSTANCE = new Net();

        private Net() {
        }
    }

    private NWConst() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NWConst$NetErrCode;", "", "()V", "INVALID_HOMELAND_CITY", "", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NWConst.kt */
    public static final class NetErrCode {
        public static final NetErrCode INSTANCE = new NetErrCode();
        public static final int INVALID_HOMELAND_CITY = 1010;

        private NetErrCode() {
        }
    }
}
