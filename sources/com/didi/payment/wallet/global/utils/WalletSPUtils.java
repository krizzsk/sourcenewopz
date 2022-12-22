package com.didi.payment.wallet.global.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.sdk.apm.SystemUtils;
import java.util.Calendar;

public class WalletSPUtils {

    /* renamed from: a */
    private static final String f32008a = "global_wallet_sp";

    public static void getAccountGuideHasShowed(Context context) {
        m22663a(context).edit().putBoolean("get_account_guide_has_showed", true).apply();
    }

    public static boolean needShowGetAccountGuide(Context context) {
        return !m22663a(context).getBoolean("get_account_guide_has_showed", false);
    }

    public static void topUpGuideHasShowed(Context context) {
        m22663a(context).edit().putBoolean("top_up_guide_has_showed", true).apply();
    }

    public static boolean needShowTopUpGuide(Context context) {
        return !m22663a(context).getBoolean("top_up_guide_has_showed", false);
    }

    public static void setHistoryShowCancelReasonCount(Context context, int i) {
        m22663a(context).edit().putInt("history_show_cancel_reason_count", i).apply();
    }

    public static int getHistoryShowCancelReasonCount(Context context) {
        return m22663a(context).getInt("history_show_cancel_reason_count", 0);
    }

    public static void savePayPwdGuideShowCount(String str, Context context) {
        int payPwdGuideShowCount = getPayPwdGuideShowCount(str, context);
        SharedPreferences.Editor edit = m22663a(context).edit();
        edit.putInt("pay_pwd_guide_" + str, payPwdGuideShowCount + 1).apply();
    }

    public static int getPayPwdGuideShowCount(String str, Context context) {
        SharedPreferences a = m22663a(context);
        return a.getInt("pay_pwd_guide_" + str, 0);
    }

    public static void saveCanRequestPwd(Context context, String str, Boolean bool) {
        SharedPreferences.Editor edit = m22663a(context).edit();
        edit.putBoolean("pay_pwd_can_request_" + str, bool.booleanValue()).apply();
    }

    public static Boolean getCanRequestPwd(Context context, String str) {
        SharedPreferences a = m22663a(context);
        return Boolean.valueOf(a.getBoolean("pay_pwd_can_request_" + str, true));
    }

    public static String getLastCouponTime(Context context, String str) {
        return m22663a(context).getString(str, "");
    }

    public static void saveLastCouponTime(Context context, String str, String str2) {
        m22663a(context).edit().putString(str, str2).apply();
    }

    public static void saveHomeAmountStatus(Context context, String str, boolean z) {
        m22663a(context).edit().putBoolean(str, z).apply();
    }

    public static boolean getHomeAmountStatus(Context context, String str) {
        return m22663a(context).getBoolean(str, true);
    }

    public static void savePublicMessageId(Context context, String str, String str2) {
        m22663a(context).edit().putString(str, str2).apply();
    }

    public static String getPublicMessageId(Context context, String str) {
        return m22663a(context).getString(str, "");
    }

    public static String getDateFromSP(Context context, String str) {
        return m22663a(context).getString(str, "");
    }

    public static void setDate(Context context, String str) {
        m22663a(context).edit().putString(str, getFormatDate().toString()).apply();
    }

    public static CharSequence getFormatDate() {
        StringBuilder sb = new StringBuilder();
        sb.append(Calendar.getInstance().get(1));
        sb.append("-");
        sb.append(Calendar.getInstance().get(2) + 1);
        sb.append("-");
        sb.append(Calendar.getInstance().get(5));
        return sb;
    }

    public static void saveFreezeStatus(Context context, String str, int i) {
        m22663a(context).edit().putInt(str, i).apply();
    }

    public static int getFreezeStatus(Context context, String str) {
        return m22663a(context).getInt(str, 0);
    }

    public static int getHomeDialogCount(Context context, String str) {
        return m22663a(context).getInt(str, 0);
    }

    public static void setHomeDialogCount(Context context, String str, int i) {
        m22663a(context).edit().putInt(str, i).apply();
    }

    public static int getHomeAddCardGifCount(Context context, String str) {
        return m22663a(context).getInt(str, 0);
    }

    public static void setHomeAddCardGifCount(Context context, String str, int i) {
        m22663a(context).edit().putInt(str, i).apply();
    }

    public static void setHomeCardRedBot(Context context, String str, String str2) {
        m22663a(context).edit().putString(str, str2).apply();
    }

    public static String getHomeCardRedBot(Context context, String str) {
        return m22663a(context).getString(str, "");
    }

    public static Long getSkuKycDialogNextShowTime(Context context, String str) {
        SharedPreferences a = m22663a(context);
        return Long.valueOf(a.getLong("sku_kyc_dialog" + PayBaseParamUtil.getStringParam(context, "uid") + str, 0));
    }

    public static void setSkuKycDialogNextShowTime(Context context, String str, Long l) {
        SharedPreferences.Editor edit = m22663a(context).edit();
        edit.putLong("sku_kyc_dialog" + PayBaseParamUtil.getStringParam(context, "uid") + str, l.longValue()).apply();
    }

    public static Long getHomeKycDialogNextShowTime(Context context) {
        SharedPreferences a = m22663a(context);
        return Long.valueOf(a.getLong("home_kyc_dialog" + PayBaseParamUtil.getStringParam(context, "uid"), 0));
    }

    public static void setHomeKycDialogNextShowTime(Context context, Long l) {
        SharedPreferences.Editor edit = m22663a(context).edit();
        edit.putLong("home_kyc_dialog" + PayBaseParamUtil.getStringParam(context, "uid"), l.longValue()).apply();
    }

    public static boolean getIsShowSettingRedDot(Context context, int i) {
        SharedPreferences a = m22663a(context);
        return a.getBoolean("setting_red_dot" + PayBaseParamUtil.getStringParam(context, "uid") + i, false);
    }

    public static void setIsShowSettingRedDot(Context context, int i, boolean z) {
        SharedPreferences.Editor edit = m22663a(context).edit();
        edit.putBoolean("setting_red_dot" + PayBaseParamUtil.getStringParam(context, "uid") + i, z).apply();
    }

    /* renamed from: a */
    private static SharedPreferences m22663a(Context context) {
        return SystemUtils.getSharedPreferences(context, f32008a, 0);
    }
}
