package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzms implements zzkc, zznc, zzno, zzoz<zzmv> {
    /* access modifiers changed from: private */
    public final Handler handler;
    private final Uri uri;
    private final Handler zzafa;
    /* access modifiers changed from: private */
    public boolean zzagd;
    private boolean zzahc;
    private long zzaiz;
    private final zzon zzaoz;
    private final int zzbdw;
    /* access modifiers changed from: private */
    public final zzmz zzbdx;
    private final zznd zzbdy;
    private final zzol zzbdz;
    /* access modifiers changed from: private */
    public final String zzbea = null;
    /* access modifiers changed from: private */
    public final long zzbeb;
    private final zzpa zzbec;
    private final zzmy zzbed;
    private final zzpi zzbee;
    private final Runnable zzbef;
    /* access modifiers changed from: private */
    public final Runnable zzbeg;
    /* access modifiers changed from: private */
    public final SparseArray<zznm> zzbeh;
    /* access modifiers changed from: private */
    public zznb zzbei;
    private zzkf zzbej;
    private boolean zzbek;
    private boolean zzbel;
    private boolean zzbem;
    private int zzben;
    private zznu zzbeo;
    private boolean[] zzbep;
    private boolean[] zzbeq;
    private boolean zzber;
    private long zzbes;
    private long zzbet;
    private int zzbeu;
    private boolean zzbev;
    private long zzco;

    public zzms(Uri uri2, zzon zzon, zzka[] zzkaArr, int i, Handler handler2, zzmz zzmz, zznd zznd, zzol zzol, String str, int i2) {
        this.uri = uri2;
        this.zzaoz = zzon;
        this.zzbdw = i;
        this.zzafa = handler2;
        this.zzbdx = zzmz;
        this.zzbdy = zznd;
        this.zzbdz = zzol;
        this.zzbeb = (long) i2;
        this.zzbec = new zzpa("Loader:ExtractorMediaPeriod");
        this.zzbed = new zzmy(zzkaArr, this);
        this.zzbee = new zzpi();
        this.zzbef = new zzmr(this);
        this.zzbeg = new zzmu(this);
        this.handler = new Handler();
        this.zzbet = -9223372036854775807L;
        this.zzbeh = new SparseArray<>();
        this.zzco = -1;
    }

    public final void zzef(long j) {
    }

    public final void release() {
        this.zzbec.zza((Runnable) new zzmt(this, this.zzbed));
        this.handler.removeCallbacksAndMessages((Object) null);
        this.zzagd = true;
    }

    public final void zza(zznb zznb, long j) {
        this.zzbei = zznb;
        this.zzbee.open();
        startLoading();
    }

    public final void zzhs() throws IOException {
        this.zzbec.zzbj(Integer.MIN_VALUE);
    }

    public final zznu zzht() {
        return this.zzbeo;
    }

    public final long zza(zzog[] zzogArr, boolean[] zArr, zznn[] zznnArr, boolean[] zArr2, long j) {
        zzpg.checkState(this.zzahc);
        for (int i = 0; i < zzogArr.length; i++) {
            if (zznnArr[i] != null && (zzogArr[i] == null || !zArr[i])) {
                int zza = zznnArr[i].track;
                zzpg.checkState(this.zzbep[zza]);
                this.zzben--;
                this.zzbep[zza] = false;
                this.zzbeh.valueAt(zza).disable();
                zznnArr[i] = null;
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < zzogArr.length; i2++) {
            if (zznnArr[i2] == null && zzogArr[i2] != null) {
                zzog zzog = zzogArr[i2];
                zzpg.checkState(zzog.length() == 1);
                zzpg.checkState(zzog.zzbg(0) == 0);
                int zza2 = this.zzbeo.zza(zzog.zzip());
                zzpg.checkState(!this.zzbep[zza2]);
                this.zzben++;
                this.zzbep[zza2] = true;
                zznnArr[i2] = new zzmx(this, zza2);
                zArr2[i2] = true;
                z = true;
            }
        }
        if (!this.zzbel) {
            int size = this.zzbeh.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!this.zzbep[i3]) {
                    this.zzbeh.valueAt(i3).disable();
                }
            }
        }
        if (this.zzben == 0) {
            this.zzbem = false;
            if (this.zzbec.isLoading()) {
                this.zzbec.zzix();
            }
        } else if (!this.zzbel ? j != 0 : z) {
            j = zzeg(j);
            for (int i4 = 0; i4 < zznnArr.length; i4++) {
                if (zznnArr[i4] != null) {
                    zArr2[i4] = true;
                }
            }
        }
        this.zzbel = true;
        return j;
    }

    public final boolean zzee(long j) {
        if (this.zzbev) {
            return false;
        }
        if (this.zzahc && this.zzben == 0) {
            return false;
        }
        boolean open = this.zzbee.open();
        if (this.zzbec.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    public final long zzhr() {
        if (this.zzben == 0) {
            return Long.MIN_VALUE;
        }
        return zzhv();
    }

    public final long zzhu() {
        if (!this.zzbem) {
            return -9223372036854775807L;
        }
        this.zzbem = false;
        return this.zzbes;
    }

    public final long zzhv() {
        long j;
        if (this.zzbev) {
            return Long.MIN_VALUE;
        }
        if (zzia()) {
            return this.zzbet;
        }
        if (this.zzber) {
            j = Long.MAX_VALUE;
            int size = this.zzbeh.size();
            for (int i = 0; i < size; i++) {
                if (this.zzbeq[i]) {
                    j = Math.min(j, this.zzbeh.valueAt(i).zzhz());
                }
            }
        } else {
            j = zzhz();
        }
        return j == Long.MIN_VALUE ? this.zzbes : j;
    }

    public final long zzeg(long j) {
        if (!this.zzbej.isSeekable()) {
            j = 0;
        }
        this.zzbes = j;
        int size = this.zzbeh.size();
        boolean z = !zzia();
        int i = 0;
        while (z && i < size) {
            if (this.zzbep[i]) {
                z = this.zzbeh.valueAt(i).zze(j, false);
            }
            i++;
        }
        if (!z) {
            this.zzbet = j;
            this.zzbev = false;
            if (this.zzbec.isLoading()) {
                this.zzbec.zzix();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.zzbeh.valueAt(i2).zzl(this.zzbep[i2]);
                }
            }
        }
        this.zzbem = false;
        return j;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbc(int i) {
        if (!this.zzbev) {
            return !zzia() && this.zzbeh.valueAt(i).zzii();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzhw() throws IOException {
        this.zzbec.zzbj(Integer.MIN_VALUE);
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i, zzhv zzhv, zzjp zzjp, boolean z) {
        if (this.zzbem || zzia()) {
            return -3;
        }
        return this.zzbeh.valueAt(i).zza(zzhv, zzjp, z, this.zzbev, this.zzbes);
    }

    /* access modifiers changed from: package-private */
    public final void zze(int i, long j) {
        zznm valueAt = this.zzbeh.valueAt(i);
        if (!this.zzbev || j <= valueAt.zzhz()) {
            valueAt.zze(j, true);
        } else {
            valueAt.zzim();
        }
    }

    public final zzkh zze(int i, int i2) {
        zznm zznm = this.zzbeh.get(i);
        if (zznm != null) {
            return zznm;
        }
        zznm zznm2 = new zznm(this.zzbdz);
        zznm2.zza(this);
        this.zzbeh.put(i, zznm2);
        return zznm2;
    }

    public final void zzgw() {
        this.zzbek = true;
        this.handler.post(this.zzbef);
    }

    public final void zza(zzkf zzkf) {
        this.zzbej = zzkf;
        this.handler.post(this.zzbef);
    }

    public final void zzf(zzht zzht) {
        this.handler.post(this.zzbef);
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public final void zzhx() {
        /*
            r8 = this;
            boolean r0 = r8.zzagd
            if (r0 != 0) goto L_0x009d
            boolean r0 = r8.zzahc
            if (r0 != 0) goto L_0x009d
            com.google.android.gms.internal.ads.zzkf r0 = r8.zzbej
            if (r0 == 0) goto L_0x009d
            boolean r0 = r8.zzbek
            if (r0 != 0) goto L_0x0012
            goto L_0x009d
        L_0x0012:
            android.util.SparseArray<com.google.android.gms.internal.ads.zznm> r0 = r8.zzbeh
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x001a:
            if (r2 >= r0) goto L_0x002e
            android.util.SparseArray<com.google.android.gms.internal.ads.zznm> r3 = r8.zzbeh
            java.lang.Object r3 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zznm r3 = (com.google.android.gms.internal.ads.zznm) r3
            com.google.android.gms.internal.ads.zzht r3 = r3.zzij()
            if (r3 != 0) goto L_0x002b
            return
        L_0x002b:
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002e:
            com.google.android.gms.internal.ads.zzpi r2 = r8.zzbee
            r2.zziy()
            com.google.android.gms.internal.ads.zznr[] r2 = new com.google.android.gms.internal.ads.zznr[r0]
            boolean[] r3 = new boolean[r0]
            r8.zzbeq = r3
            boolean[] r3 = new boolean[r0]
            r8.zzbep = r3
            com.google.android.gms.internal.ads.zzkf r3 = r8.zzbej
            long r3 = r3.getDurationUs()
            r8.zzaiz = r3
            r3 = 0
        L_0x0046:
            r4 = 1
            if (r3 >= r0) goto L_0x007c
            android.util.SparseArray<com.google.android.gms.internal.ads.zznm> r5 = r8.zzbeh
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zznm r5 = (com.google.android.gms.internal.ads.zznm) r5
            com.google.android.gms.internal.ads.zzht r5 = r5.zzij()
            com.google.android.gms.internal.ads.zznr r6 = new com.google.android.gms.internal.ads.zznr
            com.google.android.gms.internal.ads.zzht[] r7 = new com.google.android.gms.internal.ads.zzht[r4]
            r7[r1] = r5
            r6.<init>(r7)
            r2[r3] = r6
            java.lang.String r5 = r5.zzaho
            boolean r6 = com.google.android.gms.internal.ads.zzpj.zzbd(r5)
            if (r6 != 0) goto L_0x0070
            boolean r5 = com.google.android.gms.internal.ads.zzpj.zzbc(r5)
            if (r5 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = 0
        L_0x0070:
            boolean[] r5 = r8.zzbeq
            r5[r3] = r4
            boolean r5 = r8.zzber
            r4 = r4 | r5
            r8.zzber = r4
            int r3 = r3 + 1
            goto L_0x0046
        L_0x007c:
            com.google.android.gms.internal.ads.zznu r0 = new com.google.android.gms.internal.ads.zznu
            r0.<init>(r2)
            r8.zzbeo = r0
            r8.zzahc = r4
            com.google.android.gms.internal.ads.zznd r0 = r8.zzbdy
            com.google.android.gms.internal.ads.zzns r1 = new com.google.android.gms.internal.ads.zzns
            long r2 = r8.zzaiz
            com.google.android.gms.internal.ads.zzkf r4 = r8.zzbej
            boolean r4 = r4.isSeekable()
            r1.<init>(r2, r4)
            r2 = 0
            r0.zzb(r1, r2)
            com.google.android.gms.internal.ads.zznb r0 = r8.zzbei
            r0.zza(r8)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzms.zzhx():void");
    }

    private final void zza(zzmv zzmv) {
        if (this.zzco == -1) {
            this.zzco = zzmv.zzco;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        r0 = r9.zzbej;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void startLoading() {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzmv r6 = new com.google.android.gms.internal.ads.zzmv
            android.net.Uri r2 = r9.uri
            com.google.android.gms.internal.ads.zzon r3 = r9.zzaoz
            com.google.android.gms.internal.ads.zzmy r4 = r9.zzbed
            com.google.android.gms.internal.ads.zzpi r5 = r9.zzbee
            r0 = r6
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            boolean r0 = r9.zzahc
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0040
            boolean r0 = r9.zzia()
            com.google.android.gms.internal.ads.zzpg.checkState(r0)
            long r3 = r9.zzaiz
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            long r7 = r9.zzbet
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0031
            r0 = 1
            r9.zzbev = r0
            r9.zzbet = r1
            return
        L_0x0031:
            com.google.android.gms.internal.ads.zzkf r0 = r9.zzbej
            long r3 = r9.zzbet
            long r3 = r0.zzdz(r3)
            long r7 = r9.zzbet
            r6.zze(r3, r7)
            r9.zzbet = r1
        L_0x0040:
            int r0 = r9.zzhy()
            r9.zzbeu = r0
            int r0 = r9.zzbdw
            r3 = -1
            if (r0 != r3) goto L_0x0067
            boolean r0 = r9.zzahc
            if (r0 == 0) goto L_0x0066
            long r3 = r9.zzco
            r7 = -1
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0066
            com.google.android.gms.internal.ads.zzkf r0 = r9.zzbej
            if (r0 == 0) goto L_0x0064
            long r3 = r0.getDurationUs()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r0 = 6
            goto L_0x0067
        L_0x0066:
            r0 = 3
        L_0x0067:
            com.google.android.gms.internal.ads.zzpa r1 = r9.zzbec
            r1.zza(r6, r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzms.startLoading():void");
    }

    private final int zzhy() {
        int size = this.zzbeh.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.zzbeh.valueAt(i2).zzih();
        }
        return i;
    }

    private final long zzhz() {
        int size = this.zzbeh.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.zzbeh.valueAt(i).zzhz());
        }
        return j;
    }

    private final boolean zzia() {
        return this.zzbet != -9223372036854775807L;
    }

    public final /* synthetic */ int zza(zzpb zzpb, long j, long j2, IOException iOException) {
        zzkf zzkf;
        zzmv zzmv = (zzmv) zzpb;
        zza(zzmv);
        Handler handler2 = this.zzafa;
        if (!(handler2 == null || this.zzbdx == null)) {
            handler2.post(new zzmw(this, iOException));
        }
        if (iOException instanceof zznt) {
            return 3;
        }
        boolean z = zzhy() > this.zzbeu;
        if (this.zzco == -1 && ((zzkf = this.zzbej) == null || zzkf.getDurationUs() == -9223372036854775807L)) {
            this.zzbes = 0;
            this.zzbem = this.zzahc;
            int size = this.zzbeh.size();
            for (int i = 0; i < size; i++) {
                this.zzbeh.valueAt(i).zzl(!this.zzahc || this.zzbep[i]);
            }
            zzmv.zze(0, 0);
        }
        this.zzbeu = zzhy();
        return z ? 1 : 0;
    }

    public final /* synthetic */ void zza(zzpb zzpb, long j, long j2, boolean z) {
        zza((zzmv) zzpb);
        if (!z && this.zzben > 0) {
            int size = this.zzbeh.size();
            for (int i = 0; i < size; i++) {
                this.zzbeh.valueAt(i).zzl(this.zzbep[i]);
            }
            this.zzbei.zza(this);
        }
    }

    public final /* synthetic */ void zza(zzpb zzpb, long j, long j2) {
        zza((zzmv) zzpb);
        this.zzbev = true;
        if (this.zzaiz == -9223372036854775807L) {
            long zzhz = zzhz();
            long j3 = zzhz == Long.MIN_VALUE ? 0 : zzhz + 10000;
            this.zzaiz = j3;
            this.zzbdy.zzb(new zzns(j3, this.zzbej.isSeekable()), (Object) null);
        }
        this.zzbei.zza(this);
    }
}
