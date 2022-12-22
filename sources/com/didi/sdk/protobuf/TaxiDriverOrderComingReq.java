package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public final class TaxiDriverOrderComingReq extends Message {
    public static final Integer DEFAULT_ASSIGNSTATUS = 0;
    public static final Integer DEFAULT_AUTO_GRAB_FLAG = 0;
    public static final String DEFAULT_BROADCASTID = "";
    public static final Integer DEFAULT_BUSY = 0;
    public static final Integer DEFAULT_CARPOOL = 0;
    public static final Integer DEFAULT_FASTCAR_SW = 0;
    public static final Integer DEFAULT_FIRSTARRIVEORDER = 0;
    public static final Integer DEFAULT_FIRSTPICKORDER = 0;
    public static final Integer DEFAULT_FORCEPLAY = 0;
    public static final Integer DEFAULT_GOHOME = 0;
    public static final Boolean DEFAULT_ISENABLECARSHARINGMODE = false;
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_LISTENNEARHOME = 0;
    public static final Integer DEFAULT_ONBOARD = 0;
    public static final Integer DEFAULT_ORDERMODE = 0;
    public static final Integer DEFAULT_ORDERPATTERN = 0;
    public static final List<TaxiOrder> DEFAULT_ORDERS = Collections.emptyList();
    public static final Integer DEFAULT_PREFERDISTANCE = 0;
    public static final Double DEFAULT_PREFERLATITUDE;
    public static final Double DEFAULT_PREFERLONGITUDE;
    public static final Long DEFAULT_PREFERSTARTTIME = 0L;
    public static final Long DEFAULT_PREFERTOTIME = 0L;
    public static final ByteString DEFAULT_SENDINFO = ByteString.EMPTY;
    public static final String DEFAULT_TEXT = "";
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer assignStatus;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer auto_grab_flag;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String broadcastId;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer busy;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer carpool;
    @ProtoField(tag = 4)
    public final TaxiExtraInfo extraInfo;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer fastcar_sw;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer firstArriveOrder;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer firstPickOrder;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer forcePlay;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer goHome;
    @ProtoField(tag = 16, type = Message.Datatype.BOOL)
    public final Boolean isEnableCarSharingMode;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String key;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer listenNearHome;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer onBoard;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer orderMode;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer orderPattern;
    @ProtoField(label = Message.Label.REPEATED, messageType = TaxiOrder.class, tag = 5)
    public final List<TaxiOrder> orders;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer preferDistance;
    @ProtoField(tag = 11, type = Message.Datatype.DOUBLE)
    public final Double preferLatitude;
    @ProtoField(tag = 10, type = Message.Datatype.DOUBLE)
    public final Double preferLongitude;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long preferStartTime;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long preferToTime;
    @ProtoField(tag = 15, type = Message.Datatype.BYTES)
    public final ByteString sendInfo;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(tag = 6)
    public final TaxiTimeout timeout;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_PREFERLONGITUDE = valueOf;
        DEFAULT_PREFERLATITUDE = valueOf;
    }

    public TaxiDriverOrderComingReq(String str, Integer num, String str2, TaxiExtraInfo taxiExtraInfo, List<TaxiOrder> list, TaxiTimeout taxiTimeout, Integer num2, Integer num3, Integer num4, Double d, Double d2, Long l, Long l2, Integer num5, ByteString byteString, Boolean bool, Integer num6, Integer num7, String str3, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15) {
        this.broadcastId = str;
        this.type = num;
        this.text = str2;
        this.extraInfo = taxiExtraInfo;
        this.orders = immutableCopyOf(list);
        this.timeout = taxiTimeout;
        this.orderMode = num2;
        this.orderPattern = num3;
        this.preferDistance = num4;
        this.preferLongitude = d;
        this.preferLatitude = d2;
        this.preferStartTime = l;
        this.preferToTime = l2;
        this.onBoard = num5;
        this.sendInfo = byteString;
        this.isEnableCarSharingMode = bool;
        this.forcePlay = num6;
        this.firstArriveOrder = num7;
        this.key = str3;
        this.firstPickOrder = num8;
        this.listenNearHome = num9;
        this.goHome = num10;
        this.busy = num11;
        this.assignStatus = num12;
        this.carpool = num13;
        this.fastcar_sw = num14;
        this.auto_grab_flag = num15;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TaxiDriverOrderComingReq(com.didi.sdk.protobuf.TaxiDriverOrderComingReq.Builder r31) {
        /*
            r30 = this;
            r0 = r31
            r1 = r30
            java.lang.String r2 = r0.broadcastId
            java.lang.Integer r3 = r0.type
            java.lang.String r4 = r0.text
            com.didi.sdk.protobuf.TaxiExtraInfo r5 = r0.extraInfo
            java.util.List<com.didi.sdk.protobuf.TaxiOrder> r6 = r0.orders
            com.didi.sdk.protobuf.TaxiTimeout r7 = r0.timeout
            java.lang.Integer r8 = r0.orderMode
            java.lang.Integer r9 = r0.orderPattern
            java.lang.Integer r10 = r0.preferDistance
            java.lang.Double r11 = r0.preferLongitude
            java.lang.Double r12 = r0.preferLatitude
            java.lang.Long r13 = r0.preferStartTime
            java.lang.Long r14 = r0.preferToTime
            java.lang.Integer r15 = r0.onBoard
            r29 = r1
            okio.ByteString r1 = r0.sendInfo
            r16 = r1
            java.lang.Boolean r1 = r0.isEnableCarSharingMode
            r17 = r1
            java.lang.Integer r1 = r0.forcePlay
            r18 = r1
            java.lang.Integer r1 = r0.firstArriveOrder
            r19 = r1
            java.lang.String r1 = r0.key
            r20 = r1
            java.lang.Integer r1 = r0.firstPickOrder
            r21 = r1
            java.lang.Integer r1 = r0.listenNearHome
            r22 = r1
            java.lang.Integer r1 = r0.goHome
            r23 = r1
            java.lang.Integer r1 = r0.busy
            r24 = r1
            java.lang.Integer r1 = r0.assignStatus
            r25 = r1
            java.lang.Integer r1 = r0.carpool
            r26 = r1
            java.lang.Integer r1 = r0.fastcar_sw
            r27 = r1
            java.lang.Integer r1 = r0.auto_grab_flag
            r28 = r1
            r1 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r30.setBuilder(r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.protobuf.TaxiDriverOrderComingReq.<init>(com.didi.sdk.protobuf.TaxiDriverOrderComingReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiDriverOrderComingReq)) {
            return false;
        }
        TaxiDriverOrderComingReq taxiDriverOrderComingReq = (TaxiDriverOrderComingReq) obj;
        if (!equals((Object) this.broadcastId, (Object) taxiDriverOrderComingReq.broadcastId) || !equals((Object) this.type, (Object) taxiDriverOrderComingReq.type) || !equals((Object) this.text, (Object) taxiDriverOrderComingReq.text) || !equals((Object) this.extraInfo, (Object) taxiDriverOrderComingReq.extraInfo) || !equals((List<?>) this.orders, (List<?>) taxiDriverOrderComingReq.orders) || !equals((Object) this.timeout, (Object) taxiDriverOrderComingReq.timeout) || !equals((Object) this.orderMode, (Object) taxiDriverOrderComingReq.orderMode) || !equals((Object) this.orderPattern, (Object) taxiDriverOrderComingReq.orderPattern) || !equals((Object) this.preferDistance, (Object) taxiDriverOrderComingReq.preferDistance) || !equals((Object) this.preferLongitude, (Object) taxiDriverOrderComingReq.preferLongitude) || !equals((Object) this.preferLatitude, (Object) taxiDriverOrderComingReq.preferLatitude) || !equals((Object) this.preferStartTime, (Object) taxiDriverOrderComingReq.preferStartTime) || !equals((Object) this.preferToTime, (Object) taxiDriverOrderComingReq.preferToTime) || !equals((Object) this.onBoard, (Object) taxiDriverOrderComingReq.onBoard) || !equals((Object) this.sendInfo, (Object) taxiDriverOrderComingReq.sendInfo) || !equals((Object) this.isEnableCarSharingMode, (Object) taxiDriverOrderComingReq.isEnableCarSharingMode) || !equals((Object) this.forcePlay, (Object) taxiDriverOrderComingReq.forcePlay) || !equals((Object) this.firstArriveOrder, (Object) taxiDriverOrderComingReq.firstArriveOrder) || !equals((Object) this.key, (Object) taxiDriverOrderComingReq.key) || !equals((Object) this.firstPickOrder, (Object) taxiDriverOrderComingReq.firstPickOrder) || !equals((Object) this.listenNearHome, (Object) taxiDriverOrderComingReq.listenNearHome) || !equals((Object) this.goHome, (Object) taxiDriverOrderComingReq.goHome) || !equals((Object) this.busy, (Object) taxiDriverOrderComingReq.busy) || !equals((Object) this.assignStatus, (Object) taxiDriverOrderComingReq.assignStatus) || !equals((Object) this.carpool, (Object) taxiDriverOrderComingReq.carpool) || !equals((Object) this.fastcar_sw, (Object) taxiDriverOrderComingReq.fastcar_sw) || !equals((Object) this.auto_grab_flag, (Object) taxiDriverOrderComingReq.auto_grab_flag)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.broadcastId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.text;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        TaxiExtraInfo taxiExtraInfo = this.extraInfo;
        int hashCode4 = (hashCode3 + (taxiExtraInfo != null ? taxiExtraInfo.hashCode() : 0)) * 37;
        List<TaxiOrder> list = this.orders;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        TaxiTimeout taxiTimeout = this.timeout;
        int hashCode6 = (hashCode5 + (taxiTimeout != null ? taxiTimeout.hashCode() : 0)) * 37;
        Integer num2 = this.orderMode;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.orderPattern;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.preferDistance;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Double d = this.preferLongitude;
        int hashCode10 = (hashCode9 + (d != null ? d.hashCode() : 0)) * 37;
        Double d2 = this.preferLatitude;
        int hashCode11 = (hashCode10 + (d2 != null ? d2.hashCode() : 0)) * 37;
        Long l = this.preferStartTime;
        int hashCode12 = (hashCode11 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.preferToTime;
        int hashCode13 = (hashCode12 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num5 = this.onBoard;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        ByteString byteString = this.sendInfo;
        int hashCode15 = (hashCode14 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        Boolean bool = this.isEnableCarSharingMode;
        int hashCode16 = (hashCode15 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num6 = this.forcePlay;
        int hashCode17 = (hashCode16 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.firstArriveOrder;
        int hashCode18 = (hashCode17 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str3 = this.key;
        int hashCode19 = (hashCode18 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num8 = this.firstPickOrder;
        int hashCode20 = (hashCode19 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.listenNearHome;
        int hashCode21 = (hashCode20 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.goHome;
        int hashCode22 = (hashCode21 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.busy;
        int hashCode23 = (hashCode22 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.assignStatus;
        int hashCode24 = (hashCode23 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.carpool;
        int hashCode25 = (hashCode24 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.fastcar_sw;
        int hashCode26 = (hashCode25 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.auto_grab_flag;
        if (num15 != null) {
            i2 = num15.hashCode();
        }
        int i3 = hashCode26 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiDriverOrderComingReq> {
        public Integer assignStatus;
        public Integer auto_grab_flag;
        public String broadcastId;
        public Integer busy;
        public Integer carpool;
        public TaxiExtraInfo extraInfo;
        public Integer fastcar_sw;
        public Integer firstArriveOrder;
        public Integer firstPickOrder;
        public Integer forcePlay;
        public Integer goHome;
        public Boolean isEnableCarSharingMode;
        public String key;
        public Integer listenNearHome;
        public Integer onBoard;
        public Integer orderMode;
        public Integer orderPattern;
        public List<TaxiOrder> orders;
        public Integer preferDistance;
        public Double preferLatitude;
        public Double preferLongitude;
        public Long preferStartTime;
        public Long preferToTime;
        public ByteString sendInfo;
        public String text;
        public TaxiTimeout timeout;
        public Integer type;

        public Builder() {
        }

        public Builder(TaxiDriverOrderComingReq taxiDriverOrderComingReq) {
            super(taxiDriverOrderComingReq);
            if (taxiDriverOrderComingReq != null) {
                this.broadcastId = taxiDriverOrderComingReq.broadcastId;
                this.type = taxiDriverOrderComingReq.type;
                this.text = taxiDriverOrderComingReq.text;
                this.extraInfo = taxiDriverOrderComingReq.extraInfo;
                this.orders = TaxiDriverOrderComingReq.copyOf(taxiDriverOrderComingReq.orders);
                this.timeout = taxiDriverOrderComingReq.timeout;
                this.orderMode = taxiDriverOrderComingReq.orderMode;
                this.orderPattern = taxiDriverOrderComingReq.orderPattern;
                this.preferDistance = taxiDriverOrderComingReq.preferDistance;
                this.preferLongitude = taxiDriverOrderComingReq.preferLongitude;
                this.preferLatitude = taxiDriverOrderComingReq.preferLatitude;
                this.preferStartTime = taxiDriverOrderComingReq.preferStartTime;
                this.preferToTime = taxiDriverOrderComingReq.preferToTime;
                this.onBoard = taxiDriverOrderComingReq.onBoard;
                this.sendInfo = taxiDriverOrderComingReq.sendInfo;
                this.isEnableCarSharingMode = taxiDriverOrderComingReq.isEnableCarSharingMode;
                this.forcePlay = taxiDriverOrderComingReq.forcePlay;
                this.firstArriveOrder = taxiDriverOrderComingReq.firstArriveOrder;
                this.key = taxiDriverOrderComingReq.key;
                this.firstPickOrder = taxiDriverOrderComingReq.firstPickOrder;
                this.listenNearHome = taxiDriverOrderComingReq.listenNearHome;
                this.goHome = taxiDriverOrderComingReq.goHome;
                this.busy = taxiDriverOrderComingReq.busy;
                this.assignStatus = taxiDriverOrderComingReq.assignStatus;
                this.carpool = taxiDriverOrderComingReq.carpool;
                this.fastcar_sw = taxiDriverOrderComingReq.fastcar_sw;
                this.auto_grab_flag = taxiDriverOrderComingReq.auto_grab_flag;
            }
        }

        public Builder broadcastId(String str) {
            this.broadcastId = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public Builder extraInfo(TaxiExtraInfo taxiExtraInfo) {
            this.extraInfo = taxiExtraInfo;
            return this;
        }

        public Builder orders(List<TaxiOrder> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public Builder timeout(TaxiTimeout taxiTimeout) {
            this.timeout = taxiTimeout;
            return this;
        }

        public Builder orderMode(Integer num) {
            this.orderMode = num;
            return this;
        }

        public Builder orderPattern(Integer num) {
            this.orderPattern = num;
            return this;
        }

        public Builder preferDistance(Integer num) {
            this.preferDistance = num;
            return this;
        }

        public Builder preferLongitude(Double d) {
            this.preferLongitude = d;
            return this;
        }

        public Builder preferLatitude(Double d) {
            this.preferLatitude = d;
            return this;
        }

        public Builder preferStartTime(Long l) {
            this.preferStartTime = l;
            return this;
        }

        public Builder preferToTime(Long l) {
            this.preferToTime = l;
            return this;
        }

        public Builder onBoard(Integer num) {
            this.onBoard = num;
            return this;
        }

        public Builder sendInfo(ByteString byteString) {
            this.sendInfo = byteString;
            return this;
        }

        public Builder isEnableCarSharingMode(Boolean bool) {
            this.isEnableCarSharingMode = bool;
            return this;
        }

        public Builder forcePlay(Integer num) {
            this.forcePlay = num;
            return this;
        }

        public Builder firstArriveOrder(Integer num) {
            this.firstArriveOrder = num;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder firstPickOrder(Integer num) {
            this.firstPickOrder = num;
            return this;
        }

        public Builder listenNearHome(Integer num) {
            this.listenNearHome = num;
            return this;
        }

        public Builder goHome(Integer num) {
            this.goHome = num;
            return this;
        }

        public Builder busy(Integer num) {
            this.busy = num;
            return this;
        }

        public Builder assignStatus(Integer num) {
            this.assignStatus = num;
            return this;
        }

        public Builder carpool(Integer num) {
            this.carpool = num;
            return this;
        }

        public Builder fastcar_sw(Integer num) {
            this.fastcar_sw = num;
            return this;
        }

        public Builder auto_grab_flag(Integer num) {
            this.auto_grab_flag = num;
            return this;
        }

        public TaxiDriverOrderComingReq build() {
            return new TaxiDriverOrderComingReq(this);
        }
    }
}
