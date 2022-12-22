package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class OrderFeatureRes extends Message {
    public static final ByteString DEFAULT_EXTENDDATA = ByteString.EMPTY;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final ByteString extendData;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 3)
    public final PickupHint pickupHint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;

    public OrderFeatureRes(Integer num, String str, PickupHint pickupHint2, ByteString byteString) {
        this.ret = num;
        this.msg = str;
        this.pickupHint = pickupHint2;
        this.extendData = byteString;
    }

    private OrderFeatureRes(Builder builder) {
        this(builder.ret, builder.msg, builder.pickupHint, builder.extendData);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFeatureRes)) {
            return false;
        }
        OrderFeatureRes orderFeatureRes = (OrderFeatureRes) obj;
        if (!equals((Object) this.ret, (Object) orderFeatureRes.ret) || !equals((Object) this.msg, (Object) orderFeatureRes.msg) || !equals((Object) this.pickupHint, (Object) orderFeatureRes.pickupHint) || !equals((Object) this.extendData, (Object) orderFeatureRes.extendData)) {
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
        PickupHint pickupHint2 = this.pickupHint;
        int hashCode3 = (hashCode2 + (pickupHint2 != null ? pickupHint2.hashCode() : 0)) * 37;
        ByteString byteString = this.extendData;
        if (byteString != null) {
            i2 = byteString.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderFeatureRes> {
        public ByteString extendData;
        public String msg;
        public PickupHint pickupHint;
        public Integer ret;

        public Builder() {
        }

        public Builder(OrderFeatureRes orderFeatureRes) {
            super(orderFeatureRes);
            if (orderFeatureRes != null) {
                this.ret = orderFeatureRes.ret;
                this.msg = orderFeatureRes.msg;
                this.pickupHint = orderFeatureRes.pickupHint;
                this.extendData = orderFeatureRes.extendData;
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

        public Builder pickupHint(PickupHint pickupHint2) {
            this.pickupHint = pickupHint2;
            return this;
        }

        public Builder extendData(ByteString byteString) {
            this.extendData = byteString;
            return this;
        }

        public OrderFeatureRes build() {
            checkRequiredFields();
            return new OrderFeatureRes(this);
        }
    }
}
