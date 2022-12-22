package com.didi.component.pudo;

import android.view.View;
import com.didi.component.core.IView;

public interface IPudoView extends IView<AbsPudoPresenter> {
    void setFenceCardView(View view);
}
