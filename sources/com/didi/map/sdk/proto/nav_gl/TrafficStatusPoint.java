package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrafficStatusPoint extends Message {
    public static final Integer DEFAULT_ID = 0;
    public static final String DEFAULT_MSG = "";
    public static final TrafficPointKindEnum DEFAULT_POINTKIND = TrafficPointKindEnum.TPK_Slow;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT32)

    /* renamed from: id */
    public final Integer f28610id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.ENUM)
    public final TrafficPointKindEnum pointKind;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MapRoutePoint targetPos;

    public TrafficStatusPoint(TrafficPointKindEnum trafficPointKindEnum, MapRoutePoint mapRoutePoint, Integer num, String str) {
        this.pointKind = trafficPointKindEnum;
        this.targetPos = mapRoutePoint;
        this.f28610id = num;
        this.msg = str;
    }

    private TrafficStatusPoint(Builder builder) {
        this(builder.pointKind, builder.targetPos, builder.f28611id, builder.msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficStatusPoint)) {
            return false;
        }
        TrafficStatusPoint trafficStatusPoint = (TrafficStatusPoint) obj;
        if (!equals((Object) this.pointKind, (Object) trafficStatusPoint.pointKind) || !equals((Object) this.targetPos, (Object) trafficStatusPoint.targetPos) || !equals((Object) this.f28610id, (Object) trafficStatusPoint.f28610id) || !equals((Object) this.msg, (Object) trafficStatusPoint.msg)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        TrafficPointKindEnum trafficPointKindEnum = this.pointKind;
        int i2 = 0;
        int hashCode = (trafficPointKindEnum != null ? trafficPointKindEnum.hashCode() : 0) * 37;
        MapRoutePoint mapRoutePoint = this.targetPos;
        int hashCode2 = (hashCode + (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0)) * 37;
        Integer num = this.f28610id;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.msg;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrafficStatusPoint> {

        /* renamed from: id */
        public Integer f28611id;
        public String msg;
        public TrafficPointKindEnum pointKind;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(TrafficStatusPoint trafficStatusPoint) {
            super(trafficStatusPoint);
            if (trafficStatusPoint != null) {
                this.pointKind = trafficStatusPoint.pointKind;
                this.targetPos = trafficStatusPoint.targetPos;
                this.f28611id = trafficStatusPoint.f28610id;
                this.msg = trafficStatusPoint.msg;
            }
        }

        public Builder pointKind(TrafficPointKindEnum trafficPointKindEnum) {
            this.pointKind = trafficPointKindEnum;
            return this;
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        /* renamed from: id */
        public Builder mo79210id(Integer num) {
            this.f28611id = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public TrafficStatusPoint build() {
            checkRequiredFields();
            return new TrafficStatusPoint(this);
        }
    }
}
