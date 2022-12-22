package com.didi.payment.base.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.payment.base.proxy.HttpHeaderProxyHolder;
import com.didi.payment.base.proxy.HttpQueryParamProxyHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PayBaseParamUtil {
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = com.didi.payment.base.proxy.HttpQueryParamProxyHolder.getProxy().getQueryParams(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object getParam(android.content.Context r2, java.lang.String r3) {
        /*
            com.didi.payment.base.proxy.HttpQueryParamProxyHolder$IQueryParamProxy r0 = com.didi.payment.base.proxy.HttpQueryParamProxyHolder.getProxy()
            if (r0 == 0) goto L_0x0017
            if (r2 == 0) goto L_0x0017
            com.didi.payment.base.proxy.HttpQueryParamProxyHolder$IQueryParamProxy r0 = com.didi.payment.base.proxy.HttpQueryParamProxyHolder.getProxy()
            java.util.HashMap r0 = r0.getQueryParams(r2)
            if (r0 == 0) goto L_0x0017
            java.lang.Object r0 = r0.get(r3)
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x001b
            return r0
        L_0x001b:
            com.didi.payment.base.proxy.CommonProxyHolder$ICommonProxy r1 = com.didi.payment.base.proxy.CommonProxyHolder.getProxy()
            if (r1 == 0) goto L_0x0031
            if (r2 == 0) goto L_0x0031
            com.didi.payment.base.proxy.CommonProxyHolder$ICommonProxy r1 = com.didi.payment.base.proxy.CommonProxyHolder.getProxy()
            java.util.HashMap r2 = r1.getBaseParams(r2)
            if (r2 == 0) goto L_0x0031
            java.lang.Object r0 = r2.get(r3)
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.utils.PayBaseParamUtil.getParam(android.content.Context, java.lang.String):java.lang.Object");
    }

    public static void setParam(Context context, String str, Object obj) {
        HttpQueryParamProxyHolder.IQueryParamProxy proxy = HttpQueryParamProxyHolder.getProxy();
    }

    public static int getIntParam(Context context, String str) {
        try {
            return Integer.parseInt(String.valueOf(getParam(context, str)));
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String getStringParam(Context context, String str) {
        try {
            return String.valueOf(getParam(context, str));
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isLogin(Context context) {
        if (context == null || CommonProxyHolder.getProxy() == null) {
            return false;
        }
        return CommonProxyHolder.getProxy().isLogin(context);
    }

    public static void doLogin(Context context) {
        if (context != null && CommonProxyHolder.getProxy() != null) {
            CommonProxyHolder.getProxy().doLogin(context);
        }
    }

    public static HashMap<String, String> getHttpHeaders() {
        if (HttpHeaderProxyHolder.getProxy() == null) {
            return null;
        }
        return HttpHeaderProxyHolder.getProxy().getHeaders();
    }

    public static HashMap<String, Object> getHttpBaseParams(Context context) {
        HashMap<String, Object> baseParams;
        if (HttpQueryParamProxyHolder.getProxy() != null && context != null && HttpQueryParamProxyHolder.getProxy().getQueryParams(context) != null) {
            return HttpQueryParamProxyHolder.getProxy().getQueryParams(context);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        if (context == null || CommonProxyHolder.getProxy() == null || (baseParams = CommonProxyHolder.getProxy().getBaseParams(context)) == null) {
            return hashMap;
        }
        for (String next : m21011a()) {
            Object obj = baseParams.get(next);
            if (obj != null) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static List<String> m21011a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("vcode");
        arrayList.add("dviceid");
        arrayList.add("appversion");
        arrayList.add("model");
        arrayList.add("os");
        arrayList.add("imei");
        arrayList.add("suuid");
        arrayList.add("channel");
        arrayList.add("datatype");
        arrayList.add("terminal_id");
        arrayList.add("cancel");
        arrayList.add("maptype");
        arrayList.add("sig");
        arrayList.add("token");
        arrayList.add("pixels");
        arrayList.add("cpu");
        arrayList.add("android_id");
        arrayList.add("networkType");
        arrayList.add("uuid");
        arrayList.add("time");
        arrayList.add("lang");
        arrayList.add("lat");
        arrayList.add("lng");
        arrayList.add("city_id");
        arrayList.add("trip_country");
        arrayList.add("trip_cityid");
        arrayList.add("utc_offset");
        arrayList.add("trip_type");
        arrayList.add("origin_id");
        arrayList.add("location_country");
        arrayList.add("location_cityid");
        arrayList.add("biz_type");
        arrayList.add("platform_type");
        arrayList.add("product_id");
        return arrayList;
    }

    public static String getPackageName(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }
}
