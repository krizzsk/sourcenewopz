package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterDelRouteReq extends Message {
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Long DEFAULT_USER_ID = 0L;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long user_id;

    public ConnMasterDelRouteReq(Long l, Long l2) {
        this.user_id = l;
        this.timestamp = l2;
    }

    private ConnMasterDelRouteReq(Builder builder) {
        this(builder.user_id, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterDelRouteReq)) {
            return false;
        }
        ConnMasterDelRouteReq connMasterDelRouteReq = (ConnMasterDelRouteReq) obj;
        if (!equals((Object) this.user_id, (Object) connMasterDelRouteReq.user_id) || !equals((Object) this.timestamp, (Object) connMasterDelRouteReq.timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.user_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.timestamp;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConnMasterDelRouteReq> {
        public Long timestamp;
        public Long user_id;

        public Builder() {
        }

        public Builder(ConnMasterDelRouteReq connMasterDelRouteReq) {
            super(connMasterDelRouteReq);
            if (connMasterDelRouteReq != null) {
                this.user_id = connMasterDelRouteReq.user_id;
                this.timestamp = connMasterDelRouteReq.timestamp;
            }
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public ConnMasterDelRouteReq build() {
            checkRequiredFields();
            return new ConnMasterDelRouteReq(this);
        }
    }
}
