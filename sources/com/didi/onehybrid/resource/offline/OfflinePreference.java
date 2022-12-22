package com.didi.onehybrid.resource.offline;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.onehybrid.Constants;
import com.didi.sdk.apm.SystemUtils;

public class OfflinePreference {
    private static OfflinePreference instance;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPref;

    private OfflinePreference(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, Constants.FUSION_OFFLINE_PREFERENCE, 0);
        this.mPref = sharedPreferences;
        this.mEditor = sharedPreferences.edit();
    }

    public static OfflinePreference getInstance(Context context) {
        if (instance == null) {
            instance = new OfflinePreference(context);
        }
        return instance;
    }

    public void updateCurrentDayFlow(int i, long j) {
        this.mEditor.putLong(String.valueOf(i), j);
        this.mEditor.putInt(Constants.FUSION_OFFLINE_FLOW_DATE, i);
        this.mEditor.apply();
    }

    public boolean has(String str) {
        return this.mPref.contains(str);
    }

    public void putString(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.mEditor.putString(str, str2);
        } else {
            this.mEditor.remove(str);
        }
        commit();
    }

    public String getString(String str, String str2) {
        return this.mPref.getString(str, str2);
    }

    public int getInt(String str, int i) {
        return this.mPref.getInt(str, i);
    }

    public void putInt(String str, int i) {
        this.mEditor.putInt(str, i);
        commit();
    }

    public boolean contains(String str) {
        return this.mPref.contains(str);
    }

    public float getFloat(String str, float f) {
        return this.mPref.getFloat(str, f);
    }

    public void putFloat(String str, float f) {
        this.mEditor.putFloat(str, f);
        commit();
    }

    public boolean getBoolean(String str, boolean z) {
        return this.mPref.getBoolean(str, z);
    }

    public void putBoolean(String str, boolean z) {
        this.mEditor.putBoolean(str, z);
        commit();
    }

    public long getLong(String str, long j) {
        return this.mPref.getLong(str, j);
    }

    public void putLong(String str, long j) {
        this.mEditor.putLong(str, j);
        commit();
    }

    private void commit() {
        this.mEditor.apply();
    }

    public void remove(String str) {
        this.mEditor.remove(str);
        commit();
    }

    public void clear() {
        this.mEditor.clear();
        commit();
    }
}
