package com.didi.safety.god.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.Map;

public class SharedUtil {

    /* renamed from: a */
    private static String f34845a = "PushSharePreference";

    /* renamed from: b */
    private Context f34846b;

    /* renamed from: c */
    private String f34847c = "YueSuoPing";

    public SharedUtil(Context context) {
        this.f34846b = context;
    }

    public void saveIntValue(String str, int i) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public void saveLongValue(String str, long j) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).edit();
        edit.putLong(str, j);
        edit.commit();
    }

    public void writeDownStartApplicationTime() {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0);
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("nowtimekey", currentTimeMillis);
        edit.commit();
    }

    public void saveBooleanValue(String str, boolean z) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public void removeSharePreferences(String str) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).edit();
        edit.remove(str);
        edit.commit();
    }

    public boolean contains(String str) {
        return SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).contains(str);
    }

    public Map<String, Object> getAllMap() {
        return SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).getAll();
    }

    public Integer getIntValueByKey(String str) {
        return Integer.valueOf(SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).getInt(str, -1));
    }

    public Long getLongValueByKey(String str) {
        return Long.valueOf(SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).getLong(str, -1));
    }

    public void saveStringValue(String str, String str2) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public String getStringValueByKey(String str) {
        return SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).getString(str, (String) null);
    }

    public Boolean getBooleanValueByKey(String str) {
        return Boolean.valueOf(SystemUtils.getSharedPreferences(this.f34846b, this.f34847c, 0).getBoolean(str, false));
    }

    public Integer getIntValueAndRemoveByKey(String str) {
        Integer intValueByKey = getIntValueByKey(str);
        removeSharePreferences(str);
        return intValueByKey;
    }

    public void setUserkey(String str) {
        saveStringValue("params_userkey", str);
    }

    public String getUserkey() {
        return getStringValueByKey("params_userkey");
    }
}
