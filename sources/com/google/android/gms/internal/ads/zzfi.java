package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzfi extends zzcw<Integer, Long> {
    public Long zzaaa;
    public Long zzaab;
    public Long zzaac;
    public Long zzaad;
    public Long zzaae;
    public Long zzaaf;
    public Long zzaag;
    public Long zzzw;
    public Long zzzx;
    public Long zzzy;
    public Long zzzz;

    public zzfi() {
    }

    public zzfi(String str) {
        zzam(str);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzzw = (Long) zzan.get(0);
            this.zzzx = (Long) zzan.get(1);
            this.zzzy = (Long) zzan.get(2);
            this.zzzz = (Long) zzan.get(3);
            this.zzaaa = (Long) zzan.get(4);
            this.zzaab = (Long) zzan.get(5);
            this.zzaac = (Long) zzan.get(6);
            this.zzaad = (Long) zzan.get(7);
            this.zzaae = (Long) zzan.get(8);
            this.zzaaf = (Long) zzan.get(9);
            this.zzaag = (Long) zzan.get(10);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzzw);
        hashMap.put(1, this.zzzx);
        hashMap.put(2, this.zzzy);
        hashMap.put(3, this.zzzz);
        hashMap.put(4, this.zzaaa);
        hashMap.put(5, this.zzaab);
        hashMap.put(6, this.zzaac);
        hashMap.put(7, this.zzaad);
        hashMap.put(8, this.zzaae);
        hashMap.put(9, this.zzaaf);
        hashMap.put(10, this.zzaag);
        return hashMap;
    }
}
