package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GeoRect extends Message {
    public static final Integer DEFAULT_BOTTOMLAT = 0;
    public static final Integer DEFAULT_LEFTLNG = 0;
    public static final Integer DEFAULT_RIGHTLNG = 0;
    public static final Integer DEFAULT_TOPLAT = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer bottomLat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer leftLng;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer rightLng;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer topLat;

    public GeoRect(Integer num, Integer num2, Integer num3, Integer num4) {
        this.leftLng = num;
        this.topLat = num2;
        this.rightLng = num3;
        this.bottomLat = num4;
    }

    private GeoRect(Builder builder) {
        this(builder.leftLng, builder.topLat, builder.rightLng, builder.bottomLat);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoRect)) {
            return false;
        }
        GeoRect geoRect = (GeoRect) obj;
        if (!equals((Object) this.leftLng, (Object) geoRect.leftLng) || !equals((Object) this.topLat, (Object) geoRect.topLat) || !equals((Object) this.rightLng, (Object) geoRect.rightLng) || !equals((Object) this.bottomLat, (Object) geoRect.bottomLat)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.leftLng;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.topLat;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.rightLng;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.bottomLat;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GeoRect> {
        public Integer bottomLat;
        public Integer leftLng;
        public Integer rightLng;
        public Integer topLat;

        public Builder() {
        }

        public Builder(GeoRect geoRect) {
            super(geoRect);
            if (geoRect != null) {
                this.leftLng = geoRect.leftLng;
                this.topLat = geoRect.topLat;
                this.rightLng = geoRect.rightLng;
                this.bottomLat = geoRect.bottomLat;
            }
        }

        public Builder leftLng(Integer num) {
            this.leftLng = num;
            return this;
        }

        public Builder topLat(Integer num) {
            this.topLat = num;
            return this;
        }

        public Builder rightLng(Integer num) {
            this.rightLng = num;
            return this;
        }

        public Builder bottomLat(Integer num) {
            this.bottomLat = num;
            return this;
        }

        public GeoRect build() {
            checkRequiredFields();
            return new GeoRect(this);
        }
    }
}
