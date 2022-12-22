package com.facebook.soloader;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.facebook.soloader.nativeloader.NativeLoader;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;

public class SoLoader {
    static final boolean DEBUG = false;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    private static final String SO_STORE_NAME_MAIN = "lib-main";
    private static final String SO_STORE_NAME_SPLIT = "lib-";
    static final boolean SYSTRACE_LIBRARY_LOADING;
    static final String TAG = "SoLoader";
    private static boolean isSystemApp;
    @Nullable
    private static ApplicationSoSource sApplicationSoSource;
    @Nullable
    private static UnpackingSoSource[] sBackupSoSources;
    private static int sFlags;
    private static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    /* access modifiers changed from: private */
    public static final HashSet<String> sLoadedLibraries = new HashSet<>();
    /* access modifiers changed from: private */
    public static final Map<String, Object> sLoadingLibraries = new HashMap();
    @Nullable
    static SoFileLoader sSoFileLoader;
    /* access modifiers changed from: private */
    @Nullable
    public static SoSource[] sSoSources = null;
    /* access modifiers changed from: private */
    public static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    private static volatile int sSoSourcesVersion = 0;
    @Nullable
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    static /* synthetic */ int access$208() {
        int i = sSoSourcesVersion;
        sSoSourcesVersion = i + 1;
        return i;
    }

    static {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        SYSTRACE_LIBRARY_LOADING = z;
    }

    public static void init(Context context, int i) throws IOException {
        init(context, i, (SoFileLoader) null);
    }

