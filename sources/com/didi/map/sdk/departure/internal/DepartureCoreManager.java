package com.didi.map.sdk.departure.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PointF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.didi.common.map.Map;
import com.didi.common.map.Projection;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.sdk.departure.DepartureAddress;
import com.didi.map.sdk.departure.IDepartureCompContract;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubble;
import com.didi.map.sdk.departure.internal.bubble.RecBubbleController;
import com.didi.map.sdk.departure.internal.data.DepartureDataUtils;
import com.didi.map.sdk.departure.internal.data.DepartureHttpTask;
import com.didi.map.sdk.departure.internal.data.DepartureHttpTaskParam;
import com.didi.map.sdk.departure.internal.data.IDepartureHttpTask;
import com.didi.map.sdk.departure.internal.data.OnDepartureHttpTaskListener;
import com.didi.map.sdk.departure.internal.markers.IRecMarkerController;
import com.didi.map.sdk.departure.internal.markers.RecMarkerController;
import com.didi.map.sdk.departure.internal.markers.RecMarkerControllerParam;
import com.didi.map.sdk.departure.internal.markers.RecPoint;
import com.didi.map.sdk.departure.internal.pin.DepartureMarkerView;
import com.didi.map.sdk.departure.internal.pin.DeparturePinDrawer;
import com.didi.map.sdk.departure.internal.pin.IPinDrawer;
import com.didi.map.sdk.departure.internal.rec.IRecMarker;
import com.didi.map.sdk.departure.internal.rec.OnRecMarkClickListener;
import com.didi.map.sdk.departure.internal.util.ApolloUtils;
import com.didi.map.sdk.departure.internal.util.FenceUtils;
import com.didi.map.sdk.departure.internal.util.LatLngUtil;
import com.didi.map.sdk.departure.internal.util.OmegaUtil;
import com.didi.map.sdk.departure.internal.util.PinActionUtil;
import com.didi.map.sdk.departure.internal.util.ThreadManager;
import com.didi.map.sdk.departure.param.DepartureCompParam;
import com.didi.map.sdk.departure.param.DepartureLocationInfo;
import com.didi.map.sdk.fencecomponent.FenceComponentParam;
import com.didi.map.sdk.fencecomponent.FenceDrawer;
import com.didi.map.sdk.fencecomponent.IFenceDrawer;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.WindowUtil;
import com.google.gson.Gson;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.GeoFence;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DepartureCoreManager implements IDepartureCompContract {
    public static final int ZOOM_AUTO_SHOW_RECOMMEND_DEPARTURE = 15;

    /* renamed from: a */
    private static final String f28105a = "DepartureCoreManager";

    /* renamed from: A */
    private boolean f28106A = false;

    /* renamed from: B */
    private OnDepartureHttpTaskListener f28107B = new OnDepartureHttpTaskListener() {
        public void onPrepare(LatLng latLng, int i) {
            if (DepartureCoreManager.this.f28111d.get() == i) {
                if (!(DepartureCoreManager.this.f28108C == null || DepartureCoreManager.this.f28108C.listener == null)) {
                    DepartureCoreManager.this.f28108C.listener.onDepartureLoading(latLng);
                }
                if (DepartureCoreManager.this.f28113f != null) {
                    DepartureCoreManager.this.f28113f.startLoadingAnimation();
                }
            }
        }

        public void onSuccess(ReverseStationsInfo reverseStationsInfo, int i) {
            DLog.m7384d(DepartureCoreManager.f28105a, "OnDepartureHttpTaskListener onSuccess()", new Object[0]);
            if (DepartureCoreManager.this.f28111d.get() == i) {
                DepartureCoreManager.this.m19973a(reverseStationsInfo);
            }
            OmegaUtil.trackPinReqSuccess();
        }

        public void onFail(int i, int i2) {
            DLog.m7384d(DepartureCoreManager.f28105a, "OnDepartureHttpTaskListener onFail()", new Object[0]);
            if (DepartureCoreManager.this.f28111d.get() == i2) {
                DepartureCoreManager.this.m19973a((ReverseStationsInfo) null);
            }
            OmegaUtil.trackPinReqFail(i);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: C */
    public DepartureCompParam f28108C;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map f28109b;

    /* renamed from: c */
    private Context f28110c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicInteger f28111d = new AtomicInteger(-1);

    /* renamed from: e */
    private IDepartureHttpTask f28112e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IPinDrawer f28113f;

    /* renamed from: g */
    private int f28114g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IRecMarkerController f28115h;

    /* renamed from: i */
    private boolean f28116i;

    /* renamed from: j */
    private int f28117j;

    /* renamed from: k */
    private float f28118k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public RpcPoi f28119l;

    /* renamed from: m */
    private IFenceDrawer f28120m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f28121n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f28122o = false;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public CameraPosition f28123p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f28124q = false;

    /* renamed from: r */
    private DepartureLocationInfo f28125r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ReverseStationsInfo f28126s;

    /* renamed from: t */
    private List<RpcPoi> f28127t = null;

    /* renamed from: u */
    private MapListener f28128u = new MapListener();

    /* renamed from: v */
    private NetworkReceiver f28129v = new NetworkReceiver();
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f28130w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public LatLng f28131x;

    /* renamed from: y */
    private DepartureAddress f28132y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f28133z = -1;

    public void create(Context context, Map map) {
        this.f28109b = map;
        this.f28110c = context.getApplicationContext();
        this.f28116i = ApolloUtils.isNeedAdsorbControlEnabled();
        this.f28117j = ApolloUtils.getNeedAdsorbControlMaxDistance();
        this.f28118k = ApolloUtils.getNeedAdsorbControlPercentage();
        this.f28114g = ApolloUtils.getMoveDistanceLimit();
        OmegaUtil.isPinFirstShow = false;
        OmegaUtil.isFirst = true;
    }

    public void destroy() {
        stop();
        this.f28109b = null;
        this.f28110c = null;
        OmegaUtil.hasDragged = false;
        OmegaUtil.isPinFirstShow = false;
    }

    public void setConfigParam(DepartureCompParam departureCompParam) {
        if (departureCompParam != null) {
            this.f28108C = departureCompParam;
        } else {
            this.f28108C = null;
        }
    }

    public void onMapVisible(boolean z) {
        IDepartureHttpTask iDepartureHttpTask = this.f28112e;
        if (iDepartureHttpTask != null) {
            iDepartureHttpTask.onMapVisible(z);
        }
    }

    public void start() {
        if (!this.f28130w) {
            int i = 0;
            DLog.m7384d(f28105a, "start()", new Object[0]);
            this.f28130w = true;
            m19968a();
            m19986c();
            m19992f();
            this.f28124q = m19977a(this.f28110c);
            if (this.f28108C.locationInfo != null) {
                if (this.f28108C.locationInfo.sugPoi != null) {
                    i = this.f28108C.locationInfo.sugPoi.operationType;
                }
                m19971a(this.f28108C.locationInfo, i, -1);
            }
        }
    }

    public void stop() {
        DLog.m7384d(f28105a, "stop()", new Object[0]);
        Map map = this.f28109b;
        if (map != null) {
            map.stopAnimation();
        }
        this.f28130w = false;
        this.f28124q = false;
        m19983b();
        m19988d();
        m19991e();
        m19995g();
        m19999i();
        m19996h();
        removeDepartureBubble(false);
    }

    public boolean isStarted() {
        return this.f28130w;
    }

    public <T extends DepartureBubble> T createDepartureBubble(Class<T> cls) {
        IPinDrawer iPinDrawer = this.f28113f;
        if (iPinDrawer != null) {
            return iPinDrawer.createDepartureBubble(cls);
        }
        return null;
    }

    public void removeDepartureBubble(boolean z) {
        IPinDrawer iPinDrawer = this.f28113f;
        if (iPinDrawer != null) {
            iPinDrawer.removeDepartureBubble(z);
        }
    }

    /* renamed from: a */
    private void m19968a() {
        Map map = this.f28109b;
        if (map != null) {
            map.addOnCameraChangeListener(this.f28128u);
            this.f28109b.addOnMapGestureListener(this.f28128u);
        }
    }

    /* renamed from: b */
    private void m19983b() {
        Map map = this.f28109b;
        if (map != null) {
            map.removeOnCameraChangeListener(this.f28128u);
            this.f28109b.removeOnMapGestureListener(this.f28128u);
        }
    }

    /* renamed from: c */
    private void m19986c() {
        try {
            m19988d();
            if (this.f28110c != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
                try {
                    this.f28110c.registerReceiver(this.f28129v, intentFilter);
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    private void m19988d() {
        try {
            if (this.f28110c != null) {
                try {
                    this.f28110c.unregisterReceiver(this.f28129v);
                } catch (Exception e) {
                    Log.d("Context", "unregisterReceiver", e);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m19971a(DepartureLocationInfo departureLocationInfo, int i, int i2) {
        if (this.f28108C != null && departureLocationInfo != null) {
            if (OmegaUtil.isFirst) {
                this.f28106A = true;
            }
            DLog.m7384d(f28105a, "startHttp：" + departureLocationInfo.toString() + ",scrollType =" + i2, new Object[0]);
            m19991e();
            DepartureHttpTask departureHttpTask = new DepartureHttpTask();
            this.f28112e = departureHttpTask;
            departureHttpTask.create(this.f28110c, this.f28109b);
            this.f28112e.setConfigParam(new DepartureHttpTaskParam.Builder().departureTime(this.f28108C.departureTime).callFrom(this.f28108C.callFrom).isNeedFence(this.f28108C.isFenceVisible).locationInfo(departureLocationInfo).operationType(i).apiType(this.f28108C.apiType).listener(this.f28107B).taskID(this.f28111d.incrementAndGet()).timeOut(this.f28108C.timeOut).isNeedNLP(this.f28108C.isNeedNLP).build());
            this.f28112e.start();
            this.f28125r = departureLocationInfo;
            this.f28133z = i2;
        }
    }

    /* renamed from: e */
    private void m19991e() {
        IDepartureHttpTask iDepartureHttpTask = this.f28112e;
        if (iDepartureHttpTask != null) {
            iDepartureHttpTask.stop();
            this.f28112e.destroy();
            this.f28112e = null;
            this.f28111d.getAndIncrement();
        }
    }

    /* renamed from: f */
    private void m19992f() {
        DepartureCompParam departureCompParam;
        if (this.f28113f == null && this.f28109b != null && (departureCompParam = this.f28108C) != null && departureCompParam.isPinVisible) {
            DeparturePinDrawer departurePinDrawer = new DeparturePinDrawer();
            this.f28113f = departurePinDrawer;
            departurePinDrawer.create(this.f28110c, this.f28109b);
            this.f28113f.setConfigParam(this.f28108C.pinStyle);
            this.f28113f.add();
            OmegaUtil.map_fist_pin_show(this.f28110c, m20000j(), this.f28108C, false);
        }
    }

    /* renamed from: g */
    private void m19995g() {
        IPinDrawer iPinDrawer = this.f28113f;
        if (iPinDrawer != null) {
            iPinDrawer.remove();
            this.f28113f.destroy();
            this.f28113f = null;
        }
    }

    /* renamed from: a */
    private void m19972a(FenceInfo fenceInfo) {
        if (this.f28109b != null && fenceInfo != null && fenceInfo.drawFence != 0 && !CollectionUtil.isEmpty((Collection<?>) fenceInfo.polygon) && this.f28108C.isFenceVisible) {
            m19996h();
            FenceDrawer fenceDrawer = new FenceDrawer();
            this.f28120m = fenceDrawer;
            fenceDrawer.create(this.f28110c, this.f28109b);
            FenceComponentParam.Builder builder = new FenceComponentParam.Builder();
            ArrayList arrayList = new ArrayList();
            arrayList.add(FenceUtils.convert2FencePolygon(fenceInfo.polygon));
            builder.fences(arrayList).fillColor(DepartureConstants.FENCE_FILL_COLOR).strokeColor(DepartureConstants.FENCE_STROKE_COLOR).strokeWidth(2.0f).limitZoom(13.0d);
            this.f28120m.setConfigParam(builder.build());
            this.f28120m.add();
            SystemUtils.log(6, "ccc", "添加围栏" + this.f28120m.hashCode(), (Throwable) null, "com.didi.map.sdk.departure.internal.DepartureCoreManager", 387);
        }
    }

    /* renamed from: a */
    private void m19974a(List<RecPoint> list) {
        if (this.f28126s != null && this.f28108C != null && this.f28109b != null && !CollectionUtil.isEmpty((Collection<?>) list) && this.f28108C.isRecPointVisible) {
            m19999i();
            RecMarkerController recMarkerController = new RecMarkerController();
            this.f28115h = recMarkerController;
            recMarkerController.create(this.f28110c, this.f28109b);
            RecMarkerControllerParam recMarkerControllerParam = new RecMarkerControllerParam();
            recMarkerControllerParam.list = list;
            recMarkerControllerParam.icon = this.f28108C.recStyle.icon;
            recMarkerControllerParam.selectedIcon = this.f28108C.recStyle.selectedIcon;
            recMarkerControllerParam.isClickable = true;
            recMarkerControllerParam.markerClickListener = new OnRecMarkClickListener() {
                public final void onClick(IRecMarker iRecMarker) {
                    DepartureCoreManager.this.m19970a(iRecMarker);
                }
            };
            this.f28115h.setConfigParam(recMarkerControllerParam);
            this.f28115h.add();
            if (DepartureDataUtils.isAllowShowCircles(this.f28126s)) {
                this.f28115h.showCircles();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m19970a(IRecMarker iRecMarker) {
        if (!LatLngUtil.isSameLatLng(iRecMarker.getLocation(), m20000j())) {
            RpcPoi findTargetRecommend = DepartureDataUtils.findTargetRecommend(iRecMarker.getLocation(), this.f28127t);
            this.f28119l = findTargetRecommend;
            this.f28132y = m19966a(findTargetRecommend);
            RpcPoi rpcPoi = this.f28119l;
            if (rpcPoi != null) {
                final LatLng latLng = new LatLng(rpcPoi.base_info.lat, this.f28119l.base_info.lng);
                PinActionUtil.animateCamera(this.f28109b, latLng, true, false, this.f28108C.zoom, new CancelableCallback() {
                    public void onCancel() {
                    }

                    public void onFinish() {
                        PinActionUtil.startAdsorbRecommendAnimation(DepartureCoreManager.this.f28113f, 10, DepartureCoreManager.this.f28115h, latLng);
                        OmegaUtil.map_recommend_drag(DepartureCoreManager.this.f28119l);
                    }
                });
                DepartureCompParam departureCompParam = this.f28108C;
                if (departureCompParam != null && departureCompParam.listener != null) {
                    if (this.f28132y != null) {
                        this.f28108C.listener.onDepartureAddressChanged(this.f28132y);
                        return;
                    }
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = this.f28108C.listener;
                    DepartureLocationInfo departureLocationInfo = this.f28125r;
                    iDepartueCompCallback.onFetchAddressFailed(departureLocationInfo != null ? departureLocationInfo.latLng : null);
                }
            }
        }
    }

    /* renamed from: h */
    private void m19996h() {
        IFenceDrawer iFenceDrawer = this.f28120m;
        if (iFenceDrawer != null) {
            iFenceDrawer.destroy();
            SystemUtils.log(6, "ccc", "删除围栏" + this.f28120m.hashCode(), (Throwable) null, "com.didi.map.sdk.departure.internal.DepartureCoreManager", 452);
            this.f28120m = null;
        }
    }

    /* renamed from: i */
    private void m19999i() {
        IRecMarkerController iRecMarkerController = this.f28115h;
        if (iRecMarkerController != null) {
            iRecMarkerController.destroy();
            this.f28115h = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public LatLng m20000j() {
        Map map = this.f28109b;
        if (map == null || map.getCameraPosition() == null) {
            return null;
        }
        return this.f28109b.getCameraPosition().target;
    }

    class MapListener implements OnCameraChangeListener, OnMapGestureListener {
        public boolean onDoubleTap(float f, float f2) {
            return false;
        }

        public boolean onFling(float f, float f2) {
            return false;
        }

        public boolean onLongPress(float f, float f2) {
            return false;
        }

        public boolean onSingleTap(float f, float f2) {
            return false;
        }

        public boolean onUp(float f, float f2) {
            return false;
        }

        MapListener() {
        }

        public boolean onScroll(float f, float f2) {
            boolean unused = DepartureCoreManager.this.f28122o = true;
            if (!DepartureCoreManager.this.f28121n) {
                DepartureCoreManager departureCoreManager = DepartureCoreManager.this;
                LatLng unused2 = departureCoreManager.f28131x = departureCoreManager.m20000j();
                if (!(DepartureCoreManager.this.f28108C == null || DepartureCoreManager.this.f28108C.listener == null)) {
                    DepartureCoreManager.this.f28108C.listener.onStartDragging();
                }
                if (DepartureCoreManager.this.f28113f != null) {
                    DepartureCoreManager.this.f28113f.startJumpAnimation(new DepartureMarkerView.AnimationFinishListener() {
                        public void onFinish() {
                        }
                    });
                }
                OmegaUtil.map_base_slide();
            }
            boolean unused3 = DepartureCoreManager.this.f28121n = true;
            OmegaUtil.hasDragged = true;
            DepartureCoreManager.this.m20002k();
            return false;
        }

        public boolean onDown(float f, float f2) {
            if (DepartureCoreManager.this.f28109b == null) {
                return false;
            }
            DepartureCoreManager departureCoreManager = DepartureCoreManager.this;
            CameraPosition unused = departureCoreManager.f28123p = departureCoreManager.f28109b.getCameraPosition();
            return false;
        }

        public void onMapStable() {
            OmegaUtil.hasDragged = false;
            DepartureCoreManager.this.m20004l();
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            if (DepartureCoreManager.this.f28123p != null && DepartureCoreManager.this.f28109b != null && DepartureCoreManager.this.f28115h != null) {
                DepartureCoreManager.this.f28115h.onZoomChange(DepartureCoreManager.this.f28109b.getCameraPosition().zoom);
            }
        }
    }

    /* renamed from: a */
    private boolean m19978a(CameraPosition cameraPosition, CameraPosition cameraPosition2) {
        return (cameraPosition == null || cameraPosition2 == null || LatLngUtil.isSameLatLng(cameraPosition.target, cameraPosition2.target)) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m20002k() {
        m19991e();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m20004l() {
        DepartureCompParam departureCompParam;
        IRecMarkerController iRecMarkerController = this.f28115h;
        if (!(iRecMarkerController == null || iRecMarkerController.findMarker(m20000j()) == null)) {
            this.f28115h.hideCircles();
        }
        IRecMarkerController iRecMarkerController2 = this.f28115h;
        if (iRecMarkerController2 != null) {
            iRecMarkerController2.setNeedShowInfoWindow(m20007m());
            this.f28115h.onMapStable();
        }
        if (this.f28121n && (departureCompParam = this.f28108C) != null && departureCompParam.requireByDrag) {
            LatLng j = m20000j();
            DepartureLocationInfo departureLocationInfo = this.f28125r;
            updateDepartureLocation_inner(new DepartureLocationInfo(j, departureLocationInfo != null ? departureLocationInfo.sugPoi : null, "wgs84"), 1, 0);
            this.f28121n = false;
            this.f28131x = null;
        } else if (OmegaUtil.isFirst && !this.f28106A && this.f28108C != null) {
            OmegaUtil.trackPinMove(m20000j(), 0, this.f28133z, this.f28108C.callFrom);
        }
    }

    /* renamed from: m */
    private boolean m20007m() {
        DepartureAddress departureAddress;
        if (!(RecBubbleController.hasBubbleDesc(this.f28132y) || (departureAddress = this.f28132y) == null || departureAddress.getAddress() == null)) {
            RpcPoi address = this.f28132y.getAddress();
            if (address.base_info == null || TextUtils.isEmpty(address.base_info.srctag) || (!DepartureConstants.SRCTAG_DIDIFENCE_AIRPORT.equals(address.base_info.srctag) && !DepartureConstants.SRCTAG_DIDIFENCE_COMMON.equals(address.base_info.srctag))) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19977a(Context context) {
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    class NetworkReceiver extends BroadcastReceiver {
        NetworkReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION) && DepartureCoreManager.this.f28130w) {
                boolean a = DepartureCoreManager.this.m19977a(context);
                if (a && !DepartureCoreManager.this.f28124q && DepartureCoreManager.this.f28126s == null && !DepartureCoreManager.this.f28121n) {
                    boolean unused = DepartureCoreManager.this.f28121n = true;
                    DepartureCoreManager.this.m20004l();
                }
                boolean unused2 = DepartureCoreManager.this.f28124q = a;
            }
        }
    }

    public RpcPoi sensing() {
        Map map = this.f28109b;
        RpcPoi rpcPoi = null;
        if (map != null && map.getCameraPosition().zoom >= 15.0d) {
            double d = Double.MAX_VALUE;
            List<RpcPoi> list = this.f28127t;
            if (list != null && !list.isEmpty()) {
                for (RpcPoi next : this.f28127t) {
                    LatLng latLng = new LatLng(next.base_info.lat, next.base_info.lng);
                    double a = m19963a(m20000j(), latLng);
                    double distance = LatLngUtil.getDistance(m20000j(), latLng);
                    if (m19976a(a, distance) && distance < d) {
                        rpcPoi = next;
                        d = distance;
                    }
                }
            }
        }
        return rpcPoi;
    }

    /* renamed from: a */
    private double m19963a(LatLng latLng, LatLng latLng2) {
        Projection projection = this.f28109b.getProjection();
        if (projection == null) {
            return -1.0d;
        }
        PointF screenLocation = projection.toScreenLocation(latLng);
        PointF screenLocation2 = projection.toScreenLocation(latLng2);
        return Math.sqrt(Math.pow((double) Math.abs(screenLocation.x - screenLocation2.x), 2.0d) + Math.pow((double) Math.abs(screenLocation.y - screenLocation2.y), 2.0d));
    }

    /* renamed from: a */
    private boolean m19976a(double d, double d2) {
        boolean z = m19975a(d) && d < Double.MAX_VALUE;
        if (!this.f28116i || d2 <= ((double) this.f28117j)) {
            return z;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m19975a(double d) {
        if (d >= 0.0d && d / ((double) WindowUtil.getWindowWidth(this.f28110c)) <= ((double) this.f28118k)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19973a(ReverseStationsInfo reverseStationsInfo) {
        IPinDrawer iPinDrawer = this.f28113f;
        if (iPinDrawer != null) {
            iPinDrawer.stopAnimation();
        }
        LatLng latLng = null;
        if (reverseStationsInfo != null) {
            this.f28126s = reverseStationsInfo;
            m19996h();
            m19999i();
            m19972a(reverseStationsInfo.startFenceInfo);
            ArrayList<RpcPoi> recStartPoints = this.f28126s.getRecStartPoints();
            this.f28127t = recStartPoints;
            if (CollectionUtil.isEmpty((Collection<?>) recStartPoints) && reverseStationsInfo.geofenceTags != null && !reverseStationsInfo.geofenceTags.isEmpty() && reverseStationsInfo.geofenceTags.contains("airport")) {
                this.f28127t = DepartureDataUtils.getSpecialRpcPois(this.f28126s);
            }
            ArrayList arrayList = new ArrayList();
            if (!CollectionUtil.isEmpty((Collection<?>) this.f28127t)) {
                for (RpcPoi next : this.f28127t) {
                    RecPoint recPoint = new RecPoint();
                    recPoint.addrName = next.base_info.displayname;
                    recPoint.location = new LatLng(next.base_info.lat, next.base_info.lng);
                    recPoint.srctag = next.base_info.srctag;
                    arrayList.add(recPoint);
                }
            }
            RpcPoi findRecommendAdsorbPoint = DepartureDataUtils.findRecommendAdsorbPoint(this.f28127t);
            this.f28119l = findRecommendAdsorbPoint;
            this.f28132y = m19966a(findRecommendAdsorbPoint);
            m19974a((List<RecPoint>) arrayList);
            if (this.f28115h != null) {
                RpcPoi rpcPoi = this.f28119l;
                if (rpcPoi == null || rpcPoi.base_info == null) {
                    DLog.m7384d(f28105a, "HandleRecvHttpRsp：未吸附:", new Object[0]);
                } else {
                    final LatLng latLng2 = new LatLng(this.f28119l.base_info.lat, this.f28119l.base_info.lng);
                    DLog.m7384d(f28105a, "HandleRecvHttpRsp：吸附:" + latLng2.toString(), new Object[0]);
                    PinActionUtil.animateCamera(this.f28109b, latLng2, true, false, this.f28108C.zoom, new CancelableCallback() {
                        public void onCancel() {
                        }

                        public void onFinish() {
                            PinActionUtil.startAdsorbRecommendAnimation(DepartureCoreManager.this.f28113f, 10, DepartureCoreManager.this.f28115h, latLng2);
                            OmegaUtil.map_recommend_drag(DepartureCoreManager.this.f28119l);
                        }
                    });
                }
            }
            DepartureCompParam departureCompParam = this.f28108C;
            if (!(departureCompParam == null || departureCompParam.listener == null)) {
                if (this.f28132y != null) {
                    this.f28108C.listener.onDepartureAddressChanged(this.f28132y);
                } else {
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = this.f28108C.listener;
                    DepartureLocationInfo departureLocationInfo = this.f28125r;
                    if (departureLocationInfo != null) {
                        latLng = departureLocationInfo.latLng;
                    }
                    iDepartueCompCallback.onFetchAddressFailed(latLng);
                }
            }
        } else {
            DepartureCompParam departureCompParam2 = this.f28108C;
            if (!(departureCompParam2 == null || departureCompParam2.listener == null)) {
                IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback2 = this.f28108C.listener;
                DepartureLocationInfo departureLocationInfo2 = this.f28125r;
                if (departureLocationInfo2 != null) {
                    latLng = departureLocationInfo2.latLng;
                }
                iDepartueCompCallback2.onFetchAddressFailed(latLng);
            }
        }
        ThreadManager.getHandler(0).postDelayed(new Runnable() {
            public void run() {
                if (DepartureCoreManager.this.f28108C == null) {
                    return;
                }
                if (DepartureCoreManager.this.f28115h == null || DepartureCoreManager.this.f28119l == null || DepartureCoreManager.this.f28119l.base_info == null) {
                    OmegaUtil.trackPinMove(DepartureCoreManager.this.m20000j(), 0, DepartureCoreManager.this.f28133z, DepartureCoreManager.this.f28108C.callFrom);
                } else {
                    OmegaUtil.trackPinMove(DepartureCoreManager.this.m20000j(), 1, DepartureCoreManager.this.f28133z, DepartureCoreManager.this.f28108C.callFrom);
                }
            }
        }, 500);
    }

    /* renamed from: a */
    private DepartureAddress m19966a(RpcPoi rpcPoi) {
        boolean z;
        RpcPoi rpcPoi2;
        if (this.f28126s == null) {
            return null;
        }
        if (rpcPoi == null || !LatLngUtil.locateCorrect(rpcPoi.base_info.lat, rpcPoi.base_info.lng)) {
            rpcPoi2 = this.f28126s.getDepartureAddress();
            if (rpcPoi2 != null && !TextUtils.isEmpty(this.f28126s.specialPoiList)) {
                rpcPoi2.specialPoiList = this.f28126s.specialPoiList;
            }
            z = false;
        } else {
            if (!TextUtils.isEmpty(this.f28126s.specialPoiList)) {
                rpcPoi.specialPoiList = this.f28126s.specialPoiList;
            }
            rpcPoi2 = rpcPoi;
            z = true;
        }
        if (rpcPoi2 == null) {
            return null;
        }
        GeoFence geoFence = this.f28126s.geoFence;
        if (geoFence != null) {
            rpcPoi2.geofence = geoFence.f56003id;
        }
        DepartureAddress departureAddress = new DepartureAddress();
        departureAddress.setAddress(rpcPoi2);
        departureAddress.setRecommendPoi(z);
        if (rpcPoi == null || !rpcPoi.isInNoStopZone) {
            departureAddress.setFenceInfo(DepartureDataUtils.getFenceInfo(this.f28126s));
            departureAddress.setZoneStatus(0);
        } else {
            try {
                departureAddress.setFenceInfo((FenceInfo) new Gson().fromJson(this.f28126s.specialPoiList, FenceInfo.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
            departureAddress.setZoneStatus(1);
        }
        departureAddress.setSpecialPoiGuidance(this.f28126s.specialPoiGuidance);
        departureAddress.setRecommendDestinations(this.f28126s.recDestination);
        if (!TextUtils.isEmpty(rpcPoi2.base_info.displayname)) {
            departureAddress.setDepartureDisplayName(rpcPoi2.base_info.displayname);
        } else {
            departureAddress.setDepartureDisplayName("");
        }
        departureAddress.setSpecialPois(DepartureDataUtils.getSpecialPois(this.f28126s));
        departureAddress.setLanguage(this.f28126s.language);
        departureAddress.setGeofenceTags(this.f28126s.geofenceTags);
        departureAddress.setPickUpPointSize(DepartureDataUtils.getRecommendPoiCount(this.f28126s));
        if (!CollectionUtil.isEmpty((Collection<?>) this.f28126s.result)) {
            departureAddress.setRgeoResult(this.f28126s.result.get(0));
        }
        if (this.f28122o) {
            departureAddress.setOperationType(1);
        } else {
            DepartureCompParam departureCompParam = this.f28108C;
            if (departureCompParam == null || departureCompParam.locationInfo == null || this.f28108C.locationInfo.sugPoi == null) {
                departureAddress.setOperationType(0);
            } else {
                departureAddress.setOperationType(this.f28108C.locationInfo.sugPoi.operationType);
            }
        }
        return departureAddress;
    }

    /* renamed from: a */
    private boolean m19981a(DepartureLocationInfo departureLocationInfo) {
        return (departureLocationInfo == null || departureLocationInfo.latLng == null || !LatLngUtil.locateCorrect(departureLocationInfo.latLng)) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateDepartureLocation_inner(com.didi.map.sdk.departure.param.DepartureLocationInfo r12, int r13, int r14) {
        /*
            r11 = this;
            boolean r0 = r11.m19981a((com.didi.map.sdk.departure.param.DepartureLocationInfo) r12)
            if (r0 == 0) goto L_0x0131
            boolean r0 = r11.f28130w
            if (r0 != 0) goto L_0x000c
            goto L_0x0131
        L_0x000c:
            com.didi.common.map.Map r0 = r11.f28109b
            if (r0 == 0) goto L_0x0016
            com.didi.common.map.model.CameraPosition r0 = r0.getCameraPosition()
            r11.f28123p = r0
        L_0x0016:
            r0 = 0
            com.didi.map.sdk.departure.param.DepartureLocationInfo r1 = r11.f28125r
            r2 = 1
            if (r1 != 0) goto L_0x001f
        L_0x001c:
            r0 = 1
            goto L_0x00f8
        L_0x001f:
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r11.f28126s
            if (r1 != 0) goto L_0x0024
            goto L_0x001c
        L_0x0024:
            com.didi.common.map.model.LatLng r1 = r12.latLng
            com.didi.map.sdk.departure.param.DepartureLocationInfo r3 = r11.f28125r
            com.didi.common.map.model.LatLng r3 = r3.latLng
            boolean r1 = com.didi.map.sdk.departure.internal.util.LatLngUtil.isSameLatLng(r1, r3)
            if (r1 == 0) goto L_0x0031
            return
        L_0x0031:
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r11.f28126s
            com.sdk.poibase.model.poi.FenceInfo r1 = r1.startFenceInfo
            boolean r3 = com.didi.map.sdk.departure.internal.util.FenceUtils.isFenceMustAbsorb(r1)
            r4 = 0
            if (r3 == 0) goto L_0x009f
            com.didi.common.map.Map r3 = r11.f28109b
            com.didi.common.map.model.LatLng r5 = r11.m20000j()
            boolean r1 = com.didi.map.sdk.departure.internal.util.FenceUtils.positionIsInFence(r3, r1, r5)
            if (r1 == 0) goto L_0x001c
            com.didi.common.map.model.LatLng r1 = r11.m20000j()
            java.util.List<com.sdk.poibase.model.RpcPoi> r2 = r11.f28127t
            com.sdk.poibase.model.RpcPoi r1 = com.didi.map.sdk.departure.internal.data.DepartureDataUtils.findTargetRecommend(r1, r2)
            r11.f28119l = r1
            if (r1 == 0) goto L_0x00f8
            com.didi.map.sdk.departure.internal.markers.IRecMarkerController r2 = r11.f28115h
            if (r2 == 0) goto L_0x00f8
            com.didi.common.map.model.LatLng r6 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r12 = r1.base_info
            double r12 = r12.lat
            com.sdk.poibase.model.RpcPoi r14 = r11.f28119l
            com.sdk.poibase.model.RpcPoiBaseInfo r14 = r14.base_info
            double r0 = r14.lng
            r6.<init>((double) r12, (double) r0)
            com.didi.common.map.Map r5 = r11.f28109b
            r7 = 1
            r8 = 0
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f28108C
            float r9 = r12.zoom
            com.didi.map.sdk.departure.internal.DepartureCoreManager$5 r10 = new com.didi.map.sdk.departure.internal.DepartureCoreManager$5
            r10.<init>(r6)
            com.didi.map.sdk.departure.internal.util.PinActionUtil.animateCamera(r5, r6, r7, r8, r9, r10)
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f28108C
            if (r12 == 0) goto L_0x009e
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r12 = r12.listener
            if (r12 == 0) goto L_0x009e
            com.sdk.poibase.model.RpcPoi r12 = r11.f28119l
            com.didi.map.sdk.departure.DepartureAddress r12 = r11.m19966a((com.sdk.poibase.model.RpcPoi) r12)
            if (r12 == 0) goto L_0x0091
            com.didi.map.sdk.departure.param.DepartureCompParam r13 = r11.f28108C
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r13 = r13.listener
            r13.onDepartureAddressChanged(r12)
            goto L_0x009e
        L_0x0091:
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f28108C
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r12 = r12.listener
            com.didi.map.sdk.departure.param.DepartureLocationInfo r13 = r11.f28125r
            if (r13 == 0) goto L_0x009b
            com.didi.common.map.model.LatLng r4 = r13.latLng
        L_0x009b:
            r12.onFetchAddressFailed(r4)
        L_0x009e:
            return
        L_0x009f:
            com.sdk.poibase.model.RpcPoi r1 = r11.sensing()
            r11.f28119l = r1
            if (r1 == 0) goto L_0x001c
            com.didi.map.sdk.departure.internal.markers.IRecMarkerController r3 = r11.f28115h
            if (r3 == 0) goto L_0x001c
            com.didi.common.map.model.LatLng r6 = new com.didi.common.map.model.LatLng
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r1.base_info
            double r1 = r1.lat
            com.sdk.poibase.model.RpcPoi r3 = r11.f28119l
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r3.base_info
            double r7 = r3.lng
            r6.<init>((double) r1, (double) r7)
            com.didi.map.sdk.departure.internal.markers.IRecMarkerController r1 = r11.f28115h
            com.didi.map.sdk.departure.internal.rec.IRecMarker r1 = r1.findMarker(r6)
            if (r1 == 0) goto L_0x00f8
            com.didi.common.map.Map r5 = r11.f28109b
            r7 = 1
            r8 = 0
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f28108C
            float r9 = r12.zoom
            com.didi.map.sdk.departure.internal.DepartureCoreManager$6 r10 = new com.didi.map.sdk.departure.internal.DepartureCoreManager$6
            r10.<init>(r6)
            com.didi.map.sdk.departure.internal.util.PinActionUtil.animateCamera(r5, r6, r7, r8, r9, r10)
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f28108C
            if (r12 == 0) goto L_0x00f7
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r12 = r12.listener
            if (r12 == 0) goto L_0x00f7
            com.sdk.poibase.model.RpcPoi r12 = r11.f28119l
            com.didi.map.sdk.departure.DepartureAddress r12 = r11.m19966a((com.sdk.poibase.model.RpcPoi) r12)
            if (r12 == 0) goto L_0x00ea
            com.didi.map.sdk.departure.param.DepartureCompParam r13 = r11.f28108C
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r13 = r13.listener
            r13.onDepartureAddressChanged(r12)
            goto L_0x00f7
        L_0x00ea:
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f28108C
            com.didi.map.sdk.departure.IDepartureCompContract$IDepartueCompCallback r12 = r12.listener
            com.didi.map.sdk.departure.param.DepartureLocationInfo r13 = r11.f28125r
            if (r13 == 0) goto L_0x00f4
            com.didi.common.map.model.LatLng r4 = r13.latLng
        L_0x00f4:
            r12.onFetchAddressFailed(r4)
        L_0x00f7:
            return
        L_0x00f8:
            if (r0 == 0) goto L_0x0131
            com.didi.map.sdk.departure.param.DepartureLocationInfo r0 = r11.f28125r
            if (r0 == 0) goto L_0x012e
            int r0 = r11.f28114g
            r1 = -1
            if (r0 <= r1) goto L_0x012e
            com.didi.common.map.model.LatLng r0 = r12.latLng
            com.didi.map.sdk.departure.param.DepartureLocationInfo r1 = r11.f28125r
            com.didi.common.map.model.LatLng r1 = r1.latLng
            double r0 = com.didi.map.sdk.departure.internal.util.LatLngUtil.getDistance(r0, r1)
            int r2 = r11.f28114g
            double r2 = (double) r2
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x012e
            com.didi.common.map.model.LatLng r12 = r11.f28131x
            if (r12 != 0) goto L_0x011c
            com.didi.map.sdk.departure.param.DepartureLocationInfo r12 = r11.f28125r
            com.didi.common.map.model.LatLng r12 = r12.latLng
        L_0x011c:
            r1 = r12
            com.didi.common.map.Map r0 = r11.f28109b
            r2 = 1
            r3 = 0
            com.didi.map.sdk.departure.param.DepartureCompParam r12 = r11.f28108C
            float r4 = r12.zoom
            com.didi.map.sdk.departure.internal.DepartureCoreManager$7 r5 = new com.didi.map.sdk.departure.internal.DepartureCoreManager$7
            r5.<init>()
            com.didi.map.sdk.departure.internal.util.PinActionUtil.animateCamera(r0, r1, r2, r3, r4, r5)
            return
        L_0x012e:
            r11.m19971a(r12, r13, r14)
        L_0x0131:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.departure.internal.DepartureCoreManager.updateDepartureLocation_inner(com.didi.map.sdk.departure.param.DepartureLocationInfo, int, int):void");
    }

    public void updateDepartureLocation(DepartureLocationInfo departureLocationInfo, boolean z) {
        if (departureLocationInfo == null) {
            return;
        }
        if (z) {
            updateDepartureLocation_inner(departureLocationInfo, 1, 1);
        } else {
            updateDepartureLocation_inner(departureLocationInfo, departureLocationInfo.sugPoi == null ? 0 : departureLocationInfo.sugPoi.operationType, 1);
        }
    }
}
