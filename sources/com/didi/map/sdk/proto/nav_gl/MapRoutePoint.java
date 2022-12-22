package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class MapRoutePoint extends Message {
    public static final Integer DEFAULT_COORIDX = 0;
    public static final Integer DEFAULT_SHAPEOFFSET = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer coorIdx;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3)
    public final GeoPoint geoPoint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT32)
    public final Integer shapeOffset;

    public MapRoutePoint(Integer num, Integer num2, GeoPoint geoPoint2) {
        this.coorIdx = num;
        this.shapeOffset = num2;
        this.geoPoint = geoPoint2;
    }

    private MapRoutePoint(Builder builder) {
        this(builder.coorIdx, builder.shapeOffset, builder.geoPoint);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapRoutePoint)) {
            return false;
        }
        MapRoutePoint mapRoutePoint = (MapRoutePoint) obj;
        if (!equals((Object) this.coorIdx, (Object) mapRoutePoint.coorIdx) || !equals((Object) this.shapeOffset, (Object) mapRoutePoint.shapeOffset) || !equals((Object) this.geoPoint, (Object) mapRoutePoint.geoPoint)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.coorIdx;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shapeOffset;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        GeoPoint geoPoint2 = this.geoPoint;
        if (geoPoint2 != null) {
            i2 = geoPoint2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MapRoutePoint> {
        public Integer coorIdx;
        public GeoPoint geoPoint;
        public Integer shapeOffset;

        public Builder() {
        }

        public Builder(MapRoutePoint mapRoutePoint) {
            super(mapRoutePoint);
            if (mapRoutePoint != null) {
                this.coorIdx = mapRoutePoint.coorIdx;
                this.shapeOffset = mapRoutePoint.shapeOffset;
                this.geoPoint = mapRoutePoint.geoPoint;
            }
        }

        public Builder coorIdx(Integer num) {
            this.coorIdx = num;
            return this;
        }

        public Builder shapeOffset(Integer num) {
            this.shapeOffset = num;
            return this;
        }

        public Builder geoPoint(GeoPoint geoPoint2) {
            this.geoPoint = geoPoint2;
            return this;
        }

        public MapRoutePoint build() {
            checkRequiredFields();
            return new MapRoutePoint(this);
        }
    }
}
