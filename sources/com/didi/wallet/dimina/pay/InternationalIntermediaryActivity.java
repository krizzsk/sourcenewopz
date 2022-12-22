package com.didi.wallet.dimina.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.facade.FastPayFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.component.model.PayParam;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/wallet/dimina/pay/InternationalIntermediaryActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "gotoOldUniPayPage", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "useNewCashier", "", "Companion", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: InternationalIntermediaryActivity.kt */
public final class InternationalIntermediaryActivity extends FragmentActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_GLOBAL_PAY = 100;
    public static final String TAG = "InternationalIntermediaryActivity";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f45172a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static CallbackFunction f45173b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static PayParam f45174c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        LogUtil.iRelease(TAG, "onCreate()");
        if (m32451b()) {
            String str = null;
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            PayParam payParam = f45174c;
            cashierParam.setSign(payParam == null ? null : payParam.sign);
            PayParam payParam2 = f45174c;
            cashierParam.setSignType(payParam2 == null ? null : payParam2.signType);
            PayParam payParam3 = f45174c;
            cashierParam.setBizContent(payParam3 == null ? null : payParam3.bizContent);
            PayParam payParam4 = f45174c;
            if (payParam4 != null) {
                str = payParam4.outTradeId;
            }
            cashierParam.setOutTradeId(str);
            if (f45172a) {
                FastPayFacade.Companion.getInstance().pay((Activity) this, 100, cashierParam);
            } else {
                CashierFacade.Companion.getInstance().launchForResult((Activity) this, 100, cashierParam, (CashierLaunchListener) new InternationalIntermediaryActivity$onCreate$1(this));
            }
        } else {
            m32450a();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LogUtil.iRelease(TAG, "onActivityResult()");
        if (i == 100 && i2 == -1 && intent != null) {
            int intExtra = intent.getIntExtra("code", 3);
            CallBackUtil.onSuccess((Map<String, ? extends Object>) MapsKt.mapOf(TuplesKt.m42317to("code", Integer.valueOf((intExtra == 1 || intExtra == 2) ? intExtra : 4))), f45173b);
            LogUtil.iRelease(TAG, Intrinsics.stringPlus("onActivityResult() 支付结果 ", Integer.valueOf(intExtra)));
        }
        f45173b = null;
        f45174c = null;
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32450a() {
        Intent intent = new Intent(this, InternationalPaymentActivity.class);
        intent.putExtra("uni_pay_param", GsonUtils.toJson(f45174c));
        startActivityForResult(intent, 100);
    }

    /* renamed from: b */
    private final boolean m32451b() {
        Integer num;
        IToggle toggle = Apollo.getToggle("global_didipay_new_sdk");
        if (toggle == null || !toggle.allow() || !toggle.allow() || (num = (Integer) toggle.getExperiment().getParam("new", 1)) == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/wallet/dimina/pay/InternationalIntermediaryActivity$Companion;", "", "()V", "REQUEST_GLOBAL_PAY", "", "TAG", "", "bridgeCallBack", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "getBridgeCallBack", "()Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "setBridgeCallBack", "(Lcom/didi/dimina/container/bridge/base/CallbackFunction;)V", "isFastPay", "", "()Z", "setFastPay", "(Z)V", "param", "Lcom/didi/unifiedPay/component/model/PayParam;", "getParam", "()Lcom/didi/unifiedPay/component/model/PayParam;", "setParam", "(Lcom/didi/unifiedPay/component/model/PayParam;)V", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: InternationalIntermediaryActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isFastPay() {
            return InternationalIntermediaryActivity.f45172a;
        }

        public final void setFastPay(boolean z) {
            InternationalIntermediaryActivity.f45172a = z;
        }

        public final CallbackFunction getBridgeCallBack() {
            return InternationalIntermediaryActivity.f45173b;
        }

        public final void setBridgeCallBack(CallbackFunction callbackFunction) {
            InternationalIntermediaryActivity.f45173b = callbackFunction;
        }

        public final PayParam getParam() {
            return InternationalIntermediaryActivity.f45174c;
        }

        public final void setParam(PayParam payParam) {
            InternationalIntermediaryActivity.f45174c = payParam;
        }
    }
}
