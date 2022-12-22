package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PassengerWalkRouteRes extends Message {
    public static final List<DoublePoint> DEFAULT_GEOS = Collections.emptyList();
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = DoublePoint.class, tag = 3)
    public final List<DoublePoint> geos;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;

    public PassengerWalkRouteRes(Integer num, String str, List<DoublePoint> list) {
        this.ret = num;
        this.msg = str;
        this.geos = immutableCopyOf(list);
    }

    private PassengerWalkRouteRes(Builder builder) {
        this(builder.ret, builder.msg, builder.geos);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerWalkRouteRes)) {
            return false;
        }
        PassengerWalkRouteRes passengerWalkRouteRes = (PassengerWalkRouteRes) obj;
        if (!equals((Object) this.ret, (Object) passengerWalkRouteRes.ret) || !equals((Object) this.msg, (Object) passengerWalkRouteRes.msg) || !equals((List<?>) this.geos, (List<?>) passengerWalkRouteRes.geos)) {
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
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<DoublePoint> list = this.geos;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<PassengerWalkRouteRes> {
        public List<DoublePoint> geos;
        public String msg;
        public Integer ret;

        public Builder() {
        }

        public Builder(PassengerWalkRouteRes passengerWalkRouteRes) {
            super(passengerWalkRouteRes);
            if (passengerWalkRouteRes != null) {
                this.ret = passengerWalkRouteRes.ret;
                this.msg = passengerWalkRouteRes.msg;
                this.geos = PassengerWalkRouteRes.copyOf(passengerWalkRouteRes.geos);
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

        public Builder geos(List<DoublePoint> list) {
            this.geos = checkForNulls(list);
            return this;
        }

        public PassengerWalkRouteRes build() {
            return new PassengerWalkRouteRes(this);
        }
    }
}
