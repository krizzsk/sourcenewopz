package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeot<T> implements zzepi<T> {
    private final zzeon zzivy;
    private final boolean zzivz;
    private final zzeqa<?, ?> zziwi;
    private final zzemp<?> zziwj;

    private zzeot(zzeqa<?, ?> zzeqa, zzemp<?> zzemp, zzeon zzeon) {
        this.zziwi = zzeqa;
        this.zzivz = zzemp.zzj(zzeon);
        this.zziwj = zzemp;
        this.zzivy = zzeon;
    }

    static <T> zzeot<T> zza(zzeqa<?, ?> zzeqa, zzemp<?> zzemp, zzeon zzeon) {
        return new zzeot<>(zzeqa, zzemp, zzeon);
    }

    public final T newInstance() {
        return this.zzivy.zzbjo().zzbju();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zziwi.zzay(t).equals(this.zziwi.zzay(t2))) {
            return false;
        }
        if (this.zzivz) {
            return this.zziwj.zzai(t).equals(this.zziwj.zzai(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zziwi.zzay(t).hashCode();
        return this.zzivz ? (hashCode * 53) + this.zziwj.zzai(t).hashCode() : hashCode;
    }

    public final void zzg(T t, T t2) {
        zzepk.zza(this.zziwi, t, t2);
        if (this.zzivz) {
            zzepk.zza(this.zziwj, t, t2);
        }
    }

    public final void zza(T t, zzeqx zzeqx) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zziwj.zzai(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzemv zzemv = (zzemv) next.getKey();
            if (zzemv.zzbjd() != zzequ.MESSAGE || zzemv.zzbje() || zzemv.zzbjf()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzenq) {
                zzeqx.zzc(zzemv.zzv(), ((zzenq) next).zzbkk().zzbgy());
            } else {
                zzeqx.zzc(zzemv.zzv(), next.getValue());
            }
        }
        zzeqa<?, ?> zzeqa = this.zziwi;
        zzeqa.zzc(zzeqa.zzay(t), zzeqx);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.ads.zzena$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.ads.zzell r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.ads.zzena r0 = (com.google.android.gms.internal.ads.zzena) r0
            com.google.android.gms.internal.ads.zzeqd r1 = r0.zzitn
            com.google.android.gms.internal.ads.zzeqd r2 = com.google.android.gms.internal.ads.zzeqd.zzbly()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.ads.zzeqd r1 = com.google.android.gms.internal.ads.zzeqd.zzblz()
            r0.zzitn = r1
        L_0x0011:
            com.google.android.gms.internal.ads.zzena$zzd r10 = (com.google.android.gms.internal.ads.zzena.zzd) r10
            r10.zzbjw()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.ads.zzelm.zza(r11, r12, r14)
            int r2 = r14.zziov
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.ads.zzemp<?> r12 = r9.zziwj
            com.google.android.gms.internal.ads.zzemn r0 = r14.zzioy
            com.google.android.gms.internal.ads.zzeon r3 = r9.zzivy
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.ads.zzena$zzf r0 = (com.google.android.gms.internal.ads.zzena.zzf) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.ads.zzelm.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzeqd) r6, (com.google.android.gms.internal.ads.zzell) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.ads.zzepb.zzble()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.ads.zzelm.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.ads.zzell) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.ads.zzelm.zza(r11, r4, r14)
            int r5 = r14.zziov
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.ads.zzelm.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zziox
            com.google.android.gms.internal.ads.zzelq r2 = (com.google.android.gms.internal.ads.zzelq) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.ads.zzepb.zzble()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.ads.zzelm.zza(r11, r4, r14)
            int r12 = r14.zziov
            com.google.android.gms.internal.ads.zzemp<?> r0 = r9.zziwj
            com.google.android.gms.internal.ads.zzemn r5 = r14.zzioy
            com.google.android.gms.internal.ads.zzeon r6 = r9.zzivy
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.ads.zzena$zzf r0 = (com.google.android.gms.internal.ads.zzena.zzf) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.ads.zzelm.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.ads.zzell) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzd(r12, r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.ads.zzenn r10 = com.google.android.gms.internal.ads.zzenn.zzbkg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeot.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzell):void");
    }

    public final void zza(T t, zzepc zzepc, zzemn zzemn) throws IOException {
        boolean z;
        zzeqa<?, ?> zzeqa = this.zziwi;
        zzemp<?> zzemp = this.zziwj;
        Object zzaz = zzeqa.zzaz(t);
        zzemt<?> zzaj = zzemp.zzaj(t);
        do {
            try {
                if (zzepc.zzbip() == Integer.MAX_VALUE) {
                    zzeqa.zzj(t, zzaz);
                    return;
                }
                int tag = zzepc.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzelq zzelq = null;
                    while (zzepc.zzbip() != Integer.MAX_VALUE) {
                        int tag2 = zzepc.getTag();
                        if (tag2 == 16) {
                            i = zzepc.zzbia();
                            obj = zzemp.zza(zzemn, this.zzivy, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzemp.zza(zzepc, obj, zzemn, zzaj);
                            } else {
                                zzelq = zzepc.zzbhz();
                            }
                        } else if (!zzepc.zzbiq()) {
                            break;
                        }
                    }
                    if (zzepc.getTag() != 12) {
                        throw zzenn.zzbkd();
                    } else if (zzelq != null) {
                        if (obj != null) {
                            zzemp.zza(zzelq, obj, zzemn, zzaj);
                        } else {
                            zzeqa.zza(zzaz, i, zzelq);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzemp.zza(zzemn, this.zzivy, tag >>> 3);
                    if (zza != null) {
                        zzemp.zza(zzepc, zza, zzemn, zzaj);
                    } else {
                        z = zzeqa.zza(zzaz, zzepc);
                        continue;
                    }
                } else {
                    z = zzepc.zzbiq();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzeqa.zzj(t, zzaz);
            }
        } while (z);
    }

    public final void zzak(T t) {
        this.zziwi.zzak(t);
        this.zziwj.zzak(t);
    }

    public final boolean zzaw(T t) {
        return this.zziwj.zzai(t).isInitialized();
    }

    public final int zzau(T t) {
        zzeqa<?, ?> zzeqa = this.zziwi;
        int zzba = zzeqa.zzba(zzeqa.zzay(t)) + 0;
        return this.zzivz ? zzba + this.zziwj.zzai(t).zzbjb() : zzba;
    }
}
