package com.didichuxing.mas.sdk.quality.report.perforence;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class ServiceConfig {
    private static final String OMEGA_USER_INFO = "omega_user_info";
    private SharedPreferences mshardPreferences;

    private SharedPreferences getSharedPreference() {
        RuntimeCheck.CheckProcess();
        return this.mshardPreferences;
    }

    private static class InnerConfigManager {
        /* access modifiers changed from: private */
        public static ServiceConfig instanse = new ServiceConfig();

        private InnerConfigManager() {
        }
    }

    public static ServiceConfig getInstanse() {
        return InnerConfigManager.instanse;
    }

    private ServiceConfig() {
        this.mshardPreferences = null;
    }

    public void init(Context context) {
        this.mshardPreferences = SystemUtils.getSharedPreferences(context.getApplicationContext(), "omega_user_info", 0);
    }

    public long getLongValue(String str, long j) {
        if (RuntimeCheck.IsMainProcess()) {
            return getSharedPreference().getLong(str, j);
        }
        return ConfigProvider.getLongValue(str, j);
    }

    public boolean getBooleanValue(String str, boolean z) {
        if (RuntimeCheck.IsMainProcess()) {
            return getSharedPreference().getBoolean(str, z);
        }
        return ConfigProvider.getBooleanValue(str, z);
    }

    public int getIntValue(String str, int i) {
        if (RuntimeCheck.IsMainProcess()) {
            return getSharedPreference().getInt(str, i);
        }
        return ConfigProvider.getIntValue(str, i);
    }

    public String getStringValue(String str, String str2) {
        if (RuntimeCheck.IsMainProcess()) {
            return getSharedPreference().getString(str, str2);
        }
        return ConfigProvider.getStringValue(str, str2);
    }

    public void setBooleanValue(String str, boolean z) {
        if (RuntimeCheck.IsMainProcess()) {
            SharedPreferences.Editor edit = getSharedPreference().edit();
            edit.putBoolean(str, z);
            edit.apply();
            return;
        }
        ConfigProvider.setBooleanValue(str, z);
    }

    public void setLongValue(String str, long j) {
        if (RuntimeCheck.IsMainProcess()) {
            SharedPreferences.Editor edit = getSharedPreference().edit();
            edit.putLong(str, j);
            edit.apply();
            return;
        }
        ConfigProvider.setLongValue(str, j);
    }

    public void setIntValue(String str, int i) {
        if (RuntimeCheck.IsMainProcess()) {
            SharedPreferences.Editor edit = getSharedPreference().edit();
            edit.putInt(str, i);
            edit.apply();
            return;
        }
        ConfigProvider.setIntValue(str, i);
    }

    public void setStringValue(String str, String str2) {
        if (RuntimeCheck.IsMainProcess()) {
            SharedPreferences.Editor edit = getSharedPreference().edit();
            edit.putString(str, str2);
            edit.apply();
            return;
        }
        ConfigProvider.setStringValue(str, str2);
    }

    public void removeKey(String str) {
        if (RuntimeCheck.IsMainProcess()) {
            SharedPreferences.Editor edit = getSharedPreference().edit();
            edit.remove(str);
            edit.apply();
            return;
        }
        ConfigProvider.removeKey(str);
    }

    public boolean hasKey(String str) {
        if (RuntimeCheck.IsMainProcess()) {
            return getSharedPreference().contains(str);
        }
        return ConfigProvider.contains(str);
    }
}
