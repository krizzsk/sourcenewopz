package com.didi.sdk.onehotpatch.commonstatic;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.didi.dynamic.manager.DownloadManager;
import com.didi.dynamic.manager.utils.Log;
import com.didi.dynamic.manager.utils.SharedPreferencesWrapper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.onehotpatch.commonstatic.bean.MetaBean;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.EncryptDecodeUtils;
import com.didi.sdk.onehotpatch.commonstatic.util.FileUtils;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;

public class PatchManager {
    private static final String APP_KEY = "hotpatch_app_key";
    private static final String FINGERPRINT = "fingerprint";
    private static final String HOST = "hotpatch_host";
    private static final String INSERT_HACK = "hotpatch_insert_hack";
    private static final String INSTALLED_PATCH_PROFILE = "installed_profile";
    private static final String INSTALLING_PATCH_PROFILE = "installing_profile";
    private static final String LOAD_PATCH_PROFILE = "load_profile";
    private static final String PATCH_APPVERSION = "patch_appveresion";
    public static final int PATCH_FLAG_ENABLE = 1;
    public static final int PATCH_FLAG_EVALUATING = 0;
    public static final int PATCH_FLAG_IGNORED = -100;
    public static final int PATCH_FLAG_UNEXPECTED_EXIT = -1;
    public static final int PATCH_FLAG_UNEXPECTED_EXIT_2 = -2;
    public static final int PATCH_FLAG_UNEXPECTED_EXIT_3 = -3;
    private static final String PATCH_HAS_NEW_PATCH = "patch_has_new_patch";
    private static final String PATCH_HOME = "/.one-hotpatch-home";
    private static final String PATCH_ODEX_DIR = "/odex";
    private static final String PATCH_SO_DIR = "patch_lib";
    private static final String PROVIDER_SUFFIX = ".hotpatch.provider";
    private static final String SP_HOTPATCH_ENABLED_FLAG = "hotpatch_enabled_flag";
    public static final String SP_HOTPATCH_PATCH_INFO = "hotpatch_patch_info";
    private static final String SP_KEY_ENABLE_LOG = "hotpatch_enable_log";

    private PatchManager() {
    }

    public static File getPatchHome(Context context) {
        return getPatchHome(context, true);
    }

