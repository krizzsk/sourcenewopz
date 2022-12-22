package com.didi.component.expectation;

import android.content.Context;
import com.didi.component.common.push.model.ExpectationManagementModel;
import com.didi.component.core.IPresenter;
import com.didi.component.expectation.IExpectationView;

public abstract class AbsExpectationPresenter<V extends IExpectationView> extends IPresenter<V> {
    public abstract void iconClick(String str);

    public abstract void onFinishAnimate(int i);

    public abstract void onFlexClick();

    public abstract void onTipsClick();

    public abstract void processDuseInfo(ExpectationManagementModel expectationManagementModel);

    public AbsExpectationPresenter(Context context) {
        super(context);
    }
}
