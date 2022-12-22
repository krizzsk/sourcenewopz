package com.didi.map.sdk.proto.driver_gl.event;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class HisCard extends Message {
    public static final Long DEFAULT_EVENTID = 0L;
    public static final String DEFAULT_EVENTTITLE = "";
    public static final Integer DEFAULT_EVENTTYPE = 0;
    public static final List<ButtonModeInfo> DEFAULT_MODEINFO = Collections.emptyList();
    public static final Integer DEFAULT_NOTIFICATIONCOUNT = 0;
    public static final String DEFAULT_ROUTENAME = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long eventId;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String eventTitle;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer eventType;
    @ProtoField(label = Message.Label.REPEATED, messageType = ButtonModeInfo.class, tag = 2)
    public final List<ButtonModeInfo> modeInfo;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer notificationCount;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String routeName;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 5, type = Message.Datatype.UINT64)
    public final Long timestamp;

    public HisCard(String str, List<ButtonModeInfo> list, Integer num, String str2, Long l, Integer num2, Integer num3, Long l2) {
        this.eventTitle = str;
        this.modeInfo = immutableCopyOf(list);
        this.eventType = num;
        this.routeName = str2;
        this.timestamp = l;
        this.status = num2;
        this.notificationCount = num3;
        this.eventId = l2;
    }

    private HisCard(Builder builder) {
        this(builder.eventTitle, builder.modeInfo, builder.eventType, builder.routeName, builder.timestamp, builder.status, builder.notificationCount, builder.eventId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HisCard)) {
            return false;
        }
        HisCard hisCard = (HisCard) obj;
        if (!equals((Object) this.eventTitle, (Object) hisCard.eventTitle) || !equals((List<?>) this.modeInfo, (List<?>) hisCard.modeInfo) || !equals((Object) this.eventType, (Object) hisCard.eventType) || !equals((Object) this.routeName, (Object) hisCard.routeName) || !equals((Object) this.timestamp, (Object) hisCard.timestamp) || !equals((Object) this.status, (Object) hisCard.status) || !equals((Object) this.notificationCount, (Object) hisCard.notificationCount) || !equals((Object) this.eventId, (Object) hisCard.eventId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.eventTitle;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<ButtonModeInfo> list = this.modeInfo;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.eventType;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.routeName;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.notificationCount;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.eventId;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HisCard> {
        public Long eventId;
        public String eventTitle;
        public Integer eventType;
        public List<ButtonModeInfo> modeInfo;
        public Integer notificationCount;
        public String routeName;
        public Integer status;
        public Long timestamp;

        public Builder() {
        }

        public Builder(HisCard hisCard) {
            super(hisCard);
            if (hisCard != null) {
                this.eventTitle = hisCard.eventTitle;
                this.modeInfo = HisCard.copyOf(hisCard.modeInfo);
                this.eventType = hisCard.eventType;
                this.routeName = hisCard.routeName;
                this.timestamp = hisCard.timestamp;
                this.status = hisCard.status;
                this.notificationCount = hisCard.notificationCount;
                this.eventId = hisCard.eventId;
            }
        }

        public Builder eventTitle(String str) {
            this.eventTitle = str;
            return this;
        }

        public Builder modeInfo(List<ButtonModeInfo> list) {
            this.modeInfo = checkForNulls(list);
            return this;
        }

        public Builder eventType(Integer num) {
            this.eventType = num;
            return this;
        }

        public Builder routeName(String str) {
            this.routeName = str;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder notificationCount(Integer num) {
            this.notificationCount = num;
            return this;
        }

        public Builder eventId(Long l) {
            this.eventId = l;
            return this;
        }

        public HisCard build() {
            return new HisCard(this);
        }
    }
}
