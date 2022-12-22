package com.didi.map.global.component.line.data.cache;

import android.os.Handler;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.data.cache.MultiLineCacheInstance;
import com.didi.map.global.component.line.data.param.MultiRouteLineRequest;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;
import com.didichuxing.routesearchsdk.multi.SingleRouteReqParam;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiLineCacheInstance {

    /* renamed from: a */
    private static final int f25790a = 10;

    /* renamed from: d */
    private static volatile MultiLineCacheInstance f25791d;

    /* renamed from: b */
    private List<MultiLineRouteCache> f25792b = new CopyOnWriteArrayList();

    /* renamed from: c */
    private final String f25793c = "LineCacheTag";

    private MultiLineCacheInstance() {
    }

    public static MultiLineCacheInstance getCacheInstance() {
        if (f25791d == null) {
            synchronized (MultiLineCacheInstance.class) {
                if (f25791d == null) {
                    f25791d = new MultiLineCacheInstance();
                    new ClearCacheHandler(f25791d).clearCache();
                }
            }
        }
        return f25791d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18383a() {
        List<MultiLineRouteCache> list;
        if (f25791d != null && (list = this.f25792b) != null) {
            list.clear();
            this.f25792b = null;
            f25791d = null;
        }
    }

    public void addRouteToCache(MultiLineRouteCache multiLineRouteCache) {
        List<MultiLineRouteCache> list = this.f25792b;
        if (list != null && multiLineRouteCache != null) {
            if (list.size() >= 10) {
                this.f25792b.remove(0);
            }
            this.f25792b.add(multiLineRouteCache);
        }
    }

    public MultiRoutePlanRes getRouteInCache(MultiRouteLineRequest multiRouteLineRequest) {
        List<MultiLineRouteCache> list = this.f25792b;
        if (list == null) {
            return null;
        }
        for (MultiLineRouteCache next : list) {
            if (next != null && next.param != null && m18385a(next.param, multiRouteLineRequest)) {
                return next.planRes;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m18385a(MultiRouteLineRequest multiRouteLineRequest, MultiRouteLineRequest multiRouteLineRequest2) {
        if (multiRouteLineRequest2 == null || multiRouteLineRequest == null) {
            DLog.m7384d("LineCacheTag", "路线参数为空", new Object[0]);
            return false;
        } else if (multiRouteLineRequest.getLineParams() == null || multiRouteLineRequest2.getLineParams() == null) {
            DLog.m7384d("LineCacheTag", "多路段路线参数为空", new Object[0]);
            return false;
        } else if (multiRouteLineRequest.getLineParams().size() != multiRouteLineRequest2.getLineParams().size()) {
            DLog.m7384d("LineCacheTag", "多路段路线参数个数不一致", new Object[0]);
            return false;
        } else {
            boolean z = false;
            for (int i = 0; i < multiRouteLineRequest.getLineParams().size(); i++) {
                z = m18386a(multiRouteLineRequest2.getLineParams().get(i), multiRouteLineRequest.getLineParams().get(i));
                if (!z) {
                    return false;
                }
            }
            return z;
        }
    }

    /* renamed from: a */
    private boolean m18386a(SingleRouteReqParam singleRouteReqParam, SingleRouteReqParam singleRouteReqParam2) {
        if (!(singleRouteReqParam == null || singleRouteReqParam2 == null)) {
            if (singleRouteReqParam2.getWayPoints() == null && singleRouteReqParam.getWayPoints() == null) {
                return true;
            }
            if (singleRouteReqParam2.getWayPoints() == null || singleRouteReqParam.getWayPoints() == null) {
                DLog.m7384d("LineCacheTag", "途经点不同", new Object[0]);
            } else if (singleRouteReqParam2.getWayPoints().size() != singleRouteReqParam.getWayPoints().size()) {
                DLog.m7384d("LineCacheTag", "途经点个数不一致", new Object[0]);
                return false;
            } else {
                for (int i = 0; i < singleRouteReqParam2.getWayPoints().size(); i++) {
                    if (!LatLngUtils.isSameLatLng(new LatLng((double) singleRouteReqParam2.getWayPoints().get(i).point.lat.floatValue(), (double) singleRouteReqParam2.getWayPoints().get(i).point.lng.floatValue()), new LatLng((double) singleRouteReqParam.getWayPoints().get(i).point.lat.floatValue(), (double) singleRouteReqParam.getWayPoints().get(i).point.lng.floatValue()))) {
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
        private SoftReference<MultiLineCacheInstance> instanceSoftReference;

        public ClearCacheHandler(MultiLineCacheInstance multiLineCacheInstance) {
            this.instanceSoftReference = new SoftReference<>(multiLineCacheInstance);
        }

        public void clearCache() {
            postDelayed(new Runnable() {
                public final void run() {
                    MultiLineCacheInstance.ClearCacheHandler.this.lambda$clearCache$0$MultiLineCacheInstance$ClearCacheHandler();
                }
            }, (long) this.destroyCacheDelayTime);
        }

        public /* synthetic */ void lambda$clearCache$0$MultiLineCacheInstance$ClearCacheHandler() {
            if (this.instanceSoftReference.get() != null) {
                this.instanceSoftReference.get().m18383a();
            }
        }
    }

    public static class MultiLineRouteCache {
        MultiRouteLineRequest param;
        MultiRoutePlanRes planRes;

        public MultiLineRouteCache(MultiRouteLineRequest multiRouteLineRequest, MultiRoutePlanRes multiRoutePlanRes) {
            this.param = multiRouteLineRequest;
            this.planRes = multiRoutePlanRes;
        }
    }
}
