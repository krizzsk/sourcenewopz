package com.didi.soda.customer.foundation.tracker;

import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/tracker/TraceInfo;", "", "tag", "", "stage", "", "beginTime", "", "duration", "(Ljava/lang/String;IJI)V", "getBeginTime", "()J", "getDuration", "()I", "setDuration", "(I)V", "getStage", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.foundation.tracker.a */
/* compiled from: LaunchAppTracker.kt */
final class C13758a {

    /* renamed from: a */
    private final String f41095a;

    /* renamed from: b */
    private final int f41096b;

    /* renamed from: c */
    private final long f41097c;

    /* renamed from: d */
    private int f41098d;

    /* renamed from: a */
    public static /* synthetic */ C13758a m29159a(C13758a aVar, String str, int i, long j, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = aVar.f41095a;
        }
        if ((i3 & 2) != 0) {
            i = aVar.f41096b;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            j = aVar.f41097c;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            i2 = aVar.f41098d;
        }
        return aVar.mo104910a(str, i4, j2, i2);
    }

    /* renamed from: a */
    public final C13758a mo104910a(String str, int i, long j, int i2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        return new C13758a(str, i, j, i2);
    }

    /* renamed from: e */
    public final String mo104916e() {
        return this.f41095a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13758a)) {
            return false;
        }
        C13758a aVar = (C13758a) obj;
        return Intrinsics.areEqual((Object) this.f41095a, (Object) aVar.f41095a) && this.f41096b == aVar.f41096b && this.f41097c == aVar.f41097c && this.f41098d == aVar.f41098d;
    }

    /* renamed from: f */
    public final int mo104918f() {
        return this.f41096b;
    }

    /* renamed from: g */
    public final long mo104919g() {
        return this.f41097c;
    }

    /* renamed from: h */
    public final int mo104920h() {
        return this.f41098d;
    }

    public int hashCode() {
        return (((((this.f41095a.hashCode() * 31) + this.f41096b) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f41097c)) * 31) + this.f41098d;
    }

    public C13758a(String str, int i, long j, int i2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        this.f41095a = str;
        this.f41096b = i;
        this.f41097c = j;
        this.f41098d = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C13758a(String str, int i, long j, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0 : i, j, i2);
    }

    /* renamed from: a */
    public final String mo104911a() {
        return this.f41095a;
    }

    /* renamed from: b */
    public final int mo104913b() {
        return this.f41096b;
    }

    /* renamed from: c */
    public final long mo104914c() {
        return this.f41097c;
    }

    /* renamed from: a */
    public final void mo104912a(int i) {
        this.f41098d = i;
    }

    /* renamed from: d */
    public final int mo104915d() {
        return this.f41098d;
    }

    public String toString() {
        if (!LaunchAppTrackerKt.f41088a) {
            return super.toString();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss SSS");
        return "stage=" + this.f41096b + " tag = " + this.f41095a + " beginTime = " + simpleDateFormat.format(new Date(this.f41097c)) + " duration = " + this.f41098d + ' ';
    }
}
