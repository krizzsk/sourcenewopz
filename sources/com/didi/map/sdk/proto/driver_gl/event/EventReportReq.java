package com.didi.map.sdk.proto.driver_gl.event;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventReportReq extends Message {
    public static final String DEFAULT_DIDIVERSION = "";
    public static final Integer DEFAULT_EVENTTYPE = 0;
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Integer DEFAULT_SOURCETYPE = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_USERID = 0L;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6)
    public final DoublePoint eventPoint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer eventType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer sourceType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.UINT64)
    public final Long userId;

    public EventReportReq(String str, Integer num, Integer num2, Integer num3, Long l, DoublePoint doublePoint, Long l2, String str2, String str3) {
        this.orderId = str;
        this.source = num;
        this.sourceType = num2;
        this.eventType = num3;
        this.timestamp = l;
        this.eventPoint = doublePoint;
        this.userId = l2;
        this.didiVersion = str2;
        this.token = str3;
    }

    private EventReportReq(Builder builder) {
        this(builder.orderId, builder.source, builder.sourceType, builder.eventType, builder.timestamp, builder.eventPoint, builder.userId, builder.didiVersion, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventReportReq)) {
            return false;
        }
        EventReportReq eventReportReq = (EventReportReq) obj;
        if (!equals((Object) this.orderId, (Object) eventReportReq.orderId) || !equals((Object) this.source, (Object) eventReportReq.source) || !equals((Object) this.sourceType, (Object) eventReportReq.sourceType) || !equals((Object) this.eventType, (Object) eventReportReq.eventType) || !equals((Object) this.timestamp, (Object) eventReportReq.timestamp) || !equals((Object) this.eventPoint, (Object) eventReportReq.eventPoint) || !equals((Object) this.userId, (Object) eventReportReq.userId) || !equals((Object) this.didiVersion, (Object) eventReportReq.didiVersion) || !equals((Object) this.token, (Object) eventReportReq.token)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.orderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.source;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.sourceType;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.eventType;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.eventPoint;
        int hashCode6 = (hashCode5 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Long l2 = this.userId;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str2 = this.didiVersion;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventReportReq> {
        public String didiVersion;
        public DoublePoint eventPoint;
        public Integer eventType;
        public String orderId;
        public Integer source;
        public Integer sourceType;
        public Long timestamp;
        public String token;
        public Long userId;

        public Builder() {
        }

        public Builder(EventReportReq eventReportReq) {
            super(eventReportReq);
            if (eventReportReq != null) {
                this.orderId = eventReportReq.orderId;
                this.source = eventReportReq.source;
                this.sourceType = eventReportReq.sourceType;
                this.eventType = eventReportReq.eventType;
                this.timestamp = eventReportReq.timestamp;
                this.eventPoint = eventReportReq.eventPoint;
                this.userId = eventReportReq.userId;
                this.didiVersion = eventReportReq.didiVersion;
                this.token = eventReportReq.token;
            }
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder sourceType(Integer num) {
            this.sourceType = num;
            return this;
        }

        public Builder eventType(Integer num) {
            this.eventType = num;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder eventPoint(DoublePoint doublePoint) {
            this.eventPoint = doublePoint;
            return this;
        }

        public Builder userId(Long l) {
            this.userId = l;
            return this;
        }

        public Builder didiVersion(String str) {
            this.didiVersion = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public EventReportReq build() {
            checkRequiredFields();
            return new EventReportReq(this);
        }
    }
}
