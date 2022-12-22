package com.didi.payment.utilities.base;

import android.text.TextUtils;
import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.wallet.global.omega.GlobalOmegaConstant;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import java.util.HashMap;

public class CsOmegaUtils {
    public static void trackHistoryBtnClicked(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", str);
        FinOmegaSDK.trackEvent("ibt_gp_didipay_lifebillrecord_ck", hashMap);
    }

    public static void trackConfirmBtnClicked(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("page", str);
        hashMap.put("boleto_recognize_success_from", str2);
        hashMap.put("boleto_code", str3);
        FinOmegaSDK.trackEvent("ibt_gp_didipay_lifebill_confirm_ck", hashMap);
    }

    public static void trackBoletoKycNotificationSw() {
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_kyc_notification_sw");
    }

    @Deprecated
    public static void clickKycUT(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sku_source_id", str);
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_kyc_notification_ck", hashMap);
    }

    public static void trackBoletoKycPendingSw() {
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_kyc_pending_sw");
    }

    public static void trackBoletoPhotoInputCk(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("has_photo_permission", Boolean.valueOf(z));
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_photo_input_ck", hashMap);
    }

    public static void trackBoletoHistoryButtonSw(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("unpaid_bill_number", Integer.valueOf(i));
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_history_button_sw", hashMap);
    }

    public static void trackBoletoHistoryButtonCk(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("unpaid_bill_number", Integer.valueOf(i));
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_history__button_ck", hashMap);
    }

    public static void trackBoletoAlbumGuideSw(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("has_photo_permission", Boolean.valueOf(z));
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_album_guide_sw", hashMap);
    }

    public static void trackBoletoAlbumGuideCk(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("has_photo_permission", Boolean.valueOf(z));
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_album_guide_ck", hashMap);
    }

    public static void trackBoletoNoPhotoPermissionSw() {
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_no_photo_permission_sw");
    }

    public static void trackBoletoChoosePhotoSw() {
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_choose_photo_sw");
    }

    public static void trackBoletoZoomClipCK() {
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_zoom_clip_ck");
    }

    public static void trackBoletoChoosePhotoCk() {
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_choose_photo_ck");
    }

    public static void trackBoletoPhotoInputFailSw() {
        FinOmegaSDK.trackEvent("ibt_didipay_pay_boleto_photo_input_fail_sw");
    }

    public static void trackBoletoPayExpiredSw(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("boleto_code", str);
        hashMap.put("boleto_recognize_success_from", str2);
        hashMap.put("biz_order_id", str3);
        FinOmegaSDK.trackEvent("ibt_gp_didipay_pay_boleto_expired_sw", hashMap);
    }

    public static void trackBoletoPayExpiredCk(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("boleto_code", str);
        hashMap.put("boleto_recognize_success_from", str2);
        hashMap.put("biz_order_id", str3);
        FinOmegaSDK.trackEvent("ibt_gp_didipay_pay_boleto_expired_ck", hashMap);
    }

    public static void trackBoletoPayExpiredExitCk(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("boleto_code", str);
        hashMap.put("boleto_recognize_success_from", str2);
        hashMap.put("biz_order_id", str3);
        FinOmegaSDK.trackEvent("ibt_gp_didipay_pay_boleto_expired_exit_ck", hashMap);
    }

    public static void trackRiskNoKycSw() {
        HashMap hashMap = new HashMap();
        hashMap.put("pub_page", GlobalOmegaConstant.SkuRiskLimit.PUB_PAGE_BOLETO_IMPORT_METHOD);
        hashMap.put("pub_target", "text");
        hashMap.put("pub_biz", "fintech");
        hashMap.put("product_line", 606);
        hashMap.put("text_theme", LoginOmegaUtil.NEED_VERIFY_EMAIL);
        hashMap.put("button_name", "text");
        hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
        FinOmegaSDK.trackEvent("ibt_fintech_passenger_text_ck", hashMap);
    }

    public static void trackRiskNoKycCk() {
        HashMap hashMap = new HashMap();
        hashMap.put("pub_page", GlobalOmegaConstant.SkuRiskLimit.PUB_PAGE_BOLETO_IMPORT_METHOD);
        hashMap.put("pub_target", "text");
        hashMap.put("pub_biz", "fintech");
        hashMap.put("product_line", 606);
        hashMap.put("text_theme", LoginOmegaUtil.NEED_VERIFY_EMAIL);
        hashMap.put("button_name", "text");
        hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
        FinOmegaSDK.trackEvent("ibt_fintech_passenger_text_sw", hashMap);
    }

    public static void trackBoletoCouponSw(boolean z, String str, boolean z2, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("g_bizId", "billpayment");
        hashMap.put(LogBase.KEY_UID, str);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(WalletExtraConstant.Key.PUB_PAGE_FROM, str3);
        }
        if (z) {
            hashMap.put("coupon_sw", "1");
        } else {
            hashMap.put("coupon_sw", "0");
        }
        if (z2) {
            hashMap.put("cashback_sw", "1");
        } else {
            hashMap.put("cashback_sw", "0");
        }
        hashMap.put("cashback_amount", str2);
        FinOmegaSDK.trackEvent("fin_billpayinfo_sw", hashMap);
    }

    public static void trackBoletoCouponCk(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        hashMap.put("g_bizId", "billpayment");
        hashMap.put("uid", str);
        FinOmegaSDK.trackEvent("fin_billpayinfo_viewmore_ck", hashMap);
    }
}
