package com.didi.sdk.onehotpatch.installer.merge.dex;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.didi.dynamic.manager.DownloadManager;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.FileUtils;
import com.didi.sdk.onehotpatch.commonstatic.util.ZipUtils;
import com.didi.sdk.onehotpatch.commonstatic.util.ZipVerifyUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DexDiffMerger {
    private static final Pattern DEX_PATTERN = Pattern.compile("classes(\\d*)\\.dex");
    private static final String MERGE_PATCH_JAR = "mergepatch.jar";
    private static final String PATCH_CLASSES_MAP = "patchClassesMap.txt";
    private static final String PATCH_JAR = "patch.jar";

    public static boolean merge(Application application, PatchModule patchModule) throws Throwable {
        File patchDir = PatchManager.getPatchDir(application, patchModule);
        File file = new File(patchDir, PATCH_JAR);
        if (!file.exists()) {
            return true;
        }
        if (!file.canRead() || !verifyPatch(application, file.getAbsolutePath())) {
            throw new Exception("DexDiffMerger verify patch failed");
        }
        File file2 = new File(patchDir, MERGE_PATCH_JAR);
        if (PatchManager.bangProtected(application)) {
            delIfExist(file2);
            FileUtils.moveFile(file, file2);
            return true;
        }
        if (PatchManager.isArt()) {
            delIfExist(file2);
            if (Build.VERSION.SDK_INT < 24) {
                FileUtils.moveFile(file, file2);
            } else {
                makeNoInlineJar(application, patchDir, file, file2);
            }
        } else {
            ZipUtils.unJar(file, patchDir, (HashMap<String, File>) null, new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.endsWith(".dex");
                }
            });
            FileUtils.forceDelete(file);
            File[] listFiles = patchDir.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return file.getName().endsWith(".dex");
                }
            });
            if (listFiles == null) {
                return false;
            }
            for (File file3 : listFiles) {
                FileUtils.moveFile(file3, new File(patchDir, file3.getName().replace("classes", "patch")));
            }
            if (!PatchManager.isInsertHack(application)) {
                File file4 = new File(patchDir, PATCH_CLASSES_MAP);
                if (!file4.exists() || !file4.canRead()) {
                    throw new Exception("Invalid %s file.patchClassesMap.txt");
                } else if (!DalvikKnife.compare(new File(application.getApplicationInfo().sourceDir), file4, patchDir)) {
                    throw new Exception("Failed to handle dex file in dalvik vm.");
                }
            }
        }
        return true;
    }

    private static void makeNoInlineJar(Context context, File file, File file2, File file3) throws IOException {
        byte[] bArr = new byte[4096];
        File file4 = new File(file, DownloadManager.MODULE_DIR_TEMP);
        FileUtils.deleteDirectory(file4);
        if (file4.mkdirs()) {
            C126703 r10 = new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.endsWith(".dex");
                }
            };
            ZipUtils.unJar(file2, file4, (HashMap<String, File>) null, r10, bArr);
            int length = file4.list(r10).length;
            ZipFile zipFile = new ZipFile(new File(context.getPackageCodePath()));
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String name = zipEntry.getName();
                    if (name.endsWith(".dex") && !name.contains("/")) {
                        int dexIndex = getDexIndex(name);
                        if (dexIndex >= 0) {
                            ZipUtils.copyEntry(zipFile, zipEntry, new File(file4, String.format(Locale.ENGLISH, "classes%d.dex", new Object[]{Integer.valueOf(dexIndex + length)})), bArr);
                        }
                    }
                }
                ZipUtils.jar(file4, file3, bArr);
            } finally {
                zipFile.close();
                FileUtils.deleteDirectory(file4);
                FileUtils.forceDelete(file2);
            }
        } else {
            throw new IOException("failed to mkdirs: " + file4.getAbsolutePath());
        }
    }

    private static int getDexIndex(String str) {
        Matcher matcher = DEX_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return -1;
        }
        String group = matcher.group(1);
        if ("".equals(group)) {
            return 1;
        }
        return Integer.parseInt(group);
    }

    private static boolean verifyPatch(Context context, String str) {
        if (Build.VERSION.SDK_INT < 18) {
            return true;
        }
        if (!ZipVerifyUtils.verifyZip(context, str)) {
            Logger.log("DexDiffMerger verify" + str + " failed ! abort...", new Object[0]);
            return false;
        }
        Logger.log("DexDiffMerger verify" + str + " success !", new Object[0]);
        return true;
    }

    private static void delIfExist(File file) throws IOException {
        if (file != null && file.exists()) {
            FileUtils.forceDelete(file);
        }
    }
}
