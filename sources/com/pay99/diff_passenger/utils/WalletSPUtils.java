package com.pay99.diff_passenger.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class WalletSPUtils {

    /* renamed from: a */
    private static final String f55817a = "global_wallet_sp";

    public static void getAccountGuideHasShowed(Context context) {
        m40238a(context).edit().putBoolean("get_account_guide_has_showed", true).apply();
    }

    public static boolean needShowGetAccountGuide(Context context) {
        return !m40238a(context).getBoolean("get_account_guide_has_showed", false);
    }

    public static void topUpGuideHasShowed(Context context) {
        m40238a(context).edit().putBoolean("top_up_guide_has_showed", true).apply();
    }

    public static boolean needShowTopUpGuide(Context context) {
        return !m40238a(context).getBoolean("top_up_guide_has_showed", false);
    }

    public static void setHistoryShowCancelReasonCount(Context context, int i) {
        m40238a(context).edit().putInt("history_show_cancel_reason_count", i).apply();
    }

    public static int getHistoryShowCancelReasonCount(Context context) {
        return m40238a(context).getInt("history_show_cancel_reason_count", 0);
    }

    public static void savePayPwdGuideShowCount(String str, Context context) {
        int payPwdGuideShowCount = getPayPwdGuideShowCount(str, context);
        SharedPreferences.Editor edit = m40238a(context).edit();
        edit.putInt("pay_pwd_guide_" + str, payPwdGuideShowCount + 1).apply();
    }

    public static int getPayPwdGuideShowCount(String str, Context context) {
        SharedPreferences a = m40238a(context);
        return a.getInt("pay_pwd_guide_" + str, 0);
    }

    public static void saveCanRequestPwd(Context context, String str, Boolean bool) {
        SharedPreferences.Editor edit = m40238a(context).edit();
        edit.putBoolean("pay_pwd_can_request_" + str, bool.booleanValue()).apply();
    }

    public static Boolean getCanRequestPwd(Context context, String str) {
        SharedPreferences a = m40238a(context);
        return Boolean.valueOf(a.getBoolean("pay_pwd_can_request_" + str, true));
    }

    /* renamed from: a */
    private static SharedPreferences m40238a(Context context) {
        return SystemUtils.getSharedPreferences(context, f55817a, 0);
    }
}
