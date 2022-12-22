package com.didi.component.pagedata;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;
import com.didi.component.pagedata.presenter.ConfirmPageDataPresenter;
import com.didi.component.pagedata.presenter.HomePageDataPresenter;
import com.didi.component.pagedata.presenter.TripPageDataPresenter;

@ComponentRegister(product = "ride", type = "page_data")
public class PageDataComponent extends BaseComponent<IView, AbsPageDataPresenter> {
    /* access modifiers changed from: protected */
    public IView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: protected */
    public AbsPageDataPresenter onCreatePresenter(ComponentParams componentParams) {
        int i = componentParams.pageID;
        if (i == 1001) {
            return new HomePageDataPresenter(componentParams.getActivity());
        }
        if (i == 1030) {
            return new ConfirmPageDataPresenter(componentParams.getActivity());
        }
        if (i != 1040) {
            return null;
        }
        return new TripPageDataPresenter(componentParams.getActivity());
    }
}
