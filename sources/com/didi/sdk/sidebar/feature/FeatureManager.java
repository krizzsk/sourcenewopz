package com.didi.sdk.sidebar.feature;

import com.didi.one.netdetect.http.ResponseListener;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.bff.BffService;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeatureManager {
    public static void getFeatureList(ResponseListener<Map<String, Boolean>> responseListener, List<String> list) {
        BffService.getFeatureList(DIDIApplication.getAppContext(), responseListener, list);
    }

    public static void getFeature(ResponseListener<Map<String, Boolean>> responseListener, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        BffService.getFeatureList(DIDIApplication.getAppContext(), responseListener, arrayList);
    }

    public static void setFeature(String str, boolean z, ResponseListener<JsonObject> responseListener) {
        BffService.setFeature(DIDIApplication.getAppContext(), str, z, responseListener);
    }
}
