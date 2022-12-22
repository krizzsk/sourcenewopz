package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class EstimateInfo extends Message {
    public static final List<EstimatedPriceRoute> DEFAULT_ROUTE = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = EstimatedPriceRoute.class, tag = 1)
    public final List<EstimatedPriceRoute> route;

    public EstimateInfo(List<EstimatedPriceRoute> list) {
        this.route = immutableCopyOf(list);
    }

    private EstimateInfo(Builder builder) {
        this(builder.route);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EstimateInfo)) {
            return false;
        }
        return equals((List<?>) this.route, (List<?>) ((EstimateInfo) obj).route);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<EstimatedPriceRoute> list = this.route;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<EstimateInfo> {
        public List<EstimatedPriceRoute> route;

        public Builder() {
        }

        public Builder(EstimateInfo estimateInfo) {
            super(estimateInfo);
            if (estimateInfo != null) {
                this.route = EstimateInfo.copyOf(estimateInfo.route);
            }
        }

        public Builder route(List<EstimatedPriceRoute> list) {
            this.route = checkForNulls(list);
            return this;
        }

        public EstimateInfo build() {
            return new EstimateInfo(this);
        }
    }
}
