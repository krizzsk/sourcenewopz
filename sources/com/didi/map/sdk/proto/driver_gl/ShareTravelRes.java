package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ShareTravelRes extends Message {
    public static final Integer DEFAULT_DIRECTION = 0;
    public static final Integer DEFAULT_DISTANCE = -1;
    public static final Long DEFAULT_DRVLOCTIMESTAMP = 0L;
    public static final Integer DEFAULT_ETA = -1;
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final Integer DEFAULT_RET = 0;
    public static final Long DEFAULT_ROUTEID = 0L;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer direction;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer distance;
    @ProtoField(tag = 6)
    public final DoublePoint driverPoint;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long drvLocTimestamp;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 8)
    public final List<OdPoint> odPoints;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long routeId;
    @ProtoField(tag = 9)
    public final DiffGeoPoints routePoints;

    public ShareTravelRes(Integer num, String str, Long l, Integer num2, Integer num3, DoublePoint doublePoint, Integer num4, List<OdPoint> list, DiffGeoPoints diffGeoPoints, Long l2, Long l3) {
        this.ret = num;
        this.msg = str;
        this.logId = l;
        this.eta = num2;
        this.distance = num3;
        this.driverPoint = doublePoint;
        this.direction = num4;
        this.odPoints = immutableCopyOf(list);
        this.routePoints = diffGeoPoints;
        this.routeId = l2;
        this.drvLocTimestamp = l3;
    }

    private ShareTravelRes(Builder builder) {
        this(builder.ret, builder.msg, builder.logId, builder.eta, builder.distance, builder.driverPoint, builder.direction, builder.odPoints, builder.routePoints, builder.routeId, builder.drvLocTimestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShareTravelRes)) {
            return false;
        }
        ShareTravelRes shareTravelRes = (ShareTravelRes) obj;
        if (!equals((Object) this.ret, (Object) shareTravelRes.ret) || !equals((Object) this.msg, (Object) shareTravelRes.msg) || !equals((Object) this.logId, (Object) shareTravelRes.logId) || !equals((Object) this.eta, (Object) shareTravelRes.eta) || !equals((Object) this.distance, (Object) shareTravelRes.distance) || !equals((Object) this.driverPoint, (Object) shareTravelRes.driverPoint) || !equals((Object) this.direction, (Object) shareTravelRes.direction) || !equals((List<?>) this.odPoints, (List<?>) shareTravelRes.odPoints) || !equals((Object) this.routePoints, (Object) shareTravelRes.routePoints) || !equals((Object) this.routeId, (Object) shareTravelRes.routeId) || !equals((Object) this.drvLocTimestamp, (Object) shareTravelRes.drvLocTimestamp)) {
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
        Long l = this.logId;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.eta;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.distance;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.driverPoint;
        int hashCode6 = (hashCode5 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Integer num4 = this.direction;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        List<OdPoint> list = this.odPoints;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 1)) * 37;
        DiffGeoPoints diffGeoPoints = this.routePoints;
        int hashCode9 = (hashCode8 + (diffGeoPoints != null ? diffGeoPoints.hashCode() : 0)) * 37;
        Long l2 = this.routeId;
        int hashCode10 = (hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.drvLocTimestamp;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShareTravelRes> {
        public Integer direction;
        public Integer distance;
        public DoublePoint driverPoint;
        public Long drvLocTimestamp;
        public Integer eta;
        public Long logId;
        public String msg;
        public List<OdPoint> odPoints;
        public Integer ret;
        public Long routeId;
        public DiffGeoPoints routePoints;

        public Builder() {
        }

        public Builder(ShareTravelRes shareTravelRes) {
            super(shareTravelRes);
            if (shareTravelRes != null) {
                this.ret = shareTravelRes.ret;
                this.msg = shareTravelRes.msg;
                this.logId = shareTravelRes.logId;
                this.eta = shareTravelRes.eta;
                this.distance = shareTravelRes.distance;
                this.driverPoint = shareTravelRes.driverPoint;
                this.direction = shareTravelRes.direction;
                this.odPoints = ShareTravelRes.copyOf(shareTravelRes.odPoints);
                this.routePoints = shareTravelRes.routePoints;
                this.routeId = shareTravelRes.routeId;
                this.drvLocTimestamp = shareTravelRes.drvLocTimestamp;
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

        public Builder logId(Long l) {
            this.logId = l;
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

        public Builder driverPoint(DoublePoint doublePoint) {
            this.driverPoint = doublePoint;
            return this;
        }

        public Builder direction(Integer num) {
            this.direction = num;
            return this;
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
            return this;
        }

        public Builder routePoints(DiffGeoPoints diffGeoPoints) {
            this.routePoints = diffGeoPoints;
            return this;
        }

        public Builder routeId(Long l) {
            this.routeId = l;
            return this;
        }

        public Builder drvLocTimestamp(Long l) {
            this.drvLocTimestamp = l;
            return this;
        }

        public ShareTravelRes build() {
            checkRequiredFields();
            return new ShareTravelRes(this);
        }
    }
}
