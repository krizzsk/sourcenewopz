package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class OptionalRouteRes extends Message {
    public static final List<Integer> DEFAULT_ETASEC = Collections.emptyList();
    public static final Long DEFAULT_ROUTEID = 0L;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> etaSec;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
    public final Long routeId;

    public OptionalRouteRes(Long l, List<Integer> list) {
        this.routeId = l;
        this.etaSec = immutableCopyOf(list);
    }

    private OptionalRouteRes(Builder builder) {
        this(builder.routeId, builder.etaSec);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionalRouteRes)) {
            return false;
        }
        OptionalRouteRes optionalRouteRes = (OptionalRouteRes) obj;
        if (!equals((Object) this.routeId, (Object) optionalRouteRes.routeId) || !equals((List<?>) this.etaSec, (List<?>) optionalRouteRes.etaSec)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.routeId;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<Integer> list = this.etaSec;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<OptionalRouteRes> {
        public List<Integer> etaSec;
        public Long routeId;

        public Builder() {
        }

        public Builder(OptionalRouteRes optionalRouteRes) {
            super(optionalRouteRes);
            if (optionalRouteRes != null) {
                this.routeId = optionalRouteRes.routeId;
                this.etaSec = OptionalRouteRes.copyOf(optionalRouteRes.etaSec);
            }
        }

        public Builder routeId(Long l) {
            this.routeId = l;
            return this;
        }

        public Builder etaSec(List<Integer> list) {
            this.etaSec = checkForNulls(list);
            return this;
        }

        public OptionalRouteRes build() {
            checkRequiredFields();
            return new OptionalRouteRes(this);
        }
    }
}
