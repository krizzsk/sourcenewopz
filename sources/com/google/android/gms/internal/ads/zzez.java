package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzez extends zzcw<Integer, Long> {
    public Long zzyy;
    public Long zzyz;

    public zzez() {
    }

    public zzez(String str) {
        zzam(str);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzyy = (Long) zzan.get(0);
            this.zzyz = (Long) zzan.get(1);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyy);
        hashMap.put(1, this.zzyz);
        return hashMap;
    }
}
