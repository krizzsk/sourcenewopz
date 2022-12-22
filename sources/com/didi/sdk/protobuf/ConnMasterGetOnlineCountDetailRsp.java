package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterGetOnlineCountDetailRsp extends Message {
    public static final Long DEFAULT_COUNT = 0L;
    public static final Long DEFAULT_TESTING_COUNT = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)
    public final Long count;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT64)
    public final Long testing_count;

    public ConnMasterGetOnlineCountDetailRsp(RspMsg rspMsg, Long l, Long l2) {
        this.rsp_msg = rspMsg;
        this.count = l;
        this.testing_count = l2;
    }

    private ConnMasterGetOnlineCountDetailRsp(Builder builder) {
        this(builder.rsp_msg, builder.count, builder.testing_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterGetOnlineCountDetailRsp)) {
            return false;
        }
        ConnMasterGetOnlineCountDetailRsp connMasterGetOnlineCountDetailRsp = (ConnMasterGetOnlineCountDetailRsp) obj;
        if (!equals((Object) this.rsp_msg, (Object) connMasterGetOnlineCountDetailRsp.rsp_msg) || !equals((Object) this.count, (Object) connMasterGetOnlineCountDetailRsp.count) || !equals((Object) this.testing_count, (Object) connMasterGetOnlineCountDetailRsp.testing_count)) {
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
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.testing_count;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConnMasterGetOnlineCountDetailRsp> {
        public Long count;
        public RspMsg rsp_msg;
        public Long testing_count;

        public Builder() {
        }

        public Builder(ConnMasterGetOnlineCountDetailRsp connMasterGetOnlineCountDetailRsp) {
            super(connMasterGetOnlineCountDetailRsp);
            if (connMasterGetOnlineCountDetailRsp != null) {
                this.rsp_msg = connMasterGetOnlineCountDetailRsp.rsp_msg;
                this.count = connMasterGetOnlineCountDetailRsp.count;
                this.testing_count = connMasterGetOnlineCountDetailRsp.testing_count;
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

        public Builder testing_count(Long l) {
            this.testing_count = l;
            return this;
        }

        public ConnMasterGetOnlineCountDetailRsp build() {
            checkRequiredFields();
            return new ConnMasterGetOnlineCountDetailRsp(this);
        }
    }
}
