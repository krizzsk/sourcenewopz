package com.didi.soda.home.topgun.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J=\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006&"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeBusinessGridConfig;", "", "maxRow", "", "divider", "", "itemSpace", "lineSpace", "", "showDividerIndex", "(ILjava/lang/String;IFI)V", "getDivider", "()Ljava/lang/String;", "setDivider", "(Ljava/lang/String;)V", "getItemSpace", "()I", "setItemSpace", "(I)V", "getLineSpace", "()F", "setLineSpace", "(F)V", "getMaxRow", "setMaxRow", "getShowDividerIndex", "setShowDividerIndex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeBusinessGrid.kt */
public final class HomeBusinessGridConfig {

    /* renamed from: a */
    private int f43086a;

    /* renamed from: b */
    private String f43087b;

    /* renamed from: c */
    private int f43088c;

    /* renamed from: d */
    private float f43089d;

    /* renamed from: e */
    private int f43090e;

    public HomeBusinessGridConfig() {
        this(0, (String) null, 0, 0.0f, 0, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HomeBusinessGridConfig copy$default(HomeBusinessGridConfig homeBusinessGridConfig, int i, String str, int i2, float f, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = homeBusinessGridConfig.f43086a;
        }
        if ((i4 & 2) != 0) {
            str = homeBusinessGridConfig.f43087b;
        }
        String str2 = str;
        if ((i4 & 4) != 0) {
            i2 = homeBusinessGridConfig.f43088c;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            f = homeBusinessGridConfig.f43089d;
        }
        float f2 = f;
        if ((i4 & 16) != 0) {
            i3 = homeBusinessGridConfig.f43090e;
        }
        return homeBusinessGridConfig.copy(i, str2, i5, f2, i3);
    }

    public final int component1() {
        return this.f43086a;
    }

    public final String component2() {
        return this.f43087b;
    }

    public final int component3() {
        return this.f43088c;
    }

    public final float component4() {
        return this.f43089d;
    }

    public final int component5() {
        return this.f43090e;
    }

    public final HomeBusinessGridConfig copy(int i, String str, int i2, float f, int i3) {
        return new HomeBusinessGridConfig(i, str, i2, f, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeBusinessGridConfig)) {
            return false;
        }
        HomeBusinessGridConfig homeBusinessGridConfig = (HomeBusinessGridConfig) obj;
        return this.f43086a == homeBusinessGridConfig.f43086a && Intrinsics.areEqual((Object) this.f43087b, (Object) homeBusinessGridConfig.f43087b) && this.f43088c == homeBusinessGridConfig.f43088c && Intrinsics.areEqual((Object) Float.valueOf(this.f43089d), (Object) Float.valueOf(homeBusinessGridConfig.f43089d)) && this.f43090e == homeBusinessGridConfig.f43090e;
    }

    public int hashCode() {
        int i = this.f43086a * 31;
        String str = this.f43087b;
        return ((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.f43088c) * 31) + Float.floatToIntBits(this.f43089d)) * 31) + this.f43090e;
    }

    public String toString() {
        return "HomeBusinessGridConfig(maxRow=" + this.f43086a + ", divider=" + this.f43087b + ", itemSpace=" + this.f43088c + ", lineSpace=" + this.f43089d + ", showDividerIndex=" + this.f43090e + VersionRange.RIGHT_OPEN;
    }

    public HomeBusinessGridConfig(int i, String str, int i2, float f, int i3) {
        this.f43086a = i;
        this.f43087b = str;
        this.f43088c = i2;
        this.f43089d = f;
        this.f43090e = i3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HomeBusinessGridConfig(int r4, java.lang.String r5, int r6, float r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0005
            r4 = 1
        L_0x0005:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000a
            r5 = 0
        L_0x000a:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0012
            r6 = 0
            r0 = 0
            goto L_0x0013
        L_0x0012:
            r0 = r6
        L_0x0013:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            r7 = 0
            r1 = 0
            goto L_0x001b
        L_0x001a:
            r1 = r7
        L_0x001b:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0022
            r8 = -1
            r2 = -1
            goto L_0x0023
        L_0x0022:
            r2 = r8
        L_0x0023:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HomeBusinessGridConfig.<init>(int, java.lang.String, int, float, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getMaxRow() {
        return this.f43086a;
    }

    public final void setMaxRow(int i) {
        this.f43086a = i;
    }

    public final String getDivider() {
        return this.f43087b;
    }

    public final void setDivider(String str) {
        this.f43087b = str;
    }

    public final int getItemSpace() {
        return this.f43088c;
    }

    public final void setItemSpace(int i) {
        this.f43088c = i;
    }

    public final float getLineSpace() {
        return this.f43089d;
    }

    public final void setLineSpace(float f) {
        this.f43089d = f;
    }

    public final int getShowDividerIndex() {
        return this.f43090e;
    }

    public final void setShowDividerIndex(int i) {
        this.f43090e = i;
    }
}
