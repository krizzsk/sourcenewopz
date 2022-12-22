package com.didi.onehybrid.container;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.adapter.OldJavascriptBridgeAdapter;
import com.didi.onehybrid.jsbridge.BridgeHelper;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.onehybrid.log.apollo.ApolloLog;
import com.didi.onehybrid.util.C10393Util;
import org.json.JSONObject;

public class FusionWebChromeClient extends WebChromeClient {
    private static final String TAG = "FusionWebChromeClient";
    private final FusionWebView fusionWebView;
    private boolean mJSInjected = false;
    private final OldJavascriptBridgeAdapter mOldJavascriptBridgeAdpater;
    private final WebViewJavascriptBridge mWebJavascriptBridge;

    public FusionWebChromeClient(FusionWebView fusionWebView2) {
        this.fusionWebView = fusionWebView2;
        this.mWebJavascriptBridge = fusionWebView2.getJavascriptBridge();
        this.mOldJavascriptBridgeAdpater = new OldJavascriptBridgeAdapter(fusionWebView2);
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i < 25) {
            if (this.mJSInjected) {
                this.mJSInjected = false;
            }
        } else if (!this.mJSInjected) {
            BridgeHelper.webViewLoadLocalJs(webView, BridgeHelper.ASSET_BRIDGE4_JS);
            this.mJSInjected = true;
        }
        if (i < 100) {
            this.fusionWebView.showLoadProgress(i);
        } else {
            this.fusionWebView.hiddenLoadProgress();
        }
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("fusion");
            if (TextUtils.isEmpty(optString) || !optString.equals("loadJSModules")) {
                Context context = webView.getContext();
                BusinessAgent businessAgent = FusionEngine.getBusinessAgent();
                if (!C10393Util.isApkDebug(context)) {
                    if (!businessAgent.isWhiteUrl(context, str)) {
                        jsPromptResult.confirm("please put this url into white list");
                    }
                }
                if (this.mOldJavascriptBridgeAdpater.matchPreviousBridgeProtocol(jSONObject)) {
                    this.mOldJavascriptBridgeAdpater.handleInvokeOfPreviousJS(jSONObject);
                    jsPromptResult.confirm("prompt ok");
                } else {
                    jsPromptResult.confirm(this.mOldJavascriptBridgeAdpater.handleInvokeFromAncientJS(str2));
                }
            } else {
                jsPromptResult.confirm(this.mWebJavascriptBridge.getExportModules().toString());
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
            ApolloLog.uploadJsError(this.fusionWebView, consoleMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
