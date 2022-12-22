package com.didi.sdk.onehotpatch.installer;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.MetaBean;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.FileUtils;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import com.didi.sdk.onehotpatch.commonstatic.util.ZipUtils;
import com.didi.sdk.onehotpatch.installer.merge.MergePatchService;
import java.io.File;
import java.io.IOException;

public class LocalTest {
    public static void installLocalPatch(Context context, File file) {
        if (!file.exists() || !file.canRead()) {
            Logger.log("invalid patch file.", new Object[0]);
            return;
        }
        String str = file.getParent() + "/tmp_upzip_hotpatch";
        File file2 = new File(str);
        try {
            FileUtils.deleteDirectory(file2);
            ZipUtils.unzip(file, str);
            MetaBean patchMeta = PatchManager.getPatchMeta(new File(str, "meta"));
            try {
                FileUtils.deleteDirectory(file2);
            } catch (IOException unused) {
            }
            if (patchMeta == null) {
                SystemUtils.showToast(Toast.makeText(context, "meta解析失败！", 0));
                return;
            }
            SystemUtils.showToast(Toast.makeText(context, "安装中...", 0));
            PatchModule patchModule = new PatchModule();
            patchModule.moduleCode = "hotpatch";
            patchModule.appVersion = UtilsHub.getVersionNameAndCode(context);
            patchModule.modulePath = file.getAbsolutePath();
            patchModule.version = patchMeta.version;
            patchModule.versionLong = Long.valueOf(patchMeta.version).longValue();
            PatchManager.setInstallingPatch(context, patchModule);
            Intent intent = new Intent(context, MergePatchService.class);
            intent.setAction(MergePatchService.ACTION_MERGE_HOTPATCH);
            intent.putExtra("key_module", patchModule);
            context.startService(intent);
        } catch (Exception e) {
            Logger.warn(e);
            try {
                FileUtils.deleteDirectory(file2);
            } catch (IOException unused2) {
            }
        } catch (Throwable th) {
            try {
                FileUtils.deleteDirectory(file2);
            } catch (IOException unused3) {
            }
            throw th;
        }
    }
}
