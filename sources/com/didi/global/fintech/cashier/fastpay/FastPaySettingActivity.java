package com.didi.global.fintech.cashier.fastpay;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.fastpay.base.BaseFastPayActivity;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySettingPresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPaySettingView;
import com.didi.global.fintech.cashier.fastpay.presenter.FastPaySettingPresenter;
import com.didi.global.fintech.cashier.fastpay.view.FastPaySettingView;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/FastPaySettingActivity;", "Lcom/didi/global/fintech/cashier/fastpay/base/BaseFastPayActivity;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingPresenter;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingView;", "()V", "getPresenter", "getView", "layoutRes", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPaySettingActivity.kt */
public final class FastPaySettingActivity extends BaseFastPayActivity<FastPayInfoResponse, IFastPaySettingPresenter, IFastPaySettingView> {
    public int layoutRes() {
        return R.layout.activity_fast_pay_setting;
    }

    public IFastPaySettingPresenter getPresenter() {
        return new FastPaySettingPresenter(this, this);
    }

    public IFastPaySettingView getView() {
        View findViewById = findViewById(R.id.activity_fast_pay_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.activity_fast_pay_root_view)");
        return new FastPaySettingView(this, (ViewGroup) findViewById);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        IFastPaySettingPresenter iFastPaySettingPresenter;
        if (i2 != -1) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (i == 413 && (iFastPaySettingPresenter = (IFastPaySettingPresenter) getMPresenter()) != null) {
            iFastPaySettingPresenter.onPayOrderBack();
        }
        super.onActivityResult(i, i2, intent);
    }
}
