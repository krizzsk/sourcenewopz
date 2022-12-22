package com.didi.soda.customer.listener;

import android.view.View;

public interface PageClickableListener {
    View getPageView();

    boolean getTouchIntercept();
}
