package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DebugDriverLoc extends Message {
    public static final Integer DEFAULT_DIRECTION = 0;
    public static final Long DEFAULT_LINKID = 0L;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer direction;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long linkId;
    @ProtoField(tag = 1)
    public final DoublePoint point;

    public DebugDriverLoc(DoublePoint doublePoint, Integer num, Long l) {
        this.point = doublePoint;
        this.direction = num;
        this.linkId = l;
    }

    private DebugDriverLoc(Builder builder) {
        this(builder.point, builder.direction, builder.linkId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DebugDriverLoc)) {
            return false;
        }
        DebugDriverLoc debugDriverLoc = (DebugDriverLoc) obj;
        if (!equals((Object) this.point, (Object) debugDriverLoc.point) || !equals((Object) this.direction, (Object) debugDriverLoc.direction) || !equals((Object) this.linkId, (Object) debugDriverLoc.linkId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DoublePoint doublePoint = this.point;
        int i2 = 0;
        int hashCode = (doublePoint != null ? doublePoint.hashCode() : 0) * 37;
        Integer num = this.direction;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.linkId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DebugDriverLoc> {
        public Integer direction;
        public Long linkId;
        public DoublePoint point;

        public Builder() {
        }

        public Builder(DebugDriverLoc debugDriverLoc) {
            super(debugDriverLoc);
            if (debugDriverLoc != null) {
                this.point = debugDriverLoc.point;
                this.direction = debugDriverLoc.direction;
                this.linkId = debugDriverLoc.linkId;
            }
        }

        public Builder point(DoublePoint doublePoint) {
            this.point = doublePoint;
            return this;
        }

        public Builder direction(Integer num) {
            this.direction = num;
            return this;
        }

        public Builder linkId(Long l) {
            this.linkId = l;
            return this;
        }

        public DebugDriverLoc build() {
            return new DebugDriverLoc(this);
        }
    }
}
