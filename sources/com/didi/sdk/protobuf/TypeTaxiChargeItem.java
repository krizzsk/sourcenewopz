package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TypeTaxiChargeItem extends Message {
    public static final String DEFAULT_EXTRA = "";
    public static final TaxiChargeType DEFAULT_TYPE = TaxiChargeType.kChargeTypeRoad;
    public static final String DEFAULT_UNIT = "";
    public static final Float DEFAULT_VALUE = Float.valueOf(0.0f);
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String extra;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.ENUM)
    public final TaxiChargeType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String unit;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.FLOAT)
    public final Float value;

    public TypeTaxiChargeItem(TaxiChargeType taxiChargeType, Float f, String str, String str2) {
        this.type = taxiChargeType;
        this.value = f;
        this.unit = str;
        this.extra = str2;
    }

    private TypeTaxiChargeItem(Builder builder) {
        this(builder.type, builder.value, builder.unit, builder.extra);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TypeTaxiChargeItem)) {
            return false;
        }
        TypeTaxiChargeItem typeTaxiChargeItem = (TypeTaxiChargeItem) obj;
        if (!equals((Object) this.type, (Object) typeTaxiChargeItem.type) || !equals((Object) this.value, (Object) typeTaxiChargeItem.value) || !equals((Object) this.unit, (Object) typeTaxiChargeItem.unit) || !equals((Object) this.extra, (Object) typeTaxiChargeItem.extra)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        TaxiChargeType taxiChargeType = this.type;
        int i2 = 0;
        int hashCode = (taxiChargeType != null ? taxiChargeType.hashCode() : 0) * 37;
        Float f = this.value;
        int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
        String str = this.unit;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.extra;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TypeTaxiChargeItem> {
        public String extra;
        public TaxiChargeType type;
        public String unit;
        public Float value;

        public Builder() {
        }

        public Builder(TypeTaxiChargeItem typeTaxiChargeItem) {
            super(typeTaxiChargeItem);
            if (typeTaxiChargeItem != null) {
                this.type = typeTaxiChargeItem.type;
                this.value = typeTaxiChargeItem.value;
                this.unit = typeTaxiChargeItem.unit;
                this.extra = typeTaxiChargeItem.extra;
            }
        }

        public Builder type(TaxiChargeType taxiChargeType) {
            this.type = taxiChargeType;
            return this;
        }

        public Builder value(Float f) {
            this.value = f;
            return this;
        }

        public Builder unit(String str) {
            this.unit = str;
            return this;
        }

        public Builder extra(String str) {
            this.extra = str;
            return this;
        }

        public TypeTaxiChargeItem build() {
            checkRequiredFields();
            return new TypeTaxiChargeItem(this);
        }
    }
}
