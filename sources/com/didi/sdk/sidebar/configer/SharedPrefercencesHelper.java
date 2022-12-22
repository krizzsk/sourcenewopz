package com.didi.sdk.sidebar.configer;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedPrefercencesHelper {

    /* renamed from: a */
    private Map<String, String> f37226a = new ConcurrentHashMap();

    /* renamed from: b */
    private SharedPreferences f37227b = null;

    public SharedPrefercencesHelper(Context context, String str) {
        this.f37227b = SystemUtils.getSharedPreferences(context, str, 0);
    }

    public void put(Configer configer, String str) {
        SharedPreferences.Editor edit = this.f37227b.edit();
        edit.putString(configer.getName(), str);
        edit.apply();
        this.f37226a.put(configer.getName(), str);
    }

    public void put(Configer configer, long j) {
        SharedPreferences.Editor edit = this.f37227b.edit();
        edit.putLong(configer.getName(), j);
        edit.apply();
        this.f37226a.put(configer.getName(), String.valueOf(j));
    }

    public void put(Configer configer, int i) {
        SharedPreferences.Editor edit = this.f37227b.edit();
        edit.putInt(configer.getName(), i);
        edit.apply();
        this.f37226a.put(configer.getName(), String.valueOf(i));
    }

    public void put(Configer configer, boolean z) {
        SharedPreferences.Editor edit = this.f37227b.edit();
        edit.putBoolean(configer.getName(), z);
        edit.apply();
        this.f37226a.put(configer.getName(), z ? "1" : "0");
    }

    public String getString(Configer configer) {
        String str;
        if (this.f37226a.containsKey(configer.getName())) {
            return this.f37226a.get(configer.getName());
        }
        try {
            str = this.f37227b.getString(configer.getName(), configer.getDefaultValue());
        } catch (Exception unused) {
            str = "";
        }
        this.f37226a.put(configer.getName(), str);
        return str;
    }

    public int getInt(Configer configer) {
        int i;
        if (this.f37226a.containsKey(configer.getName())) {
            return Integer.parseInt(this.f37226a.get(configer.getName()));
        }
        try {
            String defaultValue = configer.getDefaultValue();
            if (TextUtils.isEmpty(defaultValue)) {
                defaultValue = "0";
            }
            i = Integer.parseInt(defaultValue);
        } catch (Exception unused) {
            i = 0;
        }
        try {
            i = this.f37227b.getInt(configer.getName(), i);
        } catch (Exception unused2) {
        }
        this.f37226a.put(configer.getName(), String.valueOf(i));
        return i;
    }

    public long getLong(Configer configer) {
        long j;
        if (this.f37226a.containsKey(configer.getName())) {
            return Long.parseLong(this.f37226a.get(configer.getName()));
        }
        try {
            String defaultValue = configer.getDefaultValue();
            if (TextUtils.isEmpty(defaultValue)) {
                defaultValue = "0";
            }
            j = Long.parseLong(defaultValue);
        } catch (Exception unused) {
            j = 0;
        }
        try {
            j = this.f37227b.getLong(configer.getName(), j);
        } catch (Exception unused2) {
        }
        this.f37226a.put(configer.getName(), String.valueOf(j));
        return j;
    }

    public boolean getBoolean(Configer configer) {
        boolean z;
        String str = "1";
        if (this.f37226a.containsKey(configer.getName())) {
            return str.equalsIgnoreCase(this.f37226a.get(configer.getName()));
        }
        try {
            z = this.f37227b.getBoolean(configer.getName(), str.equals(configer.getDefaultValue()));
        } catch (Exception unused) {
            z = false;
        }
        Map<String, String> map = this.f37226a;
        String name = configer.getName();
        if (!z) {
            str = "0";
        }
        map.put(name, str);
        return z;
    }
}
