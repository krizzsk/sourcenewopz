package com.didi.payment.base.mvp;

import android.content.Context;
import com.didi.payment.base.mvp.IBaseView;

public interface IBasePresenter<T extends IBaseView> extends ILifeCycle {
    void attachView(T t);

    void setContext(Context context);
}
