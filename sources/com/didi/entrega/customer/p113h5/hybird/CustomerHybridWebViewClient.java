package com.didi.entrega.customer.p113h5.hybird;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.net.MailTo;
import com.didi.entrega.customer.biz.scheme.RouteValidation;
import com.didi.entrega.customer.biz.scheme.SchemeHelper;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.soda.web.widgets.SodaWebViewClient;
import java.net.URLDecoder;

/* renamed from: com.didi.entrega.customer.h5.hybird.CustomerHybridWebViewClient */
public class CustomerHybridWebViewClient extends SodaWebViewClient {

    /* renamed from: a */
    private static final String f20177a = "SodaHybridWebViewClient";

    /* renamed from: b */
    private WebViewClientCallback f20178b;

    /* renamed from: c */
    private Activity f20179c;

    public CustomerHybridWebViewClient(HybridableContainer hybridableContainer, WebViewClientCallback webViewClientCallback) {
        super(hybridableContainer);
        this.f20178b = webViewClientCallback;
        this.f20179c = hybridableContainer.getActivity();
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        WebViewClientCallback webViewClientCallback = this.f20178b;
        if (webViewClientCallback != null) {
            webViewClientCallback.onPageFinished(webView, str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        WebViewClientCallback webViewClientCallback = this.f20178b;
        if (webViewClientCallback != null) {
            webViewClientCallback.onPageStarted(webView, str, bitmap);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        WebViewClientCallback webViewClientCallback = this.f20178b;
        if (webViewClientCallback != null) {
            webViewClientCallback.onReceivedError(webView, i, str, str2);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebViewClientCallback webViewClientCallback = this.f20178b;
        if (webViewClientCallback != null) {
            webViewClientCallback.shouldInterceptRequest(webView, str);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        WebViewClientCallback webViewClientCallback = this.f20178b;
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
        } else if (!RouteValidation.isEntregaSchemeUri(parse)) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            RecordTracker.Builder.create().setTag(f20177a).setMessage("shouldOverrideUrlLoading").setOtherParam("Url", str).setLogCategory("c-act|").build().info();
            SchemeHelper.dispatchMsg(parse, "webPage", "", false);
            return true;
        }
    }
}
