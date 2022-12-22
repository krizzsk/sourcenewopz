package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RoutePlanRes extends Message {
    public static final Boolean DEFAULT_BEYONDPICKUP = false;
    public static final Integer DEFAULT_DISTANCE = -1;
    public static final Integer DEFAULT_ETA = -1;
    public static final List<LegInfo> DEFAULT_LEGSINFO = Collections.emptyList();
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final Integer DEFAULT_PARKING = 0;
    public static final Integer DEFAULT_RET = 0;
    public static final List<DiffGeoPoints> DEFAULT_ROUTEGEOS = Collections.emptyList();
    public static final List<TrafficItem> DEFAULT_TRAFFIC = Collections.emptyList();
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean beyondPickup;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer distance;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(label = Message.Label.REPEATED, messageType = LegInfo.class, tag = 8)
    public final List<LegInfo> legsInfo;
    @ProtoField(tag = 11, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 6)
    public final List<OdPoint> odPoints;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer parking;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(deprecated = true, label = Message.Label.REPEATED, messageType = DiffGeoPoints.class, tag = 3)
    @Deprecated
    public final List<DiffGeoPoints> routeGeos;
    @ProtoField(deprecated = true, label = Message.Label.REPEATED, messageType = TrafficItem.class, tag = 7)
    @Deprecated
    public final List<TrafficItem> traffic;

    public RoutePlanRes(Integer num, String str, List<DiffGeoPoints> list, Integer num2, Integer num3, List<OdPoint> list2, List<TrafficItem> list3, List<LegInfo> list4, Integer num4, Boolean bool, Long l) {
        this.ret = num;
        this.msg = str;
        this.routeGeos = immutableCopyOf(list);
        this.eta = num2;
        this.distance = num3;
        this.odPoints = immutableCopyOf(list2);
        this.traffic = immutableCopyOf(list3);
        this.legsInfo = immutableCopyOf(list4);
        this.parking = num4;
        this.beyondPickup = bool;
        this.logId = l;
    }

    private RoutePlanRes(Builder builder) {
        this(builder.ret, builder.msg, builder.routeGeos, builder.eta, builder.distance, builder.odPoints, builder.traffic, builder.legsInfo, builder.parking, builder.beyondPickup, builder.logId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoutePlanRes)) {
            return false;
        }
        RoutePlanRes routePlanRes = (RoutePlanRes) obj;
        if (!equals((Object) this.ret, (Object) routePlanRes.ret) || !equals((Object) this.msg, (Object) routePlanRes.msg) || !equals((List<?>) this.routeGeos, (List<?>) routePlanRes.routeGeos) || !equals((Object) this.eta, (Object) routePlanRes.eta) || !equals((Object) this.distance, (Object) routePlanRes.distance) || !equals((List<?>) this.odPoints, (List<?>) routePlanRes.odPoints) || !equals((List<?>) this.traffic, (List<?>) routePlanRes.traffic) || !equals((List<?>) this.legsInfo, (List<?>) routePlanRes.legsInfo) || !equals((Object) this.parking, (Object) routePlanRes.parking) || !equals((Object) this.beyondPickup, (Object) routePlanRes.beyondPickup) || !equals((Object) this.logId, (Object) routePlanRes.logId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ret;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        List<DiffGeoPoints> list = this.routeGeos;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.eta;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.distance;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        List<OdPoint> list2 = this.odPoints;
        int hashCode6 = (hashCode5 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<TrafficItem> list3 = this.traffic;
        int hashCode7 = (hashCode6 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<LegInfo> list4 = this.legsInfo;
        if (list4 != null) {
            i3 = list4.hashCode();
        }
        int i4 = (hashCode7 + i3) * 37;
        Integer num4 = this.parking;
        int hashCode8 = (i4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool = this.beyondPickup;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l = this.logId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i5 = hashCode9 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<RoutePlanRes> {
        public Boolean beyondPickup;
        public Integer distance;
        public Integer eta;
        public List<LegInfo> legsInfo;
        public Long logId;
        public String msg;
        public List<OdPoint> odPoints;
        public Integer parking;
        public Integer ret;
        public List<DiffGeoPoints> routeGeos;
        public List<TrafficItem> traffic;

        public Builder() {
        }

        public Builder(RoutePlanRes routePlanRes) {
            super(routePlanRes);
            if (routePlanRes != null) {
                this.ret = routePlanRes.ret;
                this.msg = routePlanRes.msg;
                this.routeGeos = RoutePlanRes.copyOf(routePlanRes.routeGeos);
                this.eta = routePlanRes.eta;
                this.distance = routePlanRes.distance;
                this.odPoints = RoutePlanRes.copyOf(routePlanRes.odPoints);
                this.traffic = RoutePlanRes.copyOf(routePlanRes.traffic);
                this.legsInfo = RoutePlanRes.copyOf(routePlanRes.legsInfo);
                this.parking = routePlanRes.parking;
                this.beyondPickup = routePlanRes.beyondPickup;
                this.logId = routePlanRes.logId;
            }
        }

        public Builder ret(Integer num) {
            this.ret = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        @Deprecated
        public Builder routeGeos(List<DiffGeoPoints> list) {
            this.routeGeos = checkForNulls(list);
            return this;
        }

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public Builder distance(Integer num) {
            this.distance = num;
            return this;
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
            return this;
        }

        @Deprecated
        public Builder traffic(List<TrafficItem> list) {
            this.traffic = checkForNulls(list);
            return this;
        }

        public Builder legsInfo(List<LegInfo> list) {
            this.legsInfo = checkForNulls(list);
            return this;
        }

        public Builder parking(Integer num) {
            this.parking = num;
            return this;
        }

        public Builder beyondPickup(Boolean bool) {
            this.beyondPickup = bool;
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public RoutePlanRes build() {
            checkRequiredFields();
            return new RoutePlanRes(this);
        }
    }
}
