package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzuh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rui.config.RConfigConstants;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdqy implements zzdqz {
    private final ConcurrentHashMap<zzdri, zzdqw> zzhqa;
    private zzdrc zzhqb;
    private zzdra zzhqc = new zzdra();

    public zzdqy(zzdrc zzdrc) {
        this.zzhqa = new ConcurrentHashMap<>(zzdrc.zzhqq);
        this.zzhqb = zzdrc;
    }

    public final synchronized zzdrj<?> zza(zzdri zzdri) {
        zzdrj<?> zzdrj;
        zzdqw zzdqw = this.zzhqa.get(zzdri);
        zzdrj = null;
        if (zzdqw != null) {
            zzdrj = zzdqw.zzawo();
            if (zzdrj == null) {
                this.zzhqc.zzawx();
            }
            zza(zzdrj, zzdqw.zzaws());
        } else {
            this.zzhqc.zzaww();
            zza((zzdrj<?>) null, (zzdry) null);
        }
        return zzdrj;
    }

    public final synchronized boolean zza(zzdri zzdri, zzdrj<?> zzdrj) {
        boolean zzb;
        zzdqw zzdqw = this.zzhqa.get(zzdri);
        zzdrj.zzhrl = zzr.zzlc().currentTimeMillis();
        if (zzdqw == null) {
            zzdqw = new zzdqw(this.zzhqb.zzhqq, this.zzhqb.zzhqr * 1000);
            if (this.zzhqa.size() == this.zzhqb.zzhqp) {
                int i = zzdrb.zzhqj[this.zzhqb.zzhqu - 1];
                long j = Long.MAX_VALUE;
                zzdri zzdri2 = null;
                if (i == 1) {
                    for (Map.Entry next : this.zzhqa.entrySet()) {
                        if (((zzdqw) next.getValue()).getCreationTimeMillis() < j) {
                            j = ((zzdqw) next.getValue()).getCreationTimeMillis();
                            zzdri2 = (zzdri) next.getKey();
                        }
                    }
                    if (zzdri2 != null) {
                        this.zzhqa.remove(zzdri2);
                    }
                } else if (i == 2) {
                    for (Map.Entry next2 : this.zzhqa.entrySet()) {
                        if (((zzdqw) next2.getValue()).zzawp() < j) {
                            j = ((zzdqw) next2.getValue()).zzawp();
                            zzdri2 = (zzdri) next2.getKey();
                        }
                    }
                    if (zzdri2 != null) {
                        this.zzhqa.remove(zzdri2);
                    }
                } else if (i == 3) {
                    int i2 = Integer.MAX_VALUE;
                    for (Map.Entry next3 : this.zzhqa.entrySet()) {
                        if (((zzdqw) next3.getValue()).zzawq() < i2) {
                            i2 = ((zzdqw) next3.getValue()).zzawq();
                            zzdri2 = (zzdri) next3.getKey();
                        }
                    }
                    if (zzdri2 != null) {
                        this.zzhqa.remove(zzdri2);
                    }
                }
                this.zzhqc.zzawz();
            }
            this.zzhqa.put(zzdri, zzdqw);
            this.zzhqc.zzawy();
        }
        zzb = zzdqw.zzb(zzdrj);
        this.zzhqc.zzaxa();
        zzdrd zzaxb = this.zzhqc.zzaxb();
        zzdry zzaws = zzdqw.zzaws();
        if (zzdrj != null) {
            zzdrj.zzhrj.zzalw().zzd((zzuh.zzb) ((zzena) zzuh.zzb.zznt().zza(zzuh.zzb.zza.zznr().zzb(zzuh.zzb.zzc.IN_MEMORY).zza(zzuh.zzb.zze.zznx().zzv(zzaxb.zzhqx).zzw(zzaxb.zzhqy).zzcd(zzaws.zzhsg))).zzbjv()));
        }
        dumpToLog();
        return zzb;
    }

    public final synchronized boolean zzb(zzdri zzdri) {
        zzdqw zzdqw = this.zzhqa.get(zzdri);
        if (zzdqw == null) {
            return true;
        }
        if (zzdqw.size() < this.zzhqb.zzhqq) {
            return true;
        }
        return false;
    }

    @Deprecated
    public final zzdri zza(zzvq zzvq, String str, zzwc zzwc) {
        return new zzdrl(zzvq, str, new zzaur(this.zzhqb.context).zzxd().zzdzl, this.zzhqb.zzhqs, zzwc);
    }

    public final zzdrc zzawv() {
        return this.zzhqb;
    }

    private final void zza(zzdrj<?> zzdrj, zzdry zzdry) {
        if (zzdrj != null) {
            zzdrj.zzhrj.zzalw().zzc((zzuh.zzb) ((zzena) zzuh.zzb.zznt().zza(zzuh.zzb.zza.zznr().zzb(zzuh.zzb.zzc.IN_MEMORY).zza(zzuh.zzb.zzd.zznv().zzu(zzdry.zzhsf).zzcc(zzdry.zzhsg))).zzbjv()));
        }
        dumpToLog();
    }

    private final void dumpToLog() {
        if (zzdrc.zzaxd()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzhqb.zzhqo);
            sb.append(" PoolCollection");
            sb.append(this.zzhqc.zzaxc());
            int i = 0;
            for (Map.Entry next : this.zzhqa.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(next.getValue());
                sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                sb.append(((zzdri) next.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzdqw) next.getValue()).size(); i2++) {
                    sb.append("[O]");
                }
                for (int size = ((zzdqw) next.getValue()).size(); size < this.zzhqb.zzhqq; size++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzdqw) next.getValue()).zzawr());
                sb.append("\n");
            }
            while (i < this.zzhqb.zzhqp) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzd.zzdz(sb.toString());
        }
    }
}
