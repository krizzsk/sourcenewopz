package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class AuthSvrSignReq extends Message {
    public static final ByteString DEFAULT_CONTENT = ByteString.EMPTY;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.BYTES)
    public final ByteString content;

    public AuthSvrSignReq(ByteString byteString) {
        this.content = byteString;
    }

    private AuthSvrSignReq(Builder builder) {
        this(builder.content);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthSvrSignReq)) {
            return false;
        }
        return equals((Object) this.content, (Object) ((AuthSvrSignReq) obj).content);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            ByteString byteString = this.content;
            i = byteString != null ? byteString.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<AuthSvrSignReq> {
        public ByteString content;

        public Builder() {
        }

        public Builder(AuthSvrSignReq authSvrSignReq) {
            super(authSvrSignReq);
            if (authSvrSignReq != null) {
                this.content = authSvrSignReq.content;
            }
        }

        public Builder content(ByteString byteString) {
            this.content = byteString;
            return this;
        }

        public AuthSvrSignReq build() {
            checkRequiredFields();
            return new AuthSvrSignReq(this);
        }
    }
}
