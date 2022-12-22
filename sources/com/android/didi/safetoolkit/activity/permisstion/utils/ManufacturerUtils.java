package com.android.didi.safetoolkit.activity.permisstion.utils;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ManufacturerUtils {
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String brand = Build.BRAND.toLowerCase();
    private static final String manufacturer = Build.MANUFACTURER.toLowerCase();

    public static boolean isMotorola() {
        return TextUtils.equals(manufacturer, "motorola") || TextUtils.equals(manufacturer, "mot") || TextUtils.equals(manufacturer, "fih");
    }

    public static boolean isLG() {
        return TextUtils.equals(manufacturer, "lg");
    }

    public static boolean isMIUI() {
        return TextUtils.equals(brand, "redmi") || TextUtils.equals(brand, "xiaomi");
    }

    public static boolean isSony() {
        return TextUtils.equals(manufacturer, "sony");
    }

    public static boolean isFlyme() {
        return TextUtils.equals(brand, "meizu");
    }

    public static boolean isHuawei() {
        return TextUtils.equals(brand, Payload.SOURCE_HUAWEI) || TextUtils.equals(brand, "honor");
    }

    public static boolean isSamsung() {
        return TextUtils.equals(manufacturer, "samsung");
    }

    public static class BuildProperties {
        private final Properties properties;

        private BuildProperties() throws IOException {
            Properties properties2 = new Properties();
            this.properties = properties2;
            properties2.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public boolean containsKey(Object obj) {
            return this.properties.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return this.properties.containsValue(obj);
        }

        public Set<Map.Entry<Object, Object>> entrySet() {
            return this.properties.entrySet();
        }

        public String getProperty(String str) {
            return this.properties.getProperty(str);
        }

        public String getProperty(String str, String str2) {
            return this.properties.getProperty(str, str2);
        }

        public boolean isEmpty() {
            return this.properties.isEmpty();
        }

        public Enumeration<Object> keys() {
            return this.properties.keys();
        }

        public Set<Object> keySet() {
            return this.properties.keySet();
        }

        public int size() {
            return this.properties.size();
        }

        public Collection<Object> values() {
            return this.properties.values();
        }

        public static BuildProperties newInstance() throws IOException {
            return new BuildProperties();
        }
    }
}
