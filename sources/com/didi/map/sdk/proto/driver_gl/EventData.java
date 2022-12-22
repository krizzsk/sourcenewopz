package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class EventData extends Message {
    public static final ByteString DEFAULT_DATA = ByteString.EMPTY;
    public static final Integer DEFAULT_EVENTTYPE = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final ByteString data;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer eventType;

    public EventData(Integer num, ByteString byteString) {
        this.eventType = num;
        this.data = byteString;
    }

    private EventData(Builder builder) {
        this(builder.eventType, builder.data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventData)) {
            return false;
        }
        EventData eventData = (EventData) obj;
        if (!equals((Object) this.eventType, (Object) eventData.eventType) || !equals((Object) this.data, (Object) eventData.data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.eventType;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        ByteString byteString = this.data;
        if (byteString != null) {
            i2 = byteString.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventData> {
        public ByteString data;
        public Integer eventType;

        public Builder() {
        }

        public Builder(EventData eventData) {
            super(eventData);
            if (eventData != null) {
                this.eventType = eventData.eventType;
                this.data = eventData.data;
            }
        }

        public Builder eventType(Integer num) {
            this.eventType = num;
            return this;
        }

        public Builder data(ByteString byteString) {
            this.data = byteString;
            return this;
        }

        public EventData build() {
            return new EventData(this);
        }
    }
}
