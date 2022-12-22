package com.didi.sdk.onehotpatch.loader.dex;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import com.didi.sdk.onehotpatch.commonstatic.util.ZipUtils;
import com.didi.sdk.onehotpatch.installer.dexopt.DexOptService;
import com.didi.sdk.onehotpatch.loader.dex.elf.ImageSpace;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;

public class DexInstaller {
    public static final String HACK_DEX = "hack.apk";
    public static final String HACK_DIR = "hotpatch_hack";

    public static void performHack(Application application, boolean z) throws Exception {
        if (!PatchManager.isInsertHack(application)) {
            Logger.log("insert hack = false", new Object[0]);
            return;
        }
        Logger.log("insert hack = true", new Object[0]);
        File file = new File(application.getFilesDir(), HACK_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            String copyAsset = ZipUtils.copyAsset(application, HACK_DEX, file);
            ArrayList arrayList = new ArrayList();
            arrayList.add(copyAsset);
            PathListInstaller.install(getOriginalClassLoader(application, false, z), arrayList, file.getAbsolutePath());
            checkHack(application, false);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void checkHack(Context context) throws ClassNotFoundException {
        checkHack(context, true);
    }

    public static void checkHack(Context context, boolean z) throws ClassNotFoundException {
        if (!z || PatchManager.isInsertHack(context)) {
            Class.forName("com.didi.hotpatch.Hack");
        }
    }

    public static boolean loadPatch(Application application, PatchModule patchModule, boolean z) throws Throwable {
        ArrayList<File> patchDexPath = PatchManager.getPatchDexPath(application, patchModule);
        if (patchDexPath.size() == 0) {
            return false;
        }
        File patchOdexDir = PatchManager.getPatchOdexDir(application, patchModule);
        if (PatchManager.isArt()) {
            String fingerPrint = PatchManager.getFingerPrint(application);
            if (!TextUtils.isEmpty(fingerPrint)) {
                boolean z2 = !fingerPrint.equals(Build.FINGERPRINT) && !PatchManager.bangProtected(application);
                if (!z2 && Build.VERSION.SDK_INT <= 25) {
                    File[] listFiles = patchOdexDir.listFiles(new FilenameFilter() {
                        public boolean accept(File file, String str) {
                            return str.endsWith(".dex");
                        }
                    });
                    if (listFiles == null || listFiles.length == 0) {
                        z2 = true;
                    } else if (ImageSpace.needCheckImage(application)) {
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            z2 |= !ImageSpace.checkOatFileUpToDate(application, listFiles[i], patchModule);
                        }
                    }
                }
                Logger.log("fingerPrint old: " + fingerPrint, new Object[0]);
                Logger.log("fingerPrint new: " + Build.FINGERPRINT, new Object[0]);
                if (z2) {
                    Logger.info("reoat is need", new Object[0]);
                    if (UtilsHub.isMainProcess(application)) {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(application.getPackageName(), "com.didi.sdk.onehotpatch.downloader.dexopt.DexOptService"));
                        intent.setAction(DexOptService.ACTION_DEXOPT);
                        intent.putExtra(DexOptService.KEY_IS_OTA, true);
                        intent.putExtra("key_module", patchModule);
                        application.startService(intent);
                    }
                    return false;
                }
            } else {
                throw new Exception("fingerPrint is empty");
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = patchDexPath.iterator();
        while (it.hasNext()) {
            String absolutePath = it.next().getAbsolutePath();
            if (absolutePath.contains("mergepatch.dex")) {
                arrayList.add(0, absolutePath);
            } else {
                arrayList.add(absolutePath);
            }
        }
        PathClassLoader originalClassLoader = getOriginalClassLoader(application, true, z);
        if (originalClassLoader == null) {
            return false;
        }
        PathListInstaller.install(originalClassLoader, arrayList, patchOdexDir.getAbsolutePath());
        Logger.log("end install...... " + originalClassLoader.toString(), new Object[0]);
        return true;
    }

    public static PathClassLoader getOriginalClassLoader(Application application, boolean z, boolean z2) throws Exception {
        PathClassLoader pathClassLoader = (PathClassLoader) DexInstaller.class.getClassLoader();
        if (!z || PatchManager.bangProtected(application)) {
            return pathClassLoader;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            if (z2) {
                return DelegateLastClassLoader.inject(pathClassLoader, application);
            }
            try {
                PathClassLoader inject = AndroidNClassLoader.inject(pathClassLoader, application);
                Logger.log("replace classloader with AndroidNClassLoader", new Object[0]);
                return inject;
            } catch (Exception e) {
                throw e;
            }
        } else if (PatchManager.isArt() || PatchManager.isInsertHack(application)) {
            return pathClassLoader;
        } else {
            try {
                DalvikClassLoader inject2 = DalvikClassLoader.inject(pathClassLoader, application);
                Logger.log("replace classloader with DalvikClassLoader", new Object[0]);
                return inject2;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }
}
