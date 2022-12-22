package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbet {
    private final ArrayList<zzou> zzesj = new ArrayList<>();
    private long zzesk;

    zzbet() {
    }

    /* access modifiers changed from: package-private */
    public final long zzadh() {
        Iterator<zzou> it = this.zzesj.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> responseHeaders = it.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry next : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase((String) next.getKey())) {
                            this.zzesk = Math.max(this.zzesk, Long.parseLong((String) ((List) next.getValue()).get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzesk;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzou zzou) {
        this.zzesj.add(zzou);
    }
}
