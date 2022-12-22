package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class EventHis extends Message {
    public static final Integer DEFAULT_FEEDCOUNT = 0;
    public static final List<HisCard> DEFAULT_HISCARD = Collections.emptyList();
    public static final Integer DEFAULT_NOTIFICATIONSUM = 0;
    public static final Integer DEFAULT_PAGENUM = 0;
    public static final Integer DEFAULT_REPORTCOUNT = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer feedCount;
    @ProtoField(label = Message.Label.REPEATED, messageType = HisCard.class, tag = 4)
    public final List<HisCard> hisCard;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer notificationSum;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer pageNum;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer reportCount;

    public EventHis(Integer num, Integer num2, Integer num3, List<HisCard> list, Integer num4) {
        this.notificationSum = num;
        this.reportCount = num2;
        this.feedCount = num3;
        this.hisCard = immutableCopyOf(list);
        this.pageNum = num4;
    }

    private EventHis(Builder builder) {
        this(builder.notificationSum, builder.reportCount, builder.feedCount, builder.hisCard, builder.pageNum);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventHis)) {
            return false;
        }
        EventHis eventHis = (EventHis) obj;
        if (!equals((Object) this.notificationSum, (Object) eventHis.notificationSum) || !equals((Object) this.reportCount, (Object) eventHis.reportCount) || !equals((Object) this.feedCount, (Object) eventHis.feedCount) || !equals((List<?>) this.hisCard, (List<?>) eventHis.hisCard) || !equals((Object) this.pageNum, (Object) eventHis.pageNum)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.notificationSum;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.reportCount;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.feedCount;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        List<HisCard> list = this.hisCard;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num4 = this.pageNum;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EventHis> {
        public Integer feedCount;
        public List<HisCard> hisCard;
        public Integer notificationSum;
        public Integer pageNum;
        public Integer reportCount;

        public Builder() {
        }

        public Builder(EventHis eventHis) {
            super(eventHis);
            if (eventHis != null) {
                this.notificationSum = eventHis.notificationSum;
                this.reportCount = eventHis.reportCount;
                this.feedCount = eventHis.feedCount;
                this.hisCard = EventHis.copyOf(eventHis.hisCard);
                this.pageNum = eventHis.pageNum;
            }
        }

        public Builder notificationSum(Integer num) {
            this.notificationSum = num;
            return this;
        }

        public Builder reportCount(Integer num) {
            this.reportCount = num;
            return this;
        }

        public Builder feedCount(Integer num) {
            this.feedCount = num;
            return this;
        }

        public Builder hisCard(List<HisCard> list) {
            this.hisCard = checkForNulls(list);
            return this;
        }

        public Builder pageNum(Integer num) {
            this.pageNum = num;
            return this;
        }

        public EventHis build() {
            return new EventHis(this);
        }
    }
}
