package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common;

import java.util.concurrent.TimeUnit;

public final class ConnectionState {
    public static final ConnectionState NULL = new ConnectionState();

    /* renamed from: a */
    private final Object f47906a;

    /* renamed from: b */
    private final String f47907b;

    /* renamed from: c */
    private final long f47908c;

    /* renamed from: d */
    private final long f47909d;

    /* renamed from: e */
    private final TimeUnit f47910e;

    /* renamed from: f */
    private final long f47911f;

    /* renamed from: g */
    private final TimeUnit f47912g;

    /* renamed from: h */
    private final long f47913h;

    /* renamed from: i */
    private final int f47914i;

    /* renamed from: j */
    private final int f47915j;

    /* renamed from: k */
    private final boolean f47916k;

    /* renamed from: l */
    private final int f47917l;

    private ConnectionState() {
        this.f47906a = null;
        this.f47907b = null;
        this.f47908c = 0;
        this.f47909d = 60;
        this.f47910e = TimeUnit.SECONDS;
        this.f47911f = 600;
        this.f47912g = TimeUnit.SECONDS;
        this.f47913h = 1000;
        this.f47914i = 50;
        this.f47915j = 1024;
        this.f47916k = true;
        this.f47917l = 10;
    }

    public ConnectionState(Object obj, String str, long j, long j2, TimeUnit timeUnit, long j3, TimeUnit timeUnit2, long j4, int i, int i2, boolean z, int i3) {
        this.f47906a = obj;
        this.f47907b = str;
        this.f47908c = j;
        this.f47909d = j2;
        this.f47910e = timeUnit;
        this.f47911f = j3;
        this.f47912g = timeUnit2;
        this.f47913h = j4;
        this.f47914i = i;
        this.f47915j = i2;
        this.f47916k = z;
        this.f47917l = i3;
    }

    public Object getDataToken() {
        return this.f47906a;
    }

    public String getCrossProcessId() {
        return this.f47907b;
    }

    public long getServerTimestamp() {
        return this.f47908c;
    }

    public long getHarvestIntervalInSeconds() {
        return TimeUnit.SECONDS.convert(this.f47909d, this.f47910e);
    }

    public long getHarvestIntervalInMilliseconds() {
        return TimeUnit.MILLISECONDS.convert(this.f47909d, this.f47910e);
    }

    public long getMaxTransactionAgeInSeconds() {
        return TimeUnit.SECONDS.convert(this.f47911f, this.f47912g);
    }

    public long getMaxTransactionAgeInMilliseconds() {
        return TimeUnit.MILLISECONDS.convert(this.f47911f, this.f47912g);
    }

    public long getMaxTransactionCount() {
        return this.f47913h;
    }

    public int getStackTraceLimit() {
        return this.f47914i;
    }

    public int getResponseBodyLimit() {
        return this.f47915j;
    }

    public boolean isCollectingNetworkErrors() {
        return this.f47916k;
    }

    public int getErrorLimit() {
        return this.f47917l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f47906a);
        return sb.toString();
    }
}
