package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* renamed from: com.yanzhenjie.permission.checker.k */
/* compiled from: PhoneStateReadTest */
class C20699k implements PermissionTest {

    /* renamed from: a */
    private Context f56189a;

    C20699k(Context context) {
        this.f56189a = context;
    }

    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        if (!this.f56189a.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.f56189a.getSystemService("phone");
        if (telephonyManager.getPhoneType() == 0 || !TextUtils.isEmpty(telephonyManager.getDeviceId()) || !TextUtils.isEmpty(telephonyManager.getSubscriberId())) {
            return true;
        }
        return false;
    }
}
