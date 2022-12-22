package com.didi.sdk.onehotpatch.loader.dex;

import android.app.Application;
import android.content.Context;
import com.didi.sdk.onehotpatch.commonstatic.util.ReflectUtil;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;

public class DalvikClassLoader extends PathClassLoader {
    private static DalvikClassLoader classLoader;

    public void addWhiteClassName(String str) {
    }

    private DalvikClassLoader(String str, PathClassLoader pathClassLoader, Application application) {
        super(str, pathClassLoader.getParent());
    }

    private static Object recreateDexPathList(Object obj, ClassLoader classLoader2) throws Exception {
        Field findField = ReflectUtil.findField(obj, "dexElements");
        Field findField2 = ReflectUtil.findField(obj, "nativeLibraryDirectories");
        Object newInstance = ReflectUtil.findConstructor(obj, ClassLoader.class, String.class, String.class, File.class).newInstance(new Object[]{classLoader2, "", "", null});
        findField.set(newInstance, (Object[]) findField.get(obj));
        findField2.set(newInstance, (File[]) findField2.get(obj));
        return newInstance;
    }

    private static DalvikClassLoader createDalvikClassLoader(PathClassLoader pathClassLoader, Application application) throws Exception {
        DalvikClassLoader dalvikClassLoader = new DalvikClassLoader("", pathClassLoader, application);
        Field findField = ReflectUtil.findField(pathClassLoader, "pathList");
        findField.set(dalvikClassLoader, recreateDexPathList(findField.get(pathClassLoader), dalvikClassLoader));
        return dalvikClassLoader;
    }

    private static void reflectPackageInfoClassloader(Application application, ClassLoader classLoader2) throws Exception {
        Context context = (Context) ReflectUtil.findField(application, "mBase").get(application);
        Object obj = ReflectUtil.findField(context, "mPackageInfo").get(context);
        Field findField = ReflectUtil.findField(obj, "mClassLoader");
        Thread.currentThread().setContextClassLoader(classLoader2);
        findField.set(obj, classLoader2);
    }

    public static DalvikClassLoader inject(PathClassLoader pathClassLoader, Application application) throws Exception {
        if (classLoader == null) {
            DalvikClassLoader createDalvikClassLoader = createDalvikClassLoader(pathClassLoader, application);
            classLoader = createDalvikClassLoader;
            reflectPackageInfoClassloader(application, createDalvikClassLoader);
        }
        return classLoader;
    }

    public Class<?> findClass(String str) throws ClassNotFoundException {
        return super.findClass(str);
    }

    public String findLibrary(String str) {
        return super.findLibrary(str);
    }
}
