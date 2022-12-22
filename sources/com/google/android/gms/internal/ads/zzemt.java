package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzemv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzemt<T extends zzemv<T>> {
    private static final zzemt zziqv = new zzemt(true);
    final zzepn<T, Object> zziqs;
    private boolean zziqt;
    private boolean zziqu;

    private zzemt() {
        this.zziqs = zzepn.zzib(16);
    }

    private zzemt(boolean z) {
        this(zzepn.zzib(0));
        zzbhe();
    }

    private zzemt(zzepn<T, Object> zzepn) {
        this.zziqs = zzepn;
        zzbhe();
    }

    public static <T extends zzemv<T>> zzemt<T> zzbja() {
        return zziqv;
    }

    public final void zzbhe() {
        if (!this.zziqt) {
            this.zziqs.zzbhe();
            this.zziqt = true;
        }
    }

    public final boolean isImmutable() {
        return this.zziqt;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzemt)) {
            return false;
        }
        return this.zziqs.equals(((zzemt) obj).zziqs);
    }

    public final int hashCode() {
        return this.zziqs.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zziqu) {
            return new zzent(this.zziqs.entrySet().iterator());
        }
        return this.zziqs.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zziqu) {
            return new zzent(this.zziqs.zzblr().iterator());
        }
        return this.zziqs.zzblr().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zziqs.get(t);
        if (!(obj instanceof zzeno)) {
            return obj;
        }
        zzeno zzeno = (zzeno) obj;
        return zzeno.zzbki();
    }

    private final void zza(T t, Object obj) {
        if (!t.zzbje()) {
            zzb(t, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zzb(t, obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzeno) {
            this.zziqu = true;
        }
        this.zziqs.put(t, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        if ((r6 instanceof com.google.android.gms.internal.ads.zzenf) == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if ((r6 instanceof byte[]) == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r0 == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new java.lang.Object[]{java.lang.Integer.valueOf(r5.zzv()), r5.zzbjc().zzbmh(), r6.getClass().getName()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if ((r6 instanceof com.google.android.gms.internal.ads.zzeno) == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzb(T r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.ads.zzeqr r0 = r5.zzbjc()
            com.google.android.gms.internal.ads.zzenc.checkNotNull(r6)
            int[] r1 = com.google.android.gms.internal.ads.zzems.zziqr
            com.google.android.gms.internal.ads.zzequ r0 = r0.zzbmh()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L_0x0045;
                case 2: goto L_0x0042;
                case 3: goto L_0x003f;
                case 4: goto L_0x003c;
                case 5: goto L_0x0039;
                case 6: goto L_0x0036;
                case 7: goto L_0x002c;
                case 8: goto L_0x0023;
                case 9: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r0 = 0
            goto L_0x0047
        L_0x001a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzeon
            if (r0 != 0) goto L_0x0034
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzeno
            if (r0 == 0) goto L_0x0018
            goto L_0x0034
        L_0x0023:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x0034
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzenf
            if (r0 == 0) goto L_0x0018
            goto L_0x0034
        L_0x002c:
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzelq
            if (r0 != 0) goto L_0x0034
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L_0x0018
        L_0x0034:
            r0 = 1
            goto L_0x0047
        L_0x0036:
            boolean r0 = r6 instanceof java.lang.String
            goto L_0x0047
        L_0x0039:
            boolean r0 = r6 instanceof java.lang.Boolean
            goto L_0x0047
        L_0x003c:
            boolean r0 = r6 instanceof java.lang.Double
            goto L_0x0047
        L_0x003f:
            boolean r0 = r6 instanceof java.lang.Float
            goto L_0x0047
        L_0x0042:
            boolean r0 = r6 instanceof java.lang.Long
            goto L_0x0047
        L_0x0045:
            boolean r0 = r6 instanceof java.lang.Integer
        L_0x0047:
            if (r0 == 0) goto L_0x004a
            return
        L_0x004a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r5.zzv()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            com.google.android.gms.internal.ads.zzeqr r5 = r5.zzbjc()
            com.google.android.gms.internal.ads.zzequ r5 = r5.zzbmh()
            r3[r1] = r5
            r5 = 2
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getName()
            r3[r5] = r6
            java.lang.String r5 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r5 = java.lang.String.format(r5, r3)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemt.zzb(com.google.android.gms.internal.ads.zzemv, java.lang.Object):void");
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zziqs.zzblp(); i++) {
            if (!zzb(this.zziqs.zzic(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzb : this.zziqs.zzblq()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzemv<T>> boolean zzb(Map.Entry<T, Object> entry) {
        zzemv zzemv = (zzemv) entry.getKey();
        if (zzemv.zzbjd() == zzequ.MESSAGE) {
            if (zzemv.zzbje()) {
                for (zzeon isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzeon) {
                    if (!((zzeon) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzeno) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzemt<T> zzemt) {
        for (int i = 0; i < zzemt.zziqs.zzblp(); i++) {
            zzc(zzemt.zziqs.zzic(i));
        }
        for (Map.Entry<T, Object> zzc : zzemt.zziqs.zzblq()) {
            zzc(zzc);
        }
    }

    private static Object zzal(Object obj) {
        if (obj instanceof zzeos) {
            return ((zzeos) obj).zzbha();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        Object obj;
        zzemv zzemv = (zzemv) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzeno) {
            zzeno zzeno = (zzeno) value;
            value = zzeno.zzbki();
        }
        if (zzemv.zzbje()) {
            Object zza = zza(zzemv);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzal : (List) value) {
                ((List) zza).add(zzal(zzal));
            }
            this.zziqs.put(zzemv, zza);
        } else if (zzemv.zzbjd() == zzequ.MESSAGE) {
            Object zza2 = zza(zzemv);
            if (zza2 == null) {
                this.zziqs.put(zzemv, zzal(value));
                return;
            }
            if (zza2 instanceof zzeos) {
                obj = zzemv.zza((zzeos) zza2, (zzeos) value);
            } else {
                obj = zzemv.zza(((zzeon) zza2).zzbjn(), (zzeon) value).zzbjv();
            }
            this.zziqs.put(zzemv, obj);
        } else {
            this.zziqs.put(zzemv, zzal(value));
        }
    }

    static void zza(zzemk zzemk, zzeqr zzeqr, int i, Object obj) throws IOException {
        if (zzeqr == zzeqr.GROUP) {
            zzeon zzeon = (zzeon) obj;
            zzenc.zzk(zzeon);
            zzemk.writeTag(i, 3);
            zzeon.zzb(zzemk);
            zzemk.writeTag(i, 4);
            return;
        }
        zzemk.writeTag(i, zzeqr.zzbmi());
        switch (zzems.zziqb[zzeqr.ordinal()]) {
            case 1:
                zzemk.zzc(((Double) obj).doubleValue());
                return;
            case 2:
                zzemk.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzemk.zzfi(((Long) obj).longValue());
                return;
            case 4:
                zzemk.zzfi(((Long) obj).longValue());
                return;
            case 5:
                zzemk.zzgz(((Integer) obj).intValue());
                return;
            case 6:
                zzemk.zzfk(((Long) obj).longValue());
                return;
            case 7:
                zzemk.zzhc(((Integer) obj).intValue());
                return;
            case 8:
                zzemk.zzbw(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzeon) obj).zzb(zzemk);
                return;
            case 10:
                zzemk.zzg((zzeon) obj);
                return;
            case 11:
                if (obj instanceof zzelq) {
                    zzemk.zzai((zzelq) obj);
                    return;
                } else {
                    zzemk.zzia((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzelq) {
                    zzemk.zzai((zzelq) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzemk.zzk(bArr, 0, bArr.length);
                return;
            case 13:
                zzemk.zzha(((Integer) obj).intValue());
                return;
            case 14:
                zzemk.zzhc(((Integer) obj).intValue());
                return;
            case 15:
                zzemk.zzfk(((Long) obj).longValue());
                return;
            case 16:
                zzemk.zzhb(((Integer) obj).intValue());
                return;
            case 17:
                zzemk.zzfj(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzenf) {
                    zzemk.zzgz(((zzenf) obj).zzv());
                    return;
                } else {
                    zzemk.zzgz(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzbjb() {
        int i = 0;
        for (int i2 = 0; i2 < this.zziqs.zzblp(); i2++) {
            i += zzd(this.zziqs.zzic(i2));
        }
        for (Map.Entry<T, Object> zzd : this.zziqs.zzblq()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        zzemv zzemv = (zzemv) entry.getKey();
        Object value = entry.getValue();
        if (zzemv.zzbjd() != zzequ.MESSAGE || zzemv.zzbje() || zzemv.zzbjf()) {
            return zzc(zzemv, value);
        }
        if (value instanceof zzeno) {
            return zzemk.zzb(((zzemv) entry.getKey()).zzv(), (zzens) (zzeno) value);
        }
        return zzemk.zzb(((zzemv) entry.getKey()).zzv(), (zzeon) value);
    }

    static int zza(zzeqr zzeqr, int i, Object obj) {
        int zzhd = zzemk.zzhd(i);
        if (zzeqr == zzeqr.GROUP) {
            zzenc.zzk((zzeon) obj);
            zzhd <<= 1;
        }
        return zzhd + zza(zzeqr, obj);
    }

    private static int zza(zzeqr zzeqr, Object obj) {
        switch (zzems.zziqb[zzeqr.ordinal()]) {
            case 1:
                return zzemk.zzd(((Double) obj).doubleValue());
            case 2:
                return zzemk.zzg(((Float) obj).floatValue());
            case 3:
                return zzemk.zzfl(((Long) obj).longValue());
            case 4:
                return zzemk.zzfm(((Long) obj).longValue());
            case 5:
                return zzemk.zzhe(((Integer) obj).intValue());
            case 6:
                return zzemk.zzfo(((Long) obj).longValue());
            case 7:
                return zzemk.zzhh(((Integer) obj).intValue());
            case 8:
                return zzemk.zzbx(((Boolean) obj).booleanValue());
            case 9:
                return zzemk.zzi((zzeon) obj);
            case 10:
                if (obj instanceof zzeno) {
                    return zzemk.zza((zzeno) obj);
                }
                return zzemk.zzh((zzeon) obj);
            case 11:
                if (obj instanceof zzelq) {
                    return zzemk.zzaj((zzelq) obj);
                }
                return zzemk.zzib((String) obj);
            case 12:
                if (obj instanceof zzelq) {
                    return zzemk.zzaj((zzelq) obj);
                }
                return zzemk.zzw((byte[]) obj);
            case 13:
                return zzemk.zzhf(((Integer) obj).intValue());
            case 14:
                return zzemk.zzhi(((Integer) obj).intValue());
            case 15:
                return zzemk.zzfp(((Long) obj).longValue());
            case 16:
                return zzemk.zzhg(((Integer) obj).intValue());
            case 17:
                return zzemk.zzfn(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzenf) {
                    return zzemk.zzhj(((zzenf) obj).zzv());
                }
                return zzemk.zzhj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzc(zzemv<?> zzemv, Object obj) {
        zzeqr zzbjc = zzemv.zzbjc();
        int zzv = zzemv.zzv();
        if (!zzemv.zzbje()) {
            return zza(zzbjc, zzv, obj);
        }
        int i = 0;
        if (zzemv.zzbjf()) {
            for (Object zza : (List) obj) {
                i += zza(zzbjc, zza);
            }
            return zzemk.zzhd(zzv) + i + zzemk.zzhl(i);
        }
        for (Object zza2 : (List) obj) {
            i += zza(zzbjc, zzv, zza2);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzemt zzemt = new zzemt();
        for (int i = 0; i < this.zziqs.zzblp(); i++) {
            Map.Entry<T, Object> zzic = this.zziqs.zzic(i);
            zzemt.zza((zzemv) zzic.getKey(), zzic.getValue());
        }
        for (Map.Entry next : this.zziqs.zzblq()) {
            zzemt.zza((zzemv) next.getKey(), next.getValue());
        }
        zzemt.zziqu = this.zziqu;
        return zzemt;
    }
}
