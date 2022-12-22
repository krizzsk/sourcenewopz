package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.app.Activity;
import android.view.View;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.IViewContainer;
import com.didiglobal.p205sa.biz.component.sapanel.SAPanelProxy;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.IHomePanelView;
import com.didiglobal.p205sa.biz.component.sapanel.presenter.SAPanelPresenter;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SAPanelView */
public class SAPanelView implements IViewContainer, IHomePanelView<SAPanelPresenter> {

    /* renamed from: a */
    private final SAPanelProxy f51151a;

    /* renamed from: b */
    private SAPanelPresenter f51152b;

    public View getCardContainer() {
        return null;
    }

    public ComponentPresenter getHostPresenter() {
        return null;
    }

    public void onPageResume() {
    }

    public SAPanelView(Activity activity) {
        this.f51151a = new SAPanelProxy(activity);
    }

    public void resumePageSize() {
        this.f51151a.resumePageSize();
    }

    public void expandPage() {
        this.f51151a.expandPage();
    }

    public View getView() {
        return this.f51151a.getView();
    }

    public void setPresenter(SAPanelPresenter sAPanelPresenter) {
        this.f51152b = sAPanelPresenter;
    }

    public SAPanelProxy getPanelProxy() {
        return this.f51151a;
    }

    public void scrollTop(int i) {
        this.f51151a.scrollTop(i);
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.f51152b.setComponentCreator(iComponentCreator);
    }
}
