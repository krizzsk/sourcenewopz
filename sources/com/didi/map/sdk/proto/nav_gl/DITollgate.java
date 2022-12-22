package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DITollgate extends Message {
    public static final String DEFAULT_NAME = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DITollgate(MapRoutePoint mapRoutePoint, String str) {
        this.targetPos = mapRoutePoint;
        this.name = str;
    }

    private DITollgate(Builder builder) {
        this(builder.targetPos, builder.name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DITollgate)) {
            return false;
        }
        DITollgate dITollgate = (DITollgate) obj;
        if (!equals((Object) this.targetPos, (Object) dITollgate.targetPos) || !equals((Object) this.name, (Object) dITollgate.name)) {
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
        String str = this.name;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DITollgate> {
        public String name;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DITollgate dITollgate) {
            super(dITollgate);
            if (dITollgate != null) {
                this.targetPos = dITollgate.targetPos;
                this.name = dITollgate.name;
            }
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public DITollgate build() {
            checkRequiredFields();
            return new DITollgate(this);
        }
    }
}
