package com.sdk.poibase.model.reverse;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.RpcPoi;
import java.util.ArrayList;

public class ReverseGeoResult extends HttpResultBase {
    @SerializedName("canonical_country_code")
    public String canonicalCountryCode;
    @SerializedName("city")
    public String city;
    @SerializedName("city_id")
    public int cityId = -1;
    @SerializedName("country_code")
    public String countryCode;
    @SerializedName("country_id")
    public int countryId = -1;
    @SerializedName("rgeo_result")
    public ArrayList<RpcPoi> result;
    @SerializedName("search_id")
    public String searchId;
}
