package com.didi.map.global.flow.scene.order.serving.param;

import android.content.Context;
import com.didi.map.global.flow.model.WayPointParam;
import com.didi.map.global.flow.scene.PageSceneParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import java.util.HashMap;

public class ServiceOverParam extends PageSceneParam {

    /* renamed from: a */
    private boolean f26893a = true;

    /* renamed from: b */
    private long f26894b;

    /* renamed from: c */
    private int f26895c;

    /* renamed from: d */
    private long f26896d;

    /* renamed from: e */
    private long f26897e;

    /* renamed from: f */
    private String f26898f;

    /* renamed from: g */
    private String f26899g;

    /* renamed from: h */
    private String f26900h;

    /* renamed from: i */
    private String f26901i;

    /* renamed from: j */
    private String f26902j;

    /* renamed from: k */
    private int f26903k;

    /* renamed from: l */
    private HashMap<MapElementId, CommonMarkerParam> f26904l;

    /* renamed from: m */
    private WayPointParam f26905m;

    /* renamed from: n */
    private boolean f26906n;

    public ServiceOverParam(Builder builder) {
        super(builder);
        this.f26893a = builder.showRouteLine;
        this.f26894b = builder.driverId;
        this.f26895c = builder.biztype;
        this.f26896d = builder.startTime;
        this.f26897e = builder.endTime;
        this.f26898f = builder.clientVersion;
        this.f26899g = builder.token;
        this.f26900h = builder.passengerPhoneNumber;
        this.f26901i = builder.imei;
        this.f26902j = builder.orderId;
        this.f26903k = builder.orderStatus;
        this.f26904l = builder.markerParams;
        this.f26905m = builder.wayPointParam;
        this.f26906n = builder.isNewVersion;
        this.f26904l = builder.markerParams;
    }

    public boolean isShowRouteLine() {
        return this.f26893a;
    }

    public long getDriverId() {
        return this.f26894b;
    }

    public int getBiztype() {
        return this.f26895c;
    }

    public long getStartTime() {
        return this.f26896d;
    }

    public long getEndTime() {
        return this.f26897e;
    }

    public String getClientVersion() {
        return this.f26898f;
    }

    public String getToken() {
        return this.f26899g;
    }

    public String getPassengerPhoneNumber() {
        return this.f26900h;
    }

    public String getImei() {
        return this.f26901i;
    }

    public String getOrderId() {
        return this.f26902j;
    }

    public int getOrderStatus() {
        return this.f26903k;
    }

    public HashMap<MapElementId, CommonMarkerParam> getMarkerParams() {
        return this.f26904l;
    }

    public CommonMarkerParam getMarkerParam(MapElementId mapElementId) {
        HashMap<MapElementId, CommonMarkerParam> hashMap = this.f26904l;
        if (hashMap == null || !hashMap.containsKey(mapElementId)) {
            return null;
        }
        return this.f26904l.get(mapElementId);
    }

    public WayPointParam getWayPointParam() {
        return this.f26905m;
    }

    public boolean isNewVersion() {
        return this.f26906n;
    }

    public static class Builder extends PageSceneParam.Builder {
        /* access modifiers changed from: private */
        public int biztype;
        /* access modifiers changed from: private */
        public String clientVersion;
        /* access modifiers changed from: private */
        public long driverId;
        /* access modifiers changed from: private */
        public long endTime;
        /* access modifiers changed from: private */
        public String imei;
        /* access modifiers changed from: private */
        public boolean isNewVersion;
        /* access modifiers changed from: private */
        public HashMap<MapElementId, CommonMarkerParam> markerParams;
        /* access modifiers changed from: private */
        public String orderId;
        /* access modifiers changed from: private */
        public int orderStatus;
        /* access modifiers changed from: private */
        public String passengerPhoneNumber;
        /* access modifiers changed from: private */
        public boolean showRouteLine = true;
        /* access modifiers changed from: private */
        public long startTime;
        /* access modifiers changed from: private */
        public String token;
        /* access modifiers changed from: private */
        public WayPointParam wayPointParam;

        public Builder setShowRouteLine(boolean z) {
            this.showRouteLine = z;
            return this;
        }

        public Builder setDriverId(long j) {
            this.driverId = j;
            return this;
        }

        public Builder setBiztype(int i) {
            this.biztype = i;
            return this;
        }

        public Builder setStartTime(long j) {
            this.startTime = j;
            return this;
        }

        public Builder setEndTime(long j) {
            this.endTime = j;
            return this;
        }

        public Builder setClientVersion(String str) {
            this.clientVersion = str;
            return this;
        }

        public Builder setToken(String str) {
            this.token = str;
            return this;
        }

        public Builder setPassengerPhoneNumber(String str) {
            this.passengerPhoneNumber = str;
            return this;
        }

        public Builder setImei(String str) {
            this.imei = str;
            return this;
        }

        public Builder setOrderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder setOrderStatus(int i) {
            this.orderStatus = i;
            return this;
        }

        public Builder setMarkerParams(HashMap<MapElementId, CommonMarkerParam> hashMap) {
            this.markerParams = hashMap;
            return this;
        }

        public Builder setWayPointParam(WayPointParam wayPointParam2) {
            this.wayPointParam = wayPointParam2;
            return this;
        }

        public Builder setNewVersion(boolean z) {
            this.isNewVersion = z;
            return this;
        }

        public Builder context(Context context) {
            return (Builder) super.context(context);
        }

        public Builder mapChangeListener(IMapChangeListener iMapChangeListener) {
            return (Builder) super.mapChangeListener(iMapChangeListener);
        }

        public ServiceOverParam build() {
            return new ServiceOverParam(this);
        }
    }
}
