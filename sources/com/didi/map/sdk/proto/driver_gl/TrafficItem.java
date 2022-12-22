package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrafficItem extends Message {
    public static final Integer DEFAULT_ENDINDEX = 0;
    public static final Integer DEFAULT_STARTINDEX = 0;
    public static final Integer DEFAULT_STATUS = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer endIndex;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4)
    public final DoublePoint endPoint;
    @ProtoField(tag = 6)
    public final NaviTraffic navi_traffic;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer startIndex;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final DoublePoint startPoint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT32)
    public final Integer status;

    public TrafficItem(Integer num, DoublePoint doublePoint, Integer num2, DoublePoint doublePoint2, Integer num3, NaviTraffic naviTraffic) {
        this.startIndex = num;
        this.startPoint = doublePoint;
        this.endIndex = num2;
        this.endPoint = doublePoint2;
        this.status = num3;
        this.navi_traffic = naviTraffic;
    }

    private TrafficItem(Builder builder) {
        this(builder.startIndex, builder.startPoint, builder.endIndex, builder.endPoint, builder.status, builder.navi_traffic);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrafficItem)) {
            return false;
        }
        TrafficItem trafficItem = (TrafficItem) obj;
        if (!equals((Object) this.startIndex, (Object) trafficItem.startIndex) || !equals((Object) this.startPoint, (Object) trafficItem.startPoint) || !equals((Object) this.endIndex, (Object) trafficItem.endIndex) || !equals((Object) this.endPoint, (Object) trafficItem.endPoint) || !equals((Object) this.status, (Object) trafficItem.status) || !equals((Object) this.navi_traffic, (Object) trafficItem.navi_traffic)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.startIndex;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        DoublePoint doublePoint = this.startPoint;
        int hashCode2 = (hashCode + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Integer num2 = this.endIndex;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        DoublePoint doublePoint2 = this.endPoint;
        int hashCode4 = (hashCode3 + (doublePoint2 != null ? doublePoint2.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        NaviTraffic naviTraffic = this.navi_traffic;
        if (naviTraffic != null) {
            i2 = naviTraffic.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrafficItem> {
        public Integer endIndex;
        public DoublePoint endPoint;
        public NaviTraffic navi_traffic;
        public Integer startIndex;
        public DoublePoint startPoint;
        public Integer status;

        public Builder() {
        }

        public Builder(TrafficItem trafficItem) {
            super(trafficItem);
            if (trafficItem != null) {
                this.startIndex = trafficItem.startIndex;
                this.startPoint = trafficItem.startPoint;
                this.endIndex = trafficItem.endIndex;
                this.endPoint = trafficItem.endPoint;
                this.status = trafficItem.status;
                this.navi_traffic = trafficItem.navi_traffic;
            }
        }

        public Builder startIndex(Integer num) {
            this.startIndex = num;
            return this;
        }

        public Builder startPoint(DoublePoint doublePoint) {
            this.startPoint = doublePoint;
            return this;
        }

        public Builder endIndex(Integer num) {
            this.endIndex = num;
            return this;
        }

        public Builder endPoint(DoublePoint doublePoint) {
            this.endPoint = doublePoint;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder navi_traffic(NaviTraffic naviTraffic) {
            this.navi_traffic = naviTraffic;
            return this;
        }

        public TrafficItem build() {
            checkRequiredFields();
            return new TrafficItem(this);
        }
    }
}
