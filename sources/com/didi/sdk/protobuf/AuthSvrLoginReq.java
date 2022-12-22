package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class AuthSvrLoginReq extends Message {
    public static final String DEFAULT_PHONE_NUM = "";
    public static final ByteString DEFAULT_RANDOM_MSG = ByteString.EMPTY;
    public static final Integer DEFAULT_ROLE = 0;
    public static final ByteString DEFAULT_SECRET_CHAP = ByteString.EMPTY;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String phone_num;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.BYTES)
    public final ByteString random_msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BYTES)
    public final ByteString secret_chap;

    public AuthSvrLoginReq(String str, ByteString byteString, ByteString byteString2, Integer num) {
        this.phone_num = str;
        this.secret_chap = byteString;
        this.random_msg = byteString2;
        this.role = num;
    }

    private AuthSvrLoginReq(Builder builder) {
        this(builder.phone_num, builder.secret_chap, builder.random_msg, builder.role);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthSvrLoginReq)) {
            return false;
        }
        AuthSvrLoginReq authSvrLoginReq = (AuthSvrLoginReq) obj;
        if (!equals((Object) this.phone_num, (Object) authSvrLoginReq.phone_num) || !equals((Object) this.secret_chap, (Object) authSvrLoginReq.secret_chap) || !equals((Object) this.random_msg, (Object) authSvrLoginReq.random_msg) || !equals((Object) this.role, (Object) authSvrLoginReq.role)) {
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
        ByteString byteString = this.secret_chap;
        int hashCode2 = (hashCode + (byteString != null ? byteString.hashCode() : 0)) * 37;
        ByteString byteString2 = this.random_msg;
        int hashCode3 = (hashCode2 + (byteString2 != null ? byteString2.hashCode() : 0)) * 37;
        Integer num = this.role;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AuthSvrLoginReq> {
        public String phone_num;
        public ByteString random_msg;
        public Integer role;
        public ByteString secret_chap;

        public Builder() {
        }

        public Builder(AuthSvrLoginReq authSvrLoginReq) {
            super(authSvrLoginReq);
            if (authSvrLoginReq != null) {
                this.phone_num = authSvrLoginReq.phone_num;
                this.secret_chap = authSvrLoginReq.secret_chap;
                this.random_msg = authSvrLoginReq.random_msg;
                this.role = authSvrLoginReq.role;
            }
        }

        public Builder phone_num(String str) {
            this.phone_num = str;
            return this;
        }

        public Builder secret_chap(ByteString byteString) {
            this.secret_chap = byteString;
            return this;
        }

        public Builder random_msg(ByteString byteString) {
            this.random_msg = byteString;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public AuthSvrLoginReq build() {
            checkRequiredFields();
            return new AuthSvrLoginReq(this);
        }
    }
}
