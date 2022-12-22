package com.didi.global.fintech.cashier.threeds.spi;

import androidx.fragment.app.FragmentActivity;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ComponentError;
import com.adyen.checkout.core.exception.CheckoutException;
import com.didi.global.fintech.cashier.core.action.IGlobalCashier3DSActionHandler;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.threeds.ThreeDSDataParser;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;
import global.didi.pay.threeds.contract.IAdyen3DS;
import global.didi.pay.threeds.method.adyen.IAdyen3DSListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier", value = {IGlobalCashier3DSActionHandler.class})
@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/spi/GlobalCashier3DSActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashier3DSActionHandler;", "Lglobal/didi/pay/threeds/method/adyen/IAdyen3DSListener;", "()V", "mAction", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "mAdyen3DS", "Lglobal/didi/pay/threeds/contract/IAdyen3DS;", "handle", "", "activity", "action", "onCancel", "", "onDestroy", "onFailure", "error", "Lcom/adyen/checkout/components/ComponentError;", "onSuccess", "data", "Lcom/adyen/checkout/components/ActionComponentData;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashier3DSActionHandler.kt */
public final class GlobalCashier3DSActionHandler implements IGlobalCashier3DSActionHandler, IAdyen3DSListener {

    /* renamed from: a */
    private FragmentActivity f21680a;

    /* renamed from: b */
    private IAdyen3DS f21681b;

    /* renamed from: c */
    private CashierAction f21682c;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0086 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handle(androidx.fragment.app.FragmentActivity r11, com.didi.global.fintech.cashier.model.net.request.CashierAction r12) {
        /*
            r10 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r10.f21680a = r11
            r0 = r10
            com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler r0 = (com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler) r0
            r0 = 1
            r1 = 0
            if (r12 != 0) goto L_0x0010
        L_0x000e:
            r2 = 0
            goto L_0x0017
        L_0x0010:
            boolean r2 = r12.threeDS()
            if (r2 != 0) goto L_0x000e
            r2 = 1
        L_0x0017:
            if (r2 != 0) goto L_0x0037
            if (r12 != 0) goto L_0x001d
        L_0x001b:
            r2 = 0
            goto L_0x0032
        L_0x001d:
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r2 = r12.getActionData()
            if (r2 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            java.util.Map r2 = r2.getAction()
            if (r2 != 0) goto L_0x002b
            goto L_0x001b
        L_0x002b:
            boolean r2 = r2.isEmpty()
            if (r2 != r0) goto L_0x001b
            r2 = 1
        L_0x0032:
            if (r2 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r2 = 0
            goto L_0x0038
        L_0x0037:
            r2 = 1
        L_0x0038:
            r3 = 0
            if (r2 == 0) goto L_0x003d
            r2 = r10
            goto L_0x003e
        L_0x003d:
            r2 = r3
        L_0x003e:
            com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler r2 = (com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler) r2
            if (r2 != 0) goto L_0x0086
            r10.f21682c = r12
            global.didi.pay.threeds.contract.IAdyen3DS r1 = r10.f21681b
            if (r1 != 0) goto L_0x0057
            global.didi.pay.threeds.contract.IAdyen3DS r11 = global.didi.pay.threeds.ThreeDSFactory.getAdyen3DS(r11)
            r10.f21681b = r11
            if (r11 != 0) goto L_0x0051
            goto L_0x0057
        L_0x0051:
            r1 = r10
            global.didi.pay.threeds.method.adyen.IAdyen3DSListener r1 = (global.didi.pay.threeds.method.adyen.IAdyen3DSListener) r1
            r11.registerListener(r1)
        L_0x0057:
            global.didi.pay.threeds.contract.IAdyen3DS r11 = r10.f21681b
            java.lang.String r1 = "handle: "
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r11)
            r4 = 4
            r7 = 0
            r9 = 34
            java.lang.String r5 = "Arirus"
            java.lang.String r8 = "com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
            global.didi.pay.threeds.contract.IAdyen3DS r11 = r10.f21681b
            if (r11 != 0) goto L_0x006f
            goto L_0x0085
        L_0x006f:
            org.json.JSONObject r1 = new org.json.JSONObject
            if (r12 != 0) goto L_0x0074
            goto L_0x007f
        L_0x0074:
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r12 = r12.getActionData()
            if (r12 != 0) goto L_0x007b
            goto L_0x007f
        L_0x007b:
            java.util.Map r3 = r12.getAction()
        L_0x007f:
            r1.<init>(r3)
            r11.handleAction((org.json.JSONObject) r1)
        L_0x0085:
            return r0
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler.handle(androidx.fragment.app.FragmentActivity, com.didi.global.fintech.cashier.model.net.request.CashierAction):boolean");
    }

    public void onDestroy() {
        this.f21682c = null;
        IAdyen3DS iAdyen3DS = this.f21681b;
        if (iAdyen3DS != null) {
            iAdyen3DS.unregisterListener();
        }
        this.f21681b = null;
    }

    public void onSuccess(ActionComponentData actionComponentData) {
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onSuccess: ", actionComponentData), (Throwable) null, "com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler", 46);
        FragmentActivity fragmentActivity = this.f21680a;
        GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel = null;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = fragmentActivity instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) fragmentActivity : null;
        if (iGlobalCashierActionHandleCallback != null) {
            CashierAction cashierAction = this.f21682c;
            if (cashierAction != null) {
                globalCashierAdyen3DSModel = cashierAction.threeDSData();
            }
            iGlobalCashierActionHandleCallback.onAdyenThreeDSSuccess(ThreeDSDataParser.ActionComponentDataToAdyen3DSModel(actionComponentData, globalCashierAdyen3DSModel));
        }
    }

    public void onFailure(ComponentError componentError) {
        String str;
        CheckoutException exception;
        new RuntimeException().printStackTrace();
        if (!(componentError == null || (exception = componentError.getException()) == null)) {
            exception.printStackTrace();
        }
        String str2 = null;
        if (componentError == null) {
            str = null;
        } else {
            str = componentError.getErrorMessage();
        }
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onFailure: ", str), (Throwable) null, "com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler", 56);
        FragmentActivity fragmentActivity = this.f21680a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = fragmentActivity instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) fragmentActivity : null;
        if (iGlobalCashierActionHandleCallback != null) {
            if (componentError != null) {
                str2 = componentError.getErrorMessage();
            }
            iGlobalCashierActionHandleCallback.onThreeDSFailed(str2, CashierAction.ACTION_THREE_DS);
        }
    }

    public void onCancel() {
        FragmentActivity fragmentActivity = this.f21680a;
        String str = null;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = fragmentActivity instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) fragmentActivity : null;
        if (iGlobalCashierActionHandleCallback != null) {
            FragmentActivity fragmentActivity2 = this.f21680a;
            if (fragmentActivity2 != null) {
                str = fragmentActivity2.getString(R.string.threeds_fail_message);
            }
            iGlobalCashierActionHandleCallback.onThreeDSCancel(str, CashierAction.ACTION_THREE_DS);
        }
    }
}
