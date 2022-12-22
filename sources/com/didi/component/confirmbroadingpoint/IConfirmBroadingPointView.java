package com.didi.component.confirmbroadingpoint;

import android.view.View;
import android.widget.TextView;
import com.didi.component.core.IView;

public interface IConfirmBroadingPointView extends IView<AbsConfirmBroadingPointPresenter> {
    void enableConfirm(boolean z);

    void enableContent(boolean z);

    TextView getMainTitleView();

    TextView getSubTitleView();

    void hideSubTitle();

    void setConfirmAction(String str);

    void setContent(CharSequence charSequence);

    void setContentColor(int i);

    void setNormalCardView(View view);

    void setNormalVisible(int i);

    void setSubTitle(CharSequence charSequence);

    void setSubTitleColor(int i);

    void setTitle(CharSequence charSequence);

    void setVisible(boolean z);

    void showError();

    void showLoading();

    void showSubTitle();

    void stopLoading();
}
