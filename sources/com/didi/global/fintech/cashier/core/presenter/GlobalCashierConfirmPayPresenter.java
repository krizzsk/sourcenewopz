package com.didi.global.fintech.cashier.core.presenter;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierDialogProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierPrepayProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierConfirmPay;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.core.utils.PayInfoManager;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogBaseConfig;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCommonConfig;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogFactory;
import com.didi.global.fintech.cashier.p117ui.widget.GlobalCashierLoadingView;
import com.didi.sdk.util.UiThreadHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002&'B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\u001a\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010#\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierConfirmPayPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierConfirmPay;", "Lcom/didi/global/fintech/cashier/core/api/ICashierOperateProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierPrepayProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierDialogProcessor;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBizPresenter;", "context", "Landroid/content/Context;", "uniqueId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "appUpgrade", "", "customError", "config", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCommonConfig;", "api", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "dismissLoading", "loading", "cancelable", "", "duration", "", "netError", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onBind", "onConfirmClick", "onPrePayFail", "errorCode", "", "msg", "onPrePaySuccess", "prepay", "Lcom/didi/global/fintech/cashier/model/net/response/PrepayResponse;", "GlobalCashierDialogType", "GlobalCashierDialogTypeCallback", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierConfirmPayPresenter.kt */
public final class GlobalCashierConfirmPayPresenter extends GlobalCashierBizPresenter implements ICashierDialogProcessor, ICashierOperateProcessor, ICashierPrepayProcessor, IGlobalCashierConfirmPay {

    /* renamed from: a */
    private final GlobalCashierLoadingView f21443a = GlobalCashierLoadingView.Companion.newInstance$default(GlobalCashierLoadingView.Companion, false, 1, (Object) null);

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierConfirmPayPresenter$GlobalCashierDialogType;", "", "(Ljava/lang/String;I)V", "ConfirmClose", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierConfirmPayPresenter.kt */
    private enum GlobalCashierDialogType {
        ConfirmClose
    }

    public void appUpgrade() {
    }

