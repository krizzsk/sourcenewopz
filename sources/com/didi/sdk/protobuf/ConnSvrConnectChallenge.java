package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class ConnSvrConnectChallenge extends Message {
    public static final ByteString DEFAULT_RANDOM_MSG = ByteString.EMPTY;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.BYTES)
    public final ByteString random_msg;

    public ConnSvrConnectChallenge(ByteString byteString) {
        this.random_msg = byteString;
    }

    private ConnSvrConnectChallenge(Builder builder) {
        this(builder.random_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnSvrConnectChallenge)) {
            return false;
        }
        return equals((Object) this.random_msg, (Object) ((ConnSvrConnectChallenge) obj).random_msg);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            ByteString byteString = this.random_msg;
            i = byteString != null ? byteString.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ConnSvrConnectChallenge> {
        public ByteString random_msg;

        public Builder() {
        }

        public Builder(ConnSvrConnectChallenge connSvrConnectChallenge) {
            super(connSvrConnectChallenge);
            if (connSvrConnectChallenge != null) {
                this.random_msg = connSvrConnectChallenge.random_msg;
            }
        }

        public Builder random_msg(ByteString byteString) {
            this.random_msg = byteString;
            return this;
        }

        public ConnSvrConnectChallenge build() {
            checkRequiredFields();
            return new ConnSvrConnectChallenge(this);
        }
    }
}
