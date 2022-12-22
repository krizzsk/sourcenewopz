package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RspMsg extends Message {
    public static final Integer DEFAULT_RSP_CODE = 0;
    public static final String DEFAULT_RSP_MSG = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer rsp_code;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String rsp_msg;

    public RspMsg(Integer num, String str) {
        this.rsp_code = num;
        this.rsp_msg = str;
    }

    private RspMsg(Builder builder) {
        this(builder.rsp_code, builder.rsp_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RspMsg)) {
            return false;
        }
        RspMsg rspMsg = (RspMsg) obj;
        if (!equals((Object) this.rsp_code, (Object) rspMsg.rsp_code) || !equals((Object) this.rsp_msg, (Object) rspMsg.rsp_msg)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.rsp_code;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.rsp_msg;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RspMsg> {
        public Integer rsp_code;
        public String rsp_msg;

        public Builder() {
        }

        public Builder(RspMsg rspMsg) {
            super(rspMsg);
            if (rspMsg != null) {
                this.rsp_code = rspMsg.rsp_code;
                this.rsp_msg = rspMsg.rsp_msg;
            }
        }

        public Builder rsp_code(Integer num) {
            this.rsp_code = num;
            return this;
        }

        public Builder rsp_msg(String str) {
            this.rsp_msg = str;
            return this;
        }

        public RspMsg build() {
            checkRequiredFields();
            return new RspMsg(this);
        }
    }
}
