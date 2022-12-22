package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.security.wireless.adapter.SecurityWrapper;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.data.BaseInnerResult;
import com.didichuxing.dfbasesdk.http.AbsOkHttpCallback;
import com.didichuxing.dfbasesdk.http.BizAccessInterceptor;
import com.didichuxing.dfbasesdk.http.SecurityAccessWsgInterceptor;
import com.didichuxing.security.safecollector.WsgSecInfo;
import didihttp.Call;
import didihttp.Callback;
import didihttp.DidiHttpClient;
import didihttp.MediaType;
import didihttp.MultipartBody;
import didihttp.Request;
import didihttp.RequestBody;
import java.io.File;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.text.Typography;

public class DFApi {

    /* renamed from: a */
    private static DidiHttpClient f46709a = new DidiHttpClient();

    /* renamed from: b */
    private static final String f46710b = "1.0.0";

    /* renamed from: c */
    private static final String f46711c = "190001";

    /* renamed from: d */
    private static final Object f46712d = "DF_NET_REQ_TAG";

    /* renamed from: e */
    private static final MediaType f46713e = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: f */
    private static String f46714f;

    @Deprecated
    public static <T extends BaseInnerResult> void postNew(String str, Map<String, Object> map, AbsOkHttpCallback<T> absOkHttpCallback) {
        postReq(str, map, absOkHttpCallback);
    }

    @Deprecated
    public static <T extends BaseInnerResult> void postReq(String str, Map<String, Object> map, AbsOkHttpCallback<T> absOkHttpCallback) {
        m33547a(str, GsonUtils.toJsonStr(map), f46712d, false, absOkHttpCallback);
    }

    @Deprecated
    public static <T extends BaseInnerResult> void postNew(String str, String str2, AbsOkHttpCallback<T> absOkHttpCallback) {
        m33547a(str, str2, f46712d, false, absOkHttpCallback);
    }

    public static <T extends BaseInnerResult> void postWithoutEnv(String str, String str2, AbsOkHttpCallback<T> absOkHttpCallback) {
        m33547a(str, str2, f46712d, true, absOkHttpCallback);
    }

    /* renamed from: a */
    private static <T extends BaseInnerResult> void m33547a(String str, String str2, Object obj, boolean z, AbsOkHttpCallback<T> absOkHttpCallback) {
        if (f46714f == null) {
            f46714f = m33545a(AppContextHolder.getAppContext());
        }
        RequestBody create = RequestBody.create(f46713e, str2);
        Request.Builder builder = new Request.Builder();
        if (!z) {
            str = m33546a(str);
        }
        Request.Builder tag = builder.url(str).post(create).header("User-Agent", f46714f).tag(obj);
        if (!z) {
            tag.header(BizAccessInterceptor.WSG_NOT_COLLECT_WSGENV, "1");
        }
        f46709a.newCall(tag.build()).enqueue(absOkHttpCallback);
    }

    /* renamed from: a */
    private static String m33546a(String str) {
        try {
            String doCollect = SecurityWrapper.doCollect(SecurityAccessWsgInterceptor.WSG_TYPE_ACCESS_SECURITY);
            if (TextUtils.isEmpty(doCollect)) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            int indexOf = str.indexOf("?");
            if (indexOf < 0) {
                sb.append('?');
            } else if (indexOf < str.length() - 1) {
                sb.append(Typography.amp);
            }
            sb.append("wsgenv");
            sb.append('=');
            sb.append(URLEncoder.encode(doCollect, "utf-8"));
            return sb.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void postFormData(String str, Map<String, Object> map, Callback callback) {
        if (f46714f == null) {
            f46714f = m33545a(AppContextHolder.getAppContext());
        }
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof File) {
                File file = (File) value;
                type.addFormDataPart(str2, file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file));
            } else {
                type.addFormDataPart(str2, String.valueOf(value));
            }
        }
        f46709a.newCall(new Request.Builder().url(str).post(type.build()).header("User-Agent", f46714f).tag(f46712d).build()).enqueue(callback);
    }

    public static String getCommonExtra(String str) {
        return "{\"sdkVersion\":\"" + str + "\",\"clientOS\":\"Android " + WsgSecInfo.osVersion() + "\"}";
    }

    /* renamed from: a */
    private static String m33545a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("Android/");
        sb.append(WsgSecInfo.osVersion(context));
        sb.append(" ");
        sb.append("didihttp");
        sb.append(" ");
        sb.append("OneNet/");
        sb.append("2.1.0.66");
        try {
            String packageName = WsgSecInfo.packageName(context);
            String versionName = AppUtils.getVersionName(context);
            sb.append(" ");
            sb.append(packageName);
            sb.append("/");
            sb.append(versionName);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        return sb.toString();
    }

    public static void cancelRequest(Object obj) {
        for (Call next : f46709a.dispatcher().queuedCalls()) {
            if (obj.equals(next.request().tag())) {
                next.cancel();
            }
        }
        for (Call next2 : f46709a.dispatcher().runningCalls()) {
            if (obj.equals(next2.request().tag())) {
                next2.cancel();
            }
        }
    }
}
