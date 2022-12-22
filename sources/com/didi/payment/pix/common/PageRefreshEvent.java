package com.didi.payment.pix.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/pix/common/PageRefreshEvent;", "", "refer", "", "(Ljava/lang/String;)V", "getRefer", "()Ljava/lang/String;", "setRefer", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PageRefreshEvent.kt */
public final class PageRefreshEvent {

    /* renamed from: a */
    private String f31020a;

    public PageRefreshEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "refer");
        this.f31020a = str;
    }

    public final String getRefer() {
        return this.f31020a;
    }

    public final void setRefer(String str) {
        this.f31020a = str;
    }
}
