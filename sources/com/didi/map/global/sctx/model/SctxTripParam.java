package com.didi.map.global.sctx.model;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import java.util.List;
import java.util.Objects;

public class SctxTripParam {

    /* renamed from: A */
    private SctxService.SctxSearchGetter f27655A;

    /* renamed from: B */
    private VamosExpansionParam f27656B;

    /* renamed from: C */
    private boolean f27657C;

    /* renamed from: D */
    private int f27658D;

    /* renamed from: E */
    private int f27659E;

    /* renamed from: F */
    private boolean f27660F;

    /* renamed from: G */
    private TravelMode f27661G;

    /* renamed from: H */
    private int f27662H;

    /* renamed from: I */
    private boolean f27663I;

    /* renamed from: a */
    private final Map f27664a;

    /* renamed from: b */
    private final Context f27665b;

    /* renamed from: c */
    private final String f27666c;

    /* renamed from: d */
    private final String f27667d;

    /* renamed from: e */
    private final int f27668e;

    /* renamed from: f */
    private final int f27669f;

    /* renamed from: g */
    private final boolean f27670g;

    /* renamed from: h */
    private final long f27671h;
    protected transient int hashCode;

    /* renamed from: i */
    private final List<OdPoint> f27672i;

    /* renamed from: j */
    private final LatLng f27673j;

    /* renamed from: k */
    private final LatLng f27674k;

    /* renamed from: l */
    private final String f27675l;

    /* renamed from: m */
    private final long f27676m;

    /* renamed from: n */
    private final String f27677n;

    /* renamed from: o */
    private final String f27678o;

    /* renamed from: p */
    private final boolean f27679p;

    /* renamed from: q */
    private final boolean f27680q;

    /* renamed from: r */
    private final String f27681r;

    /* renamed from: s */
    private final String f27682s;

    /* renamed from: t */
    private final String f27683t;

    /* renamed from: u */
    private final BitmapDescriptor f27684u;

    /* renamed from: v */
    private final boolean f27685v;

    /* renamed from: w */
    private final List<String> f27686w;

    /* renamed from: x */
    private final int f27687x;

    /* renamed from: y */
    private final long f27688y;

    /* renamed from: z */
    private final long f27689z;

    public String getOrderId() {
        return this.f27667d;
    }

    public int getBizType() {
        return this.f27668e;
    }

    public int getTripState() {
        return this.f27669f;
    }

    public boolean isArrivedPickupPoint() {
        return this.f27670g;
    }

    public LatLng getPickupPoint() {
        return this.f27673j;
    }

    public LatLng getEndPoint() {
        return this.f27674k;
    }

    public String getToken() {
        return this.f27675l;
    }

    public long getDriverId() {
        return this.f27676m;
    }

    public String getTripId() {
        return this.f27677n;
    }

    public String getLastOrderId() {
        return this.f27678o;
    }

    public boolean isShowExtendedAnimation() {
        return this.f27679p;
    }

    public boolean isReadOnly() {
        return this.f27680q;
    }

    public String getClientVersion() {
        return this.f27681r;
    }

    public String getCountryId() {
        return this.f27682s;
    }

    public String getImei() {
        return this.f27683t;
    }

    public Map getMap() {
        return this.f27664a;
    }

    public Context getContext() {
        return this.f27665b;
    }

    public String getPassengerPhone() {
        return this.f27666c;
    }

    public BitmapDescriptor getCarBitmapDescriptor() {
        return this.f27684u;
    }

    public boolean isIs3DEnabled() {
        return this.f27685v;
    }

    public List<String> getCar3DIcons() {
        return this.f27686w;
    }

    public int getzIndex() {
        return this.f27687x;
    }

    public long getRouteExtensionAnimationDuration() {
        return this.f27688y;
    }

    public long getOraRequestInterval() {
        return this.f27689z;
    }

    public long getWayPointsTimestamp() {
        return this.f27671h;
    }

    public List<OdPoint> getWayPoints() {
        return this.f27672i;
    }

    public SctxService.SctxSearchGetter getSctxSearchGetter() {
        return this.f27655A;
    }

    public VamosExpansionParam getVamosExpansionParam() {
        return this.f27656B;
    }

    public void dispose() {
        this.f27655A = null;
    }

    public boolean isNewVersion() {
        return this.f27657C;
    }

    public boolean showRecommendPickupPoint() {
        return this.f27660F;
    }

    public int getLineColor() {
        return this.f27658D;
    }

    public int getLineWidth() {
        return this.f27659E;
    }

    public TravelMode getTravelMode() {
        return this.f27661G;
    }

    public int getBizGroup() {
        return this.f27662H;
    }

