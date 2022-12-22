package com.didi.map.global.component.line.pax.walkanddropoff.newversion;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.utils.LineDataConverter;
import com.didi.map.global.model.location.LocationHelper2;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didi.map.intl.commonwalkengine.IWalkEngine;
import com.didi.map.intl.commonwalkengine.WalkEngineType;
import com.didi.map.intl.commonwalkengine.WalkEngineWrapper;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.OrderWalkingRes;
import com.didi.map.sdk.proto.driver_gl.VisitorInfo;
import com.didi.map.sdk.proto.driver_gl.WalkScene;
import com.didi.map.sdk.proto.driver_gl.WalkState;
import com.didi.map.sdk.proto.driver_gl.enumOSType;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.routesearchsdk.CallFrom;
import com.didichuxing.routesearchsdk.RouteSearchApiFactory;
import com.didichuxing.routesearchsdk.walk.IWalkNavRouteSearchApi;
import com.didichuxing.routesearchsdk.walk.WalkNavRouteSearchCallback;
import com.didichuxing.routesearchsdk.walk.WalkNavRouteSearchParam;
import com.map.global.nav.libc.common.DMKEventPoint;
import com.map.global.nav.libc.common.GeoPoint;
import com.map.global.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NewWalkLineComponent {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f25927a = "NewWalkLineComponent";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ICompLineContract f25928b;

    /* renamed from: c */
    private Map f25929c;

    /* renamed from: d */
    private Context f25930d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IWalkEngine f25931e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f25932f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f25933g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public NewWalkParam f25934h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f25935i;

    /* renamed from: j */
    private DIDILocationListener f25936j;

    /* renamed from: k */
    private PsgLocationMarker f25937k;

    /* renamed from: l */
    private IWalkNavRouteSearchApi f25938l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public IWalkNavRouteSearchApi f25939m;

    /* renamed from: n */
    private Handler f25940n = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: o */
    public LatLng f25941o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public List<LatLng> f25942p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f25943q = -1;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f25944r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f25945s = false;

    public void create(Context context, Map map, NewWalkParam newWalkParam) {
        this.f25929c = map;
        this.f25930d = context;
        this.f25934h = newWalkParam;
        m18421a(false);
        this.f25937k = new PsgLocationMarker(this.f25930d, this.f25929c);
        C95341 r3 = new DIDILocationListener() {
            public void onLocationError(int i, ErrInfo errInfo) {
            }

            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                if (dIDILocation != null) {
                    LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                    if (!LatLngUtils.locateCorrect(latLng)) {
                        return;
                    }
                    if (NewWalkLineComponent.this.f25944r) {
                        if (NewWalkLineComponent.this.f25945s) {
                            String c = NewWalkLineComponent.this.f25927a;
                            DLog.m7384d(c, "------>定位绑路点" + latLng.longitude + "," + latLng.latitude, new Object[0]);
                        }
                        if (NewWalkLineComponent.this.f25931e != null) {
                            NewWalkLineComponent.this.f25931e.getMatchPoint(NewWalkLineComponent.this.m18412a(dIDILocation));
                        }
                    } else if (NewWalkLineComponent.this.f25928b != null && NewWalkLineComponent.this.f25934h != null) {
                        List allLinePoints = NewWalkLineComponent.this.f25928b.getAllLinePoints();
                        if (allLinePoints == null) {
                            allLinePoints = new ArrayList();
                        } else {
                            allLinePoints.clear();
                        }
                        allLinePoints.add(latLng);
                        allLinePoints.add(NewWalkLineComponent.this.f25934h.getEndPoint());
                        NewWalkLineComponent.this.m18426b((List<LatLng>) allLinePoints);
                        NewWalkLineComponent.this.m18414a(latLng);
                    }
                }
            }
        };
        this.f25936j = r3;
        LocationHelper2.registerListener(this.f25930d, r3, new LocationRegisterParam(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, LocationRegisterParam.LocType.FLP));
        m18413a();
    }

    public void updateStartPoint(LatLng latLng) {
        NewWalkParam newWalkParam;
        if (!LatLngUtils.locateCorrect(latLng) || (newWalkParam = this.f25934h) == null) {
            return;
        }
        if (!LatLngUtils.isSameLatLng(latLng, newWalkParam.getEndPoint())) {
            DLog.m7384d(this.f25927a, "updateStartPoint-> 终点更新", new Object[0]);
            this.f25934h.setEndPoint(latLng);
            m18421a(false);
            return;
        }
        DLog.m7384d(this.f25927a, "updateStartPoint-> 终点相同", new Object[0]);
    }

    public void destroy() {
        DLog.m7384d(this.f25927a, "destroy", new Object[0]);
        this.f25933g = true;
        ICompLineContract iCompLineContract = this.f25928b;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f25928b = null;
        }
        PsgLocationMarker psgLocationMarker = this.f25937k;
        if (psgLocationMarker != null) {
            psgLocationMarker.destroy();
            this.f25937k = null;
        }
        DIDILocationListener dIDILocationListener = this.f25936j;
        if (dIDILocationListener != null) {
            LocationHelper2.unRegisterListener(this.f25930d, dIDILocationListener);
            this.f25936j = null;
        }
        IWalkNavRouteSearchApi iWalkNavRouteSearchApi = this.f25938l;
        if (iWalkNavRouteSearchApi != null) {
            iWalkNavRouteSearchApi.cancelRequest();
            this.f25938l = null;
        }
        IWalkNavRouteSearchApi iWalkNavRouteSearchApi2 = this.f25939m;
        if (iWalkNavRouteSearchApi2 != null) {
            iWalkNavRouteSearchApi2.cancelRequest();
            this.f25939m = null;
        }
        Handler handler = this.f25940n;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f25940n = null;
        }
    }

    public List<IMapElement> getBestViewElements() {
        ArrayList arrayList = new ArrayList();
        ICompLineContract iCompLineContract = this.f25928b;
        if (iCompLineContract != null && !CollectionUtil.isEmpty((Collection<?>) iCompLineContract.getBestViewElements())) {
            arrayList.addAll(this.f25928b.getBestViewElements());
        }
        PsgLocationMarker psgLocationMarker = this.f25937k;
        if (psgLocationMarker != null && !CollectionUtil.isEmpty((Collection<?>) psgLocationMarker.getBestViewElements())) {
            arrayList.addAll(this.f25937k.getBestViewElements());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18420a(List<LatLng> list) {
        IWalkEngine iWalkEngine = this.f25931e;
        if (iWalkEngine != null) {
            iWalkEngine.destroy();
            this.f25931e = null;
        }
        this.f25931e = new WalkEngineWrapper(WalkEngineType.NAV_BASE);
        this.f25931e.setWalkEngineEventCallback(new IWalkEngine.IWalkEngineEventCallback() {
            public void onMatched(LatLng latLng, int i, int i2, int i3, int i4, DMKEventPoint dMKEventPoint) {
                if (LatLngUtils.locateCorrect(latLng)) {
                    if (NewWalkLineComponent.this.f25932f) {
                        LatLng unused = NewWalkLineComponent.this.f25941o = latLng;
                        NewWalkLineComponent.this.m18414a(latLng);
                    } else if (i >= 0) {
                        if (NewWalkLineComponent.this.f25945s) {
                            DLog.m7384d(NewWalkLineComponent.this.f25927a, "matchResult-> ->success", new Object[0]);
                            String c = NewWalkLineComponent.this.f25927a;
                            DLog.m7384d(c, "------>绑路点" + latLng.longitude + "," + latLng.latitude, new Object[0]);
                        }
                        LatLng unused2 = NewWalkLineComponent.this.f25941o = latLng;
                        NewWalkLineComponent.this.m18414a(latLng);
                        NewWalkLineComponent.this.m18415a(latLng, i);
                    } else if (NewWalkLineComponent.this.f25945s) {
                        DLog.m7384d(NewWalkLineComponent.this.f25927a, "matchResult-> ->fails", new Object[0]);
                    }
                }
            }

            public void onOffRoute() {
                if (!NewWalkLineComponent.this.f25932f) {
                    DLog.m7384d(NewWalkLineComponent.this.f25927a, "matchResult->->onOffRoute", new Object[0]);
                    NewWalkLineComponent.this.m18421a(true);
                    boolean unused = NewWalkLineComponent.this.f25932f = true;
                }
            }
        });
        this.f25931e.setRoutePoints(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18421a(final boolean z) {
        final LatLng latLng;
        NewWalkParam newWalkParam = this.f25934h;
        if (newWalkParam != null && LatLngUtils.locateCorrect(newWalkParam.getEndPoint())) {
            DIDILocation lastKnownLocation = LocationHelper2.getLastKnownLocation(this.f25930d, LocationRegisterParam.LocType.FLP);
            if (lastKnownLocation != null) {
                latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                if (!LatLngUtils.locateCorrect(latLng)) {
                    return;
                }
            } else {
                latLng = null;
            }
            WalkNavRouteSearchParam.Builder c = m18429c();
            if (c != null) {
                WalkNavRouteSearchParam build = c.psgPoint(LineDataConverter.latConvertToDoublePoint(latLng)).startPoint(LineDataConverter.latConvertToDoublePoint(latLng)).endPoint(LineDataConverter.latConvertToDoublePoint(this.f25934h.getEndPoint())).curRouteId(z ? this.f25935i : 0).eventType(z ? 1 : 0).build();
                IWalkNavRouteSearchApi iWalkNavRouteSearchApi = this.f25938l;
                if (iWalkNavRouteSearchApi != null) {
                    iWalkNavRouteSearchApi.cancelRequest();
                    this.f25938l = null;
                }
                IWalkNavRouteSearchApi createWalkNavSearch = RouteSearchApiFactory.createWalkNavSearch(this.f25930d);
                this.f25938l = createWalkNavSearch;
                if (createWalkNavSearch != null) {
                    final LatLng endPoint = this.f25934h.getEndPoint();
                    this.f25938l.calculateRoute(build, new WalkNavRouteSearchCallback() {
                        public void onBeginToSearch() {
                        }

                        public void onFinishToSearch(OrderWalkingRes orderWalkingRes, String str) {
                            if (!NewWalkLineComponent.this.f25933g) {
                                int unused = NewWalkLineComponent.this.f25943q = -1;
                                if (orderWalkingRes == null || orderWalkingRes.ret == null) {
                                    DLog.m7384d(NewWalkLineComponent.this.f25927a, "getWalkLineData->lineDataResponse==null", new Object[0]);
                                } else {
                                    int intValue = orderWalkingRes.ret.intValue();
                                    if (intValue == -2) {
                                        boolean unused2 = NewWalkLineComponent.this.f25944r = false;
                                        DLog.m7384d(NewWalkLineComponent.this.f25927a, "getWalkLineData  ret=-2", new Object[0]);
                                        if (NewWalkLineComponent.this.f25942p != null) {
                                            NewWalkLineComponent.this.f25942p.clear();
                                        } else {
                                            List unused3 = NewWalkLineComponent.this.f25942p = new ArrayList();
                                        }
                                        NewWalkLineComponent.this.f25942p.add(latLng);
                                        NewWalkLineComponent.this.f25942p.add(endPoint);
                                        NewWalkLineComponent newWalkLineComponent = NewWalkLineComponent.this;
                                        newWalkLineComponent.m18426b((List<LatLng>) newWalkLineComponent.f25942p);
                                    } else if (intValue != 0) {
                                        String c = NewWalkLineComponent.this.f25927a;
                                        DLog.m7384d(c, "getWalkLineData  ret=" + orderWalkingRes.ret, new Object[0]);
                                    } else {
                                        boolean unused4 = NewWalkLineComponent.this.f25944r = true;
                                        if (NewWalkLineComponent.this.f25935i != orderWalkingRes.routeId.longValue() || !z) {
                                            long unused5 = NewWalkLineComponent.this.f25935i = orderWalkingRes.routeId == null ? 0 : orderWalkingRes.routeId.longValue();
                                            String c2 = NewWalkLineComponent.this.f25927a;
                                            DLog.m7384d(c2, "logid" + orderWalkingRes.logid + "", new Object[0]);
                                            List<LatLng> latLngListFromDiffGeoPoints = LineDataConverter.getLatLngListFromDiffGeoPoints(orderWalkingRes.geos);
                                            if (CollectionUtil.isEmpty((Collection<?>) latLngListFromDiffGeoPoints)) {
                                                DLog.m7384d(NewWalkLineComponent.this.f25927a, "getWalkLineData ->allLinePoints  is null", new Object[0]);
                                                return;
                                            }
                                            if (NewWalkLineComponent.this.f25942p != null) {
                                                NewWalkLineComponent.this.f25942p.clear();
                                            } else {
                                                List unused6 = NewWalkLineComponent.this.f25942p = new ArrayList();
                                            }
                                            NewWalkLineComponent.this.f25942p.addAll(latLngListFromDiffGeoPoints);
                                            NewWalkLineComponent newWalkLineComponent2 = NewWalkLineComponent.this;
                                            newWalkLineComponent2.m18426b((List<LatLng>) newWalkLineComponent2.f25942p);
                                            NewWalkLineComponent newWalkLineComponent3 = NewWalkLineComponent.this;
                                            newWalkLineComponent3.m18420a((List<LatLng>) newWalkLineComponent3.f25942p);
                                        } else {
                                            DLog.m7384d(NewWalkLineComponent.this.f25927a, "偏航后 routeId 相同，无需更新路线", new Object[0]);
                                            return;
                                        }
                                    }
                                }
                                boolean unused7 = NewWalkLineComponent.this.f25932f = false;
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    private void m18413a() {
        NewWalkParam newWalkParam = this.f25934h;
        if (newWalkParam != null) {
            long pushInterval = newWalkParam.getPushInterval();
            if (pushInterval > 0) {
                if (this.f25940n == null) {
                    this.f25940n = new Handler();
                }
                this.f25940n.postDelayed(new Runnable() {
                    public final void run() {
                        NewWalkLineComponent.this.m18436e();
                    }
                }, pushInterval);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m18436e() {
        m18425b();
        m18413a();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18426b(List<LatLng> list) {
        if (this.f25929c != null && this.f25930d != null) {
            ICompLineContract iCompLineContract = this.f25928b;
            if (iCompLineContract != null) {
                iCompLineContract.updateLinePoints(list);
                return;
            }
            LineParams lineParams = new LineParams(list, Color.parseColor("#33BBFF"), 5);
            lineParams.setDotSpace(20.0f);
            lineParams.setZIndex(10);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT, this.f25929c, this.f25930d, lineParams);
            this.f25928b = createLineComponent;
            if (createLineComponent != null) {
                createLineComponent.start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18414a(LatLng latLng) {
        PsgLocationMarker psgLocationMarker = this.f25937k;
        if (psgLocationMarker != null) {
            psgLocationMarker.updatePosition(latLng);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18415a(LatLng latLng, int i) {
        if (this.f25928b != null && !CollectionUtil.isEmpty((Collection<?>) this.f25942p)) {
            List<LatLng> arrayList = new ArrayList<>();
            if (this.f25943q != i) {
                if (this.f25945s) {
                    DLog.m7384d(this.f25927a, "eraseLine->重新刷新路线数据segmentIndex 不同", new Object[0]);
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f25942p);
                if (i < arrayList2.size()) {
                    arrayList = arrayList2.subList(i + 1, arrayList2.size());
                } else {
                    return;
                }
            } else if (this.f25928b != null) {
                if (this.f25945s) {
                    DLog.m7384d(this.f25927a, "eraseLine->重新刷新路线数据segmentIndex 相同", new Object[0]);
                }
                List<LatLng> allLinePoints = this.f25928b.getAllLinePoints();
                if (!CollectionUtil.isEmpty((Collection<?>) allLinePoints)) {
                    arrayList = allLinePoints.subList(1, allLinePoints.size());
                }
            }
            if (!CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                arrayList.add(0, latLng);
                m18426b(arrayList);
                this.f25943q = i;
            }
        }
    }

    /* renamed from: b */
    private void m18425b() {
        WalkNavRouteSearchParam.Builder c;
        if (LatLngUtils.locateCorrect(this.f25941o) && this.f25930d != null && (c = m18429c()) != null) {
            WalkNavRouteSearchParam build = c.psgPoint(LineDataConverter.latConvertToDoublePoint(this.f25941o)).eventType(11).curRouteId(0).state(WalkState.STATE_WALKING).build();
            IWalkNavRouteSearchApi iWalkNavRouteSearchApi = this.f25939m;
            if (iWalkNavRouteSearchApi != null) {
                iWalkNavRouteSearchApi.cancelRequest();
                this.f25939m = null;
            }
            IWalkNavRouteSearchApi createWalkNavSearch = RouteSearchApiFactory.createWalkNavSearch(this.f25930d);
            this.f25939m = createWalkNavSearch;
            createWalkNavSearch.calculateRoute(build, new WalkNavRouteSearchCallback() {
                public void onBeginToSearch() {
                }

                public void onFinishToSearch(OrderWalkingRes orderWalkingRes, String str) {
                    if (!NewWalkLineComponent.this.f25933g && NewWalkLineComponent.this.f25939m != null && orderWalkingRes != null && orderWalkingRes.ret != null && orderWalkingRes.ret.intValue() == 0 && NewWalkLineComponent.this.f25945s) {
                        String c = NewWalkLineComponent.this.f25927a;
                        DLog.m7384d(c, "ora push success" + orderWalkingRes.logid, new Object[0]);
                    }
                }
            });
        }
    }

    /* renamed from: c */
    private WalkNavRouteSearchParam.Builder m18429c() {
        try {
            if (this.f25934h != null) {
                if (this.f25929c != null) {
                    String str = "";
                    if (this.f25929c.getMapVendor() != null) {
                        int i = C95385.$SwitchMap$com$didi$common$map$MapVendor[this.f25929c.getMapVendor().ordinal()];
                        if (i == 1 || i == 2) {
                            str = "didi";
                        } else if (i == 3) {
                            str = "google";
                        } else if (i == 4) {
                            str = Payload.SOURCE_HUAWEI;
                        }
                    }
                    WalkNavRouteSearchParam.Builder builder = new WalkNavRouteSearchParam.Builder();
                    builder.scene(WalkScene.START).orderId(this.f25934h.getOrderId()).visitorInfo(m18434d()).bizType(TextUtils.isEmpty(this.f25934h.getProductId()) ? -1 : Integer.valueOf(this.f25934h.getProductId()).intValue()).role(2).type(0).sdkMapType(str).passengerId(TextUtils.isEmpty(PaxEnvironment.getInstance().getUid()) ? -1 : Long.valueOf(PaxEnvironment.getInstance().getUid()).longValue()).didiVersion(PaxEnvironment.getInstance().getAppVersion()).caller(CallFrom.ORDERROUTEAPI_WALK).driverId(this.f25934h.getDriverId()).build();
                    return builder;
                }
            }
            return null;
        } catch (Exception e) {
            String str2 = this.f25927a;
            DLog.m7384d(str2, "基础参数拼接发生异常" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    /* renamed from: com.didi.map.global.component.line.pax.walkanddropoff.newversion.NewWalkLineComponent$5 */
    static /* synthetic */ class C95385 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.common.map.MapVendor[] r0 = com.didi.common.map.MapVendor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$MapVendor = r0
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.DIDI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.G_DIDI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.HUAWEI     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.line.pax.walkanddropoff.newversion.NewWalkLineComponent.C95385.<clinit>():void");
        }
    }

    /* renamed from: d */
    private VisitorInfo m18434d() {
        return new VisitorInfo.Builder().token(PaxEnvironment.getInstance().getToken()).timeStampSec(Long.valueOf(System.currentTimeMillis() / 1000)).phoneNum(PaxEnvironment.getInstance().getPhoneNumber()).didiVersion(PaxEnvironment.getInstance().getAppVersion()).mo78915OS(enumOSType.Android).imei(SystemUtil.getIMEI()).build();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RouteGuidanceGPSPoint m18412a(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return null;
        }
        try {
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
            routeGuidanceGPSPoint.accuracy = (int) dIDILocation.getAccuracy();
            routeGuidanceGPSPoint.matchedStatus = 1;
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (dIDILocation.getLatitude() * 1000000.0d));
            geoPoint.setLongitudeE6((int) (dIDILocation.getLongitude() * 1000000.0d));
            routeGuidanceGPSPoint.point = geoPoint;
            routeGuidanceGPSPoint.segmentIndex = -1;
            routeGuidanceGPSPoint.shapeOffSet = 0;
            routeGuidanceGPSPoint.timestamp = dIDILocation.getTime() / 1000;
            routeGuidanceGPSPoint.velocity = dIDILocation.getSpeed();
            routeGuidanceGPSPoint.heading = dIDILocation.getBearing();
            routeGuidanceGPSPoint.source = dIDILocation.getCoordinateType();
            return routeGuidanceGPSPoint;
        } catch (Exception unused) {
            DLog.m7384d("convertFromDiDiLocation2", "error", new Object[0]);
            return null;
        }
    }
}
