package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiOrder extends Message {
    public static final Integer DEFAULT_ASSIGNTYPE = 0;
    public static final Integer DEFAULT_DIST = 0;
    public static final String DEFAULT_EXTRAINFO = "";
    public static final String DEFAULT_FROM = "";
    public static final Double DEFAULT_FROMLATITUDE;
    public static final Double DEFAULT_FROMLONGITUDE;
    public static final Integer DEFAULT_HISTORY_NUM = 0;
    public static final Integer DEFAULT_IS_DESTINATION_HIDE = 0;
    public static final Integer DEFAULT_IS_FASTCAR = 0;
    public static final Integer DEFAULT_MEDIATYPE = 0;
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_ORDER_SOURCE = 0;
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_PUSH_TOKEN = "";
    public static final Long DEFAULT_SETOFFTIME = 0L;
    public static final Integer DEFAULT_TIMELINESSTYPE = 0;
    public static final Integer DEFAULT_TIP = 0;
    public static final String DEFAULT_TO = "";
    public static final Double DEFAULT_TOLATITUDE;
    public static final Double DEFAULT_TOLONGITUDE;
    public static final Integer DEFAULT_TRIPDISTANCE = 0;
    public static final String DEFAULT_VOICEURL = "";
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer assignType;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer dist;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String extraInfo;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String from;
    @ProtoField(tag = 8, type = Message.Datatype.DOUBLE)
    public final Double fromLatitude;
    @ProtoField(tag = 9, type = Message.Datatype.DOUBLE)
    public final Double fromLongitude;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer history_num;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer is_destination_hide;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer is_fastcar;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer mediaType;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer order_source;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String push_token;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long setOffTime;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer timeLinessType;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer tip;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)

    /* renamed from: to */
    public final String f36960to;
    @ProtoField(tag = 10, type = Message.Datatype.DOUBLE)
    public final Double toLatitude;
    @ProtoField(tag = 11, type = Message.Datatype.DOUBLE)
    public final Double toLongitude;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer tripDistance;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String voiceUrl;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_FROMLATITUDE = valueOf;
        DEFAULT_FROMLONGITUDE = valueOf;
        DEFAULT_TOLATITUDE = valueOf;
        DEFAULT_TOLONGITUDE = valueOf;
    }

    public TaxiOrder(String str, String str2, Integer num, Integer num2, Long l, String str3, String str4, Double d, Double d2, Double d3, Double d4, String str5, Integer num3, Integer num4, String str6, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, String str7, Integer num10) {
        this.orderId = str;
        this.phone = str2;
        this.mediaType = num;
        this.timeLinessType = num2;
        this.setOffTime = l;
        this.from = str3;
        this.f36960to = str4;
        this.fromLatitude = d;
        this.fromLongitude = d2;
        this.toLatitude = d3;
        this.toLongitude = d4;
        this.extraInfo = str5;
        this.tip = num3;
        this.dist = num4;
        this.voiceUrl = str6;
        this.assignType = num5;
        this.order_source = num6;
        this.is_fastcar = num7;
        this.is_destination_hide = num8;
        this.history_num = num9;
        this.push_token = str7;
        this.tripDistance = num10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TaxiOrder(com.didi.sdk.protobuf.TaxiOrder.Builder r26) {
        /*
            r25 = this;
            r0 = r26
            r1 = r25
            java.lang.String r2 = r0.orderId
            java.lang.String r3 = r0.phone
            java.lang.Integer r4 = r0.mediaType
            java.lang.Integer r5 = r0.timeLinessType
            java.lang.Long r6 = r0.setOffTime
            java.lang.String r7 = r0.from
            java.lang.String r8 = r0.f36961to
            java.lang.Double r9 = r0.fromLatitude
            java.lang.Double r10 = r0.fromLongitude
            java.lang.Double r11 = r0.toLatitude
            java.lang.Double r12 = r0.toLongitude
            java.lang.String r13 = r0.extraInfo
            java.lang.Integer r14 = r0.tip
            java.lang.Integer r15 = r0.dist
            r24 = r1
            java.lang.String r1 = r0.voiceUrl
            r16 = r1
            java.lang.Integer r1 = r0.assignType
            r17 = r1
            java.lang.Integer r1 = r0.order_source
            r18 = r1
            java.lang.Integer r1 = r0.is_fastcar
            r19 = r1
            java.lang.Integer r1 = r0.is_destination_hide
            r20 = r1
            java.lang.Integer r1 = r0.history_num
            r21 = r1
            java.lang.String r1 = r0.push_token
            r22 = r1
            java.lang.Integer r1 = r0.tripDistance
            r23 = r1
            r1 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r25.setBuilder(r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.protobuf.TaxiOrder.<init>(com.didi.sdk.protobuf.TaxiOrder$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiOrder)) {
            return false;
        }
        TaxiOrder taxiOrder = (TaxiOrder) obj;
        if (!equals((Object) this.orderId, (Object) taxiOrder.orderId) || !equals((Object) this.phone, (Object) taxiOrder.phone) || !equals((Object) this.mediaType, (Object) taxiOrder.mediaType) || !equals((Object) this.timeLinessType, (Object) taxiOrder.timeLinessType) || !equals((Object) this.setOffTime, (Object) taxiOrder.setOffTime) || !equals((Object) this.from, (Object) taxiOrder.from) || !equals((Object) this.f36960to, (Object) taxiOrder.f36960to) || !equals((Object) this.fromLatitude, (Object) taxiOrder.fromLatitude) || !equals((Object) this.fromLongitude, (Object) taxiOrder.fromLongitude) || !equals((Object) this.toLatitude, (Object) taxiOrder.toLatitude) || !equals((Object) this.toLongitude, (Object) taxiOrder.toLongitude) || !equals((Object) this.extraInfo, (Object) taxiOrder.extraInfo) || !equals((Object) this.tip, (Object) taxiOrder.tip) || !equals((Object) this.dist, (Object) taxiOrder.dist) || !equals((Object) this.voiceUrl, (Object) taxiOrder.voiceUrl) || !equals((Object) this.assignType, (Object) taxiOrder.assignType) || !equals((Object) this.order_source, (Object) taxiOrder.order_source) || !equals((Object) this.is_fastcar, (Object) taxiOrder.is_fastcar) || !equals((Object) this.is_destination_hide, (Object) taxiOrder.is_destination_hide) || !equals((Object) this.history_num, (Object) taxiOrder.history_num) || !equals((Object) this.push_token, (Object) taxiOrder.push_token) || !equals((Object) this.tripDistance, (Object) taxiOrder.tripDistance)) {
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
        String str2 = this.phone;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.mediaType;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.timeLinessType;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.setOffTime;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        String str3 = this.from;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.f36960to;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Double d = this.fromLatitude;
        int hashCode8 = (hashCode7 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.fromLongitude;
        int hashCode9 = (hashCode8 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.toLatitude;
        int hashCode10 = (hashCode9 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.toLongitude;
        int hashCode11 = (hashCode10 + (d4 != null ? d4.hashCode() : 0)) * 37;
        String str5 = this.extraInfo;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num3 = this.tip;
        int hashCode13 = (hashCode12 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.dist;
        int hashCode14 = (hashCode13 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str6 = this.voiceUrl;
        int hashCode15 = (hashCode14 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num5 = this.assignType;
        int hashCode16 = (hashCode15 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.order_source;
        int hashCode17 = (hashCode16 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.is_fastcar;
        int hashCode18 = (hashCode17 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.is_destination_hide;
        int hashCode19 = (hashCode18 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.history_num;
        int hashCode20 = (hashCode19 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str7 = this.push_token;
        int hashCode21 = (hashCode20 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num10 = this.tripDistance;
        if (num10 != null) {
            i2 = num10.hashCode();
        }
        int i3 = hashCode21 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiOrder> {
        public Integer assignType;
        public Integer dist;
        public String extraInfo;
        public String from;
        public Double fromLatitude;
        public Double fromLongitude;
        public Integer history_num;
        public Integer is_destination_hide;
        public Integer is_fastcar;
        public Integer mediaType;
        public String orderId;
        public Integer order_source;
        public String phone;
        public String push_token;
        public Long setOffTime;
        public Integer timeLinessType;
        public Integer tip;

        /* renamed from: to */
        public String f36961to;
        public Double toLatitude;
        public Double toLongitude;
        public Integer tripDistance;
        public String voiceUrl;

        public Builder() {
        }

        public Builder(TaxiOrder taxiOrder) {
            super(taxiOrder);
            if (taxiOrder != null) {
                this.orderId = taxiOrder.orderId;
                this.phone = taxiOrder.phone;
                this.mediaType = taxiOrder.mediaType;
                this.timeLinessType = taxiOrder.timeLinessType;
                this.setOffTime = taxiOrder.setOffTime;
                this.from = taxiOrder.from;
                this.f36961to = taxiOrder.f36960to;
                this.fromLatitude = taxiOrder.fromLatitude;
                this.fromLongitude = taxiOrder.fromLongitude;
                this.toLatitude = taxiOrder.toLatitude;
                this.toLongitude = taxiOrder.toLongitude;
                this.extraInfo = taxiOrder.extraInfo;
                this.tip = taxiOrder.tip;
                this.dist = taxiOrder.dist;
                this.voiceUrl = taxiOrder.voiceUrl;
                this.assignType = taxiOrder.assignType;
                this.order_source = taxiOrder.order_source;
                this.is_fastcar = taxiOrder.is_fastcar;
                this.is_destination_hide = taxiOrder.is_destination_hide;
                this.history_num = taxiOrder.history_num;
                this.push_token = taxiOrder.push_token;
                this.tripDistance = taxiOrder.tripDistance;
            }
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder mediaType(Integer num) {
            this.mediaType = num;
            return this;
        }

        public Builder timeLinessType(Integer num) {
            this.timeLinessType = num;
            return this;
        }

        public Builder setOffTime(Long l) {
            this.setOffTime = l;
            return this;
        }

        public Builder from(String str) {
            this.from = str;
            return this;
        }

        /* renamed from: to */
        public Builder mo94962to(String str) {
            this.f36961to = str;
            return this;
        }

        public Builder fromLatitude(Double d) {
            this.fromLatitude = d;
            return this;
        }

        public Builder fromLongitude(Double d) {
            this.fromLongitude = d;
            return this;
        }

        public Builder toLatitude(Double d) {
            this.toLatitude = d;
            return this;
        }

        public Builder toLongitude(Double d) {
            this.toLongitude = d;
            return this;
        }

        public Builder extraInfo(String str) {
            this.extraInfo = str;
            return this;
        }

        public Builder tip(Integer num) {
            this.tip = num;
            return this;
        }

        public Builder dist(Integer num) {
            this.dist = num;
            return this;
        }

        public Builder voiceUrl(String str) {
            this.voiceUrl = str;
            return this;
        }

        public Builder assignType(Integer num) {
            this.assignType = num;
            return this;
        }

        public Builder order_source(Integer num) {
            this.order_source = num;
            return this;
        }

        public Builder is_fastcar(Integer num) {
            this.is_fastcar = num;
            return this;
        }

        public Builder is_destination_hide(Integer num) {
            this.is_destination_hide = num;
            return this;
        }

        public Builder history_num(Integer num) {
            this.history_num = num;
            return this;
        }

        public Builder push_token(String str) {
            this.push_token = str;
            return this;
        }

        public Builder tripDistance(Integer num) {
            this.tripDistance = num;
            return this;
        }

        public TaxiOrder build() {
            return new TaxiOrder(this);
        }
    }
}
