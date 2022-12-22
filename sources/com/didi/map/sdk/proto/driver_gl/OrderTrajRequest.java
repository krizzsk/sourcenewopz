package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class OrderTrajRequest extends Message {
    public static final String DEFAULT_CALLERID = "";
    public static final String DEFAULT_DIDIVERSION = "";
    public static final List<MapDriver> DEFAULT_DRIVERS = Collections.emptyList();
    public static final String DEFAULT_IMEI = "";
    public static final String DEFAULT_PHONENUM = "";
    public static final String DEFAULT_SOURCE = "";
    public static final String DEFAULT_TOKEN = "";
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String callerId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(label = Message.Label.REPEATED, messageType = MapDriver.class, tag = 1)
    public final List<MapDriver> drivers;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.STRING)
    public final String imei;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.STRING)
    public final String phoneNum;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public OrderTrajRequest(List<MapDriver> list, String str, String str2, String str3, String str4, String str5, String str6) {
        this.drivers = immutableCopyOf(list);
        this.didiVersion = str;
        this.source = str2;
        this.token = str3;
        this.phoneNum = str4;
        this.imei = str5;
        this.callerId = str6;
    }

    private OrderTrajRequest(Builder builder) {
        this(builder.drivers, builder.didiVersion, builder.source, builder.token, builder.phoneNum, builder.imei, builder.callerId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderTrajRequest)) {
            return false;
        }
        OrderTrajRequest orderTrajRequest = (OrderTrajRequest) obj;
        if (!equals((List<?>) this.drivers, (List<?>) orderTrajRequest.drivers) || !equals((Object) this.didiVersion, (Object) orderTrajRequest.didiVersion) || !equals((Object) this.source, (Object) orderTrajRequest.source) || !equals((Object) this.token, (Object) orderTrajRequest.token) || !equals((Object) this.phoneNum, (Object) orderTrajRequest.phoneNum) || !equals((Object) this.imei, (Object) orderTrajRequest.imei) || !equals((Object) this.callerId, (Object) orderTrajRequest.callerId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<MapDriver> list = this.drivers;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        String str = this.didiVersion;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.source;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.phoneNum;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.imei;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.callerId;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderTrajRequest> {
        public String callerId;
        public String didiVersion;
        public List<MapDriver> drivers;
        public String imei;
        public String phoneNum;
        public String source;
        public String token;

        public Builder() {
        }

        public Builder(OrderTrajRequest orderTrajRequest) {
            super(orderTrajRequest);
            if (orderTrajRequest != null) {
                this.drivers = OrderTrajRequest.copyOf(orderTrajRequest.drivers);
                this.didiVersion = orderTrajRequest.didiVersion;
                this.source = orderTrajRequest.source;
                this.token = orderTrajRequest.token;
                this.phoneNum = orderTrajRequest.phoneNum;
                this.imei = orderTrajRequest.imei;
                this.callerId = orderTrajRequest.callerId;
            }
        }

        public Builder drivers(List<MapDriver> list) {
            this.drivers = checkForNulls(list);
            return this;
        }

        public Builder didiVersion(String str) {
            this.didiVersion = str;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder phoneNum(String str) {
            this.phoneNum = str;
            return this;
        }

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder callerId(String str) {
            this.callerId = str;
            return this;
        }

        public OrderTrajRequest build() {
            checkRequiredFields();
            return new OrderTrajRequest(this);
        }
    }
}
