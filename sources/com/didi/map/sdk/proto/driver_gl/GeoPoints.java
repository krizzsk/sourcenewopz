package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GeoPoints extends Message {
    public static final List<Int32Point> DEFAULT_GEOS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = Int32Point.class, tag = 1)
    public final List<Int32Point> geos;

    public GeoPoints(List<Int32Point> list) {
        this.geos = immutableCopyOf(list);
    }

    private GeoPoints(Builder builder) {
        this(builder.geos);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoPoints)) {
            return false;
        }
        return equals((List<?>) this.geos, (List<?>) ((GeoPoints) obj).geos);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<Int32Point> list = this.geos;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<GeoPoints> {
        public List<Int32Point> geos;

        public Builder() {
        }

        public Builder(GeoPoints geoPoints) {
            super(geoPoints);
            if (geoPoints != null) {
                this.geos = GeoPoints.copyOf(geoPoints.geos);
            }
        }

        public Builder geos(List<Int32Point> list) {
            this.geos = checkForNulls(list);
            return this;
        }

        public GeoPoints build() {
            return new GeoPoints(this);
        }
    }
}
