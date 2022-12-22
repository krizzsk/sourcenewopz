package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OperationActivityReq extends Message {
    public static final String DEFAULT_ACTIVITY_DED = "";
    public static final String DEFAULT_ACTIVITY_DOC = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String activity_ded;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String activity_doc;

    public OperationActivityReq(String str, String str2) {
        this.activity_doc = str;
        this.activity_ded = str2;
    }

    private OperationActivityReq(Builder builder) {
        this(builder.activity_doc, builder.activity_ded);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OperationActivityReq)) {
            return false;
        }
        OperationActivityReq operationActivityReq = (OperationActivityReq) obj;
        if (!equals((Object) this.activity_doc, (Object) operationActivityReq.activity_doc) || !equals((Object) this.activity_ded, (Object) operationActivityReq.activity_ded)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.activity_doc;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.activity_ded;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OperationActivityReq> {
        public String activity_ded;
        public String activity_doc;

        public Builder() {
        }

        public Builder(OperationActivityReq operationActivityReq) {
            super(operationActivityReq);
            if (operationActivityReq != null) {
                this.activity_doc = operationActivityReq.activity_doc;
                this.activity_ded = operationActivityReq.activity_ded;
            }
        }

        public Builder activity_doc(String str) {
            this.activity_doc = str;
            return this;
        }

        public Builder activity_ded(String str) {
            this.activity_ded = str;
            return this;
        }

        public OperationActivityReq build() {
            return new OperationActivityReq(this);
        }
    }
}
