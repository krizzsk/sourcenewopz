package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class NotifyMsg extends Message {
    public static final ByteString DEFAULT_MSG = ByteString.EMPTY;
    public static final NotifyMsgType DEFAULT_TYPE = NotifyMsgType.PullNavi;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final ByteString msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.ENUM)
    public final NotifyMsgType type;

    public NotifyMsg(NotifyMsgType notifyMsgType, ByteString byteString) {
        this.type = notifyMsgType;
        this.msg = byteString;
    }

    private NotifyMsg(Builder builder) {
        this(builder.type, builder.msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NotifyMsg)) {
            return false;
        }
        NotifyMsg notifyMsg = (NotifyMsg) obj;
        if (!equals((Object) this.type, (Object) notifyMsg.type) || !equals((Object) this.msg, (Object) notifyMsg.msg)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        NotifyMsgType notifyMsgType = this.type;
        int i2 = 0;
        int hashCode = (notifyMsgType != null ? notifyMsgType.hashCode() : 0) * 37;
        ByteString byteString = this.msg;
        if (byteString != null) {
            i2 = byteString.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<NotifyMsg> {
        public ByteString msg;
        public NotifyMsgType type;

        public Builder() {
        }

        public Builder(NotifyMsg notifyMsg) {
            super(notifyMsg);
            if (notifyMsg != null) {
                this.type = notifyMsg.type;
                this.msg = notifyMsg.msg;
            }
        }

        public Builder type(NotifyMsgType notifyMsgType) {
            this.type = notifyMsgType;
            return this;
        }

        public Builder msg(ByteString byteString) {
            this.msg = byteString;
            return this;
        }

        public NotifyMsg build() {
            checkRequiredFields();
            return new NotifyMsg(this);
        }
    }
}
