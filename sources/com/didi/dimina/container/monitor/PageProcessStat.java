package com.didi.dimina.container.monitor;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/dimina/container/monitor/PageProcessStat;", "", "()V", "pageCreateMemory", "", "pageCreatePower", "", "timestamp", "(JFJ)V", "getPageCreateMemory", "()J", "setPageCreateMemory", "(J)V", "getPageCreatePower", "()F", "setPageCreatePower", "(F)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DeviceMonitor.kt */
public final class PageProcessStat {

    /* renamed from: a */
    private long f16958a;

    /* renamed from: b */
    private float f16959b;

    /* renamed from: c */
    private long f16960c;

    public static /* synthetic */ PageProcessStat copy$default(PageProcessStat pageProcessStat, long j, float f, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pageProcessStat.f16958a;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            f = pageProcessStat.f16959b;
        }
        float f2 = f;
        if ((i & 4) != 0) {
            j2 = pageProcessStat.f16960c;
        }
        return pageProcessStat.copy(j3, f2, j2);
    }

    public final long component1() {
        return this.f16958a;
    }

    public final float component2() {
        return this.f16959b;
    }

    public final long component3() {
        return this.f16960c;
    }

    public final PageProcessStat copy(long j, float f, long j2) {
        return new PageProcessStat(j, f, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageProcessStat)) {
            return false;
        }
        PageProcessStat pageProcessStat = (PageProcessStat) obj;
        return this.f16958a == pageProcessStat.f16958a && Float.compare(this.f16959b, pageProcessStat.f16959b) == 0 && this.f16960c == pageProcessStat.f16960c;
    }

    public int hashCode() {
        long j = this.f16958a;
        long j2 = this.f16960c;
        return (((((int) (j ^ (j >>> 32))) * 31) + Float.floatToIntBits(this.f16959b)) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "PageProcessStat(pageCreateMemory=" + this.f16958a + ", pageCreatePower=" + this.f16959b + ", timestamp=" + this.f16960c + ")";
    }

    public PageProcessStat(long j, float f, long j2) {
        this.f16958a = j;
        this.f16959b = f;
        this.f16960c = j2;
    }

    public final long getPageCreateMemory() {
        return this.f16958a;
    }

    public final float getPageCreatePower() {
        return this.f16959b;
    }

    public final long getTimestamp() {
        return this.f16960c;
    }

    public final void setPageCreateMemory(long j) {
        this.f16958a = j;
    }

    public final void setPageCreatePower(float f) {
        this.f16959b = f;
    }

    public final void setTimestamp(long j) {
        this.f16960c = j;
    }

    public PageProcessStat() {
        this(0, 0.0f, System.currentTimeMillis());
    }
}
