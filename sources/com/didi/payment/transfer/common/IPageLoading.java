package com.didi.payment.transfer.common;

import android.content.Context;

public interface IPageLoading {
    Context getContext();

    void onDismissPageLoadding();

    void onShowPageLoadding();
}
