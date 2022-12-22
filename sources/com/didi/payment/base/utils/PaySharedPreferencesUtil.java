package com.didi.payment.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class PaySharedPreferencesUtil {

    /* renamed from: a */
    private static SharedPreferences f30013a = null;

    /* renamed from: b */
    private static String f30014b = "payment";

    public static void putBoolean(Context context, String str, boolean z) {
        if (f30013a == null) {
            f30013a = SystemUtils.getSharedPreferences(context, f30014b, 0);
        }
        f30013a.edit().putBoolean(str, z).apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        if (f30013a == null) {
            f30013a = SystemUtils.getSharedPreferences(context, f30014b, 0);
        }
        return f30013a.getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        if (f30013a == null) {
            f30013a = SystemUtils.getSharedPreferences(context, f30014b, 0);
        }
        f30013a.edit().putString(str, str2).apply();
    }

    public static String getString(Context context, String str, String str2) {
        if (f30013a == null) {
            f30013a = SystemUtils.getSharedPreferences(context, f30014b, 0);
        }
        return f30013a.getString(str, str2);
    }

    public static void putInt(Context context, String str, int i) {
        if (f30013a == null) {
            f30013a = SystemUtils.getSharedPreferences(context, f30014b, 0);
        }
        f30013a.edit().putInt(str, i).apply();
    }

    public static int getInt(Context context, String str, int i) {
        if (f30013a == null) {
            f30013a = SystemUtils.getSharedPreferences(context, f30014b, 0);
        }
        return f30013a.getInt(str, i);
    }

    public static void remove(Context context, String str) {
        if (f30013a == null) {
            f30013a = SystemUtils.getSharedPreferences(context, f30014b, 0);
        }
        f30013a.edit().remove(str).apply();
    }

    public static boolean exist(Context context, String str) {
        if (f30013a == null) {
            f30013a = SystemUtils.getSharedPreferences(context, f30014b, 0);
        }
        return f30013a.contains(str);
    }

    public static boolean isWalletNewFeatureDialogShown(Context context) {
        return getBoolean(context, "sp_wallet_sidebar_new_feature_dialog_shown", false);
    }

    public static void setWalletNewFeatureDialogShown(Context context, boolean z) {
        putBoolean(context, "sp_wallet_sidebar_new_feature_dialog_shown", z);
    }

    public static boolean needWalletMainListSettingPopupShown(Context context) {
        return getInt(context, "sp_wallet_sidebar_setting_popup_shown_times", 0) < 2;
    }

    public static void updateWalletMainListSettingPopupShownTimes(Context context) {
        putInt(context, "sp_wallet_sidebar_setting_popup_shown_times", getInt(context, "sp_wallet_sidebar_setting_popup_shown_times", 0) + 1);
    }

    public static boolean isBoletoScanGuideShown(Context context) {
        return getBoolean(context, "sp_consume_boleto_scan_guide", false);
    }

    public static void setBoletoScanGuideShown(Context context, boolean z) {
        putBoolean(context, "sp_consume_boleto_scan_guide", z);
    }

    public static boolean isBoletoPhotoInputGuideShown(Context context) {
        return getBoolean(context, "sp_consume_boleto_photo_guide", false);
    }

    public static void setBoletoPhotoInputGuideShown(Context context, boolean z) {
        putBoolean(context, "sp_consume_boleto_photo_guide", z);
    }

    public static boolean isPixPhotoInputGuideShown(Context context) {
        return getBoolean(context, "sp_pix_photo_guide", false);
    }

    public static void setPixPhotoInputGuideShown(Context context, boolean z) {
        putBoolean(context, "sp_pix_photo_guide", z);
    }

    public static boolean isNewPayChannelGuideH5Shown(Context context, int i) {
        return getBoolean(context, "sp_new_pay_channel_h5_guide_" + i, false);
    }

    public static void setNewPayChannelGuideH5Shown(Context context, int i, boolean z) {
        putBoolean(context, "sp_new_pay_channel_h5_guide_" + i, z);
    }

    public static boolean isFirstEnteringTopUpPage(Context context, String str) {
        return getBoolean(context, str + "sp_first_entering_top_up_page", true);
    }

    public static void setFirstEnteringTopUpPage(Context context, String str, boolean z) {
        putBoolean(context, str + "sp_first_entering_top_up_page", z);
    }

    public static boolean isAgreeTopUpProtocol(Context context, String str) {
        return getBoolean(context, str + "sp_agree_top_up_protocol", false);
    }

    public static void setAgreeTopUpProtocol(Context context, String str, boolean z) {
        putBoolean(context, str + "sp_agree_top_up_protocol", z);
    }
}
