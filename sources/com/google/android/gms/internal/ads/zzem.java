package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzem extends zzcw<Integer, Long> {
    public long zzyl;
    public long zzym;

    public zzem() {
        this.zzyl = -1;
        this.zzym = -1;
    }

    public zzem(String str) {
        this();
        zzam(str);
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzyl));
        hashMap.put(1, Long.valueOf(this.zzym));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzyl = ((Long) zzan.get(0)).longValue();
            this.zzym = ((Long) zzan.get(1)).longValue();
        }
    }
}
