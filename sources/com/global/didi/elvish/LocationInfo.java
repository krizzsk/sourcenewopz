package com.global.didi.elvish;

import android.text.TextUtils;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006 "}, mo175978d2 = {"Lcom/global/didi/elvish/LocationInfo;", "", "localeString", "", "initLocal", "country", "cityId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCityId", "()Ljava/lang/String;", "setCityId", "(Ljava/lang/String;)V", "getCountry", "setCountry", "getLocaleString", "setLocaleString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getInitLocal", "getLocale", "Ljava/util/Locale;", "hashCode", "", "magicSwitchLocale", "locale", "toString", "elvish_release"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: LocationInfo.kt */
public final class LocationInfo {

    /* renamed from: a */
    private String f52547a;

    /* renamed from: b */
    private String f52548b;

    /* renamed from: c */
    private String f52549c;

    /* renamed from: d */
    private String f52550d;

    /* renamed from: a */
    private final String m37291a() {
        return this.f52548b;
    }

    public static /* synthetic */ LocationInfo copy$default(LocationInfo locationInfo, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = locationInfo.f52547a;
        }
        if ((i & 2) != 0) {
            str2 = locationInfo.f52548b;
        }
        if ((i & 4) != 0) {
            str3 = locationInfo.f52549c;
        }
        if ((i & 8) != 0) {
            str4 = locationInfo.f52550d;
        }
        return locationInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.f52547a;
    }

    public final String component3() {
        return this.f52549c;
    }

    public final String component4() {
        return this.f52550d;
    }

    public final LocationInfo copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "localeString");
        Intrinsics.checkParameterIsNotNull(str3, "country");
        Intrinsics.checkParameterIsNotNull(str4, "cityId");
        return new LocationInfo(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationInfo)) {
            return false;
        }
        LocationInfo locationInfo = (LocationInfo) obj;
        return Intrinsics.areEqual((Object) this.f52547a, (Object) locationInfo.f52547a) && Intrinsics.areEqual((Object) this.f52548b, (Object) locationInfo.f52548b) && Intrinsics.areEqual((Object) this.f52549c, (Object) locationInfo.f52549c) && Intrinsics.areEqual((Object) this.f52550d, (Object) locationInfo.f52550d);
    }

    public int hashCode() {
        String str = this.f52547a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f52548b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f52549c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f52550d;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "LocationInfo(localeString=" + this.f52547a + ", initLocal=" + this.f52548b + ", country=" + this.f52549c + ", cityId=" + this.f52550d + ")";
    }

    public LocationInfo(String str, String str2, String str3, String str4) {
        String str5;
        Intrinsics.checkParameterIsNotNull(str, "localeString");
        Intrinsics.checkParameterIsNotNull(str3, "country");
        Intrinsics.checkParameterIsNotNull(str4, "cityId");
        this.f52547a = str;
        this.f52548b = str2;
        this.f52549c = str3;
        this.f52550d = str4;
        String replace$default = StringsKt.replace$default(str, "_", "-", false, 4, (Object) null);
        this.f52547a = replace$default;
        this.f52547a = m37292a(replace$default, this.f52549c);
        if (this.f52549c.length() > 0) {
            str5 = this.f52549c;
        } else {
            str5 = StringsKt.contains$default((CharSequence) this.f52547a, (CharSequence) "_", false, 2, (Object) null) ? (String) CollectionsKt.last(StringsKt.split$default((CharSequence) this.f52547a, new String[]{"_"}, false, 0, 6, (Object) null)) : "";
        }
        this.f52549c = str5;
    }

    public final String getLocaleString() {
        return this.f52547a;
    }

    public final void setLocaleString(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f52547a = str;
    }

    public final String getCountry() {
        return this.f52549c;
    }

    public final void setCountry(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f52549c = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationInfo(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getCityId() {
        return this.f52550d;
    }

    public final void setCityId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f52550d = str;
    }

    public final Locale getLocale() {
        if (this.f52547a.length() > 0) {
            return new Locale((String) CollectionsKt.first(StringsKt.split$default((CharSequence) this.f52547a, new String[]{"-"}, false, 0, 6, (Object) null)), (String) CollectionsKt.last(StringsKt.split$default((CharSequence) this.f52547a, new String[]{"-"}, false, 0, 6, (Object) null)));
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
        return locale;
    }

    /* renamed from: a */
    private final String m37292a(String str, String str2) {
        if (Intrinsics.areEqual((Object) str, (Object) "es-CO") && Intrinsics.areEqual((Object) str2, (Object) HistoryRecordFragment.COUNTRY_CODE_CR)) {
            return "es-CR";
        }
        if (!Intrinsics.areEqual((Object) str, (Object) "es-CO") || !Intrinsics.areEqual((Object) str2, (Object) HistoryRecordFragment.COUNTRY_CODE_PA)) {
            return (!Intrinsics.areEqual((Object) str, (Object) "es-CO") || !Intrinsics.areEqual((Object) str2, (Object) HistoryRecordFragment.COUNTRY_CODE_DO)) ? str : "es-DO";
        }
        return "es-PA";
    }

    public final String getInitLocal() {
        if (TextUtils.isEmpty(this.f52548b)) {
            return this.f52547a;
        }
        String str = this.f52548b;
        if (str != null) {
            return str;
        }
        Intrinsics.throwNpe();
        return str;
    }
}
