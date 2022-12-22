package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderChargeSuccReq extends Message {
    public static final String DEFAULT_OID = "";
    public static final String DEFAULT_PAY_INFO = "";
    public static final String DEFAULT_PAY_ORDER_TEXT = "";
    public static final Integer DEFAULT_TRADE_STATUS = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.STRING)
    public final String pay_info;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String pay_order_text;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer trade_status;

    public OrderChargeSuccReq(String str, Integer num, String str2, String str3) {
        this.oid = str;
        this.trade_status = num;
        this.pay_order_text = str2;
        this.pay_info = str3;
    }

    private OrderChargeSuccReq(Builder builder) {
        this(builder.oid, builder.trade_status, builder.pay_order_text, builder.pay_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderChargeSuccReq)) {
            return false;
        }
        OrderChargeSuccReq orderChargeSuccReq = (OrderChargeSuccReq) obj;
        if (!equals((Object) this.oid, (Object) orderChargeSuccReq.oid) || !equals((Object) this.trade_status, (Object) orderChargeSuccReq.trade_status) || !equals((Object) this.pay_order_text, (Object) orderChargeSuccReq.pay_order_text) || !equals((Object) this.pay_info, (Object) orderChargeSuccReq.pay_info)) {
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
        String str2 = this.pay_order_text;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.pay_info;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderChargeSuccReq> {
        public String oid;
        public String pay_info;
        public String pay_order_text;
        public Integer trade_status;

        public Builder() {
        }

        public Builder(OrderChargeSuccReq orderChargeSuccReq) {
            super(orderChargeSuccReq);
            if (orderChargeSuccReq != null) {
                this.oid = orderChargeSuccReq.oid;
                this.trade_status = orderChargeSuccReq.trade_status;
                this.pay_order_text = orderChargeSuccReq.pay_order_text;
                this.pay_info = orderChargeSuccReq.pay_info;
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

        public Builder pay_order_text(String str) {
            this.pay_order_text = str;
            return this;
        }

        public Builder pay_info(String str) {
            this.pay_info = str;
            return this;
        }

        public OrderChargeSuccReq build() {
            checkRequiredFields();
            return new OrderChargeSuccReq(this);
        }
    }
}
