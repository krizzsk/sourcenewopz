package com.didi.sdk.onehotpatch.installer.dexopt;

import android.app.IntentService;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.didi.sdk.onehotpatch.ShareReflectUtil;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.ConfigManager;
import com.didi.sdk.onehotpatch.commonstatic.util.FileUtils;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.security.safecollector.WsgSecInfo;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DexOptService extends IntentService {
    public static final String ACTION_DEXOPT = "action_dexopt";
    private static final String DEX_SUFFIX = ".dex";
    public static final String KEY_IS_OTA = "key_is_ota";
    public static final String KEY_MODULE = "key_module";
    public static final String ODEX_SUFFIX = ".odex";
    private static final int SHELL_COMMAND_TRANSACTION = 1598246212;
    public static final String VDEX_SUFFIX = ".vdex";
    private static String currentInstructionSet = null;
    private static final ResultReceiver sEmptyResultReceiver = new ResultReceiver(sHandler);
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    private static final IBinder[] sPMSBinderProxy = {null};
    private static final PackageManager[] sSynchronizedPMCache = {null};

    public DexOptService() {
        super("DexOptService");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a8 A[SYNTHETIC, Splitter:B:33:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "install"
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "DexOptService start"
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.info(r3, r2)
            if (r7 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.String r2 = r7.getAction()
            java.lang.String r3 = "action_dexopt"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x001a
            return
        L_0x001a:
            r2 = -2
            r3 = 0
            com.didi.sdk.apm.SystemUtils.setProcessThreadPriority(r2)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "key_module"
            java.io.Serializable r2 = r7.getSerializableExtra(r2)     // Catch:{ all -> 0x0076 }
            boolean r4 = r2 instanceof com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule     // Catch:{ all -> 0x0076 }
            if (r4 == 0) goto L_0x006e
            com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule r2 = (com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule) r2     // Catch:{ all -> 0x0076 }
            r4 = 1
            com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent.trackDexopt(r6, r2, r4, r3)     // Catch:{ all -> 0x006b }
            java.lang.String r4 = "key_is_ota"
            boolean r7 = r7.getBooleanExtra(r4, r1)     // Catch:{ all -> 0x006b }
            if (r7 == 0) goto L_0x003d
            com.didi.sdk.onehotpatch.commonstatic.PatchManager.deleteLoadPatch(r6)     // Catch:{ all -> 0x006b }
            com.didi.sdk.onehotpatch.commonstatic.PatchManager.setInstallingPatch(r6, r2)     // Catch:{ all -> 0x006b }
        L_0x003d:
            java.util.ArrayList r7 = com.didi.sdk.onehotpatch.commonstatic.PatchManager.getPatchDexPath(r6, r2)     // Catch:{ all -> 0x006b }
            java.io.File r4 = com.didi.sdk.onehotpatch.commonstatic.PatchManager.getPatchOdexDir(r6, r2)     // Catch:{ all -> 0x006b }
            boolean r7 = r6.dexopt(r7, r4)     // Catch:{ all -> 0x006b }
            if (r7 == 0) goto L_0x0063
            com.didi.sdk.onehotpatch.commonstatic.PatchManager.setInstalledPatch(r6, r2)     // Catch:{ all -> 0x006b }
            java.lang.String r7 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x006b }
            com.didi.sdk.onehotpatch.commonstatic.PatchManager.setFingerPrint(r6, r7)     // Catch:{ all -> 0x006b }
            com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent.trackDexopt(r6, r2, r1, r3)     // Catch:{ all -> 0x006b }
            java.lang.String r7 = "DexOptService: patch success, restart will effect!"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x006b }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.info(r7, r3)     // Catch:{ all -> 0x006b }
            java.lang.String r7 = r2.ext     // Catch:{ all -> 0x006b }
            com.didi.sdk.onehotpatch.openapi.HotpatchStateBroadcast.sendPatchDownloadState(r6, r0, r1, r7)     // Catch:{ all -> 0x006b }
            goto L_0x00d4
        L_0x0063:
            java.lang.Exception r7 = new java.lang.Exception     // Catch:{ all -> 0x006b }
            java.lang.String r3 = "DexOptService dexopt patch failed"
            r7.<init>(r3)     // Catch:{ all -> 0x006b }
            throw r7     // Catch:{ all -> 0x006b }
        L_0x006b:
            r7 = move-exception
            r3 = r2
            goto L_0x0077
        L_0x006e:
            java.lang.Exception r7 = new java.lang.Exception     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "DexOptService module is null"
            r7.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r7     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r7 = move-exception
        L_0x0077:
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r4 = "DexOptService failed!"
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.info(r4, r2)
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r7)
            java.lang.String r2 = r3.ext
            r4 = -1
            com.didi.sdk.onehotpatch.openapi.HotpatchStateBroadcast.sendPatchDownloadState(r6, r0, r4, r2)
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "local_test"
            r0.<init>(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = r6.getPackageName()     // Catch:{ all -> 0x00a2 }
            r0.setPackage(r2)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "key_msg"
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x00a2 }
            r0.putExtra(r2, r5)     // Catch:{ all -> 0x00a2 }
            r6.sendBroadcast(r0)     // Catch:{ all -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r0 = move-exception
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r0)
        L_0x00a6:
            if (r3 == 0) goto L_0x00d4
            java.lang.String r0 = com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub.dumpException(r7)     // Catch:{ all -> 0x00d0 }
            com.didi.sdk.onehotpatch.commonstatic.report.HotPatchEvent.trackDexopt(r6, r3, r4, r7)     // Catch:{ all -> 0x00d0 }
            com.didi.sdk.onehotpatch.commonstatic.PatchManager.deleteInstallingPatchAndDatabase(r6, r3)     // Catch:{ all -> 0x00d0 }
            com.didi.sdk.onehotpatch.commonstatic.report.Report$ReportModule r7 = new com.didi.sdk.onehotpatch.commonstatic.report.Report$ReportModule     // Catch:{ all -> 0x00d0 }
            r7.<init>()     // Catch:{ all -> 0x00d0 }
            r7.isLoadSuccess = r1     // Catch:{ all -> 0x00d0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r1.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r2 = "DexOptService:"
            r1.append(r2)     // Catch:{ all -> 0x00d0 }
            r1.append(r0)     // Catch:{ all -> 0x00d0 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00d0 }
            r7.errorMsg = r0     // Catch:{ all -> 0x00d0 }
            com.didi.sdk.onehotpatch.commonstatic.report.Report.report(r6, r3, r7)     // Catch:{ all -> 0x00d0 }
            goto L_0x00d4
        L_0x00d0:
            r7 = move-exception
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r7)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.installer.dexopt.DexOptService.onHandleIntent(android.content.Intent):void");
    }

    private int exec(File file, String str, StringBuilder sb, StringBuilder sb2) throws IOException {
        Process exec = Runtime.getRuntime().exec(str, (String[]) null, file);
        try {
            exec.waitFor();
            int exitValue = exec.exitValue();
            if (sb != null) {
                sb.delete(0, sb.length());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append(10);
                }
            }
            if (sb2 != null) {
                sb2.delete(0, sb2.length());
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
                while (true) {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb2.append(readLine2);
                    sb2.append(10);
                }
            }
            exec.destroy();
            return exitValue;
        } catch (InterruptedException e) {
            throw new IOException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x016b, code lost:
        com.didi.sdk.onehotpatch.commonstatic.log.Logger.log("invoke dex2oat completed.", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0174, code lost:
        if (r1[0] != 0) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0176, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0199, code lost:
        throw new java.io.IOException("invoke dex2oat failed. resultCode: " + r1[0] + " result: " + r2[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01a2, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01a3, code lost:
        r5.recycle();
        r7.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01a9, code lost:
        throw r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01aa, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01b2, code lost:
        throw new java.io.IOException("create classloader failed.", r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0204, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x020c, code lost:
        throw new java.io.IOException("invoke dex2oat failed.", r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x020d, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x020e, code lost:
        throw r14;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x020d A[ExcHandler: IOException (r14v1 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:4:0x0012] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dexoptForQ(android.content.Context r14, java.util.ArrayList<java.io.File> r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x0007
            return
        L_0x0007:
            java.io.File r0 = new java.io.File
            java.io.File r1 = r14.getFilesDir()
            java.lang.String r2 = "hotpatch-dexopt"
            r0.<init>(r1, r2)
            int r1 = r15.size()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r2 = 1
            if (r1 != r2) goto L_0x01ed
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r1.<init>()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r3.<init>()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r4 = "rm -rf "
            r3.append(r4)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r4 = r0.getPath()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r3.append(r4)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r4 = 0
            int r3 = r13.exec(r4, r3, r4, r1)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r5 = ", err: "
            if (r3 != 0) goto L_0x01d0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r3.<init>()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r6 = "ln -s "
            r3.append(r6)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r6 = 0
            java.lang.Object r7 = r15.get(r6)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.io.File r7 = (java.io.File) r7     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.io.File r7 = r7.getParentFile()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r7 = r7.getPath()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r3.append(r7)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r7 = " "
            r3.append(r7)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r7 = r0.getPath()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r3.append(r7)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            int r3 = r13.exec(r4, r3, r4, r1)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            if (r3 != 0) goto L_0x01b3
            int r1 = r15.size()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            int r3 = r15.size()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r5 = 0
        L_0x007b:
            int r7 = r15.size()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            if (r5 >= r7) goto L_0x00a5
            java.lang.Object r7 = r15.get(r5)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.io.File r7 = (java.io.File) r7     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r7 = r7.getPath()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r1[r5] = r7     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.io.File r7 = new java.io.File     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.Object r8 = r15.get(r5)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.io.File r8 = (java.io.File) r8     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r8 = r8.getName()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r7.<init>(r0, r8)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r7 = r7.getPath()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r3[r5] = r7     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            int r5 = r5 + 1
            goto L_0x007b
        L_0x00a5:
            java.lang.String r15 = java.io.File.pathSeparator     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            android.text.TextUtils.join(r15, r1)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r15 = java.io.File.pathSeparator     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r15 = android.text.TextUtils.join(r15, r3)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            dalvik.system.PathClassLoader r0 = new dalvik.system.PathClassLoader     // Catch:{ Exception -> 0x01aa, IOException -> 0x020d }
            java.lang.ClassLoader r1 = r13.getClassLoader()     // Catch:{ Exception -> 0x01aa, IOException -> 0x020d }
            java.lang.ClassLoader r1 = r1.getParent()     // Catch:{ Exception -> 0x01aa, IOException -> 0x020d }
            r0.<init>(r15, r1)     // Catch:{ Exception -> 0x01aa, IOException -> 0x020d }
            java.lang.Class r15 = r13.getClass()     // Catch:{ Exception -> 0x01aa, IOException -> 0x020d }
            java.lang.String r15 = r15.getName()     // Catch:{ Exception -> 0x01aa, IOException -> 0x020d }
            r0.loadClass(r15)     // Catch:{ Exception -> 0x01aa, IOException -> 0x020d }
            r15 = 6
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r0 = "compile"
            r15[r6] = r0     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r0 = "-r"
            r15[r2] = r0     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r0 = 2
            java.lang.String r1 = "install"
            r15[r0] = r1     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r0 = 3
            java.lang.String r1 = "-f"
            r15[r0] = r1     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r0 = 4
            java.lang.String r1 = "--secondary-dex"
            r15[r0] = r1     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r0 = 5
            java.lang.String r1 = com.didichuxing.security.safecollector.WsgSecInfo.packageName(r14)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15[r0] = r1     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            int[] r1 = new int[r2]     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r3 = 127(0x7f, float:1.78E-43)
            r1[r6] = r3     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            android.os.Bundle[] r2 = new android.os.Bundle[r2]     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            android.content.pm.PackageManager r3 = r14.getPackageManager()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r5 = "mPM"
            java.lang.reflect.Field r3 = com.didi.sdk.onehotpatch.commonstatic.util.ReflectUtil.findField(r3, r5)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            android.content.pm.PackageManager r14 = r14.getPackageManager()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.Object r14 = r3.get(r14)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            android.os.IInterface r14 = (android.os.IInterface) r14     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            android.os.IBinder r14 = r14.asBinder()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            com.didi.sdk.onehotpatch.installer.dexopt.DexOptService$1 r3 = new com.didi.sdk.onehotpatch.installer.dexopt.DexOptService$1     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r9 = 0
            r7 = r3
            r8 = r13
            r10 = r1
            r11 = r2
            r12 = r0
            r7.<init>(r9, r10, r11, r12)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            android.os.Parcel r5 = android.os.Parcel.obtain()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            android.os.Parcel r7 = android.os.Parcel.obtain()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.io.FileDescriptor r8 = java.io.FileDescriptor.in     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r5.writeFileDescriptor(r8)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.io.FileDescriptor r8 = java.io.FileDescriptor.out     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r5.writeFileDescriptor(r8)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.io.FileDescriptor r8 = java.io.FileDescriptor.err     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r5.writeFileDescriptor(r8)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r5.writeStringArray(r15)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r5.writeStrongBinder(r4)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r3.writeToParcel(r5, r6)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15 = 1598246212(0x5f434d44, float:1.4072979E19)
            r14.transact(r15, r5, r7, r6)     // Catch:{ all -> 0x01a2 }
            r7.readException()     // Catch:{ all -> 0x01a2 }
            r5.recycle()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r7.recycle()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            long r14 = android.os.SystemClock.uptimeMillis()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r3 = 300000(0x493e0, double:1.482197E-318)
            long r14 = r14 + r3
        L_0x0150:
            java.lang.String r3 = "waiting dex2oat..."
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r3, r4)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            long r3 = r14 - r3
            r7 = 0
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x019a
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0150, IOException -> 0x020d }
            boolean r3 = r0.await(r3, r5)     // Catch:{ Exception -> 0x0150, IOException -> 0x020d }
            if (r3 == 0) goto L_0x0150
            java.lang.String r3 = "invoke dex2oat completed."
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0150, IOException -> 0x020d }
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.log(r3, r4)     // Catch:{ Exception -> 0x0150, IOException -> 0x020d }
            r14 = r1[r6]     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            if (r14 != 0) goto L_0x0177
            return
        L_0x0177:
            java.io.IOException r14 = new java.io.IOException     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.<init>()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r0 = "invoke dex2oat failed. resultCode: "
            r15.append(r0)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r0 = r1[r6]     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.append(r0)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r0 = " result: "
            r15.append(r0)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r0 = r2[r6]     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.append(r0)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r15 = r15.toString()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r14.<init>(r15)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            throw r14     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
        L_0x019a:
            java.io.IOException r14 = new java.io.IOException     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r15 = "dex2oat timeout."
            r14.<init>(r15)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            throw r14     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
        L_0x01a2:
            r14 = move-exception
            r5.recycle()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r7.recycle()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            throw r14     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
        L_0x01aa:
            r14 = move-exception
            java.io.IOException r15 = new java.io.IOException     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r0 = "create classloader failed."
            r15.<init>(r0, r14)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            throw r15     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
        L_0x01b3:
            java.io.IOException r14 = new java.io.IOException     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.<init>()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r0 = "mkdir cache dir failed. returnCode: "
            r15.append(r0)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.append(r3)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.append(r5)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.append(r1)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r15 = r15.toString()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r14.<init>(r15)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            throw r14     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
        L_0x01d0:
            java.io.IOException r14 = new java.io.IOException     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.<init>()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r0 = "remove cache dir failed. returnCode: "
            r15.append(r0)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.append(r3)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.append(r5)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r15.append(r1)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r15 = r15.toString()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r14.<init>(r15)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            throw r14     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
        L_0x01ed:
            java.io.IOException r14 = new java.io.IOException     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r0.<init>()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r1 = "unknown dexPaths: "
            r0.append(r1)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r0.append(r15)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            java.lang.String r15 = r0.toString()     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            r14.<init>(r15)     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
            throw r14     // Catch:{ IOException -> 0x020d, Exception -> 0x0204 }
        L_0x0204:
            r14 = move-exception
            java.io.IOException r15 = new java.io.IOException
            java.lang.String r0 = "invoke dex2oat failed."
            r15.<init>(r0, r14)
            throw r15
        L_0x020d:
            r14 = move-exception
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.installer.dexopt.DexOptService.dexoptForQ(android.content.Context, java.util.ArrayList):void");
    }

    public boolean dexopt(ArrayList<File> arrayList, File file) throws IOException {
        File[] listFiles;
        if (arrayList.isEmpty()) {
            return true;
        }
        FileUtils.deleteDirectory(file);
        file.mkdirs();
        long currentTimeMillis = System.currentTimeMillis();
        if (ConfigManager.isSwitchAndroid12()) {
            Logger.log("DexOptService: SwitchAndroid12: ", new Object[0]);
            String optimizedPathFor2 = optimizedPathFor2(arrayList.get(0), file);
            if (Build.VERSION.SDK_INT < 26 && (Build.VERSION.SDK_INT < 25 || Build.VERSION.PREVIEW_SDK_INT == 0)) {
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    DexFile.loadDex(next.getPath(), optimizedPathFor(next, file), 0);
                }
            } else if (Build.VERSION.SDK_INT >= 31 || (Build.VERSION.SDK_INT == 30 && Build.VERSION.PREVIEW_SDK_INT != 0)) {
                triggerPMDexOptOnDemand(this, arrayList.get(0).getAbsolutePath(), optimizedPathFor2);
                waitUntilVdexGeneratedOrTimeout(this, optimizedPathFor2.substring(0, optimizedPathFor2.lastIndexOf(ODEX_SUFFIX)) + VDEX_SUFFIX);
            } else {
                triggerPMDexOptOnDemand(this, arrayList.get(0).getAbsolutePath(), optimizedPathFor2);
            }
        } else if (Build.VERSION.SDK_INT >= 29) {
            IOException e = null;
            int i = 3;
            while (i > 0) {
                try {
                    dexoptForQ(this, arrayList);
                    break;
                } catch (IOException e2) {
                    e = e2;
                    if (e.getMessage() == null || !e.getMessage().startsWith("invoke dex2oat failed. resultCode: -1 ")) {
                        throw e;
                    }
                    i--;
                    Logger.log("DexOptService: retry count: " + i, new Object[0]);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            if (i > 0) {
                Logger.log("DexOptService: dexopt duration:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                return true;
            }
            throw new IOException("Dexopt failed too many times.", e);
        } else {
            Iterator<File> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                File next2 = it2.next();
                DexFile.loadDex(next2.getPath(), optimizedPathFor(next2, file), 0);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            if (arrayList.size() == 1) {
                try {
                    String[] strArr = new String[arrayList.size()];
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        strArr[i2] = arrayList.get(i2).getPath();
                    }
                    new PathClassLoader(TextUtils.join(File.pathSeparator, strArr), getClassLoader().getParent()).loadClass(getClass().getName());
                    Logger.log("DexOptService: dexopt duration:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                    return true;
                } catch (Exception e3) {
                    throw new IOException("preload classloader failed.", e3);
                }
            } else {
                throw new IOException("unknown dexPaths: " + arrayList);
            }
        } else if (PatchManager.isArt() && ((listFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(DexOptService.DEX_SUFFIX);
            }
        })) == null || listFiles.length == 0)) {
            return false;
        } else {
            Logger.log("DexOptService: dexopt duration:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return true;
        }
    }

    private String optimizedPathFor(File file, File file2) {
        String name = file.getName();
        if (!name.endsWith(DEX_SUFFIX)) {
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf < 0) {
                name = name + DEX_SUFFIX;
            } else {
                StringBuilder sb = new StringBuilder(lastIndexOf + 4);
                sb.append(name, 0, lastIndexOf);
                sb.append(DEX_SUFFIX);
                name = sb.toString();
            }
        }
        return new File(file2, name).getPath();
    }

    private static void executePMSShellCommand(Context context, String[] strArr) throws IllegalStateException {
        Parcel parcel;
        IBinder pMSBinderProxy = getPMSBinderProxy(context);
        long clearCallingIdentity = Binder.clearCallingIdentity();
        Parcel parcel2 = null;
        try {
            Logger.log("[+] Execute shell cmd, args: %s", Arrays.toString(strArr));
            Parcel obtain = Parcel.obtain();
            try {
                parcel = Parcel.obtain();
            } catch (Throwable th) {
                th = th;
                parcel = null;
                parcel2 = obtain;
                try {
                    throw new IllegalStateException("Failure on executing shell cmd.", th);
                } catch (Throwable th2) {
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    if (parcel2 != null) {
                        parcel2.recycle();
                    }
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    throw th2;
                }
            }
            try {
                obtain.writeFileDescriptor(FileDescriptor.in);
                obtain.writeFileDescriptor(FileDescriptor.out);
                obtain.writeFileDescriptor(FileDescriptor.err);
                obtain.writeStringArray(strArr);
                obtain.writeStrongBinder((IBinder) null);
                sEmptyResultReceiver.writeToParcel(obtain, 0);
                pMSBinderProxy.transact(SHELL_COMMAND_TRANSACTION, obtain, parcel, 0);
                parcel.readException();
                Logger.log("[+] Execute shell cmd done.", new Object[0]);
                if (parcel != null) {
                    parcel.recycle();
                }
                if (obtain != null) {
                    obtain.recycle();
                }
                Binder.restoreCallingIdentity(clearCallingIdentity);
            } catch (Throwable th3) {
                th = th3;
                parcel2 = obtain;
                throw new IllegalStateException("Failure on executing shell cmd.", th);
            }
        } catch (Throwable th4) {
            th = th4;
            parcel = null;
            throw new IllegalStateException("Failure on executing shell cmd.", th);
        }
    }

    private static void registerDexModule(Context context, String str) throws IllegalStateException {
        PackageManager synchronizedPackageManager = getSynchronizedPackageManager(context);
        try {
            ShareReflectUtil.findMethod((Object) synchronizedPackageManager, "registerDexModule", (Class<?>[]) new Class[]{String.class, Class.forName("android.content.pm.PackageManager$DexModuleRegisterCallback")}).invoke(synchronizedPackageManager, new Object[]{str, null});
        } catch (InvocationTargetException e) {
            throw new IllegalStateException(e.getTargetException());
        } catch (Throwable th) {
            if (th instanceof IllegalStateException) {
                throw th;
            }
            throw new IllegalStateException(th);
        }
    }

    private static final PackageManager getSynchronizedPackageManager(Context context) throws IllegalStateException {
        synchronized (sSynchronizedPMCache) {
            try {
                if (sSynchronizedPMCache[0] != null) {
                    synchronized (sPMSBinderProxy) {
                        if (sPMSBinderProxy[0] != null && sPMSBinderProxy[0].isBinderAlive()) {
                            PackageManager packageManager = sSynchronizedPMCache[0];
                            return packageManager;
                        }
                    }
                }
                final IBinder pMSBinderProxy = getPMSBinderProxy(context);
                Object invoke = ShareReflectUtil.findMethod(Class.forName("android.content.pm.IPackageManager$Stub"), "asInterface", (Class<?>[]) new Class[]{IBinder.class}).invoke((Object) null, new Object[]{(IBinder) Proxy.newProxyInstance(context.getClassLoader(), pMSBinderProxy.getClass().getInterfaces(), new InvocationHandler() {
                    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        if ("transact".equals(method.getName())) {
                            objArr[3] = 0;
                        }
                        return method.invoke(pMSBinderProxy, objArr);
                    }
                })});
                Class<?> cls = Class.forName("android.app.ApplicationPackageManager");
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
                PackageManager packageManager2 = (PackageManager) ShareReflectUtil.findConstructor(cls, (Class<?>[]) new Class[]{context.getClass(), Class.forName("android.content.pm.IPackageManager")}).newInstance(new Object[]{context, invoke});
                sSynchronizedPMCache[0] = packageManager2;
                return packageManager2;
            } catch (InvocationTargetException e) {
                throw new IllegalStateException(e.getTargetException());
            } catch (Throwable th) {
                if (th instanceof IllegalStateException) {
                    throw th;
                }
                throw new IllegalStateException(th);
            }
        }
    }

    private static IBinder getPMSBinderProxy(Context context) throws IllegalStateException {
        synchronized (sPMSBinderProxy) {
            IBinder iBinder = sPMSBinderProxy[0];
            if (iBinder != null && iBinder.isBinderAlive()) {
                return iBinder;
            }
            try {
                Method findMethod = ShareReflectUtil.findMethod(Class.forName("android.os.ServiceManager"), "getService", (Class<?>[]) new Class[]{String.class});
                sPMSBinderProxy[0] = (IBinder) findMethod.invoke((Object) null, new Object[]{"package"});
                IBinder iBinder2 = sPMSBinderProxy[0];
                return iBinder2;
            } catch (Throwable th) {
                if (th instanceof InvocationTargetException) {
                    throw new IllegalStateException(th.getTargetException());
                }
                throw new IllegalStateException(th);
            }
        }
    }

    private static File getOatFinishedMarkerFile(String str) {
        return new File(str + ".oat_fine");
    }

    private static void triggerPMDexOptOnDemand(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            Logger.log("[+] Not API 29, 30 and newer device, skip triggering dexopt.", new Object[0]);
            return;
        }
        Logger.info("[+] Hit target device, do dexopt logic now.", new Object[0]);
        try {
            File file = new File(str2);
            File oatFinishedMarkerFile = getOatFinishedMarkerFile(str);
            if (!file.exists()) {
                if (oatFinishedMarkerFile.exists()) {
                    oatFinishedMarkerFile.delete();
                }
            } else if (!oatFinishedMarkerFile.exists()) {
                file.delete();
            } else {
                Logger.log("[+] Oat file %s should be valid, skip triggering dexopt.", str2);
                return;
            }
            int i = 0;
            while (true) {
                reconcileSecondaryDexFiles(context);
                try {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file.createNewFile();
                } catch (Throwable th) {
                    Logger.warn(th);
                }
                if (isNewerOrEqualThanVersion(31, true)) {
                    try {
                        registerDexModule(context, str);
                    } catch (Throwable th2) {
                        Logger.warn(th2);
                    }
                    if (checkAndMarkIfOatExists(file, oatFinishedMarkerFile, "registerDexModule")) {
                        return;
                    }
                }
                try {
                    performDexOptSecondary(context);
                } catch (Throwable th3) {
                    Logger.warn(th3);
                }
                if (!checkAndMarkIfOatExists(file, oatFinishedMarkerFile, "performDexOptSecondary")) {
                    if (Payload.SOURCE_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) || "honor".equalsIgnoreCase(Build.MANUFACTURER)) {
                        try {
                            registerDexModule(context, str);
                        } catch (Throwable th4) {
                            Logger.warn(th4);
                        }
                        if (checkAndMarkIfOatExists(file, oatFinishedMarkerFile, "registerDexModule for hw dev")) {
                            return;
                        }
                    }
                    if (i < 3) {
                        Logger.log("[!] No odex file was generated, wait for retry.", new Object[0]);
                        i++;
                        SystemClock.sleep(5000);
                    } else {
                        throw new IllegalStateException("Dexopt was triggered, but no odex file was generated.");
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable th5) {
            Logger.log("DexOptService: support12  dexopt failed", new Object[0]);
            Logger.warn(th5);
        }
    }

    private static void reconcileSecondaryDexFiles(Context context) throws IllegalStateException {
        executePMSShellCommand(context, new String[]{"reconcile-secondary-dex-files", WsgSecInfo.packageName(context)});
    }

    private static boolean checkAndMarkIfOatExists(File file, File file2, String str) {
        if (file.exists()) {
            Logger.info("[+] Oat file %s is found after %s", file.getPath(), str);
            try {
                file2.createNewFile();
            } catch (Throwable th) {
                Logger.warn(th);
            }
            return true;
        }
        Logger.info("[-] Oat file %s does not exist after %s.", file.getPath(), str);
        return false;
    }

    private static void performDexOptSecondary(Context context) throws IllegalStateException {
        String[] strArr = new String[6];
        strArr[0] = "compile";
        strArr[1] = "-f";
        strArr[2] = "--secondary-dex";
        strArr[3] = "-m";
        strArr[4] = isNewerOrEqualThanVersion(31, true) ? LoginOmegaUtil.NEED_VERIFY_EMAIL : "speed-profile";
        strArr[5] = WsgSecInfo.packageName(context);
        executePMSShellCommand(context, strArr);
    }

    public static boolean isNewerOrEqualThanVersion(int i, boolean z) {
        if (!z || Build.VERSION.SDK_INT < 23) {
            if (Build.VERSION.SDK_INT >= i) {
                return true;
            }
            return false;
        } else if (Build.VERSION.SDK_INT >= i || (Build.VERSION.SDK_INT == i - 1 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAfterAndroidO() {
        return Build.VERSION.SDK_INT > 25;
    }

    public static String getCurrentInstructionSet() throws Exception {
        String str = currentInstructionSet;
        if (str != null) {
            return str;
        }
        currentInstructionSet = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke((Object) null, new Object[0]);
        Logger.info("getCurrentInstructionSet:" + currentInstructionSet, new Object[0]);
        return currentInstructionSet;
    }

    public static String optimizedPathFor2(File file, File file2) {
        if (isAfterAndroidO()) {
            try {
                String currentInstructionSet2 = getCurrentInstructionSet();
                File parentFile = file.getParentFile();
                String name = file.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    name = name.substring(0, lastIndexOf);
                }
                return parentFile.getAbsolutePath() + "/oat/" + currentInstructionSet2 + "/" + name + ODEX_SUFFIX;
            } catch (Exception e) {
                throw new RuntimeException("getCurrentInstructionSet fail:", e);
            }
        } else {
            String name2 = file.getName();
            if (!name2.endsWith(DEX_SUFFIX)) {
                int lastIndexOf2 = name2.lastIndexOf(".");
                if (lastIndexOf2 < 0) {
                    name2 = name2 + DEX_SUFFIX;
                } else {
                    StringBuilder sb = new StringBuilder(lastIndexOf2 + 4);
                    sb.append(name2, 0, lastIndexOf2);
                    sb.append(DEX_SUFFIX);
                    name2 = sb.toString();
                }
            }
            return new File(file2, name2).getPath();
        }
    }

    private static boolean waitUntilVdexGeneratedOrTimeout(Context context, String str) {
        File file = new File(str);
        long[] jArr = {1000, 2000, Const.DELAY_TIME4LAST_GPS_TASK, 8000, 16000, 32000};
        int i = 0;
        while (!file.exists() && i < 6) {
            int i2 = i + 1;
            SystemClock.sleep(jArr[i]);
            Logger.info("[!] Vdex %s does not exist after waiting %s time(s), wait again.", str, Integer.valueOf(i2));
            i = i2;
        }
        if (file.exists()) {
            Logger.info("[+] Vdex %s was found.", str);
            return true;
        }
        Logger.info("[-] Vdex %s does not exist after waiting for %s times.", str, 6);
        return false;
    }
}
