package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RouteFeature extends Message {
    public static final Long DEFAULT_MOTORWAYCHARGE = 0L;
    public static final String DEFAULT_TOKEN = "";
    public static final List<TollGateInfo> DEFAULT_TOLLGATES = Collections.emptyList();
    public static final Long DEFAULT_TRAFFICLIGHTNUM = 0L;
    public static final List<TrafficLighInfo> DEFAULT_TRAFFICLIGHTS = Collections.emptyList();
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long motorwayCharge;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REPEATED, messageType = TollGateInfo.class, tag = 2)
    public final List<TollGateInfo> tollGates;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long trafficLightNum;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrafficLighInfo.class, tag = 4)
    public final List<TrafficLighInfo> trafficLights;

    public RouteFeature(Long l, List<TollGateInfo> list, Long l2, List<TrafficLighInfo> list2, String str) {
        this.motorwayCharge = l;
        this.tollGates = immutableCopyOf(list);
        this.trafficLightNum = l2;
        this.trafficLights = immutableCopyOf(list2);
        this.token = str;
    }

    private RouteFeature(Builder builder) {
        this(builder.motorwayCharge, builder.tollGates, builder.trafficLightNum, builder.trafficLights, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteFeature)) {
            return false;
        }
        RouteFeature routeFeature = (RouteFeature) obj;
        if (!equals((Object) this.motorwayCharge, (Object) routeFeature.motorwayCharge) || !equals((List<?>) this.tollGates, (List<?>) routeFeature.tollGates) || !equals((Object) this.trafficLightNum, (Object) routeFeature.trafficLightNum) || !equals((List<?>) this.trafficLights, (List<?>) routeFeature.trafficLights) || !equals((Object) this.token, (Object) routeFeature.token)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.motorwayCharge;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<TollGateInfo> list = this.tollGates;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Long l2 = this.trafficLightNum;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        List<TrafficLighInfo> list2 = this.trafficLights;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode3 + i3) * 37;
        String str = this.token;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<RouteFeature> {
        public Long motorwayCharge;
        public String token;
        public List<TollGateInfo> tollGates;
        public Long trafficLightNum;
        public List<TrafficLighInfo> trafficLights;

        public Builder() {
        }

        public Builder(RouteFeature routeFeature) {
            super(routeFeature);
            if (routeFeature != null) {
                this.motorwayCharge = routeFeature.motorwayCharge;
                this.tollGates = RouteFeature.copyOf(routeFeature.tollGates);
                this.trafficLightNum = routeFeature.trafficLightNum;
                this.trafficLights = RouteFeature.copyOf(routeFeature.trafficLights);
                this.token = routeFeature.token;
            }
        }

        public Builder motorwayCharge(Long l) {
            this.motorwayCharge = l;
            return this;
        }

        public Builder tollGates(List<TollGateInfo> list) {
            this.tollGates = checkForNulls(list);
            return this;
        }

        public Builder trafficLightNum(Long l) {
            this.trafficLightNum = l;
            return this;
        }

        public Builder trafficLights(List<TrafficLighInfo> list) {
            this.trafficLights = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public RouteFeature build() {
            return new RouteFeature(this);
        }
    }
}
