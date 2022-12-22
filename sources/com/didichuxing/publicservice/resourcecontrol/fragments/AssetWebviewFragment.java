package com.didichuxing.publicservice.resourcecontrol.fragments;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.taxis99.R;
import p242io.opentracing.tag.Tags;

public class AssetWebviewFragment extends AssetBasicFragment implements View.OnClickListener {
    private static final String TAG = AssetWebviewFragment.class.getSimpleName();
    /* access modifiers changed from: private */
    public RelativeLayout assetNetworkError;
    private Bundle bundle;
    /* access modifiers changed from: private */
    public LinearLayout loading;
    /* access modifiers changed from: private */
    public WebView mWebView;
    private String token;
    private String url = "";

    public static AssetWebviewFragment newInstance(Bundle bundle2) {
        AssetWebviewFragment assetWebviewFragment = new AssetWebviewFragment();
        assetWebviewFragment.setArguments(bundle2);
        return assetWebviewFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle2) {
        View inflate = layoutInflater.inflate(R.layout.asset_frag_webview_layout, viewGroup, false);
        this.assetNetworkError = (RelativeLayout) inflate.findViewById(R.id.aseet_network_error);
        this.loading = (LinearLayout) inflate.findViewById(R.id.loading);
        ((ImageView) inflate.findViewById(R.id.asset_title_bar_btn_left)).setOnClickListener(this);
        this.assetNetworkError.setOnClickListener(this);
        Bundle arguments = getArguments();
        this.bundle = arguments;
        if (arguments == null || !arguments.containsKey(ConstantUtils.EXTRA_WEBVIEW_URL)) {
            AppUtils.log(" " + TAG + "showLinkUrl -> fail : ");
        } else {
            this.url = this.bundle.getString(ConstantUtils.EXTRA_WEBVIEW_URL);
            AppUtils.log(" " + TAG + "showLinkUrl -> onSuccess : redirectUrl = " + this.url);
        }
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.getUserAgentString();
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        this.mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AppUtils.log("onPageStarted");
            }

            public void onPageFinished(WebView webView, String str) {
                AppUtils.log("onPageFinished");
                AssetWebviewFragment.this.loading.setVisibility(8);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                AppUtils.log("onReceivedError");
                AssetWebviewFragment.this.loading.setVisibility(8);
                AssetWebviewFragment.this.mWebView.setVisibility(8);
                AssetWebviewFragment.this.assetNetworkError.setVisibility(0);
            }
        });
        this.mWebView.setWebChromeClient(new WebChromeClient() {
        });
        try {
            if (Build.VERSION.SDK_INT <= 19) {
                this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
                this.mWebView.removeJavascriptInterface("accessibility");
                this.mWebView.removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mWebView.addJavascriptInterface(new JavaScriptCallback(), Tags.SPAN_KIND_CLIENT);
        if (!AppUtils.networkStatusOK(getActivity())) {
            this.loading.setVisibility(8);
            this.mWebView.setVisibility(8);
            this.assetNetworkError.setVisibility(0);
            return inflate;
        }
        this.loading.setVisibility(0);
        this.mWebView.setVisibility(0);
        this.assetNetworkError.setVisibility(8);
        if (ResourceManager.getManager().getRcRequestParams() != null) {
            this.token = ResourceManager.getManager().getRcRequestParams().token;
        }
        if (!TextUtils.isEmpty(this.token)) {
            this.url += "?token=" + this.token;
        }
        this.mWebView.loadUrl(this.url);
        return inflate;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.asset_title_bar_btn_left) {
            getFragmentManager().popBackStack();
        } else if (view.getId() != R.id.aseet_network_error) {
        } else {
            if (!AppUtils.networkStatusOK(getActivity())) {
                this.mWebView.setVisibility(8);
                this.assetNetworkError.setVisibility(0);
                return;
            }
            this.loading.setVisibility(0);
            this.mWebView.setVisibility(0);
            this.assetNetworkError.setVisibility(8);
            this.mWebView.loadUrl(this.url);
        }
    }

    class JavaScriptCallback {
        JavaScriptCallback() {
        }

        @JavascriptInterface
        public void backMethod(String str, int i, float f) {
            SystemUtils.log(2, "test", str + "   " + i + "   " + f, (Throwable) null, "com.didichuxing.publicservice.resourcecontrol.fragments.AssetWebviewFragment$JavaScriptCallback", 147);
        }
    }
}
