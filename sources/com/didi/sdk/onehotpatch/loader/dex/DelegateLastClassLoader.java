package com.didi.sdk.onehotpatch.loader.dex;

import android.app.Application;
import android.content.Context;
import com.didi.sdk.onehotpatch.commonstatic.util.ReflectUtil;
import dalvik.system.PathClassLoader;

public final class DelegateLastClassLoader extends PathClassLoader {
    private static DelegateLastClassLoader classLoader;
    private final boolean delegateResourceLoading;

    public DelegateLastClassLoader(String str, ClassLoader classLoader2) {
        this(str, (String) null, classLoader2, true);
    }

    public DelegateLastClassLoader(String str, String str2, ClassLoader classLoader2) {
        this(str, str2, classLoader2, true);
    }

    public DelegateLastClassLoader(String str, String str2, ClassLoader classLoader2, boolean z) {
        super(str, str2, classLoader2);
        this.delegateResourceLoading = z;
    }

    public static PathClassLoader inject(PathClassLoader pathClassLoader, Application application) throws Exception {
        if (classLoader == null) {
            DelegateLastClassLoader delegateLastClassLoader = new DelegateLastClassLoader("", getClassLoaderNativeLibrary(pathClassLoader), pathClassLoader);
            classLoader = delegateLastClassLoader;
            delegateLastClassLoader.reflectPackageInfoClassloader(application);
        }
        return classLoader;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|16|(3:18|(2:20|37)(3:(1:22)(1:23)|24|36)|25)|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r8 = (java.io.File[]) r1.get(r8);
        r1 = r8.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r4 < r1) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r5 = r8[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r5 == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r3 != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        r0.append(java.io.File.pathSeparator);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        r0.append(r5.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getClassLoaderNativeLibrary(dalvik.system.PathClassLoader r8) {
        /*
            java.lang.String r0 = "pathList"
            java.lang.reflect.Field r0 = com.didi.sdk.onehotpatch.commonstatic.util.ReflectUtil.findField(r8, r0)     // Catch:{ all -> 0x006b }
            java.lang.Object r8 = r0.get(r8)     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r0.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r1 = "nativeLibraryDirectories"
            java.lang.reflect.Field r1 = com.didi.sdk.onehotpatch.commonstatic.util.ReflectUtil.findField(r8, r1)     // Catch:{ all -> 0x006b }
            r2 = 0
            r3 = 1
            java.lang.Object r4 = r1.get(r8)     // Catch:{ all -> 0x0042 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x0042 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0042 }
            r5 = 1
        L_0x0022:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0042 }
            if (r6 == 0) goto L_0x0066
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0042 }
            java.io.File r6 = (java.io.File) r6     // Catch:{ all -> 0x0042 }
            if (r6 != 0) goto L_0x0031
            goto L_0x0022
        L_0x0031:
            if (r5 == 0) goto L_0x0035
            r5 = 0
            goto L_0x003a
        L_0x0035:
            java.lang.String r7 = java.io.File.pathSeparator     // Catch:{ all -> 0x0042 }
            r0.append(r7)     // Catch:{ all -> 0x0042 }
        L_0x003a:
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ all -> 0x0042 }
            r0.append(r6)     // Catch:{ all -> 0x0042 }
            goto L_0x0022
        L_0x0042:
            java.lang.Object r8 = r1.get(r8)     // Catch:{ all -> 0x006b }
            java.io.File[] r8 = (java.io.File[]) r8     // Catch:{ all -> 0x006b }
            java.io.File[] r8 = (java.io.File[]) r8     // Catch:{ all -> 0x006b }
            int r1 = r8.length     // Catch:{ all -> 0x006b }
            r4 = 0
        L_0x004c:
            if (r4 >= r1) goto L_0x0066
            r5 = r8[r4]     // Catch:{ all -> 0x006b }
            if (r5 != 0) goto L_0x0053
            goto L_0x0063
        L_0x0053:
            if (r3 == 0) goto L_0x0057
            r3 = 0
            goto L_0x005c
        L_0x0057:
            java.lang.String r6 = java.io.File.pathSeparator     // Catch:{ all -> 0x006b }
            r0.append(r6)     // Catch:{ all -> 0x006b }
        L_0x005c:
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x006b }
            r0.append(r5)     // Catch:{ all -> 0x006b }
        L_0x0063:
            int r4 = r4 + 1
            goto L_0x004c
        L_0x0066:
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x006b }
            return r8
        L_0x006b:
            r8 = move-exception
            r8.printStackTrace()
            java.lang.String r8 = ""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.loader.dex.DelegateLastClassLoader.getClassLoaderNativeLibrary(dalvik.system.PathClassLoader):java.lang.String");
    }

    private void reflectPackageInfoClassloader(Application application) throws Exception {
        Context context = (Context) ReflectUtil.findField(application, "mBase").get(application);
        Object obj = ReflectUtil.findField(context, "mPackageInfo").get(context);
        ReflectUtil.findField(obj, "mClassLoader").set(obj, classLoader);
        Thread.currentThread().setContextClassLoader(classLoader);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return getParent().loadClass(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        return findClass(r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<?> loadClass(java.lang.String r2, boolean r3) throws java.lang.ClassNotFoundException {
        /*
            r1 = this;
            java.lang.Class r3 = r1.findLoadedClass(r2)
            if (r3 == 0) goto L_0x0007
            return r3
        L_0x0007:
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0012 }
            java.lang.Class r2 = r3.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x0012 }
            return r2
        L_0x0012:
            java.lang.Class r2 = r1.findClass(r2)     // Catch:{ ClassNotFoundException -> 0x0017 }
            return r2
        L_0x0017:
            r3 = move-exception
            java.lang.ClassLoader r0 = r1.getParent()     // Catch:{ ClassNotFoundException -> 0x0021 }
            java.lang.Class r2 = r0.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x0021 }
            return r2
        L_0x0021:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.loader.dex.DelegateLastClassLoader.loadClass(java.lang.String, boolean):java.lang.Class");
    }
}
