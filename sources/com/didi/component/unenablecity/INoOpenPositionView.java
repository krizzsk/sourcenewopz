package com.didi.component.unenablecity;

import android.view.View;
import com.didi.component.core.IView;

public interface INoOpenPositionView extends IView<AbsUnableCityPresenter> {
    void setNoPositionEnableListener(View.OnClickListener onClickListener);

    void setNoPositionManualEnterListener(View.OnClickListener onClickListener);
}
