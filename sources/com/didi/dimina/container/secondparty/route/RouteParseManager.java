package com.didi.dimina.container.secondparty.route;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bundle.RemoteBundleMangerStrategy;
import com.didi.dimina.container.secondparty.DMConfig4Di;
import com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.sdk.util.TextUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class RouteParseManager {
    public static final String TAG = "RouteParseManager";

    /* renamed from: a */
    private static final Map<String, JSONObject> f17441a = new HashMap();

    public static RouteConfig parseUri(Context context, Uri uri) {
        String queryParameter = uri.getQueryParameter(RouteConstants.ROUTE_PARAMS_BUSINESS);
        JSONObject assetConfig = !TextUtils.isEmpty(queryParameter) ? getAssetConfig(context, queryParameter) : null;
        if (assetConfig == null) {
            assetConfig = new JSONObject();
        }
        for (String next : uri.getQueryParameterNames()) {
            String queryParameter2 = uri.getQueryParameter(next);
            if (TextUtils.isEmpty(queryParameter2)) {
                JSONUtil.put(assetConfig, next, (Object) "");
            } else {
                JSONUtil.put(assetConfig, next, (Object) queryParameter2);
            }
        }
        RouteConfig routeConfig = (RouteConfig) JSONUtil.objectFromJson(assetConfig.toString(), RouteConfig.class);
        Iterator<String> keys = assetConfig.keys();
        while (keys.hasNext()) {
            String next2 = keys.next();
            routeConfig.addExtraOptions(next2, assetConfig.opt(next2));
        }
        return routeConfig;
    }

    public static DMConfig4Di transformConfig(Context context, RouteConfig routeConfig) {
        if (routeConfig == null) {
            return new DMConfig4Di(context);
        }
        DMConfig4Di dMConfig4Di = new DMConfig4Di(context);
        if (!TextUtil.isEmpty(routeConfig.remoteUrl)) {
            dMConfig4Di.getLaunchConfig().setBundleManagerStrategy(new RemoteBundleMangerStrategy(routeConfig.remoteUrl));
        } else {
            DMConfig4Di.LaunchConfig launchConfig = dMConfig4Di.getLaunchConfig();
            launchConfig.setBundleManagerStrategy(new ReleaseBundleMangerStrategy("dimina/bundle/" + routeConfig.appId));
        }
        if (TextUtils.isEmpty(routeConfig.appId)) {
            routeConfig.appId = "" + System.currentTimeMillis();
        }
        dMConfig4Di.getLaunchConfig().setAppId(routeConfig.appId);
        dMConfig4Di.getLaunchConfig().setEntryPath(routeConfig.entryPath);
        dMConfig4Di.getLaunchConfig().setExtraOptions(new JSONObject(routeConfig.extraOptions));
        dMConfig4Di.getLaunchConfig().setMaxPageSize(routeConfig.maxPageSize);
        dMConfig4Di.getLaunchConfig().setRavenId(routeConfig.ravenId);
        dMConfig4Di.getLaunchConfig().setExtraUA(routeConfig.extraUA);
        dMConfig4Di.getForceUpdateConfig().setForceUpdateAppVersion(routeConfig.forceUpdateAppVersion);
        dMConfig4Di.getForceUpdateConfig().setForceUpdateJSSDKVersion(routeConfig.forceUpdateJSSDKVersion);
        dMConfig4Di.getForceUpdateConfig().setForceUpdateTimeout(Long.valueOf(routeConfig.forceUpdateTimeout));
        dMConfig4Di.getUIConfig().setHasCapsuleButton(routeConfig.hasCapsuleButton);
        return dMConfig4Di;
    }

    public static JSONObject getAssetConfig(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        if (Dimina.getConfig().isDebug()) {
            str = str + "-test";
        }
        if (f17441a.containsKey(str)) {
            return f17441a.get(str);
        }
        try {
            InputStream open = context.getAssets().open("dimina/route/" + str + ".json");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            str2 = new String(bArr, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
            str2 = "{}";
        }
        JSONObject jSONObject = JSONUtil.toJSONObject(str2);
        if (!Dimina.getConfig().isDebug()) {
            f17441a.put(str, JSONUtil.toJSONObject(str2));
        }
        return jSONObject;
    }
}
