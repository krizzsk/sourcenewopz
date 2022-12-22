package com.sdk.poibase.model.guideentrance;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.request.ServerParam;
import com.sdk.poibase.model.HttpParamBase;
import java.util.HashMap;

public class GuideEntranceParam extends HttpParamBase {
    public int battery;
    public int batteryStatus;
    public int heading;
    public int height;
    public int isArAcoreSupported;
    public int isCarpool;
    public String model;
    public String networkType;
    public String orderId;
    public int orderStatus;
    public String orderType;
    public String platformVersion;
    public String poiInfo;
    public int width;

    public HashMap<String, Object> getParamMap(Context context) {
        HashMap<String, Object> baseParamMap = super.getBaseParamMap(context);
        baseParamMap.put("is_carpool", Integer.valueOf(this.isCarpool));
        baseParamMap.put("order_id", this.orderId);
        baseParamMap.put("order_status", Integer.valueOf(this.orderStatus));
        baseParamMap.put("order_type", this.orderType);
        baseParamMap.put("passenger_id", this.uid);
        baseParamMap.put("model", this.model);
        baseParamMap.put("platform_version", this.platformVersion);
        baseParamMap.put(ServerParam.PARAM_NETWORK_TYPE, this.networkType);
        baseParamMap.put("battery", Integer.valueOf(this.battery));
        baseParamMap.put("battery_status", Integer.valueOf(this.batteryStatus));
        baseParamMap.put("arcore_is_supported", Integer.valueOf(this.isArAcoreSupported));
        baseParamMap.put("height", Integer.valueOf(this.height));
        baseParamMap.put("width", Integer.valueOf(this.width));
        baseParamMap.put("heading", Integer.valueOf(this.heading));
        return baseParamMap;
    }

    public HashMap<String, Object> getBodyMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(this.poiInfo)) {
            hashMap.put("poi_info", this.poiInfo);
        }
        return hashMap;
    }

    public String toString() {
        return "GuideEntranceParam{poi_info='" + this.poiInfo + '\'' + ", is_carpool=" + this.isCarpool + ", productId='" + this.productId + '\'' + ", appVersion='" + this.appVersion + '\'' + ", mapType='" + this.mapType + '\'' + ", coordinateType='" + this.coordinate_type + '\'' + ", requesterType='" + this.requester_type + '\'' + ", select_lng='" + this.select_lng + '\'' + ", select_lat='" + this.select_lat + '\'' + ", phone='" + this.phone + '\'' + ", token='" + this.token + '\'' + ", lang='" + this.lang + '\'' + '}';
    }
}
