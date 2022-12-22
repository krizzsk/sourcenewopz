package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OspreyOrderStriveSuccReq extends Message {
    public static final Integer DEFAULT_EXPECT_GOPICK_TIME = 0;
    public static final String DEFAULT_EXTRAINFO = "";
    public static final Integer DEFAULT_IS_PROTECT = 0;
    public static final String DEFAULT_MULTI_OID = "";
    public static final String DEFAULT_OID = "";
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_PUSH_RELATION = 0;
    public static final String DEFAULT_RST_TTS = "";
    public static final Integer DEFAULT_R_WITHINORDER = 0;
    public static final Long DEFAULT_SID = 0L;
    public static final Integer DEFAULT_STRIVED_POLL = 0;
    public static final String DEFAULT_STRIVE_TIME = "";
    public static final Integer DEFAULT_STRIVE_TYPE = 0;
    public static final String DEFAULT_TRAVEL_ID = "";
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer expect_gopick_time;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String extrainfo;
    @ProtoField(tag = 9, type = Message.Datatype.UINT32)
    public final Integer is_protect;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String multi_oid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer push_relation;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer r_withinorder;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String rst_tts;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long sid;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String strive_time;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer strive_type;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer strived_poll;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String travel_id;

    public OspreyOrderStriveSuccReq(String str, String str2, Integer num, Integer num2, Integer num3, String str3, Long l, Integer num4, Integer num5, String str4, String str5, String str6, Integer num6, String str7) {
        this.oid = str;
        this.phone = str2;
        this.push_relation = num;
        this.strived_poll = num2;
        this.r_withinorder = num3;
        this.rst_tts = str3;
        this.sid = l;
        this.expect_gopick_time = num4;
        this.is_protect = num5;
        this.travel_id = str4;
        this.strive_time = str5;
        this.extrainfo = str6;
        this.strive_type = num6;
        this.multi_oid = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OspreyOrderStriveSuccReq(com.didi.sdk.protobuf.OspreyOrderStriveSuccReq.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r2 = r0.oid
            java.lang.String r3 = r0.phone
            java.lang.Integer r4 = r0.push_relation
            java.lang.Integer r5 = r0.strived_poll
            java.lang.Integer r6 = r0.r_withinorder
            java.lang.String r7 = r0.rst_tts
            java.lang.Long r8 = r0.sid
            java.lang.Integer r9 = r0.expect_gopick_time
            java.lang.Integer r10 = r0.is_protect
            java.lang.String r11 = r0.travel_id
            java.lang.String r12 = r0.strive_time
            java.lang.String r13 = r0.extrainfo
            java.lang.Integer r14 = r0.strive_type
            java.lang.String r15 = r0.multi_oid
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.protobuf.OspreyOrderStriveSuccReq.<init>(com.didi.sdk.protobuf.OspreyOrderStriveSuccReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OspreyOrderStriveSuccReq)) {
            return false;
        }
        OspreyOrderStriveSuccReq ospreyOrderStriveSuccReq = (OspreyOrderStriveSuccReq) obj;
        if (!equals((Object) this.oid, (Object) ospreyOrderStriveSuccReq.oid) || !equals((Object) this.phone, (Object) ospreyOrderStriveSuccReq.phone) || !equals((Object) this.push_relation, (Object) ospreyOrderStriveSuccReq.push_relation) || !equals((Object) this.strived_poll, (Object) ospreyOrderStriveSuccReq.strived_poll) || !equals((Object) this.r_withinorder, (Object) ospreyOrderStriveSuccReq.r_withinorder) || !equals((Object) this.rst_tts, (Object) ospreyOrderStriveSuccReq.rst_tts) || !equals((Object) this.sid, (Object) ospreyOrderStriveSuccReq.sid) || !equals((Object) this.expect_gopick_time, (Object) ospreyOrderStriveSuccReq.expect_gopick_time) || !equals((Object) this.is_protect, (Object) ospreyOrderStriveSuccReq.is_protect) || !equals((Object) this.travel_id, (Object) ospreyOrderStriveSuccReq.travel_id) || !equals((Object) this.strive_time, (Object) ospreyOrderStriveSuccReq.strive_time) || !equals((Object) this.extrainfo, (Object) ospreyOrderStriveSuccReq.extrainfo) || !equals((Object) this.strive_type, (Object) ospreyOrderStriveSuccReq.strive_type) || !equals((Object) this.multi_oid, (Object) ospreyOrderStriveSuccReq.multi_oid)) {
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
        String str2 = this.phone;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.push_relation;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.strived_poll;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.r_withinorder;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.rst_tts;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.sid;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num4 = this.expect_gopick_time;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.is_protect;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str4 = this.travel_id;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.strive_time;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.extrainfo;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num6 = this.strive_type;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str7 = this.multi_oid;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OspreyOrderStriveSuccReq> {
        public Integer expect_gopick_time;
        public String extrainfo;
        public Integer is_protect;
        public String multi_oid;
        public String oid;
        public String phone;
        public Integer push_relation;
        public Integer r_withinorder;
        public String rst_tts;
        public Long sid;
        public String strive_time;
        public Integer strive_type;
        public Integer strived_poll;
        public String travel_id;

        public Builder() {
        }

        public Builder(OspreyOrderStriveSuccReq ospreyOrderStriveSuccReq) {
            super(ospreyOrderStriveSuccReq);
            if (ospreyOrderStriveSuccReq != null) {
                this.oid = ospreyOrderStriveSuccReq.oid;
                this.phone = ospreyOrderStriveSuccReq.phone;
                this.push_relation = ospreyOrderStriveSuccReq.push_relation;
                this.strived_poll = ospreyOrderStriveSuccReq.strived_poll;
                this.r_withinorder = ospreyOrderStriveSuccReq.r_withinorder;
                this.rst_tts = ospreyOrderStriveSuccReq.rst_tts;
                this.sid = ospreyOrderStriveSuccReq.sid;
                this.expect_gopick_time = ospreyOrderStriveSuccReq.expect_gopick_time;
                this.is_protect = ospreyOrderStriveSuccReq.is_protect;
                this.travel_id = ospreyOrderStriveSuccReq.travel_id;
                this.strive_time = ospreyOrderStriveSuccReq.strive_time;
                this.extrainfo = ospreyOrderStriveSuccReq.extrainfo;
                this.strive_type = ospreyOrderStriveSuccReq.strive_type;
                this.multi_oid = ospreyOrderStriveSuccReq.multi_oid;
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder push_relation(Integer num) {
            this.push_relation = num;
            return this;
        }

        public Builder strived_poll(Integer num) {
            this.strived_poll = num;
            return this;
        }

        public Builder r_withinorder(Integer num) {
            this.r_withinorder = num;
            return this;
        }

        public Builder rst_tts(String str) {
            this.rst_tts = str;
            return this;
        }

        public Builder sid(Long l) {
            this.sid = l;
            return this;
        }

        public Builder expect_gopick_time(Integer num) {
            this.expect_gopick_time = num;
            return this;
        }

        public Builder is_protect(Integer num) {
            this.is_protect = num;
            return this;
        }

        public Builder travel_id(String str) {
            this.travel_id = str;
            return this;
        }

        public Builder strive_time(String str) {
            this.strive_time = str;
            return this;
        }

        public Builder extrainfo(String str) {
            this.extrainfo = str;
            return this;
        }

        public Builder strive_type(Integer num) {
            this.strive_type = num;
            return this;
        }

        public Builder multi_oid(String str) {
            this.multi_oid = str;
            return this;
        }

        public OspreyOrderStriveSuccReq build() {
            checkRequiredFields();
            return new OspreyOrderStriveSuccReq(this);
        }
    }
}
