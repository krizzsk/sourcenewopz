package com.didichuxing.omega.sdk.feedback.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.feedback.webview.TitleBar;
import com.taxis99.R;

public class FeedbackDetailWebActivity extends Activity {
    /* access modifiers changed from: private */
    public String jsonStr;
    /* access modifiers changed from: private */
    public WebView myWebView = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        SystemUtils.hookSetRequestedOrientation(this, 1);
        setContentView(R.layout.fdwa_web_activity);
        this.jsonStr = getIntent().getStringExtra("feedback");
        this.myWebView = (WebView) findViewById(R.id.fdwa_myWebView);
        TitleBar titleBar = (TitleBar) findViewById(R.id.fdwa_titlebar);
        titleBar.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                FeedbackDetailWebActivity.this.finish();
            }
        });
        titleBar.setTitle(getString(R.string.afanty_myfeedback_bug_detail));
        WebSettings settings = this.myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        this.myWebView.setWebViewClient(new WebViewClient());
        this.myWebView.setWebChromeClient(new WebChromeClient() {
        });
        this.myWebView.addJavascriptInterface(new WebInterface(), "FeedbackDetailJs");
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 19) {
            this.myWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.myWebView.removeJavascriptInterface("accessibility");
            this.myWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        this.myWebView.loadUrl("file:///android_asset/my_feedback_detail.html");
    }

    private class WebInterface {
        private WebInterface() {
        }

        @JavascriptInterface
        public void setAllData() {
            if (FeedbackDetailWebActivity.this.myWebView != null) {
                FeedbackDetailWebActivity.this.myWebView.post(new Runnable() {
                    public void run() {
                        FeedbackDetailWebActivity.this.myWebView.loadUrl("javascript:fdwa_setAllData('" + FeedbackDetailWebActivity.this.jsonStr + "')");
                    }
                });
            }
        }
    }
}
