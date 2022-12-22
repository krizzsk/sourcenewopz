package com.didi.component.comp_xpanel.model;

import android.view.View;
import com.didi.component.business.xpanel.sdk.IGlobalXPanelAdapter;
import com.didi.component.business.xpanel.sdk.controllers.IXPanelBaseController;
import com.didi.component.core.IComponent;
import com.didichuxing.xpanel.base.XPanelCardData;

public class CardProperties {
    public boolean isServiceCard;
    public boolean isVisible = true;
    public IGlobalXPanelAdapter mAdapter;
    public XPanelCardData.ICardShow mCardShowCallback;
    public IComponent mComponent;
    public IXPanelBaseController mController;
    public String mId;
    public String mType;
    public View mView;
    public XPanelCardData mXPanelData;
}
