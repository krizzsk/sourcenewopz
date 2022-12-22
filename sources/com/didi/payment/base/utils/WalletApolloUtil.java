package com.didi.payment.base.utils;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.google.firebase.analytics.FirebaseAnalytics;

public class WalletApolloUtil {
    public static final String TAG = "WalletApollo";

    public static boolean isBoletoUnpaidBillReminder() {
        return true;
    }

    public static boolean getStatus(String str) {
        return getStatus(str, false);
    }

    public static boolean getStatus(String str, boolean z) {
        try {
            IToggle toggle = Apollo.getToggle(str, z);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            PayLogUtils.m21016e(TAG, e.getMessage());
        }
        return z;
    }

    public static void addToTotalSample(String str) {
        try {
            Apollo.getToggle(str, false);
        } catch (Exception e) {
            PayLogUtils.m21016e(TAG, e.getMessage());
        }
    }

    public static <T> T getParam(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception e) {
            PayLogUtils.m21016e(TAG, e.getMessage());
            return t;
        }
    }

    public static <T> T getParamByStatus(String str, String str2, T t) {
        return getStatus(str) ? getParam(str, str2, t) : t;
    }

    public static boolean isTrackRequestMonitorEnable(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = (String) getParamByStatus("wallet_request_monitor_toggle", "host_list", "");
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        String[] split = str2.split(",");
        if (split.length > 0) {
            return str.equalsIgnoreCase(split[0]);
        }
        return false;
    }

    public static boolean isNewPayMethodListEnable() {
        return ((Integer) getParamByStatus("ibt_wallet_new_pay_method_list_toggle", FirebaseAnalytics.Param.GROUP_ID, 0)).intValue() != 0;
    }

    public static boolean isNewPaySelPage() {
        return ((Integer) getParamByStatus("ibt_wallet_new_pay_method_list_toggle_v2", "newstyle", 0)).intValue() != 0;
    }

    public static boolean isNewTopUpTitle() {
        return ((Integer) getParamByStatus("PaymentMethod_Topup_Button_wordingAB", "New_Wording", 0)).intValue() != 0;
    }

    public static boolean isBoletoScanOptEnable() {
        return ((Integer) getParamByStatus("ibt_wallet_boleto_scan_opt_toggle", FirebaseAnalytics.Param.GROUP_ID, 0)).intValue() != 0;
    }

    public static boolean getBoletoScanOptTimeoutFlag() {
        return ((Integer) getParamByStatus("ibt_wallet_boleto_scan_opt_toggle", "time_out_enable", 0)).intValue() == 1;
    }

    public static int getBoletoScanOptTimeoutDelay() {
        return ((Integer) getParam("ibt_wallet_boleto_scan_opt_toggle", "time_out_delay", 10)).intValue();
    }

    public static float getBoletoScanOptTimeoutRatio() {
        return ((Float) getParam("ibt_wallet_boleto_scan_opt_toggle", "time_out_ratio", Float.valueOf(0.5f))).floatValue();
    }

    public static int getBoletoScanOptTimeoutQuality() {
        return ((Integer) getParam("ibt_wallet_boleto_scan_opt_toggle", "time_out_quality", 50)).intValue();
    }

    public static int getBoletoScanOptFailedDelay() {
        return ((Integer) getParam("ibt_wallet_boleto_scan_opt_toggle", "failed_delay", 60)).intValue();
    }

    public static boolean getBoletoScanOptQRTipsFlag() {
        return ((Integer) getParamByStatus("ibt_wallet_boleto_scan_opt_toggle", "qr_tips_enable", 0)).intValue() == 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0026, code lost:
        if (((java.lang.Integer) getParamByStatus("cash_in_redesign", "newTopup", 0)).intValue() == 1) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if (((java.lang.Integer) getParamByStatus("cash_in_redesign_MX", "newTopup", 0)).intValue() == 1) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getTopUpIsNew() {
        /*
            com.didi.payment.base.exts.ApplicationContextProvider$Companion r0 = com.didi.payment.base.exts.ApplicationContextProvider.Companion
            android.content.Context r0 = r0.getContext()
            java.lang.String r0 = com.didi.payment.base.utils.WalletCommonParamsUtil.getTerminalId(r0)
            java.lang.String r1 = "5"
            boolean r1 = r0.equals(r1)
            java.lang.String r2 = "newTopup"
            r3 = 1
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            if (r1 == 0) goto L_0x002c
            java.lang.String r0 = "cash_in_redesign"
            java.lang.Object r0 = getParamByStatus(r0, r2, r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r0 != r3) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            r4 = r3
            goto L_0x0043
        L_0x002c:
            java.lang.String r1 = "7"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = "cash_in_redesign_MX"
            java.lang.Object r0 = getParamByStatus(r0, r2, r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r0 != r3) goto L_0x0029
            goto L_0x002a
        L_0x0043:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.utils.WalletApolloUtil.getTopUpIsNew():boolean");
    }

    public static boolean isBoletoPhotoInput() {
        return ((Integer) getParamByStatus("ibt_wallet_boleto_unpaidbill_reminder", FirebaseAnalytics.Param.GROUP_ID, 0)).intValue() == 1;
    }

    public static boolean isBoletoPhotoCrop() {
        return ((Integer) getParamByStatus("ibt_wallet_boleto_unpaidbill_reminder", "is_crop", 0)).intValue() == 1;
    }

    public static boolean isNewRandomVerification() {
        return ((Integer) getParamByStatus("ibt_wallet_random_balance_verify", FirebaseAnalytics.Param.GROUP_ID, 0)).intValue() == 1;
    }
}
