package com.didi.soda.customer.component.error;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;

interface Contract {

    public static abstract class AbsErrorHandlePresenter extends IPresenter<AbsErrorHandleView> {
    }

    public static abstract class AbsErrorHandleView extends IView<AbsErrorHandlePresenter> {
        public abstract void showErrorTip(String str);
    }
}
