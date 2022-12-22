package com.didi.addressold.util;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.collection.SimpleArrayMap;
import com.didi.sdk.apm.SystemUtils;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class PreferenceUtil {

    /* renamed from: a */
    private static SimpleArrayMap<String, PreferenceUtil> f7789a = new SimpleArrayMap<>();

    /* renamed from: b */
    private SharedPreferences f7790b;

    public static PreferenceUtil getInstance(Context context) {
        return getInstance(context, "preference_name_default");
    }

    public static PreferenceUtil getInstance(Context context, String str) {
        PreferenceUtil preferenceUtil = f7789a.get(str);
        if (preferenceUtil != null) {
            return preferenceUtil;
        }
        PreferenceUtil preferenceUtil2 = new PreferenceUtil(context, str);
        f7789a.put(str, preferenceUtil2);
        return preferenceUtil2;
    }

    private PreferenceUtil(Context context, String str) {
        this.f7790b = SystemUtils.getSharedPreferences(context, str, 0);
    }

    public void put(String str, String str2) {
        this.f7790b.edit().putString(str, str2).apply();
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public String getString(String str, String str2) {
        return this.f7790b.getString(str, str2);
    }

    public void put(String str, int i) {
        this.f7790b.edit().putInt(str, i).apply();
    }

    public int getInt(String str) {
        return getInt(str, -1);
    }

    public int getInt(String str, int i) {
        return this.f7790b.getInt(str, i);
    }

    public void put(String str, long j) {
        this.f7790b.edit().putLong(str, j).apply();
    }

    public long getLong(String str) {
        return getLong(str, -1);
    }

    public long getLong(String str, long j) {
        return this.f7790b.getLong(str, j);
    }

    public void put(String str, float f) {
        this.f7790b.edit().putFloat(str, f).apply();
    }

    public float getFloat(String str) {
        return getFloat(str, -1.0f);
    }

    public float getFloat(String str, float f) {
        return this.f7790b.getFloat(str, f);
    }

    public void put(String str, boolean z) {
        this.f7790b.edit().putBoolean(str, z).apply();
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.f7790b.getBoolean(str, z);
    }

    public void put(String str, Set<String> set) {
        this.f7790b.edit().putStringSet(str, set).apply();
    }

    public Set<String> getStringSet(String str) {
        return getStringSet(str, Collections.emptySet());
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return this.f7790b.getStringSet(str, set);
    }

    public Map<String, ?> getAll() {
        return this.f7790b.getAll();
    }

    public boolean contains(String str) {
        return this.f7790b.contains(str);
    }

    public void remove(String str) {
        this.f7790b.edit().remove(str).apply();
    }

    public void clear() {
        this.f7790b.edit().clear().apply();
    }
}
