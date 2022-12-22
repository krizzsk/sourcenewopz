package com.sdk.poibase.model.local;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.util.SystemUtil;
import java.io.Serializable;
import java.util.HashMap;

public class PsnPickupParam implements Serializable {
    public float accuracy;
    public String coordinateType;
    public String data;
    public String mapSdkType;
    public int opType;
    public String orderId;
    public String phoneNum;
    public int productid;
    public String provider;
    public String requsterType;
    public double reverseLat;
    public double reverseLng;
    public String token;
    public double userLat;
    public double userLng;

    public HashMap<String, Object> getParamMap(Context context) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("lat", Double.valueOf(this.reverseLat));
        hashMap.put("lng", Double.valueOf(this.reverseLng));
        hashMap.put("product_id", Integer.valueOf(this.productid));
        hashMap.put("app_version", SystemUtil.getVersionName());
        hashMap.put("platform", "android");
        hashMap.put("app_id", context.getPackageName());
        hashMap.put("map_type", this.mapSdkType);
        hashMap.put("coordinate_type", this.coordinateType);
        hashMap.put("requester_type", this.requsterType);
        hashMap.put("select_lng", Double.valueOf(this.reverseLng));
        hashMap.put("select_lat", Double.valueOf(this.reverseLat));
        hashMap.put("phone", this.phoneNum);
        hashMap.put("token", this.token);
        hashMap.put("lang", LocaleCodeHolder.getInstance().getCurrentLang());
        if (!TextUtils.isEmpty(this.provider) || Float.compare(this.accuracy, 0.0f) != 0) {
            hashMap.put("user_loc_lng", Double.valueOf(this.userLng));
            hashMap.put("user_loc_lat", Double.valueOf(this.userLat));
            hashMap.put("user_loc_accuracy", Float.valueOf(this.accuracy));
            hashMap.put("user_loc_provider", this.provider);
        }
        hashMap.put("order_id", this.orderId);
        hashMap.put("op_type", Integer.valueOf(this.opType));
        hashMap.put("data", this.data);
        return hashMap;
    }
}
