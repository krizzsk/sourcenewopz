package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiPassengerTerminateOrderNoticeTripFriendReq extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_ORDER_ID = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String order_id;

    public TaxiPassengerTerminateOrderNoticeTripFriendReq(String str, String str2) {
        this.order_id = str;
        this.content = str2;
    }

    private TaxiPassengerTerminateOrderNoticeTripFriendReq(Builder builder) {
        this(builder.order_id, builder.content);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiPassengerTerminateOrderNoticeTripFriendReq)) {
            return false;
        }
        TaxiPassengerTerminateOrderNoticeTripFriendReq taxiPassengerTerminateOrderNoticeTripFriendReq = (TaxiPassengerTerminateOrderNoticeTripFriendReq) obj;
        if (!equals((Object) this.order_id, (Object) taxiPassengerTerminateOrderNoticeTripFriendReq.order_id) || !equals((Object) this.content, (Object) taxiPassengerTerminateOrderNoticeTripFriendReq.content)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.order_id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.content;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiPassengerTerminateOrderNoticeTripFriendReq> {
        public String content;
        public String order_id;

        public Builder() {
        }

        public Builder(TaxiPassengerTerminateOrderNoticeTripFriendReq taxiPassengerTerminateOrderNoticeTripFriendReq) {
            super(taxiPassengerTerminateOrderNoticeTripFriendReq);
            if (taxiPassengerTerminateOrderNoticeTripFriendReq != null) {
                this.order_id = taxiPassengerTerminateOrderNoticeTripFriendReq.order_id;
                this.content = taxiPassengerTerminateOrderNoticeTripFriendReq.content;
            }
        }

        public Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public TaxiPassengerTerminateOrderNoticeTripFriendReq build() {
            checkRequiredFields();
            return new TaxiPassengerTerminateOrderNoticeTripFriendReq(this);
        }
    }
}
