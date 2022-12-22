package com.sdk.poibase.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.util.SystemUtil;
import java.util.HashMap;

public class HttpParamBase {
    public float accuracy;
    public String appVersion = "";
    public int cityId;
    public String coordinate_type = "wgs84";
    public String countryId;
    public String lang = "";
    public String mapType = "gmap";
    public String phone = "";
    public String productId = "";
    public String provider = "";
    public String requester_type = "1";
    public double select_lat;
    public double select_lng;
    public String token = "";
    public String uid = "";
    public double user_loc_lat;
    public double user_loc_lng;

    public HashMap<String, Object> getBaseParamMap(Context context) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("product_id", this.productId);
        hashMap.put("app_version", this.appVersion);
        hashMap.put("platform", "2");
        hashMap.put("app_id", context.getPackageName());
        hashMap.put("map_type", this.mapType);
        if (!TextUtils.isEmpty(this.coordinate_type)) {
            hashMap.put("coordinate_type", this.coordinate_type);
        }
        if (!TextUtils.isEmpty(this.requester_type)) {
            hashMap.put("requester_type", this.requester_type);
        }
        hashMap.put("select_lng", Double.valueOf(this.select_lng));
        hashMap.put("select_lat", Double.valueOf(this.select_lat));
        hashMap.put("user_loc_lng", Double.valueOf(this.user_loc_lng));
        hashMap.put("user_loc_lat", Double.valueOf(this.user_loc_lat));
        hashMap.put("user_loc_accuracy", Float.valueOf(this.accuracy));
        hashMap.put("user_loc_provider", this.provider);
        hashMap.put("phone", this.phone);
        hashMap.put("token", this.token);
        hashMap.put("lang", this.lang);
        hashMap.put("imei", SystemUtil.getIMEI());
        return hashMap;
    }
}
