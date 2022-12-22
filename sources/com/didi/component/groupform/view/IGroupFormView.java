package com.didi.component.groupform.view;

import android.graphics.drawable.Drawable;
import com.didi.component.core.IView;
import com.didi.component.groupform.presenter.AbsGroupFormPresenter;
import java.util.List;

public interface IGroupFormView extends IView<AbsGroupFormPresenter> {
    void onDestroy();

    void setButtonBg(Drawable drawable);

    void setButtonText(CharSequence charSequence);

    void setEnabled(boolean z);

    void setMaxColCount(int i);

    void setOptionViews(List<Integer> list);

    void setVisible(boolean z);

    void setupPointText(String str, boolean z, boolean z2);

    void updateText();
}
