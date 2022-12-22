package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class MsgCenterNotificationReq extends Message {
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public MsgCenterNotificationReq(Integer num, String str) {
        this.type = num;
        this.msg = str;
    }

    private MsgCenterNotificationReq(Builder builder) {
        this(builder.type, builder.msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MsgCenterNotificationReq)) {
            return false;
        }
        MsgCenterNotificationReq msgCenterNotificationReq = (MsgCenterNotificationReq) obj;
        if (!equals((Object) this.type, (Object) msgCenterNotificationReq.type) || !equals((Object) this.msg, (Object) msgCenterNotificationReq.msg)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MsgCenterNotificationReq> {
        public String msg;
        public Integer type;

        public Builder() {
        }

        public Builder(MsgCenterNotificationReq msgCenterNotificationReq) {
            super(msgCenterNotificationReq);
            if (msgCenterNotificationReq != null) {
                this.type = msgCenterNotificationReq.type;
                this.msg = msgCenterNotificationReq.msg;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public MsgCenterNotificationReq build() {
            checkRequiredFields();
            return new MsgCenterNotificationReq(this);
        }
    }
}
