package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import org.json.JSONObject;

public class BaseWebView extends WebView {
    /* access modifiers changed from: private */
    public FileChooserListener mFileChooserListener;
    private JavascriptBridge mJavascriptBridge;
    private ProgressDialog mProgressDialog;

    public interface FileChooserListener {
        void openFileChooser(ValueCallback valueCallback);
    }

    public static class WebViewClientEx extends WebViewClient {
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BaseWebView(Context context) {
        super(context);
        init();
    }

    public JavascriptBridge getJavascriptBridge() {
        return this.mJavascriptBridge;
    }

    public void setJavascriptBridge(JavascriptBridge javascriptBridge) {
        this.mJavascriptBridge = javascriptBridge;
    }

    public void showLoadingDialog(String str) {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new ProgressDialog(getContext(), 3);
        }
        this.mProgressDialog.setCancelable(true);
        this.mProgressDialog.setCanceledOnTouchOutside(false);
        try {
            SystemUtils.showDialog(this.mProgressDialog);
        } catch (Exception unused) {
        }
    }

    public void removeLoadingDialog() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            try {
                if (progressDialog.isShowing()) {
                    this.mProgressDialog.dismiss();
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.mProgressDialog = null;
                throw th;
            }
            this.mProgressDialog = null;
        }
    }

    private void init() {
        initWebSettings();
        super.setWebChromeClient(new WebChromeClientEx("DidiJSBridge", JsFunctionHandler.class) {
            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                if (BaseWebView.this.mFileChooserListener != null) {
                    BaseWebView.this.mFileChooserListener.openFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback valueCallback, String str) {
                if (BaseWebView.this.mFileChooserListener != null) {
                    BaseWebView.this.mFileChooserListener.openFileChooser(valueCallback);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (BaseWebView.this.mFileChooserListener != null) {
                    BaseWebView.this.mFileChooserListener.openFileChooser(valueCallback);
                }
            }

            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (BaseWebView.this.mFileChooserListener == null) {
                    return false;
                }
                BaseWebView.this.mFileChooserListener.openFileChooser(valueCallback);
                return true;
            }
        });
        super.setWebViewClient(new WebViewClientEx());
    }

    private void initWebSettings() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        try {
            if (Build.VERSION.SDK_INT < 19) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Exception unused) {
        }
        settings.setDefaultTextEncodingName("UTF-8");
        addProgressView();
    }

    private void addProgressView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.afanty_v_webview_prograss, (ViewGroup) null);
        inflate.setVisibility(8);
        addView(inflate, -1, -1);
    }

    public void setWebViewSetting(WebViewModel webViewModel) {
        WebSettings settings = getSettings();
        if (webViewModel != null && settings != null) {
            settings.setCacheMode(2);
        }
    }

    public void setFileChooserListener(FileChooserListener fileChooserListener) {
        this.mFileChooserListener = fileChooserListener;
    }

    public static class WebChromeClientEx extends InjectedChromeClient {
        public WebChromeClientEx(String str, Class cls) {
            super(str, cls);
        }

        public final void onProgressChanged(WebView webView, int i) {
            if (i <= 25) {
                this.mIsInjectedJS = false;
            } else if (!this.mIsInjectedJS) {
                webView.loadUrl(this.mJsCallJava.getPreloadInterfaceJS());
                this.mIsInjectedJS = true;
            }
            super.onProgressChanged(webView, i);
        }

        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!JavascriptBridge.matchBridgeProtocol(jSONObject)) {
                    return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                }
                jsPromptResult.confirm("prompt ok");
                JavascriptBridge.onGetDataFromJs(webView, jSONObject);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                jsPromptResult.confirm("");
                return true;
            }
        }
    }
}
