package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdwh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdwh> CREATOR = new zzdwg();
    private final String packageName;
    private final int versionCode;
    private final String zzhxb;

    zzdwh(int i, String str, String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzhxb = str2;
    }

    public zzdwh(String str, String str2) {
        this(1, str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzhxb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
