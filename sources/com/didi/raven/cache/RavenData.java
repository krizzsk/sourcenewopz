package com.didi.raven.cache;

import android.text.TextUtils;
import com.didi.raven.RavenDataManger;
import com.didi.raven.config.RavenConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class RavenData {

    /* renamed from: a */
    private final AtomicInteger f33089a = new AtomicInteger(0);

    /* renamed from: b */
    private String f33090b = "";

    /* renamed from: c */
    private String f33091c = RavenConstants.DEFAULT_PATH;

    /* renamed from: d */
    private Map<String, Object> f33092d = new ConcurrentHashMap();

    /* renamed from: e */
    private Map<String, Object> f33093e = new ConcurrentHashMap();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87172a() {
        this.f33089a.set(0);
    }

    public int getIndex() {
        return this.f33089a.incrementAndGet();
    }

    public String getRavenId() {
        if (TextUtils.isEmpty(this.f33090b) || TextUtils.equals("unKnow", this.f33090b)) {
            if (TextUtils.isEmpty(RavenCache.RAVEN_ID)) {
                String loadRavenId = RavenDataManger.getInstance().loadRavenId();
                this.f33090b = loadRavenId;
                RavenCache.RAVEN_ID = loadRavenId;
            } else {
                this.f33090b = RavenCache.RAVEN_ID;
            }
        }
        return this.f33090b;
    }

    public String getBaseUrl() {
        return this.f33091c;
    }

    public void setBaseUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f33091c = str;
        }
    }

    public Map<String, Object> getAttrs() {
        return this.f33092d;
    }

    public void setAttrs(Map<String, Object> map) {
        this.f33092d = map;
    }

    public Map<String, Object> getConfig() {
        return this.f33093e;
    }

    public void setConfig(Map<String, Object> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                if (map.get(next) != null) {
                    this.f33093e.put(next, map.get(next));
                }
            }
        }
    }
}
