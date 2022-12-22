package com.didi.global.fintech.cashier.pix.contract;

import android.view.View;
import com.didi.global.fintech.cashier.pix.contract.IGlobalCashierPixController;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixLoadingView;", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "updateState", "", "state", "Lcom/didi/global/fintech/cashier/pix/contract/IGlobalCashierPixController$State;", "visibility", "visible", "", "cashier_pix_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IGlobalCashierPixLoadingView.kt */
public interface IGlobalCashierPixLoadingView {
    View getView();

    void updateState(IGlobalCashierPixController.State state);

    void visibility(boolean z);
}
