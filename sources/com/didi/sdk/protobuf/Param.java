package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class Param extends Message {
    public static final ByteString DEFAULT_DATA = ByteString.EMPTY;
    public static final ByteString DEFAULT_KEY = ByteString.EMPTY;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.BYTES)
    public final ByteString data;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.BYTES)
    public final ByteString key;

    public Param(ByteString byteString, ByteString byteString2) {
        this.key = byteString;
        this.data = byteString2;
    }

    private Param(Builder builder) {
        this(builder.key, builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Param)) {
            return false;
        }
        Param param = (Param) obj;
        if (!equals((Object) this.key, (Object) param.key) || !equals((Object) this.data, (Object) param.data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ByteString byteString = this.key;
        int i2 = 0;
        int hashCode = (byteString != null ? byteString.hashCode() : 0) * 37;
        ByteString byteString2 = this.data;
        if (byteString2 != null) {
            i2 = byteString2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Param> {
        public ByteString data;
        public ByteString key;

        public Builder() {
        }

        public Builder(Param param) {
            super(param);
            if (param != null) {
                this.key = param.key;
                this.data = param.data;
            }
        }

        public Builder key(ByteString byteString) {
            this.key = byteString;
            return this;
        }

        public Builder data(ByteString byteString) {
            this.data = byteString;
            return this;
        }

        public Param build() {
            checkRequiredFields();
            return new Param(this);
        }
    }
}
