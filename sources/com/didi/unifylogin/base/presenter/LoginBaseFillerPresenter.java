package com.didi.unifylogin.base.presenter;

import android.content.Context;
import com.didi.unifylogin.base.view.ability.ILoginBaseFillerFragment;

public class LoginBaseFillerPresenter<V extends ILoginBaseFillerFragment> extends LoginBasePresenter<V> implements ILoginBaseFillerPresenter {
    public LoginBaseFillerPresenter(V v, Context context) {
        super(v, context);
    }

    public void goFillNextInfo() {
        goFillNextInfo(((ILoginBaseFillerFragment) this.view).getNowState());
    }
}
