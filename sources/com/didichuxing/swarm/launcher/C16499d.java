package com.didichuxing.swarm.launcher;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewManager;
import android.view.WindowManager;
import com.didichuxing.swarm.toolkit.ToolkitService;
import org.osgi.framework.launch.Framework;

/* renamed from: com.didichuxing.swarm.launcher.d */
/* compiled from: ToolkitServiceImpl */
class C16499d implements ToolkitService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f49197a;

    /* renamed from: b */
    private final Handler f49198b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C16500e f49199c;

    /* renamed from: d */
    private final Application f49200d;

    /* renamed from: e */
    private final Framework f49201e;

    C16499d(Application application, Framework framework) {
        this.f49200d = application;
        this.f49201e = framework;
        this.f49199c = new C16500e((WindowManager) application.getSystemService("window"));
        if (Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new ToolkitServiceImpl$1(this));
        }
    }

    public ViewManager getViewManager() {
        return this.f49199c;
    }

    public void show() {
        this.f49198b.post(new ToolkitServiceImpl$2(this));
    }

    public void hide() {
        this.f49198b.post(new ToolkitServiceImpl$3(this));
    }

    public Activity getActivity() {
        return this.f49197a;
    }

    /* renamed from: a */
    public Application mo121209a() {
        return this.f49200d;
    }
}
