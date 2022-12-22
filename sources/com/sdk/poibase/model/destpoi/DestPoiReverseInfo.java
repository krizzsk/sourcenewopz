package com.sdk.poibase.model.destpoi;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.RpcPoi;
import java.util.ArrayList;

public class DestPoiReverseInfo extends HttpResultBase {
    @SerializedName("city")
    public String city;
    @SerializedName("city_id")
    public int cityId;
    @SerializedName("country_code")
    public String countryCode;
    @SerializedName("country_id")
    public String countryId;
    @SerializedName("lang")
    public String language;
    @SerializedName("rec_end_points")
    public ArrayList<RpcPoi> recEndPoints;
    @SerializedName("rgeo_result")
    public ArrayList<RpcPoi> result;
    @SerializedName("search_id")
    public String searchId;

    public String toString() {
        return "DestPoiReverseInfo{searchId='" + this.searchId + '\'' + ", language='" + this.language + '\'' + ", countryId='" + this.countryId + '\'' + ", countryCode='" + this.countryCode + '\'' + ", cityId=" + this.cityId + ", city='" + this.city + '\'' + ", result=" + this.result + ", recEndPoints=" + this.recEndPoints + '}';
    }
}