    private static File getPatchHome(Context context, boolean z) {
        File file = new File(context.getFilesDir() + PATCH_HOME);
        if (z && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void clearPatch(Context context) throws IOException {
        FileUtils.deleteDirectory(getPatchHome(context, false));
        DownloadManager.getInstance(context).cleanModuleByModuleType(1);
        SharedPreferencesWrapper.m14516of(context, SP_HOTPATCH_ENABLED_FLAG, 0).edit().clear().commitNow();
    }

    public static File getPatchDir(Context context, PatchModule patchModule) {
        File patchHome = getPatchHome(context);
        File file = new File(patchHome, patchModule.appVersion + "/" + patchModule.version);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getPatchSoDir(Context context, PatchModule patchModule) {
        File file = new File(getPatchDir(context, patchModule), PATCH_SO_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static MetaBean getPatchMeta(Context context, PatchModule patchModule) throws Exception {
        return getPatchMeta(new File(getPatchDir(context, patchModule), "meta"));
    }

    public static MetaBean getPatchMeta(File file) throws Exception {
        MetaBean metaBean = new MetaBean();
        JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(file));
        metaBean.version = jSONObject.optString("version", "");
        metaBean.target_version = jSONObject.optString("target_version", "");
        metaBean.min_sdk = jSONObject.optInt("min_sdk", -1);
        metaBean.max_sdk = jSONObject.optInt("max_sdk", Integer.MAX_VALUE);
        metaBean.random = jSONObject.optString("random_matching", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject != null) {
            metaBean.ext = optJSONObject.toString();
        }
        return metaBean;
    }

    public static ArrayList<File> getPatchDexPath(Context context, PatchModule patchModule) {
        return getAllDex(getPatchDir(context, patchModule));
    }

    private static ArrayList<File> getAllDex(File file) {
        File[] fileArr;
        ArrayList<File> arrayList = new ArrayList<>();
        if (isArt()) {
            fileArr = file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.endsWith(".jar") && !str.equals("patch.jar");
                }
            });
        } else {
            fileArr = file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.endsWith(".dex");
                }
            });
        }
        if (fileArr != null) {
            Collections.addAll(arrayList, fileArr);
        }
        return arrayList;
    }

    public static File getPatchOdexDir(Context context, PatchModule patchModule) {
        File file = new File(getPatchDir(context, patchModule), PATCH_ODEX_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean isJiaGu(Application application) {
        if (isDelegateMode(application)) {
            return false;
        }
        return !application.getClass().getName().equals(application.getApplicationInfo().className);
    }

    public static boolean bangProtected(Context context) {
        return new File(context.getFilesDir().getParent(), ".cache/classes.dve").exists();
    }

    public static String getAppKey(Context context) {
        try {
            return SystemUtils.getApplicationInfo(context.getPackageManager(), WsgSecInfo.packageName(context), 128).metaData.getString(APP_KEY, (String) null);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.warn(e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0030 A[SYNTHETIC, Splitter:B:19:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0038 A[SYNTHETIC, Splitter:B:26:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T extends java.io.Serializable> T readBeanFromFile(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            java.io.File r2 = getPatchHome(r2)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            if (r2 != 0) goto L_0x0011
            return r0
        L_0x0011:
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            java.lang.Object r3 = r2.readObject()     // Catch:{ Exception -> 0x0025 }
            java.io.Serializable r3 = (java.io.Serializable) r3     // Catch:{ Exception -> 0x0025 }
            r2.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            return r3
        L_0x0025:
            r3 = move-exception
            goto L_0x002b
        L_0x0027:
            r3 = move-exception
            goto L_0x0036
        L_0x0029:
            r3 = move-exception
            r2 = r0
        L_0x002b:
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r3)     // Catch:{ all -> 0x0034 }
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            return r0
        L_0x0034:
            r3 = move-exception
            r0 = r2
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ IOException -> 0x003b }
        L_0x003b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.PatchManager.readBeanFromFile(android.content.Context, java.lang.String):java.io.Serializable");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e A[SYNTHETIC, Splitter:B:18:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034 A[SYNTHETIC, Splitter:B:23:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T extends java.io.Serializable> boolean writeBeanToFile(android.content.Context r2, java.lang.String r3, T r4) {
        /*
            r0 = 0
            java.io.File r2 = getPatchHome(r2)     // Catch:{ Exception -> 0x0027 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0027 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0027 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0027 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0027 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0027 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0027 }
            r2.writeObject(r4)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r2.close()     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r2.close()     // Catch:{ IOException -> 0x001d }
        L_0x001d:
            r2 = 1
            return r2
        L_0x001f:
            r3 = move-exception
            r0 = r2
            goto L_0x0032
        L_0x0022:
            r3 = move-exception
            r0 = r2
            goto L_0x0028
        L_0x0025:
            r3 = move-exception
            goto L_0x0032
        L_0x0027:
            r3 = move-exception
        L_0x0028:
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r3)     // Catch:{ all -> 0x0025 }
            r2 = 0
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            return r2
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r0.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.PatchManager.writeBeanToFile(android.content.Context, java.lang.String, java.io.Serializable):boolean");
    }

    private static boolean deleteProfileFile(Context context, String str) {
        File file = new File(getPatchHome(context), str);
        if (file.exists()) {
            return FileUtils.deleteQuietly(file);
        }
        return true;
    }

    private static void deletePatchFileAndDatabase(Context context, PatchModule patchModule) throws IOException {
        if (patchModule != null) {
            FileUtils.deleteDirectory(getPatchDir(context, patchModule));
            DownloadManager.getInstance(context).deleteModule(patchModule.moduleCode, patchModule.version);
        }
    }

    public static PatchModule getLoadPatch(Context context) throws IOException {
        return getLoadPatch(context, false);
    }

    public static PatchModule getLoadPatch(Context context, boolean z) throws IOException {
        if (z) {
            if (checkHasNewPatch(context)) {
                if (UtilsHub.isMainProcess(context)) {
                    setHasNewPatch(context, false);
                }
                PatchModule patchModule = (PatchModule) readBeanFromFile(context, LOAD_PATCH_PROFILE);
                PatchModule installedPatch = getInstalledPatch(context);
                if (installedPatch != null) {
                    writeBeanToFile(context, LOAD_PATCH_PROFILE, installedPatch);
                    deletePatchFileAndDatabase(context, patchModule);
                }
            }
            deleteProfileFile(context, INSTALLED_PATCH_PROFILE);
        }
        return (PatchModule) readBeanFromFile(context, LOAD_PATCH_PROFILE);
    }

    public static boolean deleteLoadPatch(Context context) {
        return deleteProfileFile(context, LOAD_PATCH_PROFILE);
    }

    public static boolean setInstalledPatch(Context context, PatchModule patchModule) throws IOException {
        deleteProfileFile(context, INSTALLING_PATCH_PROFILE);
        PatchModule loadPatch = getLoadPatch(context);
        boolean z = loadPatch == null || patchModule.versionLong != loadPatch.versionLong;
        setHasNewPatch(context, z);
        if (z) {
            return writeBeanToFile(context, INSTALLED_PATCH_PROFILE, patchModule);
        }
        return false;
    }

    public static PatchModule getInstalledPatch(Context context) {
        return (PatchModule) readBeanFromFile(context, INSTALLED_PATCH_PROFILE);
    }

    public static boolean setInstallingPatch(Context context, PatchModule patchModule) {
        return writeBeanToFile(context, INSTALLING_PATCH_PROFILE, patchModule);
    }

    public static PatchModule getInstallingPatch(Context context) {
        return (PatchModule) readBeanFromFile(context, INSTALLING_PATCH_PROFILE);
    }

    public static void deleteInstallingPatchAndDatabase(Context context) throws IOException {
        PatchModule installingPatch = getInstallingPatch(context);
        if (installingPatch != null) {
            Logger.log("delete install failed patch:" + installingPatch.version, new Object[0]);
            deleteInstallingPatchAndDatabase(context, installingPatch);
        }
    }

    public static void deleteInstallingPatchAndDatabase(Context context, PatchModule patchModule) throws IOException {
        deletePatchFileAndDatabase(context, patchModule);
        deleteProfileFile(context, INSTALLING_PATCH_PROFILE);
    }

    public static void rollBackLoadPatch(Context context) {
        deleteProfileFile(context, INSTALLING_PATCH_PROFILE);
        deleteProfileFile(context, INSTALLED_PATCH_PROFILE);
        deleteProfileFile(context, LOAD_PATCH_PROFILE);
        DownloadManager.getInstance(context).cleanModuleByModuleType(1);
    }

    public static String getHost(Context context) {
        try {
            String string = SystemUtils.getApplicationInfo(context.getPackageManager(), WsgSecInfo.packageName(context), 128).metaData.getString(HOST, (String) null);
            if (string != null) {
                return string;
            }
        } catch (PackageManager.NameNotFoundException e) {
            Logger.warn(e);
        }
        return EncryptDecodeUtils.decode("iuuqt://dpog.ejejubyj.dpn.do");
    }

    public static boolean isInsertHack(Context context) {
        try {
            return SystemUtils.getApplicationInfo(context.getPackageManager(), WsgSecInfo.packageName(context), 128).metaData.getBoolean(INSERT_HACK, false);
        } catch (PackageManager.NameNotFoundException e) {
            Logger.warn(e);
            return true;
        }
    }

    public static boolean canUsePatch(Application application) {
        return "".equals(checkJiaGu(application));
    }

    public static String checkPatchRuntime(Application application) {
        try {
            boolean z = false;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (!z && "handleBindApplication".equals(stackTraceElement.getMethodName()) && "android.app.ActivityThread".equals(stackTraceElement.getClassName())) {
                    z = true;
                } else if (z && !stackTraceElement.getClassName().startsWith("android.") && !stackTraceElement.getClassName().startsWith("java.") && !stackTraceElement.getClassName().startsWith("dalvik.") && !stackTraceElement.getClassName().startsWith("com.android.")) {
                    return Log.getStackTraceString(new AndroidRuntimeException("Check runtime fail. unknown method: " + stackTraceElement));
                }
            }
            if (!z) {
                return Log.getStackTraceString(new AndroidRuntimeException("Check runtime fail. android.app.ActivityThread.handleBindApplication was not found."));
            }
            return checkJiaGu(application);
        } catch (Throwable th) {
            return Log.getStackTraceString(new AndroidRuntimeException("Check runtime fail.", th));
        }
    }

    private static String checkJiaGu(Application application) {
        if (bangProtected(application) || !isJiaGu(application)) {
            return "";
        }
        if (isArt()) {
            if (Build.VERSION.SDK_INT < 24) {
                return "";
            }
            return "Check runtime fail. ART but JiaGu.";
        } else if (isInsertHack(application)) {
            return "";
        } else {
            return "Check runtime fail. No hack but JiaGu.";
        }
    }

    public static boolean isDelegateMode(Application application) {
        try {
            if (Class.forName("com.didi.sdk.onehotpatch.ONEHotpatchApplication").isAssignableFrom(Class.forName(application.getApplicationInfo().className))) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Logger.log("PatchManager  isDelegateMode false \n" + UtilsHub.dumpException(th), new Object[0]);
        }
    }

    public static boolean isArt() {
        String property;
        if (Build.VERSION.SDK_INT >= 21) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 19 && (property = System.getProperty("java.vm.version")) != null && property.startsWith("2")) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getValueFromContentProvider(android.content.Context r9, java.lang.String r10) {
        /*
            boolean r0 = com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub.isMainProcess(r9)
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = "hotpatch_patch_info"
            com.didi.dynamic.manager.utils.SharedPreferencesWrapper r9 = com.didi.dynamic.manager.utils.SharedPreferencesWrapper.m14516of(r9, r0, r1)
            java.lang.String r9 = r9.getString(r10, r2)
            return r9
        L_0x0013:
            r0 = 1
            java.lang.String[] r5 = new java.lang.String[r0]
            r5[r1] = r10
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch:{ all -> 0x0046 }
            android.net.Uri r4 = getProviderUri(r9)     // Catch:{ all -> 0x0046 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0046 }
            if (r9 == 0) goto L_0x0040
            boolean r0 = r9.moveToNext()     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0040
            int r10 = r9.getColumnIndex(r10)     // Catch:{ all -> 0x003d }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ all -> 0x003d }
            if (r9 == 0) goto L_0x003c
            r9.close()
        L_0x003c:
            return r10
        L_0x003d:
            r10 = move-exception
            r2 = r9
            goto L_0x0047
        L_0x0040:
            if (r9 == 0) goto L_0x0045
            r9.close()
        L_0x0045:
            return r2
        L_0x0046:
            r10 = move-exception
        L_0x0047:
            if (r2 == 0) goto L_0x004c
            r2.close()
        L_0x004c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.PatchManager.getValueFromContentProvider(android.content.Context, java.lang.String):java.lang.String");
    }

    private static void setValueToContentProvider(Context context, String str, String str2) {
        if (UtilsHub.isMainProcess(context)) {
            SharedPreferencesWrapper.m14516of(context, SP_HOTPATCH_PATCH_INFO, 0).edit().putString(str, str2).commitNow();
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        context.getContentResolver().insert(getProviderUri(context), contentValues);
    }

    private static Uri getProviderUri(Context context) {
        return Uri.parse("content://" + WsgSecInfo.packageName(context) + PROVIDER_SUFFIX);
    }

    public static String getFingerPrint(Context context) {
        return getValueFromContentProvider(context, FINGERPRINT);
    }

    public static void setFingerPrint(Context context, String str) {
        setValueToContentProvider(context, FINGERPRINT, str);
    }

    private static void setHasNewPatch(Context context, boolean z) {
        setValueToContentProvider(context, PATCH_HAS_NEW_PATCH, z ? "true" : SDKConsts.BOOLEAN_FALSE);
    }

    public static boolean checkHasNewPatch(Context context) {
        return "true".equals(getValueFromContentProvider(context, PATCH_HAS_NEW_PATCH));
    }

    public static void checkHasNewPatchAndKillProcess(Context context) {
        if (checkHasNewPatch(context)) {
            Logger.info("KillProcess for new patch!", new Object[0]);
            System.exit(0);
        }
    }

    public static boolean isAppUpgraded(Context context) {
        String versionNameAndCode = UtilsHub.getVersionNameAndCode(context);
        if (!TextUtils.isEmpty(versionNameAndCode)) {
            String appVersion = getAppVersion(context);
            return appVersion == null || !appVersion.equals(versionNameAndCode);
        }
        throw new IllegalArgumentException("getVersionNameAndCode returns empty.");
    }

    public static void checkAppUpgraded(Context context) throws IOException {
        String versionNameAndCode = UtilsHub.getVersionNameAndCode(context);
        if (!TextUtils.isEmpty(versionNameAndCode)) {
            String appVersion = getAppVersion(context);
            if (appVersion == null || !appVersion.equals(versionNameAndCode)) {
                try {
                    clearPatch(context);
                } finally {
                    setAppVersion(context, versionNameAndCode);
                }
            }
        } else {
            throw new IllegalArgumentException("getVersionNameAndCode returns empty.");
        }
    }

    private static String getAppVersion(Context context) {
        return getValueFromContentProvider(context, PATCH_APPVERSION);
    }

    private static void setAppVersion(Context context, String str) {
        setValueToContentProvider(context, PATCH_APPVERSION, str);
    }

    public static int getEnabledFlag(Context context, PatchModule patchModule) {
        return SharedPreferencesWrapper.m14516of(context, SP_HOTPATCH_ENABLED_FLAG, 0).getInt(patchModule.version, 0);
    }

    public static void setEnabledFlag(Context context, PatchModule patchModule, int i) {
        if (patchModule != null) {
            SharedPreferencesWrapper.m14516of(context, SP_HOTPATCH_ENABLED_FLAG, 0).edit().putInt(patchModule.version, i).commitNow();
        }
    }

    public static boolean getEnableLog(Context context) {
        return SharedPreferencesWrapper.m14516of(context, SP_HOTPATCH_ENABLED_FLAG, 0).getBoolean(SP_KEY_ENABLE_LOG, false);
    }

    public static void setEnableLog(Context context, boolean z) {
        SharedPreferencesWrapper.m14516of(context, SP_HOTPATCH_ENABLED_FLAG, 0).edit().putBoolean(SP_KEY_ENABLE_LOG, z).commitNow();
    }

    public static int getLoadedCount(Context context, PatchModule patchModule) {
        SharedPreferencesWrapper of = SharedPreferencesWrapper.m14516of(context, SP_HOTPATCH_ENABLED_FLAG, 0);
        return of.getInt("count_" + patchModule.version, 0);
    }

    public static void setLoadedCount(Context context, PatchModule patchModule, int i) {
        SharedPreferencesWrapper.Editor edit = SharedPreferencesWrapper.m14516of(context, SP_HOTPATCH_ENABLED_FLAG, 0).edit();
        edit.putInt("count_" + patchModule.version, i).commitNow();
    }
}
