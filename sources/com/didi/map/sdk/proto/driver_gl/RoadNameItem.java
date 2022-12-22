package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RoadNameItem extends Message {
    public static final Integer DEFAULT_ENDINDEX = 0;
    public static final String DEFAULT_ROADNAME = "";
    public static final Integer DEFAULT_STARTINDEX = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer endIndex;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String roadName;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer startIndex;

    public RoadNameItem(Integer num, Integer num2, String str) {
        this.startIndex = num;
        this.endIndex = num2;
        this.roadName = str;
    }

    private RoadNameItem(Builder builder) {
        this(builder.startIndex, builder.endIndex, builder.roadName);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoadNameItem)) {
            return false;
        }
        RoadNameItem roadNameItem = (RoadNameItem) obj;
        if (!equals((Object) this.startIndex, (Object) roadNameItem.startIndex) || !equals((Object) this.endIndex, (Object) roadNameItem.endIndex) || !equals((Object) this.roadName, (Object) roadNameItem.roadName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.startIndex;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.endIndex;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.roadName;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RoadNameItem> {
        public Integer endIndex;
        public String roadName;
        public Integer startIndex;

        public Builder() {
        }

        public Builder(RoadNameItem roadNameItem) {
            super(roadNameItem);
            if (roadNameItem != null) {
                this.startIndex = roadNameItem.startIndex;
                this.endIndex = roadNameItem.endIndex;
                this.roadName = roadNameItem.roadName;
            }
        }

        public Builder startIndex(Integer num) {
            this.startIndex = num;
            return this;
        }

        public Builder endIndex(Integer num) {
            this.endIndex = num;
            return this;
        }

        public Builder roadName(String str) {
            this.roadName = str;
            return this;
        }

        public RoadNameItem build() {
            checkRequiredFields();
            return new RoadNameItem(this);
        }
    }
}
