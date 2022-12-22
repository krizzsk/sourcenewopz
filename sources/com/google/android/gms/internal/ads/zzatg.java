package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzatg {
    /* access modifiers changed from: private */
    @Nonnull
    public View zzaay;
    /* access modifiers changed from: private */
    public final Map<String, WeakReference<View>> zzdva = new HashMap();

    public final zzatg zzk(View view) {
        this.zzaay = view;
        return this;
    }

    public final zzatg zzh(Map<String, View> map) {
        this.zzdva.clear();
        for (Map.Entry next : map.entrySet()) {
            View view = (View) next.getValue();
            if (view != null) {
                this.zzdva.put((String) next.getKey(), new WeakReference(view));
            }
        }
        return this;
    }
}
