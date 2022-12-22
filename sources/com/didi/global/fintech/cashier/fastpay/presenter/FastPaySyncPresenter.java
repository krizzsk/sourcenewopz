package com.didi.global.fintech.cashier.fastpay.presenter;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierDialogProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierSyncStatusProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayPresenter;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBinderPresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySyncPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.FailedInfo;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.model.net.response.PaymentSuggest;
import com.didi.global.fintech.cashier.model.strategy.SyncStatusStrategy;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogBaseConfig;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCommonConfig;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogFactory;
import com.didi.global.fintech.cashier.p117ui.widget.GlobalCashierLoadingView;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierLaunchListener;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002<=B\u0015\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0012\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)H\u0016J\u001a\u0010*\u001a\u00020\u00102\u0006\u0010 \u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010%H\u0016J\u0018\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020%H\u0016J\u0010\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020%H\u0016J\b\u00102\u001a\u00020\u0010H\u0016J\u0010\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00102\u0006\u00104\u001a\u000205H\u0016J\u001a\u00107\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010%2\u0006\u00108\u001a\u00020%H\u0016J\u001a\u00109\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010%2\u0006\u00108\u001a\u00020%H\u0016J\b\u0010:\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020%H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPaySyncPresenter;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBinderPresenter;", "Ljava/lang/Void;", "Lcom/didi/global/fintech/cashier/core/api/ICashierOperateProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierDialogProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierSyncStatusProcessor;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionHandleCallback;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySyncPresenter;", "context", "Landroid/content/Context;", "callback", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;", "(Landroid/content/Context;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;)V", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "appUpgrade", "", "customError", "config", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCommonConfig;", "api", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "dismissLoading", "loading", "cancelable", "", "duration", "", "netError", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onAdyenThreeDSSuccess", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "onBind", "onCardBind", "cardIndex", "", "onCardVerify", "onCashierClose", "payResult", "", "onCybsThreeDSSuccess", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "cvv", "onPasswordFailed", "status", "desc", "onPasswordSuccess", "token", "onPixPaid", "onSyncFail", "response", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "onSyncSuccess", "onThreeDSCancel", "type", "onThreeDSFailed", "onTopUp", "syncStatusScene", "FastPaySyncDialogType", "FastPaySyncDialogTypeCallback", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPaySyncPresenter.kt */
public final class FastPaySyncPresenter extends GlobalCashierBinderPresenter<Void> implements ICashierDialogProcessor, ICashierOperateProcessor, ICashierSyncStatusProcessor, IGlobalCashierActionHandleCallback, IFastPaySyncPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final IGlobalCashierCallback f21587a;

    /* renamed from: b */
    private final GlobalCashierLoadingView f21588b = GlobalCashierLoadingView.Companion.newInstance$default(GlobalCashierLoadingView.Companion, false, 1, (Object) null);

    public void appUpgrade() {
    }

    public void customError(GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(globalCashierDialogCommonConfig, "config");
        Intrinsics.checkNotNullParameter(api, "api");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPaySyncPresenter(Context context, IGlobalCashierCallback iGlobalCashierCallback) {
        super(context, "", "NATIVE", (IGlobalCashierActionInterceptCallback) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iGlobalCashierCallback, "callback");
        this.f21587a = iGlobalCashierCallback;
    }

    public String syncStatusScene() {
        return IGlobalCashierPayPresenter.SyncStatusScene.FAST_PAY.name();
    }

    public void onBind() {
        super.onBind();
        ICashierBaseProcessor iCashierBaseProcessor = this;
        registerProcessor(iCashierBaseProcessor, ICashierSyncStatusProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierOperateProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierDialogProcessor.class);
        startSyncPayResult(new SyncStatusStrategy(0, 0, SyncStatusStrategy.Companion.getFastPay(), 3, (DefaultConstructorMarker) null));
    }

    public void onSyncSuccess(PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
        if (Intrinsics.areEqual((Object) payStatusResponse.getNeedPollingResult(), (Object) true)) {
            Integer pollingTimes = payStatusResponse.getPollingTimes();
            int intValue = pollingTimes == null ? 10 : pollingTimes.intValue();
            Integer pollingFrequency = payStatusResponse.getPollingFrequency();
            startSyncPayResult(new SyncStatusStrategy(intValue, pollingFrequency == null ? 3 : pollingFrequency.intValue(), SyncStatusStrategy.Companion.getNormal()));
        } else if (Intrinsics.areEqual((Object) payStatusResponse.getPayStatus(), (Object) "success")) {
            this.f21587a.onClose(1);
        }
    }

    public void onSyncFail(PayStatusResponse payStatusResponse) {
        String str;
        String str2;
        PayStatusResponse payStatusResponse2 = payStatusResponse;
        Intrinsics.checkNotNullParameter(payStatusResponse2, "response");
        dismissLoading();
        SystemUtils.log(4, "Arirus", "onSyncFail: XXXX", (Throwable) null, "com.didi.global.fintech.cashier.fastpay.presenter.FastPaySyncPresenter", 79);
        List<PaymentSuggest> suggest = payStatusResponse.getSuggest();
        PaymentSuggest paymentSuggest = suggest == null ? null : (PaymentSuggest) CollectionsKt.getOrNull(suggest, 0);
        List<PaymentSuggest> suggest2 = payStatusResponse.getSuggest();
        PaymentSuggest paymentSuggest2 = suggest2 == null ? null : (PaymentSuggest) CollectionsKt.getOrNull(suggest2, 1);
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.CENTER;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = GlobalCashierDialogCommonConfig.PAYMENT_FAILED;
        FailedInfo failedInfo = payStatusResponse.getFailedInfo();
        globalCashierDialogCommonConfig.setTitle(failedInfo == null ? null : failedInfo.getTitle());
        FailedInfo failedInfo2 = payStatusResponse.getFailedInfo();
        globalCashierDialogCommonConfig.setSubTitle(failedInfo2 == null ? null : failedInfo2.getMessage());
        if (paymentSuggest == null) {
            str = null;
        } else {
            str = paymentSuggest.getMessage();
        }
        globalCashierDialogCommonConfig.setPositiveText(str);
        if (paymentSuggest2 == null) {
            str2 = null;
        } else {
            str2 = paymentSuggest2.getMessage();
        }
        globalCashierDialogCommonConfig.setNegativeText(str2);
        Unit unit = Unit.INSTANCE;
        GlobalCashierDialogCallback[] globalCashierDialogCallbackArr = new GlobalCashierDialogCallback[2];
        GlobalCashierDialogBaseConfig globalCashierDialogBaseConfig = globalCashierDialogCommonConfig;
        globalCashierDialogCallbackArr[0] = new FastPaySyncDialogTypeCallback(FastPaySyncDialogType.Companion.value(paymentSuggest == null ? null : paymentSuggest.getType()), (Object) null, new FastPaySyncPresenter$onSyncFail$2(this, payStatusResponse2, paymentSuggest), 2, (DefaultConstructorMarker) null);
        globalCashierDialogCallbackArr[1] = new FastPaySyncDialogTypeCallback(FastPaySyncDialogType.Companion.value(paymentSuggest2 == null ? null : paymentSuggest2.getType()), (Object) null, new FastPaySyncPresenter$onSyncFail$3(this, payStatusResponse2, paymentSuggest2), 2, (DefaultConstructorMarker) null);
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogBaseConfig, globalCashierDialogCallbackArr);
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
                FastPaySyncPresenter.m15788a(FastPaySyncPresenter.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15788a(FastPaySyncPresenter fastPaySyncPresenter, boolean z, long j) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(fastPaySyncPresenter, "this$0");
        if (fastPaySyncPresenter.f21588b.isVisible()) {
            fastPaySyncPresenter = null;
        }
        if (fastPaySyncPresenter != null) {
            Context context = fastPaySyncPresenter.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                GlobalCashierLoadingView globalCashierLoadingView = fastPaySyncPresenter.f21588b;
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
        this.f21588b.dismissAllowingStateLoss();
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPaySyncPresenter$FastPaySyncDialogType;", "", "(Ljava/lang/String;I)V", "FastpayToCashier", "Cancel", "Companion", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPaySyncPresenter.kt */
    private enum FastPaySyncDialogType {
        FastpayToCashier,
        Cancel;
        
        public static final Companion Companion = null;

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPaySyncPresenter$FastPaySyncDialogType$Companion;", "", "()V", "value", "Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPaySyncPresenter$FastPaySyncDialogType;", "", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: FastPaySyncPresenter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final FastPaySyncDialogType value(String str) {
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
                    return FastPaySyncDialogType.valueOf(sb2);
                } catch (Exception unused) {
                    return null;
                }
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\bH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPaySyncPresenter$FastPaySyncDialogTypeCallback;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCallback;", "type", "Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPaySyncPresenter$FastPaySyncDialogType;", "data", "", "omega", "Lkotlin/Function0;", "", "(Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPaySyncPresenter;Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPaySyncPresenter$FastPaySyncDialogType;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "getData", "()Ljava/lang/Object;", "getOmega", "()Lkotlin/jvm/functions/Function0;", "getType", "()Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPaySyncPresenter$FastPaySyncDialogType;", "onBtnClick", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPaySyncPresenter.kt */
    private final class FastPaySyncDialogTypeCallback implements GlobalCashierDialogCallback {
        private final Object data;
        private final Function0<Unit> omega;
        private final FastPaySyncDialogType type;

        @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: FastPaySyncPresenter.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FastPaySyncDialogType.values().length];
                iArr[FastPaySyncDialogType.FastpayToCashier.ordinal()] = 1;
                iArr[FastPaySyncDialogType.Cancel.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public FastPaySyncDialogTypeCallback(FastPaySyncPresenter fastPaySyncPresenter, FastPaySyncDialogType fastPaySyncDialogType, Object obj, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(fastPaySyncPresenter, "this$0");
            FastPaySyncPresenter.this = fastPaySyncPresenter;
            this.type = fastPaySyncDialogType;
            this.data = obj;
            this.omega = function0;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FastPaySyncDialogTypeCallback(FastPaySyncDialogType fastPaySyncDialogType, Object obj, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(FastPaySyncPresenter.this, fastPaySyncDialogType, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : function0);
        }

        public final FastPaySyncDialogType getType() {
            return this.type;
        }

        public final Object getData() {
            return this.data;
        }

        public final Function0<Unit> getOmega() {
            return this.omega;
        }

        public void onBtnClick() {
            Function0<Unit> function0 = this.omega;
            if (function0 != null) {
                function0.invoke();
            }
            FastPaySyncDialogType fastPaySyncDialogType = this.type;
            int i = fastPaySyncDialogType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[fastPaySyncDialogType.ordinal()];
            if (i == 1) {
                CashierFacade.Companion.getInstance().launchForResult((Activity) (FragmentActivity) FastPaySyncPresenter.this.getContext(), 69, CashierParam.Companion.insByOutTradeId(FastPaySyncPresenter.this.getMOutTradeId()), (CashierLaunchListener) null);
            } else if (i != 2) {
                FastPaySyncPresenter.this.f21587a.onClose(2);
            } else {
                FastPaySyncPresenter.this.f21587a.onClose(2);
            }
        }
    }

    public void onCardBind(String str) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onCardVerify(String str) {
        CashierAction cashierAction;
        String str2 = str;
        if (str2 == null) {
            cashierAction = null;
        } else {
            getMSelectPayments().clear();
            List<Payment> mSelectPayments = getMSelectPayments();
            Payment payment = r3;
            Payment payment2 = new Payment((String) null, (String) null, (String) null, (String) null, (String) null, (Payment.BalanceInfo) null, false, false, false, (Payment.InstallmentVo) null, (List) null, (List) null, (CashierAction) null, 0, 16383, (DefaultConstructorMarker) null);
            payment.setChannelId(150);
            cashierAction = null;
            Payment.ExtraInfo extraInfo = new Payment.ExtraInfo((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
            extraInfo.setCardIndex(str2);
            Unit unit = Unit.INSTANCE;
            payment.setExtraInfo(extraInfo);
            Unit unit2 = Unit.INSTANCE;
            mSelectPayments.add(payment);
        }
        doPay(cashierAction);
    }

    public void onTopUp() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onPixPaid() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onCashierClose(int i) {
        this.f21587a.onClose(i);
    }

    public void onAdyenThreeDSSuccess(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        Intrinsics.checkNotNullParameter(globalCashierAdyen3DSModel, "data");
        request3DSDetails(globalCashierAdyen3DSModel);
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
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogCommonConfig, new FastPaySyncDialogTypeCallback(FastPaySyncDialogType.FastpayToCashier, (Object) null, (Function0) null, 6, (DefaultConstructorMarker) null));
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
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogCommonConfig, new FastPaySyncDialogTypeCallback(FastPaySyncDialogType.Cancel, (Object) null, (Function0) null, 6, (DefaultConstructorMarker) null));
    }

    public void onPasswordSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        updatePasswordToken(str);
    }

    public void onPasswordFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "desc");
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.CENTER;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = GlobalCashierDialogCommonConfig.PAYMENT_FAILED;
        globalCashierDialogCommonConfig.setSubTitle(str2);
        Unit unit = Unit.INSTANCE;
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogCommonConfig, new FastPaySyncDialogTypeCallback(FastPaySyncDialogType.Cancel, (Object) null, (Function0) null, 6, (DefaultConstructorMarker) null));
    }

    public void netError(CashierError cashierError, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(cashierError, "error");
        Intrinsics.checkNotNullParameter(api, "api");
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.CENTER;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = GlobalCashierDialogCommonConfig.PAYMENT_FAILED;
        globalCashierDialogCommonConfig.setSubTitle(cashierError.getMessage());
        Unit unit = Unit.INSTANCE;
        globalCashierDialogFactory.showDialog(context, type, globalCashierDialogCommonConfig, new FastPaySyncDialogTypeCallback(FastPaySyncDialogType.Cancel, (Object) null, (Function0) null, 6, (DefaultConstructorMarker) null));
    }
}
