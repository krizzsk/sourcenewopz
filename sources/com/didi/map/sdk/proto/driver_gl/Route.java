package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class Route extends Message {
    public static final Integer DEFAULT_DISTANCE = -1;
    public static final Integer DEFAULT_ETA = -1;
    public static final Integer DEFAULT_INCLUDED = 0;
    public static final List<RoadNameItem> DEFAULT_ROADNAME = Collections.emptyList();
    public static final Long DEFAULT_ROUTEID = 0L;
    public static final String DEFAULT_ROUTELABEL = "";
    public static final Integer DEFAULT_SEPIDX = 0;
    public static final List<TrafficItem> DEFAULT_TRAFFIC = Collections.emptyList();
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer distance;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer included;
    @ProtoField(tag = 8)

    /* renamed from: rf */
    public final RouteFeature f28606rf;
    @ProtoField(label = Message.Label.REPEATED, messageType = RoadNameItem.class, tag = 7)
    public final List<RoadNameItem> roadName;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
    public final Long routeId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String routeLabel;
    @ProtoField(tag = 3)
    public final DiffGeoPoints routePoints;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer sepIdx;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrafficItem.class, tag = 4)
    public final List<TrafficItem> traffic;

    public Route(Long l, String str, DiffGeoPoints diffGeoPoints, List<TrafficItem> list, Integer num, Integer num2, List<RoadNameItem> list2, RouteFeature routeFeature, Integer num3, Integer num4) {
        this.routeId = l;
        this.routeLabel = str;
        this.routePoints = diffGeoPoints;
        this.traffic = immutableCopyOf(list);
        this.eta = num;
        this.distance = num2;
        this.roadName = immutableCopyOf(list2);
        this.f28606rf = routeFeature;
        this.sepIdx = num3;
        this.included = num4;
    }

    private Route(Builder builder) {
        this(builder.routeId, builder.routeLabel, builder.routePoints, builder.traffic, builder.eta, builder.distance, builder.roadName, builder.f28607rf, builder.sepIdx, builder.included);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        if (!equals((Object) this.routeId, (Object) route.routeId) || !equals((Object) this.routeLabel, (Object) route.routeLabel) || !equals((Object) this.routePoints, (Object) route.routePoints) || !equals((List<?>) this.traffic, (List<?>) route.traffic) || !equals((Object) this.eta, (Object) route.eta) || !equals((Object) this.distance, (Object) route.distance) || !equals((List<?>) this.roadName, (List<?>) route.roadName) || !equals((Object) this.f28606rf, (Object) route.f28606rf) || !equals((Object) this.sepIdx, (Object) route.sepIdx) || !equals((Object) this.included, (Object) route.included)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.routeId;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.routeLabel;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        DiffGeoPoints diffGeoPoints = this.routePoints;
        int hashCode3 = (hashCode2 + (diffGeoPoints != null ? diffGeoPoints.hashCode() : 0)) * 37;
        List<TrafficItem> list = this.traffic;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.eta;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.distance;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<RoadNameItem> list2 = this.roadName;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode6 + i3) * 37;
        RouteFeature routeFeature = this.f28606rf;
        int hashCode7 = (i4 + (routeFeature != null ? routeFeature.hashCode() : 0)) * 37;
        Integer num3 = this.sepIdx;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.included;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i5 = hashCode8 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<Route> {
        public Integer distance;
        public Integer eta;
        public Integer included;

        /* renamed from: rf */
        public RouteFeature f28607rf;
        public List<RoadNameItem> roadName;
        public Long routeId;
        public String routeLabel;
        public DiffGeoPoints routePoints;
        public Integer sepIdx;
        public List<TrafficItem> traffic;

        public Builder() {
        }

        public Builder(Route route) {
            super(route);
            if (route != null) {
                this.routeId = route.routeId;
                this.routeLabel = route.routeLabel;
                this.routePoints = route.routePoints;
                this.traffic = Route.copyOf(route.traffic);
                this.eta = route.eta;
                this.distance = route.distance;
                this.roadName = Route.copyOf(route.roadName);
                this.f28607rf = route.f28606rf;
                this.sepIdx = route.sepIdx;
                this.included = route.included;
            }
        }

        public Builder routeId(Long l) {
            this.routeId = l;
            return this;
        }

        public Builder routeLabel(String str) {
            this.routeLabel = str;
            return this;
        }

        public Builder routePoints(DiffGeoPoints diffGeoPoints) {
            this.routePoints = diffGeoPoints;
            return this;
        }

        public Builder traffic(List<TrafficItem> list) {
            this.traffic = checkForNulls(list);
            return this;
        }

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public Builder distance(Integer num) {
            this.distance = num;
            return this;
        }

        public Builder roadName(List<RoadNameItem> list) {
            this.roadName = checkForNulls(list);
            return this;
        }

        /* renamed from: rf */
        public Builder mo78675rf(RouteFeature routeFeature) {
            this.f28607rf = routeFeature;
            return this;
        }

        public Builder sepIdx(Integer num) {
            this.sepIdx = num;
            return this;
        }

        public Builder included(Integer num) {
            this.included = num;
            return this;
        }

        public Route build() {
            checkRequiredFields();
            return new Route(this);
        }
    }
}
