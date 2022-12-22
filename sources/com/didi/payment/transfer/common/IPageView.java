package com.didi.payment.transfer.common;

import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.common.IPresenter;

public interface IPageView<P extends IPresenter> extends IPageLoading {
    void showChooseDialog(String str, String str2, String str3, String str4, DoubleCheckOnClickListener doubleCheckOnClickListener, DoubleCheckOnClickListener doubleCheckOnClickListener2);

    void showConfirmDialog(String str, String str2, String str3, DoubleCheckOnClickListener doubleCheckOnClickListener);
}
