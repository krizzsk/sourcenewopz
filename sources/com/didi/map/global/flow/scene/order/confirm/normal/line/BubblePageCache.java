package com.didi.map.global.flow.scene.order.confirm.normal.line;

import android.os.Handler;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.flow.scene.order.confirm.normal.line.BubblePageCache;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.sdk.proto.driver_gl.BubblePageRes;
import com.didi.map.sdk.proto.driver_gl.EstimatedPriceRoute;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class BubblePageCache {

    /* renamed from: c */
    private static volatile BubblePageCache f26676c;

    /* renamed from: a */
    private List<Value> f26677a = new CopyOnWriteArrayList();

    /* renamed from: b */
    private final String f26678b = "BubblePageCache";

    /* renamed from: d */
    private boolean f26679d;

    /* renamed from: e */
    private ClearCacheHandler f26680e;

    private BubblePageCache() {
        readApollo();
    }

    public void readApollo() {
        this.f26679d = MapFlowApolloUtils.enableMultiLineCache();
    }

    public static BubblePageCache getInstance() {
        if (f26676c == null) {
            synchronized (BubblePageCache.class) {
                if (f26676c == null) {
                    f26676c = new BubblePageCache();
                }
            }
        }
        return f26676c;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18876a() {
        List<Value> list;
        if (f26676c != null && (list = this.f26677a) != null) {
            list.clear();
        }
    }

    public void addBubblePageToCache(LatLng latLng, LatLng latLng2, List<LatLng> list, BubblePageRes bubblePageRes) {
        if (this.f26679d) {
            Key key = new Key(latLng, latLng2, list);
            List<Value> list2 = this.f26677a;
            if (list2 != null && bubblePageRes != null) {
                list2.clear();
                this.f26677a.add(new Value(key, bubblePageRes));
                if (this.f26680e == null) {
                    this.f26680e = new ClearCacheHandler(f26676c);
                }
                this.f26680e.removeCallbacksAndMessages((Object) null);
                this.f26680e.clearCache();
                DLog.m7384d("BubblePageCache", "添加到缓存", new Object[0]);
            }
        }
    }

    public BubblePageRes getBubblePageInCache(LatLng latLng, LatLng latLng2, List<LatLng> list) {
        List<Value> list2;
        if (this.f26679d && (list2 = this.f26677a) != null) {
            for (Value next : list2) {
                Key key = new Key(latLng, latLng2, list);
                if (next != null && next.key != null && m18878a(next.key, key)) {
                    DLog.m7384d("BubblePageCache", "使用缓存数据", new Object[0]);
                    return next.res;
                }
            }
        }
        return null;
    }

    public long getDefaultRouteId(LatLng latLng, LatLng latLng2, List<LatLng> list) {
        if (!this.f26679d) {
            return 0;
        }
        for (Value next : this.f26677a) {
            Key key = new Key(latLng, latLng2, list);
            if (next == null || next.key == null || !m18878a(next.key, key)) {
                DLog.m7384d("BubblePageCache", "起终途径点不一致，没有缓存", new Object[0]);
            } else {
                DLog.m7384d("BubblePageCache", "缓存default route id:" + next.defaultRouteId, new Object[0]);
                return next.defaultRouteId;
            }
        }
        return 0;
    }

    public long getSelectedRouteId(LatLng latLng, LatLng latLng2, List<LatLng> list) {
        if (!this.f26679d) {
            return 0;
        }
        for (Value next : this.f26677a) {
            Key key = new Key(latLng, latLng2, list);
            if (next == null || next.key == null || !m18878a(next.key, key)) {
                DLog.m7384d("BubblePageCache", "起终途径点不一致，没有缓存", new Object[0]);
            } else {
                DLog.m7384d("BubblePageCache", "缓存selected route id:" + next.selectedRouteId, new Object[0]);
                return next.selectedRouteId;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private boolean m18878a(Key key, Key key2) {
        if (key == null || key2 == null) {
            DLog.m7384d("BubblePageCache", "路线参数为空", new Object[0]);
            return false;
        } else if (!LatLngUtils.isSameLatLng(key.start, key2.start) || !LatLngUtils.isSameLatLng(key.end, key2.end)) {
            DLog.m7384d("BubblePageCache", "起终点不一致", new Object[0]);
            return false;
        } else if (key.wayPoint == null && key2.wayPoint == null) {
            return true;
        } else {
            if (key.wayPoint == null || key2.wayPoint == null) {
                DLog.m7384d("BubblePageCache", "途经点不同", new Object[0]);
                return false;
            } else if (key.wayPoint.size() != key2.wayPoint.size()) {
                DLog.m7384d("BubblePageCache", "途经点个数不一致", new Object[0]);
                return false;
            } else {
                for (int i = 0; i < key.wayPoint.size(); i++) {
                    if (!LatLngUtils.isSameLatLng(key.wayPoint.get(i), key2.wayPoint.get(i))) {
                        DLog.m7384d("BubblePageCache", "途经点不同", new Object[0]);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public void updateSelectedRouteId(LatLng latLng, LatLng latLng2, List<LatLng> list, long j) {
        if (this.f26679d) {
            for (Value next : this.f26677a) {
                Key key = new Key(latLng, latLng2, list);
                if (!(next == null || next.key == null || !m18878a(next.key, key))) {
                    next.updateSelectedRouteId(j);
                }
            }
        }
    }

    private static class ClearCacheHandler extends Handler {
        private long destroyCacheDelayTime = TimeUnit.MINUTES.toMillis((long) MapFlowApolloUtils.getMultiLineCacheTime());
        private SoftReference<BubblePageCache> instanceSoftReference;

        public ClearCacheHandler(BubblePageCache bubblePageCache) {
            this.instanceSoftReference = new SoftReference<>(bubblePageCache);
        }

        public void clearCache() {
            postDelayed(new Runnable() {
                public final void run() {
                    BubblePageCache.ClearCacheHandler.this.lambda$clearCache$0$BubblePageCache$ClearCacheHandler();
                }
            }, this.destroyCacheDelayTime);
        }

        public /* synthetic */ void lambda$clearCache$0$BubblePageCache$ClearCacheHandler() {
            if (this.instanceSoftReference.get() != null) {
                this.instanceSoftReference.get().m18876a();
            }
        }
    }

    private static class Key {
        LatLng end;
        LatLng start;
        List<LatLng> wayPoint;

        public Key(LatLng latLng, LatLng latLng2, List<LatLng> list) {
            this.start = latLng;
            this.end = latLng2;
            this.wayPoint = list;
        }
    }

    private static class Value {
        long defaultRouteId;
        Key key;
        BubblePageRes res;
        List<Long> routes = new ArrayList();
        long selectedRouteId;

        public Value(Key key2, BubblePageRes bubblePageRes) {
            this.key = key2;
            this.res = bubblePageRes;
            if (bubblePageRes != null && bubblePageRes.estimateInfo != null && bubblePageRes.estimateInfo.route != null) {
                if (bubblePageRes.estimateInfo.route.size() > 0) {
                    long longValue = bubblePageRes.estimateInfo.route.get(0).routeID.longValue();
                    this.defaultRouteId = longValue;
                    this.selectedRouteId = longValue;
                }
                for (EstimatedPriceRoute estimatedPriceRoute : bubblePageRes.estimateInfo.route) {
                    this.routes.add(estimatedPriceRoute.routeID);
                }
            }
        }

        public void updateSelectedRouteId(long j) {
            if (this.routes.contains(Long.valueOf(j))) {
                this.selectedRouteId = j;
            }
        }
    }
}
