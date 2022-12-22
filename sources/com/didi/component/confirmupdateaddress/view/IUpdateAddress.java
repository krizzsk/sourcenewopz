package com.didi.component.confirmupdateaddress.view;

import com.didi.component.confirmupdateaddress.presenter.OnServiceUpdateAddressPresenter;
import com.didi.component.core.IView;

public interface IUpdateAddress extends IView<OnServiceUpdateAddressPresenter> {
    void setChangeVisible(int i);

    void setViewVisible(int i);

    void updateAddress();

    void updateChangeVisible();
}
