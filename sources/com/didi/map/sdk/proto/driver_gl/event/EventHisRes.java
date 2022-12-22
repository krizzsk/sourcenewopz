package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class EventHisRes extends Message {
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    @ProtoField(tag = 3)
    public final EventHis history;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;

    public EventHisRes(Integer num, String str, EventHis eventHis) {
        this.ret = num;
        this.msg = str;
        this.history = eventHis;
    }

    private EventHisRes(Builder builder) {
        this(builder.ret, builder.msg, builder.history);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventHisRes)) {
            return false;
        }
        EventHisRes eventHisRes = (EventHisRes) obj;
        if (!equals((Object) this.ret, (Object) eventHisRes.ret) || !equals((Object) this.msg, (Object) eventHisRes.msg) || !equals((Object) this.history, (Object) eventHisRes.history)) {
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
        EventHis eventHis = this.history;
        if (eventHis != null) {
            i2 = eventHis.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventHisRes> {
        public EventHis history;
        public String msg;
        public Integer ret;

        public Builder() {
        }

        public Builder(EventHisRes eventHisRes) {
            super(eventHisRes);
            if (eventHisRes != null) {
                this.ret = eventHisRes.ret;
                this.msg = eventHisRes.msg;
                this.history = eventHisRes.history;
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

        public Builder history(EventHis eventHis) {
            this.history = eventHis;
            return this;
        }

        public EventHisRes build() {
            checkRequiredFields();
            return new EventHisRes(this);
        }
    }
}
