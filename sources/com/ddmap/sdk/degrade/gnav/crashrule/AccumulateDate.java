package com.ddmap.sdk.degrade.gnav.crashrule;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/ddmap/sdk/degrade/gnav/crashrule/AccumulateDate;", "", "firstCrashTimeMillis", "", "accumulateCounts", "", "(JI)V", "getAccumulateCounts", "()I", "getFirstCrashTimeMillis", "()J", "Degrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: AccumulateDate.kt */
public final class AccumulateDate {

    /* renamed from: a */
    private final long f4297a;

    /* renamed from: b */
    private final int f4298b;

    public AccumulateDate(long j, int i) {
        this.f4297a = j;
        this.f4298b = i;
    }

    public final long getFirstCrashTimeMillis() {
        return this.f4297a;
    }

    public final int getAccumulateCounts() {
        return this.f4298b;
    }
}
