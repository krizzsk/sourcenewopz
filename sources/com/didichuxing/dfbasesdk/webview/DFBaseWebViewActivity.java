package com.didichuxing.dfbasesdk.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.didichuxing.dfbasesdk.DFAppConfig;
import com.didichuxing.dfbasesdk.act.DFBaseAct;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.webview.bizjscmd.AbsJsCmdHandler;
import com.didichuxing.dfbasesdk.webview.bizjscmd.DummyJsCommandHandler;
import com.didichuxing.dfbasesdk.webview.bizjscmd.IJsCallback;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import org.json.JSONObject;

public class DFBaseWebViewActivity extends DFBaseAct implements IJsCallback, C15328c {
    protected C15329d jsBridge;
    protected AbsJsCmdHandler jsCmdHandler;
    protected String mUrl;
    protected WebView webview;

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.df_base_webview_act;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void updateWebProgress(int i) {
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        hideTitleArea();
        this.webview = (WebView) findViewById(R.id.webview);
        m33648a();
    }

    /* renamed from: a */
    private void m33648a() {
        WebSettings settings = this.webview.getSettings();
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
            this.webview.removeJavascriptInterface("searchBoxJavaBridge_");
            this.webview.removeJavascriptInterface("accessibilityTraversal");
            this.webview.removeJavascriptInterface("accessibility");
        }
        this.webview.setWebViewClient(new C15326b());
        this.webview.setWebChromeClient(new C15325a());
        C15329d dVar = new C15329d(this);
        this.jsBridge = dVar;
        this.webview.addJavascriptInterface(dVar, "NativeHandler");
        AbsJsCmdHandler jsCmdHandler2 = getJsCmdHandler();
        this.jsCmdHandler = jsCmdHandler2;
        jsCmdHandler2.setCallback(this);
    }

    public void loadUrl(String str) {
        WebView webView;
        this.mUrl = str;
        if (!TextUtils.isEmpty(str) && (webView = this.webview) != null) {
            webView.loadUrl(str);
        }
    }

    @Subscribe
    public void onJsCallbackEvent(JsCallbackEvent jsCallbackEvent) {
        C15329d dVar = this.jsBridge;
        if (dVar == null) {
            LogUtils.m33566e("Webview", "jsBridge==null!!!");
            return;
        }
        WebView webView = this.webview;
        if (webView == null) {
            LogUtils.m33566e("Webview", "webview==null!!!");
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
            toTakePhotoAct(jSONObject.optInt("photoType"));
        } else if (JSCommands.SHOW_BACK_BUTTON.equals(str)) {
            this.mLeftTitleBtn.setVisibility(jSONObject.optInt("state") == 1 ? 0 : 4);
            onJsCallbackEvent(new JsCallbackEvent(str).build());
        } else if (!this.jsCmdHandler.handleJsCmd(str, jSONObject)) {
            onJsCallbackEvent(new JsCallbackEvent(str, 1003, "unknown command: " + str).build());
        }
    }

    /* access modifiers changed from: protected */
    public AbsJsCmdHandler getJsCmdHandler() {
        return new DummyJsCommandHandler();
    }

    /* access modifiers changed from: protected */
    public void toTakePhotoAct(int i) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("difaceh5invoke://takephoto").buildUpon().build());
        intent.setPackage(WsgSecInfo.packageName(this));
        intent.putExtra("fromH5", true);
        intent.putExtra("type", i);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        this.jsCmdHandler.onUserCancel();
        super.onLeftTitleBtnClicked();
    }

    /* access modifiers changed from: protected */
    public boolean onBackKeyIntercept() {
        WebView webView = this.webview;
        if (webView == null || !webView.canGoBack()) {
            this.jsCmdHandler.onUserCancel();
            finish();
            return true;
        }
        this.webview.goBack();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.webview != null) {
            this.mLayoutBody.removeView(this.webview);
            this.webview.destroy();
            this.webview = null;
        }
        super.onDestroy();
    }

    public void onJsCallback(JsCallbackEvent jsCallbackEvent) {
        onJsCallbackEvent(jsCallbackEvent);
    }
}
