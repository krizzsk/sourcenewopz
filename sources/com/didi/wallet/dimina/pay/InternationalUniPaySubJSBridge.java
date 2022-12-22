package com.didi.wallet.dimina.pay;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.DMServiceSubBridgeModule;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.util.LogUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.soda.customer.app.constant.Const;
import com.didi.unifiedPay.component.model.PayParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/wallet/dimina/pay/InternationalUniPaySubJSBridge;", "Lcom/didi/dimina/container/messager/jsmodule/BaseServiceModule;", "mina", "Lcom/didi/dimina/container/DMMina;", "(Lcom/didi/dimina/container/DMMina;)V", "mActivity", "Landroid/app/Activity;", "goNoTripPay", "", "args", "Lorg/json/JSONObject;", "callback", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "goTripPay", "requestPayment", "Companion", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DMServiceSubBridgeModule(level = 0)
/* compiled from: InternationalUniPaySubJSBridge.kt */
public final class InternationalUniPaySubJSBridge extends BaseServiceModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "InternationalUniPaySubJSBridge";
    private final Activity mActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InternationalUniPaySubJSBridge(DMMina dMMina) {
        super(dMMina);
        Intrinsics.checkNotNullParameter(dMMina, "mina");
        LogUtil.m13412i(TAG, "init 初始化方法");
        FragmentActivity activity = dMMina.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "mina.activity");
        this.mActivity = activity;
    }

    @JsInterface({"requestPayment"})
    public final void requestPayment(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.iRelease(TAG, Intrinsics.stringPlus("国际化 requestPayment() ", jSONObject));
        UiThreadHandler.post(new Runnable(jSONObject, this, callbackFunction) {
            public final /* synthetic */ JSONObject f$0;
            public final /* synthetic */ InternationalUniPaySubJSBridge f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                InternationalUniPaySubJSBridge.m47040requestPayment$lambda1(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: requestPayment$lambda-1  reason: not valid java name */
    public static final void m47040requestPayment$lambda1(JSONObject jSONObject, InternationalUniPaySubJSBridge internationalUniPaySubJSBridge, CallbackFunction callbackFunction) {
        Intrinsics.checkNotNullParameter(internationalUniPaySubJSBridge, "this$0");
        if (jSONObject != null) {
            if (jSONObject.optBoolean("isTrip", false)) {
                internationalUniPaySubJSBridge.goTripPay(jSONObject, callbackFunction);
            } else {
                internationalUniPaySubJSBridge.goNoTripPay(jSONObject, callbackFunction);
            }
        }
    }

    private final void goNoTripPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
        InternationalIntermediaryActivity.Companion.setBridgeCallBack(callbackFunction);
        String optString = jSONObject.optString(Const.PayParams.OUT_TRADE_ID);
        PayParam payParam = new PayParam();
        CharSequence charSequence = optString;
        if (!(charSequence == null || charSequence.length() == 0)) {
            LogUtil.iRelease(TAG, Intrinsics.stringPlus("非出行业务的支付 outTradeId=", optString));
            payParam.outTradeId = optString;
        } else {
            payParam.sign = jSONObject.optString("sign");
            payParam.signType = jSONObject.optString(Const.PayParams.SIGN_TYPE);
            payParam.bizContent = jSONObject.optString(Const.PayParams.BIZ_CONTENT);
        }
        InternationalIntermediaryActivity.Companion.setParam(payParam);
        InternationalIntermediaryActivity.Companion.setFastPay(jSONObject.optBoolean("isFastPay", false));
        this.mActivity.startActivity(new Intent(this.mActivity, InternationalIntermediaryActivity.class));
    }

    private final void goTripPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.eRelease(TAG, "国际化支付, 不应该存在 出行业务支付场景");
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/wallet/dimina/pay/InternationalUniPaySubJSBridge$Companion;", "", "()V", "TAG", "", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InternationalUniPaySubJSBridge.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
