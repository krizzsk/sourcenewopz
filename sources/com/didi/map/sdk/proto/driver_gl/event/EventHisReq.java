package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventHisReq extends Message {
    public static final String DEFAULT_DIDIVERSION = "";
    public static final Integer DEFAULT_PAGECAP = 0;
    public static final Integer DEFAULT_PAGENUM = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_USERID = 0L;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer pageCap;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer pageNum;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long userId;

    public EventHisReq(Long l, Long l2, Integer num, String str, String str2, Integer num2, Integer num3) {
        this.userId = l;
        this.timestamp = l2;
        this.source = num;
        this.didiVersion = str;
        this.token = str2;
        this.pageNum = num2;
        this.pageCap = num3;
    }

    private EventHisReq(Builder builder) {
        this(builder.userId, builder.timestamp, builder.source, builder.didiVersion, builder.token, builder.pageNum, builder.pageCap);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventHisReq)) {
            return false;
        }
        EventHisReq eventHisReq = (EventHisReq) obj;
        if (!equals((Object) this.userId, (Object) eventHisReq.userId) || !equals((Object) this.timestamp, (Object) eventHisReq.timestamp) || !equals((Object) this.source, (Object) eventHisReq.source) || !equals((Object) this.didiVersion, (Object) eventHisReq.didiVersion) || !equals((Object) this.token, (Object) eventHisReq.token) || !equals((Object) this.pageNum, (Object) eventHisReq.pageNum) || !equals((Object) this.pageCap, (Object) eventHisReq.pageCap)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.userId;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.timestamp;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.source;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.didiVersion;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.pageNum;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.pageCap;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventHisReq> {
        public String didiVersion;
        public Integer pageCap;
        public Integer pageNum;
        public Integer source;
        public Long timestamp;
        public String token;
        public Long userId;

        public Builder() {
        }

        public Builder(EventHisReq eventHisReq) {
            super(eventHisReq);
            if (eventHisReq != null) {
                this.userId = eventHisReq.userId;
                this.timestamp = eventHisReq.timestamp;
                this.source = eventHisReq.source;
                this.didiVersion = eventHisReq.didiVersion;
                this.token = eventHisReq.token;
                this.pageNum = eventHisReq.pageNum;
                this.pageCap = eventHisReq.pageCap;
            }
        }

        public Builder userId(Long l) {
            this.userId = l;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
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

        public Builder pageNum(Integer num) {
            this.pageNum = num;
            return this;
        }

        public Builder pageCap(Integer num) {
            this.pageCap = num;
            return this;
        }

        public EventHisReq build() {
            checkRequiredFields();
            return new EventHisReq(this);
        }
    }
}
