package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OspreyDriverDiffInfo extends Message {
    public static final Integer DEFAULT_BUFF = 0;
    public static final String DEFAULT_BUFF_DESC = "";
    public static final Integer DEFAULT_LENG = 0;
    public static final String DEFAULT_LENG_DESC = "";
    public static final String DEFAULT_LICENSE = "";
    public static final Integer DEFAULT_MULTI = 0;
    public static final String DEFAULT_MULTI_DESC = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NEW_MULTI = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer buff;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String buff_desc;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer leng;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String leng_desc;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String license;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer multi;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String multi_desc;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String new_multi;

    public OspreyDriverDiffInfo(Integer num, Integer num2, Integer num3, String str, String str2, String str3, String str4, String str5, String str6) {
        this.multi = num;
        this.leng = num2;
        this.buff = num3;
        this.name = str;
        this.license = str2;
        this.multi_desc = str3;
        this.leng_desc = str4;
        this.buff_desc = str5;
        this.new_multi = str6;
    }

    private OspreyDriverDiffInfo(Builder builder) {
        this(builder.multi, builder.leng, builder.buff, builder.name, builder.license, builder.multi_desc, builder.leng_desc, builder.buff_desc, builder.new_multi);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OspreyDriverDiffInfo)) {
            return false;
        }
        OspreyDriverDiffInfo ospreyDriverDiffInfo = (OspreyDriverDiffInfo) obj;
        if (!equals((Object) this.multi, (Object) ospreyDriverDiffInfo.multi) || !equals((Object) this.leng, (Object) ospreyDriverDiffInfo.leng) || !equals((Object) this.buff, (Object) ospreyDriverDiffInfo.buff) || !equals((Object) this.name, (Object) ospreyDriverDiffInfo.name) || !equals((Object) this.license, (Object) ospreyDriverDiffInfo.license) || !equals((Object) this.multi_desc, (Object) ospreyDriverDiffInfo.multi_desc) || !equals((Object) this.leng_desc, (Object) ospreyDriverDiffInfo.leng_desc) || !equals((Object) this.buff_desc, (Object) ospreyDriverDiffInfo.buff_desc) || !equals((Object) this.new_multi, (Object) ospreyDriverDiffInfo.new_multi)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.multi;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.leng;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.buff;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.license;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.multi_desc;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.leng_desc;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.buff_desc;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.new_multi;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OspreyDriverDiffInfo> {
        public Integer buff;
        public String buff_desc;
        public Integer leng;
        public String leng_desc;
        public String license;
        public Integer multi;
        public String multi_desc;
        public String name;
        public String new_multi;

        public Builder() {
        }

        public Builder(OspreyDriverDiffInfo ospreyDriverDiffInfo) {
            super(ospreyDriverDiffInfo);
            if (ospreyDriverDiffInfo != null) {
                this.multi = ospreyDriverDiffInfo.multi;
                this.leng = ospreyDriverDiffInfo.leng;
                this.buff = ospreyDriverDiffInfo.buff;
                this.name = ospreyDriverDiffInfo.name;
                this.license = ospreyDriverDiffInfo.license;
                this.multi_desc = ospreyDriverDiffInfo.multi_desc;
                this.leng_desc = ospreyDriverDiffInfo.leng_desc;
                this.buff_desc = ospreyDriverDiffInfo.buff_desc;
                this.new_multi = ospreyDriverDiffInfo.new_multi;
            }
        }

        public Builder multi(Integer num) {
            this.multi = num;
            return this;
        }

        public Builder leng(Integer num) {
            this.leng = num;
            return this;
        }

        public Builder buff(Integer num) {
            this.buff = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder license(String str) {
            this.license = str;
            return this;
        }

        public Builder multi_desc(String str) {
            this.multi_desc = str;
            return this;
        }

        public Builder leng_desc(String str) {
            this.leng_desc = str;
            return this;
        }

        public Builder buff_desc(String str) {
            this.buff_desc = str;
            return this;
        }

        public Builder new_multi(String str) {
            this.new_multi = str;
            return this;
        }

        public OspreyDriverDiffInfo build() {
            checkRequiredFields();
            return new OspreyDriverDiffInfo(this);
        }
    }
}
