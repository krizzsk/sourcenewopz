package com.didi.one.netdetect.http;

import android.content.Context;
import android.text.TextUtils;
import com.didi.one.netdetect.model.DetectionParam;
import com.didi.one.netdetect.model.DetectionReportInfo;
import com.didi.one.netdetect.model.ResponseInfo;
import com.didi.one.netdetect.model.TraceRouteReportInfo;
import com.didi.one.netdetect.security.SignGenerator;
import com.didi.one.netdetect.util.NetUtil;
import com.didi.one.netdetect.util.ONDLog;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.push.ServerParam;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import didihttp.Call;
import didihttp.Callback;
import didihttp.Response;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpService {
    public static final String DETECTION_REPORT_PATH = "/appNetMonitor/v2/detectInfoReport";
    public static final String TRACE_ROUTE_REPORT_PATH = "/appNetMonitor/v2/trInfoReport";

    /* renamed from: a */
    private static final String f29442a = "OND_HttpService";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Logger f29443b = LoggerFactory.getLogger("OneNetDetect");

    public static void detectionInfoReport(Context context, String str, DetectionParam detectionParam, DetectionReportInfo detectionReportInfo, SignGenerator signGenerator, final ResponseListener<ResponseInfo> responseListener) {
        String a = m20748a((Map<String, Object>) m20749a(context, (HashMap<String, Object>) new HashMap(), detectionParam), str, signGenerator);
        final Gson gson = new Gson();
        String json = gson.toJson((Object) detectionReportInfo);
        ONDLog.m20755d(f29442a, "detectionInfoReport url: " + a);
        ONDLog.m20755d(f29442a, "detectionInfoReport body: " + json);
        OkHttpClientManager.getInstance().postAsync(a, json, new Callback() {
            public void onFailure(Call call, IOException iOException) {
                ONDLog.m20756d(HttpService.f29442a, "detectionInfoReport failed", iOException);
                HashMap hashMap = new HashMap();
                hashMap.put("result", "fail");
                try {
                    hashMap.put("contentLength", String.valueOf(call.request().body().contentLength()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                HttpService.f29443b.infoEvent("DetectionInfoReport", (Map<?, ?>) hashMap);
                ResponseListener responseListener = ResponseListener.this;
                if (responseListener != null) {
                    responseListener.onFail(iOException);
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                ResponseListener responseListener;
                HashMap hashMap = new HashMap();
                hashMap.put("result", "success");
                try {
                    hashMap.put("contentLength", String.valueOf(call.request().body().contentLength()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                HttpService.f29443b.infoEvent("DetectionInfoReport", (Map<?, ?>) hashMap);
                String string = response.body().string();
                ResponseInfo responseInfo = null;
                try {
                    responseInfo = (ResponseInfo) gson.fromJson(string, ResponseInfo.class);
                } catch (JsonParseException e2) {
                    ONDLog.m20756d(HttpService.f29442a, "detectionInfoReport json parse failed", e2);
                    ResponseListener responseListener2 = ResponseListener.this;
                    if (responseListener2 != null) {
                        responseListener2.onFail(e2);
                    }
                }
                if (responseInfo != null && (responseListener = ResponseListener.this) != null) {
                    responseListener.onSuccess(responseInfo);
                }
            }
        });
    }

    public static void traceRouteInfoReport(Context context, String str, DetectionParam detectionParam, TraceRouteReportInfo traceRouteReportInfo, SignGenerator signGenerator, final ResponseListener<ResponseInfo> responseListener) {
        String a = m20748a((Map<String, Object>) m20749a(context, (HashMap<String, Object>) new HashMap(), detectionParam), str, signGenerator);
        final Gson gson = new Gson();
        String json = gson.toJson((Object) traceRouteReportInfo);
        ONDLog.m20755d(f29442a, "traceRouteInfoReport url: " + a);
        ONDLog.m20755d(f29442a, "traceRouteInfoReport body: " + json);
        OkHttpClientManager.getInstance().postAsync(a, json, new Callback() {
            public void onFailure(Call call, IOException iOException) {
                ONDLog.m20756d(HttpService.f29442a, "traceRouteInfoReport failed", iOException);
                HashMap hashMap = new HashMap();
                hashMap.put("result", "fail");
                try {
                    hashMap.put("contentLength", String.valueOf(call.request().body().contentLength()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                HttpService.f29443b.infoEvent("TraceRouteInfoReport", (Map<?, ?>) hashMap);
                ResponseListener responseListener = ResponseListener.this;
                if (responseListener != null) {
                    responseListener.onFail(iOException);
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                HashMap hashMap = new HashMap();
                hashMap.put("result", "success");
                try {
                    hashMap.put("contentLength", String.valueOf(call.request().body().contentLength()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                HttpService.f29443b.infoEvent("TraceRouteInfoReport", (Map<?, ?>) hashMap);
                String string = response.body().string();
                ResponseInfo responseInfo = null;
                try {
                    responseInfo = (ResponseInfo) gson.fromJson(string, ResponseInfo.class);
                } catch (JsonParseException e2) {
                    ONDLog.m20756d(HttpService.f29442a, "traceRouteInfoReport json parse failed", e2);
                    ResponseListener responseListener = ResponseListener.this;
                    if (responseListener != null) {
                        responseListener.onFail(e2);
                    }
                }
                if (responseInfo != null) {
                    ONDLog.m20755d(HttpService.f29442a, "traceRouteInfoReport success");
                    ResponseListener responseListener2 = ResponseListener.this;
                    if (responseListener2 != null) {
                        responseListener2.onSuccess(responseInfo);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    private static String m20748a(Map<String, Object> map, String str, SignGenerator signGenerator) {
        if (map.isEmpty()) {
            return str;
        }
        String a = m20747a(map, signGenerator);
        if (!TextUtils.isEmpty(a)) {
            map.put("wsgsig", a);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value != null && !(value instanceof byte[]) && !(value instanceof File)) {
                sb.append(sb.length() == 0 ? "" : ParamKeys.SIGN_AND);
                sb.append(NetUtil.encode((String) next.getKey()));
                sb.append("=");
                sb.append(NetUtil.encode(value.toString()));
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (!str.endsWith("?")) {
            sb2.append("?");
        }
        sb2.append(sb);
        return sb2.toString();
    }

    /* renamed from: a */
    private static String m20747a(Map<String, Object> map, SignGenerator signGenerator) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value == null) {
                hashMap.put((String) next.getKey(), "");
            } else if (!(value instanceof byte[]) && !(value instanceof File)) {
                hashMap.put((String) next.getKey(), value.toString());
            }
        }
        if (signGenerator != null) {
            return signGenerator.genSign(hashMap);
        }
        return null;
    }

    /* renamed from: a */
    private static HashMap<String, Object> m20749a(Context context, HashMap<String, Object> hashMap, DetectionParam detectionParam) {
        HashMap<String, Object> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        if (detectionParam != null) {
            hashMap2.put("cityId", Integer.valueOf(detectionParam.cityId));
            hashMap2.put("datatype", detectionParam.datatype);
            hashMap2.put("uid", detectionParam.uid);
            hashMap2.put("appVersion", detectionParam.appVersion);
            hashMap2.put("traceId", detectionParam.traceId);
            hashMap2.put("suuid", detectionParam.suuid);
            hashMap2.put(ServerParam.PARAM_TRIPCOUNTRY, detectionParam.tripCountry);
        }
        hashMap2.put("osVersion", WsgSecInfo.osVersion(context));
        hashMap2.put("operators", WsgSecInfo.networkOperator(context));
        hashMap2.put("networkType", WsgSecInfo.networkType(context));
        hashMap2.put(ServerParam.PARAM_DDRIVER_OSTYPE, 2);
        hashMap2.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        return hashMap2;
    }
}
