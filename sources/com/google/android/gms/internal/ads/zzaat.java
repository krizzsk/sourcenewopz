package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaat> CREATOR = new zzaas();
    private final int zzadv;
    private final int zzadw;

    public zzaat(int i, int i2) {
        this.zzadv = i;
        this.zzadw = i2;
    }

    public zzaat(RequestConfiguration requestConfiguration) {
        this.zzadv = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzadw = requestConfiguration.getTagForUnderAgeOfConsent();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzadv);
        SafeParcelWriter.writeInt(parcel, 2, this.zzadw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
