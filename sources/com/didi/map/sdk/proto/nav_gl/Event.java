package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Event extends Message {
    public static final EventKindEnum DEFAULT_EVENTKIND = EventKindEnum.EventKind_Voice;
    public static final Integer DEFAULT_INDEX = 0;
    public static final Integer DEFAULT_PRIORITY = 0;
    @ProtoField(tag = 7)
    public final BIInfo biInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4)
    public final EventCheckTiming checkTiming;
    @ProtoField(tag = 6)
    public final DIInfo diInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.ENUM)
    public final EventKindEnum eventKind;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer index;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer priority;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3)
    public final EventTiming timing;
    @ProtoField(tag = 5)
    public final VIInfo viInfo;

    public Event(Integer num, EventKindEnum eventKindEnum, EventTiming eventTiming, EventCheckTiming eventCheckTiming, VIInfo vIInfo, DIInfo dIInfo, BIInfo bIInfo, Integer num2) {
        this.priority = num;
        this.eventKind = eventKindEnum;
        this.timing = eventTiming;
        this.checkTiming = eventCheckTiming;
        this.viInfo = vIInfo;
        this.diInfo = dIInfo;
        this.biInfo = bIInfo;
        this.index = num2;
    }

    private Event(Builder builder) {
        this(builder.priority, builder.eventKind, builder.timing, builder.checkTiming, builder.viInfo, builder.diInfo, builder.biInfo, builder.index);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        if (!equals((Object) this.priority, (Object) event.priority) || !equals((Object) this.eventKind, (Object) event.eventKind) || !equals((Object) this.timing, (Object) event.timing) || !equals((Object) this.checkTiming, (Object) event.checkTiming) || !equals((Object) this.viInfo, (Object) event.viInfo) || !equals((Object) this.diInfo, (Object) event.diInfo) || !equals((Object) this.biInfo, (Object) event.biInfo) || !equals((Object) this.index, (Object) event.index)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.priority;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        EventKindEnum eventKindEnum = this.eventKind;
        int hashCode2 = (hashCode + (eventKindEnum != null ? eventKindEnum.hashCode() : 0)) * 37;
        EventTiming eventTiming = this.timing;
        int hashCode3 = (hashCode2 + (eventTiming != null ? eventTiming.hashCode() : 0)) * 37;
        EventCheckTiming eventCheckTiming = this.checkTiming;
        int hashCode4 = (hashCode3 + (eventCheckTiming != null ? eventCheckTiming.hashCode() : 0)) * 37;
        VIInfo vIInfo = this.viInfo;
        int hashCode5 = (hashCode4 + (vIInfo != null ? vIInfo.hashCode() : 0)) * 37;
        DIInfo dIInfo = this.diInfo;
        int hashCode6 = (hashCode5 + (dIInfo != null ? dIInfo.hashCode() : 0)) * 37;
        BIInfo bIInfo = this.biInfo;
        int hashCode7 = (hashCode6 + (bIInfo != null ? bIInfo.hashCode() : 0)) * 37;
        Integer num2 = this.index;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Event> {
        public BIInfo biInfo;
        public EventCheckTiming checkTiming;
        public DIInfo diInfo;
        public EventKindEnum eventKind;
        public Integer index;
        public Integer priority;
        public EventTiming timing;
        public VIInfo viInfo;

        public Builder() {
        }

        public Builder(Event event) {
            super(event);
            if (event != null) {
                this.priority = event.priority;
                this.eventKind = event.eventKind;
                this.timing = event.timing;
                this.checkTiming = event.checkTiming;
                this.viInfo = event.viInfo;
                this.diInfo = event.diInfo;
                this.biInfo = event.biInfo;
                this.index = event.index;
            }
        }

        public Builder priority(Integer num) {
            this.priority = num;
            return this;
        }

        public Builder eventKind(EventKindEnum eventKindEnum) {
            this.eventKind = eventKindEnum;
            return this;
        }

        public Builder timing(EventTiming eventTiming) {
            this.timing = eventTiming;
            return this;
        }

        public Builder checkTiming(EventCheckTiming eventCheckTiming) {
            this.checkTiming = eventCheckTiming;
            return this;
        }

        public Builder viInfo(VIInfo vIInfo) {
            this.viInfo = vIInfo;
            return this;
        }

        public Builder diInfo(DIInfo dIInfo) {
            this.diInfo = dIInfo;
            return this;
        }

        public Builder biInfo(BIInfo bIInfo) {
            this.biInfo = bIInfo;
            return this;
        }

        public Builder index(Integer num) {
            this.index = num;
            return this;
        }

        public Event build() {
            checkRequiredFields();
            return new Event(this);
        }
    }
}
