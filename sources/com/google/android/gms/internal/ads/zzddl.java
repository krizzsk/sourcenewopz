package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzddl implements zzdhe<Object> {
    private static final Object lock = new Object();
    private final String zzckb;
    private final String zzdvq;
    private final zzf zzeci = zzr.zzkz().zzyl();
    private final zzdpm zzfzg;
    private final zzbqr zzhea;
    private final zzdqm zzheb;

    public zzddl(String str, String str2, zzbqr zzbqr, zzdqm zzdqm, zzdpm zzdpm) {
        this.zzdvq = str;
        this.zzckb = str2;
        this.zzhea = zzbqr;
        this.zzheb = zzdqm;
        this.zzfzg = zzdpm;
    }

    public final zzebt<Object> zzatu() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxl)).booleanValue()) {
            this.zzhea.zzf(this.zzfzg.zzhnx);
            bundle.putAll(this.zzheb.zzawm());
        }
        return zzebh.zzag(new zzddo(this, bundle));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxl)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcxk)).booleanValue()) {
                synchronized (lock) {
                    this.zzhea.zzf(this.zzfzg.zzhnx);
                    bundle2.putBundle("quality_signals", this.zzheb.zzawm());
                }
            } else {
                this.zzhea.zzf(this.zzfzg.zzhnx);
                bundle2.putBundle("quality_signals", this.zzheb.zzawm());
            }
        }
        bundle2.putString("seq_num", this.zzdvq);
        bundle2.putString("session_id", this.zzeci.zzzn() ? "" : this.zzckb);
    }
}
