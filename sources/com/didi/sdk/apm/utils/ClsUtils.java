package com.didi.sdk.apm.utils;

import android.util.Log;
import com.didi.soda.customer.p165h5.hybird.model.GuideParamModel;

public class ClsUtils {

    /* renamed from: a */
    private static final String f35059a = "ClsUtils";

    public static Class<?> creatClassObject(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public static void setSystemProperties(Class<?> cls, String str, String str2) {
        try {
            cls.getMethod(GuideParamModel.ACTION_SET, new Class[]{String.class, String.class}).invoke(cls.newInstance(), new Object[]{new String(str), new String(str2)});
        } catch (Exception e) {
            Log.w(f35059a, "Caught: " + e, e);
        }
    }

    public static String getSystemProperties(Class<?> cls, String str) {
        try {
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls.newInstance(), new Object[]{str});
        } catch (Exception e) {
            Log.w(f35059a, "Caught: " + e, e);
            return null;
        }
    }

    public static String getPropValue(String str) {
        try {
            return getSystemProperties(creatClassObject("android.os.SystemProperties"), str);
        } catch (Exception e) {
            Log.w(f35059a, "Caught: " + e);
            return null;
        }
    }
}
