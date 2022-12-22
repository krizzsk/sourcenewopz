package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiExtraInfo extends Message {
    public static final Integer DEFAULT_ADDEDINCOME = 0;
    public static final Integer DEFAULT_BONUS = 0;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Integer DEFAULT_PRICE = 0;
    public static final Integer DEFAULT_SCORE = 0;
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer addedIncome;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer bonus;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer price;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer score;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String title;

    public TaxiExtraInfo(Integer num, Integer num2, Integer num3, Integer num4, String str, String str2) {
        this.bonus = num;
        this.score = num2;
        this.price = num3;
        this.addedIncome = num4;
        this.title = str;
        this.description = str2;
    }

    private TaxiExtraInfo(Builder builder) {
        this(builder.bonus, builder.score, builder.price, builder.addedIncome, builder.title, builder.description);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiExtraInfo)) {
            return false;
        }
        TaxiExtraInfo taxiExtraInfo = (TaxiExtraInfo) obj;
        if (!equals((Object) this.bonus, (Object) taxiExtraInfo.bonus) || !equals((Object) this.score, (Object) taxiExtraInfo.score) || !equals((Object) this.price, (Object) taxiExtraInfo.price) || !equals((Object) this.addedIncome, (Object) taxiExtraInfo.addedIncome) || !equals((Object) this.title, (Object) taxiExtraInfo.title) || !equals((Object) this.description, (Object) taxiExtraInfo.description)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.bonus;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.score;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.price;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.addedIncome;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.title;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.description;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiExtraInfo> {
        public Integer addedIncome;
        public Integer bonus;
        public String description;
        public Integer price;
        public Integer score;
        public String title;

        public Builder() {
        }

        public Builder(TaxiExtraInfo taxiExtraInfo) {
            super(taxiExtraInfo);
            if (taxiExtraInfo != null) {
                this.bonus = taxiExtraInfo.bonus;
                this.score = taxiExtraInfo.score;
                this.price = taxiExtraInfo.price;
                this.addedIncome = taxiExtraInfo.addedIncome;
                this.title = taxiExtraInfo.title;
                this.description = taxiExtraInfo.description;
            }
        }

        public Builder bonus(Integer num) {
            this.bonus = num;
            return this;
        }

        public Builder score(Integer num) {
            this.score = num;
            return this;
        }

        public Builder price(Integer num) {
            this.price = num;
            return this;
        }

        public Builder addedIncome(Integer num) {
            this.addedIncome = num;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public TaxiExtraInfo build() {
            return new TaxiExtraInfo(this);
        }
    }
}
