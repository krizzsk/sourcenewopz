package com.didi.global.fintech.cashier.core.presenter;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.component.common.net.CarServerParam;
import com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierResultProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierMerchantResponseHandler;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierResultPayViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierResultPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierResultView;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierResultPayViewBinder;
import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.p117ui.viewholder.MerchantButtonData;
import com.didi.global.fintech.cashier.p117ui.widget.GlobalCashierLoadingView;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0002H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierResultPresenter;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBinderPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultPresenter;", "Lcom/didi/global/fintech/cashier/core/api/ICashierOperateProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierResultProcessor;", "context", "Landroid/content/Context;", "uniqueId", "", "callback", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;)V", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "merchantResponseHandler", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierMerchantResponseHandler;", "kotlin.jvm.PlatformType", "IView", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultView;", "bindView", "", "view", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "dismissLoading", "loading", "cancelable", "", "duration", "", "onBind", "onBottomBtnClick", "button", "Lcom/didi/global/fintech/cashier/ui/viewholder/MerchantButtonData;", "successInfoProcess", "response", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierResultPresenter.kt */
public final class GlobalCashierResultPresenter extends GlobalCashierBinderPresenter<SuccessInfoResponse> implements ICashierOperateProcessor, ICashierResultProcessor, IGlobalCashierResultPresenter {

    /* renamed from: a */
    private final IGlobalCashierCallback f21484a;

    /* renamed from: b */
    private final GlobalCashierLoadingView f21485b = GlobalCashierLoadingView.Companion.newInstance$default(GlobalCashierLoadingView.Companion, false, 1, (Object) null);

    /* renamed from: c */
    private final IGlobalCashierMerchantResponseHandler f21486c = ((IGlobalCashierMerchantResponseHandler) ServiceLoader.load(IGlobalCashierMerchantResponseHandler.class).get());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierResultPresenter(Context context, String str, IGlobalCashierCallback iGlobalCashierCallback) {
        super(context, str, (String) null, (IGlobalCashierActionInterceptCallback) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iGlobalCashierCallback, "callback");
        this.f21484a = iGlobalCashierCallback;
    }

    public void loading(boolean z, long j) {
        UiThreadHandler.post(new Runnable(z, j) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ long f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                GlobalCashierResultPresenter.m15744a(GlobalCashierResultPresenter.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15744a(GlobalCashierResultPresenter globalCashierResultPresenter, boolean z, long j) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(globalCashierResultPresenter, "this$0");
        if (globalCashierResultPresenter.f21485b.isVisible()) {
            globalCashierResultPresenter = null;
        }
        if (globalCashierResultPresenter != null) {
            Context context = globalCashierResultPresenter.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                GlobalCashierLoadingView globalCashierLoadingView = globalCashierResultPresenter.f21485b;
                globalCashierLoadingView.setCancelable(z);
                GlobalCashierLoadingView globalCashierLoadingView2 = (j > 0 ? 1 : (j == 0 ? 0 : -1)) == 0 ? globalCashierLoadingView : null;
                if (globalCashierLoadingView2 == null) {
                    globalCashierLoadingView2 = null;
                } else {
                    globalCashierLoadingView2.show(supportFragmentManager, (String) null);
                }
                if (globalCashierLoadingView2 == null) {
                    globalCashierLoadingView.showDuration(j, supportFragmentManager, (String) null);
                }
            }
        }
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        super.bindView(iGlobalCashierBaseView);
        GlobalCashierResultPayViewBinder globalCashierResultPayViewBinder = new GlobalCashierResultPayViewBinder(this);
        IGlobalCashierResultView IView = IView();
        globalCashierResultPayViewBinder.viewBind(IView == null ? null : IView.paySuccessView());
    }

    public void dismissLoading() {
        this.f21485b.dismissAllowingStateLoss();
    }

    public void successInfoProcess(SuccessInfoResponse successInfoResponse) {
        Intrinsics.checkNotNullParameter(successInfoResponse, "response");
        for (IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder : getViewBinders()) {
            iGlobalCashierBaseViewBinder.setupView(successInfoResponse);
        }
        IGlobalCashierResultView IView = IView();
        if (IView != null) {
            IView.setupView(successInfoResponse);
        }
        omegaPaySuccessSw();
    }

    public void onBind() {
        super.onBind();
        ICashierBaseProcessor iCashierBaseProcessor = this;
        registerProcessor(iCashierBaseProcessor, ICashierOperateProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierResultProcessor.class);
        requestSuccessInfo();
    }

    public void onBottomBtnClick(MerchantButtonData merchantButtonData) {
        Intrinsics.checkNotNullParameter(merchantButtonData, CarServerParam.PARAM_BUTTON);
        omegaPaySuccessBackCk();
        UiThreadHandler.postDelayed(new Runnable(merchantButtonData) {
            public final /* synthetic */ MerchantButtonData f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                GlobalCashierResultPresenter.m15743a(GlobalCashierResultPresenter.this, this.f$1);
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15743a(GlobalCashierResultPresenter globalCashierResultPresenter, MerchantButtonData merchantButtonData) {
        IGlobalCashierResultPayViewBinder iGlobalCashierResultPayViewBinder;
        Object obj;
        Intrinsics.checkNotNullParameter(globalCashierResultPresenter, "this$0");
        Intrinsics.checkNotNullParameter(merchantButtonData, "$button");
        globalCashierResultPresenter.f21484a.onClose(1);
        Iterator it = globalCashierResultPresenter.f21439a.iterator();
        while (true) {
            iGlobalCashierResultPayViewBinder = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IGlobalCashierBaseViewBinder) obj) instanceof IGlobalCashierResultPayViewBinder) {
                break;
            }
        }
        IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder = (IGlobalCashierBaseViewBinder) obj;
        if (iGlobalCashierBaseViewBinder instanceof IGlobalCashierResultPayViewBinder) {
            iGlobalCashierResultPayViewBinder = iGlobalCashierBaseViewBinder;
        }
        IGlobalCashierResultPayViewBinder iGlobalCashierResultPayViewBinder2 = iGlobalCashierResultPayViewBinder;
        if (iGlobalCashierResultPayViewBinder2 != null) {
            iGlobalCashierResultPayViewBinder2.disableBtn();
        }
        IGlobalCashierMerchantResponseHandler iGlobalCashierMerchantResponseHandler = globalCashierResultPresenter.f21486c;
        if (iGlobalCashierMerchantResponseHandler != null) {
            iGlobalCashierMerchantResponseHandler.onHandle(globalCashierResultPresenter.getContext(), 1, globalCashierResultPresenter.getFromType(), merchantButtonData.getReturn_url());
        }
    }

    public IGlobalCashierResultView IView() {
        IGlobalCashierBaseView mView = getMView();
        if (mView instanceof IGlobalCashierResultView) {
            return (IGlobalCashierResultView) mView;
        }
        return null;
    }
}
