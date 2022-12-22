package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PushSvrMultiRsp extends Message {
    public static final List<RspMsg> DEFAULT_RSPS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = RspMsg.class, tag = 1)
    public final List<RspMsg> rsps;

    public PushSvrMultiRsp(List<RspMsg> list) {
        this.rsps = immutableCopyOf(list);
    }

    private PushSvrMultiRsp(Builder builder) {
        this(builder.rsps);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushSvrMultiRsp)) {
            return false;
        }
        return equals((List<?>) this.rsps, (List<?>) ((PushSvrMultiRsp) obj).rsps);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<RspMsg> list = this.rsps;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<PushSvrMultiRsp> {
        public List<RspMsg> rsps;

        public Builder() {
        }

        public Builder(PushSvrMultiRsp pushSvrMultiRsp) {
            super(pushSvrMultiRsp);
            if (pushSvrMultiRsp != null) {
                this.rsps = PushSvrMultiRsp.copyOf(pushSvrMultiRsp.rsps);
            }
        }

        public Builder rsps(List<RspMsg> list) {
            this.rsps = checkForNulls(list);
            return this;
        }

        public PushSvrMultiRsp build() {
            return new PushSvrMultiRsp(this);
        }
    }
}
