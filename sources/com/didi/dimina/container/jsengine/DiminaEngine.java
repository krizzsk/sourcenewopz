package com.didi.dimina.container.jsengine;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.jsengine.method.JSCallback;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.v8util.V8TrackUtil;
import com.didi.dimina.p108v8.C7781V8;
import com.didi.dimina.p108v8.JavaCallback;
import com.didi.dimina.p108v8.V8Array;
import com.didi.dimina.p108v8.V8Object;
import com.didi.dimina.p108v8.inspector.V8Inspector;
import com.didi.dimina.p108v8.inspector.V8InspectorDelegate;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class DiminaEngine implements JSEngine {
    private static final String JS_ON_UN_HANDLED_REJECTION_FUNC_NAME = "onunhandledrejectionForNative";
    private static final String TAG = "DiminaEngine";
    private final ConcurrentHashMap<String, Boolean> cacheDeleteMap = new ConcurrentHashMap<>();
    private final String codeCacheRootFilePath = FileUtil.getInternalFilesDirectory(Dimina.getConfig().getApp(), "").toString();
    public volatile boolean isRelease;
    /* access modifiers changed from: private */
    public Handler jsHandler;
    /* access modifiers changed from: private */
    public final HandlerThread jsThread = new HandlerThread("Dimina V8 Task #" + System.currentTimeMillis()) {
        public void run() {
            try {
                super.run();
            } catch (Throwable th) {
                LogUtil.m13409e("V8 Task error ---------------------------------------------");
                th.printStackTrace();
                try {
                    TraceUtil.trackEventError(TraceUtil.MINA_INDEX_UN_KNOW, "JSEngineException", 1010, Log.getStackTraceString(th));
                } catch (Exception unused) {
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public JSExceptionCallback mJSExceptionCallback;
    /* access modifiers changed from: private */
    public C7781V8 mV8Runtime;

    public /* synthetic */ void setDMMina(DMMina dMMina) {
        JSEngine.CC.$default$setDMMina(this, dMMina);
    }

    static {
        C7781V8.oomCallback = new C7781V8.ErrorOOMCallback() {
            public void onErrorOOM(String str, boolean z) {
                LogUtil.eRelease(DiminaEngine.TAG, "oom info:" + str + " heapoom:" + z);
            }
        };
    }

    public DiminaEngine() {
        LogUtil.iRelease(TAG, "JSEngine: DiminaEngine");
        this.isRelease = true;
        this.jsThread.start();
        Handler handler = new Handler(getLooper());
        this.jsHandler = handler;
        handler.post(new Runnable() {
            public void run() {
                C7781V8 unused = DiminaEngine.this.mV8Runtime = C7781V8.createV8Runtime("Dimina", (String) null);
                DiminaEngine.this.isRelease = false;
                if (Dimina.getConfig().isDebug()) {
                    DiminaEngine.this.enableV8RunIfWaitingForDebugger();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void enableV8RunIfWaitingForDebugger() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", 0);
            jSONObject.put("method", "Runtime.runIfWaitingForDebugger");
            jSONObject.put("params", (Object) null);
            V8Inspector.createV8Inspector(this.mV8Runtime, new V8InspectorDelegate() {
                public void waitFrontendMessageOnPause() {
                }

                public void onResponse(String str) {
                    LogUtil.m13409e("websocket: onResponse:" + str);
                }
            }).dispatchProtocolMessage(jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release(boolean z) {
        Handler handler = this.jsHandler;
        if (handler != null) {
            if (z) {
                this.isRelease = true;
                this.jsHandler.removeCallbacksAndMessages((Object) null);
                this.jsHandler.post(new Runnable() {
                    public void run() {
                        DiminaEngine.this.mV8Runtime.release(false);
                        UIHandlerUtil.post(new Runnable() {
                            public void run() {
                                Handler unused = DiminaEngine.this.jsHandler = null;
                                if (Build.VERSION.SDK_INT >= 18) {
                                    DiminaEngine.this.jsThread.quitSafely();
                                } else {
                                    DiminaEngine.this.jsThread.quit();
                                }
                            }
                        });
                    }
                });
                return;
            }
            handler.post(new Runnable() {
                public void run() {
                    DiminaEngine.this.isRelease = true;
                    DiminaEngine.this.jsHandler.removeCallbacksAndMessages((Object) null);
                    DiminaEngine.this.jsHandler.postDelayed(new Runnable() {
                        public void run() {
                            DiminaEngine.this.mV8Runtime.release(false);
                            UIHandlerUtil.post(new Runnable() {
                                public void run() {
                                    if (Build.VERSION.SDK_INT >= 18) {
                                        DiminaEngine.this.jsThread.quitSafely();
                                    } else {
                                        DiminaEngine.this.jsThread.quit();
                                    }
                                }
                            });
                        }
                    }, 5000);
                }
            });
        }
    }

    public void executeScript(String str) {
        executeScript(str, (String) null, (IDMCommonAction<Void>) null);
    }

    public void executeScript(final String str, final String str2, final IDMCommonAction<Void> iDMCommonAction) {
        Handler handler = this.jsHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (!DiminaEngine.this.isRelease) {
                        try {
                            if (TextUtils.isEmpty(str2)) {
                                DiminaEngine.this.mV8Runtime.executeVoidScript(str);
                            } else {
                                DiminaEngine.this.mV8Runtime.executeVoidScript(str, str2, 0);
                            }
                            if (iDMCommonAction != null) {
                                iDMCommonAction.callback(null);
                            }
                        } catch (Exception e) {
                            if (DiminaEngine.this.mJSExceptionCallback != null) {
                                DiminaEngine.this.mJSExceptionCallback.onJSException(e);
                            }
                            e.printStackTrace();
                            IDMCommonAction iDMCommonAction = iDMCommonAction;
                            if (iDMCommonAction != null) {
                                iDMCommonAction.callback(null);
                            }
                        }
                    }
                }
            });
        }
    }

    public void executeScriptFile(String str, String str2, int i, String str3, String str4, String str5, String str6, IDMCommonAction<Void> iDMCommonAction) {
        Handler handler = this.jsHandler;
        if (handler != null) {
            final String str7 = str2;
            final String str8 = str4;
            final String str9 = str5;
            final String str10 = str3;
            final String str11 = str;
            final String str12 = str6;
            final int i2 = i;
            final IDMCommonAction<Void> iDMCommonAction2 = iDMCommonAction;
            handler.post(new Runnable() {
                public void run() {
                    if (!DiminaEngine.this.isRelease) {
                        try {
                            StringBuilder sb = new StringBuilder("");
                            if (!TextUtils.isEmpty(str7)) {
                                sb.append(str7);
                            }
                            if (!TextUtils.isEmpty(str8)) {
                                sb.append(str8);
                            }
                            if (!TextUtils.isEmpty(str9)) {
                                sb.append(str9);
                            }
                            if (TextUtils.isEmpty(str10)) {
                                DiminaEngine.this.mV8Runtime.executeVoidScript(str11, sb.toString(), 0);
                            } else {
                                String access$500 = DiminaEngine.this.checkFilePathAndDeleteOldVersionFile(str10, str12);
                                if (!TextUtils.isEmpty(access$500)) {
                                    String replaceAll = str8.replaceAll("/", "_");
                                    String replaceAll2 = str9.replaceAll("/", "_").replaceAll(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX, "");
                                    C7781V8 access$000 = DiminaEngine.this.mV8Runtime;
                                    String str = str11;
                                    String sb2 = sb.toString();
                                    access$000.executeVoidScriptFileWithCodeCache(str, sb2, access$500 + replaceAll + replaceAll2, DiminaEngine.this.buildParam(i2, str10, str8, str9, str12));
                                } else {
                                    DiminaEngine.this.mV8Runtime.executeVoidScript(str11, sb.toString(), 0);
                                }
                            }
                            if (iDMCommonAction2 != null) {
                                iDMCommonAction2.callback(null);
                            }
                        } catch (Exception e) {
                            if (DiminaEngine.this.mJSExceptionCallback != null) {
                                DiminaEngine.this.mJSExceptionCallback.onJSException(e);
                            }
                            e.printStackTrace();
                            IDMCommonAction iDMCommonAction = iDMCommonAction2;
                            if (iDMCommonAction != null) {
                                iDMCommonAction.callback(null);
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> buildParam(int i, String str, String str2, String str3, String str4) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(V8TrackUtil.MINA_INDEX_KEY, Integer.valueOf(i));
        hashMap.put("apid", str);
        hashMap.put("mna", str2);
        hashMap.put("fna", str3);
        hashMap.put("vna", str4);
        return hashMap;
    }

    /* access modifiers changed from: private */
    public String checkFilePathAndDeleteOldVersionFile(String str, String str2) {
        String str3 = this.codeCacheRootFilePath + File.separator + DMSandboxHelper.DIMINA + File.separator + "dm_codecache" + File.separator + str + File.separator;
        String str4 = str3 + str2 + File.separator;
        File file = new File(str4);
        File file2 = new File(str3);
        if (!file.exists()) {
            return file.mkdirs() ? str4 : "";
        }
        if (!this.cacheDeleteMap.containsKey(str)) {
            this.cacheDeleteMap.put(str, true);
            if (file2.isDirectory()) {
                for (File file3 : file2.listFiles()) {
                    if (!(file3.toString() + File.separator).contains(str4)) {
                        FileUtil.delete(file3.toString());
                    }
                }
            }
        }
        return str4;
    }

    public void registerCallBack(final String str, final String str2, final JSCallback jSCallback) {
        if (!TextUtils.isEmpty(str2) && jSCallback != null) {
            if (!TextUtils.isEmpty(str)) {
                this.jsHandler.post(new Runnable() {
                    public void run() {
                        if (!DiminaEngine.this.mV8Runtime.contains(str)) {
                            DiminaEngine.this.mV8Runtime.executeScript("var " + str + " = {};");
                        }
                    }
                });
            }
            this.jsHandler.post(new Runnable() {
                public void run() {
                    V8Object v8Object;
                    if (TextUtils.isEmpty(str)) {
                        v8Object = DiminaEngine.this.mV8Runtime;
                    } else {
                        v8Object = DiminaEngine.this.mV8Runtime.getV8Object(str);
                        if (v8Object.isUndefined()) {
                            return;
                        }
                    }
                    v8Object.registerJavaMethod((JavaCallback) new JavaCallback() {
                        public Object invoke(V8Object v8Object, V8Array v8Array) {
                            return DiminaObjectAdapter.toV8Object(DiminaEngine.this.mV8Runtime, jSCallback.callback(new DiminaArray(DiminaEngine.this.mV8Runtime, v8Array)));
                        }
                    }, str2);
                }
            });
        }
    }

    public void setJSExceptionCallback(JSExceptionCallback jSExceptionCallback) {
        this.mJSExceptionCallback = jSExceptionCallback;
    }

    public Looper getLooper() {
        return this.jsThread.getLooper();
    }

    public void onLowMemory() {
        Handler handler = this.jsHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (!DiminaEngine.this.isRelease && DiminaEngine.this.mV8Runtime != null) {
                        DiminaEngine.this.mV8Runtime.lowMemoryNotification();
                    }
                }
            });
        }
    }

    public void onMemoryPressNotify(final JSEngine.PressLevel pressLevel) {
        Handler handler = this.jsHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (!DiminaEngine.this.isRelease && DiminaEngine.this.mV8Runtime != null) {
                        DiminaEngine.this.mV8Runtime.memoryPressureNotification(pressLevel.value);
                    }
                }
            });
        }
    }

    public void setJSEngineCallback(final JSEngineCallback jSEngineCallback) {
        Handler handler = this.jsHandler;
        if (handler != null && jSEngineCallback != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (!DiminaEngine.this.isRelease && DiminaEngine.this.mV8Runtime != null) {
                        DiminaEngine.this.mV8Runtime.nearHeapLimitCallback = new C7781V8.NearHeapLimitCallback() {
                            public int onNearHeapLimit(int i, int i2) {
                                return jSEngineCallback.onNearHeapLimit(i, i2);
                            }
                        };
                    }
                }
            });
        }
    }

    public void setOnFatalErrorCallback(final JSEngineFatalCallback jSEngineFatalCallback) {
        Handler handler;
        if (jSEngineFatalCallback != null && (handler = this.jsHandler) != null) {
            handler.post(new Runnable() {
                public void run() {
                    DiminaEngine.this.mV8Runtime.setOnFatalErrorCallback(new C7781V8.OnFatalErrorCallback() {
                        public void onFatal(String str, String str2) {
                            Runtime.getRuntime().gc();
                            JSEngineFatalCallback jSEngineFatalCallback = jSEngineFatalCallback;
                            jSEngineFatalCallback.callback(str + " - " + str2);
                        }
                    });
                }
            });
        }
    }

    public void setGlobalOnFatalErrorCallback(final JSEngineFatalCallback jSEngineFatalCallback) {
        if (jSEngineFatalCallback != null) {
            C7781V8.onGlobalFatalErrorCallback = new C7781V8.OnFatalErrorCallback() {
                public void onFatal(String str, String str2) {
                    Runtime.getRuntime().gc();
                    JSEngineFatalCallback jSEngineFatalCallback = jSEngineFatalCallback;
                    jSEngineFatalCallback.callback(str + " - " + str2);
                }
            };
        }
    }

    public void setOnFatalPrinter(final JSEngineFatalCallback jSEngineFatalCallback) {
        if (jSEngineFatalCallback != null) {
            C7781V8.onErrorPrinter = new C7781V8.OnErrorPrinter() {
                public void onPrint(String str) {
                    jSEngineFatalCallback.callback(str);
                }
            };
        }
    }

    public void registerOnUnHandledRejection() {
        Handler handler = this.jsHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (DiminaEngine.this.mV8Runtime != null && !DiminaEngine.this.mV8Runtime.isReleased()) {
                        if (!DiminaEngine.this.mV8Runtime.findOnUnHandledRejectionCallback(DiminaEngine.JS_ON_UN_HANDLED_REJECTION_FUNC_NAME)) {
                            LogUtil.eRelease(DiminaEngine.TAG, "findOnUnHandledRejectionCallback failed.");
                        } else if (!DiminaEngine.this.mV8Runtime.setPromiseRejectCallback()) {
                            LogUtil.eRelease(DiminaEngine.TAG, "setPromiseRejectCallback failed.");
                        }
                    }
                }
            });
        }
    }
}
