package com.didiglobal.xbanner.router;

import android.text.TextUtils;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didiglobal.xbanner.XBanner;
import com.didiglobal.xbanner.template.mdel.XBannerExtension;
import com.google.gson.Gson;
import org.json.JSONObject;

public class XBRouter {
    public static void routerStart(String str, XBannerExtension xBannerExtension) {
        routerStart(str, new Gson().toJson((Object) xBannerExtension), xBannerExtension.f51476id);
    }

    public static void routerStart(String str, String str2, String str3) {
        Request build = DRouter.build(str);
        if (str2 != null) {
            build.putExtra(XBanner.XB_EXTENSION_KEY, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            build.putExtra(XBanner.XB_CARDID_KEY, str3);
        }
        build.start();
    }

    public static void routerStart(String str, JSONObject jSONObject, String str2) {
        routerStart(str, jSONObject.toString(), str2);
    }
}
