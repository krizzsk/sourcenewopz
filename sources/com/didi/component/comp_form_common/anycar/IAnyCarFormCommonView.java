package com.didi.component.comp_form_common.anycar;

import com.didi.component.core.IView;

public interface IAnyCarFormCommonView extends IView<AbsAnyCarFormCommonPresenter> {
    void hide();

    void setData(String str, String str2);

    void show();
}
