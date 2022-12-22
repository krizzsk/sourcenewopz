package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnSvrGetOnlineCountRsp extends Message {
    public static final Long DEFAULT_COUNT = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)
    public final Long count;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;

    public ConnSvrGetOnlineCountRsp(RspMsg rspMsg, Long l) {
        this.rsp_msg = rspMsg;
        this.count = l;
    }

    private ConnSvrGetOnlineCountRsp(Builder builder) {
        this(builder.rsp_msg, builder.count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnSvrGetOnlineCountRsp)) {
            return false;
        }
        ConnSvrGetOnlineCountRsp connSvrGetOnlineCountRsp = (ConnSvrGetOnlineCountRsp) obj;
        if (!equals((Object) this.rsp_msg, (Object) connSvrGetOnlineCountRsp.rsp_msg) || !equals((Object) this.count, (Object) connSvrGetOnlineCountRsp.count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RspMsg rspMsg = this.rsp_msg;
        int i2 = 0;
        int hashCode = (rspMsg != null ? rspMsg.hashCode() : 0) * 37;
        Long l = this.count;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConnSvrGetOnlineCountRsp> {
        public Long count;
        public RspMsg rsp_msg;

        public Builder() {
        }

        public Builder(ConnSvrGetOnlineCountRsp connSvrGetOnlineCountRsp) {
            super(connSvrGetOnlineCountRsp);
            if (connSvrGetOnlineCountRsp != null) {
                this.rsp_msg = connSvrGetOnlineCountRsp.rsp_msg;
                this.count = connSvrGetOnlineCountRsp.count;
            }
        }

        public Builder rsp_msg(RspMsg rspMsg) {
            this.rsp_msg = rspMsg;
            return this;
        }

        public Builder count(Long l) {
            this.count = l;
            return this;
        }

        public ConnSvrGetOnlineCountRsp build() {
            checkRequiredFields();
            return new ConnSvrGetOnlineCountRsp(this);
        }
    }
}
