package com.didi.global.fintech.cashier.pix.presenter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierSyncStatusProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBinderPresenter;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.strategy.SyncStatusStrategy;
import com.didi.global.fintech.cashier.p117ui.kts.ContextKtxKt;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixPresenter;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/presenter/GlobalCashierPixPresenter;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBinderPresenter;", "Ljava/lang/Void;", "Lcom/didi/global/fintech/cashier/core/api/ICashierSyncStatusProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierOperateProcessor;", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixPresenter;", "context", "Landroid/content/Context;", "uniqueId", "", "controller", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixController;", "(Landroid/content/Context;Ljava/lang/String;Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixController;)V", "pixCode", "IView", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixView;", "dismissLoading", "", "doClip", "loading", "cancelable", "", "duration", "", "onBind", "onCancelClick", "onConfirmClick", "onPaidClick", "onSyncFail", "response", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "onSyncSuccess", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPixPresenter.kt */
public final class GlobalCashierPixPresenter extends GlobalCashierBinderPresenter<Void> implements ICashierOperateProcessor, ICashierSyncStatusProcessor, IGlobalCashierPixPresenter {

    /* renamed from: a */
    private final IGlobalCashierPixController f21650a;

    /* renamed from: b */
    private String f21651b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierPixPresenter(Context context, String str, IGlobalCashierPixController iGlobalCashierPixController) {
        super(context, str, (String) null, (IGlobalCashierActionInterceptCallback) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iGlobalCashierPixController, "controller");
        this.f21650a = iGlobalCashierPixController;
    }

    public void onBind() {
        super.onBind();
        SystemUtils.log(4, "Arirus", "onBind: GlobalCashierPixPresenter", (Throwable) null, "com.didi.global.fintech.cashier.pix.presenter.GlobalCashierPixPresenter", 34);
        ICashierBaseProcessor iCashierBaseProcessor = this;
        registerProcessor(iCashierBaseProcessor, ICashierOperateProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierSyncStatusProcessor.class);
        this.f21651b = this.f21650a.getPixCode();
        IGlobalCashierPixView IView = IView();
        if (IView != null) {
            String str = this.f21651b;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixCode");
                str = null;
            }
            IView.updatePixCode(str);
        }
        IGlobalCashierPixView IView2 = IView();
        if (IView2 != null) {
            IView2.setOnConfirmClickListener(new GlobalCashierPixPresenter$onBind$1(this));
        }
        IGlobalCashierPixView IView3 = IView();
        if (IView3 != null) {
            IView3.setOnCancelClickListener(new GlobalCashierPixPresenter$onBind$2(this));
        }
        IGlobalCashierPixView IView4 = IView();
        if (IView4 != null) {
            IView4.setOnPaidClickListener(new GlobalCashierPixPresenter$onBind$3(this));
        }
        omegaEndsPixCodeSw();
    }

    public void onConfirmClick() {
        ToastHelper.showShortInfo(getContext(), getContext().getString(R.string.GRider_payment_Copy_successfully_Lycd), (int) R.drawable.global_cashier_payment_success);
        Context context = getContext();
        String str = this.f21651b;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixCode");
            str = null;
        }
        m15797a(context, str);
        UiThreadHandler.postDelayed(new Runnable() {
            public final void run() {
                GlobalCashierPixPresenter.m15798a(GlobalCashierPixPresenter.this);
            }
        }, 1000);
        omegaEndsPixCodeBtnCk(ContextKtxKt.string(getContext(), R.string.GRider_payment_Copy_PIX_ybbs));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15798a(GlobalCashierPixPresenter globalCashierPixPresenter) {
        Intrinsics.checkNotNullParameter(globalCashierPixPresenter, "this$0");
        globalCashierPixPresenter.f21650a.updateState(IGlobalCashierPixController.State.Loading);
        globalCashierPixPresenter.startSyncPayResult(new SyncStatusStrategy(0, 0, SyncStatusStrategy.Companion.getNormal(), 3, (DefaultConstructorMarker) null));
    }

    public void onCancelClick() {
        this.f21650a.finish();
        omegaEndsPixCodeBtnCk(ContextKtxKt.string(getContext(), R.string.GRider_payment_Cancel_ntbd));
    }

    public void onPaidClick() {
        Context context = getContext();
        String str = this.f21651b;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixCode");
            str = null;
        }
        m15797a(context, str);
        this.f21650a.updateState(IGlobalCashierPixController.State.Loading);
        startSyncPayResult(new SyncStatusStrategy(0, 0, SyncStatusStrategy.Companion.getNormal(), 3, (DefaultConstructorMarker) null));
    }

    public void loading(boolean z, long j) {
        this.f21650a.updateState(IGlobalCashierPixController.State.Loading);
    }

    public void dismissLoading() {
        this.f21650a.updateState(IGlobalCashierPixController.State.Timeout);
    }

    public IGlobalCashierPixView IView() {
        IGlobalCashierBaseView mView = getMView();
        if (mView instanceof IGlobalCashierPixView) {
            return (IGlobalCashierPixView) mView;
        }
        return null;
    }

    /* renamed from: a */
    private final void m15797a(Context context, String str) {
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Label", str));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    public void onSyncSuccess(PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
        this.f21650a.updateState(IGlobalCashierPixController.State.Success);
        UiThreadHandler.postDelayed(new Runnable() {
            public final void run() {
                GlobalCashierPixPresenter.m15799b(GlobalCashierPixPresenter.this);
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15799b(GlobalCashierPixPresenter globalCashierPixPresenter) {
        Intrinsics.checkNotNullParameter(globalCashierPixPresenter, "this$0");
        globalCashierPixPresenter.f21650a.finish();
    }

    public void onSyncFail(PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
        this.f21650a.updateState(IGlobalCashierPixController.State.Timeout);
    }
}
