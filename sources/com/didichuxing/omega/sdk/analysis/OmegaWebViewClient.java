package com.didichuxing.omega.sdk.analysis;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.threadpool.ThreadTaskObject;

public class OmegaWebViewClient extends WebViewClient {
    private WebViewClient webViewClient;

    public OmegaWebViewClient() {
    }

    public OmegaWebViewClient(WebViewClient webViewClient2) {
        this.webViewClient = webViewClient2;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.addJavascriptInterface(OmegaJS.getInstance(), "OmegaSDK");
        Event event = new Event("OMGH5WebOpen");
        event.putAttr("url", str);
        Tracker.trackEvent(event);
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return webViewClient2.shouldOverrideUrlLoading(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Event event = new Event("OMGH5WebStart");
        event.putAttr("url", str);
        Tracker.trackEvent(event);
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            super.onPageStarted(webView, str, bitmap);
        } else {
            webViewClient2.onPageStarted(webView, str, bitmap);
        }
    }

    public void onPageFinished(WebView webView, final String str) {
        new ThreadTaskObject() {
            public void run() {
                ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                Event event = new Event("OMGH5WebFinish");
                event.putAttr("url", str);
                event.putNetType();
                Tracker.trackEvent(event);
            }
        }.start();
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            super.onPageFinished(webView, str);
        } else {
            webViewClient2.onPageFinished(webView, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004d, code lost:
        r0.onReceivedError(r4, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0036, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0047, code lost:
        if (r0 != null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0049, code lost:
        super.onReceivedError(r4, r5, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceivedError(android.webkit.WebView r4, android.webkit.WebResourceRequest r5, android.webkit.WebResourceError r6) {
        /*
            r3 = this;
            com.didichuxing.omega.sdk.common.record.Event r0 = new com.didichuxing.omega.sdk.common.record.Event     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "OMGH5UrlError"
            r0.<init>(r1)     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "url"
            android.net.Uri r2 = r5.getUrl()     // Catch:{ all -> 0x0039 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0039 }
            r0.putAttr(r1, r2)     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "et"
            int r2 = r6.getErrorCode()     // Catch:{ all -> 0x0039 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0039 }
            r0.putAttr(r1, r2)     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "em"
            java.lang.CharSequence r2 = r6.getDescription()     // Catch:{ all -> 0x0039 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0039 }
            r0.putAttr(r1, r2)     // Catch:{ all -> 0x0039 }
            r0.putNetType()     // Catch:{ all -> 0x0039 }
            com.didichuxing.omega.sdk.analysis.Tracker.trackEvent((com.didichuxing.omega.sdk.common.record.Event) r0)     // Catch:{ all -> 0x0039 }
            android.webkit.WebViewClient r0 = r3.webViewClient
            if (r0 != 0) goto L_0x004d
            goto L_0x0049
        L_0x0039:
            r0 = move-exception
            android.net.Uri r1 = r5.getUrl()     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0051 }
            com.didichuxing.omega.sdk.analysis.Tracker.trackError(r1, r0)     // Catch:{ all -> 0x0051 }
            android.webkit.WebViewClient r0 = r3.webViewClient
            if (r0 != 0) goto L_0x004d
        L_0x0049:
            super.onReceivedError(r4, r5, r6)
            goto L_0x0050
        L_0x004d:
            r0.onReceivedError(r4, r5, r6)
        L_0x0050:
            return
        L_0x0051:
            r0 = move-exception
            android.webkit.WebViewClient r1 = r3.webViewClient
            if (r1 != 0) goto L_0x005a
            super.onReceivedError(r4, r5, r6)
            goto L_0x005d
        L_0x005a:
            r1.onReceivedError(r4, r5, r6)
        L_0x005d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.analysis.OmegaWebViewClient.onReceivedError(android.webkit.WebView, android.webkit.WebResourceRequest, android.webkit.WebResourceError):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r0.onReceivedError(r4, r5, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
        if (r0 == null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r0 != null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        super.onReceivedError(r4, r5, r6, r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceivedError(android.webkit.WebView r4, int r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            com.didichuxing.omega.sdk.common.record.Event r0 = new com.didichuxing.omega.sdk.common.record.Event     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = "OMGH5UrlError"
            r0.<init>(r1)     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = "url"
            r0.putAttr(r1, r7)     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = "et"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0025 }
            r0.putAttr(r1, r2)     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = "em"
            r0.putAttr(r1, r6)     // Catch:{ all -> 0x0025 }
            r0.putNetType()     // Catch:{ all -> 0x0025 }
            com.didichuxing.omega.sdk.analysis.Tracker.trackEvent((com.didichuxing.omega.sdk.common.record.Event) r0)     // Catch:{ all -> 0x0025 }
            android.webkit.WebViewClient r0 = r3.webViewClient
            if (r0 != 0) goto L_0x0031
            goto L_0x002d
        L_0x0025:
            r0 = move-exception
            com.didichuxing.omega.sdk.analysis.Tracker.trackError(r7, r0)     // Catch:{ all -> 0x0035 }
            android.webkit.WebViewClient r0 = r3.webViewClient
            if (r0 != 0) goto L_0x0031
        L_0x002d:
            super.onReceivedError(r4, r5, r6, r7)
            goto L_0x0034
        L_0x0031:
            r0.onReceivedError(r4, r5, r6, r7)
        L_0x0034:
            return
        L_0x0035:
            r0 = move-exception
            android.webkit.WebViewClient r1 = r3.webViewClient
            if (r1 != 0) goto L_0x003e
            super.onReceivedError(r4, r5, r6, r7)
            goto L_0x0041
        L_0x003e:
            r1.onReceivedError(r4, r5, r6, r7)
        L_0x0041:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.analysis.OmegaWebViewClient.onReceivedError(android.webkit.WebView, int, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
        r0.onReceivedHttpError(r4, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0029, code lost:
        if (r0 == null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003a, code lost:
        if (r0 != null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        super.onReceivedHttpError(r4, r5, r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceivedHttpError(android.webkit.WebView r4, android.webkit.WebResourceRequest r5, android.webkit.WebResourceResponse r6) {
        /*
            r3 = this;
            com.didichuxing.omega.sdk.common.record.Event r0 = new com.didichuxing.omega.sdk.common.record.Event     // Catch:{ all -> 0x002c }
            java.lang.String r1 = "OMGH5UrlError"
            r0.<init>(r1)     // Catch:{ all -> 0x002c }
            java.lang.String r1 = "url"
            android.net.Uri r2 = r5.getUrl()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x002c }
            r0.putAttr(r1, r2)     // Catch:{ all -> 0x002c }
            java.lang.String r1 = "et"
            int r2 = r6.getStatusCode()     // Catch:{ all -> 0x002c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x002c }
            r0.putAttr(r1, r2)     // Catch:{ all -> 0x002c }
            r0.putNetType()     // Catch:{ all -> 0x002c }
            com.didichuxing.omega.sdk.analysis.Tracker.trackEvent((com.didichuxing.omega.sdk.common.record.Event) r0)     // Catch:{ all -> 0x002c }
            android.webkit.WebViewClient r0 = r3.webViewClient
            if (r0 != 0) goto L_0x0040
            goto L_0x003c
        L_0x002c:
            r0 = move-exception
            android.net.Uri r1 = r5.getUrl()     // Catch:{ all -> 0x0044 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0044 }
            com.didichuxing.omega.sdk.analysis.Tracker.trackError(r1, r0)     // Catch:{ all -> 0x0044 }
            android.webkit.WebViewClient r0 = r3.webViewClient
            if (r0 != 0) goto L_0x0040
        L_0x003c:
            super.onReceivedHttpError(r4, r5, r6)
            goto L_0x0043
        L_0x0040:
            r0.onReceivedHttpError(r4, r5, r6)
        L_0x0043:
            return
        L_0x0044:
            r0 = move-exception
            android.webkit.WebViewClient r1 = r3.webViewClient
            if (r1 != 0) goto L_0x004d
            super.onReceivedHttpError(r4, r5, r6)
            goto L_0x0050
        L_0x004d:
            r1.onReceivedHttpError(r4, r5, r6)
        L_0x0050:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.analysis.OmegaWebViewClient.onReceivedHttpError(android.webkit.WebView, android.webkit.WebResourceRequest, android.webkit.WebResourceResponse):void");
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        WebViewClient webViewClient2;
        try {
            Event event = new Event("OMGH5UrlError");
            event.putAttr("url", sslError.getUrl());
            event.putAttr("et", Integer.valueOf(sslError.getPrimaryError()));
            event.putAttr("em", sslError.getClass().getSimpleName());
            event.putNetType();
            Tracker.trackEvent(event);
            if (webViewClient2 != null) {
                webViewClient2.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        } finally {
            webViewClient2 = this.webViewClient;
            if (webViewClient2 == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                webViewClient2.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }
    }

    public void onLoadResource(WebView webView, String str) {
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            super.onLoadResource(webView, str);
        } else {
            webViewClient2.onLoadResource(webView, str);
        }
    }

    public void onPageCommitVisible(WebView webView, String str) {
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            super.onPageCommitVisible(webView, str);
        } else {
            webViewClient2.onPageCommitVisible(webView, str);
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return webViewClient2.shouldInterceptRequest(webView, webResourceRequest);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            super.onFormResubmission(webView, message, message2);
        } else {
            webViewClient2.onFormResubmission(webView, message, message2);
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            super.doUpdateVisitedHistory(webView, str, z);
        } else {
            webViewClient2.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            webViewClient2.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            webViewClient2.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }
        return webViewClient2.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            super.onScaleChanged(webView, f, f2);
        } else {
            webViewClient2.onScaleChanged(webView, f, f2);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewClient webViewClient2 = this.webViewClient;
        if (webViewClient2 == null) {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            webViewClient2.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }
}
