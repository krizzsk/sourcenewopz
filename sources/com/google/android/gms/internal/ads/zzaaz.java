package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaaz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaaz> CREATOR = new zzaay();
    public final boolean zzaee;
    public final boolean zzaef;
    public final boolean zzaeg;

    public zzaaz(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    public zzaaz(boolean z, boolean z2, boolean z3) {
        this.zzaee = z;
        this.zzaef = z2;
        this.zzaeg = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzaee);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzaef);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzaeg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
