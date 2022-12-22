package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OdPoint extends Message {
    public static final Integer DEFAULT_CIRCLEINDEX = -1;
    public static final String DEFAULT_CRMEXTENDPARAMS = "";
    public static final Integer DEFAULT_ODTYPE = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_POINTTYPE = 0;
    public static final Float DEFAULT_RADIUS_M = Float.valueOf(0.0f);
    public static final String DEFAULT_STRORDERID = "";
    @ProtoField(tag = 8)
    public final DoublePoint circleCenter;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer circleIndex;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String crmExtendParams;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer odType;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderId;
    @ProtoField(tag = 3)
    public final DoublePoint point;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer pointType;
    @ProtoField(tag = 6, type = Message.Datatype.FLOAT)
    public final Float radius_m;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String strOrderId;

    public OdPoint(Long l, Integer num, DoublePoint doublePoint, String str, Integer num2, Float f, Integer num3, DoublePoint doublePoint2, String str2) {
        this.orderId = l;
        this.odType = num;
        this.point = doublePoint;
        this.strOrderId = str;
        this.pointType = num2;
        this.radius_m = f;
        this.circleIndex = num3;
        this.circleCenter = doublePoint2;
        this.crmExtendParams = str2;
    }

    private OdPoint(Builder builder) {
        this(builder.orderId, builder.odType, builder.point, builder.strOrderId, builder.pointType, builder.radius_m, builder.circleIndex, builder.circleCenter, builder.crmExtendParams);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OdPoint)) {
            return false;
        }
        OdPoint odPoint = (OdPoint) obj;
        if (!equals((Object) this.orderId, (Object) odPoint.orderId) || !equals((Object) this.odType, (Object) odPoint.odType) || !equals((Object) this.point, (Object) odPoint.point) || !equals((Object) this.strOrderId, (Object) odPoint.strOrderId) || !equals((Object) this.pointType, (Object) odPoint.pointType) || !equals((Object) this.radius_m, (Object) odPoint.radius_m) || !equals((Object) this.circleIndex, (Object) odPoint.circleIndex) || !equals((Object) this.circleCenter, (Object) odPoint.circleCenter) || !equals((Object) this.crmExtendParams, (Object) odPoint.crmExtendParams)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.orderId;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.odType;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.point;
        int hashCode3 = (hashCode2 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        String str = this.strOrderId;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.pointType;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Float f = this.radius_m;
        int hashCode6 = (hashCode5 + (f != null ? f.hashCode() : 0)) * 37;
        Integer num3 = this.circleIndex;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        DoublePoint doublePoint2 = this.circleCenter;
        int hashCode8 = (hashCode7 + (doublePoint2 != null ? doublePoint2.hashCode() : 0)) * 37;
        String str2 = this.crmExtendParams;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OdPoint> {
        public DoublePoint circleCenter;
        public Integer circleIndex;
        public String crmExtendParams;
        public Integer odType;
        public Long orderId;
        public DoublePoint point;
        public Integer pointType;
        public Float radius_m;
        public String strOrderId;

        public Builder() {
        }

        public Builder(OdPoint odPoint) {
            super(odPoint);
            if (odPoint != null) {
                this.orderId = odPoint.orderId;
                this.odType = odPoint.odType;
                this.point = odPoint.point;
                this.strOrderId = odPoint.strOrderId;
                this.pointType = odPoint.pointType;
                this.radius_m = odPoint.radius_m;
                this.circleIndex = odPoint.circleIndex;
                this.circleCenter = odPoint.circleCenter;
                this.crmExtendParams = odPoint.crmExtendParams;
            }
        }

        public Builder orderId(Long l) {
            this.orderId = l;
            return this;
        }

        public Builder odType(Integer num) {
            this.odType = num;
            return this;
        }

        public Builder point(DoublePoint doublePoint) {
            this.point = doublePoint;
            return this;
        }

        public Builder strOrderId(String str) {
            this.strOrderId = str;
            return this;
        }

        public Builder pointType(Integer num) {
            this.pointType = num;
            return this;
        }

        public Builder radius_m(Float f) {
            this.radius_m = f;
            return this;
        }

        public Builder circleIndex(Integer num) {
            this.circleIndex = num;
            return this;
        }

        public Builder circleCenter(DoublePoint doublePoint) {
            this.circleCenter = doublePoint;
            return this;
        }

        public Builder crmExtendParams(String str) {
            this.crmExtendParams = str;
            return this;
        }

        public OdPoint build() {
            return new OdPoint(this);
        }
    }
}
