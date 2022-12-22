package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzhk implements zzhh {
    private int repeatMode;
    private final zzhy[] zzaex;
    private final zzoh zzaey;
    private final zzoi zzaez;
    private final Handler zzafa;
    private final zzhm zzafb;
    private final CopyOnWriteArraySet<zzhg> zzafc;
    private final zzie zzafd;
    private final zzif zzafe;
    private boolean zzaff;
    private boolean zzafg;
    private int zzafh;
    private int zzafi;
    private int zzafj;
    private boolean zzafk;
    private zzid zzafl;
    private Object zzafm;
    private zznu zzafn;
    private zzoi zzafo;
    private zzhz zzafp;
    private zzho zzafq;
    private int zzafr;
    private int zzafs;
    private long zzaft;

    public zzhk(zzhy[] zzhyArr, zzoh zzoh, zzhx zzhx) {
        String str = zzpt.zzbkx;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append(Const.jaRight);
        SystemUtils.log(4, "ExoPlayerImpl", sb.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzhk", 2);
        zzpg.checkState(zzhyArr.length > 0);
        this.zzaex = (zzhy[]) zzpg.checkNotNull(zzhyArr);
        this.zzaey = (zzoh) zzpg.checkNotNull(zzoh);
        this.zzafg = false;
        this.repeatMode = 0;
        this.zzafh = 1;
        this.zzafc = new CopyOnWriteArraySet<>();
        this.zzaez = new zzoi(new zzog[zzhyArr.length]);
        this.zzafl = zzid.zzaiq;
        this.zzafd = new zzie();
        this.zzafe = new zzif();
        this.zzafn = zznu.zzbhf;
        this.zzafo = this.zzaez;
        this.zzafp = zzhz.zzaik;
        this.zzafa = new zzhn(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        zzho zzho = new zzho(0, 0);
        this.zzafq = zzho;
        this.zzafb = new zzhm(zzhyArr, zzoh, zzhx, this.zzafg, 0, this.zzafa, zzho, this);
    }

    public final void zza(zzhg zzhg) {
        this.zzafc.add(zzhg);
    }

    public final void zzb(zzhg zzhg) {
        this.zzafc.remove(zzhg);
    }

    public final int getPlaybackState() {
        return this.zzafh;
    }

    public final void zza(zzne zzne) {
        if (!this.zzafl.isEmpty() || this.zzafm != null) {
            this.zzafl = zzid.zzaiq;
            this.zzafm = null;
            Iterator<zzhg> it = this.zzafc.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzafl, this.zzafm);
            }
        }
        if (this.zzaff) {
            this.zzaff = false;
            this.zzafn = zznu.zzbhf;
            this.zzafo = this.zzaez;
            this.zzaey.zzd((Object) null);
            Iterator<zzhg> it2 = this.zzafc.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.zzafn, this.zzafo);
            }
        }
        this.zzafj++;
        this.zzafb.zza(zzne, true);
    }

    public final void zzh(boolean z) {
        if (this.zzafg != z) {
            this.zzafg = z;
            this.zzafb.zzh(z);
            Iterator<zzhg> it = this.zzafc.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.zzafh);
            }
        }
    }

    public final boolean zzeo() {
        return this.zzafg;
    }

    public final void seekTo(long j) {
        long j2;
        int zzes = zzes();
        if (zzes < 0 || (!this.zzafl.isEmpty() && zzes >= this.zzafl.zzfj())) {
            throw new zzhu(this.zzafl, zzes, j);
        }
        this.zzafi++;
        this.zzafr = zzes;
        if (!this.zzafl.isEmpty()) {
            this.zzafl.zza(zzes, this.zzafd, false);
            if (j == -9223372036854775807L) {
                j2 = 0;
            } else {
                j2 = zzhf.zzdp(j);
            }
            long j3 = j2 + 0;
            long j4 = this.zzafl.zza(0, this.zzafe, false).zzaiz;
            if (j4 != -9223372036854775807L) {
                int i = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
            }
        }
        this.zzafs = 0;
        if (j == -9223372036854775807L) {
            this.zzaft = 0;
            this.zzafb.zza(this.zzafl, zzes, -9223372036854775807L);
            return;
        }
        this.zzaft = j;
        this.zzafb.zza(this.zzafl, zzes, zzhf.zzdp(j));
        Iterator<zzhg> it = this.zzafc.iterator();
        while (it.hasNext()) {
            it.next().zzen();
        }
    }

    public final void stop() {
        this.zzafb.stop();
    }

    public final void release() {
        this.zzafb.release();
        this.zzafa.removeCallbacksAndMessages((Object) null);
    }

    public final void zza(zzhi... zzhiArr) {
        this.zzafb.zza(zzhiArr);
    }

    public final void zzb(zzhi... zzhiArr) {
        this.zzafb.zzb(zzhiArr);
    }

    private final int zzes() {
        if (this.zzafl.isEmpty() || this.zzafi > 0) {
            return this.zzafr;
        }
        this.zzafl.zza(this.zzafq.zzags, this.zzafe, false);
        return 0;
    }

    public final long getDuration() {
        if (this.zzafl.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzhf.zzdo(this.zzafl.zza(zzes(), this.zzafd, false).zzaiz);
    }

    public final long zzeq() {
        if (this.zzafl.isEmpty() || this.zzafi > 0) {
            return this.zzaft;
        }
        this.zzafl.zza(this.zzafq.zzags, this.zzafe, false);
        return this.zzafe.zzfl() + zzhf.zzdo(this.zzafq.zzagu);
    }

    public final long getBufferedPosition() {
        if (this.zzafl.isEmpty() || this.zzafi > 0) {
            return this.zzaft;
        }
        this.zzafl.zza(this.zzafq.zzags, this.zzafe, false);
        return this.zzafe.zzfl() + zzhf.zzdo(this.zzafq.zzagv);
    }

    public final int zzep() {
        return this.zzaex.length;
    }

    public final void zzer() {
        this.zzafb.zzer();
    }

    public final void zzv(int i) {
        this.zzafb.zzv(i);
    }

    public final void zzw(int i) {
        this.zzafb.zzw(i);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.zzafj--;
                return;
            case 1:
                this.zzafh = message.arg1;
                Iterator<zzhg> it = this.zzafc.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.zzafg, this.zzafh);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.zzafk = z;
                Iterator<zzhg> it2 = this.zzafc.iterator();
                while (it2.hasNext()) {
                    it2.next().zzg(this.zzafk);
                }
                return;
            case 3:
                if (this.zzafj == 0) {
                    zzoj zzoj = (zzoj) message.obj;
                    this.zzaff = true;
                    this.zzafn = zzoj.zzbih;
                    this.zzafo = zzoj.zzbii;
                    this.zzaey.zzd(zzoj.zzbij);
                    Iterator<zzhg> it3 = this.zzafc.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.zzafn, this.zzafo);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzafi - 1;
                this.zzafi = i;
                if (i == 0) {
                    this.zzafq = (zzho) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzhg> it4 = this.zzafc.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzen();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzafi == 0) {
                    this.zzafq = (zzho) message.obj;
                    Iterator<zzhg> it5 = this.zzafc.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzen();
                    }
                    return;
                }
                return;
            case 6:
                zzhq zzhq = (zzhq) message.obj;
                this.zzafi -= zzhq.zzahh;
                if (this.zzafj == 0) {
                    this.zzafl = zzhq.zzafl;
                    this.zzafm = zzhq.zzafm;
                    this.zzafq = zzhq.zzafq;
                    Iterator<zzhg> it6 = this.zzafc.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzafl, this.zzafm);
                    }
                    return;
                }
                return;
            case 7:
                zzhz zzhz = (zzhz) message.obj;
                if (!this.zzafp.equals(zzhz)) {
                    this.zzafp = zzhz;
                    Iterator<zzhg> it7 = this.zzafc.iterator();
                    while (it7.hasNext()) {
                        it7.next().zza(zzhz);
                    }
                    return;
                }
                return;
            case 8:
                zzhe zzhe = (zzhe) message.obj;
                Iterator<zzhg> it8 = this.zzafc.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzhe);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
