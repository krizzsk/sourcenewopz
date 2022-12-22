package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcil extends VideoController.VideoLifecycleCallbacks {
    private final zzcdr zzgeo;

    public zzcil(zzcdr zzcdr) {
        this.zzgeo = zzcdr;
    }

    public final void onVideoStart() {
        zzzi zza = zza(this.zzgeo);
        if (zza != null) {
            try {
                zza.onVideoStart();
            } catch (RemoteException e) {
                zzd.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoPause() {
        zzzi zza = zza(this.zzgeo);
        if (zza != null) {
            try {
                zza.onVideoPause();
            } catch (RemoteException e) {
                zzd.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoEnd() {
        zzzi zza = zza(this.zzgeo);
        if (zza != null) {
            try {
                zza.onVideoEnd();
            } catch (RemoteException e) {
                zzd.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    private static zzzi zza(zzcdr zzcdr) {
        zzzd videoController = zzcdr.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzrm();
        } catch (RemoteException unused) {
            return null;
        }
    }
}
