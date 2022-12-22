package com.didi.component.core;

import android.view.View;
import com.didi.component.core.IPresenter;

public interface IView<P extends IPresenter> {
    View getView();

    void setPresenter(P p);
}
