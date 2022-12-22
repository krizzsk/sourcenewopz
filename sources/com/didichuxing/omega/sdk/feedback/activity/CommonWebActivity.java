package com.didichuxing.omega.sdk.feedback.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import com.didichuxing.omega.sdk.feedback.webview.TitleBar;
import com.taxis99.R;

public class CommonWebActivity extends FragmentActivity {
    private WebView myWebView = null;
    private Uri uri;

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        SystemUtils.hookSetRequestedOrientation(this, 1);
        setContentView((int) R.layout.activity_web_js);
        Intent intent = getIntent();
        this.myWebView = (WebView) findViewById(R.id.awj_myWebView);
        TitleBar titleBar = (TitleBar) findViewById(R.id.awj_titlebar);
        titleBar.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                CommonWebActivity.this.finish();
            }
        });
        WebSettings settings = this.myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        this.myWebView.setWebViewClient(new WebViewClient());
        this.myWebView.setWebChromeClient(new WebChromeClient() {
        });
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 19) {
            this.myWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.myWebView.removeJavascriptInterface("accessibility");
            this.myWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        Bundle extras = intent.getExtras();
        String userToken = SwarmUtil.getUserToken();
        WebView webView = this.myWebView;
        webView.loadUrl(((String) extras.get("url")) + "?ts=" + System.currentTimeMillis() + "&ticket=" + userToken);
        titleBar.setTitle((String) extras.get("title"));
    }
}
