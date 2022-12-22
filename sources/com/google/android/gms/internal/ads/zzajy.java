package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzajy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzajy> CREATOR = new zzakb();
    public final int versionCode;
    public final int zzbod;
    public final int zzdkg;
    public final String zzdkh;

    public zzajy(zzakk zzakk) {
        this(2, 1, zzakk.zzup(), zzakk.getMediaAspectRatio());
    }

    public zzajy(int i, int i2, String str, int i3) {
        this.versionCode = i;
        this.zzdkg = i2;
        this.zzdkh = str;
        this.zzbod = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzdkg);
        SafeParcelWriter.writeString(parcel, 2, this.zzdkh, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbod);
        SafeParcelWriter.writeInt(parcel, 1000, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
