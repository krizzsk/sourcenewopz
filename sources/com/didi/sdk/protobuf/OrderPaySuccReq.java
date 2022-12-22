package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderPaySuccReq extends Message {
    public static final String DEFAULT_ACTUAL_PAY_MONEY = "";
    public static final String DEFAULT_OID = "";
    public static final String DEFAULT_PAY_INFO = "";
    public static final String DEFAULT_PAY_ORDER_SUBTITLE = "";
    public static final String DEFAULT_PAY_ORDER_TITLE = "";
    public static final Integer DEFAULT_REFUND_STATUS = 0;
    public static final String DEFAULT_SHARE_COUPON = "";
    public static final Integer DEFAULT_TRADE_STATUS = 0;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String actual_pay_money;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.STRING)
    public final String pay_info;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String pay_order_subtitle;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String pay_order_title;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer refund_status;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String share_coupon;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer trade_status;

    public OrderPaySuccReq(String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, String str6) {
        this.oid = str;
        this.trade_status = num;
        this.pay_order_title = str2;
        this.pay_order_subtitle = str3;
        this.pay_info = str4;
        this.share_coupon = str5;
        this.refund_status = num2;
        this.actual_pay_money = str6;
    }

    private OrderPaySuccReq(Builder builder) {
        this(builder.oid, builder.trade_status, builder.pay_order_title, builder.pay_order_subtitle, builder.pay_info, builder.share_coupon, builder.refund_status, builder.actual_pay_money);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderPaySuccReq)) {
            return false;
        }
        OrderPaySuccReq orderPaySuccReq = (OrderPaySuccReq) obj;
        if (!equals((Object) this.oid, (Object) orderPaySuccReq.oid) || !equals((Object) this.trade_status, (Object) orderPaySuccReq.trade_status) || !equals((Object) this.pay_order_title, (Object) orderPaySuccReq.pay_order_title) || !equals((Object) this.pay_order_subtitle, (Object) orderPaySuccReq.pay_order_subtitle) || !equals((Object) this.pay_info, (Object) orderPaySuccReq.pay_info) || !equals((Object) this.share_coupon, (Object) orderPaySuccReq.share_coupon) || !equals((Object) this.refund_status, (Object) orderPaySuccReq.refund_status) || !equals((Object) this.actual_pay_money, (Object) orderPaySuccReq.actual_pay_money)) {
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
        String str2 = this.pay_order_title;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.pay_order_subtitle;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.pay_info;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.share_coupon;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num2 = this.refund_status;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str6 = this.actual_pay_money;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderPaySuccReq> {
        public String actual_pay_money;
        public String oid;
        public String pay_info;
        public String pay_order_subtitle;
        public String pay_order_title;
        public Integer refund_status;
        public String share_coupon;
        public Integer trade_status;

        public Builder() {
        }

        public Builder(OrderPaySuccReq orderPaySuccReq) {
            super(orderPaySuccReq);
            if (orderPaySuccReq != null) {
                this.oid = orderPaySuccReq.oid;
                this.trade_status = orderPaySuccReq.trade_status;
                this.pay_order_title = orderPaySuccReq.pay_order_title;
                this.pay_order_subtitle = orderPaySuccReq.pay_order_subtitle;
                this.pay_info = orderPaySuccReq.pay_info;
                this.share_coupon = orderPaySuccReq.share_coupon;
                this.refund_status = orderPaySuccReq.refund_status;
                this.actual_pay_money = orderPaySuccReq.actual_pay_money;
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

        public Builder pay_order_title(String str) {
            this.pay_order_title = str;
            return this;
        }

        public Builder pay_order_subtitle(String str) {
            this.pay_order_subtitle = str;
            return this;
        }

        public Builder pay_info(String str) {
            this.pay_info = str;
            return this;
        }

        public Builder share_coupon(String str) {
            this.share_coupon = str;
            return this;
        }

        public Builder refund_status(Integer num) {
            this.refund_status = num;
            return this;
        }

        public Builder actual_pay_money(String str) {
            this.actual_pay_money = str;
            return this;
        }

        public OrderPaySuccReq build() {
            checkRequiredFields();
            return new OrderPaySuccReq(this);
        }
    }
}
