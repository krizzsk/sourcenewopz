package com.dmap.navigation.engine.p207a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.didi.map.common.utils.MapSerializeUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.dmap.navigation.api.core.IBaseNaviAPI;
import com.dmap.navigation.api.core.INaviPlanner;
import com.dmap.navigation.api.core.INaviPlannerBuilder;
import com.dmap.navigation.api.core.INaviPlannerInner;
import com.dmap.navigation.api.core.INaviTrafficUpdater;
import com.dmap.navigation.api.route.IRouteEx;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.base.location.INaviLatLng;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.base.route.IRoute;
import com.dmap.navigation.jni.sub.BindNaviLocationNative;
import com.dmap.navigation.jni.sub.NaviInfoNative;
import com.dmap.navigation.jni.sub.NaviLocationListNative;
import com.dmap.navigation.jni.sub.NaviLocationNative;
import com.dmap.navigation.jni.sub.NaviPoiListNative;
import com.dmap.navigation.jni.sub.NaviPoiNative;
import com.dmap.navigation.jni.swig.APIRequestCallback;
import com.dmap.navigation.jni.swig.APIRequestHelper;
import com.dmap.navigation.jni.swig.BaseNaviAPI;
import com.dmap.navigation.jni.swig.DefaultRetryStrategy;
import com.dmap.navigation.jni.swig.FirstRetryStrategy;
import com.dmap.navigation.jni.swig.LongList;
import com.dmap.navigation.jni.swig.NaviBusinessBridge;
import com.dmap.navigation.jni.swig.NaviResponse;
import com.dmap.navigation.jni.swig.ReqRouteInfo;
import com.dmap.navigation.jni.swig.RequestInfo;
import com.dmap.navigation.jni.swig.RetryStrategy;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_unsigned_char;
import com.dmap.navigation.jni.swig.YawRetryStrategy;
import com.dmap.navigation.location.diloc.DMapDiDiLocation;
import com.dmap.navigation.simple.SimplePoi;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.dmap.navigation.engine.a.a */
/* compiled from: BaseNaviAPIImpl */
class C17374a<T extends BaseNaviAPI> implements IBaseNaviAPI, INaviPlanner, INaviPlannerBuilder {

    /* renamed from: a */
    final NaviInfoNative f51731a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final T f51732b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C17401n f51733c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public INaviPlanner.Callback f51734d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Handler f51735e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    private RetryStrategy f51736f;

    /* renamed from: g */
    private final APIRequestHelper f51737g = new APIRequestHelper() {
        public final void onPost(int i, final String str, SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i2) {
            HWLog.m16761i("nv_a", "url = " + str + " , body size = " + i2);
            if (!TextUtils.isEmpty(str)) {
                final byte[] a = C17400m.m37040a(sWIGTYPE_p_unsigned_char, i2);
                C17374a.this.f51735e.postDelayed(new Runnable() {
                    public final void run() {
                        HashMap hashMap = new HashMap();
                        hashMap.put("Cityid", C17374a.this.f51733c.f51827aL.getCityId());
                        AsyncNetUtils.doPost(str, a, new AsyncNetUtils.Callback() {
                            public final void onSuccess(byte[] bArr) {
                                HWLog.m16761i("nv_a", "result size = " + bArr.length);
                                C17374a.this.f51732b.onResponse(bArr, bArr.length, (int) (System.currentTimeMillis() / 1000));
                                C17374a.m37018a(bArr, C17374a.this.f51731a.getEventType());
                            }

                            public final void onFailed(int i, Exception exc) {
                                HWLog.m16761i("nv_a", "error msg = " + exc.getMessage());
                                C17374a.this.f51732b.onResponse(new byte[0], 0, (int) (System.currentTimeMillis() / 1000));
                            }
                        }, hashMap);
                    }
                }, (long) i);
                return;
            }
            HWLog.m16761i("nv_a", "url = null");
        }

        public final RequestInfo getRequestInfo() {
            RequestInfo requestInfo = new RequestInfo();
            requestInfo.setTraceId(C17400m.m37039a(C17374a.this.f51733c.f51827aL.getImei()));
            requestInfo.setCurrentTime(BigInteger.valueOf(System.currentTimeMillis()));
            requestInfo.setSessionId(C17374a.this.f51733c.getSessionId());
            requestInfo.setSeq(C17374a.this.f51733c.getSeq());
            requestInfo.setSpanId(C17400m.m37041b(C17374a.this.f51733c.f51827aL.getImei()));
            requestInfo.setLogId(C17400m.m37041b(C17374a.this.f51733c.f51827aL.getImei()) + C17400m.m37041b(C17374a.this.f51733c.f51827aL.getImei()));
            requestInfo.setTripId(C17374a.this.f51733c.getTripId());
            C17374a.this.f51731a.setRequestInfo(requestInfo);
            return requestInfo;
        }
    };

