package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class MapPassengeOrderRouteNotifyReq extends Message {
    public static final String DEFAULT_NOTIFYMSG = "";
    public static final Integer DEFAULT_NOTIFYTYPE = 0;
    public static final Long DEFAULT_ROUTEID = 0L;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String notifyMsg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer notifyType;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long routeId;

    public MapPassengeOrderRouteNotifyReq(Integer num, String str, Long l) {
        this.notifyType = num;
        this.notifyMsg = str;
        this.routeId = l;
    }

    private MapPassengeOrderRouteNotifyReq(Builder builder) {
        this(builder.notifyType, builder.notifyMsg, builder.routeId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapPassengeOrderRouteNotifyReq)) {
            return false;
        }
        MapPassengeOrderRouteNotifyReq mapPassengeOrderRouteNotifyReq = (MapPassengeOrderRouteNotifyReq) obj;
        if (!equals((Object) this.notifyType, (Object) mapPassengeOrderRouteNotifyReq.notifyType) || !equals((Object) this.notifyMsg, (Object) mapPassengeOrderRouteNotifyReq.notifyMsg) || !equals((Object) this.routeId, (Object) mapPassengeOrderRouteNotifyReq.routeId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.notifyType;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.notifyMsg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.routeId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MapPassengeOrderRouteNotifyReq> {
        public String notifyMsg;
        public Integer notifyType;
        public Long routeId;

        public Builder() {
        }

        public Builder(MapPassengeOrderRouteNotifyReq mapPassengeOrderRouteNotifyReq) {
            super(mapPassengeOrderRouteNotifyReq);
            if (mapPassengeOrderRouteNotifyReq != null) {
                this.notifyType = mapPassengeOrderRouteNotifyReq.notifyType;
                this.notifyMsg = mapPassengeOrderRouteNotifyReq.notifyMsg;
                this.routeId = mapPassengeOrderRouteNotifyReq.routeId;
            }
        }

        public Builder notifyType(Integer num) {
            this.notifyType = num;
            return this;
        }

        public Builder notifyMsg(String str) {
            this.notifyMsg = str;
            return this;
        }

        public Builder routeId(Long l) {
            this.routeId = l;
            return this;
        }

        public MapPassengeOrderRouteNotifyReq build() {
            checkRequiredFields();
            return new MapPassengeOrderRouteNotifyReq(this);
        }
    }
}
