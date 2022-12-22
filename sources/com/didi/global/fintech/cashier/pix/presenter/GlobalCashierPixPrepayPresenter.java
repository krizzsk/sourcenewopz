package com.didi.global.fintech.cashier.pix.presenter;

import android.content.Context;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierPayInfoProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalPixPrepayCashierPresenter;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBinderPresenter;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.strategy.BaseStrategy;
import com.didi.global.fintech.cashier.model.strategy.PayInfoStrategy;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J \u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/presenter/GlobalCashierPixPrepayPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalPixPrepayCashierPresenter;", "Lcom/didi/global/fintech/cashier/core/api/ICashierPayInfoProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierOperateProcessor;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBinderPresenter;", "Ljava/lang/Void;", "context", "Landroid/content/Context;", "uniqueId", "", "callback", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;)V", "dismissLoading", "", "loading", "cancelable", "", "duration", "", "onBind", "onPayInfoSuccess", "strategy", "Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "response", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "API", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPixPrepayPresenter.kt */
public final class GlobalCashierPixPrepayPresenter extends GlobalCashierBinderPresenter<Void> implements ICashierOperateProcessor, ICashierPayInfoProcessor, IGlobalPixPrepayCashierPresenter {

    /* renamed from: a */
    private final IGlobalCashierCallback f21649a;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierPixPrepayPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BaseStrategy.Result.values().length];
            iArr[BaseStrategy.Result.SUCCESS.ordinal()] = 1;
            iArr[BaseStrategy.Result.FAILED.ordinal()] = 2;
            iArr[BaseStrategy.Result.CONTINUE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierPixPrepayPresenter(Context context, String str, IGlobalCashierCallback iGlobalCashierCallback) {
        super(context, str, (String) null, (IGlobalCashierActionInterceptCallback) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "uniqueId");
        Intrinsics.checkNotNullParameter(iGlobalCashierCallback, "callback");
        this.f21649a = iGlobalCashierCallback;
    }

    public void onBind() {
        SystemUtils.log(4, "Arirus", "GlobalCashierPresenter onBind: ", (Throwable) null, "com.didi.global.fintech.cashier.pix.presenter.GlobalCashierPixPrepayPresenter", 26);
        super.onBind();
        requestPayInfo(new PayInfoStrategy(0, PayInfoStrategy.Companion.getPix(), 1, (DefaultConstructorMarker) null));
    }

    public void loading(boolean z, long j) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void dismissLoading() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onPayInfoSuccess(PayInfoStrategy payInfoStrategy, PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(payInfoStrategy, "strategy");
        Intrinsics.checkNotNullParameter(payInfoResponse, "response");
        Intrinsics.checkNotNullParameter(api, "API");
        int i = WhenMappings.$EnumSwitchMapping$0[payInfoStrategy.handle(payInfoResponse).ordinal()];
        if (i == 1) {
            SystemUtils.log(4, "Arirus", "process: Success", (Throwable) null, "com.didi.global.fintech.cashier.pix.presenter.GlobalCashierPixPrepayPresenter", 47);
        } else if (i == 2) {
            SystemUtils.log(4, "Arirus", "process: Failed", (Throwable) null, "com.didi.global.fintech.cashier.pix.presenter.GlobalCashierPixPrepayPresenter", 48);
        } else if (i == 3) {
            requestPayInfo(payInfoStrategy);
        }
    }
}
