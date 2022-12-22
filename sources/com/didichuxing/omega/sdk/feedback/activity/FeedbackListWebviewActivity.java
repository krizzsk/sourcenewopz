package com.didichuxing.omega.sdk.feedback.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.afanty.common.utils.OLog;
import com.didichuxing.omega.sdk.feedback.webview.TitleBar;
import com.taxis99.R;
import org.json.JSONArray;
import org.json.JSONObject;

public class FeedbackListWebviewActivity extends Activity {
    /* access modifiers changed from: private */
    public String myFeedbackListjsonStr;
    /* access modifiers changed from: private */
    public WebView myWebView = null;
    /* access modifiers changed from: private */
    public String personStr;

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        requestWindowFeature(1);
        SystemUtils.hookSetRequestedOrientation(this, 1);
        setContentView(R.layout.flwa_web_activity);
        Intent intent = getIntent();
        this.personStr = intent.getStringExtra("personinfo");
        this.myFeedbackListjsonStr = intent.getStringExtra("listdata");
        this.myWebView = (WebView) findViewById(R.id.flwa_myWebView);
        TitleBar titleBar = (TitleBar) findViewById(R.id.flwa_titlebar);
        titleBar.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                FeedbackListWebviewActivity.this.finish();
            }
        });
        titleBar.setTitle(getString(R.string.afanty_myfeedback_my_feedback));
        WebSettings settings = this.myWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        this.myWebView.setWebViewClient(new WebViewClient());
        this.myWebView.setWebChromeClient(new WebChromeClient() {
        });
        this.myWebView.addJavascriptInterface(new WebInterface(), "FeedbackListJs");
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 19) {
            this.myWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.myWebView.removeJavascriptInterface("accessibility");
            this.myWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        this.myWebView.loadUrl("file:///android_asset/my_feedback.html");
    }

    private class WebInterface {
        private WebInterface() {
        }

        @JavascriptInterface
        public void getPersonInfoStr() {
            if (FeedbackListWebviewActivity.this.myWebView != null && FeedbackListWebviewActivity.this.personStr != null) {
                FeedbackListWebviewActivity.this.myWebView.post(new Runnable() {
                    public void run() {
                        FeedbackListWebviewActivity.this.myWebView.loadUrl("javascript:flwa_setTotalData('" + FeedbackListWebviewActivity.this.personStr + "')");
                    }
                });
            }
        }

        @JavascriptInterface
        public void getMyfeedbackListStr() {
            if (FeedbackListWebviewActivity.this.myWebView != null) {
                FeedbackListWebviewActivity.this.myWebView.post(new Runnable() {
                    public void run() {
                        OLog.m32669i("myFeedbackListjsonStr is:" + FeedbackListWebviewActivity.this.myFeedbackListjsonStr);
                        FeedbackListWebviewActivity.this.myWebView.loadUrl("javascript:flwa_setListData('" + FeedbackListWebviewActivity.this.myFeedbackListjsonStr + "')");
                    }
                });
            }
        }

        @JavascriptInterface
        public void showDetail(String str) {
            JSONObject jSONObject = null;
            try {
                JSONArray jSONArray = new JSONArray(FeedbackListWebviewActivity.this.myFeedbackListjsonStr);
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    if (str.equals(jSONObject2.getString("msgid"))) {
                        jSONObject = jSONObject2;
                        break;
                    }
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jSONObject != null) {
                Intent intent = new Intent(FeedbackListWebviewActivity.this, FeedbackDetailWebActivity.class);
                intent.putExtra("feedback", jSONObject.toString());
                FeedbackListWebviewActivity.this.startActivity(intent);
            }
        }
    }
}
