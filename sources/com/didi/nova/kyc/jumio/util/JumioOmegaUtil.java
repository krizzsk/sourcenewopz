package com.didi.nova.kyc.jumio.util;

import com.didi.nova.kyc.jumio.module.JumioParams;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/util/JumioOmegaUtil;", "", "()V", "Companion", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JumioOmegaUtil.kt */
public final class JumioOmegaUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010$\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\nJ\u0016\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0006J\"\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00062\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010'¨\u0006("}, mo175978d2 = {"Lcom/didi/nova/kyc/jumio/util/JumioOmegaUtil$Companion;", "", "()V", "fin_fullkycverification_quit_sw", "", "code", "", "msg", "fin_jumioconfirm_button_ck", "button_name", "", "fin_jumioconfirm_popup_sw", "fin_jumioconfirm_popupbutton_ck", "fin_jumioconfirm_sw", "fin_jumiodocument_button_ck", "fin_jumiodocument_popup_sw", "fin_jumiodocument_popupbutton_ck", "fin_jumiodocument_sw", "fin_jumiodocument_tip_sw", "fin_jumiodocument_tipbutton_ck", "fin_jumiodocumentreject_button_ck", "fin_jumiodocumentreject_popup_ck", "fin_jumiodocumentreject_popup_sw", "fin_jumiodocumentreject_sw", "fin_jumiodocumentretry_button_ck", "fin_jumiodocumentretry_popup_sw", "fin_jumiodocumentretry_popupbutton_ck", "fin_jumiodocumentretry_sw", "fin_jumioerror_button_ck", "fin_jumioerror_popup_ck", "fin_jumioerror_popup_sw", "fin_jumioerror_sw", "fin_jumiofacecheck_result_sw", "trackBackAndDialog", "type", "trackButtonEvent", "eventId", "trackEvent", "params", "", "kyc-jumios_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: JumioOmegaUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void trackEvent(String str, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            Intrinsics.checkNotNullParameter(map, "params");
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            for (Map.Entry next : map.entrySet()) {
                commonParams.put(next.getKey(), next.getValue());
            }
            FinOmegaSDK.trackEvent(str, commonParams);
        }

        public final void trackEvent(String str) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            KycOmega.Companion.getCommonParams();
            FinOmegaSDK.trackEvent(str, KycOmega.Companion.getCommonParams());
        }

        public final void trackButtonEvent(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("button_name", Integer.valueOf(i));
            FinOmegaSDK.trackEvent(str, commonParams);
        }

        public final void fin_jumiofacecheck_result_sw(int i) {
            OmegaComParams.Companion.setPubPage(OmegaComParams.JUMIO_FACECHECK);
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("face_result", Integer.valueOf(i));
            FinOmegaSDK.trackEvent("fin_jumiofacecheck_result_sw", commonParams);
        }

        public final void fin_jumiodocument_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumiodocument_sw", commonParams);
        }

        public final void fin_jumiodocument_button_ck(int i) {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            commonParams.put("button_name", Integer.valueOf(i));
            FinOmegaSDK.trackEvent("fin_jumiodocument_button_ck", commonParams);
        }

        public final void fin_jumiodocument_tip_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumiodocument_tip_sw", commonParams);
        }

        public final void fin_jumiodocument_tipbutton_ck() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("button_name", 5);
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumiodocument_tipbutton_ck", commonParams);
        }

        public final void fin_jumiodocument_popup_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumiodocument_popup_sw", commonParams);
        }

        public final void fin_jumiodocument_popupbutton_ck(int i) {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("button_name", Integer.valueOf(i));
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumiodocument_popupbutton_ck", commonParams);
        }

        public final void fin_jumioconfirm_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumioconfirm_sw", commonParams);
        }

        public final void fin_jumioconfirm_button_ck(int i) {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("button_name", Integer.valueOf(i));
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumioconfirm_button_ck", commonParams);
        }

        public final void fin_jumioconfirm_popup_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumioconfirm_popup_sw", commonParams);
        }

        public final void fin_jumioconfirm_popupbutton_ck(int i) {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("button_name", Integer.valueOf(i));
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumioconfirm_popupbutton_ck", commonParams);
        }

        public final void fin_jumiodocumentreject_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("reject_reason", JumioParams.INSTANCE.getREJECT_REASON());
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumiodocumentreject_sw", commonParams);
        }

        public final void fin_jumiodocumentreject_button_ck(int i) {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("button_name", Integer.valueOf(i));
            commonParams.put("reject_reason", JumioParams.INSTANCE.getREJECT_REASON());
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumiodocumentreject_button_ck", commonParams);
        }

        public final void fin_jumiodocumentreject_popup_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("reject_reason", JumioParams.INSTANCE.getREJECT_REASON());
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumiodocumentreject_popup_sw", commonParams);
        }

        public final void fin_jumiodocumentreject_popup_ck(int i) {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("button_name", Integer.valueOf(i));
            commonParams.put("reject_reason", JumioParams.INSTANCE.getREJECT_REASON());
            commonParams.put("type", Integer.valueOf(JumioParams.INSTANCE.getAUTO_TYPE()));
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("flash_status", Integer.valueOf(JumioParams.INSTANCE.getFLASH_STATUS()));
            FinOmegaSDK.trackEvent("fin_jumiodocumentreject_popup_ck", commonParams);
        }

        public final void fin_jumiodocumentretry_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("retry_reason", JumioParams.INSTANCE.getRETRY_REASON());
            FinOmegaSDK.trackEvent("fin_jumiodocumentretry_sw", commonParams);
        }

        public final void fin_jumiodocumentretry_button_ck(int i) {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("retry_reason", JumioParams.INSTANCE.getRETRY_REASON());
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("button_name", Integer.valueOf(i));
            FinOmegaSDK.trackEvent("fin_jumiodocumentretry_button_ck", commonParams);
        }

        public final void fin_jumiodocumentretry_popup_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("retry_reason", JumioParams.INSTANCE.getRETRY_REASON());
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            FinOmegaSDK.trackEvent("fin_jumiodocumentretry_popup_sw", commonParams);
        }

        public final void fin_jumiodocumentretry_popupbutton_ck(int i) {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("retry_reason", JumioParams.INSTANCE.getRETRY_REASON());
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            commonParams.put("button_name", Integer.valueOf(i));
            FinOmegaSDK.trackEvent("fin_jumiodocumentretry_popupbutton_ck", commonParams);
        }

        public final void fin_jumioerror_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("error_code", JumioParams.INSTANCE.getERROR_CODE());
            commonParams.put("document_side", Integer.valueOf(JumioParams.INSTANCE.getDOCUMENT_SIDE()));
            FinOmegaSDK.trackEvent("fin_jumioerror_sw", commonParams);
        }

        public final void fin_jumioerror_button_ck(int i) {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("error_code", JumioParams.INSTANCE.getERROR_CODE());
            commonParams.put("button_name", Integer.valueOf(i));
            FinOmegaSDK.trackEvent("fin_jumioerror_button_ck", commonParams);
        }

        public final void fin_jumioerror_popup_sw() {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("error_code", JumioParams.INSTANCE.getERROR_CODE());
            FinOmegaSDK.trackEvent("fin_jumioerror_popup_sw", commonParams);
        }

        public final void fin_jumioerror_popup_ck(int i) {
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("error_code", JumioParams.INSTANCE.getERROR_CODE());
            commonParams.put("button_name", Integer.valueOf(i));
            FinOmegaSDK.trackEvent("fin_jumioerror_popup_ck", commonParams);
        }

        public final void fin_fullkycverification_quit_sw(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "code");
            Intrinsics.checkNotNullParameter(str2, "msg");
            Map<String, Object> commonParams = KycOmega.Companion.getCommonParams();
            commonParams.put("pub_page", OmegaComParams.FULL_KYC_VER);
            commonParams.put("error_code", str);
            commonParams.put("message", str2);
            FinOmegaSDK.trackEvent("fin_fullkycverification_quit_sw", commonParams);
        }

        public final void trackBackAndDialog(int i) {
            String pub_page = OmegaComParams.Companion.getPUB_PAGE();
            switch (pub_page.hashCode()) {
                case -1764043073:
                    if (pub_page.equals(OmegaComParams.FACE_GUIDE)) {
                        if (i == 1) {
                            trackButtonEvent("fin_faceguide_button_ck", 5);
                            return;
                        } else if (i == 2) {
                            trackEvent("fin_faceguide_popup_sw");
                            return;
                        } else if (i == 3) {
                            KycOmega.Companion.trackButtonEvent("fin_faceguide_popupbutton_ck", 1);
                            return;
                        } else if (i == 4) {
                            KycOmega.Companion.trackButtonEvent("fin_faceguide_popupbutton_ck", 2);
                            return;
                        } else if (i == 5) {
                            KycOmega.Companion.trackButtonEvent("fin_faceguide_popupbutton_ck", 5);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case -1708344864:
                    if (pub_page.equals(OmegaComParams.JUMIO_ERROR)) {
                        if (i == 1) {
                            fin_jumioerror_button_ck(2);
                            return;
                        } else if (i == 2) {
                            fin_jumioerror_popup_sw();
                            return;
                        } else if (i == 3) {
                            fin_jumioerror_popup_ck(1);
                            return;
                        } else if (i == 4) {
                            fin_jumioerror_popup_ck(2);
                            return;
                        } else if (i == 5) {
                            fin_jumioerror_popup_ck(5);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 1388198040:
                    if (pub_page.equals(OmegaComParams.JUMIO_CONFIRM)) {
                        if (i == 1) {
                            fin_jumioconfirm_button_ck(5);
                            return;
                        } else if (i == 2) {
                            fin_jumioconfirm_popup_sw();
                            return;
                        } else if (i == 3) {
                            fin_jumioconfirm_popupbutton_ck(1);
                            return;
                        } else if (i == 4) {
                            fin_jumioconfirm_popupbutton_ck(2);
                            return;
                        } else if (i == 5) {
                            fin_jumioconfirm_popupbutton_ck(5);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 1526315587:
                    if (pub_page.equals(OmegaComParams.JUMIO_DOCUMENT)) {
                        if (i == 1) {
                            fin_jumiodocument_button_ck(JumioParams.INSTANCE.getBUTTON_BACK());
                            return;
                        } else if (i == 2) {
                            fin_jumiodocument_popup_sw();
                            return;
                        } else if (i == 3) {
                            fin_jumiodocument_popupbutton_ck(1);
                            return;
                        } else if (i == 4) {
                            fin_jumiodocument_popupbutton_ck(2);
                            return;
                        } else if (i == 5) {
                            fin_jumiodocument_popupbutton_ck(5);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 1654439075:
                    if (pub_page.equals(OmegaComParams.JUMIO_FACECHECK) && i == 1) {
                        KycOmega.Companion.trackButtonEvent("fin_jumiofacecheck_button_ck", 5);
                        return;
                    }
                    return;
                case 1674653602:
                    if (pub_page.equals(OmegaComParams.JUMIO_DOCUMENT_REJECT)) {
                        if (i == 1) {
                            fin_jumiodocumentreject_button_ck(5);
                            return;
                        } else if (i == 2) {
                            fin_jumiodocumentreject_popup_sw();
                            return;
                        } else if (i == 3) {
                            fin_jumiodocumentreject_popup_ck(1);
                            return;
                        } else if (i == 4) {
                            fin_jumiodocumentreject_popup_ck(2);
                            return;
                        } else if (i == 5) {
                            fin_jumiodocumentreject_popup_ck(5);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 1993693765:
                    if (pub_page.equals(OmegaComParams.JUMIO_DOCUMENT_RETRY)) {
                        if (i == 1) {
                            fin_jumiodocumentretry_button_ck(5);
                            return;
                        } else if (i == 2) {
                            fin_jumiodocumentretry_popup_sw();
                            return;
                        } else if (i == 3) {
                            fin_jumiodocumentretry_popupbutton_ck(1);
                            return;
                        } else if (i == 4) {
                            fin_jumiodocumentretry_popupbutton_ck(2);
                            return;
                        } else if (i == 5) {
                            fin_jumiodocumentretry_popupbutton_ck(5);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