    public boolean isBackgroundOra() {
        return this.f27663I;
    }

    private SctxTripParam(Builder builder) {
        this.hashCode = 0;
        this.f27661G = TravelMode.DRIVING;
        this.f27667d = builder.orderId;
        this.f27668e = builder.bizType;
        this.f27669f = builder.tripState;
        this.f27670g = builder.isArrivedPickupPoint;
        this.f27671h = builder.wayPointsTimestamp;
        this.f27672i = builder.wayPoints;
        this.f27673j = builder.pickupPoint;
        this.f27674k = builder.endPoint;
        this.f27675l = builder.token;
        this.f27676m = builder.driverId;
        this.f27677n = builder.tripId;
        this.f27678o = builder.lastOrderId;
        this.f27679p = builder.isShowExtendedAnimation;
        this.f27680q = builder.isReadOnly;
        this.f27681r = builder.clientVersion;
        this.f27682s = builder.countryId;
        this.f27683t = builder.imei;
        this.f27684u = builder.carBitmapDescriptor;
        this.f27685v = builder.is3DEnabled;
        this.f27686w = builder.car3DIcons;
        this.f27687x = builder.zIndex;
        this.f27655A = builder.sctxSearchGetter;
        this.f27688y = builder.routeExtensionAnimationDuration;
        this.f27689z = builder.oraRequestInterval;
        this.f27656B = builder.vamosExpansionParam;
        this.f27664a = builder.map;
        this.f27665b = builder.context;
        this.f27666c = builder.passengerPhone;
        this.f27657C = builder.newVersion;
        this.f27660F = builder.showRecommendPickupPoint;
        this.f27658D = builder.lineColor;
        this.f27659E = builder.lineWidth;
        this.f27661G = builder.travelMode;
        this.f27662H = builder.bizGroup;
        this.f27663I = builder.backgroundOra;
    }

    public static class Builder {
        boolean backgroundOra;
        int bizGroup;
        int bizType;
        boolean bluetoothNotify;
        List<String> car3DIcons;
        BitmapDescriptor carBitmapDescriptor;
        String clientVersion;
        Context context;
        String countryId;
        long driverId;
        LatLng endPoint;
        String imei;
        boolean is3DEnabled;
        boolean isArrivedPickupPoint;
        boolean isReadOnly;
        boolean isShowExtendedAnimation;
        String lastOrderId;
        int lineColor;
        int lineWidth;
        Map map;
        boolean newVersion;
        LatLng oasisDriverEndPoint;
        long oraRequestInterval;
        String orderId;
        String passengerPhone;
        LatLng pickupPoint;
        long routeExtensionAnimationDuration;
        SctxService.SctxSearchGetter sctxSearchGetter;
        boolean showRecommendPickupPoint;
        String token;
        TravelMode travelMode;
        String tripId;
        int tripState;
        VamosExpansionParam vamosExpansionParam;
        List<OdPoint> wayPoints;
        long wayPointsTimestamp;
        int zIndex;

