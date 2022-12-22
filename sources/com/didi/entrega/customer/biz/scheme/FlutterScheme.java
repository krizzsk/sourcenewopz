package com.didi.entrega.customer.biz.scheme;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.Request;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p242io.flutter.embedding.android.registry.NFlutterContainerRegistry;

public class FlutterScheme {

    /* renamed from: a */
    private static final String f19830a = "FlutterScheme";

    public static void flutterOpenSodaPage(String str, HashMap<String, Object> hashMap, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Request.Builder request = DiRouter.request();
            if (RouteValidation.isWebSchemeUri(str)) {
                request.path("webPage");
                hashMap.put("url", m14697a(str, ParamsHelper.getFlutterRouterCommonParam()));
                hashMap.put("removesFromViewOnPush", false);
            } else if (RouteValidation.isOneTravelSchemeUri(str)) {
                Uri parse = Uri.parse(str);
                String path = parse.getPath();
                request.path(path);
                m14698a(request, parse);
                str = path;
            } else {
                request.path(str);
            }
            RecordTracker.Builder.create().setTag(f19830a).setMessage("onOpenFlutterContainer").setLogCategory("c-data|").setOtherParam("path", str).setOtherParam("param", hashMap != null ? hashMap.toString() : "null").build().info();
            if (hashMap != null && hashMap.size() > 0) {
                for (String next : hashMap.keySet()) {
                    m14699a(request, next, hashMap.get(next));
                }
            }
            request.setFromPage(NFlutterContainerRegistry.getContainer(str2).getScopeContext());
            request.open();
        }
    }

    /* renamed from: a */
    private static void m14699a(Request.Builder builder, String str, Object obj) {
        if (obj instanceof String) {
            builder.putString(str, (String) obj);
        } else if (obj instanceof Boolean) {
            builder.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            builder.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            builder.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Double) {
            builder.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Serializable) {
            builder.putSerializable(str, (Serializable) obj);
        }
    }

    /* renamed from: a */
    private static String m14697a(String str, Map<String, String> map) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile("\\$\\{(.+?)\\}").matcher(str);
        while (matcher.find()) {
            String str2 = map.get(matcher.group(1));
            if (str2 != null) {
                matcher.appendReplacement(stringBuffer, str2);
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m14698a(Request.Builder builder, Uri uri) {
        if (!TextUtils.isEmpty(uri.getQuery())) {
            for (String next : uri.getQueryParameterNames()) {
                builder.putString(next, uri.getQueryParameter(next));
            }
        }
    }
}
