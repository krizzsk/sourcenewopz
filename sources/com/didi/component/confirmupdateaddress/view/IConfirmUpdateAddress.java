package com.didi.component.confirmupdateaddress.view;

import com.didi.component.confirmupdateaddress.presenter.ConfirmUpdateAddressPresenter;
import com.didi.component.core.IView;

public interface IConfirmUpdateAddress extends IView<ConfirmUpdateAddressPresenter> {

    public interface IPresenterCallback {
        void hideGuide();

        void onChangeClick();
    }

    int getBestViewTopPadding();

    void hideGuide();

    void sendGetBestViewTopPaddingEvent();

    void setDestinationText(String str);

    void setPickUpText(String str);

    void setVisible(int i);

    void updateAlpha(float f);
}
