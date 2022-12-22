package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcoz extends zzcpb {
    public zzcoz(Context context) {
        this.zzgrh = new zzatr(context, zzr.zzlj().zzaai(), this, this);
    }

    public final zzebt<InputStream> zzi(zzauj zzauj) {
        synchronized (this.mLock) {
            if (this.zzgre) {
                zzbbe zzbbe = this.zzdml;
                return zzbbe;
            }
            this.zzgre = true;
            this.zzgrg = zzauj;
            this.zzgrh.checkAvailabilityAndConnect();
            this.zzdml.addListener(new zzcoy(this), zzbat.zzekj);
            zzbbe zzbbe2 = this.zzdml;
            return zzbbe2;
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzd.zzdz("Cannot connect to remote service, fallback to local instance.");
        this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgrf) {
                this.zzgrf = true;
                try {
                    this.zzgrh.zzwt().zza(this.zzgrg, (zzaud) new zzcpa(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                } catch (Throwable th) {
                    zzr.zzkz().zza(th, "RemoteAdRequestClientTask.onConnected");
                    this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                }
            }
        }
    }
}
