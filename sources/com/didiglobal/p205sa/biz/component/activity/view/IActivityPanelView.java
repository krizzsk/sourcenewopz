package com.didiglobal.p205sa.biz.component.activity.view;

import android.view.View;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.presenter.IActivityPresenter;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.IActivityPanelView */
public interface IActivityPanelView {
    View getView();

    void resetLoading();

    void setData(List<ActivityProperty> list, int i, int i2);

    void setPresenter(IActivityPresenter iActivityPresenter);

    void showErrorView(int i, String str);
}
