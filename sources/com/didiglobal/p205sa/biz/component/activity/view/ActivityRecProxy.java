package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.View;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.presenter.IActivityPresenter;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityRecProxy */
public class ActivityRecProxy implements IActivityViewProxy {

    /* renamed from: a */
    private final IActivityPanelView f50764a;

    public ActivityRecProxy(Context context) {
        this.f50764a = new ActivityRecyclerView(context);
    }

    public View getView() {
        return this.f50764a.getView();
    }

    public void setData(List<ActivityProperty> list, int i, int i2) {
        this.f50764a.setData(list, i, i2);
    }

    public void setPresenter(IActivityPresenter iActivityPresenter) {
        this.f50764a.setPresenter(iActivityPresenter);
    }

    public void showErrorView(int i, String str) {
        this.f50764a.showErrorView(i, str);
    }

    public void resetLoading() {
        this.f50764a.resetLoading();
    }
}
