package com.sdk.poibase.model.poi;

import com.didi.sdk.util.collection.CollectionUtil;
import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.RpcPoi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ReverseStationsInfo extends HttpResultBase {
    @SerializedName("around_fence_list")
    public ArrayList<AroundFenceInfo> aroundFenceList;
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
    @SerializedName("geofence")
    public GeoFence geoFence;
    @SerializedName("location_tags")
    public ArrayList<String> geofenceTags;
    @SerializedName("lang")
    public String language;
    @SerializedName("loc_level")
    public String locLevel = "good";
    @SerializedName("rec_destination")
    public ArrayList<RpcPoi> recDestination;
    @SerializedName("rec_start_points")
    public ArrayList<RpcPoi> recStartPoints;
    @SerializedName("rec_ripple")
    public int recomRipple = 0;
    @SerializedName("rgeo_result")
    public ArrayList<RpcPoi> result;
    @SerializedName("search_id")
    public String searchId;
    @SerializedName("main_scene_show_station_info")
    public int showStationInfo;
    @SerializedName("special_poi_info")
    public SpecialPoiGuidance specialPoiGuidance;
    @SerializedName("special_poi_list")
    public String specialPoiList;
    @SerializedName("rec_start_fence_info")
    public FenceInfo startFenceInfo;
    @SerializedName("station_info")
    public StationInfo stationInfo;

    public ArrayList<RpcPoi> getRecStartPoints() {
        if (CollectionUtil.isEmpty((Collection<?>) this.recStartPoints)) {
            return this.recStartPoints;
        }
        Iterator<RpcPoi> it = this.recStartPoints.iterator();
        while (it.hasNext()) {
            it.next().searchId = this.searchId;
        }
        return this.recStartPoints;
    }

    public RpcPoi getDepartureAddress() {
        RpcPoi rpcPoi = !CollectionUtil.isEmpty((Collection<?>) this.result) ? this.result.get(0) : null;
        if (rpcPoi != null) {
            rpcPoi.searchId = this.searchId;
        }
        return rpcPoi;
    }

    public ArrayList<RpcPoi> getList() {
        if (CollectionUtil.isEmpty((Collection<?>) this.result)) {
            return this.result;
        }
        Iterator<RpcPoi> it = this.result.iterator();
        while (it.hasNext()) {
            it.next().searchId = this.searchId;
        }
        return this.result;
    }

    public String toString() {
        return "ReverseStationsInfo{countryId=" + this.countryId + ", countryCode='" + this.countryCode + '\'' + ", canonicalCountryCode='" + this.canonicalCountryCode + '\'' + ", cityId=" + this.cityId + ", city='" + this.city + '\'' + ", geoFence=" + this.geoFence + ", geofenceTags=" + this.geofenceTags + ", recomRipple=" + this.recomRipple + ", result=" + this.result + ", recStartPoints=" + this.recStartPoints + ", showStationInfo=" + this.showStationInfo + ", startFenceInfo=" + this.startFenceInfo + ", recDestination=" + this.recDestination + ", specialPoiGuidance=" + this.specialPoiGuidance + ", specialPoiList='" + this.specialPoiList + '\'' + ", stationInfo=" + this.stationInfo + ", searchId='" + this.searchId + '\'' + ", language='" + this.language + '\'' + ", errno=" + this.errno + ", errmsg='" + this.errmsg + '\'' + '}';
    }
}
