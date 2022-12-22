package com.didiglobal.p205sa.biz.component.sapanel.interfaces;

import android.view.View;
import com.didi.component.never.core.IView;
import com.didiglobal.p205sa.biz.component.sapanel.SAPanelProxy;
import com.didiglobal.p205sa.biz.component.sapanel.presenter.AbsPanelPresenter;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.interfaces.IHomePanelView */
public interface IHomePanelView<P extends AbsPanelPresenter> extends IView<P> {
    void expandPage();

    View getCardContainer();

    SAPanelProxy getPanelProxy();

    void onPageResume();

    void resumePageSize();

    void scrollTop(int i);
}
