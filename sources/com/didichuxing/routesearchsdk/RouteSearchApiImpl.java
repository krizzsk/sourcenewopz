package com.didichuxing.routesearchsdk;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.util.NetUtils;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.HisTraj;
import com.didi.map.sdk.proto.driver_gl.LocationSource;
import com.didi.map.sdk.proto.driver_gl.RoutePlanRes;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.routesearchsdk.RouteSearchParam;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class RouteSearchApiImpl implements IRouteSearchApi {

    /* renamed from: a */
    private static final int f48507a = 100000;

    /* renamed from: b */
    private static final int f48508b = 100;

    RouteSearchApiImpl() {
    }

    public void calculateRoute(RouteSearchParam routeSearchParam, IRouteSearchCallback iRouteSearchCallback) {
        if (iRouteSearchCallback != null) {
            if (routeSearchParam == null) {
                iRouteSearchCallback.onFinishToSearch((RoutePlanRes) null, "param can not be null!");
                return;
            }
            String checkParam = routeSearchParam.checkParam();
            if (checkParam != null) {
                iRouteSearchCallback.onFinishToSearch((RoutePlanRes) null, String.format(Locale.CHINA, "param %s can not be null!", new Object[]{checkParam}));
                return;
            }
            byte[] a = m34800a(routeSearchParam);
            new RouteSearchTask(routeSearchParam.f48509a, iRouteSearchCallback).execute(new byte[][]{a});
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m34800a(com.didichuxing.routesearchsdk.RouteSearchParam r11) {
        /*
            r10 = this;
            java.util.List<com.didi.map.sdk.proto.driver_gl.OidPidPair> r0 = r11.f48525q
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0025
            java.util.List<com.didi.map.sdk.proto.driver_gl.OidPidPair> r0 = r11.f48525q
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.didi.map.sdk.proto.driver_gl.OidPidPair r0 = (com.didi.map.sdk.proto.driver_gl.OidPidPair) r0
            java.lang.String r3 = r0.orderId
            java.lang.String r4 = r0.passengerId     // Catch:{ Exception -> 0x0022 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x0022 }
            java.lang.String r0 = r0.passengerId     // Catch:{ Exception -> 0x0023 }
            long r6 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0029
        L_0x0022:
            r4 = r1
        L_0x0023:
            r6 = r1
            goto L_0x0029
        L_0x0025:
            java.lang.String r3 = ""
            r4 = r1
            r6 = r4
        L_0x0029:
            long r8 = r11.f48524p
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0031
            long r6 = r11.f48524p
        L_0x0031:
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = new com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder
            r0.<init>()
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r1 = new com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder
            r1.<init>()
            double r8 = r11.f48510b
            float r2 = (float) r8
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r1 = r1.lat(r2)
            double r8 = r11.f48511c
            float r2 = (float) r8
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r1 = r1.lng(r2)
            com.didi.map.sdk.proto.driver_gl.DoublePoint r1 = r1.build()
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.startPoint(r1)
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r1 = new com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder
            r1.<init>()
            double r8 = r11.f48512d
            float r2 = (float) r8
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r1 = r1.lat(r2)
            double r8 = r11.f48513e
            float r2 = (float) r8
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            com.didi.map.sdk.proto.driver_gl.DoublePoint$Builder r1 = r1.lng(r2)
            com.didi.map.sdk.proto.driver_gl.DoublePoint r1 = r1.build()
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.endPoint(r1)
            java.lang.String r1 = r11.f48514f
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.token(r1)
            java.lang.String r1 = r11.f48515g
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.productId(r1)
            java.lang.String r1 = r11.f48516h
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.phoneNum(r1)
            int r1 = r11.f48517i
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.orderStage(r1)
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r1 = r11.f48518j
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.odPoints(r1)
            com.didi.map.sdk.proto.driver_gl.TravelMode r1 = r11.f48520l
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.travelMode(r1)
            com.didichuxing.routesearchsdk.CallFrom r1 = r11.f48519k
            java.lang.String r1 = r1.toString()
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.caller(r1)
            java.lang.String r1 = r11.f48521m
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.countryId(r1)
            int r1 = r11.f48527s
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.bizGroup(r1)
            java.lang.String r1 = r11.f48523o
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.travelId(r1)
            java.lang.String r1 = r11.f48522n
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.traceInfo(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.passengerId(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.driverId(r1)
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r0 = r0.orderId(r3)
            java.util.List<com.didi.common.map.model.GpsLocation> r11 = r11.f48526r
            com.didi.map.sdk.proto.driver_gl.HisTraj r11 = r10.m34796a((java.util.List<com.didi.common.map.model.GpsLocation>) r11)
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq$Builder r11 = r0.trajs(r11)
            com.didi.map.sdk.proto.driver_gl.RoutePlanReq r11 = r11.build()
            byte[] r11 = r11.toByteArray()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.routesearchsdk.RouteSearchApiImpl.m34800a(com.didichuxing.routesearchsdk.RouteSearchParam):byte[]");
    }

    /* renamed from: a */
    private HisTraj m34796a(List<GpsLocation> list) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        int i;
        List<GpsLocation> list2 = list;
        if (list2 == null || list.isEmpty()) {
            return null;
        }
        HisTraj.Builder builder = new HisTraj.Builder();
        DiffGeoPoints.Builder builder2 = new DiffGeoPoints.Builder();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            GpsLocation gpsLocation = list2.get(i2);
            arrayList5.add(Float.valueOf((float) gpsLocation.accuracy));
            arrayList6.add(Integer.valueOf(((int) (gpsLocation.direction + 360.0f)) % 360));
            arrayList7.add(Integer.valueOf((int) gpsLocation.velocity));
            arrayList8.add(Long.valueOf(gpsLocation.time / 1000));
            arrayList9.add(m34797a(gpsLocation.provider));
            if (i2 > 0) {
                GpsLocation gpsLocation2 = list2.get(i2 - 1);
                arrayList4 = arrayList8;
                arrayList3 = arrayList9;
                arrayList2 = arrayList6;
                arrayList = arrayList7;
                Integer valueOf = Integer.valueOf((int) ((gpsLocation.latitude - gpsLocation2.latitude) * 100000.0d * 100.0d));
                i = size;
                Integer valueOf2 = Integer.valueOf((int) ((gpsLocation.longitude - gpsLocation2.longitude) * 100000.0d * 100.0d));
                arrayList10.add(valueOf);
                arrayList11.add(valueOf2);
            } else {
                arrayList2 = arrayList6;
                arrayList = arrayList7;
                arrayList4 = arrayList8;
                arrayList3 = arrayList9;
                i = size;
            }
            i2++;
            size = i;
            arrayList8 = arrayList4;
            arrayList9 = arrayList3;
            arrayList6 = arrayList2;
            arrayList7 = arrayList;
        }
        ArrayList arrayList12 = arrayList6;
        ArrayList arrayList13 = arrayList7;
        ArrayList arrayList14 = arrayList9;
        DoublePoint.Builder builder3 = new DoublePoint.Builder();
        GpsLocation gpsLocation3 = list2.get(0);
        double d = gpsLocation3.latitude * 100000.0d;
        double d2 = gpsLocation3.longitude * 100000.0d;
        builder3.dlat(Double.valueOf(d)).dlng(Double.valueOf(d2)).lat(Float.valueOf((float) d)).lng(Float.valueOf((float) d2)).accuracy(Double.valueOf((double) gpsLocation3.accuracy)).timestamp(Long.valueOf(gpsLocation3.time / 1000)).gpsTimestamp(Long.valueOf(gpsLocation3.time / 1000)).speed(Integer.valueOf((int) gpsLocation3.velocity)).gpsSource(m34797a(gpsLocation3.provider));
        builder2.base(builder3.build()).dlats(arrayList10).dlngs(arrayList11);
        builder.hisAccuracy(arrayList5).hisDirection(arrayList12).hisSpeed(arrayList13).hisTimestamp(arrayList8).historyTraj(builder2.build()).hisLocationSource(arrayList14);
        return builder.build();
    }

    /* renamed from: a */
    private LocationSource m34797a(String str) {
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

    private class RouteSearchTask extends AsyncTask<byte[], Integer, RoutePlanRes> {
        private RouteSearchParam.BizType bizType;
        private IRouteSearchCallback callback;
        private String errMsg = "";

        public RouteSearchTask(RouteSearchParam.BizType bizType2, IRouteSearchCallback iRouteSearchCallback) {
            this.bizType = bizType2;
            this.callback = iRouteSearchCallback;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.callback.onBeginToSearch();
        }

        /* access modifiers changed from: protected */
        public RoutePlanRes doInBackground(byte[]... bArr) {
            this.errMsg = "";
            try {
                byte[] doPost = NetUtils.doPost(RouteSearchApiImpl.this.m34798a(), bArr[0]);
                if (doPost != null) {
                    return (RoutePlanRes) new Wire((Class<?>[]) new Class[0]).parseFrom(doPost, RoutePlanRes.class);
                }
                this.errMsg = "request return is null";
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                this.errMsg = e.toString();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(RoutePlanRes routePlanRes) {
            this.callback.onFinishToSearch(routePlanRes, this.errMsg);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m34798a() {
        return RouteSearchUrls.getRoutePlanUrl();
    }
}
