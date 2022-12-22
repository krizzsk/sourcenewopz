package com.didi.soda.web.widgets;

import android.net.Uri;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.didi.onehybrid.container.FusionWebChromeClient;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.soda.web.widgets.SodaWebView;

public class SodaWebChromeClient extends FusionWebChromeClient {

    /* renamed from: a */
    private SodaWebView.FileChooserListener f43943a;

    /* renamed from: b */
    private SodaWebView.WebPageErrorListener f43944b;

    public SodaWebChromeClient(FusionWebView fusionWebView) {
        super(fusionWebView);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if ((webView instanceof SodaWebView) && webView.getResources().getConfiguration().orientation != 2) {
            ((SodaWebView) webView).alert(str2);
        }
        jsResult.confirm();
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
    }

    public void setFileChooserListener(SodaWebView.FileChooserListener fileChooserListener) {
        this.f43943a = fileChooserListener;
    }

    public void setWebPageErrorListener(SodaWebView.WebPageErrorListener webPageErrorListener) {
        this.f43944b = webPageErrorListener;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        SodaWebView.FileChooserListener fileChooserListener = this.f43943a;
        if (fileChooserListener != null) {
            fileChooserListener.openFileChooser(valueCallback);
        }
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        SodaWebView.FileChooserListener fileChooserListener = this.f43943a;
        if (fileChooserListener != null) {
            fileChooserListener.openFileChooser(valueCallback);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        SodaWebView.FileChooserListener fileChooserListener = this.f43943a;
        if (fileChooserListener != null) {
            fileChooserListener.openFileChooser(valueCallback);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        SodaWebView.WebPageErrorListener webPageErrorListener = this.f43944b;
        if (webPageErrorListener != null) {
            webPageErrorListener.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        SodaWebView.FileChooserListener fileChooserListener = this.f43943a;
        if (fileChooserListener == null) {
            return true;
        }
        fileChooserListener.onShowFileChooser(valueCallback, fileChooserParams);
        return true;
    }
}
