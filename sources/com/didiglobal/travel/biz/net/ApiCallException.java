package com.didiglobal.travel.biz.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didiglobal/travel/biz/net/ApiCallException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errNo", "", "message", "", "throwable", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getErrNo", "()I", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Exceptions.kt */
public final class ApiCallException extends RuntimeException {
    private final int errNo;

    public ApiCallException(int i) {
        this(i, (String) null, (Throwable) null, 6, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ApiCallException(int i, String str) {
        this(i, str, (Throwable) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "message");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApiCallException(int i, String str, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, "message");
        this.errNo = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApiCallException(int i, String str, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : th);
    }

    public final int getErrNo() {
        return this.errNo;
    }
}
