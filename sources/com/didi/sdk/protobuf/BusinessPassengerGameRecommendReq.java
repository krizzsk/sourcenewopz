package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BusinessPassengerGameRecommendReq extends Message {
    public static final String DEFAULT_DESCRIBE = "";
    public static final String DEFAULT_DOWN_URL_AD = "";
    public static final String DEFAULT_DOWN_URL_IOS = "";
    public static final String DEFAULT_GAME_ID = "";
    public static final String DEFAULT_H5_URL = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_INTERFACE_NAME = "";
    public static final String DEFAULT_PACKAGE_NAME = "";
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String describe;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String down_url_ad;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String down_url_ios;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.STRING)
    public final String game_id;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String h5_url;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String icon_url;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String interface_name;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String package_name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.UINT32)
    public final Integer type;

    public BusinessPassengerGameRecommendReq(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.icon_url = str;
        this.title = str2;
        this.describe = str3;
        this.type = num;
        this.game_id = str4;
        this.package_name = str5;
        this.interface_name = str6;
        this.h5_url = str7;
        this.down_url_ad = str8;
        this.down_url_ios = str9;
    }

    private BusinessPassengerGameRecommendReq(Builder builder) {
        this(builder.icon_url, builder.title, builder.describe, builder.type, builder.game_id, builder.package_name, builder.interface_name, builder.h5_url, builder.down_url_ad, builder.down_url_ios);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BusinessPassengerGameRecommendReq)) {
            return false;
        }
        BusinessPassengerGameRecommendReq businessPassengerGameRecommendReq = (BusinessPassengerGameRecommendReq) obj;
        if (!equals((Object) this.icon_url, (Object) businessPassengerGameRecommendReq.icon_url) || !equals((Object) this.title, (Object) businessPassengerGameRecommendReq.title) || !equals((Object) this.describe, (Object) businessPassengerGameRecommendReq.describe) || !equals((Object) this.type, (Object) businessPassengerGameRecommendReq.type) || !equals((Object) this.game_id, (Object) businessPassengerGameRecommendReq.game_id) || !equals((Object) this.package_name, (Object) businessPassengerGameRecommendReq.package_name) || !equals((Object) this.interface_name, (Object) businessPassengerGameRecommendReq.interface_name) || !equals((Object) this.h5_url, (Object) businessPassengerGameRecommendReq.h5_url) || !equals((Object) this.down_url_ad, (Object) businessPassengerGameRecommendReq.down_url_ad) || !equals((Object) this.down_url_ios, (Object) businessPassengerGameRecommendReq.down_url_ios)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.icon_url;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.describe;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str4 = this.game_id;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.package_name;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.interface_name;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.h5_url;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.down_url_ad;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.down_url_ios;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BusinessPassengerGameRecommendReq> {
        public String describe;
        public String down_url_ad;
        public String down_url_ios;
        public String game_id;
        public String h5_url;
        public String icon_url;
        public String interface_name;
        public String package_name;
        public String title;
        public Integer type;

        public Builder() {
        }

        public Builder(BusinessPassengerGameRecommendReq businessPassengerGameRecommendReq) {
            super(businessPassengerGameRecommendReq);
            if (businessPassengerGameRecommendReq != null) {
                this.icon_url = businessPassengerGameRecommendReq.icon_url;
                this.title = businessPassengerGameRecommendReq.title;
                this.describe = businessPassengerGameRecommendReq.describe;
                this.type = businessPassengerGameRecommendReq.type;
                this.game_id = businessPassengerGameRecommendReq.game_id;
                this.package_name = businessPassengerGameRecommendReq.package_name;
                this.interface_name = businessPassengerGameRecommendReq.interface_name;
                this.h5_url = businessPassengerGameRecommendReq.h5_url;
                this.down_url_ad = businessPassengerGameRecommendReq.down_url_ad;
                this.down_url_ios = businessPassengerGameRecommendReq.down_url_ios;
            }
        }

        public Builder icon_url(String str) {
            this.icon_url = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder describe(String str) {
            this.describe = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder game_id(String str) {
            this.game_id = str;
            return this;
        }

        public Builder package_name(String str) {
            this.package_name = str;
            return this;
        }

        public Builder interface_name(String str) {
            this.interface_name = str;
            return this;
        }

        public Builder h5_url(String str) {
            this.h5_url = str;
            return this;
        }

        public Builder down_url_ad(String str) {
            this.down_url_ad = str;
            return this;
        }

        public Builder down_url_ios(String str) {
            this.down_url_ios = str;
            return this;
        }

        public BusinessPassengerGameRecommendReq build() {
            checkRequiredFields();
            return new BusinessPassengerGameRecommendReq(this);
        }
    }
}
