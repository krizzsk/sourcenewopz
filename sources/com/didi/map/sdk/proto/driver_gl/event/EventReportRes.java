package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventReportRes extends Message {
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;

    public EventReportRes(Integer num, String str) {
        this.ret = num;
        this.msg = str;
    }

    private EventReportRes(Builder builder) {
        this(builder.ret, builder.msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventReportRes)) {
            return false;
        }
        EventReportRes eventReportRes = (EventReportRes) obj;
        if (!equals((Object) this.ret, (Object) eventReportRes.ret) || !equals((Object) this.msg, (Object) eventReportRes.msg)) {
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
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventReportRes> {
        public String msg;
        public Integer ret;

        public Builder() {
        }

        public Builder(EventReportRes eventReportRes) {
            super(eventReportRes);
            if (eventReportRes != null) {
                this.ret = eventReportRes.ret;
                this.msg = eventReportRes.msg;
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

        public EventReportRes build() {
            checkRequiredFields();
            return new EventReportRes(this);
        }
    }
}
