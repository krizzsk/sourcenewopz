package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RouteGuidanceInfos extends Message {
    public static final String DEFAULT_DATA_VERSION = "";
    public static final List<RoutePOI> DEFAULT_PASSINGPOINT = Collections.emptyList();
    public static final List<RouteGuidanceInfo> DEFAULT_RGINFO = Collections.emptyList();
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String data_version;
    @ProtoField(tag = 4)
    public final RoutePOI destPoint;
    @ProtoField(label = Message.Label.REPEATED, messageType = RoutePOI.class, tag = 3)
    public final List<RoutePOI> passingPoint;
    @ProtoField(label = Message.Label.REPEATED, messageType = RouteGuidanceInfo.class, tag = 5)
    public final List<RouteGuidanceInfo> rginfo;
    @ProtoField(tag = 2)
    public final RoutePOI startPoint;

    public RouteGuidanceInfos(String str, RoutePOI routePOI, List<RoutePOI> list, RoutePOI routePOI2, List<RouteGuidanceInfo> list2) {
        this.data_version = str;
        this.startPoint = routePOI;
        this.passingPoint = immutableCopyOf(list);
        this.destPoint = routePOI2;
        this.rginfo = immutableCopyOf(list2);
    }

    private RouteGuidanceInfos(Builder builder) {
        this(builder.data_version, builder.startPoint, builder.passingPoint, builder.destPoint, builder.rginfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteGuidanceInfos)) {
            return false;
        }
        RouteGuidanceInfos routeGuidanceInfos = (RouteGuidanceInfos) obj;
        if (!equals((Object) this.data_version, (Object) routeGuidanceInfos.data_version) || !equals((Object) this.startPoint, (Object) routeGuidanceInfos.startPoint) || !equals((List<?>) this.passingPoint, (List<?>) routeGuidanceInfos.passingPoint) || !equals((Object) this.destPoint, (Object) routeGuidanceInfos.destPoint) || !equals((List<?>) this.rginfo, (List<?>) routeGuidanceInfos.rginfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.data_version;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        RoutePOI routePOI = this.startPoint;
        int hashCode2 = (hashCode + (routePOI != null ? routePOI.hashCode() : 0)) * 37;
        List<RoutePOI> list = this.passingPoint;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        RoutePOI routePOI2 = this.destPoint;
        if (routePOI2 != null) {
            i2 = routePOI2.hashCode();
        }
        int i4 = (hashCode3 + i2) * 37;
        List<RouteGuidanceInfo> list2 = this.rginfo;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<RouteGuidanceInfos> {
        public String data_version;
        public RoutePOI destPoint;
        public List<RoutePOI> passingPoint;
        public List<RouteGuidanceInfo> rginfo;
        public RoutePOI startPoint;

        public Builder() {
        }

        public Builder(RouteGuidanceInfos routeGuidanceInfos) {
            super(routeGuidanceInfos);
            if (routeGuidanceInfos != null) {
                this.data_version = routeGuidanceInfos.data_version;
                this.startPoint = routeGuidanceInfos.startPoint;
                this.passingPoint = RouteGuidanceInfos.copyOf(routeGuidanceInfos.passingPoint);
                this.destPoint = routeGuidanceInfos.destPoint;
                this.rginfo = RouteGuidanceInfos.copyOf(routeGuidanceInfos.rginfo);
            }
        }

        public Builder data_version(String str) {
            this.data_version = str;
            return this;
        }

        public Builder startPoint(RoutePOI routePOI) {
            this.startPoint = routePOI;
            return this;
        }

        public Builder passingPoint(List<RoutePOI> list) {
            this.passingPoint = checkForNulls(list);
            return this;
        }

        public Builder destPoint(RoutePOI routePOI) {
            this.destPoint = routePOI;
            return this;
        }

        public Builder rginfo(List<RouteGuidanceInfo> list) {
            this.rginfo = checkForNulls(list);
            return this;
        }

        public RouteGuidanceInfos build() {
            checkRequiredFields();
            return new RouteGuidanceInfos(this);
        }
    }
}
