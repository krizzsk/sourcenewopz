package com.didi.dimina.container.secondparty.bundle.download;

import android.app.Application;
import android.text.TextUtils;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;

public class PmDownloadHelper {
    public static PmDownloadTask appModulesBean2PmDownloadTask(DMConfigBean.AppModulesBean appModulesBean, String str, String str2) {
        Application app = Dimina.getConfig().getApp();
        String moduleName = appModulesBean.getModuleName();
        if (TextUtils.isEmpty(str2)) {
            str2 = appModulesBean.getVersion();
        }
        return new PmDownloadTask(str, (long) appModulesBean.getModuleId(), appModulesBean.getMd5(), appModulesBean.getUrl(), PmFileHelper.getZipModuleCacheFilePath(app, moduleName, str, str2), appModulesBean.getModuleName());
    }

    public static InstallModuleFileDescribe appModulesBean2InstallModuleFileDescribe(DMConfigBean.AppModulesBean appModulesBean, String str) {
        InstallModuleFileDescribe installModuleFileDescribe = new InstallModuleFileDescribe(appModulesBean);
        installModuleFileDescribe.setRelativePath(PmFileHelper.absolutePath2RelativePath(str));
        installModuleFileDescribe.setCacheAbsolutePath(str);
        return installModuleFileDescribe;
    }
}
