package com.didi.sdk.webview;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onehybrid.container.FusionWebChromeClient;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.FusionWebViewClient;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.omega.sdk.analysis.OmegaWebViewClient;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.taxis99.R;

public class BaseWebView extends FusionWebView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AlertDialogFragment f38376a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FileChooserListener f38377b;

    public interface FileChooserListener {
        void openFileChooser(ValueCallback<Uri> valueCallback);

        void openFileChooserAboveL(ValueCallback<Uri[]> valueCallback);
    }

    public void showLoadingDialog(String str) {
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27128a(context);
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27128a(context);
    }

    public BaseWebView(Context context) {
        super(context);
        m27128a(context);
    }

    public FusionBridgeModule getFusionBridge() {
        return (FusionBridgeModule) getExportModuleInstance(FusionBridgeModule.class);
    }

    /* renamed from: a */
    private void m27128a(Context context) {
        setWebViewClient(new WebViewClientEx(this));
        setWebChromeClient(new WebChromeClientEx(this));
        OmegaSDK.addJsOmegaSDK(this);
    }

    public void setWebViewSetting(WebViewModel webViewModel) {
        WebSettings settings = getSettings();
        if (webViewModel != null && settings != null) {
            if (webViewModel.isSupportCache) {
                settings.setCacheMode(-1);
            } else {
                settings.setCacheMode(2);
            }
        }
    }

    public void setFileChooserListener(FileChooserListener fileChooserListener) {
        this.f38377b = fileChooserListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27130a(String str) {
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(getContext());
            builder.setMessage(str).setPositiveButton((int) R.string.me_known, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    BaseWebView.this.f38376a.dismiss();
                }
            });
            AlertDialogFragment create = builder.create();
            this.f38376a = create;
            try {
                create.show(supportFragmentManager, (String) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class WebChromeClientEx extends FusionWebChromeClient {
        public WebChromeClientEx(FusionWebView fusionWebView) {
            super(fusionWebView);
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if ((webView instanceof BaseWebView) && BaseWebView.this.getResources().getConfiguration().orientation != 2) {
                ((BaseWebView) webView).m27130a(str2);
            }
            jsResult.confirm();
            return true;
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (BaseWebView.this.f38377b == null) {
                return true;
            }
            BaseWebView.this.f38377b.openFileChooserAboveL(valueCallback);
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            if (BaseWebView.this.f38377b != null) {
                BaseWebView.this.f38377b.openFileChooser(valueCallback);
            }
        }

        public void openFileChooser(ValueCallback valueCallback, String str) {
            if (BaseWebView.this.f38377b != null) {
                BaseWebView.this.f38377b.openFileChooser(valueCallback);
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (BaseWebView.this.f38377b != null) {
                BaseWebView.this.f38377b.openFileChooser(valueCallback);
            }
        }
    }

    public static class WebViewClientEx extends FusionWebViewClient {
        public WebViewClientEx(HybridableContainer hybridableContainer) {
            super(hybridableContainer);
            setWebviewClient(new OmegaWebViewClient());
        }

        public void onLoadResource(WebView webView, String str) {
            if (StrategyManager.getInstance().isUrlInWhiteList(str)) {
                str = StrategyManager.getInstance().appendToken(str);
            }
            super.onLoadResource(webView, str);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            webView.getSettings().setBlockNetworkImage(false);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            System.currentTimeMillis();
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }
}
