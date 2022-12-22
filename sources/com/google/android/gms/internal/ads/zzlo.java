package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzlo implements zzka, zzkf {
    private static final zzkb zzapu = new zzln();
    private static final int zzbaj = zzpt.zzbh("qt  ");
    private long zzaiz;
    private final zzpn zzaqb = new zzpn(zzpm.zzbkd);
    private final zzpn zzaqc = new zzpn(4);
    private int zzarq;
    private int zzarr;
    private zzkc zzaru;
    private final zzpn zzayb = new zzpn(16);
    private final Stack<zzkv> zzayd = new Stack<>();
    private int zzayf;
    private int zzayg;
    private long zzayh;
    private int zzayi;
    private zzpn zzayj;
    private zzlq[] zzbak;
    private boolean zzbal;

    public final boolean isSeekable() {
        return true;
    }

    public final void release() {
    }

    public final boolean zza(zzjz zzjz) throws IOException, InterruptedException {
        return zzlp.zze(zzjz);
    }

    public final void zza(zzkc zzkc) {
        this.zzaru = zzkc;
    }

    public final void zzc(long j, long j2) {
        this.zzayd.clear();
        this.zzayi = 0;
        this.zzarr = 0;
        this.zzarq = 0;
        if (j == 0) {
            zzhf();
            return;
        }
        zzlq[] zzlqArr = this.zzbak;
        if (zzlqArr != null) {
            for (zzlq zzlq : zzlqArr) {
                zzlt zzlt = zzlq.zzban;
                int zzec = zzlt.zzec(j2);
                if (zzec == -1) {
                    zzec = zzlt.zzed(j2);
                }
                zzlq.zzaxq = zzec;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:151:0x0196 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02ac A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0193  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjz r24, com.google.android.gms.internal.ads.zzkg r25) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
        L_0x0006:
            int r3 = r0.zzayf
            r4 = -1
            r5 = 8
            r6 = 1
            if (r3 == 0) goto L_0x0198
            r8 = 262144(0x40000, double:1.295163E-318)
            r10 = 2
            if (r3 == r6) goto L_0x0115
            if (r3 != r10) goto L_0x010f
            r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = 0
            r5 = -1
        L_0x001d:
            com.google.android.gms.internal.ads.zzlq[] r14 = r0.zzbak
            int r15 = r14.length
            if (r3 >= r15) goto L_0x003b
            r14 = r14[r3]
            int r15 = r14.zzaxq
            com.google.android.gms.internal.ads.zzlt r11 = r14.zzban
            int r11 = r11.zzaxm
            if (r15 == r11) goto L_0x0038
            com.google.android.gms.internal.ads.zzlt r11 = r14.zzban
            long[] r11 = r11.zzapf
            r14 = r11[r15]
            int r11 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r11 >= 0) goto L_0x0038
            r5 = r3
            r12 = r14
        L_0x0038:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x003b:
            if (r5 != r4) goto L_0x003e
            return r4
        L_0x003e:
            r3 = r14[r5]
            com.google.android.gms.internal.ads.zzkh r4 = r3.zzbao
            int r5 = r3.zzaxq
            com.google.android.gms.internal.ads.zzlt r11 = r3.zzban
            long[] r11 = r11.zzapf
            r12 = r11[r5]
            com.google.android.gms.internal.ads.zzlt r11 = r3.zzban
            int[] r11 = r11.zzape
            r11 = r11[r5]
            com.google.android.gms.internal.ads.zzls r14 = r3.zzbac
            int r14 = r14.zzbat
            if (r14 != r6) goto L_0x005b
            r14 = 8
            long r12 = r12 + r14
            int r11 = r11 + -8
        L_0x005b:
            long r14 = r24.getPosition()
            long r14 = r12 - r14
            int r10 = r0.zzarr
            long r6 = (long) r10
            long r14 = r14 + r6
            r6 = 0
            int r10 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r10 < 0) goto L_0x010b
            int r6 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0071
            goto L_0x010b
        L_0x0071:
            int r2 = (int) r14
            r1.zzaj(r2)
            com.google.android.gms.internal.ads.zzls r2 = r3.zzbac
            int r2 = r2.zzata
            if (r2 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaqc
            byte[] r2 = r2.data
            r6 = 0
            r2[r6] = r6
            r7 = 1
            r2[r7] = r6
            r7 = 2
            r2[r7] = r6
            com.google.android.gms.internal.ads.zzls r2 = r3.zzbac
            int r2 = r2.zzata
            com.google.android.gms.internal.ads.zzls r6 = r3.zzbac
            int r6 = r6.zzata
            r7 = 4
            int r6 = 4 - r6
        L_0x0093:
            int r7 = r0.zzarr
            if (r7 >= r11) goto L_0x00e8
            int r7 = r0.zzarq
            if (r7 != 0) goto L_0x00c2
            com.google.android.gms.internal.ads.zzpn r7 = r0.zzaqc
            byte[] r7 = r7.data
            r1.readFully(r7, r6, r2)
            com.google.android.gms.internal.ads.zzpn r7 = r0.zzaqc
            r8 = 0
            r7.zzbl(r8)
            com.google.android.gms.internal.ads.zzpn r7 = r0.zzaqc
            int r7 = r7.zzje()
            r0.zzarq = r7
            com.google.android.gms.internal.ads.zzpn r7 = r0.zzaqb
            r7.zzbl(r8)
            com.google.android.gms.internal.ads.zzpn r7 = r0.zzaqb
            r9 = 4
            r4.zza(r7, r9)
            int r7 = r0.zzarr
            int r7 = r7 + r9
            r0.zzarr = r7
            int r11 = r11 + r6
            goto L_0x0093
        L_0x00c2:
            r8 = 0
            int r7 = r4.zza(r1, r7, r8)
            int r8 = r0.zzarr
            int r8 = r8 + r7
            r0.zzarr = r8
            int r8 = r0.zzarq
            int r8 = r8 - r7
            r0.zzarq = r8
            goto L_0x0093
        L_0x00d2:
            int r2 = r0.zzarr
            if (r2 >= r11) goto L_0x00e8
            int r2 = r11 - r2
            r6 = 0
            int r2 = r4.zza(r1, r2, r6)
            int r6 = r0.zzarr
            int r6 = r6 + r2
            r0.zzarr = r6
            int r6 = r0.zzarq
            int r6 = r6 - r2
            r0.zzarq = r6
            goto L_0x00d2
        L_0x00e8:
            r20 = r11
            com.google.android.gms.internal.ads.zzlt r1 = r3.zzban
            long[] r1 = r1.zzbax
            r17 = r1[r5]
            com.google.android.gms.internal.ads.zzlt r1 = r3.zzban
            int[] r1 = r1.zzayv
            r19 = r1[r5]
            r21 = 0
            r22 = 0
            r16 = r4
            r16.zza(r17, r19, r20, r21, r22)
            int r1 = r3.zzaxq
            r4 = 1
            int r1 = r1 + r4
            r3.zzaxq = r1
            r1 = 0
            r0.zzarr = r1
            r0.zzarq = r1
            return r1
        L_0x010b:
            r4 = 1
            r2.position = r12
            return r4
        L_0x010f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0115:
            long r3 = r0.zzayh
            int r6 = r0.zzayi
            long r6 = (long) r6
            long r3 = r3 - r6
            long r6 = r24.getPosition()
            long r6 = r6 + r3
            com.google.android.gms.internal.ads.zzpn r10 = r0.zzayj
            if (r10 == 0) goto L_0x0175
            byte[] r8 = r10.data
            int r9 = r0.zzayi
            int r4 = (int) r3
            r1.readFully(r8, r9, r4)
            int r3 = r0.zzayg
            int r4 = com.google.android.gms.internal.ads.zzkw.zzath
            if (r3 != r4) goto L_0x0158
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzayj
            r3.zzbl(r5)
            int r4 = r3.readInt()
            int r5 = zzbaj
            if (r4 != r5) goto L_0x0141
        L_0x013f:
            r3 = 1
            goto L_0x0155
        L_0x0141:
            r4 = 4
            r3.zzbm(r4)
        L_0x0145:
            int r4 = r3.zziz()
            if (r4 <= 0) goto L_0x0154
            int r4 = r3.readInt()
            int r5 = zzbaj
            if (r4 != r5) goto L_0x0145
            goto L_0x013f
        L_0x0154:
            r3 = 0
        L_0x0155:
            r0.zzbal = r3
            goto L_0x017d
        L_0x0158:
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r3 = r0.zzayd
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x017d
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r3 = r0.zzayd
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzkv r3 = (com.google.android.gms.internal.ads.zzkv) r3
            com.google.android.gms.internal.ads.zzky r4 = new com.google.android.gms.internal.ads.zzky
            int r5 = r0.zzayg
            com.google.android.gms.internal.ads.zzpn r8 = r0.zzayj
            r4.<init>(r5, r8)
            r3.zza((com.google.android.gms.internal.ads.zzky) r4)
            goto L_0x017d
        L_0x0175:
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x017f
            int r4 = (int) r3
            r1.zzaj(r4)
        L_0x017d:
            r3 = 0
            goto L_0x0187
        L_0x017f:
            long r8 = r24.getPosition()
            long r8 = r8 + r3
            r2.position = r8
            r3 = 1
        L_0x0187:
            r0.zzeb(r6)
            if (r3 == 0) goto L_0x0193
            int r3 = r0.zzayf
            r4 = 2
            if (r3 == r4) goto L_0x0193
            r7 = 1
            goto L_0x0194
        L_0x0193:
            r7 = 0
        L_0x0194:
            if (r7 == 0) goto L_0x0006
            r3 = 1
            return r3
        L_0x0198:
            r3 = 1
            int r6 = r0.zzayi
            if (r6 != 0) goto L_0x01c2
            com.google.android.gms.internal.ads.zzpn r6 = r0.zzayb
            byte[] r6 = r6.data
            r7 = 0
            boolean r6 = r1.zza(r6, r7, r5, r3)
            if (r6 != 0) goto L_0x01ab
            r6 = 0
            goto L_0x02aa
        L_0x01ab:
            r0.zzayi = r5
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzayb
            r3.zzbl(r7)
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzayb
            long r6 = r3.zzjb()
            r0.zzayh = r6
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzayb
            int r3 = r3.readInt()
            r0.zzayg = r3
        L_0x01c2:
            long r6 = r0.zzayh
            r8 = 1
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x01de
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzayb
            byte[] r3 = r3.data
            r1.readFully(r3, r5, r5)
            int r3 = r0.zzayi
            int r3 = r3 + r5
            r0.zzayi = r3
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzayb
            long r6 = r3.zzjf()
            r0.zzayh = r6
        L_0x01de:
            int r3 = r0.zzayg
            int r6 = com.google.android.gms.internal.ads.zzkw.zzaui
            if (r3 == r6) goto L_0x01fb
            int r6 = com.google.android.gms.internal.ads.zzkw.zzauk
            if (r3 == r6) goto L_0x01fb
            int r6 = com.google.android.gms.internal.ads.zzkw.zzaul
            if (r3 == r6) goto L_0x01fb
            int r6 = com.google.android.gms.internal.ads.zzkw.zzaum
            if (r3 == r6) goto L_0x01fb
            int r6 = com.google.android.gms.internal.ads.zzkw.zzaun
            if (r3 == r6) goto L_0x01fb
            int r6 = com.google.android.gms.internal.ads.zzkw.zzauw
            if (r3 != r6) goto L_0x01f9
            goto L_0x01fb
        L_0x01f9:
            r6 = 0
            goto L_0x01fc
        L_0x01fb:
            r6 = 1
        L_0x01fc:
            if (r6 == 0) goto L_0x0228
            long r5 = r24.getPosition()
            long r7 = r0.zzayh
            long r5 = r5 + r7
            int r3 = r0.zzayi
            long r7 = (long) r3
            long r5 = r5 - r7
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r3 = r0.zzayd
            com.google.android.gms.internal.ads.zzkv r7 = new com.google.android.gms.internal.ads.zzkv
            int r8 = r0.zzayg
            r7.<init>(r8, r5)
            r3.add(r7)
            long r7 = r0.zzayh
            int r3 = r0.zzayi
            long r9 = (long) r3
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0222
            r0.zzeb(r5)
            goto L_0x0225
        L_0x0222:
            r23.zzhf()
        L_0x0225:
            r3 = 1
            goto L_0x02a9
        L_0x0228:
            int r3 = r0.zzayg
            int r6 = com.google.android.gms.internal.ads.zzkw.zzauy
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzauj
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzauz
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzava
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzavt
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzavu
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzavv
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzaux
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzavw
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzavx
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzavy
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzavz
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzawa
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzauv
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzath
            if (r3 == r6) goto L_0x026d
            int r6 = com.google.android.gms.internal.ads.zzkw.zzawh
            if (r3 != r6) goto L_0x026b
            goto L_0x026d
        L_0x026b:
            r6 = 0
            goto L_0x026e
        L_0x026d:
            r6 = 1
        L_0x026e:
            if (r6 == 0) goto L_0x02a3
            int r3 = r0.zzayi
            if (r3 != r5) goto L_0x0276
            r6 = 1
            goto L_0x0277
        L_0x0276:
            r6 = 0
        L_0x0277:
            com.google.android.gms.internal.ads.zzpg.checkState(r6)
            long r6 = r0.zzayh
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 > 0) goto L_0x0285
            r6 = 1
            goto L_0x0286
        L_0x0285:
            r6 = 0
        L_0x0286:
            com.google.android.gms.internal.ads.zzpg.checkState(r6)
            com.google.android.gms.internal.ads.zzpn r3 = new com.google.android.gms.internal.ads.zzpn
            long r6 = r0.zzayh
            int r7 = (int) r6
            r3.<init>((int) r7)
            r0.zzayj = r3
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzayb
            byte[] r3 = r3.data
            com.google.android.gms.internal.ads.zzpn r6 = r0.zzayj
            byte[] r6 = r6.data
            r7 = 0
            java.lang.System.arraycopy(r3, r7, r6, r7, r5)
            r3 = 1
            r0.zzayf = r3
            goto L_0x02a9
        L_0x02a3:
            r3 = 1
            r5 = 0
            r0.zzayj = r5
            r0.zzayf = r3
        L_0x02a9:
            r6 = 1
        L_0x02aa:
            if (r6 != 0) goto L_0x0006
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlo.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkg):int");
    }

    public final long getDurationUs() {
        return this.zzaiz;
    }

    public final long zzdz(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzlq zzlq : this.zzbak) {
            zzlt zzlt = zzlq.zzban;
            int zzec = zzlt.zzec(j);
            if (zzec == -1) {
                zzec = zzlt.zzed(j);
            }
            long j3 = zzlt.zzapf[zzec];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private final void zzhf() {
        this.zzayf = 0;
        this.zzayi = 0;
    }

    private final void zzeb(long j) throws zzhw {
        zzmh zzmh;
        zzke zzke;
        zzls zza;
        while (!this.zzayd.isEmpty() && this.zzayd.peek().zzate == j) {
            zzkv pop = this.zzayd.pop();
            if (pop.type == zzkw.zzaui) {
                long j2 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                long j3 = Long.MAX_VALUE;
                zzmh zzmh2 = null;
                zzke zzke2 = new zzke();
                zzky zzas = pop.zzas(zzkw.zzawh);
                if (!(zzas == null || (zzmh2 = zzkx.zza(zzas, this.zzbal)) == null)) {
                    zzke2.zzb(zzmh2);
                }
                int i = 0;
                while (i < pop.zzatg.size()) {
                    zzkv zzkv = pop.zzatg.get(i);
                    if (zzkv.type == zzkw.zzauk && (zza = zzkx.zza(zzkv, pop.zzas(zzkw.zzauj), -9223372036854775807L, (zzjo) null, this.zzbal)) != null) {
                        zzlt zza2 = zzkx.zza(zza, zzkv.zzat(zzkw.zzaul).zzat(zzkw.zzaum).zzat(zzkw.zzaun), zzke2);
                        if (zza2.zzaxm != 0) {
                            zzlq zzlq = new zzlq(zza, zza2, this.zzaru.zze(i, zza.type));
                            zzht zzy = zza.zzaij.zzy(zza2.zzayt + 30);
                            if (zza.type == 1) {
                                if (zzke2.zzgx()) {
                                    zzy = zzy.zzd(zzke2.zzaib, zzke2.zzaic);
                                }
                                if (zzmh2 != null) {
                                    zzy = zzy.zza(zzmh2);
                                }
                            }
                            zzlq.zzbao.zze(zzy);
                            zzmh = zzmh2;
                            zzke = zzke2;
                            j2 = Math.max(j2, zza.zzaiz);
                            arrayList.add(zzlq);
                            long j4 = zza2.zzapf[0];
                            if (j4 < j3) {
                                j3 = j4;
                            }
                            i++;
                            zzke2 = zzke;
                            zzmh2 = zzmh;
                        }
                    }
                    zzmh = zzmh2;
                    zzke = zzke2;
                    i++;
                    zzke2 = zzke;
                    zzmh2 = zzmh;
                }
                this.zzaiz = j2;
                this.zzbak = (zzlq[]) arrayList.toArray(new zzlq[arrayList.size()]);
                this.zzaru.zzgw();
                this.zzaru.zza(this);
                this.zzayd.clear();
                this.zzayf = 2;
            } else if (!this.zzayd.isEmpty()) {
                this.zzayd.peek().zza(pop);
            }
        }
        if (this.zzayf != 2) {
            zzhf();
        }
    }
}
