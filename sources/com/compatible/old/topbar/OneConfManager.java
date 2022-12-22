package com.compatible.old.topbar;

import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/compatible/old/topbar/OneConfManager;", "", "()V", "locationChangedListener", "Lcom/didi/sdk/map/ILocation$ILocationChangedListener;", "addOneConfLocationChangedListener", "", "onWindowFocusChanged", "hasFocus", "", "removeLocationListener", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OneConfManager.kt */
public final class OneConfManager {
    public static final OneConfManager INSTANCE = new OneConfManager();

    /* renamed from: a */
    private static final ILocation.ILocationChangedListener f3279a = new OneConfManager$locationChangedListener$1();

    private OneConfManager() {
    }

    /* renamed from: a */
    private final void m2226a() {
        LocationPerformer.getInstance().addLocationListener(f3279a);
    }

    /* renamed from: b */
    private final void m2227b() {
        LocationPerformer.getInstance().removeLocationListener(f3279a);
    }

    public final void onWindowFocusChanged(boolean z) {
        if (z) {
            m2226a();
        } else {
            m2227b();
        }
    }
}
