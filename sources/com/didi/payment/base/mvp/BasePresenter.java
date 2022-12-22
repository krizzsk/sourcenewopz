package com.didi.payment.base.mvp;

import android.content.Context;
import android.content.Intent;
import com.didi.payment.base.mvp.IBaseView;

public class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {
    public Context mContext;
    public T mView;

    public void onCreate(Intent intent) {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void attachView(T t) {
        this.mView = t;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }
}
