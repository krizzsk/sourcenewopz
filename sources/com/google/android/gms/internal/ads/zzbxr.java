package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbxr {
    private final zzdmi zzfyo;
    private final Set<zzbzl<zzve>> zzgcn;
    private final Set<zzbzl<zzbsy>> zzgco;
    private final Set<zzbzl<zzbtq>> zzgcp;
    private final Set<zzbzl<zzbus>> zzgcq;
    private final Set<zzbzl<zzbuj>> zzgcr;
    private final Set<zzbzl<zzbsz>> zzgcs;
    private final Set<zzbzl<zzbtm>> zzgct;
    private final Set<zzbzl<AdMetadataListener>> zzgcu;
    private final Set<zzbzl<AppEventListener>> zzgcv;
    private final Set<zzbzl<zzbvb>> zzgcw;
    private final Set<zzbzl<zzp>> zzgcx;
    private final Set<zzbzl<zzbvm>> zzgcy;
    private zzbsx zzgcz;
    private zzcwk zzgda;

    private zzbxr(zza zza2) {
        this.zzgcn = zza2.zzgcn;
        this.zzgcp = zza2.zzgcp;
        this.zzgcq = zza2.zzgcq;
        this.zzgco = zza2.zzgco;
        this.zzgcr = zza2.zzgcr;
        this.zzgcs = zza2.zzgcs;
        this.zzgct = zza2.zzgct;
        this.zzgcu = zza2.zzgcu;
        this.zzgcv = zza2.zzgcv;
        this.zzgcw = zza2.zzgdb;
        this.zzfyo = zza2.zzfyo;
        this.zzgcx = zza2.zzgcx;
        this.zzgcy = zza2.zzgcy;
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static class zza {
        /* access modifiers changed from: private */
        public zzdmi zzfyo;
        /* access modifiers changed from: private */
        public Set<zzbzl<zzve>> zzgcn = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<zzbsy>> zzgco = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<zzbtq>> zzgcp = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<zzbus>> zzgcq = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<zzbuj>> zzgcr = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<zzbsz>> zzgcs = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<zzbtm>> zzgct = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<AdMetadataListener>> zzgcu = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<AppEventListener>> zzgcv = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<zzp>> zzgcx = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<zzbvm>> zzgcy = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbzl<zzbvb>> zzgdb = new HashSet();

        public final zza zza(zzbsy zzbsy, Executor executor) {
            this.zzgco.add(new zzbzl(zzbsy, executor));
            return this;
        }

        public final zza zza(zzbuj zzbuj, Executor executor) {
            this.zzgcr.add(new zzbzl(zzbuj, executor));
            return this;
        }

        public final zza zza(zzbsz zzbsz, Executor executor) {
            this.zzgcs.add(new zzbzl(zzbsz, executor));
            return this;
        }

        public final zza zza(zzbtm zzbtm, Executor executor) {
            this.zzgct.add(new zzbzl(zzbtm, executor));
            return this;
        }

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.zzgcv.add(new zzbzl(appEventListener, executor));
            return this;
        }

        public final zza zza(zzve zzve, Executor executor) {
            this.zzgcn.add(new zzbzl(zzve, executor));
            return this;
        }

        public final zza zza(zzbtq zzbtq, Executor executor) {
            this.zzgcp.add(new zzbzl(zzbtq, executor));
            return this;
        }

        public final zza zza(zzbus zzbus, Executor executor) {
            this.zzgcq.add(new zzbzl(zzbus, executor));
            return this;
        }

        public final zza zza(zzp zzp, Executor executor) {
            this.zzgcx.add(new zzbzl(zzp, executor));
            return this;
        }

        public final zza zza(zzbvb zzbvb, Executor executor) {
            this.zzgdb.add(new zzbzl(zzbvb, executor));
            return this;
        }

        public final zza zza(zzdmi zzdmi) {
            this.zzfyo = zzdmi;
            return this;
        }

        public final zza zza(zzbvm zzbvm, Executor executor) {
            this.zzgcy.add(new zzbzl(zzbvm, executor));
            return this;
        }

        public final zzbxr zzanf() {
            return new zzbxr(this);
        }
    }

    public final Set<zzbzl<zzbsy>> zzams() {
        return this.zzgco;
    }

    public final Set<zzbzl<zzbuj>> zzamt() {
        return this.zzgcr;
    }

    public final Set<zzbzl<zzbsz>> zzamu() {
        return this.zzgcs;
    }

    public final Set<zzbzl<zzbtm>> zzamv() {
        return this.zzgct;
    }

    public final Set<zzbzl<AdMetadataListener>> zzamw() {
        return this.zzgcu;
    }

    public final Set<zzbzl<AppEventListener>> zzamx() {
        return this.zzgcv;
    }

    public final Set<zzbzl<zzve>> zzamy() {
        return this.zzgcn;
    }

    public final Set<zzbzl<zzbtq>> zzamz() {
        return this.zzgcp;
    }

    public final Set<zzbzl<zzbus>> zzana() {
        return this.zzgcq;
    }

    public final Set<zzbzl<zzbvb>> zzanb() {
        return this.zzgcw;
    }

    public final Set<zzbzl<zzbvm>> zzanc() {
        return this.zzgcy;
    }

    public final Set<zzbzl<zzp>> zzand() {
        return this.zzgcx;
    }

    public final zzdmi zzane() {
        return this.zzfyo;
    }

    public final zzbsx zzc(Set<zzbzl<zzbsz>> set) {
        if (this.zzgcz == null) {
            this.zzgcz = new zzbsx(set);
        }
        return this.zzgcz;
    }

    public final zzcwk zza(Clock clock, zzcwm zzcwm, zzctc zzctc) {
        if (this.zzgda == null) {
            this.zzgda = new zzcwk(clock, zzcwm, zzctc);
        }
        return this.zzgda;
    }
}
