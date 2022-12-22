package com.didi.map.global.flow.toolkit.sctx;

import android.content.Context;
import com.didi.common.map.MapView;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.flow.scene.order.serving.IEtaEdaCallback;
import com.didi.map.sdk.sharetrack.callback.INavigationCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchOffRouteCallback;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import java.util.Locale;

public class DriverSctxParam {
    public final int carBitmapRes;
    public final int carZIndex;
    public final IEtaEdaCallback etaEdaCallback;
    public final int lineZIndex;
    public final DIDILocationListener locationListener;
    public final MapView mapView;
    public final INavigationCallback navigationCallback;
    public final Point orderEndPoint;
    public final OrderInfo orderInfo;
    public final Point orderStartPoint;
    public final ISearchOffRouteCallback searchOffRouteCallback;
    public final ISearchRouteCallback searchRouteCallback;

    public DriverSctxParam(Builder builder) {
        this.mapView = builder.mapView;
        this.orderInfo = builder.orderInfo;
        this.orderStartPoint = builder.orderStartPoint;
        this.orderEndPoint = builder.orderEndPoint;
        this.carBitmapRes = builder.carBitmapRes;
        this.carZIndex = builder.carZIndex;
        this.lineZIndex = builder.lineZIndex;
        this.etaEdaCallback = builder.etaEdaCallback;
        this.navigationCallback = builder.navigationCallback;
        this.searchOffRouteCallback = builder.searchOffRouteCallback;
        this.searchRouteCallback = builder.searchRouteCallback;
        this.locationListener = builder.locationListener;
    }

    public Context getApplicationContext() {
        MapView mapView2 = this.mapView;
        if (mapView2 == null || mapView2.getContext() == null) {
            return null;
        }
        return this.mapView.getContext().getApplicationContext();
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s, orderStartPoint:%s, orderEndPoint:%s", new Object[]{this.orderInfo.toString(), this.orderStartPoint.toString(), this.orderEndPoint.toString()});
    }

    public static class Point {
        public LatLng latLng;
        public int markerIconResId;
        public String name;

        public Point(LatLng latLng2, String str, int i) {
            this.latLng = latLng2;
            this.name = str;
            this.markerIconResId = i;
        }

        public String toString() {
            return String.format(Locale.getDefault(), "{(%.6f,%.6f), %s}", new Object[]{Double.valueOf(this.latLng.longitude), Double.valueOf(this.latLng.latitude), this.name});
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public int carBitmapRes;
        /* access modifiers changed from: private */
        public int carZIndex;
        /* access modifiers changed from: private */
        public IEtaEdaCallback etaEdaCallback;
        /* access modifiers changed from: private */
        public int lineZIndex;
        /* access modifiers changed from: private */
        public DIDILocationListener locationListener;
        /* access modifiers changed from: private */
        public MapView mapView;
        /* access modifiers changed from: private */
        public INavigationCallback navigationCallback;
        /* access modifiers changed from: private */
        public Point orderEndPoint;
        /* access modifiers changed from: private */
        public OrderInfo orderInfo;
        /* access modifiers changed from: private */
        public Point orderStartPoint;
        /* access modifiers changed from: private */
        public ISearchOffRouteCallback searchOffRouteCallback;
        /* access modifiers changed from: private */
        public ISearchRouteCallback searchRouteCallback;

        public Builder setMapView(MapView mapView2) {
            this.mapView = mapView2;
            return this;
        }

        public Builder setOrderInfo(OrderInfo orderInfo2) {
            this.orderInfo = orderInfo2;
            return this;
        }

        public Builder setOrderStartPoint(Point point) {
            this.orderStartPoint = point;
            return this;
        }

        public Builder setOrderEndPoint(Point point) {
            this.orderEndPoint = point;
            return this;
        }

        public Builder setCarBitmapRes(int i) {
            this.carBitmapRes = i;
            return this;
        }

        public Builder setCarZIndex(int i) {
            this.carZIndex = i;
            return this;
        }

        public Builder setLineZIndex(int i) {
            this.lineZIndex = i;
            return this;
        }

        public Builder setEtaEdaCallback(IEtaEdaCallback iEtaEdaCallback) {
            this.etaEdaCallback = iEtaEdaCallback;
            return this;
        }

        public Builder setNavigationCallback(INavigationCallback iNavigationCallback) {
            this.navigationCallback = iNavigationCallback;
            return this;
        }

        public Builder setSearchOffRouteCallback(ISearchOffRouteCallback iSearchOffRouteCallback) {
            this.searchOffRouteCallback = iSearchOffRouteCallback;
            return this;
        }

        public Builder setSearchRouteCallback(ISearchRouteCallback iSearchRouteCallback) {
            this.searchRouteCallback = iSearchRouteCallback;
            return this;
        }

        public Builder setLocationListener(DIDILocationListener dIDILocationListener) {
            this.locationListener = dIDILocationListener;
            return this;
        }

        public DriverSctxParam build() {
            return new DriverSctxParam(this);
        }
    }
}
