package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DIDestination extends Message {
    public static final Integer DEFAULT_DESTNO = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer destNo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DIDestination(MapRoutePoint mapRoutePoint, Integer num) {
        this.targetPos = mapRoutePoint;
        this.destNo = num;
    }

    private DIDestination(Builder builder) {
        this(builder.targetPos, builder.destNo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DIDestination)) {
            return false;
        }
        DIDestination dIDestination = (DIDestination) obj;
        if (!equals((Object) this.targetPos, (Object) dIDestination.targetPos) || !equals((Object) this.destNo, (Object) dIDestination.destNo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        MapRoutePoint mapRoutePoint = this.targetPos;
        int i2 = 0;
        int hashCode = (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0) * 37;
        Integer num = this.destNo;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DIDestination> {
        public Integer destNo;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DIDestination dIDestination) {
            super(dIDestination);
            if (dIDestination != null) {
                this.targetPos = dIDestination.targetPos;
                this.destNo = dIDestination.destNo;
            }
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        public Builder destNo(Integer num) {
            this.destNo = num;
            return this;
        }

        public DIDestination build() {
            checkRequiredFields();
            return new DIDestination(this);
        }
    }
}
