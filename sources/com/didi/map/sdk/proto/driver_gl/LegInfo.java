package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class LegInfo extends Message {
    public static final Integer DEFAULT_EDA = 0;
    public static final Integer DEFAULT_ETA = 0;
    public static final List<DoublePoint> DEFAULT_GEOS = Collections.emptyList();
    public static final List<TrafficItem> DEFAULT_TRAFFICITEMS = Collections.emptyList();
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer eda;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(label = Message.Label.REPEATED, messageType = DoublePoint.class, tag = 3)
    public final List<DoublePoint> geos;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrafficItem.class, tag = 4)
    public final List<TrafficItem> trafficItems;

    public LegInfo(Integer num, Integer num2, List<DoublePoint> list, List<TrafficItem> list2) {
        this.eta = num;
        this.eda = num2;
        this.geos = immutableCopyOf(list);
        this.trafficItems = immutableCopyOf(list2);
    }

    private LegInfo(Builder builder) {
        this(builder.eta, builder.eda, builder.geos, builder.trafficItems);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LegInfo)) {
            return false;
        }
        LegInfo legInfo = (LegInfo) obj;
        if (!equals((Object) this.eta, (Object) legInfo.eta) || !equals((Object) this.eda, (Object) legInfo.eda) || !equals((List<?>) this.geos, (List<?>) legInfo.geos) || !equals((List<?>) this.trafficItems, (List<?>) legInfo.trafficItems)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.eta;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.eda;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<DoublePoint> list = this.geos;
        int i4 = 1;
        int hashCode2 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<TrafficItem> list2 = this.trafficItems;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode2 + i4;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<LegInfo> {
        public Integer eda;
        public Integer eta;
        public List<DoublePoint> geos;
        public List<TrafficItem> trafficItems;

        public Builder() {
        }

        public Builder(LegInfo legInfo) {
            super(legInfo);
            if (legInfo != null) {
                this.eta = legInfo.eta;
                this.eda = legInfo.eda;
                this.geos = LegInfo.copyOf(legInfo.geos);
                this.trafficItems = LegInfo.copyOf(legInfo.trafficItems);
            }
        }

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public Builder eda(Integer num) {
            this.eda = num;
            return this;
        }

        public Builder geos(List<DoublePoint> list) {
            this.geos = checkForNulls(list);
            return this;
        }

        public Builder trafficItems(List<TrafficItem> list) {
            this.trafficItems = checkForNulls(list);
            return this;
        }

        public LegInfo build() {
            checkRequiredFields();
            return new LegInfo(this);
        }
    }
}
