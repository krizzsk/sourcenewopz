package com.didi.map.sdk.sharetrack.google.inner.net;

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.DriverPushRouteReq;
import com.didi.map.sdk.proto.driver_gl.DriverPushRouteRes;
import com.didi.map.sdk.proto.driver_gl.LegInfo;
import com.didi.map.sdk.proto.driver_gl.LocationSource;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.PickupHint;
import com.didi.map.sdk.sharetrack.callback.IUploadRouteCallback;
import com.didi.map.sdk.sharetrack.common.NetUtils;
import com.didi.map.sdk.sharetrack.entity.DiDiRouteSegment;
import com.didi.map.sdk.sharetrack.entity.DiDiTimeAndDistance;
import com.didi.map.sdk.sharetrack.entity.OrderPoint;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.map.sdk.sharetrack.net.DUrl;
import com.squareup.wire.Wire;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SctxDataUploader extends AsyncTask<byte[], Integer, DriverPushRouteRes> {

    /* renamed from: a */
    private static final String f28863a = "SctxDataUploader";

    /* renamed from: b */
    private String f28864b = "https://apimap.didiglobal.com/navi/v1/driver/pushroute/sctx2/";

    /* renamed from: c */
    private Context f28865c;

    /* renamed from: d */
    private IUploadRouteCallback f28866d;

    public SctxDataUploader(Context context, IUploadRouteCallback iUploadRouteCallback) {
        this.f28865c = context;
        this.f28866d = iUploadRouteCallback;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        NetUtils.init(this.f28865c);
    }

    /* access modifiers changed from: protected */
    public DriverPushRouteRes doInBackground(byte[]... bArr) {
        if (isCancelled()) {
            return null;
        }
        try {
            String pushRouteUrl = DUrl.getPushRouteUrl(this.f28865c);
            this.f28864b = pushRouteUrl;
            byte[] doPost = NetUtils.doPost(pushRouteUrl, bArr[0]);
            if (doPost != null) {
                return (DriverPushRouteRes) new Wire((Class<?>[]) new Class[0]).parseFrom(doPost, DriverPushRouteRes.class);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            DLog.m20357d(f28863a, "GoogleRouteInfoUploader doInBackground(),Exception,%s", e.toString());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(DriverPushRouteRes driverPushRouteRes) {
        super.onPostExecute(driverPushRouteRes);
        if (this.f28866d == null) {
            return;
        }
        if (driverPushRouteRes == null || driverPushRouteRes.routeIds == null || driverPushRouteRes.routeIds.size() <= 0) {
            this.f28866d.finishToUpload(0, (PickupHint) null);
        } else {
            this.f28866d.finishToUpload(driverPushRouteRes.routeIds.get(0).longValue(), driverPushRouteRes.pickupHint);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
    }

    public static byte[] getRequestData(List<DiDiRouteSegment> list, List<DiDiTimeAndDistance> list2, List<OrderPoint> list3, long j, Location location, String str, int i, OrderPoint orderPoint, List<GpsLocation> list4, String str2, String str3, String str4) {
        ArrayList arrayList;
        List<DiDiRouteSegment> list5 = list;
        List<DiDiTimeAndDistance> list6 = list2;
        OrderPoint orderPoint2 = orderPoint;
        DoublePoint.Builder builder = new DoublePoint.Builder();
        if (location != null) {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(location.getLatitude()));
            BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(location.getLongitude()));
            builder.lat = Float.valueOf(bigDecimal.floatValue());
            builder.lng = Float.valueOf(bigDecimal2.floatValue());
            builder.dlat = Double.valueOf(location.getLatitude());
            builder.dlng = Double.valueOf(location.getLongitude());
            builder.speed = Integer.valueOf(Math.round(location.getSpeed()));
            builder.gpsTimestamp = Long.valueOf(location.getTime() / 1000);
            builder.accuracy = Double.valueOf(new BigDecimal(String.valueOf(location.getAccuracy())).doubleValue());
            if (builder.accuracy.doubleValue() > 30.0d) {
                builder.gpsSource = LocationSource.Network;
            } else {
                builder.gpsSource = LocationSource.GPS;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = null;
        if (list6 != null && list2.size() > 0) {
            int size = list2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list5 == null || list.size() <= 0 || list.size() != size) {
                    arrayList = null;
                } else {
                    List<LatLng> latLngList = list5.get(i2).getLatLngList();
                    arrayList = new ArrayList();
                    if (latLngList != null && latLngList.size() > 0) {
                        for (LatLng next : latLngList) {
                            BigDecimal bigDecimal3 = new BigDecimal(String.valueOf(next.latitude));
                            BigDecimal bigDecimal4 = new BigDecimal(String.valueOf(next.longitude));
                            DoublePoint.Builder builder2 = new DoublePoint.Builder();
                            builder2.lat = Float.valueOf(bigDecimal3.floatValue());
                            builder2.lng = Float.valueOf(bigDecimal4.floatValue());
                            arrayList.add(builder2.build());
                        }
                    }
                }
                LegInfo.Builder builder3 = new LegInfo.Builder();
                builder3.eda = Integer.valueOf(list6.get(i2).getEdaMeters());
                builder3.eta = Integer.valueOf(list6.get(i2).getEtaMinutes() * 60);
                builder3.geos = arrayList;
                arrayList2.add(builder3.build());
            }
        }
        if (list3 != null) {
            arrayList3 = new ArrayList();
            for (OrderPoint next2 : list3) {
                if (!(next2 == null || next2.point == null)) {
                    arrayList3.add(new OdPoint(Long.valueOf(next2.orderId), Integer.valueOf(next2.orderType), new DoublePoint.Builder().lat(Float.valueOf((float) next2.point.latitude)).lng(Float.valueOf((float) next2.point.longitude)).build(), next2.strOrderId, Integer.valueOf(next2.pointType), Float.valueOf(0.0f), 0, (DoublePoint) null, ""));
                }
            }
        }
        DriverPushRouteReq.Builder builder4 = new DriverPushRouteReq.Builder();
        builder4.timestamp = Long.valueOf(System.currentTimeMillis());
        builder4.ticket = PlatInfo.getInstance().getDriverTicket();
        builder4.orderId = str;
        builder4.orderStage = Integer.valueOf(i);
        if (location != null) {
            builder4.driverLocation = builder.build();
            builder4.driverDirection = Integer.valueOf((int) location.getBearing());
        }
        builder4.phoneNum = PlatInfo.getInstance().getDriverPhoneNumber();
        builder4.productId = String.valueOf(PlatInfo.getInstance().getBizType());
        builder4.countryId = PlatInfo.getInstance().getCountryCode();
        builder4.driverId = Long.valueOf(PlatInfo.getInstance().getDriverId());
        builder4.legsInfo = arrayList2;
        String str5 = TextUtils.isEmpty(str3) ? "googleNav" : str3;
        String str6 = TextUtils.isEmpty(str4) ? "1.6.3" : str4;
        builder4.mapType = str5;
        builder4.mapVersion = str6;
        builder4.odPoints = arrayList3;
        builder4.odPointsTimestamp = Long.valueOf(j);
        if (orderPoint2 != null) {
            builder4.destPoint = new OdPoint(Long.valueOf(orderPoint2.orderId), Integer.valueOf(orderPoint2.orderType), new DoublePoint.Builder().lat(Float.valueOf((float) orderPoint2.point.latitude)).lng(Float.valueOf((float) orderPoint2.point.longitude)).build(), orderPoint2.strOrderId, Integer.valueOf(orderPoint2.pointType), Float.valueOf(0.0f), 0, (DoublePoint) null, "");
        }
        builder4.version = "5";
        builder4.dynamicParameter = str2;
        builder4.trajs(FetcherManager.getHisTraj(list4));
        return builder4.build().toByteArray();
    }
}
