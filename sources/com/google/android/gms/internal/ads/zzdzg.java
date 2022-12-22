package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdzg<E> extends zzdyy<E> {
    private int zzaih;
    @NullableDecl
    private Object[] zzibc;

    public zzdzg() {
        super(4);
    }

    zzdzg(int i) {
        super(i);
        this.zzibc = new Object[zzdzd.zzez(i)];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.internal.ads.zzdzu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.google.android.gms.internal.ads.zzdzd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: com.google.android.gms.internal.ads.zzdzu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: com.google.android.gms.internal.ads.zzdzu} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzdzd<E> zzbar() {
        /*
            r8 = this;
            int r0 = r8.size
            if (r0 == 0) goto L_0x005b
            r1 = 1
            if (r0 == r1) goto L_0x0051
            java.lang.Object[] r0 = r8.zzibc
            if (r0 == 0) goto L_0x003d
            int r0 = r8.size
            int r0 = com.google.android.gms.internal.ads.zzdzd.zzez(r0)
            java.lang.Object[] r2 = r8.zzibc
            int r2 = r2.length
            if (r0 != r2) goto L_0x003d
            int r0 = r8.size
            java.lang.Object[] r2 = r8.zziaq
            int r2 = r2.length
            boolean r0 = com.google.android.gms.internal.ads.zzdzd.zzy(r0, r2)
            if (r0 == 0) goto L_0x002a
            java.lang.Object[] r0 = r8.zziaq
            int r2 = r8.size
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
            goto L_0x002c
        L_0x002a:
            java.lang.Object[] r0 = r8.zziaq
        L_0x002c:
            r3 = r0
            com.google.android.gms.internal.ads.zzdzu r0 = new com.google.android.gms.internal.ads.zzdzu
            int r4 = r8.zzaih
            java.lang.Object[] r5 = r8.zzibc
            int r2 = r5.length
            int r6 = r2 + -1
            int r7 = r8.size
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x004b
        L_0x003d:
            int r0 = r8.size
            java.lang.Object[] r2 = r8.zziaq
            com.google.android.gms.internal.ads.zzdzd r0 = com.google.android.gms.internal.ads.zzdzd.zza(r0, r2)
            int r2 = r0.size()
            r8.size = r2
        L_0x004b:
            r8.zziar = r1
            r1 = 0
            r8.zzibc = r1
            return r0
        L_0x0051:
            java.lang.Object[] r0 = r8.zziaq
            r1 = 0
            r0 = r0[r1]
            com.google.android.gms.internal.ads.zzdzd r0 = com.google.android.gms.internal.ads.zzdzd.zzad(r0)
            return r0
        L_0x005b:
            com.google.android.gms.internal.ads.zzdzu<java.lang.Object> r0 = com.google.android.gms.internal.ads.zzdzu.zzibp
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdzg.zzbar():com.google.android.gms.internal.ads.zzdzd");
    }

    public final /* synthetic */ zzdyx zzg(Iterable iterable) {
        zzdyi.checkNotNull(iterable);
        if (this.zzibc != null) {
            for (Object zzaa : iterable) {
                zzaa(zzaa);
            }
        } else {
            super.zzg(iterable);
        }
        return this;
    }

    public final /* synthetic */ zzdyy zzab(Object obj) {
        return (zzdzg) zzaa(obj);
    }

    public final /* synthetic */ zzdyx zza(Iterator it) {
        zzdyi.checkNotNull(it);
        while (it.hasNext()) {
            zzaa(it.next());
        }
        return this;
    }

    public final /* synthetic */ zzdyx zzaa(Object obj) {
        zzdyi.checkNotNull(obj);
        if (this.zzibc != null) {
            int zzez = zzdzd.zzez(this.size);
            Object[] objArr = this.zzibc;
            if (zzez <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int zzex = zzdyw.zzex(hashCode);
                while (true) {
                    int i = zzex & length;
                    Object[] objArr2 = this.zzibc;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zzex = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zzaih += hashCode;
                        super.zzaa(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzibc = null;
        super.zzaa(obj);
        return this;
    }
}
