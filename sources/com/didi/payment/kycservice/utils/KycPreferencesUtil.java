package com.didi.payment.kycservice.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.sdk.apm.SystemUtils;

public class KycPreferencesUtil {

    /* renamed from: a */
    private static SharedPreferences f30928a = null;

    /* renamed from: b */
    private static String f30929b = "payment_kyc_sp";

    public static void putBoolean(Context context, String str, boolean z) {
        if (f30928a == null) {
            f30928a = SystemUtils.getSharedPreferences(context, f30929b, 0);
        }
        f30928a.edit().putBoolean(str, z).apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        if (f30928a == null) {
            f30928a = SystemUtils.getSharedPreferences(context, f30929b, 0);
        }
        return f30928a.getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        if (f30928a == null) {
            f30928a = SystemUtils.getSharedPreferences(context, f30929b, 0);
        }
        f30928a.edit().putString(str, str2).apply();
    }

    public static String getString(Context context, String str, String str2) {
        if (f30928a == null) {
            f30928a = SystemUtils.getSharedPreferences(context, f30929b, 0);
        }
        return f30928a.getString(str, str2);
    }

    public static void putInt(Context context, String str, int i) {
        if (f30928a == null) {
            f30928a = SystemUtils.getSharedPreferences(context, f30929b, 0);
        }
        f30928a.edit().putInt(str, i).apply();
    }

    public static int getInt(Context context, String str, int i) {
        if (f30928a == null) {
            f30928a = SystemUtils.getSharedPreferences(context, f30929b, 0);
        }
        return f30928a.getInt(str, i);
    }

    public static void remove(Context context, String str) {
        if (f30928a == null) {
            f30928a = SystemUtils.getSharedPreferences(context, f30929b, 0);
        }
        f30928a.edit().remove(str).apply();
    }

    public static boolean exist(Context context, String str) {
        if (f30928a == null) {
            f30928a = SystemUtils.getSharedPreferences(context, f30929b, 0);
        }
        return f30928a.contains(str);
    }

    public static boolean primaryKycNeedGuides(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(PayBaseParamUtil.getStringParam(context, "uid"));
        sb.append("sp_kyc_primary_show");
        return getInt(context, sb.toString(), 0) < 3;
    }

    public static void primaryKycShowGuides(Context context, int i) {
        int i2 = getInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_primary_show", 0);
        putInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_primary_show", i2 + i);
    }

    public static boolean fullKycNeedGuides(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(PayBaseParamUtil.getStringParam(context, "uid"));
        sb.append("sp_kyc_full_show");
        return getInt(context, sb.toString(), 0) < 3;
    }

    public static void fullKycShowGuides(Context context, int i) {
        int i2 = getInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_full_show", 0);
        putInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_full_show", i2 + i);
    }

    public static boolean pixKycNeedGuides(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(PayBaseParamUtil.getStringParam(context, "uid"));
        sb.append("sp_kyc_pix_show");
        return getInt(context, sb.toString(), 0) < 3;
    }

    public static void pixKycShowGuides(Context context, int i) {
        int i2 = getInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_pix_show", 0);
        putInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_pix_show", i2 + i);
    }

    public static boolean pwdKycNeedGuides(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(PayBaseParamUtil.getStringParam(context, "uid"));
        sb.append("sp_kyc_pwd_show");
        return getInt(context, sb.toString(), 0) < 3;
    }

    public static void pwdKycShowGuides(Context context, int i) {
        int i2 = getInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_pwd_show", 0);
        putInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_pwd_show", i2 + i);
    }

    public static boolean antiKycNeedGuides(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(PayBaseParamUtil.getStringParam(context, "uid"));
        sb.append("sp_kyc_anti_show");
        return getInt(context, sb.toString(), 0) < 3;
    }

    public static void antiKycShowGuides(Context context, int i) {
        int i2 = getInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_anti_show", 0);
        putInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_anti_show", i2 + i);
    }

    public static boolean cryptoKycNeedGuides(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(PayBaseParamUtil.getStringParam(context, "uid"));
        sb.append("sp_kyc_crypto_show");
        return getInt(context, sb.toString(), 0) < 3;
    }

    public static void cryptoKycShowGuides(Context context, int i) {
        int i2 = getInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_crypto_show", 0);
        putInt(context, PayBaseParamUtil.getStringParam(context, "uid") + "sp_kyc_crypto_show", i2 + i);
    }
}
