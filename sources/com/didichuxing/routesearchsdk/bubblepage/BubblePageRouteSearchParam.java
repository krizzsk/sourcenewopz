package com.didichuxing.routesearchsdk.bubblepage;

import com.didi.common.map.util.LatLngUtils;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.VisitorInfo;
import com.didi.soda.customer.app.constant.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001KB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010J\u001a\u0004\u0018\u00010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0012\"\u0004\b-\u0010\u0014R\u001e\u0010.\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b/\u0010\b\"\u0004\b0\u0010\nR\"\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00108\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R\u001c\u0010;\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0012\"\u0004\b=\u0010\u0014R\u001e\u0010>\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b?\u0010\b\"\u0004\b@\u0010\nR\u001c\u0010A\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010\u001dR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006L"}, mo175978d2 = {"Lcom/didichuxing/routesearchsdk/bubblepage/BubblePageRouteSearchParam;", "", "builder", "Lcom/didichuxing/routesearchsdk/bubblepage/BubblePageRouteSearchParam$Builder;", "(Lcom/didichuxing/routesearchsdk/bubblepage/BubblePageRouteSearchParam$Builder;)V", "bizGroup", "", "getBizGroup", "()Ljava/lang/Integer;", "setBizGroup", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bizType", "getBizType", "setBizType", "countryId", "", "getCountryId", "()Ljava/lang/String;", "setCountryId", "(Ljava/lang/String;)V", "endCityID", "getEndCityID", "setEndCityID", "endPoint", "Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "getEndPoint", "()Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "setEndPoint", "(Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;)V", "epfOrderType", "Lcom/didi/map/sdk/proto/driver_gl/EpfOrderType;", "getEpfOrderType", "()Lcom/didi/map/sdk/proto/driver_gl/EpfOrderType;", "setEpfOrderType", "(Lcom/didi/map/sdk/proto/driver_gl/EpfOrderType;)V", "estimateRouteID", "", "getEstimateRouteID", "()Ljava/lang/Long;", "setEstimateRouteID", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "lang", "getLang", "setLang", "needSingleRoute", "getNeedSingleRoute", "setNeedSingleRoute", "odPoints", "", "Lcom/didi/map/sdk/proto/driver_gl/OdPoint;", "getOdPoints", "()Ljava/util/List;", "setOdPoints", "(Ljava/util/List;)V", "passengerID", "getPassengerID", "setPassengerID", "productId", "getProductId", "setProductId", "startCityID", "getStartCityID", "setStartCityID", "startPoint", "getStartPoint", "setStartPoint", "visitorInfo", "Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;", "getVisitorInfo", "()Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;", "setVisitorInfo", "(Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;)V", "checkParam", "Builder", "RouteSearchSDK_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BubblePageRouteSearchParam.kt */
public final class BubblePageRouteSearchParam {

    /* renamed from: a */
    private VisitorInfo f48534a;

    /* renamed from: b */
    private Long f48535b;

    /* renamed from: c */
    private Long f48536c;

    /* renamed from: d */
    private Integer f48537d;

    /* renamed from: e */
    private Integer f48538e;

    /* renamed from: f */
    private Integer f48539f;

    /* renamed from: g */
    private Integer f48540g;

    /* renamed from: h */
    private String f48541h;

    /* renamed from: i */
    private EpfOrderType f48542i;

    /* renamed from: j */
    private Integer f48543j;

    /* renamed from: k */
    private String f48544k;

    /* renamed from: l */
    private String f48545l;

    /* renamed from: m */
    private DoublePoint f48546m;

    /* renamed from: n */
    private DoublePoint f48547n;

    /* renamed from: o */
    private List<OdPoint> f48548o;

    public final VisitorInfo getVisitorInfo() {
        return this.f48534a;
    }

    public final void setVisitorInfo(VisitorInfo visitorInfo) {
        this.f48534a = visitorInfo;
    }

    public final Long getEstimateRouteID() {
        return this.f48535b;
    }

    public final void setEstimateRouteID(Long l) {
        this.f48535b = l;
    }

    public final Long getPassengerID() {
        return this.f48536c;
    }

    public final void setPassengerID(Long l) {
        this.f48536c = l;
    }

    public final Integer getBizType() {
        return this.f48537d;
    }

    public final void setBizType(Integer num) {
        this.f48537d = num;
    }

    public final Integer getBizGroup() {
        return this.f48538e;
    }

    public final void setBizGroup(Integer num) {
        this.f48538e = num;
    }

    public final Integer getStartCityID() {
        return this.f48539f;
    }

    public final void setStartCityID(Integer num) {
        this.f48539f = num;
    }

    public final Integer getEndCityID() {
        return this.f48540g;
    }

    public final void setEndCityID(Integer num) {
        this.f48540g = num;
    }

    public final String getLang() {
        return this.f48541h;
    }

    public final void setLang(String str) {
        this.f48541h = str;
    }

    public final EpfOrderType getEpfOrderType() {
        return this.f48542i;
    }

    public final void setEpfOrderType(EpfOrderType epfOrderType) {
        this.f48542i = epfOrderType;
    }

    public final Integer getNeedSingleRoute() {
        return this.f48543j;
    }

    public final void setNeedSingleRoute(Integer num) {
        this.f48543j = num;
    }

    public final String getProductId() {
        return this.f48544k;
    }

    public final void setProductId(String str) {
        this.f48544k = str;
    }

    public final String getCountryId() {
        return this.f48545l;
    }

    public final void setCountryId(String str) {
        this.f48545l = str;
    }

    public final DoublePoint getStartPoint() {
        return this.f48546m;
    }

    public final void setStartPoint(DoublePoint doublePoint) {
        this.f48546m = doublePoint;
    }

    public final DoublePoint getEndPoint() {
        return this.f48547n;
    }

    public final void setEndPoint(DoublePoint doublePoint) {
        this.f48547n = doublePoint;
    }

    public final List<OdPoint> getOdPoints() {
        return this.f48548o;
    }

    public final void setOdPoints(List<OdPoint> list) {
        this.f48548o = list;
    }

    public BubblePageRouteSearchParam(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f48534a = builder.getVisitorInfo();
        this.f48535b = builder.getEstimateRouteID();
        this.f48536c = builder.getPassengerID();
        this.f48537d = builder.getBizType();
        this.f48539f = builder.getStartCityID();
        this.f48540g = builder.getEndCityID();
        this.f48541h = builder.getLang();
        this.f48542i = builder.getEpfOrderType();
        this.f48543j = builder.getNeedSingleRoute();
        this.f48544k = builder.getProductId();
        this.f48545l = builder.getCountryId();
        this.f48546m = builder.getStartPoint();
        this.f48547n = builder.getEndPoint();
        this.f48548o = builder.getOdPoints();
        this.f48538e = builder.getBizGroup();
    }

    public final String checkParam() {
        DoublePoint doublePoint = this.f48546m;
        if (doublePoint == null) {
            return "startLat";
        }
        Intrinsics.checkNotNull(doublePoint);
        Double d = doublePoint.dlat;
        Intrinsics.checkNotNullExpressionValue(d, "startPoint!!.dlat");
        double doubleValue = d.doubleValue();
        DoublePoint doublePoint2 = this.f48546m;
        Intrinsics.checkNotNull(doublePoint2);
        Double d2 = doublePoint2.dlng;
        Intrinsics.checkNotNullExpressionValue(d2, "startPoint!!.dlng");
        if (!LatLngUtils.locateCorrect(doubleValue, d2.doubleValue())) {
            return "startLat";
        }
        DoublePoint doublePoint3 = this.f48547n;
        if (doublePoint3 == null) {
            return "endLat";
        }
        Intrinsics.checkNotNull(doublePoint3);
        Double d3 = doublePoint3.dlat;
        Intrinsics.checkNotNullExpressionValue(d3, "endPoint!!.dlat");
        double doubleValue2 = d3.doubleValue();
        DoublePoint doublePoint4 = this.f48547n;
        Intrinsics.checkNotNull(doublePoint4);
        Double d4 = doublePoint4.dlng;
        Intrinsics.checkNotNullExpressionValue(d4, "endPoint!!.dlng");
        if (!LatLngUtils.locateCorrect(doubleValue2, d4.doubleValue())) {
            return "endLat";
        }
        return null;
    }

    @Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010H\u001a\u00020IJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0004J\u0014\u0010/\u001a\u00020\u00002\f\u0010J\u001a\b\u0012\u0004\u0012\u00020100J\u000e\u00106\u001a\u00020\u00002\u0006\u00106\u001a\u00020#J\u000e\u00109\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u000eJ\u000e\u0010<\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0017J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010B\u001a\u00020CR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R\u001e\u0010,\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\"\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b7\u0010%\"\u0004\b8\u0010'R\u001c\u00109\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0010\"\u0004\b;\u0010\u0012R\u001e\u0010<\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001c\u0010?\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0019\"\u0004\bA\u0010\u001bR\u001c\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006K"}, mo175978d2 = {"Lcom/didichuxing/routesearchsdk/bubblepage/BubblePageRouteSearchParam$Builder;", "", "()V", "bizGroup", "", "getBizGroup", "()Ljava/lang/Integer;", "setBizGroup", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bizType", "getBizType", "setBizType", "countryId", "", "getCountryId", "()Ljava/lang/String;", "setCountryId", "(Ljava/lang/String;)V", "endCityID", "getEndCityID", "setEndCityID", "endPoint", "Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "getEndPoint", "()Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "setEndPoint", "(Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;)V", "epfOrderType", "Lcom/didi/map/sdk/proto/driver_gl/EpfOrderType;", "getEpfOrderType", "()Lcom/didi/map/sdk/proto/driver_gl/EpfOrderType;", "setEpfOrderType", "(Lcom/didi/map/sdk/proto/driver_gl/EpfOrderType;)V", "estimateRouteID", "", "getEstimateRouteID", "()Ljava/lang/Long;", "setEstimateRouteID", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "lang", "getLang", "setLang", "needSingleRoute", "getNeedSingleRoute", "setNeedSingleRoute", "odPoints", "", "Lcom/didi/map/sdk/proto/driver_gl/OdPoint;", "getOdPoints", "()Ljava/util/List;", "setOdPoints", "(Ljava/util/List;)V", "passengerID", "getPassengerID", "setPassengerID", "productId", "getProductId", "setProductId", "startCityID", "getStartCityID", "setStartCityID", "startPoint", "getStartPoint", "setStartPoint", "visitorInfo", "Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;", "getVisitorInfo", "()Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;", "setVisitorInfo", "(Lcom/didi/map/sdk/proto/driver_gl/VisitorInfo;)V", "build", "Lcom/didichuxing/routesearchsdk/bubblepage/BubblePageRouteSearchParam;", "odPoint", "RouteSearchSDK_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BubblePageRouteSearchParam.kt */
    public static final class Builder {
        private Integer bizGroup;
        private Integer bizType;
        private String countryId;
        private Integer endCityID;
        private DoublePoint endPoint;
        private EpfOrderType epfOrderType;
        private Long estimateRouteID;
        private String lang;
        private Integer needSingleRoute;
        private List<OdPoint> odPoints;
        private Long passengerID;
        private String productId;
        private Integer startCityID;
        private DoublePoint startPoint;
        private VisitorInfo visitorInfo;

        public final VisitorInfo getVisitorInfo() {
            return this.visitorInfo;
        }

        public final void setVisitorInfo(VisitorInfo visitorInfo2) {
            this.visitorInfo = visitorInfo2;
        }

        public final Long getEstimateRouteID() {
            return this.estimateRouteID;
        }

        public final void setEstimateRouteID(Long l) {
            this.estimateRouteID = l;
        }

        public final Long getPassengerID() {
            return this.passengerID;
        }

        public final void setPassengerID(Long l) {
            this.passengerID = l;
        }

        public final Integer getBizType() {
            return this.bizType;
        }

        public final void setBizType(Integer num) {
            this.bizType = num;
        }

        public final Integer getStartCityID() {
            return this.startCityID;
        }

        public final void setStartCityID(Integer num) {
            this.startCityID = num;
        }

        public final Integer getEndCityID() {
            return this.endCityID;
        }

        public final void setEndCityID(Integer num) {
            this.endCityID = num;
        }

        public final String getLang() {
            return this.lang;
        }

        public final void setLang(String str) {
            this.lang = str;
        }

        public final EpfOrderType getEpfOrderType() {
            return this.epfOrderType;
        }

        public final void setEpfOrderType(EpfOrderType epfOrderType2) {
            this.epfOrderType = epfOrderType2;
        }

        public final Integer getNeedSingleRoute() {
            return this.needSingleRoute;
        }

        public final void setNeedSingleRoute(Integer num) {
            this.needSingleRoute = num;
        }

        public final String getProductId() {
            return this.productId;
        }

        public final void setProductId(String str) {
            this.productId = str;
        }

        public final String getCountryId() {
            return this.countryId;
        }

        public final void setCountryId(String str) {
            this.countryId = str;
        }

        public final DoublePoint getStartPoint() {
            return this.startPoint;
        }

        public final void setStartPoint(DoublePoint doublePoint) {
            this.startPoint = doublePoint;
        }

        public final DoublePoint getEndPoint() {
            return this.endPoint;
        }

        public final void setEndPoint(DoublePoint doublePoint) {
            this.endPoint = doublePoint;
        }

        public final List<OdPoint> getOdPoints() {
            return this.odPoints;
        }

        public final void setOdPoints(List<OdPoint> list) {
            this.odPoints = list;
        }

        public final Integer getBizGroup() {
            return this.bizGroup;
        }

        public final void setBizGroup(Integer num) {
            this.bizGroup = num;
        }

        public final Builder visitorInfo(VisitorInfo visitorInfo2) {
            Intrinsics.checkNotNullParameter(visitorInfo2, "visitorInfo");
            this.visitorInfo = visitorInfo2;
            return this;
        }

        public final Builder bizGroup(int i) {
            this.bizGroup = Integer.valueOf(i);
            return this;
        }

        public final Builder estimateRouteID(long j) {
            this.estimateRouteID = Long.valueOf(j);
            return this;
        }

        public final Builder passengerID(long j) {
            this.passengerID = Long.valueOf(j);
            return this;
        }

        public final Builder bizType(int i) {
            this.bizType = Integer.valueOf(i);
            return this;
        }

        public final Builder startCityID(int i) {
            this.startCityID = Integer.valueOf(i);
            return this;
        }

        public final Builder endCityID(int i) {
            this.endCityID = Integer.valueOf(i);
            return this;
        }

        public final Builder lang(String str) {
            Intrinsics.checkNotNullParameter(str, "lang");
            this.lang = str;
            return this;
        }

        public final Builder epfOrderType(EpfOrderType epfOrderType2) {
            Intrinsics.checkNotNullParameter(epfOrderType2, "epfOrderType");
            this.epfOrderType = epfOrderType2;
            return this;
        }

        public final Builder needSingleRoute(int i) {
            this.needSingleRoute = Integer.valueOf(i);
            return this;
        }

        public final Builder productId(String str) {
            Intrinsics.checkNotNullParameter(str, "productId");
            this.productId = str;
            return this;
        }

        public final Builder countryId(String str) {
            Intrinsics.checkNotNullParameter(str, Const.H5Params.COUNTRYID);
            this.countryId = str;
            return this;
        }

        public final Builder startPoint(DoublePoint doublePoint) {
            Intrinsics.checkNotNullParameter(doublePoint, "startPoint");
            this.startPoint = doublePoint;
            return this;
        }

        public final Builder endPoint(DoublePoint doublePoint) {
            Intrinsics.checkNotNullParameter(doublePoint, "endPoint");
            this.endPoint = doublePoint;
            return this;
        }

        public final Builder odPoints(List<OdPoint> list) {
            Intrinsics.checkNotNullParameter(list, "odPoint");
            this.odPoints = this.odPoints;
            return this;
        }

        public final BubblePageRouteSearchParam build() {
            return new BubblePageRouteSearchParam(this);
        }
    }
}
