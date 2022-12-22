package com.didi.soda.web.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.didi.onehybrid.container.BaseHybridableActivity;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.web.UpdateUIHandlerImp;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.soda.web.p168ui.IErrorLayout;
import com.didi.soda.web.page.performance.PagePerformanceDelegate;
import com.didi.soda.web.page.performance.PagePerformanceListener;
import com.didi.soda.web.proxy.WebProxy;
import com.didi.soda.web.tools.LogUtil;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didi.soda.web.widgets.SodaWebView;
import com.didi.soda.web.widgets.WebPageTitleBar;
import com.taxis99.R;
import java.util.List;
import org.json.JSONObject;

public class SodaWebActivity extends BaseHybridableActivity implements UpdateUIHandlerImp, SodaWebView.WebPageStateListener {

    /* renamed from: a */
    private WebConfig f43875a;

    /* renamed from: b */
    private WebProxy f43876b;

    /* renamed from: c */
    private View f43877c;

    /* renamed from: d */
    private PagePerformanceDelegate f43878d;

    /* access modifiers changed from: protected */
    public int backgroundColor() {
        return -1;
    }

    public void hideEntrance() {
    }

    /* access modifiers changed from: protected */
    public View inflateTitleBar() {
        return null;
    }

    /* access modifiers changed from: protected */
    public SodaWebView inflateWebView() {
        return null;
    }

    public boolean onInterceptedToNative(String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean remoteDebuggingEnable() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        View inflate = View.inflate(this, R.layout.nova_web_page_hybrid, (ViewGroup) null);
        this.f43877c = inflate;
        inflate.findViewById(R.id.cl_hybrid_root).setBackgroundColor(backgroundColor());
        setContentView(this.f43877c);
        m31209a();
        this.f43878d = new PagePerformanceDelegate();
    }

    /* renamed from: a */
    private void m31209a() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        } else if (intent.hasExtra(WebConstant.WEB_MODEL)) {
            WebConfig webConfig = (WebConfig) intent.getParcelableExtra(WebConstant.WEB_MODEL);
            this.f43875a = webConfig;
            if (webConfig == null || TextUtils.isEmpty(webConfig.url)) {
                finish();
                return;
            }
            this.f43875a.remoteDebuggable = remoteDebuggingEnable();
            this.f43876b = new WebProxy(this, inflateWebView(), inflateTitleBar(), this.f43877c, (IErrorLayout) null, this.f43875a);
        } else {
            finish();
        }
    }

    public void invokeJSMethod(String str, String str2, Object... objArr) {
        if (getWebView() != null) {
            getWebView().getJavascriptBridge().invokeJSMethod(str, str2, objArr);
        }
    }

    public void onBackPressed() {
        this.f43876b.onBack();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        WebProxy webProxy = this.f43876b;
        if (webProxy != null) {
            webProxy.destory();
        }
        PagePerformanceDelegate pagePerformanceDelegate = this.f43878d;
        if (pagePerformanceDelegate != null) {
            pagePerformanceDelegate.onDestroy();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public WebPageTitleBar getTitleBar() {
        return this.f43876b.getWebTitleBar();
    }

    public FusionWebView getWebView() {
        WebProxy webProxy = this.f43876b;
        if (webProxy == null) {
            return null;
        }
        return webProxy.getWebView();
    }

    public void finishPage() {
        finish();
    }

    public void launchScan(CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void onWebPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f43876b.onWebPageStarted();
        PagePerformanceDelegate pagePerformanceDelegate = this.f43878d;
        if (pagePerformanceDelegate != null) {
            pagePerformanceDelegate.onWebPageStarted(str);
        }
    }

    public void onWebPageFinished(WebView webView, String str) {
        this.f43876b.onWebPageFinished(webView, str);
        PagePerformanceDelegate pagePerformanceDelegate = this.f43878d;
        if (pagePerformanceDelegate != null) {
            pagePerformanceDelegate.onWebPageFinished(str);
        }
    }

    public void onWebPageReceivedError(WebView webView, int i, String str, String str2) {
        this.f43876b.onWebPageReceivedError(i, str2);
    }

    public void updateUI(String str, Object... objArr) {
        this.f43876b.updateUI(str, objArr);
    }

    public void showEntrance(CallbackFunction callbackFunction, String str) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void onEntranceClick(List<ShareToolModel> list, CallbackFunction callbackFunction) {
        invokeEntrance(list, callbackFunction);
    }

    public void invokeEntrance(List<ShareToolModel> list, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void showSystemEntrance(ShareToolModel shareToolModel, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void updateNav(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void setPagePerformanceListener(PagePerformanceListener pagePerformanceListener) {
        LogUtil.info("setPagePerformanceListener");
        PagePerformanceDelegate pagePerformanceDelegate = this.f43878d;
        if (pagePerformanceDelegate == null) {
            LogUtil.info("Delegate null");
        } else {
            pagePerformanceDelegate.setPerformanceListener(pagePerformanceListener);
        }
    }
}
