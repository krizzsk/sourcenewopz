package com.didi.map.sdk.sharetrack.google.inner.net;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq;
import com.didi.map.sdk.proto.driver_gl.HisTraj;
import com.didi.map.sdk.proto.driver_gl.LocationSource;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.entity.OrderPoint;
import com.didi.map.sdk.sharetrack.entity.RouteSearchOptions;
import com.didi.map.sdk.sharetrack.google.inner.model.PickUpPoint;
import com.didi.map.sdk.sharetrack.google.inner.model.PointInfo;
import com.didi.map.sdk.sharetrack.google.inner.utils.ApolloUtils;
import com.didi.map.sdk.sharetrack.google.inner.utils.C10194utils;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.map.sdk.sharetrack.net.DUrl;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

public class FetcherManager {

    /* renamed from: a */
    private static final String f28828a = "FetcherManager";

    /* renamed from: b */
    private static final int f28829b = 0;

    /* renamed from: c */
    private static final int f28830c = 1;

    /* renamed from: d */
    private static final int f28831d = 2;

    /* renamed from: e */
    private static final int f28832e = 4;

    /* renamed from: f */
    private static final int f28833f = 5;

    /* renamed from: l */
    private static final int f28834l = 100000;

    /* renamed from: m */
    private static final int f28835m = 100;

    /* renamed from: A */
    private boolean f28836A = true;

    /* renamed from: B */
    private CallFrom f28837B;

    /* renamed from: C */
    private String f28838C = "";

