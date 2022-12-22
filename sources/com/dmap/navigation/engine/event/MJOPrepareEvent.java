package com.dmap.navigation.engine.event;

import java.math.BigInteger;

public class MJOPrepareEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51924a;

    /* renamed from: b */
    private final long f51925b;

    /* renamed from: c */
    private final String f51926c;

    /* renamed from: d */
    private final BigInteger f51927d;

    public MJOPrepareEvent(int i) {
        this(i, 0, (String) null, BigInteger.valueOf(0));
    }

    public MJOPrepareEvent(int i, long j, String str, BigInteger bigInteger) {
        this.f51924a = i;
        this.f51925b = j;
        this.f51926c = str;
        this.f51927d = bigInteger;
    }

    public String toString() {
        return "MjoEvent{updateType=" + this.f51924a + ", mjoId=" + this.f51925b + ", url='" + this.f51926c + '\'' + ", linkId=" + this.f51927d + '}';
    }

    public int getUpdateType() {
        return this.f51924a;
    }

    public long getMjoId() {
        return this.f51925b;
    }

    public String getUrl() {
        return this.f51926c;
    }

    public BigInteger getLinkId() {
        return this.f51927d;
    }
}
