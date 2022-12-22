package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class AuthSvrAddUserReq extends Message {
    public static final String DEFAULT_PHONE_NUM = "";
    public static final ByteString DEFAULT_TOKEN = ByteString.EMPTY;
    public static final Long DEFAULT_USER_ID = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String phone_num;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.BYTES)
    public final ByteString token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long user_id;

    public AuthSvrAddUserReq(Long l, ByteString byteString, String str) {
        this.user_id = l;
        this.token = byteString;
        this.phone_num = str;
    }

    private AuthSvrAddUserReq(Builder builder) {
        this(builder.user_id, builder.token, builder.phone_num);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthSvrAddUserReq)) {
            return false;
        }
        AuthSvrAddUserReq authSvrAddUserReq = (AuthSvrAddUserReq) obj;
        if (!equals((Object) this.user_id, (Object) authSvrAddUserReq.user_id) || !equals((Object) this.token, (Object) authSvrAddUserReq.token) || !equals((Object) this.phone_num, (Object) authSvrAddUserReq.phone_num)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.user_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        ByteString byteString = this.token;
        int hashCode2 = (hashCode + (byteString != null ? byteString.hashCode() : 0)) * 37;
        String str = this.phone_num;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AuthSvrAddUserReq> {
        public String phone_num;
        public ByteString token;
        public Long user_id;

        public Builder() {
        }

        public Builder(AuthSvrAddUserReq authSvrAddUserReq) {
            super(authSvrAddUserReq);
            if (authSvrAddUserReq != null) {
                this.user_id = authSvrAddUserReq.user_id;
                this.token = authSvrAddUserReq.token;
                this.phone_num = authSvrAddUserReq.phone_num;
            }
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder token(ByteString byteString) {
            this.token = byteString;
            return this;
        }

        public Builder phone_num(String str) {
            this.phone_num = str;
            return this;
        }

        public AuthSvrAddUserReq build() {
            checkRequiredFields();
            return new AuthSvrAddUserReq(this);
        }
    }
}
