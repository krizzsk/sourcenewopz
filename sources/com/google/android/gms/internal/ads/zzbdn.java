package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbdn implements zzhg, zzil, zzmz, zzpd<zzon>, zzqk {
    private static int zzeqi;
    private static int zzeqj;
    private int bytesTransferred;
    private final Context context;
    private int zzbmc;
    private final String zzbwe;
    private final int zzbwf;
    private final zzbcp zzepi;
    private final zzbdo zzeqk;
    private final zzhy zzeql;
    private final zzhy zzeqm;
    private final zzob zzeqn;
    private zzhh zzeqo;
    private ByteBuffer zzeqp;
    private boolean zzeqq;
    private final WeakReference<zzbcs> zzeqr;
    private zzbdx zzeqs;
    private long zzeqt;
    private final ArrayList<zzot> zzequ;
    private volatile zzbdj zzeqv;
    private Set<WeakReference<zzbdh>> zzeqw = new HashSet();

    public zzbdn(Context context2, zzbcp zzbcp, zzbcs zzbcs) {
        this.context = context2;
        this.zzepi = zzbcp;
        this.zzeqr = new WeakReference<>(zzbcs);
        this.zzeqk = new zzbdo();
        this.zzeql = new zzqe(this.context, zzlx.zzbde, 0, zzj.zzegq, this, -1);
        this.zzeqm = new zzjc(zzlx.zzbde, zzj.zzegq, this);
        this.zzeqn = new zzoa();
        if (zzd.zzyz()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzd.zzed(sb.toString());
        }
        zzeqi++;
        int i = 0;
        zzhh zza = zzhl.zza(new zzhy[]{this.zzeqm, this.zzeql}, this.zzeqn, this.zzeqk);
        this.zzeqo = zza;
        zza.zza((zzhg) this);
        this.bytesTransferred = 0;
        this.zzeqt = 0;
        this.zzbmc = 0;
        this.zzequ = new ArrayList<>();
        this.zzeqv = null;
        this.zzbwe = (zzbcs == null || zzbcs.zzabz() == null) ? "" : zzbcs.zzabz();
        this.zzbwf = zzbcs != null ? zzbcs.zzaca() : i;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcng)).booleanValue()) {
            this.zzeqo.zzer();
        }
        if (zzbcs != null && zzbcs.zzacg() > 0) {
            this.zzeqo.zzv(zzbcs.zzacg());
        }
        if (zzbcs != null && zzbcs.zzach() > 0) {
            this.zzeqo.zzw(zzbcs.zzach());
        }
    }

    public final void zza(zzhz zzhz) {
    }

    public final void zza(zzid zzid, Object obj) {
    }

    public final void zza(zznu zznu, zzoi zzoi) {
    }

    public final void zzaa(int i) {
    }

    public final void zzb(int i, long j, long j2) {
    }

    public final void zzb(Surface surface) {
    }

    public final void zzb(String str, long j, long j2) {
    }

    public final void zzc(zzjm zzjm) {
    }

    public final void zzd(zzjm zzjm) {
    }

    public final void zzd(String str, long j, long j2) {
    }

    public final void zze(zzjm zzjm) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    public final void zzen() {
    }

    public final void zzf(zzjm zzjm) {
    }

    public final void zzg(boolean z) {
    }

    public final zzhh zzadd() {
        return this.zzeqo;
    }

    public static int zzade() {
        return zzeqi;
    }

    public static int zzadf() {
        return zzeqj;
    }

    private static long zzk(Map<String, List<String>> map) {
        if (map == null) {
            return 0;
        }
        for (Map.Entry next : map.entrySet()) {
            if (next != null) {
                try {
                    if (!(next.getKey() == null || !zzdxo.zza("content-length", (CharSequence) next.getKey()) || next.getValue() == null || ((List) next.getValue()).get(0) == null)) {
                        return Long.parseLong((String) ((List) next.getValue()).get(0));
                    }
                } catch (NumberFormatException unused) {
                    continue;
                }
            }
        }
        return 0;
    }

    public final void zza(zzbdx zzbdx) {
        this.zzeqs = zzbdx;
    }

    public final zzbdo zzadg() {
        return this.zzeqk;
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzne zzne;
        if (this.zzeqo != null) {
            this.zzeqp = byteBuffer;
            this.zzeqq = z;
            if (uriArr.length == 1) {
                zzne = zzb(uriArr[0], str);
            } else {
                zzne[] zzneArr = new zzne[uriArr.length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzneArr[i] = zzb(uriArr[i], str);
                }
                zzne = new zznf(zzneArr);
            }
            this.zzeqo.zza(zzne);
            zzeqj++;
        }
    }

    public final void release() {
        zzhh zzhh = this.zzeqo;
        if (zzhh != null) {
            zzhh.zzb((zzhg) this);
            this.zzeqo.release();
            this.zzeqo = null;
            zzeqj--;
        }
    }

    public final long getBytesTransferred() {
        return (long) this.bytesTransferred;
    }

    private final boolean zzacz() {
        return this.zzeqv != null && this.zzeqv.zzacz();
    }

    public final long zzaba() {
        if (!zzacz()) {
            return (long) this.bytesTransferred;
        }
        return 0;
    }

    public final long zznh() {
        if (zzacz() && this.zzeqv.zzni()) {
            return Math.min((long) this.bytesTransferred, this.zzeqv.zznh());
        }
        return 0;
    }

    public final long getTotalBytes() {
        if (zzacz()) {
            return this.zzeqv.getContentLength();
        }
        while (!this.zzequ.isEmpty()) {
            this.zzeqt += zzk(this.zzequ.remove(0).getResponseHeaders());
        }
        return this.zzeqt;
    }

    public final int zzabb() {
        return this.zzbmc;
    }

    public final void zzb(IOException iOException) {
        if (this.zzeqs == null) {
            return;
        }
        if (this.zzepi.zzens) {
            this.zzeqs.zzc("onLoadException", iOException);
        } else {
            this.zzeqs.zzb("onLoadError", (Exception) iOException);
        }
    }

    public final void zzk(zzht zzht) {
        zzbcs zzbcs = (zzbcs) this.zzeqr.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() && zzbcs != null && zzht != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzht.zzahs));
            hashMap.put("bitRate", String.valueOf(zzht.zzahk));
            int i = zzht.width;
            int i2 = zzht.height;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            hashMap.put("resolution", sb.toString());
            hashMap.put("videoMime", zzht.zzahn);
            hashMap.put("videoSampleMime", zzht.zzaho);
            hashMap.put("videoCodec", zzht.zzahl);
            zzbcs.zza("onMetadataEvent", (Map<String, ?>) hashMap);
        }
    }

    public final void zzg(int i, long j) {
        this.zzbmc += i;
    }

    public final void zzb(int i, int i2, int i3, float f) {
        zzbdx zzbdx = this.zzeqs;
        if (zzbdx != null) {
            zzbdx.zzp(i, i2);
        }
    }

    public final void zzc(zzht zzht) {
        zzbcs zzbcs = (zzbcs) this.zzeqr.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() && zzbcs != null && zzht != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzht.zzahn);
            hashMap.put("audioSampleMime", zzht.zzaho);
            hashMap.put("audioCodec", zzht.zzahl);
            zzbcs.zza("onMetadataEvent", (Map<String, ?>) hashMap);
        }
    }

    public final void zza(boolean z, int i) {
        zzbdx zzbdx = this.zzeqs;
        if (zzbdx != null) {
            zzbdx.zzdy(i);
        }
    }

    public final void zza(zzhe zzhe) {
        zzbdx zzbdx = this.zzeqs;
        if (zzbdx != null) {
            zzbdx.zzb("onPlayerError", (Exception) zzhe);
        }
    }

    public final void zzdu(int i) {
        for (WeakReference<zzbdh> weakReference : this.zzeqw) {
            zzbdh zzbdh = (zzbdh) weakReference.get();
            if (zzbdh != null) {
                zzbdh.setReceiveBufferSize(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Surface surface, boolean z) {
        if (this.zzeqo != null) {
            zzhi zzhi = new zzhi(this.zzeql, 1, surface);
            if (z) {
                this.zzeqo.zzb(zzhi);
                return;
            }
            this.zzeqo.zza(zzhi);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(float f, boolean z) {
        if (this.zzeqo != null) {
            zzhi zzhi = new zzhi(this.zzeqm, 2, Float.valueOf(f));
            if (z) {
                this.zzeqo.zzb(zzhi);
                return;
            }
            this.zzeqo.zza(zzhi);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzba(boolean z) {
        if (this.zzeqo != null) {
            for (int i = 0; i < this.zzeqo.zzep(); i++) {
                this.zzeqn.zzf(i, !z);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0044, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzww.zzra().zzd(com.google.android.gms.internal.ads.zzabq.zzcsd)).booleanValue() == false) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzne zzb(android.net.Uri r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzna r9 = new com.google.android.gms.internal.ads.zzna
            boolean r0 = r10.zzeqq
            if (r0 == 0) goto L_0x0022
            java.nio.ByteBuffer r0 = r10.zzeqp
            int r0 = r0.limit()
            if (r0 <= 0) goto L_0x0022
            java.nio.ByteBuffer r12 = r10.zzeqp
            int r12 = r12.limit()
            byte[] r12 = new byte[r12]
            java.nio.ByteBuffer r0 = r10.zzeqp
            r0.get(r12)
            com.google.android.gms.internal.ads.zzbdp r0 = new com.google.android.gms.internal.ads.zzbdp
            r0.<init>(r12)
            r2 = r0
            goto L_0x008a
        L_0x0022:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcsf
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcsd
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x004c
        L_0x0046:
            com.google.android.gms.internal.ads.zzbcp r0 = r10.zzepi
            boolean r0 = r0.zzenq
            if (r0 != 0) goto L_0x004e
        L_0x004c:
            r0 = 1
            goto L_0x004f
        L_0x004e:
            r0 = 0
        L_0x004f:
            com.google.android.gms.internal.ads.zzbcp r1 = r10.zzepi
            int r1 = r1.zzenp
            if (r1 <= 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzbds r1 = new com.google.android.gms.internal.ads.zzbds
            r1.<init>(r10, r12, r0)
            goto L_0x0060
        L_0x005b:
            com.google.android.gms.internal.ads.zzbdr r1 = new com.google.android.gms.internal.ads.zzbdr
            r1.<init>(r10, r12, r0)
        L_0x0060:
            com.google.android.gms.internal.ads.zzbcp r12 = r10.zzepi
            boolean r12 = r12.zzenq
            if (r12 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzbdu r12 = new com.google.android.gms.internal.ads.zzbdu
            r12.<init>(r10, r1)
            r1 = r12
        L_0x006c:
            java.nio.ByteBuffer r12 = r10.zzeqp
            if (r12 == 0) goto L_0x0089
            int r12 = r12.limit()
            if (r12 <= 0) goto L_0x0089
            java.nio.ByteBuffer r12 = r10.zzeqp
            int r12 = r12.limit()
            byte[] r12 = new byte[r12]
            java.nio.ByteBuffer r0 = r10.zzeqp
            r0.get(r12)
            com.google.android.gms.internal.ads.zzbdt r0 = new com.google.android.gms.internal.ads.zzbdt
            r0.<init>(r1, r12)
            r1 = r0
        L_0x0089:
            r2 = r1
        L_0x008a:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r12 = com.google.android.gms.internal.ads.zzabq.zzcnf
            com.google.android.gms.internal.ads.zzabm r0 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r12 = r0.zzd(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x009f
            com.google.android.gms.internal.ads.zzkb r12 = com.google.android.gms.internal.ads.zzbdw.zzeri
            goto L_0x00a1
        L_0x009f:
            com.google.android.gms.internal.ads.zzkb r12 = com.google.android.gms.internal.ads.zzbdv.zzeri
        L_0x00a1:
            r3 = r12
            com.google.android.gms.internal.ads.zzbcp r12 = r10.zzepi
            int r4 = r12.zzenr
            com.google.android.gms.internal.ads.zzdxi r5 = com.google.android.gms.ads.internal.util.zzj.zzegq
            r7 = 0
            com.google.android.gms.internal.ads.zzbcp r12 = r10.zzepi
            int r8 = r12.zzenn
            r0 = r9
            r1 = r11
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdn.zzb(android.net.Uri, java.lang.String):com.google.android.gms.internal.ads.zzne");
    }

    public final void finalize() throws Throwable {
        zzeqi--;
        if (zzd.zzyz()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzd.zzed(sb.toString());
        }
    }

    public final /* synthetic */ void zzc(Object obj, int i) {
        this.bytesTransferred += i;
    }

    public final /* synthetic */ void zza(Object obj, zzos zzos) {
        zzon zzon = (zzon) obj;
        if (zzon instanceof zzot) {
            this.zzequ.add((zzot) zzon);
        } else if (zzon instanceof zzbdj) {
            this.zzeqv = (zzbdj) zzon;
            zzbcs zzbcs = (zzbcs) this.zzeqr.get();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() && zzbcs != null && this.zzeqv.zznf()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzeqv.zzni()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzeqv.zzada()));
                zzj.zzegq.post(new zzbdq(zzbcs, hashMap));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzon zza(zzoq zzoq) {
        return new zzbdj(this.context, zzoq.zzit(), this.zzbwe, this.zzbwf, this, new zzbdy(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(boolean z, long j) {
        zzbdx zzbdx = this.zzeqs;
        if (zzbdx != null) {
            zzbdx.zzb(z, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzon zzi(String str, boolean z) {
        return new zzou(str, (zzpp<String>) null, z ? this : null, this.zzepi.zzenk, this.zzepi.zzenm, true, (zzox) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzon zzj(String str, boolean z) {
        zzbdh zzbdh = new zzbdh(str, z ? this : null, this.zzepi.zzenk, this.zzepi.zzenm, this.zzepi.zzenp);
        this.zzeqw.add(new WeakReference(zzbdh));
        return zzbdh;
    }
}
