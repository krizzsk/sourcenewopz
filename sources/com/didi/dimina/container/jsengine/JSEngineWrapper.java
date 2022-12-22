package com.didi.dimina.container.jsengine;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.jsengine.JSEngineWrapper;
import com.didi.dimina.container.jsengine.method.JSCallback;
import com.didi.dimina.container.jsengine.web.WebSystemJSEngine;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.mina.DMMemoryManager;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.CoreDottingExtra;
import com.didi.dimina.container.util.DebugKitStoreUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import java.util.concurrent.locks.LockSupport;

public class JSEngineWrapper {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final StringBuilder f16817e = new StringBuilder();

    /* renamed from: f */
    private static final JSEngineFatalCallback f16818f = new JSEngineFatalCallback() {
        private static final int MAX_LENGTH = 20480;

        public void callback(String str) {
            if (str != null) {
                int length = JSEngineWrapper.f16817e.length() + str.length();
                if (length > 20480) {
                    JSEngineWrapper.f16817e.delete(0, length - 20480);
                }
                StringBuilder a = JSEngineWrapper.f16817e;
                a.append(str);
                a.append("\n");
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final DMMina f16819a;

    /* renamed from: b */
    private final JSEngine f16820b;

    /* renamed from: c */
    private final JSExceptionCallback f16821c = new JSExceptionCallback() {
        public void onJSException(Exception exc) {
            String stackTraceString = Log.getStackTraceString(exc);
            LogUtil.eRelease("JS Exception", stackTraceString);
            if (!TextUtils.isEmpty(stackTraceString)) {
                JSEngineWrapper.this.f16819a.getMessageTransfer().sendMessageToServiceFromNative("onAppError", new MessageWrapperBuilder().data(stackTraceString).build());
            }
        }
    };

    /* renamed from: d */
    private final JSEngineCallback f16822d = new JSEngineCallback() {
        public int onNearHeapLimit(int i, int i2) {
            LogUtil.wRelease("JS Engine Callback", "curHeapLimit:" + i + " initHeapLimit:" + i2);
            return DMMemoryManager.getInstance().onJSEngineNearHeapLimit(JSEngineWrapper.this.f16819a, i, i2);
        }
    };

    /* renamed from: g */
    private final JSEngineFatalCallback f16823g = new JSEngineFatalCallback() {
        public void callback(String str) {
            TraceUtil.traceV8Fatal("error:" + str + "  v8 msg:" + JSEngineWrapper.f16817e.toString());
            JSEngineWrapper.f16817e.delete(0, JSEngineWrapper.f16817e.length());
            UIHandlerUtil.post(new Runnable() {
                public final void run() {
                    JSEngineWrapper.C74744.this.lambda$callback$0$JSEngineWrapper$4();
                }
            });
            LogUtil.m13410e("catchWhenJsError", "catchWhenJsError catchWhenJsError");
            LockSupport.park();
        }

        public /* synthetic */ void lambda$callback$0$JSEngineWrapper$4() {
            JSEngineWrapper.this.f16819a.getConfig().getCallbackConfig().getRelaunchCallback().relaunch(JSEngineWrapper.this.f16819a);
        }
    };

    public JSEngineWrapper(int i) {
        this.f16819a = DMMinaPool.get(i);
        JSEngine b = m12456b();
        this.f16820b = b;
        b.setJSExceptionCallback(this.f16821c);
        this.f16820b.setJSEngineCallback(this.f16822d);
        this.f16820b.setOnFatalErrorCallback(this.f16823g);
        this.f16820b.setGlobalOnFatalErrorCallback(this.f16823g);
        this.f16820b.setOnFatalPrinter(f16818f);
        this.f16820b.setDMMina(this.f16819a);
    }

    public void executeScript(String str) {
        this.f16820b.executeScript(str);
    }

    public void executeScriptFile(String str, String str2, IDMCommonAction<Void> iDMCommonAction) {
        executeScriptFile(str, str2, -1, (String) null, (String) null, (String) null, (String) null, iDMCommonAction);
    }

    public void executeScriptFile(String str, String str2, int i, String str3, String str4, String str5, String str6, IDMCommonAction<Void> iDMCommonAction) {
        this.f16820b.executeScriptFile(str, str2, i, str3, str4, str5, str6, iDMCommonAction);
    }

    /* renamed from: b */
    private JSEngine m12456b() {
        JSEngine createJSEngine = this.f16819a.getConfig().getLaunchConfig().getEngineFactory().createJSEngine();
        if (createJSEngine == null || DebugKitStoreUtil.getWebViewJSEngineEnabled()) {
            createJSEngine = new WebSystemJSEngine();
        }
        String name = createJSEngine.getClass().getName();
        TraceUtil.trackEventCoreDotting(this.f16819a.getMinaIndex(), Constant.CORE_DOTTING.LAUNCH_ENGINE_CREATE, CoreDottingExtra.create().with("engine", name).toInfo());
        TraceUtil.traceEngineType(this.f16819a.getMinaIndex(), name);
        return createJSEngine;
    }

    public void release(boolean z) {
        this.f16820b.release(z);
    }

    public void registerCallBack(String str, JSCallback jSCallback) {
        this.f16820b.registerCallBack("", str, jSCallback);
    }

    public void registerCallBack(String str, String str2, JSCallback jSCallback) {
        this.f16820b.registerCallBack(str, str2, jSCallback);
    }

    public Looper getLooper() {
        return this.f16820b.getLooper();
    }

    public void onLowMemory() {
        this.f16820b.onLowMemory();
    }

    public void notifyMemoryPress(JSEngine.PressLevel pressLevel) {
        this.f16820b.onMemoryPressNotify(pressLevel);
    }

    public void registerOnUnHandledRejection() {
        this.f16820b.registerOnUnHandledRejection();
    }

    public JSEngine getRealJSEngine() {
        return this.f16820b;
    }
}
