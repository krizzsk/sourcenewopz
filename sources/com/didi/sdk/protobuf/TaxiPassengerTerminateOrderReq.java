package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiPassengerTerminateOrderReq extends Message {
    public static final String DEFAULT_CANCEL_REASON = "";
    public static final String DEFAULT_MSG = "";
    public static final String DEFAULT_ORDER_ID = "";
    public static final String DEFAULT_TRIP_ID = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String cancel_reason;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String order_id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String trip_id;

    public TaxiPassengerTerminateOrderReq(String str, String str2, String str3, String str4) {
        this.order_id = str;
        this.msg = str2;
        this.cancel_reason = str3;
        this.trip_id = str4;
    }

    private TaxiPassengerTerminateOrderReq(Builder builder) {
        this(builder.order_id, builder.msg, builder.cancel_reason, builder.trip_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiPassengerTerminateOrderReq)) {
            return false;
        }
        TaxiPassengerTerminateOrderReq taxiPassengerTerminateOrderReq = (TaxiPassengerTerminateOrderReq) obj;
        if (!equals((Object) this.order_id, (Object) taxiPassengerTerminateOrderReq.order_id) || !equals((Object) this.msg, (Object) taxiPassengerTerminateOrderReq.msg) || !equals((Object) this.cancel_reason, (Object) taxiPassengerTerminateOrderReq.cancel_reason) || !equals((Object) this.trip_id, (Object) taxiPassengerTerminateOrderReq.trip_id)) {
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
        String str2 = this.msg;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.cancel_reason;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.trip_id;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiPassengerTerminateOrderReq> {
        public String cancel_reason;
        public String msg;
        public String order_id;
        public String trip_id;

        public Builder() {
        }

        public Builder(TaxiPassengerTerminateOrderReq taxiPassengerTerminateOrderReq) {
            super(taxiPassengerTerminateOrderReq);
            if (taxiPassengerTerminateOrderReq != null) {
                this.order_id = taxiPassengerTerminateOrderReq.order_id;
                this.msg = taxiPassengerTerminateOrderReq.msg;
                this.cancel_reason = taxiPassengerTerminateOrderReq.cancel_reason;
                this.trip_id = taxiPassengerTerminateOrderReq.trip_id;
            }
        }

        public Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder cancel_reason(String str) {
            this.cancel_reason = str;
            return this;
        }

        public Builder trip_id(String str) {
            this.trip_id = str;
            return this;
        }

        public TaxiPassengerTerminateOrderReq build() {
            checkRequiredFields();
            return new TaxiPassengerTerminateOrderReq(this);
        }
    }
}
