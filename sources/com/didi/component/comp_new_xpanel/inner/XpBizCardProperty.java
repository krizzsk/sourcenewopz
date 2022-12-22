package com.didi.component.comp_new_xpanel.inner;

import android.view.View;
import com.didi.component.business.xpanelnew.IXpCardBindDataReady;
import com.didi.component.business.xpanelnew.IXpCardLifeCycle;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didiglobal.xpanelnew.base.XpCardProperty;

public class XpBizCardProperty {
    public XpNewAdapter mAdapter;
    public XpCardProperty mCardProperty;
    public String mId;
    public IXpCardLifeCycle mLifeCycle;
    public IXpCardBindDataReady mReady;
    public IXpCompRefresh mRefresh;
    public String mType;
    public View mView;
}
