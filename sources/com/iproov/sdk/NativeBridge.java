package com.iproov.sdk;

import android.content.Context;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.login.LoginLogger;
import com.iproov.sdk.IProov;
import com.iproov.sdk.bridge.C19764do;
import com.iproov.sdk.bridge.C19765if;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.core.C19902return;
import com.iproov.sdk.core.C19905this;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.logging.IPLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p093switch.C3127throw;
import p093switch.C3128try;
import p242io.socket.client.Socket;

public class NativeBridge {
    private static final String JAVASCRIPT_INTERFACE_NAME = "iProovNativeBridge";
    /* access modifiers changed from: private */
    public static final String TAG = "NativeBridge";
    private IProov.Listener listener;

    /* renamed from: com.iproov.sdk.NativeBridge$do */
    class C19752do implements IProov.Listener {

        /* renamed from: do */
        final /* synthetic */ WebView f53993do;

        C19752do(NativeBridge nativeBridge, WebView webView) {
            this.f53993do = webView;
        }

        public void onCancelled() {
            NativeBridge.evaluateJavascript(this.f53993do, new C19765if(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, (Map<String, Object>) null));
        }

        public void onConnected() {
            NativeBridge.evaluateJavascript(this.f53993do, new C19765if(AnalyseTickHelper.SDK_CONNECTED, (Map<String, Object>) null));
        }

        public void onConnecting() {
            NativeBridge.evaluateJavascript(this.f53993do, new C19765if(Socket.EVENT_CONNECTING, (Map<String, Object>) null));
        }

        public void onError(IProovException iProovException) {
            NativeBridge.evaluateJavascript(this.f53993do, new C19765if("error", Collections.singletonMap("error", iProovException.getLocalizedMessage())));
        }

        public void onFailure(IProov.FailureResult failureResult) {
            HashMap hashMap = new HashMap();
            hashMap.put("reason", failureResult.reason);
            hashMap.put("feedbackCode", failureResult.feedbackCode);
            NativeBridge.evaluateJavascript(this.f53993do, new C19765if(LoginLogger.EVENT_EXTRAS_FAILURE, hashMap));
        }

        public void onProcessing(double d, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("progress", Double.valueOf(d));
            hashMap.put("message", str);
            NativeBridge.evaluateJavascript(this.f53993do, new C19765if("processing", hashMap));
        }

        public void onSuccess(IProov.SuccessResult successResult) {
            NativeBridge.evaluateJavascript(this.f53993do, new C19765if("success", Collections.singletonMap("token", successResult.token)));
        }
    }

    /* renamed from: com.iproov.sdk.NativeBridge$if */
    private static class C19753if {

        /* renamed from: do */
        private final Context f53994do;

        /* renamed from: for  reason: not valid java name */
        private final boolean f61734for;

        /* renamed from: if */
        private final WebView f53995if;

        /* synthetic */ C19753if(WebView webView, boolean z, C19752do doVar) {
            this(webView, z);
        }

        @JavascriptInterface
        public boolean launch(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = C3128try.m4081if(jSONObject, "token");
                String str3 = C3128try.m4081if(jSONObject, "streaming_url");
                JSONObject optJSONObject = jSONObject.optJSONObject(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                if (C3127throw.m4053do(str2)) {
                    IPLog.m39301e(NativeBridge.TAG, "Token not specified");
                    NativeBridge.evaluateJavascript(this.f53995if, new C19765if("error", Collections.singletonMap("error", "Token not specified")));
                    return false;
                } else if (C3127throw.m4053do(str3)) {
                    IPLog.m39301e(NativeBridge.TAG, "Streaming URL not specified");
                    NativeBridge.evaluateJavascript(this.f53995if, new C19765if("error", Collections.singletonMap("error", "Streaming URL not specified")));
                    return false;
                } else {
                    try {
                        try {
                            IProov.m38647a(this.f53994do, str3, str2, new C19902return(OptionsBridge.fromJson(this.f53994do, optJSONObject), new C19905this(C19905this.C19906do.NATIVE_BRIDGE)));
                            return true;
                        } catch (IProovException e) {
                            e.printStackTrace();
                            IPLog.m39305w(NativeBridge.TAG, "Failed to launch via native bridge");
                            return false;
                        }
                    } catch (IProovException e2) {
                        e2.printStackTrace();
                        IPLog.m39305w(NativeBridge.TAG, "Failed to launch via native bridge");
                        return false;
                    }
                }
            } catch (JSONException unused) {
                IPLog.m39301e(NativeBridge.TAG, "Failed to parse JSON launch configuration");
                NativeBridge.evaluateJavascript(this.f53995if, new C19765if("error", Collections.singletonMap("error", "Failed to parse JSON launch configuration")));
                return false;
            }
        }

        @JavascriptInterface
        public String publicKey() {
            if (this.f61734for) {
                IPLog.m39305w(NativeBridge.TAG, "Failed to get public key because cryptography is not enabled");
                return null;
            }
            try {
                return IProov.getKeyPair(this.f53994do).getPublicKey().getPem();
            } catch (IProovException e) {
                e.printStackTrace();
                IPLog.m39305w(NativeBridge.TAG, "Error signing data");
                return null;
            }
        }

        @JavascriptInterface
        public String sign(String str) {
            if (this.f61734for) {
                IPLog.m39305w(NativeBridge.TAG, "Failed to sign data because cryptography is not enabled");
                return null;
            } else if (str == null) {
                IPLog.m39305w(NativeBridge.TAG, "Error signing data, input can not be null");
                return null;
            } else {
                try {
                    return C3127throw.m4050do(IProov.getKeyPair(this.f53994do).sign(Base64.decode(str, 2)));
                } catch (IProovException e) {
                    e.printStackTrace();
                    String access$200 = NativeBridge.TAG;
                    IPLog.m39305w(access$200, "Error signing data: " + e.getMessage());
                    return null;
                }
            }
        }

        private C19753if(WebView webView, boolean z) {
            this.f53994do = webView.getContext().getApplicationContext();
            this.f53995if = webView;
            this.f61734for = z;
        }
    }

    /* access modifiers changed from: private */
    public static void evaluateJavascript(WebView webView, C19764do doVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Executing JS: ");
        sb.append(doVar.mo161872do());
        C3127throw.m4052do((Runnable) new Runnable(webView, doVar) {
            public final /* synthetic */ WebView f$0;
            public final /* synthetic */ C19764do f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                this.f$0.evaluateJavascript(this.f$1.mo161872do(), (ValueCallback) null);
            }
        });
    }

    private IProov.Listener webViewBridgeListener(WebView webView) {
        return new C19752do(this, webView);
    }

    public void install(WebView webView, boolean z) {
        if (webView == null) {
            IPLog.m39301e(TAG, "Cannot install into a null webView");
            return;
        }
        if (!webView.getSettings().getJavaScriptEnabled()) {
            IPLog.m39301e(TAG, "Native Bridge requires WebView Javascript execution to be enabled");
        }
        IProov.Listener webViewBridgeListener = IProov.nativeBridge.webViewBridgeListener(webView);
        this.listener = webViewBridgeListener;
        IProov.registerListener(webViewBridgeListener);
        webView.addJavascriptInterface(new C19753if(webView, z, (C19752do) null), JAVASCRIPT_INTERFACE_NAME);
    }

    public void uninstall(WebView webView) {
        if (webView != null) {
            webView.removeJavascriptInterface(JAVASCRIPT_INTERFACE_NAME);
        }
        IProov.Listener listener2 = this.listener;
        if (listener2 != null) {
            IProov.unregisterListener(listener2);
            this.listener = null;
        }
    }
}
