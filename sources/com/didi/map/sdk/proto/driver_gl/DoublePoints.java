package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DoublePoints extends Message {
    public static final List<DoublePoint> DEFAULT_POINTS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = DoublePoint.class, tag = 1)
    public final List<DoublePoint> points;

    public DoublePoints(List<DoublePoint> list) {
        this.points = immutableCopyOf(list);
    }

    private DoublePoints(Builder builder) {
        this(builder.points);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DoublePoints)) {
            return false;
        }
        return equals((List<?>) this.points, (List<?>) ((DoublePoints) obj).points);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<DoublePoint> list = this.points;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<DoublePoints> {
        public List<DoublePoint> points;

        public Builder() {
        }

        public Builder(DoublePoints doublePoints) {
            super(doublePoints);
            if (doublePoints != null) {
                this.points = DoublePoints.copyOf(doublePoints.points);
            }
        }

        public Builder points(List<DoublePoint> list) {
            this.points = checkForNulls(list);
            return this;
        }

        public DoublePoints build() {
            return new DoublePoints(this);
        }
    }
}
