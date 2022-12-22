package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.sdk.messagecenter.pb.PassengerDiverLocGetReq */
public final class PassengerDiverLocGetReq extends Message {
    public static final String DEFAULT_APP_VERSION = "";
    public static final String DEFAULT_BUBBLE_ID = "";
    public static final Integer DEFAULT_CAR_LEVEL = 0;
    public static final Integer DEFAULT_CHANNEL = 0;
    public static final Integer DEFAULT_COORD_TYPE = 0;
    public static final String DEFAULT_DATA_TYPE = "";
    public static final String DEFAULT_DEVICE_ID = "";
    public static final String DEFAULT_EXTRA = "";
    public static final Integer DEFAULT_FREE_SEAT_NUM = 0;
    public static final Integer DEFAULT_IS_CARPOOL = 0;
    public static final List<String> DEFAULT_KEYLIST = Collections.emptyList();
    public static final String DEFAULT_LANG = "";
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final String DEFAULT_LOCATION_COUNTRY = "";
    public static final String DEFAULT_OPEN_ID = "";
    public static final Integer DEFAULT_ORDER_MODEL = 0;
    public static final OrderStat DEFAULT_ORDER_STAT = OrderStat.HomePage;
    public static final Integer DEFAULT_ORDER_TAB = 0;
    public static final String DEFAULT_PHONE_NUM = "";
    public static final String DEFAULT_PID = "";
    public static final Double DEFAULT_RADIUS;
    public static final Integer DEFAULT_ROLE = 0;
    public static final String DEFAULT_SDKMAPTYPE = "";
    public static final String DEFAULT_SRC = "";
    public static final String DEFAULT_START_PARKING_PROPERTY = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Double DEFAULT_TLAT;
    public static final Double DEFAULT_TLNG;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_TRIP_COUNTRY = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final String DEFAULT_USER_LEVEL = "";
    public static final String DEFAULT_UTC_OFFSET = "";
    public static final String DEFAULT_XTAGS = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String app_version;
    @ProtoField(tag = 31, type = Message.Datatype.STRING)
    public final String bubble_id;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer car_level;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer channel;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer coord_type;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String data_type;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String device_id;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String extra;
    @ProtoField(tag = 12, type = Message.Datatype.UINT32)
    public final Integer free_seat_num;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer is_carpool;
    @ProtoField(label = Message.Label.REPEATED, tag = 15, type = Message.Datatype.STRING)
    public final List<String> keylist;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String location_country;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String open_id;
    @ProtoField(tag = 30, type = Message.Datatype.INT32)
    public final Integer order_model;
    @ProtoField(tag = 9, type = Message.Datatype.ENUM)
    public final OrderStat order_stat;
    @ProtoField(tag = 29, type = Message.Datatype.INT32)
    public final Integer order_tab;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String phone_num;
    @ProtoField(tag = 35, type = Message.Datatype.STRING)
    public final String pid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.DOUBLE)
    public final Double radius;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String sdkmaptype;
    @ProtoField(tag = 33, type = Message.Datatype.STRING)
    public final String src;
    @ProtoField(tag = 32, type = Message.Datatype.STRING)
    public final String start_parking_property;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 27, type = Message.Datatype.DOUBLE)
    public final Double tlat;
    @ProtoField(tag = 28, type = Message.Datatype.DOUBLE)
    public final Double tlng;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String trip_country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 34, type = Message.Datatype.STRING)
    public final String user_level;
    @ProtoField(tag = 24, type = Message.Datatype.STRING)
    public final String utc_offset;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String xtags;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LAT = valueOf;
        DEFAULT_LNG = valueOf;
        DEFAULT_RADIUS = valueOf;
        DEFAULT_TLAT = valueOf;
        DEFAULT_TLNG = valueOf;
    }

    public PassengerDiverLocGetReq(String str, Integer num, Double d, Double d2, Double d3, Integer num2, Integer num3, Integer num4, OrderStat orderStat, String str2, String str3, Integer num5, String str4, String str5, List<String> list, String str6, String str7, String str8, String str9, Integer num6, Integer num7, Integer num8, String str10, String str11, String str12, String str13, Double d4, Double d5, Integer num9, Integer num10, String str14, String str15, String str16, String str17, String str18) {
        this.phone_num = str;
        this.role = num;
        this.lat = d;
        this.lng = d2;
        this.radius = d3;
        this.channel = num2;
        this.type = num3;
        this.timestamp = num4;
        this.order_stat = orderStat;
        this.sdkmaptype = str2;
        this.extra = str3;
        this.free_seat_num = num5;
        this.xtags = str4;
        this.token = str5;
        this.keylist = immutableCopyOf(list);
        this.data_type = str6;
        this.device_id = str7;
        this.open_id = str8;
        this.app_version = str9;
        this.coord_type = num6;
        this.car_level = num7;
        this.is_carpool = num8;
        this.location_country = str10;
        this.utc_offset = str11;
        this.lang = str12;
        this.trip_country = str13;
        this.tlat = d4;
        this.tlng = d5;
        this.order_tab = num9;
        this.order_model = num10;
        this.bubble_id = str14;
        this.start_parking_property = str15;
        this.src = str16;
        this.user_level = str17;
        this.pid = str18;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PassengerDiverLocGetReq(com.didi.sdk.messagecenter.p152pb.PassengerDiverLocGetReq.Builder r39) {
        /*
            r38 = this;
            r0 = r39
            r1 = r38
            java.lang.String r2 = r0.phone_num
            java.lang.Integer r3 = r0.role
            java.lang.Double r4 = r0.lat
            java.lang.Double r5 = r0.lng
            java.lang.Double r6 = r0.radius
            java.lang.Integer r7 = r0.channel
            java.lang.Integer r8 = r0.type
            java.lang.Integer r9 = r0.timestamp
            com.didi.sdk.messagecenter.pb.OrderStat r10 = r0.order_stat
            java.lang.String r11 = r0.sdkmaptype
            java.lang.String r12 = r0.extra
            java.lang.Integer r13 = r0.free_seat_num
            java.lang.String r14 = r0.xtags
            java.lang.String r15 = r0.token
            r37 = r1
            java.util.List<java.lang.String> r1 = r0.keylist
            r16 = r1
            java.lang.String r1 = r0.data_type
            r17 = r1
            java.lang.String r1 = r0.device_id
            r18 = r1
            java.lang.String r1 = r0.open_id
            r19 = r1
            java.lang.String r1 = r0.app_version
            r20 = r1
            java.lang.Integer r1 = r0.coord_type
            r21 = r1
            java.lang.Integer r1 = r0.car_level
            r22 = r1
            java.lang.Integer r1 = r0.is_carpool
            r23 = r1
            java.lang.String r1 = r0.location_country
            r24 = r1
            java.lang.String r1 = r0.utc_offset
            r25 = r1
            java.lang.String r1 = r0.lang
            r26 = r1
            java.lang.String r1 = r0.trip_country
            r27 = r1
            java.lang.Double r1 = r0.tlat
            r28 = r1
            java.lang.Double r1 = r0.tlng
            r29 = r1
            java.lang.Integer r1 = r0.order_tab
            r30 = r1
            java.lang.Integer r1 = r0.order_model
            r31 = r1
            java.lang.String r1 = r0.bubble_id
            r32 = r1
            java.lang.String r1 = r0.start_parking_property
            r33 = r1
            java.lang.String r1 = r0.src
            r34 = r1
            java.lang.String r1 = r0.user_level
            r35 = r1
            java.lang.String r1 = r0.pid
            r36 = r1
            r1 = r37
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            r38.setBuilder(r39)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.messagecenter.p152pb.PassengerDiverLocGetReq.<init>(com.didi.sdk.messagecenter.pb.PassengerDiverLocGetReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerDiverLocGetReq)) {
            return false;
        }
        PassengerDiverLocGetReq passengerDiverLocGetReq = (PassengerDiverLocGetReq) obj;
        if (!equals((Object) this.phone_num, (Object) passengerDiverLocGetReq.phone_num) || !equals((Object) this.role, (Object) passengerDiverLocGetReq.role) || !equals((Object) this.lat, (Object) passengerDiverLocGetReq.lat) || !equals((Object) this.lng, (Object) passengerDiverLocGetReq.lng) || !equals((Object) this.radius, (Object) passengerDiverLocGetReq.radius) || !equals((Object) this.channel, (Object) passengerDiverLocGetReq.channel) || !equals((Object) this.type, (Object) passengerDiverLocGetReq.type) || !equals((Object) this.timestamp, (Object) passengerDiverLocGetReq.timestamp) || !equals((Object) this.order_stat, (Object) passengerDiverLocGetReq.order_stat) || !equals((Object) this.sdkmaptype, (Object) passengerDiverLocGetReq.sdkmaptype) || !equals((Object) this.extra, (Object) passengerDiverLocGetReq.extra) || !equals((Object) this.free_seat_num, (Object) passengerDiverLocGetReq.free_seat_num) || !equals((Object) this.xtags, (Object) passengerDiverLocGetReq.xtags) || !equals((Object) this.token, (Object) passengerDiverLocGetReq.token) || !equals((List<?>) this.keylist, (List<?>) passengerDiverLocGetReq.keylist) || !equals((Object) this.data_type, (Object) passengerDiverLocGetReq.data_type) || !equals((Object) this.device_id, (Object) passengerDiverLocGetReq.device_id) || !equals((Object) this.open_id, (Object) passengerDiverLocGetReq.open_id) || !equals((Object) this.app_version, (Object) passengerDiverLocGetReq.app_version) || !equals((Object) this.coord_type, (Object) passengerDiverLocGetReq.coord_type) || !equals((Object) this.car_level, (Object) passengerDiverLocGetReq.car_level) || !equals((Object) this.is_carpool, (Object) passengerDiverLocGetReq.is_carpool) || !equals((Object) this.location_country, (Object) passengerDiverLocGetReq.location_country) || !equals((Object) this.utc_offset, (Object) passengerDiverLocGetReq.utc_offset) || !equals((Object) this.lang, (Object) passengerDiverLocGetReq.lang) || !equals((Object) this.trip_country, (Object) passengerDiverLocGetReq.trip_country) || !equals((Object) this.tlat, (Object) passengerDiverLocGetReq.tlat) || !equals((Object) this.tlng, (Object) passengerDiverLocGetReq.tlng) || !equals((Object) this.order_tab, (Object) passengerDiverLocGetReq.order_tab) || !equals((Object) this.order_model, (Object) passengerDiverLocGetReq.order_model) || !equals((Object) this.bubble_id, (Object) passengerDiverLocGetReq.bubble_id) || !equals((Object) this.start_parking_property, (Object) passengerDiverLocGetReq.start_parking_property) || !equals((Object) this.src, (Object) passengerDiverLocGetReq.src) || !equals((Object) this.user_level, (Object) passengerDiverLocGetReq.user_level) || !equals((Object) this.pid, (Object) passengerDiverLocGetReq.pid)) {
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
        Double d = this.lat;
        int hashCode3 = (hashCode2 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.lng;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.radius;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Integer num2 = this.channel;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.type;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.timestamp;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        OrderStat orderStat = this.order_stat;
        int hashCode9 = (hashCode8 + (orderStat != null ? orderStat.hashCode() : 0)) * 37;
        String str2 = this.sdkmaptype;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.extra;
        int hashCode11 = (hashCode10 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num5 = this.free_seat_num;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str4 = this.xtags;
        int hashCode13 = (hashCode12 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.token;
        int hashCode14 = (hashCode13 + (str5 != null ? str5.hashCode() : 0)) * 37;
        List<String> list = this.keylist;
        int hashCode15 = (hashCode14 + (list != null ? list.hashCode() : 1)) * 37;
        String str6 = this.data_type;
        int hashCode16 = (hashCode15 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.device_id;
        int hashCode17 = (hashCode16 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.open_id;
        int hashCode18 = (hashCode17 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.app_version;
        int hashCode19 = (hashCode18 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Integer num6 = this.coord_type;
        int hashCode20 = (hashCode19 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.car_level;
        int hashCode21 = (hashCode20 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.is_carpool;
        int hashCode22 = (hashCode21 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str10 = this.location_country;
        int hashCode23 = (hashCode22 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.utc_offset;
        int hashCode24 = (hashCode23 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.lang;
        int hashCode25 = (hashCode24 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.trip_country;
        int hashCode26 = (hashCode25 + (str13 != null ? str13.hashCode() : 0)) * 37;
        Double d4 = this.tlat;
        int hashCode27 = (hashCode26 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Double d5 = this.tlng;
        int hashCode28 = (hashCode27 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Integer num9 = this.order_tab;
        int hashCode29 = (hashCode28 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.order_model;
        int hashCode30 = (hashCode29 + (num10 != null ? num10.hashCode() : 0)) * 37;
        String str14 = this.bubble_id;
        int hashCode31 = (hashCode30 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.start_parking_property;
        int hashCode32 = (hashCode31 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.src;
        int hashCode33 = (hashCode32 + (str16 != null ? str16.hashCode() : 0)) * 37;
        String str17 = this.user_level;
        int hashCode34 = (hashCode33 + (str17 != null ? str17.hashCode() : 0)) * 37;
        String str18 = this.pid;
        if (str18 != null) {
            i2 = str18.hashCode();
        }
        int i3 = hashCode34 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.PassengerDiverLocGetReq$Builder */
    public static final class Builder extends Message.Builder<PassengerDiverLocGetReq> {
        public String app_version;
        public String bubble_id;
        public Integer car_level;
        public Integer channel;
        public Integer coord_type;
        public String data_type;
        public String device_id;
        public String extra;
        public Integer free_seat_num;
        public Integer is_carpool;
        public List<String> keylist;
        public String lang;
        public Double lat;
        public Double lng;
        public String location_country;
        public String open_id;
        public Integer order_model;
        public OrderStat order_stat;
        public Integer order_tab;
        public String phone_num;
        public String pid;
        public Double radius;
        public Integer role;
        public String sdkmaptype;
        public String src;
        public String start_parking_property;
        public Integer timestamp;
        public Double tlat;
        public Double tlng;
        public String token;
        public String trip_country;
        public Integer type;
        public String user_level;
        public String utc_offset;
        public String xtags;

        public Builder() {
        }

        public Builder(PassengerDiverLocGetReq passengerDiverLocGetReq) {
            super(passengerDiverLocGetReq);
            if (passengerDiverLocGetReq != null) {
                this.phone_num = passengerDiverLocGetReq.phone_num;
                this.role = passengerDiverLocGetReq.role;
                this.lat = passengerDiverLocGetReq.lat;
                this.lng = passengerDiverLocGetReq.lng;
                this.radius = passengerDiverLocGetReq.radius;
                this.channel = passengerDiverLocGetReq.channel;
                this.type = passengerDiverLocGetReq.type;
                this.timestamp = passengerDiverLocGetReq.timestamp;
                this.order_stat = passengerDiverLocGetReq.order_stat;
                this.sdkmaptype = passengerDiverLocGetReq.sdkmaptype;
                this.extra = passengerDiverLocGetReq.extra;
                this.free_seat_num = passengerDiverLocGetReq.free_seat_num;
                this.xtags = passengerDiverLocGetReq.xtags;
                this.token = passengerDiverLocGetReq.token;
                this.keylist = PassengerDiverLocGetReq.copyOf(passengerDiverLocGetReq.keylist);
                this.data_type = passengerDiverLocGetReq.data_type;
                this.device_id = passengerDiverLocGetReq.device_id;
                this.open_id = passengerDiverLocGetReq.open_id;
                this.app_version = passengerDiverLocGetReq.app_version;
                this.coord_type = passengerDiverLocGetReq.coord_type;
                this.car_level = passengerDiverLocGetReq.car_level;
                this.is_carpool = passengerDiverLocGetReq.is_carpool;
                this.location_country = passengerDiverLocGetReq.location_country;
                this.utc_offset = passengerDiverLocGetReq.utc_offset;
                this.lang = passengerDiverLocGetReq.lang;
                this.trip_country = passengerDiverLocGetReq.trip_country;
                this.tlat = passengerDiverLocGetReq.tlat;
                this.tlng = passengerDiverLocGetReq.tlng;
                this.order_tab = passengerDiverLocGetReq.order_tab;
                this.order_model = passengerDiverLocGetReq.order_model;
                this.bubble_id = passengerDiverLocGetReq.bubble_id;
                this.start_parking_property = passengerDiverLocGetReq.start_parking_property;
                this.src = passengerDiverLocGetReq.src;
                this.user_level = passengerDiverLocGetReq.user_level;
                this.pid = passengerDiverLocGetReq.pid;
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

        public Builder lat(Double d) {
            this.lat = d;
            return this;
        }

        public Builder lng(Double d) {
            this.lng = d;
            return this;
        }

        public Builder radius(Double d) {
            this.radius = d;
            return this;
        }

        public Builder channel(Integer num) {
            this.channel = num;
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

        public Builder sdkmaptype(String str) {
            this.sdkmaptype = str;
            return this;
        }

        public Builder extra(String str) {
            this.extra = str;
            return this;
        }

        public Builder free_seat_num(Integer num) {
            this.free_seat_num = num;
            return this;
        }

        public Builder xtags(String str) {
            this.xtags = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder keylist(List<String> list) {
            this.keylist = checkForNulls(list);
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

        public Builder car_level(Integer num) {
            this.car_level = num;
            return this;
        }

        public Builder is_carpool(Integer num) {
            this.is_carpool = num;
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

        public Builder tlat(Double d) {
            this.tlat = d;
            return this;
        }

        public Builder tlng(Double d) {
            this.tlng = d;
            return this;
        }

        public Builder order_tab(Integer num) {
            this.order_tab = num;
            return this;
        }

        public Builder order_model(Integer num) {
            this.order_model = num;
            return this;
        }

        public Builder bubble_id(String str) {
            this.bubble_id = str;
            return this;
        }

        public Builder start_parking_property(String str) {
            this.start_parking_property = str;
            return this;
        }

        public Builder src(String str) {
            this.src = str;
            return this;
        }

        public Builder user_level(String str) {
            this.user_level = str;
            return this;
        }

        public Builder pid(String str) {
            this.pid = str;
            return this;
        }

        public PassengerDiverLocGetReq build() {
            checkRequiredFields();
            return new PassengerDiverLocGetReq(this);
        }
    }
}
