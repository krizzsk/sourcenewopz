package com.didi.map.global.component.departure;

import com.didi.map.global.component.departure.circle.ZoneCircleOption;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.CallFrom;

public class DepartureCompParams {

    /* renamed from: a */
    private long f24841a;

    /* renamed from: b */
    private DepartureLocationInfo f24842b;

    /* renamed from: c */
    private CallFrom f24843c;

    /* renamed from: d */
    private RecPointStyle f24844d;

    /* renamed from: e */
    private PinStyle f24845e;

    /* renamed from: f */
    private DepartureFenceOptions f24846f;

    /* renamed from: g */
    private boolean f24847g;

    /* renamed from: h */
    private boolean f24848h;

    /* renamed from: i */
    private boolean f24849i;

    /* renamed from: j */
    private boolean f24850j;

    /* renamed from: k */
    private boolean f24851k;

    /* renamed from: l */
    private boolean f24852l;

    /* renamed from: m */
    private int f24853m;

    /* renamed from: n */
    private boolean f24854n;

    /* renamed from: o */
    private boolean f24855o;

    /* renamed from: p */
    private float f24856p = -1.0f;

    /* renamed from: q */
    private boolean f24857q;

    /* renamed from: r */
    private ApiType f24858r;

    /* renamed from: s */
    private NLPRegisterParam f24859s;

    /* renamed from: t */
    private ZoneCircleOption f24860t;

    /* renamed from: u */
    private int f24861u;

    /* renamed from: v */
    private boolean f24862v;

    /* renamed from: w */
    private boolean f24863w;

    /* renamed from: x */
    private Address f24864x;

    public NLPRegisterParam getNlpRegisterParam() {
        return this.f24859s;
    }

    public ZoneCircleOption getCircleOptions() {
        return this.f24860t;
    }

    public boolean isHasWayPoint() {
        return this.f24863w;
    }

    public Address getEndPoint() {
        return this.f24864x;
    }

    public int getSceneType() {
        return this.f24861u;
    }

    public long getDepartureTime() {
        return this.f24841a;
    }

    public DepartureLocationInfo getLocationInfo() {
        return this.f24842b;
    }

    public CallFrom getReqCallerId() {
        return this.f24843c;
    }

    public RecPointStyle getRecStyle() {
        return this.f24844d;
    }

    public PinStyle getPinStyle() {
        return this.f24845e;
    }

    public boolean isPinVisible() {
        return this.f24847g;
    }

    public boolean isRecPointVisible() {
        return this.f24848h;
    }

    public boolean isTerminalViewVisible() {
        return this.f24854n;
    }

    public boolean isConfirmPickupCardViewVisible() {
        return this.f24855o;
    }

    public boolean isFenceVisible() {
        return this.f24849i;
    }

    public float getZoom() {
        return this.f24856p;
    }

    public boolean isRequireByDrag() {
        return this.f24857q;
    }

    public ApiType getApiType() {
        return this.f24858r;
    }

    public boolean isBubbleVisible() {
        return this.f24850j;
    }

    public boolean isGuideLineVisible() {
        return this.f24851k;
    }

    public boolean isWalkDropVisible() {
        return this.f24852l;
    }

    public int getGuideLineColor() {
        return this.f24853m;
    }

    public DepartureFenceOptions getFenceOptions() {
        return this.f24846f;
    }

    public ZoneCircleOption getCircleOption() {
        return this.f24860t;
    }

    public boolean isCacheEnable() {
        return this.f24862v;
    }

    public DepartureCompParams(Builder builder) {
        this.f24842b = builder.locationInfo;
        this.f24843c = builder.reqCallerId;
        this.f24844d = builder.recStyle;
        this.f24845e = builder.pinStyle;
        this.f24856p = builder.zoom;
        this.f24849i = builder.isFenceVisible;
        this.f24847g = builder.isPinVisible;
        this.f24850j = builder.isBubbleVisible;
        this.f24841a = builder.departureTime;
        this.f24848h = builder.isRecPointVisible;
        this.f24854n = builder.isTerminalViewVisible;
        this.f24855o = builder.isConfirmPickupCardViewVisible;
        this.f24857q = builder.requireByDrag;
        this.f24851k = builder.isGuideLineVisible;
        this.f24853m = builder.guideLineColor;
        this.f24846f = builder.fenceOptions;
        this.f24860t = builder.circleOptions;
        this.f24861u = builder.sceneType;
        this.f24862v = builder.isCacheEnable;
        this.f24859s = builder.nlpRegisterParam;
        if (builder.apiType == null) {
            this.f24858r = ApiType.DEPARTURE_POI_INFO;
        } else {
            this.f24858r = builder.apiType;
        }
        this.f24863w = builder.hasWayPoint;
        this.f24864x = builder.endPoint;
        this.f24852l = builder.isWalkDropVisible;
    }

