package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverMsgPayReq extends Message {
    public static final Integer DEFAULT_BC_TYPE = 0;
    public static final Integer DEFAULT_EXPIRETIME = 0;
    public static final String DEFAULT_H5_TEXT = "";
    public static final String DEFAULT_MSG_ID = "";
    public static final Integer DEFAULT_NEEDPUBLICPARAMS = 0;
    public static final String DEFAULT_OID = "";
    public static final Integer DEFAULT_PORTALTYPE = 0;
    public static final String DEFAULT_PORTALURL = "";
    public static final Integer DEFAULT_POSTYPE = 0;
    public static final Integer DEFAULT_PUSHTIME = 0;
    public static final Integer DEFAULT_SHOWTYPE = 0;
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_VOICEURL = "";
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer bc_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer expireTime;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String h5_text;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String msg_id;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer needPublicParams;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 8, type = Message.Datatype.INT32)
    public final Integer portalType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9, type = Message.Datatype.STRING)
    public final String portalUrl;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer posType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT32)
    public final Integer pushTime;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer showType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.STRING)
    public final String voiceUrl;

    public DriverMsgPayReq(Integer num, Integer num2, String str, String str2, Integer num3, Integer num4, String str3, Integer num5, String str4, String str5, Integer num6, String str6, Integer num7, String str7) {
        this.posType = num;
        this.showType = num2;
        this.title = str;
        this.text = str2;
        this.pushTime = num3;
        this.expireTime = num4;
        this.voiceUrl = str3;
        this.portalType = num5;
        this.portalUrl = str4;
        this.oid = str5;
        this.bc_type = num6;
        this.h5_text = str6;
        this.needPublicParams = num7;
        this.msg_id = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DriverMsgPayReq(com.didi.sdk.protobuf.DriverMsgPayReq.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Integer r2 = r0.posType
            java.lang.Integer r3 = r0.showType
            java.lang.String r4 = r0.title
            java.lang.String r5 = r0.text
            java.lang.Integer r6 = r0.pushTime
            java.lang.Integer r7 = r0.expireTime
            java.lang.String r8 = r0.voiceUrl
            java.lang.Integer r9 = r0.portalType
            java.lang.String r10 = r0.portalUrl
            java.lang.String r11 = r0.oid
            java.lang.Integer r12 = r0.bc_type
            java.lang.String r13 = r0.h5_text
            java.lang.Integer r14 = r0.needPublicParams
            java.lang.String r15 = r0.msg_id
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.protobuf.DriverMsgPayReq.<init>(com.didi.sdk.protobuf.DriverMsgPayReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverMsgPayReq)) {
            return false;
        }
        DriverMsgPayReq driverMsgPayReq = (DriverMsgPayReq) obj;
        if (!equals((Object) this.posType, (Object) driverMsgPayReq.posType) || !equals((Object) this.showType, (Object) driverMsgPayReq.showType) || !equals((Object) this.title, (Object) driverMsgPayReq.title) || !equals((Object) this.text, (Object) driverMsgPayReq.text) || !equals((Object) this.pushTime, (Object) driverMsgPayReq.pushTime) || !equals((Object) this.expireTime, (Object) driverMsgPayReq.expireTime) || !equals((Object) this.voiceUrl, (Object) driverMsgPayReq.voiceUrl) || !equals((Object) this.portalType, (Object) driverMsgPayReq.portalType) || !equals((Object) this.portalUrl, (Object) driverMsgPayReq.portalUrl) || !equals((Object) this.oid, (Object) driverMsgPayReq.oid) || !equals((Object) this.bc_type, (Object) driverMsgPayReq.bc_type) || !equals((Object) this.h5_text, (Object) driverMsgPayReq.h5_text) || !equals((Object) this.needPublicParams, (Object) driverMsgPayReq.needPublicParams) || !equals((Object) this.msg_id, (Object) driverMsgPayReq.msg_id)) {
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
        String str5 = this.oid;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num6 = this.bc_type;
        int hashCode11 = (hashCode10 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str6 = this.h5_text;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num7 = this.needPublicParams;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str7 = this.msg_id;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverMsgPayReq> {
        public Integer bc_type;
        public Integer expireTime;
        public String h5_text;
        public String msg_id;
        public Integer needPublicParams;
        public String oid;
        public Integer portalType;
        public String portalUrl;
        public Integer posType;
        public Integer pushTime;
        public Integer showType;
        public String text;
        public String title;
        public String voiceUrl;

        public Builder() {
        }

        public Builder(DriverMsgPayReq driverMsgPayReq) {
            super(driverMsgPayReq);
            if (driverMsgPayReq != null) {
                this.posType = driverMsgPayReq.posType;
                this.showType = driverMsgPayReq.showType;
                this.title = driverMsgPayReq.title;
                this.text = driverMsgPayReq.text;
                this.pushTime = driverMsgPayReq.pushTime;
                this.expireTime = driverMsgPayReq.expireTime;
                this.voiceUrl = driverMsgPayReq.voiceUrl;
                this.portalType = driverMsgPayReq.portalType;
                this.portalUrl = driverMsgPayReq.portalUrl;
                this.oid = driverMsgPayReq.oid;
                this.bc_type = driverMsgPayReq.bc_type;
                this.h5_text = driverMsgPayReq.h5_text;
                this.needPublicParams = driverMsgPayReq.needPublicParams;
                this.msg_id = driverMsgPayReq.msg_id;
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

        public Builder oid(String str) {
            this.oid = str;
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

        public DriverMsgPayReq build() {
            checkRequiredFields();
            return new DriverMsgPayReq(this);
        }
    }
}
