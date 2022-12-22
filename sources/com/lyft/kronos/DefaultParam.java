package com.lyft.kronos;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, mo175978d2 = {"Lcom/lyft/kronos/DefaultParam;", "", "()V", "CACHE_EXPIRATION_MS", "", "getCACHE_EXPIRATION_MS", "()J", "MAX_NTP_RESPONSE_TIME_MS", "getMAX_NTP_RESPONSE_TIME_MS", "MIN_WAIT_TIME_BETWEEN_SYNC_MS", "getMIN_WAIT_TIME_BETWEEN_SYNC_MS", "NTP_HOSTS", "", "", "getNTP_HOSTS", "()Ljava/util/List;", "TIMEOUT_MS", "getTIMEOUT_MS", "kronos-java"}, mo175979k = 1, mo175980mv = {1, 4, 0})
/* compiled from: DefaultParam.kt */
public final class DefaultParam {
    public static final DefaultParam INSTANCE = new DefaultParam();

    /* renamed from: a */
    private static final List<String> f55651a = CollectionsKt.listOf("0.pool.ntp.org", "1.pool.ntp.org", "2.pool.ntp.org", "3.pool.ntp.org");

    /* renamed from: b */
    private static final long f55652b = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: c */
    private static final long f55653c = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: d */
    private static final long f55654d = TimeUnit.SECONDS.toMillis(6);

    /* renamed from: e */
    private static final long f55655e = TimeUnit.SECONDS.toMillis(5);

    private DefaultParam() {
    }

    public final List<String> getNTP_HOSTS() {
        return f55651a;
    }

    public final long getCACHE_EXPIRATION_MS() {
        return f55652b;
    }

    public final long getMIN_WAIT_TIME_BETWEEN_SYNC_MS() {
        return f55653c;
    }

    public final long getTIMEOUT_MS() {
        return f55654d;
    }

    public final long getMAX_NTP_RESPONSE_TIME_MS() {
        return f55655e;
    }
}
