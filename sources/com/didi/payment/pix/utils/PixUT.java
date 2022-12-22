package com.didi.payment.pix.utils;

import com.didi.payment.base.tracker.FinOmegaSDK;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!J\u001e\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006J\u001e\u0010&\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u001e\u0010'\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u001e\u0010(\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J&\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006J\u001e\u0010.\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0006J&\u00100\u001a\u00020\u00042\u0006\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006J&\u00101\u001a\u00020\u00042\u0006\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006J\u0006\u00102\u001a\u00020\u0004J\u000e\u00103\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!J\u000e\u00104\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!J\u000e\u00105\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!J\u000e\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0006J\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020\u0004J\u0006\u0010:\u001a\u00020\u0004J\u000e\u0010;\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010>\u001a\u00020\u0004J\u0006\u0010?\u001a\u00020\u0004J\u0006\u0010@\u001a\u00020\u0004J\u0006\u0010A\u001a\u00020\u0004J\u0006\u0010B\u001a\u00020\u0004J\u0006\u0010C\u001a\u00020\u0004J\u0016\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020!¨\u0006G"}, mo175978d2 = {"Lcom/didi/payment/pix/utils/PixUT;", "", "()V", "trackCodePageShow", "", "keyType", "", "trackCreateCPFKeyPageBtnCk", "trackCreateCPFKeyPageShow", "trackCreateEmailKeyPageBtnCk", "trackCreateEmailKeyPageMigrateBtnCk", "trackCreateEmailKeyPageMigrateFail", "errno", "trackCreateEmailKeyPageShow", "trackCreateEmailKeyPageUsedOn99Show", "trackCreateEmailKeyPageUsedOnOtherShow", "trackCreateMobileKeyPageBtnCk", "trackCreateMobileKeyPageMigrateBtnCk", "trackCreateMobileKeyPageMigrateFail", "trackCreateMobileKeyPageShow", "trackCreateMobileKeyPageUsedOn99Show", "trackCreateMobileKeyPageUsedOnOtherShow", "trackCreateRandomKeyPageBtnCk", "trackCreateRandomKeyPageShow", "trackFullKycAddressFormCk", "inboundSource", "trackFullKycAddressFormSm", "trackFullKycVerificationBackCk", "trackFullKycVerificationCk", "trackFullKycVerificationPageShow", "trackFullKycVerificationSkipCk", "trackKeyDetailPageDefaultBtnCk", "keyVal", "", "trackKeyDetailPageShow", "isDefault", "", "keyStatus", "trackKeyDetailPageUnbindBtnCk", "trackKeyDetailPageUnbindDlgConfirmBtnCk", "trackKeyDetailPageUnbindDlgShow", "trackKeyListPageAddBtnCk", "defaultKey", "bindKeyNum", "unbindKeyNum", "portKeyNum", "trackKeyListPageItemCk", "status", "trackKeyListPagePortBtnCk", "trackKeyListPageShow", "trackKeyManageCk", "trackMigrateOutDetailPageConfirmBtnCk", "trackMigrateOutDetailPageShow", "trackMigrateOutListPageItemCk", "trackMigrateOutListPageShow", "count", "trackPixChooseIdPageCNHCk", "trackPixChooseIdPageRGCk", "trackPixChooseIdPageShow", "trackPixChooseKeyPageCPFUsed", "trackPixChooseKeyPageCPFUsedOnOtherShow", "trackPixChooseKeyPageItemCk", "trackPixChooseKeyPageMigrateBtnCk", "trackPixChooseKeyPageShow", "trackPixGuidePageBtnCk", "trackPixGuidePageShow", "trackPixSignUp99PageBtnCk", "trackPixSignUp99PageShow", "trackRegisterPixPage", "pixKey", "pixKeyType", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixUT.kt */
public final class PixUT {
    public static final PixUT INSTANCE = new PixUT();

    private PixUT() {
    }

