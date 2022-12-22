package com.didi.global.fintech.cashier.core.presenter;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierPolicyProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyView;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyViewBinder;
import com.didi.global.fintech.cashier.core.utils.PayInfoManager;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierHeaderViewBinder;
import com.didi.global.fintech.cashier.core.viewbinder.policy.GlobalCashierPolicyBtnViewBinder;
import com.didi.global.fintech.cashier.core.viewbinder.policy.GlobalCashierPolicyViewBinder;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PolicyData;
import com.didi.global.fintech.cashier.model.net.response.PolicyInfo;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPayBtnViewHolder;
import com.didi.global.fintech.cashier.p117ui.widget.GlobalCashierLoadingView;
import com.didi.sdk.util.UiThreadHandler;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierPolicyPresenter;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBinderPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyPresenter;", "Lcom/didi/global/fintech/cashier/core/api/ICashierPolicyProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierOperateProcessor;", "context", "Landroid/content/Context;", "uniqueId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "IView", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyView;", "bindView", "", "view", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "dismissLoading", "loading", "cancelable", "", "duration", "", "onBackPressed", "type", "onBind", "onConfirmClick", "onPolicyProcess", "response", "Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "onShowPrivacyPolicy", "payInfo", "unBind", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPolicyPresenter.kt */
public final class GlobalCashierPolicyPresenter extends GlobalCashierBinderPresenter<PayInfoResponse> implements ICashierOperateProcessor, ICashierPolicyProcessor, IGlobalCashierPolicyPresenter {

