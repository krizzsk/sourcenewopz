package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzap;
import com.google.android.gms.ads.internal.util.zzaq;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcpa extends zzauc {
    private final /* synthetic */ zzcpb zzgrd;

    protected zzcpa(zzcpb zzcpb) {
        this.zzgrd = zzcpb;
    }

    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzgrd.zzdml.set(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }

    public final void zza(zzaq zzaq) {
        this.zzgrd.zzdml.setException(new zzap(zzaq.zzacu, zzaq.errorCode));
    }
}
