package com.didi.component.unenablecity;

import com.didi.component.core.IView;

public interface IPreheatCityView extends IView<AbsUnableCityPresenter> {
    void setContent(CharSequence charSequence);

    void setTitle(CharSequence charSequence);

    void showImage(int i);

    void showImage(String str);
}
