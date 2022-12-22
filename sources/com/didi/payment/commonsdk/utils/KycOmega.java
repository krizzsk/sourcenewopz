package com.didi.payment.commonsdk.utils;

import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/KycOmega;", "", "()V", "Companion", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KycOmega.kt */
public final class KycOmega {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\fJ\u0017\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\tJ\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0016¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/KycOmega$Companion;", "", "()V", "fin_jumiofacecheck_result_sw", "", "code", "", "fin_tech_wallet_http_req_lite_en", "msg", "", "path", "getCommonParams", "", "ibt_didipay_verification_sw", "isAccess", "", "(Ljava/lang/Boolean;)V", "trackButtonEvent", "eventId", "type", "trackEvent", "params", "", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: KycOmega.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> getCommonParams() {
            Map<String, Object> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
            linkedHashMap.put("pub_subbiz", "payment");
            linkedHashMap.put("pub_channel", "");
            linkedHashMap.put("pub_from_res", "");
            linkedHashMap.put("pub_from_page", OmegaComParams.Companion.getPUB_FROM_PAGE());
            linkedHashMap.put("pub_page", OmegaComParams.Companion.getPUB_PAGE());
            linkedHashMap.put("source", OmegaComParams.Companion.getSOURCE());
            String stringParam = PayBaseParamUtil.getStringParam(ApplicationContextProvider.Companion.getContext(), "uid");
            Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(\n        …ayParam.UID\n            )");
            linkedHashMap.put(LogBase.KEY_UID, stringParam);
            linkedHashMap.put("full_kyc_type", Integer.valueOf(OmegaComParams.Companion.getPUB_FROM_PRIMARY()));
            String stringParam2 = PayBaseParamUtil.getStringParam(ApplicationContextProvider.Companion.getContext(), "terminal_id");
            Intrinsics.checkNotNullExpressionValue(stringParam2, "getStringParam(\n        …TERMINAL_ID\n            )");
            linkedHashMap.put("terminal", stringParam2);
            return linkedHashMap;
        }

        public final void trackEvent(String str, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            Intrinsics.checkNotNullParameter(map, "params");
            Map<String, Object> commonParams = getCommonParams();
            for (Map.Entry next : map.entrySet()) {
                commonParams.put(next.getKey(), next.getValue());
            }
            FinOmegaSDK.trackEvent(str, commonParams);
        }

        public final void trackEvent(String str) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            FinOmegaSDK.trackEvent(str, getCommonParams());
        }

        public final void trackButtonEvent(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "eventId");
            Map<String, Object> commonParams = getCommonParams();
            commonParams.put("button_name", Integer.valueOf(i));
            FinOmegaSDK.trackEvent(str, commonParams);
        }

        public static /* synthetic */ void ibt_didipay_verification_sw$default(Companion companion, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = false;
            }
            companion.ibt_didipay_verification_sw(bool);
        }

        public final void ibt_didipay_verification_sw(Boolean bool) {
            Map<String, Object> commonParams = getCommonParams();
            commonParams.put("is_access", Integer.valueOf(Intrinsics.areEqual((Object) bool, (Object) true) ? 1 : 0));
            FinOmegaSDK.trackEvent("ibt_didipay_verification_sw", commonParams);
        }

        public final void fin_jumiofacecheck_result_sw(int i) {
            OmegaComParams.Companion.setPubPage(OmegaComParams.JUMIO_FACECHECK);
            Map<String, Object> commonParams = getCommonParams();
            commonParams.put("face_result", Integer.valueOf(i));
            FinOmegaSDK.trackEvent("fin_jumiofacecheck_result_sw", commonParams);
        }

        public final void fin_tech_wallet_http_req_lite_en(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "msg");
            Intrinsics.checkNotNullParameter(str2, "path");
            Map<String, Object> commonParams = getCommonParams();
            commonParams.put("errorno", Integer.valueOf(i));
            commonParams.put("errormsg", str);
            commonParams.put("url", str2);
            FinOmegaSDK.trackEvent("fin_tech_wallet_http_req_lite_en", commonParams);
        }
    }
}
