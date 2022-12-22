package com.didi.security.uuid;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class DeviceToken {

    /* renamed from: a */
    private static final String f38524a = "device_token";

    /* renamed from: b */
    private static final String f38525b = "createTime";

    /* renamed from: c */
    private static final String f38526c = "expireTime";

    /* renamed from: d */
    private static final String f38527d = "data";

    /* renamed from: e */
    private long f38528e;

    /* renamed from: f */
    private long f38529f;

    /* renamed from: g */
    private String f38530g;

    private DeviceToken() {
    }

    public long getExpireTime() {
        return this.f38529f;
    }

    public long getCreateTime() {
        return this.f38528e;
    }

    public static DeviceToken create(long j, long j2, String str) {
        DeviceToken deviceToken = new DeviceToken();
        deviceToken.f38528e = j;
        deviceToken.f38529f = j2;
        deviceToken.f38530g = str;
        return deviceToken;
    }

    public static DeviceToken create(long j, String str) {
        return create(System.currentTimeMillis(), j, str);
    }

    public boolean isValid() {
        return this.f38530g != null && System.currentTimeMillis() < this.f38529f;
    }

    public static DeviceToken load(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = SystemUtils.getSharedPreferences(context, "device_token", 0)) == null) {
            return null;
        }
        long j = sharedPreferences.getLong(f38525b, 0);
        long j2 = sharedPreferences.getLong(f38526c, 0);
        String string = sharedPreferences.getString("data", (String) null);
        if (string == null) {
            return null;
        }
        DeviceToken deviceToken = new DeviceToken();
        deviceToken.f38528e = j;
        deviceToken.f38529f = j2;
        deviceToken.f38530g = string;
        return deviceToken;
    }

    public void save(Context context) {
        SharedPreferences.Editor edit;
        if (context != null && (edit = SystemUtils.getSharedPreferences(context, "device_token", 0).edit()) != null && this.f38530g != null) {
            edit.putLong(f38525b, this.f38528e);
            edit.putLong(f38526c, this.f38529f);
            edit.putString("data", this.f38530g);
            edit.commit();
        }
    }

    public String toString() {
        return this.f38530g;
    }
}
