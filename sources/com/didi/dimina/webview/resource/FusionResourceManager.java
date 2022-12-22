package com.didi.dimina.webview.resource;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.didi.dimina.starbox.util.FileUtil;
import com.didi.dimina.webview.FusionEngine;
import com.didi.dimina.webview.resource.FusionBridgeStream;
import com.didi.dimina.webview.util.C7819Util;
import com.didi.dimina.webview.util.FusionMimeTypeMap;
import com.didi.dimina.webview.util.NetworkUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FusionResourceManager {

    /* renamed from: a */
    private static final String f18340a = "FusionResourceManager";
    public static final Set<String> cacheExtentionSet;

    static {
        HashSet hashSet = new HashSet();
        cacheExtentionSet = hashSet;
        hashSet.add("js");
        cacheExtentionSet.add(Constants.JSON_KEY_CUR_CPU_STAT);
        cacheExtentionSet.add("jpeg");
        cacheExtentionSet.add("png");
        cacheExtentionSet.add("gif");
        cacheExtentionSet.add(FileUtil.JPG);
        cacheExtentionSet.add("jfif");
        cacheExtentionSet.add("woff");
        cacheExtentionSet.add("woff2");
        cacheExtentionSet.add("eot");
        cacheExtentionSet.add("svg");
        cacheExtentionSet.add("webp");
    }

    public static FusionResource getFusionResource(String str, Map<String, String> map, FusionUrlPreLoader fusionUrlPreLoader) {
        FusionCacheClient fusionCacheClient = FusionCacheClient.sInstance;
        if (!fusionCacheClient.isValid()) {
            return null;
        }
        C7819Util.firstLaunchRequestUrlCount++;
        if (fusionCacheClient.isCacheExist(str)) {
            FusionResource a = m13633a(str, map, true);
            C7819Util.firstLaunchCachedUrlCount++;
            return a;
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl) || !cacheExtentionSet.contains(fileExtensionFromUrl)) {
            return null;
        }
        m13634a(str, map, (Map<String, String>) null);
        return null;
    }

    public static FusionResource fetchResourceFromNet(String str, Map<String, String> map, boolean z) {
        FusionHttpClient fusionHttpClient = new FusionHttpClient(str, map);
        if (fusionHttpClient.connect() == 0 && 200 == fusionHttpClient.getResponseCode()) {
            return m13632a(fusionHttpClient, z);
        }
        return null;
    }

    /* renamed from: a */
    private static FusionResource m13632a(FusionHttpClient fusionHttpClient, boolean z) {
        if (fusionHttpClient == null) {
            return null;
        }
        final FusionCacheClient fusionCacheClient = FusionCacheClient.sInstance;
        String headerValue = fusionHttpClient.getHeaderValue("Content-Type");
        String str = !TextUtils.isEmpty(headerValue) ? headerValue.split(";")[0] : "";
        if (TextUtils.isEmpty(str)) {
            str = FusionMimeTypeMap.getMimeTypeFromUrl(fusionHttpClient.getRequestUrl());
        }
        String str2 = str;
        Map<String, List<String>> responseHeader = fusionHttpClient.getResponseHeader();
        FusionBridgeStream fusionBridgeStream = new FusionBridgeStream(fusionHttpClient.getResponseStream());
        final String str3 = str2;
        final boolean z2 = z;
        final FusionHttpClient fusionHttpClient2 = fusionHttpClient;
        final Map<String, List<String>> map = responseHeader;
        fusionBridgeStream.setOnCloseListener(new FusionBridgeStream.OnCloseListener() {
            public void onClose(boolean z, final ByteArrayOutputStream byteArrayOutputStream) {
                if (!TextUtils.isEmpty(str3)) {
                    FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                        public void run() {
                            if (z2) {
                                fusionCacheClient.saveHeaders(fusionHttpClient2.getRequestUrl(), map);
                                fusionCacheClient.saveBody(fusionHttpClient2.getRequestUrl(), byteArrayOutputStream);
                            }
                            fusionHttpClient2.disconnect();
                        }
                    }, 2, TimeUnit.SECONDS);
                }
            }
        });
        Map<String, String> adapterHeaderForWebView = adapterHeaderForWebView(responseHeader);
        adapterHeaderForWebView.put("fusion_source", "net");
        return new FusionResource(str2, adapterHeaderForWebView, fusionBridgeStream);
    }

    /* renamed from: a */
    private static FusionResource m13633a(String str, Map<String, String> map, boolean z) {
        FusionCacheClient fusionCacheClient = FusionCacheClient.sInstance;
        Map<String, String> headerForResponse = fusionCacheClient.getHeaderForResponse(str);
        String str2 = headerForResponse.get("content-type");
        if (TextUtils.isEmpty(str2)) {
            str2 = FusionMimeTypeMap.getContentType(MimeTypeMap.getFileExtensionFromUrl(str));
        }
        Object attr = FusionEngine.getAttr("cache_html");
        boolean z2 = false;
        if (attr != null && (attr instanceof Boolean)) {
            z2 = ((Boolean) attr).booleanValue();
        }
        FusionResource fusionResource = null;
        if (!TextUtils.isEmpty(str2) && (z2 || !str2.contains("text/html"))) {
            InputStream bodyAsStream = fusionCacheClient.getBodyAsStream(str);
            if (bodyAsStream != null) {
                headerForResponse.put("fusion_source", "cache");
                fusionResource = new FusionResource(str2, headerForResponse, bodyAsStream);
            }
            if (fusionResource != null && z) {
                m13634a(str, map, fusionCacheClient.getHeaderForRequest(str));
            }
        }
        return fusionResource;
    }

    /* renamed from: a */
    private static void m13634a(final String str, final Map<String, String> map, final Map<String, String> map2) {
        FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
            public void run() {
                FusionCacheClient fusionCacheClient = FusionCacheClient.sInstance;
                HashMap hashMap = new HashMap();
                hashMap.putAll(map);
                Map map = map2;
                if (map != null && !map.isEmpty()) {
                    hashMap.putAll(map2);
                }
                FusionHttpClient fusionHttpClient = new FusionHttpClient(str, hashMap);
                if (fusionHttpClient.connect() == 0) {
                    if (!fusionHttpClient.isNotModified(map2) && fusionHttpClient.getResponseCode() == 200) {
                        fusionCacheClient.saveHeaders(str, fusionHttpClient.getResponseHeader());
                        fusionCacheClient.saveBody(str, fusionHttpClient.getResponseStream());
                    }
                    fusionHttpClient.disconnect();
                }
            }
        }, 3, TimeUnit.SECONDS);
    }

    public static void preloadResources(final Context context, final List<String> list) {
        if (list != null && !list.isEmpty()) {
            final FusionCacheClient fusionCacheClient = FusionCacheClient.sInstance;
            if (fusionCacheClient.isValid()) {
                FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                    public void run() {
                        for (String str : list) {
                            if (!NetworkUtil.isNetworkWifi(context)) {
                                return;
                            }
                            if (!fusionCacheClient.isCacheExist(str)) {
                                if (C7819Util.isApkDebug(context)) {
                                    SystemUtils.log(4, "Preload", "preload resource:" + str, (Throwable) null, "com.didi.dimina.webview.resource.FusionResourceManager$3", 237);
                                }
                                FusionHttpClient fusionHttpClient = new FusionHttpClient(str);
                                if (fusionHttpClient.connect() == 0) {
                                    if (fusionHttpClient.getResponseCode() == 200) {
                                        fusionCacheClient.saveHeaders(str, fusionHttpClient.getResponseHeader());
                                        fusionCacheClient.saveBody(str, fusionHttpClient.getResponseStream());
                                    }
                                    fusionHttpClient.disconnect();
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public static Map<String, String> adapterHeaderForWebView(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str.toLowerCase(), ((List) next.getValue()).get(0));
            }
        }
        return hashMap;
    }

    public static class FusionResource {
        public InputStream body;
        public Map<String, String> header;
        public String mimeType;

        public FusionResource(String str, Map<String, String> map, InputStream inputStream) {
            this.mimeType = str;
            this.header = map;
            this.body = inputStream;
        }

        public FusionResource(String str, InputStream inputStream) {
            this.mimeType = str;
            this.body = inputStream;
            HashMap hashMap = new HashMap();
            this.header = hashMap;
            hashMap.put("Access-Control-Allow-Origin", "*");
            this.header.put("fusion_source", "net");
        }
    }
}