    public void onPrePaySuccess(PrepayResponse prepayResponse) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierConfirmPayPresenter(Context context, String str) {
        super(context, str, (String) null, (IGlobalCashierActionInterceptCallback) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onBind() {
        super.onBind();
        ICashierBaseProcessor iCashierBaseProcessor = this;
        registerProcessor(iCashierBaseProcessor, ICashierOperateProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierDialogProcessor.class);
        PayInfoResponse payInfo = PayInfoManager.getInstance().getPayInfo(getUniqueId());
        if (payInfo != null) {
            interceptPayInfo(payInfo);
        }
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
                GlobalCashierConfirmPayPresenter.m15725a(GlobalCashierConfirmPayPresenter.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15725a(GlobalCashierConfirmPayPresenter globalCashierConfirmPayPresenter, boolean z, long j) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(globalCashierConfirmPayPresenter, "this$0");
        if (globalCashierConfirmPayPresenter.f21443a.isVisible()) {
            globalCashierConfirmPayPresenter = null;
        }
        if (globalCashierConfirmPayPresenter != null) {
            Context context = globalCashierConfirmPayPresenter.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                GlobalCashierLoadingView globalCashierLoadingView = globalCashierConfirmPayPresenter.f21443a;
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
        this.f21443a.dismissAllowingStateLoss();
    }

    public void onConfirmClick() {
        updateBoletoConfirm();
    }

    public void onPrePayFail(int i, String str) {
        GlobalCashierDialogFactory.INSTANCE.showDialog(getContext(), GlobalCashierDialogFactory.TYPE.CENTER, GlobalCashierDialogCommonConfig.NET_ERROR, new GlobalCashierDialogCallback[0]);
    }

    public void netError(CashierError cashierError, IGlobalCashierNetPresenter.API api) {
        IGlobalCashierNetPresenter.API api2 = api;
        Intrinsics.checkNotNullParameter(cashierError, "error");
        Intrinsics.checkNotNullParameter(api2, "api");
        new RuntimeException().printStackTrace();
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.CENTER;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = GlobalCashierDialogCommonConfig.NET_ERROR;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig2 = cashierError.getMessage().length() > 0 ? globalCashierDialogCommonConfig : null;
        if (globalCashierDialogCommonConfig2 != null) {
            globalCashierDialogCommonConfig2.setSubTitle(cashierError.getMessage());
            globalCashierDialogCommonConfig2.setTitle(cashierError.getTitle());
        }
        Unit unit = Unit.INSTANCE;
        GlobalCashierDialogBaseConfig globalCashierDialogBaseConfig = globalCashierDialogCommonConfig;
        GlobalCashierDialogCallback[] globalCashierDialogCallbackArr = new GlobalCashierDialogCallback[1];
        globalCashierDialogCallbackArr[0] = new GlobalCashierDialogTypeCallback(GlobalCashierDialogType.ConfirmClose, 3, api2 == IGlobalCashierNetPresenter.API.GET_PAY_INFO, (Function0) null, 8, (DefaultConstructorMarker) null);
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogBaseConfig, globalCashierDialogCallbackArr);
        omegaNetworkErrorSw(String.valueOf(cashierError.getCode()));
    }

    public void customError(GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig, IGlobalCashierNetPresenter.API api) {
        GlobalCashierDialogFactory.TYPE type;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig2 = globalCashierDialogCommonConfig;
        IGlobalCashierNetPresenter.API api2 = api;
        Intrinsics.checkNotNullParameter(globalCashierDialogCommonConfig2, "config");
        Intrinsics.checkNotNullParameter(api2, "api");
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierConfirmPayPresenter globalCashierConfirmPayPresenter = this;
        boolean z = true;
        GlobalCashierDialogTypeCallback globalCashierDialogTypeCallback = null;
        if ((api2 == IGlobalCashierNetPresenter.API.GET_PAY_INFO ? this : null) == null) {
            type = null;
        } else {
            type = GlobalCashierDialogFactory.TYPE.BOTTOM;
        }
        if (type == null) {
            type = GlobalCashierDialogFactory.TYPE.CENTER;
        }
        GlobalCashierDialogFactory.TYPE type2 = type;
        GlobalCashierDialogBaseConfig globalCashierDialogBaseConfig = globalCashierDialogCommonConfig2;
        GlobalCashierDialogCallback[] globalCashierDialogCallbackArr = new GlobalCashierDialogCallback[1];
        if (api2 != IGlobalCashierNetPresenter.API.GET_PAY_INFO) {
            z = false;
        }
        GlobalCashierConfirmPayPresenter globalCashierConfirmPayPresenter2 = z ? this : null;
        if (globalCashierConfirmPayPresenter2 != null) {
            globalCashierDialogTypeCallback = new GlobalCashierDialogTypeCallback(GlobalCashierDialogType.ConfirmClose, 3, false, (Function0) null, 12, (DefaultConstructorMarker) null);
        }
        if (globalCashierDialogTypeCallback == null) {
            globalCashierDialogTypeCallback = new GlobalCashierDialogTypeCallback((GlobalCashierDialogType) null, (Object) null, false, (Function0) null, 14, (DefaultConstructorMarker) null);
        }
        globalCashierDialogCallbackArr[0] = globalCashierDialogTypeCallback;
        globalCashierDialogFactory.showDialog(context, type2, globalCashierDialogBaseConfig, globalCashierDialogCallbackArr);
        omegaOrderNotExistSw("0");
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\nH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierConfirmPayPresenter$GlobalCashierDialogTypeCallback;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCallback;", "type", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierConfirmPayPresenter$GlobalCashierDialogType;", "data", "", "condition", "", "omega", "Lkotlin/Function0;", "", "(Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierConfirmPayPresenter;Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierConfirmPayPresenter$GlobalCashierDialogType;Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;)V", "getCondition", "()Z", "getData", "()Ljava/lang/Object;", "getOmega", "()Lkotlin/jvm/functions/Function0;", "getType", "()Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierConfirmPayPresenter$GlobalCashierDialogType;", "onBtnClick", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierConfirmPayPresenter.kt */
    private final class GlobalCashierDialogTypeCallback implements GlobalCashierDialogCallback {
        private final boolean condition;
        private final Object data;
        private final Function0<Unit> omega;
        private final GlobalCashierDialogType type;

        public GlobalCashierDialogTypeCallback(GlobalCashierConfirmPayPresenter globalCashierConfirmPayPresenter, GlobalCashierDialogType globalCashierDialogType, Object obj, boolean z, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(globalCashierConfirmPayPresenter, "this$0");
            GlobalCashierConfirmPayPresenter.this = globalCashierConfirmPayPresenter;
            this.type = globalCashierDialogType;
            this.data = obj;
            this.condition = z;
            this.omega = function0;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GlobalCashierDialogTypeCallback(GlobalCashierDialogType globalCashierDialogType, Object obj, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(GlobalCashierConfirmPayPresenter.this, globalCashierDialogType, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : function0);
        }

        public final GlobalCashierDialogType getType() {
            return this.type;
        }

        public final Object getData() {
            return this.data;
        }

        public final boolean getCondition() {
            return this.condition;
        }

        public final Function0<Unit> getOmega() {
            return this.omega;
        }

        public void onBtnClick() {
            Function0<Unit> function0 = this.omega;
            if (function0 != null) {
                function0.invoke();
            }
            if (!this.condition) {
            }
        }
    }
}
