package com.didi.entrega.customer.map;

import android.os.Looper;
import android.os.MessageQueue;
import com.didi.common.map.Map;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;

public final class MapLazyLoader {
    public static final int MAP_DEFAULT_DELAY = 5000;

    /* renamed from: a */
    private static final String f20182a = "MapLazyLoader";

    /* renamed from: b */
    private static MapLazyLoader f20183b = new MapLazyLoader();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f20184c = false;
    public boolean mLazyloadApolloOn = false;

    private MapLazyLoader() {
        boolean isMapLazyLoadOn = CustomerApolloUtil.isMapLazyLoadOn();
        this.mLazyloadApolloOn = isMapLazyLoadOn;
        LogUtil.m14765i(f20182a, isMapLazyLoadOn ? "lazyload apollo on" : "lazyload apollo off");
    }

    public static MapLazyLoader getLoader() {
        return f20183b;
    }

    public void resetMapLazyLoader() {
        this.f20184c = false;
    }

    public boolean loadMapDelayed(int i) {
        if (!this.mLazyloadApolloOn) {
            return false;
        }
        UiHandlerUtil.postDelayed(new Runnable() {
            public void run() {
                if (!MapLazyLoader.this.f20184c) {
                    LogUtil.m14765i(MapLazyLoader.f20182a, "loadMapDelayed");
                    MapLazyLoader.this.m14861a();
                    boolean unused = MapLazyLoader.this.f20184c = true;
                }
            }
        }, (long) i);
        return true;
    }

    public boolean loadMapNextIdle() {
        if (!this.mLazyloadApolloOn) {
            return false;
        }
        if (this.f20184c) {
            return true;
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                LogUtil.m14765i(MapLazyLoader.f20182a, "loadMapNextIdle");
                MapLazyLoader.this.m14861a();
                return false;
            }
        });
        this.f20184c = true;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14861a() {
        GlobalContext.initMapView(new OnMapInitCallback() {
            public void onMapInitFinish(Map map) {
                RecordTracker.Builder.create().setTag(MapLazyLoader.f20182a).setLogModule("m-map|").setMessage("onMapInitFinish").setLogCategory("c-state|").build().info();
            }
        });
    }
}
