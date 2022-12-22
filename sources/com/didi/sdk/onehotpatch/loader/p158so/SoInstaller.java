package com.didi.sdk.onehotpatch.loader.p158so;

import android.app.Application;
import android.os.Build;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.bean.SoInfo;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.ReflectUtil;
import com.didi.sdk.onehotpatch.loader.dex.DexInstaller;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.sdk.onehotpatch.loader.so.SoInstaller */
public class SoInstaller {
    public static void loadPatch(Application application, PatchModule patchModule, boolean z, boolean z2) throws Throwable {
        PathClassLoader originalClassLoader = DexInstaller.getOriginalClassLoader(application, z, z2);
        if (originalClassLoader != null) {
            File patchSoDir = PatchManager.getPatchSoDir(application, patchModule);
            if (patchSoDir.exists() && patchSoDir.isDirectory()) {
                if (patchSoDir.getName().equalsIgnoreCase(SoInfo.getCurrentAbi(application)) || patchSoDir.listFiles().length <= 0) {
                    Logger.log("Invalid so dir: %s", patchSoDir.getAbsolutePath());
                    return;
                }
                installNativeLibraryPath(originalClassLoader, patchSoDir.listFiles()[0]);
            }
        }
    }

    private static void installNativeLibraryPath(ClassLoader classLoader, File file) throws Throwable {
        if (file == null || !file.exists()) {
            Logger.log("installNativeLibraryPath, folder %s is illegal", file);
        } else if (Build.VERSION.SDK_INT > 25 || (Build.VERSION.SDK_INT == 25 && Build.VERSION.PREVIEW_SDK_INT != 0)) {
            try {
                V25.install(classLoader, file);
            } catch (Throwable th) {
                Logger.log("installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th.getMessage());
                V23.install(classLoader, file);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            try {
                V23.install(classLoader, file);
            } catch (Throwable th2) {
                Logger.log("installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", Integer.valueOf(Build.VERSION.SDK_INT), th2.getMessage());
                V14.install(classLoader, file);
            }
        } else {
            V14.install(classLoader, file);
        }
    }

    /* renamed from: com.didi.sdk.onehotpatch.loader.so.SoInstaller$V14 */
    private static final class V14 {
        private V14() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            ReflectUtil.expandFieldArray(ReflectUtil.findField(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
        }
    }

    /* renamed from: com.didi.sdk.onehotpatch.loader.so.SoInstaller$V23 */
    private static final class V23 {
        private V23() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = ReflectUtil.findField(classLoader, "pathList").get(classLoader);
            List list = (List) ReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            Method findMethod = ReflectUtil.findMethod(obj, "makePathElements", List.class, File.class, List.class);
            ArrayList arrayList = new ArrayList();
            list.addAll((List) ReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj));
            Object[] objArr = {list, null, arrayList};
            Field findField = ReflectUtil.findField(obj, "nativeLibraryPathElements");
            findField.setAccessible(true);
            findField.set(obj, (Object[]) findMethod.invoke(obj, objArr));
        }
    }

    /* renamed from: com.didi.sdk.onehotpatch.loader.so.SoInstaller$V25 */
    private static final class V25 {
        private V25() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = ReflectUtil.findField(classLoader, "pathList").get(classLoader);
            List list = (List) ReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            list.add(0, file);
            Method findMethod = ReflectUtil.findMethod(obj, "makePathElements", List.class);
            list.addAll((List) ReflectUtil.findField(obj, "systemNativeLibraryDirectories").get(obj));
            Object[] objArr = {list};
            Field findField = ReflectUtil.findField(obj, "nativeLibraryPathElements");
            findField.setAccessible(true);
            findField.set(obj, (Object[]) findMethod.invoke(obj, objArr));
        }
    }
}
