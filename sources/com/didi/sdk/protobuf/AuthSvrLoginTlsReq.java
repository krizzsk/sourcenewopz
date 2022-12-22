package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class AuthSvrLoginTlsReq extends Message {
    public static final String DEFAULT_PHONE_NUM = "";
    public static final Integer DEFAULT_ROLE = 0;
    public static final ByteString DEFAULT_TOKEN = ByteString.EMPTY;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String phone_num;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BYTES)
    public final ByteString token;

    public AuthSvrLoginTlsReq(String str, ByteString byteString, Integer num) {
        this.phone_num = str;
        this.token = byteString;
        this.role = num;
    }

    private AuthSvrLoginTlsReq(Builder builder) {
        this(builder.phone_num, builder.token, builder.role);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthSvrLoginTlsReq)) {
            return false;
        }
        AuthSvrLoginTlsReq authSvrLoginTlsReq = (AuthSvrLoginTlsReq) obj;
        if (!equals((Object) this.phone_num, (Object) authSvrLoginTlsReq.phone_num) || !equals((Object) this.token, (Object) authSvrLoginTlsReq.token) || !equals((Object) this.role, (Object) authSvrLoginTlsReq.role)) {
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
        ByteString byteString = this.token;
        int hashCode2 = (hashCode + (byteString != null ? byteString.hashCode() : 0)) * 37;
        Integer num = this.role;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AuthSvrLoginTlsReq> {
        public String phone_num;
        public Integer role;
        public ByteString token;

        public Builder() {
        }

        public Builder(AuthSvrLoginTlsReq authSvrLoginTlsReq) {
            super(authSvrLoginTlsReq);
            if (authSvrLoginTlsReq != null) {
                this.phone_num = authSvrLoginTlsReq.phone_num;
                this.token = authSvrLoginTlsReq.token;
                this.role = authSvrLoginTlsReq.role;
            }
        }

        public Builder phone_num(String str) {
            this.phone_num = str;
            return this;
        }

        public Builder token(ByteString byteString) {
            this.token = byteString;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public AuthSvrLoginTlsReq build() {
            checkRequiredFields();
            return new AuthSvrLoginTlsReq(this);
        }
    }
}
