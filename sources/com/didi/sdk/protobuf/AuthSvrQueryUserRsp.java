package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AuthSvrQueryUserRsp extends Message {
    public static final Long DEFAULT_USER_ID = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long user_id;

    public AuthSvrQueryUserRsp(RspMsg rspMsg, Long l) {
        this.rsp_msg = rspMsg;
        this.user_id = l;
    }

    private AuthSvrQueryUserRsp(Builder builder) {
        this(builder.rsp_msg, builder.user_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthSvrQueryUserRsp)) {
            return false;
        }
        AuthSvrQueryUserRsp authSvrQueryUserRsp = (AuthSvrQueryUserRsp) obj;
        if (!equals((Object) this.rsp_msg, (Object) authSvrQueryUserRsp.rsp_msg) || !equals((Object) this.user_id, (Object) authSvrQueryUserRsp.user_id)) {
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

    public static final class Builder extends Message.Builder<AuthSvrQueryUserRsp> {
        public RspMsg rsp_msg;
        public Long user_id;

        public Builder() {
        }

        public Builder(AuthSvrQueryUserRsp authSvrQueryUserRsp) {
            super(authSvrQueryUserRsp);
            if (authSvrQueryUserRsp != null) {
                this.rsp_msg = authSvrQueryUserRsp.rsp_msg;
                this.user_id = authSvrQueryUserRsp.user_id;
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

        public AuthSvrQueryUserRsp build() {
            checkRequiredFields();
            return new AuthSvrQueryUserRsp(this);
        }
    }
}
