package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderInfo extends Message {
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final Long DEFAULT_DRIVERID = 0L;
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_ORDERSTAGE = 3;
    public static final Long DEFAULT_PASSENGERID = 0L;
    public static final String DEFAULT_TRAVELID = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer bizType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT64)
    public final Long driverId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5)
    public final DoublePoint orderEndPoint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer orderStage;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)
    public final Long passengerId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4)
    public final DoublePoint pickupEndPoint;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String travelId;

    public OrderInfo(String str, Long l, Long l2, DoublePoint doublePoint, DoublePoint doublePoint2, Integer num, Integer num2, String str2) {
        this.orderId = str;
        this.passengerId = l;
        this.driverId = l2;
        this.pickupEndPoint = doublePoint;
        this.orderEndPoint = doublePoint2;
        this.bizType = num;
        this.orderStage = num2;
        this.travelId = str2;
    }

    private OrderInfo(Builder builder) {
        this(builder.orderId, builder.passengerId, builder.driverId, builder.pickupEndPoint, builder.orderEndPoint, builder.bizType, builder.orderStage, builder.travelId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderInfo)) {
            return false;
        }
        OrderInfo orderInfo = (OrderInfo) obj;
        if (!equals((Object) this.orderId, (Object) orderInfo.orderId) || !equals((Object) this.passengerId, (Object) orderInfo.passengerId) || !equals((Object) this.driverId, (Object) orderInfo.driverId) || !equals((Object) this.pickupEndPoint, (Object) orderInfo.pickupEndPoint) || !equals((Object) this.orderEndPoint, (Object) orderInfo.orderEndPoint) || !equals((Object) this.bizType, (Object) orderInfo.bizType) || !equals((Object) this.orderStage, (Object) orderInfo.orderStage) || !equals((Object) this.travelId, (Object) orderInfo.travelId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.orderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.passengerId;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.driverId;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.pickupEndPoint;
        int hashCode4 = (hashCode3 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        DoublePoint doublePoint2 = this.orderEndPoint;
        int hashCode5 = (hashCode4 + (doublePoint2 != null ? doublePoint2.hashCode() : 0)) * 37;
        Integer num = this.bizType;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.orderStage;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.travelId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderInfo> {
        public Integer bizType;
        public Long driverId;
        public DoublePoint orderEndPoint;
        public String orderId;
        public Integer orderStage;
        public Long passengerId;
        public DoublePoint pickupEndPoint;
        public String travelId;

        public Builder() {
        }

        public Builder(OrderInfo orderInfo) {
            super(orderInfo);
            if (orderInfo != null) {
                this.orderId = orderInfo.orderId;
                this.passengerId = orderInfo.passengerId;
                this.driverId = orderInfo.driverId;
                this.pickupEndPoint = orderInfo.pickupEndPoint;
                this.orderEndPoint = orderInfo.orderEndPoint;
                this.bizType = orderInfo.bizType;
                this.orderStage = orderInfo.orderStage;
                this.travelId = orderInfo.travelId;
            }
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder passengerId(Long l) {
            this.passengerId = l;
            return this;
        }

        public Builder driverId(Long l) {
            this.driverId = l;
            return this;
        }

        public Builder pickupEndPoint(DoublePoint doublePoint) {
            this.pickupEndPoint = doublePoint;
            return this;
        }

        public Builder orderEndPoint(DoublePoint doublePoint) {
            this.orderEndPoint = doublePoint;
            return this;
        }

        public Builder bizType(Integer num) {
            this.bizType = num;
            return this;
        }

        public Builder orderStage(Integer num) {
            this.orderStage = num;
            return this;
        }

        public Builder travelId(String str) {
            this.travelId = str;
            return this;
        }

        public OrderInfo build() {
            checkRequiredFields();
            return new OrderInfo(this);
        }
    }
}
