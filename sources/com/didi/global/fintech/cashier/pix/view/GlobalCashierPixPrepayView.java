package com.didi.global.fintech.cashier.pix.view;

import android.view.View;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPixPrepayView;
import com.didi.global.fintech.cashier.core.contract.IPresenter;
import com.didi.global.fintech.cashier.core.contract.IView;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/view/GlobalCashierPixPrepayView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPixPrepayView;", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "bindPresenter", "", "presenter", "Lcom/didi/global/fintech/cashier/core/contract/IPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IView;", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPixPrepayView.kt */
public final class GlobalCashierPixPrepayView implements IGlobalCashierPixPrepayView {
    public View getView() {
        return null;
    }

    public void bindPresenter(IPresenter<? extends IView> iPresenter) {
        Intrinsics.checkNotNullParameter(iPresenter, "presenter");
        SystemUtils.log(4, "Arirus", "GlobalCashierView bindPresenter: ", (Throwable) null, "com.didi.global.fintech.cashier.pix.view.GlobalCashierPixPrepayView", 15);
    }
}
