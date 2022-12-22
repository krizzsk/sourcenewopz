package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class MapRouteSection extends Message {
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint beginPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MapRoutePoint endPos;

    public MapRouteSection(MapRoutePoint mapRoutePoint, MapRoutePoint mapRoutePoint2) {
        this.beginPos = mapRoutePoint;
        this.endPos = mapRoutePoint2;
    }

    private MapRouteSection(Builder builder) {
        this(builder.beginPos, builder.endPos);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapRouteSection)) {
            return false;
        }
        MapRouteSection mapRouteSection = (MapRouteSection) obj;
        if (!equals((Object) this.beginPos, (Object) mapRouteSection.beginPos) || !equals((Object) this.endPos, (Object) mapRouteSection.endPos)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        MapRoutePoint mapRoutePoint = this.beginPos;
        int i2 = 0;
        int hashCode = (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0) * 37;
        MapRoutePoint mapRoutePoint2 = this.endPos;
        if (mapRoutePoint2 != null) {
            i2 = mapRoutePoint2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MapRouteSection> {
        public MapRoutePoint beginPos;
        public MapRoutePoint endPos;

        public Builder() {
        }

        public Builder(MapRouteSection mapRouteSection) {
            super(mapRouteSection);
            if (mapRouteSection != null) {
                this.beginPos = mapRouteSection.beginPos;
                this.endPos = mapRouteSection.endPos;
            }
        }

        public Builder beginPos(MapRoutePoint mapRoutePoint) {
            this.beginPos = mapRoutePoint;
            return this;
        }

        public Builder endPos(MapRoutePoint mapRoutePoint) {
            this.endPos = mapRoutePoint;
            return this;
        }

        public MapRouteSection build() {
            checkRequiredFields();
            return new MapRouteSection(this);
        }
    }
}
