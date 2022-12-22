package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiSuccOrderInfo extends Message {
    public static final Long DEFAULT_EXPECTGOPICKTIME = 0L;
    public static final String DEFAULT_EXTRAINFO = "";
    public static final String DEFAULT_ISPROTECT = "";
    public static final String DEFAULT_ORDERID = "";
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_PUSHRELATION = 0;
    public static final Long DEFAULT_SESSIONID = 0L;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long expectGoPickTime;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String extrainfo;
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

    public TaxiSuccOrderInfo(String str, String str2, Integer num, Long l, String str3, Long l2, String str4) {
        this.orderId = str;
        this.phone = str2;
        this.pushRelation = num;
        this.expectGoPickTime = l;
        this.isProtect = str3;
        this.sessionId = l2;
        this.extrainfo = str4;
    }

    private TaxiSuccOrderInfo(Builder builder) {
        this(builder.orderId, builder.phone, builder.pushRelation, builder.expectGoPickTime, builder.isProtect, builder.sessionId, builder.extrainfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiSuccOrderInfo)) {
            return false;
        }
        TaxiSuccOrderInfo taxiSuccOrderInfo = (TaxiSuccOrderInfo) obj;
        if (!equals((Object) this.orderId, (Object) taxiSuccOrderInfo.orderId) || !equals((Object) this.phone, (Object) taxiSuccOrderInfo.phone) || !equals((Object) this.pushRelation, (Object) taxiSuccOrderInfo.pushRelation) || !equals((Object) this.expectGoPickTime, (Object) taxiSuccOrderInfo.expectGoPickTime) || !equals((Object) this.isProtect, (Object) taxiSuccOrderInfo.isProtect) || !equals((Object) this.sessionId, (Object) taxiSuccOrderInfo.sessionId) || !equals((Object) this.extrainfo, (Object) taxiSuccOrderInfo.extrainfo)) {
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
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str4 = this.extrainfo;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiSuccOrderInfo> {
        public Long expectGoPickTime;
        public String extrainfo;
        public String isProtect;
        public String orderId;
        public String phone;
        public Integer pushRelation;
        public Long sessionId;

        public Builder() {
        }

        public Builder(TaxiSuccOrderInfo taxiSuccOrderInfo) {
            super(taxiSuccOrderInfo);
            if (taxiSuccOrderInfo != null) {
                this.orderId = taxiSuccOrderInfo.orderId;
                this.phone = taxiSuccOrderInfo.phone;
                this.pushRelation = taxiSuccOrderInfo.pushRelation;
                this.expectGoPickTime = taxiSuccOrderInfo.expectGoPickTime;
                this.isProtect = taxiSuccOrderInfo.isProtect;
                this.sessionId = taxiSuccOrderInfo.sessionId;
                this.extrainfo = taxiSuccOrderInfo.extrainfo;
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

        public Builder extrainfo(String str) {
            this.extrainfo = str;
            return this;
        }

        public TaxiSuccOrderInfo build() {
            return new TaxiSuccOrderInfo(this);
        }
    }
}
