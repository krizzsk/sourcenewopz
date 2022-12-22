package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.DoublePoint */
public final class DoublePoint extends Message {
    public static final Double DEFAULT_DLAT;
    public static final Double DEFAULT_DLNG;
    public static final Float DEFAULT_LAT;
    public static final Float DEFAULT_LNG;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double dlat;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double dlng;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.FLOAT)
    public final Float lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.FLOAT)
    public final Float lng;

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_LAT = valueOf;
        DEFAULT_LNG = valueOf;
        Double valueOf2 = Double.valueOf(0.0d);
        DEFAULT_DLNG = valueOf2;
        DEFAULT_DLAT = valueOf2;
    }

    public DoublePoint(Float f, Float f2, Double d, Double d2) {
        this.lat = f;
        this.lng = f2;
        this.dlng = d;
        this.dlat = d2;
    }

    private DoublePoint(Builder builder) {
        this(builder.lat, builder.lng, builder.dlng, builder.dlat);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DoublePoint)) {
            return false;
        }
        DoublePoint doublePoint = (DoublePoint) obj;
        if (!equals((Object) this.lat, (Object) doublePoint.lat) || !equals((Object) this.lng, (Object) doublePoint.lng) || !equals((Object) this.dlng, (Object) doublePoint.dlng) || !equals((Object) this.dlat, (Object) doublePoint.dlat)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Float f = this.lat;
        int i2 = 0;
        int hashCode = (f != null ? f.hashCode() : 0) * 37;
        Float f2 = this.lng;
        int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
        Double d = this.dlng;
        int hashCode3 = (hashCode2 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.dlat;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.DoublePoint$Builder */
    public static final class Builder extends Message.Builder<DoublePoint> {
        public Double dlat;
        public Double dlng;
        public Float lat;
        public Float lng;

        public Builder() {
        }

        public Builder(DoublePoint doublePoint) {
            super(doublePoint);
            if (doublePoint != null) {
                this.lat = doublePoint.lat;
                this.lng = doublePoint.lng;
                this.dlng = doublePoint.dlng;
                this.dlat = doublePoint.dlat;
            }
        }

        public Builder lat(Float f) {
            this.lat = f;
            return this;
        }

        public Builder lng(Float f) {
            this.lng = f;
            return this;
        }

        public Builder dlng(Double d) {
            this.dlng = d;
            return this;
        }

        public Builder dlat(Double d) {
            this.dlat = d;
            return this;
        }

        public DoublePoint build() {
            checkRequiredFields();
            return new DoublePoint(this);
        }
    }
}
