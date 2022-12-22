package com.didi.beatles.p099im.api;

import com.didi.beatles.p099im.utils.IMLog;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.Map;

/* renamed from: com.didi.beatles.im.api.IMGetParamHelper */
public class IMGetParamHelper {
    public static String generateGetUrl(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (Map.Entry next : map.entrySet()) {
            if (!sb.toString().endsWith("?")) {
                sb.append(ParamKeys.SIGN_AND);
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append(next.getValue());
        }
        IMLog.m6631d("hkctest", "generateGetUrl: " + sb.toString());
        return sb.toString();
    }
}
