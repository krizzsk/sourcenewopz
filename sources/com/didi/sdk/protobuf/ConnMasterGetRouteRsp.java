package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterGetRouteRsp extends Message {
    @ProtoField(tag = 2)
    public final Address conn_svr;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;

    public ConnMasterGetRouteRsp(RspMsg rspMsg, Address address) {
        this.rsp_msg = rspMsg;
        this.conn_svr = address;
    }

    private ConnMasterGetRouteRsp(Builder builder) {
        this(builder.rsp_msg, builder.conn_svr);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterGetRouteRsp)) {
            return false;
        }
        ConnMasterGetRouteRsp connMasterGetRouteRsp = (ConnMasterGetRouteRsp) obj;
        if (!equals((Object) this.rsp_msg, (Object) connMasterGetRouteRsp.rsp_msg) || !equals((Object) this.conn_svr, (Object) connMasterGetRouteRsp.conn_svr)) {
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
        Address address = this.conn_svr;
        if (address != null) {
            i2 = address.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConnMasterGetRouteRsp> {
        public Address conn_svr;
        public RspMsg rsp_msg;

        public Builder() {
        }

        public Builder(ConnMasterGetRouteRsp connMasterGetRouteRsp) {
            super(connMasterGetRouteRsp);
            if (connMasterGetRouteRsp != null) {
                this.rsp_msg = connMasterGetRouteRsp.rsp_msg;
                this.conn_svr = connMasterGetRouteRsp.conn_svr;
            }
        }

        public Builder rsp_msg(RspMsg rspMsg) {
            this.rsp_msg = rspMsg;
            return this;
        }

        public Builder conn_svr(Address address) {
            this.conn_svr = address;
            return this;
        }

        public ConnMasterGetRouteRsp build() {
            checkRequiredFields();
            return new ConnMasterGetRouteRsp(this);
        }
    }
}
