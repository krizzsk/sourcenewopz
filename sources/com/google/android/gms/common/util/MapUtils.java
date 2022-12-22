package com.google.android.gms.common.util;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class MapUtils {
    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        sb.append(Const.joLeft);
        boolean z = true;
        for (String next : hashMap.keySet()) {
            if (!z) {
                sb.append(",");
            }
            String str = hashMap.get(next);
            sb.append(Const.jsQuote);
            sb.append(next);
            sb.append("\":");
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(Const.jsQuote);
                sb.append(str);
                sb.append(Const.jsQuote);
            }
            z = false;
        }
        sb.append("}");
    }
}
