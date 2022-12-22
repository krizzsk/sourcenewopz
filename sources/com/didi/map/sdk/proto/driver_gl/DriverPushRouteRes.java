package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DriverPushRouteRes extends Message {
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    public static final List<Long> DEFAULT_ROUTEIDS = Collections.emptyList();
    @ProtoField(tag = 5, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 4)
    public final PickupHint pickupHint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> routeIds;

    public DriverPushRouteRes(Integer num, String str, List<Long> list, PickupHint pickupHint2, Long l) {
        this.ret = num;
        this.msg = str;
        this.routeIds = immutableCopyOf(list);
        this.pickupHint = pickupHint2;
        this.logId = l;
    }

    private DriverPushRouteRes(Builder builder) {
        this(builder.ret, builder.msg, builder.routeIds, builder.pickupHint, builder.logId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverPushRouteRes)) {
            return false;
        }
        DriverPushRouteRes driverPushRouteRes = (DriverPushRouteRes) obj;
        if (!equals((Object) this.ret, (Object) driverPushRouteRes.ret) || !equals((Object) this.msg, (Object) driverPushRouteRes.msg) || !equals((List<?>) this.routeIds, (List<?>) driverPushRouteRes.routeIds) || !equals((Object) this.pickupHint, (Object) driverPushRouteRes.pickupHint) || !equals((Object) this.logId, (Object) driverPushRouteRes.logId)) {
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
        List<Long> list = this.routeIds;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        PickupHint pickupHint2 = this.pickupHint;
        int hashCode4 = (hashCode3 + (pickupHint2 != null ? pickupHint2.hashCode() : 0)) * 37;
        Long l = this.logId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverPushRouteRes> {
        public Long logId;
        public String msg;
        public PickupHint pickupHint;
        public Integer ret;
        public List<Long> routeIds;

        public Builder() {
        }

        public Builder(DriverPushRouteRes driverPushRouteRes) {
            super(driverPushRouteRes);
            if (driverPushRouteRes != null) {
                this.ret = driverPushRouteRes.ret;
                this.msg = driverPushRouteRes.msg;
                this.routeIds = DriverPushRouteRes.copyOf(driverPushRouteRes.routeIds);
                this.pickupHint = driverPushRouteRes.pickupHint;
                this.logId = driverPushRouteRes.logId;
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

        public Builder routeIds(List<Long> list) {
            this.routeIds = checkForNulls(list);
            return this;
        }

        public Builder pickupHint(PickupHint pickupHint2) {
            this.pickupHint = pickupHint2;
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public DriverPushRouteRes build() {
            checkRequiredFields();
            return new DriverPushRouteRes(this);
        }
    }
}
