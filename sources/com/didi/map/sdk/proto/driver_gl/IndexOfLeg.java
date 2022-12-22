package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class IndexOfLeg extends Message {
    public static final Integer DEFAULT_ENDINDEX = 0;
    public static final Integer DEFAULT_ETA = 0;
    public static final Integer DEFAULT_STARTINDEX = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer endIndex;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer startIndex;

    public IndexOfLeg(Integer num, Integer num2, Integer num3) {
        this.startIndex = num;
        this.endIndex = num2;
        this.eta = num3;
    }

    private IndexOfLeg(Builder builder) {
        this(builder.startIndex, builder.endIndex, builder.eta);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexOfLeg)) {
            return false;
        }
        IndexOfLeg indexOfLeg = (IndexOfLeg) obj;
        if (!equals((Object) this.startIndex, (Object) indexOfLeg.startIndex) || !equals((Object) this.endIndex, (Object) indexOfLeg.endIndex) || !equals((Object) this.eta, (Object) indexOfLeg.eta)) {
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
        Integer num3 = this.eta;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<IndexOfLeg> {
        public Integer endIndex;
        public Integer eta;
        public Integer startIndex;

        public Builder() {
        }

        public Builder(IndexOfLeg indexOfLeg) {
            super(indexOfLeg);
            if (indexOfLeg != null) {
                this.startIndex = indexOfLeg.startIndex;
                this.endIndex = indexOfLeg.endIndex;
                this.eta = indexOfLeg.eta;
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

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public IndexOfLeg build() {
            checkRequiredFields();
            return new IndexOfLeg(this);
        }
    }
}
