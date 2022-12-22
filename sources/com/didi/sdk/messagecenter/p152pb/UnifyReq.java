package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.UnifyReq */
public final class UnifyReq extends Message {
    public static final Integer DEFAULT_BUSINESS_ID = 0;
    public static final Integer DEFAULT_EXPIRE_TIME = 0;
    public static final Integer DEFAULT_ID = 0;
    public static final String DEFAULT_LEVEL = "";
    public static final String DEFAULT_MEDIA = "";
    public static final String DEFAULT_MSG_BODY = "";
    public static final String DEFAULT_MSG_ID = "";
    public static final String DEFAULT_MSG_TYPE = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer business_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer expire_time;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)

    /* renamed from: id */
    public final Integer f36792id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String level;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String media;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String msg_body;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String msg_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg_type;

    public UnifyReq(Integer num, String str, Integer num2, String str2, String str3, String str4, Integer num3, String str5) {
        this.business_id = num;
        this.msg_type = str;
        this.f36792id = num2;
        this.level = str2;
        this.media = str3;
        this.msg_id = str4;
        this.expire_time = num3;
        this.msg_body = str5;
    }

    private UnifyReq(Builder builder) {
        this(builder.business_id, builder.msg_type, builder.f36793id, builder.level, builder.media, builder.msg_id, builder.expire_time, builder.msg_body);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnifyReq)) {
            return false;
        }
        UnifyReq unifyReq = (UnifyReq) obj;
        if (!equals((Object) this.business_id, (Object) unifyReq.business_id) || !equals((Object) this.msg_type, (Object) unifyReq.msg_type) || !equals((Object) this.f36792id, (Object) unifyReq.f36792id) || !equals((Object) this.level, (Object) unifyReq.level) || !equals((Object) this.media, (Object) unifyReq.media) || !equals((Object) this.msg_id, (Object) unifyReq.msg_id) || !equals((Object) this.expire_time, (Object) unifyReq.expire_time) || !equals((Object) this.msg_body, (Object) unifyReq.msg_body)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.business_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg_type;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.f36792id;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.level;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.media;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.msg_id;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num3 = this.expire_time;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str5 = this.msg_body;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.UnifyReq$Builder */
    public static final class Builder extends Message.Builder<UnifyReq> {
        public Integer business_id;
        public Integer expire_time;

        /* renamed from: id */
        public Integer f36793id;
        public String level;
        public String media;
        public String msg_body;
        public String msg_id;
        public String msg_type;

        public Builder() {
        }

        public Builder(UnifyReq unifyReq) {
            super(unifyReq);
            if (unifyReq != null) {
                this.business_id = unifyReq.business_id;
                this.msg_type = unifyReq.msg_type;
                this.f36793id = unifyReq.f36792id;
                this.level = unifyReq.level;
                this.media = unifyReq.media;
                this.msg_id = unifyReq.msg_id;
                this.expire_time = unifyReq.expire_time;
                this.msg_body = unifyReq.msg_body;
            }
        }

        public Builder business_id(Integer num) {
            this.business_id = num;
            return this;
        }

        public Builder msg_type(String str) {
            this.msg_type = str;
            return this;
        }

        /* renamed from: id */
        public Builder mo93371id(Integer num) {
            this.f36793id = num;
            return this;
        }

        public Builder level(String str) {
            this.level = str;
            return this;
        }

        public Builder media(String str) {
            this.media = str;
            return this;
        }

        public Builder msg_id(String str) {
            this.msg_id = str;
            return this;
        }

        public Builder expire_time(Integer num) {
            this.expire_time = num;
            return this;
        }

        public Builder msg_body(String str) {
            this.msg_body = str;
            return this;
        }

        public UnifyReq build() {
            checkRequiredFields();
            return new UnifyReq(this);
        }
    }
}
