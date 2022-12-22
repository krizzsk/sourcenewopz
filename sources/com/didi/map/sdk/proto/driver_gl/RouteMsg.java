package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RouteMsg extends Message {
    public static final String DEFAULT_MSGSTR = "";
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msgStr;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public RouteMsg(Integer num, String str) {
        this.type = num;
        this.msgStr = str;
    }

    private RouteMsg(Builder builder) {
        this(builder.type, builder.msgStr);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteMsg)) {
            return false;
        }
        RouteMsg routeMsg = (RouteMsg) obj;
        if (!equals((Object) this.type, (Object) routeMsg.type) || !equals((Object) this.msgStr, (Object) routeMsg.msgStr)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msgStr;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RouteMsg> {
        public String msgStr;
        public Integer type;

        public Builder() {
        }

        public Builder(RouteMsg routeMsg) {
            super(routeMsg);
            if (routeMsg != null) {
                this.type = routeMsg.type;
                this.msgStr = routeMsg.msgStr;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder msgStr(String str) {
            this.msgStr = str;
            return this;
        }

        public RouteMsg build() {
            checkRequiredFields();
            return new RouteMsg(this);
        }
    }
}
