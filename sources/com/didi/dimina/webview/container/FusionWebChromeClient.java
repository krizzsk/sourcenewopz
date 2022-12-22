package com.didi.dimina.webview.container;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.didi.dimina.webview.BusinessAgent;
import com.didi.dimina.webview.FusionEngine;
import com.didi.dimina.webview.adapter.OldJavascriptBridgeAdapter;
import com.didi.dimina.webview.jsbridge.BridgeHelper;
import com.didi.dimina.webview.jsbridge.WebViewJavascriptBridge;
import com.didi.dimina.webview.log.apollo.ApolloLog;
import com.didi.dimina.webview.util.C7819Util;
import org.json.JSONObject;

public class FusionWebChromeClient extends WebChromeClient {

    /* renamed from: a */
    private static final String f18229a = "FusionWebChromeClient";

    /* renamed from: b */
    private final FusionWebView f18230b;

    /* renamed from: c */
    private final WebViewJavascriptBridge f18231c;

    /* renamed from: d */
    private final OldJavascriptBridgeAdapter f18232d;

    /* renamed from: e */
    private boolean f18233e = false;

    public FusionWebChromeClient(FusionWebView fusionWebView) {
        this.f18230b = fusionWebView;
        this.f18231c = fusionWebView.getJavascriptBridge();
        this.f18232d = new OldJavascriptBridgeAdapter(fusionWebView);
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i < 25) {
            if (this.f18233e) {
                this.f18233e = false;
            }
        } else if (!this.f18233e) {
            BridgeHelper.webViewLoadLocalJs(webView, BridgeHelper.ASSET_BRIDGE4_JS);
            this.f18233e = true;
        }
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("fusion");
            if (TextUtils.isEmpty(optString) || !optString.equals("loadJSModules")) {
                Context context = webView.getContext();
                BusinessAgent businessAgent = FusionEngine.getBusinessAgent();
                if (!C7819Util.isApkDebug(context)) {
                    if (!businessAgent.isWhiteUrl(context, str)) {
                        jsPromptResult.confirm("please put this url into white list");
                    }
                }
                if (this.f18232d.matchPreviousBridgeProtocol(jSONObject)) {
                    this.f18232d.handleInvokeOfPreviousJS(jSONObject);
                    jsPromptResult.confirm("prompt ok");
                } else {
                    jsPromptResult.confirm(this.f18232d.handleInvokeFromAncientJS(str2));
                }
            } else {
                jsPromptResult.confirm(this.f18231c.getExportModules().toString());
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            jsPromptResult.confirm("");
            return true;
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        try {
            ApolloLog.uploadJsError(this.f18230b, consoleMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