    public static class Builder {
        ApiType apiType = ApiType.DEPARTURE_POI_INFO;
        /* access modifiers changed from: private */
        public ZoneCircleOption circleOptions;
        /* access modifiers changed from: private */
        public long departureTime;
        /* access modifiers changed from: private */
        public Address endPoint;
        /* access modifiers changed from: private */
        public DepartureFenceOptions fenceOptions;
        /* access modifiers changed from: private */
        public int guideLineColor;
        /* access modifiers changed from: private */
        public boolean hasWayPoint;
        /* access modifiers changed from: private */
        public boolean isBubbleVisible;
        /* access modifiers changed from: private */
        public boolean isCacheEnable;
        /* access modifiers changed from: private */
        public boolean isConfirmPickupCardViewVisible;
        /* access modifiers changed from: private */
        public boolean isFenceVisible;
        /* access modifiers changed from: private */
        public boolean isGuideLineVisible;
        /* access modifiers changed from: private */
        public boolean isPinVisible;
        /* access modifiers changed from: private */
        public boolean isRecPointVisible;
        /* access modifiers changed from: private */
        public boolean isTerminalViewVisible = true;
        /* access modifiers changed from: private */
        public boolean isWalkDropVisible;
        /* access modifiers changed from: private */
        public DepartureLocationInfo locationInfo;
        /* access modifiers changed from: private */
        public NLPRegisterParam nlpRegisterParam;
        /* access modifiers changed from: private */
        public PinStyle pinStyle;
        /* access modifiers changed from: private */
        public RecPointStyle recStyle;
        CallFrom reqCallerId = null;
        /* access modifiers changed from: private */
        public boolean requireByDrag;
        /* access modifiers changed from: private */
        public int sceneType = 0;
        /* access modifiers changed from: private */
        public float zoom = -1.0f;

        public Builder setEndPoint(Address address) {
            this.endPoint = address;
            return this;
        }

        public Builder hasWayPoint(boolean z) {
            this.hasWayPoint = z;
            return this;
        }

        public Builder departureTime(long j) {
            this.departureTime = j;
            return this;
        }

        public Builder locationInfo(DepartureLocationInfo departureLocationInfo) {
            this.locationInfo = departureLocationInfo;
            return this;
        }

        public Builder recStyle(RecPointStyle recPointStyle) {
            this.recStyle = recPointStyle;
            return this;
        }

        public Builder pinStyle(PinStyle pinStyle2) {
            this.pinStyle = pinStyle2;
            return this;
        }

        public Builder fenceOptions(DepartureFenceOptions departureFenceOptions) {
            this.fenceOptions = departureFenceOptions;
            return this;
        }

        public Builder zoom(float f) {
            this.zoom = f;
            return this;
        }

        public Builder callFrom(CallFrom callFrom) {
            this.reqCallerId = callFrom;
            return this;
        }

        public Builder isPinVisible(boolean z) {
            this.isPinVisible = z;
            return this;
        }

        public Builder isRecPointVisible(boolean z) {
            this.isRecPointVisible = z;
            return this;
        }

        public Builder isFenceVisible(boolean z) {
            this.isFenceVisible = z;
            return this;
        }

        public Builder isBubbleVisible(boolean z) {
            this.isBubbleVisible = z;
            return this;
        }

        public Builder guideLineColor(int i) {
            this.guideLineColor = i;
            return this;
        }

        public Builder isGuideLineVisible(boolean z) {
            this.isGuideLineVisible = z;
            return this;
        }

        public Builder isTerminalViewVisible(boolean z) {
            this.isTerminalViewVisible = z;
            return this;
        }

        public Builder isConfirmPickupPointCardViewVisible(boolean z) {
            this.isConfirmPickupCardViewVisible = z;
            return this;
        }

        public Builder requireByDrag(boolean z) {
            this.requireByDrag = z;
            return this;
        }

        public Builder apiType(ApiType apiType2) {
            this.apiType = apiType2;
            return this;
        }

        public Builder zoneCircleOptions(ZoneCircleOption zoneCircleOption) {
            this.circleOptions = zoneCircleOption;
            return this;
        }

        public Builder sceneType(int i) {
            this.sceneType = i;
            return this;
        }

        public Builder cacheEnable(boolean z) {
            this.isCacheEnable = z;
            return this;
        }

        public Builder isWalkDropVisible(boolean z) {
            this.isWalkDropVisible = z;
            return this;
        }

        public Builder setNlpRegisterParam(NLPRegisterParam nLPRegisterParam) {
            this.nlpRegisterParam = nLPRegisterParam;
            return this;
        }

        public DepartureCompParams build() {
            return new DepartureCompParams(this);
        }
    }
}
