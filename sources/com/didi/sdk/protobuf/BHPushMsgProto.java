package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BHPushMsgProto extends Message {
    public static final String DEFAULT_MSG_CONTENT = "";
    public static final Integer DEFAULT_MSG_TYPE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg_content;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer msg_type;

    public BHPushMsgProto(Integer num, String str) {
        this.msg_type = num;
        this.msg_content = str;
    }

    private BHPushMsgProto(Builder builder) {
        this(builder.msg_type, builder.msg_content);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BHPushMsgProto)) {
            return false;
        }
        BHPushMsgProto bHPushMsgProto = (BHPushMsgProto) obj;
        if (!equals((Object) this.msg_type, (Object) bHPushMsgProto.msg_type) || !equals((Object) this.msg_content, (Object) bHPushMsgProto.msg_content)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.msg_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg_content;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BHPushMsgProto> {
        public String msg_content;
        public Integer msg_type;

        public Builder() {
        }

        public Builder(BHPushMsgProto bHPushMsgProto) {
            super(bHPushMsgProto);
            if (bHPushMsgProto != null) {
                this.msg_type = bHPushMsgProto.msg_type;
                this.msg_content = bHPushMsgProto.msg_content;
            }
        }

        public Builder msg_type(Integer num) {
            this.msg_type = num;
            return this;
        }

        public Builder msg_content(String str) {
            this.msg_content = str;
            return this;
        }

        public BHPushMsgProto build() {
            checkRequiredFields();
            return new BHPushMsgProto(this);
        }
    }
}
