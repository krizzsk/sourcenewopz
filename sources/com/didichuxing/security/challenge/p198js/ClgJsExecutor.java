package com.didichuxing.security.challenge.p198js;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.didichuxing.security.challenge.js.ClgJsExecutor */
public class ClgJsExecutor {
    private static volatile ClgJsExecutor instance;
    /* access modifiers changed from: private */
    public Context context;
    private volatile ExecutorService executorService = Executors.newCachedThreadPool();
    private Handler mainThreadHandler;
    /* access modifiers changed from: private */
    public volatile WebView webView;

    /* renamed from: com.didichuxing.security.challenge.js.ClgJsExecutor$Callback */
    public interface Callback {
        void onMessage(String str);

        void onResult(String str);
    }

    private ClgJsExecutor(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public static ClgJsExecutor getInstance(Context context2) {
        if (instance == null) {
            synchronized (ClgJsExecutor.class) {
                if (instance == null) {
                    instance = new ClgJsExecutor(context2);
                }
            }
        }
        return instance;
    }

    public void execute(String str, String str2, String str3, final Callback callback) {
        final String jsScript = getJsScript(str, str2, str3);
        this.executorService.execute(new Runnable() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.didichuxing.security.quickjs.JSRuntime} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.didichuxing.security.quickjs.JSContext} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.didichuxing.security.quickjs.JSRuntime} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.didichuxing.security.quickjs.JSContext} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.didichuxing.security.quickjs.JSRuntime} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.didichuxing.security.quickjs.JSContext} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.didichuxing.security.quickjs.JSRuntime} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.didichuxing.security.quickjs.JSContext} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.didichuxing.security.quickjs.JSRuntime} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[SYNTHETIC, Splitter:B:19:0x0073] */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x007a A[SYNTHETIC, Splitter:B:23:0x007a] */
            /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r8 = this;
                    r0 = 0
                    com.didichuxing.security.challenge.js.ClgJsExecutor$Callback r1 = r4     // Catch:{ all -> 0x0044 }
                    java.lang.String r2 = "js engine didi-quickjs"
                    r1.onMessage(r2)     // Catch:{ all -> 0x0044 }
                    com.didichuxing.security.quickjs.QuickJS$Builder r1 = new com.didichuxing.security.quickjs.QuickJS$Builder     // Catch:{ all -> 0x0044 }
                    r1.<init>()     // Catch:{ all -> 0x0044 }
                    com.didichuxing.security.quickjs.QuickJS r1 = r1.build()     // Catch:{ all -> 0x0044 }
                    com.didichuxing.security.quickjs.JSRuntime r1 = r1.createJSRuntime()     // Catch:{ all -> 0x0044 }
                    com.didichuxing.security.quickjs.JSContext r0 = r1.createJSContext()     // Catch:{ all -> 0x003f }
                    java.lang.String r2 = r1     // Catch:{ all -> 0x003f }
                    java.lang.String r3 = "cr.js"
                    java.lang.Class r4 = java.lang.Double.TYPE     // Catch:{ all -> 0x003f }
                    java.lang.Object r2 = r0.evaluate((java.lang.String) r2, (java.lang.String) r3, r4)     // Catch:{ all -> 0x003f }
                    java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ all -> 0x003f }
                    double r2 = r2.doubleValue()     // Catch:{ all -> 0x003f }
                    com.didichuxing.security.challenge.js.ClgJsExecutor$Callback r4 = r4     // Catch:{ all -> 0x003f }
                    java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x003f }
                    r4.onResult(r2)     // Catch:{ all -> 0x003f }
                    if (r0 == 0) goto L_0x0039
                    r0.close()     // Catch:{ all -> 0x0038 }
                    goto L_0x0039
                L_0x0038:
                L_0x0039:
                    if (r1 == 0) goto L_0x007d
                    r1.close()     // Catch:{ all -> 0x007d }
                    goto L_0x007d
                L_0x003f:
                    r2 = move-exception
                    r7 = r1
                    r1 = r0
                    r0 = r7
                    goto L_0x0046
                L_0x0044:
                    r2 = move-exception
                    r1 = r0
                L_0x0046:
                    com.didichuxing.security.challenge.js.ClgJsExecutor r3 = com.didichuxing.security.challenge.p198js.ClgJsExecutor.this     // Catch:{ all -> 0x007e }
                    android.content.Context r3 = r3.context     // Catch:{ all -> 0x007e }
                    r4 = 0
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
                    r5.<init>()     // Catch:{ all -> 0x007e }
                    java.lang.String r6 = "didi-quickjs："
                    r5.append(r6)     // Catch:{ all -> 0x007e }
                    r5.append(r2)     // Catch:{ all -> 0x007e }
                    java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x007e }
                    com.didichuxing.security.challenge.track.ClgTracker.trackTest(r3, r4, r2)     // Catch:{ all -> 0x007e }
                    com.didichuxing.security.challenge.js.ClgJsExecutor$Callback r2 = r4     // Catch:{ all -> 0x007e }
                    java.lang.String r3 = "js engine wv"
                    r2.onMessage(r3)     // Catch:{ all -> 0x007e }
                    com.didichuxing.security.challenge.js.ClgJsExecutor r2 = com.didichuxing.security.challenge.p198js.ClgJsExecutor.this     // Catch:{ all -> 0x007e }
                    java.lang.String r3 = r1     // Catch:{ all -> 0x007e }
                    com.didichuxing.security.challenge.js.ClgJsExecutor$Callback r4 = r4     // Catch:{ all -> 0x007e }
                    r2.doWithWebview(r3, r4)     // Catch:{ all -> 0x007e }
                    if (r1 == 0) goto L_0x0078
                    r1.close()     // Catch:{ all -> 0x0077 }
                    goto L_0x0078
                L_0x0077:
                L_0x0078:
                    if (r0 == 0) goto L_0x007d
                    r0.close()     // Catch:{ all -> 0x007d }
                L_0x007d:
                    return
                L_0x007e:
                    r2 = move-exception
                    if (r1 == 0) goto L_0x0086
                    r1.close()     // Catch:{ all -> 0x0085 }
                    goto L_0x0086
                L_0x0085:
                L_0x0086:
                    if (r0 == 0) goto L_0x008b
                    r0.close()     // Catch:{ all -> 0x008b }
                L_0x008b:
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.security.challenge.p198js.ClgJsExecutor.C164221.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public void doWithWebview(final String str, final Callback callback) {
        final C164232 r0 = new ValueCallback<String>() {
            public void onReceiveValue(String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onResult(str);
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ensureWebView();
            if (this.webView != null) {
                this.webView.evaluateJavascript(str, r0);
            } else if (callback != null) {
                callback.onResult((String) null);
            }
        } else {
            if (this.mainThreadHandler == null) {
                synchronized (ClgJsExecutor.class) {
                    if (this.mainThreadHandler == null) {
                        this.mainThreadHandler = new Handler(Looper.getMainLooper());
                    }
                }
            }
            this.mainThreadHandler.post(new Runnable() {
                public void run() {
                    ClgJsExecutor.this.ensureWebView();
                    if (ClgJsExecutor.this.webView != null) {
                        ClgJsExecutor.this.webView.evaluateJavascript(str, r0);
                        return;
                    }
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onResult((String) null);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void ensureWebView() {
        if (this.webView == null) {
            try {
                this.webView = new WebView(this.context);
                this.webView.getSettings().setJavaScriptEnabled(true);
                this.webView.removeJavascriptInterface("searchBoxJavaBridge_");
                this.webView.removeJavascriptInterface("accessibility");
                this.webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
                this.webView = null;
            }
        }
    }

    private String getJsScript(String str, String str2, String str3) {
        return "a=" + str + "\na(" + str3 + ")";
    }
}
