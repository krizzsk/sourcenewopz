package com.didi.trackupload.sdk.datachannel.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class City extends Message {
    public static final String DEFAULT_CANONICAL_COUNTRY_CODE = "";
    public static final Integer DEFAULT_CITYID = 0;
    public static final String DEFAULT_CITY_DESC = "";
    public static final Integer DEFAULT_COUNTRYID = 0;
    public static final String DEFAULT_COUNTRY_DESC = "";
    public static final String DEFAULT_COUNTRY_ISO_CODE = "";
    public static final Integer DEFAULT_COUNTYID = 0;
    public static final String DEFAULT_COUNTY_DESC = "";
    public static final Integer DEFAULT_PROVINCEID = 0;
    public static final String DEFAULT_PROVINCE_DESC = "";
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String canonical_country_code;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String city_desc;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer cityid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country_desc;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country_iso_code;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer countryid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String county_desc;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT32)
    public final Integer countyid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String province_desc;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer provinceid;

    public City(Integer num, String str, Integer num2, String str2, Integer num3, String str3, Integer num4, String str4, String str5, String str6) {
        this.cityid = num;
        this.city_desc = str;
        this.countyid = num2;
        this.county_desc = str2;
        this.countryid = num3;
        this.country_desc = str3;
        this.provinceid = num4;
        this.province_desc = str4;
        this.country_iso_code = str5;
        this.canonical_country_code = str6;
    }

    private City(Builder builder) {
        this(builder.cityid, builder.city_desc, builder.countyid, builder.county_desc, builder.countryid, builder.country_desc, builder.provinceid, builder.province_desc, builder.country_iso_code, builder.canonical_country_code);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof City)) {
            return false;
        }
        City city = (City) obj;
        if (!equals((Object) this.cityid, (Object) city.cityid) || !equals((Object) this.city_desc, (Object) city.city_desc) || !equals((Object) this.countyid, (Object) city.countyid) || !equals((Object) this.county_desc, (Object) city.county_desc) || !equals((Object) this.countryid, (Object) city.countryid) || !equals((Object) this.country_desc, (Object) city.country_desc) || !equals((Object) this.provinceid, (Object) city.provinceid) || !equals((Object) this.province_desc, (Object) city.province_desc) || !equals((Object) this.country_iso_code, (Object) city.country_iso_code) || !equals((Object) this.canonical_country_code, (Object) city.canonical_country_code)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.cityid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.city_desc;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.countyid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.county_desc;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.countryid;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.country_desc;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num4 = this.provinceid;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str4 = this.province_desc;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.country_iso_code;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.canonical_country_code;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<City> {
        public String canonical_country_code;
        public String city_desc;
        public Integer cityid;
        public String country_desc;
        public String country_iso_code;
        public Integer countryid;
        public String county_desc;
        public Integer countyid;
        public String province_desc;
        public Integer provinceid;

        public Builder() {
        }

        public Builder(City city) {
            super(city);
            if (city != null) {
                this.cityid = city.cityid;
                this.city_desc = city.city_desc;
                this.countyid = city.countyid;
                this.county_desc = city.county_desc;
                this.countryid = city.countryid;
                this.country_desc = city.country_desc;
                this.provinceid = city.provinceid;
                this.province_desc = city.province_desc;
                this.country_iso_code = city.country_iso_code;
                this.canonical_country_code = city.canonical_country_code;
            }
        }

        public Builder cityid(Integer num) {
            this.cityid = num;
            return this;
        }

        public Builder city_desc(String str) {
            this.city_desc = str;
            return this;
        }

        public Builder countyid(Integer num) {
            this.countyid = num;
            return this;
        }

        public Builder county_desc(String str) {
            this.county_desc = str;
            return this;
        }

        public Builder countryid(Integer num) {
            this.countryid = num;
            return this;
        }

        public Builder country_desc(String str) {
            this.country_desc = str;
            return this;
        }

        public Builder provinceid(Integer num) {
            this.provinceid = num;
            return this;
        }

        public Builder province_desc(String str) {
            this.province_desc = str;
            return this;
        }

        public Builder country_iso_code(String str) {
            this.country_iso_code = str;
            return this;
        }

        public Builder canonical_country_code(String str) {
            this.canonical_country_code = str;
            return this;
        }

        public City build() {
            checkRequiredFields();
            return new City(this);
        }
    }
}
