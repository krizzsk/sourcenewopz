package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class POPEActionReq extends Message {
    public static final String DEFAULT_DATA = "";
    public static final Integer DEFAULT_PRODUCT_ID = 0;
    public static final String DEFAULT_TYPE = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String data;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer product_id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String type;

    public POPEActionReq(Integer num, String str, String str2) {
        this.product_id = num;
        this.type = str;
        this.data = str2;
    }

    private POPEActionReq(Builder builder) {
        this(builder.product_id, builder.type, builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof POPEActionReq)) {
            return false;
        }
        POPEActionReq pOPEActionReq = (POPEActionReq) obj;
        if (!equals((Object) this.product_id, (Object) pOPEActionReq.product_id) || !equals((Object) this.type, (Object) pOPEActionReq.type) || !equals((Object) this.data, (Object) pOPEActionReq.data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.product_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.type;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.data;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<POPEActionReq> {
        public String data;
        public Integer product_id;
        public String type;

        public Builder() {
        }

        public Builder(POPEActionReq pOPEActionReq) {
            super(pOPEActionReq);
            if (pOPEActionReq != null) {
                this.product_id = pOPEActionReq.product_id;
                this.type = pOPEActionReq.type;
                this.data = pOPEActionReq.data;
            }
        }

        public Builder product_id(Integer num) {
            this.product_id = num;
            return this;
        }

        public Builder type(String str) {
            this.type = str;
            return this;
        }

        public Builder data(String str) {
            this.data = str;
            return this;
        }

        public POPEActionReq build() {
            return new POPEActionReq(this);
        }
    }
}
