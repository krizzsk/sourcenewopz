package com.didi.map.global.component.line.data.cache;

import android.os.Handler;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.data.cache.LineCacheInstance;
import com.didi.map.global.component.line.data.param.RouteLineRequest;
import com.didi.map.sdk.proto.driver_gl.RoutePlanRes;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LineCacheInstance {

    /* renamed from: a */
    private static final int f25786a = 10;

    /* renamed from: d */
    private static volatile LineCacheInstance f25787d;

    /* renamed from: b */
    private List<NormalLineCache> f25788b = new CopyOnWriteArrayList();

    /* renamed from: c */
    private final String f25789c = "LineCacheTag";

    private LineCacheInstance() {
    }

    public static LineCacheInstance getCacheInstance() {
        if (f25787d == null) {
            synchronized (LineCacheInstance.class) {
                if (f25787d == null) {
                    f25787d = new LineCacheInstance();
                    new ClearCacheHandler(f25787d).clearCache();
                }
            }
        }
        return f25787d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18380a() {
        List<NormalLineCache> list;
        if (f25787d != null && (list = this.f25788b) != null) {
            list.clear();
            this.f25788b = null;
            f25787d = null;
        }
    }

    public void addRouteToCache(NormalLineCache normalLineCache) {
        List<NormalLineCache> list = this.f25788b;
        if (list != null && normalLineCache != null) {
            if (list.size() >= 10) {
                this.f25788b.remove(0);
            }
            this.f25788b.add(normalLineCache);
        }
    }

    public RoutePlanRes getRouteInCache(RouteLineRequest routeLineRequest) {
        List<NormalLineCache> list = this.f25788b;
        if (list == null) {
            return null;
        }
        for (NormalLineCache next : list) {
            if (next != null && next.param != null && m18382a(next.param, routeLineRequest)) {
                return next.planRes;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m18382a(RouteLineRequest routeLineRequest, RouteLineRequest routeLineRequest2) {
        if (routeLineRequest2 == null || routeLineRequest == null) {
            DLog.m7384d("LineCacheTag", "路线参数为空", new Object[0]);
            return false;
        }
        if (LatLngUtils.isSameLatLng(routeLineRequest.getStart(), routeLineRequest2.getStart()) && LatLngUtils.isSameLatLng(routeLineRequest.getEnd(), routeLineRequest2.getEnd())) {
            if (routeLineRequest.getWayPoint() == null && routeLineRequest2.getWayPoint() == null) {
                return true;
            }
            if (routeLineRequest.getWayPoint() == null || routeLineRequest2.getWayPoint() == null) {
                DLog.m7384d("LineCacheTag", "途经点不同", new Object[0]);
            } else if (routeLineRequest.getWayPoint().size() != routeLineRequest2.getWayPoint().size()) {
                DLog.m7384d("LineCacheTag", "途经点个数不一致", new Object[0]);
                return false;
            } else {
                for (int i = 0; i < routeLineRequest.getWayPoint().size(); i++) {
                    if (!LatLngUtils.isSameLatLng(routeLineRequest.getWayPoint().get(i), routeLineRequest2.getWayPoint().get(i))) {
                        DLog.m7384d("LineCacheTag", "途经点不同", new Object[0]);
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static class ClearCacheHandler extends Handler {
        private int destroyCacheDelayTime = 300000;
        private SoftReference<LineCacheInstance> instanceSoftReference;

        public ClearCacheHandler(LineCacheInstance lineCacheInstance) {
            this.instanceSoftReference = new SoftReference<>(lineCacheInstance);
        }

        public void clearCache() {
            postDelayed(new Runnable() {
                public final void run() {
                    LineCacheInstance.ClearCacheHandler.this.lambda$clearCache$0$LineCacheInstance$ClearCacheHandler();
                }
            }, (long) this.destroyCacheDelayTime);
        }

        public /* synthetic */ void lambda$clearCache$0$LineCacheInstance$ClearCacheHandler() {
            if (this.instanceSoftReference.get() != null) {
                this.instanceSoftReference.get().m18380a();
            }
        }
    }

    public static class NormalLineCache {
        RouteLineRequest param;
        RoutePlanRes planRes;

        public NormalLineCache(RouteLineRequest routeLineRequest, RoutePlanRes routePlanRes) {
            this.param = routeLineRequest;
            this.planRes = routePlanRes;
        }
    }
}
