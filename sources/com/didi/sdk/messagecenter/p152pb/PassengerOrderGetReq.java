package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.PassengerOrderGetReq */
public final class PassengerOrderGetReq extends Message {
    public static final String DEFAULT_OID = "";
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_WAIT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6)
    public final Coordinate coordinate;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.STRING)
    public final String wait;

    public PassengerOrderGetReq(String str, String str2, String str3, Integer num, String str4, Coordinate coordinate2) {
        this.phone = str;
        this.token = str2;
        this.oid = str3;
        this.status = num;
        this.wait = str4;
        this.coordinate = coordinate2;
    }

    private PassengerOrderGetReq(Builder builder) {
        this(builder.phone, builder.token, builder.oid, builder.status, builder.wait, builder.coordinate);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerOrderGetReq)) {
            return false;
        }
        PassengerOrderGetReq passengerOrderGetReq = (PassengerOrderGetReq) obj;
        if (!equals((Object) this.phone, (Object) passengerOrderGetReq.phone) || !equals((Object) this.token, (Object) passengerOrderGetReq.token) || !equals((Object) this.oid, (Object) passengerOrderGetReq.oid) || !equals((Object) this.status, (Object) passengerOrderGetReq.status) || !equals((Object) this.wait, (Object) passengerOrderGetReq.wait) || !equals((Object) this.coordinate, (Object) passengerOrderGetReq.coordinate)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.phone;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.oid;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.status;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str4 = this.wait;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Coordinate coordinate2 = this.coordinate;
        if (coordinate2 != null) {
            i2 = coordinate2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.PassengerOrderGetReq$Builder */
    public static final class Builder extends Message.Builder<PassengerOrderGetReq> {
        public Coordinate coordinate;
        public String oid;
        public String phone;
        public Integer status;
        public String token;
        public String wait;

        public Builder() {
        }

        public Builder(PassengerOrderGetReq passengerOrderGetReq) {
            super(passengerOrderGetReq);
            if (passengerOrderGetReq != null) {
                this.phone = passengerOrderGetReq.phone;
                this.token = passengerOrderGetReq.token;
                this.oid = passengerOrderGetReq.oid;
                this.status = passengerOrderGetReq.status;
                this.wait = passengerOrderGetReq.wait;
                this.coordinate = passengerOrderGetReq.coordinate;
            }
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder wait(String str) {
            this.wait = str;
            return this;
        }

        public Builder coordinate(Coordinate coordinate2) {
            this.coordinate = coordinate2;
            return this;
        }

        public PassengerOrderGetReq build() {
            checkRequiredFields();
            return new PassengerOrderGetReq(this);
        }
    }
}
