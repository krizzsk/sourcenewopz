package com.megvii.livenessdetection.obf;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.security.InvalidParameterException;

/* renamed from: com.megvii.livenessdetection.obf.e */
public final class C20347e {

    /* renamed from: a */
    private String f55806a;

    /* renamed from: b */
    private SharedPreferences f55807b;

    private C20347e(Context context, String str, String str2) {
        this.f55806a = "";
        if (context != null) {
            this.f55806a = str2;
            this.f55807b = SystemUtils.getSharedPreferences(context.getApplicationContext(), str, 0);
            return;
        }
        throw new InvalidParameterException();
    }

    public C20347e(Context context) {
        this(context, "MegviiSDKPreference", "");
    }

    /* renamed from: a */
    public final synchronized void mo165093a(String str, String str2) {
        SharedPreferences.Editor edit = this.f55807b.edit();
        edit.putString(str + this.f55806a, str2).apply();
    }

    /* renamed from: a */
    public final synchronized String mo165092a(String str) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.f55807b;
        return sharedPreferences.getString(str + this.f55806a, (String) null);
    }

    /* renamed from: b */
    public final synchronized String mo165094b(String str) {
        String string;
        SharedPreferences sharedPreferences = this.f55807b;
        string = sharedPreferences.getString(str + this.f55806a, (String) null);
        SharedPreferences.Editor edit = this.f55807b.edit();
        edit.remove(str + this.f55806a).apply();
        return string;
    }
}
