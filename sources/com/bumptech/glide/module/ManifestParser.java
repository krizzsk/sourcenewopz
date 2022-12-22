package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context context2) {
        this.context = context2;
    }

    public List<GlideModule> parse() {
        if (Log.isLoggable(TAG, 3)) {
            SystemUtils.log(3, TAG, "Loading Glide modules", (Throwable) null, "com.bumptech.glide.module.ManifestParser", 30);
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = SystemUtils.getApplicationInfo(this.context.getPackageManager(), this.context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable(TAG, 3)) {
                    SystemUtils.log(3, TAG, "Got null app info metadata", (Throwable) null, "com.bumptech.glide.module.ManifestParser", 40);
                }
                return arrayList;
            }
            if (Log.isLoggable(TAG, 2)) {
                SystemUtils.log(2, TAG, "Got app info metadata: " + applicationInfo.metaData, (Throwable) null, "com.bumptech.glide.module.ManifestParser", 45);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if (GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(parseModule(str));
                    if (Log.isLoggable(TAG, 3)) {
                        SystemUtils.log(3, TAG, "Loaded Glide module: " + str, (Throwable) null, "com.bumptech.glide.module.ManifestParser", 51);
                    }
                }
            }
            if (Log.isLoggable(TAG, 3)) {
                SystemUtils.log(3, TAG, "Finished loading Glide modules", (Throwable) null, "com.bumptech.glide.module.ManifestParser", 59);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    private static GlideModule parseModule(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (InstantiationException e) {
                throwInstantiateGlideModuleException(cls, e);
            } catch (IllegalAccessException e2) {
                throwInstantiateGlideModuleException(cls, e2);
            } catch (NoSuchMethodException e3) {
                throwInstantiateGlideModuleException(cls, e3);
            } catch (InvocationTargetException e4) {
                throwInstantiateGlideModuleException(cls, e4);
            }
            if (obj instanceof GlideModule) {
                return (GlideModule) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    private static void throwInstantiateGlideModuleException(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }
}
