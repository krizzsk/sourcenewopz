package com.didi.app.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.app.SchemeDispatcherImpl;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.log.Logger;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class DRouterUtils {

    /* renamed from: a */
    private static final String f8665a = "handle_deep_link";

    public static void startUrlSafety(Context context, Uri uri) {
        Logger.m25808d("startUrlSafety uri =  " + uri, new Object[0]);
        if (uri == null || context == null) {
            Logger.m25809e("handleSchemeByDRouter failed while uri is null!", new Object[0]);
        } else if (!ActivityLifecycleManager.getInstance().isMainActivityRunning()) {
            Logger.m25808d("start mainActivity before start with drouter ", new Object[0]);
            Intent intent = new Intent();
            intent.putExtra(SchemeDispatcherImpl.PARAM_DROUTER_URL, uri.toString());
            intent.addFlags(805306368);
            PageRouter.getInstance().startMainActivity(context, intent);
        } else {
            HashMap hashMap = new HashMap(8);
            hashMap.put("scheme", uri.getScheme());
            hashMap.put("host", uri.getHost());
            hashMap.put("path", uri.getPath());
            hashMap.put("query", uri.getQuery());
            hashMap.put("handled", 1);
            OmegaSDKAdapter.trackEvent("handle_deep_link", (Map<String, Object>) hashMap);
            DRouter.build(uri.toString()).start(context);
        }
    }
}
