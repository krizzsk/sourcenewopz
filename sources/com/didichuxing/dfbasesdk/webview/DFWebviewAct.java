package com.didichuxing.dfbasesdk.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.didichuxing.dfbasesdk.DFAppConfig;
import com.didichuxing.dfbasesdk.act.DFBaseAct;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.webview.bizjscmd.BizJsCmdHandlerFactory;
import com.didichuxing.dfbasesdk.webview.bizjscmd.IBizJsCmdHandler;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import org.json.JSONObject;

public class DFWebviewAct extends DFBaseAct implements C15328c {
    public static int progressDrawable = 2131232459;

    /* renamed from: a */
    private WebView f46931a;

    /* renamed from: b */
    private ProgressBar f46932b;

    /* renamed from: c */
    private C15329d f46933c;

    /* renamed from: d */
    private IBizJsCmdHandler f46934d;

    /* renamed from: e */
    private String f46935e;

    /* renamed from: f */
    private String f46936f;

    /* renamed from: g */
    private int f46937g;

    /* renamed from: h */
    private String f46938h;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.df_webview_act;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            this.f46935e = data.getQueryParameter("url");
        }
        if (TextUtils.isEmpty(this.f46935e)) {
            this.f46935e = intent.getStringExtra("url");
        }
        this.f46936f = intent.getStringExtra("id");
        this.f46937g = intent.getIntExtra("state", 2);
        this.f46938h = intent.getStringExtra("sceneType");
        if (TextUtils.isEmpty(this.f46935e)) {
            this.f46935e = intent.getStringExtra("webUrl");
        }
        if (TextUtils.isEmpty(this.f46935e)) {
            this.f46935e = "about:blank";
        }
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        this.f46931a = (WebView) findViewById(R.id.webview);
        m33649a();
        this.f46931a.loadUrl(this.f46935e);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.web_progress_bar);
        this.f46932b = progressBar;
        progressBar.setProgressDrawable(getResources().getDrawable(progressDrawable));
    }

    /* renamed from: a */
    private void m33649a() {
        WebSettings settings = this.f46931a.getSettings();
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        String userAgentString = settings.getUserAgentString();
        if (userAgentString == null) {
            userAgentString = "";
        }
        settings.setUserAgentString((userAgentString + " dfbasesdk_v0.5.11.38.5").trim());
        if (Build.VERSION.SDK_INT < 18) {
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        }
        if (Build.VERSION.SDK_INT >= 19 && DFAppConfig.getInstance().isDebug()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT < 17) {
            this.f46931a.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f46931a.removeJavascriptInterface("accessibilityTraversal");
            this.f46931a.removeJavascriptInterface("accessibility");
        }
        this.f46931a.setWebViewClient(new C15326b());
        this.f46931a.setWebChromeClient(new C15325a());
        C15329d dVar = new C15329d(this);
        this.f46933c = dVar;
        this.f46931a.addJavascriptInterface(dVar, "NativeHandler");
        this.f46934d = BizJsCmdHandlerFactory.newJsCmdHandler(this.f46938h, this.f46936f, this.f46937g, this.f46935e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo115934a(int i) {
        if (i <= 100) {
            if (i < 100 && this.f46932b.getVisibility() == 4) {
                this.f46932b.setVisibility(0);
            }
            this.f46932b.setProgress(i);
            if (i == 100) {
                this.f46932b.setVisibility(4);
            }
        }
    }

    @Subscribe
    public void onJsCallbackEvent(JsCallbackEvent jsCallbackEvent) {
        C15329d dVar = this.f46933c;
        if (dVar == null) {
            LogUtils.m33566e("Webview", "mJsBridge==null!!!");
            return;
        }
        WebView webView = this.f46931a;
        if (webView == null) {
            LogUtils.m33566e("Webview", "mWebview==null!!!");
        } else {
            dVar.mo115953a(webView, jsCallbackEvent);
        }
    }

    @Subscribe
    public void onCloseWebviewEvent(CloseWebviewEvent closeWebviewEvent) {
        finish();
    }

    public void handleJsInvoke(String str, JSONObject jSONObject) {
        if (JSCommands.TAKE_PHOTO.equals(str)) {
            m33650b(jSONObject.optInt("photoType"));
        } else if (JSCommands.SHOW_BACK_BUTTON.equals(str)) {
            this.mLeftTitleBtn.setVisibility(jSONObject.optInt("state") == 1 ? 0 : 4);
            onJsCallbackEvent(new JsCallbackEvent(str).build());
        } else if (!this.f46934d.handleJsCmd(str, jSONObject)) {
            onJsCallbackEvent(new JsCallbackEvent(str, 1003, "unknown command: " + str).build());
        }
    }

    /* renamed from: b */
    private void m33650b(int i) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("difaceh5invoke://takephoto").buildUpon().build());
        intent.setPackage(WsgSecInfo.packageName(this));
        intent.putExtra("fromH5", true);
        intent.putExtra("type", i);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        this.f46934d.onUserCancel();
        super.onLeftTitleBtnClicked();
    }

    /* access modifiers changed from: protected */
    public boolean onBackKeyIntercept() {
        WebView webView = this.f46931a;
        if (webView == null || !webView.canGoBack()) {
            this.f46934d.onUserCancel();
            finish();
            return true;
        }
        this.f46931a.goBack();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.f46931a != null) {
            this.mLayoutBody.removeView(this.f46931a);
            this.f46931a.destroy();
            this.f46931a = null;
        }
        super.onDestroy();
    }
}
