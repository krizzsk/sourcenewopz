package com.didi.dimina.container.util;

import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J(\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0007J*\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001e\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/dimina/container/util/CallBackUtil;", "", "()V", "onFail", "", "data", "", "", "outerErrMsg", "outerCallback", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "Lorg/json/JSONObject;", "errMsg", "callback", "onSuccess", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CallBackUtil.kt */
public final class CallBackUtil {
    public static final CallBackUtil INSTANCE = new CallBackUtil();

    @JvmStatic
    public static final void onFail(String str, CallbackFunction callbackFunction) {
        onFail$default((JSONObject) null, str, callbackFunction, 1, (Object) null);
    }

    @JvmStatic
    public static final void onSuccess(CallbackFunction callbackFunction) {
        onSuccess$default((JSONObject) null, callbackFunction, 1, (Object) null);
    }

    private CallBackUtil() {
    }

    @JvmStatic
    public static final void onSuccess(Map<String, ? extends Object> map, CallbackFunction callbackFunction) {
        if (map == null || !(!map.isEmpty())) {
            onSuccess$default((JSONObject) null, callbackFunction, 1, (Object) null);
        } else {
            onSuccess(new JSONObject(map), callbackFunction);
        }
    }

    public static /* synthetic */ void onSuccess$default(JSONObject jSONObject, CallbackFunction callbackFunction, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = null;
        }
        onSuccess(jSONObject, callbackFunction);
    }

    @JvmStatic
    public static final void onSuccess(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                JSONUtil.put(jSONObject2, "data", (Object) jSONObject);
            }
            JSONUtil.put(jSONObject2, "success", true);
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    @JvmStatic
    public static final void onFail(Map<String, ? extends Object> map, String str, CallbackFunction callbackFunction) {
        if (map == null || !(!map.isEmpty())) {
            onFail$default((JSONObject) null, str, callbackFunction, 1, (Object) null);
        } else {
            onFail(new JSONObject(map), str, callbackFunction);
        }
    }

    public static /* synthetic */ void onFail$default(JSONObject jSONObject, String str, CallbackFunction callbackFunction, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = null;
        }
        onFail(jSONObject, str, callbackFunction);
    }

    @JvmStatic
    public static final void onFail(JSONObject jSONObject, String str, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                JSONUtil.put(jSONObject2, "data", (Object) jSONObject);
            }
            JSONUtil.put(jSONObject2, "success", false);
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                LogUtil.m13413w("callback errMsg is empty");
                JSONUtil.put(jSONObject2, DMWebSocketListener.KEY_ERR_MSG, (Object) "empty errMsg");
            } else {
                JSONUtil.put(jSONObject2, DMWebSocketListener.KEY_ERR_MSG, (Object) str);
            }
            callbackFunction.onCallBack(jSONObject2);
        }
    }
}
