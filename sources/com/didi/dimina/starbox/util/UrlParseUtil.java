package com.didi.dimina.starbox.util;

import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public class UrlParseUtil {
    private UrlParseUtil() {
    }

    public static Map<String, String> getQueryPairs(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            for (String str2 : new URI(str).getQuery().split(ParamKeys.SIGN_AND)) {
                int indexOf = str2.indexOf("=");
                linkedHashMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkedHashMap;
    }

    public static JSONObject getLaunchParams(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String split : str.split(ParamKeys.SIGN_AND)) {
                String[] split2 = split.split("=");
                JSONUtil.put(jSONObject, split2[0], (Object) split2[1]);
            }
        } catch (Exception unused) {
            LogUtil.m13409e("启动参数有误");
        }
        return jSONObject;
    }
}
