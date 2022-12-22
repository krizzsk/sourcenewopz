package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.PreAuthResultReq */
public final class PreAuthResultReq extends Message {
    public static final String DEFAULT_ERROR_MSG = "";
    public static final Integer DEFAULT_ERROR_TYPE = 0;
    public static final String DEFAULT_OID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String error_msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer error_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;

    public PreAuthResultReq(String str, Integer num, String str2) {
        this.oid = str;
        this.error_type = num;
        this.error_msg = str2;
    }

    private PreAuthResultReq(Builder builder) {
        this(builder.oid, builder.error_type, builder.error_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PreAuthResultReq)) {
            return false;
        }
        PreAuthResultReq preAuthResultReq = (PreAuthResultReq) obj;
        if (!equals((Object) this.oid, (Object) preAuthResultReq.oid) || !equals((Object) this.error_type, (Object) preAuthResultReq.error_type) || !equals((Object) this.error_msg, (Object) preAuthResultReq.error_msg)) {
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
        Integer num = this.error_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.error_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.PreAuthResultReq$Builder */
    public static final class Builder extends Message.Builder<PreAuthResultReq> {
        public String error_msg;
        public Integer error_type;
        public String oid;

        public Builder() {
        }

        public Builder(PreAuthResultReq preAuthResultReq) {
            super(preAuthResultReq);
            if (preAuthResultReq != null) {
                this.oid = preAuthResultReq.oid;
                this.error_type = preAuthResultReq.error_type;
                this.error_msg = preAuthResultReq.error_msg;
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder error_type(Integer num) {
            this.error_type = num;
            return this;
        }

        public Builder error_msg(String str) {
            this.error_msg = str;
            return this;
        }

        public PreAuthResultReq build() {
            checkRequiredFields();
            return new PreAuthResultReq(this);
        }
    }
}
