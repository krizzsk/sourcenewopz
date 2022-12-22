package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class OrderFeatureRouteReq extends Message {
    public static final String DEFAULT_CALLER = "";
    public static final Long DEFAULT_CURROUTEID = 0L;
    public static final String DEFAULT_DIDIVERSION = "";
    public static final Long DEFAULT_DRIVERID = 0L;
    public static final String DEFAULT_DRVSYNCMSG = "";
    public static final ByteString DEFAULT_EXTENDDATA = ByteString.EMPTY;
    public static final String DEFAULT_MAPTYPE = "";
    public static final String DEFAULT_ORDERID = "";
    public static final Integer DEFAULT_ORDERSTAGE = 0;
    public static final String DEFAULT_PHONENUM = "";
    public static final String DEFAULT_PRODUCTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_TRAVELID = "";
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String caller;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long curRouteId;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(tag = 6, type = Message.Datatype.UINT64)
    public final Long driverId;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String drvSyncMsg;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final ByteString extendData;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String maptype;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT32)
    public final Integer orderStage;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String phoneNum;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String productId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String travelID;

    public OrderFeatureRouteReq(String str, String str2, String str3, String str4, Integer num, Long l, String str5, Long l2, String str6, ByteString byteString, String str7, String str8, String str9) {
        this.token = str;
        this.orderId = str2;
        this.travelID = str3;
        this.phoneNum = str4;
        this.orderStage = num;
        this.driverId = l;
        this.productId = str5;
        this.curRouteId = l2;
        this.drvSyncMsg = str6;
        this.extendData = byteString;
        this.caller = str7;
        this.maptype = str8;
        this.didiVersion = str9;
    }

    private OrderFeatureRouteReq(Builder builder) {
        this(builder.token, builder.orderId, builder.travelID, builder.phoneNum, builder.orderStage, builder.driverId, builder.productId, builder.curRouteId, builder.drvSyncMsg, builder.extendData, builder.caller, builder.maptype, builder.didiVersion);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderFeatureRouteReq)) {
            return false;
        }
        OrderFeatureRouteReq orderFeatureRouteReq = (OrderFeatureRouteReq) obj;
        if (!equals((Object) this.token, (Object) orderFeatureRouteReq.token) || !equals((Object) this.orderId, (Object) orderFeatureRouteReq.orderId) || !equals((Object) this.travelID, (Object) orderFeatureRouteReq.travelID) || !equals((Object) this.phoneNum, (Object) orderFeatureRouteReq.phoneNum) || !equals((Object) this.orderStage, (Object) orderFeatureRouteReq.orderStage) || !equals((Object) this.driverId, (Object) orderFeatureRouteReq.driverId) || !equals((Object) this.productId, (Object) orderFeatureRouteReq.productId) || !equals((Object) this.curRouteId, (Object) orderFeatureRouteReq.curRouteId) || !equals((Object) this.drvSyncMsg, (Object) orderFeatureRouteReq.drvSyncMsg) || !equals((Object) this.extendData, (Object) orderFeatureRouteReq.extendData) || !equals((Object) this.caller, (Object) orderFeatureRouteReq.caller) || !equals((Object) this.maptype, (Object) orderFeatureRouteReq.maptype) || !equals((Object) this.didiVersion, (Object) orderFeatureRouteReq.didiVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.token;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.orderId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.travelID;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.phoneNum;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num = this.orderStage;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.driverId;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        String str5 = this.productId;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l2 = this.curRouteId;
        int hashCode8 = (hashCode7 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str6 = this.drvSyncMsg;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37;
        ByteString byteString = this.extendData;
        int hashCode10 = (hashCode9 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        String str7 = this.caller;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.maptype;
        int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.didiVersion;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderFeatureRouteReq> {
        public String caller;
        public Long curRouteId;
        public String didiVersion;
        public Long driverId;
        public String drvSyncMsg;
        public ByteString extendData;
        public String maptype;
        public String orderId;
        public Integer orderStage;
        public String phoneNum;
        public String productId;
        public String token;
        public String travelID;

        public Builder() {
        }

        public Builder(OrderFeatureRouteReq orderFeatureRouteReq) {
            super(orderFeatureRouteReq);
            if (orderFeatureRouteReq != null) {
                this.token = orderFeatureRouteReq.token;
                this.orderId = orderFeatureRouteReq.orderId;
                this.travelID = orderFeatureRouteReq.travelID;
                this.phoneNum = orderFeatureRouteReq.phoneNum;
                this.orderStage = orderFeatureRouteReq.orderStage;
                this.driverId = orderFeatureRouteReq.driverId;
                this.productId = orderFeatureRouteReq.productId;
                this.curRouteId = orderFeatureRouteReq.curRouteId;
                this.drvSyncMsg = orderFeatureRouteReq.drvSyncMsg;
                this.extendData = orderFeatureRouteReq.extendData;
                this.caller = orderFeatureRouteReq.caller;
                this.maptype = orderFeatureRouteReq.maptype;
                this.didiVersion = orderFeatureRouteReq.didiVersion;
            }
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder travelID(String str) {
            this.travelID = str;
            return this;
        }

        public Builder phoneNum(String str) {
            this.phoneNum = str;
            return this;
        }

        public Builder orderStage(Integer num) {
            this.orderStage = num;
            return this;
        }

        public Builder driverId(Long l) {
            this.driverId = l;
            return this;
        }

        public Builder productId(String str) {
            this.productId = str;
            return this;
        }

        public Builder curRouteId(Long l) {
            this.curRouteId = l;
            return this;
        }

        public Builder drvSyncMsg(String str) {
            this.drvSyncMsg = str;
            return this;
        }

        public Builder extendData(ByteString byteString) {
            this.extendData = byteString;
            return this;
        }

        public Builder caller(String str) {
            this.caller = str;
            return this;
        }

        public Builder maptype(String str) {
            this.maptype = str;
            return this;
        }

        public Builder didiVersion(String str) {
            this.didiVersion = str;
            return this;
        }

        public OrderFeatureRouteReq build() {
            checkRequiredFields();
            return new OrderFeatureRouteReq(this);
        }
    }
}
