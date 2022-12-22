package com.didi.sdk.onehotpatch;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.MetaBean;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent;
import com.didi.sdk.onehotpatch.commonstatic.report.Report;
import com.didi.sdk.onehotpatch.commonstatic.util.ConfigManager;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import com.didi.sdk.onehotpatch.loader.crash.CrashHandler;
import com.didi.sdk.onehotpatch.loader.dex.DexInstaller;
import com.didi.sdk.onehotpatch.loader.p158so.SoInstaller;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class ONEPatchFacade {
    static final Handler sMainHandler = new Handler(Looper.getMainLooper());

    public static void launch(Application application) {
        if (!PatchManager.isDelegateMode(application)) {
            launch(application, false);
        }
    }

    protected static void launch(final Application application, boolean z) {
        HotPatchEvent.LoadResult.sLaunchStartTime = System.currentTimeMillis();
        PatchModule patchModule = null;
        try {
            Logger.info("hotpatch sdk version: 3.11.4.9 " + UtilsHub.getProcessName(application), new Object[0]);
            Logger.log("bangProtected " + PatchManager.bangProtected(application), new Object[0]);
            DexInstaller.performHack(application, z);
            if (UtilsHub.isMainProcess(application)) {
                Logger.log("start launc.......... " + UtilsHub.getProcessName(application), new Object[0]);
                ConfigManager.init(application);
                String checkPatchRuntime = PatchManager.checkPatchRuntime(application);
                if (!"".equals(checkPatchRuntime)) {
                    trackEvent(application, 11, "This device can't use hotpatch", "This device can't use hotpatch. reason: " + checkPatchRuntime);
                    PatchManager.clearPatch(application);
                } else if (PatchManager.isAppUpgraded(application)) {
                    sMainHandler.post(new Runnable() {
                        public void run() {
                            try {
                                PatchManager.checkAppUpgraded(application);
                            } catch (Throwable th) {
                                ONEPatchFacade.trackEvent(application, -1, "app upgrade error", UtilsHub.dumpException(th));
                            }
                        }
                    });
                } else {
                    patchModule = PatchManager.getLoadPatch(application, true);
                    if (patchModule != null) {
                        Logger.info("current patch: " + patchModule.toString(), new Object[0]);
                        MetaBean patchMeta = PatchManager.getPatchMeta(application, patchModule);
                        String versionNameAndCode = UtilsHub.getVersionNameAndCode(application);
                        if (!patchMeta.target_version.equals(versionNameAndCode)) {
                            trackEvent(application, patchModule, 21, "App version not match", String.format("App版本(%s)与补丁版本(%s)不一致", new Object[]{versionNameAndCode, patchMeta.target_version}));
                            return;
                        }
                        if (Build.VERSION.SDK_INT >= patchMeta.min_sdk) {
                            if (Build.VERSION.SDK_INT <= patchMeta.max_sdk) {
                                int enabledFlag = PatchManager.getEnabledFlag(application, patchModule);
                                if (enabledFlag == -100) {
                                    trackEvent(application, patchModule, 30, "Ignore", "avoid crash");
                                    return;
                                } else if (enabledFlag != -3) {
                                    if (enabledFlag != -2) {
                                        if (enabledFlag != -1) {
                                            if (!(enabledFlag == 0 || enabledFlag == 1)) {
                                                throw new Exception("wrong enabledFlag: " + enabledFlag);
                                            }
                                        } else if (PatchManager.getLoadedCount(application, patchModule) == -1) {
                                            trackEvent(application, patchModule, -1, "app unexpected exit", "app unexpected exit. First reboot.");
                                            PatchManager.setEnabledFlag(application, patchModule, -100);
                                            return;
                                        }
                                    }
                                    CrashHandler.init(application);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    loadPatch(application, patchModule, z);
                                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                    Logger.log("加载patch所用时间： " + currentTimeMillis2, new Object[0]);
                                    trackEvent(application, patchModule, 0, currentTimeMillis2, (String) null, (String) null);
                                    Report.ReportModule reportModule = new Report.ReportModule();
                                    reportModule.isLoadSuccess = true;
                                    reportModule.loadTime = currentTimeMillis2;
                                    Report.report(application, patchModule, reportModule);
                                    return;
                                } else {
                                    PatchManager.setEnabledFlag(application, patchModule, -100);
                                    trackEvent(application, patchModule, 30, "app unexpected exit", "app unexpected exit. Turn to ignore.");
                                    return;
                                }
                            }
                        }
                        trackEvent(application, patchModule, 22, "Os version not match", String.format(Locale.CHINA, "SDK版本(%d)无效", new Object[]{Integer.valueOf(Build.VERSION.SDK_INT)}));
                    }
                }
            }
        } catch (Throwable th) {
            Logger.warn(th);
        }
    }

    private static void loadPatch(Application application, PatchModule patchModule, boolean z) throws Throwable {
        SoInstaller.loadPatch(application, patchModule, DexInstaller.loadPatch(application, patchModule, z), z);
    }

    /* access modifiers changed from: private */
    public static void trackEvent(Application application, int i, String str, String str2) {
        trackEvent(application, (PatchModule) null, i, 0, str, str2);
    }

    /* access modifiers changed from: private */
    public static void trackEvent(Application application, PatchModule patchModule, int i, String str, String str2) {
        trackEvent(application, patchModule, i, 0, str, str2);
    }

    static void trackEvent(final Application application, PatchModule patchModule, int i, long j, String str, String str2) {
        if (str2 != null) {
            Logger.info(str2, new Object[0]);
        }
        final HotPatchEvent.LoadResult loadResult = new HotPatchEvent.LoadResult();
        loadResult.status = i;
        loadResult.costTime = j;
        loadResult.errorType = str;
        loadResult.errmsg = str2;
        if (patchModule != null) {
            loadResult.patchVersion = patchModule.version;
        }
        Handler handler = sMainHandler;
        handler.post(new Runnable() {
            public void run() {
                HotPatchEvent.trackLoad(application, loadResult);
            }
        });
        if (patchModule != null && loadResult.status == 0) {
            new Monitor(application, handler, patchModule).execute();
        }
    }

    static class Monitor implements Application.ActivityLifecycleCallbacks, Runnable {
        final int MAX_COUNT;
        final long TIMEOUT_MILLIS;
        Application mApp;
        boolean mDone = false;
        Thread mExitingHook;
        Handler mHandler;
        AtomicBoolean mIsWatching = new AtomicBoolean(false);
        PatchModule mPatchModule;

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        Monitor(Application application, Handler handler, PatchModule patchModule) {
            this.mApp = application;
            this.mHandler = handler;
            this.mPatchModule = patchModule;
            this.MAX_COUNT = ConfigManager.getInt(application, "monitor_maxcount", 5);
            this.TIMEOUT_MILLIS = ((long) ConfigManager.getInt(application, "monitor_timeout", 120)) * 1000;
            this.mExitingHook = new Thread() {
                public void run() {
                    if (!Monitor.this.mDone) {
                        Monitor.this.mDone = true;
                        Logger.info("Process was exiting.", new Object[0]);
                        Monitor.this.updateCounter();
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        public void execute() {
            int enabledFlag = PatchManager.getEnabledFlag(this.mApp, this.mPatchModule);
            if (enabledFlag > 0) {
                Logger.info("Skipped watching. flag: " + enabledFlag, new Object[0]);
                Logger.info("Set EnabledFlag ok", new Object[0]);
                return;
            }
            int loadedCount = PatchManager.getLoadedCount(this.mApp, this.mPatchModule);
            if (loadedCount < 0) {
                PatchManager.setLoadedCount(this.mApp, this.mPatchModule, 0);
                ONEPatchFacade.trackEvent(this.mApp, this.mPatchModule, -1, "app unexpected exit. flag: " + enabledFlag, "app unexpected exit. watched count: " + Math.abs(loadedCount) + ", flag: " + enabledFlag);
            } else if (loadedCount >= this.MAX_COUNT) {
                PatchManager.setLoadedCount(this.mApp, this.mPatchModule, 0);
                int i = enabledFlag + 1;
                PatchManager.setEnabledFlag(this.mApp, this.mPatchModule, i);
                Logger.info("Updated count: " + loadedCount + ", flag: " + i, new Object[0]);
            }
            this.mApp.registerActivityLifecycleCallbacks(this);
            Runtime.getRuntime().addShutdownHook(this.mExitingHook);
            if (!UtilsHub.isForegroundProcess(this.mApp)) {
                Logger.info("Skipped watching. Booted in the background.", new Object[0]);
            } else {
                tryStartWatching();
            }
        }

        /* access modifiers changed from: package-private */
        public void tryStartWatching() {
            if (!this.mIsWatching.getAndSet(true)) {
                int loadedCount = PatchManager.getLoadedCount(this.mApp, this.mPatchModule);
                PatchManager.setLoadedCount(this.mApp, this.mPatchModule, -(loadedCount + 1));
                this.mHandler.removeCallbacks(this);
                this.mHandler.postDelayed(this, this.TIMEOUT_MILLIS);
                int enabledFlag = PatchManager.getEnabledFlag(this.mApp, this.mPatchModule) - 1;
                PatchManager.setEnabledFlag(this.mApp, this.mPatchModule, enabledFlag);
                Logger.info("Started watching. count: " + loadedCount + ", flag: " + enabledFlag, new Object[0]);
            }
        }

        /* access modifiers changed from: package-private */
        public void updateCounter() {
            try {
                int loadedCount = PatchManager.getLoadedCount(this.mApp, this.mPatchModule);
                if (loadedCount < 0) {
                    int enabledFlag = PatchManager.getEnabledFlag(this.mApp, this.mPatchModule) + 1;
                    PatchManager.setEnabledFlag(this.mApp, this.mPatchModule, enabledFlag);
                    int i = -loadedCount;
                    PatchManager.setLoadedCount(this.mApp, this.mPatchModule, i);
                    Logger.info("Updated count ok. count: " + i + ", flag: " + enabledFlag, new Object[0]);
                    try {
                        Runtime.getRuntime().removeShutdownHook(this.mExitingHook);
                    } catch (Exception unused) {
                    }
                } else {
                    throw new Exception("wrong count: " + loadedCount);
                }
            } catch (Throwable th) {
                Logger.warn(th);
            }
        }

        public void run() {
            if (!this.mDone) {
                this.mDone = true;
                this.mApp.unregisterActivityLifecycleCallbacks(this);
                Logger.info("Watching timeout.", new Object[0]);
                updateCounter();
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            tryStartWatching();
        }

        public void onActivityStopped(Activity activity) {
            if (!this.mDone) {
                if (UtilsHub.isForegroundProcess(this.mApp)) {
                    Logger.info("Process was still foreground.", new Object[0]);
                    return;
                }
                this.mDone = true;
                this.mHandler.removeCallbacks(this);
                this.mApp.unregisterActivityLifecycleCallbacks(this);
                Logger.info("Process was background.", new Object[0]);
                updateCounter();
            }
        }
    }
}
