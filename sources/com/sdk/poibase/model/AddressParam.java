package com.sdk.poibase.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.SystemUtil;
import com.sdk.poibase.model.wifi.WifiInfoParam;
import com.sdk.poibase.util.CellInfoUtil;
import com.sdk.poibase.util.LocTrackUtil;
import com.sdk.poibase.util.SatelliteManager;
import com.sdk.poibase.util.Utils;
import java.io.Serializable;
import java.util.HashMap;

public class AddressParam extends HttpParamBase implements Serializable, Cloneable {
    public static final int ADDRESS_TYPE_COMMON = 5;
    public static final int ADDRESS_TYPE_COMPANY = 4;
    public static final int ADDRESS_TYPE_END = 2;
    public static final int ADDRESS_TYPE_HOME = 3;
    public static final int ADDRESS_TYPE_START = 1;
    public static final int ADDRESS_TYPE_WAYPOINT = 6;
    public static final int ADDRESS_TYPE_WAYPOINT_1 = 101;
    public static final int ADDRESS_TYPE_WAYPOINT_2 = 102;
    private static final int QUERY_TYPE_COMMON = 3;
    private static final int QUERY_TYPE_COMPANY = 5;
    private static final int QUERY_TYPE_CURRENT = 2;
    private static final int QUERY_TYPE_END = 1;
    private static final int QUERY_TYPE_HOME = 4;
    private static final int QUERY_TYPE_START = 0;
    private static final int QUERY_TYPE_UNKNOWN = 8;
    public int addressType = -1;
    public String assist;
    public int callFrom;
    public Address currentAddress;
    public String departure_time;
    public int isNeedCommon;
    public String is_no_cache;
    public String is_test;
    public String mansearch;
    public boolean needDiscount;
    public String order_type;
    public String query;
    public Address startAddress;
    public Address targetAddress;

    public AddressParam clone() {
        try {
            return (AddressParam) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static HashMap<String, Object> getParamMap(Context context, AddressParam addressParam, String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("token", addressParam.token);
        hashMap.put("phone", addressParam.phone);
        hashMap.put("passenger_id", addressParam.uid);
        hashMap.put("product_id", addressParam.productId);
        hashMap.put("app_version", addressParam.appVersion);
        hashMap.put("platform", "2");
        hashMap.put("app_id", context.getPackageName());
        hashMap.put("map_type", addressParam.mapType);
        hashMap.put("coordinate_type", addressParam.coordinate_type);
        hashMap.put("requester_type", addressParam.requester_type);
        hashMap.put("lang", addressParam.lang);
        hashMap.put("country_id", addressParam.countryId);
        Address address = addressParam.currentAddress;
        if (address != null) {
            hashMap.put("user_loc_lat", Double.valueOf(address.latitude));
            hashMap.put("user_loc_lng", Double.valueOf(addressParam.currentAddress.longitude));
            if (!Utils.isValidLocation(addressParam.currentAddress)) {
                Utils.logWarn("TAG: " + str + ", AddressParam.currentAddress is invalid location, addressParam: " + addressParam);
            }
        } else {
            Utils.logWarn("TAG: " + str + ", AddressParam.currentAddress = null, addressParam: " + addressParam);
        }
        Address address2 = addressParam.targetAddress;
        if (address2 != null) {
            hashMap.put("select_lat", Double.valueOf(address2.latitude));
            hashMap.put("select_lng", Double.valueOf(addressParam.targetAddress.longitude));
            if (!Utils.isValidLocation(addressParam.targetAddress)) {
                Utils.logWarn("TAG: " + str + ", AddressParam.targetAddress is invalid location, addressParam: " + addressParam);
            }
        } else {
            Utils.logWarn("TAG: " + str + ", AddressParam.targetAddress = null, addressParam: " + addressParam);
        }
        return hashMap;
    }

    public static HashMap<String, Object> getBodyMap(Context context) {
        HashMap<String, Object> hashMap = new HashMap<>();
        String wifiParam = WifiInfoParam.getWifiParam(context);
        if (wifiParam != null) {
            hashMap.put("wifi_info", wifiParam);
        }
        String lastSatellitesInfo = SatelliteManager.getInstance(context).getLastSatellitesInfo();
        if (lastSatellitesInfo != null) {
            hashMap.put("satellite_info", lastSatellitesInfo);
        }
        return hashMap;
    }

    public static HashMap<String, Object> getRecBodyMap(Context context, String str) {
        HashMap<String, Object> bodyMap = getBodyMap(context);
        String locTrackJson = LocTrackUtil.getLocTrackJson(str);
        if (!TextUtils.isEmpty(locTrackJson)) {
            bodyMap.put("loc_track", locTrackJson);
        }
        String cellInfoJson = CellInfoUtil.getCellInfoJson();
        if (!TextUtils.isEmpty(cellInfoJson)) {
            bodyMap.put("cell_info", cellInfoJson);
        }
        return bodyMap;
    }

    public String toString() {
        return "AddressParam{, departure_time='" + this.departure_time + '\'' + ", query='" + this.query + '\'' + ", order_type='" + this.order_type + '\'' + ", assist='" + this.assist + '\'' + ", mansearch='" + this.mansearch + '\'' + ", is_no_cache='" + this.is_no_cache + '\'' + ", is_test='" + this.is_test + '\'' + ", mapType='" + this.mapType + '\'' + ", currentAddress=" + this.currentAddress + ", targetAddress=" + this.targetAddress + ", addressType=" + this.addressType + ", callFrom=" + this.callFrom + ", is_discount=" + this.needDiscount + ", startAddress=" + this.startAddress + '}';
    }
}