    /* renamed from: D */
    private Handler f28839D = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                if (FetcherManager.this.f28843j == null || FetcherManager.this.f28843j.getStatus() == AsyncTask.Status.FINISHED) {
                    SctxRouteFetcher unused = FetcherManager.this.f28843j = new SctxRouteFetcher(FetcherManager.this.getRequireData(false, false), FetcherManager.this.f28854w);
                    FetcherManager.this.f28843j.execute(new String[]{DUrl.getOrderRouteUrl(FetcherManager.this.f28840g)});
                } else {
                    DLog.m20357d(FetcherManager.f28828a, "require eta busy", new Object[0]);
                }
                FetcherManager.this.m20334b();
            } else if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i == 5) {
                            if (FetcherManager.this.f28844k == null) {
                                FetcherManager.this.m20331a();
                                FetcherManager.this.f28844k.calculateRoute(FetcherManager.this.m20336c(), FetcherManager.this.f28852u);
                                return;
                            }
                            DLog.m20357d(FetcherManager.f28828a, "require offroute req busy", new Object[0]);
                        }
                    } else if (FetcherManager.this.f28844k == null) {
                        FetcherManager.this.m20331a();
                        FetcherManager.this.f28844k.calculateRoute(FetcherManager.this.m20336c(), FetcherManager.this.f28853v);
                    } else {
                        DLog.m20357d(FetcherManager.f28828a, "require offroute req busy", new Object[0]);
                    }
                } else if (FetcherManager.this.f28841h == null || FetcherManager.this.f28841h.getStatus() == AsyncTask.Status.FINISHED) {
                    SctxRouteFetcher unused2 = FetcherManager.this.f28841h = new SctxRouteFetcher(FetcherManager.this.getRequireData(false, true), FetcherManager.this.f28852u);
                    FetcherManager.this.f28841h.execute(new String[]{DUrl.getOrderRouteUrl(FetcherManager.this.f28840g)});
                } else {
                    DLog.m20357d(FetcherManager.f28828a, "require route busy", new Object[0]);
                }
            } else if (FetcherManager.this.f28842i == null || FetcherManager.this.f28842i.getStatus() == AsyncTask.Status.FINISHED) {
                SctxRouteFetcher unused3 = FetcherManager.this.f28842i = new SctxRouteFetcher(FetcherManager.this.getRequireData(true, true), FetcherManager.this.f28853v);
                FetcherManager.this.f28842i.execute(new String[]{DUrl.getOrderRouteUrl(FetcherManager.this.f28840g)});
            } else {
                DLog.m20357d(FetcherManager.f28828a, "require offroute req busy", new Object[0]);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Context f28840g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SctxRouteFetcher f28841h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SctxRouteFetcher f28842i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public SctxRouteFetcher f28843j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public NormalRouteFetcherV2 f28844k;

    /* renamed from: n */
    private List<GpsLocation> f28845n;

    /* renamed from: o */
    private NaviRoute f28846o;

    /* renamed from: p */
    private long f28847p = 0;

    /* renamed from: q */
    private GpsLocation f28848q;

    /* renamed from: r */
    private LatLng f28849r;

    /* renamed from: s */
    private List<OrderPoint> f28850s;

    /* renamed from: t */
    private long f28851t = 0;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public ISearchRouteCallback f28852u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public ISearchRouteCallback f28853v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public ISearchRouteCallback f28854w;

    /* renamed from: x */
    private OrderInfo f28855x;

    /* renamed from: y */
    private boolean f28856y = false;

    /* renamed from: z */
    private boolean f28857z = true;

    public FetcherManager(Context context) {
        this.f28840g = context;
    }

    public void setIsSctx(boolean z) {
        this.f28857z = z;
    }

    public void setMultiSctxGroup(String str) {
        this.f28838C = str;
    }

    public void setRecentLocList(List<GpsLocation> list) {
        this.f28845n = list;
    }

    public void setNaviRoute(NaviRoute naviRoute) {
        this.f28846o = naviRoute;
    }

    public void setRouteId(long j) {
        this.f28847p = j;
    }

    public void setStart(GpsLocation gpsLocation) {
        this.f28848q = gpsLocation;
    }

    public void setDest(LatLng latLng) {
        this.f28849r = latLng;
    }

    public void setPassPoints(List<OrderPoint> list) {
        this.f28850s = list;
    }

    public long getPassPointTimeStamp() {
        return this.f28851t;
    }

    public void setPassPointTimeStamp(long j) {
        this.f28851t = j;
    }

    public void setInnerSearchRouteCallback(ISearchRouteCallback iSearchRouteCallback) {
        this.f28852u = iSearchRouteCallback;
    }

    public void setInnerOffRouteSearchRouteCallback(ISearchRouteCallback iSearchRouteCallback) {
        this.f28853v = iSearchRouteCallback;
    }

    public void setInnerEtaCallback(ISearchRouteCallback iSearchRouteCallback) {
        this.f28854w = iSearchRouteCallback;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.f28855x = orderInfo;
    }

    public void setShouldShowRoute(boolean z) {
        this.f28836A = z;
    }

    public void initRoute() {
        if (this.f28857z) {
            SctxRouteFetcher sctxRouteFetcher = new SctxRouteFetcher(getRequireData(false, true), this.f28852u);
            this.f28841h = sctxRouteFetcher;
            sctxRouteFetcher.execute(new String[]{DUrl.getOrderRouteUrl(this.f28840g)});
            DLog.m20357d(f28828a, "initRoute send require ok", new Object[0]);
            return;
        }
        m20331a();
        this.f28844k.calculateRoute(m20336c(), this.f28852u);
        DLog.m20357d(f28828a, "nav initRoute send require ok", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20331a() {
        if (this.f28844k == null) {
            this.f28844k = new NormalRouteFetcherV2(this.f28840g);
        }
        this.f28844k.setCaller(this.f28837B);
    }

    public void setCaller(CallFrom callFrom) {
        this.f28837B = callFrom;
    }

    public void additionalEtaReq() {
        SctxRouteFetcher sctxRouteFetcher = this.f28843j;
        if (sctxRouteFetcher == null || sctxRouteFetcher.getStatus() == AsyncTask.Status.FINISHED) {
            SctxRouteFetcher sctxRouteFetcher2 = new SctxRouteFetcher(getRequireData(false, false), (ISearchRouteCallback) null);
            this.f28843j = sctxRouteFetcher2;
            sctxRouteFetcher2.execute(new String[]{DUrl.getOrderRouteUrl(this.f28840g)});
            return;
        }
        DLog.m20357d(f28828a, "require eta busy", new Object[0]);
    }

    public boolean offRouteReq() {
        if (this.f28857z) {
            SctxRouteFetcher sctxRouteFetcher = this.f28842i;
            if (sctxRouteFetcher != null && sctxRouteFetcher.getStatus() != AsyncTask.Status.FINISHED) {
                return false;
            }
            SctxRouteFetcher sctxRouteFetcher2 = new SctxRouteFetcher(getRequireData(true, true), this.f28853v);
            this.f28842i = sctxRouteFetcher2;
            sctxRouteFetcher2.execute(new String[]{DUrl.getOrderRouteUrl(this.f28840g)});
            DLog.m20357d(f28828a, "onOffRoute send require ok", new Object[0]);
            return true;
        } else if (this.f28844k != null) {
            return false;
        } else {
            m20331a();
            this.f28844k.calculateRoute(m20336c(), this.f28853v);
            DLog.m20357d(f28828a, "nav onOffRoute send require ok", new Object[0]);
            return true;
        }
    }

    public void stop() {
        SctxRouteFetcher sctxRouteFetcher = this.f28842i;
        if (sctxRouteFetcher != null) {
            sctxRouteFetcher.cancel(true);
            this.f28842i = null;
        }
        SctxRouteFetcher sctxRouteFetcher2 = this.f28843j;
        if (sctxRouteFetcher2 != null) {
            sctxRouteFetcher2.cancel(true);
            this.f28843j = null;
        }
        SctxRouteFetcher sctxRouteFetcher3 = this.f28841h;
        if (sctxRouteFetcher3 != null) {
            sctxRouteFetcher3.cancel(true);
            this.f28841h = null;
        }
        if (this.f28844k != null) {
            this.f28844k = null;
        }
        Handler handler = this.f28839D;
        if (handler != null) {
            handler.removeMessages(0);
            this.f28839D.removeMessages(1);
            this.f28839D.removeMessages(2);
            this.f28839D.removeMessages(4);
            this.f28839D.removeMessages(5);
        }
    }

    public void destroy() {
        this.f28841h = null;
        this.f28843j = null;
        this.f28842i = null;
        this.f28844k = null;
        this.f28839D = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20334b() {
        if (!this.f28857z) {
            DLog.m20357d(f28828a, "updateEta， return because mIsSctx is false", new Object[0]);
            return;
        }
        OrderInfo orderInfo = this.f28855x;
        if (orderInfo == null || orderInfo.getOrderStage() != 2) {
            Handler handler = this.f28839D;
            if (handler == null || this.f28855x == null) {
                DLog.m20357d(f28828a, "updateEta error start fail", new Object[0]);
                return;
            }
            handler.removeMessages(0);
            this.f28839D.sendEmptyMessageDelayed(0, (long) ApolloUtils.getEtaInterval(this.f28855x.getOrderStage()));
            this.f28856y = true;
            return;
        }
        DLog.m20357d(f28828a, "updateEta， return because orderStage is 2", new Object[0]);
    }

    public void startEta() {
        DLog.m20357d(f28828a, "startEta enter", new Object[0]);
        if (this.f28857z && !this.f28856y) {
            m20334b();
        }
    }

    public void CancelEta() {
        if (!this.f28857z) {
            DLog.m20357d(f28828a, "CancelEta， return because mIsSctx is false", new Object[0]);
            return;
        }
        OrderInfo orderInfo = this.f28855x;
        if (orderInfo == null || orderInfo.getOrderStage() != 2) {
            this.f28856y = false;
            Handler handler = this.f28839D;
            if (handler != null) {
                handler.removeMessages(0);
                return;
            }
            return;
        }
        DLog.m20357d(f28828a, "CancelEta， return because orderStage is 2", new Object[0]);
    }

    public void updateRoute(long j) {
        Handler handler = this.f28839D;
        if (handler != null && j > 0) {
            int i = 2;
            handler.removeMessages(this.f28857z ? 2 : 5);
            Handler handler2 = this.f28839D;
            if (!this.f28857z) {
                i = 5;
            }
            handler2.sendEmptyMessageDelayed(i, j * 1000);
        }
    }

    public void offRouteTryAgain() {
        Handler handler = this.f28839D;
        if (handler != null) {
            boolean z = this.f28857z;
            handler.removeMessages(1);
            Handler handler2 = this.f28839D;
            boolean z2 = this.f28857z;
            handler2.sendEmptyMessageDelayed(1, 1000);
        }
    }

    public DriverOrderRouteReq getRequireData(boolean z, boolean z2) {
        DriverOrderRouteReq.Builder builder = new DriverOrderRouteReq.Builder();
        String driverPhoneNumber = PlatInfo.getInstance().getDriverPhoneNumber();
        if (driverPhoneNumber == null || driverPhoneNumber.isEmpty()) {
            driverPhoneNumber = "0";
        }
        builder.ticket(PlatInfo.getInstance().getDriverTicket()).phoneNum(driverPhoneNumber).driverId(Long.valueOf(PlatInfo.getInstance().getDriverId())).traverId(PlatInfo.getInstance().getTraverId());
        if (this.f28848q != null) {
            builder.startPoint(new DoublePoint.Builder().dlat(Double.valueOf(this.f28848q.latitude)).dlng(Double.valueOf(this.f28848q.longitude)).lat(Float.valueOf((float) this.f28848q.latitude)).lng(Float.valueOf((float) this.f28848q.longitude)).accuracy(Double.valueOf((double) this.f28848q.accuracy)).timestamp(Long.valueOf(this.f28848q.time / 1000)).gpsTimestamp(Long.valueOf(this.f28848q.time / 1000)).speed(Integer.valueOf((int) this.f28848q.velocity)).gpsSource(getLocationSrc(this.f28848q.provider)).build()).startPointAccuracy(0).startPointDirection(Integer.valueOf(((int) (this.f28848q.direction + 360.0f)) % 360)).startPointSpeed(0);
        }
        if (this.f28849r != null) {
            builder.endPoint(new DoublePoint.Builder().lat(Float.valueOf((float) this.f28849r.latitude)).lng(Float.valueOf((float) this.f28849r.longitude)).build());
        }
        if (this.f28850s != null) {
            ArrayList arrayList = new ArrayList();
            for (OrderPoint next : this.f28850s) {
                if (!(next == null || next.point == null)) {
                    arrayList.add(new OdPoint(Long.valueOf(next.orderId), Integer.valueOf(next.orderType), new DoublePoint.Builder().lat(Float.valueOf((float) next.point.latitude)).lng(Float.valueOf((float) next.point.longitude)).build(), next.strOrderId, Integer.valueOf(next.pointType), Float.valueOf(0.0f), 0, (DoublePoint) null, ""));
                }
            }
            builder.odPoints(arrayList);
        }
        long j = this.f28851t;
        if (j > 0) {
            builder.odPointsTimestamp(Long.valueOf(j));
        }
        byte[] bytes = m20341e().getBytes();
        DriverOrderRouteReq.Builder timestamp = builder.eventType(Integer.valueOf(z ? 1 : 0)).timestamp(Long.valueOf(System.currentTimeMillis()));
        OrderInfo orderInfo = this.f28855x;
        DriverOrderRouteReq.Builder bizType = timestamp.orderId(orderInfo == null ? "" : orderInfo.getOrderId()).bizType(Integer.valueOf(PlatInfo.getInstance().getBizType()));
        OrderInfo orderInfo2 = this.f28855x;
        DriverOrderRouteReq.Builder sdkmaptype = bizType.orderStage(Integer.valueOf(orderInfo2 == null ? 0 : orderInfo2.getOrderStage())).countryId(PlatInfo.getInstance().getCountryCode()).productId(String.valueOf(PlatInfo.getInstance().getBizType())).imei(C10194utils.getImei(this.f28840g)).routeEngineReqPack(ByteString.m3607of(bytes)).version("5").sdkmaptype("google");
        NaviRoute naviRoute = this.f28846o;
        sdkmaptype.curRouteId(Long.valueOf((naviRoute == null || naviRoute.getRouteId() == null) ? this.f28847p : Long.valueOf(this.f28846o.getRouteId()).longValue())).didiVersion(PlatInfo.getInstance().getClientVersion());
        builder.noNeedGeo(Boolean.valueOf(!z2));
        builder.trajs(getHisTraj(this.f28845n));
        try {
            DriverOrderRouteReq build = builder.build();
            DLog.m20357d(f28828a, "getRequireData %s", build.toString());
            return build;
        } catch (Exception e) {
            DLog.m20357d(f28828a, "getRequireData Exception:" + e.toString(), new Object[0]);
            return null;
        }
    }

    public PickUpPoint getPickupPoint(LatLng latLng, int i) {
        if (latLng == null) {
            return null;
        }
        PickUpPoint pickUpPoint = new PickUpPoint();
        pickUpPoint.app_version = PlatInfo.getInstance().getClientVersion();
        Context context = this.f28840g;
        pickUpPoint.app_id = (context == null || context.getApplicationContext() == null) ? "" : this.f28840g.getApplicationContext().getPackageName();
        pickUpPoint.lang = C10194utils.getUsingLanguage(this.f28840g);
        OrderInfo orderInfo = this.f28855x;
        if (orderInfo != null) {
            pickUpPoint.order_id = orderInfo.getOrderId();
        }
        pickUpPoint.token = PlatInfo.getInstance().getDriverTicket();
        pickUpPoint.data = new PointInfo();
        pickUpPoint.data.driver_id = String.valueOf(PlatInfo.getInstance().getDriverId());
        pickUpPoint.data.lat = latLng.latitude;
        pickUpPoint.data.lng = latLng.longitude;
        pickUpPoint.data.accuracy = i;
        DLog.m20357d(f28828a, "getPickupPoint %s", pickUpPoint.toString());
        return pickUpPoint;
    }

    public static LocationSource getLocationSrc(String str) {
        if (TextUtils.isEmpty(str)) {
            return LocationSource.Unknown;
        }
        if (str.equalsIgnoreCase("gps")) {
            return LocationSource.GPS;
        }
        if (str.equalsIgnoreCase(DIDILocation.NLP_PROVIDER)) {
            return LocationSource.Network;
        }
        return LocationSource.Unknown;
    }

    public static HisTraj getHisTraj(List<GpsLocation> list) {
        int i;
        ArrayList arrayList;
        List<GpsLocation> list2 = list;
        if (list2 == null || list.isEmpty()) {
            return null;
        }
        HisTraj.Builder builder = new HisTraj.Builder();
        DiffGeoPoints.Builder builder2 = new DiffGeoPoints.Builder();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            GpsLocation gpsLocation = list2.get(i2);
            arrayList2.add(Float.valueOf((float) gpsLocation.accuracy));
            arrayList3.add(Integer.valueOf(((int) (gpsLocation.direction + 360.0f)) % 360));
            arrayList4.add(Integer.valueOf((int) gpsLocation.velocity));
            ArrayList arrayList9 = arrayList3;
            ArrayList arrayList10 = arrayList4;
            arrayList5.add(Long.valueOf(gpsLocation.time / 1000));
            arrayList6.add(getLocationSrc(gpsLocation.provider));
            if (i2 > 0) {
                GpsLocation gpsLocation2 = list2.get(i2 - 1);
                arrayList = arrayList5;
                Integer valueOf = Integer.valueOf((int) ((gpsLocation.latitude - gpsLocation2.latitude) * 100000.0d * 100.0d));
                i = size;
                Integer valueOf2 = Integer.valueOf((int) ((gpsLocation.longitude - gpsLocation2.longitude) * 100000.0d * 100.0d));
                arrayList7.add(valueOf);
                arrayList8.add(valueOf2);
            } else {
                arrayList = arrayList5;
                i = size;
            }
            i2++;
            arrayList3 = arrayList9;
            arrayList4 = arrayList10;
            arrayList5 = arrayList;
            size = i;
        }
        ArrayList arrayList11 = arrayList3;
        ArrayList arrayList12 = arrayList4;
        DoublePoint.Builder builder3 = new DoublePoint.Builder();
        GpsLocation gpsLocation3 = list2.get(0);
        double d = gpsLocation3.latitude * 100000.0d;
        double d2 = gpsLocation3.longitude * 100000.0d;
        builder3.dlat(Double.valueOf(d)).dlng(Double.valueOf(d2)).lat(Float.valueOf((float) d)).lng(Float.valueOf((float) d2)).accuracy(Double.valueOf((double) gpsLocation3.accuracy)).timestamp(Long.valueOf(gpsLocation3.time / 1000)).gpsTimestamp(Long.valueOf(gpsLocation3.time / 1000)).speed(Integer.valueOf((int) gpsLocation3.velocity)).gpsSource(getLocationSrc(gpsLocation3.provider));
        builder2.base(builder3.build()).dlats(arrayList7).dlngs(arrayList8);
        builder.hisAccuracy(arrayList2).hisDirection(arrayList11).hisSpeed(arrayList12).hisTimestamp(arrayList5).historyTraj(builder2.build()).hisLocationSource(arrayList6);
        return builder.build();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public RouteSearchOptions m20336c() {
        return new RouteSearchOptions(new LatLng(this.f28848q.latitude, this.f28848q.longitude), this.f28849r);
    }

    /* renamed from: d */
    private String m20338d() {
        String str = "is_yaw_reject=" + ApolloUtils.isServerRejectYaw() + "&yaw_version=" + ApolloUtils.getYawModelType();
        DLog.m20357d(f28828a, "isArrived: " + str, new Object[0]);
        return str;
    }

    /* renamed from: e */
    private String m20341e() {
        String d = m20338d();
        if (!TextUtils.isEmpty(this.f28838C)) {
            d = d + ParamKeys.SIGN_AND + this.f28838C;
        }
        DLog.m20357d(f28828a, "RouteEngineParam = " + d, new Object[0]);
        return d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0271 A[Catch:{ Exception -> 0x02af }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pushEdaToServer(int r19) {
        /*
            r18 = this;
            r0 = r18
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x02af }
            r1.<init>()     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "eda"
            r3 = r19
            r1.put(r2, r3)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r2 = new com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder     // Catch:{ Exception -> 0x02af }
            r2.<init>()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r3 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = r3.getDriverTicket()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r2.ticket(r3)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r4 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = r4.getDriverPhoneNumber()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.phoneNum(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r4 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            long r4 = r4.getDriverId()     // Catch:{ Exception -> 0x02af }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.driverId(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r4 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = r4.getTraverId()     // Catch:{ Exception -> 0x02af }
            r3.traverId(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r3 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            r4 = 0
            if (r3 == 0) goto L_0x00ed
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = new com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder     // Catch:{ Exception -> 0x02af }
            r3.<init>()     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            double r5 = r5.latitude     // Catch:{ Exception -> 0x02af }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.dlat(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            double r5 = r5.longitude     // Catch:{ Exception -> 0x02af }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.dlng(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            double r5 = r5.latitude     // Catch:{ Exception -> 0x02af }
            float r5 = (float) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.lat(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            double r5 = r5.longitude     // Catch:{ Exception -> 0x02af }
            float r5 = (float) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.lng(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            int r5 = r5.accuracy     // Catch:{ Exception -> 0x02af }
            double r5 = (double) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.accuracy(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            long r5 = r5.time     // Catch:{ Exception -> 0x02af }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.timestamp(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            long r5 = r5.time     // Catch:{ Exception -> 0x02af }
            long r5 = r5 / r7
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.gpsTimestamp(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            float r5 = r5.velocity     // Catch:{ Exception -> 0x02af }
            int r5 = (int) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.speed(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = r5.provider     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.LocationSource r5 = getLocationSrc(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.gpsSource(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint r3 = r3.build()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r2.startPoint(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.startPointAccuracy(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.GpsLocation r5 = r0.f28848q     // Catch:{ Exception -> 0x02af }
            float r5 = r5.direction     // Catch:{ Exception -> 0x02af }
            r6 = 1135869952(0x43b40000, float:360.0)
            float r5 = r5 + r6
            int r5 = (int) r5     // Catch:{ Exception -> 0x02af }
            int r5 = r5 % 360
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.startPointDirection(r5)     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x02af }
            r3.startPointSpeed(r5)     // Catch:{ Exception -> 0x02af }
        L_0x00ed:
            com.didi.common.map.model.LatLng r3 = r0.f28849r     // Catch:{ Exception -> 0x02af }
            if (r3 == 0) goto L_0x0117
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = new com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder     // Catch:{ Exception -> 0x02af }
            r3.<init>()     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.LatLng r5 = r0.f28849r     // Catch:{ Exception -> 0x02af }
            double r5 = r5.latitude     // Catch:{ Exception -> 0x02af }
            float r5 = (float) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.lat(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.LatLng r5 = r0.f28849r     // Catch:{ Exception -> 0x02af }
            double r5 = r5.longitude     // Catch:{ Exception -> 0x02af }
            float r5 = (float) r5     // Catch:{ Exception -> 0x02af }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r3 = r3.lng(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint r3 = r3.build()     // Catch:{ Exception -> 0x02af }
            r2.endPoint(r3)     // Catch:{ Exception -> 0x02af }
        L_0x0117:
            java.util.List<com.didi.map.sdk.sharetrack.entity.OrderPoint> r3 = r0.f28850s     // Catch:{ Exception -> 0x02af }
            if (r3 == 0) goto L_0x0189
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x02af }
            r3.<init>()     // Catch:{ Exception -> 0x02af }
            java.util.List<com.didi.map.sdk.sharetrack.entity.OrderPoint> r5 = r0.f28850s     // Catch:{ Exception -> 0x02af }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x02af }
        L_0x0126:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x02af }
            if (r6 == 0) goto L_0x0186
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.entity.OrderPoint r6 = (com.didi.map.sdk.sharetrack.entity.OrderPoint) r6     // Catch:{ Exception -> 0x02af }
            if (r6 == 0) goto L_0x0126
            com.didi.common.map.model.LatLng r7 = r6.point     // Catch:{ Exception -> 0x02af }
            if (r7 == 0) goto L_0x0126
            com.didi.map.sdk.proto.driver_gl.OdPoint r7 = new com.didi.map.sdk.proto.driver_gl.OdPoint     // Catch:{ Exception -> 0x02af }
            long r8 = r6.orderId     // Catch:{ Exception -> 0x02af }
            java.lang.Long r9 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x02af }
            int r8 = r6.orderType     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r8 = new com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder     // Catch:{ Exception -> 0x02af }
            r8.<init>()     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.LatLng r11 = r6.point     // Catch:{ Exception -> 0x02af }
            double r11 = r11.latitude     // Catch:{ Exception -> 0x02af }
            float r11 = (float) r11     // Catch:{ Exception -> 0x02af }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r8 = r8.lat(r11)     // Catch:{ Exception -> 0x02af }
            com.didi.common.map.model.LatLng r11 = r6.point     // Catch:{ Exception -> 0x02af }
            double r11 = r11.longitude     // Catch:{ Exception -> 0x02af }
            float r11 = (float) r11     // Catch:{ Exception -> 0x02af }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r8 = r8.lng(r11)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DoublePoint r11 = r8.build()     // Catch:{ Exception -> 0x02af }
            java.lang.String r12 = r6.strOrderId     // Catch:{ Exception -> 0x02af }
            int r6 = r6.pointType     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            r6 = 0
            java.lang.Float r14 = java.lang.Float.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x02af }
            r16 = 0
            java.lang.String r17 = ""
            r8 = r7
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x02af }
            r3.add(r7)     // Catch:{ Exception -> 0x02af }
            goto L_0x0126
        L_0x0186:
            r2.odPoints(r3)     // Catch:{ Exception -> 0x02af }
        L_0x0189:
            long r5 = r0.f28851t     // Catch:{ Exception -> 0x02af }
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x019a
            long r5 = r0.f28851t     // Catch:{ Exception -> 0x02af }
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            r2.odPointsTimestamp(r3)     // Catch:{ Exception -> 0x02af }
        L_0x019a:
            java.lang.String r3 = r18.m20341e()     // Catch:{ Exception -> 0x02af }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r2.eventType(r5)     // Catch:{ Exception -> 0x02af }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02af }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.timestamp(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.entity.OrderInfo r6 = r0.f28855x     // Catch:{ Exception -> 0x02af }
            if (r6 != 0) goto L_0x01bd
            java.lang.String r6 = ""
            goto L_0x01c3
        L_0x01bd:
            com.didi.map.sdk.sharetrack.entity.OrderInfo r6 = r0.f28855x     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = r6.getOrderId()     // Catch:{ Exception -> 0x02af }
        L_0x01c3:
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.orderId(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r6 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            int r6 = r6.getBizType()     // Catch:{ Exception -> 0x02af }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.bizType(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.entity.OrderInfo r6 = r0.f28855x     // Catch:{ Exception -> 0x02af }
            if (r6 != 0) goto L_0x01dd
            r6 = 0
            goto L_0x01e3
        L_0x01dd:
            com.didi.map.sdk.sharetrack.entity.OrderInfo r6 = r0.f28855x     // Catch:{ Exception -> 0x02af }
            int r6 = r6.getOrderStage()     // Catch:{ Exception -> 0x02af }
        L_0x01e3:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.orderStage(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r6 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = r6.getCountryCode()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.countryId(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r6 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            int r6 = r6.getBizType()     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.productId(r6)     // Catch:{ Exception -> 0x02af }
            android.content.Context r6 = r0.f28840g     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = com.didi.map.sdk.sharetrack.google.inner.utils.C10194utils.getImei(r6)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r5 = r5.imei(r6)     // Catch:{ Exception -> 0x02af }
            okio.ByteString r3 = okio.ByteString.m3607of((byte[]) r3)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r5.routeEngineReqPack(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = "5"
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.version(r5)     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = "google"
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.sdkmaptype(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.entity.NaviRoute r5 = r0.f28846o     // Catch:{ Exception -> 0x02af }
            if (r5 == 0) goto L_0x0241
            com.didi.map.sdk.sharetrack.entity.NaviRoute r5 = r0.f28846o     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = r5.getRouteId()     // Catch:{ Exception -> 0x02af }
            if (r5 != 0) goto L_0x0232
            goto L_0x0241
        L_0x0232:
            com.didi.map.sdk.sharetrack.entity.NaviRoute r5 = r0.f28846o     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = r5.getRouteId()     // Catch:{ Exception -> 0x02af }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            long r5 = r5.longValue()     // Catch:{ Exception -> 0x02af }
            goto L_0x0243
        L_0x0241:
            long r5 = r0.f28847p     // Catch:{ Exception -> 0x02af }
        L_0x0243:
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq$Builder r3 = r3.curRouteId(r5)     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.maprouter.global.PlatInfo r5 = com.didi.map.sdk.maprouter.global.PlatInfo.getInstance()     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = r5.getClientVersion()     // Catch:{ Exception -> 0x02af }
            r3.didiVersion(r5)     // Catch:{ Exception -> 0x02af }
            r3 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x02af }
            r2.noNeedGeo(r5)     // Catch:{ Exception -> 0x02af }
            java.util.List<com.didi.common.map.model.GpsLocation> r5 = r0.f28845n     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.proto.driver_gl.HisTraj r5 = getHisTraj(r5)     // Catch:{ Exception -> 0x02af }
            r2.trajs(r5)     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x02af }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x02af }
            if (r5 != 0) goto L_0x0280
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02af }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x02af }
            okio.ByteString r1 = okio.ByteString.m3607of((byte[]) r1)     // Catch:{ Exception -> 0x02af }
            r2.extendData(r1)     // Catch:{ Exception -> 0x02af }
        L_0x0280:
            com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq r1 = r2.build()     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.google.inner.net.SctxRouteFetcher r2 = new com.didi.map.sdk.sharetrack.google.inner.net.SctxRouteFetcher     // Catch:{ Exception -> 0x02af }
            r5 = 0
            r2.<init>(r1, r5)     // Catch:{ Exception -> 0x02af }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x02af }
            android.content.Context r5 = r0.f28840g     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = com.didi.map.sdk.sharetrack.net.DUrl.getOrderRouteUrl(r5)     // Catch:{ Exception -> 0x02af }
            r3[r4] = r5     // Catch:{ Exception -> 0x02af }
            r2.execute(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "FetcherManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02af }
            r3.<init>()     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = "push eda to server = "
            r3.append(r5)     // Catch:{ Exception -> 0x02af }
            r3.append(r1)     // Catch:{ Exception -> 0x02af }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x02af }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x02af }
            com.didi.map.sdk.sharetrack.logger.DLog.m20357d(r2, r1, r3)     // Catch:{ Exception -> 0x02af }
        L_0x02af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.sharetrack.google.inner.net.FetcherManager.pushEdaToServer(int):void");
    }
}
