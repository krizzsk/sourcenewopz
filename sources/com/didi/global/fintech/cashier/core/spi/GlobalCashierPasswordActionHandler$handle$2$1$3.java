package com.didi.global.fintech.cashier.core.spi;

import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.core.GlobalCashierMainActivity;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.p117ui.dialog.GlobalCashierDialogCallback;
import com.didi.payment.wallet.password.PasswordScene;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/global/fintech/cashier/core/spi/GlobalCashierPasswordActionHandler$handle$2$1$3", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCallback;", "onBtnClick", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPasswordActionHandler.kt */
public final class GlobalCashierPasswordActionHandler$handle$2$1$3 implements GlobalCashierDialogCallback {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ OpenCertificationListener $listener;

    GlobalCashierPasswordActionHandler$handle$2$1$3(FragmentActivity fragmentActivity, OpenCertificationListener openCertificationListener) {
        this.$activity = fragmentActivity;
        this.$listener = openCertificationListener;
    }

    public void onBtnClick() {
        IGlobalMainCashierPresenter presenter;
        FragmentActivity fragmentActivity = this.$activity;
        GlobalCashierMainActivity globalCashierMainActivity = fragmentActivity instanceof GlobalCashierMainActivity ? (GlobalCashierMainActivity) fragmentActivity : null;
        if (!(globalCashierMainActivity == null || (presenter = globalCashierMainActivity.getPresenter()) == null)) {
            presenter.omegaPasswordPopupYesCk();
        }
        PaySecure.INSTANCE.createPayPassword(PasswordScene.CHECK_OUT_SETTING.name(), this.$listener, new GlobalCashierPasswordActionHandler$handle$2$1$3$onBtnClick$1(this.$activity));
    }
}
