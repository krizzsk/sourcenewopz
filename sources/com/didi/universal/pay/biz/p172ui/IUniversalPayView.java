package com.didi.universal.pay.biz.p172ui;

import android.view.View;
import com.didi.universal.pay.biz.model.ErrorMessage;
import com.didi.universal.pay.biz.model.UniversalViewModel;

/* renamed from: com.didi.universal.pay.biz.ui.IUniversalPayView */
public interface IUniversalPayView {

    /* renamed from: com.didi.universal.pay.biz.ui.IUniversalPayView$Action */
    public enum Action {
        GET_PAY_INFO,
        CHANGE_PAY_INFO,
        GET_PAY_STATUS,
        CLICK_PAY_BTN,
        CLICK_ERROR_DIALOG,
        CHANGE_PAY_METHOD
    }

    View getView();

    void setViewEnabled(boolean z);

    void showContent();

    void showError(ErrorMessage errorMessage);

    void showLoading(Action action, String str);

    void showSuccess();

    void update(UniversalViewModel universalViewModel);
}
