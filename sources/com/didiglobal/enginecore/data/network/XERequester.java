package com.didiglobal.enginecore.data.network;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.BffCallBack;
import com.android.didi.bfflib.IBffProxy;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.enginecore.constant.XENetConstant;
import com.didiglobal.enginecore.littleboy.LBAbility;
import com.didiglobal.enginecore.littleboy.LBRequest;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class XERequester {

    /* renamed from: a */
    private static final String f50157a = "request_method";

    /* renamed from: b */
    private static final String f50158b = "request_module";

    /* renamed from: c */
    private static final String f50159c = "type";

    /* renamed from: d */
    private static final String f50160d = "action_type";

    /* renamed from: e */
    private static final String f50161e = "common_param";

    /* renamed from: f */
    private static final String f50162f = "biz_param";

    public static void expoRequest(Context context, Map<String, Object> map, String str, RpcService.Callback<JsonObject> callback) {
        LBRequest.call(new LBAbility.Builder(context, str).setParams(map).setCallback(callback).build());
    }

    public static void enginePageRequest(Context context, Map<String, Object> map, Map<String, Object> map2, BffCallBack<JsonObject> bffCallBack) {
        m36143a(context, map, map2, (String[]) null, XENetConstant.XE_ENGINE_PAGE_REQUEST, (JsonObject) null, bffCallBack);
    }

    public static void engineSimpleRequest(Context context, Map<String, Object> map, Map<String, Object> map2, String[] strArr, BffCallBack<JsonObject> bffCallBack) {
        m36143a(context, map, map2, strArr, XENetConstant.XE_ENGINE_SIMPLE_REQUEST, (JsonObject) null, bffCallBack);
    }

    public static void engineCommit(Context context, Map<String, Object> map, Map<String, Object> map2, JsonObject jsonObject, BffCallBack<JsonObject> bffCallBack) {
        m36143a(context, map, map2, (String[]) null, XENetConstant.XE_KEY_ENGINE_COMMIT, jsonObject, bffCallBack);
    }

    /* renamed from: a */
    private static void m36143a(Context context, Map<String, Object> map, Map<String, Object> map2, String[] strArr, String str, JsonObject jsonObject, BffCallBack<JsonObject> bffCallBack) {
        HashMap hashMap = new HashMap();
        if (jsonObject != null) {
            try {
                Map map3 = (Map) map.get(f50162f);
                map3.put(XENetConstant.XE_KEY_ENGINE_COMMIT, jsonObject);
                map.put(f50162f, map3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        hashMap.putAll(map);
        if (map2 != null && !map2.isEmpty()) {
            hashMap.put(f50161e, m36141a(map2, str));
        }
        if (strArr != null) {
            hashMap.put(f50157a, m36142a(strArr));
        }
        Bff.callImmediately(new IBffProxy.Ability.Builder(context, XENetConstant.XE_XENGINE_PASSENGER).setParams(hashMap).setBffCallBack(bffCallBack).build());
    }

    /* renamed from: a */
    private static JSONObject m36142a(String[] strArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        if (!(strArr == null || strArr.length == 0)) {
            JSONArray jSONArray = new JSONArray();
            int length = strArr.length;
            while (i < length) {
                jSONArray.put(strArr[i]);
                i++;
            }
            jSONObject.put(f50158b, jSONArray);
            i = 1;
        }
        jSONObject.put("type", i);
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONObject m36140a(Map<String, Object> map) {
        return new JSONObject(map);
    }

    /* renamed from: a */
    private static JSONObject m36141a(Map<String, Object> map, String str) {
        if (!TextUtils.isEmpty(str)) {
            map.put("action_type", str);
        }
        return m36140a(map);
    }
}
