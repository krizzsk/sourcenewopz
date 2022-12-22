package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ConnMasterGetOnlineRsp extends Message {
    public static final List<Long> DEFAULT_USER_ID = Collections.emptyList();
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.UINT64)
    public final List<Long> user_id;

    public ConnMasterGetOnlineRsp(RspMsg rspMsg, List<Long> list) {
        this.rsp_msg = rspMsg;
        this.user_id = immutableCopyOf(list);
    }

    private ConnMasterGetOnlineRsp(Builder builder) {
        this(builder.rsp_msg, builder.user_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterGetOnlineRsp)) {
            return false;
        }
        ConnMasterGetOnlineRsp connMasterGetOnlineRsp = (ConnMasterGetOnlineRsp) obj;
        if (!equals((Object) this.rsp_msg, (Object) connMasterGetOnlineRsp.rsp_msg) || !equals((List<?>) this.user_id, (List<?>) connMasterGetOnlineRsp.user_id)) {
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
        int hashCode = (rspMsg != null ? rspMsg.hashCode() : 0) * 37;
        List<Long> list = this.user_id;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ConnMasterGetOnlineRsp> {
        public RspMsg rsp_msg;
        public List<Long> user_id;

        public Builder() {
        }

        public Builder(ConnMasterGetOnlineRsp connMasterGetOnlineRsp) {
            super(connMasterGetOnlineRsp);
            if (connMasterGetOnlineRsp != null) {
                this.rsp_msg = connMasterGetOnlineRsp.rsp_msg;
                this.user_id = ConnMasterGetOnlineRsp.copyOf(connMasterGetOnlineRsp.user_id);
            }
        }

        public Builder rsp_msg(RspMsg rspMsg) {
            this.rsp_msg = rspMsg;
            return this;
        }

        public Builder user_id(List<Long> list) {
            this.user_id = checkForNulls(list);
            return this;
        }

        public ConnMasterGetOnlineRsp build() {
            checkRequiredFields();
            return new ConnMasterGetOnlineRsp(this);
        }
    }
}
