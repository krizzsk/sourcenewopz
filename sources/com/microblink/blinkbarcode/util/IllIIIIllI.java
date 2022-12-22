package com.microblink.blinkbarcode.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

/* compiled from: line */
public abstract class IllIIIIllI {
    private SharedPreferences llIIlIlIIl;

    public IllIIIIllI(Context context, String str) {
        this.llIIlIlIIl = SystemUtils.getSharedPreferences(context, str, 0);
    }

    public long IlIllIlIIl(String str) {
        return this.llIIlIlIIl.getLong(str, 0);
    }

    public String IllIIIllII(String str) {
        return this.llIIlIlIIl.getString(str, (String) null);
    }

    public void llIIIlllll(String str) {
        this.llIIlIlIIl.edit().remove(str).apply();
    }

    public void llIIlIlIIl(String str, String str2) {
        this.llIIlIlIIl.edit().putString(str, str2).apply();
    }

    public void llIIlIlIIl(String str, long j) {
        this.llIIlIlIIl.edit().putLong(str, j).apply();
    }

    public void llIIlIlIIl(String str, Boolean bool) {
        this.llIIlIlIIl.edit().putBoolean(str, bool.booleanValue()).apply();
    }

    public Boolean llIIlIlIIl(String str) {
        return Boolean.valueOf(this.llIIlIlIIl.getBoolean(str, false));
    }
}
