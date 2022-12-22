package com.didi.sdk.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.global.loading.app.LoadingDelegate;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fusionbridge.FusionWebActivity;
import com.didi.sdk.log.Logger;
import com.didi.sdk.webview.BaseWebActivity;

public abstract class AbsLoadingWebActivity extends FusionWebActivity implements ILoadingHolder, ILoadingable {

    /* renamed from: a */
    private LoadingDelegate f38358a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (this.mWebView != null) {
            this.mWebView.setNeedShowProgressBar(false);
        }
        reSetWebViewClient(new BaseWebActivity.DiDiWebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AbsLoadingWebActivity.this.showLoading();
            }

            public void onPageFinished(WebView webView, String str) {
                AbsLoadingWebActivity.this.hideLoading();
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                AbsLoadingWebActivity.this.hideLoading();
            }
        });
        this.f38358a = new LoadingDelegate(this, this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    public View getFallbackView() {
        return this.mWebTitleBar;
    }

    public LoadingConfig getLoadingConfig() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setRenderType(LoadingRenderType.ANIMATION);
        return loadingConfig;
    }

    public void showMaskLayerLoading() {
        LoadingDelegate loadingDelegate = this.f38358a;
        if (loadingDelegate != null) {
            loadingDelegate.showMaskLayerLoading();
        }
    }

    public void showLoading() {
        LoadingDelegate loadingDelegate = this.f38358a;
        if (loadingDelegate != null) {
            loadingDelegate.showLoading();
        }
    }

    public void showLoading(LoadingConfig loadingConfig) {
        LoadingDelegate loadingDelegate = this.f38358a;
        if (loadingDelegate != null) {
            loadingDelegate.showLoading(loadingConfig);
        }
    }

    public void hideLoading() {
        LoadingDelegate loadingDelegate = this.f38358a;
        if (loadingDelegate != null) {
            loadingDelegate.hideLoading();
        }
    }

    public boolean isLoading() {
        LoadingDelegate loadingDelegate = this.f38358a;
        if (loadingDelegate != null) {
            return loadingDelegate.isLoading();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean workaroundException(Exception exc) {
        if (exc != null) {
            boolean isEmpty = TextUtils.isEmpty(exc.getMessage());
            Throwable th = exc;
            if (!isEmpty) {
                while (th.getCause() != null) {
                    th = th.getCause();
                }
                String message = th.getMessage();
                Logger.m25809e("#####workaround: " + message, new Object[0]);
                if ((TextUtils.isEmpty(message) || (!message.contains("Unsupported ABI") && !message.contains("MissingWebViewPackageException") && !message.contains("No WebView installed"))) && !message.contains("com.google.android.webview")) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
