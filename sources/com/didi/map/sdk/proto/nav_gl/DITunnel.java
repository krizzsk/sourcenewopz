package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DITunnel extends Message {
    public static final Integer DEFAULT_LENGTH = 0;
    public static final String DEFAULT_NAME = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT32)
    public final Integer length;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DITunnel(MapRoutePoint mapRoutePoint, String str, Integer num) {
        this.targetPos = mapRoutePoint;
        this.name = str;
        this.length = num;
    }

    private DITunnel(Builder builder) {
        this(builder.targetPos, builder.name, builder.length);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DITunnel)) {
            return false;
        }
        DITunnel dITunnel = (DITunnel) obj;
        if (!equals((Object) this.targetPos, (Object) dITunnel.targetPos) || !equals((Object) this.name, (Object) dITunnel.name) || !equals((Object) this.length, (Object) dITunnel.length)) {
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
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.length;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DITunnel> {
        public Integer length;
        public String name;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DITunnel dITunnel) {
            super(dITunnel);
            if (dITunnel != null) {
                this.targetPos = dITunnel.targetPos;
                this.name = dITunnel.name;
                this.length = dITunnel.length;
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

        public Builder length(Integer num) {
            this.length = num;
            return this;
        }

        public DITunnel build() {
            checkRequiredFields();
            return new DITunnel(this);
        }
    }
}
