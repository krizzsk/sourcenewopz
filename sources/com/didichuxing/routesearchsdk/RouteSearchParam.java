package com.didichuxing.routesearchsdk;

import android.text.TextUtils;
import com.didi.common.map.model.GpsLocation;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.OidPidPair;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import java.util.Collections;
import java.util.List;

public class RouteSearchParam {

    /* renamed from: a */
    final BizType f48509a;

    /* renamed from: b */
    final double f48510b;

    /* renamed from: c */
    final double f48511c;

    /* renamed from: d */
    final double f48512d;

    /* renamed from: e */
    final double f48513e;

    /* renamed from: f */
    final String f48514f;

    /* renamed from: g */
    final String f48515g;

    /* renamed from: h */
    final String f48516h;

    /* renamed from: i */
    final int f48517i;

    /* renamed from: j */
    final List<OdPoint> f48518j;

    /* renamed from: k */
    final CallFrom f48519k;

    /* renamed from: l */
    TravelMode f48520l;

    /* renamed from: m */
    final String f48521m;

    /* renamed from: n */
    final String f48522n;

    /* renamed from: o */
    final String f48523o;

    /* renamed from: p */
    final long f48524p;

    /* renamed from: q */
    final List<OidPidPair> f48525q;

    /* renamed from: r */
    final List<GpsLocation> f48526r;

    /* renamed from: s */
    final int f48527s;

    public enum BizType {
        BRAZIL,
        TAIWAN,
        GLOBAL
    }

    RouteSearchParam(Builder builder) {
        this.f48509a = builder.bizType;
        this.f48510b = builder.startLat;
        this.f48511c = builder.startLng;
        this.f48512d = builder.endLat;
        this.f48513e = builder.endLng;
        this.f48514f = builder.token;
        this.f48515g = builder.productId;
        this.f48516h = builder.phoneNum;
        this.f48518j = builder.odPoints;
        this.f48517i = builder.orderStage;
        this.f48520l = builder.travelMode;
        this.f48519k = builder.caller;
        this.f48521m = builder.countryId;
        this.f48523o = builder.travelId;
        this.f48522n = builder.traceInfo;
        this.f48525q = builder.oidPidPairs;
        this.f48524p = builder.driverId;
        this.f48526r = builder.recentLocList;
        this.f48527s = builder.bizGroup;
    }

    public String checkParam() {
        CallFrom callFrom;
        if (this.f48509a == null) {
            return "bizType";
        }
        if (this.f48510b == 0.0d) {
            return "startLat";
        }
        if (this.f48511c == 0.0d) {
            return "startLng";
        }
        if (this.f48512d == 0.0d) {
            return "endLat";
        }
        if (this.f48513e == 0.0d || (callFrom = this.f48519k) == null || callFrom.equals(CallFrom.UNKNOWN)) {
            return "endLng";
        }
        if (TextUtils.isEmpty(this.f48514f)) {
            return "token";
        }
        return null;
    }

    public static class Builder {
        int bizGroup;
        BizType bizType;
        CallFrom caller = CallFrom.UNKNOWN;
        String countryId;
        long driverId;
        double endLat;
        double endLng;
        List<OdPoint> odPoints;
        List<OidPidPair> oidPidPairs = Collections.emptyList();
        int orderStage;
        String phoneNum;
        String productId;
        List<GpsLocation> recentLocList;
        double startLat;
        double startLng;
        String token;
        String traceInfo;
        String travelId;
        TravelMode travelMode;

        public Builder(BizType bizType2, double d, double d2, double d3, double d4, String str) {
            this.bizType = bizType2;
            this.startLat = d;
            this.startLng = d2;
            this.endLat = d3;
            this.endLng = d4;
            this.token = str;
        }

        public Builder setProductId(String str) {
            this.productId = str;
            return this;
        }

        public Builder setPhoneNum(String str) {
            this.phoneNum = str;
            return this;
        }

        public Builder setOrderStage(int i) {
            this.orderStage = i;
            return this;
        }

        public Builder setOdPoints(List<OdPoint> list) {
            this.odPoints = list;
            return this;
        }

        public Builder setTravelMode(TravelMode travelMode2) {
            this.travelMode = travelMode2;
            return this;
        }

        public Builder setCaller(CallFrom callFrom) {
            this.caller = callFrom;
            return this;
        }

        public Builder setCountryId(String str) {
            this.countryId = str;
            return this;
        }

        public Builder setTravelId(String str) {
            this.travelId = str;
            return this;
        }

        public Builder setTraceInfo(String str) {
            this.traceInfo = str;
            return this;
        }

        public Builder setBizGroup(int i) {
            this.bizGroup = i;
            return this;
        }

        public Builder setOidPidPairsList(List<OidPidPair> list) {
            this.oidPidPairs = list;
            return this;
        }

        public Builder setDriverId(long j) {
            this.driverId = j;
            return this;
        }

        public Builder setRecentLocList(List<GpsLocation> list) {
            this.recentLocList = list;
            return this;
        }

        public RouteSearchParam build() {
            return new RouteSearchParam(this);
        }
    }
}
