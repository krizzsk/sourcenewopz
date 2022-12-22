package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TypeTaxiPassengerChargeReq extends Message {
    public static final String DEFAULT_DESC = "";
    public static final String DEFAULT_OID = "";
    public static final Float DEFAULT_PRICE = Float.valueOf(0.0f);
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String desc;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.FLOAT)
    public final Float price;

    public TypeTaxiPassengerChargeReq(String str, Float f, String str2) {
        this.oid = str;
        this.price = f;
        this.desc = str2;
    }

    private TypeTaxiPassengerChargeReq(Builder builder) {
        this(builder.oid, builder.price, builder.desc);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TypeTaxiPassengerChargeReq)) {
            return false;
        }
        TypeTaxiPassengerChargeReq typeTaxiPassengerChargeReq = (TypeTaxiPassengerChargeReq) obj;
        if (!equals((Object) this.oid, (Object) typeTaxiPassengerChargeReq.oid) || !equals((Object) this.price, (Object) typeTaxiPassengerChargeReq.price) || !equals((Object) this.desc, (Object) typeTaxiPassengerChargeReq.desc)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.oid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Float f = this.price;
        int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
        String str2 = this.desc;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TypeTaxiPassengerChargeReq> {
        public String desc;
        public String oid;
        public Float price;

        public Builder() {
        }

        public Builder(TypeTaxiPassengerChargeReq typeTaxiPassengerChargeReq) {
            super(typeTaxiPassengerChargeReq);
            if (typeTaxiPassengerChargeReq != null) {
                this.oid = typeTaxiPassengerChargeReq.oid;
                this.price = typeTaxiPassengerChargeReq.price;
                this.desc = typeTaxiPassengerChargeReq.desc;
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder price(Float f) {
            this.price = f;
            return this;
        }

        public Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public TypeTaxiPassengerChargeReq build() {
            checkRequiredFields();
            return new TypeTaxiPassengerChargeReq(this);
        }
    }
}
