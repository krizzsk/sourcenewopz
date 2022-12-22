package com.sdk.poibase.model.poi;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.common.net.CarServerParam;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.HttpParamBase;
import com.sdk.poibase.model.wifi.WifiInfoParam;
import com.sdk.poibase.util.CellInfoUtil;
import com.sdk.poibase.util.DestInfoUtil;
import com.sdk.poibase.util.DidiLocUtil;
import com.sdk.poibase.util.LocTrackUtil;
import com.sdk.poibase.util.SatelliteManager;
import com.sdk.poibase.util.Utils;
import java.io.Serializable;
import java.util.HashMap;

public class PoiInfoParam extends HttpParamBase implements Serializable {
    public int appAutoCall;
    public CallFrom callFrom = CallFrom.UNKNOWN;
    public long departureTime;
    public Address destInfo;
    public String entrance;
    public boolean isFence;
    public boolean isFirstLaunch;
    public boolean isNeedNLP;
    public String locStrategy;
    public long localTime;
    public String poiInfo;
    public String source;
    public int timeOut;
    public int userOperationType;

    public String toString() {
        return "PoiInfoParam{productid=" + this.productId + ", mapSdkType='" + this.mapType + '\'' + ", coordinateType='" + this.coordinate_type + '\'' + ", reverseLng=" + this.select_lng + ", reverseLat=" + this.select_lat + ", userLng=" + this.user_loc_lng + ", userLat=" + this.user_loc_lat + ", accuracy=" + this.accuracy + ", provider='" + this.provider + '\'' + ", phoneNum='" + this.phone + '\'' + ", passengerId='" + this.uid + '\'' + ", isFirstLaunch=" + this.isFirstLaunch + ", isFence=" + this.isFence + ", token='" + this.token + '\'' + ", departureTime=" + this.departureTime + ", lang='" + this.lang + '\'' + ", requsterType='" + this.requester_type + '\'' + ", userOperationType=" + this.userOperationType + ", poiInfo='" + this.poiInfo + '\'' + ", localTime='" + this.localTime + '\'' + ", source='" + this.source + '\'' + ", loc_Strategy='" + this.locStrategy + '\'' + ", app_auto_call='" + this.appAutoCall + '\'' + ", isNeedNLP='" + this.isNeedNLP + '\'' + ", timeOut='" + this.timeOut + '\'' + '}';
    }

    private boolean initUserLoc(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return false;
        }
        this.user_loc_lng = dIDILocation.getLongitude();
        this.user_loc_lat = dIDILocation.getLatitude();
        this.source = dIDILocation.getSource();
        this.accuracy = dIDILocation.getAccuracy();
        this.provider = dIDILocation.getProvider();
        if (dIDILocation.getExtra() == null) {
            return true;
        }
        this.locStrategy = String.valueOf(dIDILocation.getExtra().getLong(DIDILocation.EXTRA_KEY_STRATEGY_FLAGS));
        return true;
    }

    public HashMap<String, Object> getParamMap(Context context, DIDILocation dIDILocation, int i) {
        Utils.logInfo("PoiInfoParam getParamMap() this: " + this);
        HashMap<String, Object> baseParamMap = getBaseParamMap(context);
        baseParamMap.put("user_operation_type", Integer.valueOf(this.userOperationType));
        baseParamMap.put("local_time", Long.valueOf(this.localTime));
        CallFrom callFrom2 = this.callFrom;
        if (callFrom2 != null) {
            baseParamMap.put(CarServerParam.PARAM_CALL_FROM, callFrom2.toString());
        }
        if (initUserLoc(dIDILocation)) {
            if (!TextUtils.isEmpty(this.provider) || Float.compare(this.accuracy, 0.0f) != 0) {
                baseParamMap.put("user_loc_lng", Double.valueOf(this.user_loc_lng));
                baseParamMap.put("user_loc_lat", Double.valueOf(this.user_loc_lat));
                baseParamMap.put("user_loc_accuracy", Float.valueOf(this.accuracy));
                baseParamMap.put("user_loc_provider", this.provider);
            }
            if (this.callFrom == CallFrom.PICKUP_PAGE) {
                String str = "";
                baseParamMap.put("source", TextUtils.isEmpty(this.source) ? str : this.source);
                if (!TextUtils.isEmpty(this.locStrategy)) {
                    str = this.locStrategy;
                }
                baseParamMap.put("loc_strategy", str);
                baseParamMap.put("app_auto_call", Integer.valueOf(this.appAutoCall));
            }
        }
        baseParamMap.put("is_first_launch", Integer.valueOf(this.isFirstLaunch ? 1 : 0));
        baseParamMap.put("is_fence", Integer.valueOf(this.isFence ? 1 : 0));
        baseParamMap.put("passenger_id", this.uid);
        baseParamMap.put("departure_time", Long.valueOf(this.departureTime));
        baseParamMap.put("adjust_user_loc", Integer.valueOf(i));
        return baseParamMap;
    }

    public HashMap<String, Object> getBodyMap(Context context, DIDILocation dIDILocation) {
        String lastSatellitesInfo;
        String wifiParam;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!isBubblePageStation() && !TextUtils.isEmpty(this.poiInfo)) {
            hashMap.put("poi_info", this.poiInfo);
        }
        String locTrackJson = LocTrackUtil.getLocTrackJson(this.appVersion);
        if (!TextUtils.isEmpty(locTrackJson)) {
            hashMap.put("loc_track", locTrackJson);
        }
        if (enableTransferWifiAndSatelliteInfo() && !isBubblePageStation() && (wifiParam = WifiInfoParam.getWifiParam(context)) != null) {
            hashMap.put("wifi_info", wifiParam);
        }
        if (enableTransferWifiAndSatelliteInfo() && (lastSatellitesInfo = SatelliteManager.getInstance(context).getLastSatellitesInfo()) != null) {
            hashMap.put("satellite_info", lastSatellitesInfo);
        }
        String cellInfoJson = CellInfoUtil.getCellInfoJson();
        SystemUtils.log(3, "sfs-poiinfo", "cellInfo: " + cellInfoJson, (Throwable) null, "com.sdk.poibase.model.poi.PoiInfoParam", 218);
        if (!TextUtils.isEmpty(cellInfoJson)) {
            hashMap.put("cell_info", cellInfoJson);
        }
        String didiLocJson = DidiLocUtil.getDidiLocJson(dIDILocation);
        SystemUtils.log(3, "sfs-poiinfo", "didiLocInfo: " + didiLocJson, (Throwable) null, "com.sdk.poibase.model.poi.PoiInfoParam", 224);
        if (!TextUtils.isEmpty(didiLocJson)) {
            hashMap.put("didi_loc_info", didiLocJson);
        }
        if (!isBubblePageStation()) {
            if (this.destInfo != null) {
                hashMap.put("dest_info", DestInfoUtil.INSTANCE.getDestInfo(this.destInfo));
                SystemUtils.log(6, "ccc", "dest_info= " + DestInfoUtil.INSTANCE.getDestInfo(this.destInfo), (Throwable) null, "com.sdk.poibase.model.poi.PoiInfoParam", 232);
            } else {
                SystemUtils.log(6, "ccc", "dest_info= null", (Throwable) null, "com.sdk.poibase.model.poi.PoiInfoParam", 234);
            }
        }
        return hashMap;
    }

    private boolean enableTransferWifiAndSatelliteInfo() {
        return this.callFrom != CallFrom.GLOBAL_HOMEPAGE_STATION;
    }

    private boolean isBubblePageStation() {
        return this.callFrom == CallFrom.GLOBAL_BUBBLEPAGE_STATION;
    }
}
