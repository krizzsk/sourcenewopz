package com.datadog.android.rum.internal.domain.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006+"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "", "dnsStart", "", "dnsDuration", "connectStart", "connectDuration", "sslStart", "sslDuration", "firstByteStart", "firstByteDuration", "downloadStart", "downloadDuration", "(JJJJJJJJJJ)V", "getConnectDuration", "()J", "getConnectStart", "getDnsDuration", "getDnsStart", "getDownloadDuration", "getDownloadStart", "getFirstByteDuration", "getFirstByteStart", "getSslDuration", "getSslStart", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ResourceTiming.kt */
public final class ResourceTiming {

    /* renamed from: a */
    private final long f3697a;

    /* renamed from: b */
    private final long f3698b;

    /* renamed from: c */
    private final long f3699c;

    /* renamed from: d */
    private final long f3700d;

    /* renamed from: e */
    private final long f3701e;

    /* renamed from: f */
    private final long f3702f;

    /* renamed from: g */
    private final long f3703g;

    /* renamed from: h */
    private final long f3704h;

    /* renamed from: i */
    private final long f3705i;

    /* renamed from: j */
    private final long f3706j;

    public ResourceTiming() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ResourceTiming copy$default(ResourceTiming resourceTiming, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int i, Object obj) {
        ResourceTiming resourceTiming2 = resourceTiming;
        int i2 = i;
        return resourceTiming.copy((i2 & 1) != 0 ? resourceTiming2.f3697a : j, (i2 & 2) != 0 ? resourceTiming2.f3698b : j2, (i2 & 4) != 0 ? resourceTiming2.f3699c : j3, (i2 & 8) != 0 ? resourceTiming2.f3700d : j4, (i2 & 16) != 0 ? resourceTiming2.f3701e : j5, (i2 & 32) != 0 ? resourceTiming2.f3702f : j6, (i2 & 64) != 0 ? resourceTiming2.f3703g : j7, (i2 & 128) != 0 ? resourceTiming2.f3704h : j8, (i2 & 256) != 0 ? resourceTiming2.f3705i : j9, (i2 & 512) != 0 ? resourceTiming2.f3706j : j10);
    }

    public final long component1() {
        return this.f3697a;
    }

    public final long component10() {
        return this.f3706j;
    }

    public final long component2() {
        return this.f3698b;
    }

    public final long component3() {
        return this.f3699c;
    }

    public final long component4() {
        return this.f3700d;
    }

    public final long component5() {
        return this.f3701e;
    }

    public final long component6() {
        return this.f3702f;
    }

    public final long component7() {
        return this.f3703g;
    }

    public final long component8() {
        return this.f3704h;
    }

    public final long component9() {
        return this.f3705i;
    }

    public final ResourceTiming copy(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        return new ResourceTiming(j, j2, j3, j4, j5, j6, j7, j8, j9, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceTiming)) {
            return false;
        }
        ResourceTiming resourceTiming = (ResourceTiming) obj;
        return this.f3697a == resourceTiming.f3697a && this.f3698b == resourceTiming.f3698b && this.f3699c == resourceTiming.f3699c && this.f3700d == resourceTiming.f3700d && this.f3701e == resourceTiming.f3701e && this.f3702f == resourceTiming.f3702f && this.f3703g == resourceTiming.f3703g && this.f3704h == resourceTiming.f3704h && this.f3705i == resourceTiming.f3705i && this.f3706j == resourceTiming.f3706j;
    }

    public int hashCode() {
        return (((((((((((((((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3697a) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3698b)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3699c)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3700d)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3701e)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3702f)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3703g)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3704h)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3705i)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3706j);
    }

    public String toString() {
        return "ResourceTiming(dnsStart=" + this.f3697a + ", dnsDuration=" + this.f3698b + ", connectStart=" + this.f3699c + ", connectDuration=" + this.f3700d + ", sslStart=" + this.f3701e + ", sslDuration=" + this.f3702f + ", firstByteStart=" + this.f3703g + ", firstByteDuration=" + this.f3704h + ", downloadStart=" + this.f3705i + ", downloadDuration=" + this.f3706j + VersionRange.RIGHT_OPEN;
    }

    public ResourceTiming(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.f3697a = j;
        this.f3698b = j2;
        this.f3699c = j3;
        this.f3700d = j4;
        this.f3701e = j5;
        this.f3702f = j6;
        this.f3703g = j7;
        this.f3704h = j8;
        this.f3705i = j9;
        this.f3706j = j10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ResourceTiming(long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41, int r43, kotlin.jvm.internal.DefaultConstructorMarker r44) {
        /*
            r22 = this;
            r0 = r43
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r4 = r2
            goto L_0x000c
        L_0x000a:
            r4 = r23
        L_0x000c:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0012
            r6 = r2
            goto L_0x0014
        L_0x0012:
            r6 = r25
        L_0x0014:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x001a
            r8 = r2
            goto L_0x001c
        L_0x001a:
            r8 = r27
        L_0x001c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0022
            r10 = r2
            goto L_0x0024
        L_0x0022:
            r10 = r29
        L_0x0024:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002a
            r12 = r2
            goto L_0x002c
        L_0x002a:
            r12 = r31
        L_0x002c:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0032
            r14 = r2
            goto L_0x0034
        L_0x0032:
            r14 = r33
        L_0x0034:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x003b
            r16 = r2
            goto L_0x003d
        L_0x003b:
            r16 = r35
        L_0x003d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0044
            r18 = r2
            goto L_0x0046
        L_0x0044:
            r18 = r37
        L_0x0046:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004d
            r20 = r2
            goto L_0x004f
        L_0x004d:
            r20 = r39
        L_0x004f:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r2 = r41
        L_0x0056:
            r23 = r22
            r24 = r4
            r26 = r6
            r28 = r8
            r30 = r10
            r32 = r12
            r34 = r14
            r36 = r16
            r38 = r18
            r40 = r20
            r42 = r2
            r23.<init>(r24, r26, r28, r30, r32, r34, r36, r38, r40, r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.internal.domain.event.ResourceTiming.<init>(long, long, long, long, long, long, long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getDnsStart() {
        return this.f3697a;
    }

    public final long getDnsDuration() {
        return this.f3698b;
    }

    public final long getConnectStart() {
        return this.f3699c;
    }

    public final long getConnectDuration() {
        return this.f3700d;
    }

    public final long getSslStart() {
        return this.f3701e;
    }

    public final long getSslDuration() {
        return this.f3702f;
    }

    public final long getFirstByteStart() {
        return this.f3703g;
    }

    public final long getFirstByteDuration() {
        return this.f3704h;
    }

    public final long getDownloadStart() {
        return this.f3705i;
    }

    public final long getDownloadDuration() {
        return this.f3706j;
    }
}
