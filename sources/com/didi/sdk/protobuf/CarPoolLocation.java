package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CarPoolLocation extends Message {
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final String DEFAULT_OID = "";
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double Lat;
    @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
    public final Double Lng;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LNG = valueOf;
        DEFAULT_LAT = valueOf;
    }

    public CarPoolLocation(Double d, Double d2, String str, Integer num) {
        this.Lng = d;
        this.Lat = d2;
        this.oid = str;
        this.type = num;
    }

    private CarPoolLocation(Builder builder) {
        this(builder.Lng, builder.Lat, builder.oid, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CarPoolLocation)) {
            return false;
        }
        CarPoolLocation carPoolLocation = (CarPoolLocation) obj;
        if (!equals((Object) this.Lng, (Object) carPoolLocation.Lng) || !equals((Object) this.Lat, (Object) carPoolLocation.Lat) || !equals((Object) this.oid, (Object) carPoolLocation.oid) || !equals((Object) this.type, (Object) carPoolLocation.type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.Lng;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.Lat;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        String str = this.oid;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CarPoolLocation> {
        public Double Lat;
        public Double Lng;
        public String oid;
        public Integer type;

        public Builder() {
        }

        public Builder(CarPoolLocation carPoolLocation) {
            super(carPoolLocation);
            if (carPoolLocation != null) {
                this.Lng = carPoolLocation.Lng;
                this.Lat = carPoolLocation.Lat;
                this.oid = carPoolLocation.oid;
                this.type = carPoolLocation.type;
            }
        }

        public Builder Lng(Double d) {
            this.Lng = d;
            return this;
        }

        public Builder Lat(Double d) {
            this.Lat = d;
            return this;
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public CarPoolLocation build() {
            return new CarPoolLocation(this);
        }
    }
}
