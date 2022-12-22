package com.didi.sdk.componentconfig;

import android.content.Context;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.CommonParamsUtil;
import java.util.HashMap;

public class ComponentParams {
    public static String PARAMS_CID = "cid";
    public static String PARAMS_FLAT = "flat";
    public static String PARAMS_FLNG = "flng";
    public static String PARAMS_MAP_TYPE = "maptype";
    public static String PARAMS_TOKEN = "token";
    public static String PARAMS_VERSION = "version";
    public static String URL = "https://conf.didiglobal.com";

    public static HashMap<String, Object> createParams(Context context, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(PARAMS_FLAT, str3);
        hashMap.put(PARAMS_FLNG, str4);
        hashMap.put(PARAMS_MAP_TYPE, str);
        hashMap.put(PARAMS_CID, str2);
        hashMap.put(PARAMS_TOKEN, NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
        return CommonParamsUtil.addCommonParam(hashMap, context);
    }
}
