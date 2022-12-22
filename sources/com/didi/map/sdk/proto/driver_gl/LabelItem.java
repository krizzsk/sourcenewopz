package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LabelItem extends Message {
    public static final String DEFAULT_BUDDLECONTENT = "";
    public static final Integer DEFAULT_GEOIDX = 0;
    public static final IconType DEFAULT_ICONTYPE = IconType.Non;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String buddleContent;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer geoIdx;
    @ProtoField(tag = 2, type = Message.Datatype.ENUM)
    public final IconType iconType;

    public LabelItem(Integer num, IconType iconType2, String str) {
        this.geoIdx = num;
        this.iconType = iconType2;
        this.buddleContent = str;
    }

    private LabelItem(Builder builder) {
        this(builder.geoIdx, builder.iconType, builder.buddleContent);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LabelItem)) {
            return false;
        }
        LabelItem labelItem = (LabelItem) obj;
        if (!equals((Object) this.geoIdx, (Object) labelItem.geoIdx) || !equals((Object) this.iconType, (Object) labelItem.iconType) || !equals((Object) this.buddleContent, (Object) labelItem.buddleContent)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.geoIdx;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        IconType iconType2 = this.iconType;
        int hashCode2 = (hashCode + (iconType2 != null ? iconType2.hashCode() : 0)) * 37;
        String str = this.buddleContent;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LabelItem> {
        public String buddleContent;
        public Integer geoIdx;
        public IconType iconType;

        public Builder() {
        }

        public Builder(LabelItem labelItem) {
            super(labelItem);
            if (labelItem != null) {
                this.geoIdx = labelItem.geoIdx;
                this.iconType = labelItem.iconType;
                this.buddleContent = labelItem.buddleContent;
            }
        }

        public Builder geoIdx(Integer num) {
            this.geoIdx = num;
            return this;
        }

        public Builder iconType(IconType iconType2) {
            this.iconType = iconType2;
            return this;
        }

        public Builder buddleContent(String str) {
            this.buddleContent = str;
            return this;
        }

        public LabelItem build() {
            return new LabelItem(this);
        }
    }
}
