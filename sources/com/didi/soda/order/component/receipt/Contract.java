package com.didi.soda.order.component.receipt;

import android.view.View;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;

public interface Contract {

    public static abstract class AbsOrderReceiptPresenter extends CustomerRecyclerPresenter<AbsOrderReceiptView> {
        /* access modifiers changed from: package-private */
        public abstract void goBack();

        /* access modifiers changed from: package-private */
        public abstract void onConformClicked();
    }

    public static abstract class AbsOrderReceiptView extends CustomerRecyclerView<AbsOrderReceiptPresenter> {
        /* access modifiers changed from: package-private */
        public abstract void hideLoading();

        /* access modifiers changed from: package-private */
        public abstract void hideSoftInput();

        /* access modifiers changed from: package-private */
        public abstract void showErrorToast(String str);

        /* access modifiers changed from: package-private */
        public abstract void showLoading();

        /* access modifiers changed from: package-private */
        public abstract void showSendSuccessView(String str);

        /* access modifiers changed from: package-private */
        public abstract void updateConfirmButtonState(boolean z, View.OnClickListener onClickListener);

        /* access modifiers changed from: package-private */
        public abstract void updateViewStyle(boolean z);
    }
}
