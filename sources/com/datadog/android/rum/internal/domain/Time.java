package com.datadog.android.rum.internal.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/Time;", "", "timestamp", "", "nanoTime", "(JJ)V", "getNanoTime", "()J", "getTimestamp", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Time.kt */
public final class Time {

    /* renamed from: a */
    private final long f3695a;

    /* renamed from: b */
    private final long f3696b;

    public Time() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Time copy$default(Time time, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = time.f3695a;
        }
        if ((i & 2) != 0) {
            j2 = time.f3696b;
        }
        return time.copy(j, j2);
    }

    public final long component1() {
        return this.f3695a;
    }

    public final long component2() {
        return this.f3696b;
    }

    public final Time copy(long j, long j2) {
        return new Time(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Time)) {
            return false;
        }
        Time time = (Time) obj;
        return this.f3695a == time.f3695a && this.f3696b == time.f3696b;
    }

    public int hashCode() {
        return (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3695a) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3696b);
    }

    public String toString() {
        return "Time(timestamp=" + this.f3695a + ", nanoTime=" + this.f3696b + VersionRange.RIGHT_OPEN;
    }

    public Time(long j, long j2) {
        this.f3695a = j;
        this.f3696b = j2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Time(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? System.currentTimeMillis() : j, (i & 2) != 0 ? System.nanoTime() : j2);
    }

    public final long getTimestamp() {
        return this.f3695a;
    }

    public final long getNanoTime() {
        return this.f3696b;
    }
}
