package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaww extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaww> CREATOR = new zzawz();
    public final String zzear;
    public final String zzeas;

    public zzaww(ServerSideVerificationOptions serverSideVerificationOptions) {
        this(serverSideVerificationOptions.getUserId(), serverSideVerificationOptions.getCustomData());
    }

    public zzaww(String str, String str2) {
        this.zzear = str;
        this.zzeas = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzear, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzeas, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
