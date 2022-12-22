package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DILimitSpeedSection extends Message {
    public static final Integer DEFAULT_LIMITSPEEDVALUE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint beginPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MapRoutePoint endPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT32)
    public final Integer limitSpeedValue;

    public DILimitSpeedSection(MapRoutePoint mapRoutePoint, MapRoutePoint mapRoutePoint2, Integer num) {
        this.beginPos = mapRoutePoint;
        this.endPos = mapRoutePoint2;
        this.limitSpeedValue = num;
    }

    private DILimitSpeedSection(Builder builder) {
        this(builder.beginPos, builder.endPos, builder.limitSpeedValue);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DILimitSpeedSection)) {
            return false;
        }
        DILimitSpeedSection dILimitSpeedSection = (DILimitSpeedSection) obj;
        if (!equals((Object) this.beginPos, (Object) dILimitSpeedSection.beginPos) || !equals((Object) this.endPos, (Object) dILimitSpeedSection.endPos) || !equals((Object) this.limitSpeedValue, (Object) dILimitSpeedSection.limitSpeedValue)) {
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
        int hashCode2 = (hashCode + (mapRoutePoint2 != null ? mapRoutePoint2.hashCode() : 0)) * 37;
        Integer num = this.limitSpeedValue;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DILimitSpeedSection> {
        public MapRoutePoint beginPos;
        public MapRoutePoint endPos;
        public Integer limitSpeedValue;

        public Builder() {
        }

        public Builder(DILimitSpeedSection dILimitSpeedSection) {
            super(dILimitSpeedSection);
            if (dILimitSpeedSection != null) {
                this.beginPos = dILimitSpeedSection.beginPos;
                this.endPos = dILimitSpeedSection.endPos;
                this.limitSpeedValue = dILimitSpeedSection.limitSpeedValue;
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

        public Builder limitSpeedValue(Integer num) {
            this.limitSpeedValue = num;
            return this;
        }

        public DILimitSpeedSection build() {
            checkRequiredFields();
            return new DILimitSpeedSection(this);
        }
    }
}
