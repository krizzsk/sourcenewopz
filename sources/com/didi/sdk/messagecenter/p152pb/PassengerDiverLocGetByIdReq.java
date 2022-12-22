package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.sdk.messagecenter.pb.PassengerDiverLocGetByIdReq */
public final class PassengerDiverLocGetByIdReq extends Message {
    public static final String DEFAULT_APP_VERSION = "";
    public static final Integer DEFAULT_CHANNEL = 0;
    public static final Integer DEFAULT_COORD_TYPE = 0;
    public static final String DEFAULT_DATA_TYPE = "";
    public static final String DEFAULT_DEVICE_ID = "";
    public static final List<Long> DEFAULT_DIVERIDS = Collections.emptyList();
    public static final Integer DEFAULT_IS_ETA = 0;
    public static final String DEFAULT_LANG = "";
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final String DEFAULT_LOCATION_COUNTRY = "";
    public static final String DEFAULT_OPEN_ID = "";
    public static final OrderStat DEFAULT_ORDER_STAT = OrderStat.HomePage;
    public static final List<LocPoint> DEFAULT_PASSLOCPOINTS = Collections.emptyList();
    public static final String DEFAULT_PHONE_NUM = "";
    public static final Integer DEFAULT_ROLE = 0;
    public static final String DEFAULT_SDKMAPTYPE = "";
    public static final String DEFAULT_SRC = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Double DEFAULT_TLAT;
    public static final Double DEFAULT_TLNG;
    public static final String DEFAULT_TRIP_COUNTRY = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final String DEFAULT_UTC_OFFSET = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String app_version;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer channel;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer coord_type;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String data_type;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String device_id;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT64)
    public final List<Long> diverIds;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer is_eta;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(tag = 8, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 9, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String location_country;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String open_id;
    @ProtoField(tag = 7, type = Message.Datatype.ENUM)
    public final OrderStat order_stat;
    @ProtoField(label = Message.Label.REPEATED, messageType = LocPoint.class, tag = 12)
    public final List<LocPoint> passLocPoints;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String phone_num;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String sdkmaptype;
    @ProtoField(tag = 24, type = Message.Datatype.STRING)
    public final String src;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 10, type = Message.Datatype.DOUBLE)
    public final Double tlat;
    @ProtoField(tag = 11, type = Message.Datatype.DOUBLE)
    public final Double tlng;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String trip_country;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String utc_offset;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LAT = valueOf;
        DEFAULT_LNG = valueOf;
        DEFAULT_TLAT = valueOf;
        DEFAULT_TLNG = valueOf;
    }

    public PassengerDiverLocGetByIdReq(String str, Integer num, Integer num2, List<Long> list, Integer num3, Integer num4, OrderStat orderStat, Double d, Double d2, Double d3, Double d4, List<LocPoint> list2, String str2, String str3, String str4, String str5, String str6, Integer num5, Integer num6, String str7, String str8, String str9, String str10, String str11) {
        this.phone_num = str;
        this.role = num;
        this.channel = num2;
        this.diverIds = immutableCopyOf(list);
        this.type = num3;
        this.timestamp = num4;
        this.order_stat = orderStat;
        this.lat = d;
        this.lng = d2;
        this.tlat = d3;
        this.tlng = d4;
        this.passLocPoints = immutableCopyOf(list2);
        this.sdkmaptype = str2;
        this.data_type = str3;
        this.device_id = str4;
        this.open_id = str5;
        this.app_version = str6;
        this.coord_type = num5;
        this.is_eta = num6;
        this.location_country = str7;
        this.utc_offset = str8;
        this.lang = str9;
        this.trip_country = str10;
        this.src = str11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PassengerDiverLocGetByIdReq(com.didi.sdk.messagecenter.p152pb.PassengerDiverLocGetByIdReq.Builder r28) {
        /*
            r27 = this;
            r0 = r28
            r1 = r27
            java.lang.String r2 = r0.phone_num
            java.lang.Integer r3 = r0.role
            java.lang.Integer r4 = r0.channel
            java.util.List<java.lang.Long> r5 = r0.diverIds
            java.lang.Integer r6 = r0.type
            java.lang.Integer r7 = r0.timestamp
            com.didi.sdk.messagecenter.pb.OrderStat r8 = r0.order_stat
            java.lang.Double r9 = r0.lat
            java.lang.Double r10 = r0.lng
            java.lang.Double r11 = r0.tlat
            java.lang.Double r12 = r0.tlng
            java.util.List<com.didi.sdk.messagecenter.pb.LocPoint> r13 = r0.passLocPoints
            java.lang.String r14 = r0.sdkmaptype
            java.lang.String r15 = r0.data_type
            r26 = r1
            java.lang.String r1 = r0.device_id
            r16 = r1
            java.lang.String r1 = r0.open_id
            r17 = r1
            java.lang.String r1 = r0.app_version
            r18 = r1
            java.lang.Integer r1 = r0.coord_type
            r19 = r1
            java.lang.Integer r1 = r0.is_eta
            r20 = r1
            java.lang.String r1 = r0.location_country
            r21 = r1
            java.lang.String r1 = r0.utc_offset
            r22 = r1
            java.lang.String r1 = r0.lang
            r23 = r1
            java.lang.String r1 = r0.trip_country
            r24 = r1
            java.lang.String r1 = r0.src
            r25 = r1
            r1 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r27.setBuilder(r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.messagecenter.p152pb.PassengerDiverLocGetByIdReq.<init>(com.didi.sdk.messagecenter.pb.PassengerDiverLocGetByIdReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerDiverLocGetByIdReq)) {
            return false;
        }
        PassengerDiverLocGetByIdReq passengerDiverLocGetByIdReq = (PassengerDiverLocGetByIdReq) obj;
        if (!equals((Object) this.phone_num, (Object) passengerDiverLocGetByIdReq.phone_num) || !equals((Object) this.role, (Object) passengerDiverLocGetByIdReq.role) || !equals((Object) this.channel, (Object) passengerDiverLocGetByIdReq.channel) || !equals((List<?>) this.diverIds, (List<?>) passengerDiverLocGetByIdReq.diverIds) || !equals((Object) this.type, (Object) passengerDiverLocGetByIdReq.type) || !equals((Object) this.timestamp, (Object) passengerDiverLocGetByIdReq.timestamp) || !equals((Object) this.order_stat, (Object) passengerDiverLocGetByIdReq.order_stat) || !equals((Object) this.lat, (Object) passengerDiverLocGetByIdReq.lat) || !equals((Object) this.lng, (Object) passengerDiverLocGetByIdReq.lng) || !equals((Object) this.tlat, (Object) passengerDiverLocGetByIdReq.tlat) || !equals((Object) this.tlng, (Object) passengerDiverLocGetByIdReq.tlng) || !equals((List<?>) this.passLocPoints, (List<?>) passengerDiverLocGetByIdReq.passLocPoints) || !equals((Object) this.sdkmaptype, (Object) passengerDiverLocGetByIdReq.sdkmaptype) || !equals((Object) this.data_type, (Object) passengerDiverLocGetByIdReq.data_type) || !equals((Object) this.device_id, (Object) passengerDiverLocGetByIdReq.device_id) || !equals((Object) this.open_id, (Object) passengerDiverLocGetByIdReq.open_id) || !equals((Object) this.app_version, (Object) passengerDiverLocGetByIdReq.app_version) || !equals((Object) this.coord_type, (Object) passengerDiverLocGetByIdReq.coord_type) || !equals((Object) this.is_eta, (Object) passengerDiverLocGetByIdReq.is_eta) || !equals((Object) this.location_country, (Object) passengerDiverLocGetByIdReq.location_country) || !equals((Object) this.utc_offset, (Object) passengerDiverLocGetByIdReq.utc_offset) || !equals((Object) this.lang, (Object) passengerDiverLocGetByIdReq.lang) || !equals((Object) this.trip_country, (Object) passengerDiverLocGetByIdReq.trip_country) || !equals((Object) this.src, (Object) passengerDiverLocGetByIdReq.src)) {
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
        Integer num4 = this.timestamp;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        OrderStat orderStat = this.order_stat;
        int hashCode7 = (hashCode6 + (orderStat != null ? orderStat.hashCode() : 0)) * 37;
        Double d = this.lat;
        int hashCode8 = (hashCode7 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.lng;
        int hashCode9 = (hashCode8 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.tlat;
        int hashCode10 = (hashCode9 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.tlng;
        int hashCode11 = (hashCode10 + (d4 != null ? d4.hashCode() : 0)) * 37;
        List<LocPoint> list2 = this.passLocPoints;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode11 + i3) * 37;
        String str2 = this.sdkmaptype;
        int hashCode12 = (i4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.data_type;
        int hashCode13 = (hashCode12 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.device_id;
        int hashCode14 = (hashCode13 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.open_id;
        int hashCode15 = (hashCode14 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.app_version;
        int hashCode16 = (hashCode15 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num5 = this.coord_type;
        int hashCode17 = (hashCode16 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.is_eta;
        int hashCode18 = (hashCode17 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str7 = this.location_country;
        int hashCode19 = (hashCode18 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.utc_offset;
        int hashCode20 = (hashCode19 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.lang;
        int hashCode21 = (hashCode20 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.trip_country;
        int hashCode22 = (hashCode21 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.src;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        int i5 = hashCode22 + i2;
        this.hashCode = i5;
        return i5;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.PassengerDiverLocGetByIdReq$Builder */
    public static final class Builder extends Message.Builder<PassengerDiverLocGetByIdReq> {
        public String app_version;
        public Integer channel;
        public Integer coord_type;
        public String data_type;
        public String device_id;
        public List<Long> diverIds;
        public Integer is_eta;
        public String lang;
        public Double lat;
        public Double lng;
        public String location_country;
        public String open_id;
        public OrderStat order_stat;
        public List<LocPoint> passLocPoints;
        public String phone_num;
        public Integer role;
        public String sdkmaptype;
        public String src;
        public Integer timestamp;
        public Double tlat;
        public Double tlng;
        public String trip_country;
        public Integer type;
        public String utc_offset;

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
                this.sdkmaptype = passengerDiverLocGetByIdReq.sdkmaptype;
                this.data_type = passengerDiverLocGetByIdReq.data_type;
                this.device_id = passengerDiverLocGetByIdReq.device_id;
                this.open_id = passengerDiverLocGetByIdReq.open_id;
                this.app_version = passengerDiverLocGetByIdReq.app_version;
                this.coord_type = passengerDiverLocGetByIdReq.coord_type;
                this.is_eta = passengerDiverLocGetByIdReq.is_eta;
                this.location_country = passengerDiverLocGetByIdReq.location_country;
                this.utc_offset = passengerDiverLocGetByIdReq.utc_offset;
                this.lang = passengerDiverLocGetByIdReq.lang;
                this.trip_country = passengerDiverLocGetByIdReq.trip_country;
                this.src = passengerDiverLocGetByIdReq.src;
            }
        }

        public Builder phone_num(String str) {
            this.phone_num = str;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public Builder channel(Integer num) {
            this.channel = num;
            return this;
        }

        public Builder diverIds(List<Long> list) {
            this.diverIds = checkForNulls(list);
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder order_stat(OrderStat orderStat) {
            this.order_stat = orderStat;
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

        public Builder tlat(Double d) {
            this.tlat = d;
            return this;
        }

        public Builder tlng(Double d) {
            this.tlng = d;
            return this;
        }

        public Builder passLocPoints(List<LocPoint> list) {
            this.passLocPoints = checkForNulls(list);
            return this;
        }

        public Builder sdkmaptype(String str) {
            this.sdkmaptype = str;
            return this;
        }

        public Builder data_type(String str) {
            this.data_type = str;
            return this;
        }

        public Builder device_id(String str) {
            this.device_id = str;
            return this;
        }

        public Builder open_id(String str) {
            this.open_id = str;
            return this;
        }

        public Builder app_version(String str) {
            this.app_version = str;
            return this;
        }

        public Builder coord_type(Integer num) {
            this.coord_type = num;
            return this;
        }

        public Builder is_eta(Integer num) {
            this.is_eta = num;
            return this;
        }

        public Builder location_country(String str) {
            this.location_country = str;
            return this;
        }

        public Builder utc_offset(String str) {
            this.utc_offset = str;
            return this;
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public Builder trip_country(String str) {
            this.trip_country = str;
            return this;
        }

        public Builder src(String str) {
            this.src = str;
            return this;
        }

        public PassengerDiverLocGetByIdReq build() {
            checkRequiredFields();
            return new PassengerDiverLocGetByIdReq(this);
        }
    }
}
