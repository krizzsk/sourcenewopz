package com.sdk.poibase.model.guideentrance;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.HttpResultBase;
import java.io.Serializable;
import java.util.ArrayList;

public class GuideEntranceResult extends HttpResultBase {
    @SerializedName("avail_display_types")
    public ArrayList<EntranceType> availDisplayTypes;
    @SerializedName("canonical_country_code")
    public String canonicalCountryCode;
    @SerializedName("city")
    public String city;
    @SerializedName("city_id")
    public int cityId;
    @SerializedName("country_code")
    public String countryCode;
    @SerializedName("country_id")
    public int countryId;
    @SerializedName("search_id")
    public String searchId;

    public class EntranceType implements Serializable {
        @SerializedName("extend_info")
        public ExtendInfo extendInfo;
        @SerializedName("type")
        public int type;
        @SerializedName("type_desc")
        public String typeDesc;

        public EntranceType() {
        }

        public String toString() {
            return "GuideType{type=" + this.type + ", extend_info='" + this.extendInfo + '\'' + '}';
        }
    }

    public class ExtendInfo implements Serializable {
        @SerializedName("street_view_url")
        public String streetViewUrl;
        @SerializedName("tripid")
        public String tripId;
        @SerializedName("walk_guide_link")
        public String walkGuideLink;
        @SerializedName("walk_guide_photo")
        public String walkGuidePhoto;

        public ExtendInfo() {
        }

        public String toString() {
            return "ExtendInfo{walkGuideLink='" + this.walkGuideLink + '\'' + ", walkGuidePhoto='" + this.walkGuidePhoto + '\'' + ", tripId='" + this.tripId + '\'' + ", streetViewUrl='" + this.streetViewUrl + '\'' + '}';
        }
    }

    public String toString() {
        return "GuideEntranceResult{searchId='" + this.searchId + '\'' + ", countryId=" + this.countryId + ", countryCode='" + this.countryCode + '\'' + ", canonicalCountryCode='" + this.canonicalCountryCode + '\'' + ", cityId=" + this.cityId + ", city='" + this.city + '\'' + ", availDisplayTypes=" + this.availDisplayTypes + '}';
    }
}
