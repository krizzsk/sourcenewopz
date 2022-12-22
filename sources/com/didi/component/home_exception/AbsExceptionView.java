package com.didi.component.home_exception;

import android.content.Context;
import android.view.View;
import com.didi.component.home_exception.widget.ExceptionCardModel;
import com.didi.component.home_exception.widget.ExceptionCardView;

public abstract class AbsExceptionView implements IExceptionView {
    protected Context mContext;
    protected AbsExceptionPresenter mPresenter;
    protected ExceptionCardView mRootView = new ExceptionCardView(this.mContext);

    public AbsExceptionView(Context context) {
        this.mContext = context;
    }

    public void bindData(ExceptionCardModel.Data data) {
        ExceptionCardView exceptionCardView = this.mRootView;
        if (exceptionCardView != null) {
            exceptionCardView.bindData(data);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(AbsExceptionPresenter absExceptionPresenter) {
        this.mPresenter = absExceptionPresenter;
    }
}
