package com.didi.address.util;

import android.text.TextUtils;
import com.didi.address.model.WayPoint;
import com.didi.sdk.address.address.entity.Address;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SugWayPointsUtils {
    public static List<WayPoint> getWayPointListFromJson(String str) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        Address address = new Address();
                        address.setLatitude(jSONObject.optDouble("lat", 0.0d));
                        address.setLongitude(jSONObject.optDouble("lng", 0.0d));
                        address.setDisplayName(jSONObject.optString("name", ""));
                        address.setAddress(jSONObject.optString("address", ""));
                        address.poiId = jSONObject.optString("poi_id", "");
                        address.setLatitude(jSONObject.optDouble("lat", 0.0d));
                        WayPoint wayPoint = new WayPoint(2, address);
                        wayPoint.setTripState(jSONObject.optInt("status", 0));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(wayPoint);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String getJsonStrFromWayPoints(List<WayPoint> list) {
        if (list == null) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (WayPoint next : list) {
                if (next != null && CommonUtils.isValidLocation(next.getAddress())) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("status", next.getTripState());
                    jSONObject.put("lat", next.getAddress().getLatitude());
                    jSONObject.put("lng", next.getAddress().getLongitude());
                    PoiidCompleteUtils.completePoiid(next.getAddress());
                    jSONObject.put("poi_id", next.getAddress().poiId);
                    jSONObject.put("name", next.getAddress().getDisplayName());
                    jSONObject.put("address", next.getAddress().getAddress());
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
