package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DIIntersection extends Message {
    public static final Integer DEFAULT_ACTIONLENGTH = 0;
    public static final List<GeoPoint> DEFAULT_ARROWPOS = Collections.emptyList();
    public static final Integer DEFAULT_CONNECTLENGTH = 0;
    public static final Integer DEFAULT_INTERSECTION = 0;
    public static final List<Integer> DEFAULT_NEWINTERSECTIONS = Collections.emptyList();
    public static final String DEFAULT_OUTROADNAME = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.UINT32)
    public final Integer actionLength;
    @ProtoField(label = Message.Label.REPEATED, messageType = GeoPoint.class, tag = 3)
    public final List<GeoPoint> arrowPos;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer connectLength;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT32)
    public final Integer intersection;
    @ProtoField(label = Message.Label.REPEATED, tag = 7, type = Message.Datatype.UINT32)
    public final List<Integer> newIntersections;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String outRoadName;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DIIntersection(MapRoutePoint mapRoutePoint, Integer num, List<GeoPoint> list, Integer num2, String str, Integer num3, List<Integer> list2) {
        this.targetPos = mapRoutePoint;
        this.intersection = num;
        this.arrowPos = immutableCopyOf(list);
        this.actionLength = num2;
        this.outRoadName = str;
        this.connectLength = num3;
        this.newIntersections = immutableCopyOf(list2);
    }

    private DIIntersection(Builder builder) {
        this(builder.targetPos, builder.intersection, builder.arrowPos, builder.actionLength, builder.outRoadName, builder.connectLength, builder.newIntersections);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DIIntersection)) {
            return false;
        }
        DIIntersection dIIntersection = (DIIntersection) obj;
        if (!equals((Object) this.targetPos, (Object) dIIntersection.targetPos) || !equals((Object) this.intersection, (Object) dIIntersection.intersection) || !equals((List<?>) this.arrowPos, (List<?>) dIIntersection.arrowPos) || !equals((Object) this.actionLength, (Object) dIIntersection.actionLength) || !equals((Object) this.outRoadName, (Object) dIIntersection.outRoadName) || !equals((Object) this.connectLength, (Object) dIIntersection.connectLength) || !equals((List<?>) this.newIntersections, (List<?>) dIIntersection.newIntersections)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        MapRoutePoint mapRoutePoint = this.targetPos;
        int i2 = 0;
        int hashCode = (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0) * 37;
        Integer num = this.intersection;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<GeoPoint> list = this.arrowPos;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.actionLength;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.outRoadName;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.connectLength;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i4 = (hashCode5 + i2) * 37;
        List<Integer> list2 = this.newIntersections;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<DIIntersection> {
        public Integer actionLength;
        public List<GeoPoint> arrowPos;
        public Integer connectLength;
        public Integer intersection;
        public List<Integer> newIntersections;
        public String outRoadName;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DIIntersection dIIntersection) {
            super(dIIntersection);
            if (dIIntersection != null) {
                this.targetPos = dIIntersection.targetPos;
                this.intersection = dIIntersection.intersection;
                this.arrowPos = DIIntersection.copyOf(dIIntersection.arrowPos);
                this.actionLength = dIIntersection.actionLength;
                this.outRoadName = dIIntersection.outRoadName;
                this.connectLength = dIIntersection.connectLength;
                this.newIntersections = DIIntersection.copyOf(dIIntersection.newIntersections);
            }
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        public Builder intersection(Integer num) {
            this.intersection = num;
            return this;
        }

        public Builder arrowPos(List<GeoPoint> list) {
            this.arrowPos = checkForNulls(list);
            return this;
        }

        public Builder actionLength(Integer num) {
            this.actionLength = num;
            return this;
        }

        public Builder outRoadName(String str) {
            this.outRoadName = str;
            return this;
        }

        public Builder connectLength(Integer num) {
            this.connectLength = num;
            return this;
        }

        public Builder newIntersections(List<Integer> list) {
            this.newIntersections = checkForNulls(list);
            return this;
        }

        public DIIntersection build() {
            checkRequiredFields();
            return new DIIntersection(this);
        }
    }
}
