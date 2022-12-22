package com.didi.soda.customer.map;

import android.os.Looper;
import android.os.MessageQueue;
import com.didi.common.map.Map;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;

public final class MapLazyLoader {
    public static final int MAP_DEFAULT_DELAY = 5000;

    /* renamed from: a */
    private static final String f41364a = "MapLazyLoader";

    /* renamed from: b */
    private static MapLazyLoader f41365b = new MapLazyLoader();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f41366c = false;
    public boolean mLazyloadApolloOn = false;

    private MapLazyLoader() {
        boolean isMapLazyLoadOn = CustomerApolloUtil.isMapLazyLoadOn();
        this.mLazyloadApolloOn = isMapLazyLoadOn;
        LogUtil.m29104i(f41364a, isMapLazyLoadOn ? "lazyload apollo on" : "lazyload apollo off");
    }

    public static MapLazyLoader getLoader() {
        return f41365b;
    }

    public void resetMapLazyLoader() {
        this.f41366c = false;
    }

    public boolean loadMapDelayed(int i) {
        if (!this.mLazyloadApolloOn) {
            return false;
        }
        UiHandlerUtil.postDelayed(new Runnable() {
            public void run() {
                if (!MapLazyLoader.this.f41366c) {
                    LogUtil.m29104i(MapLazyLoader.f41364a, "loadMapDelayed");
                    MapLazyLoader.this.m29304a();
                    boolean unused = MapLazyLoader.this.f41366c = true;
                }
            }
        }, (long) i);
        return true;
    }

    public boolean loadMapNextIdle() {
        if (!this.mLazyloadApolloOn) {
            return false;
        }
        if (this.f41366c) {
            return true;
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                LogUtil.m29104i(MapLazyLoader.f41364a, "loadMapNextIdle");
                MapLazyLoader.this.m29304a();
                return false;
            }
        });
        this.f41366c = true;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29304a() {
        GlobalContext.initMapView(new OnMapInitCallback() {
            public void onMapInitFinish(Map map) {
                RecordTracker.Builder.create().setTag(MapLazyLoader.f41364a).setLogModule("m-map|").setMessage("onMapInitFinish").setLogCategory("c-state|").build().info();
            }
        });
    }
}
