package com.didi.unifiedPay.component.view;

import com.didi.unifiedPay.sdk.model.InstallmentModel;

public interface IInstallmentView {

    public interface IInstallmentListener {
        void onInstallmentClick();
    }

    String getCurrentInstallmentNumber();

    String getHelperUrl();

    void setHelperUrl(String str);

    void setInstallmentListener(IInstallmentListener iInstallmentListener);

    void showInstallmentBubble(String str);

    void updateInstallment(InstallmentModel installmentModel);

    void updateInstallmentRedPoint(boolean z);
}
