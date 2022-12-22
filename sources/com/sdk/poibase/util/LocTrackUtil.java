package com.sdk.poibase.util;

import com.didi.sdk.push.ServerParam;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;

public class LocTrackUtil {
    public static String getLocTrackJson(String str) {
        List<DIDILocation> recentLocations = DIDILocBusinessHelper.getInstance().getRecentLocations(20);
        if (recentLocations == null || recentLocations.isEmpty()) {
            OmegaUtil.trackLocTrackCount(0, str);
            return "";
        }
        JsonArray jsonArray = new JsonArray();
        for (DIDILocation next : recentLocations) {
            if (next != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("lat", (Number) Double.valueOf(next.getLatitude()));
                jsonObject.addProperty("lng", (Number) Double.valueOf(next.getLongitude()));
                jsonObject.addProperty("speed", (Number) Float.valueOf(next.getSpeed()));
                jsonObject.addProperty("bearing", (Number) Float.valueOf(next.getBearing()));
                jsonObject.addProperty(ServerParam.PARAM_ACCURACY, (Number) Float.valueOf(next.getAccuracy()));
                jsonObject.addProperty("local_time", (Number) Long.valueOf(next.getLocalTime()));
                jsonObject.addProperty("elapsedreal_time", (Number) Long.valueOf(next.getTime()));
                jsonObject.addProperty("provider", next.getProvider());
                jsonObject.addProperty("altitude", (Number) Double.valueOf(next.getAltitude()));
                jsonObject.addProperty("is_mock_gps", (Number) Integer.valueOf(next.isMockGps()));
                jsonObject.addProperty("coordinate_type", (Number) Integer.valueOf(next.getCoordinateType()));
                jsonObject.addProperty("source", next.getSource());
                jsonArray.add((JsonElement) jsonObject);
            }
        }
        OmegaUtil.trackLocTrackCount(jsonArray.size(), str);
        return jsonArray.toString();
    }
}
