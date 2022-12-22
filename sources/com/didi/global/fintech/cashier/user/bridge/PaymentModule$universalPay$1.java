package com.didi.global.fintech.cashier.user.bridge;

import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierResultListener;
import com.didi.global.fintech.cashier.user.model.CashierResult;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/global/fintech/cashier/user/bridge/PaymentModule$universalPay$1", "Lcom/didi/global/fintech/cashier/user/facade/CashierResultListener;", "onCashierResult", "", "cashierResult", "Lcom/didi/global/fintech/cashier/user/model/CashierResult;", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaymentModule.kt */
public final class PaymentModule$universalPay$1 implements CashierResultListener {
    final /* synthetic */ CallbackFunction $jsCallback;
    final /* synthetic */ String $out_trade_id;
    final /* synthetic */ String $product_id;

    PaymentModule$universalPay$1(String str, String str2, CallbackFunction callbackFunction) {
        this.$out_trade_id = str;
        this.$product_id = str2;
        this.$jsCallback = callbackFunction;
    }

    public void onCashierResult(CashierResult cashierResult) {
        Intrinsics.checkNotNullParameter(cashierResult, "cashierResult");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Const.PayParams.BIZ_CONTENT_UNDERLINE, "");
        linkedHashMap.put("out_trade_id", this.$out_trade_id);
        linkedHashMap.put("product_id", this.$product_id);
        linkedHashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        linkedHashMap.put("pub_subbiz", "payment");
        linkedHashMap.put(LogBase.KEY_UID, CashierFacade.Companion.getInstance().getInitConfig().getUid());
        JSONObject jSONObject = new JSONObject();
        if (cashierResult.getStatus() == 1) {
            jSONObject.put("status", 1);
            linkedHashMap.put("status", 1);
        } else {
            jSONObject.put("status", 3);
            linkedHashMap.put("status", 3);
        }
        jSONObject.put("return_url", cashierResult.getExtra("return_url"));
        linkedHashMap.put("return_url", cashierResult.getExtra("return_url"));
        this.$jsCallback.onCallBack(jSONObject);
        OmegaSDKAdapter.trackEvent("ibgfintech_didipay_bridge_universalpay_ex", (Map<String, Object>) linkedHashMap);
    }
}
