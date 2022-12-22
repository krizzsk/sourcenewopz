package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import android.view.View;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.IView;
import com.didi.component.never.core.IViewContainer;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.presenter.ActivityPanelPresenter;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityPanelView */
public class ActivityPanelView implements IView<ActivityPanelPresenter>, IViewContainer {

    /* renamed from: a */
    private final IActivityViewProxy f50762a;

    /* renamed from: b */
    private ActivityPanelPresenter f50763b;

    public ComponentPresenter getHostPresenter() {
        return null;
    }

    public ActivityPanelView(Context context) {
        this.f50762a = new ActivityRecProxy(context);
    }

    public View getView() {
        return this.f50762a.getView();
    }

    public void setPresenter(ActivityPanelPresenter activityPanelPresenter) {
        this.f50763b = activityPanelPresenter;
        this.f50762a.setPresenter(activityPanelPresenter);
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        ActivityPanelPresenter activityPanelPresenter = this.f50763b;
        if (activityPanelPresenter != null) {
            activityPanelPresenter.setComponentCreator(iComponentCreator);
        }
    }

    public void setData(List<ActivityProperty> list, int i, int i2) {
        this.f50762a.setData(list, i, i2);
    }

    public void showErrorView(int i, String str) {
        this.f50762a.showErrorView(i, str);
    }

    public void resetLoading() {
        this.f50762a.resetLoading();
    }
}
