package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AuthSvrQueryUserReq extends Message {
    public static final String DEFAULT_PHONE_NUM = "";
    public static final Integer DEFAULT_ROLE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String phone_num;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer role;

    public AuthSvrQueryUserReq(String str, Integer num) {
        this.phone_num = str;
        this.role = num;
    }

    private AuthSvrQueryUserReq(Builder builder) {
        this(builder.phone_num, builder.role);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthSvrQueryUserReq)) {
            return false;
        }
        AuthSvrQueryUserReq authSvrQueryUserReq = (AuthSvrQueryUserReq) obj;
        if (!equals((Object) this.phone_num, (Object) authSvrQueryUserReq.phone_num) || !equals((Object) this.role, (Object) authSvrQueryUserReq.role)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.phone_num;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.role;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AuthSvrQueryUserReq> {
        public String phone_num;
        public Integer role;

        public Builder() {
        }

        public Builder(AuthSvrQueryUserReq authSvrQueryUserReq) {
            super(authSvrQueryUserReq);
            if (authSvrQueryUserReq != null) {
                this.phone_num = authSvrQueryUserReq.phone_num;
                this.role = authSvrQueryUserReq.role;
            }
        }

        public Builder phone_num(String str) {
            this.phone_num = str;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public AuthSvrQueryUserReq build() {
            checkRequiredFields();
            return new AuthSvrQueryUserReq(this);
        }
    }
}
