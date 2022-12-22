package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.IDMVConsole;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import org.json.JSONObject;

public class VConsoleJSBridge {

    /* renamed from: a */
    private final WebViewEngine f16667a;

    /* renamed from: b */
    private final IDMVConsole f16668b;

    /* renamed from: c */
    private final boolean f16669c;

    public VConsoleJSBridge(WebViewEngine webViewEngine) {
        this.f16667a = webViewEngine;
        DMMina dmMina = webViewEngine.getDmMina();
        this.f16668b = dmMina.getVConsoleManager();
        this.f16669c = !(dmMina.getVConsoleManager() instanceof IDMVConsole.NOVConsole);
        LogUtil.m13411i("VConsoleJSBridge init");
    }

    public void ifOpenVConsole(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("VConsoleJSBridge ifOpenVconsole");
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("open", this.f16669c);
            CallBackUtil.onSuccess(jSONObject2, callbackFunction);
        } catch (Exception unused) {
            CallBackUtil.onFail("获取VConsole开启信息失败", callbackFunction);
        }
    }

    public void vConsoleReady(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("VConsoleJSBridge vConsoleReady");
        if (this.f16669c) {
            this.f16668b.inspectVConsole(this.f16667a);
        }
        CallBackUtil.onSuccess(callbackFunction);
    }
}
