package com.didi.sdk.payment.activity;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.pay.sign.util.SignConstant;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.webview.BaseWebView;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebTitleBar;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.taxis99.R;
import didihttp.DidiHttpClient;
import didihttp.MediaType;
import didihttp.Request;
import didihttp.RequestBody;
import didihttp.Response;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;

public class CreditCardWebActivity extends WebActivity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebTitleBar f36894a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BaseWebView f36895b;

    /* renamed from: c */
    private String f36896c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f36897d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f36898e;

    /* renamed from: f */
    private Handler f36899f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f36900g;

    /* renamed from: h */
    private View.OnClickListener f36901h = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CreditCardWebActivity.this.finish();
        }
    };

    /* renamed from: i */
    private View.OnClickListener f36902i = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            CreditCardWebActivity.this.finish();
        }
    };

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
        this.f36894a = (WebTitleBar) findViewById(R.id.web_title_bar);
        this.f36895b = (BaseWebView) findViewById(R.id.web_view);
        this.f36899f = new MyHandler(this.f36895b);
        this.f36896c = getIntent().getStringExtra("title");
        this.f36897d = getIntent().getStringExtra("postData");
        this.f36898e = getIntent().getStringExtra("url");
        this.f36900g = getIntent().getStringExtra("backUrl");
        m26137b();
        m26139c();
    }

    /* renamed from: b */
    private void m26137b() {
        if (!TextUtils.isEmpty(this.f36896c)) {
            this.f36894a.setTitleName(this.f36896c);
        }
        this.f36894a.setCloseBtnVisibility(8);
        this.f36894a.setMoreBtnVisibility(8);
        this.f36894a.setOnBackClickListener(this.f36901h);
        this.f36894a.setOnCloseClickListener(this.f36902i);
    }

    /* renamed from: c */
    private void m26139c() {
        WebSettings settings = this.f36895b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setSupportZoom(false);
        this.f36895b.setWebViewClient(new BaseWebView.WebViewClientEx(this.f36895b) {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (CreditCardWebActivity.this.f36895b.canGoBack()) {
                    CreditCardWebActivity.this.f36894a.setCloseBtnVisibility(0);
                } else {
                    CreditCardWebActivity.this.f36894a.setCloseBtnVisibility(8);
                }
                String title = webView.getTitle();
                if (CreditCardWebActivity.this.mFusionWebModel.canChangeWebViewTitle) {
                    if (title == null || TextUtils.equals(title, "about:blank")) {
                        title = "";
                    } else if (webView.getUrl() != null) {
                        Uri parse = Uri.parse(webView.getUrl());
                        if (parse.getHost() != null && title.contains(parse.getHost())) {
                            title = CreditCardWebActivity.this.getString(R.string.app_name);
                        }
                    }
                    CreditCardWebActivity.this.f36894a.setTitleName(title);
                }
                CreditCardWebActivity.this.f36895b.requestFocus();
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (!TextUtil.isEmpty(CreditCardWebActivity.this.f36900g) && !TextUtil.isEmpty(str) && str.startsWith(CreditCardWebActivity.this.f36900g)) {
                    SystemUtils.log(6, "CreditCardWebActivity", str, (Throwable) null, "com.didi.sdk.payment.activity.CreditCardWebActivity$1", 166);
                    try {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (String str2 : new URL(str).getQuery().split(ParamKeys.SIGN_AND)) {
                            int indexOf = str2.indexOf("=");
                            linkedHashMap.put(URLDecoder.decode(str2.substring(0, indexOf), "UTF-8"), URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8"));
                        }
                        Intent intent = new Intent();
                        intent.putExtra(SignConstant.KEY_ADYEN_ERROR_NO, (String) linkedHashMap.get("errno"));
                        intent.putExtra(SignConstant.KEY_ADYEN_ERROR_MSG, (String) linkedHashMap.get("errmsg"));
                        CreditCardWebActivity.this.setResult(1, intent);
                        CreditCardWebActivity.this.finish();
                    } catch (Exception unused) {
                    }
                }
                super.onPageStarted(webView, str, bitmap);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return super.shouldOverrideUrlLoading(webView, str);
            }

            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        });
        try {
            CookieSyncManager.createInstance(getApplicationContext());
            CookieManager.getInstance().removeAllCookie();
            CookieSyncManager.getInstance().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
        m26141d();
    }

    /* renamed from: d */
    private void m26141d() {
        ApmThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                try {
                    Response execute = new DidiHttpClient().newCall(new Request.Builder().url(CreditCardWebActivity.this.f36898e).addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), CreditCardWebActivity.this.f36897d)).build()).execute();
                    if (execute != null) {
                        CreditCardWebActivity.this.m26135a(execute.body().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26135a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", this.f36898e);
        bundle.putString("result", str);
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.setData(bundle);
        this.f36899f.sendMessage(obtain);
    }

    public boolean goBack(boolean z) {
        boolean z2;
        String str;
        WebBackForwardList copyBackForwardList = this.f36895b.copyBackForwardList();
        String url = this.f36895b.getUrl();
        int i = -1;
        while (true) {
            if (!this.f36895b.canGoBackOrForward(i)) {
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
                this.f36895b.goBackOrForward(i);
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
