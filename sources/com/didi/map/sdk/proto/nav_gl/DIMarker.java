package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DIMarker extends Message {
    public static final String DEFAULT_MSG = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DIMarker(MapRoutePoint mapRoutePoint, String str) {
        this.targetPos = mapRoutePoint;
        this.msg = str;
    }

    private DIMarker(Builder builder) {
        this(builder.targetPos, builder.msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DIMarker)) {
            return false;
        }
        DIMarker dIMarker = (DIMarker) obj;
        if (!equals((Object) this.targetPos, (Object) dIMarker.targetPos) || !equals((Object) this.msg, (Object) dIMarker.msg)) {
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
        String str = this.msg;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DIMarker> {
        public String msg;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DIMarker dIMarker) {
            super(dIMarker);
            if (dIMarker != null) {
                this.targetPos = dIMarker.targetPos;
                this.msg = dIMarker.msg;
            }
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public DIMarker build() {
            checkRequiredFields();
            return new DIMarker(this);
        }
    }
}
