package com.didi.component.common.router;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.util.Utils;
import com.didi.drouter.api.DRouter;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didi.sdk.util.DebugUtils;

public class GRouterUtil {
    public static int parseInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (Exception e) {
            if (!DebugUtils.isDebug()) {
                e.printStackTrace();
                return i;
            }
            throw e;
        }
    }

    public static void navigation(Context context, String str, String str2) {
        String str3 = Utils.isBrazilPackage(context) ? "taxis99OneTravel" : "globalOneTravel";
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append(HWMapConstant.HTTP.SEPARATOR);
        sb.append(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb.append(str2);
        DRouter.build(sb.toString()).start(context);
    }
}
