package com.didi.soda.home.component.web;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import com.didi.soda.customer.p165h5.WebHelper;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridWebChromeClient;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridWebViewClient;
import com.didi.soda.customer.p165h5.hybird.WebChromeClientCallback;
import com.didi.soda.customer.p165h5.hybird.WebViewClientCallback;
import com.didi.soda.home.component.web.Contract;
import com.didi.soda.web.widgets.SodaWebView;
import com.taxis99.R;

public class WebHomeView extends Contract.AbsWebRecView implements WebChromeClientCallback, WebViewClientCallback {

    /* renamed from: a */
    private SodaWebView f42625a;
    @BindView(24722)
    FrameLayout mWebLayout;

    public void onConsoleMessage(ConsoleMessage consoleMessage) {
    }

    public void onPageFinished(WebView webView, String str) {
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    public void onProgressChanged(WebView webView, int i) {
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    public void onReceivedTitle(WebView webView, String str) {
    }

    public void shouldInterceptRequest(WebView webView, String str) {
    }

    public void loadUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            String addH5CommonParams = ParamsHelper.addH5CommonParams(str);
            SodaWebView sodaWebView = this.f42625a;
            if (sodaWebView != null) {
                sodaWebView.loadUrl(addH5CommonParams);
            }
        }
    }

    public void setPaddingBottom(int i) {
        this.mWebLayout.setPadding(0, 0, 0, i);
    }

    public void setWebVisible(boolean z) {
        if (z) {
            m30106b();
        } else {
            m30107c();
        }
        this.mWebLayout.setVisibility(z ? 0 : 8);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.component_web_home_layout, viewGroup, true);
    }

    /* renamed from: a */
    private void m30105a() {
        if (this.f42625a != null) {
            CustomerHybridWebViewClient customerHybridWebViewClient = new CustomerHybridWebViewClient(this.f42625a, this);
            WebHelper.attachOmegaJS(this.f42625a, customerHybridWebViewClient);
            this.f42625a.setWebViewClient(customerHybridWebViewClient);
            this.f42625a.setWebChromeClient(new CustomerHybridWebChromeClient(this.f42625a, this));
        }
    }

    /* renamed from: b */
    private void m30106b() {
        if (this.f42625a == null) {
            try {
                SodaWebView sodaWebView = new SodaWebView(getContext());
                this.f42625a = sodaWebView;
                this.mWebLayout.addView(sodaWebView);
            } catch (Exception unused) {
                return;
            }
        }
        m30105a();
    }

    /* renamed from: c */
    private void m30107c() {
        SodaWebView sodaWebView = this.f42625a;
        if (sodaWebView != null) {
            this.mWebLayout.removeView(sodaWebView);
            this.f42625a.clearHistory();
            this.f42625a.clearCache(true);
            this.f42625a.loadUrl("about:blank");
            this.f42625a.freeMemory();
            this.f42625a = null;
        }
    }
}