    public static void init(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            isSystemApp = checkIfSystemApp(context, i);
            initSoLoader(soFileLoader);
            initSoSources(context, i, soFileLoader);
            NativeLoader.initIfUninitialized(new NativeLoaderToSoLoaderDelegate());
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initSoSources(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        String str;
        String str2;
        int i2;
        Context context2 = context;
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                SystemUtils.log(3, TAG, "init start", (Throwable) null, "com.facebook.soloader.SoLoader", 228);
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                String str3 = System.getenv("LD_LIBRARY_PATH");
                if (str3 == null) {
                    str3 = SysUtil.is64Bit() ? "/vendor/lib64:/system/lib64" : "/vendor/lib:/system/lib";
                }
                for (String str4 : str3.split(":")) {
                    SystemUtils.log(3, TAG, "adding system library source: " + str4, (Throwable) null, "com.facebook.soloader.SoLoader", 247);
                    arrayList.add(new DirectorySoSource(new File(str4), 2));
                }
                if (context2 != null) {
                    if ((i & 1) != 0) {
                        sBackupSoSources = null;
                        SystemUtils.log(3, TAG, "adding exo package source: lib-main", (Throwable) null, "com.facebook.soloader.SoLoader", 266);
                        arrayList.add(0, new ExoSoSource(context2, SO_STORE_NAME_MAIN));
                    } else {
                        if (isSystemApp) {
                            i2 = 0;
                        } else {
                            sApplicationSoSource = new ApplicationSoSource(context2, Build.VERSION.SDK_INT <= 17 ? 1 : 0);
                            SystemUtils.log(3, TAG, "adding application source: " + sApplicationSoSource.toString(), (Throwable) null, "com.facebook.soloader.SoLoader", 286);
                            arrayList.add(0, sApplicationSoSource);
                            i2 = 1;
                        }
                        if ((sFlags & 8) != 0) {
                            sBackupSoSources = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            ApkSoSource apkSoSource = new ApkSoSource(context2, file, SO_STORE_NAME_MAIN, i2);
                            arrayList2.add(apkSoSource);
                            SystemUtils.log(3, TAG, "adding backup source from : " + apkSoSource.toString(), (Throwable) null, "com.facebook.soloader.SoLoader", 299);
                            if (Build.VERSION.SDK_INT >= 21 && context.getApplicationInfo().splitSourceDirs != null) {
                                SystemUtils.log(3, TAG, "adding backup sources from split apks", (Throwable) null, "com.facebook.soloader.SoLoader", 303);
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < length) {
                                    File file2 = new File(strArr[i3]);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(SO_STORE_NAME_SPLIT);
                                    sb.append(i4);
                                    ApkSoSource apkSoSource2 = new ApkSoSource(context2, file2, sb.toString(), i2);
                                    SystemUtils.log(3, TAG, "adding backup source: " + apkSoSource2.toString(), (Throwable) null, "com.facebook.soloader.SoLoader", 312);
                                    arrayList2.add(apkSoSource2);
                                    i3++;
                                    i4++;
                                }
                            }
                            sBackupSoSources = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int makePrepareFlags = makePrepareFlags();
                int length2 = soSourceArr.length;
                while (true) {
                    int i5 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    SystemUtils.log(3, TAG, "Preparing SO source: " + soSourceArr[i5], (Throwable) null, "com.facebook.soloader.SoLoader", 326);
                    soSourceArr[i5].prepare(makePrepareFlags);
                    length2 = i5;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion++;
                SystemUtils.log(3, TAG, "init finish: " + sSoSources.length + " SO sources prepared", (Throwable) null, "com.facebook.soloader.SoLoader", 331);
            }
        } finally {
            str = "init exiting";
            str2 = "com.facebook.soloader.SoLoader";
            SystemUtils.log(3, TAG, str, (Throwable) null, str2, 334);
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static int makePrepareFlags() {
        sSoSourcesLock.writeLock().lock();
        try {
            return (sFlags & 2) != 0 ? 1 : 0;
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static synchronized void initSoLoader(@Nullable SoFileLoader soFileLoader) {
        synchronized (SoLoader.class) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            final boolean z = nativeLoadRuntimeMethod != null;
            final String classLoaderLdLoadLibrary = z ? Api14Utils.getClassLoaderLdLoadLibrary() : null;
            final String makeNonZipPath = makeNonZipPath(classLoaderLdLoadLibrary);
            sSoFileLoader = new SoFileLoader() {
                /* JADX WARNING: type inference failed for: r1v0 */
                /* JADX WARNING: type inference failed for: r1v10 */
                /* JADX WARNING: type inference failed for: r1v12 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
                    if (r1 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
                    com.didi.sdk.apm.SystemUtils.log(6, com.facebook.soloader.SoLoader.TAG, "Error when loading lib: " + r1 + " lib hash: " + getLibHash(r12) + " search path is " + r13, (java.lang.Throwable) null, "com.facebook.soloader.SoLoader$1", 394);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
                    return;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void load(java.lang.String r12, int r13) {
                    /*
                        r11 = this;
                        boolean r0 = r2
                        if (r0 == 0) goto L_0x00d5
                        r0 = 4
                        r13 = r13 & r0
                        r1 = 1
                        r2 = 0
                        if (r13 != r0) goto L_0x000c
                        r13 = 1
                        goto L_0x000d
                    L_0x000c:
                        r13 = 0
                    L_0x000d:
                        if (r13 == 0) goto L_0x0012
                        java.lang.String r13 = r3
                        goto L_0x0014
                    L_0x0012:
                        java.lang.String r13 = r4
                    L_0x0014:
                        r0 = 0
                        java.lang.Runtime r3 = r5     // Catch:{ IllegalAccessException -> 0x0086, IllegalArgumentException -> 0x0084, InvocationTargetException -> 0x0082, all -> 0x007d }
                        monitor-enter(r3)     // Catch:{ IllegalAccessException -> 0x0086, IllegalArgumentException -> 0x0084, InvocationTargetException -> 0x0082, all -> 0x007d }
                        java.lang.reflect.Method r4 = r6     // Catch:{ all -> 0x006f }
                        java.lang.Runtime r5 = r5     // Catch:{ all -> 0x006f }
                        r6 = 3
                        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x006f }
                        r6[r2] = r12     // Catch:{ all -> 0x006f }
                        java.lang.Class<com.facebook.soloader.SoLoader> r2 = com.facebook.soloader.SoLoader.class
                        java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ all -> 0x006f }
                        r6[r1] = r2     // Catch:{ all -> 0x006f }
                        r1 = 2
                        r6[r1] = r13     // Catch:{ all -> 0x006f }
                        java.lang.Object r1 = r4.invoke(r5, r6)     // Catch:{ all -> 0x006f }
                        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x006f }
                        if (r1 != 0) goto L_0x0069
                        monitor-exit(r3)     // Catch:{ all -> 0x007b }
                        if (r1 == 0) goto L_0x00d8
                        java.lang.String r5 = "SoLoader"
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r2 = "Error when loading lib: "
                        r0.append(r2)
                        r0.append(r1)
                        java.lang.String r1 = " lib hash: "
                        r0.append(r1)
                        java.lang.String r12 = r11.getLibHash(r12)
                        r0.append(r12)
                        java.lang.String r12 = " search path is "
                        r0.append(r12)
                        r0.append(r13)
                        java.lang.String r6 = r0.toString()
                        r4 = 6
                        r7 = 0
                        java.lang.String r8 = "com.facebook.soloader.SoLoader$1"
                        r9 = 394(0x18a, float:5.52E-43)
                        com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
                        goto L_0x00d8
                    L_0x0069:
                        java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x007b }
                        r0.<init>(r1)     // Catch:{ all -> 0x007b }
                        throw r0     // Catch:{ all -> 0x007b }
                    L_0x006f:
                        r1 = move-exception
                        r10 = r1
                        r1 = r0
                        r0 = r10
                    L_0x0073:
                        monitor-exit(r3)     // Catch:{ all -> 0x007b }
                        throw r0     // Catch:{ IllegalAccessException -> 0x0079, IllegalArgumentException -> 0x0077, InvocationTargetException -> 0x0075 }
                    L_0x0075:
                        r0 = move-exception
                        goto L_0x008a
                    L_0x0077:
                        r0 = move-exception
                        goto L_0x008a
                    L_0x0079:
                        r0 = move-exception
                        goto L_0x008a
                    L_0x007b:
                        r0 = move-exception
                        goto L_0x0073
                    L_0x007d:
                        r1 = move-exception
                        r10 = r1
                        r1 = r0
                        r0 = r10
                        goto L_0x00a2
                    L_0x0082:
                        r1 = move-exception
                        goto L_0x0087
                    L_0x0084:
                        r1 = move-exception
                        goto L_0x0087
                    L_0x0086:
                        r1 = move-exception
                    L_0x0087:
                        r10 = r1
                        r1 = r0
                        r0 = r10
                    L_0x008a:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
                        r2.<init>()     // Catch:{ all -> 0x00a1 }
                        java.lang.String r3 = "Error: Cannot load "
                        r2.append(r3)     // Catch:{ all -> 0x00a1 }
                        r2.append(r12)     // Catch:{ all -> 0x00a1 }
                        java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00a1 }
                        java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x00a1 }
                        r2.<init>(r1, r0)     // Catch:{ all -> 0x00a1 }
                        throw r2     // Catch:{ all -> 0x00a1 }
                    L_0x00a1:
                        r0 = move-exception
                    L_0x00a2:
                        if (r1 == 0) goto L_0x00d4
                        java.lang.String r3 = "SoLoader"
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r4 = "Error when loading lib: "
                        r2.append(r4)
                        r2.append(r1)
                        java.lang.String r1 = " lib hash: "
                        r2.append(r1)
                        java.lang.String r12 = r11.getLibHash(r12)
                        r2.append(r12)
                        java.lang.String r12 = " search path is "
                        r2.append(r12)
                        r2.append(r13)
                        java.lang.String r4 = r2.toString()
                        r2 = 6
                        r5 = 0
                        java.lang.String r6 = "com.facebook.soloader.SoLoader$1"
                        r7 = 394(0x18a, float:5.52E-43)
                        com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
                    L_0x00d4:
                        throw r0
                    L_0x00d5:
                        java.lang.System.load(r12)
                    L_0x00d8:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.C177971.load(java.lang.String, int):void");
                }

                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
                    r1.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
                    throw r0;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private java.lang.String getLibHash(java.lang.String r7) {
                    /*
                        r6 = this;
                        java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        r0.<init>(r7)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        java.lang.String r7 = "MD5"
                        java.security.MessageDigest r7 = java.security.MessageDigest.getInstance(r7)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        r1.<init>(r0)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        r0 = 4096(0x1000, float:5.74E-42)
                        byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0037 }
                    L_0x0014:
                        int r2 = r1.read(r0)     // Catch:{ all -> 0x0037 }
                        r3 = 0
                        if (r2 <= 0) goto L_0x001f
                        r7.update(r0, r3, r2)     // Catch:{ all -> 0x0037 }
                        goto L_0x0014
                    L_0x001f:
                        java.lang.String r0 = "%32x"
                        r2 = 1
                        java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0037 }
                        java.math.BigInteger r5 = new java.math.BigInteger     // Catch:{ all -> 0x0037 }
                        byte[] r7 = r7.digest()     // Catch:{ all -> 0x0037 }
                        r5.<init>(r2, r7)     // Catch:{ all -> 0x0037 }
                        r4[r3] = r5     // Catch:{ all -> 0x0037 }
                        java.lang.String r7 = java.lang.String.format(r0, r4)     // Catch:{ all -> 0x0037 }
                        r1.close()     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                        goto L_0x0054
                    L_0x0037:
                        r7 = move-exception
                        throw r7     // Catch:{ all -> 0x0039 }
                    L_0x0039:
                        r0 = move-exception
                        r1.close()     // Catch:{ all -> 0x003e }
                        goto L_0x0042
                    L_0x003e:
                        r1 = move-exception
                        r7.addSuppressed(r1)     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                    L_0x0042:
                        throw r0     // Catch:{ IOException -> 0x004f, SecurityException -> 0x0049, NoSuchAlgorithmException -> 0x0043 }
                    L_0x0043:
                        r7 = move-exception
                        java.lang.String r7 = r7.toString()
                        goto L_0x0054
                    L_0x0049:
                        r7 = move-exception
                        java.lang.String r7 = r7.toString()
                        goto L_0x0054
                    L_0x004f:
                        r7 = move-exception
                        java.lang.String r7 = r7.toString()
                    L_0x0054:
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.C177971.getLibHash(java.lang.String):java.lang.String");
                }
            };
        }
    }

    @Nullable
    private static Method getNativeLoadRuntimeMethod() {
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT <= 27) {
            try {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException | SecurityException e) {
                SystemUtils.log(5, TAG, "Cannot get nativeLoad method", e, "com.facebook.soloader.SoLoader", 450);
            }
        }
        return null;
    }

    private static boolean checkIfSystemApp(Context context, int i) {
        return ((i & 32) != 0 || context == null || (context.getApplicationInfo().flags & 129) == 0) ? false : true;
    }

    public static void setInTestMode() {
        TestOnlyUtils.setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void deinitForTest() {
        TestOnlyUtils.setSoSources((SoSource[]) null);
    }

    static class TestOnlyUtils {
        TestOnlyUtils() {
        }

        static void setSoSources(SoSource[] soSourceArr) {
            SoLoader.sSoSourcesLock.writeLock().lock();
            try {
                SoSource[] unused = SoLoader.sSoSources = soSourceArr;
                SoLoader.access$208();
            } finally {
                SoLoader.sSoSourcesLock.writeLock().unlock();
            }
        }

        static void setSoFileLoader(SoFileLoader soFileLoader) {
            SoLoader.sSoFileLoader = soFileLoader;
        }

        static void resetStatus() {
            synchronized (SoLoader.class) {
                SoLoader.sLoadedLibraries.clear();
                SoLoader.sLoadingLibraries.clear();
                SoLoader.sSoFileLoader = null;
            }
            setSoSources((SoSource[]) null);
        }
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.getSupportedAbis()) + " error: " + str);
            initCause(th);
        }
    }

    @Nullable
    public static String getLibraryPath(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String str2 = null;
            if (sSoSources != null) {
                int i = 0;
                while (str2 == null && i < sSoSources.length) {
                    str2 = sSoSources[i].getLibraryPath(str);
                    i++;
                }
            }
            return str2;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @Nullable
    public static String[] getLibraryDependencies(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String[] strArr = null;
            if (sSoSources != null) {
                int i = 0;
                while (strArr == null && i < sSoSources.length) {
                    strArr = sSoSources[i].getLibraryDependencies(str);
                    i++;
                }
            }
            return strArr;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        boolean z;
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        z = !sLoadedLibraries.contains(str);
                        if (z) {
                            if (sSystemLoadLibraryWrapper != null) {
                                sSystemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    sSoSourcesLock.readLock().unlock();
                    return z;
                }
            }
            sSoSourcesLock.readLock().unlock();
            if (!isSystemApp || (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) == null) {
                String mapLibName = MergedSoMapping.mapLibName(str);
                return loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), str, mapLibName, i, (StrictMode.ThreadPolicy) null);
            }
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    static void loadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        loadLibraryBySoNameImpl(str, (String) null, (String) null, i, threadPolicy);
    }

    private static boolean loadLibraryBySoName(String str, @Nullable String str2, @Nullable String str3, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        boolean z2 = false;
        do {
            try {
                z2 = loadLibraryBySoNameImpl(str, str2, str3, i, threadPolicy);
                z = false;
                String str4 = str;
                continue;
            } catch (UnsatisfiedLinkError e) {
                UnsatisfiedLinkError unsatisfiedLinkError = e;
                int i2 = sSoSourcesVersion;
                sSoSourcesLock.writeLock().lock();
                try {
                    z = true;
                    if (sApplicationSoSource == null || !sApplicationSoSource.checkAndMaybeUpdate()) {
                        String str5 = str;
                        z = false;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("sApplicationSoSource updated during load: ");
                        String str6 = str;
                        sb.append(str);
                        sb.append(", attempting load again.");
                        SystemUtils.log(5, TAG, sb.toString(), (Throwable) null, "com.facebook.soloader.SoLoader", 660);
                        sSoSourcesVersion++;
                    }
                    sSoSourcesLock.writeLock().unlock();
                    if (sSoSourcesVersion == i2) {
                        throw unsatisfiedLinkError;
                    }
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                } catch (Throwable th) {
                    sSoSourcesLock.writeLock().unlock();
                    throw th;
                }
            }
        } while (z);
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0168, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0169, code lost:
        sSoSourcesLock.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0172, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        sSoSourcesLock.readLock().lock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r4 != false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        if (sLoadedLibraries.contains(r14) == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r16 != null) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0058, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0063, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0064, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0066, code lost:
        if (r4 != false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        com.didi.sdk.apm.SystemUtils.log(3, TAG, "About to load: " + r14, (java.lang.Throwable) null, "com.facebook.soloader.SoLoader", 739);
        doLoadLibraryBySoName(r14, r0, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        com.didi.sdk.apm.SystemUtils.log(3, TAG, "Loaded: " + r14, (java.lang.Throwable) null, "com.facebook.soloader.SoLoader", 751);
        sLoadedLibraries.add(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ab, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b1, code lost:
        r1 = r0.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b5, code lost:
        if (r1 == null) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ce, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r0, r1.substring(r1.lastIndexOf("unexpected e_machine:")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00cf, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d5, code lost:
        if ((r0 & 16) != 0) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00db, code lost:
        if (android.text.TextUtils.isEmpty(r15) != false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e3, code lost:
        if (sLoadedAndMergedLibraries.contains(r15) == false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00e5, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00e6, code lost:
        if (r16 == null) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00e8, code lost:
        if (r5 != false) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ec, code lost:
        if (SYSTRACE_LIBRARY_LOADING == false) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ee, code lost:
        com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", r15, com.didichuxing.bigdata.p173dp.locsdk.Const.jaRight);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        com.didi.sdk.apm.SystemUtils.log(3, TAG, "About to merge: " + r15 + " / " + r14, (java.lang.Throwable) null, "com.facebook.soloader.SoLoader", 768);
        com.facebook.soloader.MergedSoMapping.invokeJniOnload(r15);
        sLoadedAndMergedLibraries.add(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0123, code lost:
        if (SYSTRACE_LIBRARY_LOADING == false) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0125, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0129, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x012b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x014f, code lost:
        throw new java.lang.RuntimeException("Failed to call JNI_OnLoad from '" + r15 + "', which has been merged into '" + r14 + "'.  See comment for details.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0152, code lost:
        if (SYSTRACE_LIBRARY_LOADING != false) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0154, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0157, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0158, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0159, code lost:
        sSoSourcesLock.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0164, code lost:
        return !r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean loadLibraryBySoNameImpl(java.lang.String r14, @javax.annotation.Nullable java.lang.String r15, @javax.annotation.Nullable java.lang.String r16, int r17, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r18) {
        /*
            r1 = r14
            r2 = r15
            r0 = r17
            java.lang.Class<com.facebook.soloader.SoLoader> r3 = com.facebook.soloader.SoLoader.class
            boolean r4 = android.text.TextUtils.isEmpty(r15)
            r5 = 0
            if (r4 != 0) goto L_0x0016
            java.util.Set<java.lang.String> r4 = sLoadedAndMergedLibraries
            boolean r4 = r4.contains(r15)
            if (r4 == 0) goto L_0x0016
            return r5
        L_0x0016:
            monitor-enter(r3)
            java.util.HashSet<java.lang.String> r4 = sLoadedLibraries     // Catch:{ all -> 0x0173 }
            boolean r4 = r4.contains(r14)     // Catch:{ all -> 0x0173 }
            r6 = 1
            if (r4 == 0) goto L_0x0026
            if (r16 != 0) goto L_0x0024
            monitor-exit(r3)     // Catch:{ all -> 0x0173 }
            return r5
        L_0x0024:
            r4 = 1
            goto L_0x0027
        L_0x0026:
            r4 = 0
        L_0x0027:
            java.util.Map<java.lang.String, java.lang.Object> r7 = sLoadingLibraries     // Catch:{ all -> 0x0173 }
            boolean r7 = r7.containsKey(r14)     // Catch:{ all -> 0x0173 }
            if (r7 == 0) goto L_0x0036
            java.util.Map<java.lang.String, java.lang.Object> r7 = sLoadingLibraries     // Catch:{ all -> 0x0173 }
            java.lang.Object r7 = r7.get(r14)     // Catch:{ all -> 0x0173 }
            goto L_0x0040
        L_0x0036:
            java.lang.Object r7 = new java.lang.Object     // Catch:{ all -> 0x0173 }
            r7.<init>()     // Catch:{ all -> 0x0173 }
            java.util.Map<java.lang.String, java.lang.Object> r8 = sLoadingLibraries     // Catch:{ all -> 0x0173 }
            r8.put(r14, r7)     // Catch:{ all -> 0x0173 }
        L_0x0040:
            monitor-exit(r3)     // Catch:{ all -> 0x0173 }
            java.util.concurrent.locks.ReentrantReadWriteLock r8 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r8 = r8.readLock()
            r8.lock()
            monitor-enter(r7)     // Catch:{ all -> 0x0168 }
            if (r4 != 0) goto L_0x00d3
            monitor-enter(r3)     // Catch:{ all -> 0x0165 }
            java.util.HashSet<java.lang.String> r8 = sLoadedLibraries     // Catch:{ all -> 0x00d0 }
            boolean r8 = r8.contains(r14)     // Catch:{ all -> 0x00d0 }
            if (r8 == 0) goto L_0x0065
            if (r16 != 0) goto L_0x0064
            monitor-exit(r3)     // Catch:{ all -> 0x00d0 }
            monitor-exit(r7)     // Catch:{ all -> 0x0165 }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r5
        L_0x0064:
            r4 = 1
        L_0x0065:
            monitor-exit(r3)     // Catch:{ all -> 0x00d0 }
            if (r4 != 0) goto L_0x00d3
            java.lang.String r9 = "SoLoader"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            r8.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            java.lang.String r10 = "About to load: "
            r8.append(r10)     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            r8.append(r14)     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            java.lang.String r10 = r8.toString()     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            r8 = 3
            r11 = 0
            java.lang.String r12 = "com.facebook.soloader.SoLoader"
            r13 = 739(0x2e3, float:1.036E-42)
            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            r8 = r18
            doLoadLibraryBySoName(r14, r0, r8)     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            monitor-enter(r3)     // Catch:{ all -> 0x0165 }
            java.lang.String r9 = "SoLoader"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r8.<init>()     // Catch:{ all -> 0x00ad }
            java.lang.String r10 = "Loaded: "
            r8.append(r10)     // Catch:{ all -> 0x00ad }
            r8.append(r14)     // Catch:{ all -> 0x00ad }
            java.lang.String r10 = r8.toString()     // Catch:{ all -> 0x00ad }
            r8 = 3
            r11 = 0
            java.lang.String r12 = "com.facebook.soloader.SoLoader"
            r13 = 751(0x2ef, float:1.052E-42)
            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00ad }
            java.util.HashSet<java.lang.String> r8 = sLoadedLibraries     // Catch:{ all -> 0x00ad }
            r8.add(r14)     // Catch:{ all -> 0x00ad }
            monitor-exit(r3)     // Catch:{ all -> 0x00ad }
            goto L_0x00d3
        L_0x00ad:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00ad }
            throw r0     // Catch:{ all -> 0x0165 }
        L_0x00b0:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0165 }
            if (r1 == 0) goto L_0x00cf
            java.lang.String r2 = "unexpected e_machine:"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x0165 }
            if (r2 == 0) goto L_0x00cf
            java.lang.String r2 = "unexpected e_machine:"
            int r2 = r1.lastIndexOf(r2)     // Catch:{ all -> 0x0165 }
            java.lang.String r1 = r1.substring(r2)     // Catch:{ all -> 0x0165 }
            com.facebook.soloader.SoLoader$WrongAbiError r2 = new com.facebook.soloader.SoLoader$WrongAbiError     // Catch:{ all -> 0x0165 }
            r2.<init>(r0, r1)     // Catch:{ all -> 0x0165 }
            throw r2     // Catch:{ all -> 0x0165 }
        L_0x00cf:
            throw r0     // Catch:{ all -> 0x0165 }
        L_0x00d0:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00d0 }
            throw r0     // Catch:{ all -> 0x0165 }
        L_0x00d3:
            r0 = r0 & 16
            if (r0 != 0) goto L_0x0158
            boolean r0 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0165 }
            if (r0 != 0) goto L_0x00e6
            java.util.Set<java.lang.String> r0 = sLoadedAndMergedLibraries     // Catch:{ all -> 0x0165 }
            boolean r0 = r0.contains(r15)     // Catch:{ all -> 0x0165 }
            if (r0 == 0) goto L_0x00e6
            r5 = 1
        L_0x00e6:
            if (r16 == 0) goto L_0x0158
            if (r5 != 0) goto L_0x0158
            boolean r0 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x0165 }
            if (r0 == 0) goto L_0x00f5
            java.lang.String r0 = "MergedSoMapping.invokeJniOnload["
            java.lang.String r3 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r0, r15, r3)     // Catch:{ all -> 0x0165 }
        L_0x00f5:
            java.lang.String r9 = "SoLoader"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            r0.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            java.lang.String r3 = "About to merge: "
            r0.append(r3)     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            r0.append(r15)     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            java.lang.String r3 = " / "
            r0.append(r3)     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            r0.append(r14)     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            java.lang.String r10 = r0.toString()     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            r8 = 3
            r11 = 0
            java.lang.String r12 = "com.facebook.soloader.SoLoader"
            r13 = 768(0x300, float:1.076E-42)
            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            com.facebook.soloader.MergedSoMapping.invokeJniOnload(r15)     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            java.util.Set<java.lang.String> r0 = sLoadedAndMergedLibraries     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            r0.add(r15)     // Catch:{ UnsatisfiedLinkError -> 0x012b }
            boolean r0 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x0165 }
            if (r0 == 0) goto L_0x0158
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x0165 }
            goto L_0x0158
        L_0x0129:
            r0 = move-exception
            goto L_0x0150
        L_0x012b:
            r0 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x0129 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            r4.<init>()     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = "Failed to call JNI_OnLoad from '"
            r4.append(r5)     // Catch:{ all -> 0x0129 }
            r4.append(r15)     // Catch:{ all -> 0x0129 }
            java.lang.String r2 = "', which has been merged into '"
            r4.append(r2)     // Catch:{ all -> 0x0129 }
            r4.append(r14)     // Catch:{ all -> 0x0129 }
            java.lang.String r1 = "'.  See comment for details."
            r4.append(r1)     // Catch:{ all -> 0x0129 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0129 }
            r3.<init>(r1, r0)     // Catch:{ all -> 0x0129 }
            throw r3     // Catch:{ all -> 0x0129 }
        L_0x0150:
            boolean r1 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x0165 }
            if (r1 == 0) goto L_0x0157
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x0165 }
        L_0x0157:
            throw r0     // Catch:{ all -> 0x0165 }
        L_0x0158:
            monitor-exit(r7)     // Catch:{ all -> 0x0165 }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            r0 = r4 ^ 1
            return r0
        L_0x0165:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0165 }
            throw r0     // Catch:{ all -> 0x0168 }
        L_0x0168:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            throw r0
        L_0x0173:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0173 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.loadLibraryBySoNameImpl(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doLoadLibraryBySoName(java.lang.String r18, int r19, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r20) throws java.lang.UnsatisfiedLinkError {
        /*
            r1 = r18
            r0 = r19
            java.lang.String r2 = " result: "
            java.util.concurrent.locks.ReentrantReadWriteLock r3 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r3 = r3.readLock()
            r3.lock()
            com.facebook.soloader.SoSource[] r3 = sSoSources     // Catch:{ all -> 0x01b2 }
            java.lang.String r4 = "couldn't find DSO to load: "
            if (r3 == 0) goto L_0x017c
            java.util.concurrent.locks.ReentrantReadWriteLock r3 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r3 = r3.readLock()
            r3.unlock()
            r3 = 1
            r5 = 0
            if (r20 != 0) goto L_0x0028
            android.os.StrictMode$ThreadPolicy r6 = android.os.StrictMode.allowThreadDiskReads()
            r7 = 1
            goto L_0x002b
        L_0x0028:
            r6 = r20
            r7 = 0
        L_0x002b:
            boolean r8 = SYSTRACE_LIBRARY_LOADING
            if (r8 == 0) goto L_0x0036
            java.lang.String r8 = "SoLoader.loadLibrary["
            java.lang.String r9 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r8, r1, r9)
        L_0x0036:
            r8 = 3
            java.util.concurrent.locks.ReentrantReadWriteLock r9 = sSoSourcesLock     // Catch:{ all -> 0x012a }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r9 = r9.readLock()     // Catch:{ all -> 0x012a }
            r9.lock()     // Catch:{ all -> 0x012a }
            r9 = 0
            r10 = 0
        L_0x0042:
            if (r9 != 0) goto L_0x0098
            com.facebook.soloader.SoSource[] r11 = sSoSources     // Catch:{ all -> 0x008c }
            int r11 = r11.length     // Catch:{ all -> 0x008c }
            if (r10 >= r11) goto L_0x0098
            com.facebook.soloader.SoSource[] r11 = sSoSources     // Catch:{ all -> 0x008c }
            r11 = r11[r10]     // Catch:{ all -> 0x008c }
            int r9 = r11.loadLibrary(r1, r0, r6)     // Catch:{ all -> 0x008c }
            if (r9 != r8) goto L_0x0089
            com.facebook.soloader.UnpackingSoSource[] r11 = sBackupSoSources     // Catch:{ all -> 0x008c }
            if (r11 == 0) goto L_0x0089
            java.lang.String r13 = "SoLoader"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r10.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r11 = "Trying backup SoSource for "
            r10.append(r11)     // Catch:{ all -> 0x008c }
            r10.append(r1)     // Catch:{ all -> 0x008c }
            java.lang.String r14 = r10.toString()     // Catch:{ all -> 0x008c }
            r12 = 3
            r15 = 0
            java.lang.String r16 = "com.facebook.soloader.SoLoader"
            r17 = 863(0x35f, float:1.21E-42)
            com.didi.sdk.apm.SystemUtils.log(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x008c }
            com.facebook.soloader.UnpackingSoSource[] r10 = sBackupSoSources     // Catch:{ all -> 0x008c }
            int r11 = r10.length     // Catch:{ all -> 0x008c }
            r12 = 0
        L_0x0077:
            if (r12 >= r11) goto L_0x0098
            r13 = r10[r12]     // Catch:{ all -> 0x008c }
            r13.prepare((java.lang.String) r1)     // Catch:{ all -> 0x008c }
            int r13 = r13.loadLibrary(r1, r0, r6)     // Catch:{ all -> 0x008c }
            if (r13 != r3) goto L_0x0086
            r9 = r13
            goto L_0x0098
        L_0x0086:
            int r12 = r12 + 1
            goto L_0x0077
        L_0x0089:
            int r10 = r10 + 1
            goto L_0x0042
        L_0x008c:
            r0 = move-exception
            r5 = r9
            java.util.concurrent.locks.ReentrantReadWriteLock r3 = sSoSourcesLock     // Catch:{ all -> 0x012a }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r3 = r3.readLock()     // Catch:{ all -> 0x012a }
            r3.unlock()     // Catch:{ all -> 0x012a }
            throw r0     // Catch:{ all -> 0x012a }
        L_0x0098:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock     // Catch:{ all -> 0x0127 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()     // Catch:{ all -> 0x0127 }
            r0.unlock()     // Catch:{ all -> 0x0127 }
            boolean r0 = SYSTRACE_LIBRARY_LOADING
            if (r0 == 0) goto L_0x00a8
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x00a8:
            if (r7 == 0) goto L_0x00ad
            android.os.StrictMode.setThreadPolicy(r6)
        L_0x00ad:
            if (r9 == 0) goto L_0x00b1
            if (r9 != r8) goto L_0x013c
        L_0x00b1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r1)
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.lock()
        L_0x00c5:
            com.facebook.soloader.SoSource[] r1 = sSoSources
            int r1 = r1.length
            if (r5 >= r1) goto L_0x00e5
            java.lang.String r1 = "\n\tSoSource "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = ": "
            r0.append(r1)
            com.facebook.soloader.SoSource[] r1 = sSoSources
            r1 = r1[r5]
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            int r5 = r5 + 1
            goto L_0x00c5
        L_0x00e5:
            com.facebook.soloader.ApplicationSoSource r1 = sApplicationSoSource
            if (r1 == 0) goto L_0x0102
            android.content.Context r1 = r1.getUpdatedContext()
            java.io.File r1 = com.facebook.soloader.ApplicationSoSource.getNativeLibDirFromContext(r1)
            java.lang.String r3 = "\n\tNative lib dir: "
            r0.append(r3)
            java.lang.String r1 = r1.getAbsolutePath()
            r0.append(r1)
            java.lang.String r1 = "\n"
            r0.append(r1)
        L_0x0102:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            r0.append(r2)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r3 = 6
            r6 = 0
            r8 = 917(0x395, float:1.285E-42)
            java.lang.String r4 = "SoLoader"
            java.lang.String r7 = "com.facebook.soloader.SoLoader"
            r5 = r0
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            java.lang.UnsatisfiedLinkError r1 = new java.lang.UnsatisfiedLinkError
            r1.<init>(r0)
            throw r1
        L_0x0127:
            r0 = move-exception
            r5 = r9
            goto L_0x012b
        L_0x012a:
            r0 = move-exception
        L_0x012b:
            boolean r3 = SYSTRACE_LIBRARY_LOADING
            if (r3 == 0) goto L_0x0132
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x0132:
            if (r7 == 0) goto L_0x0137
            android.os.StrictMode.setThreadPolicy(r6)
        L_0x0137:
            if (r5 == 0) goto L_0x013d
            if (r5 != r8) goto L_0x013c
            goto L_0x013d
        L_0x013c:
            return
        L_0x013d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r0.getMessage()
            if (r1 != 0) goto L_0x0152
            java.lang.String r1 = r0.toString()
        L_0x0152:
            java.lang.String r4 = " caused by: "
            r3.append(r4)
            r3.append(r1)
            r0.printStackTrace()
            r3.append(r2)
            r3.append(r5)
            java.lang.String r1 = r3.toString()
            r6 = 6
            r9 = 0
            r11 = 917(0x395, float:1.285E-42)
            java.lang.String r7 = "SoLoader"
            java.lang.String r10 = "com.facebook.soloader.SoLoader"
            r8 = r1
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)
            java.lang.UnsatisfiedLinkError r2 = new java.lang.UnsatisfiedLinkError
            r2.<init>(r1)
            r2.initCause(r0)
            throw r2
        L_0x017c:
            java.lang.String r6 = "SoLoader"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b2 }
            r0.<init>()     // Catch:{ all -> 0x01b2 }
            java.lang.String r2 = "Could not load: "
            r0.append(r2)     // Catch:{ all -> 0x01b2 }
            r0.append(r1)     // Catch:{ all -> 0x01b2 }
            java.lang.String r2 = " because no SO source exists"
            r0.append(r2)     // Catch:{ all -> 0x01b2 }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x01b2 }
            r5 = 6
            r8 = 0
            java.lang.String r9 = "com.facebook.soloader.SoLoader"
            r10 = 835(0x343, float:1.17E-42)
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x01b2 }
            java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x01b2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b2 }
            r2.<init>()     // Catch:{ all -> 0x01b2 }
            r2.append(r4)     // Catch:{ all -> 0x01b2 }
            r2.append(r1)     // Catch:{ all -> 0x01b2 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x01b2 }
            r0.<init>(r1)     // Catch:{ all -> 0x01b2 }
            throw r0     // Catch:{ all -> 0x01b2 }
        L_0x01b2:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.doLoadLibraryBySoName(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    @Nullable
    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            for (SoSource unpackLibrary : sSoSources) {
                File unpackLibrary2 = unpackLibrary.unpackLibrary(str);
                if (unpackLibrary2 != null) {
                    return unpackLibrary2;
                }
            }
            sSoSourcesLock.readLock().unlock();
            throw new FileNotFoundException(str);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    private static void assertInitialized() {
        if (!isInitialized()) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
    }

    public static boolean isInitialized() {
        sSoSourcesLock.readLock().lock();
        try {
            return sSoSources != null;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static int getSoSourcesVersion() {
        return sSoSourcesVersion;
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        sSoSourcesLock.writeLock().lock();
        try {
            SystemUtils.log(3, TAG, "Prepending to SO sources: " + soSource, (Throwable) null, "com.facebook.soloader.SoLoader", 989);
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = new SoSource[(sSoSources.length + 1)];
            soSourceArr[0] = soSource;
            System.arraycopy(sSoSources, 0, soSourceArr, 1, sSoSources.length);
            sSoSources = soSourceArr;
            sSoSourcesVersion++;
            SystemUtils.log(3, TAG, "Prepended to SO sources: " + soSource, (Throwable) null, "com.facebook.soloader.SoLoader", 997);
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            SystemUtils.log(3, TAG, "makeLdLibraryPath", (Throwable) null, "com.facebook.soloader.SoLoader", 1011);
            ArrayList arrayList = new ArrayList();
            SoSource[] soSourceArr = sSoSources;
            if (soSourceArr != null) {
                for (SoSource addToLdLibraryPath : soSourceArr) {
                    addToLdLibraryPath.addToLdLibraryPath(arrayList);
                }
            }
            String join = TextUtils.join(":", arrayList);
            SystemUtils.log(3, TAG, "makeLdLibraryPath final path: " + join, (Throwable) null, "com.facebook.soloader.SoLoader", 1020);
            return join;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean areSoSourcesAbisSupported() {
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                String[] supportedAbis = SysUtil.getSupportedAbis();
                for (SoSource soSourceAbis : sSoSources) {
                    String[] soSourceAbis2 = soSourceAbis.getSoSourceAbis();
                    int length = soSourceAbis2.length;
                    int i = 0;
                    while (i < length) {
                        String str = soSourceAbis2[i];
                        boolean z = false;
                        for (int i2 = 0; i2 < supportedAbis.length && !z; i2++) {
                            z = str.equals(supportedAbis[i2]);
                        }
                        if (!z) {
                            SystemUtils.log(6, TAG, "abi not supported: " + str, (Throwable) null, "com.facebook.soloader.SoLoader", 1049);
                        } else {
                            i++;
                        }
                    }
                }
                sSoSourcesLock.readLock().unlock();
                return true;
            }
            return false;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    private static class Api14Utils {
        private Api14Utils() {
        }

        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            } else {
                throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
            }
        }
    }
}
