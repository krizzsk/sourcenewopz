package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.FeeInfoItem */
public final class FeeInfoItem extends Message {
    public static final String DEFAULT_EXTRA_INFO = "";
    public static final String DEFAULT_FEE_API = "";
    public static final String DEFAULT_FEE_COLOR = "";
    public static final Integer DEFAULT_FEE_CUST = 0;
    public static final String DEFAULT_FEE_ID = "";
    public static final String DEFAULT_FEE_KEY = "";
    public static final String DEFAULT_FEE_LABEL = "";
    public static final Integer DEFAULT_FEE_TYPE = 0;
    public static final String DEFAULT_FEE_URL = "";
    public static final String DEFAULT_FEE_VALUE = "";
    public static final Integer DEFAULT_IS_BASE_FEE = 0;
    public static final Integer DEFAULT_IS_EDIT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String extra_info;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String fee_api;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String fee_color;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer fee_cust;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String fee_id;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String fee_key;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String fee_label;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer fee_type;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String fee_url;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String fee_value;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer is_base_fee;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer is_edit;

    public FeeInfoItem(String str, String str2, Integer num, String str3, Integer num2, String str4, String str5, String str6, Integer num3, Integer num4, String str7, String str8) {
        this.fee_label = str;
        this.fee_value = str2;
        this.fee_type = num;
        this.fee_url = str3;
        this.fee_cust = num2;
        this.fee_id = str4;
        this.fee_color = str5;
        this.fee_key = str6;
        this.is_edit = num3;
        this.is_base_fee = num4;
        this.fee_api = str7;
        this.extra_info = str8;
    }

    private FeeInfoItem(Builder builder) {
        this(builder.fee_label, builder.fee_value, builder.fee_type, builder.fee_url, builder.fee_cust, builder.fee_id, builder.fee_color, builder.fee_key, builder.is_edit, builder.is_base_fee, builder.fee_api, builder.extra_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeeInfoItem)) {
            return false;
        }
        FeeInfoItem feeInfoItem = (FeeInfoItem) obj;
        if (!equals((Object) this.fee_label, (Object) feeInfoItem.fee_label) || !equals((Object) this.fee_value, (Object) feeInfoItem.fee_value) || !equals((Object) this.fee_type, (Object) feeInfoItem.fee_type) || !equals((Object) this.fee_url, (Object) feeInfoItem.fee_url) || !equals((Object) this.fee_cust, (Object) feeInfoItem.fee_cust) || !equals((Object) this.fee_id, (Object) feeInfoItem.fee_id) || !equals((Object) this.fee_color, (Object) feeInfoItem.fee_color) || !equals((Object) this.fee_key, (Object) feeInfoItem.fee_key) || !equals((Object) this.is_edit, (Object) feeInfoItem.is_edit) || !equals((Object) this.is_base_fee, (Object) feeInfoItem.is_base_fee) || !equals((Object) this.fee_api, (Object) feeInfoItem.fee_api) || !equals((Object) this.extra_info, (Object) feeInfoItem.extra_info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.fee_label;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.fee_value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.fee_type;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.fee_url;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.fee_cust;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str4 = this.fee_id;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.fee_color;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.fee_key;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num3 = this.is_edit;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.is_base_fee;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str7 = this.fee_api;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.extra_info;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.FeeInfoItem$Builder */
    public static final class Builder extends Message.Builder<FeeInfoItem> {
        public String extra_info;
        public String fee_api;
        public String fee_color;
        public Integer fee_cust;
        public String fee_id;
        public String fee_key;
        public String fee_label;
        public Integer fee_type;
        public String fee_url;
        public String fee_value;
        public Integer is_base_fee;
        public Integer is_edit;

        public Builder() {
        }

        public Builder(FeeInfoItem feeInfoItem) {
            super(feeInfoItem);
            if (feeInfoItem != null) {
                this.fee_label = feeInfoItem.fee_label;
                this.fee_value = feeInfoItem.fee_value;
                this.fee_type = feeInfoItem.fee_type;
                this.fee_url = feeInfoItem.fee_url;
                this.fee_cust = feeInfoItem.fee_cust;
                this.fee_id = feeInfoItem.fee_id;
                this.fee_color = feeInfoItem.fee_color;
                this.fee_key = feeInfoItem.fee_key;
                this.is_edit = feeInfoItem.is_edit;
                this.is_base_fee = feeInfoItem.is_base_fee;
                this.fee_api = feeInfoItem.fee_api;
                this.extra_info = feeInfoItem.extra_info;
            }
        }

        public Builder fee_label(String str) {
            this.fee_label = str;
            return this;
        }

        public Builder fee_value(String str) {
            this.fee_value = str;
            return this;
        }

        public Builder fee_type(Integer num) {
            this.fee_type = num;
            return this;
        }

        public Builder fee_url(String str) {
            this.fee_url = str;
            return this;
        }

        public Builder fee_cust(Integer num) {
            this.fee_cust = num;
            return this;
        }

        public Builder fee_id(String str) {
            this.fee_id = str;
            return this;
        }

        public Builder fee_color(String str) {
            this.fee_color = str;
            return this;
        }

        public Builder fee_key(String str) {
            this.fee_key = str;
            return this;
        }

        public Builder is_edit(Integer num) {
            this.is_edit = num;
            return this;
        }

        public Builder is_base_fee(Integer num) {
            this.is_base_fee = num;
            return this;
        }

        public Builder fee_api(String str) {
            this.fee_api = str;
            return this;
        }

        public Builder extra_info(String str) {
            this.extra_info = str;
            return this;
        }

        public FeeInfoItem build() {
            checkRequiredFields();
            return new FeeInfoItem(this);
        }
    }
}
