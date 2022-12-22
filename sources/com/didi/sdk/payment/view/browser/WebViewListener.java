package com.didi.sdk.payment.view.browser;

import android.app.Activity;
import android.content.Context;

public interface WebViewListener {
    void callAliagentAgreement(Context context, WebViewModelProxy webViewModelProxy);

    void callFusionWebView(WebViewModelProxy webViewModelProxy);

    void callPaypalWebView(WebViewModelProxy webViewModelProxy);

    void callPostWebView(Activity activity, WebViewModelProxy webViewModelProxy);

    void callSignWebActivity(WebViewModelProxy webViewModelProxy);

    void callSingIntroWebActivity(WebViewModelProxy webViewModelProxy);

    void callWebView(WebViewModelProxy webViewModelProxy);

    void callWxagentAgreement(Context context, WebViewModelProxy webViewModelProxy);

    void callZftWebActivity(WebViewModelProxy webViewModelProxy);
}
