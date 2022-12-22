package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AuthSvrSignRsp extends Message {
    public static final String DEFAULT_HMAC = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String hmac;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;

    public AuthSvrSignRsp(RspMsg rspMsg, String str) {
        this.rsp_msg = rspMsg;
        this.hmac = str;
    }

    private AuthSvrSignRsp(Builder builder) {
        this(builder.rsp_msg, builder.hmac);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthSvrSignRsp)) {
            return false;
        }
        AuthSvrSignRsp authSvrSignRsp = (AuthSvrSignRsp) obj;
        if (!equals((Object) this.rsp_msg, (Object) authSvrSignRsp.rsp_msg) || !equals((Object) this.hmac, (Object) authSvrSignRsp.hmac)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RspMsg rspMsg = this.rsp_msg;
        int i2 = 0;
        int hashCode = (rspMsg != null ? rspMsg.hashCode() : 0) * 37;
        String str = this.hmac;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AuthSvrSignRsp> {
        public String hmac;
        public RspMsg rsp_msg;

        public Builder() {
        }

        public Builder(AuthSvrSignRsp authSvrSignRsp) {
            super(authSvrSignRsp);
            if (authSvrSignRsp != null) {
                this.rsp_msg = authSvrSignRsp.rsp_msg;
                this.hmac = authSvrSignRsp.hmac;
            }
        }

        public Builder rsp_msg(RspMsg rspMsg) {
            this.rsp_msg = rspMsg;
            return this;
        }

        public Builder hmac(String str) {
            this.hmac = str;
            return this;
        }

        public AuthSvrSignRsp build() {
            checkRequiredFields();
            return new AuthSvrSignRsp(this);
        }
    }
}
