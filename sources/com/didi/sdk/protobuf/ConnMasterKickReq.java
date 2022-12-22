package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterKickReq extends Message {
    public static final Integer DEFAULT_ROLE = 0;
    public static final Long DEFAULT_USER_ID = 0L;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long user_id;

    public ConnMasterKickReq(Long l, Integer num) {
        this.user_id = l;
        this.role = num;
    }

    private ConnMasterKickReq(Builder builder) {
        this(builder.user_id, builder.role);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterKickReq)) {
            return false;
        }
        ConnMasterKickReq connMasterKickReq = (ConnMasterKickReq) obj;
        if (!equals((Object) this.user_id, (Object) connMasterKickReq.user_id) || !equals((Object) this.role, (Object) connMasterKickReq.role)) {
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
        Integer num = this.role;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConnMasterKickReq> {
        public Integer role;
        public Long user_id;

        public Builder() {
        }

        public Builder(ConnMasterKickReq connMasterKickReq) {
            super(connMasterKickReq);
            if (connMasterKickReq != null) {
                this.user_id = connMasterKickReq.user_id;
                this.role = connMasterKickReq.role;
            }
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public ConnMasterKickReq build() {
            checkRequiredFields();
            return new ConnMasterKickReq(this);
        }
    }
}
