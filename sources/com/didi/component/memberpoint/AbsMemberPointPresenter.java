package com.didi.component.memberpoint;

import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;

public abstract class AbsMemberPointPresenter extends BaseExpressPresenter<IMemberPointView> {
    public abstract void onMemberpointClick();

    public AbsMemberPointPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
