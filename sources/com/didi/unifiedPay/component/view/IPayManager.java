package com.didi.unifiedPay.component.view;

public interface IPayManager {
    void onPayBtnClick();

    void showQueryPayResultView(boolean z);

    void showSuccessView(boolean z, String str);
}
