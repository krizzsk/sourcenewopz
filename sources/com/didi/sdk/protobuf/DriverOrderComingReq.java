package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public final class DriverOrderComingReq extends Message {
    public static final String DEFAULT_AUDIOURL = "";
    public static final Integer DEFAULT_BONUS = 0;
    public static final String DEFAULT_CARPOOL_HEADURL = "";
    public static final List<CarPoolLocation> DEFAULT_CARPOOL_LOCATIONS = Collections.emptyList();
    public static final String DEFAULT_CARPOOL_NICKNAME = "";
    public static final String DEFAULT_CARPOOL_ONE_PRICE = "";
    public static final Integer DEFAULT_CARPOOL_PASSENGERNUMBER = 0;
    public static final String DEFAULT_CARPOOL_PRICE = "";
    public static final String DEFAULT_CARPOOL_PRICE_KEY = "";
    public static final Double DEFAULT_COMBO_DISTANCE;
    public static final Integer DEFAULT_COMBO_FEE = 0;
    public static final Integer DEFAULT_COMBO_TIME = 0;
    public static final Integer DEFAULT_COMBO_TYPE = 0;
    public static final Integer DEFAULT_CREATETIME = 0;
    public static final Integer DEFAULT_DISABLETIME = 0;
    public static final Integer DEFAULT_DISABLETIME4LOOK = 0;
    public static final Long DEFAULT_DISPATCH_UUID = 0L;
    public static final String DEFAULT_DISTANCE = "";
    public static final Integer DEFAULT_DYNAMIC_PRICE = 0;
    public static final Integer DEFAULT_EXP = 0;
    public static final String DEFAULT_EXP2 = "";
    public static final String DEFAULT_EXTRAINFO = "";
    public static final Integer DEFAULT_FORCEPLAY = 0;
    public static final String DEFAULT_FROM = "";
    public static final String DEFAULT_FROMADDR1 = "";
    public static final String DEFAULT_FROMADDR2 = "";
    public static final Double DEFAULT_FROMLAT;
    public static final Double DEFAULT_FROMLNG;
    public static final Integer DEFAULT_HISTORY_NUM = 0;
    public static final Integer DEFAULT_INPUT = 0;
    public static final Integer DEFAULT_IS_CARPOLL = 0;
    public static final Integer DEFAULT_IS_DESTINATION_HIDE = 0;
    public static final Integer DEFAULT_IS_FASTCAR = 0;
    public static final Integer DEFAULT_IS_ZHIPAI_ORDER = 0;
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_LASTUPDATE = 0;
    public static final Integer DEFAULT_LISTENMETHOD = 0;
    public static final Integer DEFAULT_LISTENMODEL = 0;
    public static final String DEFAULT_OID = "";
    public static final Integer DEFAULT_ON_BOARD = 0;
    public static final String DEFAULT_ORDER_FLOAT_PRICE = "";
    public static final String DEFAULT_ORDER_PRICE = "";
    public static final Integer DEFAULT_ORDER_SOURCE = 0;
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_PLAYTXT = "";
    public static final String DEFAULT_PLAYTXT2 = "";
    public static final Integer DEFAULT_PREEND = 0;
    public static final Integer DEFAULT_PRESTART = 0;
    public static final String DEFAULT_PUSH_TOKEN = "";
    public static final Integer DEFAULT_REALLIMIT = 0;
    public static final Double DEFAULT_REALTOLAT;
    public static final Double DEFAULT_REALTOLNG;
    public static final String DEFAULT_RECEIVE_LEVEL = "";
    public static final Integer DEFAULT_REQUIRE_LEVEL = 0;
    public static final String DEFAULT_REQUIRE_LEVEL_TXT = "";
    public static final String DEFAULT_REWARD_SHOW_CONTENT = "";
    public static final ByteString DEFAULT_SEND_INFO = ByteString.EMPTY;
    public static final Integer DEFAULT_SETUPTIME = 0;
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Integer DEFAULT_TIP = 0;
    public static final String DEFAULT_TO = "";
    public static final String DEFAULT_TOADDR1 = "";
    public static final String DEFAULT_TOADDR2 = "";
    public static final Double DEFAULT_TOLAT;
    public static final Double DEFAULT_TOLNG;
    public static final Integer DEFAULT_TWAIT = 0;
    public static final Integer DEFAULT_TWAITMAX = 0;
    public static final Integer DEFAULT_TWAITMAX4LOOK = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_VOICESIZE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 22, type = Message.Datatype.STRING)
    public final String audioUrl;
    @ProtoField(label = Message.Label.REQUIRED, tag = 15, type = Message.Datatype.UINT32)
    public final Integer bonus;
    @ProtoField(tag = 63, type = Message.Datatype.STRING)
    public final String carpool_headurl;
    @ProtoField(label = Message.Label.REPEATED, messageType = CarPoolLocation.class, tag = 61)
    public final List<CarPoolLocation> carpool_locations;
    @ProtoField(tag = 62, type = Message.Datatype.STRING)
    public final String carpool_nickname;
    @ProtoField(tag = 59, type = Message.Datatype.STRING)
    public final String carpool_one_price;
    @ProtoField(tag = 60, type = Message.Datatype.INT32)
    public final Integer carpool_passengernumber;
    @ProtoField(tag = 64, type = Message.Datatype.STRING)
    public final String carpool_price;
    @ProtoField(tag = 65, type = Message.Datatype.STRING)
    public final String carpool_price_key;
    @ProtoField(tag = 51, type = Message.Datatype.DOUBLE)
    public final Double combo_distance;
    @ProtoField(tag = 49, type = Message.Datatype.INT32)
    public final Integer combo_fee;
    @ProtoField(tag = 50, type = Message.Datatype.INT32)
    public final Integer combo_time;
    @ProtoField(tag = 48, type = Message.Datatype.INT32)
    public final Integer combo_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT32)
    public final Integer createTime;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer disableTime;
    @ProtoField(tag = 40, type = Message.Datatype.INT32)
    public final Integer disableTime4look;
    @ProtoField(tag = 68, type = Message.Datatype.UINT64)
    public final Long dispatch_uuid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.STRING)
    public final String distance;
    @ProtoField(tag = 54, type = Message.Datatype.INT32)
    public final Integer dynamic_price;
    @ProtoField(label = Message.Label.REQUIRED, tag = 18, type = Message.Datatype.UINT32)
    public final Integer exp;
    @ProtoField(tag = 42, type = Message.Datatype.STRING)
    public final String exp2;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String extraInfo;
    @ProtoField(tag = 41, type = Message.Datatype.INT32)
    public final Integer forcePlay;
    @ProtoField(label = Message.Label.REQUIRED, tag = 8, type = Message.Datatype.STRING)
    public final String from;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String fromAddr1;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String fromAddr2;
    @ProtoField(label = Message.Label.REQUIRED, tag = 10, type = Message.Datatype.DOUBLE)
    public final Double fromLat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 11, type = Message.Datatype.DOUBLE)
    public final Double fromLng;
    @ProtoField(tag = 69, type = Message.Datatype.INT32)
    public final Integer history_num;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer input;
    @ProtoField(tag = 58, type = Message.Datatype.INT32)
    public final Integer is_carpoll;
    @ProtoField(tag = 67, type = Message.Datatype.INT32)
    public final Integer is_destination_hide;
    @ProtoField(tag = 53, type = Message.Datatype.INT32)
    public final Integer is_fastcar;
    @ProtoField(tag = 55, type = Message.Datatype.INT32)
    public final Integer is_zhipai_order;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer lastUpdate;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer listenMethod;
    @ProtoField(tag = 31, type = Message.Datatype.INT32)
    public final Integer listenModel;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(tag = 43, type = Message.Datatype.INT32)
    public final Integer on_board;
    @ProtoField(tag = 57, type = Message.Datatype.STRING)
    public final String order_float_price;
    @ProtoField(tag = 56, type = Message.Datatype.STRING)
    public final String order_price;
    @ProtoField(tag = 52, type = Message.Datatype.INT32)
    public final Integer order_source;
    @ProtoField(label = Message.Label.REQUIRED, tag = 23, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(label = Message.Label.REQUIRED, tag = 19, type = Message.Datatype.STRING)
    public final String playTxt;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String playTxt2;
    @ProtoField(tag = 38, type = Message.Datatype.INT32)
    public final Integer preEnd;
    @ProtoField(tag = 37, type = Message.Datatype.INT32)
    public final Integer preStart;
    @ProtoField(tag = 70, type = Message.Datatype.STRING)
    public final String push_token;
    @ProtoField(tag = 34, type = Message.Datatype.INT32)
    public final Integer realLimit;
    @ProtoField(tag = 36, type = Message.Datatype.DOUBLE)
    public final Double realtoLat;
    @ProtoField(tag = 35, type = Message.Datatype.DOUBLE)
    public final Double realtoLng;
    @ProtoField(tag = 44, type = Message.Datatype.STRING)
    public final String receive_level;
    @ProtoField(tag = 46, type = Message.Datatype.INT32)
    public final Integer require_level;
    @ProtoField(tag = 45, type = Message.Datatype.STRING)
    public final String require_level_txt;
    @ProtoField(tag = 66, type = Message.Datatype.STRING)
    public final String reward_show_content;
    @ProtoField(tag = 47, type = Message.Datatype.BYTES)
    public final ByteString send_info;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer setupTime;
    @ProtoField(label = Message.Label.REQUIRED, tag = 16, type = Message.Datatype.INT32)
    public final Integer tWait;
    @ProtoField(label = Message.Label.REQUIRED, tag = 17, type = Message.Datatype.INT32)
    public final Integer tWaitMax;
    @ProtoField(tag = 39, type = Message.Datatype.INT32)
    public final Integer tWaitMax4look;
    @ProtoField(label = Message.Label.REQUIRED, tag = 20, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 14, type = Message.Datatype.UINT32)
    public final Integer tip;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9, type = Message.Datatype.STRING)

    /* renamed from: to */
    public final String f36952to;
    @ProtoField(tag = 27, type = Message.Datatype.STRING)
    public final String toAddr1;
    @ProtoField(tag = 28, type = Message.Datatype.STRING)
    public final String toAddr2;
    @ProtoField(label = Message.Label.REQUIRED, tag = 12, type = Message.Datatype.DOUBLE)
    public final Double toLat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 13, type = Message.Datatype.DOUBLE)
    public final Double toLng;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 21, type = Message.Datatype.UINT32)
    public final Integer voiceSize;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_FROMLAT = valueOf;
        DEFAULT_FROMLNG = valueOf;
        DEFAULT_TOLAT = valueOf;
        DEFAULT_TOLNG = valueOf;
        DEFAULT_REALTOLNG = valueOf;
        DEFAULT_REALTOLAT = valueOf;
        DEFAULT_COMBO_DISTANCE = valueOf;
    }

    public DriverOrderComingReq(String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, String str3, String str4, String str5, Double d, Double d2, Double d3, Double d4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, String str6, Integer num10, Integer num11, String str7, String str8, Integer num12, String str9, String str10, String str11, String str12, String str13, String str14, Integer num13, Integer num14, Integer num15, Integer num16, Double d5, Double d6, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, String str15, Integer num22, String str16, String str17, Integer num23, ByteString byteString, Integer num24, Integer num25, Integer num26, Double d7, Integer num27, Integer num28, Integer num29, Integer num30, String str18, String str19, Integer num31, String str20, Integer num32, List<CarPoolLocation> list, String str21, String str22, String str23, String str24, String str25, Integer num33, Long l, Integer num34, String str26) {
        this.oid = str;
        this.key = str2;
        this.type = num;
        this.input = num2;
        this.createTime = num3;
        this.setupTime = num4;
        this.distance = str3;
        this.from = str4;
        this.f36952to = str5;
        this.fromLat = d;
        this.fromLng = d2;
        this.toLat = d3;
        this.toLng = d4;
        this.tip = num5;
        this.bonus = num6;
        this.tWait = num7;
        this.tWaitMax = num8;
        this.exp = num9;
        this.playTxt = str6;
        this.timestamp = num10;
        this.voiceSize = num11;
        this.audioUrl = str7;
        this.phone = str8;
        this.disableTime = num12;
        this.fromAddr1 = str9;
        this.fromAddr2 = str10;
        this.toAddr1 = str11;
        this.toAddr2 = str12;
        this.extraInfo = str13;
        this.playTxt2 = str14;
        this.listenModel = num13;
        this.lastUpdate = num14;
        this.listenMethod = num15;
        this.realLimit = num16;
        this.realtoLng = d5;
        this.realtoLat = d6;
        this.preStart = num17;
        this.preEnd = num18;
        this.tWaitMax4look = num19;
        this.disableTime4look = num20;
        this.forcePlay = num21;
        this.exp2 = str15;
        this.on_board = num22;
        this.receive_level = str16;
        this.require_level_txt = str17;
        this.require_level = num23;
        this.send_info = byteString;
        this.combo_type = num24;
        this.combo_fee = num25;
        this.combo_time = num26;
        this.combo_distance = d7;
        this.order_source = num27;
        this.is_fastcar = num28;
        this.dynamic_price = num29;
        this.is_zhipai_order = num30;
        this.order_price = str18;
        this.order_float_price = str19;
        this.is_carpoll = num31;
        this.carpool_one_price = str20;
        this.carpool_passengernumber = num32;
        this.carpool_locations = immutableCopyOf(list);
        this.carpool_nickname = str21;
        this.carpool_headurl = str22;
        this.carpool_price = str23;
        this.carpool_price_key = str24;
        this.reward_show_content = str25;
        this.is_destination_hide = num33;
        this.dispatch_uuid = l;
        this.history_num = num34;
        this.push_token = str26;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DriverOrderComingReq(com.didi.sdk.protobuf.DriverOrderComingReq.Builder r74) {
        /*
            r73 = this;
            r0 = r74
            r1 = r73
            java.lang.String r2 = r0.oid
            java.lang.String r3 = r0.key
            java.lang.Integer r4 = r0.type
            java.lang.Integer r5 = r0.input
            java.lang.Integer r6 = r0.createTime
            java.lang.Integer r7 = r0.setupTime
            java.lang.String r8 = r0.distance
            java.lang.String r9 = r0.from
            java.lang.String r10 = r0.f36953to
            java.lang.Double r11 = r0.fromLat
            java.lang.Double r12 = r0.fromLng
            java.lang.Double r13 = r0.toLat
            java.lang.Double r14 = r0.toLng
            java.lang.Integer r15 = r0.tip
            r72 = r1
            java.lang.Integer r1 = r0.bonus
            r16 = r1
            java.lang.Integer r1 = r0.tWait
            r17 = r1
            java.lang.Integer r1 = r0.tWaitMax
            r18 = r1
            java.lang.Integer r1 = r0.exp
            r19 = r1
            java.lang.String r1 = r0.playTxt
            r20 = r1
            java.lang.Integer r1 = r0.timestamp
            r21 = r1
            java.lang.Integer r1 = r0.voiceSize
            r22 = r1
            java.lang.String r1 = r0.audioUrl
            r23 = r1
            java.lang.String r1 = r0.phone
            r24 = r1
            java.lang.Integer r1 = r0.disableTime
            r25 = r1
            java.lang.String r1 = r0.fromAddr1
            r26 = r1
            java.lang.String r1 = r0.fromAddr2
            r27 = r1
            java.lang.String r1 = r0.toAddr1
            r28 = r1
            java.lang.String r1 = r0.toAddr2
            r29 = r1
            java.lang.String r1 = r0.extraInfo
            r30 = r1
            java.lang.String r1 = r0.playTxt2
            r31 = r1
            java.lang.Integer r1 = r0.listenModel
            r32 = r1
            java.lang.Integer r1 = r0.lastUpdate
            r33 = r1
            java.lang.Integer r1 = r0.listenMethod
            r34 = r1
            java.lang.Integer r1 = r0.realLimit
            r35 = r1
            java.lang.Double r1 = r0.realtoLng
            r36 = r1
            java.lang.Double r1 = r0.realtoLat
            r37 = r1
            java.lang.Integer r1 = r0.preStart
            r38 = r1
            java.lang.Integer r1 = r0.preEnd
            r39 = r1
            java.lang.Integer r1 = r0.tWaitMax4look
            r40 = r1
            java.lang.Integer r1 = r0.disableTime4look
            r41 = r1
            java.lang.Integer r1 = r0.forcePlay
            r42 = r1
            java.lang.String r1 = r0.exp2
            r43 = r1
            java.lang.Integer r1 = r0.on_board
            r44 = r1
            java.lang.String r1 = r0.receive_level
            r45 = r1
            java.lang.String r1 = r0.require_level_txt
            r46 = r1
            java.lang.Integer r1 = r0.require_level
            r47 = r1
            okio.ByteString r1 = r0.send_info
            r48 = r1
            java.lang.Integer r1 = r0.combo_type
            r49 = r1
            java.lang.Integer r1 = r0.combo_fee
            r50 = r1
            java.lang.Integer r1 = r0.combo_time
            r51 = r1
            java.lang.Double r1 = r0.combo_distance
            r52 = r1
            java.lang.Integer r1 = r0.order_source
            r53 = r1
            java.lang.Integer r1 = r0.is_fastcar
            r54 = r1
            java.lang.Integer r1 = r0.dynamic_price
            r55 = r1
            java.lang.Integer r1 = r0.is_zhipai_order
            r56 = r1
            java.lang.String r1 = r0.order_price
            r57 = r1
            java.lang.String r1 = r0.order_float_price
            r58 = r1
            java.lang.Integer r1 = r0.is_carpoll
            r59 = r1
            java.lang.String r1 = r0.carpool_one_price
            r60 = r1
            java.lang.Integer r1 = r0.carpool_passengernumber
            r61 = r1
            java.util.List<com.didi.sdk.protobuf.CarPoolLocation> r1 = r0.carpool_locations
            r62 = r1
            java.lang.String r1 = r0.carpool_nickname
            r63 = r1
            java.lang.String r1 = r0.carpool_headurl
            r64 = r1
            java.lang.String r1 = r0.carpool_price
            r65 = r1
            java.lang.String r1 = r0.carpool_price_key
            r66 = r1
            java.lang.String r1 = r0.reward_show_content
            r67 = r1
            java.lang.Integer r1 = r0.is_destination_hide
            r68 = r1
            java.lang.Long r1 = r0.dispatch_uuid
            r69 = r1
            java.lang.Integer r1 = r0.history_num
            r70 = r1
            java.lang.String r1 = r0.push_token
            r71 = r1
            r1 = r72
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71)
            r73.setBuilder(r74)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.protobuf.DriverOrderComingReq.<init>(com.didi.sdk.protobuf.DriverOrderComingReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverOrderComingReq)) {
            return false;
        }
        DriverOrderComingReq driverOrderComingReq = (DriverOrderComingReq) obj;
        if (!equals((Object) this.oid, (Object) driverOrderComingReq.oid) || !equals((Object) this.key, (Object) driverOrderComingReq.key) || !equals((Object) this.type, (Object) driverOrderComingReq.type) || !equals((Object) this.input, (Object) driverOrderComingReq.input) || !equals((Object) this.createTime, (Object) driverOrderComingReq.createTime) || !equals((Object) this.setupTime, (Object) driverOrderComingReq.setupTime) || !equals((Object) this.distance, (Object) driverOrderComingReq.distance) || !equals((Object) this.from, (Object) driverOrderComingReq.from) || !equals((Object) this.f36952to, (Object) driverOrderComingReq.f36952to) || !equals((Object) this.fromLat, (Object) driverOrderComingReq.fromLat) || !equals((Object) this.fromLng, (Object) driverOrderComingReq.fromLng) || !equals((Object) this.toLat, (Object) driverOrderComingReq.toLat) || !equals((Object) this.toLng, (Object) driverOrderComingReq.toLng) || !equals((Object) this.tip, (Object) driverOrderComingReq.tip) || !equals((Object) this.bonus, (Object) driverOrderComingReq.bonus) || !equals((Object) this.tWait, (Object) driverOrderComingReq.tWait) || !equals((Object) this.tWaitMax, (Object) driverOrderComingReq.tWaitMax) || !equals((Object) this.exp, (Object) driverOrderComingReq.exp) || !equals((Object) this.playTxt, (Object) driverOrderComingReq.playTxt) || !equals((Object) this.timestamp, (Object) driverOrderComingReq.timestamp) || !equals((Object) this.voiceSize, (Object) driverOrderComingReq.voiceSize) || !equals((Object) this.audioUrl, (Object) driverOrderComingReq.audioUrl) || !equals((Object) this.phone, (Object) driverOrderComingReq.phone) || !equals((Object) this.disableTime, (Object) driverOrderComingReq.disableTime) || !equals((Object) this.fromAddr1, (Object) driverOrderComingReq.fromAddr1) || !equals((Object) this.fromAddr2, (Object) driverOrderComingReq.fromAddr2) || !equals((Object) this.toAddr1, (Object) driverOrderComingReq.toAddr1) || !equals((Object) this.toAddr2, (Object) driverOrderComingReq.toAddr2) || !equals((Object) this.extraInfo, (Object) driverOrderComingReq.extraInfo) || !equals((Object) this.playTxt2, (Object) driverOrderComingReq.playTxt2) || !equals((Object) this.listenModel, (Object) driverOrderComingReq.listenModel) || !equals((Object) this.lastUpdate, (Object) driverOrderComingReq.lastUpdate) || !equals((Object) this.listenMethod, (Object) driverOrderComingReq.listenMethod) || !equals((Object) this.realLimit, (Object) driverOrderComingReq.realLimit) || !equals((Object) this.realtoLng, (Object) driverOrderComingReq.realtoLng) || !equals((Object) this.realtoLat, (Object) driverOrderComingReq.realtoLat) || !equals((Object) this.preStart, (Object) driverOrderComingReq.preStart) || !equals((Object) this.preEnd, (Object) driverOrderComingReq.preEnd) || !equals((Object) this.tWaitMax4look, (Object) driverOrderComingReq.tWaitMax4look) || !equals((Object) this.disableTime4look, (Object) driverOrderComingReq.disableTime4look) || !equals((Object) this.forcePlay, (Object) driverOrderComingReq.forcePlay) || !equals((Object) this.exp2, (Object) driverOrderComingReq.exp2) || !equals((Object) this.on_board, (Object) driverOrderComingReq.on_board) || !equals((Object) this.receive_level, (Object) driverOrderComingReq.receive_level) || !equals((Object) this.require_level_txt, (Object) driverOrderComingReq.require_level_txt) || !equals((Object) this.require_level, (Object) driverOrderComingReq.require_level) || !equals((Object) this.send_info, (Object) driverOrderComingReq.send_info) || !equals((Object) this.combo_type, (Object) driverOrderComingReq.combo_type) || !equals((Object) this.combo_fee, (Object) driverOrderComingReq.combo_fee) || !equals((Object) this.combo_time, (Object) driverOrderComingReq.combo_time) || !equals((Object) this.combo_distance, (Object) driverOrderComingReq.combo_distance) || !equals((Object) this.order_source, (Object) driverOrderComingReq.order_source) || !equals((Object) this.is_fastcar, (Object) driverOrderComingReq.is_fastcar) || !equals((Object) this.dynamic_price, (Object) driverOrderComingReq.dynamic_price) || !equals((Object) this.is_zhipai_order, (Object) driverOrderComingReq.is_zhipai_order) || !equals((Object) this.order_price, (Object) driverOrderComingReq.order_price) || !equals((Object) this.order_float_price, (Object) driverOrderComingReq.order_float_price) || !equals((Object) this.is_carpoll, (Object) driverOrderComingReq.is_carpoll) || !equals((Object) this.carpool_one_price, (Object) driverOrderComingReq.carpool_one_price) || !equals((Object) this.carpool_passengernumber, (Object) driverOrderComingReq.carpool_passengernumber) || !equals((List<?>) this.carpool_locations, (List<?>) driverOrderComingReq.carpool_locations) || !equals((Object) this.carpool_nickname, (Object) driverOrderComingReq.carpool_nickname) || !equals((Object) this.carpool_headurl, (Object) driverOrderComingReq.carpool_headurl) || !equals((Object) this.carpool_price, (Object) driverOrderComingReq.carpool_price) || !equals((Object) this.carpool_price_key, (Object) driverOrderComingReq.carpool_price_key) || !equals((Object) this.reward_show_content, (Object) driverOrderComingReq.reward_show_content) || !equals((Object) this.is_destination_hide, (Object) driverOrderComingReq.is_destination_hide) || !equals((Object) this.dispatch_uuid, (Object) driverOrderComingReq.dispatch_uuid) || !equals((Object) this.history_num, (Object) driverOrderComingReq.history_num) || !equals((Object) this.push_token, (Object) driverOrderComingReq.push_token)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.oid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.key;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.input;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.createTime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.setupTime;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str3 = this.distance;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.from;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.f36952to;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Double d = this.fromLat;
        int hashCode10 = (hashCode9 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.fromLng;
        int hashCode11 = (hashCode10 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.toLat;
        int hashCode12 = (hashCode11 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Double d4 = this.toLng;
        int hashCode13 = (hashCode12 + (d4 != null ? d4.hashCode() : 0)) * 37;
        Integer num5 = this.tip;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.bonus;
        int hashCode15 = (hashCode14 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.tWait;
        int hashCode16 = (hashCode15 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.tWaitMax;
        int hashCode17 = (hashCode16 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.exp;
        int hashCode18 = (hashCode17 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str6 = this.playTxt;
        int hashCode19 = (hashCode18 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num10 = this.timestamp;
        int hashCode20 = (hashCode19 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.voiceSize;
        int hashCode21 = (hashCode20 + (num11 != null ? num11.hashCode() : 0)) * 37;
        String str7 = this.audioUrl;
        int hashCode22 = (hashCode21 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.phone;
        int hashCode23 = (hashCode22 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num12 = this.disableTime;
        int hashCode24 = (hashCode23 + (num12 != null ? num12.hashCode() : 0)) * 37;
        String str9 = this.fromAddr1;
        int hashCode25 = (hashCode24 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.fromAddr2;
        int hashCode26 = (hashCode25 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.toAddr1;
        int hashCode27 = (hashCode26 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.toAddr2;
        int hashCode28 = (hashCode27 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.extraInfo;
        int hashCode29 = (hashCode28 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.playTxt2;
        int hashCode30 = (hashCode29 + (str14 != null ? str14.hashCode() : 0)) * 37;
        Integer num13 = this.listenModel;
        int hashCode31 = (hashCode30 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.lastUpdate;
        int hashCode32 = (hashCode31 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.listenMethod;
        int hashCode33 = (hashCode32 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.realLimit;
        int hashCode34 = (hashCode33 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Double d5 = this.realtoLng;
        int hashCode35 = (hashCode34 + (d5 != null ? d5.hashCode() : 0)) * 37;
        Double d6 = this.realtoLat;
        int hashCode36 = (hashCode35 + (d6 != null ? d6.hashCode() : 0)) * 37;
        Integer num17 = this.preStart;
        int hashCode37 = (hashCode36 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Integer num18 = this.preEnd;
        int hashCode38 = (hashCode37 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Integer num19 = this.tWaitMax4look;
        int hashCode39 = (hashCode38 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Integer num20 = this.disableTime4look;
        int hashCode40 = (hashCode39 + (num20 != null ? num20.hashCode() : 0)) * 37;
        Integer num21 = this.forcePlay;
        int hashCode41 = (hashCode40 + (num21 != null ? num21.hashCode() : 0)) * 37;
        String str15 = this.exp2;
        int hashCode42 = (hashCode41 + (str15 != null ? str15.hashCode() : 0)) * 37;
        Integer num22 = this.on_board;
        int hashCode43 = (hashCode42 + (num22 != null ? num22.hashCode() : 0)) * 37;
        String str16 = this.receive_level;
        int hashCode44 = (hashCode43 + (str16 != null ? str16.hashCode() : 0)) * 37;
        String str17 = this.require_level_txt;
        int hashCode45 = (hashCode44 + (str17 != null ? str17.hashCode() : 0)) * 37;
        Integer num23 = this.require_level;
        int hashCode46 = (hashCode45 + (num23 != null ? num23.hashCode() : 0)) * 37;
        ByteString byteString = this.send_info;
        int hashCode47 = (hashCode46 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        Integer num24 = this.combo_type;
        int hashCode48 = (hashCode47 + (num24 != null ? num24.hashCode() : 0)) * 37;
        Integer num25 = this.combo_fee;
        int hashCode49 = (hashCode48 + (num25 != null ? num25.hashCode() : 0)) * 37;
        Integer num26 = this.combo_time;
        int hashCode50 = (hashCode49 + (num26 != null ? num26.hashCode() : 0)) * 37;
        Double d7 = this.combo_distance;
        int hashCode51 = (hashCode50 + (d7 != null ? d7.hashCode() : 0)) * 37;
        Integer num27 = this.order_source;
        int hashCode52 = (hashCode51 + (num27 != null ? num27.hashCode() : 0)) * 37;
        Integer num28 = this.is_fastcar;
        int hashCode53 = (hashCode52 + (num28 != null ? num28.hashCode() : 0)) * 37;
        Integer num29 = this.dynamic_price;
        int hashCode54 = (hashCode53 + (num29 != null ? num29.hashCode() : 0)) * 37;
        Integer num30 = this.is_zhipai_order;
        int hashCode55 = (hashCode54 + (num30 != null ? num30.hashCode() : 0)) * 37;
        String str18 = this.order_price;
        int hashCode56 = (hashCode55 + (str18 != null ? str18.hashCode() : 0)) * 37;
        String str19 = this.order_float_price;
        int hashCode57 = (hashCode56 + (str19 != null ? str19.hashCode() : 0)) * 37;
        Integer num31 = this.is_carpoll;
        int hashCode58 = (hashCode57 + (num31 != null ? num31.hashCode() : 0)) * 37;
        String str20 = this.carpool_one_price;
        int hashCode59 = (hashCode58 + (str20 != null ? str20.hashCode() : 0)) * 37;
        Integer num32 = this.carpool_passengernumber;
        int hashCode60 = (hashCode59 + (num32 != null ? num32.hashCode() : 0)) * 37;
        List<CarPoolLocation> list = this.carpool_locations;
        int hashCode61 = (hashCode60 + (list != null ? list.hashCode() : 1)) * 37;
        String str21 = this.carpool_nickname;
        int hashCode62 = (hashCode61 + (str21 != null ? str21.hashCode() : 0)) * 37;
        String str22 = this.carpool_headurl;
        int hashCode63 = (hashCode62 + (str22 != null ? str22.hashCode() : 0)) * 37;
        String str23 = this.carpool_price;
        int hashCode64 = (hashCode63 + (str23 != null ? str23.hashCode() : 0)) * 37;
        String str24 = this.carpool_price_key;
        int hashCode65 = (hashCode64 + (str24 != null ? str24.hashCode() : 0)) * 37;
        String str25 = this.reward_show_content;
        int hashCode66 = (hashCode65 + (str25 != null ? str25.hashCode() : 0)) * 37;
        Integer num33 = this.is_destination_hide;
        int hashCode67 = (hashCode66 + (num33 != null ? num33.hashCode() : 0)) * 37;
        Long l = this.dispatch_uuid;
        int hashCode68 = (hashCode67 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num34 = this.history_num;
        int hashCode69 = (hashCode68 + (num34 != null ? num34.hashCode() : 0)) * 37;
        String str26 = this.push_token;
        if (str26 != null) {
            i2 = str26.hashCode();
        }
        int i3 = hashCode69 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverOrderComingReq> {
        public String audioUrl;
        public Integer bonus;
        public String carpool_headurl;
        public List<CarPoolLocation> carpool_locations;
        public String carpool_nickname;
        public String carpool_one_price;
        public Integer carpool_passengernumber;
        public String carpool_price;
        public String carpool_price_key;
        public Double combo_distance;
        public Integer combo_fee;
        public Integer combo_time;
        public Integer combo_type;
        public Integer createTime;
        public Integer disableTime;
        public Integer disableTime4look;
        public Long dispatch_uuid;
        public String distance;
        public Integer dynamic_price;
        public Integer exp;
        public String exp2;
        public String extraInfo;
        public Integer forcePlay;
        public String from;
        public String fromAddr1;
        public String fromAddr2;
        public Double fromLat;
        public Double fromLng;
        public Integer history_num;
        public Integer input;
        public Integer is_carpoll;
        public Integer is_destination_hide;
        public Integer is_fastcar;
        public Integer is_zhipai_order;
        public String key;
        public Integer lastUpdate;
        public Integer listenMethod;
        public Integer listenModel;
        public String oid;
        public Integer on_board;
        public String order_float_price;
        public String order_price;
        public Integer order_source;
        public String phone;
        public String playTxt;
        public String playTxt2;
        public Integer preEnd;
        public Integer preStart;
        public String push_token;
        public Integer realLimit;
        public Double realtoLat;
        public Double realtoLng;
        public String receive_level;
        public Integer require_level;
        public String require_level_txt;
        public String reward_show_content;
        public ByteString send_info;
        public Integer setupTime;
        public Integer tWait;
        public Integer tWaitMax;
        public Integer tWaitMax4look;
        public Integer timestamp;
        public Integer tip;

        /* renamed from: to */
        public String f36953to;
        public String toAddr1;
        public String toAddr2;
        public Double toLat;
        public Double toLng;
        public Integer type;
        public Integer voiceSize;

        public Builder() {
        }

        public Builder(DriverOrderComingReq driverOrderComingReq) {
            super(driverOrderComingReq);
            if (driverOrderComingReq != null) {
                this.oid = driverOrderComingReq.oid;
                this.key = driverOrderComingReq.key;
                this.type = driverOrderComingReq.type;
                this.input = driverOrderComingReq.input;
                this.createTime = driverOrderComingReq.createTime;
                this.setupTime = driverOrderComingReq.setupTime;
                this.distance = driverOrderComingReq.distance;
                this.from = driverOrderComingReq.from;
                this.f36953to = driverOrderComingReq.f36952to;
                this.fromLat = driverOrderComingReq.fromLat;
                this.fromLng = driverOrderComingReq.fromLng;
                this.toLat = driverOrderComingReq.toLat;
                this.toLng = driverOrderComingReq.toLng;
                this.tip = driverOrderComingReq.tip;
                this.bonus = driverOrderComingReq.bonus;
                this.tWait = driverOrderComingReq.tWait;
                this.tWaitMax = driverOrderComingReq.tWaitMax;
                this.exp = driverOrderComingReq.exp;
                this.playTxt = driverOrderComingReq.playTxt;
                this.timestamp = driverOrderComingReq.timestamp;
                this.voiceSize = driverOrderComingReq.voiceSize;
                this.audioUrl = driverOrderComingReq.audioUrl;
                this.phone = driverOrderComingReq.phone;
                this.disableTime = driverOrderComingReq.disableTime;
                this.fromAddr1 = driverOrderComingReq.fromAddr1;
                this.fromAddr2 = driverOrderComingReq.fromAddr2;
                this.toAddr1 = driverOrderComingReq.toAddr1;
                this.toAddr2 = driverOrderComingReq.toAddr2;
                this.extraInfo = driverOrderComingReq.extraInfo;
                this.playTxt2 = driverOrderComingReq.playTxt2;
                this.listenModel = driverOrderComingReq.listenModel;
                this.lastUpdate = driverOrderComingReq.lastUpdate;
                this.listenMethod = driverOrderComingReq.listenMethod;
                this.realLimit = driverOrderComingReq.realLimit;
                this.realtoLng = driverOrderComingReq.realtoLng;
                this.realtoLat = driverOrderComingReq.realtoLat;
                this.preStart = driverOrderComingReq.preStart;
                this.preEnd = driverOrderComingReq.preEnd;
                this.tWaitMax4look = driverOrderComingReq.tWaitMax4look;
                this.disableTime4look = driverOrderComingReq.disableTime4look;
                this.forcePlay = driverOrderComingReq.forcePlay;
                this.exp2 = driverOrderComingReq.exp2;
                this.on_board = driverOrderComingReq.on_board;
                this.receive_level = driverOrderComingReq.receive_level;
                this.require_level_txt = driverOrderComingReq.require_level_txt;
                this.require_level = driverOrderComingReq.require_level;
                this.send_info = driverOrderComingReq.send_info;
                this.combo_type = driverOrderComingReq.combo_type;
                this.combo_fee = driverOrderComingReq.combo_fee;
                this.combo_time = driverOrderComingReq.combo_time;
                this.combo_distance = driverOrderComingReq.combo_distance;
                this.order_source = driverOrderComingReq.order_source;
                this.is_fastcar = driverOrderComingReq.is_fastcar;
                this.dynamic_price = driverOrderComingReq.dynamic_price;
                this.is_zhipai_order = driverOrderComingReq.is_zhipai_order;
                this.order_price = driverOrderComingReq.order_price;
                this.order_float_price = driverOrderComingReq.order_float_price;
                this.is_carpoll = driverOrderComingReq.is_carpoll;
                this.carpool_one_price = driverOrderComingReq.carpool_one_price;
                this.carpool_passengernumber = driverOrderComingReq.carpool_passengernumber;
                this.carpool_locations = DriverOrderComingReq.copyOf(driverOrderComingReq.carpool_locations);
                this.carpool_nickname = driverOrderComingReq.carpool_nickname;
                this.carpool_headurl = driverOrderComingReq.carpool_headurl;
                this.carpool_price = driverOrderComingReq.carpool_price;
                this.carpool_price_key = driverOrderComingReq.carpool_price_key;
                this.reward_show_content = driverOrderComingReq.reward_show_content;
                this.is_destination_hide = driverOrderComingReq.is_destination_hide;
                this.dispatch_uuid = driverOrderComingReq.dispatch_uuid;
                this.history_num = driverOrderComingReq.history_num;
                this.push_token = driverOrderComingReq.push_token;
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder input(Integer num) {
            this.input = num;
            return this;
        }

        public Builder createTime(Integer num) {
            this.createTime = num;
            return this;
        }

        public Builder setupTime(Integer num) {
            this.setupTime = num;
            return this;
        }

        public Builder distance(String str) {
            this.distance = str;
            return this;
        }

        public Builder from(String str) {
            this.from = str;
            return this;
        }

        /* renamed from: to */
        public Builder mo94544to(String str) {
            this.f36953to = str;
            return this;
        }

        public Builder fromLat(Double d) {
            this.fromLat = d;
            return this;
        }

        public Builder fromLng(Double d) {
            this.fromLng = d;
            return this;
        }

        public Builder toLat(Double d) {
            this.toLat = d;
            return this;
        }

        public Builder toLng(Double d) {
            this.toLng = d;
            return this;
        }

        public Builder tip(Integer num) {
            this.tip = num;
            return this;
        }

        public Builder bonus(Integer num) {
            this.bonus = num;
            return this;
        }

        public Builder tWait(Integer num) {
            this.tWait = num;
            return this;
        }

        public Builder tWaitMax(Integer num) {
            this.tWaitMax = num;
            return this;
        }

        public Builder exp(Integer num) {
            this.exp = num;
            return this;
        }

        public Builder playTxt(String str) {
            this.playTxt = str;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder voiceSize(Integer num) {
            this.voiceSize = num;
            return this;
        }

        public Builder audioUrl(String str) {
            this.audioUrl = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder disableTime(Integer num) {
            this.disableTime = num;
            return this;
        }

        public Builder fromAddr1(String str) {
            this.fromAddr1 = str;
            return this;
        }

        public Builder fromAddr2(String str) {
            this.fromAddr2 = str;
            return this;
        }

        public Builder toAddr1(String str) {
            this.toAddr1 = str;
            return this;
        }

        public Builder toAddr2(String str) {
            this.toAddr2 = str;
            return this;
        }

        public Builder extraInfo(String str) {
            this.extraInfo = str;
            return this;
        }

        public Builder playTxt2(String str) {
            this.playTxt2 = str;
            return this;
        }

        public Builder listenModel(Integer num) {
            this.listenModel = num;
            return this;
        }

        public Builder lastUpdate(Integer num) {
            this.lastUpdate = num;
            return this;
        }

        public Builder listenMethod(Integer num) {
            this.listenMethod = num;
            return this;
        }

        public Builder realLimit(Integer num) {
            this.realLimit = num;
            return this;
        }

        public Builder realtoLng(Double d) {
            this.realtoLng = d;
            return this;
        }

        public Builder realtoLat(Double d) {
            this.realtoLat = d;
            return this;
        }

        public Builder preStart(Integer num) {
            this.preStart = num;
            return this;
        }

        public Builder preEnd(Integer num) {
            this.preEnd = num;
            return this;
        }

        public Builder tWaitMax4look(Integer num) {
            this.tWaitMax4look = num;
            return this;
        }

        public Builder disableTime4look(Integer num) {
            this.disableTime4look = num;
            return this;
        }

        public Builder forcePlay(Integer num) {
            this.forcePlay = num;
            return this;
        }

        public Builder exp2(String str) {
            this.exp2 = str;
            return this;
        }

        public Builder on_board(Integer num) {
            this.on_board = num;
            return this;
        }

        public Builder receive_level(String str) {
            this.receive_level = str;
            return this;
        }

        public Builder require_level_txt(String str) {
            this.require_level_txt = str;
            return this;
        }

        public Builder require_level(Integer num) {
            this.require_level = num;
            return this;
        }

        public Builder send_info(ByteString byteString) {
            this.send_info = byteString;
            return this;
        }

        public Builder combo_type(Integer num) {
            this.combo_type = num;
            return this;
        }

        public Builder combo_fee(Integer num) {
            this.combo_fee = num;
            return this;
        }

        public Builder combo_time(Integer num) {
            this.combo_time = num;
            return this;
        }

        public Builder combo_distance(Double d) {
            this.combo_distance = d;
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

        public Builder dynamic_price(Integer num) {
            this.dynamic_price = num;
            return this;
        }

        public Builder is_zhipai_order(Integer num) {
            this.is_zhipai_order = num;
            return this;
        }

        public Builder order_price(String str) {
            this.order_price = str;
            return this;
        }

        public Builder order_float_price(String str) {
            this.order_float_price = str;
            return this;
        }

        public Builder is_carpoll(Integer num) {
            this.is_carpoll = num;
            return this;
        }

        public Builder carpool_one_price(String str) {
            this.carpool_one_price = str;
            return this;
        }

        public Builder carpool_passengernumber(Integer num) {
            this.carpool_passengernumber = num;
            return this;
        }

        public Builder carpool_locations(List<CarPoolLocation> list) {
            this.carpool_locations = checkForNulls(list);
            return this;
        }

        public Builder carpool_nickname(String str) {
            this.carpool_nickname = str;
            return this;
        }

        public Builder carpool_headurl(String str) {
            this.carpool_headurl = str;
            return this;
        }

        public Builder carpool_price(String str) {
            this.carpool_price = str;
            return this;
        }

        public Builder carpool_price_key(String str) {
            this.carpool_price_key = str;
            return this;
        }

        public Builder reward_show_content(String str) {
            this.reward_show_content = str;
            return this;
        }

        public Builder is_destination_hide(Integer num) {
            this.is_destination_hide = num;
            return this;
        }

        public Builder dispatch_uuid(Long l) {
            this.dispatch_uuid = l;
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

        public DriverOrderComingReq build() {
            checkRequiredFields();
            return new DriverOrderComingReq(this);
        }
    }

    public enum OnBoardType implements ProtoEnum {
        kOnBoardTypeFree(0),
        kOnBoardTypeLoad(1),
        kOnBoardTypeOldV(2);
        
        private final int value;

        private OnBoardType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
