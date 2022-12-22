package com.didi.global.fintech.cashier.fastpay.base;

import android.content.Intent;
import com.didi.global.fintech.cashier.core.base.BaseActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBasePresenter;
import com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayBasePresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayBaseView;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayCallback;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.user.model.FastPayParam;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000 1*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003*\b\b\u0002\u0010\u0004*\u00020\u00052\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00062\u00020\u00072\u00020\b:\u00011B\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0017H\u0016J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0017H\u0016J\b\u0010*\u001a\u00020\u0011H\u0016J\b\u0010+\u001a\u00020\u0011H\u0016J\u001a\u0010,\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00172\u0006\u0010.\u001a\u00020\u0017H\u0016J\u001a\u0010/\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00172\u0006\u0010.\u001a\u00020\u0017H\u0016J\b\u00100\u001a\u00020\u0011H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u00062"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/base/BaseFastPayActivity;", "D", "P", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBasePresenter;", "V", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseView;", "Lcom/didi/global/fintech/cashier/core/base/BaseActivity;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionHandleCallback;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayCallback;", "()V", "mFastPayParam", "Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "getMFastPayParam", "()Lcom/didi/global/fintech/cashier/user/model/FastPayParam;", "setMFastPayParam", "(Lcom/didi/global/fintech/cashier/user/model/FastPayParam;)V", "onAdyenThreeDSSuccess", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "onBackPressed", "onCardBind", "cardIndex", "", "onCardVerify", "onCashierClose", "payResult", "", "onClose", "refreshed", "", "curStatus", "Lcom/didi/global/fintech/cashier/fastpay/consts/FastPayStatus;", "onCybsThreeDSSuccess", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "cvv", "onParamInit", "onPasswordFailed", "status", "desc", "onPasswordSuccess", "token", "onPixPaid", "onPresenterCreated", "onThreeDSCancel", "error", "type", "onThreeDSFailed", "onTopUp", "Companion", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseFastPayActivity.kt */
public abstract class BaseFastPayActivity<D, P extends IFastPayBasePresenter<D>, V extends IFastPayBaseView> extends BaseActivity<P, V> implements IGlobalCashierActionHandleCallback, IFastPayCallback {
    public static final String ARGS_PARAM = "args_param";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String RESULT_FAST_PAY_STATUS = "result_fast_pay_status";

    /* renamed from: a */
    private FastPayParam f21535a;

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/base/BaseFastPayActivity$Companion;", "", "()V", "ARGS_PARAM", "", "RESULT_FAST_PAY_STATUS", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BaseFastPayActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public final FastPayParam getMFastPayParam() {
        return this.f21535a;
    }

    /* access modifiers changed from: protected */
    public final void setMFastPayParam(FastPayParam fastPayParam) {
        this.f21535a = fastPayParam;
    }

    public void onParamInit() {
        FastPayParam fastPayParam = (FastPayParam) getIntent().getSerializableExtra("args_param");
        this.f21535a = fastPayParam;
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("BaseFastPayActivity onParamInit: ", fastPayParam), (Throwable) null, "com.didi.global.fintech.cashier.fastpay.base.BaseFastPayActivity", 26);
    }

    public void onPresenterCreated() {
        IFastPayBasePresenter iFastPayBasePresenter = (IFastPayBasePresenter) getMPresenter();
        if (iFastPayBasePresenter != null) {
            iFastPayBasePresenter.init(this.f21535a);
        }
    }

    public void onClose(boolean z, FastPayStatus fastPayStatus) {
        Intrinsics.checkNotNullParameter(fastPayStatus, "curStatus");
        int i = z ? -1 : 0;
        Intent intent = new Intent();
        intent.putExtra(RESULT_FAST_PAY_STATUS, fastPayStatus.name());
        Unit unit = Unit.INSTANCE;
        setResult(i, intent);
        finish();
    }

    public void onBackPressed() {
        IFastPayBasePresenter iFastPayBasePresenter = (IFastPayBasePresenter) getMPresenter();
        if (iFastPayBasePresenter != null) {
            iFastPayBasePresenter.onBackPressed();
        }
    }

    public void onCardBind(String str) {
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onCardBind(str);
        }
    }

    public void onCardVerify(String str) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onTopUp() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onPixPaid() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onAdyenThreeDSSuccess(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        Intrinsics.checkNotNullParameter(globalCashierAdyen3DSModel, "data");
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onCybsThreeDSSuccess(PrepayRequest.ThreeDSV2 threeDSV2, String str) {
        Intrinsics.checkNotNullParameter(threeDSV2, "data");
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onThreeDSFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onThreeDSCancel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onPasswordSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onPasswordSuccess(str);
        }
    }

    public void onPasswordFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "desc");
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onPasswordFailed(str, str2);
        }
    }

    public void onCashierClose(int i) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }
}
