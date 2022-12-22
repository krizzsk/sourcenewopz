package com.didi.dimina.container.messager;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.jsengine.JSArray;
import com.didi.dimina.container.jsengine.JSEngineWrapper;
import com.didi.dimina.container.messager.MessageHandler;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.monitor.TimeTrackMonitor;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TextUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

public class DMMessageTransfer {
    public static final String DM_MESSAGE_THREAD = "DMMessageTransfer_Thread";

    /* renamed from: a */
    private static final String f16859a = "DiminaServiceBridge";

    /* renamed from: b */
    private static final String f16860b = "invokeCallbackHandler";

    /* renamed from: c */
    private static final String f16861c = "subscribeHandler";

    /* renamed from: d */
    private final DMMina f16862d;

    /* renamed from: e */
    private boolean f16863e = false;

    /* renamed from: f */
    private final LinkedList<Runnable> f16864f = new LinkedList<>();

    /* renamed from: g */
    private volatile boolean f16865g;

    /* renamed from: h */
    private Handler f16866h;

    /* renamed from: i */
    private final HandlerThread f16867i;

    public DMMessageTransfer(int i) {
        HandlerThread handlerThread = new HandlerThread(DM_MESSAGE_THREAD);
        this.f16867i = handlerThread;
        handlerThread.start();
        this.f16866h = new Handler(this.f16867i.getLooper());
        this.f16865g = true;
        this.f16862d = DMMinaPool.get(i);
        try {
            MessageHandler.sEnableAllBridgeListener = ((Boolean) MMKVUtil.getInstance().get(MessageHandler.PARAM_ENABLE_ALL_BRIDGE_LISTENER, false)).booleanValue();
            MessageHandler.sEnableFirstDomReadyBridgeListener = ((Boolean) MMKVUtil.getInstance().get(MessageHandler.PARAM_ENABLE_FIRST_DOM_READY_BRIDGE_LISTENER, false)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enableServiceMessageTransform() {
        this.f16865g = false;
    }

    public Object invokeNativeFromService(JSArray jSArray) {
        return TimeTrackMonitor.timeTrackAction(this.f16862d.getConfig().getLaunchConfig().getMonitorLogConfig().getJsCoreLog(), jSArray, new Function0(jSArray) {
            public final /* synthetic */ JSArray f$1;

            {
                this.f$1 = r2;
            }

            public final Object invoke() {
                return DMMessageTransfer.this.m12475a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Object m12475a(JSArray jSArray) {
        if (jSArray.length() == 0 || this.f16865g) {
            return "";
        }
        String string = jSArray.getString(0);
        String jSONString = jSArray.getObject(1).toJSONString();
        String string2 = jSArray.getString(2);
        String string3 = TextUtil.isEmpty(jSArray.getString(3)) ? "DMServiceBridgeModule" : jSArray.getString(3);
        if (TextUtil.isEmpty(string2)) {
            return m12487b(jSArray, string, string2, jSONString, string3);
        }
        this.f16866h.post(new Runnable(jSArray, string, string2, jSONString, string3) {
            public final /* synthetic */ JSArray f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ String f$3;
            public final /* synthetic */ String f$4;
            public final /* synthetic */ String f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void run() {
                DMMessageTransfer.this.m12487b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        });
        return "";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Object m12487b(JSArray jSArray, String str, String str2, String str3, String str4) {
        try {
            return m12477a(str4, str, TextUtils.isEmpty(str3) ? new JSONObject() : new JSONObject(str3), str2);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.m13409e("jsArray-Native: " + jSArray.toJSONArray());
            TraceUtil.trackEventError(this.f16862d.getMinaIndex(), "JSEngineException", 1011, Log.getStackTraceString(e));
            return null;
        }
    }

    /* renamed from: a */
    private Object m12477a(String str, String str2, JSONObject jSONObject, String str3) {
        return MessageHandler.handleFromService(this.f16862d, str, str2, jSONObject, new MessageHandler.Callback(str3) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onResult(JSONObject jSONObject) {
                DMMessageTransfer.this.m12490c(this.f$1, jSONObject);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m12490c(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            invokeCallbackToService(str, jSONObject);
        }
    }

    public void sendMessageToServiceFromNative(String str, JSONObject jSONObject) {
        m12485a(f16859a, f16860b, m12478a(str, jSONObject));
    }

    public void invokeCallbackToService(String str, JSONObject jSONObject) {
        m12485a(f16859a, f16860b, m12486b(str, jSONObject));
    }

    public void sendMessageToServiceFromWebView(String str) {
        JSEngineWrapper jSEngine = this.f16862d.getJSEngine();
        jSEngine.executeScript("javascript: DiminaServiceBridge.subscribeHandler(" + str + ")");
    }

    /* renamed from: a */
    private void m12485a(String str, String str2, JSONObject jSONObject) {
        JSEngineWrapper jSEngine = this.f16862d.getJSEngine();
        jSEngine.executeScript("javascript: " + str + "." + str2 + "(" + jSONObject + ")");
    }

    public void invokeNativeFromWebView(WebViewEngine webViewEngine, String str, String str2, String str3, String str4) {
        this.f16866h.post(new Runnable(str4, str, str2, str3, webViewEngine) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ String f$3;
            public final /* synthetic */ String f$4;
            public final /* synthetic */ WebViewEngine f$5;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
            }

            public final void run() {
                DMMessageTransfer.this.m12489b(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m12489b(String str, String str2, String str3, String str4, WebViewEngine webViewEngine) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = "DMWebViewBridgeModule";
            }
            m12484a(str, str2, str3, str4, webViewEngine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m12484a(String str, String str2, String str3, String str4, WebViewEngine webViewEngine) {
        String str5 = str;
        String str6 = str2;
        MessageHandler.handleFromWebView(this.f16862d, str5, str6, JSONUtil.toJSONObject(str3), webViewEngine, new MessageHandler.Callback(webViewEngine, str4) {
            public final /* synthetic */ WebViewEngine f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onResult(JSONObject jSONObject) {
                DMMessageTransfer.this.m12483a(this.f$1, this.f$2, jSONObject);
            }
        });
    }

    public void sendMessageToWebView(int i, String str) {
        m12480a(i, "javascript: DiminaWebViewBridge.subscribeHandler(" + str + ")");
    }

    public void sendMessageToWebView(WebViewEngine webViewEngine, String str, JSONObject jSONObject) {
        JSONObject a = m12478a(str, jSONObject);
        m12481a(webViewEngine, "javascript: DiminaWebViewBridge.invokeCallbackHandler(" + a.toString() + ")");
    }

    /* renamed from: invokeCallbackToWebView */
    public void m12483a(WebViewEngine webViewEngine, String str, JSONObject jSONObject) {
        if (webViewEngine != null) {
            JSONObject b = m12486b(str, jSONObject);
            m12481a(webViewEngine, "javascript: DiminaWebViewBridge.invokeCallbackHandler(" + b + ")");
        }
    }

    /* renamed from: a */
    private void m12480a(int i, String str) {
        WebViewEngine webViewEngine = this.f16862d.getDmWebViewManager().get(Integer.valueOf(i));
        if (webViewEngine != null) {
            m12481a(webViewEngine, str);
        }
    }

    public void ddInvokeJSToJSEngineWhileBusinessReady(Runnable runnable) {
        if (this.f16863e) {
            runnable.run();
        } else {
            this.f16864f.addLast(runnable);
        }
    }

    public void setBusinessReady() {
        if (!this.f16863e) {
            this.f16863e = true;
            Iterator it = this.f16864f.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
    }

    /* renamed from: a */
    private void m12481a(WebViewEngine webViewEngine, String str) {
        if (webViewEngine != null) {
            UIHandlerUtil.runOnUiThread(new Runnable(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    WebViewEngine.this.evaluateJavascript(this.f$1, (WebViewEngine.WebViewEngineValueCallback<String>) null);
                }
            });
        }
    }

    public void release() {
        this.f16865g = true;
        UIHandlerUtil.post(new Runnable() {
            public final void run() {
                DMMessageTransfer.this.m12479a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12479a() {
        Handler handler = this.f16866h;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f16866h = null;
        }
        HandlerThread handlerThread = this.f16867i;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    public void evaluateJavascriptWebView(WebViewEngine webViewEngine, String str, WebViewEngine.WebViewEngineValueCallback<String> webViewEngineValueCallback) {
        UIHandlerUtil.runOnUiThread(new Runnable(str, webViewEngineValueCallback) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ WebViewEngine.WebViewEngineValueCallback f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                WebViewEngine.this.evaluateJavascript(this.f$1, this.f$2);
            }
        });
    }

    /* renamed from: a */
    private JSONObject m12478a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "payload", (Object) jSONObject);
        JSONUtil.put(jSONObject2, "event", (Object) str);
        return jSONObject2;
    }

    /* renamed from: b */
    private JSONObject m12486b(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "payload", (Object) jSONObject);
        JSONUtil.put(jSONObject2, "invokeId", (Object) str);
        return jSONObject2;
    }
}
