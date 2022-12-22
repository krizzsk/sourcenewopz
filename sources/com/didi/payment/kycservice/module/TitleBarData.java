package com.didi.payment.kycservice.module;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/payment/kycservice/module/TitleBarData;", "", "topTitleTxt", "", "mainTitleTxt", "subTitleTxt", "isHideBack", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setHideBack", "(Z)V", "getMainTitleTxt", "()Ljava/lang/String;", "setMainTitleTxt", "(Ljava/lang/String;)V", "getSubTitleTxt", "setSubTitleTxt", "getTopTitleTxt", "setTopTitleTxt", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTitleBarModule.kt */
public final class TitleBarData {

    /* renamed from: a */
    private String f30907a;

    /* renamed from: b */
    private String f30908b;

    /* renamed from: c */
    private String f30909c;

    /* renamed from: d */
    private boolean f30910d;

    public static /* synthetic */ TitleBarData copy$default(TitleBarData titleBarData, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = titleBarData.f30907a;
        }
        if ((i & 2) != 0) {
            str2 = titleBarData.f30908b;
        }
        if ((i & 4) != 0) {
            str3 = titleBarData.f30909c;
        }
        if ((i & 8) != 0) {
            z = titleBarData.f30910d;
        }
        return titleBarData.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.f30907a;
    }

    public final String component2() {
        return this.f30908b;
    }

    public final String component3() {
        return this.f30909c;
    }

    public final boolean component4() {
        return this.f30910d;
    }

    public final TitleBarData copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "topTitleTxt");
        Intrinsics.checkNotNullParameter(str2, "mainTitleTxt");
        Intrinsics.checkNotNullParameter(str3, "subTitleTxt");
        return new TitleBarData(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TitleBarData)) {
            return false;
        }
        TitleBarData titleBarData = (TitleBarData) obj;
        return Intrinsics.areEqual((Object) this.f30907a, (Object) titleBarData.f30907a) && Intrinsics.areEqual((Object) this.f30908b, (Object) titleBarData.f30908b) && Intrinsics.areEqual((Object) this.f30909c, (Object) titleBarData.f30909c) && this.f30910d == titleBarData.f30910d;
    }

    public int hashCode() {
        int hashCode = ((((this.f30907a.hashCode() * 31) + this.f30908b.hashCode()) * 31) + this.f30909c.hashCode()) * 31;
        boolean z = this.f30910d;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "TitleBarData(topTitleTxt=" + this.f30907a + ", mainTitleTxt=" + this.f30908b + ", subTitleTxt=" + this.f30909c + ", isHideBack=" + this.f30910d + VersionRange.RIGHT_OPEN;
    }

    public TitleBarData(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "topTitleTxt");
        Intrinsics.checkNotNullParameter(str2, "mainTitleTxt");
        Intrinsics.checkNotNullParameter(str3, "subTitleTxt");
        this.f30907a = str;
        this.f30908b = str2;
        this.f30909c = str3;
        this.f30910d = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TitleBarData(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : z);
    }

    public final String getTopTitleTxt() {
        return this.f30907a;
    }

    public final void setTopTitleTxt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30907a = str;
    }

    public final String getMainTitleTxt() {
        return this.f30908b;
    }

    public final void setMainTitleTxt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30908b = str;
    }

    public final String getSubTitleTxt() {
        return this.f30909c;
    }

    public final void setSubTitleTxt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f30909c = str;
    }

    public final boolean isHideBack() {
        return this.f30910d;
    }

    public final void setHideBack(boolean z) {
        this.f30910d = z;
    }
}
