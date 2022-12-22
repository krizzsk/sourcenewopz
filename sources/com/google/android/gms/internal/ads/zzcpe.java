package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcpe extends zzcpb {
    private String zzgrj;
    private int zzgrk = zzcpj.zzgrm;

    public zzcpe(Context context) {
        this.zzgrh = new zzatr(context, zzr.zzlj().zzaai(), this, this);
    }

    public final zzebt<InputStream> zzk(zzauj zzauj) {
        synchronized (this.mLock) {
            if (this.zzgrk != zzcpj.zzgrm && this.zzgrk != zzcpj.zzgrn) {
                zzebt<InputStream> immediateFailedFuture = zzebh.immediateFailedFuture(new zzcpo(zzdqj.INVALID_REQUEST));
                return immediateFailedFuture;
            } else if (this.zzgre) {
                zzbbe zzbbe = this.zzdml;
                return zzbbe;
            } else {
                this.zzgrk = zzcpj.zzgrn;
                this.zzgre = true;
                this.zzgrg = zzauj;
                this.zzgrh.checkAvailabilityAndConnect();
                this.zzdml.addListener(new zzcph(this), zzbat.zzekj);
                zzbbe zzbbe2 = this.zzdml;
                return zzbbe2;
            }
        }
    }

    public final zzebt<InputStream> zzgj(String str) {
        synchronized (this.mLock) {
            if (this.zzgrk != zzcpj.zzgrm && this.zzgrk != zzcpj.zzgro) {
                zzebt<InputStream> immediateFailedFuture = zzebh.immediateFailedFuture(new zzcpo(zzdqj.INVALID_REQUEST));
                return immediateFailedFuture;
            } else if (this.zzgre) {
                zzbbe zzbbe = this.zzdml;
                return zzbbe;
            } else {
                this.zzgrk = zzcpj.zzgro;
                this.zzgre = true;
                this.zzgrj = str;
                this.zzgrh.checkAvailabilityAndConnect();
                this.zzdml.addListener(new zzcpg(this), zzbat.zzekj);
                zzbbe zzbbe2 = this.zzdml;
                return zzbbe2;
            }
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
                    if (this.zzgrk == zzcpj.zzgrn) {
                        this.zzgrh.zzwt().zzc(this.zzgrg, new zzcpa(this));
                    } else if (this.zzgrk == zzcpj.zzgro) {
                        this.zzgrh.zzwt().zza(this.zzgrj, (zzaud) new zzcpa(this));
                    } else {
                        this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                } catch (Throwable th) {
                    zzr.zzkz().zza(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zzdml.setException(new zzcpo(zzdqj.INTERNAL_ERROR));
                }
            }
        }
    }
}
