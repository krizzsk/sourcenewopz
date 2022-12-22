package com.didi.dimina.webview;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.didi.dimina.container.bridge.DMWebViewJSModule;
import com.didi.dimina.webview.FusionInitConfig;
import com.didi.dimina.webview.dmwebview.DMBusinessAgent;
import com.didi.sdk.apm.SystemUtils;

public final class FusionInitializerProvider extends ContentProvider {

    /* renamed from: a */
    private static volatile boolean f18220a = false;

    /* renamed from: b */
    private static final String f18221b = "FusionInitializerProvider";

    /* renamed from: a */
    private static void m13580a(Application application) {
        if (!f18220a) {
            SystemUtils.log(4, f18221b, "initInternal >>>", (Throwable) null, "com.didi.dimina.webview.FusionInitializerProvider", 25);
            f18220a = true;
            FusionEngine.init(application, new FusionInitConfig.Builder().setBusinessAgent(new DMBusinessAgent(application)).build());
            FusionEngine.export("DMWebViewBridgeModule", DMWebViewJSModule.class);
        }
    }

    public boolean onCreate() {
        SystemUtils.log(4, f18221b, "FusionInitializerProvider onCreate>>>", (Throwable) null, "com.didi.dimina.webview.FusionInitializerProvider", 37);
        m13580a((Application) getContext().getApplicationContext());
        SystemUtils.log(4, f18221b, "FusionInitializerProvider onCreate end>>>", (Throwable) null, "com.didi.dimina.webview.FusionInitializerProvider", 40);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new UnsupportedOperationException("Just initializer");
    }

    public String getType(Uri uri) {
        throw new UnsupportedOperationException("Just initializer");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Just initializer");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Just initializer");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Just initializer");
    }
}
