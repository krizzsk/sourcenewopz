package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BubblePageReq extends Message {
    public static final Integer DEFAULT_BIZGROUP = 0;
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final String DEFAULT_COUNTRYID = "";
    public static final Integer DEFAULT_ENDCITYID = 0;
    public static final Long DEFAULT_ESTIMATEROUTEID = 0L;
    public static final String DEFAULT_LANG = "";
    public static final Integer DEFAULT_NEEDSINGLEROUTE = 0;
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final EpfOrderType DEFAULT_ORDERTYPE = EpfOrderType.NormalType;
    public static final Long DEFAULT_PASSENGERID = 0L;
    public static final String DEFAULT_PRODUCTID = "";
    public static final Integer DEFAULT_STARTCITYID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer NeedSingleRoute;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer bizGroup;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer bizType;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String countryId;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer endCityID;
    @ProtoField(tag = 13)
    public final DoublePoint endPoint;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long estimateRouteID;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 14)
    public final List<OdPoint> odPoints;
    @ProtoField(tag = 8, type = Message.Datatype.ENUM)
    public final EpfOrderType orderType;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long passengerID;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String productId;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer startCityID;
    @ProtoField(tag = 12)
    public final DoublePoint startPoint;
    @ProtoField(tag = 1)
    public final VisitorInfo visitorInfo;

    public BubblePageReq(VisitorInfo visitorInfo2, Long l, Long l2, Integer num, Integer num2, Integer num3, String str, EpfOrderType epfOrderType, Integer num4, String str2, String str3, DoublePoint doublePoint, DoublePoint doublePoint2, List<OdPoint> list, Integer num5) {
        this.visitorInfo = visitorInfo2;
        this.estimateRouteID = l;
        this.passengerID = l2;
        this.bizType = num;
        this.startCityID = num2;
        this.endCityID = num3;
        this.lang = str;
        this.orderType = epfOrderType;
        this.NeedSingleRoute = num4;
        this.productId = str2;
        this.countryId = str3;
        this.startPoint = doublePoint;
        this.endPoint = doublePoint2;
        this.odPoints = immutableCopyOf(list);
        this.bizGroup = num5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private BubblePageReq(com.didi.map.sdk.proto.driver_gl.BubblePageReq.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            com.didi.map.sdk.proto.driver_gl.VisitorInfo r2 = r0.visitorInfo
            java.lang.Long r3 = r0.estimateRouteID
            java.lang.Long r4 = r0.passengerID
            java.lang.Integer r5 = r0.bizType
            java.lang.Integer r6 = r0.startCityID
            java.lang.Integer r7 = r0.endCityID
            java.lang.String r8 = r0.lang
            com.didi.map.sdk.proto.driver_gl.EpfOrderType r9 = r0.orderType
            java.lang.Integer r10 = r0.NeedSingleRoute
            java.lang.String r11 = r0.productId
            java.lang.String r12 = r0.countryId
            com.didi.map.sdk.proto.driver_gl.DoublePoint r13 = r0.startPoint
            com.didi.map.sdk.proto.driver_gl.DoublePoint r14 = r0.endPoint
            java.util.List<com.didi.map.sdk.proto.driver_gl.OdPoint> r15 = r0.odPoints
            java.lang.Integer r1 = r0.bizGroup
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.driver_gl.BubblePageReq.<init>(com.didi.map.sdk.proto.driver_gl.BubblePageReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BubblePageReq)) {
            return false;
        }
        BubblePageReq bubblePageReq = (BubblePageReq) obj;
        if (!equals((Object) this.visitorInfo, (Object) bubblePageReq.visitorInfo) || !equals((Object) this.estimateRouteID, (Object) bubblePageReq.estimateRouteID) || !equals((Object) this.passengerID, (Object) bubblePageReq.passengerID) || !equals((Object) this.bizType, (Object) bubblePageReq.bizType) || !equals((Object) this.startCityID, (Object) bubblePageReq.startCityID) || !equals((Object) this.endCityID, (Object) bubblePageReq.endCityID) || !equals((Object) this.lang, (Object) bubblePageReq.lang) || !equals((Object) this.orderType, (Object) bubblePageReq.orderType) || !equals((Object) this.NeedSingleRoute, (Object) bubblePageReq.NeedSingleRoute) || !equals((Object) this.productId, (Object) bubblePageReq.productId) || !equals((Object) this.countryId, (Object) bubblePageReq.countryId) || !equals((Object) this.startPoint, (Object) bubblePageReq.startPoint) || !equals((Object) this.endPoint, (Object) bubblePageReq.endPoint) || !equals((List<?>) this.odPoints, (List<?>) bubblePageReq.odPoints) || !equals((Object) this.bizGroup, (Object) bubblePageReq.bizGroup)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        VisitorInfo visitorInfo2 = this.visitorInfo;
        int i2 = 0;
        int hashCode = (visitorInfo2 != null ? visitorInfo2.hashCode() : 0) * 37;
        Long l = this.estimateRouteID;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.passengerID;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.bizType;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.startCityID;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.endCityID;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.lang;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        EpfOrderType epfOrderType = this.orderType;
        int hashCode8 = (hashCode7 + (epfOrderType != null ? epfOrderType.hashCode() : 0)) * 37;
        Integer num4 = this.NeedSingleRoute;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.productId;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.countryId;
        int hashCode11 = (hashCode10 + (str3 != null ? str3.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.startPoint;
        int hashCode12 = (hashCode11 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        DoublePoint doublePoint2 = this.endPoint;
        int hashCode13 = (hashCode12 + (doublePoint2 != null ? doublePoint2.hashCode() : 0)) * 37;
        List<OdPoint> list = this.odPoints;
        int hashCode14 = (hashCode13 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num5 = this.bizGroup;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode14 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BubblePageReq> {
        public Integer NeedSingleRoute;
        public Integer bizGroup;
        public Integer bizType;
        public String countryId;
        public Integer endCityID;
        public DoublePoint endPoint;
        public Long estimateRouteID;
        public String lang;
        public List<OdPoint> odPoints;
        public EpfOrderType orderType;
        public Long passengerID;
        public String productId;
        public Integer startCityID;
        public DoublePoint startPoint;
        public VisitorInfo visitorInfo;

        public Builder() {
        }

        public Builder(BubblePageReq bubblePageReq) {
            super(bubblePageReq);
            if (bubblePageReq != null) {
                this.visitorInfo = bubblePageReq.visitorInfo;
                this.estimateRouteID = bubblePageReq.estimateRouteID;
                this.passengerID = bubblePageReq.passengerID;
                this.bizType = bubblePageReq.bizType;
                this.startCityID = bubblePageReq.startCityID;
                this.endCityID = bubblePageReq.endCityID;
                this.lang = bubblePageReq.lang;
                this.orderType = bubblePageReq.orderType;
                this.NeedSingleRoute = bubblePageReq.NeedSingleRoute;
                this.productId = bubblePageReq.productId;
                this.countryId = bubblePageReq.countryId;
                this.startPoint = bubblePageReq.startPoint;
                this.endPoint = bubblePageReq.endPoint;
                this.odPoints = BubblePageReq.copyOf(bubblePageReq.odPoints);
                this.bizGroup = bubblePageReq.bizGroup;
            }
        }

        public Builder visitorInfo(VisitorInfo visitorInfo2) {
            this.visitorInfo = visitorInfo2;
            return this;
        }

        public Builder estimateRouteID(Long l) {
            this.estimateRouteID = l;
            return this;
        }

        public Builder passengerID(Long l) {
            this.passengerID = l;
            return this;
        }

        public Builder bizType(Integer num) {
            this.bizType = num;
            return this;
        }

        public Builder startCityID(Integer num) {
            this.startCityID = num;
            return this;
        }

        public Builder endCityID(Integer num) {
            this.endCityID = num;
            return this;
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public Builder orderType(EpfOrderType epfOrderType) {
            this.orderType = epfOrderType;
            return this;
        }

        public Builder NeedSingleRoute(Integer num) {
            this.NeedSingleRoute = num;
            return this;
        }

        public Builder productId(String str) {
            this.productId = str;
            return this;
        }

        public Builder countryId(String str) {
            this.countryId = str;
            return this;
        }

        public Builder startPoint(DoublePoint doublePoint) {
            this.startPoint = doublePoint;
            return this;
        }

        public Builder endPoint(DoublePoint doublePoint) {
            this.endPoint = doublePoint;
            return this;
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
            return this;
        }

        public Builder bizGroup(Integer num) {
            this.bizGroup = num;
            return this;
        }

        public BubblePageReq build() {
            return new BubblePageReq(this);
        }
    }
}
