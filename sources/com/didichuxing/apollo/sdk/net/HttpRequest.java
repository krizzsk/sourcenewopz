package com.didichuxing.apollo.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.remotereslibrary.Config;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.apollo.sdk.ApolloException;
import com.didichuxing.apollo.sdk.IAppInfoDelegate;
import com.didichuxing.apollo.sdk.IUserInfoDelegate;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.apollo.sdk.utils.Utils;
import com.didichuxing.request.ServerParam;
import com.turbomanage.httpclient.BasicRequestHandler;
import com.turbomanage.httpclient.ParameterMap;
import com.turbomanage.httpclient.android.AndroidHttpClient;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import org.apache.commons.p071io.IOUtils;

public class HttpRequest {

    /* renamed from: a */
    private static String f45630a = "";

    /* renamed from: b */
    private static String f45631b = "";

    /* renamed from: c */
    private static String f45632c = "ep/as/toggles";

    /* renamed from: d */
    private static String f45633d = "ep/as/feature";

    /* renamed from: e */
    private static boolean f45634e = true;

    public static String getHost() {
        if (TextUtils.isEmpty(f45631b)) {
            return f45630a;
        }
        return f45631b;
    }

    public static void setHost(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("http:", "https:");
        }
        f45630a = str;
    }

    public static void setPath(String str) {
        f45632c = str;
    }

    public static void setEnable(boolean z) {
        f45634e = z;
    }

    public static void getApolloConfig(Context context, String str, String str2, IUserInfoDelegate iUserInfoDelegate, IAppInfoDelegate iAppInfoDelegate, RequestHandler requestHandler, ObjectCallback objectCallback) {
        if (f45634e) {
            String a = m32693a(context);
            m32694a();
            SystemUtils.log(3, GlobalCashierCoreModule.APOLLO, "host is " + a, (Throwable) null, "com.didichuxing.apollo.sdk.net.HttpRequest", 73);
            AndroidHttpClient androidHttpClient = new AndroidHttpClient(a, new BasicRequestHandler(new DRequestLogger()) {
            });
            androidHttpClient.setRequestLogger(new DRequestLogger());
            androidHttpClient.setMaxRetries(3);
            ParameterMap parameterMap = new ParameterMap();
            if (requestHandler != null) {
                try {
                    RequestParams requestParams = requestHandler.getRequestParams();
                    if (!(requestParams == null || requestParams.getParams() == null)) {
                        for (Map.Entry next : requestParams.getParams().entrySet()) {
                            String str3 = (String) next.getKey();
                            Object value = next.getValue();
                            if (!(str3 == null || value == null)) {
                                parameterMap.put(str3, value.toString());
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            parameterMap.addIfNotEmpty(Config.KEY_NS, str);
            if (!parameterMap.containsKey("__caller") && !TextUtils.isEmpty(str)) {
                parameterMap.add("__caller", "apollo_android_sdk." + str);
            }
            parameterMap.add("api_version", "1.0");
            if (str2 == null) {
                str2 = "";
            }
            parameterMap.add("md5", str2);
            parameterMap.add("os_type", Utils.getOsType());
            parameterMap.add(ServerParam.PARAM_OS_VERSION, Utils.getOsVersion());
            parameterMap.add("key", Utils.generateKey());
            parameterMap.add("app_version", Utils.getVersionName());
            parameterMap.add("app_vcode", Utils.getVersionCode() + "");
            if (iAppInfoDelegate != null) {
                parameterMap.addIfNotEmpty("bundle_ver", iAppInfoDelegate.getFullVersion());
            }
            if (iUserInfoDelegate != null) {
                parameterMap.addIfNotEmpty("city", iUserInfoDelegate.getLocationCityId()).addIfNotEmpty("order_city", iUserInfoDelegate.getOrderCityId()).addIfNotEmpty("ticket", iUserInfoDelegate.getToken()).addIfNotEmpty("uid", iUserInfoDelegate.getUid()).addIfNotEmpty("__lang", iUserInfoDelegate.getLang());
                if (TextUtils.isEmpty(iUserInfoDelegate.getLocationCityId())) {
                    parameterMap.addIfNotEmpty("lat", iUserInfoDelegate.getLatString()).addIfNotEmpty("lng", iUserInfoDelegate.getLngString());
                }
            }
            try {
                androidHttpClient.get(f45632c, parameterMap, objectCallback);
            } catch (Throwable unused2) {
            }
        }
    }

    /* renamed from: a */
    private static void m32694a() {
        if (TextUtils.isEmpty(getHost())) {
            throw new ApolloException("must set apollo host");
        }
    }

    public static String getSingleToggle(Map<String, String> map, int i, int i2) throws Exception {
        if (!f45634e) {
            return "{}";
        }
        m32694a();
        if (map == null) {
            return "{}";
        }
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        StringBuilder sb = new StringBuilder("?");
        for (Map.Entry next : entrySet) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                sb.append(ParamKeys.SIGN_AND);
            }
        }
        String substring = sb.toString().substring(0, sb.toString().length() - 1);
        URL url = new URL(f45630a + f45633d + substring);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i2);
        httpURLConnection.setRequestMethod("GET");
        InputStream inputStream = httpURLConnection.getInputStream();
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "feature url:" + url);
        return IOUtils.toString(inputStream);
    }

    /* renamed from: a */
    private static String m32693a(Context context) {
        if (!TextUtils.isEmpty(f45631b)) {
            return f45631b;
        }
        String str = null;
        try {
            str = SystemUtils.getApplicationInfo(context.getPackageManager(), Utils.getPackageName(), 128).metaData.getString("APOLLO_SERVER_HOST", "");
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            return f45630a;
        }
        f45631b = str;
        return str;
    }
}
