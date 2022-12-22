package com.component.android.comp_location;

import android.view.View;
import com.didi.component.core.IView;

public interface IGlobalLocationView extends IView<AbsGlobalLocationPresenter> {
    void doAnim(int i, int i2);

    void setAlpha(float f);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnOverviewClickListener(View.OnClickListener onClickListener);

    void setOverviewIcon(int i);

    void setOverviewVisibility(int i);

    void setStartOrEndOverviewVisible(int i);

    void setTranslationY(int i);

    void setVisibility(int i);
}
