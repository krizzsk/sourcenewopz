package com.didi.soda.customer.p165h5.hybird;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.net.MailTo;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.p165h5.CustomerH5UrlConst;
import com.didi.soda.web.widgets.SodaWebViewClient;
import java.net.URLDecoder;

/* renamed from: com.didi.soda.customer.h5.hybird.CustomerHybridWebViewClient */
public class CustomerHybridWebViewClient extends SodaWebViewClient {

    /* renamed from: a */
    private static final String f41318a = "SodaHybridWebViewClient";

    /* renamed from: b */
    private WebViewClientCallback f41319b;

    /* renamed from: c */
    private Activity f41320c;

    public CustomerHybridWebViewClient(HybridableContainer hybridableContainer, WebViewClientCallback webViewClientCallback) {
        super(hybridableContainer);
        this.f41319b = webViewClientCallback;
        this.f41320c = hybridableContainer.getActivity();
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        WebViewClientCallback webViewClientCallback = this.f41319b;
        if (webViewClientCallback != null) {
            webViewClientCallback.onPageFinished(webView, str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        WebViewClientCallback webViewClientCallback = this.f41319b;
        if (webViewClientCallback != null) {
            webViewClientCallback.onPageStarted(webView, str, bitmap);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        WebViewClientCallback webViewClientCallback = this.f41319b;
        if (webViewClientCallback != null) {
            webViewClientCallback.onReceivedError(webView, i, str, str2);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebViewClientCallback webViewClientCallback = this.f41319b;
        if (webViewClientCallback != null) {
            webViewClientCallback.shouldInterceptRequest(webView, str);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        WebViewClientCallback webViewClientCallback = this.f41319b;
        if (webViewClientCallback != null) {
            webViewClientCallback.shouldInterceptRequest(webView, uri);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        if (str.startsWith("tel:")) {
            CustomerSystemUtil.doCall(webView.getContext(), str);
            return true;
        } else if (str.startsWith(MailTo.MAILTO_SCHEME)) {
            try {
                Intent intent = new Intent("android.intent.action.SENDTO");
                if (str.contains("?body=")) {
                    intent.setData(Uri.parse(str.substring(0, str.indexOf(63))));
                    intent.putExtra("android.intent.extra.TEXT", URLDecoder.decode(str.substring(str.indexOf("?body=") + 6).replaceAll("%(?![0-9a-fA-F]{2})", "%25")));
                } else {
                    intent.setData(Uri.parse(str));
                }
                webView.getContext().startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                return true;
            }
        } else if (SchemeHelper.isSodaSchemeUri(parse)) {
            RecordTracker.Builder.create().setTag(f41318a).setMessage("shouldOverrideUrlLoading").setOtherParam("Url", str).setLogCategory("c-act|").build().info();
            SchemeHelper.dispatchMsg(parse, "webPage", "", false);
            return true;
        } else if (!CustomerH5UrlConst.isPassengerServiceUrl(str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            webView.loadUrl(CustomerH5UrlConst.getHelperServiceUrl(str));
            return true;
        }
    }
}
