package com.didi.sdk.payment.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import com.didi.sdk.log.Logger;
import com.didi.sdk.webview.BaseWebView;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebTitleBar;
import com.taxis99.R;
import java.lang.ref.WeakReference;

public class SignWebActivity extends WebActivity {
    public static final String BIND_FAIL = "0";
    public static final String BIND_SUCCESS = "1";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebTitleBar f36906a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BaseWebView f36907b;

    /* renamed from: c */
    private String f36908c;

    /* renamed from: d */
    private String f36909d;

    /* renamed from: e */
    private String f36910e;

    /* renamed from: f */
    private FusionBridgeModule f36911f;

    /* renamed from: g */
    private Handler f36912g;

    /* renamed from: h */
    private View.OnClickListener f36913h = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SignWebActivity.this.finish();
        }
    };

    /* renamed from: i */
    private View.OnClickListener f36914i = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            SignWebActivity.this.finish();
        }
    };

    public interface H5Callback {
        void onResult(String str);
    }

    /* renamed from: d */
    private void m26158d() {
    }

    static class MyHandler extends Handler {
        WeakReference<BaseWebView> mWebViewReference;

        MyHandler(BaseWebView baseWebView) {
            this.mWebViewReference = new WeakReference<>(baseWebView);
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                Bundle data = message.getData();
                ((BaseWebView) this.mWebViewReference.get()).loadDataWithBaseURL(data.getString("url"), data.getString("result"), "text/html", "UTF-8", (String) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.a_sign_web);
        this.f36906a = (WebTitleBar) findViewById(R.id.web_title_bar);
        this.f36907b = (BaseWebView) findViewById(R.id.web_view);
        this.f36912g = new MyHandler(this.f36907b);
        this.f36908c = getIntent().getStringExtra("title");
        this.f36909d = getIntent().getStringExtra("postData");
        this.f36910e = getIntent().getStringExtra("url");
        m26155b();
        m26157c();
    }

    /* renamed from: b */
    private void m26155b() {
        if (!TextUtils.isEmpty(this.f36908c)) {
            this.f36906a.setTitleName(this.f36908c);
        }
        this.f36906a.setCloseBtnVisibility(8);
        this.f36906a.setMoreBtnVisibility(8);
        this.f36906a.setOnBackClickListener(this.f36913h);
        this.f36906a.setOnCloseClickListener(this.f36914i);
    }

    /* renamed from: c */
    private void m26157c() {
        WebSettings settings = this.f36907b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setSupportZoom(false);
        new H5Callback() {
            public void onResult(String str) {
                if ("0".equals(str)) {
                    SignWebActivity.this.setResult(1);
                } else if ("1".equals(str)) {
                    SignWebActivity.this.setResult(2);
                }
            }
        };
        this.f36911f = this.f36907b.getFusionBridge();
        this.f36907b.setWebViewClient(new BaseWebView.WebViewClientEx(this.f36907b) {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (SignWebActivity.this.f36907b.canGoBack()) {
                    SignWebActivity.this.f36906a.setCloseBtnVisibility(0);
                } else {
                    SignWebActivity.this.f36906a.setCloseBtnVisibility(8);
                }
                String title = webView.getTitle();
                if (SignWebActivity.this.mFusionWebModel.canChangeWebViewTitle) {
                    if (title == null || TextUtils.equals(title, "about:blank")) {
                        title = "";
                    } else if (webView.getUrl() != null) {
                        Uri parse = Uri.parse(webView.getUrl());
                        if (parse.getHost() != null && title.contains(parse.getHost())) {
                            title = SignWebActivity.this.getString(R.string.app_name);
                        }
                    }
                    SignWebActivity.this.f36906a.setTitleName(title);
                }
                SignWebActivity.this.cancelProgressDialog();
                SignWebActivity.this.f36907b.requestFocus();
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                Logger.m25809e("shouldOverrideUrlLoading", new Object[0]);
                return false;
            }
        });
        try {
            CookieSyncManager.createInstance(getApplicationContext());
            CookieManager.getInstance().removeAllCookie();
            CookieSyncManager.getInstance().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
        m26158d();
    }

    /* renamed from: a */
    private void m26153a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", this.f36910e);
        bundle.putString("result", str);
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.setData(bundle);
        this.f36912g.sendMessage(obtain);
    }

    public boolean goBack(boolean z) {
        boolean z2;
        String str;
        WebBackForwardList copyBackForwardList = this.f36907b.copyBackForwardList();
        String url = this.f36907b.getUrl();
        int i = -1;
        while (true) {
            if (!this.f36907b.canGoBackOrForward(i)) {
                z2 = false;
                break;
            }
            WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
            if (itemAtIndex == null) {
                str = null;
            } else {
                str = itemAtIndex.getUrl();
            }
            if (str != null && !TextUtils.equals(str, url) && !TextUtils.equals(str, "about:blank")) {
                this.f36907b.goBackOrForward(i);
                z2 = true;
                break;
            }
            i--;
        }
        if (!z2 && z) {
            finishWithResultCodeOK();
        }
        return z2;
    }

    public void finishWithResultCodeOK() {
        setResult(-1);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        finish();
        return false;
    }
}
