package com.didi.foundation.sdk.hotpatch;

import android.app.Application;
import com.didi.dynamic.manager.DownloadManager;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.login.LoginService;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.downloader.HotPatchDownloadListener;

public final class HotPatchHelper {

    /* renamed from: a */
    private static Logger f21170a = LogService.getLogger("HotPatchHelper");

    private HotPatchHelper() {
    }

    public static void downloadHotPatch(Application application) {
        Logger logger = f21170a;
        logger.debug("downloadHotPatch: " + application, new Object[0]);
        DownloadManager.setModuleUrlHost(PatchManager.getHost(application));
        DownloadManager instance = DownloadManager.getInstance(application);
        instance.setExtraParameter(PatchManager.getAppKey(application), LoginService.getInstance().getPhone(), -1, -1.0d, -1.0d, "");
        instance.addDownloadListener(1, new HotPatchDownloadListener(application));
        instance.checkModuleAndDownload();
    }
}
