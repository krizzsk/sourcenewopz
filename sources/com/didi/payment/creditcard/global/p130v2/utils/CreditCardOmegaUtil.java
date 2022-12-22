package com.didi.payment.creditcard.global.p130v2.utils;

import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/creditcard/global/v2/utils/CreditCardOmegaUtil;", "", "()V", "Companion", "creditcard_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.creditcard.global.v2.utils.CreditCardOmegaUtil */
/* compiled from: CreditCardOmegaUtil.kt */
public final class CreditCardOmegaUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f30565a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f30566b;

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J5\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0004¢\u0006\u0002\u0010\u001eJ-\u0010\u001f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010 J$\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00042\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010$H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006%"}, mo175978d2 = {"Lcom/didi/payment/creditcard/global/v2/utils/CreditCardOmegaUtil$Companion;", "", "()V", "marketingId", "", "getMarketingId", "()Ljava/lang/String;", "setMarketingId", "(Ljava/lang/String;)V", "resourceId", "getResourceId", "setResourceId", "bindCardGiveUpCancelCkTrace", "", "info", "bindCardGiveUpOkCkTrace", "bindCardGiveUpShowTrace", "bindCardInputTrace", "inputType", "isHasStr", "", "bindCardPasUpShowTrace", "bindCardSuccessCkTrace", "bindCardSuccessShowTrace", "errorCkTrace", "errorCode", "", "button_1", "button_2", "ck", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "errorShowTrace", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "trackCreditCardOmega", "eventId", "map", "Ljava/util/HashMap;", "creditcard_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.creditcard.global.v2.utils.CreditCardOmegaUtil$Companion */
    /* compiled from: CreditCardOmegaUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getMarketingId() {
            return CreditCardOmegaUtil.f30565a;
        }

        public final void setMarketingId(String str) {
            CreditCardOmegaUtil.f30565a = str;
        }

        public final String getResourceId() {
            return CreditCardOmegaUtil.f30566b;
        }

        public final void setResourceId(String str) {
            CreditCardOmegaUtil.f30566b = str;
        }

        public static /* synthetic */ void errorShowTrace$default(Companion companion, Integer num, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            companion.errorShowTrace(num, str, str2);
        }

        public final void errorShowTrace(Integer num, String str, String str2) {
            HashMap hashMap = new HashMap();
            if (num != null) {
                hashMap.put("error_code", String.valueOf(num.intValue()));
            }
            if (str != null) {
                hashMap.put("button_1", str);
            }
            CharSequence charSequence = str2;
            if (!(charSequence == null || charSequence.length() == 0)) {
                hashMap.put("button_2", str2);
            }
            trackCreditCardOmega("fin_addcard_error_sw", hashMap);
        }

        public static /* synthetic */ void errorCkTrace$default(Companion companion, Integer num, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            companion.errorCkTrace(num, str, str2, str3);
        }

        public final void errorCkTrace(Integer num, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str3, "ck");
            HashMap hashMap = new HashMap();
            if (num != null) {
                hashMap.put("error_code", String.valueOf(num.intValue()));
            }
            if (str != null) {
                hashMap.put("button_1", str);
            }
            CharSequence charSequence = str2;
            if (!(charSequence == null || charSequence.length() == 0)) {
                hashMap.put("button_2", str2);
            }
            hashMap.put("button_ck", str3);
            trackCreditCardOmega("fin_addcard_error_ck", hashMap);
        }

        public final void bindCardInputTrace(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "inputType");
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            map.put("inputbox", str);
            map.put("type", z ? "1" : "0");
            trackCreditCardOmega("fin_addcard_input_ck", hashMap);
        }

        public final void bindCardPasUpShowTrace(String str) {
            Intrinsics.checkNotNullParameter(str, "info");
            HashMap hashMap = new HashMap();
            hashMap.put("marketing_information", str);
            trackCreditCardOmega(GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_ADDCARD_SW, hashMap);
        }

        public final void bindCardGiveUpShowTrace(String str) {
            Intrinsics.checkNotNullParameter(str, "info");
            HashMap hashMap = new HashMap();
            hashMap.put("marketing_information", str);
            trackCreditCardOmega("fin_binding_card_giveup_sw", hashMap);
        }

        public final void bindCardGiveUpOkCkTrace(String str) {
            Intrinsics.checkNotNullParameter(str, "info");
            HashMap hashMap = new HashMap();
            hashMap.put("marketing_information", str);
            trackCreditCardOmega("fin_binding_card_giveup_yes_ck", hashMap);
        }

        public final void bindCardGiveUpCancelCkTrace(String str) {
            Intrinsics.checkNotNullParameter(str, "info");
            HashMap hashMap = new HashMap();
            hashMap.put("marketing_information", str);
            trackCreditCardOmega("fin_binding_card_give_up_no_ck", hashMap);
        }

        public final void bindCardSuccessShowTrace(String str) {
            Intrinsics.checkNotNullParameter(str, "info");
            HashMap hashMap = new HashMap();
            hashMap.put("marketing_information", str);
            trackCreditCardOmega("fin_addcard_succeed_sw", hashMap);
        }

        public final void bindCardSuccessCkTrace(String str) {
            Intrinsics.checkNotNullParameter(str, "info");
            HashMap hashMap = new HashMap();
            hashMap.put("marketing_information", str);
            trackCreditCardOmega("fin_addcard_succeed_ck", hashMap);
        }

        private final void trackCreditCardOmega(String str, HashMap<String, Object> hashMap) {
            String marketingId = getMarketingId();
            boolean z = true;
            if (marketingId != null) {
                if (marketingId.length() > 0) {
                    hashMap.put("activity_id", marketingId);
                }
            }
            String resourceId = getResourceId();
            if (resourceId != null) {
                if (resourceId.length() <= 0) {
                    z = false;
                }
                if (z) {
                    hashMap.put("resource_id", resourceId);
                }
            }
            FinOmegaSDK.trackEvent(str, hashMap);
        }
    }
}
