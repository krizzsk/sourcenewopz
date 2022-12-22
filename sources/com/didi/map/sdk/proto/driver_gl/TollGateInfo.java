package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TollGateInfo extends Message {
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final DoublePoint point;

    public TollGateInfo(DoublePoint doublePoint) {
        this.point = doublePoint;
    }

    private TollGateInfo(Builder builder) {
        this(builder.point);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TollGateInfo)) {
            return false;
        }
        return equals((Object) this.point, (Object) ((TollGateInfo) obj).point);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            DoublePoint doublePoint = this.point;
            i = doublePoint != null ? doublePoint.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<TollGateInfo> {
        public DoublePoint point;

        public Builder() {
        }

        public Builder(TollGateInfo tollGateInfo) {
            super(tollGateInfo);
            if (tollGateInfo != null) {
                this.point = tollGateInfo.point;
            }
        }

        public Builder point(DoublePoint doublePoint) {
            this.point = doublePoint;
            return this;
        }

        public TollGateInfo build() {
            checkRequiredFields();
            return new TollGateInfo(this);
        }
    }
}
