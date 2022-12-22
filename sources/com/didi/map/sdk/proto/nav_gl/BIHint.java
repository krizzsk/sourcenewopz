package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BIHint extends Message {
    public static final String DEFAULT_SEGHINT = "";
    public static final Integer DEFAULT_SEGHINTLENGTH = 0;
    public static final HintKindEnum DEFAULT_SEGHINTTYPE = HintKindEnum.SEG_HINT_NONE;
    public static final String DEFAULT_SEG_DESC = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint beginLonLatPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MapRoutePoint endLonLatPos;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final HintKindEnum segHintType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.STRING)
    public final String seg_desc;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.STRING)
    public final String seghint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.UINT32)
    public final Integer seghintLength;

    public BIHint(MapRoutePoint mapRoutePoint, MapRoutePoint mapRoutePoint2, HintKindEnum hintKindEnum, Integer num, String str, String str2) {
        this.beginLonLatPos = mapRoutePoint;
        this.endLonLatPos = mapRoutePoint2;
        this.segHintType = hintKindEnum;
        this.seghintLength = num;
        this.seghint = str;
        this.seg_desc = str2;
    }

    private BIHint(Builder builder) {
        this(builder.beginLonLatPos, builder.endLonLatPos, builder.segHintType, builder.seghintLength, builder.seghint, builder.seg_desc);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BIHint)) {
            return false;
        }
        BIHint bIHint = (BIHint) obj;
        if (!equals((Object) this.beginLonLatPos, (Object) bIHint.beginLonLatPos) || !equals((Object) this.endLonLatPos, (Object) bIHint.endLonLatPos) || !equals((Object) this.segHintType, (Object) bIHint.segHintType) || !equals((Object) this.seghintLength, (Object) bIHint.seghintLength) || !equals((Object) this.seghint, (Object) bIHint.seghint) || !equals((Object) this.seg_desc, (Object) bIHint.seg_desc)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        MapRoutePoint mapRoutePoint = this.beginLonLatPos;
        int i2 = 0;
        int hashCode = (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0) * 37;
        MapRoutePoint mapRoutePoint2 = this.endLonLatPos;
        int hashCode2 = (hashCode + (mapRoutePoint2 != null ? mapRoutePoint2.hashCode() : 0)) * 37;
        HintKindEnum hintKindEnum = this.segHintType;
        int hashCode3 = (hashCode2 + (hintKindEnum != null ? hintKindEnum.hashCode() : 0)) * 37;
        Integer num = this.seghintLength;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.seghint;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.seg_desc;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BIHint> {
        public MapRoutePoint beginLonLatPos;
        public MapRoutePoint endLonLatPos;
        public HintKindEnum segHintType;
        public String seg_desc;
        public String seghint;
        public Integer seghintLength;

        public Builder() {
        }

        public Builder(BIHint bIHint) {
            super(bIHint);
            if (bIHint != null) {
                this.beginLonLatPos = bIHint.beginLonLatPos;
                this.endLonLatPos = bIHint.endLonLatPos;
                this.segHintType = bIHint.segHintType;
                this.seghintLength = bIHint.seghintLength;
                this.seghint = bIHint.seghint;
                this.seg_desc = bIHint.seg_desc;
            }
        }

        public Builder beginLonLatPos(MapRoutePoint mapRoutePoint) {
            this.beginLonLatPos = mapRoutePoint;
            return this;
        }

        public Builder endLonLatPos(MapRoutePoint mapRoutePoint) {
            this.endLonLatPos = mapRoutePoint;
            return this;
        }

        public Builder segHintType(HintKindEnum hintKindEnum) {
            this.segHintType = hintKindEnum;
            return this;
        }

        public Builder seghintLength(Integer num) {
            this.seghintLength = num;
            return this;
        }

        public Builder seghint(String str) {
            this.seghint = str;
            return this;
        }

        public Builder seg_desc(String str) {
            this.seg_desc = str;
            return this;
        }

        public BIHint build() {
            checkRequiredFields();
            return new BIHint(this);
        }
    }
}
