package com.didi.payment.wallet.global.omega;

import android.content.Context;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.wallet.global.omega.GlobalOmegaConstant;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import java.util.HashMap;
import java.util.Map;

public class GlobalOmegaUtils {
    public static void trackPayMethodSettingPageSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent("global_pas_payment_sw", hashMap);
    }

    public static void trackPayMethodSettingPageCloseCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent("global_pas_payment_methods_close_ck", hashMap);
    }

    public static void trackPayMethodSettingPageCashCK(Context context, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        hashMap.put("source", 3);
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("card_count", Integer.valueOf(i2));
        FinOmegaSDK.trackEvent("global_pas_payment_cash_ck", hashMap);
    }

    public static void trackPayMethodSettingPagePosCK(Context context, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        hashMap.put("source", 3);
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("card_count", Integer.valueOf(i2));
        FinOmegaSDK.trackEvent("global_pas_payment_pos_ck", hashMap);
    }

    public static void trackPayMethodSettingPageCreditCK(Context context, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        hashMap.put("source", 3);
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("card_count", Integer.valueOf(i2));
        FinOmegaSDK.trackEvent("global_pas_payment_credit_ck", hashMap);
    }

    public static void trackPayMethodSettingPagePaypalCK(Context context, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        hashMap.put("source", 3);
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("card_count", Integer.valueOf(i2));
        FinOmegaSDK.trackEvent("global_pas_payment_paypal_ck", hashMap);
    }

    public static void trackPayMethodSettingPagePaypal2CK(Context context, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        hashMap.put("source", 3);
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("card_count", Integer.valueOf(i2));
        FinOmegaSDK.trackEvent("gp_payment_paypalv2_ck", hashMap);
    }

    public static void trackPayMethodSettingPagePayPayCK(Context context, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        hashMap.put("source", 3);
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("card_count", Integer.valueOf(i2));
        FinOmegaSDK.trackEvent("global_pas_payment_paypay_ck", hashMap);
    }

    public static void trackPayMethodSettingPageDiscountsCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent("global_pas_payment_methods_discounts_ck", hashMap);
    }

    public static void trackPayMethodSettingPageBalanceSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_WALLET_BALANCE_SW, hashMap);
    }

    public static void trackPayMethodSettingPageBalanceCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        hashMap.put("source", 3);
        FinOmegaSDK.trackEvent("gp_wallet_balance_ck", hashMap);
    }

    public static void trackPayMethodSettingPageBalanceQaCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_WALLET_BALANCEQA_CK, hashMap);
    }

    public static void trackPayMethodSettingPageBalanceTopupCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent("gp_balance_topup_ck", hashMap);
    }

    public static void trackPayMethodSettingPageBalanceMbpCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_BALANCE_MBP_CK, hashMap);
    }

    public static void trackPayMethodSettingPagebalancePhotoCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_BALANCE_PHOTO_CK, hashMap);
    }

    public static void trackPayMethodSettingPageMethodQaCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_WALLET_METHODQA_CK, hashMap);
    }

    public static void trackPayMethodSettingPagebalanceAddPmtCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_WALLET_ADDPMT_CK, hashMap);
    }

    public static void trackPayMethodSettingPagebalancePopupSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_WALLET_POPUP_SW, hashMap);
    }

    public static void trackPayMethodSettingPagebalancePopupCloseCK(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_WALLET_POPUPCLOSE_CK, hashMap);
    }

    public static void trackPayMethodSettingPageRechargePopupSW(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_RECHARGE_POPUP_SW, hashMap);
    }

    public static void trackPayMethodSettingPageRechargeBtnCk(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_RECHARGE_BTN_CK, hashMap);
    }

    public static void trackPayMethodSettingPageRechargeCancelBtnCk(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.PayMethodSettingPage.EventId.GP_RECHARGECANCEL_BTN_CK, hashMap);
    }

    public static void trackTopUpOnlineClick(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpPage.EventId.GLOBAL_TOPUP_ONLINE_CK, hashMap);
    }

    public static void trackTopUpOfflineClick(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpPage.EventId.GLOBAL_TOPUP_OFFLINE_CK, hashMap);
    }

    public static void trackTopUpDetailShow(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpPage.EventId.GLOBAL_TOPUP_DETAIL_SW, hashMap);
    }

    public static void trackTopUpConfirmClick(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id", m22521a(context));
        hashMap.put("city_id", m22522b(context));
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpPage.EventId.GLOBAL_TOPUP_COFIRM_CK, hashMap);
    }

    /* renamed from: a */
    private static String m22521a(Context context) {
        return context == null ? "" : PayBaseParamUtil.getStringParam(context, "uid");
    }

    /* renamed from: b */
    private static String m22522b(Context context) {
        return context == null ? "" : PayBaseParamUtil.getStringParam(context, "trip_city_id");
    }

    public static void trackTopupChannelPageSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpChannelPage.EventId.GLOBAL_TOPUP_99PAY_CHARGE_VIEW_SW);
    }

    public static void trackTopupCardPaymentCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpChannelPage.EventId.GLOBAL_TOPUP_CARD_PAYMENT_CK);
    }

    public static void trackTopupCardPaymentPageSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpCardPaymentPage.EventId.GLOBAL_TOPUP_CARD_PAYMENT_SW);
    }

    public static void trackTopupCardPaymentConfirmCK(Map<String, Object> map) {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpCardPaymentPage.EventId.GLOBAL_TOPUP_CARD_PAYMENT_CONFIRM_CK, map);
    }

    public static void trackTopupChannelBoletoCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpChannelPage.EventId.GLOBAL_TOPUP_99PAY_CHARGE_BOLETO_CK);
    }

    public static void trackTopupChannelBankTransferCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.TopUpChannelPage.EventId.GLOBAL_TOPUP_99PAY_CHARGE_BANK_CK);
    }

    public static void trackBankTransferPageSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BankTransferPage.EventId.GLOBAL_99PAY_CHARGE_BANK_INFORMATION_SW);
    }

    public static void trackBoletoAddressPatchZipcodePageSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoAddressPatchZipcodePage.EventId.GLOBAL_99PAY_CHARGE_BOLETO1_SW);
    }

    public static void trackBoletoAddressPatchZipcodeButtonCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoAddressPatchZipcodePage.EventId.GLOBAL_99PAY_CHARGE_BOLETO1_CONFIRM_CK);
    }

    public static void trackBoletoAddressPatchDetailSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoAddressPatchDetailPage.EventId.GLOBAL_99PAY_CHARGE_BOLETO2_SW);
    }

    public static void trackBoletoAddressPatchDetailBtnCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoAddressPatchDetailPage.EventId.GLOBAL_99PAY_CHARGE_BOLETO2_CONFIRM_CK);
    }

    public static void trackBoletoCashinPageSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoTopUpAmountPage.EventId.GLOBAL_99PAY_CHARGE_AMOUNT_VIEW);
    }

    public static void trackBoletoCashinHistoryPageCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoTopUpAmountPage.EventId.GLOBAL_99PAY_CHARGE_AMOUNT_BOLETO_CK);
    }

    public static void trackBoletoCashinBtnCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoTopUpAmountPage.EventId.GLOBAL_99PAY_CHARGE_AMOUNT_CONFIRM_CK);
    }

    public static void trackBillViewSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.ViewBoletoPage.EventId.GLOBAL_99PAY_BILL_VIEW_SW);
    }

    public static void trackBillCopyCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.ViewBoletoPage.EventId.GLOBAL_99PAY_BILL_COPY_CK);
    }

    public static void trackSendEmailCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.ViewBoletoPage.EventId.GLOBAL_99PAY_BILL_SENDEMAIL_CK);
    }

    public static void trackBillDetailCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.ViewBoletoPage.EventId.GLOBAL_99PAY_BILL_DETAIL_CK);
    }

    public static void trackBillSendEmailBtnCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoSendEmailDialog.EventId.GLOBAL_99PAY_SENDEMAIL_CONFIRM_CK);
    }

    public static void trackBillsViewSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.GLOBAL_99PAY_BILLS_VIEW_SW);
    }

    public static void trackBoletoCashinHistoryBillCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.GLOBAL_99PAY_BILLS_BILL_CK);
    }

    public static void trackBankBalanceViewSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.AccountBalancePage.EventId.GLOBAL_99PAY_ACCOUNT_BALANCE_VIEW_SW);
    }

    public static void trackBoletoHistoryUnpaidSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_HISTORY_UNPAID_SW);
    }

    public static void trackBoletoHistoryExitCK(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("page_when_exiting", i == 0 ? "unpaid" : "completed");
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_HISTORY_EXIT_CK, hashMap);
    }

    public static void trackBoletoHistoryUnpaidOrderPayCK(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("biz_order_id", str);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_HISTORY_UNPAID_ORDER_PAY_CK, hashMap);
    }

    public static void trackBoletoHistoryUnpaidOrderCancelCK(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("biz_order_id", str);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_HISTORY_UNPAID_ORDER_CANCEL_CK, hashMap);
    }

    public static void trackBoletoHistoryCompletedCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_HISTORY_COMPLETED_CK);
    }

    public static void trackBoletoHistoryCompletedSW() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_HISTORY_COMPLETED_SW);
    }

    public static void trackBoletoHistoryUnpaidCK() {
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_HISTORY_UNPAID_CK);
    }

    public static void trackBoletoHistoryCancelOrderSW(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("biz_order_id", str);
        hashMap.put("cancellation_notification_type", str2);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_HISTORY_CANCEL_ORDER_SW, hashMap);
    }

    public static void trackBoletoHistoryCancelOrderCK(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("biz_order_id", str);
        hashMap.put("cancellation_notification_type", str2);
        hashMap.put("cancel_order_reason", str3);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_HISTORY_CANCEL_ORDER_CK, hashMap);
    }

    public static void trackBoletoHistoryCancelOrderExitCK(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("biz_order_id", str);
        hashMap.put("cancellation_notification_type", str2);
        FinOmegaSDK.trackEvent(GlobalOmegaConstant.BoletoHistoryPage.EventId.BOLETO_HISTORY_CANCEL_ORDER_EXIT_CK, hashMap);
    }

    public static void trackBoletoHistoryKycDialog(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("biz_order_id", str2);
        hashMap.put("no_kyc_popup_from", "boleto_history");
        FinOmegaSDK.trackEvent(str, hashMap);
    }

    public static void trackSkuLimitInputExceedSw(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("pub_page", "input_amount");
        hashMap.put("pub_target", "text");
        hashMap.put("pub_biz", "fintech");
        hashMap.put("product_line", Integer.valueOf(i));
        hashMap.put("text_theme", "limit_rules");
        hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
        FinOmegaSDK.trackEvent("ibt_fintech_passenger_text_sw", hashMap);
    }

    public static void trackSkuLimitInputExceedCk(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("pub_page", "input_amount");
        hashMap.put("pub_target", "text");
        hashMap.put("pub_biz", "fintech");
        hashMap.put("product_line", Integer.valueOf(i));
        hashMap.put("text_theme", "limit_rules");
        hashMap.put("button_name", "text");
        hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
        FinOmegaSDK.trackEvent("ibt_fintech_passenger_text_ck", hashMap);
    }

    public static void trackTopUpSW() {
        FinOmegaSDK.trackEvent("ibt_topup_sw");
    }

    public static void trackTopUpBtnCK(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("button_name", str);
        FinOmegaSDK.trackEvent("ibt_topup_btn_ck", hashMap);
    }
}
