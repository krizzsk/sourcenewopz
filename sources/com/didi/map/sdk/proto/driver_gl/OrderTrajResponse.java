package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class OrderTrajResponse extends Message {
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    public static final List<DiffGeoPoints> DEFAULT_TRAJS = Collections.emptyList();
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(label = Message.Label.REPEATED, messageType = DiffGeoPoints.class, tag = 4)
    public final List<DiffGeoPoints> trajs;

    public OrderTrajResponse(Integer num, String str, Long l, List<DiffGeoPoints> list) {
        this.ret = num;
        this.msg = str;
        this.logId = l;
        this.trajs = immutableCopyOf(list);
    }

    private OrderTrajResponse(Builder builder) {
        this(builder.ret, builder.msg, builder.logId, builder.trajs);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderTrajResponse)) {
            return false;
        }
        OrderTrajResponse orderTrajResponse = (OrderTrajResponse) obj;
        if (!equals((Object) this.ret, (Object) orderTrajResponse.ret) || !equals((Object) this.msg, (Object) orderTrajResponse.msg) || !equals((Object) this.logId, (Object) orderTrajResponse.logId) || !equals((List<?>) this.trajs, (List<?>) orderTrajResponse.trajs)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ret;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.logId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<DiffGeoPoints> list = this.trajs;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<OrderTrajResponse> {
        public Long logId;
        public String msg;
        public Integer ret;
        public List<DiffGeoPoints> trajs;

        public Builder() {
        }

        public Builder(OrderTrajResponse orderTrajResponse) {
            super(orderTrajResponse);
            if (orderTrajResponse != null) {
                this.ret = orderTrajResponse.ret;
                this.msg = orderTrajResponse.msg;
                this.logId = orderTrajResponse.logId;
                this.trajs = OrderTrajResponse.copyOf(orderTrajResponse.trajs);
            }
        }

        public Builder ret(Integer num) {
            this.ret = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public Builder trajs(List<DiffGeoPoints> list) {
            this.trajs = checkForNulls(list);
            return this;
        }

        public OrderTrajResponse build() {
            checkRequiredFields();
            return new OrderTrajResponse(this);
        }
    }
}
