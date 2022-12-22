package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzauj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzauj> CREATOR = new zzaui();
    private final ApplicationInfo applicationInfo;
    public final String packageName;
    public final zzbar zzdvi;
    public final PackageInfo zzdvo;
    public final List<String> zzdvy;
    public final String zzdwh;
    public final Bundle zzdys;
    public final String zzdyt;
    public zzdrc zzdyu;
    public String zzdyv;

    public zzauj(Bundle bundle, zzbar zzbar, ApplicationInfo applicationInfo2, String str, List<String> list, PackageInfo packageInfo, String str2, String str3, zzdrc zzdrc, String str4) {
        this.zzdys = bundle;
        this.zzdvi = zzbar;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzdvy = list;
        this.zzdvo = packageInfo;
        this.zzdwh = str2;
        this.zzdyt = str3;
        this.zzdyu = zzdrc;
        this.zzdyv = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdys, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdvi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdvy, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdvo, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdwh, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzdyt, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzdyu, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzdyv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
