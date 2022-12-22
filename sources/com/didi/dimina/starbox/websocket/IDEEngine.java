package com.didi.dimina.starbox.websocket;

import android.os.Looper;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.debug.IWebSocketMsgSender;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.jsengine.JSEngineCallback;
import com.didi.dimina.container.jsengine.JSEngineFatalCallback;
import com.didi.dimina.container.jsengine.JSExceptionCallback;
import com.didi.dimina.container.jsengine.method.JSCallback;
import com.didi.dimina.container.mina.IDMCommonAction;

public class IDEEngine implements JSEngine {

    /* renamed from: a */
    private IWebSocketMsgSender f18177a;

    /* renamed from: b */
    private DMMina f18178b;

    public void executeScript(String str, String str2, IDMCommonAction<Void> iDMCommonAction) {
    }

    public void executeScriptFile(String str, String str2, int i, String str3, String str4, String str5, String str6, IDMCommonAction<Void> iDMCommonAction) {
    }

    public Looper getLooper() {
        return null;
    }

    public void onLowMemory() {
    }

    public void onMemoryPressNotify(JSEngine.PressLevel pressLevel) {
    }

    public void registerCallBack(String str, String str2, JSCallback jSCallback) {
    }

    public void registerOnUnHandledRejection() {
    }

    public void setGlobalOnFatalErrorCallback(JSEngineFatalCallback jSEngineFatalCallback) {
    }

    public void setJSEngineCallback(JSEngineCallback jSEngineCallback) {
    }

    public void setJSExceptionCallback(JSExceptionCallback jSExceptionCallback) {
    }

    public void setOnFatalErrorCallback(JSEngineFatalCallback jSEngineFatalCallback) {
    }

    public void setOnFatalPrinter(JSEngineFatalCallback jSEngineFatalCallback) {
    }

    public void setDMMina(DMMina dMMina) {
        this.f18178b = dMMina;
        this.f18177a = dMMina.getWebSocketMsgSender();
        this.f18178b.getMessageTransfer().enableServiceMessageTransform();
    }

    public void executeScript(String str) {
        this.f18177a.doSend(str);
    }

    public void release(boolean z) {
        this.f18177a.destroy();
    }
}
