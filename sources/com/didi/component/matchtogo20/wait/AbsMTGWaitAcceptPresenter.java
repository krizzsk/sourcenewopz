package com.didi.component.matchtogo20.wait;

import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.matchtogo20.wait.view.IMTGWaitAcceptView;

public abstract class AbsMTGWaitAcceptPresenter extends IPresenter<IMTGWaitAcceptView> {
    protected IXpCardBindDataReadyCallback mXpanelController;

    public AbsMTGWaitAcceptPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void addViewToXpanel() {
        IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback = this.mXpanelController;
        if (iXpCardBindDataReadyCallback != null) {
            iXpCardBindDataReadyCallback.ready(true);
        }
    }

    /* access modifiers changed from: protected */
    public void removeviewFromXpanel() {
        IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback = this.mXpanelController;
        if (iXpCardBindDataReadyCallback != null) {
            iXpCardBindDataReadyCallback.ready(false);
        }
    }
}
