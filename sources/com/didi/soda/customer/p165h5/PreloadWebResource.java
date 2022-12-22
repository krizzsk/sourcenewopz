package com.didi.soda.customer.p165h5;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.didi.onehybrid.container.FusionWebViewClient;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.p165h5.PreloadWebResource;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridWebChromeClient;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridWebViewClient;
import com.didi.soda.customer.p165h5.hybird.WebChromeClientCallback;
import com.didi.soda.customer.p165h5.hybird.WebViewClientCallback;
import com.didi.soda.web.widgets.SodaWebView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0014\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J.\u0010\u001a\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u001e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010#\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010&\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/didi/soda/customer/h5/PreloadWebResource;", "Lcom/didi/soda/customer/h5/hybird/WebChromeClientCallback;", "Lcom/didi/soda/customer/h5/hybird/WebViewClientCallback;", "()V", "preWebView", "Lcom/didi/soda/web/widgets/SodaWebView;", "createWebView", "", "context", "Landroid/content/Context;", "destroy", "doPreload", "onConsoleMessage", "consoleMessage", "Landroid/webkit/ConsoleMessage;", "onPageFinished", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onProgressChanged", "newProgress", "", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedHttpError", "request", "Landroid/webkit/WebResourceRequest;", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedTitle", "title", "preloadWebRes", "shouldInterceptRequest", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.PreloadWebResource */
/* compiled from: PreloadWebResource.kt */
public final class PreloadWebResource implements WebChromeClientCallback, WebViewClientCallback {
    public static final Companion Companion;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f41302b;

    /* renamed from: c */
    private static final String f41303c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static PreloadWebResource f41304d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Runnable f41305e;

    /* renamed from: a */
    private SodaWebView f41306a;

    public void onConsoleMessage(ConsoleMessage consoleMessage) {
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    public void onProgressChanged(WebView webView, int i) {
    }

    public void onReceivedTitle(WebView webView, String str) {
    }

    public void shouldInterceptRequest(WebView webView, String str) {
    }

    @Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/PreloadWebResource$Companion;", "", "()V", "isPreload", "", "preloadUrl", "", "runnable", "Ljava/lang/Runnable;", "tempRef", "Lcom/didi/soda/customer/h5/PreloadWebResource;", "beginPreloadWebResource", "", "context", "Landroid/content/Context;", "destroyPreloadWebResource", "toDestroy", "delay", "", "getPreloadUrl", "isOpenPreloadH5", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.soda.customer.h5.PreloadWebResource$Companion */
    /* compiled from: PreloadWebResource.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final String getPreloadUrl() {
            return GlobalContext.isBrazil() ? "https://food.99app.com/${locale}/grocery/?grocery_preload=true" : "https://didi-food.com/${locale}/grocery/?grocery_preload=true";
        }

        public final void beginPreloadWebResource(Context context) {
            if (context != null && !PreloadWebResource.f41302b) {
                PreloadWebResource.f41302b = true;
                if (isOpenPreloadH5()) {
                    PreloadWebResource.f41304d = new PreloadWebResource();
                    PreloadWebResource access$getTempRef$cp = PreloadWebResource.f41304d;
                    if (access$getTempRef$cp != null) {
                        access$getTempRef$cp.preloadWebRes(context);
                    }
                    destroyPreloadWebResource(PreloadWebResource.f41304d, 60000);
                }
            }
        }

        private final boolean isOpenPreloadH5() {
            return CustomerApolloUtil.isOpenPreloadH5();
        }

        /* access modifiers changed from: private */
        public final void destroyPreloadWebResource(PreloadWebResource preloadWebResource, long j) {
            if (preloadWebResource != null) {
                if (PreloadWebResource.f41305e != null) {
                    UiHandlerUtil.removeCallbacks(PreloadWebResource.f41305e);
                }
                PreloadWebResource.f41305e = new Runnable() {
                    public final void run() {
                        PreloadWebResource.Companion.m46903destroyPreloadWebResource$lambda0(PreloadWebResource.this);
                    }
                };
                UiHandlerUtil.postDelayed(PreloadWebResource.f41305e, j);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: destroyPreloadWebResource$lambda-0  reason: not valid java name */
        public static final void m46903destroyPreloadWebResource$lambda0(PreloadWebResource preloadWebResource) {
            preloadWebResource.m29258a();
            Companion companion = PreloadWebResource.Companion;
            PreloadWebResource.f41305e = null;
            Companion companion2 = PreloadWebResource.Companion;
            PreloadWebResource.f41304d = null;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        f41303c = companion.getPreloadUrl();
    }

    public final void preloadWebRes(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogUtil.m29100d("PreloadWeb", ">>>>>> Begin preload web resource <<<<<<<<");
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler(context) {
            public final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final boolean queueIdle() {
                return PreloadWebResource.m29260a(PreloadWebResource.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m29260a(PreloadWebResource preloadWebResource, Context context) {
        Intrinsics.checkNotNullParameter(preloadWebResource, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        preloadWebResource.m29259a(context);
        return false;
    }

    /* renamed from: a */
    private final void m29259a(Context context) {
        m29261b(context);
    }

    /* renamed from: b */
    private final void m29261b(Context context) {
        try {
            SodaWebView sodaWebView = new SodaWebView(context);
            FusionWebViewClient customerHybridWebViewClient = new CustomerHybridWebViewClient(sodaWebView, this);
            WebHelper.attachOmegaJS(sodaWebView, customerHybridWebViewClient);
            sodaWebView.setWebViewClient(customerHybridWebViewClient);
            sodaWebView.setWebChromeClient(new CustomerHybridWebChromeClient(sodaWebView, this));
            sodaWebView.loadUrl(f41303c);
            this.f41306a = sodaWebView;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29258a() {
        LogUtil.m29100d("PreloadWeb", " >>>>>>> destroyWeb <<<<<<<< ");
        try {
            SodaWebView sodaWebView = this.f41306a;
            if (sodaWebView != null) {
                sodaWebView.destroy();
            }
            this.f41306a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onPageFinished(WebView webView, String str) {
        Companion.destroyPreloadWebResource(this, 3000);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Companion.destroyPreloadWebResource(this, 3000);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Companion.destroyPreloadWebResource(this, 3000);
    }
}
