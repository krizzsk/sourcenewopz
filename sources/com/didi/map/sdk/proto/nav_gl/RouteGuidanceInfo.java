package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RouteGuidanceInfo extends Message {
    public static final String DEFAULT_ARGS = "";
    public static final Integer DEFAULT_COLOR = 0;
    public static final List<GeoPoint> DEFAULT_COOR = Collections.emptyList();
    public static final Integer DEFAULT_DISTANCE = 0;
    public static final List<Event> DEFAULT_EVENT = Collections.emptyList();
    public static final List<RouteRoadName> DEFAULT_ROADNAME = Collections.emptyList();
    public static final Long DEFAULT_ROUTEID = 0L;
    public static final List<RouteSegInfo> DEFAULT_SEGINFOS = Collections.emptyList();
    public static final List<RouteTag> DEFAULT_TAG = Collections.emptyList();
    public static final Integer DEFAULT_TIME = 0;
    public static final List<MapRoutePoint> DEFAULT_TRAFFICLIGHT = Collections.emptyList();
    public static final Integer DEFAULT_TRAFFICTIME = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String args;
    @ProtoField(tag = 4)
    public final GeoRect bounds;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer color;
    @ProtoField(label = Message.Label.REPEATED, messageType = GeoPoint.class, tag = 3)
    public final List<GeoPoint> coor;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer distance;
    @ProtoField(label = Message.Label.REPEATED, messageType = Event.class, tag = 9)
    public final List<Event> event;
    @ProtoField(tag = 14)
    public final MapRoutePoint forkPoint;
    @ProtoField(label = Message.Label.REPEATED, messageType = RouteRoadName.class, tag = 11)
    public final List<RouteRoadName> roadName;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long routeid;
    @ProtoField(label = Message.Label.REPEATED, messageType = RouteSegInfo.class, tag = 15)
    public final List<RouteSegInfo> segInfos;
    @ProtoField(label = Message.Label.REPEATED, messageType = RouteTag.class, tag = 13)
    public final List<RouteTag> tag;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer time;
    @ProtoField(tag = 10)
    public final RouteTrafficInfo trafficInfo;
    @ProtoField(label = Message.Label.REPEATED, messageType = MapRoutePoint.class, tag = 12)
    public final List<MapRoutePoint> trafficLight;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer traffictime;

    public RouteGuidanceInfo(String str, Integer num, List<GeoPoint> list, GeoRect geoRect, Integer num2, Long l, Integer num3, Integer num4, List<Event> list2, RouteTrafficInfo routeTrafficInfo, List<RouteRoadName> list3, List<MapRoutePoint> list4, List<RouteTag> list5, MapRoutePoint mapRoutePoint, List<RouteSegInfo> list6) {
        this.args = str;
        this.color = num;
        this.coor = immutableCopyOf(list);
        this.bounds = geoRect;
        this.distance = num2;
        this.routeid = l;
        this.time = num3;
        this.traffictime = num4;
        this.event = immutableCopyOf(list2);
        this.trafficInfo = routeTrafficInfo;
        this.roadName = immutableCopyOf(list3);
        this.trafficLight = immutableCopyOf(list4);
        this.tag = immutableCopyOf(list5);
        this.forkPoint = mapRoutePoint;
        this.segInfos = immutableCopyOf(list6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private RouteGuidanceInfo(com.didi.map.sdk.proto.nav_gl.RouteGuidanceInfo.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r2 = r0.args
            java.lang.Integer r3 = r0.color
            java.util.List<com.didi.map.sdk.proto.nav_gl.GeoPoint> r4 = r0.coor
            com.didi.map.sdk.proto.nav_gl.GeoRect r5 = r0.bounds
            java.lang.Integer r6 = r0.distance
            java.lang.Long r7 = r0.routeid
            java.lang.Integer r8 = r0.time
            java.lang.Integer r9 = r0.traffictime
            java.util.List<com.didi.map.sdk.proto.nav_gl.Event> r10 = r0.event
            com.didi.map.sdk.proto.nav_gl.RouteTrafficInfo r11 = r0.trafficInfo
            java.util.List<com.didi.map.sdk.proto.nav_gl.RouteRoadName> r12 = r0.roadName
            java.util.List<com.didi.map.sdk.proto.nav_gl.MapRoutePoint> r13 = r0.trafficLight
            java.util.List<com.didi.map.sdk.proto.nav_gl.RouteTag> r14 = r0.tag
            com.didi.map.sdk.proto.nav_gl.MapRoutePoint r15 = r0.forkPoint
            java.util.List<com.didi.map.sdk.proto.nav_gl.RouteSegInfo> r1 = r0.segInfos
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.nav_gl.RouteGuidanceInfo.<init>(com.didi.map.sdk.proto.nav_gl.RouteGuidanceInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteGuidanceInfo)) {
            return false;
        }
        RouteGuidanceInfo routeGuidanceInfo = (RouteGuidanceInfo) obj;
        if (!equals((Object) this.args, (Object) routeGuidanceInfo.args) || !equals((Object) this.color, (Object) routeGuidanceInfo.color) || !equals((List<?>) this.coor, (List<?>) routeGuidanceInfo.coor) || !equals((Object) this.bounds, (Object) routeGuidanceInfo.bounds) || !equals((Object) this.distance, (Object) routeGuidanceInfo.distance) || !equals((Object) this.routeid, (Object) routeGuidanceInfo.routeid) || !equals((Object) this.time, (Object) routeGuidanceInfo.time) || !equals((Object) this.traffictime, (Object) routeGuidanceInfo.traffictime) || !equals((List<?>) this.event, (List<?>) routeGuidanceInfo.event) || !equals((Object) this.trafficInfo, (Object) routeGuidanceInfo.trafficInfo) || !equals((List<?>) this.roadName, (List<?>) routeGuidanceInfo.roadName) || !equals((List<?>) this.trafficLight, (List<?>) routeGuidanceInfo.trafficLight) || !equals((List<?>) this.tag, (List<?>) routeGuidanceInfo.tag) || !equals((Object) this.forkPoint, (Object) routeGuidanceInfo.forkPoint) || !equals((List<?>) this.segInfos, (List<?>) routeGuidanceInfo.segInfos)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.args;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.color;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<GeoPoint> list = this.coor;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        GeoRect geoRect = this.bounds;
        int hashCode4 = (hashCode3 + (geoRect != null ? geoRect.hashCode() : 0)) * 37;
        Integer num2 = this.distance;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.routeid;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.time;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.traffictime;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        List<Event> list2 = this.event;
        int hashCode9 = (hashCode8 + (list2 != null ? list2.hashCode() : 1)) * 37;
        RouteTrafficInfo routeTrafficInfo = this.trafficInfo;
        int hashCode10 = (hashCode9 + (routeTrafficInfo != null ? routeTrafficInfo.hashCode() : 0)) * 37;
        List<RouteRoadName> list3 = this.roadName;
        int hashCode11 = (hashCode10 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<MapRoutePoint> list4 = this.trafficLight;
        int hashCode12 = (hashCode11 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<RouteTag> list5 = this.tag;
        int hashCode13 = (hashCode12 + (list5 != null ? list5.hashCode() : 1)) * 37;
        MapRoutePoint mapRoutePoint = this.forkPoint;
        if (mapRoutePoint != null) {
            i2 = mapRoutePoint.hashCode();
        }
        int i4 = (hashCode13 + i2) * 37;
        List<RouteSegInfo> list6 = this.segInfos;
        if (list6 != null) {
            i3 = list6.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<RouteGuidanceInfo> {
        public String args;
        public GeoRect bounds;
        public Integer color;
        public List<GeoPoint> coor;
        public Integer distance;
        public List<Event> event;
        public MapRoutePoint forkPoint;
        public List<RouteRoadName> roadName;
        public Long routeid;
        public List<RouteSegInfo> segInfos;
        public List<RouteTag> tag;
        public Integer time;
        public RouteTrafficInfo trafficInfo;
        public List<MapRoutePoint> trafficLight;
        public Integer traffictime;

        public Builder() {
        }

        public Builder(RouteGuidanceInfo routeGuidanceInfo) {
            super(routeGuidanceInfo);
            if (routeGuidanceInfo != null) {
                this.args = routeGuidanceInfo.args;
                this.color = routeGuidanceInfo.color;
                this.coor = RouteGuidanceInfo.copyOf(routeGuidanceInfo.coor);
                this.bounds = routeGuidanceInfo.bounds;
                this.distance = routeGuidanceInfo.distance;
                this.routeid = routeGuidanceInfo.routeid;
                this.time = routeGuidanceInfo.time;
                this.traffictime = routeGuidanceInfo.traffictime;
                this.event = RouteGuidanceInfo.copyOf(routeGuidanceInfo.event);
                this.trafficInfo = routeGuidanceInfo.trafficInfo;
                this.roadName = RouteGuidanceInfo.copyOf(routeGuidanceInfo.roadName);
                this.trafficLight = RouteGuidanceInfo.copyOf(routeGuidanceInfo.trafficLight);
                this.tag = RouteGuidanceInfo.copyOf(routeGuidanceInfo.tag);
                this.forkPoint = routeGuidanceInfo.forkPoint;
                this.segInfos = RouteGuidanceInfo.copyOf(routeGuidanceInfo.segInfos);
            }
        }

        public Builder args(String str) {
            this.args = str;
            return this;
        }

        public Builder color(Integer num) {
            this.color = num;
            return this;
        }

        public Builder coor(List<GeoPoint> list) {
            this.coor = checkForNulls(list);
            return this;
        }

        public Builder bounds(GeoRect geoRect) {
            this.bounds = geoRect;
            return this;
        }

        public Builder distance(Integer num) {
            this.distance = num;
            return this;
        }

        public Builder routeid(Long l) {
            this.routeid = l;
            return this;
        }

        public Builder time(Integer num) {
            this.time = num;
            return this;
        }

        public Builder traffictime(Integer num) {
            this.traffictime = num;
            return this;
        }

        public Builder event(List<Event> list) {
            this.event = checkForNulls(list);
            return this;
        }

        public Builder trafficInfo(RouteTrafficInfo routeTrafficInfo) {
            this.trafficInfo = routeTrafficInfo;
            return this;
        }

        public Builder roadName(List<RouteRoadName> list) {
            this.roadName = checkForNulls(list);
            return this;
        }

        public Builder trafficLight(List<MapRoutePoint> list) {
            this.trafficLight = checkForNulls(list);
            return this;
        }

        public Builder tag(List<RouteTag> list) {
            this.tag = checkForNulls(list);
            return this;
        }

        public Builder forkPoint(MapRoutePoint mapRoutePoint) {
            this.forkPoint = mapRoutePoint;
            return this;
        }

        public Builder segInfos(List<RouteSegInfo> list) {
            this.segInfos = checkForNulls(list);
            return this;
        }

        public RouteGuidanceInfo build() {
            return new RouteGuidanceInfo(this);
        }
    }
}
