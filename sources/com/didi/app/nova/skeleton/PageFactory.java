package com.didi.app.nova.skeleton;

import android.os.Bundle;
import com.didi.app.nova.skeleton.conductor.internal.ClassUtils;
import java.lang.reflect.Constructor;

public class PageFactory {
    public static Page newInstance(String str, Bundle bundle) {
        return newInstance(ClassUtils.classForName(str, false), bundle);
    }

    public static Page newInstance(Class cls, Bundle bundle) {
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        Constructor b = m5422b(declaredConstructors);
        if (b != null) {
            try {
                return (Page) b.newInstance(new Object[]{bundle});
            } catch (Exception e) {
                throw new RuntimeException("An exception occurred while creating a new instance of " + cls.getName() + ". " + e.getMessage(), e);
            }
        } else {
            Page page = (Page) m5421a(declaredConstructors).newInstance(new Object[0]);
            page.setArgs(bundle);
            return page;
        }
    }

    /* renamed from: a */
    private static Constructor m5421a(Constructor[] constructorArr) {
        for (Constructor constructor : constructorArr) {
            if (constructor.getParameterTypes().length == 0) {
                constructor.setAccessible(true);
                return constructor;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static Constructor m5422b(Constructor[] constructorArr) {
        for (Constructor constructor : constructorArr) {
            if (constructor.getParameterTypes().length == 1 && constructor.getParameterTypes()[0] == Bundle.class) {
                return constructor;
            }
        }
        return null;
    }
}
