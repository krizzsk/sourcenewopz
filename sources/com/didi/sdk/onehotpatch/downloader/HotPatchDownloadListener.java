package com.didi.sdk.onehotpatch.downloader;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.didi.dynamic.manager.IDownloadListener;
import com.didi.dynamic.manager.Module;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent;
import com.didi.sdk.onehotpatch.commonstatic.util.FileUtils;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import com.didi.sdk.onehotpatch.gesture.GestureDebugHelper;
import com.didi.sdk.onehotpatch.installer.merge.MergePatchService;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateBroadcast;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import com.didichuxing.swarm.launcher.SwarmLauncher;
import com.didichuxing.swarm.launcher.toolkit.HotPatchService;
import org.osgi.framework.BundleContext;

public class HotPatchDownloadListener implements IDownloadListener {
    private int downloadState = -100;
    private Application mApplication;
    private boolean mCanUsePatch;

    public HotPatchDownloadListener(Application application) {
        try {
            this.mApplication = application;
            this.mCanUsePatch = PatchManager.canUsePatch(application);
            if (UtilsHub.isMainProcess(application)) {
                if (!this.mCanUsePatch) {
                    Logger.info("Skip init!", new Object[0]);
                }
                PatchManager.deleteInstallingPatchAndDatabase(application);
                PatchManager.checkAppUpgraded(application);
                PatchModule loadPatch = PatchManager.getLoadPatch(application);
                if (loadPatch == null) {
                    FileUtils.deleteDirectory(PatchManager.getPatchHome(application));
                } else {
                    reportSwarm(application, loadPatch);
                }
                GestureDebugHelper.init(application);
            }
        } catch (Throwable th) {
            Logger.warn(th);
            HotPatchEvent.trackDownload(this.mApplication, 0 != 0 ? null.version : "", -1, th);
        }
    }

    private void reportSwarm(Context context, PatchModule patchModule) {
        if (patchModule != null) {
            try {
                if (PatchManager.getEnabledFlag(context, patchModule) == -100) {
                    Logger.log("ignore to report swarm: " + patchModule.version, new Object[0]);
                    return;
                }
                BundleContext bundleContext = SwarmLauncher.getInstance().getFramework().getBundleContext();
                long j = patchModule.versionLong;
                ((HotPatchService) bundleContext.getService(bundleContext.getServiceReference(HotPatchService.class))).setVersion(j);
                Logger.log("report swarm success: " + j, new Object[0]);
            } catch (Throwable th) {
                Logger.warn(th);
                Logger.log("report swarm error", new Object[0]);
            }
        }
    }

    public void onDownloadStart(Module module) {
        if (this.mCanUsePatch) {
            Logger.info("HotPatchDownloadListener downloadStart:" + module, new Object[0]);
            this.downloadState = 1;
            HotpatchStateBroadcast.sendPatchDownloadState(this.mApplication, HotpatchStateConst.DOWNLOAD, 1, module.ext);
        }
    }

    public void onDownloadEnd(Module module, int i) {
        try {
            if (this.mCanUsePatch) {
                PatchModule convertToPatchModule = convertToPatchModule(module);
                if (i == 0) {
                    Logger.info("HotPatchDownloadListener downloadFailed:" + module, new Object[0]);
                    HotPatchEvent.trackDownload(this.mApplication, convertToPatchModule.version, -1, (Throwable) null);
                    this.downloadState = -1;
                    HotpatchStateBroadcast.sendPatchDownloadState(this.mApplication, HotpatchStateConst.DOWNLOAD, -1, module.ext);
                    return;
                }
                HotPatchEvent.trackDownload(this.mApplication, convertToPatchModule.version, 0, (Throwable) null);
                this.downloadState = 0;
                HotpatchStateBroadcast.sendPatchDownloadState(this.mApplication, HotpatchStateConst.DOWNLOAD, 0, module.ext);
                if ("10000000".equals(convertToPatchModule.version)) {
                    Logger.info("HotPatchDownloadListener rollback patch", new Object[0]);
                    PatchManager.rollBackLoadPatch(this.mApplication);
                    HotPatchEvent.trackRollback(this.mApplication);
                    this.downloadState = HotpatchStateConst.ROLLBACK_PATHCH;
                    HotpatchStateBroadcast.sendPatchDownloadState(this.mApplication, HotpatchStateConst.DOWNLOAD, HotpatchStateConst.ROLLBACK_PATHCH, "");
                    return;
                }
                PatchManager.setInstallingPatch(this.mApplication, convertToPatchModule);
                Intent intent = new Intent(this.mApplication, MergePatchService.class);
                intent.setAction(MergePatchService.ACTION_MERGE_HOTPATCH);
                intent.putExtra("key_module", convertToPatchModule);
                this.mApplication.startService(intent);
                return;
            }
            return;
        } catch (Throwable unused) {
            return;
        }
        HotpatchStateBroadcast.sendPatchDownloadState(this.mApplication, HotpatchStateConst.INSTALL, -1, module.ext);
        HotPatchEvent.trackDownload(this.mApplication, module.version, -1, th);
    }

    public void onFinishAllDownload() {
        if (this.mCanUsePatch) {
            Logger.log("HotPatchDownloadListener onFinishAllDownload", new Object[0]);
            if (this.downloadState == -100) {
                this.downloadState = -2;
                HotpatchStateBroadcast.sendPatchDownloadState(this.mApplication, HotpatchStateConst.DOWNLOAD, -2, "");
            }
            this.downloadState = -100;
        }
    }

    private PatchModule convertToPatchModule(Module module) {
        PatchModule patchModule = new PatchModule();
        patchModule.moduleCode = module.moduleCode;
        patchModule.version = module.version;
        patchModule.appVersion = module.appVersion;
        patchModule.versionLong = module.versionLong;
        patchModule.modulePath = module.modulePath.getAbsolutePath();
        patchModule.ext = module.ext;
        return patchModule;
    }
}
