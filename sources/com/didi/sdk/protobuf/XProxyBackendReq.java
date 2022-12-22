package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class XProxyBackendReq extends Message {
    public static final String DEFAULT_MSG = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String msg;

    public XProxyBackendReq(String str) {
        this.msg = str;
    }

    private XProxyBackendReq(Builder builder) {
        this(builder.msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof XProxyBackendReq)) {
            return false;
        }
        return equals((Object) this.msg, (Object) ((XProxyBackendReq) obj).msg);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.msg;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<XProxyBackendReq> {
        public String msg;

        public Builder() {
        }

        public Builder(XProxyBackendReq xProxyBackendReq) {
            super(xProxyBackendReq);
            if (xProxyBackendReq != null) {
                this.msg = xProxyBackendReq.msg;
            }
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public XProxyBackendReq build() {
            checkRequiredFields();
            return new XProxyBackendReq(this);
        }
    }
}
