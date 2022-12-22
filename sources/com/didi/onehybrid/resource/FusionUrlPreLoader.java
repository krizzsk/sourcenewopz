package com.didi.onehybrid.resource;

import android.content.Context;
import com.didi.onehybrid.resource.FusionResourceManager;

public class FusionUrlPreLoader {
    public static long ActivityStart = -1;

    /* renamed from: a */
    private static final String f29697a = "FusionUrlPreLoader";

    /* renamed from: b */
    private static final short f29698b = 201;

    /* renamed from: c */
    private static final short f29699c = 202;

    /* renamed from: d */
    private static final short f29700d = 203;

    /* renamed from: e */
    private Context f29701e;

    /* renamed from: f */
    private String f29702f;

    /* renamed from: g */
    private FusionCacheClient f29703g = null;

    /* renamed from: h */
    private FusionHttpClient f29704h = null;

    /* renamed from: i */
    private volatile int f29705i = -1;

    /* renamed from: j */
    private FusionResourceManager.FusionResource f29706j;

    public FusionUrlPreLoader(Context context, String str) {
        this.f29701e = context;
        this.f29702f = str;
        ActivityStart = System.currentTimeMillis();
        this.f29703g = FusionCacheClient.sInstance;
    }

    public synchronized void startLoad() {
    }

    public synchronized FusionResourceManager.FusionResource getPreLoadResource() {
        this.f29705i = 202;
        return this.f29706j;
    }

    public synchronized boolean isValid() {
        return (this.f29705i == -1 || this.f29705i == 202) ? false : true;
    }

    public boolean isLoadFinished() {
        return this.f29705i == 203;
    }
}
