package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzr;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcpd extends zzcpb {
    public zzcpd(Context context) {
        this.zzgrh = new zzatr(context, zzr.zzlj().zzaai(), this, this);
    }

    public final zzebt<InputStream> zzj(zzauj zzauj) {
        synchronized (this.mLock) {
            if (this.zzgre) {
                zzbbe zzbbe = this.zzdml;
                return zzbbe;
            }
            this.zzgre = true;
            this.zzgrg = zzauj;
            this.zzgrh.checkAvailabilityAndConnect();
            this.zzdml.addListener(new zzcpc(this), zzbat.zzekj);
            zzbbe zzbbe2 = this.zzdml;
            return zzbbe2;
        }
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgrf) {
                this.zzgrf = true;
                try {
                    this.zzgrh.zzwt().zzb(this.zzgrg, new zzcpa(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                } catch (Throwable th) {
                    zzr.zzkz().zza(th, "RemoteSignalsClientTask.onConnected");
                    this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                }
            }
        }
    }
}
