package com.didi.flutter.hotpatch.flutterhotpatch;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.didi.dynamic.manager.utils.SharedPreferencesWrapper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.MetaBean;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.bean.SoInfo;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.io.File;

public class OnePatchAdapter implements HotPatchAdapter {
    public static final String FLUTTER_HOTPATCH_SP = "flutter_hotpatch_sp";

    /* renamed from: a */
    Logger f21073a = LoggerFactory.getLogger("OnePatchAdapter");

    /* renamed from: b */
    private PatchModule f21074b;

    /* renamed from: c */
    private Application f21075c;

    /* renamed from: d */
    private int f21076d = 3;

    public String getPatchPath(Application application) {
        try {
            if (this.f21074b == null) {
                return null;
            }
            File file = new File(new File(PatchManager.getPatchSoDir(application, this.f21074b), SoInfo.getCurrentAbi(application)), "libapp.so");
            if (!file.exists() || !file.canRead()) {
                return null;
            }
            return file.getCanonicalPath();
        } catch (Throwable th) {
            this.f21073a.error("getPatchPath error", th);
            return null;
        }
    }

    public void onFlutterError() {
        PatchModule patchModule = this.f21074b;
        if (patchModule != null) {
            int errorCount = getErrorCount(this.f21075c, patchModule);
            m15514a(errorCount + 1);
            Logger logger = this.f21073a;
            logger.info("onFlutterError new errorCount:" + errorCount, new Object[0]);
        }
    }

    /* renamed from: a */
    private void m15514a(int i) {
        SharedPreferencesWrapper.Editor edit = SharedPreferencesWrapper.m14516of(this.f21075c, FLUTTER_HOTPATCH_SP, 0).edit();
        edit.putInt("error_count_" + this.f21074b.version, i).apply();
    }

    public static int getErrorCount(Context context, PatchModule patchModule) {
        SharedPreferencesWrapper of = SharedPreferencesWrapper.m14516of(context, FLUTTER_HOTPATCH_SP, 0);
        return of.getInt("error_count_" + patchModule.version, 0);
    }

    public boolean canLoadPatch(Application application) {
        this.f21073a.debug("canLoadPatch", new Object[0]);
        this.f21075c = application;
        try {
            if (!UtilsHub.isMainProcess(application)) {
                return false;
            }
            if (PatchManager.isAppUpgraded(application)) {
                this.f21073a.info("isAppUpgraded", new Object[0]);
                return false;
            }
            IToggle a = m15513a();
            if (!a.allow()) {
                Logger logger = this.f21073a;
                logger.info("toggle not allow:" + a, new Object[0]);
                return false;
            }
            PatchModule loadPatch = PatchManager.getLoadPatch(application, true);
            if (loadPatch == null) {
                this.f21073a.info("patchModule == null", new Object[0]);
                return false;
            }
            MetaBean patchMeta = PatchManager.getPatchMeta(application, loadPatch);
            if (patchMeta == null) {
                this.f21073a.info("metaBean == null", new Object[0]);
                return false;
            }
            String versionNameAndCode = UtilsHub.getVersionNameAndCode(application);
            if (!patchMeta.target_version.equals(versionNameAndCode)) {
                Logger logger2 = this.f21073a;
                logger2.info("target_version is not equals，appVersion:" + versionNameAndCode + "target_version:" + patchMeta.target_version, new Object[0]);
                return false;
            }
            if (Build.VERSION.SDK_INT >= patchMeta.min_sdk) {
                if (Build.VERSION.SDK_INT <= patchMeta.max_sdk) {
                    int enabledFlag = PatchManager.getEnabledFlag(application, loadPatch);
                    if (enabledFlag != 1) {
                        Logger logger3 = this.f21073a;
                        logger3.info("enabledFlag:" + enabledFlag, new Object[0]);
                        return false;
                    }
                    this.f21076d = ((Integer) a.getExperiment().getParam("maxErrorCount", 3)).intValue();
                    int errorCount = getErrorCount(application, loadPatch);
                    if (errorCount > this.f21076d) {
                        Logger logger4 = this.f21073a;
                        logger4.info("errorCount:" + errorCount + ",maxErrorCount:" + this.f21076d, new Object[0]);
                        return false;
                    }
                    this.f21073a.info("canLoadPatch ok", new Object[0]);
                    this.f21074b = loadPatch;
                    return true;
                }
            }
            this.f21073a.info("SDK version not match", new Object[0]);
            return false;
        } catch (Throwable th) {
            this.f21073a.error("canLoadPatch error", th);
            return false;
        }
    }

    /* renamed from: a */
    private IToggle m15513a() {
        return Apollo.getToggle("flutter_hotpatch_config", true);
    }
}
