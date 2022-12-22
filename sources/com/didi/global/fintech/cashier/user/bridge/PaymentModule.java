package com.didi.global.fintech.cashier.user.bridge;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.didi.dimina.container.secondparty.trace.inner.LogBase;
import com.didi.global.fintech.cashier.base.module.GlobalCashierModuleType;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierResultListener;
import com.didi.global.fintech.cashier.user.facade.ICashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0007J\u001a\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u0007R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/bridge/PaymentModule;", "Lcom/didi/onehybrid/BaseHybridModule;", "hybridableContainer", "Lcom/didi/onehybrid/container/HybridableContainer;", "(Lcom/didi/onehybrid/container/HybridableContainer;)V", "activity", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "goToMarket", "", "param", "Lorg/json/JSONObject;", "callbackFunction", "Lcom/didi/onehybrid/jsbridge/CallbackFunction;", "universalPay", "jsonObject", "jsCallback", "version", "Companion", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaymentModule.kt */
public final class PaymentModule extends BaseHybridModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ModuleName = "payment";
    public static final int RESULT_CANCEL = 3;
    public static final int RESULT_CLOSE = 2;
    public static final int RESULT_NET_ERROR = 4;
    public static final int RESULT_SUCCESS = 1;

    /* renamed from: a */
    private final Activity f22019a;

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/bridge/PaymentModule$Companion;", "", "()V", "ModuleName", "", "RESULT_CANCEL", "", "RESULT_CLOSE", "RESULT_NET_ERROR", "RESULT_SUCCESS", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PaymentModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        Intrinsics.checkNotNullParameter(hybridableContainer, "hybridableContainer");
        this.f22019a = hybridableContainer.getActivity();
    }

    @JsInterface({"universalPay"})
    public final void universalPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkNotNullParameter(callbackFunction, "jsCallback");
        String str = null;
        String optString = jSONObject == null ? null : jSONObject.optString("out_trade_id");
        if (jSONObject != null) {
            str = jSONObject.optString("product_id");
        }
        CashierFacade instance = CashierFacade.Companion.getInstance();
        Activity activity = this.f22019a;
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        instance.launchForCashierResult(activity, CashierParam.Companion.insByOutTradeId(optString), (CashierResultListener) new PaymentModule$universalPay$1(optString, str, callbackFunction));
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Const.PayParams.BIZ_CONTENT_UNDERLINE, "");
        linkedHashMap.put("out_trade_id", optString);
        linkedHashMap.put("params_error", "0");
        linkedHashMap.put("product_id", str);
        linkedHashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        linkedHashMap.put("pub_subbiz", "payment");
        linkedHashMap.put(LogBase.KEY_UID, CashierFacade.Companion.getInstance().getInitConfig().getUid());
        OmegaSDKAdapter.trackEvent("ibgfintech_didipay_bridge_universalpay_en", (Map<String, Object>) linkedHashMap);
    }

    @JsInterface({"getSDKVersion"})
    public final void version(JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkNotNullParameter(callbackFunction, "jsCallback");
        String paramByModuleSync = CashierFacade.Companion.getInstance().getParamByModuleSync(GlobalCashierModuleType.Core, GlobalCashierCoreModule.META_DATA, ICashierFacade.DefaultImpls.getParamByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.Core, GlobalCashierCoreModule.CASHIER_SDK_VERSION_NAME, (String) null, 4, (Object) null));
        if (paramByModuleSync != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("version", paramByModuleSync);
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    @JsInterface({"goToMarket"})
    public final void goToMarket(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str;
        JSONObject jSONObject2 = jSONObject;
        Map linkedHashMap = new LinkedHashMap();
        String str2 = null;
        if (jSONObject2 == null) {
            str = null;
        } else {
            str = jSONObject2.optString("url");
        }
        linkedHashMap.put("params_error", "0");
        linkedHashMap.put("url", str);
        linkedHashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        linkedHashMap.put("pub_subbiz", "payment");
        linkedHashMap.put(LogBase.KEY_UID, CashierFacade.Companion.getInstance().getInitConfig().getUid());
        OmegaSDKAdapter.trackEvent("ibgfintech_didipay_bridge_gotomarket_en", (Map<String, Object>) linkedHashMap);
        String paramByModuleSync$default = ICashierFacade.DefaultImpls.getParamByModuleSync$default(CashierFacade.Companion.getInstance(), GlobalCashierModuleType.Core, GlobalCashierCoreModule.PACKAGE_NAME, (String) null, 4, (Object) null);
        if (paramByModuleSync$default != null) {
            try {
                if (jSONObject2 != null) {
                    str2 = jSONObject2.optString("url");
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                intent.addFlags(268435456);
                this.f22019a.startActivity(intent);
                linkedHashMap.put("success", "1");
                OmegaSDKAdapter.trackEvent("ibgfintech_didipay_bridge_gotomarket_ex", (Map<String, Object>) linkedHashMap);
            } catch (RuntimeException unused) {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(Intrinsics.stringPlus("market://details?id=", paramByModuleSync$default)));
                intent2.addFlags(268435456);
                this.f22019a.startActivity(intent2);
                linkedHashMap.put("success", "1");
                OmegaSDKAdapter.trackEvent("ibgfintech_didipay_bridge_gotomarket_ex", (Map<String, Object>) linkedHashMap);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                linkedHashMap.put("success", "0");
                OmegaSDKAdapter.trackEvent("ibgfintech_didipay_bridge_gotomarket_ex", (Map<String, Object>) linkedHashMap);
            }
        }
    }
}
