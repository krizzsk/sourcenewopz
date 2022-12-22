package com.didi.sdk.push.common;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class UploadThirdIdParams {
    public static int APP_TYPE_GUARANA_DRIVER = 1007;
    public static int APP_TYPE_GUARANA_PASSENGER = 1006;
    public static int APP_TYPE_ZHUANKUAI_DRIVER = 2;
    public int app_type;
    public String appversion = "";
    public int area_id = -1;
    public String brand_id = "";
    public String cid = "";
    public String deviceToken = "";
    public String device_id = "";
    private HashMap<String, Object> extraParams;
    public String fcm_id = "";
    public long firstOpenTime = 0;
    public FoodTabParams foodTabParams;
    public String host = "";
    public String huawei_token = "";
    public String imei = "";
    public double lat;
    public int legalAgreement = -1;
    public long legalAgreementTime = 0;
    public double lng;
    public String testHost = "";

    public Map<String, Object> getExtras() {
        return this.extraParams;
    }

    public void addExtra(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (this.extraParams == null) {
                this.extraParams = new HashMap<>();
            }
            this.extraParams.put(str, obj);
        }
    }

    public void addExtras(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            if (this.extraParams == null) {
                this.extraParams = new HashMap<>();
            }
            this.extraParams.putAll(map);
        }
    }

    public void removeExtra(String str) {
        HashMap<String, Object> hashMap;
        if (!TextUtils.isEmpty(str) && (hashMap = this.extraParams) != null) {
            hashMap.remove(str);
        }
    }

    public String toString() {
        return "UploadThirdIdParams{cid='" + this.cid + '\'' + ", brand_id='" + this.brand_id + '\'' + ", fcm_id='" + this.fcm_id + '\'' + ", imei='" + this.imei + '\'' + ", area_id=" + this.area_id + ", appversion='" + this.appversion + '\'' + ", app_type=" + this.app_type + ", testHost='" + this.testHost + '\'' + ", host='" + this.host + '\'' + ", device_id='" + this.device_id + '\'' + ", extraParams=" + this.extraParams + '}';
    }
}
