package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TimeItem extends Message {
    public static final Double DEFAULT_DIST;
    public static final Integer DEFAULT_ENDTIME = 0;
    public static final Double DEFAULT_ETATIME;
    public static final Double DEFAULT_SLOWTIME;
    public static final Integer DEFAULT_STARTTIME = 0;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double dist;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer endTime;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double etaTime;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double slowTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer startTime;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_DIST = valueOf;
        DEFAULT_SLOWTIME = valueOf;
        DEFAULT_ETATIME = valueOf;
    }

    public TimeItem(Integer num, Integer num2, Double d, Double d2, Double d3) {
        this.startTime = num;
        this.endTime = num2;
        this.dist = d;
        this.slowTime = d2;
        this.etaTime = d3;
    }

    private TimeItem(Builder builder) {
        this(builder.startTime, builder.endTime, builder.dist, builder.slowTime, builder.etaTime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TimeItem)) {
            return false;
        }
        TimeItem timeItem = (TimeItem) obj;
        if (!equals((Object) this.startTime, (Object) timeItem.startTime) || !equals((Object) this.endTime, (Object) timeItem.endTime) || !equals((Object) this.dist, (Object) timeItem.dist) || !equals((Object) this.slowTime, (Object) timeItem.slowTime) || !equals((Object) this.etaTime, (Object) timeItem.etaTime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.startTime;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.endTime;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Double d = this.dist;
        int hashCode3 = (hashCode2 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.slowTime;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.etaTime;
        if (d3 != null) {
            i2 = d3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TimeItem> {
        public Double dist;
        public Integer endTime;
        public Double etaTime;
        public Double slowTime;
        public Integer startTime;

        public Builder() {
        }

        public Builder(TimeItem timeItem) {
            super(timeItem);
            if (timeItem != null) {
                this.startTime = timeItem.startTime;
                this.endTime = timeItem.endTime;
                this.dist = timeItem.dist;
                this.slowTime = timeItem.slowTime;
                this.etaTime = timeItem.etaTime;
            }
        }

        public Builder startTime(Integer num) {
            this.startTime = num;
            return this;
        }

        public Builder endTime(Integer num) {
            this.endTime = num;
            return this;
        }

        public Builder dist(Double d) {
            this.dist = d;
            return this;
        }

        public Builder slowTime(Double d) {
            this.slowTime = d;
            return this;
        }

        public Builder etaTime(Double d) {
            this.etaTime = d;
            return this;
        }

        public TimeItem build() {
            return new TimeItem(this);
        }
    }
}
