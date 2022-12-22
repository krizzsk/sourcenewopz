package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PassengerMultiRouteSelectRes extends Message {
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;

    public PassengerMultiRouteSelectRes(Integer num, String str, Long l) {
        this.ret = num;
        this.msg = str;
        this.logId = l;
    }

    private PassengerMultiRouteSelectRes(Builder builder) {
        this(builder.ret, builder.msg, builder.logId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerMultiRouteSelectRes)) {
            return false;
        }
        PassengerMultiRouteSelectRes passengerMultiRouteSelectRes = (PassengerMultiRouteSelectRes) obj;
        if (!equals((Object) this.ret, (Object) passengerMultiRouteSelectRes.ret) || !equals((Object) this.msg, (Object) passengerMultiRouteSelectRes.msg) || !equals((Object) this.logId, (Object) passengerMultiRouteSelectRes.logId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ret;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.logId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PassengerMultiRouteSelectRes> {
        public Long logId;
        public String msg;
        public Integer ret;

        public Builder() {
        }

        public Builder(PassengerMultiRouteSelectRes passengerMultiRouteSelectRes) {
            super(passengerMultiRouteSelectRes);
            if (passengerMultiRouteSelectRes != null) {
                this.ret = passengerMultiRouteSelectRes.ret;
                this.msg = passengerMultiRouteSelectRes.msg;
                this.logId = passengerMultiRouteSelectRes.logId;
            }
        }

        public Builder ret(Integer num) {
            this.ret = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public PassengerMultiRouteSelectRes build() {
            checkRequiredFields();
            return new PassengerMultiRouteSelectRes(this);
        }
    }
}
