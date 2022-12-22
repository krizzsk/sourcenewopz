package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.sdk.messagecenter.pb.OrderRealtimeFeeReq */
public final class OrderRealtimeFeeReq extends Message {
    public static final List<LocationInfo> DEFAULT_DRIVING_TRACK = Collections.emptyList();
    public static final List<FeeBottom> DEFAULT_FEE_BOTTOM = Collections.emptyList();
    public static final List<FeeInfoItem> DEFAULT_FEE_INFO = Collections.emptyList();
    public static final String DEFAULT_NORMAL_DISTANCE = "";
    public static final String DEFAULT_NORMAL_TIME = "";
    public static final String DEFAULT_OID = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_TOTAL_FEE = "";
    public static final String DEFAULT_TOTAL_FEE_TEXT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = LocationInfo.class, tag = 1)
    public final List<LocationInfo> driving_track;
    @ProtoField(label = Message.Label.REPEATED, messageType = FeeBottom.class, tag = 6)
    public final List<FeeBottom> fee_bottom;
    @ProtoField(label = Message.Label.REPEATED, messageType = FeeInfoItem.class, tag = 2)
    public final List<FeeInfoItem> fee_info;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String normal_distance;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String normal_time;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String total_fee;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String total_fee_text;

    public OrderRealtimeFeeReq(List<LocationInfo> list, List<FeeInfoItem> list2, String str, Integer num, String str2, List<FeeBottom> list3, String str3, String str4, String str5) {
        this.driving_track = immutableCopyOf(list);
        this.fee_info = immutableCopyOf(list2);
        this.oid = str;
        this.timestamp = num;
        this.total_fee = str2;
        this.fee_bottom = immutableCopyOf(list3);
        this.normal_distance = str3;
        this.normal_time = str4;
        this.total_fee_text = str5;
    }

    private OrderRealtimeFeeReq(Builder builder) {
        this(builder.driving_track, builder.fee_info, builder.oid, builder.timestamp, builder.total_fee, builder.fee_bottom, builder.normal_distance, builder.normal_time, builder.total_fee_text);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderRealtimeFeeReq)) {
            return false;
        }
        OrderRealtimeFeeReq orderRealtimeFeeReq = (OrderRealtimeFeeReq) obj;
        if (!equals((List<?>) this.driving_track, (List<?>) orderRealtimeFeeReq.driving_track) || !equals((List<?>) this.fee_info, (List<?>) orderRealtimeFeeReq.fee_info) || !equals((Object) this.oid, (Object) orderRealtimeFeeReq.oid) || !equals((Object) this.timestamp, (Object) orderRealtimeFeeReq.timestamp) || !equals((Object) this.total_fee, (Object) orderRealtimeFeeReq.total_fee) || !equals((List<?>) this.fee_bottom, (List<?>) orderRealtimeFeeReq.fee_bottom) || !equals((Object) this.normal_distance, (Object) orderRealtimeFeeReq.normal_distance) || !equals((Object) this.normal_time, (Object) orderRealtimeFeeReq.normal_time) || !equals((Object) this.total_fee_text, (Object) orderRealtimeFeeReq.total_fee_text)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<LocationInfo> list = this.driving_track;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<FeeInfoItem> list2 = this.fee_info;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 1)) * 37;
        String str = this.oid;
        int i3 = 0;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.total_fee;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<FeeBottom> list3 = this.fee_bottom;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        int i4 = (hashCode5 + i2) * 37;
        String str3 = this.normal_distance;
        int hashCode6 = (i4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.normal_time;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.total_fee_text;
        if (str5 != null) {
            i3 = str5.hashCode();
        }
        int i5 = hashCode7 + i3;
        this.hashCode = i5;
        return i5;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.OrderRealtimeFeeReq$Builder */
    public static final class Builder extends Message.Builder<OrderRealtimeFeeReq> {
        public List<LocationInfo> driving_track;
        public List<FeeBottom> fee_bottom;
        public List<FeeInfoItem> fee_info;
        public String normal_distance;
        public String normal_time;
        public String oid;
        public Integer timestamp;
        public String total_fee;
        public String total_fee_text;

        public Builder() {
        }

        public Builder(OrderRealtimeFeeReq orderRealtimeFeeReq) {
            super(orderRealtimeFeeReq);
            if (orderRealtimeFeeReq != null) {
                this.driving_track = OrderRealtimeFeeReq.copyOf(orderRealtimeFeeReq.driving_track);
                this.fee_info = OrderRealtimeFeeReq.copyOf(orderRealtimeFeeReq.fee_info);
                this.oid = orderRealtimeFeeReq.oid;
                this.timestamp = orderRealtimeFeeReq.timestamp;
                this.total_fee = orderRealtimeFeeReq.total_fee;
                this.fee_bottom = OrderRealtimeFeeReq.copyOf(orderRealtimeFeeReq.fee_bottom);
                this.normal_distance = orderRealtimeFeeReq.normal_distance;
                this.normal_time = orderRealtimeFeeReq.normal_time;
                this.total_fee_text = orderRealtimeFeeReq.total_fee_text;
            }
        }

        public Builder driving_track(List<LocationInfo> list) {
            this.driving_track = checkForNulls(list);
            return this;
        }

        public Builder fee_info(List<FeeInfoItem> list) {
            this.fee_info = checkForNulls(list);
            return this;
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder total_fee(String str) {
            this.total_fee = str;
            return this;
        }

        public Builder fee_bottom(List<FeeBottom> list) {
            this.fee_bottom = checkForNulls(list);
            return this;
        }

        public Builder normal_distance(String str) {
            this.normal_distance = str;
            return this;
        }

        public Builder normal_time(String str) {
            this.normal_time = str;
            return this;
        }

        public Builder total_fee_text(String str) {
            this.total_fee_text = str;
            return this;
        }

        public OrderRealtimeFeeReq build() {
            return new OrderRealtimeFeeReq(this);
        }
    }
}
