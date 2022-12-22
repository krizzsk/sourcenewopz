package com.didi.dimina.container.mina;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.jsengine.JSEngineWrapper;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.page.ITabBarPageHost;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.Collection;
import java.util.List;

public class DMMemoryManager implements ComponentCallbacks2 {

    /* renamed from: a */
    private static final String f16883a = "DiminaMemoryManager";

    /* renamed from: b */
    private DiminaMemoryManagerCallback f16884b;

    /* renamed from: c */
    private boolean f16885c;

    /* renamed from: d */
    private int f16886d;

    public interface DiminaMemoryManagerCallback {
        void onTrimMemory(int i);
    }

    public static class MinaMemoryInfo {
        int currentHeapLimit;
        int expandTimes = 0;
        int initialHeapLimit;
        boolean relaunch = false;
        long startTime = 0;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    private DMMemoryManager() {
        this.f16885c = false;
        this.f16886d = 0;
    }

    public static DMMemoryManager getInstance() {
        return DiminaMemoryManagerHolder.diminaMemoryManager;
    }

    private static class DiminaMemoryManagerHolder {
        public static DMMemoryManager diminaMemoryManager = new DMMemoryManager();

        private DiminaMemoryManagerHolder() {
        }
    }

    public boolean isLowMemory() {
        return this.f16885c;
    }

    public void setLowMemory(boolean z) {
        this.f16885c = z;
    }

    public void handleMemory(List<IPageHost> list) {
        if (!CollectionsUtil.isEmpty((Collection) list) && getInstance().isLowMemory()) {
            for (int i = 1; i < list.size() - 1; i++) {
                IPageHost iPageHost = list.get(i);
                if (!(iPageHost instanceof ITabBarPageHost)) {
                    DMPage page = ((IPageHost) iPageHost.getPageHost()).getPage();
                    if (!page.isWebViewRelease) {
                        page.releaseWebView();
                        setLowMemory(false);
                        return;
                    }
                }
            }
        }
    }

    public void checkPageMemory(IPageHost iPageHost) {
        if (iPageHost != null && m12503b(iPageHost)) {
            m12502a(iPageHost);
        }
    }

    /* renamed from: a */
    private void m12502a(IPageHost iPageHost) {
        DMPage page = iPageHost.getPage();
        LogUtil.iRelease(f16883a, "DiminaMemoryManager: host webViewId= " + page.getWebViewId() + " reCreatePageWebView");
        page.reLoadView();
    }

    /* renamed from: b */
    private boolean m12503b(IPageHost iPageHost) {
        DMPage page = iPageHost.getPage();
        return page != null && page.isWebViewRelease;
    }

    public void onTrimMemory(int i) {
        LogUtil.iRelease(f16883a, "invoke onTrimMemory() level = " + i);
        this.f16886d = i;
        if (i == 15) {
            LogUtil.wRelease(f16883a, "invoke onTrimMemory() level = 15 mIsLowMemory = true");
            this.f16885c = true;
        }
        m12500a(i);
        if (i == 80) {
            for (DMMina a : DMMinaPool.getAll()) {
                m12501a(a, "memory");
            }
        }
        DiminaMemoryManagerCallback diminaMemoryManagerCallback = this.f16884b;
        if (diminaMemoryManagerCallback != null) {
            diminaMemoryManagerCallback.onTrimMemory(i);
        }
    }

    public void onLowMemory() {
        LogUtil.wRelease(f16883a, "onLowMemory ");
        m12500a(80);
    }

    /* renamed from: a */
    private void m12500a(int i) {
        JSEngine.PressLevel pressLevel;
        if (i >= 80 || i == 15) {
            pressLevel = JSEngine.PressLevel.CRITICAL;
        } else if (i >= 40) {
            pressLevel = JSEngine.PressLevel.MODERATE;
        } else {
            pressLevel = JSEngine.PressLevel.NONE;
        }
        for (DMMina jSEngine : DMMinaPool.getAll()) {
            JSEngineWrapper jSEngine2 = jSEngine.getJSEngine();
            if (jSEngine2 != null) {
                jSEngine2.notifyMemoryPress(pressLevel);
                LogUtil.iRelease("V8Dimina", "trackSagaV8GC");
            }
        }
    }

    public int onJSEngineNearHeapLimit(DMMina dMMina, int i, int i2) {
        int i3 = i + 104857600;
        dMMina.memoryInfo.currentHeapLimit = i3;
        dMMina.memoryInfo.initialHeapLimit = i2;
        dMMina.memoryInfo.expandTimes++;
        dMMina.getJSEngine().onLowMemory();
        LogUtil.iRelease("V8Dimina", "trackSagaV8GC");
        return i3;
    }

    public void notifyDiminaResumeMainPage(DMMina dMMina) {
        m12501a(dMMina, "home");
    }

    public void notifyDiminaBackground(DMMina dMMina) {
        m12501a(dMMina, Constants.BACKGROUND);
    }

    /* renamed from: a */
    private void m12501a(DMMina dMMina, String str) {
        if (dMMina.getConfig().getLaunchConfig().isIsUseReLaunch() && !dMMina.isRelease() && !dMMina.memoryInfo.relaunch && dMMina.memoryInfo.expandTimes != 0) {
            long reLaunchTimeDiff = dMMina.getConfig().getLaunchConfig().getReLaunchTimeDiff();
            if (System.currentTimeMillis() - dMMina.memoryInfo.startTime < reLaunchTimeDiff) {
                LogUtil.wRelease(f16883a, "dimina relaunch but diff time " + (System.currentTimeMillis() - dMMina.memoryInfo.startTime) + " and set " + reLaunchTimeDiff);
            } else if (this.f16886d >= 60) {
                DMConfig.ReLaunchCallback relaunchCallback = dMMina.getConfig().getCallbackConfig().getRelaunchCallback();
                if (relaunchCallback == null) {
                    LogUtil.wRelease(f16883a, "dimina relaunch fail by no callback set");
                    return;
                }
                dMMina.memoryInfo.relaunch = true;
                LogUtil.iRelease(f16883a, "dimina relaunch from " + str);
                TraceUtil.trackRelaunch(dMMina.getMinaIndex(), dMMina.memoryInfo.currentHeapLimit, str);
                DMMina relaunch = relaunchCallback.relaunch(dMMina);
                if (relaunch != null) {
                    relaunch.memoryInfo.startTime = System.currentTimeMillis();
                }
            }
        }
    }

    public void setMemoryManagerCallback(DiminaMemoryManagerCallback diminaMemoryManagerCallback) {
        this.f16884b = diminaMemoryManagerCallback;
    }
}
