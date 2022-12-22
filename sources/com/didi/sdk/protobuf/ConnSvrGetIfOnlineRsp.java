package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ConnSvrGetIfOnlineRsp extends Message {
    public static final List<Long> DEFAULT_USER_ID = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.UINT64)
    public final List<Long> user_id;

    public ConnSvrGetIfOnlineRsp(List<Long> list) {
        this.user_id = immutableCopyOf(list);
    }

    private ConnSvrGetIfOnlineRsp(Builder builder) {
        this(builder.user_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnSvrGetIfOnlineRsp)) {
            return false;
        }
        return equals((List<?>) this.user_id, (List<?>) ((ConnSvrGetIfOnlineRsp) obj).user_id);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<Long> list = this.user_id;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ConnSvrGetIfOnlineRsp> {
        public List<Long> user_id;

        public Builder() {
        }

        public Builder(ConnSvrGetIfOnlineRsp connSvrGetIfOnlineRsp) {
            super(connSvrGetIfOnlineRsp);
            if (connSvrGetIfOnlineRsp != null) {
                this.user_id = ConnSvrGetIfOnlineRsp.copyOf(connSvrGetIfOnlineRsp.user_id);
            }
        }

        public Builder user_id(List<Long> list) {
            this.user_id = checkForNulls(list);
            return this;
        }

        public ConnSvrGetIfOnlineRsp build() {
            return new ConnSvrGetIfOnlineRsp(this);
        }
    }
}
