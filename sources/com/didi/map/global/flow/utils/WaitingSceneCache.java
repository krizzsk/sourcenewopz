package com.didi.map.global.flow.utils;

import android.content.Context;
import com.sdk.poibase.store.PoiStore;

public class WaitingSceneCache {

    /* renamed from: a */
    private static final String f27284a = "Key_Has_Show_Recommend_Pickup";

    /* renamed from: b */
    private PoiStore f27285b;

    /* renamed from: c */
    private Context f27286c;

    /* renamed from: d */
    private boolean f27287d;

    /* renamed from: e */
    private boolean f27288e = true;

    public WaitingSceneCache(Context context) {
        this.f27286c = context;
    }

    /* renamed from: a */
    private void m19284a() {
        Context context = this.f27286c;
        if (context != null && !this.f27287d && this.f27288e) {
            this.f27285b = PoiStore.getInstance(context);
            this.f27287d = true;
        }
    }

    public void setSupported(boolean z) {
        this.f27288e = z;
    }

    public void setRecommendPickupStatus(boolean z) {
        m19284a();
        PoiStore poiStore = this.f27285b;
        if (poiStore != null) {
            poiStore.putAndSave(f27284a, z);
        }
    }

    public boolean hasShowedRecommendPickup() {
        m19284a();
        PoiStore poiStore = this.f27285b;
        if (poiStore != null) {
            return poiStore.getBoolean(f27284a, false);
        }
        return false;
    }
}
