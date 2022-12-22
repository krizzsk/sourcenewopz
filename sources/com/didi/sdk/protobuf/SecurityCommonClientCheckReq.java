package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SecurityCommonClientCheckReq extends Message {
    public static final Integer DEFAULT_CMDID = 0;
    public static final Integer DEFAULT_CMDTYPE = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer cmdId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer cmdType;

    public SecurityCommonClientCheckReq(Integer num, Integer num2) {
        this.cmdId = num;
        this.cmdType = num2;
    }

    private SecurityCommonClientCheckReq(Builder builder) {
        this(builder.cmdId, builder.cmdType);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecurityCommonClientCheckReq)) {
            return false;
        }
        SecurityCommonClientCheckReq securityCommonClientCheckReq = (SecurityCommonClientCheckReq) obj;
        if (!equals((Object) this.cmdId, (Object) securityCommonClientCheckReq.cmdId) || !equals((Object) this.cmdType, (Object) securityCommonClientCheckReq.cmdType)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.cmdId;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.cmdType;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SecurityCommonClientCheckReq> {
        public Integer cmdId;
        public Integer cmdType;

        public Builder() {
        }

        public Builder(SecurityCommonClientCheckReq securityCommonClientCheckReq) {
            super(securityCommonClientCheckReq);
            if (securityCommonClientCheckReq != null) {
                this.cmdId = securityCommonClientCheckReq.cmdId;
                this.cmdType = securityCommonClientCheckReq.cmdType;
            }
        }

        public Builder cmdId(Integer num) {
            this.cmdId = num;
            return this;
        }

        public Builder cmdType(Integer num) {
            this.cmdType = num;
            return this;
        }

        public SecurityCommonClientCheckReq build() {
            return new SecurityCommonClientCheckReq(this);
        }
    }
}
