package com.didi.sdk.logging.util;

import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class ReportUtils {

    /* renamed from: a */
    private static final String f36662a = "tone_p_x_catchdata_query_result";

    /* renamed from: b */
    private static final String f36663b = "tone_p_x_catchdata_upload_slice_result";

    /* renamed from: c */
    private static final String f36664c = "tone_p_x_upload_filetree_result";

    /* renamed from: d */
    private static final String f36665d = "tone_p_x_catchdata_upload_total_result";

    /* renamed from: e */
    private static final String f36666e = "tone_p_x_catchdata_file_receive_socket";

    /* renamed from: f */
    private static final String f36667f = "networkType";

    /* renamed from: g */
    private static final String f36668g = "statusCode";

    /* renamed from: h */
    private static final String f36669h = "errorMsg";

    /* renamed from: i */
    private static final String f36670i = "result";

    /* renamed from: j */
    private static final String f36671j = "catchType";

    /* renamed from: k */
    private static final String f36672k = "sliceid";

    /* renamed from: l */
    private static final String f36673l = "taskid";

    /* renamed from: m */
    private static final String f36674m = "intentAction";

    /* renamed from: n */
    private static final String f36675n = "intentExtra";

    public static void reportProgramError(String str, Throwable th) {
        OmegaSDK.trackError(str, th);
    }

    public static void reportUploadTaskResult(boolean z, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(z ? 1 : 0));
        hashMap.put("networkType", str);
        hashMap.put(f36673l, str2);
        hashMap.put(f36669h, str3);
        hashMap.put("serverUrl", LoggerFactory.getConfig().getServerHost());
        OmegaSDKAdapter.trackEvent(f36665d, (Map<String, Object>) hashMap);
    }

    public static void reportQueryTaskResult(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", str);
        hashMap.put("serverUrl", LoggerFactory.getConfig().getServerHost());
        OmegaSDKAdapter.trackEvent(f36662a, (Map<String, Object>) hashMap);
    }

    public static void reportUploadSliceResult(boolean z, String str, long j, int i, String str2, int i2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(z ? 1 : 0));
        hashMap.put("networkType", str);
        hashMap.put(f36668g, Integer.valueOf(i2));
        hashMap.put(f36672k, Integer.valueOf(i));
        hashMap.put(f36669h, str3);
        hashMap.put(f36673l, str2);
        hashMap.put("fileLength", Long.valueOf(j));
        hashMap.put("serverUrl", LoggerFactory.getConfig().getServerHost());
        hashMap.put("file", str4);
        OmegaSDKAdapter.trackEvent(f36663b, (Map<String, Object>) hashMap);
    }

    public static void reportUploadFileTreeResult(boolean z, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(z ? 1 : 0));
        hashMap.put("networkType", str);
        hashMap.put("response", str3);
        hashMap.put(f36673l, str2);
        hashMap.put("serverUrl", LoggerFactory.getConfig().getServerHost());
        OmegaSDKAdapter.trackEvent(f36664c, (Map<String, Object>) hashMap);
    }

    public static void reportReceivePush(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(f36674m, str);
        hashMap.put(f36675n, str2);
        OmegaSDKAdapter.trackEvent(f36666e, (Map<String, Object>) hashMap);
    }

    public static void reportRequest(String str, Map<String, Object> map, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("param", map.toString());
        hashMap.put("response", str2);
        OmegaSDKAdapter.trackEvent("tone_p_x_catchdata_request", (Map<String, Object>) hashMap);
    }
}
