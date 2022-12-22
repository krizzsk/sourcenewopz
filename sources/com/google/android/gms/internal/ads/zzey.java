package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzey extends zzcw<Integer, Object> {
    public Long zzyv;
    public Boolean zzyw;
    public Boolean zzyx;

    public zzey() {
    }

    public zzey(String str) {
        zzam(str);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzyv = (Long) zzan.get(0);
            this.zzyw = (Boolean) zzan.get(1);
            this.zzyx = (Boolean) zzan.get(2);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzbo() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyv);
        hashMap.put(1, this.zzyw);
        hashMap.put(2, this.zzyx);
        return hashMap;
    }
}
