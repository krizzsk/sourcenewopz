package com.didi.dimina.webview.resource;

import android.content.Context;
import com.didi.dimina.webview.resource.FusionResourceManager;

public class FusionUrlPreLoader {
    public static long ActivityStart = -1;

    /* renamed from: a */
    private static final String f18341a = "FusionUrlPreLoader";

    /* renamed from: b */
    private static final short f18342b = 201;

    /* renamed from: c */
    private static final short f18343c = 202;

    /* renamed from: d */
    private static final short f18344d = 203;

    /* renamed from: e */
    private final Context f18345e;

    /* renamed from: f */
    private final String f18346f;

    /* renamed from: g */
    private FusionCacheClient f18347g = null;

    /* renamed from: h */
    private final FusionHttpClient f18348h = null;

    /* renamed from: i */
    private volatile int f18349i = -1;

    /* renamed from: j */
    private FusionResourceManager.FusionResource f18350j;

    public FusionUrlPreLoader(Context context, String str) {
        this.f18345e = context;
        this.f18346f = str;
        ActivityStart = System.currentTimeMillis();
        this.f18347g = FusionCacheClient.sInstance;
    }

    public synchronized FusionResourceManager.FusionResource getPreLoadResource() {
        this.f18349i = 202;
        return this.f18350j;
    }

    public synchronized boolean isValid() {
        return (this.f18349i == -1 || this.f18349i == 202) ? false : true;
    }

    public boolean isLoadFinished() {
        return this.f18349i == 203;
    }
}
