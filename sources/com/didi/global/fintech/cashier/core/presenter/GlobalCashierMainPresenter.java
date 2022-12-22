package com.didi.global.fintech.cashier.core.presenter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.global.fintech.cashier.core.GlobalCashierPlansInfoActivity;
import com.didi.global.fintech.cashier.core.api.ICashier3DSProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierDialogProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierPayInfoProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierPrepayProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierResultProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierSyncStatusProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCardChannelViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierMerchantResponseHandler;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayBtnViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierThirdChannelViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierView;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.core.interceptor.BaseRouterAdapter;
import com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor;
import com.didi.global.fintech.cashier.core.interceptor.ExitConfirmInterceptor;
import com.didi.global.fintech.cashier.core.interceptor.ResultRouterAdapter;
import com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor;
import com.didi.global.fintech.cashier.core.utils.CashierAppUtils;
import com.didi.global.fintech.cashier.core.utils.PayInfoManager;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierCardChannelViewBinder;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierFeeViewBinder;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierHeaderViewBinder;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierPayBtnViewBinder;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierThirdChannelViewBinder;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.model.net.response.OrderInfo;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.model.net.response.PaymentThreeDSDetailsResponse;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import com.didi.global.fintech.cashier.model.net.response.ShowInfo;
import com.didi.global.fintech.cashier.model.strategy.PayInfoStrategy;
import com.didi.global.fintech.cashier.p117ui.IGlobalCashierPayBtnViewHolder;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogBaseConfig;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCommonConfig;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogFactory;
import com.didi.global.fintech.cashier.p117ui.kts.ContextKtxKt;
import com.didi.global.fintech.cashier.p117ui.kts.JsonKtxKt;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.p117ui.viewholder.FeeHelpInfo;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.InstallmentVo;
import com.didi.global.fintech.cashier.p117ui.widget.GlobalCashierLoadingView;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\b\u0012\u0004\u0012\u00020\u000b0\n:\u0002klB'\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u0002042\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00105\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u00106\u001a\u00020\u001d2\b\u00107\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u00108\u001a\u00020\u001dH\u0016J\b\u00109\u001a\u00020\u001dH\u0016J\u0012\u0010:\u001a\u00020\u001d2\b\u0010;\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010<\u001a\u00020\u001d2\b\u0010;\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0016J\u001a\u0010>\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010A\u001a\u00020\u001dH\u0016J\b\u0010B\u001a\u00020\u001dH\u0016J\u0012\u0010C\u001a\u00020\u001d2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J!\u0010F\u001a\u00020\u001d2\b\u0010;\u001a\u0004\u0018\u00010\u000f2\b\u0010G\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0002\u0010HJ\u0018\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u000fH\u0016J\u0010\u0010L\u001a\u00020\u001d2\u0006\u0010M\u001a\u00020\u000fH\u0016J\b\u0010N\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020QH\u0016J \u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020(H\u0016J\b\u0010W\u001a\u00020\u001dH\u0016J\u001a\u0010X\u001a\u00020\u001d2\b\u0010;\u001a\u0004\u0018\u00010\u000f2\u0006\u0010Y\u001a\u00020ZH\u0016J\u001a\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020,2\b\u0010]\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010^\u001a\u00020\u001d2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020bH\u0016J\u001a\u0010d\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u00010\u000f2\u0006\u00107\u001a\u00020\u000fH\u0016J\u001a\u0010e\u001a\u00020\u001d2\b\u00103\u001a\u0004\u0018\u00010\u000f2\u0006\u00107\u001a\u00020\u000fH\u0016J\b\u0010f\u001a\u00020\u001dH\u0016J\u0010\u0010g\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020jH\u0016R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierMainPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/core/api/ICashierOperateProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierPayInfoProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierResultProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierPrepayProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierDialogProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierSyncStatusProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashier3DSProcessor;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionHandleCallback;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBinderPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "context", "Landroid/content/Context;", "uniqueId", "", "actionInterceptCallback", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "callback", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;)V", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "merchantResponseHandler", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierMerchantResponseHandler;", "kotlin.jvm.PlatformType", "IView", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierView;", "adyenActionHandle", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "appUpgrade", "bindView", "view", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "customError", "config", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCommonConfig;", "api", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "dismissLoading", "doClose", "payResult", "", "loading", "cancelable", "", "duration", "", "netError", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onAdyenThreeDSSuccess", "onBackPressed", "type", "onBind", "onBindCardClick", "onCardBind", "cardIndex", "onCardVerify", "onCashierClose", "onCybsThreeDSSuccess", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "cvv", "onGoSignUp", "onGoTopUp", "onHelpIconClick", "helpInfo", "Lcom/didi/global/fintech/cashier/ui/viewholder/FeeHelpInfo;", "onInstallmentClick", "number", "(Ljava/lang/String;Ljava/lang/Integer;)V", "onPasswordFailed", "status", "desc", "onPasswordSuccess", "token", "onPayBtnClick", "onPayChannelClick", "d", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "onPayInfoSuccess", "strategy", "Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "response", "API", "onPixPaid", "onPlansClick", "vo", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo;", "onPrePayFail", "errorCode", "msg", "onPrePaySuccess", "prepay", "Lcom/didi/global/fintech/cashier/model/net/response/PrepayResponse;", "onSyncFail", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "onSyncSuccess", "onThreeDSCancel", "onThreeDSFailed", "onTopUp", "payment3DSDetailProcess", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "successInfoProcess", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "GlobalCashierDialogType", "GlobalCashierDialogTypeCallback", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierMainPresenter.kt */
public final class GlobalCashierMainPresenter extends GlobalCashierBinderPresenter<PayInfoResponse> implements ICashier3DSProcessor, ICashierDialogProcessor, ICashierOperateProcessor, ICashierPayInfoProcessor, ICashierPrepayProcessor, ICashierResultProcessor, ICashierSyncStatusProcessor, IGlobalCashierActionHandleCallback, IGlobalMainCashierPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final IGlobalCashierCallback f21444a;

    /* renamed from: b */
    private final GlobalCashierLoadingView f21445b = GlobalCashierLoadingView.Companion.newInstance$default(GlobalCashierLoadingView.Companion, false, 1, (Object) null);

    /* renamed from: c */
    private final IGlobalCashierMerchantResponseHandler f21446c = ((IGlobalCashierMerchantResponseHandler) ServiceLoader.load(IGlobalCashierMerchantResponseHandler.class).get());

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierMainPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IGlobalCashierNetPresenter.API.values().length];
            iArr[IGlobalCashierNetPresenter.API.GET_PAY_INFO.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void onPasswordFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "desc");
    }

    public void onPrePaySuccess(PrepayResponse prepayResponse) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierMainPresenter(Context context, String str, IGlobalCashierActionInterceptCallback iGlobalCashierActionInterceptCallback, IGlobalCashierCallback iGlobalCashierCallback) {
        super(context, str, (String) null, iGlobalCashierActionInterceptCallback);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iGlobalCashierActionInterceptCallback, "actionInterceptCallback");
        Intrinsics.checkNotNullParameter(iGlobalCashierCallback, "callback");
        this.f21444a = iGlobalCashierCallback;
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        super.bindView(iGlobalCashierBaseView);
        GlobalCashierHeaderViewBinder globalCashierHeaderViewBinder = new GlobalCashierHeaderViewBinder(this);
        IGlobalCashierView IView = IView();
        IGlobalCashierPayBtnViewHolder iGlobalCashierPayBtnViewHolder = null;
        globalCashierHeaderViewBinder.viewBind(IView == null ? null : IView.headerView());
        IGlobalMainCashierPresenter iGlobalMainCashierPresenter = this;
        GlobalCashierFeeViewBinder globalCashierFeeViewBinder = new GlobalCashierFeeViewBinder(iGlobalMainCashierPresenter);
        IGlobalCashierView IView2 = IView();
        globalCashierFeeViewBinder.viewBind(IView2 == null ? null : IView2.feeView());
        GlobalCashierCardChannelViewBinder globalCashierCardChannelViewBinder = new GlobalCashierCardChannelViewBinder(iGlobalMainCashierPresenter);
        IGlobalCashierView IView3 = IView();
        globalCashierCardChannelViewBinder.viewBind(IView3 == null ? null : IView3.cardChannelView());
        GlobalCashierThirdChannelViewBinder globalCashierThirdChannelViewBinder = new GlobalCashierThirdChannelViewBinder(iGlobalMainCashierPresenter);
        IGlobalCashierView IView4 = IView();
        globalCashierThirdChannelViewBinder.viewBind(IView4 == null ? null : IView4.thirdChannelView());
        GlobalCashierPayBtnViewBinder globalCashierPayBtnViewBinder = new GlobalCashierPayBtnViewBinder(iGlobalMainCashierPresenter);
        IGlobalCashierView IView5 = IView();
        if (IView5 != null) {
            iGlobalCashierPayBtnViewHolder = IView5.payBtnView();
        }
        globalCashierPayBtnViewBinder.viewBind(iGlobalCashierPayBtnViewHolder);
        SystemUtils.log(4, "Arirus", "GlobalCashierPresenter bindView: ", (Throwable) null, "com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter", 78);
    }

    public void onBind() {
        super.onBind();
        SystemUtils.log(4, "Arirus", "GlobalCashierPresenter onBind: 开始网络请求", (Throwable) null, "com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter", 83);
        ICashierBaseProcessor iCashierBaseProcessor = this;
        registerProcessor(iCashierBaseProcessor, ICashierOperateProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierPayInfoProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierResultProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierPrepayProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierSyncStatusProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierDialogProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashier3DSProcessor.class);
        requestPayInfo(new PayInfoStrategy(0, PayInfoStrategy.Companion.getNormal(), 1, (DefaultConstructorMarker) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.didi.global.fintech.cashier.model.net.response.Payment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.didi.global.fintech.cashier.model.net.response.Payment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.didi.global.fintech.cashier.model.net.response.Payment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.didi.global.fintech.cashier.model.net.response.Payment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.didi.global.fintech.cashier.model.net.response.Payment} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPayChannelClick(com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData r10) {
        /*
            r9 = this;
            java.lang.String r0 = "d"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r10.getSelected()
            if (r0 == 0) goto L_0x0014
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation r0 = r10.getOperatorType()
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation r1 = com.didi.global.fintech.cashier.p117ui.viewholder.item.ChannelItemViewHolderData.Operation.OPERATION_SWITCH
            if (r0 == r1) goto L_0x0014
            return
        L_0x0014:
            com.didi.global.fintech.cashier.core.utils.PayInfoManager r0 = com.didi.global.fintech.cashier.core.utils.PayInfoManager.getInstance()
            java.lang.String r1 = r9.getUniqueId()
            com.didi.global.fintech.cashier.model.net.response.PayInfoResponse r0 = r0.getPayInfo(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            r2 = 0
            if (r0 != 0) goto L_0x002b
            goto L_0x007d
        L_0x002b:
            java.util.List r3 = r0.getPaymentGroups()
            if (r3 != 0) goto L_0x0032
            goto L_0x007d
        L_0x0032:
            r4 = 0
            java.lang.Object r3 = kotlin.collections.CollectionsKt.getOrNull(r3, r4)
            com.didi.global.fintech.cashier.model.net.response.PaymentGroup r3 = (com.didi.global.fintech.cashier.model.net.response.PaymentGroup) r3
            if (r3 != 0) goto L_0x003c
            goto L_0x007d
        L_0x003c:
            java.util.List r3 = r3.getPayments()
            if (r3 != 0) goto L_0x0043
            goto L_0x007d
        L_0x0043:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0049:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007b
            java.lang.Object r5 = r3.next()
            r6 = r5
            com.didi.global.fintech.cashier.model.net.response.Payment r6 = (com.didi.global.fintech.cashier.model.net.response.Payment) r6
            java.lang.Integer r7 = r6.getChannelId()
            r8 = 120(0x78, float:1.68E-43)
            if (r7 != 0) goto L_0x005f
            goto L_0x0065
        L_0x005f:
            int r7 = r7.intValue()
            if (r7 == r8) goto L_0x0077
        L_0x0065:
            java.lang.Integer r6 = r6.getChannelId()
            r7 = 190(0xbe, float:2.66E-43)
            if (r6 != 0) goto L_0x006e
            goto L_0x0075
        L_0x006e:
            int r6 = r6.intValue()
            if (r6 != r7) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r6 = 0
            goto L_0x0078
        L_0x0077:
            r6 = 1
        L_0x0078:
            if (r6 == 0) goto L_0x0049
            r2 = r5
        L_0x007b:
            com.didi.global.fintech.cashier.model.net.response.Payment r2 = (com.didi.global.fintech.cashier.model.net.response.Payment) r2
        L_0x007d:
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$onPayChannelClick$1 r3 = new com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$onPayChannelClick$1
            r3.<init>(r10, r9, r2)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r9.getPaymentsFromPayInfo(r0, r1, r3)
            boolean r10 = r1.isEmpty()
            if (r10 == 0) goto L_0x008e
            return
        L_0x008e:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r0 = r1.iterator()
        L_0x009b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b8
            java.lang.Object r1 = r0.next()
            com.didi.global.fintech.cashier.model.net.response.Payment r1 = (com.didi.global.fintech.cashier.model.net.response.Payment) r1
            com.didi.global.fintech.cashier.model.net.response.BasicPayment r2 = new com.didi.global.fintech.cashier.model.net.response.BasicPayment
            java.lang.Integer r3 = r1.getChannelId()
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r1 = r1.getExtraInfo()
            r2.<init>(r3, r1)
            r10.add(r2)
            goto L_0x009b
        L_0x00b8:
            r9.refreshPayInfo(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter.onPayChannelClick(com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData):void");
    }

    public void onBindCardClick() {
        CashierActionInterceptor actionInterceptor = getActionInterceptor();
        if (actionInterceptor != null) {
            actionInterceptor.intercept(getContext(), CashierAction.Companion.insAddCard(getMProductId(), getMAppId()), (Function0<Unit>[]) new Function0[]{new GlobalCashierMainPresenter$onBindCardClick$1(this)});
        }
        omegaAddCardCk(getMProductId(), getMAppId());
    }

    public void onGoTopUp() {
        CashierActionInterceptor actionInterceptor = getActionInterceptor();
        if (actionInterceptor != null) {
            actionInterceptor.intercept(getContext(), CashierAction.Companion.insTopUp(getOmegaAttr(GlobalCashierBizPresenter.OMEGA_ATTR_PUB_SOURCE)), (Function0<Unit>[]) new Function0[]{new GlobalCashierMainPresenter$onGoTopUp$1(this)});
        }
        omegaCheckoutTopUpCk();
    }

    public void onGoSignUp() {
        CashierActionInterceptor actionInterceptor = getActionInterceptor();
        if (actionInterceptor != null) {
            actionInterceptor.intercept(getContext(), CashierAction.Companion.insSignUp(), (Function0<Unit>[]) new Function0[]{new GlobalCashierMainPresenter$onGoSignUp$1(this)});
        }
        omegaCheckoutTopUpCk();
    }

    public void onCardBind(String str) {
        List arrayList = new ArrayList();
        Payment.ExtraInfo extraInfo = new Payment.ExtraInfo((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
        extraInfo.setCardIndex(str);
        Unit unit = Unit.INSTANCE;
        arrayList.add(new BasicPayment(150, extraInfo));
        Unit unit2 = Unit.INSTANCE;
        refreshPayInfo(arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0043 A[EDGE_INSN: B:27:0x0043->B:19:0x0043 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCardVerify(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            goto L_0x0052
        L_0x0004:
            java.util.List r1 = r8.getMSelectPayments()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x000e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0042
            java.lang.Object r2 = r1.next()
            r3 = r2
            com.didi.global.fintech.cashier.model.net.response.Payment r3 = (com.didi.global.fintech.cashier.model.net.response.Payment) r3
            java.lang.Integer r4 = r3.getChannelId()
            r5 = 150(0x96, float:2.1E-43)
            r6 = 1
            r7 = 0
            if (r4 != 0) goto L_0x0026
            goto L_0x003e
        L_0x0026:
            int r4 = r4.intValue()
            if (r4 != r5) goto L_0x003e
            com.didi.global.fintech.cashier.model.net.request.CashierAction r3 = r3.getSelectAction()
            if (r3 != 0) goto L_0x0034
        L_0x0032:
            r3 = 0
            goto L_0x003b
        L_0x0034:
            boolean r3 = r3.updateCardInfo()
            if (r3 != r6) goto L_0x0032
            r3 = 1
        L_0x003b:
            if (r3 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r6 = 0
        L_0x003f:
            if (r6 == 0) goto L_0x000e
            goto L_0x0043
        L_0x0042:
            r2 = r0
        L_0x0043:
            com.didi.global.fintech.cashier.model.net.response.Payment r2 = (com.didi.global.fintech.cashier.model.net.response.Payment) r2
            if (r2 != 0) goto L_0x0048
            goto L_0x0052
        L_0x0048:
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r1 = r2.getExtraInfo()
            if (r1 != 0) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            r1.setCardIndex(r9)
        L_0x0052:
            r8.doPay(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter.onCardVerify(java.lang.String):void");
    }

    public void onTopUp() {
        List arrayList = new ArrayList();
        if (CashierFacade.Companion.getInstance().getTheme().global()) {
            arrayList.add(new BasicPayment(120, (Payment.ExtraInfo) null, 2, (DefaultConstructorMarker) null));
        } else if (CashierFacade.Companion.getInstance().getTheme().brazil()) {
            arrayList.add(new BasicPayment(190, (Payment.ExtraInfo) null, 2, (DefaultConstructorMarker) null));
        } else {
            arrayList.add(new BasicPayment(190, (Payment.ExtraInfo) null, 2, (DefaultConstructorMarker) null));
        }
        Unit unit = Unit.INSTANCE;
        refreshPayInfo(arrayList);
    }

    public void onPayBtnClick() {
        CashierAction cashierAction;
        Object obj;
        boolean z;
        Iterator it = getMSelectPayments().iterator();
        while (true) {
            cashierAction = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Payment) obj).getSelectAction() != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Payment payment = (Payment) obj;
        if (payment != null) {
            cashierAction = payment.getSelectAction();
        }
        doPay(cashierAction);
        omegaPayCk(getMSelectPayments());
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
                GlobalCashierMainPresenter.m15727a(GlobalCashierMainPresenter.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15727a(GlobalCashierMainPresenter globalCashierMainPresenter, boolean z, long j) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(globalCashierMainPresenter, "this$0");
        if (globalCashierMainPresenter.f21445b.isVisible()) {
            globalCashierMainPresenter = null;
        }
        if (globalCashierMainPresenter != null) {
            Context context = globalCashierMainPresenter.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                GlobalCashierLoadingView globalCashierLoadingView = globalCashierMainPresenter.f21445b;
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
        this.f21445b.dismissAllowingStateLoss();
    }

    public void onPayInfoSuccess(PayInfoStrategy payInfoStrategy, PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(payInfoStrategy, "strategy");
        Intrinsics.checkNotNullParameter(payInfoResponse, "response");
        Intrinsics.checkNotNullParameter(api, "API");
        for (IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder : getViewBinders()) {
            iGlobalCashierBaseViewBinder.setupView(payInfoResponse);
        }
        IGlobalCashierView IView = IView();
        if (IView != null) {
            IView.setupView(payInfoResponse);
        }
        GlobalCashierMainPresenter globalCashierMainPresenter = this;
        GlobalCashierMainPresenter globalCashierMainPresenter2 = api == IGlobalCashierNetPresenter.API.GET_PAY_INFO ? this : null;
        if (globalCashierMainPresenter2 != null) {
            ShowInfo showInfo = payInfoResponse.getShowInfo();
            globalCashierMainPresenter2.omegaCheckoutSw(showInfo == null ? null : showInfo.getPayButtonEnable(), globalCashierMainPresenter2.getMAppId(), JsonKtxKt.toJson$default(payInfoResponse, (Type) null, 1, (Object) null));
            for (Payment omegaPayMethodCk : globalCashierMainPresenter2.getMSelectPayments()) {
                globalCashierMainPresenter2.omegaPayMethodCk(omegaPayMethodCk, 1);
            }
        }
    }

    public void onPrePayFail(int i, String str) {
        GlobalCashierDialogFactory.INSTANCE.showDialog(getContext(), GlobalCashierDialogFactory.TYPE.CENTER, GlobalCashierDialogCommonConfig.NET_ERROR, new GlobalCashierDialogCallback[0]);
    }

    public void onSyncSuccess(PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
        RouterOpenInterceptor routerInterceptor = getRouterInterceptor();
        if (routerInterceptor != null) {
            routerInterceptor.intercept(getContext(), (BaseRouterAdapter<?>) new ResultRouterAdapter(payStatusResponse), (Function0<Unit>[]) new Function0[]{new GlobalCashierMainPresenter$onSyncSuccess$1(this), new GlobalCashierMainPresenter$onSyncSuccess$2(this)});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        if ((r0 == null || r0.isEmpty()) != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        if ((r0 == null || r0.isEmpty()) != false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        r15 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSyncFail(com.didi.global.fintech.cashier.model.net.response.PayStatusResponse r27) {
        /*
            r26 = this;
            r8 = r26
            r9 = r27
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.List r0 = r27.getSuggest()
            r10 = 0
            if (r0 != 0) goto L_0x0013
            r12 = 0
            goto L_0x001a
        L_0x0013:
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r0, r10)
            com.didi.global.fintech.cashier.model.net.response.PaymentSuggest r0 = (com.didi.global.fintech.cashier.model.net.response.PaymentSuggest) r0
            r12 = r0
        L_0x001a:
            java.util.List r0 = r27.getSuggest()
            r13 = 1
            if (r0 != 0) goto L_0x0023
            r14 = 0
            goto L_0x002a
        L_0x0023:
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r0, r13)
            com.didi.global.fintech.cashier.model.net.response.PaymentSuggest r0 = (com.didi.global.fintech.cashier.model.net.response.PaymentSuggest) r0
            r14 = r0
        L_0x002a:
            if (r12 == 0) goto L_0x0040
            java.util.List r0 = r12.getChannels()
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x003d
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r0 = 0
            goto L_0x003e
        L_0x003d:
            r0 = 1
        L_0x003e:
            if (r0 == 0) goto L_0x0057
        L_0x0040:
            if (r14 == 0) goto L_0x0059
            java.util.List r0 = r14.getChannels()
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0053
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r0 = 0
            goto L_0x0054
        L_0x0053:
            r0 = 1
        L_0x0054:
            if (r0 == 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r15 = 0
            goto L_0x005a
        L_0x0059:
            r15 = 1
        L_0x005a:
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogFactory r7 = com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogFactory.INSTANCE
            android.content.Context r6 = r26.getContext()
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogFactory$TYPE r5 = com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogFactory.TYPE.BOTTOM
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCommonConfig r0 = com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCommonConfig.PAYMENT_FAILED
            com.didi.global.fintech.cashier.model.net.response.FailedInfo r1 = r27.getFailedInfo()
            if (r1 != 0) goto L_0x006c
            r1 = 0
            goto L_0x0070
        L_0x006c:
            java.lang.String r1 = r1.getTitle()
        L_0x0070:
            r0.setTitle(r1)
            com.didi.global.fintech.cashier.model.net.response.FailedInfo r1 = r27.getFailedInfo()
            if (r1 != 0) goto L_0x007b
            r1 = 0
            goto L_0x007f
        L_0x007b:
            java.lang.String r1 = r1.getMessage()
        L_0x007f:
            r0.setSubTitle(r1)
            if (r12 != 0) goto L_0x0086
            r1 = 0
            goto L_0x008a
        L_0x0086:
            java.lang.String r1 = r12.getMessage()
        L_0x008a:
            r0.setPositiveText(r1)
            if (r14 != 0) goto L_0x0091
            r1 = 0
            goto L_0x0095
        L_0x0091:
            java.lang.String r1 = r14.getMessage()
        L_0x0095:
            r0.setNegativeText(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r4 = r0
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogBaseConfig r4 = (com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogBaseConfig) r4
            r0 = 2
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback[] r3 = new com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback[r0]
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogTypeCallback r16 = new com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogTypeCallback
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogType$Companion r0 = com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter.GlobalCashierDialogType.Companion
            if (r12 != 0) goto L_0x00a8
            r1 = 0
            goto L_0x00ac
        L_0x00a8:
            java.lang.String r1 = r12.getType()
        L_0x00ac:
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogType r2 = r0.value(r1)
            if (r12 != 0) goto L_0x00b5
            r17 = 0
            goto L_0x00bb
        L_0x00b5:
            java.util.List r0 = r12.getChannels()
            r17 = r0
        L_0x00bb:
            r18 = 0
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$onSyncFail$2 r0 = new com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$onSyncFail$2
            r0.<init>(r15, r8, r9, r12)
            r19 = r0
            kotlin.jvm.functions.Function0 r19 = (kotlin.jvm.functions.Function0) r19
            r20 = 4
            r21 = 0
            r0 = r16
            r1 = r26
            r11 = r3
            r3 = r17
            r22 = r4
            r4 = r18
            r23 = r5
            r5 = r19
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r21
            r0.<init>(r2, r3, r4, r5, r6, r7)
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback r16 = (com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback) r16
            r11[r10] = r16
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogTypeCallback r10 = new com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogTypeCallback
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogType$Companion r0 = com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter.GlobalCashierDialogType.Companion
            if (r14 != 0) goto L_0x00f0
            r1 = 0
            goto L_0x00f4
        L_0x00f0:
            java.lang.String r1 = r14.getType()
        L_0x00f4:
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogType r2 = r0.value(r1)
            if (r14 != 0) goto L_0x00fc
            r3 = 0
            goto L_0x0101
        L_0x00fc:
            java.util.List r0 = r14.getChannels()
            r3 = r0
        L_0x0101:
            r4 = 0
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$onSyncFail$3 r0 = new com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$onSyncFail$3
            r0.<init>(r8, r9, r12)
            r5 = r0
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r6 = 4
            r7 = 0
            r0 = r10
            r1 = r26
            r0.<init>(r2, r3, r4, r5, r6, r7)
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback r10 = (com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback) r10
            r11[r13] = r10
            r3 = r22
            r2 = r23
            r1 = r24
            r0 = r25
            r0.showDialog(r1, r2, r3, r11)
            java.lang.String r0 = "pay_method"
            java.lang.String r1 = "error_code"
            if (r15 == 0) goto L_0x0150
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Map r2 = (java.util.Map) r2
            com.didi.global.fintech.cashier.model.net.response.FailedInfo r3 = r27.getFailedInfo()
            if (r3 != 0) goto L_0x0137
            r3 = 0
            goto L_0x013b
        L_0x0137:
            java.lang.Integer r3 = r3.getCode()
        L_0x013b:
            r2.put(r1, r3)
            java.util.List r1 = r26.getMSelectPayments()
            r3 = 0
            java.lang.String r1 = com.didi.global.fintech.cashier.p117ui.kts.JsonKtxKt.toJson$default(r1, r3, r13, r3)
            r2.put(r0, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r8.omegaFailNoDrawerSw(r2)
            goto L_0x0189
        L_0x0150:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Map r2 = (java.util.Map) r2
            com.didi.global.fintech.cashier.model.net.response.FailedInfo r3 = r27.getFailedInfo()
            if (r3 != 0) goto L_0x015f
            r3 = 0
            goto L_0x0163
        L_0x015f:
            java.lang.Integer r3 = r3.getCode()
        L_0x0163:
            r2.put(r1, r3)
            java.util.List r1 = r26.getMSelectPayments()
            r3 = 0
            java.lang.String r1 = com.didi.global.fintech.cashier.p117ui.kts.JsonKtxKt.toJson$default(r1, r3, r13, r3)
            r2.put(r0, r1)
            java.util.List r0 = r27.getSuggest()
            if (r0 != 0) goto L_0x017a
            r11 = r3
            goto L_0x017e
        L_0x017a:
            java.lang.String r11 = com.didi.global.fintech.cashier.p117ui.kts.JsonKtxKt.toJson$default(r0, r3, r13, r3)
        L_0x017e:
            java.lang.String r0 = "rcmd_method"
            r2.put(r0, r11)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r8.omegaFailDrawerSw(r2)
        L_0x0189:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter.onSyncFail(com.didi.global.fintech.cashier.model.net.response.PayStatusResponse):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
        r5 = r5.getActualAmount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void successInfoProcess(com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse r17) {
        /*
            r16 = this;
            java.lang.String r0 = "response"
            r1 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r16.omegaCheckoutPaySuccessSw()
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogFactory r0 = com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogFactory.INSTANCE
            android.content.Context r2 = r16.getContext()
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogFactory$TYPE r3 = com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogFactory.TYPE.SUCCESS
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogSuccessConfig r4 = com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogSuccessConfig.PAYMENT_SUCCESS
            com.didi.global.fintech.cashier.model.net.response.ResultPriceInfo r5 = r17.getPriceInfo()
            r6 = 0
            if (r5 != 0) goto L_0x001e
        L_0x001c:
            r5 = r6
            goto L_0x0029
        L_0x001e:
            com.didi.global.fintech.cashier.model.net.response.PriceAmount r5 = r5.getActualAmount()
            if (r5 != 0) goto L_0x0025
            goto L_0x001c
        L_0x0025:
            java.lang.String r5 = r5.symbol()
        L_0x0029:
            r4.setSymbol(r5)
            com.didi.global.fintech.cashier.model.net.response.ResultPriceInfo r5 = r17.getPriceInfo()
            if (r5 != 0) goto L_0x0034
        L_0x0032:
            r5 = r6
            goto L_0x003f
        L_0x0034:
            com.didi.global.fintech.cashier.model.net.response.PriceAmount r5 = r5.getActualAmount()
            if (r5 != 0) goto L_0x003b
            goto L_0x0032
        L_0x003b:
            java.lang.String r5 = r5.price()
        L_0x003f:
            r4.setPrice(r5)
            com.didi.global.fintech.cashier.model.net.response.ResultPriceInfo r1 = r17.getPriceInfo()
            if (r1 != 0) goto L_0x0049
            goto L_0x004d
        L_0x0049:
            java.lang.String r6 = r1.additionalMessages()
        L_0x004d:
            r4.setTipContent(r6)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogBaseConfig r4 = (com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogBaseConfig) r4
            r1 = 1
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback[] r5 = new com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback[r1]
            r6 = 0
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogTypeCallback r15 = new com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogTypeCallback
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$GlobalCashierDialogType r9 = com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter.GlobalCashierDialogType.ConfirmClose
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)
            r11 = 0
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$successInfoProcess$2 r1 = new com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter$successInfoProcess$2
            r14 = r16
            r1.<init>(r14)
            r12 = r1
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r13 = 4
            r1 = 0
            r7 = r15
            r8 = r16
            r14 = r1
            r7.<init>(r9, r10, r11, r12, r13, r14)
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback r15 = (com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback) r15
            r5[r6] = r15
            r0.showDialog(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter.successInfoProcess(com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse):void");
    }

    public void onBackPressed(String str) {
        ShowInfo showInfo;
        omegaCheckoutReturnCk();
        ExitConfirmInterceptor instance = ExitConfirmInterceptor.Companion.getInstance();
        Context context = getContext();
        PayInfoResponse payInfo = PayInfoManager.getInstance().getPayInfo(getUniqueId());
        ShowInfo.CancelConfirm cancelConfirm = null;
        if (!(payInfo == null || (showInfo = payInfo.getShowInfo()) == null)) {
            cancelConfirm = showInfo.getCancelConfirm();
        }
        instance.intercept(context, cancelConfirm, (Function0<Unit>[]) new Function0[]{new GlobalCashierMainPresenter$onBackPressed$1(this), new GlobalCashierMainPresenter$onBackPressed$2(this), new GlobalCashierMainPresenter$onBackPressed$3(this), new GlobalCashierMainPresenter$onBackPressed$4(this)});
    }

    public void onHelpIconClick(FeeHelpInfo feeHelpInfo) {
        String str;
        omegaTransactionFeeCk();
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.BOTTOM;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = GlobalCashierDialogCommonConfig.CUSTOM_ERROR;
        String str2 = null;
        if (feeHelpInfo == null) {
            str = null;
        } else {
            str = feeHelpInfo.getTitle();
        }
        globalCashierDialogCommonConfig.setTitle(str);
        if (feeHelpInfo != null) {
            str2 = feeHelpInfo.getMessage();
        }
        globalCashierDialogCommonConfig.setSubTitle(str2);
        globalCashierDialogCommonConfig.setPositiveText(ContextKtxKt.string(getContext(), R.string.GRider_Interest_Got_it_LERY));
        Unit unit = Unit.INSTANCE;
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogCommonConfig, new GlobalCashierDialogCallback[0]);
    }

    public void onPlansClick(String str, InstallmentVo installmentVo) {
        Intrinsics.checkNotNullParameter(installmentVo, "vo");
        omegaAllInstallmentCk();
        IGlobalCashierCallback iGlobalCashierCallback = this.f21444a;
        Intent intent = new Intent(getContext(), GlobalCashierPlansInfoActivity.class);
        intent.putExtra("card_index", str);
        intent.putExtra(GlobalCashierPlansInfoActivity.PARAM_INSTALLMENT_PLANS, installmentVo);
        Unit unit = Unit.INSTANCE;
        iGlobalCashierCallback.onCallStartActivityForResult(intent, 300);
    }

    public void onInstallmentClick(String str, Integer num) {
        omegaChangeInstallmentCk(num);
        List arrayList = new ArrayList();
        BasicPayment basicPayment = new BasicPayment((Integer) null, (Payment.ExtraInfo) null, 3, (DefaultConstructorMarker) null);
        basicPayment.setChannelId(150);
        Payment.ExtraInfo extraInfo = new Payment.ExtraInfo((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
        extraInfo.setCardIndex(str);
        extraInfo.setInstallmentNumber(num);
        Unit unit = Unit.INSTANCE;
        basicPayment.setExtraInfo(extraInfo);
        Unit unit2 = Unit.INSTANCE;
        arrayList.add(basicPayment);
        Unit unit3 = Unit.INSTANCE;
        refreshPayInfo(arrayList);
    }

    public void onPixPaid() {
        requestSuccessInfo();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r4 = r4.getAction();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void adyenActionHandle(com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel r4) {
        /*
            r3 = this;
            java.lang.String r0 = r3.getMOrderId()
            r1 = 0
            if (r4 != 0) goto L_0x0009
        L_0x0007:
            r4 = r1
            goto L_0x0017
        L_0x0009:
            java.util.Map r4 = r4.getAction()
            if (r4 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r2 = "type"
            java.lang.Object r4 = r4.get(r2)
        L_0x0017:
            boolean r2 = r4 instanceof java.lang.String
            if (r2 == 0) goto L_0x001e
            r1 = r4
            java.lang.String r1 = (java.lang.String) r1
        L_0x001e:
            com.didi.global.fintech.cashier.ui.omega.CashierOmegaUtils$Companion r4 = com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils.Companion
            java.lang.String r4 = r4.getUid()
            r3.omega3dsVerifySt(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierMainPresenter.adyenActionHandle(com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel):void");
    }

    public void onAdyenThreeDSSuccess(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        Intrinsics.checkNotNullParameter(globalCashierAdyen3DSModel, "data");
        request3DSDetails(globalCashierAdyen3DSModel);
        omega3dsVerifyResultSt(getMOrderId(), CashierOmegaUtils.Companion.getUid(), globalCashierAdyen3DSModel.getAuth_details(), "", "", 0);
    }

    public void payment3DSDetailProcess(PaymentThreeDSDetailsResponse paymentThreeDSDetailsResponse) {
        Integer threeDSResult;
        Intrinsics.checkNotNullParameter(paymentThreeDSDetailsResponse, "response");
        String mOrderId = getMOrderId();
        String uid = CashierOmegaUtils.Companion.getUid();
        CashierAction nextStep = paymentThreeDSDetailsResponse.getNextStep();
        int i = 0;
        if (!(nextStep == null || (threeDSResult = nextStep.threeDSResult()) == null || threeDSResult.intValue() != 0)) {
            i = 1;
        }
        omega3dsVerifyServerSt(mOrderId, uid, Integer.valueOf(i ^ 1));
    }

    public void onCybsThreeDSSuccess(PrepayRequest.ThreeDSV2 threeDSV2, String str) {
        Intrinsics.checkNotNullParameter(threeDSV2, "data");
        updateCybs3DS(threeDSV2, str);
    }

    public void onThreeDSFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        dismissLoading();
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.CENTER;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = GlobalCashierDialogCommonConfig.PAYMENT_FAILED;
        globalCashierDialogCommonConfig.setSubTitle(str);
        Unit unit = Unit.INSTANCE;
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogCommonConfig, new GlobalCashierDialogCallback[0]);
        GlobalCashierMainPresenter globalCashierMainPresenter = this;
        GlobalCashierMainPresenter globalCashierMainPresenter2 = Intrinsics.areEqual((Object) str2, (Object) CashierAction.ACTION_THREE_DS) ? this : null;
        if (globalCashierMainPresenter2 != null) {
            globalCashierMainPresenter2.omega3dsVerifyResultSt(globalCashierMainPresenter2.getMOrderId(), CashierOmegaUtils.Companion.getUid(), "", str, str, 0);
        }
    }

    public void onThreeDSCancel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        dismissLoading();
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.CENTER;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = GlobalCashierDialogCommonConfig.PAYMENT_FAILED;
        globalCashierDialogCommonConfig.setSubTitle(str);
        Unit unit = Unit.INSTANCE;
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogCommonConfig, new GlobalCashierDialogCallback[0]);
        GlobalCashierMainPresenter globalCashierMainPresenter = this;
        GlobalCashierMainPresenter globalCashierMainPresenter2 = Intrinsics.areEqual((Object) str2, (Object) CashierAction.ACTION_THREE_DS) ? this : null;
        if (globalCashierMainPresenter2 != null) {
            globalCashierMainPresenter2.omega3dsVerifyResultSt(globalCashierMainPresenter2.getMOrderId(), CashierOmegaUtils.Companion.getUid(), "", "", "", 1);
        }
    }

    public void onPasswordSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        updatePasswordToken(str);
    }

    public void onCashierClose(int i) {
        m15726a(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m15726a(int i) {
        OrderInfo orderInfo;
        this.f21444a.onClose(i);
        IGlobalCashierMerchantResponseHandler iGlobalCashierMerchantResponseHandler = this.f21446c;
        if (iGlobalCashierMerchantResponseHandler != null) {
            Context context = getContext();
            Integer valueOf = Integer.valueOf(i);
            String fromType = getFromType();
            PayInfoResponse payInfo = PayInfoManager.getInstance().getPayInfo(getUniqueId());
            String str = null;
            if (!(payInfo == null || (orderInfo = payInfo.getOrderInfo()) == null)) {
                str = orderInfo.getReturnUrl();
            }
            iGlobalCashierMerchantResponseHandler.onHandle(context, valueOf, fromType, str);
        }
    }

    public IGlobalCashierView IView() {
        IGlobalCashierBaseView mView = getMView();
        if (mView instanceof IGlobalCashierView) {
            return (IGlobalCashierView) mView;
        }
        return null;
    }

    public void netError(CashierError cashierError, IGlobalCashierNetPresenter.API api) {
        GlobalCashierDialogFactory.TYPE type;
        IGlobalCashierView IView;
        IGlobalCashierNetPresenter.API api2 = api;
        Intrinsics.checkNotNullParameter(cashierError, "error");
        Intrinsics.checkNotNullParameter(api2, "api");
        new RuntimeException().printStackTrace();
        GlobalCashierMainPresenter globalCashierMainPresenter = this;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = null;
        if (!((api2 == IGlobalCashierNetPresenter.API.GET_PAY_INFO ? this : null) == null || (IView = IView()) == null)) {
            IView.showLogoView();
        }
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        if (WhenMappings.$EnumSwitchMapping$0[api.ordinal()] == 1) {
            type = GlobalCashierDialogFactory.TYPE.BOTTOM;
        } else {
            type = GlobalCashierDialogFactory.TYPE.CENTER;
        }
        GlobalCashierDialogFactory.TYPE type2 = type;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig2 = GlobalCashierDialogCommonConfig.NET_ERROR;
        if (cashierError.getMessage().length() > 0) {
            globalCashierDialogCommonConfig = globalCashierDialogCommonConfig2;
        }
        if (globalCashierDialogCommonConfig != null) {
            globalCashierDialogCommonConfig.setSubTitle(cashierError.getMessage());
            globalCashierDialogCommonConfig.setTitle(cashierError.getTitle());
        }
        Unit unit = Unit.INSTANCE;
        GlobalCashierDialogBaseConfig globalCashierDialogBaseConfig = globalCashierDialogCommonConfig2;
        GlobalCashierDialogCallback[] globalCashierDialogCallbackArr = new GlobalCashierDialogCallback[1];
        globalCashierDialogCallbackArr[0] = new GlobalCashierDialogTypeCallback(GlobalCashierDialogType.ConfirmClose, 3, api2 == IGlobalCashierNetPresenter.API.GET_PAY_INFO, (Function0) null, 8, (DefaultConstructorMarker) null);
        globalCashierDialogFactory.showDialog(context, type2, globalCashierDialogBaseConfig, globalCashierDialogCallbackArr);
        omegaNetworkErrorSw(String.valueOf(cashierError.getCode()));
    }

    public void appUpgrade() {
        IGlobalCashierView IView = IView();
        if (IView != null) {
            IView.showLogoView();
        }
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.BOTTOM;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = GlobalCashierDialogCommonConfig.APP_UPGRADE;
        globalCashierDialogCommonConfig.setSubTitle(getContext().getString(R.string.Wallet_App_V2_Please_click_TnDn, new Object[]{CashierAppUtils.INSTANCE.getAppName(getContext())}));
        Unit unit = Unit.INSTANCE;
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogCommonConfig, new GlobalCashierDialogTypeCallback(GlobalCashierDialogType.JumpStore, (Object) null, false, new GlobalCashierMainPresenter$appUpgrade$2(this), 6, (DefaultConstructorMarker) null), new GlobalCashierDialogTypeCallback(GlobalCashierDialogType.ConfirmClose, 2, false, new GlobalCashierMainPresenter$appUpgrade$3(this), 4, (DefaultConstructorMarker) null));
        omegaVersionUpdateSw();
    }

    public void customError(GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig, IGlobalCashierNetPresenter.API api) {
        GlobalCashierDialogFactory.TYPE type;
        IGlobalCashierView IView;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig2 = globalCashierDialogCommonConfig;
        IGlobalCashierNetPresenter.API api2 = api;
        Intrinsics.checkNotNullParameter(globalCashierDialogCommonConfig2, "config");
        Intrinsics.checkNotNullParameter(api2, "api");
        GlobalCashierMainPresenter globalCashierMainPresenter = this;
        boolean z = true;
        GlobalCashierDialogTypeCallback globalCashierDialogTypeCallback = null;
        if (!((api2 == IGlobalCashierNetPresenter.API.GET_PAY_INFO ? this : null) == null || (IView = IView()) == null)) {
            IView.showLogoView();
        }
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
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
        GlobalCashierMainPresenter globalCashierMainPresenter2 = z ? this : null;
        if (globalCashierMainPresenter2 != null) {
            globalCashierDialogTypeCallback = new GlobalCashierDialogTypeCallback(GlobalCashierDialogType.ConfirmClose, 3, false, (Function0) null, 12, (DefaultConstructorMarker) null);
        }
        if (globalCashierDialogTypeCallback == null) {
            globalCashierDialogTypeCallback = new GlobalCashierDialogTypeCallback((GlobalCashierDialogType) null, (Object) null, false, (Function0) null, 14, (DefaultConstructorMarker) null);
        }
        globalCashierDialogCallbackArr[0] = globalCashierDialogTypeCallback;
        globalCashierDialogFactory.showDialog(context, type2, globalCashierDialogBaseConfig, globalCashierDialogCallbackArr);
        omegaOrderNotExistSw("0");
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierMainPresenter$GlobalCashierDialogType;", "", "(Ljava/lang/String;I)V", "ConfirmClose", "JumpStore", "ChangeToChannel", "BindCard", "PayWithChannel", "BackToHomepage", "Companion", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierMainPresenter.kt */
    private enum GlobalCashierDialogType {
        ConfirmClose,
        JumpStore,
        ChangeToChannel,
        BindCard,
        PayWithChannel,
        BackToHomepage;
        
        public static final Companion Companion = null;

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierMainPresenter$GlobalCashierDialogType$Companion;", "", "()V", "value", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierMainPresenter$GlobalCashierDialogType;", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: GlobalCashierMainPresenter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final GlobalCashierDialogType value(String str) {
                if (str == null) {
                    return null;
                }
                Pattern compile = Pattern.compile("_");
                Intrinsics.checkNotNullExpressionValue(compile, "compile(\"_\")");
                List<CharSequence> split$default = StringsKt.split$default(str, compile, 0, 2, (Object) null);
                StringBuilder sb = new StringBuilder();
                for (CharSequence charSequence : split$default) {
                    Collection arrayList = new ArrayList(charSequence.length());
                    int i = 0;
                    int i2 = 0;
                    while (i < charSequence.length()) {
                        char charAt = charSequence.charAt(i);
                        int i3 = i2 + 1;
                        if (i2 == 0) {
                            charAt = Character.toUpperCase(charAt);
                        }
                        arrayList.add(Character.valueOf(charAt));
                        i++;
                        i2 = i3;
                    }
                    for (Character charValue : (List) arrayList) {
                        sb.append(charValue.charValue());
                    }
                }
                try {
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                    return GlobalCashierDialogType.valueOf(sb2);
                } catch (Exception unused) {
                    return null;
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\nH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierMainPresenter$GlobalCashierDialogTypeCallback;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCallback;", "type", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierMainPresenter$GlobalCashierDialogType;", "data", "", "condition", "", "omega", "Lkotlin/Function0;", "", "(Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierMainPresenter;Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierMainPresenter$GlobalCashierDialogType;Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;)V", "getCondition", "()Z", "getData", "()Ljava/lang/Object;", "getOmega", "()Lkotlin/jvm/functions/Function0;", "getType", "()Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierMainPresenter$GlobalCashierDialogType;", "onBtnClick", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierMainPresenter.kt */
    private final class GlobalCashierDialogTypeCallback implements GlobalCashierDialogCallback {
        private final boolean condition;
        private final Object data;
        private final Function0<Unit> omega;
        private final GlobalCashierDialogType type;

        @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: GlobalCashierMainPresenter.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[GlobalCashierDialogType.values().length];
                iArr[GlobalCashierDialogType.ConfirmClose.ordinal()] = 1;
                iArr[GlobalCashierDialogType.JumpStore.ordinal()] = 2;
                iArr[GlobalCashierDialogType.ChangeToChannel.ordinal()] = 3;
                iArr[GlobalCashierDialogType.BindCard.ordinal()] = 4;
                iArr[GlobalCashierDialogType.BackToHomepage.ordinal()] = 5;
                iArr[GlobalCashierDialogType.PayWithChannel.ordinal()] = 6;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public GlobalCashierDialogTypeCallback(GlobalCashierMainPresenter globalCashierMainPresenter, GlobalCashierDialogType globalCashierDialogType, Object obj, boolean z, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(globalCashierMainPresenter, "this$0");
            GlobalCashierMainPresenter.this = globalCashierMainPresenter;
            this.type = globalCashierDialogType;
            this.data = obj;
            this.condition = z;
            this.omega = function0;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GlobalCashierDialogTypeCallback(GlobalCashierDialogType globalCashierDialogType, Object obj, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(GlobalCashierMainPresenter.this, globalCashierDialogType, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : function0);
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
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Function0<Unit> function0 = this.omega;
            if (function0 != null) {
                function0.invoke();
                Unit unit = Unit.INSTANCE;
            }
            if (this.condition) {
                GlobalCashierDialogType globalCashierDialogType = this.type;
                boolean z = false;
                boolean z2 = true;
                Object obj6 = null;
                switch (globalCashierDialogType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[globalCashierDialogType.ordinal()]) {
                    case 1:
                        GlobalCashierDialogTypeCallback globalCashierDialogTypeCallback = this;
                        if ((getData() instanceof Integer ? this : null) != null) {
                            GlobalCashierMainPresenter globalCashierMainPresenter = GlobalCashierMainPresenter.this;
                            Object data2 = getData();
                            if (data2 != null) {
                                globalCashierMainPresenter.m15726a(((Integer) data2).intValue());
                                Unit unit2 = Unit.INSTANCE;
                                obj6 = Unit.INSTANCE;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                            }
                        }
                        if (obj6 == null) {
                            GlobalCashierMainPresenter.this.m15726a(2);
                            return;
                        }
                        return;
                    case 2:
                        try {
                            GlobalCashierMainPresenter.this.f21444a.onCallStartActivity(new Intent("android.intent.action.VIEW", Uri.parse(Intrinsics.stringPlus("market://details?id=", GlobalCashierMainPresenter.this.getContext().getPackageName()))));
                            return;
                        } catch (ActivityNotFoundException unused) {
                            GlobalCashierMainPresenter.this.f21444a.onCallStartActivity(new Intent("android.intent.action.VIEW", Uri.parse(Intrinsics.stringPlus("http://play.google.com/store/apps/details?id=", GlobalCashierMainPresenter.this.getContext().getPackageName()))));
                            return;
                        }
                    case 3:
                        GlobalCashierDialogTypeCallback globalCashierDialogTypeCallback2 = this;
                        if (!(getData() instanceof List) || !(!((Collection) getData()).isEmpty()) || !(CollectionsKt.firstOrNull((List) getData()) instanceof BasicPayment)) {
                            z2 = false;
                        }
                        GlobalCashierDialogTypeCallback globalCashierDialogTypeCallback3 = z2 ? this : null;
                        if (globalCashierDialogTypeCallback3 != null) {
                            GlobalCashierMainPresenter globalCashierMainPresenter2 = GlobalCashierMainPresenter.this;
                            IGlobalCashierView IView = globalCashierMainPresenter2.IView();
                            if (IView != null) {
                                IView.scrollTo(0);
                                Unit unit3 = Unit.INSTANCE;
                            }
                            Iterator it = globalCashierMainPresenter2.f21439a.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj = it.next();
                                    if (((IGlobalCashierBaseViewBinder) obj) instanceof IGlobalCashierCardChannelViewBinder) {
                                    }
                                } else {
                                    obj = null;
                                }
                            }
                            IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder = (IGlobalCashierBaseViewBinder) obj;
                            if (iGlobalCashierBaseViewBinder instanceof IGlobalCashierCardChannelViewBinder) {
                                obj6 = iGlobalCashierBaseViewBinder;
                            }
                            IGlobalCashierCardChannelViewBinder iGlobalCashierCardChannelViewBinder = (IGlobalCashierCardChannelViewBinder) obj6;
                            if (iGlobalCashierCardChannelViewBinder != null) {
                                Object data3 = globalCashierDialogTypeCallback3.getData();
                                if (data3 != null) {
                                    iGlobalCashierCardChannelViewBinder.topMethod((List) data3);
                                    Unit unit4 = Unit.INSTANCE;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.didi.global.fintech.cashier.model.net.response.BasicPayment>");
                                }
                            }
                            Object data4 = globalCashierDialogTypeCallback3.getData();
                            if (data4 != null) {
                                globalCashierMainPresenter2.refreshPayInfo((List) data4);
                                Unit unit5 = Unit.INSTANCE;
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.didi.global.fintech.cashier.model.net.response.BasicPayment>");
                        }
                        return;
                    case 4:
                        GlobalCashierMainPresenter.this.onBindCardClick();
                        return;
                    case 5:
                        Iterator it2 = GlobalCashierMainPresenter.this.f21439a.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                obj2 = it2.next();
                                if (((IGlobalCashierBaseViewBinder) obj2) instanceof IGlobalCashierCardChannelViewBinder) {
                                }
                            } else {
                                obj2 = null;
                            }
                        }
                        IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder2 = (IGlobalCashierBaseViewBinder) obj2;
                        if (!(iGlobalCashierBaseViewBinder2 instanceof IGlobalCashierCardChannelViewBinder)) {
                            iGlobalCashierBaseViewBinder2 = null;
                        }
                        IGlobalCashierCardChannelViewBinder iGlobalCashierCardChannelViewBinder2 = (IGlobalCashierCardChannelViewBinder) iGlobalCashierBaseViewBinder2;
                        if (iGlobalCashierCardChannelViewBinder2 != null) {
                            iGlobalCashierCardChannelViewBinder2.onSpreadClick((ChannelItemViewHolderData) null);
                            Unit unit6 = Unit.INSTANCE;
                        }
                        Iterator it3 = GlobalCashierMainPresenter.this.f21439a.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                obj3 = it3.next();
                                if (((IGlobalCashierBaseViewBinder) obj3) instanceof IGlobalCashierPayBtnViewBinder) {
                                }
                            } else {
                                obj3 = null;
                            }
                        }
                        IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder3 = (IGlobalCashierBaseViewBinder) obj3;
                        if (!(iGlobalCashierBaseViewBinder3 instanceof IGlobalCashierPayBtnViewBinder)) {
                            iGlobalCashierBaseViewBinder3 = null;
                        }
                        IGlobalCashierPayBtnViewBinder iGlobalCashierPayBtnViewBinder = (IGlobalCashierPayBtnViewBinder) iGlobalCashierBaseViewBinder3;
                        if (iGlobalCashierPayBtnViewBinder != null) {
                            iGlobalCashierPayBtnViewBinder.disableBtn();
                            Unit unit7 = Unit.INSTANCE;
                        }
                        Iterator it4 = GlobalCashierMainPresenter.this.f21439a.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                obj4 = it4.next();
                                if (((IGlobalCashierBaseViewBinder) obj4) instanceof IGlobalCashierCardChannelViewBinder) {
                                }
                            } else {
                                obj4 = null;
                            }
                        }
                        IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder4 = (IGlobalCashierBaseViewBinder) obj4;
                        if (!(iGlobalCashierBaseViewBinder4 instanceof IGlobalCashierCardChannelViewBinder)) {
                            iGlobalCashierBaseViewBinder4 = null;
                        }
                        IGlobalCashierCardChannelViewBinder iGlobalCashierCardChannelViewBinder3 = (IGlobalCashierCardChannelViewBinder) iGlobalCashierBaseViewBinder4;
                        if (iGlobalCashierCardChannelViewBinder3 != null) {
                            iGlobalCashierCardChannelViewBinder3.removeAllMethodSelect();
                            Unit unit8 = Unit.INSTANCE;
                        }
                        Iterator it5 = GlobalCashierMainPresenter.this.f21439a.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                obj5 = it5.next();
                                if (((IGlobalCashierBaseViewBinder) obj5) instanceof IGlobalCashierThirdChannelViewBinder) {
                                }
                            } else {
                                obj5 = null;
                            }
                        }
                        IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder5 = (IGlobalCashierBaseViewBinder) obj5;
                        if (iGlobalCashierBaseViewBinder5 instanceof IGlobalCashierThirdChannelViewBinder) {
                            obj6 = iGlobalCashierBaseViewBinder5;
                        }
                        IGlobalCashierThirdChannelViewBinder iGlobalCashierThirdChannelViewBinder = (IGlobalCashierThirdChannelViewBinder) obj6;
                        if (iGlobalCashierThirdChannelViewBinder != null) {
                            iGlobalCashierThirdChannelViewBinder.removeAllMethodSelect();
                            Unit unit9 = Unit.INSTANCE;
                        }
                        GlobalCashierMainPresenter.this.refreshPayInfo(new ArrayList());
                        return;
                    case 6:
                        GlobalCashierDialogTypeCallback globalCashierDialogTypeCallback4 = this;
                        if ((getData() instanceof List) && (!((Collection) getData()).isEmpty()) && (CollectionsKt.firstOrNull((List) getData()) instanceof BasicPayment)) {
                            z = true;
                        }
                        if (z) {
                            obj6 = this;
                        }
                        GlobalCashierDialogTypeCallback globalCashierDialogTypeCallback5 = (GlobalCashierDialogTypeCallback) obj6;
                        if (globalCashierDialogTypeCallback5 != null) {
                            GlobalCashierMainPresenter globalCashierMainPresenter3 = GlobalCashierMainPresenter.this;
                            PrepayRequest prepayRequest = new PrepayRequest((String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (PrepayRequest.ThirdParty) null, (Boolean) null, 255, (DefaultConstructorMarker) null);
                            String mOutTradeId = globalCashierMainPresenter3.getMOutTradeId();
                            if (mOutTradeId == null) {
                                mOutTradeId = "";
                            }
                            prepayRequest.setOut_trade_id(mOutTradeId);
                            String mPasswordToken = globalCashierMainPresenter3.getMPasswordToken();
                            if (mPasswordToken != null) {
                                prepayRequest.setPassword_token(mPasswordToken);
                                Unit unit10 = Unit.INSTANCE;
                                Unit unit11 = Unit.INSTANCE;
                            }
                            Boolean mBoletoConfirm = globalCashierMainPresenter3.getMBoletoConfirm();
                            if (mBoletoConfirm != null) {
                                prepayRequest.setPay_tip_confirmed(Boolean.valueOf(mBoletoConfirm.booleanValue()));
                                Unit unit12 = Unit.INSTANCE;
                                Unit unit13 = Unit.INSTANCE;
                            }
                            prepayRequest.setMerchant_wsgenv((String) globalCashierMainPresenter3.getParamByName(CashierParam.PARAM_MERCHANT_WSG_ENV));
                            List<BasicPayment> user_select = prepayRequest.getUser_select();
                            Object data5 = globalCashierDialogTypeCallback5.getData();
                            if (data5 != null) {
                                user_select.addAll((List) data5);
                                prepayRequest.getThird_party().setThree_ds_v2(globalCashierMainPresenter3.getMThreeDSV2());
                                Unit unit14 = Unit.INSTANCE;
                                globalCashierMainPresenter3.prePay(prepayRequest);
                                Unit unit15 = Unit.INSTANCE;
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.didi.global.fintech.cashier.model.net.response.BasicPayment>");
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
