package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.common.PauseableThread;
import com.didi.map.common.ApolloHawaii;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.hawaii.mapsdkv2.core.i */
/* compiled from: TrafficUpdateThread */
class C9189i extends PauseableThread {

    /* renamed from: d */
    private static final long f24046d = ApolloHawaii.getTrafficUpdateInterval();

    /* renamed from: a */
    private final WeakReference<MapDataUpdateHandler> f24047a;

    /* renamed from: b */
    private final WeakReference<GLBaseMapView> f24048b;

    /* renamed from: c */
    private long f24049c = -1;

    C9189i(GLBaseMapView gLBaseMapView, MapDataUpdateHandler mapDataUpdateHandler) {
        super("traffic");
        this.f24047a = new WeakReference<>(mapDataUpdateHandler);
        this.f24048b = new WeakReference<>(gLBaseMapView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo70622a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f24049c >= f24046d || !z) {
            synchronized (this) {
                notify();
            }
            this.f24049c = currentTimeMillis;
        }
    }

    /* access modifiers changed from: protected */
    public int onRun() throws InterruptedException {
        MapDataUpdateHandler mapDataUpdateHandler = (MapDataUpdateHandler) this.f24047a.get();
        GLBaseMapView gLBaseMapView = (GLBaseMapView) this.f24048b.get();
        if (mapDataUpdateHandler == null || gLBaseMapView == null) {
            throw new PauseableThread.Exit();
        }
        BaseMapData baseMapData = gLBaseMapView.getBaseMapData();
        if (baseMapData == null) {
            return 600;
        }
        int onUpdateTrafficData = mapDataUpdateHandler.onUpdateTrafficData(gLBaseMapView, baseMapData);
        if (onUpdateTrafficData <= 0) {
            return Integer.MAX_VALUE;
        }
        return onUpdateTrafficData;
    }
}
