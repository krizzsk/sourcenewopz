package com.didi.soda.business.component.dynamic;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/business/component/dynamic/BusinessPayload;", "Ljava/io/Serializable;", "()V", "mRecId", "", "getMRecId", "()Ljava/lang/String;", "setMRecId", "(Ljava/lang/String;)V", "mTraceId", "getMTraceId", "setMTraceId", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessPayload.kt */
public final class BusinessPayload implements Serializable {
    public static final BusinessPayload INSTANCE = new BusinessPayload();
    private static String mRecId = "";
    private static String mTraceId = "";
    private static final long serialVersionUID = -2711154146908374990L;

    private BusinessPayload() {
    }

    public final String getMRecId() {
        return mRecId;
    }

    public final void setMRecId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mRecId = str;
    }

    public final String getMTraceId() {
        return mTraceId;
    }

    public final void setMTraceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mTraceId = str;
    }
}
