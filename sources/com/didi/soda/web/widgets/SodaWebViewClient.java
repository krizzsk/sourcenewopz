package com.didi.soda.web.widgets;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.didi.onehybrid.container.FusionWebViewClient;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.soda.web.overriders.IUrlOverriders;
import com.didi.soda.web.tools.LogUtil;
import com.didi.soda.web.widgets.SodaWebView;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class SodaWebViewClient extends FusionWebViewClient {

    /* renamed from: a */
    private final Activity f43950a;

    /* renamed from: b */
    private final LinkedHashSet<IUrlOverriders> f43951b = new LinkedHashSet<>();

    /* renamed from: c */
    private SodaWebView.WebPageStateListener f43952c;

    /* renamed from: d */
    private SodaWebView.WebPageErrorListener f43953d;

    public SodaWebViewClient(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f43950a = hybridableContainer.getActivity();
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        SodaWebView.WebPageErrorListener webPageErrorListener = this.f43953d;
        if (webPageErrorListener != null) {
            webPageErrorListener.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    public void addUrlOverriders(IUrlOverriders iUrlOverriders) {
        this.f43951b.add(iUrlOverriders);
    }

    public void setWebPageStateListener(SodaWebView.WebPageStateListener webPageStateListener) {
        this.f43952c = webPageStateListener;
    }

    public void setWebPageErrorListener(SodaWebView.WebPageErrorListener webPageErrorListener) {
        this.f43953d = webPageErrorListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Iterator it = this.f43951b.iterator();
        while (it.hasNext()) {
            IUrlOverriders iUrlOverriders = (IUrlOverriders) it.next();
            if (iUrlOverriders != null && iUrlOverriders.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        LogUtil.info("shouldInterceptRequest21");
        return m31268a(webResourceRequest.getUrl().toString()) ? new WebResourceResponse((String) null, (String) null, (InputStream) null) : super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        LogUtil.info("shouldInterceptRequest");
        return m31268a(str) ? new WebResourceResponse((String) null, (String) null, (InputStream) null) : super.shouldInterceptRequest(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        SodaWebView.WebPageStateListener webPageStateListener = this.f43952c;
        if (webPageStateListener != null) {
            webPageStateListener.onWebPageStarted(webView, str, bitmap);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        webView.getSettings().setBlockNetworkImage(false);
        SodaWebView.WebPageStateListener webPageStateListener = this.f43952c;
        if (webPageStateListener != null) {
            webPageStateListener.onWebPageFinished(webView, str);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        webView.stopLoading();
        SodaWebView.WebPageStateListener webPageStateListener = this.f43952c;
        if (webPageStateListener != null) {
            webPageStateListener.onWebPageReceivedError(webView, i, str, str2);
        }
    }

    /* renamed from: a */
    private boolean m31268a(String str) {
        SodaWebView.WebPageStateListener webPageStateListener;
        if (TextUtils.isEmpty(str) || (webPageStateListener = this.f43952c) == null) {
            return false;
        }
        return webPageStateListener.onInterceptedToNative(str);
    }
}
