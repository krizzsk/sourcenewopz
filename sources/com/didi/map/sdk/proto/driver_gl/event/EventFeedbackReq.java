package com.didi.map.sdk.proto.driver_gl.event;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventFeedbackReq extends Message {
    public static final String DEFAULT_DIDIVERSION = "";
    public static final Long DEFAULT_EVENTID = 0L;
    public static final Integer DEFAULT_FEEDCODE = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_USERID = 0L;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long eventId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer feedCode;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4)
    public final DoublePoint feedbackPoint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.UINT64)
    public final Long userId;

    public EventFeedbackReq(Long l, Integer num, Long l2, DoublePoint doublePoint, Long l3, Integer num2, String str, String str2) {
        this.eventId = l;
        this.source = num;
        this.timestamp = l2;
        this.feedbackPoint = doublePoint;
        this.userId = l3;
        this.feedCode = num2;
        this.didiVersion = str;
        this.token = str2;
    }

    private EventFeedbackReq(Builder builder) {
        this(builder.eventId, builder.source, builder.timestamp, builder.feedbackPoint, builder.userId, builder.feedCode, builder.didiVersion, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventFeedbackReq)) {
            return false;
        }
        EventFeedbackReq eventFeedbackReq = (EventFeedbackReq) obj;
        if (!equals((Object) this.eventId, (Object) eventFeedbackReq.eventId) || !equals((Object) this.source, (Object) eventFeedbackReq.source) || !equals((Object) this.timestamp, (Object) eventFeedbackReq.timestamp) || !equals((Object) this.feedbackPoint, (Object) eventFeedbackReq.feedbackPoint) || !equals((Object) this.userId, (Object) eventFeedbackReq.userId) || !equals((Object) this.feedCode, (Object) eventFeedbackReq.feedCode) || !equals((Object) this.didiVersion, (Object) eventFeedbackReq.didiVersion) || !equals((Object) this.token, (Object) eventFeedbackReq.token)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.eventId;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.source;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.timestamp;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.feedbackPoint;
        int hashCode4 = (hashCode3 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Long l3 = this.userId;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num2 = this.feedCode;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.didiVersion;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventFeedbackReq> {
        public String didiVersion;
        public Long eventId;
        public Integer feedCode;
        public DoublePoint feedbackPoint;
        public Integer source;
        public Long timestamp;
        public String token;
        public Long userId;

        public Builder() {
        }

        public Builder(EventFeedbackReq eventFeedbackReq) {
            super(eventFeedbackReq);
            if (eventFeedbackReq != null) {
                this.eventId = eventFeedbackReq.eventId;
                this.source = eventFeedbackReq.source;
                this.timestamp = eventFeedbackReq.timestamp;
                this.feedbackPoint = eventFeedbackReq.feedbackPoint;
                this.userId = eventFeedbackReq.userId;
                this.feedCode = eventFeedbackReq.feedCode;
                this.didiVersion = eventFeedbackReq.didiVersion;
                this.token = eventFeedbackReq.token;
            }
        }

        public Builder eventId(Long l) {
            this.eventId = l;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder feedbackPoint(DoublePoint doublePoint) {
            this.feedbackPoint = doublePoint;
            return this;
        }

        public Builder userId(Long l) {
            this.userId = l;
            return this;
        }

        public Builder feedCode(Integer num) {
            this.feedCode = num;
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

        public EventFeedbackReq build() {
            checkRequiredFields();
            return new EventFeedbackReq(this);
        }
    }
}
