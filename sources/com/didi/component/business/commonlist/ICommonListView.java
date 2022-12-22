package com.didi.component.business.commonlist;

import com.didi.component.core.IView;
import com.didi.component.core.IViewContainer;

public interface ICommonListView extends IView<AbsCommonListPresenter>, IViewContainer {
    ICommonListInterface getCommonListInterface();
}
