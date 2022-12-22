package com.didichuxing.xpanel.agent;

import com.didichuxing.xpanel.util.LogcatUtil;
import java.util.HashMap;

public class NetworkCache {
    public static final int BUFFER_LENGTH = 10;
    public static final long DURATION_TIME = 30000;
    public static final String TAG = "NetworkCache";
    public static NetworkCache instance;

    /* renamed from: a */
    LimitUpdateList<CacheEntry> f49274a = new LimitUpdateList<CacheEntry>(10) {
        /* access modifiers changed from: protected */
        public boolean equals(CacheEntry cacheEntry, CacheEntry cacheEntry2) {
            return cacheEntry.params.equals(cacheEntry2.params);
        }
    };

    private NetworkCache() {
    }

    public static NetworkCache getInstance() {
        if (instance == null) {
            synchronized (NetworkCache.class) {
                if (instance == null) {
                    instance = new NetworkCache();
                }
            }
        }
        return instance;
    }

    public void putCache(HashMap<String, Object> hashMap, String str) {
        LogcatUtil.m35795e(TAG, "putCache cache length = " + str.length());
        this.f49274a.putParams(new CacheEntry(hashMap, str, System.currentTimeMillis()));
    }

    public void clearCache(HashMap<String, Object> hashMap) {
        this.f49274a.removeParams(new CacheEntry(hashMap));
    }

    public String getCache(HashMap<String, Object> hashMap) {
        CacheEntry params = this.f49274a.getParams(new CacheEntry(hashMap));
        if (params == null) {
            LogcatUtil.m35795e(TAG, "缓存不存在 请求");
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        LogcatUtil.m35795e(TAG, "取出缓存 间隔：" + (currentTimeMillis - params.time));
        if (currentTimeMillis - params.time <= 30000) {
            return params.cache;
        }
        LogcatUtil.m35795e(TAG, "缓存失效 清除它 间隔：" + (currentTimeMillis - params.time));
        clearCache(hashMap);
        return "";
    }

    class CacheEntry {
        String cache;
        HashMap<String, Object> params;
        long time;

        public CacheEntry(HashMap<String, Object> hashMap) {
            this.params = hashMap;
        }

        public CacheEntry(HashMap<String, Object> hashMap, String str, long j) {
            this.params = hashMap;
            this.time = j;
            this.cache = str;
        }
    }
}
