package com.didichuxing.afanty.common.collector;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.sdk.apm.SystemUtils;

public class PackageCollector {

    /* renamed from: a */
    private static Context f45556a;

    /* renamed from: b */
    private static PackageManager f45557b;

    /* renamed from: c */
    private static PackageInfo f45558c;

    public static void init(Context context) {
        f45556a = context;
    }

    public static String getPkgName() {
        try {
            if (f45556a != null) {
                return f45556a.getPackageName();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getVN() {
        try {
            PackageManager packageManager = f45556a.getPackageManager();
            f45557b = packageManager;
            PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, f45556a.getPackageName(), 0);
            f45558c = packageInfo;
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return DCryptoMainFragment.DCRYPTO_NA;
        } catch (Exception unused) {
            return DCryptoMainFragment.DCRYPTO_NA;
        }
    }

    public static int getVC() {
        try {
            PackageManager packageManager = f45556a.getPackageManager();
            f45557b = packageManager;
            PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, f45556a.getPackageName(), 0);
            f45558c = packageInfo;
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
