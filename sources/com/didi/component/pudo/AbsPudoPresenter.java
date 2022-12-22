package com.didi.component.pudo;

import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;

public abstract class AbsPudoPresenter extends BaseExpressPresenter<IPudoView> {
    public void onSendButtonClick() {
    }

    public AbsPudoPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
