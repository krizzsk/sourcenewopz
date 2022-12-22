package com.didi.app.nova.skeleton.conductor.internal;

import android.text.TextUtils;

public class ClassUtils {
    public static <T> Class<? extends T> classForName(String str, boolean z) {
        if (z && TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new RuntimeException("An exception occurred while finding class for name " + str + ". " + e.getMessage());
        }
    }

    public static <T> T newInstance(String str) {
        try {
            Class classForName = classForName(str, true);
            if (classForName != null) {
                return classForName.newInstance();
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("An exception occurred while creating a new instance of " + str + ". " + e.getMessage());
        }
    }
}
