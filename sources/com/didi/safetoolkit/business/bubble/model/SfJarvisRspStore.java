package com.didi.safetoolkit.business.bubble.model;

import com.google.gson.Gson;

public class SfJarvisRspStore {

    /* renamed from: a */
    private static SfJarvisRspStore f34282a;

    /* renamed from: b */
    private SfJarvisData f34283b;

    public static SfJarvisRspStore getInstance() {
        SfJarvisRspStore sfJarvisRspStore = f34282a;
        if (sfJarvisRspStore != null) {
            return sfJarvisRspStore;
        }
        SfJarvisRspStore sfJarvisRspStore2 = new SfJarvisRspStore();
        f34282a = sfJarvisRspStore2;
        return sfJarvisRspStore2;
    }

    public void setSfJarvisRspData(SfJarvisData sfJarvisData) {
        this.f34283b = sfJarvisData;
    }

    public SfJarvisData getSfJarvisRspData() {
        return this.f34283b;
    }

    public void clearSfJarvisRspData() {
        this.f34283b = null;
    }

    public String getSfJarvisRspStr() {
        if (this.f34283b == null) {
            return "{}";
        }
        return new Gson().toJson((Object) this.f34283b);
    }
}
