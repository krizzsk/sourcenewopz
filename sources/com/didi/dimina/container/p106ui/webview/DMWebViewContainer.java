package com.didi.dimina.container.p106ui.webview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.p106ui.webview.DMWebViewContainer;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.webview.DMWebViewContainer */
public class DMWebViewContainer extends FrameLayout {

    /* renamed from: a */
    private static final String f17850a = "DMWebViewContainer";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WebViewEngine f17851b;

    /* renamed from: c */
    private FrameLayout f17852c;

    /* renamed from: d */
    private TouchInterceptFrameLayout f17853d;

    /* renamed from: e */
    private OnTitleChangeListener f17854e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DMMina f17855f;

    /* renamed from: g */
    private DMMinaNavigatorDelegate f17856g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final List<WebViewEngine.OnWebViewLoadListener> f17857h = new ArrayList();

    /* renamed from: com.didi.dimina.container.ui.webview.DMWebViewContainer$OnTitleChangeListener */
    public interface OnTitleChangeListener {
        void onTitleChanged(String str);
    }

    public DMWebViewContainer(Context context) {
        super(context);
        m13367b();
    }

    public DMWebViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13367b();
    }

    public DMWebViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13367b();
    }

    public void setChangeTitleListener(OnTitleChangeListener onTitleChangeListener) {
        this.f17854e = onTitleChangeListener;
        WebViewEngine webViewEngine = this.f17851b;
        if (webViewEngine != null) {
            onTitleChangeListener.getClass();
            webViewEngine.setOnTitleReceiveListener(new WebViewEngine.OnTitleReceiveListener() {
                public final void onReceiveTitle(String str) {
                    DMWebViewContainer.OnTitleChangeListener.this.onTitleChanged(str);
                }
            });
        }
    }

    public OnTitleChangeListener getChangeTitleListener() {
        return this.f17854e;
    }

    public void loadUrl(String str) {
        WebViewEngine webViewEngine = this.f17851b;
        if (webViewEngine != null) {
            webViewEngine.loadUrl(str);
        }
    }

    public void syncData(DMPage dMPage, DMMina dMMina, DMMinaNavigatorDelegate dMMinaNavigatorDelegate) {
        this.f17855f = dMMina;
        this.f17856g = dMMinaNavigatorDelegate;
        initWebView();
        WebViewEngine webViewEngine = this.f17851b;
        if (webViewEngine != null) {
            webViewEngine.dmCreate(this, dMPage, this.f17855f, dMMinaNavigatorDelegate);
        }
    }

    public void initBackground(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSAppConfig jSAppConfig = getWebView().getDmMina().getJSAppConfig();
            if (jSAppConfig != null) {
                JSAppConfig.PageConfig pageConfig = jSAppConfig.getPageConfig(str);
                if (pageConfig == null || !TextUtils.equals(pageConfig.type, "map")) {
                    m13365a();
                } else {
                    setWebViewBackgroundTransparent();
                }
            }
        } else {
            m13365a();
        }
    }

    public void setWebViewBackgroundTransparent() {
        WebViewEngine webViewEngine = this.f17851b;
        if (webViewEngine != null) {
            webViewEngine.getWebView().setBackgroundColor(Color.argb(1, 255, 255, 255));
            this.f17851b.setNeedShowProgressBar(false);
            this.f17851b.getWebView().setHorizontalScrollBarEnabled(false);
            this.f17851b.getWebView().setVerticalScrollBarEnabled(false);
        }
    }

    /* renamed from: a */
    private void m13365a() {
        if (this.f17851b != null) {
            this.f17853d.setInterceptEnabled(false);
            this.f17851b.getWebView().setBackgroundColor(getResources().getColor(R.color.dimina_color_FFFFFF));
            this.f17851b.getWebView().setLayerType(2, (Paint) null);
        }
    }

    public void initWebView() {
        WebViewEngine createWebViewEngine = this.f17855f.getConfig().getLaunchConfig().getEngineFactory().createWebViewEngine(this.f17855f.getActivity());
        this.f17851b = createWebViewEngine;
        createWebViewEngine.getWebView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f17853d.addView(this.f17851b.getWebView());
        WebViewEngine webViewEngine = this.f17851b;
        webViewEngine.addJavascriptInterface(new DMWebViewJSInterface(webViewEngine), DMWebViewJSInterface.TAG);
        this.f17851b.setOnLoadStatusListener(new WebViewEngine.OnWebViewLoadListener() {
            public void onPageFinished(WebViewEngine webViewEngine, String str) {
                for (WebViewEngine.OnWebViewLoadListener onPageFinished : DMWebViewContainer.this.f17857h) {
                    onPageFinished.onPageFinished(webViewEngine, str);
                }
                WebViewEngine.OnWebViewLoadListener onWebViewLoadListener = DMWebViewContainer.this.f17855f.getConfig().getLaunchConfig().getOnWebViewLoadListener();
                if (onWebViewLoadListener != null) {
                    onWebViewLoadListener.onPageFinished(webViewEngine, str);
                }
            }

            public void onReceivedError(WebViewEngine webViewEngine, String str) {
                for (WebViewEngine.OnWebViewLoadListener onReceivedError : DMWebViewContainer.this.f17857h) {
                    onReceivedError.onReceivedError(webViewEngine, str);
                }
                WebViewEngine.OnWebViewLoadListener onWebViewLoadListener = DMWebViewContainer.this.f17855f.getConfig().getLaunchConfig().getOnWebViewLoadListener();
                if (onWebViewLoadListener != null) {
                    onWebViewLoadListener.onReceivedError(webViewEngine, str);
                }
            }

            public Boolean shouldOverrideUrlLoading(WebViewEngine webViewEngine, String str) {
                Boolean shouldOverrideUrlLoading;
                WebViewEngine.OnWebViewLoadListener onWebViewLoadListener = DMWebViewContainer.this.f17855f.getConfig().getLaunchConfig().getOnWebViewLoadListener();
                if (onWebViewLoadListener == null || (shouldOverrideUrlLoading = onWebViewLoadListener.shouldOverrideUrlLoading(webViewEngine, str)) == CONTINUE_OVERRIDE) {
                    return null;
                }
                return shouldOverrideUrlLoading;
            }

            public WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, String str, String str2) {
                WebResourceResponse shouldInterceptRequest;
                WebViewEngine.OnWebViewLoadListener onWebViewLoadListener = DMWebViewContainer.this.f17855f.getConfig().getLaunchConfig().getOnWebViewLoadListener();
                if (onWebViewLoadListener == null || (shouldInterceptRequest = onWebViewLoadListener.shouldInterceptRequest(webViewEngine, str, str2)) == null) {
                    return null;
                }
                return shouldInterceptRequest;
            }

            public WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, WebResourceRequest webResourceRequest, String str) {
                WebResourceResponse shouldInterceptRequest;
                WebViewEngine.OnWebViewLoadListener onWebViewLoadListener = DMWebViewContainer.this.f17855f.getConfig().getLaunchConfig().getOnWebViewLoadListener();
                if (onWebViewLoadListener == null || (shouldInterceptRequest = onWebViewLoadListener.shouldInterceptRequest(webViewEngine, webResourceRequest, str)) == null) {
                    return null;
                }
                return shouldInterceptRequest;
            }
        });
    }

    /* renamed from: b */
    private void m13367b() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_webview_container, this);
        this.f17853d = (TouchInterceptFrameLayout) findViewById(R.id.touch_intercept_fl);
        ImageView imageView = (ImageView) findViewById(R.id.debug_mark_icon);
        if (Dimina.getConfig().isDebug()) {
            imageView.setVisibility(0);
        }
    }

    public FrameLayout getBottomLayer() {
        if (this.f17852c == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.f17852c = frameLayout;
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.f17852c, 0);
        }
        return this.f17852c;
    }

    public TouchInterceptFrameLayout getTouchInterceptFrameLayout() {
        return this.f17853d;
    }

    public void release(final int i) {
        if (this.f17851b != null) {
            UIHandlerUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (DMWebViewContainer.this.f17851b != null) {
                        DMWebViewContainer.this.f17855f.getDmWebViewManager().remove(Integer.valueOf(i));
                        ViewParent parent = DMWebViewContainer.this.f17851b.getWebView().getParent();
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(DMWebViewContainer.this.f17851b.getWebView());
                        }
                        DMWebViewContainer.this.f17851b.dmDestroy();
                        WebViewEngine unused = DMWebViewContainer.this.f17851b = null;
                    }
                }
            });
        }
    }

    public WebViewEngine getWebView() {
        return this.f17851b;
    }

    public DMMinaNavigatorDelegate getNavigator() {
        return this.f17856g;
    }

    public void setMapInterceptFrameLayout(boolean z) {
        this.f17853d.setInterceptEnabled(z);
    }

    public void addWebViewLoadListener(WebViewEngine.OnWebViewLoadListener onWebViewLoadListener) {
        this.f17857h.add(onWebViewLoadListener);
    }

    public boolean removePageFinishListener(WebViewEngine.OnWebViewLoadListener onWebViewLoadListener) {
        return this.f17857h.remove(onWebViewLoadListener);
    }

    public void onPause() {
        WebViewEngine webViewEngine = this.f17851b;
        if (webViewEngine != null) {
            webViewEngine.dmPause();
        } else {
            LogUtil.iRelease(f17850a, "webview is null,pause");
        }
    }

    public void onResume() {
        WebViewEngine webViewEngine = this.f17851b;
        if (webViewEngine != null) {
            webViewEngine.dmResume();
        } else {
            LogUtil.iRelease(f17850a, "webview is null,resume");
        }
    }
}
