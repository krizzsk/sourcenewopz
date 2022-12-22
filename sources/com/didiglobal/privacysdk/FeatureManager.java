package com.didiglobal.privacysdk;

import android.content.Context;
import com.didi.one.netdetect.http.ResponseListener;
import com.didiglobal.privacysdk.bff.BffService;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;

public class FeatureManager {
    public static void getFeatureList(Context context, ResponseListener<Map<String, Boolean>> responseListener, List<String> list) {
        BffService.getFeatureList(context, responseListener, list);
    }

    public static void setFeature(Context context, String str, boolean z, ResponseListener<JsonObject> responseListener) {
        BffService.setFeature(context, str, z, responseListener);
    }
}
