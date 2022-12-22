package com.didi.sdk.onehotpatch.loader.dex;

import android.app.Application;
import android.content.Context;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.ReflectUtil;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AndroidNClassLoader extends PathClassLoader {
    private static final boolean ENABLE_REPLACE_CLASSLOADER_PARENT = false;
    private static AndroidNClassLoader classLoader;
    private static PathClassLoader originClassLoader;
    private static boolean sEnableLogging;
    private static Method sFindClassMethod;
    private static Method sFindLoadedClassMethod;
    private static final boolean sUseSimpleCompare;
    private static final Set<String> sWhiteClassPackages;
    private static final String[] sWhiteClassPackagesArr;
    private final Set<String> whiteClassNames;

    static {
        HashSet hashSet = new HashSet();
        sWhiteClassPackages = hashSet;
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        sWhiteClassPackagesArr = strArr;
        sUseSimpleCompare = strArr.length <= 5;
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLoadedClass", new Class[]{String.class});
            sFindLoadedClassMethod = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = BaseDexClassLoader.class.getDeclaredMethod("findClass", new Class[]{String.class});
            sFindClassMethod = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (NoSuchMethodException unused) {
        }
    }

    public static void setEnableLogging(boolean z) {
        sEnableLogging = z;
    }

    private static Class<?> findClassDirectly(BaseDexClassLoader baseDexClassLoader, String str) throws ClassNotFoundException {
        try {
            Class<?> cls = (Class) sFindLoadedClassMethod.invoke(baseDexClassLoader, new Object[]{str});
            if (cls != null) {
                return cls;
            }
            return (Class) sFindClassMethod.invoke(baseDexClassLoader, new Object[]{str});
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof ClassNotFoundException)) {
                return null;
            }
            throw ((ClassNotFoundException) e.getTargetException());
        } catch (Throwable unused) {
            return null;
        }
    }

    private AndroidNClassLoader(String str, PathClassLoader pathClassLoader, Application application) {
        super(str, pathClassLoader.getParent());
        HashSet hashSet = new HashSet();
        this.whiteClassNames = hashSet;
        originClassLoader = pathClassLoader;
        addClassToSet(hashSet, getClass());
        addClassToSet(this.whiteClassNames, application.getClass());
    }

    private static void addClassToSet(Set<String> set, Class cls) {
        if (cls != null && cls != Object.class && cls != Application.class && cls.getClassLoader() != Object.class.getClassLoader() && cls.getClassLoader() != Application.class.getClassLoader() && set.add(cls.getName())) {
            addClassToSet(set, cls.getSuperclass());
            for (Class addClassToSet : cls.getInterfaces()) {
                addClassToSet(set, addClassToSet);
            }
        }
    }

    private static Object recreateDexPathList(Object obj, ClassLoader classLoader2) throws Exception {
        Object[] objArr = (Object[]) ReflectUtil.findField(obj, "dexElements").get(obj);
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Object obj2 : objArr) {
            DexFile dexFile = (DexFile) ReflectUtil.findField(obj2, "dexFile").get(obj2);
            if (dexFile != null) {
                Logger.log("AndroidNClassLoader dexName:" + dexFile.getName(), new Object[0]);
                if (z) {
                    z = false;
                } else {
                    sb.append(File.pathSeparator);
                }
                sb.append(dexFile.getName());
            }
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        Field findField = ReflectUtil.findField(obj, "nativeLibraryDirectories");
        try {
            boolean z2 = true;
            for (File file : (List) findField.get(obj)) {
                if (file != null) {
                    if (z2) {
                        z2 = false;
                    } else {
                        sb3.append(File.pathSeparator);
                    }
                    sb3.append(file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
            boolean z3 = true;
            for (File file2 : (File[]) findField.get(obj)) {
                if (file2 != null) {
                    if (z3) {
                        z3 = false;
                    } else {
                        sb3.append(File.pathSeparator);
                    }
                    sb3.append(file2.getAbsolutePath());
                }
            }
        }
        return ReflectUtil.findConstructor(obj, ClassLoader.class, String.class, String.class, File.class).newInstance(new Object[]{classLoader2, sb2, sb3.toString(), null});
    }

    private static AndroidNClassLoader createAndroidNClassLoader(PathClassLoader pathClassLoader, Application application) throws Exception {
        AndroidNClassLoader androidNClassLoader = new AndroidNClassLoader("", pathClassLoader, application);
        Field findField = ReflectUtil.findField(pathClassLoader, "pathList");
        findField.set(androidNClassLoader, recreateDexPathList(findField.get(pathClassLoader), androidNClassLoader));
        return androidNClassLoader;
    }

    private void reflectPackageInfoClassloader(Application application) throws Exception {
        Context context = (Context) ReflectUtil.findField(application, "mBase").get(application);
        Object obj = ReflectUtil.findField(context, "mPackageInfo").get(context);
        Field findField = ReflectUtil.findField(obj, "mClassLoader");
        Thread.currentThread().setContextClassLoader(this);
        findField.set(obj, this);
        setEnableLogging(PatchManager.getEnableLog(application));
    }

    public static PathClassLoader inject(PathClassLoader pathClassLoader, Application application) throws Exception {
        if (classLoader == null) {
            AndroidNClassLoader createAndroidNClassLoader = createAndroidNClassLoader(pathClassLoader, application);
            classLoader = createAndroidNClassLoader;
            createAndroidNClassLoader.reflectPackageInfoClassloader(application);
        }
        return classLoader;
    }

    private boolean contains(String str) {
        return this.whiteClassNames.contains(str);
    }

    private boolean containsWhitePackages(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            if (sWhiteClassPackages.contains(str.substring(0, lastIndexOf + 1))) {
                return true;
            }
            int lastIndexOf2 = str.lastIndexOf(46, lastIndexOf - 1);
            while (lastIndexOf2 >= 0) {
                if (sWhiteClassPackages.contains(str.substring(0, lastIndexOf2 + 1))) {
                    return true;
                }
                lastIndexOf2 = str.lastIndexOf(46, lastIndexOf2 - 1);
            }
        }
        return false;
    }

    private boolean containsWhitePackagesSimple(String str) {
        for (int length = sWhiteClassPackagesArr.length - 1; length >= 0; length--) {
            if (startsWith(str, sWhiteClassPackagesArr[length])) {
                return true;
            }
        }
        return false;
    }

    private boolean startsWith(String str, String str2) {
        int length = str2.length();
        if (str.length() - length < 0) {
            return false;
        }
        do {
            length--;
            if (length < 0) {
                return true;
            }
        } while (str.charAt(length) == str2.charAt(length));
        return false;
    }

    /* access modifiers changed from: protected */
    public Class<?> findClass(String str) throws ClassNotFoundException {
        String str2;
        boolean z = sEnableLogging;
        long currentTimeMillis = z ? System.currentTimeMillis() : 0;
        String str3 = null;
        if (contains(str)) {
            Class<?> findClassDirectly = findClassDirectly(originClassLoader, str);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("found origin class (+");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                sb.append("ms): ");
                sb.append(str);
                sb.append(" at cl: ");
                if (!(findClassDirectly == null || findClassDirectly.getClassLoader() == null)) {
                    str3 = findClassDirectly.getClassLoader().getClass().getName();
                }
                sb.append(str3);
                Logger.log(sb.toString(), new Object[0]);
            }
            return findClassDirectly;
        }
        try {
            Class<?> findClass = super.findClass(str);
            if (z) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("found fixed class (+");
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                sb2.append("ms): ");
                sb2.append(str);
                sb2.append(" at cl: ");
                if (findClass != null) {
                    if (findClass.getClassLoader() != null) {
                        str2 = findClass.getClassLoader().getClass().getName();
                        sb2.append(str2);
                        Logger.log(sb2.toString(), new Object[0]);
                    }
                }
                str2 = null;
                sb2.append(str2);
                Logger.log(sb2.toString(), new Object[0]);
            }
            return findClass;
        } catch (ClassNotFoundException unused) {
            Class<?> findClassDirectly2 = findClassDirectly(originClassLoader, str);
            if (z) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("found external class (+");
                sb3.append(System.currentTimeMillis() - currentTimeMillis);
                sb3.append("ms): ");
                sb3.append(str);
                sb3.append(" at cl: ");
                if (!(findClassDirectly2 == null || findClassDirectly2.getClassLoader() == null)) {
                    str3 = findClassDirectly2.getClassLoader().getClass().getName();
                }
                sb3.append(str3);
                Logger.log(sb3.toString(), new Object[0]);
            }
            return findClassDirectly2;
        }
    }

    public String findLibrary(String str) {
        return super.findLibrary(str);
    }

    /* access modifiers changed from: protected */
    public URL findResource(String str) {
        URL findResource = super.findResource(str);
        return findResource == null ? originClassLoader.getResource(str) : findResource;
    }

    /* access modifiers changed from: protected */
    public Enumeration<URL> findResources(String str) {
        Enumeration<URL> findResources = super.findResources(str);
        if (findResources != null) {
            return findResources;
        }
        try {
            return originClassLoader.getResources(str);
        } catch (IOException e) {
            Logger.warn(e);
            return findResources;
        }
    }

    public void addWhiteClassName(String str) {
        this.whiteClassNames.add(str);
        Logger.info("added white list class: " + str + ", list size: " + this.whiteClassNames.size(), new Object[0]);
    }
}
