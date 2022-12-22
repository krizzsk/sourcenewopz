package com.didichuxing.security.safecollector;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.Map;
import java.util.Set;

/* renamed from: com.didichuxing.security.safecollector.b */
/* compiled from: DefaultPreferences */
final class C16447b implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: a */
    private static C16447b f48996a;

    /* renamed from: b */
    private SharedPreferences f48997b;

    /* renamed from: c */
    private SharedPreferences.Editor f48998c;

    private C16447b() {
    }

    /* renamed from: a */
    public static synchronized C16447b m35229a() {
        C16447b bVar;
        synchronized (C16447b.class) {
            if (f48996a == null) {
                f48996a = new C16447b();
            }
            bVar = f48996a;
        }
        return bVar;
    }

    /* renamed from: a */
    public void mo120989a(Context context) {
        SharedPreferences defaultSharedPreferences = SystemUtils.getDefaultSharedPreferences(context);
        this.f48997b = defaultSharedPreferences;
        this.f48998c = defaultSharedPreferences.edit();
    }

    public Map<String, ?> getAll() {
        return this.f48997b.getAll();
    }

    public String getString(String str, String str2) {
        return this.f48997b.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return this.f48997b.getStringSet(str, set);
    }

    public int getInt(String str, int i) {
        return this.f48997b.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return this.f48997b.getLong(str, j);
    }

    public float getFloat(String str, float f) {
        return this.f48997b.getFloat(str, f);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.f48997b.getBoolean(str, z);
    }

    public boolean contains(String str) {
        return this.f48997b.contains(str);
    }

    public SharedPreferences.Editor edit() {
        return this.f48997b.edit();
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f48997b.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f48997b.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        SharedPreferences.Editor putString = this.f48998c.putString(str, str2);
        putString.apply();
        return putString;
    }

    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        SharedPreferences.Editor putStringSet = this.f48998c.putStringSet(str, set);
        putStringSet.apply();
        return putStringSet;
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        SharedPreferences.Editor putInt = this.f48998c.putInt(str, i);
        putInt.apply();
        return putInt;
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        SharedPreferences.Editor putLong = this.f48998c.putLong(str, j);
        putLong.apply();
        return putLong;
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        SharedPreferences.Editor putFloat = this.f48998c.putFloat(str, f);
        putFloat.apply();
        return putFloat;
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        SharedPreferences.Editor putBoolean = this.f48998c.putBoolean(str, z);
        putBoolean.apply();
        return putBoolean;
    }

    public SharedPreferences.Editor remove(String str) {
        SharedPreferences.Editor remove = this.f48998c.remove(str);
        remove.apply();
        return remove;
    }

    public SharedPreferences.Editor clear() {
        SharedPreferences.Editor clear = this.f48998c.clear();
        clear.apply();
        return clear;
    }

    public boolean commit() {
        return this.f48998c.commit();
    }

    public void apply() {
        this.f48998c.apply();
    }

    /* renamed from: a */
    public boolean mo120990a(String str, Object obj) {
        if (str == null) {
            return false;
        }
        if (obj instanceof String) {
            putString(str, (String) obj);
        } else if (obj instanceof Set) {
            putStringSet(str, (Set) obj);
        } else if (obj instanceof Integer) {
            putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            putFloat(str, ((Float) obj).floatValue());
        } else if (!(obj instanceof Long)) {
            return false;
        } else {
            putLong(str, ((Long) obj).longValue());
        }
        apply();
        return true;
    }

    /* renamed from: b */
    public <T> T mo120992b(String str, T t) {
        if (str == null) {
            return null;
        }
        if (t instanceof String) {
            return getString(str, (String) t);
        }
        if (t instanceof Set) {
            return putStringSet(str, (Set) t);
        }
        if (t instanceof Integer) {
            return Integer.valueOf(getInt(str, ((Integer) t).intValue()));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(getBoolean(str, ((Boolean) t).booleanValue()));
        }
        if (t instanceof Float) {
            return Float.valueOf(getFloat(str, ((Float) t).floatValue()));
        }
        if (t instanceof Long) {
            return Long.valueOf(getLong(str, ((Long) t).longValue()));
        }
        return null;
    }
}
