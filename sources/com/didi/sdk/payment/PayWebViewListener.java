package com.didi.sdk.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.didi.sdk.fusionbridge.FusionUtil;
import com.didi.sdk.fusionbridge.FusionWebActivity;
import com.didi.sdk.payment.activity.CreditCardWebActivity;
import com.didi.sdk.payment.activity.PayPalActivity;
import com.didi.sdk.payment.activity.SignIntroActivity;
import com.didi.sdk.payment.activity.SignWebActivity;
import com.didi.sdk.payment.view.browser.WebViewListener;
import com.didi.sdk.payment.view.browser.WebViewModelProxy;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;

public class PayWebViewListener implements WebViewListener {
    public void callZftWebActivity(WebViewModelProxy webViewModelProxy) {
    }

    public void callWebView(WebViewModelProxy webViewModelProxy) {
        Activity activity = webViewModelProxy.getActivity();
        if (activity != null) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.title = webViewModelProxy.getTitle();
            webViewModel.isPostBaseParams = webViewModelProxy.isPostBaseParams();
            String url = webViewModelProxy.getUrl();
            webViewModel.url = url;
            if (url.contains("apph5_coupon.html")) {
                FusionUtil.openWebActivityWithApollo(activity, webViewModel, "fusion_apph5_coupon_toggle_v5");
            } else if (url.contains("apph5_travelcard.html")) {
                FusionUtil.openWebActivityWithApollo(activity, webViewModel, "fusion_apph5_travelcard_toggle_v5");
            } else if (url.contains("ticketbuyer") || url.contains("orders") || url.contains("ivan")) {
                FusionUtil.openWebActivityWithApollo(activity, webViewModel, "fusion_apph5_sidebar_toggle_v5");
            } else {
                FusionUtil.openWebActivity(activity, webViewModel);
            }
        }
    }

    public void callPaypalWebView(WebViewModelProxy webViewModelProxy) {
        if (webViewModelProxy != null) {
            Activity activity = webViewModelProxy.getActivity();
            Fragment fragment = webViewModelProxy.getFragment();
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.title = webViewModelProxy.getTitle();
            webViewModel.url = webViewModelProxy.getUrl();
            webViewModel.isPostBaseParams = false;
            webViewModel.isFromPaypal = true;
            webViewModel.canChangeWebViewTitle = webViewModelProxy.isCanChangeWebViewTitle();
            if (activity != null) {
                Intent intent = new Intent(activity, PayPalActivity.class);
                intent.putExtra("web_view_model", webViewModel);
                intent.putExtra("backUrl", webViewModelProxy.getBackUrl());
                intent.putExtra("cancelUrl", webViewModelProxy.getCancelUrl());
                if (fragment != null) {
                    fragment.startActivityForResult(intent, webViewModelProxy.getRequestCode());
                } else {
                    activity.startActivityForResult(intent, webViewModelProxy.getRequestCode());
                }
            }
        }
    }

    public void callSignWebActivity(WebViewModelProxy webViewModelProxy) {
        Activity activity = webViewModelProxy.getActivity();
        Intent intent = new Intent(activity, SignWebActivity.class);
        intent.putExtra("url", webViewModelProxy.getUrl());
        intent.putExtra("postData", webViewModelProxy.getPostData());
        activity.startActivityForResult(intent, webViewModelProxy.getRequestCode());
    }

    public void callWxagentAgreement(Context context, WebViewModelProxy webViewModelProxy) {
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.title = webViewModelProxy.getTitle();
        webViewModel.url = webViewModelProxy.getUrl();
        webViewModel.isSupportCache = webViewModelProxy.isSupportCache();
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("web_view_model", webViewModel);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void callAliagentAgreement(Context context, WebViewModelProxy webViewModelProxy) {
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.title = webViewModelProxy.getTitle();
        webViewModel.url = webViewModelProxy.getUrl();
        webViewModel.isSupportCache = webViewModelProxy.isSupportCache();
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("web_view_model", webViewModel);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void callSingIntroWebActivity(WebViewModelProxy webViewModelProxy) {
        Activity activity = webViewModelProxy.getActivity();
        Intent intent = new Intent(activity, SignIntroActivity.class);
        intent.putExtra("url", webViewModelProxy.getUrl());
        activity.startActivityForResult(intent, 1);
    }

    public void callPostWebView(Activity activity, WebViewModelProxy webViewModelProxy) {
        Activity activity2 = webViewModelProxy.getActivity();
        if (activity2 != null) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.title = webViewModelProxy.getTitle();
            webViewModel.url = webViewModelProxy.getUrl();
            Intent intent = new Intent(activity2, CreditCardWebActivity.class);
            intent.putExtra("postData", webViewModelProxy.getPostData());
            intent.putExtra("web_view_model", webViewModel);
            intent.putExtra("url", webViewModelProxy.getUrl());
            intent.putExtra("backUrl", webViewModelProxy.getBackUrl());
            activity.startActivityForResult(intent, 1);
        }
    }

    public void callFusionWebView(WebViewModelProxy webViewModelProxy) {
        Activity activity = webViewModelProxy.getActivity();
        if (activity != null) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.title = webViewModelProxy.getTitle();
            webViewModel.url = webViewModelProxy.getUrl();
            Intent intent = new Intent(activity, FusionWebActivity.class);
            intent.putExtra("web_view_model", webViewModel);
            activity.startActivity(intent);
        }
    }
}
