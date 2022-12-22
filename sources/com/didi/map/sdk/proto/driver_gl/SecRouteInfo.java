package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class SecRouteInfo extends Message {
    public static final String DEFAULT_BUBMSG = "";
    public static final ByteString DEFAULT_BUBMSGV2 = ByteString.EMPTY;
    public static final String DEFAULT_BUBNEWPPMSG = "";
    public static final Integer DEFAULT_BUBTYPE = 0;
    public static final String DEFAULT_CANTCHGMSG = "";
    public static final String DEFAULT_CHGSUCCMSG = "";
    public static final String DEFAULT_CURPPGRTMSG = "";
    public static final String DEFAULT_IGNMSG = "";
    public static final ByteString DEFAULT_NEWPPMSG = ByteString.EMPTY;
    public static final Integer DEFAULT_ROUTETERM = 0;
    public static final String DEFAULT_USEMSG = "";
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String bubMsg;
    @ProtoField(tag = 13, type = Message.Datatype.BYTES)
    public final ByteString bubMsgV2;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String bubNewPPMsg;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer bubType;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String cantChgMsg;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String chgSuccMsg;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String curPPGrtMsg;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String ignMsg;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final ByteString newPPMsg;
    @ProtoField(tag = 1)
    public final PickupPoint point;
    @ProtoField(tag = 2)
    public final Route route;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer routeTerm;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String useMsg;

    public SecRouteInfo(PickupPoint pickupPoint, Route route2, Integer num, ByteString byteString, String str, Integer num2, String str2, String str3, String str4, String str5, String str6, String str7, ByteString byteString2) {
        this.point = pickupPoint;
        this.route = route2;
        this.routeTerm = num;
        this.newPPMsg = byteString;
        this.bubMsg = str;
        this.bubType = num2;
        this.useMsg = str2;
        this.ignMsg = str3;
        this.curPPGrtMsg = str4;
        this.cantChgMsg = str5;
        this.chgSuccMsg = str6;
        this.bubNewPPMsg = str7;
        this.bubMsgV2 = byteString2;
    }

    private SecRouteInfo(Builder builder) {
        this(builder.point, builder.route, builder.routeTerm, builder.newPPMsg, builder.bubMsg, builder.bubType, builder.useMsg, builder.ignMsg, builder.curPPGrtMsg, builder.cantChgMsg, builder.chgSuccMsg, builder.bubNewPPMsg, builder.bubMsgV2);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecRouteInfo)) {
            return false;
        }
        SecRouteInfo secRouteInfo = (SecRouteInfo) obj;
        if (!equals((Object) this.point, (Object) secRouteInfo.point) || !equals((Object) this.route, (Object) secRouteInfo.route) || !equals((Object) this.routeTerm, (Object) secRouteInfo.routeTerm) || !equals((Object) this.newPPMsg, (Object) secRouteInfo.newPPMsg) || !equals((Object) this.bubMsg, (Object) secRouteInfo.bubMsg) || !equals((Object) this.bubType, (Object) secRouteInfo.bubType) || !equals((Object) this.useMsg, (Object) secRouteInfo.useMsg) || !equals((Object) this.ignMsg, (Object) secRouteInfo.ignMsg) || !equals((Object) this.curPPGrtMsg, (Object) secRouteInfo.curPPGrtMsg) || !equals((Object) this.cantChgMsg, (Object) secRouteInfo.cantChgMsg) || !equals((Object) this.chgSuccMsg, (Object) secRouteInfo.chgSuccMsg) || !equals((Object) this.bubNewPPMsg, (Object) secRouteInfo.bubNewPPMsg) || !equals((Object) this.bubMsgV2, (Object) secRouteInfo.bubMsgV2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        PickupPoint pickupPoint = this.point;
        int i2 = 0;
        int hashCode = (pickupPoint != null ? pickupPoint.hashCode() : 0) * 37;
        Route route2 = this.route;
        int hashCode2 = (hashCode + (route2 != null ? route2.hashCode() : 0)) * 37;
        Integer num = this.routeTerm;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        ByteString byteString = this.newPPMsg;
        int hashCode4 = (hashCode3 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        String str = this.bubMsg;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.bubType;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.useMsg;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.ignMsg;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.curPPGrtMsg;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.cantChgMsg;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.chgSuccMsg;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.bubNewPPMsg;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        ByteString byteString2 = this.bubMsgV2;
        if (byteString2 != null) {
            i2 = byteString2.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SecRouteInfo> {
        public String bubMsg;
        public ByteString bubMsgV2;
        public String bubNewPPMsg;
        public Integer bubType;
        public String cantChgMsg;
        public String chgSuccMsg;
        public String curPPGrtMsg;
        public String ignMsg;
        public ByteString newPPMsg;
        public PickupPoint point;
        public Route route;
        public Integer routeTerm;
        public String useMsg;

        public Builder() {
        }

        public Builder(SecRouteInfo secRouteInfo) {
            super(secRouteInfo);
            if (secRouteInfo != null) {
                this.point = secRouteInfo.point;
                this.route = secRouteInfo.route;
                this.routeTerm = secRouteInfo.routeTerm;
                this.newPPMsg = secRouteInfo.newPPMsg;
                this.bubMsg = secRouteInfo.bubMsg;
                this.bubType = secRouteInfo.bubType;
                this.useMsg = secRouteInfo.useMsg;
                this.ignMsg = secRouteInfo.ignMsg;
                this.curPPGrtMsg = secRouteInfo.curPPGrtMsg;
                this.cantChgMsg = secRouteInfo.cantChgMsg;
                this.chgSuccMsg = secRouteInfo.chgSuccMsg;
                this.bubNewPPMsg = secRouteInfo.bubNewPPMsg;
                this.bubMsgV2 = secRouteInfo.bubMsgV2;
            }
        }

        public Builder point(PickupPoint pickupPoint) {
            this.point = pickupPoint;
            return this;
        }

        public Builder route(Route route2) {
            this.route = route2;
            return this;
        }

        public Builder routeTerm(Integer num) {
            this.routeTerm = num;
            return this;
        }

        public Builder newPPMsg(ByteString byteString) {
            this.newPPMsg = byteString;
            return this;
        }

        public Builder bubMsg(String str) {
            this.bubMsg = str;
            return this;
        }

        public Builder bubType(Integer num) {
            this.bubType = num;
            return this;
        }

        public Builder useMsg(String str) {
            this.useMsg = str;
            return this;
        }

        public Builder ignMsg(String str) {
            this.ignMsg = str;
            return this;
        }

        public Builder curPPGrtMsg(String str) {
            this.curPPGrtMsg = str;
            return this;
        }

        public Builder cantChgMsg(String str) {
            this.cantChgMsg = str;
            return this;
        }

        public Builder chgSuccMsg(String str) {
            this.chgSuccMsg = str;
            return this;
        }

        public Builder bubNewPPMsg(String str) {
            this.bubNewPPMsg = str;
            return this;
        }

        public Builder bubMsgV2(ByteString byteString) {
            this.bubMsgV2 = byteString;
            return this;
        }

        public SecRouteInfo build() {
            return new SecRouteInfo(this);
        }
    }
}
