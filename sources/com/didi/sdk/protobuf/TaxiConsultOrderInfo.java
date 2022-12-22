package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiConsultOrderInfo extends Message {
    public static final Long DEFAULT_EXPECTGOPICKTIME = 0L;
    public static final String DEFAULT_ISPROTECT = "";
    public static final String DEFAULT_ORDERID = "";
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_PUSHRELATION = 0;
    public static final Long DEFAULT_SESSIONID = 0L;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long expectGoPickTime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String isProtect;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer pushRelation;
    @ProtoField(tag = 6, type = Message.Datatype.UINT64)
    public final Long sessionId;

    public TaxiConsultOrderInfo(String str, String str2, Integer num, Long l, String str3, Long l2) {
        this.orderId = str;
        this.phone = str2;
        this.pushRelation = num;
        this.expectGoPickTime = l;
        this.isProtect = str3;
        this.sessionId = l2;
    }

    private TaxiConsultOrderInfo(Builder builder) {
        this(builder.orderId, builder.phone, builder.pushRelation, builder.expectGoPickTime, builder.isProtect, builder.sessionId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiConsultOrderInfo)) {
            return false;
        }
        TaxiConsultOrderInfo taxiConsultOrderInfo = (TaxiConsultOrderInfo) obj;
        if (!equals((Object) this.orderId, (Object) taxiConsultOrderInfo.orderId) || !equals((Object) this.phone, (Object) taxiConsultOrderInfo.phone) || !equals((Object) this.pushRelation, (Object) taxiConsultOrderInfo.pushRelation) || !equals((Object) this.expectGoPickTime, (Object) taxiConsultOrderInfo.expectGoPickTime) || !equals((Object) this.isProtect, (Object) taxiConsultOrderInfo.isProtect) || !equals((Object) this.sessionId, (Object) taxiConsultOrderInfo.sessionId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.orderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.phone;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.pushRelation;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.expectGoPickTime;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        String str3 = this.isProtect;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l2 = this.sessionId;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiConsultOrderInfo> {
        public Long expectGoPickTime;
        public String isProtect;
        public String orderId;
        public String phone;
        public Integer pushRelation;
        public Long sessionId;

        public Builder() {
        }

        public Builder(TaxiConsultOrderInfo taxiConsultOrderInfo) {
            super(taxiConsultOrderInfo);
            if (taxiConsultOrderInfo != null) {
                this.orderId = taxiConsultOrderInfo.orderId;
                this.phone = taxiConsultOrderInfo.phone;
                this.pushRelation = taxiConsultOrderInfo.pushRelation;
                this.expectGoPickTime = taxiConsultOrderInfo.expectGoPickTime;
                this.isProtect = taxiConsultOrderInfo.isProtect;
                this.sessionId = taxiConsultOrderInfo.sessionId;
            }
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder pushRelation(Integer num) {
            this.pushRelation = num;
            return this;
        }

        public Builder expectGoPickTime(Long l) {
            this.expectGoPickTime = l;
            return this;
        }

        public Builder isProtect(String str) {
            this.isProtect = str;
            return this;
        }

        public Builder sessionId(Long l) {
            this.sessionId = l;
            return this;
        }

        public TaxiConsultOrderInfo build() {
            return new TaxiConsultOrderInfo(this);
        }
    }
}
