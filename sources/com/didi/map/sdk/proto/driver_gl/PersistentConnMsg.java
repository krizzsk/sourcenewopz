package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class PersistentConnMsg extends Message {
    public static final ByteString DEFAULT_MSG = ByteString.EMPTY;
    public static final Type DEFAULT_TYPE = Type.UnknownType;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final ByteString msg;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final Type type;

    public PersistentConnMsg(Type type2, ByteString byteString) {
        this.type = type2;
        this.msg = byteString;
    }

    private PersistentConnMsg(Builder builder) {
        this(builder.type, builder.msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistentConnMsg)) {
            return false;
        }
        PersistentConnMsg persistentConnMsg = (PersistentConnMsg) obj;
        if (!equals((Object) this.type, (Object) persistentConnMsg.type) || !equals((Object) this.msg, (Object) persistentConnMsg.msg)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Type type2 = this.type;
        int i2 = 0;
        int hashCode = (type2 != null ? type2.hashCode() : 0) * 37;
        ByteString byteString = this.msg;
        if (byteString != null) {
            i2 = byteString.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PersistentConnMsg> {
        public ByteString msg;
        public Type type;

        public Builder() {
        }

        public Builder(PersistentConnMsg persistentConnMsg) {
            super(persistentConnMsg);
            if (persistentConnMsg != null) {
                this.type = persistentConnMsg.type;
                this.msg = persistentConnMsg.msg;
            }
        }

        public Builder type(Type type2) {
            this.type = type2;
            return this;
        }

        public Builder msg(ByteString byteString) {
            this.msg = byteString;
            return this;
        }

        public PersistentConnMsg build() {
            return new PersistentConnMsg(this);
        }
    }

    public enum Type implements ProtoEnum {
        UnknownType(0),
        ReportDrvStatus(1);
        
        private final int value;

        private Type(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
