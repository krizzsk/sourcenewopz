package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcwr<AdT> implements zzear<zzdpi, AdT> {
    private final Executor executor;
    private final zzdun zzftm;
    private final zzdup zzftn;
    private final ScheduledExecutorService zzfvp;
    private final zzdtg zzfzh;
    private final zzctc zzfzp;
    private final zzbsx zzgcz;
    private final zzbph<AdT> zzgyh;
    private final zzcwk zzgyi;

    public zzcwr(zzdtg zzdtg, zzcwk zzcwk, zzbsx zzbsx, zzdun zzdun, zzdup zzdup, zzbph<AdT> zzbph, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzctc zzctc) {
        this.zzfzh = zzdtg;
        this.zzgyi = zzcwk;
        this.zzgcz = zzbsx;
        this.zzftm = zzdun;
        this.zzftn = zzdup;
        this.zzgyh = zzbph;
        this.executor = executor2;
        this.zzfvp = scheduledExecutorService;
        this.zzfzp = zzctc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzebt zzf(java.lang.Object r10) throws java.lang.Exception {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzdpi r10 = (com.google.android.gms.internal.ads.zzdpi) r10
            com.google.android.gms.internal.ads.zzdpg r0 = r10.zzhnt
            com.google.android.gms.internal.ads.zzdoy r0 = r0.zzeuy
            int r0 = r0.responseCode
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 300(0x12c, float:4.2E-43)
            if (r0 == 0) goto L_0x0044
            if (r0 < r1) goto L_0x0027
            if (r0 >= r2) goto L_0x0027
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcxf
            com.google.android.gms.internal.ads.zzabm r3 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0044
            java.lang.String r0 = "No fill."
            goto L_0x0046
        L_0x0027:
            if (r0 < r2) goto L_0x0030
            r3 = 400(0x190, float:5.6E-43)
            if (r0 >= r3) goto L_0x0030
            java.lang.String r0 = "No location header to follow redirect or too many redirects."
            goto L_0x0046
        L_0x0030:
            r3 = 46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Received error HTTP response code: "
            r4.append(r3)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            goto L_0x0046
        L_0x0044:
            java.lang.String r0 = "No ad config."
        L_0x0046:
            com.google.android.gms.internal.ads.zzdpg r3 = r10.zzhnt
            com.google.android.gms.internal.ads.zzdoy r3 = r3.zzeuy
            com.google.android.gms.internal.ads.zzdov r3 = r3.zzhni
            if (r3 == 0) goto L_0x0052
            java.lang.String r0 = r3.getDescription()
        L_0x0052:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabq.zzdba
            com.google.android.gms.internal.ads.zzabm r4 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzdpg r3 = r10.zzhnt
            com.google.android.gms.internal.ads.zzdoy r3 = r3.zzeuy
            int r3 = r3.responseCode
            if (r3 < r1) goto L_0x006e
            if (r3 < r2) goto L_0x007a
        L_0x006e:
            com.google.android.gms.internal.ads.zzcwo r10 = new com.google.android.gms.internal.ads.zzcwo
            com.google.android.gms.internal.ads.zzdqj r1 = com.google.android.gms.internal.ads.zzdqj.NO_FILL
            r10.<init>(r1, r0)
            com.google.android.gms.internal.ads.zzebt r10 = com.google.android.gms.internal.ads.zzebh.immediateFailedFuture(r10)
            return r10
        L_0x007a:
            com.google.android.gms.internal.ads.zzdtg r1 = r9.zzfzh
            com.google.android.gms.internal.ads.zzdth r2 = com.google.android.gms.internal.ads.zzdth.RENDER_CONFIG_INIT
            com.google.android.gms.internal.ads.zzdsw r1 = r1.zzt(r2)
            com.google.android.gms.internal.ads.zzcwo r2 = new com.google.android.gms.internal.ads.zzcwo
            com.google.android.gms.internal.ads.zzdqj r3 = com.google.android.gms.internal.ads.zzdqj.NO_FILL
            r2.<init>(r3, r0)
            com.google.android.gms.internal.ads.zzebt r0 = com.google.android.gms.internal.ads.zzebh.immediateFailedFuture(r2)
            com.google.android.gms.internal.ads.zzdsy r0 = r1.zze(r0)
            com.google.android.gms.internal.ads.zzdst r0 = r0.zzayi()
            com.google.android.gms.internal.ads.zzbsx r1 = r9.zzgcz
            com.google.android.gms.internal.ads.zzbkw r2 = new com.google.android.gms.internal.ads.zzbkw
            com.google.android.gms.internal.ads.zzdup r3 = r9.zzftn
            com.google.android.gms.internal.ads.zzdun r4 = r9.zzftm
            r2.<init>(r10, r3, r4)
            java.util.concurrent.Executor r3 = r9.executor
            r1.zza(r2, r3)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabq.zzdbb
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r2 = 0
            if (r1 == 0) goto L_0x0107
            com.google.android.gms.internal.ads.zzdpg r1 = r10.zzhnt
            java.util.List<com.google.android.gms.internal.ads.zzdot> r1 = r1.zzhnq
            java.util.Iterator r1 = r1.iterator()
        L_0x00c0:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0107
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzdot r3 = (com.google.android.gms.internal.ads.zzdot) r3
            com.google.android.gms.internal.ads.zzctc r4 = r9.zzfzp
            r4.zzd(r3)
            java.util.List<java.lang.String> r4 = r3.zzhly
            java.util.Iterator r4 = r4.iterator()
        L_0x00d7:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00f5
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzbph<AdT> r6 = r9.zzgyh
            int r7 = r3.zzhlz
            com.google.android.gms.internal.ads.zzcsz r5 = r6.zze(r7, r5)
            if (r5 == 0) goto L_0x00d7
            boolean r5 = r5.zza(r10, r3)
            if (r5 == 0) goto L_0x00d7
            r4 = 1
            goto L_0x00f6
        L_0x00f5:
            r4 = 0
        L_0x00f6:
            if (r4 != 0) goto L_0x00c0
            com.google.android.gms.internal.ads.zzctc r4 = r9.zzfzp
            r5 = 0
            com.google.android.gms.internal.ads.zzdqj r7 = com.google.android.gms.internal.ads.zzdqj.INTERNAL_ERROR
            r8 = 0
            com.google.android.gms.internal.ads.zzvh r7 = com.google.android.gms.internal.ads.zzdqh.zza(r7, r8, r8)
            r4.zza(r3, r5, r7)
            goto L_0x00c0
        L_0x0107:
            com.google.android.gms.internal.ads.zzdpg r1 = r10.zzhnt
            java.util.List<com.google.android.gms.internal.ads.zzdot> r1 = r1.zzhnq
            java.util.Iterator r1 = r1.iterator()
        L_0x010f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x017e
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzdot r3 = (com.google.android.gms.internal.ads.zzdot) r3
            java.util.List<java.lang.String> r4 = r3.zzhly
            java.util.Iterator r4 = r4.iterator()
        L_0x0121:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x017b
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzbph<AdT> r6 = r9.zzgyh
            int r7 = r3.zzhlz
            com.google.android.gms.internal.ads.zzcsz r6 = r6.zze(r7, r5)
            if (r6 == 0) goto L_0x0121
            boolean r7 = r6.zza(r10, r3)
            if (r7 == 0) goto L_0x0121
            com.google.android.gms.internal.ads.zzdtg r4 = r9.zzfzh
            com.google.android.gms.internal.ads.zzdth r7 = com.google.android.gms.internal.ads.zzdth.RENDER_CONFIG_WATERFALL
            com.google.android.gms.internal.ads.zzdsy r0 = r4.zza(r7, r0)
            java.lang.String r4 = java.lang.String.valueOf(r5)
            int r4 = r4.length()
            int r4 = r4 + 26
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r4)
            java.lang.String r4 = "render-config-"
            r7.append(r4)
            r7.append(r2)
            java.lang.String r4 = "-"
            r7.append(r4)
            r7.append(r5)
            java.lang.String r4 = r7.toString()
            com.google.android.gms.internal.ads.zzdsy r0 = r0.zzgv(r4)
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            com.google.android.gms.internal.ads.zzcwq r5 = new com.google.android.gms.internal.ads.zzcwq
            r5.<init>(r9, r10, r3, r6)
            com.google.android.gms.internal.ads.zzdsy r0 = r0.zza(r4, r5)
            com.google.android.gms.internal.ads.zzdst r0 = r0.zzayi()
        L_0x017b:
            int r2 = r2 + 1
            goto L_0x010f
        L_0x017e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcwr.zzf(java.lang.Object):com.google.android.gms.internal.ads.zzebt");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdpi zzdpi, zzdot zzdot, zzcsz zzcsz, Throwable th) throws Exception {
        return this.zzgyi.zza(zzdpi.zzhnt.zzeuy, zzdot, zzebh.zza(zzcsz.zzb(zzdpi, zzdot), (long) zzdot.zzhmr, TimeUnit.MILLISECONDS, this.zzfvp));
    }
}
