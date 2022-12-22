package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.PassengerPayStatusReq */
public final class PassengerPayStatusReq extends Message {
    public static final String DEFAULT_OID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TRADE_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer trade_status;

    public PassengerPayStatusReq(String str, Integer num, String str2) {
        this.oid = str;
        this.trade_status = num;
        this.token = str2;
    }

    private PassengerPayStatusReq(Builder builder) {
        this(builder.oid, builder.trade_status, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerPayStatusReq)) {
            return false;
        }
        PassengerPayStatusReq passengerPayStatusReq = (PassengerPayStatusReq) obj;
        if (!equals((Object) this.oid, (Object) passengerPayStatusReq.oid) || !equals((Object) this.trade_status, (Object) passengerPayStatusReq.trade_status) || !equals((Object) this.token, (Object) passengerPayStatusReq.token)) {
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
        Integer num = this.trade_status;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.PassengerPayStatusReq$Builder */
    public static final class Builder extends Message.Builder<PassengerPayStatusReq> {
        public String oid;
        public String token;
        public Integer trade_status;

        public Builder() {
        }

        public Builder(PassengerPayStatusReq passengerPayStatusReq) {
            super(passengerPayStatusReq);
            if (passengerPayStatusReq != null) {
                this.oid = passengerPayStatusReq.oid;
                this.trade_status = passengerPayStatusReq.trade_status;
                this.token = passengerPayStatusReq.token;
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder trade_status(Integer num) {
            this.trade_status = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public PassengerPayStatusReq build() {
            checkRequiredFields();
            return new PassengerPayStatusReq(this);
        }
    }
}
