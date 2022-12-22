package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class NaviTraffic extends Message {
    public static final Integer DEFAULT_ANGLE = 0;
    public static final String DEFAULT_DESC = "";
    public static final Integer DEFAULT_ETA = 0;
    public static final Integer DEFAULT_EVENT_ID = 0;
    public static final Integer DEFAULT_EVENT_TYPE = 0;
    public static final Integer DEFAULT_IDX = 0;
    public static final Integer DEFAULT_INFORM_TYPE = 0;
    public static final String DEFAULT_ROADNAME = "";
    public static final Integer DEFAULT_SHAPE_TYPE = 0;
    public static final Integer DEFAULT_SPEED = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer angle;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String desc;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer event_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer event_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer idx;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer inform_type;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String roadname;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer shape_type;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer speed;

    public NaviTraffic(Integer num, Integer num2, Integer num3, Integer num4, String str, Integer num5, Integer num6, String str2, Integer num7, Integer num8) {
        this.idx = num;
        this.event_type = num2;
        this.event_id = num3;
        this.angle = num4;
        this.desc = str;
        this.inform_type = num5;
        this.shape_type = num6;
        this.roadname = str2;
        this.speed = num7;
        this.eta = num8;
    }

    private NaviTraffic(Builder builder) {
        this(builder.idx, builder.event_type, builder.event_id, builder.angle, builder.desc, builder.inform_type, builder.shape_type, builder.roadname, builder.speed, builder.eta);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NaviTraffic)) {
            return false;
        }
        NaviTraffic naviTraffic = (NaviTraffic) obj;
        if (!equals((Object) this.idx, (Object) naviTraffic.idx) || !equals((Object) this.event_type, (Object) naviTraffic.event_type) || !equals((Object) this.event_id, (Object) naviTraffic.event_id) || !equals((Object) this.angle, (Object) naviTraffic.angle) || !equals((Object) this.desc, (Object) naviTraffic.desc) || !equals((Object) this.inform_type, (Object) naviTraffic.inform_type) || !equals((Object) this.shape_type, (Object) naviTraffic.shape_type) || !equals((Object) this.roadname, (Object) naviTraffic.roadname) || !equals((Object) this.speed, (Object) naviTraffic.speed) || !equals((Object) this.eta, (Object) naviTraffic.eta)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.idx;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.event_type;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.event_id;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.angle;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.desc;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num5 = this.inform_type;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.shape_type;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str2 = this.roadname;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num7 = this.speed;
        int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.eta;
        if (num8 != null) {
            i2 = num8.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<NaviTraffic> {
        public Integer angle;
        public String desc;
        public Integer eta;
        public Integer event_id;
        public Integer event_type;
        public Integer idx;
        public Integer inform_type;
        public String roadname;
        public Integer shape_type;
        public Integer speed;

        public Builder() {
        }

        public Builder(NaviTraffic naviTraffic) {
            super(naviTraffic);
            if (naviTraffic != null) {
                this.idx = naviTraffic.idx;
                this.event_type = naviTraffic.event_type;
                this.event_id = naviTraffic.event_id;
                this.angle = naviTraffic.angle;
                this.desc = naviTraffic.desc;
                this.inform_type = naviTraffic.inform_type;
                this.shape_type = naviTraffic.shape_type;
                this.roadname = naviTraffic.roadname;
                this.speed = naviTraffic.speed;
                this.eta = naviTraffic.eta;
            }
        }

        public Builder idx(Integer num) {
            this.idx = num;
            return this;
        }

        public Builder event_type(Integer num) {
            this.event_type = num;
            return this;
        }

        public Builder event_id(Integer num) {
            this.event_id = num;
            return this;
        }

        public Builder angle(Integer num) {
            this.angle = num;
            return this;
        }

        public Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public Builder inform_type(Integer num) {
            this.inform_type = num;
            return this;
        }

        public Builder shape_type(Integer num) {
            this.shape_type = num;
            return this;
        }

        public Builder roadname(String str) {
            this.roadname = str;
            return this;
        }

        public Builder speed(Integer num) {
            this.speed = num;
            return this;
        }

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public NaviTraffic build() {
            checkRequiredFields();
            return new NaviTraffic(this);
        }
    }
}
