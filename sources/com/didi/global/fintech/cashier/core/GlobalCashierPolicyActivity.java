package com.didi.global.fintech.cashier.core;

import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyView;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierPolicyPresenter;
import com.didi.global.fintech.cashier.core.view.GlobalCashierPolicyView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/GlobalCashierPolicyActivity;", "Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyView;", "()V", "getPresenter", "getView", "layoutRes", "", "onBackPressed", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPolicyActivity.kt */
public final class GlobalCashierPolicyActivity extends BaseCashierActivity<IGlobalCashierPolicyPresenter, IGlobalCashierPolicyView> {
    public int layoutRes() {
        return R.layout.activity_global_cashier_main;
    }

    public IGlobalCashierPolicyPresenter getPresenter() {
        return new GlobalCashierPolicyPresenter(this, getMUniqueId());
    }

    public IGlobalCashierPolicyView getView() {
        View findViewById = findViewById(R.id.activity_cashier_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.activity_cashier_root_view)");
        return new GlobalCashierPolicyView(this, (ViewGroup) findViewById);
    }

    public void onBackPressed() {
        IGlobalCashierPolicyPresenter iGlobalCashierPolicyPresenter = (IGlobalCashierPolicyPresenter) getMPresenter();
        if (iGlobalCashierPolicyPresenter != null) {
            iGlobalCashierPolicyPresenter.onBackPressed("key");
        }
    }
}
