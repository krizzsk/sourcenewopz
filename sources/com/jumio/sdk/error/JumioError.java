package com.jumio.sdk.error;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0015"}, mo175978d2 = {"Lcom/jumio/sdk/error/JumioError;", "Ljava/io/Serializable;", "", "a", "Z", "isRetryable", "()Z", "", "b", "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "domain", "c", "getCode", "code", "d", "getMessage", "message", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioError.kt */
public final class JumioError implements Serializable {

    /* renamed from: a */
    public final boolean f55088a;

    /* renamed from: b */
    public final String f55089b;

    /* renamed from: c */
    public final String f55090c;

    /* renamed from: d */
    public final String f55091d;

    public JumioError(boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "domain");
        Intrinsics.checkNotNullParameter(str2, "code");
        Intrinsics.checkNotNullParameter(str3, "message");
        this.f55088a = z;
        this.f55089b = str;
        this.f55090c = str2;
        this.f55091d = str3;
    }

    public final String getCode() {
        return this.f55090c;
    }

    public final String getDomain() {
        return this.f55089b;
    }

    public final String getMessage() {
        return this.f55091d;
    }

    public final boolean isRetryable() {
        return this.f55088a;
    }
}
