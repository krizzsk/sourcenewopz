package com.didiglobal.pay.paysecure.prepaidcard;

import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.omega.OmegaUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/TrackerManager;", "", "()V", "Companion", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TrackerManager.kt */
public final class TrackerManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J;\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0007J\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010!\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0005¨\u0006\""}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/TrackerManager$Companion;", "", "()V", "getBasePrepaid", "", "", "trackActiveCard", "", "trackActiveError", "trackActiveSuccess", "trackForgetPwd", "trackInputCardPwd", "trackInputCardPwdClick", "name", "trackInputCardPwdDone", "trackInputCardPwdError", "errMsg", "trackInputCardPwdLimit", "trackInputCardPwdLimitClick", "trackLast4NoError", "trackNewPwdError", "trackOldPwdLimit", "trackOldPwdLimitClick", "trackOldPwdVerifyError", "trackPrepaidLast4No", "eventId", "step", "", "type", "num", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "trackSettingPwd", "trackStopActive", "trackStopActiveClick", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: TrackerManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map<String, Object> getBasePrepaid() {
            Object obj;
            Map<String, Object> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
            linkedHashMap.put("pub_subbiz", "payment");
            Map<String, Object> extraInfo = PaySecure.INSTANCE.getConfig().getNetParamListener().getExtraInfo();
            if (extraInfo == null || (obj = extraInfo.get("uid")) == null) {
                obj = "";
            }
            linkedHashMap.put(LogBase.KEY_UID, obj);
            return linkedHashMap;
        }

        public final void trackPrepaidLast4No(String str, Integer num, Integer num2, String str2, String str3) {
            Intrinsics.checkParameterIsNotNull(str, "eventId");
            new OmegaUtil(str).addAll(getBasePrepaid()).add("activate_steps", num).add("prepaycardtype", num2).add("card_num", str2).add("errmsg", str3).send();
        }

        public final void trackLast4NoError(String str) {
            new OmegaUtil("fin_prepaidcard_activate1_wrong_sw").addAll(getBasePrepaid()).add("errmsg", str).send();
        }

        public final void trackSettingPwd() {
            new OmegaUtil("fin_prepaidcard_activate1_num_ty").addAll(getBasePrepaid()).send();
        }

        public final void trackActiveCard() {
            new OmegaUtil("fin_prepaidcard_activate2_pin_ck").addAll(getBasePrepaid()).send();
        }

        public final void trackActiveError() {
            new OmegaUtil("fin_prepaidcard_activate_err").addAll(getBasePrepaid()).send();
        }

        public final void trackActiveSuccess() {
            new OmegaUtil("fin_prepaidcard_activate_suc_toast_sw").addAll(getBasePrepaid()).send();
        }

        public final void trackStopActive() {
            new OmegaUtil("fin_prepaidcard_activate_stop_popup_sw").addAll(getBasePrepaid()).send();
        }

        public final void trackStopActiveClick(String str) {
            new OmegaUtil("fin_prepaidcard_activate_stop_popup_ck").addAll(getBasePrepaid()).add("button_name", str).send();
        }

        public final void trackForgetPwd() {
            new OmegaUtil("fin_prepaidcard_forget_pin_ck").addAll(getBasePrepaid()).send();
        }

        public final void trackOldPwdVerifyError() {
            new OmegaUtil("fin_prepaidcard_pin_error_times_sw").addAll(getBasePrepaid()).send();
        }

        public final void trackOldPwdLimit() {
            new OmegaUtil("fin_prepaidcard_pin_error_maxtimes_sw").addAll(getBasePrepaid()).send();
        }

        public final void trackOldPwdLimitClick() {
            new OmegaUtil("fin_prepaidcard_pin_error_maxtimes_ck").addAll(getBasePrepaid()).send();
        }

        public final void trackNewPwdError() {
            new OmegaUtil("fin_prepaidcard_pin_again_error_sw").addAll(getBasePrepaid()).send();
        }

        public final void trackInputCardPwd() {
            new OmegaUtil("fin_prepaidcard_enter_cardpin_sw").addAll(getBasePrepaid()).send();
        }

        public final void trackInputCardPwdDone() {
            new OmegaUtil("fin_prepaidcard_enter_cardpin_ty").addAll(getBasePrepaid()).send();
        }

        public final void trackInputCardPwdClick(String str) {
            new OmegaUtil("fin_prepaidcard_enter_cardpin_ck").addAll(getBasePrepaid()).add("button_name", str).send();
        }

        public final void trackInputCardPwdError(String str) {
            new OmegaUtil("fin_prepaidcard_wrong_cardpin_sw").addAll(getBasePrepaid()).add("errmsg", str).send();
        }

        public final void trackInputCardPwdLimit() {
            new OmegaUtil("fin_prepaidcard_wrong_maxpin_sw").addAll(getBasePrepaid()).send();
        }

        public final void trackInputCardPwdLimitClick() {
            new OmegaUtil("fin_prepaidcard_wrong_maxpin_ck").addAll(getBasePrepaid()).send();
        }
    }
}
