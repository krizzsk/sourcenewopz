package com.global.didi.elvish.datetime.model;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010JR\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\b\u001a\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010%\u001a\u00020\u0003H\u0016J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006'"}, mo175978d2 = {"Lcom/global/didi/elvish/datetime/model/DTPattern;", "", "is24", "", "patterns", "", "", "duration", "alias", "amPmMarkers", "(I[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "setAlias", "(Ljava/lang/String;)V", "getAmPmMarkers", "()[Ljava/lang/String;", "setAmPmMarkers", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getDuration", "setDuration", "()I", "set24", "(I)V", "getPatterns", "setPatterns", "component1", "component2", "component3", "component4", "component5", "copy", "(I[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/global/didi/elvish/datetime/model/DTPattern;", "equals", "", "other", "hashCode", "toString", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: DTPatternsModel.kt */
public final class DTPattern {
    @SerializedName("alias")
    private String alias;
    @SerializedName("amPmMarkers")
    private String[] amPmMarkers;
    @SerializedName("duration")
    private String[] duration;
    @SerializedName("is24")
    private int is24;
    @SerializedName("dateTimePatterns")
    private String[] patterns;

    public DTPattern() {
        this(0, (String[]) null, (String[]) null, (String) null, (String[]) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DTPattern copy$default(DTPattern dTPattern, int i, String[] strArr, String[] strArr2, String str, String[] strArr3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dTPattern.is24;
        }
        if ((i2 & 2) != 0) {
            strArr = dTPattern.patterns;
        }
        String[] strArr4 = strArr;
        if ((i2 & 4) != 0) {
            strArr2 = dTPattern.duration;
        }
        String[] strArr5 = strArr2;
        if ((i2 & 8) != 0) {
            str = dTPattern.alias;
        }
        String str2 = str;
        if ((i2 & 16) != 0) {
            strArr3 = dTPattern.amPmMarkers;
        }
        return dTPattern.copy(i, strArr4, strArr5, str2, strArr3);
    }

    public final int component1() {
        return this.is24;
    }

    public final String[] component2() {
        return this.patterns;
    }

    public final String[] component3() {
        return this.duration;
    }

    public final String component4() {
        return this.alias;
    }

    public final String[] component5() {
        return this.amPmMarkers;
    }

    public final DTPattern copy(int i, String[] strArr, String[] strArr2, String str, String[] strArr3) {
        Intrinsics.checkParameterIsNotNull(strArr, "patterns");
        Intrinsics.checkParameterIsNotNull(strArr2, "duration");
        Intrinsics.checkParameterIsNotNull(str, "alias");
        Intrinsics.checkParameterIsNotNull(strArr3, "amPmMarkers");
        return new DTPattern(i, strArr, strArr2, str, strArr3);
    }

    public String toString() {
        return "DTPattern(is24=" + this.is24 + ", patterns=" + Arrays.toString(this.patterns) + ", duration=" + Arrays.toString(this.duration) + ", alias=" + this.alias + ", amPmMarkers=" + Arrays.toString(this.amPmMarkers) + ")";
    }

    public DTPattern(int i, String[] strArr, String[] strArr2, String str, String[] strArr3) {
        Intrinsics.checkParameterIsNotNull(strArr, "patterns");
        Intrinsics.checkParameterIsNotNull(strArr2, "duration");
        Intrinsics.checkParameterIsNotNull(str, "alias");
        Intrinsics.checkParameterIsNotNull(strArr3, "amPmMarkers");
        this.is24 = i;
        this.patterns = strArr;
        this.duration = strArr2;
        this.alias = str;
        this.amPmMarkers = strArr3;
    }

    public final int is24() {
        return this.is24;
    }

    public final void set24(int i) {
        this.is24 = i;
    }

    public final String[] getPatterns() {
        return this.patterns;
    }

    public final void setPatterns(String[] strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "<set-?>");
        this.patterns = strArr;
    }

    public final String[] getDuration() {
        return this.duration;
    }

    public final void setDuration(String[] strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "<set-?>");
        this.duration = strArr;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final void setAlias(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.alias = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DTPattern(int r5, java.lang.String[] r6, java.lang.String[] r7, java.lang.String r8, java.lang.String[] r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = 0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            java.lang.String[] r6 = new java.lang.String[r0]
        L_0x000e:
            r1 = r6
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            java.lang.String[] r7 = new java.lang.String[r0]
        L_0x0015:
            r2 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            java.lang.String r8 = ""
        L_0x001c:
            r3 = r8
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            java.lang.String[] r9 = new java.lang.String[r0]
        L_0x0023:
            r10 = r9
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.global.didi.elvish.datetime.model.DTPattern.<init>(int, java.lang.String[], java.lang.String[], java.lang.String, java.lang.String[], int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String[] getAmPmMarkers() {
        return this.amPmMarkers;
    }

    public final void setAmPmMarkers(String[] strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "<set-?>");
        this.amPmMarkers = strArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            DTPattern dTPattern = (DTPattern) obj;
            if (this.is24 == dTPattern.is24 && Arrays.equals(this.patterns, dTPattern.patterns) && Arrays.equals(this.duration, dTPattern.duration) && !(!Intrinsics.areEqual((Object) this.alias, (Object) dTPattern.alias)) && Arrays.equals(this.amPmMarkers, dTPattern.amPmMarkers)) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.global.didi.elvish.datetime.model.DTPattern");
    }

    public int hashCode() {
        return (((((((this.is24 * 31) + Arrays.hashCode(this.patterns)) * 31) + Arrays.hashCode(this.duration)) * 31) + this.alias.hashCode()) * 31) + Arrays.hashCode(this.amPmMarkers);
    }
}
