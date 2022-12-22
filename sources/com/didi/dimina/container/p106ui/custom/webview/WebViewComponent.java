package com.didi.dimina.container.p106ui.custom.webview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.p106ui.custom.CustomComponent;
import com.didi.dimina.container.p106ui.webview.DMWebViewContainer;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.soda.blocks.constant.Const;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.custom.webview.WebViewComponent */
public class WebViewComponent extends CustomComponent {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DMWebViewContainer f17532a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WebViewEngine f17533b;

    public View onMounted(Context context, JSONObject jSONObject) {
        DMWebViewContainer dMWebViewContainer = new DMWebViewContainer(context);
        this.f17532a = dMWebViewContainer;
        dMWebViewContainer.syncData(this.mDMPage, this.mDMPage.getDMMina(), this.mDMPage.getNavigator());
        WebViewEngine webView = this.f17532a.getWebView();
        this.f17533b = webView;
        webView.setNeedShowProgressBar(true);
        WebViewEngine webViewEngine = this.f17533b;
        webViewEngine.setUserAgentString(this.f17533b.getUserAgentString() + "; Dimina miniProgram");
        this.f17532a.setChangeTitleListener(new DMWebViewContainer.OnTitleChangeListener() {
            public final void onTitleChanged(String str) {
                WebViewComponent.this.m13040a(str);
            }
        });
        this.mDMPage.setH5Page(true);
        this.mDMPage.setH5WebViewContainer(this.f17532a);
        onPropertiesUpdate(jSONObject);
        this.f17532a.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        return this.f17532a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m13040a(String str) {
        if (this.mDMPage.getWebViewContainer().getChangeTitleListener() != null) {
            this.mDMPage.getWebViewContainer().getChangeTitleListener().onTitleChanged(str);
        }
    }

    public void onPropertiesUpdate(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.has("attributes")) {
                Object opt = jSONObject.opt("attributes");
                if (opt instanceof JSONObject) {
                    jSONObject = (JSONObject) opt;
                } else if (opt != null) {
                    jSONObject = JSONUtil.toJSONObject(opt.toString());
                }
            }
            m13041a(jSONObject);
        }
    }

    /* renamed from: a */
    private void m13041a(final JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(Const.BlockParamConst.SRC)) {
            this.f17532a.setVisibility(0);
            this.f17532a.addWebViewLoadListener(new WebViewEngine.OnWebViewLoadListener() {
                public WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, WebResourceRequest webResourceRequest, String str) {
                    return null;
                }

                public WebResourceResponse shouldInterceptRequest(WebViewEngine webViewEngine, String str, String str2) {
                    return null;
                }

                public Boolean shouldOverrideUrlLoading(WebViewEngine webViewEngine, String str) {
                    return null;
                }

                public void onPageFinished(WebViewEngine webViewEngine, String str) {
                    WebViewComponent.this.mDMPage.getDMMina().getMessageTransfer().sendMessageToWebView(WebViewComponent.this.mDMPage.getWebViewContainer().getWebView(), "bindload", new MessageWrapperBuilder().webViewId(WebViewComponent.this.mDMPage.getWebViewId()).build());
                    WebViewComponent.this.f17533b.setNeedShowProgressBar(false);
                    if (jSONObject.has("javascript") && WebViewComponent.this.f17533b != null) {
                        WebViewEngine d = WebViewComponent.this.f17533b;
                        d.evaluateJavascript("javascript:" + jSONObject.optString("javascript"), (WebViewEngine.WebViewEngineValueCallback<String>) null);
                    }
                    String title = webViewEngine.getTitle();
                    if (!TextUtils.isEmpty(title) && !URLUtil.isNetworkUrl(title) && !title.endsWith(".html") && !title.endsWith(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX) && WebViewComponent.this.mDMPage.getWebViewContainer().getChangeTitleListener() != null) {
                        WebViewComponent.this.mDMPage.getWebViewContainer().getChangeTitleListener().onTitleChanged(webViewEngine.getTitle());
                    }
                }

                public void onReceivedError(WebViewEngine webViewEngine, String str) {
                    if (!TextUtils.isEmpty(str) && str.endsWith(".html")) {
                        WebViewComponent.this.f17532a.setVisibility(8);
                        WebViewComponent.this.mDMPage.getDMMina().getMessageTransfer().sendMessageToWebView(WebViewComponent.this.mDMPage.getWebViewContainer().getWebView(), "binderror", new MessageWrapperBuilder().webViewId(WebViewComponent.this.mDMPage.getWebViewId()).build());
                    }
                }
            });
            this.f17533b.loadUrl(jSONObject.optString(Const.BlockParamConst.SRC));
        }
    }

    public void onDestroyed() {
        if (this.mDMPage != null) {
            this.mDMPage.setH5Page(false);
            this.mDMPage.setH5WebViewContainer((DMWebViewContainer) null);
        }
        if (this.f17533b != null) {
            UIHandlerUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (WebViewComponent.this.f17533b != null) {
                        ViewParent parent = WebViewComponent.this.f17533b.getWebView().getParent();
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(WebViewComponent.this.f17533b.getWebView());
                        }
                        WebViewComponent.this.f17533b.dmDestroy();
                        WebViewEngine unused = WebViewComponent.this.f17533b = null;
                    }
                }
            });
        }
    }
}
