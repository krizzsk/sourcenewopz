package com.didi.soda.customer.biz.sliding.p163pb;

import com.didi.soda.customer.biz.sliding.param.OrderStat;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.List;

/* renamed from: com.didi.soda.customer.biz.sliding.pb.PassengerDiverLocGetByIdReq */
public final class PassengerDiverLocGetByIdReq extends Message {
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer channel;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT64)
    public final List<Long> diverIds;
    @ProtoField(tag = 8, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 9, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 7, type = Message.Datatype.ENUM)
    public final OrderStat order_stat;
    @ProtoField(label = Message.Label.REPEATED, messageType = LocPoint.class, tag = 12)
    public final List<LocPoint> passLocPoints;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String phone_num;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 10, type = Message.Datatype.DOUBLE)
    public final Double tlat;
    @ProtoField(tag = 11, type = Message.Datatype.DOUBLE)
    public final Double tlng;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer type;

    public PassengerDiverLocGetByIdReq(String str, Integer num, Integer num2, List<Long> list, Integer num3, Long l, OrderStat orderStat, Double d, Double d2, Double d3, Double d4, List<LocPoint> list2) {
        this.phone_num = str;
        this.role = num;
        this.channel = num2;
        this.diverIds = immutableCopyOf(list);
        this.type = num3;
        this.timestamp = l;
        this.order_stat = orderStat;
        this.lat = d;
        this.lng = d2;
        this.tlat = d3;
        this.tlng = d4;
        this.passLocPoints = immutableCopyOf(list2);
    }

    private PassengerDiverLocGetByIdReq(Builder builder) {
        this(builder.phone_num, builder.role, builder.channel, builder.diverIds, builder.type, builder.timestamp, builder.order_stat, builder.lat, builder.lng, builder.tlat, builder.tlng, builder.passLocPoints);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerDiverLocGetByIdReq)) {
            return false;
        }
        PassengerDiverLocGetByIdReq passengerDiverLocGetByIdReq = (PassengerDiverLocGetByIdReq) obj;
        if (!equals((Object) this.phone_num, (Object) passengerDiverLocGetByIdReq.phone_num) || !equals((Object) this.role, (Object) passengerDiverLocGetByIdReq.role) || !equals((Object) this.channel, (Object) passengerDiverLocGetByIdReq.channel) || !equals((List<?>) this.diverIds, (List<?>) passengerDiverLocGetByIdReq.diverIds) || !equals((Object) this.type, (Object) passengerDiverLocGetByIdReq.type) || !equals((Object) this.timestamp, (Object) passengerDiverLocGetByIdReq.timestamp) || !equals((Object) this.order_stat, (Object) passengerDiverLocGetByIdReq.order_stat) || !equals((Object) this.lat, (Object) passengerDiverLocGetByIdReq.lat) || !equals((Object) this.lng, (Object) passengerDiverLocGetByIdReq.lng) || !equals((Object) this.tlat, (Object) passengerDiverLocGetByIdReq.tlat) || !equals((Object) this.tlng, (Object) passengerDiverLocGetByIdReq.tlng) || !equals((List<?>) this.passLocPoints, (List<?>) passengerDiverLocGetByIdReq.passLocPoints)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.phone_num;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.role;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.channel;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<Long> list = this.diverIds;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num3 = this.type;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        OrderStat orderStat = this.order_stat;
        int hashCode7 = (hashCode6 + (orderStat != null ? orderStat.hashCode() : 0)) * 37;
        Double d = this.lat;
        int hashCode8 = (hashCode7 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.lng;
        int hashCode9 = (hashCode8 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.tlat;
        int hashCode10 = (hashCode9 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.tlng;
        if (d4 != null) {
            i2 = d4.hashCode();
        }
        int i4 = (hashCode10 + i2) * 37;
        List<LocPoint> list2 = this.passLocPoints;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    /* renamed from: com.didi.soda.customer.biz.sliding.pb.PassengerDiverLocGetByIdReq$Builder */
    public static final class Builder extends Message.Builder<PassengerDiverLocGetByIdReq> {
        public Integer channel;
        public List<Long> diverIds;
        public Double lat;
        public Double lng;
        public OrderStat order_stat;
        public List<LocPoint> passLocPoints;
        public String phone_num;
        public Integer role;
        public Long timestamp;
        public Double tlat;
        public Double tlng;
        public Integer type;

        public Builder() {
        }

        public Builder(PassengerDiverLocGetByIdReq passengerDiverLocGetByIdReq) {
            super(passengerDiverLocGetByIdReq);
            if (passengerDiverLocGetByIdReq != null) {
                this.phone_num = passengerDiverLocGetByIdReq.phone_num;
                this.role = passengerDiverLocGetByIdReq.role;
                this.channel = passengerDiverLocGetByIdReq.channel;
                this.diverIds = PassengerDiverLocGetByIdReq.copyOf(passengerDiverLocGetByIdReq.diverIds);
                this.type = passengerDiverLocGetByIdReq.type;
                this.timestamp = passengerDiverLocGetByIdReq.timestamp;
                this.order_stat = passengerDiverLocGetByIdReq.order_stat;
                this.lat = passengerDiverLocGetByIdReq.lat;
                this.lng = passengerDiverLocGetByIdReq.lng;
                this.tlat = passengerDiverLocGetByIdReq.tlat;
                this.tlng = passengerDiverLocGetByIdReq.tlng;
                this.passLocPoints = PassengerDiverLocGetByIdReq.copyOf(passengerDiverLocGetByIdReq.passLocPoints);
            }
        }

        public PassengerDiverLocGetByIdReq build() {
            checkRequiredFields();
            return new PassengerDiverLocGetByIdReq(this);
        }

        public Builder channel(Integer num) {
            this.channel = num;
            return this;
        }

        public Builder diverIds(List<Long> list) {
            this.diverIds = checkForNulls(list);
            return this;
        }

        public Builder lat(Double d) {
            this.lat = d;
            return this;
        }

        public Builder lng(Double d) {
            this.lng = d;
            return this;
        }

        public Builder order_stat(OrderStat orderStat) {
            this.order_stat = orderStat;
            return this;
        }

        public Builder passLocPoints(List<LocPoint> list) {
            this.passLocPoints = checkForNulls(list);
            return this;
        }

        public Builder phone_num(String str) {
            this.phone_num = str;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder tlat(Double d) {
            this.tlat = d;
            return this;
        }

        public Builder tlng(Double d) {
            this.tlng = d;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }
    }
}
