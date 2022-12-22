package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RouteTrafficInfo extends Message {
    public static final List<TrafficEta> DEFAULT_ETA = Collections.emptyList();
    public static final List<TrafficStatusLine> DEFAULT_LINESTATUS = Collections.emptyList();
    public static final List<TrafficStatusPoint> DEFAULT_POINTSTATUS = Collections.emptyList();
    public static final Integer DEFAULT_UPDATECOORINDEX = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrafficEta.class, tag = 3)
    public final List<TrafficEta> eta;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrafficStatusLine.class, tag = 2)
    public final List<TrafficStatusLine> lineStatus;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrafficStatusPoint.class, tag = 1)
    public final List<TrafficStatusPoint> pointStatus;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer updateCoorIndex;
    @ProtoField(tag = 4)
    public final GeoPoint updatePos;

    public RouteTrafficInfo(List<TrafficStatusPoint> list, List<TrafficStatusLine> list2, List<TrafficEta> list3, GeoPoint geoPoint, Integer num) {
        this.pointStatus = immutableCopyOf(list);
        this.lineStatus = immutableCopyOf(list2);
        this.eta = immutableCopyOf(list3);
        this.updatePos = geoPoint;
        this.updateCoorIndex = num;
    }

    private RouteTrafficInfo(Builder builder) {
        this(builder.pointStatus, builder.lineStatus, builder.eta, builder.updatePos, builder.updateCoorIndex);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteTrafficInfo)) {
            return false;
        }
        RouteTrafficInfo routeTrafficInfo = (RouteTrafficInfo) obj;
        if (!equals((List<?>) this.pointStatus, (List<?>) routeTrafficInfo.pointStatus) || !equals((List<?>) this.lineStatus, (List<?>) routeTrafficInfo.lineStatus) || !equals((List<?>) this.eta, (List<?>) routeTrafficInfo.eta) || !equals((Object) this.updatePos, (Object) routeTrafficInfo.updatePos) || !equals((Object) this.updateCoorIndex, (Object) routeTrafficInfo.updateCoorIndex)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<TrafficStatusPoint> list = this.pointStatus;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<TrafficStatusLine> list2 = this.lineStatus;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<TrafficEta> list3 = this.eta;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        GeoPoint geoPoint = this.updatePos;
        int i4 = 0;
        int hashCode3 = (i3 + (geoPoint != null ? geoPoint.hashCode() : 0)) * 37;
        Integer num = this.updateCoorIndex;
        if (num != null) {
            i4 = num.hashCode();
        }
        int i5 = hashCode3 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<RouteTrafficInfo> {
        public List<TrafficEta> eta;
        public List<TrafficStatusLine> lineStatus;
        public List<TrafficStatusPoint> pointStatus;
        public Integer updateCoorIndex;
        public GeoPoint updatePos;

        public Builder() {
        }

        public Builder(RouteTrafficInfo routeTrafficInfo) {
            super(routeTrafficInfo);
            if (routeTrafficInfo != null) {
                this.pointStatus = RouteTrafficInfo.copyOf(routeTrafficInfo.pointStatus);
                this.lineStatus = RouteTrafficInfo.copyOf(routeTrafficInfo.lineStatus);
                this.eta = RouteTrafficInfo.copyOf(routeTrafficInfo.eta);
                this.updatePos = routeTrafficInfo.updatePos;
                this.updateCoorIndex = routeTrafficInfo.updateCoorIndex;
            }
        }

        public Builder pointStatus(List<TrafficStatusPoint> list) {
            this.pointStatus = checkForNulls(list);
            return this;
        }

        public Builder lineStatus(List<TrafficStatusLine> list) {
            this.lineStatus = checkForNulls(list);
            return this;
        }

        public Builder eta(List<TrafficEta> list) {
            this.eta = checkForNulls(list);
            return this;
        }

        public Builder updatePos(GeoPoint geoPoint) {
            this.updatePos = geoPoint;
            return this;
        }

        public Builder updateCoorIndex(Integer num) {
            this.updateCoorIndex = num;
            return this;
        }

        public RouteTrafficInfo build() {
            return new RouteTrafficInfo(this);
        }
    }
}
