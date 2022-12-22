package com.didi.component.floatbar;

import android.view.View;
import com.didi.component.core.IView;

public interface IFloatBarContainerView extends IView<AbsFloatBarPresenter> {
    void setContentView(View view);
}
