package com.didi.component.comp_form_common;

import com.didi.component.core.IView;

public interface IFormCommonView extends IView<AbsFormCommonPresenter> {
    void hide();

    void setData(String str, String str2);

    void show();
}
