package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterGetOnlineCountRsp extends Message {
    public static final Long DEFAULT_COUNT = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)
    public final Long count;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;

    public ConnMasterGetOnlineCountRsp(RspMsg rspMsg, Long l) {
        this.rsp_msg = rspMsg;
        this.count = l;
    }

    private ConnMasterGetOnlineCountRsp(Builder builder) {
        this(builder.rsp_msg, builder.count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterGetOnlineCountRsp)) {
            return false;
        }
        ConnMasterGetOnlineCountRsp connMasterGetOnlineCountRsp = (ConnMasterGetOnlineCountRsp) obj;
        if (!equals((Object) this.rsp_msg, (Object) connMasterGetOnlineCountRsp.rsp_msg) || !equals((Object) this.count, (Object) connMasterGetOnlineCountRsp.count)) {
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

    public static final class Builder extends Message.Builder<ConnMasterGetOnlineCountRsp> {
        public Long count;
        public RspMsg rsp_msg;

        public Builder() {
        }

        public Builder(ConnMasterGetOnlineCountRsp connMasterGetOnlineCountRsp) {
            super(connMasterGetOnlineCountRsp);
            if (connMasterGetOnlineCountRsp != null) {
                this.rsp_msg = connMasterGetOnlineCountRsp.rsp_msg;
                this.count = connMasterGetOnlineCountRsp.count;
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

        public ConnMasterGetOnlineCountRsp build() {
            checkRequiredFields();
            return new ConnMasterGetOnlineCountRsp(this);
        }
    }
}
