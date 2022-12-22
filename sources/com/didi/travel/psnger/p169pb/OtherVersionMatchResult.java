package com.didi.travel.psnger.p169pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.travel.psnger.pb.OtherVersionMatchResult */
public final class OtherVersionMatchResult extends Message {
    public static final Integer DEFAULT_CERTAINTY = 0;
    public static final Double DEFAULT_LINE_DIRECTION;
    public static final Double DEFAULT_LINE_SPEED;
    public static final Double DEFAULT_LINK_PASS_DIST;
    public static final Double DEFAULT_LINK_TRANSITION_DIST;
    public static final String DEFAULT_MAP_VERSION = "";
    public static final Long DEFAULT_PRE_LAST_LINK_ID = 0L;
    public static final Double DEFAULT_PROJ_LAT;
    public static final List<Long> DEFAULT_PROJ_LINK_ID = Collections.emptyList();
    public static final Double DEFAULT_PROJ_LNG;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer certainty;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)
    public final Double line_direction;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double line_speed;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double link_pass_dist;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double link_transition_dist;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String map_version;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long pre_last_link_id;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double proj_lat;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.UINT64)
    public final List<Long> proj_link_id;
    @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
    public final Double proj_lng;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_PROJ_LNG = valueOf;
        DEFAULT_PROJ_LAT = valueOf;
        DEFAULT_LINK_PASS_DIST = valueOf;
        DEFAULT_LINE_SPEED = valueOf;
        DEFAULT_LINE_DIRECTION = valueOf;
        DEFAULT_LINK_TRANSITION_DIST = valueOf;
    }

    public OtherVersionMatchResult(Double d, Double d2, List<Long> list, Double d3, Double d4, Double d5, Double d6, Long l, Integer num, String str) {
        this.proj_lng = d;
        this.proj_lat = d2;
        this.proj_link_id = immutableCopyOf(list);
        this.link_pass_dist = d3;
        this.line_speed = d4;
        this.line_direction = d5;
        this.link_transition_dist = d6;
        this.pre_last_link_id = l;
        this.certainty = num;
        this.map_version = str;
    }

    private OtherVersionMatchResult(Builder builder) {
        this(builder.proj_lng, builder.proj_lat, builder.proj_link_id, builder.link_pass_dist, builder.line_speed, builder.line_direction, builder.link_transition_dist, builder.pre_last_link_id, builder.certainty, builder.map_version);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtherVersionMatchResult)) {
            return false;
        }
        OtherVersionMatchResult otherVersionMatchResult = (OtherVersionMatchResult) obj;
        if (!equals((Object) this.proj_lng, (Object) otherVersionMatchResult.proj_lng) || !equals((Object) this.proj_lat, (Object) otherVersionMatchResult.proj_lat) || !equals((List<?>) this.proj_link_id, (List<?>) otherVersionMatchResult.proj_link_id) || !equals((Object) this.link_pass_dist, (Object) otherVersionMatchResult.link_pass_dist) || !equals((Object) this.line_speed, (Object) otherVersionMatchResult.line_speed) || !equals((Object) this.line_direction, (Object) otherVersionMatchResult.line_direction) || !equals((Object) this.link_transition_dist, (Object) otherVersionMatchResult.link_transition_dist) || !equals((Object) this.pre_last_link_id, (Object) otherVersionMatchResult.pre_last_link_id) || !equals((Object) this.certainty, (Object) otherVersionMatchResult.certainty) || !equals((Object) this.map_version, (Object) otherVersionMatchResult.map_version)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.proj_lng;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.proj_lat;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        List<Long> list = this.proj_link_id;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Double d3 = this.link_pass_dist;
        int hashCode4 = (hashCode3 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.line_speed;
        int hashCode5 = (hashCode4 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Double d5 = this.line_direction;
        int hashCode6 = (hashCode5 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Double d6 = this.link_transition_dist;
        int hashCode7 = (hashCode6 + (d6 != null ? d6.hashCode() : 0)) * 37;
        Long l = this.pre_last_link_id;
        int hashCode8 = (hashCode7 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.certainty;
        int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.map_version;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.travel.psnger.pb.OtherVersionMatchResult$Builder */
    public static final class Builder extends Message.Builder<OtherVersionMatchResult> {
        public Integer certainty;
        public Double line_direction;
        public Double line_speed;
        public Double link_pass_dist;
        public Double link_transition_dist;
        public String map_version;
        public Long pre_last_link_id;
        public Double proj_lat;
        public List<Long> proj_link_id;
        public Double proj_lng;

        public Builder() {
        }

        public Builder(OtherVersionMatchResult otherVersionMatchResult) {
            super(otherVersionMatchResult);
            if (otherVersionMatchResult != null) {
                this.proj_lng = otherVersionMatchResult.proj_lng;
                this.proj_lat = otherVersionMatchResult.proj_lat;
                this.proj_link_id = OtherVersionMatchResult.copyOf(otherVersionMatchResult.proj_link_id);
                this.link_pass_dist = otherVersionMatchResult.link_pass_dist;
                this.line_speed = otherVersionMatchResult.line_speed;
                this.line_direction = otherVersionMatchResult.line_direction;
                this.link_transition_dist = otherVersionMatchResult.link_transition_dist;
                this.pre_last_link_id = otherVersionMatchResult.pre_last_link_id;
                this.certainty = otherVersionMatchResult.certainty;
                this.map_version = otherVersionMatchResult.map_version;
            }
        }

        public Builder proj_lng(Double d) {
            this.proj_lng = d;
            return this;
        }

        public Builder proj_lat(Double d) {
            this.proj_lat = d;
            return this;
        }

        public Builder proj_link_id(List<Long> list) {
            this.proj_link_id = checkForNulls(list);
            return this;
        }

        public Builder link_pass_dist(Double d) {
            this.link_pass_dist = d;
            return this;
        }

        public Builder line_speed(Double d) {
            this.line_speed = d;
            return this;
        }

        public Builder line_direction(Double d) {
            this.line_direction = d;
            return this;
        }

        public Builder link_transition_dist(Double d) {
            this.link_transition_dist = d;
            return this;
        }

        public Builder pre_last_link_id(Long l) {
            this.pre_last_link_id = l;
            return this;
        }

        public Builder certainty(Integer num) {
            this.certainty = num;
            return this;
        }

        public Builder map_version(String str) {
            this.map_version = str;
            return this;
        }

        public OtherVersionMatchResult build() {
            return new OtherVersionMatchResult(this);
        }
    }
}
