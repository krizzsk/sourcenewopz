package com.datadog.android.rum.internal.domain.scope;

import kotlin.Metadata;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/scope/Timing;", "", "startTime", "", "duration", "(JJ)V", "getDuration", "()J", "getStartTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.datadog.android.rum.internal.domain.scope.a */
/* compiled from: ExternalResourceTimings.kt */
final class C2199a {

    /* renamed from: a */
    private final long f3828a;

    /* renamed from: b */
    private final long f3829b;

    /* renamed from: a */
    public static /* synthetic */ C2199a m2475a(C2199a aVar, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = aVar.f3828a;
        }
        if ((i & 2) != 0) {
            j2 = aVar.f3829b;
        }
        return aVar.mo20829a(j, j2);
    }

    /* renamed from: a */
    public final C2199a mo20829a(long j, long j2) {
        return new C2199a(j, j2);
    }

    /* renamed from: c */
    public final long mo20831c() {
        return this.f3828a;
    }

    /* renamed from: d */
    public final long mo20832d() {
        return this.f3829b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2199a)) {
            return false;
        }
        C2199a aVar = (C2199a) obj;
        return this.f3828a == aVar.f3828a && this.f3829b == aVar.f3829b;
    }

    public int hashCode() {
        return (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3828a) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3829b);
    }

    public String toString() {
        return "Timing(startTime=" + this.f3828a + ", duration=" + this.f3829b + VersionRange.RIGHT_OPEN;
    }

    public C2199a(long j, long j2) {
        this.f3828a = j;
        this.f3829b = j2;
    }

    /* renamed from: a */
    public final long mo20828a() {
        return this.f3828a;
    }

    /* renamed from: b */
    public final long mo20830b() {
        return this.f3829b;
    }
}
