package com.sdk.poibase.util;

import com.didi.component.business.tracker.GPageIdConstant;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.google.gson.JsonObject;

public class DidiLocUtil {
    public static String getDidiLocJson(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("lat", (Number) Double.valueOf(dIDILocation.getLatitude()));
        jsonObject.addProperty("lng", (Number) Double.valueOf(dIDILocation.getLongitude()));
        jsonObject.addProperty(GPageIdConstant.G_PAGE_ID_CONF, (Number) Double.valueOf(dIDILocation.getConfidence()));
        jsonObject.addProperty("radius", (Number) Float.valueOf(dIDILocation.getAccuracy()));
        return jsonObject.toString();
    }
}
