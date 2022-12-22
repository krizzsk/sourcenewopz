package com.didi.global.fintech.cashier.pix;

import android.content.Intent;
import android.os.Bundle;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPixPrepayView;
import com.didi.global.fintech.cashier.pix.presenter.GlobalCashierPixPrepayPresenter;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.NotImplementedError;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/GlobalCashierPixPrepayActivity;", "Lcom/didi/global/fintech/cashier/core/base/BaseCashierActivity;", "Lcom/didi/global/fintech/cashier/pix/presenter/GlobalCashierPixPrepayPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPixPrepayView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierCallback;", "()V", "getPresenter", "getView", "layoutRes", "", "onCallStartActivity", "", "intent", "Landroid/content/Intent;", "onCallStartActivityForResult", "requestCode", "onClose", "payResult", "onViewCreated", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPixPrepayActivity.kt */
public final class GlobalCashierPixPrepayActivity extends BaseCashierActivity<GlobalCashierPixPrepayPresenter, IGlobalCashierPixPrepayView> implements IGlobalCashierCallback {
    public GlobalCashierPixPrepayPresenter getPresenter() {
        return null;
    }

    public IGlobalCashierPixPrepayView getView() {
        return null;
    }

    public int layoutRes() {
        return R.layout.activity_global_cashier_pix_prepay;
    }

    public void onViewCreated() {
        super.onViewCreated();
    }

    public void onClose(int i) {
        GlobalCashierPixPrepayPresenter globalCashierPixPrepayPresenter = (GlobalCashierPixPrepayPresenter) getMPresenter();
        if (globalCashierPixPrepayPresenter != null) {
            globalCashierPixPrepayPresenter.unBind();
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("code", i);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    public void onCallStartActivityForResult(Intent intent, int i) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onCallStartActivity(Intent intent) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }
}
