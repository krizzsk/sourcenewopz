package com.didi.dimina.container.secondparty.bundle;

import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.bundle.util.PmFileHelper;
import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.container.secondparty.util.DebugExceptionUtil;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.LogUtil;

public class PmNodeConfigManager {
    public static final String TAG = "Dimina-PM PmNodeConfigManager";

    public static void writeConfigRespJsonFile(String str, String str2) {
        DMThreadPool.getExecutor().execute(new Runnable(str, str2) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                PmNodeConfigManager.m12572a(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m12572a(String str, String str2) {
        boolean rename;
        String filesNodeConfigTmpFilePath = PmFileHelper.getFilesNodeConfigTmpFilePath(Dimina.getConfig().getApp(), str);
        LogUtil.iRelease(TAG, "将配置写入到 config.json.cache 文件 -> " + filesNodeConfigTmpFilePath + "\t 写入长度=" + str2.length());
        FileUtil.delete(filesNodeConfigTmpFilePath);
        PmFileUtil.writeFile(filesNodeConfigTmpFilePath, str2);
        DebugExceptionUtil.dottingPmTime("renameJsonCache2Json", "重命名 config.json start");
        String filesNodeConfigNormalFilePath = PmFileHelper.getFilesNodeConfigNormalFilePath(Dimina.getConfig().getApp(), str);
        synchronized (PmNodeConfigManager.class) {
            rename = PmFileUtil.rename(filesNodeConfigTmpFilePath, filesNodeConfigNormalFilePath);
        }
        DebugExceptionUtil.dottingPmTime("renameJsonCache2Json", "重命名 config.json over, 操作结果:" + rename);
    }

    public static void readConfigRespJsonFile(String str, IDMCommonAction<String> iDMCommonAction) {
        DMThreadPool.getExecutor().execute(new Runnable(str, iDMCommonAction) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ IDMCommonAction f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                PmNodeConfigManager.m12571a(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m12571a(String str, IDMCommonAction iDMCommonAction) {
        String read;
        String filesNodeConfigNormalFilePath = PmFileHelper.getFilesNodeConfigNormalFilePath(Dimina.getConfig().getApp(), str);
        synchronized (PmNodeConfigManager.class) {
            read = PmFileUtil.read(filesNodeConfigNormalFilePath);
        }
        if (iDMCommonAction != null) {
            iDMCommonAction.callback(read);
        }
    }
}