    public final void trackKeyListPageShow(String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "defaultKey");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("default_key", str);
        linkedHashMap.put("current_bind_key_number", Integer.valueOf(i));
        linkedHashMap.put("current_unbind_key_number", Integer.valueOf(i2));
        linkedHashMap.put("current_port_out_pending_key_number", Integer.valueOf(i3));
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_mypix_manage_key_sw", "ibt_didipay_mypix_manage_key_sw", linkedHashMap);
    }

    public final void trackKeyListPageAddBtnCk(String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "defaultKey");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("default_key", str);
        linkedHashMap.put("current_bind_key_number", Integer.valueOf(i));
        linkedHashMap.put("current_unbind_key_number", Integer.valueOf(i2));
        linkedHashMap.put("current_port_out_pending_key_number", Integer.valueOf(i3));
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_mypix_manage_key_register_ck", "ibt_didipay_mypix_manage_key_register_ck", linkedHashMap);
    }

    public final void trackKeyListPagePortBtnCk(String str, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "defaultKey");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("default_key", str);
        linkedHashMap.put("current_bind_key_number", Integer.valueOf(i));
        linkedHashMap.put("current_unbind_key_number", Integer.valueOf(i2));
        linkedHashMap.put("current_port_out_pending_key_number", Integer.valueOf(i3));
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_mypix_manage_key_port_out_ck", "ibt_didipay_mypix_manage_key_port_out_ck", linkedHashMap);
    }

    public final void trackKeyListPageItemCk(String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key", str);
        linkedHashMap.put("is_default_key", Boolean.valueOf(z));
        linkedHashMap.put("key_status", Integer.valueOf(i));
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_mypix_manage_key_existing_key_ck", "ibt_didipay_mypix_manage_key_existing_key_ck", linkedHashMap);
    }

    public final void trackKeyManageCk() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_mypix_manage_key_ck", "ibt_didipay_mypix_manage_key_ck");
    }

    public final void trackKeyDetailPageShow(String str, boolean z, int i) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, "keyVal");
        if (i == 1) {
            str2 = "ibt_didipay_mypix_manage_pending_key_detail_sw";
            str3 = "ibt_drv_wallet_mypix_manage_pending_key_detail_sw";
        } else {
            str2 = "ibt_didipay_mypix_manage_key_detail_sw";
            str3 = "ibt_drv_wallet_mypix_manage_key_detail_sw";
        }
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key", str);
        linkedHashMap.put("is_default_key", Boolean.valueOf(z));
        FinOmegaSDK.trackEvent(str2, linkedHashMap);
        TrackUtils.Companion.trackEvent(str3, str2, linkedHashMap);
    }

    public final void trackKeyDetailPageDefaultBtnCk(String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key", str);
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_mypix_manage_key_detail_default_ck", "ibt_didipay_mypix_manage_key_detail_default_ck", linkedHashMap);
    }

    public final void trackKeyDetailPageUnbindBtnCk(String str, int i, boolean z) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, "keyVal");
        if (i == 1) {
            str2 = "ibt_didipay_mypix_manage_pending_key_detail_delete_ck";
            str3 = "ibt_drv_wallet_mypix_manage_pending_key_detail_delete_ck";
        } else {
            str2 = "ibt_didipay_mypix_manage_key_detail_untie_ck";
            str3 = "ibt_drv_wallet_mypix_manage_key_detail_untie_ck";
        }
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key", str);
        linkedHashMap.put("is_default_key", Boolean.valueOf(z));
        TrackUtils.Companion.trackEvent(str3, str2, linkedHashMap);
    }

    public final void trackKeyDetailPageUnbindDlgShow(String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key", str);
        linkedHashMap.put("is_default_key", Boolean.valueOf(z));
        TrackUtils.Companion.trackEvent(i == 1 ? "ibt_drv_wallet_mypix_manage_pending_key_detail_delete_sw" : "ibt_drv_wallet_mypix_manage_key_detail_untie_sw", "ibt_didipay_mypix_manage_key_detail_untie_sw", linkedHashMap);
    }

    public final void trackKeyDetailPageUnbindDlgConfirmBtnCk(String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key", str);
        linkedHashMap.put("is_default_key", Boolean.valueOf(z));
        TrackUtils.Companion.trackEvent(i == 1 ? "ibt_drv_wallet_mypix_manage_pending_key_detail_delete_confirm_ck" : "ibt_drv_wallet_mypix_manage_key_detail_untie_confirm_ck", "ibt_didipay_mypix_manage_key_detail_untie_confirm_ck", linkedHashMap);
    }

    public final void trackMigrateOutListPageShow(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("current_port_out_pending_key_number", Integer.valueOf(i));
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_mypix_manage_port_out_key_sw", "ibt_didipay_mypix_manage_port_out_key_sw", linkedHashMap);
    }

    public final void trackMigrateOutListPageItemCk(String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key", str);
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_mypix_manage_port_out_key_ck", "ibt_didipay_mypix_manage_port_out_key_ck", linkedHashMap);
    }

    public final void trackMigrateOutDetailPageShow(String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key", str);
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_mypix_manage_port_out_key_detail_sw", "ibt_didipay_mypix_manage_port_out_key_detail_sw", linkedHashMap);
    }

    public final void trackMigrateOutDetailPageConfirmBtnCk(String str) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key", str);
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_mypix_manage_port_out_key_detail_confirm_ck", "ibt_didipay_mypix_manage_port_out_key_detail_confirm_ck", linkedHashMap);
    }

    public final void trackPixGuidePageShow() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_pix_guide_sw", "ibt_didipay_pix_guide_sw");
    }

    public final void trackFullKycVerificationPageShow() {
        FinOmegaSDK.trackEvent("ibt_didipay_kyc_identity_verification_sw", new LinkedHashMap());
    }

    public final void trackFullKycVerificationCk() {
        FinOmegaSDK.trackEvent("ibt_didipay_kyc_identity_verification_ck", new LinkedHashMap());
    }

    public final void trackFullKycVerificationSkipCk() {
        FinOmegaSDK.trackEvent("ibt_didipay_kyc_identity_verification_skip_ck", new LinkedHashMap());
    }

    public final void trackFullKycVerificationBackCk() {
        FinOmegaSDK.trackEvent("ibt_didipay_kyc_identity_verification_back_ck", new LinkedHashMap());
    }

    public final void trackFullKycAddressFormSm(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("inbound_source", Integer.valueOf(i));
        FinOmegaSDK.trackEvent("ibt_didipay_kyc_address_form_sw", linkedHashMap);
    }

    public final void trackFullKycAddressFormCk(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("inbound_source", Integer.valueOf(i));
        FinOmegaSDK.trackEvent("ibt_didipay_kyc_address_form_ck", linkedHashMap);
    }

    public final void trackPixGuidePageBtnCk() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_pix_guide_ck", "ibt_didipay_pix_guide_ck");
    }

    public final void trackPixSignUp99PageShow() {
        FinOmegaSDK.trackEvent("ibt_didipay_kyc_sw", new LinkedHashMap());
    }

    public final void trackPixSignUp99PageBtnCk() {
        FinOmegaSDK.trackEvent("ibt_didipay_kyc_ck", new LinkedHashMap());
    }

    public final void trackPixChooseIdPageShow() {
        FinOmegaSDK.trackEvent("ibt_didipay_verification_sw", new LinkedHashMap());
    }

    public final void trackPixChooseIdPageCNHCk() {
        FinOmegaSDK.trackEvent("ibt_didipay_verification_cnh_ck", new LinkedHashMap());
    }

    public final void trackPixChooseIdPageRGCk() {
        FinOmegaSDK.trackEvent("ibt_didipay_verification_rg_ck", new LinkedHashMap());
    }

    public final void trackPixChooseKeyPageShow() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_sw", "ibt_didipay_registration_sw");
    }

    public final void trackPixChooseKeyPageItemCk(int i) {
        String str;
        String str2;
        String str3;
        String str4 = "";
        if (i == 1) {
            str3 = "ibt_didipay_registration_cpf_ck";
            str2 = "ibt_drv_wallet_registration_cpf_ck";
        } else if (i == 2) {
            str3 = "ibt_didipay_registration_email_ck";
            str2 = "ibt_drv_wallet_registration_email_ck";
        } else if (i == 3) {
            str3 = "ibt_didipay_registration_mobile_ck";
            str2 = "ibt_drv_wallet_registration_mobile_ck";
        } else if (i != 4) {
            str = str4;
            TrackUtils.Companion.trackEvent(str4, str);
        } else {
            str3 = "ibt_didipay_registration_random_key_ck";
            str2 = "ibt_drv_wallet_registration_random_key_ck";
        }
        String str5 = str3;
        str4 = str2;
        str = str5;
        TrackUtils.Companion.trackEvent(str4, str);
    }

    public final void trackPixChooseKeyPageCPFUsed(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errno", Integer.valueOf(i));
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_cpf_taken_99pay_sw", "ibt_didipay_registration_cpf_taken_99pay_sw", linkedHashMap);
    }

    public final void trackPixChooseKeyPageCPFUsedOnOtherShow() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_cpf_taken_others_sw", "ibt_didipay_registration_cpf_taken_others_sw");
    }

    public final void trackPixChooseKeyPageMigrateBtnCk() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_cpf_taken_others_port_in_ck", "ibt_didipay_registration_cpf_taken_others_port_in_ck");
    }

    public final void trackCreateCPFKeyPageShow() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_cpf_sw", "ibt_didipay_registration_cpf_sw");
    }

    public final void trackCreateCPFKeyPageBtnCk() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_cpf_confirm_ck", "ibt_didipay_registration_cpf_confirm_ck");
    }

    public final void trackCreateRandomKeyPageShow() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_random_key_sw", "ibt_didipay_registration_random_key_sw");
    }

    public final void trackCreateRandomKeyPageBtnCk() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_random_key_confirm_ck", "ibt_didipay_registration_random_key_confirm_ck");
    }

    public final void trackCreateMobileKeyPageShow() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_mobile_sw", "ibt_didipay_registration_mobile_sw");
    }

    public final void trackCreateMobileKeyPageBtnCk() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_mobile_confirm_ck", "ibt_didipay_registration_mobile_confirm_ck");
    }

    public final void trackCreateMobileKeyPageUsedOn99Show(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errno", Integer.valueOf(i));
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_mobile_taken_99pay_sw", "ibt_didipay_registration_mobile_taken_99pay_sw", linkedHashMap);
    }

    public final void trackCreateEmailKeyPageUsedOn99Show(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errno", Integer.valueOf(i));
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_email_taken_99pay_sw", "ibt_didipay_registration_email_taken_99pay_sw", linkedHashMap);
    }

    public final void trackCreateMobileKeyPageUsedOnOtherShow() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_mobile_taken_others_sw", "ibt_didipay_registration_mobile_taken_others_sw");
    }

    public final void trackCreateMobileKeyPageMigrateBtnCk() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_mobile_taken_others_port_in_ck", "ibt_didipay_registration_mobile_taken_others_port_in_ck");
    }

    public final void trackCreateMobileKeyPageMigrateFail(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errno", Integer.valueOf(i));
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_mobile_taken_others_port_in_fail_sw", "ibt_didipay_registration_mobile_taken_others_port_in_fail_sw", linkedHashMap);
    }

    public final void trackCreateEmailKeyPageMigrateFail(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("errno", Integer.valueOf(i));
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_email_taken_others_port_in_fail_sw", "ibt_didipay_registration_email_taken_others_port_in_fail_sw", linkedHashMap);
    }

    public final void trackCreateEmailKeyPageShow() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_email_sw", "ibt_didipay_registration_email_sw");
    }

    public final void trackCreateEmailKeyPageBtnCk() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_email_confirm_ck", "ibt_didipay_registration_email_confirm_ck");
    }

    public final void trackCreateEmailKeyPageUsedOnOtherShow() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_email_taken_others_sw", "ibt_didipay_registration_email_taken_others_sw");
    }

    public final void trackCreateEmailKeyPageMigrateBtnCk() {
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_email_taken_others_port_in_ck", "ibt_didipay_registration_email_taken_others_port_in_ck");
    }

    public final void trackCodePageShow(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key_registration_type", i == 2 ? "email" : "mobile");
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_verification_code_sw", "ibt_didipay_registration_verification_code_sw", linkedHashMap);
    }

    public final void trackRegisterPixPage(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "pixKey");
        Intrinsics.checkNotNullParameter(str2, "pixKeyType");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key", str);
        linkedHashMap.put("pix_key_type", str2);
        TrackUtils.Companion.trackEvent("ibt_drv_wallet_registration_result_success_no_reward_sw", "", linkedHashMap);
    }
}
