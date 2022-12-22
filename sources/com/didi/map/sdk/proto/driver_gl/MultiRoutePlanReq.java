package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class MultiRoutePlanReq extends Message {
    public static final String DEFAULT_CALLER = "";
    public static final String DEFAULT_COUNTRYID = "";
    public static final String DEFAULT_DIDIVERSION = "";
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_ORDERSTAGE = 0;
    public static final Long DEFAULT_PASSENGERID = 0L;
    public static final String DEFAULT_PHONENUM = "";
    public static final String DEFAULT_PRODUCTID = "";
    public static final List<SingleRouteReq> DEFAULT_ROUTEREQ = Collections.emptyList();
    public static final String DEFAULT_TOKEN = "";
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String caller;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String countryId;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer orderStage;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long passengerId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String phoneNum;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String productId;
    @ProtoField(label = Message.Label.REPEATED, messageType = SingleRouteReq.class, tag = 2)
    public final List<SingleRouteReq> routeReq;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String token;

    public MultiRoutePlanReq(String str, List<SingleRouteReq> list, String str2, Long l, String str3, String str4, String str5, Integer num, String str6, String str7) {
        this.token = str;
        this.routeReq = immutableCopyOf(list);
        this.phoneNum = str2;
        this.passengerId = l;
        this.productId = str3;
        this.countryId = str4;
        this.caller = str5;
        this.orderStage = num;
        this.didiVersion = str6;
        this.orderId = str7;
    }

    private MultiRoutePlanReq(Builder builder) {
        this(builder.token, builder.routeReq, builder.phoneNum, builder.passengerId, builder.productId, builder.countryId, builder.caller, builder.orderStage, builder.didiVersion, builder.orderId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiRoutePlanReq)) {
            return false;
        }
        MultiRoutePlanReq multiRoutePlanReq = (MultiRoutePlanReq) obj;
        if (!equals((Object) this.token, (Object) multiRoutePlanReq.token) || !equals((List<?>) this.routeReq, (List<?>) multiRoutePlanReq.routeReq) || !equals((Object) this.phoneNum, (Object) multiRoutePlanReq.phoneNum) || !equals((Object) this.passengerId, (Object) multiRoutePlanReq.passengerId) || !equals((Object) this.productId, (Object) multiRoutePlanReq.productId) || !equals((Object) this.countryId, (Object) multiRoutePlanReq.countryId) || !equals((Object) this.caller, (Object) multiRoutePlanReq.caller) || !equals((Object) this.orderStage, (Object) multiRoutePlanReq.orderStage) || !equals((Object) this.didiVersion, (Object) multiRoutePlanReq.didiVersion) || !equals((Object) this.orderId, (Object) multiRoutePlanReq.orderId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.token;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<SingleRouteReq> list = this.routeReq;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.phoneNum;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.passengerId;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        String str3 = this.productId;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.countryId;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.caller;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num = this.orderStage;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        String str6 = this.didiVersion;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.orderId;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MultiRoutePlanReq> {
        public String caller;
        public String countryId;
        public String didiVersion;
        public String orderId;
        public Integer orderStage;
        public Long passengerId;
        public String phoneNum;
        public String productId;
        public List<SingleRouteReq> routeReq;
        public String token;

        public Builder() {
        }

        public Builder(MultiRoutePlanReq multiRoutePlanReq) {
            super(multiRoutePlanReq);
            if (multiRoutePlanReq != null) {
                this.token = multiRoutePlanReq.token;
                this.routeReq = MultiRoutePlanReq.copyOf(multiRoutePlanReq.routeReq);
                this.phoneNum = multiRoutePlanReq.phoneNum;
                this.passengerId = multiRoutePlanReq.passengerId;
                this.productId = multiRoutePlanReq.productId;
                this.countryId = multiRoutePlanReq.countryId;
                this.caller = multiRoutePlanReq.caller;
                this.orderStage = multiRoutePlanReq.orderStage;
                this.didiVersion = multiRoutePlanReq.didiVersion;
                this.orderId = multiRoutePlanReq.orderId;
            }
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder routeReq(List<SingleRouteReq> list) {
            this.routeReq = checkForNulls(list);
            return this;
        }

        public Builder phoneNum(String str) {
            this.phoneNum = str;
            return this;
        }

        public Builder passengerId(Long l) {
            this.passengerId = l;
            return this;
        }

        public Builder productId(String str) {
            this.productId = str;
            return this;
        }

        public Builder countryId(String str) {
            this.countryId = str;
            return this;
        }

        public Builder caller(String str) {
            this.caller = str;
            return this;
        }

        public Builder orderStage(Integer num) {
            this.orderStage = num;
            return this;
        }

        public Builder didiVersion(String str) {
            this.didiVersion = str;
            return this;
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public MultiRoutePlanReq build() {
            checkRequiredFields();
            return new MultiRoutePlanReq(this);
        }
    }
}
