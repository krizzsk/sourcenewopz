package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DynamicRouteReq extends Message {
    public static final Integer DEFAULT_BACKGROUND = -1;
    public static final Boolean DEFAULT_ISFORCEROUTE = false;
    public static final Long DEFAULT_ROUTEID = 0L;
    public static final Integer DEFAULT_SEGMENTINDEX = 0;
    public static final String DEFAULT_STATUS = "";
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer background;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final DoublePoint curPoint;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean isForceRoute;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long routeid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer segmentIndex;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String status;

    public DynamicRouteReq(DoublePoint doublePoint, Long l, Integer num, Boolean bool, String str, Integer num2) {
        this.curPoint = doublePoint;
        this.routeid = l;
        this.segmentIndex = num;
        this.isForceRoute = bool;
        this.status = str;
        this.background = num2;
    }

    private DynamicRouteReq(Builder builder) {
        this(builder.curPoint, builder.routeid, builder.segmentIndex, builder.isForceRoute, builder.status, builder.background);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DynamicRouteReq)) {
            return false;
        }
        DynamicRouteReq dynamicRouteReq = (DynamicRouteReq) obj;
        if (!equals((Object) this.curPoint, (Object) dynamicRouteReq.curPoint) || !equals((Object) this.routeid, (Object) dynamicRouteReq.routeid) || !equals((Object) this.segmentIndex, (Object) dynamicRouteReq.segmentIndex) || !equals((Object) this.isForceRoute, (Object) dynamicRouteReq.isForceRoute) || !equals((Object) this.status, (Object) dynamicRouteReq.status) || !equals((Object) this.background, (Object) dynamicRouteReq.background)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DoublePoint doublePoint = this.curPoint;
        int i2 = 0;
        int hashCode = (doublePoint != null ? doublePoint.hashCode() : 0) * 37;
        Long l = this.routeid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.segmentIndex;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.isForceRoute;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.status;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.background;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DynamicRouteReq> {
        public Integer background;
        public DoublePoint curPoint;
        public Boolean isForceRoute;
        public Long routeid;
        public Integer segmentIndex;
        public String status;

        public Builder() {
        }

        public Builder(DynamicRouteReq dynamicRouteReq) {
            super(dynamicRouteReq);
            if (dynamicRouteReq != null) {
                this.curPoint = dynamicRouteReq.curPoint;
                this.routeid = dynamicRouteReq.routeid;
                this.segmentIndex = dynamicRouteReq.segmentIndex;
                this.isForceRoute = dynamicRouteReq.isForceRoute;
                this.status = dynamicRouteReq.status;
                this.background = dynamicRouteReq.background;
            }
        }

        public Builder curPoint(DoublePoint doublePoint) {
            this.curPoint = doublePoint;
            return this;
        }

        public Builder routeid(Long l) {
            this.routeid = l;
            return this;
        }

        public Builder segmentIndex(Integer num) {
            this.segmentIndex = num;
            return this;
        }

        public Builder isForceRoute(Boolean bool) {
            this.isForceRoute = bool;
            return this;
        }

        public Builder status(String str) {
            this.status = str;
            return this;
        }

        public Builder background(Integer num) {
            this.background = num;
            return this;
        }

        public DynamicRouteReq build() {
            checkRequiredFields();
            return new DynamicRouteReq(this);
        }
    }
}
