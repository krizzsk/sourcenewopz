package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RouteInfo extends Message {
    public static final List<LinkInfo> DEFAULT_LINKINFOES = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = LinkInfo.class, tag = 1)
    public final List<LinkInfo> linkInfoes;

    public RouteInfo(List<LinkInfo> list) {
        this.linkInfoes = immutableCopyOf(list);
    }

    private RouteInfo(Builder builder) {
        this(builder.linkInfoes);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteInfo)) {
            return false;
        }
        return equals((List<?>) this.linkInfoes, (List<?>) ((RouteInfo) obj).linkInfoes);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<LinkInfo> list = this.linkInfoes;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<RouteInfo> {
        public List<LinkInfo> linkInfoes;

        public Builder() {
        }

        public Builder(RouteInfo routeInfo) {
            super(routeInfo);
            if (routeInfo != null) {
                this.linkInfoes = RouteInfo.copyOf(routeInfo.linkInfoes);
            }
        }

        public Builder linkInfoes(List<LinkInfo> list) {
            this.linkInfoes = checkForNulls(list);
            return this;
        }

        public RouteInfo build() {
            return new RouteInfo(this);
        }
    }
}