    /* renamed from: h */
    private final APIRequestCallback f51738h = new APIRequestCallback() {
        public final void onBegin() {
            HWLog.m16761i("nv_a", "onBegin, EventType = " + C17374a.this.f51731a.getEventType());
            C17374a.this.f51735e.postDelayed(C17374a.this.f51739i, 10000);
            if (C17374a.this.f51734d != null) {
                C17374a.this.f51735e.post(new Runnable() {
                    public final void run() {
                        C17374a.this.f51734d.onBegin(0);
                    }
                });
            }
        }

        public final void onRetry(final int i) {
            HWLog.m16761i("nv_a", "onRetry");
            if (C17374a.this.f51734d != null) {
                C17374a.this.f51735e.post(new Runnable() {
                    public final void run() {
                        if (C17374a.this.f51734d instanceof INaviPlannerInner.Callback) {
                            ((INaviPlannerInner.Callback) C17374a.this.f51734d).onRetry(i);
                        }
                    }
                });
            }
        }

        public final void onFinish(NaviResponse naviResponse) {
            HWLog.m16761i("nv_a", "onFinish = " + naviResponse.getErrorCode() + " ,route size = " + naviResponse.getRoutes().size());
            C17374a.this.f51735e.removeCallbacks(C17374a.this.f51739i);
            if (C17374a.this.f51734d != null) {
                final C17393f fVar = new C17393f(C17374a.this.f51732b, naviResponse);
                C17374a.this.f51735e.post(new Runnable() {
                    public final void run() {
                        C17374a.this.f51734d.onFinish(fVar.getRoutesList(), fVar.getErrorCode(), fVar.getIsMultiRoute());
                        if (C17374a.this.f51734d instanceof INaviPlannerInner.Callback) {
                            ((INaviPlannerInner.Callback) C17374a.this.f51734d).onFinish(C17374a.this.f51731a, fVar);
                        }
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Runnable f51739i = new Runnable() {
        public final void run() {
            if (C17374a.this.f51734d != null) {
                C17374a.this.f51734d.onFinish((List<IRoute>) null, NaviBusinessBridge.getERROR_REQUEST_TIME_OUT(), 0);
            }
        }
    };

    C17374a(INaviContext iNaviContext, T t) {
        AsyncNetUtils.init(iNaviContext.getAndroidContext());
        this.f51733c = (C17401n) iNaviContext;
        this.f51732b = t;
        this.f51731a = new NaviInfoNative();
        this.f51732b.setHelper(this.f51737g);
        this.f51732b.setCallback(this.f51738h);
    }

    public INaviPlannerBuilder firstRoute(INaviPoi iNaviPoi, INaviPoi iNaviPoi2, List<INaviPoi> list, int i) {
        if (iNaviPoi == null || iNaviPoi2 == null) {
            throw new RuntimeException("start or end point is null !");
        }
        this.f51731a.setEventType(NaviBusinessBridge.getAPI_FIRST_ROUTE());
        this.f51731a.setStart(new NaviPoiNative(iNaviPoi));
        this.f51731a.setEnd(new NaviPoiNative(iNaviPoi2));
        this.f51731a.setPassPoints(new NaviPoiListNative(list));
        ReqRouteInfo reqRouteInfo = new ReqRouteInfo();
        reqRouteInfo.setLastRouteId(BigInteger.ZERO);
        reqRouteInfo.setPassfork(0);
        this.f51731a.setCurrentRoute(reqRouteInfo);
        this.f51731a.setNaviModel(i);
        List<INaviLocation> a = m37016a();
        if (a.size() > 0) {
            this.f51731a.setHistoryPoints(new NaviLocationListNative(a));
            this.f51731a.setLastGpsPoint(new NaviLocationNative(a.get(a.size() - 1)));
        }
        return this;
    }

    public INaviPlannerBuilder yawRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2, int i3) {
        this.f51731a.setEventType(NaviBusinessBridge.getAPI_YAW_ROUTE());
        IRouteEx iRouteEx = (IRouteEx) iRoute;
        this.f51731a.setStart(new NaviPoiNative(new SimplePoi((INaviLatLng) iNaviLocation.getLatLng(), "", "")));
        this.f51731a.setEnd(new NaviPoiNative(iRouteEx.getEnd()));
        this.f51731a.setPassPoints(new NaviPoiListNative(iRouteEx.getOriginalPassPoints()));
        this.f51731a.setCurrentBindPoint(new BindNaviLocationNative(iNaviLocation, i));
        this.f51731a.setLastBindPoint(new BindNaviLocationNative(iNaviLocation2, i2));
        this.f51731a.setYawType(i3);
        ReqRouteInfo reqRouteInfo = new ReqRouteInfo();
        reqRouteInfo.setLastRouteId(iRoute.getRouteId());
        reqRouteInfo.setPassfork(0);
        this.f51731a.setCurrentRoute(reqRouteInfo);
        List<INaviLocation> a = m37016a();
        if (a.size() > 0) {
            this.f51731a.setHistoryPoints(new NaviLocationListNative(a));
            this.f51731a.setLastGpsPoint(new NaviLocationNative(a.get(a.size() - 1)));
        }
        return this;
    }

    public INaviPlannerBuilder parallelRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2) {
        this.f51731a.setEventType(NaviBusinessBridge.getAPI_PARALLEL_ROUTE());
        m37017a((IRouteEx) iRoute, new ReqRouteInfo(), iNaviLocation, i, iNaviLocation2, i2);
        return this;
    }

    public INaviPlannerBuilder elevatedRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2) {
        this.f51731a.setEventType(NaviBusinessBridge.getAPI_ELEVATED_ROUTE());
        m37017a((IRouteEx) iRoute, new ReqRouteInfo(), iNaviLocation, i, iNaviLocation2, i2);
        return this;
    }

    public INaviPlannerBuilder multiRoute(IRoute iRoute, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2, String str, int i3, int i4) {
        this.f51731a.setEventType(NaviBusinessBridge.getAPI_MULTI_ROUTE());
        ReqRouteInfo reqRouteInfo = new ReqRouteInfo();
        String str2 = str;
        reqRouteInfo.setRouteScene(str);
        int i5 = i3;
        reqRouteInfo.setRouteCount(i3);
        reqRouteInfo.setPassfork(i4);
        m37017a((IRouteEx) iRoute, reqRouteInfo, iNaviLocation, i, iNaviLocation2, i2);
        return this;
    }

    public INaviPlannerBuilder arrivedDestination() {
        this.f51731a.setEventType(NaviBusinessBridge.getAPI_ARRIVED_DESTINATION());
        return this;
    }

    public INaviTrafficUpdater updateTraffic(IRoute iRoute, INaviLocation iNaviLocation, int i, List<BigInteger> list) {
        this.f51731a.setCurrentBindPoint(new BindNaviLocationNative(iNaviLocation, i));
        ReqRouteInfo reqRouteInfo = new ReqRouteInfo();
        reqRouteInfo.setLastRouteId(iRoute.getRouteId());
        LongList longList = new LongList();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                longList.add(list.get(i2));
            }
        }
        reqRouteInfo.setOtherRouteIds(longList);
        reqRouteInfo.setHasMjoEvent(((IRouteEx) iRoute).hasMjoEvent());
        this.f51731a.setCurrentRoute(reqRouteInfo);
        return new C17385d(this.f51733c, this.f51731a);
    }

    public void enqueue(INaviPlanner.Callback callback) {
        HWLog.m16761i("nv_a", "enqueue = ".concat(String.valueOf(this)));
        this.f51734d = callback;
        this.f51732b.execute();
    }

    public void cancel() {
        HWLog.m16761i("nv_a", "cancel = ".concat(String.valueOf(this)));
        this.f51732b.cancel();
        this.f51735e.removeCallbacksAndMessages((Object) null);
    }

    public INaviPlanner build() {
        if (!TextUtils.isEmpty(this.f51733c.f51827aL.getUserId())) {
            this.f51732b.setNaviInfo(this.f51731a);
            this.f51732b.setRetryStrategy(mo125493a(this.f51731a.getEventType()));
            return this;
        }
        throw new RuntimeException("UserId is empty !!!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public RetryStrategy mo125493a(int i) {
        if (i == NaviBusinessBridge.getAPI_FIRST_ROUTE()) {
            this.f51736f = new FirstRetryStrategy();
        } else if (i == NaviBusinessBridge.getAPI_YAW_ROUTE() || i == NaviBusinessBridge.getAPI_PARALLEL_ROUTE() || i == NaviBusinessBridge.getAPI_ELEVATED_ROUTE()) {
            this.f51736f = new YawRetryStrategy();
        } else {
            this.f51736f = new DefaultRetryStrategy();
        }
        return this.f51736f;
    }

    /* renamed from: a */
    private void m37017a(IRouteEx iRouteEx, ReqRouteInfo reqRouteInfo, INaviLocation iNaviLocation, int i, INaviLocation iNaviLocation2, int i2) {
        this.f51731a.setStart(new NaviPoiNative(iRouteEx.getStart()));
        this.f51731a.setEnd(new NaviPoiNative(iRouteEx.getEnd()));
        this.f51731a.setPassPoints(new NaviPoiListNative(iRouteEx.getOriginalPassPoints()));
        this.f51731a.setCurrentBindPoint(new BindNaviLocationNative(iNaviLocation, i));
        this.f51731a.setLastBindPoint(new BindNaviLocationNative(iNaviLocation2, i2));
        reqRouteInfo.setLastRouteId(iRouteEx.getRouteId());
        this.f51731a.setCurrentRoute(reqRouteInfo);
    }

    /* renamed from: a */
    private static List<INaviLocation> m37016a() {
        List<DIDILocation> recentLocations = DIDILocBusinessHelper.getInstance().getRecentLocations(20);
        HWLog.m16761i("nv_a", "getRecentLocations : " + recentLocations.toString());
        ArrayList arrayList = new ArrayList();
        for (DIDILocation next : recentLocations) {
            if (next != null) {
                arrayList.add(new DMapDiDiLocation(next));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ void m37018a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[(bArr.length + 4)];
        System.arraycopy(MapSerializeUtil.intToBytes(i), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        HWLog.binary_i((byte) 1, bArr2, System.currentTimeMillis());
    }
}
