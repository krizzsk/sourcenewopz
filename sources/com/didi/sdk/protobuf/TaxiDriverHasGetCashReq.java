package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiDriverHasGetCashReq extends Message {
    public static final String DEFAULT_IS_VIP = "";
    public static final String DEFAULT_ORDER_ID = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String is_vip;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String order_id;

    public TaxiDriverHasGetCashReq(String str, String str2) {
        this.order_id = str;
        this.is_vip = str2;
    }

    private TaxiDriverHasGetCashReq(Builder builder) {
        this(builder.order_id, builder.is_vip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiDriverHasGetCashReq)) {
            return false;
        }
        TaxiDriverHasGetCashReq taxiDriverHasGetCashReq = (TaxiDriverHasGetCashReq) obj;
        if (!equals((Object) this.order_id, (Object) taxiDriverHasGetCashReq.order_id) || !equals((Object) this.is_vip, (Object) taxiDriverHasGetCashReq.is_vip)) {
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
        String str2 = this.is_vip;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiDriverHasGetCashReq> {
        public String is_vip;
        public String order_id;

        public Builder() {
        }

        public Builder(TaxiDriverHasGetCashReq taxiDriverHasGetCashReq) {
            super(taxiDriverHasGetCashReq);
            if (taxiDriverHasGetCashReq != null) {
                this.order_id = taxiDriverHasGetCashReq.order_id;
                this.is_vip = taxiDriverHasGetCashReq.is_vip;
            }
        }

        public Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public Builder is_vip(String str) {
            this.is_vip = str;
            return this;
        }

        public TaxiDriverHasGetCashReq build() {
            checkRequiredFields();
            return new TaxiDriverHasGetCashReq(this);
        }
    }
}
