package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VICond extends Message {
    public static final Integer DEFAULT_ATTR = 0;
    public static final Integer DEFAULT_MAXNAVIDISTANCE = 0;
    public static final Integer DEFAULT_MAXNAVITIME = 0;
    public static final Integer DEFAULT_MAXROUTEGETTIME = 0;
    public static final Integer DEFAULT_MAXSPEED = 0;
    public static final Integer DEFAULT_MINNAVIDISTANCE = 0;
    public static final Integer DEFAULT_MINNAVITIME = 0;
    public static final Integer DEFAULT_MINROUTEGETTIME = 0;
    public static final Integer DEFAULT_MINSPEED = 0;
    public static final Integer DEFAULT_REPEATPLAYSECONDSATSAMPESTATE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer attr;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer maxNaviDistance;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer maxNaviTime;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer maxRouteGetTime;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer maxSpeed;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer minNaviDistance;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer minNaviTime;
    @ProtoField(tag = 9, type = Message.Datatype.UINT32)
    public final Integer minRouteGetTime;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer minSpeed;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer repeatPlaySecondsAtSampeState;

    public VICond(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10) {
        this.attr = num;
        this.minSpeed = num2;
        this.maxSpeed = num3;
        this.repeatPlaySecondsAtSampeState = num4;
        this.minNaviDistance = num5;
        this.maxNaviDistance = num6;
        this.minNaviTime = num7;
        this.maxNaviTime = num8;
        this.minRouteGetTime = num9;
        this.maxRouteGetTime = num10;
    }

    private VICond(Builder builder) {
        this(builder.attr, builder.minSpeed, builder.maxSpeed, builder.repeatPlaySecondsAtSampeState, builder.minNaviDistance, builder.maxNaviDistance, builder.minNaviTime, builder.maxNaviTime, builder.minRouteGetTime, builder.maxRouteGetTime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VICond)) {
            return false;
        }
        VICond vICond = (VICond) obj;
        if (!equals((Object) this.attr, (Object) vICond.attr) || !equals((Object) this.minSpeed, (Object) vICond.minSpeed) || !equals((Object) this.maxSpeed, (Object) vICond.maxSpeed) || !equals((Object) this.repeatPlaySecondsAtSampeState, (Object) vICond.repeatPlaySecondsAtSampeState) || !equals((Object) this.minNaviDistance, (Object) vICond.minNaviDistance) || !equals((Object) this.maxNaviDistance, (Object) vICond.maxNaviDistance) || !equals((Object) this.minNaviTime, (Object) vICond.minNaviTime) || !equals((Object) this.maxNaviTime, (Object) vICond.maxNaviTime) || !equals((Object) this.minRouteGetTime, (Object) vICond.minRouteGetTime) || !equals((Object) this.maxRouteGetTime, (Object) vICond.maxRouteGetTime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.attr;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.minSpeed;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.maxSpeed;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.repeatPlaySecondsAtSampeState;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.minNaviDistance;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.maxNaviDistance;
        int hashCode6 = (hashCode5 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.minNaviTime;
        int hashCode7 = (hashCode6 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.maxNaviTime;
        int hashCode8 = (hashCode7 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.minRouteGetTime;
        int hashCode9 = (hashCode8 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.maxRouteGetTime;
        if (num10 != null) {
            i2 = num10.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VICond> {
        public Integer attr;
        public Integer maxNaviDistance;
        public Integer maxNaviTime;
        public Integer maxRouteGetTime;
        public Integer maxSpeed;
        public Integer minNaviDistance;
        public Integer minNaviTime;
        public Integer minRouteGetTime;
        public Integer minSpeed;
        public Integer repeatPlaySecondsAtSampeState;

        public Builder() {
        }

        public Builder(VICond vICond) {
            super(vICond);
            if (vICond != null) {
                this.attr = vICond.attr;
                this.minSpeed = vICond.minSpeed;
                this.maxSpeed = vICond.maxSpeed;
                this.repeatPlaySecondsAtSampeState = vICond.repeatPlaySecondsAtSampeState;
                this.minNaviDistance = vICond.minNaviDistance;
                this.maxNaviDistance = vICond.maxNaviDistance;
                this.minNaviTime = vICond.minNaviTime;
                this.maxNaviTime = vICond.maxNaviTime;
                this.minRouteGetTime = vICond.minRouteGetTime;
                this.maxRouteGetTime = vICond.maxRouteGetTime;
            }
        }

        public Builder attr(Integer num) {
            this.attr = num;
            return this;
        }

        public Builder minSpeed(Integer num) {
            this.minSpeed = num;
            return this;
        }

        public Builder maxSpeed(Integer num) {
            this.maxSpeed = num;
            return this;
        }

        public Builder repeatPlaySecondsAtSampeState(Integer num) {
            this.repeatPlaySecondsAtSampeState = num;
            return this;
        }

        public Builder minNaviDistance(Integer num) {
            this.minNaviDistance = num;
            return this;
        }

        public Builder maxNaviDistance(Integer num) {
            this.maxNaviDistance = num;
            return this;
        }

        public Builder minNaviTime(Integer num) {
            this.minNaviTime = num;
            return this;
        }

        public Builder maxNaviTime(Integer num) {
            this.maxNaviTime = num;
            return this;
        }

        public Builder minRouteGetTime(Integer num) {
            this.minRouteGetTime = num;
            return this;
        }

        public Builder maxRouteGetTime(Integer num) {
            this.maxRouteGetTime = num;
            return this;
        }

        public VICond build() {
            checkRequiredFields();
            return new VICond(this);
        }
    }
}
