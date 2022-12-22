package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaul extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaul> CREATOR = new zzauk();
    String zzdyw;

    public zzaul(String str) {
        this.zzdyw = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdyw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
