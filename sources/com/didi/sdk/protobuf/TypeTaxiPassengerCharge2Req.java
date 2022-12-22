package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TypeTaxiPassengerCharge2Req extends Message {
    public static final List<TypeTaxiChargeItem> DEFAULT_ITEM = Collections.emptyList();
    public static final String DEFAULT_OID = "";
    @ProtoField(label = Message.Label.REPEATED, messageType = TypeTaxiChargeItem.class, tag = 2)
    public final List<TypeTaxiChargeItem> item;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;

    public TypeTaxiPassengerCharge2Req(String str, List<TypeTaxiChargeItem> list) {
        this.oid = str;
        this.item = immutableCopyOf(list);
    }

    private TypeTaxiPassengerCharge2Req(Builder builder) {
        this(builder.oid, builder.item);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TypeTaxiPassengerCharge2Req)) {
            return false;
        }
        TypeTaxiPassengerCharge2Req typeTaxiPassengerCharge2Req = (TypeTaxiPassengerCharge2Req) obj;
        if (!equals((Object) this.oid, (Object) typeTaxiPassengerCharge2Req.oid) || !equals((List<?>) this.item, (List<?>) typeTaxiPassengerCharge2Req.item)) {
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
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<TypeTaxiChargeItem> list = this.item;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<TypeTaxiPassengerCharge2Req> {
        public List<TypeTaxiChargeItem> item;
        public String oid;

        public Builder() {
        }

        public Builder(TypeTaxiPassengerCharge2Req typeTaxiPassengerCharge2Req) {
            super(typeTaxiPassengerCharge2Req);
            if (typeTaxiPassengerCharge2Req != null) {
                this.oid = typeTaxiPassengerCharge2Req.oid;
                this.item = TypeTaxiPassengerCharge2Req.copyOf(typeTaxiPassengerCharge2Req.item);
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder item(List<TypeTaxiChargeItem> list) {
            this.item = checkForNulls(list);
            return this;
        }

        public TypeTaxiPassengerCharge2Req build() {
            checkRequiredFields();
            return new TypeTaxiPassengerCharge2Req(this);
        }
    }
}
