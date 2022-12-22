package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class EstimatedPriceRoute extends Message {
    public static final String DEFAULT_APPOINTEDDETAIL = "";
    public static final DrawingType DEFAULT_DTYPE = DrawingType.Normal;
    public static final Integer DEFAULT_EDAMETER = 0;
    public static final Integer DEFAULT_ETASEC = 0;
    public static final List<DoublePoint> DEFAULT_GEO = Collections.emptyList();
    public static final Boolean DEFAULT_ISEXPLAINABLE = false;
    public static final Boolean DEFAULT_ISSELECTABLE = false;
    public static final List<LabelItem> DEFAULT_LABEL = Collections.emptyList();
    public static final String DEFAULT_RBTRACEID = "";
    public static final Long DEFAULT_ROUTEID = 0L;
    public static final String DEFAULT_ROUTELABEL = "";
    public static final List<TrafficItem> DEFAULT_TRAFFIC = Collections.emptyList();
    public static final List<UniqueRoute> DEFAULT_UNIQUEROUTES = Collections.emptyList();
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer EDAMeter;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer ETASec;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String appointedDetail;
    @ProtoField(tag = 12, type = Message.Datatype.ENUM)
    public final DrawingType dtype;
    @ProtoField(label = Message.Label.REPEATED, messageType = DoublePoint.class, tag = 1)
    public final List<DoublePoint> geo;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean isExplainable;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean isSelectable;
    @ProtoField(label = Message.Label.REPEATED, messageType = LabelItem.class, tag = 3)
    public final List<LabelItem> label;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String rbTraceId;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long routeID;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String routeLabel;
    @ProtoField(label = Message.Label.REPEATED, messageType = TrafficItem.class, tag = 2)
    public final List<TrafficItem> traffic;
    @ProtoField(label = Message.Label.REPEATED, messageType = UniqueRoute.class, tag = 10)
    public final List<UniqueRoute> uniqueRoutes;

    public EstimatedPriceRoute(List<DoublePoint> list, List<TrafficItem> list2, List<LabelItem> list3, String str, Long l, Boolean bool, String str2, Integer num, Integer num2, List<UniqueRoute> list4, Boolean bool2, DrawingType drawingType, String str3) {
        this.geo = immutableCopyOf(list);
        this.traffic = immutableCopyOf(list2);
        this.label = immutableCopyOf(list3);
        this.rbTraceId = str;
        this.routeID = l;
        this.isSelectable = bool;
        this.routeLabel = str2;
        this.ETASec = num;
        this.EDAMeter = num2;
        this.uniqueRoutes = immutableCopyOf(list4);
        this.isExplainable = bool2;
        this.dtype = drawingType;
        this.appointedDetail = str3;
    }

    private EstimatedPriceRoute(Builder builder) {
        this(builder.geo, builder.traffic, builder.label, builder.rbTraceId, builder.routeID, builder.isSelectable, builder.routeLabel, builder.ETASec, builder.EDAMeter, builder.uniqueRoutes, builder.isExplainable, builder.dtype, builder.appointedDetail);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EstimatedPriceRoute)) {
            return false;
        }
        EstimatedPriceRoute estimatedPriceRoute = (EstimatedPriceRoute) obj;
        if (!equals((List<?>) this.geo, (List<?>) estimatedPriceRoute.geo) || !equals((List<?>) this.traffic, (List<?>) estimatedPriceRoute.traffic) || !equals((List<?>) this.label, (List<?>) estimatedPriceRoute.label) || !equals((Object) this.rbTraceId, (Object) estimatedPriceRoute.rbTraceId) || !equals((Object) this.routeID, (Object) estimatedPriceRoute.routeID) || !equals((Object) this.isSelectable, (Object) estimatedPriceRoute.isSelectable) || !equals((Object) this.routeLabel, (Object) estimatedPriceRoute.routeLabel) || !equals((Object) this.ETASec, (Object) estimatedPriceRoute.ETASec) || !equals((Object) this.EDAMeter, (Object) estimatedPriceRoute.EDAMeter) || !equals((List<?>) this.uniqueRoutes, (List<?>) estimatedPriceRoute.uniqueRoutes) || !equals((Object) this.isExplainable, (Object) estimatedPriceRoute.isExplainable) || !equals((Object) this.dtype, (Object) estimatedPriceRoute.dtype) || !equals((Object) this.appointedDetail, (Object) estimatedPriceRoute.appointedDetail)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<DoublePoint> list = this.geo;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<TrafficItem> list2 = this.traffic;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<LabelItem> list3 = this.label;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 1)) * 37;
        String str = this.rbTraceId;
        int i3 = 0;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.routeID;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.isSelectable;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.routeLabel;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.ETASec;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.EDAMeter;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<UniqueRoute> list4 = this.uniqueRoutes;
        if (list4 != null) {
            i2 = list4.hashCode();
        }
        int i4 = (hashCode9 + i2) * 37;
        Boolean bool2 = this.isExplainable;
        int hashCode10 = (i4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        DrawingType drawingType = this.dtype;
        int hashCode11 = (hashCode10 + (drawingType != null ? drawingType.hashCode() : 0)) * 37;
        String str3 = this.appointedDetail;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        int i5 = hashCode11 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<EstimatedPriceRoute> {
        public Integer EDAMeter;
        public Integer ETASec;
        public String appointedDetail;
        public DrawingType dtype;
        public List<DoublePoint> geo;
        public Boolean isExplainable;
        public Boolean isSelectable;
        public List<LabelItem> label;
        public String rbTraceId;
        public Long routeID;
        public String routeLabel;
        public List<TrafficItem> traffic;
        public List<UniqueRoute> uniqueRoutes;

        public Builder() {
        }

        public Builder(EstimatedPriceRoute estimatedPriceRoute) {
            super(estimatedPriceRoute);
            if (estimatedPriceRoute != null) {
                this.geo = EstimatedPriceRoute.copyOf(estimatedPriceRoute.geo);
                this.traffic = EstimatedPriceRoute.copyOf(estimatedPriceRoute.traffic);
                this.label = EstimatedPriceRoute.copyOf(estimatedPriceRoute.label);
                this.rbTraceId = estimatedPriceRoute.rbTraceId;
                this.routeID = estimatedPriceRoute.routeID;
                this.isSelectable = estimatedPriceRoute.isSelectable;
                this.routeLabel = estimatedPriceRoute.routeLabel;
                this.ETASec = estimatedPriceRoute.ETASec;
                this.EDAMeter = estimatedPriceRoute.EDAMeter;
                this.uniqueRoutes = EstimatedPriceRoute.copyOf(estimatedPriceRoute.uniqueRoutes);
                this.isExplainable = estimatedPriceRoute.isExplainable;
                this.dtype = estimatedPriceRoute.dtype;
                this.appointedDetail = estimatedPriceRoute.appointedDetail;
            }
        }

        public Builder geo(List<DoublePoint> list) {
            this.geo = checkForNulls(list);
            return this;
        }

        public Builder traffic(List<TrafficItem> list) {
            this.traffic = checkForNulls(list);
            return this;
        }

        public Builder label(List<LabelItem> list) {
            this.label = checkForNulls(list);
            return this;
        }

        public Builder rbTraceId(String str) {
            this.rbTraceId = str;
            return this;
        }

        public Builder routeID(Long l) {
            this.routeID = l;
            return this;
        }

        public Builder isSelectable(Boolean bool) {
            this.isSelectable = bool;
            return this;
        }

        public Builder routeLabel(String str) {
            this.routeLabel = str;
            return this;
        }

        public Builder ETASec(Integer num) {
            this.ETASec = num;
            return this;
        }

        public Builder EDAMeter(Integer num) {
            this.EDAMeter = num;
            return this;
        }

        public Builder uniqueRoutes(List<UniqueRoute> list) {
            this.uniqueRoutes = checkForNulls(list);
            return this;
        }

        public Builder isExplainable(Boolean bool) {
            this.isExplainable = bool;
            return this;
        }

        public Builder dtype(DrawingType drawingType) {
            this.dtype = drawingType;
            return this;
        }

        public Builder appointedDetail(String str) {
            this.appointedDetail = str;
            return this;
        }

        public EstimatedPriceRoute build() {
            return new EstimatedPriceRoute(this);
        }
    }
}
