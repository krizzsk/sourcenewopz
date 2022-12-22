package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AuthSvrLoginRsp extends Message {
    public static final Long DEFAULT_USER_ID = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)
    public final Long user_id;

    public AuthSvrLoginRsp(RspMsg rspMsg, Long l) {
        this.rsp_msg = rspMsg;
        this.user_id = l;
    }

    private AuthSvrLoginRsp(Builder builder) {
        this(builder.rsp_msg, builder.user_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthSvrLoginRsp)) {
            return false;
        }
        AuthSvrLoginRsp authSvrLoginRsp = (AuthSvrLoginRsp) obj;
        if (!equals((Object) this.rsp_msg, (Object) authSvrLoginRsp.rsp_msg) || !equals((Object) this.user_id, (Object) authSvrLoginRsp.user_id)) {
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
        Long l = this.user_id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AuthSvrLoginRsp> {
        public RspMsg rsp_msg;
        public Long user_id;

        public Builder() {
        }

        public Builder(AuthSvrLoginRsp authSvrLoginRsp) {
            super(authSvrLoginRsp);
            if (authSvrLoginRsp != null) {
                this.rsp_msg = authSvrLoginRsp.rsp_msg;
                this.user_id = authSvrLoginRsp.user_id;
            }
        }

        public Builder rsp_msg(RspMsg rspMsg) {
            this.rsp_msg = rspMsg;
            return this;
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public AuthSvrLoginRsp build() {
            checkRequiredFields();
            return new AuthSvrLoginRsp(this);
        }
    }
}
