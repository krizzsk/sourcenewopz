package com.didi.dimina.starbox.websocket;

import android.os.Handler;
import android.text.TextUtils;
import com.didi.dimina.container.util.LogUtil;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class V8Debugger {

    /* renamed from: f */
    private static final int f18183f = 0;

    /* renamed from: g */
    private static final int f18184g = 1;

    /* renamed from: h */
    private static final int f18185h = 2;

    /* renamed from: i */
    private static final String f18186i = "Runtime.runIfWaitingForDebugger";

    /* renamed from: j */
    private static final String f18187j = "Debugger.paused";

    /* renamed from: k */
    private static final String f18188k = "Debugger.resumed";

    /* renamed from: l */
    private static final String f18189l = "Debugger.resume";

    /* renamed from: m */
    private static final String f18190m = "Debugger.pause";

    /* renamed from: n */
    private static final String f18191n = "Debugger.enable";

    /* renamed from: o */
    private static final String f18192o = "Debugger.disable";

    /* renamed from: p */
    private static final String f18193p = "chrome_socket_closed";

    /* renamed from: q */
    private static final String f18194q = "websocket";

    /* renamed from: a */
    private final V8InspectorDelegate f18195a;

    /* renamed from: b */
    private final Handler f18196b;

    /* renamed from: c */
    private final Map<String, JSONObject> f18197c = Collections.synchronizedMap(new LinkedHashMap());

    /* renamed from: d */
    private final AtomicInteger f18198d = new AtomicInteger(0);

    /* renamed from: e */
    private int f18199e = 0;

    public V8Debugger(V8InspectorDelegate v8InspectorDelegate, Handler handler) {
        this.f18195a = v8InspectorDelegate;
        this.f18196b = handler;
    }

    public void onMessage(String str) {
        if (TextUtils.equals(f18193p, str)) {
            sendMessage2V8(f18192o, (JSONObject) null);
            return;
        }
        ChromeMessage newInstance = ChromeMessage.newInstance(str);
        if (newInstance != null) {
            if (TextUtils.equals(newInstance.method, f18191n)) {
                this.f18199e = 1;
            }
            sendMessage2V8(newInstance.method, newInstance.params);
        }
    }

    public void sendMessage2V8(final String str, final JSONObject jSONObject) {
        if (this.f18199e == 2 || this.f18195a == null) {
            synchronized (this.f18197c) {
                this.f18197c.put(str, jSONObject);
            }
            return;
        }
        Handler handler = this.f18196b;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    V8Debugger.this.m13569a(str, jSONObject);
                }
            });
        } else {
            m13569a(str, jSONObject);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13569a(String str, JSONObject jSONObject) {
        Object obj;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                if (jSONObject.has("id")) {
                    obj = jSONObject.remove("id");
                    jSONObject2.put("id", obj);
                    jSONObject2.put("method", str);
                    jSONObject2.put("params", jSONObject);
                    this.f18195a.dispatchProtocolMessage(jSONObject2.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        obj = Integer.valueOf(this.f18198d.incrementAndGet());
        jSONObject2.put("id", obj);
        jSONObject2.put("method", str);
        jSONObject2.put("params", jSONObject);
        this.f18195a.dispatchProtocolMessage(jSONObject2.toString());
    }

    public final void recordMsgState(String str) {
        V8Response newInstance = V8Response.newInstance(str);
        if (newInstance != null) {
            if (!newInstance.method.equalsIgnoreCase("Debugger.scriptParsed")) {
                log("status：" + this.f18199e + ",onResponse: " + str);
            } else if (!TextUtils.isEmpty(newInstance.params.optString("url"))) {
                log("status：" + this.f18199e + ",onResponse: " + str);
            }
        }
        String str2 = newInstance != null ? newInstance.method : null;
        if (str2 != null) {
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 100879227) {
                if (hashCode == 720033066 && str2.equals(f18188k)) {
                    c = 1;
                }
            } else if (str2.equals(f18187j)) {
                c = 0;
            }
            if (c != 0) {
                if (c == 1 && this.f18199e == 2) {
                    this.f18199e = 1;
                }
            } else if (this.f18199e == 0) {
                m13569a(f18189l, (JSONObject) null);
            } else if (newInstance.params != null) {
                this.f18199e = 2;
            }
        }
    }

    public final void waitFrontendMessageOnPause() {
        if (this.f18199e != 2) {
            log("Debugger paused without connection.  Resuming J2V8");
            m13569a(f18189l, (JSONObject) null);
            return;
        }
        synchronized (this.f18197c) {
            if (!this.f18197c.isEmpty()) {
                for (Map.Entry next : this.f18197c.entrySet()) {
                    m13570b((String) next.getKey(), (JSONObject) next.getValue());
                }
                this.f18197c.clear();
            }
        }
    }

    /* renamed from: b */
    private void m13570b(String str, JSONObject jSONObject) {
        m13569a(str, jSONObject);
    }

    public static void log(String str) {
        LogUtil.m13410e("websocket", str);
    }

    public static class ChromeMessage {

        /* renamed from: id */
        public Long f18200id;
        public String method;
        public JSONObject params;

        public static ChromeMessage newInstance(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ChromeMessage chromeMessage = new ChromeMessage();
                chromeMessage.f18200id = Long.valueOf(jSONObject.optLong("id"));
                chromeMessage.method = jSONObject.optString("method");
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                chromeMessage.params = optJSONObject;
                if (optJSONObject == null) {
                    chromeMessage.params = new JSONObject();
                }
                chromeMessage.params.put("id", chromeMessage.f18200id);
                return chromeMessage;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static class V8Response {

        /* renamed from: id */
        public int f18201id;
        public String method;
        public JSONObject params;
        public JSONObject result;

        public static V8Response newInstance(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                V8Response v8Response = new V8Response();
                v8Response.f18201id = jSONObject.optInt("id");
                v8Response.method = jSONObject.optString("method");
                v8Response.result = jSONObject.optJSONObject("result");
                v8Response.params = jSONObject.optJSONObject("params");
                return v8Response;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
