package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SingleRouteReq extends Message {
    public static final Integer DEFAULT_EXPECTSTYLE = 0;
    public static final List<OdPoint> DEFAULT_ODPOINTS = Collections.emptyList();
    public static final TravelMode DEFAULT_TRAVELMODE = TravelMode.DRIVING;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final DoublePoint endPoint;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer expectStyle;
    @ProtoField(label = Message.Label.REPEATED, messageType = OdPoint.class, tag = 3)
    public final List<OdPoint> odPoints;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final DoublePoint startPoint;
    @ProtoField(tag = 4, type = Message.Datatype.ENUM)
    public final TravelMode travelMode;

    public SingleRouteReq(DoublePoint doublePoint, DoublePoint doublePoint2, List<OdPoint> list, TravelMode travelMode2, Integer num) {
        this.startPoint = doublePoint;
        this.endPoint = doublePoint2;
        this.odPoints = immutableCopyOf(list);
        this.travelMode = travelMode2;
        this.expectStyle = num;
    }

    private SingleRouteReq(Builder builder) {
        this(builder.startPoint, builder.endPoint, builder.odPoints, builder.travelMode, builder.expectStyle);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SingleRouteReq)) {
            return false;
        }
        SingleRouteReq singleRouteReq = (SingleRouteReq) obj;
        if (!equals((Object) this.startPoint, (Object) singleRouteReq.startPoint) || !equals((Object) this.endPoint, (Object) singleRouteReq.endPoint) || !equals((List<?>) this.odPoints, (List<?>) singleRouteReq.odPoints) || !equals((Object) this.travelMode, (Object) singleRouteReq.travelMode) || !equals((Object) this.expectStyle, (Object) singleRouteReq.expectStyle)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DoublePoint doublePoint = this.startPoint;
        int i2 = 0;
        int hashCode = (doublePoint != null ? doublePoint.hashCode() : 0) * 37;
        DoublePoint doublePoint2 = this.endPoint;
        int hashCode2 = (hashCode + (doublePoint2 != null ? doublePoint2.hashCode() : 0)) * 37;
        List<OdPoint> list = this.odPoints;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        TravelMode travelMode2 = this.travelMode;
        int hashCode4 = (hashCode3 + (travelMode2 != null ? travelMode2.hashCode() : 0)) * 37;
        Integer num = this.expectStyle;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SingleRouteReq> {
        public DoublePoint endPoint;
        public Integer expectStyle;
        public List<OdPoint> odPoints;
        public DoublePoint startPoint;
        public TravelMode travelMode;

        public Builder() {
        }

        public Builder(SingleRouteReq singleRouteReq) {
            super(singleRouteReq);
            if (singleRouteReq != null) {
                this.startPoint = singleRouteReq.startPoint;
                this.endPoint = singleRouteReq.endPoint;
                this.odPoints = SingleRouteReq.copyOf(singleRouteReq.odPoints);
                this.travelMode = singleRouteReq.travelMode;
                this.expectStyle = singleRouteReq.expectStyle;
            }
        }

        public Builder startPoint(DoublePoint doublePoint) {
            this.startPoint = doublePoint;
            return this;
        }

        public Builder endPoint(DoublePoint doublePoint) {
            this.endPoint = doublePoint;
            return this;
        }

        public Builder odPoints(List<OdPoint> list) {
            this.odPoints = checkForNulls(list);
            return this;
        }

        public Builder travelMode(TravelMode travelMode2) {
            this.travelMode = travelMode2;
            return this;
        }

        public Builder expectStyle(Integer num) {
            this.expectStyle = num;
            return this;
        }

        public SingleRouteReq build() {
            checkRequiredFields();
            return new SingleRouteReq(this);
        }
    }
}
