package com.didi.dimina.container.secondparty.bundle;

import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.bundle.bean.InstallModuleFileDescribe;
import com.didi.dimina.container.secondparty.bundle.util.PmBundleUtil;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import net.lingala.zip4j.ZipFile;

public class UnzipManager {
    public static final String TAG = "Dimina-PM UnzipManager";

    public static void unzip(List<InstallModuleFileDescribe> list, IDMCommonAction<Boolean> iDMCommonAction) {
        LogUtil.iRelease(TAG, "需要操作的文件列表=" + list);
        DebugExceptionUtil.log("需要操作的文件列表", "", (List<?>) list);
        String str = PmFileHelper.getFileDmBundleDir(Dimina.getConfig().getApp()) + File.separator;
        boolean z = true;
        boolean z2 = false;
        for (int i = 0; i < list.size(); i++) {
            InstallModuleFileDescribe installModuleFileDescribe = list.get(i);
            String str2 = str + installModuleFileDescribe.getRelativePath();
            String str3 = PmFileHelper.filePath2fileDir(str2) + File.separator + installModuleFileDescribe.getModuleName();
            LogUtil.iRelease(TAG, "第" + i + "个 ->" + installModuleFileDescribe + "\t dstDir=" + str3);
            installModuleFileDescribe.setFilesAbsolutePath(str3);
            if (!CollectionsUtil.isEmpty((Collection) PmFileUtil.childFileInDir(str3))) {
                LogUtil.iRelease(TAG, str3 + " 路径下有子文件, 所以RemoteUnzip 操作时跳过, 并删除cache路径:" + installModuleFileDescribe.getCacheAbsolutePath());
                PmFileUtil.deleteFile(installModuleFileDescribe.getCacheAbsolutePath());
            } else if (!m12581a(installModuleFileDescribe.getCacheAbsolutePath(), str3)) {
                z = false;
            }
        }
        if (!PmBundleUtil.isAppIntegral(list)) {
            LogUtil.eRelease(TAG, "检查完整性 fail");
        } else {
            LogUtil.iRelease(TAG, "检查完整性 succ");
            z2 = z;
        }
        if (iDMCommonAction != null) {
            iDMCommonAction.callback(new Boolean(z2));
        }
    }

    /* renamed from: a */
    private static boolean m12581a(String str, String str2) {
        if (new File(str).exists()) {
            PmFileUtil.deleteFile(str2);
            try {
                new ZipFile(str).extractAll(str2);
                try {
                    new File(str2, PmFileConstant.MODULE_UNZIP_SUCCESS_FLAG).createNewFile();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    LogUtil.m13412i(TAG, "将zip的源文件进行删除:" + str);
                    PmFileUtil.deleteFile(str);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