    /* renamed from: a */
    private final GlobalCashierLoadingView f21483a = GlobalCashierLoadingView.Companion.newInstance$default(GlobalCashierLoadingView.Companion, false, 1, (Object) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierPolicyPresenter(Context context, String str) {
        super(context, str, (String) null, (IGlobalCashierActionInterceptCallback) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        super.bindView(iGlobalCashierBaseView);
        GlobalCashierHeaderViewBinder globalCashierHeaderViewBinder = new GlobalCashierHeaderViewBinder(this);
        IGlobalCashierPolicyView IView = IView();
        IGlobalCashierPayBtnViewHolder iGlobalCashierPayBtnViewHolder = null;
        globalCashierHeaderViewBinder.viewBind(IView == null ? null : IView.headerView());
        IGlobalCashierPolicyPresenter iGlobalCashierPolicyPresenter = this;
        GlobalCashierPolicyViewBinder globalCashierPolicyViewBinder = new GlobalCashierPolicyViewBinder(iGlobalCashierPolicyPresenter);
        IGlobalCashierPolicyView IView2 = IView();
        globalCashierPolicyViewBinder.viewBind(IView2 == null ? null : IView2.policyView());
        GlobalCashierPolicyBtnViewBinder globalCashierPolicyBtnViewBinder = new GlobalCashierPolicyBtnViewBinder(iGlobalCashierPolicyPresenter);
        IGlobalCashierPolicyView IView3 = IView();
        if (IView3 != null) {
            iGlobalCashierPayBtnViewHolder = IView3.btnView();
        }
        globalCashierPolicyBtnViewBinder.viewBind(iGlobalCashierPayBtnViewHolder);
        getPolicy();
    }

    public void onBind() {
        super.onBind();
        ICashierBaseProcessor iCashierBaseProcessor = this;
        registerProcessor(iCashierBaseProcessor, ICashierOperateProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierPolicyProcessor.class);
    }

    public void onShowPrivacyPolicy(PayInfoResponse payInfoResponse) {
        IGlobalCashierPolicyViewBinder iGlobalCashierPolicyViewBinder;
        Object obj;
        if (payInfoResponse != null) {
            for (IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder : getViewBinders()) {
                iGlobalCashierBaseViewBinder.setupView(payInfoResponse);
            }
            IGlobalCashierPolicyView IView = IView();
            if (IView != null) {
                IView.setupView(payInfoResponse);
            }
        }
        Iterator it = this.f21439a.iterator();
        while (true) {
            iGlobalCashierPolicyViewBinder = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IGlobalCashierBaseViewBinder) obj) instanceof IGlobalCashierPolicyViewBinder) {
                break;
            }
        }
        IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder2 = (IGlobalCashierBaseViewBinder) obj;
        if (iGlobalCashierBaseViewBinder2 instanceof IGlobalCashierPolicyViewBinder) {
            iGlobalCashierPolicyViewBinder = iGlobalCashierBaseViewBinder2;
        }
        IGlobalCashierPolicyViewBinder iGlobalCashierPolicyViewBinder2 = iGlobalCashierPolicyViewBinder;
        if (iGlobalCashierPolicyViewBinder2 != null) {
            iGlobalCashierPolicyViewBinder2.registerLinkListener(new GlobalCashierPolicyPresenter$onShowPrivacyPolicy$2(this));
        }
        omegaPolicySw();
    }

    public void onConfirmClick() {
        GlobalCashierPolicyPresenter globalCashierPolicyPresenter;
        Object obj;
        PolicyInfo policyInfo;
        PolicyData policyData;
        GlobalCashierPolicyPresenter globalCashierPolicyPresenter2 = this;
        Iterator it = this.f21439a.iterator();
        while (true) {
            globalCashierPolicyPresenter = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IGlobalCashierBaseViewBinder) obj) instanceof IGlobalCashierPolicyViewBinder) {
                break;
            }
        }
        IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder = (IGlobalCashierBaseViewBinder) obj;
        if (!(iGlobalCashierBaseViewBinder instanceof IGlobalCashierPolicyViewBinder)) {
            iGlobalCashierBaseViewBinder = null;
        }
        IGlobalCashierPolicyViewBinder iGlobalCashierPolicyViewBinder = (IGlobalCashierPolicyViewBinder) iGlobalCashierBaseViewBinder;
        boolean z = false;
        if (iGlobalCashierPolicyViewBinder != null && iGlobalCashierPolicyViewBinder.checked()) {
            z = true;
        }
        GlobalCashierPolicyPresenter globalCashierPolicyPresenter3 = z ? this : null;
        if (globalCashierPolicyPresenter3 != null) {
            PayInfoResponse payInfo = PayInfoManager.getInstance().getPayInfo(globalCashierPolicyPresenter3.getUniqueId());
            if (!(payInfo == null || (policyInfo = payInfo.getPolicyInfo()) == null || (policyData = policyInfo.getPolicyData()) == null)) {
                globalCashierPolicyPresenter3.requestConfirmPolicy(policyData);
            }
            globalCashierPolicyPresenter = globalCashierPolicyPresenter3;
        }
        if (globalCashierPolicyPresenter == null) {
            IGlobalCashierPolicyView IView = globalCashierPolicyPresenter2.IView();
            if (IView != null) {
                IView.showUncheckTip();
            }
            globalCashierPolicyPresenter2.omegaPolicyToastSw();
        }
        omegaPolicyCk(4);
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPolicyProcess(com.didi.global.fintech.cashier.model.net.response.AgreePolicyResponse r3) {
        /*
            r2 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.Boolean r3 = r3.getResult()
            r0 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 != 0) goto L_0x0016
            return
        L_0x0016:
            android.content.Context r3 = r2.getContext()
            boolean r0 = r3 instanceof android.app.Activity
            r1 = 0
            if (r0 == 0) goto L_0x0022
            android.app.Activity r3 = (android.app.Activity) r3
            goto L_0x0023
        L_0x0022:
            r3 = r1
        L_0x0023:
            if (r3 != 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            r0 = -1
            r3.setResult(r0)
        L_0x002a:
            android.content.Context r3 = r2.getContext()
            boolean r0 = r3 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0035
            r1 = r3
            android.app.Activity r1 = (android.app.Activity) r1
        L_0x0035:
            if (r1 != 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            r1.finish()
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierPolicyPresenter.onPolicyProcess(com.didi.global.fintech.cashier.model.net.response.AgreePolicyResponse):void");
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed(java.lang.String r3) {
        /*
            r2 = this;
            r3 = 3
            r2.omegaPolicyCk(r3)
            android.content.Context r3 = r2.getContext()
            boolean r0 = r3 instanceof android.app.Activity
            r1 = 0
            if (r0 == 0) goto L_0x0010
            android.app.Activity r3 = (android.app.Activity) r3
            goto L_0x0011
        L_0x0010:
            r3 = r1
        L_0x0011:
            if (r3 != 0) goto L_0x0014
            goto L_0x0018
        L_0x0014:
            r0 = 0
            r3.setResult(r0)
        L_0x0018:
            android.content.Context r3 = r2.getContext()
            boolean r0 = r3 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0023
            r1 = r3
            android.app.Activity r1 = (android.app.Activity) r1
        L_0x0023:
            if (r1 != 0) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            r1.finish()
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierPolicyPresenter.onBackPressed(java.lang.String):void");
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
                GlobalCashierPolicyPresenter.m15742a(GlobalCashierPolicyPresenter.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15742a(GlobalCashierPolicyPresenter globalCashierPolicyPresenter, boolean z, long j) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(globalCashierPolicyPresenter, "this$0");
        if (globalCashierPolicyPresenter.f21483a.isVisible()) {
            globalCashierPolicyPresenter = null;
        }
        if (globalCashierPolicyPresenter != null) {
            Context context = globalCashierPolicyPresenter.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                GlobalCashierLoadingView globalCashierLoadingView = globalCashierPolicyPresenter.f21483a;
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

    public void dismissLoading() {
        this.f21483a.dismissAllowingStateLoss();
    }

    public IGlobalCashierPolicyView IView() {
        IGlobalCashierBaseView mView = getMView();
        if (mView instanceof IGlobalCashierPolicyView) {
            return (IGlobalCashierPolicyView) mView;
        }
        return null;
    }

    public void unBind() {
        super.unBind();
        getViewBinders().clear();
    }
}
