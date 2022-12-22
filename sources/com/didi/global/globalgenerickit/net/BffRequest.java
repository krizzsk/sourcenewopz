package com.didi.global.globalgenerickit.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.business.BffCallbackAdapter;
import com.android.didi.bfflib.business.BffRequestUtil;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.global.globalgenerickit.model.ComponentConfigPopModel;
import com.didi.global.globalgenerickit.model.sheet.ComponentSheet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class BffRequest {
    public static void requestCompoentConfig(Context context, Map<String, Object> map, String str, String str2, BffResponseListener<ComponentConfigPopModel> bffResponseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("business_scene", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(ParamKeys.PARAM_PASSENGER_POPUP, new JSONObject(hashMap));
        Bff.call(new IBffProxy.Ability.Builder(context, "expo/passenger").setParams(hashMap).setServiceId(str2).setBffCallBack(new BffCallbackAdapter(bffResponseListener)).build());
    }

    public static void requestSheetComponentConfig(Context context, Map<String, Object> map, String str, BffResponseListener<ComponentSheet> bffResponseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("business_scene", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("passenger_sheet", new JSONObject(hashMap));
        BffRequestUtil.request(context, "expo/passenger", hashMap, bffResponseListener);
    }
}
