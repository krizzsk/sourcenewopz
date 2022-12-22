package com.didi.soda.customer.biz.sliding.p163pb;

import com.didi.soda.customer.biz.sliding.param.OrderStat;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.soda.customer.biz.sliding.pb.GulfstreamPassengerDriverLocReq */
public final class GulfstreamPassengerDriverLocReq extends Message {
    public static final Integer DEFAULT_ETA = 0;
    public static final Integer DEFAULT_ETA_DISTANCE = 0;
    public static final String DEFAULT_ETA_STR = "";
    public static final List<DriverLocationInfo> DEFAULT_LOC = Collections.emptyList();
    public static final Integer DEFAULT_REDIRECT = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer debug_open;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer eta_distance;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String eta_str;
    @ProtoField(label = Message.Label.REPEATED, messageType = DriverLocationInfo.class, tag = 1)
    public final List<DriverLocationInfo> loc;
    @ProtoField(tag = 5, type = Message.Datatype.ENUM)
    public final OrderStat order_stat;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer redirect;

    public GulfstreamPassengerDriverLocReq(List<DriverLocationInfo> list, Integer num, Integer num2, String str, OrderStat orderStat, Integer num3, Integer num4) {
        this.loc = immutableCopyOf(list);
        this.eta = num;
        this.eta_distance = num2;
        this.eta_str = str;
        this.order_stat = orderStat;
        this.redirect = num3;
        this.debug_open = num4;
    }

    private GulfstreamPassengerDriverLocReq(Builder builder) {
        this(builder.loc, builder.eta, builder.eta_distance, builder.eta_str, builder.order_stat, builder.redirect, builder.debug_open);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GulfstreamPassengerDriverLocReq)) {
            return false;
        }
        GulfstreamPassengerDriverLocReq gulfstreamPassengerDriverLocReq = (GulfstreamPassengerDriverLocReq) obj;
        if (!equals((List<?>) this.loc, (List<?>) gulfstreamPassengerDriverLocReq.loc) || !equals((Object) this.eta, (Object) gulfstreamPassengerDriverLocReq.eta) || !equals((Object) this.eta_distance, (Object) gulfstreamPassengerDriverLocReq.eta_distance) || !equals((Object) this.eta_str, (Object) gulfstreamPassengerDriverLocReq.eta_str) || !equals((Object) this.order_stat, (Object) gulfstreamPassengerDriverLocReq.order_stat) || !equals((Object) this.redirect, (Object) gulfstreamPassengerDriverLocReq.redirect) || !equals((Object) this.debug_open, (Object) gulfstreamPassengerDriverLocReq.debug_open)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<DriverLocationInfo> list = this.loc;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.eta;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.eta_distance;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.eta_str;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        OrderStat orderStat = this.order_stat;
        int hashCode5 = (hashCode4 + (orderStat != null ? orderStat.hashCode() : 0)) * 37;
        Integer num3 = this.redirect;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.debug_open;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.soda.customer.biz.sliding.pb.GulfstreamPassengerDriverLocReq$Builder */
    public static final class Builder extends Message.Builder<GulfstreamPassengerDriverLocReq> {
        public Integer debug_open;
        public Integer eta;
        public Integer eta_distance;
        public String eta_str;
        public List<DriverLocationInfo> loc;
        public OrderStat order_stat;
        public Integer redirect;

        public Builder() {
        }

        public Builder(GulfstreamPassengerDriverLocReq gulfstreamPassengerDriverLocReq) {
            super(gulfstreamPassengerDriverLocReq);
            if (gulfstreamPassengerDriverLocReq != null) {
                this.loc = GulfstreamPassengerDriverLocReq.copyOf(gulfstreamPassengerDriverLocReq.loc);
                this.eta = gulfstreamPassengerDriverLocReq.eta;
                this.eta_distance = gulfstreamPassengerDriverLocReq.eta_distance;
                this.eta_str = gulfstreamPassengerDriverLocReq.eta_str;
                this.order_stat = gulfstreamPassengerDriverLocReq.order_stat;
                this.redirect = gulfstreamPassengerDriverLocReq.redirect;
                this.debug_open = gulfstreamPassengerDriverLocReq.debug_open;
            }
        }

        public GulfstreamPassengerDriverLocReq build() {
            return new GulfstreamPassengerDriverLocReq(this);
        }

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }
    }
}
