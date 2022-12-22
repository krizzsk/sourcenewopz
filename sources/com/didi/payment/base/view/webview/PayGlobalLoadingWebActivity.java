package com.didi.payment.base.view.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.global.loading.app.LoadingDelegate;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.sdk.apm.SystemUtils;

public class PayGlobalLoadingWebActivity extends PayBaseWebActivity implements ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private LoadingDelegate f30041a;

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.mWebView.setNeedShowProgressBar(false);
        setWebViewClient(new PayBaseWebActivity.IPayWebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                PayGlobalLoadingWebActivity.this.showLoading();
            }

            public void onPageFinished(WebView webView, String str) {
                PayGlobalLoadingWebActivity.this.hideLoading();
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                PayGlobalLoadingWebActivity.this.hideLoading();
            }
        });
        this.f30041a = new LoadingDelegate(this, this);
    }

    public View getFallbackView() {
        return this.mWebTitleBar;
    }

    public LoadingConfig getLoadingConfig() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setRenderType(LoadingRenderType.ANIMATION);
        return loadingConfig;
    }

    public void showLoading() {
        this.f30041a.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f30041a.showLoading(loadingConfig);
    }

    public void hideLoading() {
        this.f30041a.hideLoading();
    }

    public boolean isLoading() {
        return this.f30041a.isLoading();
    }
}
