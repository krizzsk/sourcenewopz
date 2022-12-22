package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShareTravelReq extends Message {
    public static final Long DEFAULT_LASTROUTEID = 0L;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long lastRouteId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final OrderInfo orderInfo;

    public ShareTravelReq(OrderInfo orderInfo2, Long l) {
        this.orderInfo = orderInfo2;
        this.lastRouteId = l;
    }

    private ShareTravelReq(Builder builder) {
        this(builder.orderInfo, builder.lastRouteId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShareTravelReq)) {
            return false;
        }
        ShareTravelReq shareTravelReq = (ShareTravelReq) obj;
        if (!equals((Object) this.orderInfo, (Object) shareTravelReq.orderInfo) || !equals((Object) this.lastRouteId, (Object) shareTravelReq.lastRouteId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        OrderInfo orderInfo2 = this.orderInfo;
        int i2 = 0;
        int hashCode = (orderInfo2 != null ? orderInfo2.hashCode() : 0) * 37;
        Long l = this.lastRouteId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShareTravelReq> {
        public Long lastRouteId;
        public OrderInfo orderInfo;

        public Builder() {
        }

        public Builder(ShareTravelReq shareTravelReq) {
            super(shareTravelReq);
            if (shareTravelReq != null) {
                this.orderInfo = shareTravelReq.orderInfo;
                this.lastRouteId = shareTravelReq.lastRouteId;
            }
        }

        public Builder orderInfo(OrderInfo orderInfo2) {
            this.orderInfo = orderInfo2;
            return this;
        }

        public Builder lastRouteId(Long l) {
            this.lastRouteId = l;
            return this;
        }

        public ShareTravelReq build() {
            checkRequiredFields();
            return new ShareTravelReq(this);
        }
    }
}
