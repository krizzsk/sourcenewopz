package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiPassengerOrderEventReq extends Message {
    public static final OrderEvent DEFAULT_ORDEREVENT = OrderEvent.kPGetOn;
    public static final String DEFAULT_ORDERID = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.ENUM)
    public final OrderEvent orderEvent;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String orderId;

    public TaxiPassengerOrderEventReq(String str, OrderEvent orderEvent2) {
        this.orderId = str;
        this.orderEvent = orderEvent2;
    }

    private TaxiPassengerOrderEventReq(Builder builder) {
        this(builder.orderId, builder.orderEvent);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiPassengerOrderEventReq)) {
            return false;
        }
        TaxiPassengerOrderEventReq taxiPassengerOrderEventReq = (TaxiPassengerOrderEventReq) obj;
        if (!equals((Object) this.orderId, (Object) taxiPassengerOrderEventReq.orderId) || !equals((Object) this.orderEvent, (Object) taxiPassengerOrderEventReq.orderEvent)) {
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
        OrderEvent orderEvent2 = this.orderEvent;
        if (orderEvent2 != null) {
            i2 = orderEvent2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiPassengerOrderEventReq> {
        public OrderEvent orderEvent;
        public String orderId;

        public Builder() {
        }

        public Builder(TaxiPassengerOrderEventReq taxiPassengerOrderEventReq) {
            super(taxiPassengerOrderEventReq);
            if (taxiPassengerOrderEventReq != null) {
                this.orderId = taxiPassengerOrderEventReq.orderId;
                this.orderEvent = taxiPassengerOrderEventReq.orderEvent;
            }
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder orderEvent(OrderEvent orderEvent2) {
            this.orderEvent = orderEvent2;
            return this;
        }

        public TaxiPassengerOrderEventReq build() {
            checkRequiredFields();
            return new TaxiPassengerOrderEventReq(this);
        }
    }
}
