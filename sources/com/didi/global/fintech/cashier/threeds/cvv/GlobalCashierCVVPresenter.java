package com.didi.global.fintech.cashier.threeds.cvv;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierCVVProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierDialogProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.CVVCardInfo;
import com.didi.global.fintech.cashier.model.net.response.CVVDrawerData;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.EncryptInfo;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierBaseViewHolder;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCommonConfig;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.p117ui.widget.GlobalCashierLoadingView;
import com.didi.global.fintech.cashier.p117ui.widget.GlobalCashierRetryView;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCCVContentViewBinder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVPresenter;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVView;
import com.didi.global.fintech.cashier.threeds.dialog.GlobalCashierCVVDrawer;
import com.didi.global.fintech.cashier.threeds.omega.ThreeDSOmegaConstants;
import com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVBtnVB;
import com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB;
import com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVHeaderVB;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J$\u0010%\u001a\u0004\u0018\u0001H&\"\u0012\b\u0000\u0010&\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\b¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020\u001bH\u0016J\b\u00100\u001a\u00020\u001bH\u0016J\u0012\u00101\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u001bH\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u00020\u001b2\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00130\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/cvv/GlobalCashierCVVPresenter;", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;", "Lcom/didi/global/fintech/cashier/core/api/ICashierOperateProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierCVVProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierDialogProcessor;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBizPresenter;", "context", "Landroid/content/Context;", "uniqueId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "mCvvCardInfo", "Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "mEncryptInfo", "Lcom/didi/global/fintech/cashier/model/net/response/EncryptInfo;", "viewBinders", "", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "IView", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVView;", "addViewBinder", "", "binder", "appUpgrade", "", "bindView", "view", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "customError", "config", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCommonConfig;", "api", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "dismissLoading", "getViewBinder", "T", "()Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVBaseViewBinder;", "loading", "cancelable", "duration", "", "netError", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onBackPressed", "onBind", "onCVVDrawerClick", "data", "Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData;", "onConfirmClick", "onCvvInfoSuccess", "response", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "updateCardInfo", "cardInfo", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVPresenter.kt */
public final class GlobalCashierCVVPresenter extends GlobalCashierBizPresenter implements ICashierCVVProcessor, ICashierDialogProcessor, ICashierOperateProcessor, IGlobalCashierCVVPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<IGlobalCashierCVVBaseViewBinder<? extends IGlobalCashierBaseViewHolder>> f21666a = new ArrayList();

    /* renamed from: b */
    private final GlobalCashierLoadingView f21667b = GlobalCashierLoadingView.Companion.newInstance$default(GlobalCashierLoadingView.Companion, false, 1, (Object) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CVVCardInfo f21668c;

    /* renamed from: d */
    private EncryptInfo f21669d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierCVVPresenter(Context context, String str) {
        super(context, str, "NATIVE", (IGlobalCashierActionInterceptCallback) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean addViewBinder(IGlobalCashierCVVBaseViewBinder<? extends IGlobalCashierBaseViewHolder> iGlobalCashierCVVBaseViewBinder) {
        Intrinsics.checkNotNullParameter(iGlobalCashierCVVBaseViewBinder, "binder");
        return this.f21666a.add(iGlobalCashierCVVBaseViewBinder);
    }

    /* renamed from: a */
    private final /* synthetic */ <T extends IGlobalCashierCVVBaseViewBinder<? extends IGlobalCashierBaseViewHolder>> T m15805a() {
        T t;
        Iterator it = this.f21666a.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (((IGlobalCashierCVVBaseViewBinder) t) instanceof IGlobalCashierCVVBaseViewBinder) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return (IGlobalCashierCVVBaseViewBinder) t;
    }

    public void updateCardInfo(CVVCardInfo cVVCardInfo) {
        this.f21668c = cVVCardInfo;
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        Object obj;
        super.bindView(iGlobalCashierBaseView);
        IGlobalCashierCVVPresenter iGlobalCashierCVVPresenter = this;
        GlobalCashierCVVHeaderVB globalCashierCVVHeaderVB = new GlobalCashierCVVHeaderVB(iGlobalCashierCVVPresenter);
        IGlobalCashierCVVView IView = IView();
        IGlobalCashierCCVContentViewBinder iGlobalCashierCCVContentViewBinder = null;
        globalCashierCVVHeaderVB.viewBind(IView == null ? null : IView.headerView());
        GlobalCashierCVVContentVB globalCashierCVVContentVB = new GlobalCashierCVVContentVB(iGlobalCashierCVVPresenter);
        IGlobalCashierCVVView IView2 = IView();
        globalCashierCVVContentVB.viewBind(IView2 == null ? null : IView2.cvvView());
        GlobalCashierCVVBtnVB globalCashierCVVBtnVB = new GlobalCashierCVVBtnVB(iGlobalCashierCVVPresenter);
        IGlobalCashierCVVView IView3 = IView();
        globalCashierCVVBtnVB.viewBind(IView3 == null ? null : IView3.btnView());
        Iterator it = this.f21666a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IGlobalCashierCVVBaseViewBinder) obj) instanceof IGlobalCashierCCVContentViewBinder) {
                break;
            }
        }
        IGlobalCashierCVVBaseViewBinder iGlobalCashierCVVBaseViewBinder = (IGlobalCashierCVVBaseViewBinder) obj;
        if (iGlobalCashierCVVBaseViewBinder instanceof IGlobalCashierCCVContentViewBinder) {
            iGlobalCashierCCVContentViewBinder = iGlobalCashierCVVBaseViewBinder;
        }
        IGlobalCashierCCVContentViewBinder iGlobalCashierCCVContentViewBinder2 = iGlobalCashierCCVContentViewBinder;
        if (iGlobalCashierCCVContentViewBinder2 != null) {
            iGlobalCashierCCVContentViewBinder2.registerTextChangeListener(new GlobalCashierCVVPresenter$bindView$1(this));
        }
    }

    public void onBind() {
        super.onBind();
        ICashierBaseProcessor iCashierBaseProcessor = this;
        registerProcessor(iCashierBaseProcessor, ICashierOperateProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierCVVProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierDialogProcessor.class);
        requestCVVInfo(this.f21668c);
    }

    public void onCVVDrawerClick(CVVDrawerData cVVDrawerData) {
        GlobalCashierCVVDrawer newInstance = GlobalCashierCVVDrawer.Companion.newInstance();
        newInstance.setData(cVVDrawerData);
        FragmentManager supportFragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context as FragmentActiv…y).supportFragmentManager");
        newInstance.show(supportFragmentManager, Const.DRAWER);
        CashierOmegaUtils cashierOmegaUtils = new CashierOmegaUtils(ThreeDSOmegaConstants.fin_cvv_component_button_ck);
        CVVCardInfo cVVCardInfo = this.f21668c;
        cashierOmegaUtils.addParam(ThreeDSOmegaConstants.PARAM_CARD_ID, cVVCardInfo == null ? null : cVVCardInfo.getCard_prefix()).addParam("button_name", "help").send();
    }

    public void onCvvInfoSuccess(CVVInfoResponse cVVInfoResponse) {
        Intrinsics.checkNotNullParameter(cVVInfoResponse, "response");
        for (IGlobalCashierCVVBaseViewBinder iGlobalCashierCVVBaseViewBinder : this.f21666a) {
            iGlobalCashierCVVBaseViewBinder.setupView(cVVInfoResponse);
        }
        IGlobalCashierCVVView IView = IView();
        if (IView != null) {
            IView.setupView(cVVInfoResponse);
        }
        this.f21669d = cVVInfoResponse.getEncryptInfo();
        CashierOmegaUtils cashierOmegaUtils = new CashierOmegaUtils(ThreeDSOmegaConstants.fin_cvv_component_sw);
        CVVCardInfo cVVCardInfo = this.f21668c;
        cashierOmegaUtils.addParam(ThreeDSOmegaConstants.PARAM_CARD_ID, cVVCardInfo == null ? null : cVVCardInfo.getCard_prefix()).send();
    }

    public IGlobalCashierCVVView IView() {
        IGlobalCashierBaseView mView = getMView();
        if (mView instanceof IGlobalCashierCVVView) {
            return (IGlobalCashierCVVView) mView;
        }
        return null;
    }

    public void netError(CashierError cashierError, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(cashierError, "error");
        Intrinsics.checkNotNullParameter(api, "api");
        GlobalCashierRetryView.Companion.showInstance((FragmentActivity) getContext(), new GlobalCashierCVVPresenter$netError$1(this));
    }

    public void appUpgrade() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void customError(GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(globalCashierDialogCommonConfig, "config");
        Intrinsics.checkNotNullParameter(api, "api");
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
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
                GlobalCashierCVVPresenter.m15806a(GlobalCashierCVVPresenter.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15806a(GlobalCashierCVVPresenter globalCashierCVVPresenter, boolean z, long j) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(globalCashierCVVPresenter, "this$0");
        if (globalCashierCVVPresenter.f21667b.isVisible()) {
            globalCashierCVVPresenter = null;
        }
        if (globalCashierCVVPresenter != null) {
            Context context = globalCashierCVVPresenter.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                GlobalCashierLoadingView globalCashierLoadingView = globalCashierCVVPresenter.f21667b;
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
        this.f21667b.dismissAllowingStateLoss();
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r5 = this;
            java.util.List r0 = r5.f21666a
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x001d
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder r3 = (com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder) r3
            boolean r3 = r3 instanceof com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB
            if (r3 == 0) goto L_0x000a
            goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder r1 = (com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder) r1
            boolean r0 = r1 instanceof com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB
            if (r0 != 0) goto L_0x0025
            r1 = r2
        L_0x0025:
            com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB r1 = (com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB) r1
            com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder r1 = (com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder) r1
            com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB r1 = (com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB) r1
            if (r1 != 0) goto L_0x002f
            r0 = r2
            goto L_0x0033
        L_0x002f:
            java.lang.String r0 = r1.getCvvContent()
        L_0x0033:
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r1 = new com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils
            java.lang.String r3 = "fin_cvvcomponent_cvv_ck"
            r1.<init>(r3)
            com.didi.global.fintech.cashier.model.net.request.CVVCardInfo r3 = r5.f21668c
            if (r3 != 0) goto L_0x0040
            r3 = r2
            goto L_0x0044
        L_0x0040:
            java.lang.String r3 = r3.getCard_prefix()
        L_0x0044:
            java.lang.String r4 = "payment_card_id"
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r1 = r1.addParam(r4, r3)
            if (r0 != 0) goto L_0x004f
            r0 = 0
            goto L_0x0053
        L_0x004f:
            int r0 = r0.length()
        L_0x0053:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "inputed_amount"
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r0 = r1.addParam(r3, r0)
            r0.send()
            org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
            com.didi.global.fintech.cashier.threeds.event.CvvNotifyEvent r1 = new com.didi.global.fintech.cashier.threeds.event.CvvNotifyEvent
            r1.<init>(r2)
            r0.post(r1)
            android.content.Context r0 = r5.getContext()
            boolean r1 = r0 instanceof androidx.fragment.app.FragmentActivity
            if (r1 == 0) goto L_0x0077
            r2 = r0
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2
        L_0x0077:
            if (r2 != 0) goto L_0x007a
            goto L_0x007d
        L_0x007a:
            r2.finish()
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.threeds.cvv.GlobalCashierCVVPresenter.onBackPressed():void");
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfirmClick() {
        /*
            r7 = this;
            java.util.List r0 = r7.f21666a
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x001d
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder r3 = (com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder) r3
            boolean r3 = r3 instanceof com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB
            if (r3 == 0) goto L_0x000a
            goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder r1 = (com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder) r1
            boolean r0 = r1 instanceof com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB
            if (r0 != 0) goto L_0x0025
            r1 = r2
        L_0x0025:
            com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB r1 = (com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB) r1
            com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder r1 = (com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVBaseViewBinder) r1
            com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB r1 = (com.didi.global.fintech.cashier.threeds.viewbinder.cvv.GlobalCashierCVVContentVB) r1
            if (r1 != 0) goto L_0x002f
            r0 = r2
            goto L_0x0033
        L_0x002f:
            java.lang.String r0 = r1.getCvvContent()
        L_0x0033:
            org.greenrobot.eventbus.EventBus r1 = org.greenrobot.eventbus.EventBus.getDefault()
            com.didi.global.fintech.cashier.threeds.event.CvvNotifyEvent r3 = new com.didi.global.fintech.cashier.threeds.event.CvvNotifyEvent
            com.didi.global.fintech.cashier.model.net.response.EncryptInfo r4 = r7.f21669d
            java.lang.String r5 = ""
            if (r4 != 0) goto L_0x0041
        L_0x003f:
            r4 = r5
            goto L_0x0048
        L_0x0041:
            java.lang.String r4 = r4.getKey()
            if (r4 != 0) goto L_0x0048
            goto L_0x003f
        L_0x0048:
            com.didi.global.fintech.cashier.model.net.response.EncryptInfo r6 = r7.f21669d
            if (r6 != 0) goto L_0x004d
            goto L_0x0055
        L_0x004d:
            java.lang.String r6 = r6.getIv()
            if (r6 != 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r5 = r6
        L_0x0055:
            java.lang.String r4 = com.didi.global.fintech.cashier.core.utils.AESUtils.CbcEncrypt(r0, r4, r5)
            r3.<init>(r4)
            r1.post(r3)
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r1 = new com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils
            java.lang.String r3 = "fin_cvvcomponent_cvv_ck"
            r1.<init>(r3)
            com.didi.global.fintech.cashier.model.net.request.CVVCardInfo r3 = r7.f21668c
            if (r3 != 0) goto L_0x006c
            r3 = r2
            goto L_0x0070
        L_0x006c:
            java.lang.String r3 = r3.getCard_prefix()
        L_0x0070:
            java.lang.String r4 = "payment_card_id"
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r1 = r1.addParam(r4, r3)
            if (r0 != 0) goto L_0x007b
            r0 = 0
            goto L_0x007f
        L_0x007b:
            int r0 = r0.length()
        L_0x007f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "inputed_amount"
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r0 = r1.addParam(r3, r0)
            r0.send()
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r0 = new com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils
            java.lang.String r1 = "fin_cvvcomponent_button_ck"
            r0.<init>(r1)
            com.didi.global.fintech.cashier.model.net.request.CVVCardInfo r1 = r7.f21668c
            if (r1 != 0) goto L_0x0099
            r1 = r2
            goto L_0x009d
        L_0x0099:
            java.lang.String r1 = r1.getCard_prefix()
        L_0x009d:
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r0 = r0.addParam(r4, r1)
            java.lang.String r1 = "button_name"
            java.lang.String r3 = "confirm"
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils r0 = r0.addParam(r1, r3)
            r0.send()
            android.content.Context r0 = r7.getContext()
            boolean r1 = r0 instanceof androidx.fragment.app.FragmentActivity
            if (r1 == 0) goto L_0x00b7
            r2 = r0
            androidx.fragment.app.FragmentActivity r2 = (androidx.fragment.app.FragmentActivity) r2
        L_0x00b7:
            if (r2 != 0) goto L_0x00ba
            goto L_0x00bd
        L_0x00ba:
            r2.finish()
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.threeds.cvv.GlobalCashierCVVPresenter.onConfirmClick():void");
    }
}
