package com.didiglobal.p205sa.biz.component.sapanel;

import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.IHomePanelView;
import com.didiglobal.p205sa.biz.component.sapanel.presenter.AbsPanelPresenter;
import com.didiglobal.p205sa.biz.component.sapanel.presenter.SAPanelPresenter;
import com.didiglobal.p205sa.biz.component.sapanel.view.SAPanelView;

@ComponentName(type = "component_sa_xpanel")
/* renamed from: com.didiglobal.sa.biz.component.sapanel.SAPanelComponent */
public class SAPanelComponent extends BaseComponent<IHomePanelView, AbsPanelPresenter> {
    public boolean needInflate(ComponentParams componentParams) {
        return false;
    }

    /* access modifiers changed from: protected */
    public IHomePanelView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new SAPanelView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public AbsPanelPresenter onCreatePresenter(ComponentParams componentParams) {
        return new SAPanelPresenter(componentParams);
    }
}
