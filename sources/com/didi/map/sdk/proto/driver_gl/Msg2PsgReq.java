package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Msg2PsgReq extends Message {
    public static final Integer DEFAULT_LINEVISIBLE = -1;
    public static final Integer DEFAULT_POINTTYPE = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer lineVisible;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer pointType;

    public Msg2PsgReq(Integer num, Integer num2) {
        this.lineVisible = num;
        this.pointType = num2;
    }

    private Msg2PsgReq(Builder builder) {
        this(builder.lineVisible, builder.pointType);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Msg2PsgReq)) {
            return false;
        }
        Msg2PsgReq msg2PsgReq = (Msg2PsgReq) obj;
        if (!equals((Object) this.lineVisible, (Object) msg2PsgReq.lineVisible) || !equals((Object) this.pointType, (Object) msg2PsgReq.pointType)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.lineVisible;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.pointType;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Msg2PsgReq> {
        public Integer lineVisible;
        public Integer pointType;

        public Builder() {
        }

        public Builder(Msg2PsgReq msg2PsgReq) {
            super(msg2PsgReq);
            if (msg2PsgReq != null) {
                this.lineVisible = msg2PsgReq.lineVisible;
                this.pointType = msg2PsgReq.pointType;
            }
        }

        public Builder lineVisible(Integer num) {
            this.lineVisible = num;
            return this;
        }

        public Builder pointType(Integer num) {
            this.pointType = num;
            return this;
        }

        public Msg2PsgReq build() {
            return new Msg2PsgReq(this);
        }
    }
}
