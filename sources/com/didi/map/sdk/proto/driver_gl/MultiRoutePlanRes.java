package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class MultiRoutePlanRes extends Message {
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    public static final List<SingleRouteRes> DEFAULT_ROUTERES = Collections.emptyList();
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(label = Message.Label.REPEATED, messageType = SingleRouteRes.class, tag = 3)
    public final List<SingleRouteRes> routeRes;

    public MultiRoutePlanRes(Integer num, String str, List<SingleRouteRes> list, Long l) {
        this.ret = num;
        this.msg = str;
        this.routeRes = immutableCopyOf(list);
        this.logId = l;
    }

    private MultiRoutePlanRes(Builder builder) {
        this(builder.ret, builder.msg, builder.routeRes, builder.logId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiRoutePlanRes)) {
            return false;
        }
        MultiRoutePlanRes multiRoutePlanRes = (MultiRoutePlanRes) obj;
        if (!equals((Object) this.ret, (Object) multiRoutePlanRes.ret) || !equals((Object) this.msg, (Object) multiRoutePlanRes.msg) || !equals((List<?>) this.routeRes, (List<?>) multiRoutePlanRes.routeRes) || !equals((Object) this.logId, (Object) multiRoutePlanRes.logId)) {
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
        List<SingleRouteRes> list = this.routeRes;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.logId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MultiRoutePlanRes> {
        public Long logId;
        public String msg;
        public Integer ret;
        public List<SingleRouteRes> routeRes;

        public Builder() {
        }

        public Builder(MultiRoutePlanRes multiRoutePlanRes) {
            super(multiRoutePlanRes);
            if (multiRoutePlanRes != null) {
                this.ret = multiRoutePlanRes.ret;
                this.msg = multiRoutePlanRes.msg;
                this.routeRes = MultiRoutePlanRes.copyOf(multiRoutePlanRes.routeRes);
                this.logId = multiRoutePlanRes.logId;
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

        public Builder routeRes(List<SingleRouteRes> list) {
            this.routeRes = checkForNulls(list);
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public MultiRoutePlanRes build() {
            checkRequiredFields();
            return new MultiRoutePlanRes(this);
        }
    }
}
