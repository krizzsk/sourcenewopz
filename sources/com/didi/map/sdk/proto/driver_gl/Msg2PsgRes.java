package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Msg2PsgRes extends Message {
    public static final Integer DEFAULT_LINEVISIBLE = -1;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer lineVisible;

    public Msg2PsgRes(Integer num) {
        this.lineVisible = num;
    }

    private Msg2PsgRes(Builder builder) {
        this(builder.lineVisible);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Msg2PsgRes)) {
            return false;
        }
        return equals((Object) this.lineVisible, (Object) ((Msg2PsgRes) obj).lineVisible);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.lineVisible;
            i = num != null ? num.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<Msg2PsgRes> {
        public Integer lineVisible;

        public Builder() {
        }

        public Builder(Msg2PsgRes msg2PsgRes) {
            super(msg2PsgRes);
            if (msg2PsgRes != null) {
                this.lineVisible = msg2PsgRes.lineVisible;
            }
        }

        public Builder lineVisible(Integer num) {
            this.lineVisible = num;
            return this;
        }

        public Msg2PsgRes build() {
            return new Msg2PsgRes(this);
        }
    }
}