        public SctxTripParam build() {
            return new SctxTripParam(this);
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder bizType(int i) {
            this.bizType = i;
            return this;
        }

        public Builder tripState(int i) {
            this.tripState = i;
            return this;
        }

        public Builder pickupPoint(LatLng latLng) {
            this.pickupPoint = latLng;
            return this;
        }

        public Builder endPoint(LatLng latLng) {
            this.endPoint = latLng;
            return this;
        }

        public Builder oasisDriverEndPoint(LatLng latLng) {
            this.oasisDriverEndPoint = latLng;
            return this;
        }

        public Builder isArrivedPickupPoint(boolean z) {
            this.isArrivedPickupPoint = z;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder tripId(String str) {
            this.tripId = str;
            return this;
        }

        public Builder driverId(long j) {
            this.driverId = j;
            return this;
        }

        public Builder isShowExtendedAnimation(boolean z) {
            this.isShowExtendedAnimation = z;
            return this;
        }

        public Builder isReadOnly(boolean z) {
            this.isReadOnly = z;
            return this;
        }

        public Builder lastOrderId(String str) {
            this.lastOrderId = str;
            return this;
        }

        public Builder clientVersion(String str) {
            this.clientVersion = str;
            return this;
        }

        public Builder countryId(String str) {
            this.countryId = str;
            return this;
        }

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder carBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
            this.carBitmapDescriptor = bitmapDescriptor;
            return this;
        }

        public Builder car3DIcons(List<String> list) {
            this.car3DIcons = list;
            return this;
        }

        public Builder car3DEnabled(boolean z) {
            this.is3DEnabled = z;
            return this;
        }

        public Builder zIndex(int i) {
            this.zIndex = i;
            return this;
        }

        public Builder routeExtensionAnimationDuration(long j) {
            this.routeExtensionAnimationDuration = j;
            return this;
        }

        public Builder oraRequestInterval(long j) {
            this.oraRequestInterval = j;
            return this;
        }

        public Builder map(Map map2) {
            this.map = map2;
            return this;
        }

        public Builder context(Context context2) {
            this.context = context2;
            return this;
        }

        public Builder passengerPhone(String str) {
            this.passengerPhone = str;
            return this;
        }

        public Builder wayPointsTimestamp(long j) {
            this.wayPointsTimestamp = j;
            return this;
        }

        public Builder wayPoints(List<OdPoint> list) {
            this.wayPoints = list;
            return this;
        }

        public Builder vamosExpansionParam(VamosExpansionParam vamosExpansionParam2) {
            this.vamosExpansionParam = vamosExpansionParam2;
            return this;
        }

        public Builder sctxSearchGetter(SctxService.SctxSearchGetter sctxSearchGetter2) {
            this.sctxSearchGetter = sctxSearchGetter2;
            return this;
        }

        public Builder newVersion(boolean z) {
            this.newVersion = z;
            return this;
        }

        public Builder showRecommendPickupPoint(boolean z) {
            this.showRecommendPickupPoint = z;
            return this;
        }

        public Builder lineColor(int i) {
            this.lineColor = i;
            return this;
        }

        public Builder lineWidth(int i) {
            this.lineWidth = i;
            return this;
        }

        public Builder travelMode(TravelMode travelMode2) {
            this.travelMode = travelMode2;
            return this;
        }

        public Builder enableBluetoothNotify(boolean z) {
            this.bluetoothNotify = z;
            return this;
        }

        public Builder bizGroup(int i) {
            this.bizGroup = i;
            return this;
        }

        public Builder backgroundOra(boolean z) {
            this.backgroundOra = z;
            return this;
        }
    }

    public boolean isSameParam(SctxTripParam sctxTripParam) {
        if (sctxTripParam == this) {
            return true;
        }
        if (m19838a(this.f27665b, sctxTripParam.f27665b) && m19838a(this.f27664a, sctxTripParam.f27664a) && m19838a(this.f27667d, sctxTripParam.f27667d) && m19838a(this.f27673j, sctxTripParam.f27673j) && m19838a(this.f27674k, sctxTripParam.f27674k)) {
            VamosExpansionParam vamosExpansionParam = this.f27656B;
            LatLng latLng = null;
            LatLng latLng2 = vamosExpansionParam == null ? null : vamosExpansionParam.driverTripDestPoint;
            VamosExpansionParam vamosExpansionParam2 = sctxTripParam.f27656B;
            if (vamosExpansionParam2 != null) {
                latLng = vamosExpansionParam2.driverTripDestPoint;
            }
            if (!m19838a(latLng2, latLng) || !m19838a(Integer.valueOf(this.f27669f), Integer.valueOf(sctxTripParam.f27669f)) || !m19838a(Integer.valueOf(this.f27668e), Integer.valueOf(sctxTripParam.f27668e)) || !m19838a(this.f27666c, sctxTripParam.f27666c) || !m19838a(Long.valueOf(this.f27676m), Long.valueOf(sctxTripParam.f27676m)) || !m19838a(this.f27683t, sctxTripParam.f27683t) || !m19838a(this.f27675l, sctxTripParam.f27675l) || !m19838a(this.f27681r, sctxTripParam.f27681r) || !m19838a(this.f27678o, sctxTripParam.f27678o) || !m19838a(this.f27682s, sctxTripParam.f27682s) || !m19838a(this.f27677n, sctxTripParam.f27677n) || !m19838a(Boolean.valueOf(this.f27680q), Boolean.valueOf(sctxTripParam.f27680q)) || !m19838a(Long.valueOf(this.f27671h), Long.valueOf(sctxTripParam.f27671h)) || !m19838a(Boolean.valueOf(this.f27657C), Boolean.valueOf(sctxTripParam.f27657C)) || !m19838a(Boolean.valueOf(this.f27660F), Boolean.valueOf(sctxTripParam.f27660F)) || !m19838a(Integer.valueOf(this.f27658D), Integer.valueOf(sctxTripParam.f27658D)) || !m19838a(Integer.valueOf(this.f27659E), Integer.valueOf(sctxTripParam.f27659E)) || !m19838a(this.f27661G, sctxTripParam.f27661G) || !m19838a(Integer.valueOf(this.f27662H), Integer.valueOf(sctxTripParam.f27662H)) || this.f27663I != sctxTripParam.f27663I) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m19838a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }
}
