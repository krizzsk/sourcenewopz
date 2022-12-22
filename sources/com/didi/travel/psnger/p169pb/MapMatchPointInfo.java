package com.didi.travel.psnger.p169pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.travel.psnger.pb.MapMatchPointInfo */
public final class MapMatchPointInfo extends Message {
    public static final Integer DEFAULT_CERTAINTY = 0;
    public static final Double DEFAULT_LINE_DIRECTION;
    public static final Double DEFAULT_LINE_SPEED;
    public static final Double DEFAULT_LINK_PASS_DIST;
    public static final Double DEFAULT_LINK_TRANSITION_DIST;
    public static final List<String> DEFAULT_MAP_VERSION_VEC = Collections.emptyList();
    public static final List<OtherVersionMatchResult> DEFAULT_OTHER_VERSION_RESULT = Collections.emptyList();
    public static final PointType DEFAULT_POINT_TYPE = PointType.NormalMatchPoint;
    public static final Long DEFAULT_PRE_LAST_LINK_ID = 0L;
    public static final Double DEFAULT_PROJ_LAT;
    public static final List<Long> DEFAULT_PROJ_LINK_ID = Collections.emptyList();
    public static final Double DEFAULT_PROJ_LNG;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer certainty;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double line_direction;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)
    public final Double line_speed;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double link_pass_dist;
    @ProtoField(tag = 8, type = Message.Datatype.DOUBLE)
    public final Double link_transition_dist;
    @ProtoField(label = Message.Label.REPEATED, tag = 30, type = Message.Datatype.STRING)
    public final List<String> map_version_vec;
    @ProtoField(label = Message.Label.REPEATED, messageType = OtherVersionMatchResult.class, tag = 31)
    public final List<OtherVersionMatchResult> other_version_result;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.ENUM)
    public final PointType point_type;
    @ProtoField(tag = 9, type = Message.Datatype.UINT64)
    public final Long pre_last_link_id;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double proj_lat;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.UINT64)
    public final List<Long> proj_link_id;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double proj_lng;
    @ProtoField(tag = 11, type = Message.Datatype.UINT64)
    public final Long timestamp;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_PROJ_LNG = valueOf;
        DEFAULT_PROJ_LAT = valueOf;
        DEFAULT_LINK_PASS_DIST = valueOf;
        DEFAULT_LINE_SPEED = valueOf;
        DEFAULT_LINE_DIRECTION = valueOf;
        DEFAULT_LINK_TRANSITION_DIST = valueOf;
    }

    public MapMatchPointInfo(PointType pointType, Double d, Double d2, List<Long> list, Double d3, Double d4, Double d5, Double d6, Long l, Integer num, Long l2, List<String> list2, List<OtherVersionMatchResult> list3) {
        this.point_type = pointType;
        this.proj_lng = d;
        this.proj_lat = d2;
        this.proj_link_id = immutableCopyOf(list);
        this.link_pass_dist = d3;
        this.line_speed = d4;
        this.line_direction = d5;
        this.link_transition_dist = d6;
        this.pre_last_link_id = l;
        this.certainty = num;
        this.timestamp = l2;
        this.map_version_vec = immutableCopyOf(list2);
        this.other_version_result = immutableCopyOf(list3);
    }

    private MapMatchPointInfo(Builder builder) {
        this(builder.point_type, builder.proj_lng, builder.proj_lat, builder.proj_link_id, builder.link_pass_dist, builder.line_speed, builder.line_direction, builder.link_transition_dist, builder.pre_last_link_id, builder.certainty, builder.timestamp, builder.map_version_vec, builder.other_version_result);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapMatchPointInfo)) {
            return false;
        }
        MapMatchPointInfo mapMatchPointInfo = (MapMatchPointInfo) obj;
        if (!equals((Object) this.point_type, (Object) mapMatchPointInfo.point_type) || !equals((Object) this.proj_lng, (Object) mapMatchPointInfo.proj_lng) || !equals((Object) this.proj_lat, (Object) mapMatchPointInfo.proj_lat) || !equals((List<?>) this.proj_link_id, (List<?>) mapMatchPointInfo.proj_link_id) || !equals((Object) this.link_pass_dist, (Object) mapMatchPointInfo.link_pass_dist) || !equals((Object) this.line_speed, (Object) mapMatchPointInfo.line_speed) || !equals((Object) this.line_direction, (Object) mapMatchPointInfo.line_direction) || !equals((Object) this.link_transition_dist, (Object) mapMatchPointInfo.link_transition_dist) || !equals((Object) this.pre_last_link_id, (Object) mapMatchPointInfo.pre_last_link_id) || !equals((Object) this.certainty, (Object) mapMatchPointInfo.certainty) || !equals((Object) this.timestamp, (Object) mapMatchPointInfo.timestamp) || !equals((List<?>) this.map_version_vec, (List<?>) mapMatchPointInfo.map_version_vec) || !equals((List<?>) this.other_version_result, (List<?>) mapMatchPointInfo.other_version_result)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        PointType pointType = this.point_type;
        int i2 = 0;
        int hashCode = (pointType != null ? pointType.hashCode() : 0) * 37;
        Double d = this.proj_lng;
        int hashCode2 = (hashCode + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.proj_lat;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
        List<Long> list = this.proj_link_id;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Double d3 = this.link_pass_dist;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.line_speed;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Double d5 = this.line_direction;
        int hashCode7 = (hashCode6 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Double d6 = this.link_transition_dist;
        int hashCode8 = (hashCode7 + (d6 != null ? d6.hashCode() : 0)) * 37;
        Long l = this.pre_last_link_id;
        int hashCode9 = (hashCode8 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.certainty;
        int hashCode10 = (hashCode9 + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.timestamp;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i4 = (hashCode10 + i2) * 37;
        List<String> list2 = this.map_version_vec;
        int hashCode11 = (i4 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<OtherVersionMatchResult> list3 = this.other_version_result;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i5 = hashCode11 + i3;
        this.hashCode = i5;
        return i5;
    }

    /* renamed from: com.didi.travel.psnger.pb.MapMatchPointInfo$Builder */
    public static final class Builder extends Message.Builder<MapMatchPointInfo> {
        public Integer certainty;
        public Double line_direction;
        public Double line_speed;
        public Double link_pass_dist;
        public Double link_transition_dist;
        public List<String> map_version_vec;
        public List<OtherVersionMatchResult> other_version_result;
        public PointType point_type;
        public Long pre_last_link_id;
        public Double proj_lat;
        public List<Long> proj_link_id;
        public Double proj_lng;
        public Long timestamp;

        public Builder() {
        }

        public Builder(MapMatchPointInfo mapMatchPointInfo) {
            super(mapMatchPointInfo);
            if (mapMatchPointInfo != null) {
                this.point_type = mapMatchPointInfo.point_type;
                this.proj_lng = mapMatchPointInfo.proj_lng;
                this.proj_lat = mapMatchPointInfo.proj_lat;
                this.proj_link_id = MapMatchPointInfo.copyOf(mapMatchPointInfo.proj_link_id);
                this.link_pass_dist = mapMatchPointInfo.link_pass_dist;
                this.line_speed = mapMatchPointInfo.line_speed;
                this.line_direction = mapMatchPointInfo.line_direction;
                this.link_transition_dist = mapMatchPointInfo.link_transition_dist;
                this.pre_last_link_id = mapMatchPointInfo.pre_last_link_id;
                this.certainty = mapMatchPointInfo.certainty;
                this.timestamp = mapMatchPointInfo.timestamp;
                this.map_version_vec = MapMatchPointInfo.copyOf(mapMatchPointInfo.map_version_vec);
                this.other_version_result = MapMatchPointInfo.copyOf(mapMatchPointInfo.other_version_result);
            }
        }

        public Builder point_type(PointType pointType) {
            this.point_type = pointType;
            return this;
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

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder map_version_vec(List<String> list) {
            this.map_version_vec = checkForNulls(list);
            return this;
        }

        public Builder other_version_result(List<OtherVersionMatchResult> list) {
            this.other_version_result = checkForNulls(list);
            return this;
        }

        public MapMatchPointInfo build() {
            checkRequiredFields();
            return new MapMatchPointInfo(this);
        }
    }
}
