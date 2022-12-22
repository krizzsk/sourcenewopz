package com.didi.global.fintech.cashier.core;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierResultPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierResultView;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierResultPresenter;
import com.didi.global.fintech.cashier.core.view.GlobalCashierResultView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0016¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/GlobalCashierResultActivity;", "Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierResultView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;", "()V", "getPresenter", "getView", "layoutRes", "", "onBackPressed", "", "onCallStartActivity", "intent", "Landroid/content/Intent;", "onCallStartActivityForResult", "requestCode", "onClose", "payResult", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierResultActivity.kt */
public final class GlobalCashierResultActivity extends BaseCashierActivity<IGlobalCashierResultPresenter, IGlobalCashierResultView> implements IGlobalCashierCallback {
    public int layoutRes() {
        return R.layout.activity_global_cashier_result;
    }

    public void onBackPressed() {
    }

    public void onCallStartActivity(Intent intent) {
    }

    public void onCallStartActivityForResult(Intent intent, int i) {
    }

    public void onClose(int i) {
        IGlobalCashierResultPresenter iGlobalCashierResultPresenter = (IGlobalCashierResultPresenter) getMPresenter();
        if (iGlobalCashierResultPresenter != null) {
            iGlobalCashierResultPresenter.unBind();
        }
        setResult(0);
    }

    public IGlobalCashierResultPresenter getPresenter() {
        return new GlobalCashierResultPresenter(this, getMUniqueId(), this);
    }

    public IGlobalCashierResultView getView() {
        View findViewById = findViewById(R.id.activity_result_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.activity_result_root_view)");
        return new GlobalCashierResultView(this, (ViewGroup) findViewById);
    }
}
