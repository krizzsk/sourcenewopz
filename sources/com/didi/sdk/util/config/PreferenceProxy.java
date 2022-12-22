package com.didi.sdk.util.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.ConcurrentHashMap;

public class PreferenceProxy {

    /* renamed from: a */
    private static PreferenceProxy f37726a;

    /* renamed from: b */
    private SharedPreferences f37727b;

    /* renamed from: c */
    private PreferenceEditorProxy f37728c;

    /* renamed from: d */
    private ConcurrentHashMap<String, Object> f37729d = new ConcurrentHashMap<>();

    public PreferenceProxy(Context context) {
        this.f37727b = SystemUtils.getSharedPreferences(context, "imconfig", 0);
        PreferenceEditorProxy instance = PreferenceEditorProxy.getInstance();
        this.f37728c = instance;
        instance.mo96661a(this.f37727b.edit());
        this.f37728c.mo96662a(this.f37729d);
    }

    public PreferenceEditorProxy getEditor() {
        return this.f37728c;
    }

    public String getString(String str, String str2) {
        Object obj = this.f37729d.get(str);
        if (obj != null) {
            return String.valueOf(obj);
        }
        String str3 = null;
        if (this.f37727b.contains(str) && (str3 = this.f37727b.getString(str, str2)) != null) {
            this.f37729d.put(str, str3);
        }
        return str3 == null ? str2 : str3;
    }

    public long getLong(String str, int i) {
        long j;
        Object obj = this.f37729d.get(str);
        if (obj != null) {
            return Long.parseLong(String.valueOf(obj));
        }
        if (this.f37727b.contains(str)) {
            j = this.f37727b.getLong(str, (long) i);
            this.f37729d.put(str, Long.valueOf(j));
        } else {
            j = Long.MIN_VALUE;
        }
        return j == Long.MIN_VALUE ? (long) i : j;
    }

    public String getStringCur(String str, String str2) {
        return this.f37727b.getString(str, str2);
    }

    public int getInt(String str, int i) {
        int i2;
        Object obj = this.f37729d.get(str);
        if (obj != null) {
            return Integer.parseInt(String.valueOf(obj));
        }
        if (this.f37727b.contains(str)) {
            i2 = this.f37727b.getInt(str, i);
            this.f37729d.put(str, Integer.valueOf(i2));
        } else {
            i2 = Integer.MIN_VALUE;
        }
        return i2 == Integer.MIN_VALUE ? i : i2;
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = this.f37729d.get(str);
        if (obj != null) {
            return Boolean.parseBoolean(String.valueOf(obj));
        }
        if (!this.f37727b.contains(str)) {
            return z;
        }
        boolean z2 = this.f37727b.getBoolean(str, z);
        this.f37729d.put(str, Boolean.valueOf(z2));
        return z2;
    }

    public long getLong(String str, long j) {
        long j2;
        Object obj = this.f37729d.get(str);
        if (obj != null) {
            return Long.parseLong(String.valueOf(obj));
        }
        if (this.f37727b.contains(str)) {
            j2 = this.f37727b.getLong(str, j);
            this.f37729d.put(str, Long.valueOf(j2));
        } else {
            j2 = Long.MIN_VALUE;
        }
        return j2 == Long.MIN_VALUE ? j : j2;
    }

    public float getFloat(String str, int i) {
        float f;
        Object obj = this.f37729d.get(str);
        if (obj != null) {
            return Float.parseFloat(String.valueOf(obj));
        }
        if (this.f37727b.contains(str)) {
            f = this.f37727b.getFloat(str, (float) i);
            this.f37729d.put(str, Float.valueOf(f));
        } else {
            f = Float.MIN_VALUE;
        }
        return f == Float.MIN_VALUE ? (float) i : f;
    }
}
