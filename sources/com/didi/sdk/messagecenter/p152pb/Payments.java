package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.Payments */
public final class Payments extends Message {
    public static final String DEFAULT_ACT_URL = "";
    public static final String DEFAULT_EXTRA_MSG = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final Integer DEFAULT_PAYMENT_MODE = 0;
    public static final String DEFAULT_PAYMENT_NAME = "";
    public static final String DEFAULT_WARN_MSG = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String act_url;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String extra_msg;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String icon_url;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer payment_mode;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String payment_name;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String warn_msg;

    public Payments(Integer num, String str, String str2, String str3, String str4, String str5) {
        this.payment_mode = num;
        this.payment_name = str;
        this.icon_url = str2;
        this.extra_msg = str3;
        this.act_url = str4;
        this.warn_msg = str5;
    }

    private Payments(Builder builder) {
        this(builder.payment_mode, builder.payment_name, builder.icon_url, builder.extra_msg, builder.act_url, builder.warn_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Payments)) {
            return false;
        }
        Payments payments = (Payments) obj;
        if (!equals((Object) this.payment_mode, (Object) payments.payment_mode) || !equals((Object) this.payment_name, (Object) payments.payment_name) || !equals((Object) this.icon_url, (Object) payments.icon_url) || !equals((Object) this.extra_msg, (Object) payments.extra_msg) || !equals((Object) this.act_url, (Object) payments.act_url) || !equals((Object) this.warn_msg, (Object) payments.warn_msg)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.payment_mode;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.payment_name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.icon_url;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.extra_msg;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.act_url;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.warn_msg;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.Payments$Builder */
    public static final class Builder extends Message.Builder<Payments> {
        public String act_url;
        public String extra_msg;
        public String icon_url;
        public Integer payment_mode;
        public String payment_name;
        public String warn_msg;

        public Builder() {
        }

        public Builder(Payments payments) {
            super(payments);
            if (payments != null) {
                this.payment_mode = payments.payment_mode;
                this.payment_name = payments.payment_name;
                this.icon_url = payments.icon_url;
                this.extra_msg = payments.extra_msg;
                this.act_url = payments.act_url;
                this.warn_msg = payments.warn_msg;
            }
        }

        public Builder payment_mode(Integer num) {
            this.payment_mode = num;
            return this;
        }

        public Builder payment_name(String str) {
            this.payment_name = str;
            return this;
        }

        public Builder icon_url(String str) {
            this.icon_url = str;
            return this;
        }

        public Builder extra_msg(String str) {
            this.extra_msg = str;
            return this;
        }

        public Builder act_url(String str) {
            this.act_url = str;
            return this;
        }

        public Builder warn_msg(String str) {
            this.warn_msg = str;
            return this;
        }

        public Payments build() {
            checkRequiredFields();
            return new Payments(this);
        }
    }
}
