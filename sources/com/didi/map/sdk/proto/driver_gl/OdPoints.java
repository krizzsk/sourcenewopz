package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class OdPoints extends Message {
    public static final List<OdPoint> DEFAULT_POINTS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 1)
    public final List<OdPoint> points;

    public OdPoints(List<OdPoint> list) {
        this.points = immutableCopyOf(list);
    }

    private OdPoints(Builder builder) {
        this(builder.points);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OdPoints)) {
            return false;
        }
        return equals((List<?>) this.points, (List<?>) ((OdPoints) obj).points);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<OdPoint> list = this.points;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<OdPoints> {
        public List<OdPoint> points;

        public Builder() {
        }

        public Builder(OdPoints odPoints) {
            super(odPoints);
            if (odPoints != null) {
                this.points = OdPoints.copyOf(odPoints.points);
            }
        }

        public Builder points(List<OdPoint> list) {
            this.points = checkForNulls(list);
            return this;
        }

        public OdPoints build() {
            return new OdPoints(this);
        }
    }
}
