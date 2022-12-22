package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterGetRouteReq extends Message {
    public static final Long DEFAULT_USER_ID = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long user_id;

    public ConnMasterGetRouteReq(Long l) {
        this.user_id = l;
    }

    private ConnMasterGetRouteReq(Builder builder) {
        this(builder.user_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterGetRouteReq)) {
            return false;
        }
        return equals((Object) this.user_id, (Object) ((ConnMasterGetRouteReq) obj).user_id);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Long l = this.user_id;
            i = l != null ? l.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ConnMasterGetRouteReq> {
        public Long user_id;

        public Builder() {
        }

        public Builder(ConnMasterGetRouteReq connMasterGetRouteReq) {
            super(connMasterGetRouteReq);
            if (connMasterGetRouteReq != null) {
                this.user_id = connMasterGetRouteReq.user_id;
            }
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public ConnMasterGetRouteReq build() {
            checkRequiredFields();
            return new ConnMasterGetRouteReq(this);
        }
    }
}
