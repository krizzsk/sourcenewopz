package com.didi.dimina.container.secondparty.bundle.util;

import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.chain.InterceptorConfig;
import com.didi.dimina.container.util.LogUtil;

public class InterceptorConfigHelper {
    public static final String TAG = "Dimina-PM InterceptorConfigHelper";

    /* renamed from: a */
    private static boolean m12659a(InterceptorConfig interceptorConfig) {
        return interceptorConfig == null;
    }

    public static void dealProcessCallBack(InterceptorConfig interceptorConfig, int i) {
        if (!m12659a(interceptorConfig) && interceptorConfig.processCb != null) {
            interceptorConfig.processCb.onProcess(i);
        }
    }

    public static void deleteDownloadInFilesdir(InterceptorConfig interceptorConfig) {
        if (!m12659a(interceptorConfig)) {
            for (InstallModuleFileDescribe next : interceptorConfig.downloadModuleList) {
                LogUtil.iRelease(TAG, "需要删除的文件列表 = " + PmFileHelper.filePath2fileDir(next.getFilesAbsolutePath()));
                PmFileUtil.deleteFile(PmFileHelper.filePath2fileDir(next.getFilesAbsolutePath()), false);
            }
        }
    }
}
