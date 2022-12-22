package com.didi.sdk.onehotpatch.loader.dex;

import android.os.Build;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.commonstatic.util.ReflectUtil;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PathListInstaller {
    public static void install(PathClassLoader pathClassLoader, ArrayList<String> arrayList, String str) throws Exception {
        if (pathClassLoader != null) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Logger.log("PathListInstaller install:" + next, new Object[0]);
                arrayList2.add(new File(next));
            }
            installDex(pathClassLoader, file, arrayList2);
        }
    }

    public static void installDex(PathClassLoader pathClassLoader, File file, List<File> list) throws Exception {
        if (list.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            V24.install(pathClassLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 23) {
            V23.install(pathClassLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 19) {
            V19.install(pathClassLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 14) {
            V14.install(pathClassLoader, list, file);
        }
    }

    private static final class V24 {
        private V24() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException {
            IOException[] iOExceptionArr;
            Object obj = ReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ReflectUtil.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList, classLoader));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Logger.warn((IOException) it.next());
                    Logger.log("V23 Exception in makeDexElement", new Object[0]);
                }
                Field findField = ReflectUtil.findField(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) findField.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                findField.set(obj, iOExceptionArr);
            }
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2, ClassLoader classLoader) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) ReflectUtil.findMethod(obj, "makeDexElements", List.class, File.class, List.class, ClassLoader.class).invoke(obj, new Object[]{arrayList, file, arrayList2, classLoader});
        }
    }

    private static final class V23 {
        private V23() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException {
            IOException[] iOExceptionArr;
            Object obj = ReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ReflectUtil.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Logger.warn((IOException) it.next());
                    Logger.log("V23 Exception in makeDexElement", new Object[0]);
                }
                Field findField = ReflectUtil.findField(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) findField.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                findField.set(obj, iOExceptionArr);
            }
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) ReflectUtil.findMethod(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private static final class V19 {
        private V19() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            IOException[] iOExceptionArr;
            Object obj = ReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ReflectUtil.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Logger.warn((IOException) it.next());
                    Logger.log("V19 Exception in makeDexElement", new Object[0]);
                }
                Field findField = ReflectUtil.findField(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) findField.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                findField.set(obj, iOExceptionArr);
            }
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) ReflectUtil.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private static final class V14 {
        private V14() {
        }

        /* access modifiers changed from: private */
        public static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object obj = ReflectUtil.findField(classLoader, "pathList").get(classLoader);
            ReflectUtil.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file));
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) ReflectUtil.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
        }
    }
}
