package com.didi.onehybrid.resource;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.didi.onehybrid.util.C10393Util;
import com.didi.onehybrid.util.FileUtil;
import com.didi.onehybrid.util.MD5Util;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.common.net.HttpHeaders;
import com.jakewharton.disklrucache.DiskLruCache;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class FusionCacheClient {

    /* renamed from: a */
    private static final String f29672a = "hybridfile";

    /* renamed from: b */
    private static final long f29673b = 52428800;

    /* renamed from: c */
    private static AtomicBoolean f29674c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static File f29675f;
    public static FusionCacheClient sInstance;

    /* renamed from: d */
    private DiskLruCache f29676d;

    /* renamed from: e */
    private Context f29677e;

    /* renamed from: g */
    private CookieManager f29678g;

    public static void init(Context context) {
        if (f29674c.compareAndSet(false, true)) {
            sInstance = new FusionCacheClient(context);
        }
    }

    private FusionCacheClient(Context context) {
        this.f29677e = context;
        FusionCacheDataHelper.sInstance.initFusionCacheDataHelper(context);
        try {
            DiskLruCache open = DiskLruCache.open(C10393Util.getDiskCacheDir(context, f29672a), C10393Util.getAppVersion(context), 1, 52428800);
            this.f29676d = open;
            open.setEntryRemoveListener(new DiskLruCache.RemoveListener() {
                public void onEntryRemoved(String str) {
                    FusionCacheDataHelper.sInstance.removeHeader(str);
                }
            });
            f29675f = this.f29676d.getDirectory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isValid() {
        return (this.f29676d == null || f29675f == null) ? false : true;
    }

    public boolean isCacheExist(String str) {
        DiskLruCache.Snapshot snapshot;
        if (!isValid()) {
            return false;
        }
        try {
            snapshot = this.f29676d.get(m20843b(str));
        } catch (IOException unused) {
            snapshot = null;
        }
        if (snapshot != null) {
            return true;
        }
        return false;
    }

    public void saveBody(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (isValid()) {
            if (byteArrayOutputStream == null || TextUtils.isEmpty(str)) {
                throw new NullPointerException("saveBody null params!");
            }
            try {
                DiskLruCache.Editor edit = this.f29676d.edit(m20843b(str));
                edit.newOutputStream(0).write(byteArrayOutputStream.toByteArray());
                edit.commit();
                this.f29676d.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveBody(String str, BufferedInputStream bufferedInputStream) {
        if (isValid()) {
            String b = m20843b(str);
            try {
                DiskLruCache.Editor edit = this.f29676d.edit(b);
                boolean writeInputStreamToOutputStream = FileUtil.writeInputStreamToOutputStream(bufferedInputStream, edit.newOutputStream(0));
                edit.commit();
                this.f29676d.flush();
                if (!writeInputStreamToOutputStream) {
                    this.f29676d.remove(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m20843b(String str) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split("\\?");
        sb.append(split[0]);
        if (split.length >= 2) {
            sb.append("?");
            for (String str2 : split[1].split(ParamKeys.SIGN_AND)) {
                if (!str2.startsWith("time=") && !str2.startsWith("lat=") && !str2.startsWith("lng=")) {
                    sb.append(str2);
                    sb.append(ParamKeys.SIGN_AND);
                }
            }
        }
        return MD5Util.md5(sb.toString());
    }

    public File getBody(String str) {
        if (!isValid()) {
            return null;
        }
        File file = new File(FusionCacheDataHelper.sInstance.getFilePath(MD5Util.md5(str)));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public InputStream getBodyAsStream(String str) {
        try {
            DiskLruCache.Snapshot snapshot = this.f29676d.get(m20843b(str));
            if (snapshot != null) {
                return snapshot.getInputStream(0);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public void saveHeaders(String str, Map<String, List<String>> map) {
        FusionCacheDataHelper.sInstance.setHeaders(str, map);
    }

    public Map<String, String> getHeaderForRequest(String str) {
        return FusionCacheDataHelper.sInstance.getHeadersForRequest(str);
    }

    public Map<String, String> getHeaderForResponse(String str) {
        return FusionCacheDataHelper.sInstance.getHeadersForResponse(str);
    }

    public void saveHeadersAndBody(ByteArrayOutputStream byteArrayOutputStream, String str, Map<String, List<String>> map) {
        saveBody(str, byteArrayOutputStream);
        saveHeaders(str, map);
    }

    public void removeHeader(String str) {
        if (!TextUtils.isEmpty(str)) {
            FusionCacheDataHelper.sInstance.removeHeader(str);
        }
    }

    /* renamed from: b */
    private synchronized CookieManager m20842b() {
        if (this.f29678g == null) {
            this.f29678g = CookieManager.getInstance();
        }
        return this.f29678g;
    }

    public String getCookie(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return m20842b().getCookie(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public void saveCookie(String str, Map<String, List<String>> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            for (String next : map.keySet()) {
                if (next != null && (next.equalsIgnoreCase(HttpHeaders.SET_COOKIE2) || next.equalsIgnoreCase("Set-Cookie"))) {
                    for (String cookie : map.get(next)) {
                        m20842b().setCookie(str, cookie);
                    }
                }
            }
        }
    }

    public void deleteAll() {
        try {
            if (this.f29676d != null) {
                this.f29676d.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class FusionCacheDataHelper {
        private static final String CACHE_DATA_FILE = "cache_data";
        private static AtomicBoolean sInit = new AtomicBoolean(false);
        public static FusionCacheDataHelper sInstance = new FusionCacheDataHelper();
        private static final Map<String, String> sRequestHeaderKeyMap;
        private static final List<String> sResponseHeaderKeys;
        private static final Set<String> sResponseHeadersNeedCache;
        private SharedPreferences sharedPreferences;

        private FusionCacheDataHelper() {
        }

        static {
            HashSet hashSet = new HashSet();
            sResponseHeadersNeedCache = hashSet;
            hashSet.add("last-modified");
            sResponseHeadersNeedCache.add("etag");
            sResponseHeadersNeedCache.add("access-control-allow-credentials");
            sResponseHeadersNeedCache.add("access-control-allow-headers");
            sResponseHeadersNeedCache.add("access-control-allow-methods");
            sResponseHeadersNeedCache.add("access-control-allow-origin");
            sResponseHeadersNeedCache.add("access-control-expose-headers");
            sResponseHeadersNeedCache.add("access-control-max-age");
            sResponseHeadersNeedCache.add("content-type");
            HashMap hashMap = new HashMap();
            sRequestHeaderKeyMap = hashMap;
            hashMap.put("last-modified", "if-modified-since");
            sRequestHeaderKeyMap.put("etag", "if-none-match");
            ArrayList arrayList = new ArrayList(6);
            sResponseHeaderKeys = arrayList;
            arrayList.add("access-control-allow-credentials");
            sResponseHeaderKeys.add("access-control-allow-headers");
            sResponseHeaderKeys.add("access-control-allow-methods");
            sResponseHeaderKeys.add("access-control-allow-origin");
            sResponseHeaderKeys.add("access-control-expose-headers");
            sResponseHeaderKeys.add("access-control-max-age");
            sResponseHeaderKeys.add("content-type");
        }

        public FusionCacheDataHelper initFusionCacheDataHelper(Context context) {
            if (sInit.compareAndSet(false, true)) {
                this.sharedPreferences = SystemUtils.getSharedPreferences(context, CACHE_DATA_FILE, 0);
            }
            return sInstance;
        }

        public String getFilePath(String str) {
            return FusionCacheClient.f29675f.getAbsolutePath() + File.separator + str + ".0";
        }

        public void setHeaders(String str, Map<String, List<String>> map) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry next : map.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) next.getKey()) && sResponseHeadersNeedCache.contains(((String) next.getKey()).toLowerCase())) {
                    try {
                        jSONObject.put(((String) next.getKey()).toLowerCase(), ((List) next.getValue()).get(0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            SharedPreferences.Editor edit = this.sharedPreferences.edit();
            edit.putString("fusion_cache_pre_headers_" + FusionCacheClient.m20843b(str), jSONObject.toString());
            edit.apply();
        }

        public void removeHeader(String str) {
            SharedPreferences.Editor edit = this.sharedPreferences.edit();
            edit.remove("fusion_cache_pre_headers_" + str);
            edit.apply();
        }

        public Map<String, String> getHeadersForRequest(String str) {
            HashMap hashMap = new HashMap();
            String string = this.sharedPreferences.getString("fusion_cache_pre_headers_" + FusionCacheClient.m20843b(str), "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    for (Map.Entry next : sRequestHeaderKeyMap.entrySet()) {
                        String optString = jSONObject.optString((String) next.getKey());
                        if (!TextUtils.isEmpty(optString)) {
                            hashMap.put(next.getValue(), optString);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return hashMap;
        }

        public Map<String, String> getHeadersForResponse(String str) {
            HashMap hashMap = new HashMap();
            String a = FusionCacheClient.m20843b(str);
            String string = this.sharedPreferences.getString("fusion_cache_pre_headers_" + a, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    for (String next : sResponseHeaderKeys) {
                        String optString = jSONObject.optString(next);
                        if (!TextUtils.isEmpty(optString)) {
                            hashMap.put(next, optString);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return hashMap;
        }
    }

    public static File getHybridDir() {
        return f29675f;
    }
}
