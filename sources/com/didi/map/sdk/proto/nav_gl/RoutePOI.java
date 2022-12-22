package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RoutePOI extends Message {
    public static final String DEFAULT_ADDR = "";
    public static final String DEFAULT_NAME = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String addr;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final GeoPoint geoPoint;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;

    public RoutePOI(GeoPoint geoPoint2, String str, String str2) {
        this.geoPoint = geoPoint2;
        this.addr = str;
        this.name = str2;
    }

    private RoutePOI(Builder builder) {
        this(builder.geoPoint, builder.addr, builder.name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoutePOI)) {
            return false;
        }
        RoutePOI routePOI = (RoutePOI) obj;
        if (!equals((Object) this.geoPoint, (Object) routePOI.geoPoint) || !equals((Object) this.addr, (Object) routePOI.addr) || !equals((Object) this.name, (Object) routePOI.name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        GeoPoint geoPoint2 = this.geoPoint;
        int i2 = 0;
        int hashCode = (geoPoint2 != null ? geoPoint2.hashCode() : 0) * 37;
        String str = this.addr;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RoutePOI> {
        public String addr;
        public GeoPoint geoPoint;
        public String name;

        public Builder() {
        }

        public Builder(RoutePOI routePOI) {
            super(routePOI);
            if (routePOI != null) {
                this.geoPoint = routePOI.geoPoint;
                this.addr = routePOI.addr;
                this.name = routePOI.name;
            }
        }

        public Builder geoPoint(GeoPoint geoPoint2) {
            this.geoPoint = geoPoint2;
            return this;
        }

        public Builder addr(String str) {
            this.addr = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public RoutePOI build() {
            checkRequiredFields();
            return new RoutePOI(this);
        }
    }
}
