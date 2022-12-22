package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TypeTaxiDriverChargeReq extends Message {
    public static final Float DEFAULT_PASSENGER1_PRICE;
    public static final Float DEFAULT_PASSENGER2_PRICE;
    public static final Float DEFAULT_PRICE;
    public static final String DEFAULT_TRIPID = "";
    @ProtoField(tag = 3, type = Message.Datatype.FLOAT)
    public final Float passenger1_price;
    @ProtoField(tag = 4, type = Message.Datatype.FLOAT)
    public final Float passenger2_price;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.FLOAT)
    public final Float price;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String tripid;

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_PRICE = valueOf;
        DEFAULT_PASSENGER1_PRICE = valueOf;
        DEFAULT_PASSENGER2_PRICE = valueOf;
    }

    public TypeTaxiDriverChargeReq(String str, Float f, Float f2, Float f3) {
        this.tripid = str;
        this.price = f;
        this.passenger1_price = f2;
        this.passenger2_price = f3;
    }

    private TypeTaxiDriverChargeReq(Builder builder) {
        this(builder.tripid, builder.price, builder.passenger1_price, builder.passenger2_price);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TypeTaxiDriverChargeReq)) {
            return false;
        }
        TypeTaxiDriverChargeReq typeTaxiDriverChargeReq = (TypeTaxiDriverChargeReq) obj;
        if (!equals((Object) this.tripid, (Object) typeTaxiDriverChargeReq.tripid) || !equals((Object) this.price, (Object) typeTaxiDriverChargeReq.price) || !equals((Object) this.passenger1_price, (Object) typeTaxiDriverChargeReq.passenger1_price) || !equals((Object) this.passenger2_price, (Object) typeTaxiDriverChargeReq.passenger2_price)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.tripid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Float f = this.price;
        int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
        Float f2 = this.passenger1_price;
        int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.passenger2_price;
        if (f3 != null) {
            i2 = f3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TypeTaxiDriverChargeReq> {
        public Float passenger1_price;
        public Float passenger2_price;
        public Float price;
        public String tripid;

        public Builder() {
        }

        public Builder(TypeTaxiDriverChargeReq typeTaxiDriverChargeReq) {
            super(typeTaxiDriverChargeReq);
            if (typeTaxiDriverChargeReq != null) {
                this.tripid = typeTaxiDriverChargeReq.tripid;
                this.price = typeTaxiDriverChargeReq.price;
                this.passenger1_price = typeTaxiDriverChargeReq.passenger1_price;
                this.passenger2_price = typeTaxiDriverChargeReq.passenger2_price;
            }
        }

        public Builder tripid(String str) {
            this.tripid = str;
            return this;
        }

        public Builder price(Float f) {
            this.price = f;
            return this;
        }

        public Builder passenger1_price(Float f) {
            this.passenger1_price = f;
            return this;
        }

        public Builder passenger2_price(Float f) {
            this.passenger2_price = f;
            return this;
        }

        public TypeTaxiDriverChargeReq build() {
            checkRequiredFields();
            return new TypeTaxiDriverChargeReq(this);
        }
    }
}
