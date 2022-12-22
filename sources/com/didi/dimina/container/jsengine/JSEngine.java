package com.didi.dimina.container.jsengine;

import android.os.Looper;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.jsengine.method.JSCallback;
import com.didi.dimina.container.mina.IDMCommonAction;

public interface JSEngine {

    /* renamed from: com.didi.dimina.container.jsengine.JSEngine$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$registerOnUnHandledRejection(JSEngine jSEngine) {
        }

        public static void $default$setDMMina(JSEngine jSEngine, DMMina dMMina) {
        }
    }

    void executeScript(String str);

    void executeScript(String str, String str2, IDMCommonAction<Void> iDMCommonAction);

    void executeScriptFile(String str, String str2, int i, String str3, String str4, String str5, String str6, IDMCommonAction<Void> iDMCommonAction);

    Looper getLooper();

    void onLowMemory();

    void onMemoryPressNotify(PressLevel pressLevel);

    void registerCallBack(String str, String str2, JSCallback jSCallback);

    void registerOnUnHandledRejection();

    void release(boolean z);

    void setDMMina(DMMina dMMina);

    void setGlobalOnFatalErrorCallback(JSEngineFatalCallback jSEngineFatalCallback);

    void setJSEngineCallback(JSEngineCallback jSEngineCallback);

    void setJSExceptionCallback(JSExceptionCallback jSExceptionCallback);

    void setOnFatalErrorCallback(JSEngineFatalCallback jSEngineFatalCallback);

    void setOnFatalPrinter(JSEngineFatalCallback jSEngineFatalCallback);

    public enum PressLevel {
        CRITICAL(2),
        MODERATE(1),
        NONE(0);
        
        public final int value;

        private PressLevel(int i) {
            this.value = i;
        }
    }
}
