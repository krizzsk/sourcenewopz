package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcwm {
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzcjw zzgmx;
    private final zzdpz zzgnx;

    public zzcwm(zzdpz zzdpz, zzcjw zzcjw, zzcmb zzcmb, zzdtw zzdtw) {
        this.zzgnx = zzdpz;
        this.zzgmx = zzcjw;
        this.zzdje = zzcmb;
        this.zzdjf = zzdtw;
    }

    public final void zza(zzdoy zzdoy, zzdot zzdot, int i, @Nullable zzctd zzctd, long j) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            zzdtx zzw = zzdtx.zzgy("adapter_status").zzb(zzdoy).zzg(zzdot).zzw("adapter_l", String.valueOf(j)).zzw("sc", Integer.toString(i));
            if (zzctd != null) {
                zzw.zzw("arec", Integer.toString(zzctd.zzasv().errorCode));
                String zzgu = this.zzgnx.zzgu(zzctd.getMessage());
                if (zzgu != null) {
                    zzw.zzw("areec", zzgu);
                }
            }
            zzcjx zzi = this.zzgmx.zzi(zzdot.zzhmi);
            if (zzi != null) {
                zzw.zzw("ancn", zzi.zzdka);
                if (zzi.zzgmu != null) {
                    zzw.zzw("adapter_v", zzi.zzgmu.toString());
                }
                if (zzi.zzgmv != null) {
                    zzw.zzw("adapter_sv", zzi.zzgmv.toString());
                }
            }
            this.zzdjf.zzb(zzw);
            return;
        }
        zzcma zzs = this.zzdje.zzarp().zza(zzdoy).zzc(zzdot).zzs("action", "adapter_status").zzs("adapter_l", String.valueOf(j));
        zzs.zzs("sc", Integer.toString(i));
        if (zzctd != null) {
            zzs.zzs("arec", Integer.toString(zzctd.zzasv().errorCode));
            String zzgu2 = this.zzgnx.zzgu(zzctd.getMessage());
            if (zzgu2 != null) {
                zzs.zzs("areec", zzgu2);
            }
        }
        zzcjx zzi2 = this.zzgmx.zzi(zzdot.zzhmi);
        if (zzi2 != null) {
            zzs.zzs("ancn", zzi2.zzdka);
            if (zzi2.zzgmu != null) {
                zzs.zzs("adapter_v", zzi2.zzgmu.toString());
            }
            if (zzi2.zzgmv != null) {
                zzs.zzs("adapter_sv", zzi2.zzgmv.toString());
            }
        }
        zzs.zzarm();
    }
}
