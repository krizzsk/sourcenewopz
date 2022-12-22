package com.didi.sdk.apm;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.didi.sdk.apm.crash.AppCrashInterceptor;
import com.didi.sdk.apm.ext.VoidPrintStream;
import com.didi.sdk.apm.utils.ApmUncaughtExceptionHandler;
import com.didi.sdk.apm.utils.DebugUtils;
import com.didi.sdk.apm.utils.TimingLogger;
import global.didi.pay.newview.pix.IPixView;

public class ApmServiceManager {
    public static final String TAG = "ApmServiceManager";

    /* renamed from: a */
    private static final ApmServiceManager f34924a = new ApmServiceManager();

    /* renamed from: b */
    private BroadcastReceiverMonitor f34925b;

    /* renamed from: c */
    private boolean f34926c;

    public static ApmServiceManager getInstance() {
        return f34924a;
    }

    private ApmServiceManager() {
    }

    public synchronized ApmServiceManager init(Context context) {
        if (this.f34926c) {
            return this;
        }
        this.f34926c = true;
        try {
            m24686a(context);
        } catch (Throwable th) {
            Log.e(TAG, "init error: ", th);
        }
        return this;
    }

    /* renamed from: a */
    private void m24686a(Context context) {
        TimingLogger timingLogger = new TimingLogger(TAG, IPixView.PAGE_STATUS_INIT);
        timingLogger.setDisabled(!DebugUtils.isDebuggableApp(context));
        ApmUncaughtExceptionHandler.init();
        timingLogger.addSplit("ApmUncaughtExceptionHandler init");
        SystemUtils.m24708a(context);
        timingLogger.addSplit("SystemUtils init");
        AppCrashInterceptor.init();
        timingLogger.addSplit("AppCrashInterceptor init");
        C11888d.m24750a(context);
        timingLogger.addSplit("PreLoaders start");
        SystemServiceHelper.m24705a(context);
        timingLogger.addSplit("SystemServiceHelper init");
        timingLogger.addSplit("LogcatFilter init");
        m24690e(context);
        timingLogger.addSplit("redirectLogStreams");
        timingLogger.dumpToLog();
    }

    /* renamed from: b */
    private void m24687b(Context context) {
        TimingLogger timingLogger = new TimingLogger(TAG, IPixView.PAGE_STATUS_INIT);
        timingLogger.setDisabled(!DebugUtils.isDebuggableApp(context));
        timingLogger.addSplit("redirectLogStreams");
        m24690e(context);
        timingLogger.addSplit("AppStateMonitor init");
        AppStateMonitor.getInstance().init(context);
        timingLogger.addSplit("PreLoaders start");
        C11888d.m24750a(context);
        timingLogger.addSplit("SystemServiceHelper init");
        SystemServiceHelper.m24705a(context);
        timingLogger.addSplit("SystemUtils init");
        SystemUtils.m24708a(context);
        timingLogger.addSplit("startStrictMode");
        m24689d(context);
        timingLogger.addSplit("AntiHookHelper init");
        AntiHookHelper.init(context);
        timingLogger.addSplit("LogcatFilter init");
        if (Build.VERSION.SDK_INT <= 27) {
            timingLogger.addSplit("BroadcastReceiverMonitor <init>");
            this.f34925b = new BroadcastReceiverMonitor(context);
        }
        timingLogger.addSplit("Runtime addShutdownHook");
        m24688c(context);
        timingLogger.addSplit("AppAutoCloser init");
        C11877a.m24714a().mo90303a(context);
        timingLogger.dumpToLog();
    }

    public void start() {
        if (this.f34926c) {
            try {
                Log.i(TAG, "start");
                m24685a();
            } catch (Throwable th) {
                Log.e(TAG, "start error: ", th);
            }
        }
    }

    /* renamed from: a */
    private void m24685a() {
        BroadcastReceiverMonitor broadcastReceiverMonitor = this.f34925b;
        if (broadcastReceiverMonitor != null) {
            broadcastReceiverMonitor.mo90273a();
        }
        C11877a.m24714a().mo90304b();
    }

    /* renamed from: c */
    private void m24688c(Context context) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                Log.e(ApmServiceManager.TAG, "Runtime exit called");
                super.run();
            }
        });
    }

    /* renamed from: d */
    private void m24689d(Context context) {
        if (DebugUtils.isDebuggableApp(context)) {
            Log.i(TAG, "startStrictMode");
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectActivityLeaks().detectLeakedClosableObjects().detectLeakedSqlLiteObjects().penaltyLog().build());
        }
    }

    /* renamed from: e */
    private void m24690e(Context context) {
        if (!DebugUtils.isDebuggableApp(context)) {
            Log.i(TAG, "redirectLogStreams");
            try {
                VoidPrintStream voidPrintStream = new VoidPrintStream();
                System.out.close();
                System.setOut(voidPrintStream);
                System.err.close();
                System.setErr(voidPrintStream);
            } catch (Exception unused) {
            }
        }
    }
}
