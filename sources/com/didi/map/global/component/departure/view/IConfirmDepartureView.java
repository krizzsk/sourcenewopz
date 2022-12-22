package com.didi.map.global.component.departure.view;

import android.view.View;
import com.didi.map.global.component.departure.model.DepartureAddress;

public interface IConfirmDepartureView {

    public interface Callback {
        void onClickConfirm();

        void onClickSelectAddress();
    }

    void enableConfirm(boolean z);

    void enableContent(boolean z);

    View getView();

    boolean isValid();

    void setCallback(Callback callback);

    void setContent(CharSequence charSequence);

    void setDepartureAddress(DepartureAddress departureAddress);
}
