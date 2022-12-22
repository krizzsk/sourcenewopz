package com.didi.component.matchtogo20.wait.view;

import com.didi.component.core.IView;
import com.didi.component.matchtogo20.wait.AbsMTGWaitAcceptPresenter;
import com.didi.component.matchtogo20.wait.model.WaitAcceptModel;

public interface IMTGWaitAcceptView extends IView<AbsMTGWaitAcceptPresenter> {
    void setWaitAccept(WaitAcceptModel waitAcceptModel);

    void updateWaitTime(int i);
}
