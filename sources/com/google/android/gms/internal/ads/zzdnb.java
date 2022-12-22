package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdnb extends AdMetadataListener implements zzbsy, zzbsz, zzbtm, zzbuj, zzbvb, zzdmi {
    private final zzdqs zzhis;
    private final AtomicReference<AdMetadataListener> zzhlb = new AtomicReference<>();
    private final AtomicReference<zzawn> zzhlc = new AtomicReference<>();
    private final AtomicReference<zzawg> zzhld = new AtomicReference<>();
    private final AtomicReference<zzavn> zzhle = new AtomicReference<>();
    private final AtomicReference<zzawo> zzhlf = new AtomicReference<>();
    private final AtomicReference<zzave> zzhlg = new AtomicReference<>();
    private final AtomicReference<zzyx> zzhlh = new AtomicReference<>();
    private zzdnb zzhli = null;

    public zzdnb(zzdqs zzdqs) {
        this.zzhis = zzdqs;
    }

    public final void zzb(zzawn zzawn) {
        this.zzhlc.set(zzawn);
    }

    public final void zzb(zzawg zzawg) {
        this.zzhld.set(zzawg);
    }

    public final void zzb(zzawo zzawo) {
        this.zzhlf.set(zzawo);
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.zzhlb.set(adMetadataListener);
    }

    public final void zzd(zzyx zzyx) {
        this.zzhlh.set(zzyx);
    }

    @Deprecated
    public final void zzb(zzavn zzavn) {
        this.zzhle.set(zzavn);
    }

    @Deprecated
    public final void zzb(zzave zzave) {
        this.zzhlg.set(zzave);
    }

    public final void onAdLoaded() {
        zzdnb zzdnb = this;
        while (true) {
            zzdnb zzdnb2 = zzdnb.zzhli;
            if (zzdnb2 != null) {
                zzdnb = zzdnb2;
            } else {
                zzdlx.zza(zzdnb.zzhlc, zzdne.zzhbd);
                zzdlx.zza(zzdnb.zzhle, zzdnd.zzhbd);
                return;
            }
        }
    }

    public final void zzd(zzvh zzvh) {
        zzdnb zzdnb = this;
        while (true) {
            zzdnb zzdnb2 = zzdnb.zzhli;
            if (zzdnb2 != null) {
                zzdnb = zzdnb2;
            } else {
                int i = zzvh.errorCode;
                zzdlx.zza(zzdnb.zzhlc, new zzdnq(zzvh));
                zzdlx.zza(zzdnb.zzhlc, new zzdns(i));
                zzdlx.zza(zzdnb.zzhle, new zzdnr(i));
                return;
            }
        }
    }

    public final void onAdOpened() {
        zzdnb zzdnb = this;
        while (true) {
            zzdnb zzdnb2 = zzdnb.zzhli;
            if (zzdnb2 != null) {
                zzdnb = zzdnb2;
            } else {
                zzdlx.zza(zzdnb.zzhld, zzdnu.zzhbd);
                zzdlx.zza(zzdnb.zzhle, zzdnt.zzhbd);
                zzdlx.zza(zzdnb.zzhld, zzdnw.zzhbd);
                return;
            }
        }
    }

    public final void onAdClosed() {
        zzdnb zzdnb = this;
        while (true) {
            zzdnb zzdnb2 = zzdnb.zzhli;
            if (zzdnb2 != null) {
                zzdnb = zzdnb2;
            } else {
                zzdnb.zzhis.onAdClosed();
                zzdlx.zza(zzdnb.zzhld, zzdnv.zzhbd);
                zzdlx.zza(zzdnb.zzhle, zzdny.zzhbd);
                return;
            }
        }
    }

    public final void onAdLeftApplication() {
        zzdnb zzdnb = this;
        while (true) {
            zzdnb zzdnb2 = zzdnb.zzhli;
            if (zzdnb2 != null) {
                zzdnb = zzdnb2;
            } else {
                zzdlx.zza(zzdnb.zzhle, zzdng.zzhbd);
                return;
            }
        }
    }

    public final void onRewardedVideoStarted() {
        zzdnb zzdnb = this;
        while (true) {
            zzdnb zzdnb2 = zzdnb.zzhli;
            if (zzdnb2 != null) {
                zzdnb = zzdnb2;
            } else {
                zzdlx.zza(zzdnb.zzhle, zzdnf.zzhbd);
                return;
            }
        }
    }

    public final void zzb(zzavd zzavd, String str, String str2) {
        zzdnb zzdnb = this;
        while (true) {
            zzdnb zzdnb2 = zzdnb.zzhli;
            if (zzdnb2 != null) {
                zzdnb = zzdnb2;
            } else {
                zzdlx.zza(zzdnb.zzhld, new zzdni(zzavd));
                zzdlx.zza(zzdnb.zzhlf, new zzdnh(zzavd, str, str2));
                zzdlx.zza(zzdnb.zzhle, new zzdnk(zzavd));
                zzdlx.zza(zzdnb.zzhlg, new zzdnj(zzavd, str, str2));
                return;
            }
        }
    }

    public final void onRewardedVideoCompleted() {
        zzdnb zzdnb = this;
        while (true) {
            zzdnb zzdnb2 = zzdnb.zzhli;
            if (zzdnb2 != null) {
                zzdnb = zzdnb2;
            } else {
                zzdlx.zza(zzdnb.zzhle, zzdnm.zzhbd);
                return;
            }
        }
    }

    public final void zzk(zzvh zzvh) {
        zzdnb zzdnb = this;
        while (true) {
            zzdnb zzdnb2 = zzdnb.zzhli;
            if (zzdnb2 != null) {
                zzdnb = zzdnb2;
            } else {
                zzdlx.zza(zzdnb.zzhld, new zzdnl(zzvh));
                zzdlx.zza(zzdnb.zzhld, new zzdno(zzvh));
                return;
            }
        }
    }

    public final void onAdMetadataChanged() {
        zzdnb zzdnb = this.zzhli;
        if (zzdnb != null) {
            zzdnb.onAdMetadataChanged();
        } else {
            zzdlx.zza(this.zzhlb, zzdnn.zzhbd);
        }
    }

    public final void zzb(zzvv zzvv) {
        zzdnb zzdnb = this;
        while (true) {
            zzdnb zzdnb2 = zzdnb.zzhli;
            if (zzdnb2 != null) {
                zzdnb = zzdnb2;
            } else {
                zzdlx.zza(zzdnb.zzhlh, new zzdnp(zzvv));
                return;
            }
        }
    }

    public final void zzb(zzdmi zzdmi) {
        this.zzhli = (zzdnb) zzdmi;
    }
}
