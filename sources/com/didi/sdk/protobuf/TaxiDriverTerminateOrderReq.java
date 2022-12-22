package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiDriverTerminateOrderReq extends Message {
    public static final String DEFAULT_CANCEL_REASON = "";
    public static final Integer DEFAULT_DUTY_TYPE = 0;
    public static final String DEFAULT_MSG = "";
    public static final String DEFAULT_ORDER_ID = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String cancel_reason;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer duty_type;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String order_id;

    public TaxiDriverTerminateOrderReq(String str, String str2, String str3, Integer num) {
        this.order_id = str;
        this.msg = str2;
        this.cancel_reason = str3;
        this.duty_type = num;
    }

    private TaxiDriverTerminateOrderReq(Builder builder) {
        this(builder.order_id, builder.msg, builder.cancel_reason, builder.duty_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiDriverTerminateOrderReq)) {
            return false;
        }
        TaxiDriverTerminateOrderReq taxiDriverTerminateOrderReq = (TaxiDriverTerminateOrderReq) obj;
        if (!equals((Object) this.order_id, (Object) taxiDriverTerminateOrderReq.order_id) || !equals((Object) this.msg, (Object) taxiDriverTerminateOrderReq.msg) || !equals((Object) this.cancel_reason, (Object) taxiDriverTerminateOrderReq.cancel_reason) || !equals((Object) this.duty_type, (Object) taxiDriverTerminateOrderReq.duty_type)) {
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
        Integer num = this.duty_type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiDriverTerminateOrderReq> {
        public String cancel_reason;
        public Integer duty_type;
        public String msg;
        public String order_id;

        public Builder() {
        }

        public Builder(TaxiDriverTerminateOrderReq taxiDriverTerminateOrderReq) {
            super(taxiDriverTerminateOrderReq);
            if (taxiDriverTerminateOrderReq != null) {
                this.order_id = taxiDriverTerminateOrderReq.order_id;
                this.msg = taxiDriverTerminateOrderReq.msg;
                this.cancel_reason = taxiDriverTerminateOrderReq.cancel_reason;
                this.duty_type = taxiDriverTerminateOrderReq.duty_type;
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

        public Builder duty_type(Integer num) {
            this.duty_type = num;
            return this;
        }

        public TaxiDriverTerminateOrderReq build() {
            checkRequiredFields();
            return new TaxiDriverTerminateOrderReq(this);
        }
    }
}
