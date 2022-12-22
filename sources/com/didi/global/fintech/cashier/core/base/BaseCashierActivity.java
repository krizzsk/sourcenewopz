package com.didi.global.fintech.cashier.core.base;

import com.didi.global.fintech.cashier.core.contract.IGlobalBizCashierPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBasePresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayView;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000 .*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00052\u00020\u0006:\u0001.B\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\u0015H\u0016J\u001a\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0016J\u001a\u0010,\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020\u0015H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006/"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity;", "P", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBizCashierPresenter;", "V", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayView;", "Lcom/didi/global/fintech/cashier/core/base/BaseActivity;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionHandleCallback;", "()V", "mCashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "getMCashierParam", "()Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "setMCashierParam", "(Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "mUniqueId", "", "getMUniqueId", "()Ljava/lang/String;", "setMUniqueId", "(Ljava/lang/String;)V", "onAdyenThreeDSSuccess", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "onCardBind", "cardIndex", "onCardVerify", "onCashierClose", "payResult", "", "onCybsThreeDSSuccess", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "cvv", "onParamInit", "onPasswordFailed", "status", "desc", "onPasswordSuccess", "token", "onPixPaid", "onPresenterCreated", "onThreeDSCancel", "error", "type", "onThreeDSFailed", "onTopUp", "Companion", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseCashierActivity.kt */
public abstract class BaseCashierActivity<P extends IGlobalBizCashierPresenter, V extends IGlobalCashierPayView> extends BaseActivity<P, V> implements IGlobalCashierActionHandleCallback {
    public static final String ARGS_PARAM = "args_param";
    public static final String ARGS_UNIQUE_ID = "args_unique_id";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private CashierParam f21425a;

    /* renamed from: b */
    private String f21426b;

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity$Companion;", "", "()V", "ARGS_PARAM", "", "ARGS_UNIQUE_ID", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BaseCashierActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public final CashierParam getMCashierParam() {
        return this.f21425a;
    }

    /* access modifiers changed from: protected */
    public final void setMCashierParam(CashierParam cashierParam) {
        this.f21425a = cashierParam;
    }

    /* access modifiers changed from: protected */
    public final String getMUniqueId() {
        return this.f21426b;
    }

    /* access modifiers changed from: protected */
    public final void setMUniqueId(String str) {
        this.f21426b = str;
    }

    public void onParamInit() {
        this.f21425a = (CashierParam) getIntent().getSerializableExtra("args_param");
        this.f21426b = getIntent().getStringExtra(ARGS_UNIQUE_ID);
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onParamInit: ", this.f21425a), (Throwable) null, "com.didi.global.fintech.cashier.core.base.BaseCashierActivity", 26);
    }

    public void onPresenterCreated() {
        IGlobalBizCashierPresenter iGlobalBizCashierPresenter = (IGlobalBizCashierPresenter) getMPresenter();
        if (iGlobalBizCashierPresenter != null) {
            iGlobalBizCashierPresenter.init(this.f21425a);
        }
    }

    public void onPixPaid() {
        SystemUtils.log(4, "Arirus", "onPixPaid: ", (Throwable) null, "com.didi.global.fintech.cashier.core.base.BaseCashierActivity", 34);
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onPixPaid();
        }
    }

    public void onAdyenThreeDSSuccess(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        Intrinsics.checkNotNullParameter(globalCashierAdyen3DSModel, "data");
        SystemUtils.log(4, "Arirus", "onThreedsSuccess: ", (Throwable) null, "com.didi.global.fintech.cashier.core.base.BaseCashierActivity", 39);
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onAdyenThreeDSSuccess(globalCashierAdyen3DSModel);
        }
    }

    public void onCybsThreeDSSuccess(PrepayRequest.ThreeDSV2 threeDSV2, String str) {
        Intrinsics.checkNotNullParameter(threeDSV2, "data");
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onCybsThreeDSSuccess(threeDSV2, str);
        }
    }

    public void onThreeDSFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        SystemUtils.log(4, "Arirus", "onThreeDSFailed: ", (Throwable) null, "com.didi.global.fintech.cashier.core.base.BaseCashierActivity", 48);
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onThreeDSFailed(str, str2);
        }
    }

    public void onThreeDSCancel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        SystemUtils.log(4, "Arirus", "onThreeDSCancel: ", (Throwable) null, "com.didi.global.fintech.cashier.core.base.BaseCashierActivity", 53);
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onThreeDSCancel(str, str2);
        }
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

    public void onCardBind(String str) {
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onCardBind(str);
        }
    }

    public void onCardVerify(String str) {
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onCardVerify(str);
        }
    }

    public void onTopUp() {
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onTopUp();
        }
    }

    public void onCashierClose(int i) {
        IGlobalCashierBasePresenter mPresenter = getMPresenter();
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = mPresenter instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) mPresenter : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onCashierClose(i);
        }
    }
}
