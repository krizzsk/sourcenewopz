package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DISA extends Message {
    public static final Boolean DEFAULT_HASNEXTSA = false;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NEXTNAME = "";
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean hasNextSa;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String nextName;
    @ProtoField(tag = 4)
    public final MapRoutePoint nextTargetPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DISA(MapRoutePoint mapRoutePoint, String str, Boolean bool, MapRoutePoint mapRoutePoint2, String str2) {
        this.targetPos = mapRoutePoint;
        this.name = str;
        this.hasNextSa = bool;
        this.nextTargetPos = mapRoutePoint2;
        this.nextName = str2;
    }

    private DISA(Builder builder) {
        this(builder.targetPos, builder.name, builder.hasNextSa, builder.nextTargetPos, builder.nextName);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DISA)) {
            return false;
        }
        DISA disa = (DISA) obj;
        if (!equals((Object) this.targetPos, (Object) disa.targetPos) || !equals((Object) this.name, (Object) disa.name) || !equals((Object) this.hasNextSa, (Object) disa.hasNextSa) || !equals((Object) this.nextTargetPos, (Object) disa.nextTargetPos) || !equals((Object) this.nextName, (Object) disa.nextName)) {
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
        Boolean bool = this.hasNextSa;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        MapRoutePoint mapRoutePoint2 = this.nextTargetPos;
        int hashCode4 = (hashCode3 + (mapRoutePoint2 != null ? mapRoutePoint2.hashCode() : 0)) * 37;
        String str2 = this.nextName;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DISA> {
        public Boolean hasNextSa;
        public String name;
        public String nextName;
        public MapRoutePoint nextTargetPos;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DISA disa) {
            super(disa);
            if (disa != null) {
                this.targetPos = disa.targetPos;
                this.name = disa.name;
                this.hasNextSa = disa.hasNextSa;
                this.nextTargetPos = disa.nextTargetPos;
                this.nextName = disa.nextName;
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

        public Builder hasNextSa(Boolean bool) {
            this.hasNextSa = bool;
            return this;
        }

        public Builder nextTargetPos(MapRoutePoint mapRoutePoint) {
            this.nextTargetPos = mapRoutePoint;
            return this;
        }

        public Builder nextName(String str) {
            this.nextName = str;
            return this;
        }

        public DISA build() {
            checkRequiredFields();
            return new DISA(this);
        }
    }
}
