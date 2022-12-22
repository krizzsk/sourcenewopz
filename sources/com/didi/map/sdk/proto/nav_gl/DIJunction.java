package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DIJunction extends Message {
    public static final JunctionKindEnum DEFAULT_KIND = JunctionKindEnum.JunctionKind_Left;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.ENUM)
    public final JunctionKindEnum kind;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DIJunction(MapRoutePoint mapRoutePoint, JunctionKindEnum junctionKindEnum) {
        this.targetPos = mapRoutePoint;
        this.kind = junctionKindEnum;
    }

    private DIJunction(Builder builder) {
        this(builder.targetPos, builder.kind);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DIJunction)) {
            return false;
        }
        DIJunction dIJunction = (DIJunction) obj;
        if (!equals((Object) this.targetPos, (Object) dIJunction.targetPos) || !equals((Object) this.kind, (Object) dIJunction.kind)) {
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
        JunctionKindEnum junctionKindEnum = this.kind;
        if (junctionKindEnum != null) {
            i2 = junctionKindEnum.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DIJunction> {
        public JunctionKindEnum kind;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DIJunction dIJunction) {
            super(dIJunction);
            if (dIJunction != null) {
                this.targetPos = dIJunction.targetPos;
                this.kind = dIJunction.kind;
            }
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        public Builder kind(JunctionKindEnum junctionKindEnum) {
            this.kind = junctionKindEnum;
            return this;
        }

        public DIJunction build() {
            checkRequiredFields();
            return new DIJunction(this);
        }
    }
}
