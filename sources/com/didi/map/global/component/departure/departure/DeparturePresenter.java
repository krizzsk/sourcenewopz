package com.didi.map.global.component.departure.departure;

import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.Projection;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.apolllo.ApolloParamsDeparture;
import com.didi.map.global.component.departure.apolllo.MapGlobalApolloUtils;
import com.didi.map.global.component.departure.apolllo.WalkDropApollo;
import com.didi.map.global.component.departure.data.DepartureHttpTask;
import com.didi.map.global.component.departure.data.DepartureHttpTaskParam;
import com.didi.map.global.component.departure.data.IDepartureHttpTask;
import com.didi.map.global.component.departure.data.OnDepartureHttpTaskListener;
import com.didi.map.global.component.departure.model.AddressExtendInfo;
import com.didi.map.global.component.departure.model.AddressWalkGuide;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.util.DepartureUtils;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.model.location.LocationHelper2;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.WindowUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DeparturePresenter {

    /* renamed from: a */
    private Map f25062a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f25063b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DepartureCompParams f25064c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IResponseCallback f25065d;

    /* renamed from: e */
    private IDepartureHttpTask f25066e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ReverseStationsInfo f25067f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DepartureLocationInfo f25068g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AtomicInteger f25069h = new AtomicInteger(-1);

    /* renamed from: i */
    private ApolloParamsDeparture f25070i;

    /* renamed from: j */
    private int f25071j;

    /* renamed from: k */
    private DIDILocationListener f25072k = new DIDILocationListener() {
        public void onLocationError(int i, ErrInfo errInfo) {
        }

        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (DeparturePresenter.this.f25065d != null) {
                DeparturePresenter.this.f25065d.onLocationChange(dIDILocation);
            }
        }
    };

    /* renamed from: l */
    private OnDepartureHttpTaskListener f25073l = new OnDepartureHttpTaskListener() {
        public void onPrepare(LatLng latLng, int i) {
            if (DeparturePresenter.this.f25069h.get() == i && DeparturePresenter.this.f25065d != null) {
                DeparturePresenter.this.f25065d.onLoading(latLng);
            }
        }

        public void onSuccess(ReverseStationsInfo reverseStationsInfo, int i) {
            DeparturePresenter.this.m17913a("request onSuccess");
            if (DeparturePresenter.this.f25065d != null && DeparturePresenter.this.f25069h.get() == i) {
                if (reverseStationsInfo != null) {
                    ReverseStationsInfo unused = DeparturePresenter.this.f25067f = reverseStationsInfo;
                }
                DeparturePresenter.this.f25065d.onHandleResult(reverseStationsInfo);
            }
        }

        public void onFail(int i, int i2) {
            DeparturePresenter departurePresenter = DeparturePresenter.this;
            departurePresenter.m17913a("request onFail, errNo: " + i);
            if (DeparturePresenter.this.f25069h.get() == i2 && DeparturePresenter.this.f25065d != null) {
                if (DeparturePresenter.this.f25064c.getReqCallerId() == CallFrom.SUG_PACKING_PROMPT || DeparturePresenter.this.f25064c.getReqCallerId() == CallFrom.CANOE_DEPARTURE_FROMHOME) {
                    DeparturePresenter.this.f25065d.onHandleResult((ReverseStationsInfo) null);
                } else if (DeparturePresenter.this.f25068g != null && LatLngUtils.locateCorrect(DeparturePresenter.this.f25068g.latLng)) {
                    ReverseStationsInfo reverseStationsInfo = new ReverseStationsInfo();
                    ArrayList<RpcPoi> arrayList = new ArrayList<>();
                    RpcPoi rpcPoi = new RpcPoi();
                    RpcPoiBaseInfo rpcPoiBaseInfo = new RpcPoiBaseInfo();
                    rpcPoiBaseInfo.lat = DeparturePresenter.this.f25068g.latLng.latitude;
                    rpcPoiBaseInfo.lng = DeparturePresenter.this.f25068g.latLng.longitude;
                    rpcPoiBaseInfo.displayname = DeparturePresenter.this.f25063b.getResources().getString(R.string.mfv_pin_location);
                    rpcPoi.base_info = rpcPoiBaseInfo;
                    arrayList.add(rpcPoi);
                    reverseStationsInfo.result = arrayList;
                    ReverseStationsInfo unused = DeparturePresenter.this.f25067f = reverseStationsInfo;
                    DeparturePresenter.this.f25065d.onHandleResult(reverseStationsInfo);
                }
            }
        }
    };

    public interface IResponseCallback {
        void onHandleResult(ReverseStationsInfo reverseStationsInfo);

        void onLoading(LatLng latLng);

        void onLocationChange(DIDILocation dIDILocation);
    }

    /* renamed from: a */
    private int m17906a(boolean z) {
        return z ? 1 : 0;
    }

    public DeparturePresenter(Map map, Context context, DepartureCompParams departureCompParams) {
        LocationRegisterParam locationRegisterParam;
        getApolloParams();
        this.f25062a = map;
        this.f25063b = context;
        this.f25064c = departureCompParams;
        if (departureCompParams.getNlpRegisterParam() != null) {
            String str = departureCompParams.getNlpRegisterParam().getmCallFrom();
            if (TextUtils.isEmpty(str) || !str.equals(CallFrom.PICKUP_PAGE.toString())) {
                locationRegisterParam = new LocationRegisterParam(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, LocationRegisterParam.LocType.FLP);
            } else {
                locationRegisterParam = new LocationRegisterParam(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, LocationRegisterParam.LocType.NLP);
                locationRegisterParam.setNlpRegisterParam(departureCompParams.getNlpRegisterParam());
            }
        } else {
            locationRegisterParam = new LocationRegisterParam(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, LocationRegisterParam.LocType.FLP);
        }
        LocationHelper2.registerListener(context, this.f25072k, locationRegisterParam);
    }

    public void setResponseCallback(IResponseCallback iResponseCallback) {
        this.f25065d = iResponseCallback;
    }

    public void destroy() {
        stopRequest();
        LocationHelper2.unRegisterListener(this.f25063b, this.f25072k);
        LocationHelper.unRegisterListener(this.f25063b, this.f25072k);
    }

    public boolean startRequest(DepartureLocationInfo departureLocationInfo, int i, boolean z) {
        boolean z2;
        m17913a("startRequest ,location=" + departureLocationInfo);
        this.f25071j = i;
        int i2 = 0;
        if (this.f25064c == null || departureLocationInfo == null) {
            return false;
        }
        stopRequest();
        this.f25068g = departureLocationInfo;
        DepartureHttpTask departureHttpTask = new DepartureHttpTask();
        this.f25066e = departureHttpTask;
        departureHttpTask.create(this.f25063b, this.f25062a);
        NLPRegisterParam nlpRegisterParam = this.f25064c.getNlpRegisterParam();
        if (nlpRegisterParam != null) {
            i2 = nlpRegisterParam.getmConnectTimeOut();
            z2 = true;
        } else {
            z2 = false;
        }
        DepartureHttpTaskParam.Builder builder = new DepartureHttpTaskParam.Builder();
        builder.departureTime(this.f25064c.getDepartureTime()).reqCallerId(this.f25064c.getReqCallerId()).isNeedFence(this.f25064c.isFenceVisible()).locationInfo(departureLocationInfo).operationType(i).apiType(this.f25064c.getApiType()).listener(this.f25073l).cacheEnable(this.f25064c.isCacheEnable()).isAutoCall(m17906a(z)).setTimeOut(i2).setIsNeedNLP(z2).taskID(this.f25069h.incrementAndGet()).destInfo(this.f25064c.getEndPoint());
        this.f25066e.setConfigParam(builder.build());
        this.f25066e.start();
        return true;
    }

    public void stopRequest() {
        IDepartureHttpTask iDepartureHttpTask = this.f25066e;
        if (iDepartureHttpTask != null) {
            iDepartureHttpTask.stop();
            this.f25066e.destroy();
            this.f25066e = null;
            this.f25069h.getAndIncrement();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f6, code lost:
        if (r10 != false) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0105, code lost:
        if (r10 != false) goto L_0x0109;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.map.global.component.departure.model.DepartureAddress getDepartureAddress(com.sdk.poibase.model.RpcPoi r7, com.sdk.poibase.model.RpcPoi r8, com.didi.common.map.model.LatLng r9, boolean r10) {
        /*
            r6 = this;
            com.sdk.poibase.model.poi.ReverseStationsInfo r0 = r6.f25067f
            if (r0 != 0) goto L_0x002c
            if (r8 == 0) goto L_0x002a
            com.sdk.poibase.model.RpcPoiBaseInfo r7 = r8.base_info
            if (r7 == 0) goto L_0x002a
            com.didi.map.global.component.departure.model.DepartureAddress r7 = new com.didi.map.global.component.departure.model.DepartureAddress
            r7.<init>()
            com.didi.sdk.address.address.entity.Address r9 = new com.didi.sdk.address.address.entity.Address
            r9.<init>()
            com.sdk.poibase.model.RpcPoiBaseInfo r10 = r8.base_info
            double r0 = r10.lat
            r9.latitude = r0
            com.sdk.poibase.model.RpcPoiBaseInfo r10 = r8.base_info
            double r0 = r10.lng
            r9.longitude = r0
            com.sdk.poibase.model.RpcPoiBaseInfo r8 = r8.base_info
            java.lang.String r8 = r8.displayname
            r9.displayName = r8
            r7.setAddress(r9)
            return r7
        L_0x002a:
            r7 = 0
            return r7
        L_0x002c:
            r8 = 1
            r0 = 0
            if (r7 == 0) goto L_0x0044
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r7.base_info
            if (r1 == 0) goto L_0x0044
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r7.base_info
            double r1 = r1.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r7.base_info
            double r3 = r3.lng
            boolean r1 = com.didi.common.map.util.LatLngUtils.locateCorrect(r1, r3)
            if (r1 == 0) goto L_0x0044
            r9 = 1
            goto L_0x0081
        L_0x0044:
            com.sdk.poibase.model.poi.ReverseStationsInfo r7 = r6.f25067f
            com.sdk.poibase.model.RpcPoi r7 = r7.getDepartureAddress()
            if (r7 == 0) goto L_0x0080
            if (r9 == 0) goto L_0x0080
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r7.base_info
            if (r1 != 0) goto L_0x0066
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = new com.sdk.poibase.model.RpcPoiBaseInfo
            r1.<init>()
            r7.base_info = r1
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r7.base_info
            double r2 = r9.latitude
            r1.lat = r2
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r7.base_info
            double r2 = r9.longitude
            r1.lng = r2
            goto L_0x0080
        L_0x0066:
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r7.base_info
            double r1 = r1.lat
            com.sdk.poibase.model.RpcPoiBaseInfo r3 = r7.base_info
            double r3 = r3.lng
            boolean r1 = com.didi.common.map.util.LatLngUtils.locateCorrect(r1, r3)
            if (r1 != 0) goto L_0x0080
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r7.base_info
            double r2 = r9.latitude
            r1.lat = r2
            com.sdk.poibase.model.RpcPoiBaseInfo r1 = r7.base_info
            double r2 = r9.longitude
            r1.lng = r2
        L_0x0080:
            r9 = 0
        L_0x0081:
            if (r7 == 0) goto L_0x0093
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r6.f25067f
            java.lang.String r1 = r1.specialPoiList
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0093
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r6.f25067f
            java.lang.String r1 = r1.specialPoiList
            r7.specialPoiList = r1
        L_0x0093:
            com.sdk.poibase.model.poi.ReverseStationsInfo r1 = r6.f25067f
            com.sdk.poibase.model.poi.GeoFence r1 = r1.geoFence
            if (r7 == 0) goto L_0x009f
            if (r1 == 0) goto L_0x009f
            java.lang.String[] r1 = r1.f56003id
            r7.geofence = r1
        L_0x009f:
            com.didi.map.global.component.departure.model.DepartureAddress r1 = new com.didi.map.global.component.departure.model.DepartureAddress
            r1.<init>()
            com.sdk.poibase.model.poi.ReverseStationsInfo r2 = r6.f25067f
            r6.m17912a((com.sdk.poibase.model.poi.ReverseStationsInfo) r2, (com.didi.map.global.component.departure.model.DepartureAddress) r1, (com.sdk.poibase.model.RpcPoi) r7, (boolean) r9)
            com.sdk.poibase.model.poi.ReverseStationsInfo r2 = r6.f25067f
            java.util.ArrayList<java.lang.String> r2 = r2.geofenceTags
            if (r2 == 0) goto L_0x00d5
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.sdk.poibase.model.poi.ReverseStationsInfo r3 = r6.f25067f
            java.util.ArrayList<java.lang.String> r3 = r3.geofenceTags
            boolean r4 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r3)
            if (r4 != 0) goto L_0x00d2
            java.util.Iterator r3 = r3.iterator()
        L_0x00c2:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00d2
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.add(r4)
            goto L_0x00c2
        L_0x00d2:
            r1.setSpecialLocations(r2)
        L_0x00d5:
            r2 = 2
            boolean r3 = r6.m17914a()
            if (r3 == 0) goto L_0x011c
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch:{ Exception -> 0x00fb }
            r3.<init>()     // Catch:{ Exception -> 0x00fb }
            com.sdk.poibase.model.poi.ReverseStationsInfo r4 = r6.f25067f     // Catch:{ Exception -> 0x00fb }
            java.lang.String r4 = r4.specialPoiList     // Catch:{ Exception -> 0x00fb }
            java.lang.Class<com.sdk.poibase.model.poi.FenceInfo> r5 = com.sdk.poibase.model.poi.FenceInfo.class
            java.lang.Object r3 = r3.fromJson((java.lang.String) r4, r5)     // Catch:{ Exception -> 0x00fb }
            com.sdk.poibase.model.poi.FenceInfo r3 = (com.sdk.poibase.model.poi.FenceInfo) r3     // Catch:{ Exception -> 0x00fb }
            r1.setFenceInfo(r3)     // Catch:{ Exception -> 0x00fb }
            com.sdk.poibase.model.poi.FenceInfo r3 = r1.getFenceInfo()
            if (r3 == 0) goto L_0x0108
            if (r10 == 0) goto L_0x0108
            goto L_0x0109
        L_0x00f9:
            r7 = move-exception
            goto L_0x010e
        L_0x00fb:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x00f9 }
            com.sdk.poibase.model.poi.FenceInfo r3 = r1.getFenceInfo()
            if (r3 == 0) goto L_0x0108
            if (r10 == 0) goto L_0x0108
            goto L_0x0109
        L_0x0108:
            r8 = 2
        L_0x0109:
            r1.setZoneType(r8)
            r2 = r8
            goto L_0x012b
        L_0x010e:
            com.sdk.poibase.model.poi.FenceInfo r9 = r1.getFenceInfo()
            if (r9 == 0) goto L_0x0117
            if (r10 == 0) goto L_0x0117
            goto L_0x0118
        L_0x0117:
            r8 = 2
        L_0x0118:
            r1.setZoneType(r8)
            throw r7
        L_0x011c:
            com.sdk.poibase.model.poi.ReverseStationsInfo r8 = r6.f25067f
            com.sdk.poibase.model.poi.FenceInfo r8 = com.didi.map.global.component.departure.util.DepartureUtils.getFenceInfo(r8)
            if (r8 == 0) goto L_0x012b
            r1.setFenceInfo(r8)
            r1.setZoneType(r0)
            r2 = 0
        L_0x012b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "getDepartureAddress zoneType="
            r8.append(r10)
            int r10 = r1.getZoneType()
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r6.m17913a((java.lang.String) r8)
            com.sdk.poibase.model.poi.ReverseStationsInfo r8 = r6.f25067f
            com.sdk.poibase.model.poi.SpecialPoiGuidance r8 = r8.specialPoiGuidance
            r1.setSpecialPoiGuidance(r8)
            com.sdk.poibase.model.poi.ReverseStationsInfo r8 = r6.f25067f
            java.util.ArrayList<com.sdk.poibase.model.RpcPoi> r8 = r8.recDestination
            com.sdk.poibase.model.poi.ReverseStationsInfo r10 = r6.f25067f
            java.lang.String r10 = r10.language
            r6.m17909a(r1, r8, r10)
            r6.m17911a((com.didi.map.global.component.departure.model.DepartureAddress) r1, (com.sdk.poibase.model.RpcPoi) r7, (int) r2, (boolean) r9)
            if (r7 == 0) goto L_0x0170
            com.sdk.poibase.model.RpcPoiBaseInfo r8 = r7.base_info
            if (r8 == 0) goto L_0x0170
            com.sdk.poibase.model.RpcPoiBaseInfo r8 = r7.base_info
            java.lang.String r8 = r8.displayname
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0170
            com.sdk.poibase.model.RpcPoiBaseInfo r7 = r7.base_info
            java.lang.String r7 = r7.displayname
            r1.setDepartureDisplayName(r7)
            goto L_0x0175
        L_0x0170:
            java.lang.String r7 = ""
            r1.setDepartureDisplayName(r7)
        L_0x0175:
            com.sdk.poibase.model.poi.ReverseStationsInfo r7 = r6.f25067f
            com.didi.map.global.component.departure.model.SpecialPois r7 = com.didi.map.global.component.departure.util.TerminalUtils.getSpecialPois(r7)
            r1.setSpecialPois(r7)
            com.sdk.poibase.model.poi.ReverseStationsInfo r7 = r6.f25067f
            java.lang.String r7 = r7.language
            r1.setLanguage(r7)
            com.sdk.poibase.model.poi.ReverseStationsInfo r7 = r6.f25067f
            java.util.ArrayList<java.lang.String> r7 = r7.geofenceTags
            r1.setGeofenceTags(r7)
            com.sdk.poibase.model.poi.ReverseStationsInfo r7 = r6.f25067f
            int r7 = com.didi.map.global.component.departure.util.DepartureUtils.getRecommendPoiCount(r7)
            r1.setPickUpPointSize(r7)
            com.sdk.poibase.model.poi.ReverseStationsInfo r7 = r6.f25067f
            java.util.ArrayList<com.sdk.poibase.model.RpcPoi> r7 = r7.result
            boolean r7 = com.didi.common.map.util.CollectionUtil.isEmpty((java.util.Collection<?>) r7)
            if (r7 != 0) goto L_0x01b6
            com.sdk.poibase.model.poi.ReverseStationsInfo r7 = r6.f25067f
            java.util.ArrayList<com.sdk.poibase.model.RpcPoi> r7 = r7.result
            java.lang.Object r7 = r7.get(r0)
            com.sdk.poibase.model.RpcPoi r7 = (com.sdk.poibase.model.RpcPoi) r7
            com.sdk.poibase.model.poi.ReverseStationsInfo r8 = r6.f25067f
            java.lang.String r8 = r8.language
            int r9 = r6.f25071j
            com.didi.sdk.address.address.entity.Address r7 = com.didi.map.global.component.departure.util.DepartureUtils.getAddressByRpcPoi(r7, r0, r8, r9)
            r1.setRgeoResult(r7)
        L_0x01b6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.departure.DeparturePresenter.getDepartureAddress(com.sdk.poibase.model.RpcPoi, com.sdk.poibase.model.RpcPoi, com.didi.common.map.model.LatLng, boolean):com.didi.map.global.component.departure.model.DepartureAddress");
    }

    /* renamed from: a */
    private boolean m17914a() {
        ReverseStationsInfo reverseStationsInfo = this.f25067f;
        return reverseStationsInfo != null && reverseStationsInfo.geofenceTags != null && !this.f25067f.geofenceTags.isEmpty() && this.f25067f.geofenceTags.contains("forbidden_area");
    }

    public RpcPoi sensing(List<RpcPoi> list) {
        Map map = this.f25062a;
        RpcPoi rpcPoi = null;
        if (map != null && map.getCameraPosition().zoom >= 15.0d) {
            double d = Double.MAX_VALUE;
            if (list != null && !list.isEmpty()) {
                for (RpcPoi next : list) {
                    if (next.base_info != null) {
                        LatLng latLng = new LatLng(next.base_info.lat, next.base_info.lng);
                        LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f25062a);
                        double a = m17905a(mapCenterPoint, latLng);
                        double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(mapCenterPoint, latLng);
                        if (m17916a(a, computeDistanceBetween) && computeDistanceBetween < d) {
                            rpcPoi = next;
                            d = computeDistanceBetween;
                        }
                    }
                }
            }
        }
        return rpcPoi;
    }

    public RecPoint sensing_terminal(List<RecPoint> list) {
        Map map = this.f25062a;
        RecPoint recPoint = null;
        if (map != null && map.getCameraPosition().zoom >= 15.0d) {
            double d = Double.MAX_VALUE;
            if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                for (RecPoint next : list) {
                    LatLng mapCenterPoint = DepartureUtils.getMapCenterPoint(this.f25062a);
                    double a = m17905a(mapCenterPoint, next.location);
                    double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(mapCenterPoint, next.location);
                    if (m17916a(a, computeDistanceBetween) && computeDistanceBetween < d) {
                        recPoint = next;
                        d = computeDistanceBetween;
                    }
                }
            }
        }
        return recPoint;
    }

    /* renamed from: a */
    private double m17905a(LatLng latLng, LatLng latLng2) {
        Projection projection;
        Map map = this.f25062a;
        if (map == null || (projection = map.getProjection()) == null) {
            return -1.0d;
        }
        PointF screenLocation = projection.toScreenLocation(latLng);
        PointF screenLocation2 = projection.toScreenLocation(latLng2);
        if (!(screenLocation == null || screenLocation2 == null)) {
            return Math.sqrt(Math.pow((double) Math.abs(screenLocation.x - screenLocation2.x), 2.0d) + Math.pow((double) Math.abs(screenLocation.y - screenLocation2.y), 2.0d));
        }
        return -1.0d;
    }

    /* renamed from: a */
    private boolean m17916a(double d, double d2) {
        boolean z = m17915a(d) && d < Double.MAX_VALUE;
        ApolloParamsDeparture apolloParamsDeparture = this.f25070i;
        if (apolloParamsDeparture == null || !apolloParamsDeparture.isNeedAdsorbControlEnabled || d2 <= ((double) this.f25070i.mNeedAdsorbMaxDistance)) {
            return z;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m17915a(double d) {
        if (d < 0.0d) {
            return false;
        }
        double windowWidth = d / ((double) WindowUtil.getWindowWidth(this.f25063b));
        ApolloParamsDeparture apolloParamsDeparture = this.f25070i;
        if (windowWidth <= ((double) (apolloParamsDeparture != null ? apolloParamsDeparture.mNeedAdsorbPercentage : 0.05f))) {
            return true;
        }
        return false;
    }

    public ApolloParamsDeparture getApolloParams() {
        if (this.f25070i == null) {
            this.f25070i = MapGlobalApolloUtils.getDepartureApolloParams();
        }
        m17913a("getApolloParams =" + this.f25070i);
        return this.f25070i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17913a(String str) {
        DLog.m7384d("DeparturePresenter", str, new Object[0]);
    }

    /* renamed from: a */
    private void m17912a(ReverseStationsInfo reverseStationsInfo, DepartureAddress departureAddress, RpcPoi rpcPoi, boolean z) {
        departureAddress.setRecommendPoi(z);
        if (rpcPoi != null) {
            departureAddress.setAddress(DepartureUtils.getAddressByRpcPoi(rpcPoi, z, reverseStationsInfo.language, this.f25071j));
            if (rpcPoi.base_info != null) {
                departureAddress.setIsAirPortPickUpPoint(rpcPoi.base_info.isAirPortPickUpPoint);
                departureAddress.setCountryId(rpcPoi.base_info.countryId);
                departureAddress.setCountryCode(rpcPoi.base_info.countryCode);
            }
            if (rpcPoi.extend_info != null) {
                departureAddress.setPickIconUrl(rpcPoi.extend_info.pickIconUrl);
                departureAddress.setEta(rpcPoi.extend_info.eta);
                departureAddress.setStartParkingProperty(rpcPoi.extend_info.startParkingProperty);
                int i = rpcPoi.extend_info.pictureStyle;
                boolean z2 = true;
                if (i == 1) {
                    z2 = false;
                }
                departureAddress.setShowRealPicInXpanel(z2);
            }
        }
    }

    /* renamed from: a */
    private List<Address> m17909a(DepartureAddress departureAddress, ArrayList<RpcPoi> arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        if (!CollectionUtil.isEmpty((Collection<?>) arrayList)) {
            Iterator<RpcPoi> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(DepartureUtils.getRecDestAddressByRpcPoi(it.next(), str));
            }
        }
        if (!arrayList2.isEmpty()) {
            departureAddress.setRecDestinations(arrayList2);
        }
        return arrayList2;
    }

    /* renamed from: a */
    private void m17911a(DepartureAddress departureAddress, RpcPoi rpcPoi, int i, boolean z) {
        if (rpcPoi != null && rpcPoi.extend_info != null) {
            AddressExtendInfo addressExtendInfo = new AddressExtendInfo();
            addressExtendInfo.setZoneType(i);
            addressExtendInfo.setXpanelDesc(rpcPoi.extend_info.xpanelDesc);
            addressExtendInfo.setNavigationText(rpcPoi.extend_info.navigationText);
            if (i == 0) {
                if (DepartureUtils.hasWalkGuidePhoto(rpcPoi)) {
                    AddressWalkGuide addressWalkGuide = new AddressWalkGuide();
                    addressWalkGuide.setGuidePhoto(rpcPoi.extend_info.walkGuidePhoto);
                    addressWalkGuide.setGuidePhotoH5(rpcPoi.extend_info.walk_guide_link);
                    addressExtendInfo.setWalkGuide(addressWalkGuide);
                } else if (DepartureUtils.hasStationBubbleDescription(rpcPoi)) {
                    addressExtendInfo.setBubbleText(rpcPoi.extend_info.stationBubbleDescV2);
                }
                addressExtendInfo.setMainNoticeTitle(rpcPoi.extend_info.xpanelDesc);
            } else if (i != 1) {
                if (i == 2 && rpcPoi.extend_info != null) {
                    addressExtendInfo.setBubbleText(rpcPoi.extend_info.bubbleDescV2);
                    addressExtendInfo.setMainNoticeTitle(rpcPoi.extend_info.mainTitleDesc);
                    addressExtendInfo.setSubNoticeTitle(rpcPoi.extend_info.subTitleDesc);
                }
            } else if (rpcPoi.extend_info != null) {
                addressExtendInfo.setBubbleText(rpcPoi.extend_info.bubbleDescV2);
                addressExtendInfo.setMainNoticeTitle(rpcPoi.extend_info.subTitleDesc);
            }
            if (i != 0 && !z && WalkDropApollo.Companion.getSubtitle_not_adsorbed()) {
                String string = this.f25063b.getResources().getString(R.string.GRider_reveal_Please_pick_iyQv);
                addressExtendInfo.setSubNoticeTitle("{\"text\":\"" + string + "\",\"info\":[{\"start\":\"0\",\"length\":\"" + string.length() + "\",\"color\":\"#EB6675\",\"bold\":1,\"through\":0,\"link\":\"\"}]}");
            }
            departureAddress.setExtendInfo(addressExtendInfo);
        }
    }
}
