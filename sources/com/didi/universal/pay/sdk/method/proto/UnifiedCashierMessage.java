package com.didi.universal.pay.sdk.method.proto;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UnifiedCashierMessage extends Message {
    public static final Integer DEFAULT_CODE = 0;
    public static final String DEFAULT_DATA = "";
    public static final String DEFAULT_MSG = "";
    public static final String DEFAULT_OID = "";
    public static final String DEFAULT_PRODUCT_ID = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer code;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String data;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String product_id;

    public UnifiedCashierMessage(Integer num, String str, String str2, String str3, String str4) {
        this.code = num;
        this.msg = str;
        this.oid = str2;
        this.product_id = str3;
        this.data = str4;
    }

    private UnifiedCashierMessage(Builder builder) {
        this(builder.code, builder.msg, builder.oid, builder.product_id, builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnifiedCashierMessage)) {
            return false;
        }
        UnifiedCashierMessage unifiedCashierMessage = (UnifiedCashierMessage) obj;
        if (!equals((Object) this.code, (Object) unifiedCashierMessage.code) || !equals((Object) this.msg, (Object) unifiedCashierMessage.msg) || !equals((Object) this.oid, (Object) unifiedCashierMessage.oid) || !equals((Object) this.product_id, (Object) unifiedCashierMessage.product_id) || !equals((Object) this.data, (Object) unifiedCashierMessage.data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.code;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.oid;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.product_id;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.data;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UnifiedCashierMessage> {
        public Integer code;
        public String data;
        public String msg;
        public String oid;
        public String product_id;

        public Builder() {
        }

        public Builder(UnifiedCashierMessage unifiedCashierMessage) {
            super(unifiedCashierMessage);
            if (unifiedCashierMessage != null) {
                this.code = unifiedCashierMessage.code;
                this.msg = unifiedCashierMessage.msg;
                this.oid = unifiedCashierMessage.oid;
                this.product_id = unifiedCashierMessage.product_id;
                this.data = unifiedCashierMessage.data;
            }
        }

        public Builder code(Integer num) {
            this.code = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder product_id(String str) {
            this.product_id = str;
            return this;
        }

        public Builder data(String str) {
            this.data = str;
            return this;
        }

        public UnifiedCashierMessage build() {
            checkRequiredFields();
            return new UnifiedCashierMessage(this);
        }
    }
}
