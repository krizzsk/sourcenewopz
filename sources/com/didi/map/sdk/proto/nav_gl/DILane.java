package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DILane extends Message {
    public static final String DEFAULT_ARROW = "";
    public static final String DEFAULT_FLAG = "";
    public static final String DEFAULT_PROPERTY = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String arrow;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String flag;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String property;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DILane(MapRoutePoint mapRoutePoint, String str, String str2, String str3) {
        this.targetPos = mapRoutePoint;
        this.flag = str;
        this.arrow = str2;
        this.property = str3;
    }

    private DILane(Builder builder) {
        this(builder.targetPos, builder.flag, builder.arrow, builder.property);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DILane)) {
            return false;
        }
        DILane dILane = (DILane) obj;
        if (!equals((Object) this.targetPos, (Object) dILane.targetPos) || !equals((Object) this.flag, (Object) dILane.flag) || !equals((Object) this.arrow, (Object) dILane.arrow) || !equals((Object) this.property, (Object) dILane.property)) {
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
        String str = this.flag;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.arrow;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.property;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DILane> {
        public String arrow;
        public String flag;
        public String property;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DILane dILane) {
            super(dILane);
            if (dILane != null) {
                this.targetPos = dILane.targetPos;
                this.flag = dILane.flag;
                this.arrow = dILane.arrow;
                this.property = dILane.property;
            }
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        public Builder flag(String str) {
            this.flag = str;
            return this;
        }

        public Builder arrow(String str) {
            this.arrow = str;
            return this;
        }

        public Builder property(String str) {
            this.property = str;
            return this;
        }

        public DILane build() {
            checkRequiredFields();
            return new DILane(this);
        }
    }
}
