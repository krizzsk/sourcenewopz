package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ExtendData extends Message {
    public static final List<EventData> DEFAULT_EVENTDATA = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = EventData.class, tag = 1)
    public final List<EventData> eventData;

    public ExtendData(List<EventData> list) {
        this.eventData = immutableCopyOf(list);
    }

    private ExtendData(Builder builder) {
        this(builder.eventData);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExtendData)) {
            return false;
        }
        return equals((List<?>) this.eventData, (List<?>) ((ExtendData) obj).eventData);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<EventData> list = this.eventData;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ExtendData> {
        public List<EventData> eventData;

        public Builder() {
        }

        public Builder(ExtendData extendData) {
            super(extendData);
            if (extendData != null) {
                this.eventData = ExtendData.copyOf(extendData.eventData);
            }
        }

        public Builder eventData(List<EventData> list) {
            this.eventData = checkForNulls(list);
            return this;
        }

        public ExtendData build() {
            return new ExtendData(this);
        }
    }
}
