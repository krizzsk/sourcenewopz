package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ConnMasterGetIfOnlineReq extends Message {
    public static final Integer DEFAULT_ROLE = 0;
    public static final List<Long> DEFAULT_USER_ID = Collections.emptyList();
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.UINT64)
    public final List<Long> user_id;

    public ConnMasterGetIfOnlineReq(List<Long> list, Integer num) {
        this.user_id = immutableCopyOf(list);
        this.role = num;
    }

    private ConnMasterGetIfOnlineReq(Builder builder) {
        this(builder.user_id, builder.role);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnMasterGetIfOnlineReq)) {
            return false;
        }
        ConnMasterGetIfOnlineReq connMasterGetIfOnlineReq = (ConnMasterGetIfOnlineReq) obj;
        if (!equals((List<?>) this.user_id, (List<?>) connMasterGetIfOnlineReq.user_id) || !equals((Object) this.role, (Object) connMasterGetIfOnlineReq.role)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.user_id;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.role;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ConnMasterGetIfOnlineReq> {
        public Integer role;
        public List<Long> user_id;

        public Builder() {
        }

        public Builder(ConnMasterGetIfOnlineReq connMasterGetIfOnlineReq) {
            super(connMasterGetIfOnlineReq);
            if (connMasterGetIfOnlineReq != null) {
                this.user_id = ConnMasterGetIfOnlineReq.copyOf(connMasterGetIfOnlineReq.user_id);
                this.role = connMasterGetIfOnlineReq.role;
            }
        }

        public Builder user_id(List<Long> list) {
            this.user_id = checkForNulls(list);
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public ConnMasterGetIfOnlineReq build() {
            return new ConnMasterGetIfOnlineReq(this);
        }
    }
}
