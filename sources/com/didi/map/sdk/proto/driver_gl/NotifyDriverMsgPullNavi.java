package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class NotifyDriverMsgPullNavi extends Message {
    public static final String DEFAULT_PSGMULTIROUTETRACEID = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String psgMultiRouteTraceId;

    public NotifyDriverMsgPullNavi(String str) {
        this.psgMultiRouteTraceId = str;
    }

    private NotifyDriverMsgPullNavi(Builder builder) {
        this(builder.psgMultiRouteTraceId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NotifyDriverMsgPullNavi)) {
            return false;
        }
        return equals((Object) this.psgMultiRouteTraceId, (Object) ((NotifyDriverMsgPullNavi) obj).psgMultiRouteTraceId);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.psgMultiRouteTraceId;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<NotifyDriverMsgPullNavi> {
        public String psgMultiRouteTraceId;

        public Builder() {
        }

        public Builder(NotifyDriverMsgPullNavi notifyDriverMsgPullNavi) {
            super(notifyDriverMsgPullNavi);
            if (notifyDriverMsgPullNavi != null) {
                this.psgMultiRouteTraceId = notifyDriverMsgPullNavi.psgMultiRouteTraceId;
            }
        }

        public Builder psgMultiRouteTraceId(String str) {
            this.psgMultiRouteTraceId = str;
            return this;
        }

        public NotifyDriverMsgPullNavi build() {
            return new NotifyDriverMsgPullNavi(this);
        }
    }
}
