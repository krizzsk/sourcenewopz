package com.didi.global.fintech.cashier.threeds.cvv;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.model.net.request.CVVCardInfo;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVPresenter;
import com.didi.global.fintech.cashier.threeds.contract.IGlobalCashierCVVView;
import com.didi.global.fintech.cashier.threeds.view.cvv.GlobalCashierCVVView;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/cvv/GlobalCashierCVVActivity;", "Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity;", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVPresenter;", "Lcom/didi/global/fintech/cashier/threeds/contract/IGlobalCashierCVVView;", "()V", "mCvvCardInfo", "Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "getPresenter", "getView", "layoutRes", "", "onBackPressed", "", "onParamInit", "onPresenterCreated", "Companion", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVActivity.kt */
public final class GlobalCashierCVVActivity extends BaseCashierActivity<IGlobalCashierCVVPresenter, IGlobalCashierCVVView> {
    public static final String ARGS_CARD_INFO = "card_info";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private CVVCardInfo f21665a;

    public int layoutRes() {
        return R.layout.activity_global_cashier_cvv;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/cvv/GlobalCashierCVVActivity$Companion;", "", "()V", "ARGS_CARD_INFO", "", "startIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "cardInfo", "Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "uniqueId", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GlobalCashierCVVActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent startIntent(Context context, CashierParam cashierParam, CVVCardInfo cVVCardInfo, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, GlobalCashierCVVActivity.class);
            if (cashierParam != null) {
                intent.putExtra("args_param", cashierParam);
            }
            if (cVVCardInfo != null) {
                intent.putExtra(GlobalCashierCVVActivity.ARGS_CARD_INFO, cVVCardInfo);
            }
            if (str != null) {
                intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, str);
            }
            return intent;
        }
    }

    public void onParamInit() {
        super.onParamInit();
        this.f21665a = (CVVCardInfo) getIntent().getSerializableExtra(ARGS_CARD_INFO);
    }

    public IGlobalCashierCVVPresenter getPresenter() {
        return new GlobalCashierCVVPresenter(this, getMUniqueId());
    }

    public IGlobalCashierCVVView getView() {
        View findViewById = findViewById(R.id.activity_cashier_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.activity_cashier_root_view)");
        return new GlobalCashierCVVView(this, (ViewGroup) findViewById);
    }

    public void onPresenterCreated() {
        super.onPresenterCreated();
        IGlobalCashierCVVPresenter iGlobalCashierCVVPresenter = (IGlobalCashierCVVPresenter) getMPresenter();
        if (iGlobalCashierCVVPresenter != null) {
            iGlobalCashierCVVPresenter.updateCardInfo(this.f21665a);
        }
    }

    public void onBackPressed() {
        IGlobalCashierCVVPresenter iGlobalCashierCVVPresenter = (IGlobalCashierCVVPresenter) getMPresenter();
        if (iGlobalCashierCVVPresenter != null) {
            iGlobalCashierCVVPresenter.onBackPressed();
        }
    }
}
