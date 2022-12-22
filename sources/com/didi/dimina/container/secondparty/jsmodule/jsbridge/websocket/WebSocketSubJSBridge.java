package com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import didihttp.WebSocket;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J\u001c\u0010\u0014\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/WebSocketSubJSBridge;", "", "mDmMina", "Lcom/didi/dimina/container/DMMina;", "(Lcom/didi/dimina/container/DMMina;)V", "buildRequestOptions", "Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/RequestOptions;", "params", "Lorg/json/JSONObject;", "createSocketTask", "", "callback", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "operateSocketTask", "optClose", "taskId", "", "code", "", "reason", "optSend", "optString", "Companion", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: WebSocketSubJSBridge.kt */
public final class WebSocketSubJSBridge {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final String f17288b = "WebSocketSubJSBridge";

    /* renamed from: c */
    private static final String f17289c = "taskId";

    /* renamed from: d */
    private static final String f17290d = "options";

    /* renamed from: e */
    private static final String f17291e = "url";

    /* renamed from: f */
    private static final String f17292f = "protocols";

    /* renamed from: g */
    private static final String f17293g = "header";

    /* renamed from: h */
    private static final String f17294h = "timeout";

    /* renamed from: i */
    private static final String f17295i = "perMessageDeflate";

    /* renamed from: j */
    private static final String f17296j = "operationType";

    /* renamed from: k */
    private static final String f17297k = "extra";

    /* renamed from: l */
    private static final String f17298l = "code";

    /* renamed from: m */
    private static final String f17299m = "reason";

    /* renamed from: n */
    private static final String f17300n = "data";

    /* renamed from: o */
    private static final String f17301o = "send";

    /* renamed from: p */
    private static final String f17302p = "close";

    /* renamed from: a */
    private final DMMina f17303a;

    public WebSocketSubJSBridge(DMMina dMMina) {
        Intrinsics.checkParameterIsNotNull(dMMina, "mDmMina");
        this.f17303a = dMMina;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/WebSocketSubJSBridge$Companion;", "", "()V", "KEY_CODE", "", "KEY_DATA", "KEY_EXTRA", "KEY_HEADER", "KEY_OPERATION_TYPE", "KEY_OPTIONS", "KEY_PER_MESSAGE_DEFLATE", "KEY_PROTOCOLS", "KEY_REASON", "KEY_TASK_ID", "KEY_TIMEOUT", "KEY_URL", "OPT_CLOSE", "OPT_SEND", "TAG", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: WebSocketSubJSBridge.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void createSocketTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        if (jSONObject != null) {
            String optString = jSONObject.optString("taskId");
            LogUtil.iRelease(f17288b, "create socket task " + optString);
            CharSequence charSequence = optString;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                SocketTaskManager.INSTANCE.createSocketTask(m12842a(jSONObject), new DMWebSocketListener(this.f17303a, optString));
                CallBackUtil.onSuccess$default((JSONObject) null, callbackFunction, 1, (Object) null);
                return;
            }
            CallBackUtil.onFail$default((JSONObject) null, "taskId is is Null Or Blank", callbackFunction, 1, (Object) null);
            return;
        }
        CallBackUtil.onFail$default((JSONObject) null, "params is is Null", callbackFunction, 1, (Object) null);
    }

    public final void operateSocketTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(callbackFunction, "callback");
        if (jSONObject != null) {
            LogUtil.iRelease(f17288b, "operateSocketTask socket params:" + jSONObject);
            String optString = jSONObject.optString("taskId");
            String optString2 = jSONObject.optString(f17296j);
            LogUtil.iRelease(f17288b, "operateSocketTask socket task " + optString + " action: " + optString2);
            JSONObject optJSONObject = jSONObject.optJSONObject("extra");
            if (optString2 != null) {
                int hashCode = optString2.hashCode();
                String str = null;
                if (hashCode != 3526536) {
                    if (hashCode == 94756344 && optString2.equals("close")) {
                        Integer valueOf = optJSONObject != null ? Integer.valueOf(optJSONObject.optInt("code")) : null;
                        if (optJSONObject != null) {
                            str = optJSONObject.optString("reason");
                        }
                        m12844a(optString, valueOf != null ? valueOf.intValue() : WebSocketCodes.CLOSE_NORMAL.getCode(), str);
                        CallBackUtil.onFail(jSONObject, "", callbackFunction);
                    }
                } else if (optString2.equals(f17301o)) {
                    if (optJSONObject != null) {
                        str = optJSONObject.optString("data");
                    }
                    m12845a(optString, str);
                    CallBackUtil.onSuccess(new JSONObject(), callbackFunction);
                }
            }
            if (jSONObject != null) {
                return;
            }
        }
        LogUtil.eRelease(f17288b, "operateSocketTask params is null");
        Unit unit = Unit.INSTANCE;
    }

    /* renamed from: a */
    private final RequestOptions m12842a(JSONObject jSONObject) {
        ArrayList<String> arrayList = null;
        String optString = jSONObject != null ? jSONObject.optString("options") : null;
        LogUtil.iRelease(f17288b, "options is: " + optString);
        JSONObject jSONObject2 = JSONUtil.toJSONObject(optString);
        String optString2 = jSONObject2.optString("url");
        LogUtil.iRelease(f17288b, "server url is: " + optString2);
        long optLong = jSONObject2.optLong("timeout");
        boolean optBoolean = jSONObject2.optBoolean(f17295i);
        String optString3 = jSONObject2.optString("header");
        CharSequence charSequence = optString3;
        boolean z = false;
        HashMap<String, V> jsonToMapSimple = !(charSequence == null || StringsKt.isBlank(charSequence)) ? JSONUtil.jsonToMapSimple(optString3, String.class, String.class) : null;
        String optString4 = jSONObject2.optString(f17292f);
        CharSequence charSequence2 = optString4;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            z = true;
        }
        if (!z) {
            arrayList = JSONUtil.jsonToList(optString4, String.class);
        }
        return new RequestOptions(optString2, arrayList, jsonToMapSimple, optLong, false, optBoolean, 16, (DefaultConstructorMarker) null);
    }

    /* renamed from: a */
    static /* synthetic */ void m12843a(WebSocketSubJSBridge webSocketSubJSBridge, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = WebSocketCodes.CLOSE_NORMAL.getCode();
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        webSocketSubJSBridge.m12844a(str, i, str2);
    }

    /* renamed from: a */
    private final void m12844a(String str, int i, String str2) {
        SocketTask socketTask;
        WebSocket webSocket;
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence)) && (socketTask = SocketTaskManager.INSTANCE.getSocketTask(str)) != null && (webSocket = socketTask.getWebSocket()) != null) {
            webSocket.close(i, str2);
        }
    }

    /* renamed from: a */
    private final void m12845a(String str, String str2) {
        WebSocket webSocket;
        LogUtil.iRelease(f17288b, "optSend  " + str2);
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            SocketTask socketTask = SocketTaskManager.INSTANCE.getSocketTask(str);
            if (str2 != null && socketTask != null && (webSocket = socketTask.getWebSocket()) != null) {
                webSocket.send(str2);
            }
        }
    }
}
