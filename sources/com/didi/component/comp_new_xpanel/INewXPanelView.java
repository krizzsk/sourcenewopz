package com.didi.component.comp_new_xpanel;

import com.didi.component.core.IView;
import com.didi.component.core.IViewContainer;
import com.didiglobal.xpanelnew.sdk.XpanelNew;

public interface INewXPanelView extends IView<AbsNewXPanelPresenter>, IViewContainer {
    XpanelNew getXPanel();
}
