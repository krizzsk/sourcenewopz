package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SingleRouteRes extends Message {
    public static final Integer DEFAULT_DISTANCE = -1;
    public static final Integer DEFAULT_ETA = -1;
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final Integer DEFAULT_STYLE = 0;
    public static final TravelMode DEFAULT_TRAVELMODE = TravelMode.DRIVING;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer distance;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 1)
    public final List<OdPoint> odPoints;
    @ProtoField(tag = 2)
    public final DiffGeoPoints routeGeos;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer style;
    @ProtoField(tag = 5, type = Message.Datatype.ENUM)
    public final TravelMode travelMode;

    public SingleRouteRes(List<OdPoint> list, DiffGeoPoints diffGeoPoints, Integer num, Integer num2, TravelMode travelMode2, Integer num3) {
        this.odPoints = immutableCopyOf(list);
        this.routeGeos = diffGeoPoints;
        this.eta = num;
        this.distance = num2;
        this.travelMode = travelMode2;
        this.style = num3;
    }

    private SingleRouteRes(Builder builder) {
        this(builder.odPoints, builder.routeGeos, builder.eta, builder.distance, builder.travelMode, builder.style);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SingleRouteRes)) {
            return false;
        }
        SingleRouteRes singleRouteRes = (SingleRouteRes) obj;
        if (!equals((List<?>) this.odPoints, (List<?>) singleRouteRes.odPoints) || !equals((Object) this.routeGeos, (Object) singleRouteRes.routeGeos) || !equals((Object) this.eta, (Object) singleRouteRes.eta) || !equals((Object) this.distance, (Object) singleRouteRes.distance) || !equals((Object) this.travelMode, (Object) singleRouteRes.travelMode) || !equals((Object) this.style, (Object) singleRouteRes.style)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<OdPoint> list = this.odPoints;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        DiffGeoPoints diffGeoPoints = this.routeGeos;
        int i2 = 0;
        int hashCode2 = (hashCode + (diffGeoPoints != null ? diffGeoPoints.hashCode() : 0)) * 37;
        Integer num = this.eta;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.distance;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        TravelMode travelMode2 = this.travelMode;
        int hashCode5 = (hashCode4 + (travelMode2 != null ? travelMode2.hashCode() : 0)) * 37;
        Integer num3 = this.style;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SingleRouteRes> {
        public Integer distance;
        public Integer eta;
        public List<OdPoint> odPoints;
        public DiffGeoPoints routeGeos;
        public Integer style;
        public TravelMode travelMode;

        public Builder() {
        }

        public Builder(SingleRouteRes singleRouteRes) {
            super(singleRouteRes);
            if (singleRouteRes != null) {
                this.odPoints = SingleRouteRes.copyOf(singleRouteRes.odPoints);
                this.routeGeos = singleRouteRes.routeGeos;
                this.eta = singleRouteRes.eta;
                this.distance = singleRouteRes.distance;
                this.travelMode = singleRouteRes.travelMode;
                this.style = singleRouteRes.style;
            }
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
            return this;
        }

        public Builder routeGeos(DiffGeoPoints diffGeoPoints) {
            this.routeGeos = diffGeoPoints;
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

        public Builder travelMode(TravelMode travelMode2) {
            this.travelMode = travelMode2;
            return this;
        }

        public Builder style(Integer num) {
            this.style = num;
            return this;
        }

        public SingleRouteRes build() {
            return new SingleRouteRes(this);
        }
    }
}
