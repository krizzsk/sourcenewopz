package com.didi.soda.customer.biz.sliding.p163pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.soda.customer.biz.sliding.pb.LocPoint */
public final class LocPoint extends Message {
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)
    public final Double lng;

    public LocPoint(Double d, Double d2) {
        this.lat = d;
        this.lng = d2;
    }

    private LocPoint(Builder builder) {
        this(builder.lat, builder.lng);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocPoint)) {
            return false;
        }
        LocPoint locPoint = (LocPoint) obj;
        if (!equals((Object) this.lat, (Object) locPoint.lat) || !equals((Object) this.lng, (Object) locPoint.lng)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.lat;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.lng;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.soda.customer.biz.sliding.pb.LocPoint$Builder */
    public static final class Builder extends Message.Builder<LocPoint> {
        public Double lat;
        public Double lng;

        public Builder() {
        }

        public Builder(LocPoint locPoint) {
            super(locPoint);
            if (locPoint != null) {
                this.lat = locPoint.lat;
                this.lng = locPoint.lng;
            }
        }

        public LocPoint build() {
            checkRequiredFields();
            return new LocPoint(this);
        }

        public Builder lat(Double d) {
            this.lat = d;
            return this;
        }

        public Builder lng(Double d) {
            this.lng = d;
            return this;
        }
    }
}
