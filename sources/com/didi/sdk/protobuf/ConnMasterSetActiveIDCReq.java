package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConnMasterSetActiveIDCReq extends Message {
    public static final Boolean DEFAULT_ACTIVE = false;
    public static final Integer DEFAULT_ROLE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.BOOL)
    public final Boolean active;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer role;

    public ConnMasterSetActiveIDCReq(Boolean bool, Integer num) {
        this.active = bool;
        this.role = num;
    }

    private ConnMasterSetActiveIDCReq(Builder builder) {
        this(builder.active, builder.role);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterSetActiveIDCReq)) {
            return false;
        }
        ConnMasterSetActiveIDCReq connMasterSetActiveIDCReq = (ConnMasterSetActiveIDCReq) obj;
        if (!equals((Object) this.active, (Object) connMasterSetActiveIDCReq.active) || !equals((Object) this.role, (Object) connMasterSetActiveIDCReq.role)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.active;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        Integer num = this.role;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConnMasterSetActiveIDCReq> {
        public Boolean active;
        public Integer role;

        public Builder() {
        }

        public Builder(ConnMasterSetActiveIDCReq connMasterSetActiveIDCReq) {
            super(connMasterSetActiveIDCReq);
            if (connMasterSetActiveIDCReq != null) {
                this.active = connMasterSetActiveIDCReq.active;
                this.role = connMasterSetActiveIDCReq.role;
            }
        }

        public Builder active(Boolean bool) {
            this.active = bool;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public ConnMasterSetActiveIDCReq build() {
            checkRequiredFields();
            return new ConnMasterSetActiveIDCReq(this);
        }
    }
}
