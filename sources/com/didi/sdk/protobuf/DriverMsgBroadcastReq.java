package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;

public final class DriverMsgBroadcastReq extends Message {
    public static final Integer DEFAULT_ANNOUNCETYPE = 0;
    public static final Integer DEFAULT_BC_TYPE = 0;
    public static final Integer DEFAULT_EXPIRETIME = 0;
    public static final String DEFAULT_EXTENDVALUE = "";
    public static final String DEFAULT_H5_TEXT = "";
    public static final String DEFAULT_MSG_ID = "";
    public static final Integer DEFAULT_NEEDPUBLICPARAMS = 0;
    public static final Integer DEFAULT_NEEDSHOW = 0;
    public static final String DEFAULT_PICURL = "";
    public static final Integer DEFAULT_PORTALTYPE = 0;
    public static final String DEFAULT_PORTALURL = "";
    public static final Integer DEFAULT_POSTYPE = 0;
    public static final Integer DEFAULT_PUSHTIME = 0;
    public static final Integer DEFAULT_REDIRECT_TYPE = 0;
    public static final Integer DEFAULT_SHOWTYPE = 0;
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_URGENT = 0;
    public static final String DEFAULT_VOICEURL = "";
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer announceType;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer bc_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer expireTime;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String extendValue;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String h5_text;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String msg_id;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer needPublicParams;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer needShow;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String picUrl;
    @ProtoField(label = Message.Label.REQUIRED, tag = 8, type = Message.Datatype.INT32)
    public final Integer portalType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9, type = Message.Datatype.STRING)
    public final String portalUrl;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer posType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT32)
    public final Integer pushTime;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer redirect_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer showType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer urgent;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.STRING)
    public final String voiceUrl;

    public DriverMsgBroadcastReq(Integer num, Integer num2, String str, String str2, Integer num3, Integer num4, String str3, Integer num5, String str4, Integer num6, String str5, Integer num7, Integer num8, Integer num9, String str6, Integer num10, String str7, Integer num11, String str8) {
        this.posType = num;
        this.showType = num2;
        this.title = str;
        this.text = str2;
        this.pushTime = num3;
        this.expireTime = num4;
        this.voiceUrl = str3;
        this.portalType = num5;
        this.portalUrl = str4;
        this.urgent = num6;
        this.picUrl = str5;
        this.redirect_type = num7;
        this.announceType = num8;
        this.bc_type = num9;
        this.h5_text = str6;
        this.needPublicParams = num10;
        this.msg_id = str7;
        this.needShow = num11;
        this.extendValue = str8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DriverMsgBroadcastReq(com.didi.sdk.protobuf.DriverMsgBroadcastReq.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            java.lang.Integer r2 = r0.posType
            java.lang.Integer r3 = r0.showType
            java.lang.String r4 = r0.title
            java.lang.String r5 = r0.text
            java.lang.Integer r6 = r0.pushTime
            java.lang.Integer r7 = r0.expireTime
            java.lang.String r8 = r0.voiceUrl
            java.lang.Integer r9 = r0.portalType
            java.lang.String r10 = r0.portalUrl
            java.lang.Integer r11 = r0.urgent
            java.lang.String r12 = r0.picUrl
            java.lang.Integer r13 = r0.redirect_type
            java.lang.Integer r14 = r0.announceType
            java.lang.Integer r15 = r0.bc_type
            r21 = r1
            java.lang.String r1 = r0.h5_text
            r16 = r1
            java.lang.Integer r1 = r0.needPublicParams
            r17 = r1
            java.lang.String r1 = r0.msg_id
            r18 = r1
            java.lang.Integer r1 = r0.needShow
            r19 = r1
            java.lang.String r1 = r0.extendValue
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.protobuf.DriverMsgBroadcastReq.<init>(com.didi.sdk.protobuf.DriverMsgBroadcastReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverMsgBroadcastReq)) {
            return false;
        }
        DriverMsgBroadcastReq driverMsgBroadcastReq = (DriverMsgBroadcastReq) obj;
        if (!equals((Object) this.posType, (Object) driverMsgBroadcastReq.posType) || !equals((Object) this.showType, (Object) driverMsgBroadcastReq.showType) || !equals((Object) this.title, (Object) driverMsgBroadcastReq.title) || !equals((Object) this.text, (Object) driverMsgBroadcastReq.text) || !equals((Object) this.pushTime, (Object) driverMsgBroadcastReq.pushTime) || !equals((Object) this.expireTime, (Object) driverMsgBroadcastReq.expireTime) || !equals((Object) this.voiceUrl, (Object) driverMsgBroadcastReq.voiceUrl) || !equals((Object) this.portalType, (Object) driverMsgBroadcastReq.portalType) || !equals((Object) this.portalUrl, (Object) driverMsgBroadcastReq.portalUrl) || !equals((Object) this.urgent, (Object) driverMsgBroadcastReq.urgent) || !equals((Object) this.picUrl, (Object) driverMsgBroadcastReq.picUrl) || !equals((Object) this.redirect_type, (Object) driverMsgBroadcastReq.redirect_type) || !equals((Object) this.announceType, (Object) driverMsgBroadcastReq.announceType) || !equals((Object) this.bc_type, (Object) driverMsgBroadcastReq.bc_type) || !equals((Object) this.h5_text, (Object) driverMsgBroadcastReq.h5_text) || !equals((Object) this.needPublicParams, (Object) driverMsgBroadcastReq.needPublicParams) || !equals((Object) this.msg_id, (Object) driverMsgBroadcastReq.msg_id) || !equals((Object) this.needShow, (Object) driverMsgBroadcastReq.needShow) || !equals((Object) this.extendValue, (Object) driverMsgBroadcastReq.extendValue)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.posType;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.showType;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.title;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.text;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.pushTime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.expireTime;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str3 = this.voiceUrl;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num5 = this.portalType;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str4 = this.portalUrl;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num6 = this.urgent;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str5 = this.picUrl;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num7 = this.redirect_type;
        int hashCode12 = (hashCode11 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.announceType;
        int hashCode13 = (hashCode12 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.bc_type;
        int hashCode14 = (hashCode13 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str6 = this.h5_text;
        int hashCode15 = (hashCode14 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num10 = this.needPublicParams;
        int hashCode16 = (hashCode15 + (num10 != null ? num10.hashCode() : 0)) * 37;
        String str7 = this.msg_id;
        int hashCode17 = (hashCode16 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num11 = this.needShow;
        int hashCode18 = (hashCode17 + (num11 != null ? num11.hashCode() : 0)) * 37;
        String str8 = this.extendValue;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverMsgBroadcastReq> {
        public Integer announceType;
        public Integer bc_type;
        public Integer expireTime;
        public String extendValue;
        public String h5_text;
        public String msg_id;
        public Integer needPublicParams;
        public Integer needShow;
        public String picUrl;
        public Integer portalType;
        public String portalUrl;
        public Integer posType;
        public Integer pushTime;
        public Integer redirect_type;
        public Integer showType;
        public String text;
        public String title;
        public Integer urgent;
        public String voiceUrl;

        public Builder() {
        }

        public Builder(DriverMsgBroadcastReq driverMsgBroadcastReq) {
            super(driverMsgBroadcastReq);
            if (driverMsgBroadcastReq != null) {
                this.posType = driverMsgBroadcastReq.posType;
                this.showType = driverMsgBroadcastReq.showType;
                this.title = driverMsgBroadcastReq.title;
                this.text = driverMsgBroadcastReq.text;
                this.pushTime = driverMsgBroadcastReq.pushTime;
                this.expireTime = driverMsgBroadcastReq.expireTime;
                this.voiceUrl = driverMsgBroadcastReq.voiceUrl;
                this.portalType = driverMsgBroadcastReq.portalType;
                this.portalUrl = driverMsgBroadcastReq.portalUrl;
                this.urgent = driverMsgBroadcastReq.urgent;
                this.picUrl = driverMsgBroadcastReq.picUrl;
                this.redirect_type = driverMsgBroadcastReq.redirect_type;
                this.announceType = driverMsgBroadcastReq.announceType;
                this.bc_type = driverMsgBroadcastReq.bc_type;
                this.h5_text = driverMsgBroadcastReq.h5_text;
                this.needPublicParams = driverMsgBroadcastReq.needPublicParams;
                this.msg_id = driverMsgBroadcastReq.msg_id;
                this.needShow = driverMsgBroadcastReq.needShow;
                this.extendValue = driverMsgBroadcastReq.extendValue;
            }
        }

        public Builder posType(Integer num) {
            this.posType = num;
            return this;
        }

        public Builder showType(Integer num) {
            this.showType = num;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public Builder pushTime(Integer num) {
            this.pushTime = num;
            return this;
        }

        public Builder expireTime(Integer num) {
            this.expireTime = num;
            return this;
        }

        public Builder voiceUrl(String str) {
            this.voiceUrl = str;
            return this;
        }

        public Builder portalType(Integer num) {
            this.portalType = num;
            return this;
        }

        public Builder portalUrl(String str) {
            this.portalUrl = str;
            return this;
        }

        public Builder urgent(Integer num) {
            this.urgent = num;
            return this;
        }

        public Builder picUrl(String str) {
            this.picUrl = str;
            return this;
        }

        public Builder redirect_type(Integer num) {
            this.redirect_type = num;
            return this;
        }

        public Builder announceType(Integer num) {
            this.announceType = num;
            return this;
        }

        public Builder bc_type(Integer num) {
            this.bc_type = num;
            return this;
        }

        public Builder h5_text(String str) {
            this.h5_text = str;
            return this;
        }

        public Builder needPublicParams(Integer num) {
            this.needPublicParams = num;
            return this;
        }

        public Builder msg_id(String str) {
            this.msg_id = str;
            return this;
        }

        public Builder needShow(Integer num) {
            this.needShow = num;
            return this;
        }

        public Builder extendValue(String str) {
            this.extendValue = str;
            return this;
        }

        public DriverMsgBroadcastReq build() {
            checkRequiredFields();
            return new DriverMsgBroadcastReq(this);
        }
    }

    public enum AnnounceType implements ProtoEnum {
        kAnnounceSystem(0),
        kAnnounceTask(1),
        kAnnounceActivity(2);
        
        private final int value;

        private AnnounceType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
