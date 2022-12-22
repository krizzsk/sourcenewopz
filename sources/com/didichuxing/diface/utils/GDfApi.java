package com.didichuxing.diface.utils;

import com.didichuxing.dfbasesdk.data.BaseInnerResult;
import com.didichuxing.dfbasesdk.http.AbsOkHttpCallback;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.dfbasesdk.utils.DFApi;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GDfApi {

    /* renamed from: a */
    private static JSONObject f47535a = new JSONObject();

    public static void addExtraParam(String str, Object obj) {
        try {
            f47535a.put(str, obj);
        } catch (JSONException e) {
            LogUtils.logStackTrace(e);
        }
    }

    public static <T extends BaseInnerResult> void postNew(String str, Map<String, Object> map, AbsOkHttpCallback<T> absOkHttpCallback) {
        CheckUtils.checkAssert(!map.containsKey("extra"), "params already contains extra key!!!");
        map.put("extra", f47535a.toString());
        DFApi.postNew(str, map, absOkHttpCallback);
    }
}
