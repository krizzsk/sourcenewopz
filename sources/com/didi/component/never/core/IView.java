package com.didi.component.never.core;

import android.view.View;
import com.didi.component.never.core.ComponentPresenter;

public interface IView<P extends ComponentPresenter> {
    View getView();

    void setPresenter(P p);
}
