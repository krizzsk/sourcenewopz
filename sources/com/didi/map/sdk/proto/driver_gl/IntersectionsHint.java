package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class IntersectionsHint extends Message {
    public static final Integer DEFAULT_ENDINDEX = 0;
    public static final Float DEFAULT_ENDOFFSET;
    public static final String DEFAULT_HINTMESSAGE = "";
    public static final String DEFAULT_PICURL = "";
    public static final Integer DEFAULT_STARTINDEX = 0;
    public static final Float DEFAULT_STARTOFFSET;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer endIndex;
    @ProtoField(tag = 6, type = Message.Datatype.FLOAT)
    public final Float endOffset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String hintMessage;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String picUrl;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer startIndex;
    @ProtoField(tag = 5, type = Message.Datatype.FLOAT)
    public final Float startOffset;

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_STARTOFFSET = valueOf;
        DEFAULT_ENDOFFSET = valueOf;
    }

    public IntersectionsHint(String str, Integer num, Integer num2, String str2, Float f, Float f2) {
        this.hintMessage = str;
        this.startIndex = num;
        this.endIndex = num2;
        this.picUrl = str2;
        this.startOffset = f;
        this.endOffset = f2;
    }

    private IntersectionsHint(Builder builder) {
        this(builder.hintMessage, builder.startIndex, builder.endIndex, builder.picUrl, builder.startOffset, builder.endOffset);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntersectionsHint)) {
            return false;
        }
        IntersectionsHint intersectionsHint = (IntersectionsHint) obj;
        if (!equals((Object) this.hintMessage, (Object) intersectionsHint.hintMessage) || !equals((Object) this.startIndex, (Object) intersectionsHint.startIndex) || !equals((Object) this.endIndex, (Object) intersectionsHint.endIndex) || !equals((Object) this.picUrl, (Object) intersectionsHint.picUrl) || !equals((Object) this.startOffset, (Object) intersectionsHint.startOffset) || !equals((Object) this.endOffset, (Object) intersectionsHint.endOffset)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.hintMessage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.startIndex;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.endIndex;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.picUrl;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Float f = this.startOffset;
        int hashCode5 = (hashCode4 + (f != null ? f.hashCode() : 0)) * 37;
        Float f2 = this.endOffset;
        if (f2 != null) {
            i2 = f2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<IntersectionsHint> {
        public Integer endIndex;
        public Float endOffset;
        public String hintMessage;
        public String picUrl;
        public Integer startIndex;
        public Float startOffset;

        public Builder() {
        }

        public Builder(IntersectionsHint intersectionsHint) {
            super(intersectionsHint);
            if (intersectionsHint != null) {
                this.hintMessage = intersectionsHint.hintMessage;
                this.startIndex = intersectionsHint.startIndex;
                this.endIndex = intersectionsHint.endIndex;
                this.picUrl = intersectionsHint.picUrl;
                this.startOffset = intersectionsHint.startOffset;
                this.endOffset = intersectionsHint.endOffset;
            }
        }

        public Builder hintMessage(String str) {
            this.hintMessage = str;
            return this;
        }

        public Builder startIndex(Integer num) {
            this.startIndex = num;
            return this;
        }

        public Builder endIndex(Integer num) {
            this.endIndex = num;
            return this;
        }

        public Builder picUrl(String str) {
            this.picUrl = str;
            return this;
        }

        public Builder startOffset(Float f) {
            this.startOffset = f;
            return this;
        }

        public Builder endOffset(Float f) {
            this.endOffset = f;
            return this;
        }

        public IntersectionsHint build() {
            return new IntersectionsHint(this);
        }
    }
}
