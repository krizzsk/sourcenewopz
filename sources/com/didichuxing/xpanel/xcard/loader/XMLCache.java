package com.didichuxing.xpanel.xcard.loader;

import java.util.LinkedHashMap;
import java.util.Map;

public class XMLCache {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f49636a;

    /* renamed from: b */
    private LinkedHashMap<String, XMLCacheEntity> f49637b;

    private XMLCache() {
        this.f49636a = 40;
        this.f49637b = new LinkedHashMap<String, XMLCacheEntity>(this.f49636a) {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<String, XMLCacheEntity> entry) {
                return size() > XMLCache.this.f49636a;
            }
        };
    }

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static XMLCache sInstance = new XMLCache();

        private SingleTon() {
        }
    }

    public static XMLCache getInstance() {
        return SingleTon.sInstance;
    }

    public LinkedHashMap<String, XMLCacheEntity> getXMLCache() {
        return this.f49637b;
    }

    public void putXMLCache(String str, XMLCacheEntity xMLCacheEntity) {
        this.f49637b.put(str, xMLCacheEntity);
    }
}
