package com.didi.entrega.customer.component.provider;

import android.view.View;

public interface ICartProvider {
    void hide();

    void hideAll();

    void hideLoading();

    boolean isCanShow();

    void setOnClickCartListener(View.OnClickListener onClickListener);

    void show();

    void showAll();

    void showLoading();
}
