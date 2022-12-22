package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PushSvrRetryReq extends Message {
    public static final Long DEFAULT_MESSAGE_ID = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)
    public final Long message_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final PushSvrReq msg;

    public PushSvrRetryReq(PushSvrReq pushSvrReq, Long l) {
        this.msg = pushSvrReq;
        this.message_id = l;
    }

    private PushSvrRetryReq(Builder builder) {
        this(builder.msg, builder.message_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushSvrRetryReq)) {
            return false;
        }
        PushSvrRetryReq pushSvrRetryReq = (PushSvrRetryReq) obj;
        if (!equals((Object) this.msg, (Object) pushSvrRetryReq.msg) || !equals((Object) this.message_id, (Object) pushSvrRetryReq.message_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        PushSvrReq pushSvrReq = this.msg;
        int i2 = 0;
        int hashCode = (pushSvrReq != null ? pushSvrReq.hashCode() : 0) * 37;
        Long l = this.message_id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PushSvrRetryReq> {
        public Long message_id;
        public PushSvrReq msg;

        public Builder() {
        }

        public Builder(PushSvrRetryReq pushSvrRetryReq) {
            super(pushSvrRetryReq);
            if (pushSvrRetryReq != null) {
                this.msg = pushSvrRetryReq.msg;
                this.message_id = pushSvrRetryReq.message_id;
            }
        }

        public Builder msg(PushSvrReq pushSvrReq) {
            this.msg = pushSvrReq;
            return this;
        }

        public Builder message_id(Long l) {
            this.message_id = l;
            return this;
        }

        public PushSvrRetryReq build() {
            checkRequiredFields();
            return new PushSvrRetryReq(this);
        }
    }
}
