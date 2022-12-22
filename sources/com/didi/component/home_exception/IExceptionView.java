package com.didi.component.home_exception;

import com.didi.component.home_exception.widget.ExceptionCardModel;
import com.didi.component.never.core.IView;

public interface IExceptionView extends IView<AbsExceptionPresenter> {
    void bindData(ExceptionCardModel.Data data);
}
