package com.didi.sdk.config.commonconfig.p149sp;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

/* renamed from: com.didi.sdk.config.commonconfig.sp.CommonConfigSp */
public class CommonConfigSp {
    public static final String KEY_COMMON_LASTEMAIL = "key_common_lastemail";
    public static final String KEY_COMMON_LASTTITLE = "key_common_lasttitle";
    public static final String KEY_FIREBASE_APP_ID = "key_firebase_app_id";

    /* renamed from: a */
    private static final String f35705a = "commoncfg-debug";

    /* renamed from: c */
    private static final String f35706c = "common_config_store";

    /* renamed from: f */
    private static CommonConfigSp f35707f;

    /* renamed from: b */
    private Logger f35708b = LoggerFactory.getLogger("CommonConfigSp");

    /* renamed from: d */
    private Context f35709d;

    /* renamed from: e */
    private SharedPreferences f35710e;

    private CommonConfigSp() {
    }

    public void init(Context context) {
        this.f35709d = context;
        this.f35710e = SystemUtils.getSharedPreferences(context, f35706c, 0);
    }

    public static CommonConfigSp getInstance() {
        if (f35707f == null) {
            f35707f = new CommonConfigSp();
        }
        return f35707f;
    }

    public void clear() {
        SharedPreferences.Editor edit = this.f35710e.edit();
        if (edit != null) {
            edit.clear();
            edit.apply();
        }
    }

    public void put(String str, String str2) {
        this.f35710e.edit().putString(str, str2).apply();
    }

    public void put(String str, int i) {
        this.f35710e.edit().putInt(str, i).apply();
    }

    public void put(String str, long j) {
        this.f35710e.edit().putLong(str, j).apply();
    }

    public void put(String str, float f) {
        this.f35710e.edit().putFloat(str, f).apply();
    }

    public String get(String str, String str2) {
        return this.f35710e.getString(str, str2);
    }

    public int get(String str, int i) {
        return this.f35710e.getInt(str, i);
    }

    public long get(String str, long j) {
        return this.f35710e.getLong(str, j);
    }

    public float get(String str, float f) {
        return this.f35710e.getFloat(str, f);
    }
}
