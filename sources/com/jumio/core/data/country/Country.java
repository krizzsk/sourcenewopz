package com.jumio.core.data.country;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003:\u0001*B\u001b\b\u0017\u0012\u0006\u0010#\u001a\u00020\u0012\u0012\b\b\u0002\u0010$\u001a\u00020\n¢\u0006\u0004\b%\u0010&B\u0019\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u0012¢\u0006\u0004\b%\u0010'B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020\r¢\u0006\u0004\b%\u0010)J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\"\u0010\u001a\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0013\u0010\"\u001a\u00020\u001f8F@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006+"}, mo175978d2 = {"Lcom/jumio/core/data/country/Country;", "", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "country", "", "compareTo", "hashCode", "", "another", "", "equals", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "", "toString", "a", "Ljava/lang/String;", "getIsoCode", "()Ljava/lang/String;", "setIsoCode", "(Ljava/lang/String;)V", "isoCode", "b", "getName", "setName", "name", "Ljava/text/CollationKey;", "getCollationKey", "()Ljava/text/CollationKey;", "collationKey", "iso3Code", "localize", "<init>", "(Ljava/lang/String;Z)V", "(Ljava/lang/String;Ljava/lang/String;)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: Country.kt */
public final class Country implements Parcelable, Serializable, Comparable<Country> {
    public static final Parcelable.Creator<Country> CREATOR = new Country$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public String f54669a;

    /* renamed from: b */
    public String f54670b;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/core/data/country/Country$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/jumio/core/data/country/Country;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: Country.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Country(String str) {
        this(str, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "iso3Code");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r1 = com.jumio.sdk.util.IsoCountryConverter.convertToAlpha2(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Country(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "iso3Code"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r3.<init>()
            java.lang.String r0 = ""
            r3.f54669a = r0
            r3.f54670b = r0
            int r1 = r4.length()
            r2 = 3
            if (r1 != r2) goto L_0x001c
            java.lang.String r1 = com.jumio.sdk.util.IsoCountryConverter.convertToAlpha2(r4)
            if (r1 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r0
        L_0x001d:
            if (r5 == 0) goto L_0x0031
            java.util.Locale r5 = new java.util.Locale
            r5.<init>(r0, r1)
            java.lang.String r5 = r5.getDisplayCountry()
            java.lang.String r0 = "Locale(\"\", iso2Code).displayCountry"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r3.mo162611a(r4, r5)
            goto L_0x0044
        L_0x0031:
            java.util.Locale r5 = new java.util.Locale
            r5.<init>(r0, r1)
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r5 = r5.getDisplayCountry(r0)
            java.lang.String r0 = "Locale(\"\", iso2Code).get…ayCountry(Locale.ENGLISH)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r3.mo162611a(r4, r5)
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.data.country.Country.<init>(java.lang.String, boolean):void");
    }

    /* renamed from: a */
    public final void mo162611a(String str, String str2) {
        this.f54669a = str;
        if (Intrinsics.areEqual((Object) str2, (Object) "")) {
            this.f54670b = str;
        } else {
            this.f54670b = str2;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Country)) {
            return false;
        }
        Country country = (Country) obj;
        if (!Intrinsics.areEqual((Object) country.f54670b, (Object) this.f54670b) || !Intrinsics.areEqual((Object) country.f54669a, (Object) this.f54669a)) {
            return false;
        }
        return true;
    }

    public final CollationKey getCollationKey() {
        CollationKey collationKey = Collator.getInstance().getCollationKey(this.f54670b);
        Intrinsics.checkNotNullExpressionValue(collationKey, "getInstance().getCollationKey(name)");
        return collationKey;
    }

    public final String getIsoCode() {
        return this.f54669a;
    }

    public final String getName() {
        return this.f54670b;
    }

    public int hashCode() {
        String str = this.f54670b;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f54669a;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final void setIsoCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f54669a = str;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f54670b = str;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s (%s)", Arrays.copyOf(new Object[]{this.f54670b, this.f54669a}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.f54669a);
        parcel.writeString(this.f54670b);
    }

    public int compareTo(Country country) {
        Intrinsics.checkNotNullParameter(country, "country");
        return Collator.getInstance().getCollationKey(this.f54670b).compareTo(country.getCollationKey());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Country(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    public Country(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "isoCode");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.f54669a = "";
        this.f54670b = "";
        mo162611a(str, str2);
    }

    public Country(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.f54669a = "";
        this.f54670b = "";
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        Intrinsics.checkNotNullExpressionValue(readString, "parcel.readString()!!");
        this.f54669a = readString;
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        Intrinsics.checkNotNullExpressionValue(readString2, "parcel.readString()!!");
        this.f54670b = readString2;
    }
}
